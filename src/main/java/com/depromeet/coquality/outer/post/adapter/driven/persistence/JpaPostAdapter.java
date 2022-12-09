package com.depromeet.coquality.outer.post.adapter.driven.persistence;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.vo.PostDetailResponse;
import com.depromeet.coquality.inner.post.vo.PostResponse;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import com.depromeet.coquality.outer.comment.infrastructure.JpaCommentRepository;
import com.depromeet.coquality.outer.common.exception.CoQualityOuterExceptionCode;
import com.depromeet.coquality.outer.post.entity.PostEntity;
import com.depromeet.coquality.outer.post.infrastructure.JpaPostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaPostAdapter implements PostPort {

    private final JpaPostRepository jpaPostRepository;
    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public void create(final Post post) {
        final var postEntity = PostEntity.from(post);

        jpaPostRepository.save(postEntity);
    }

    @Override
    public PostDetailResponse readOne(Long userId, Long id) {
        final var postEntity = jpaPostRepository.findByIdAndPostStatusCodeNotLike(id,
                PostStatusCode.DELETED)
            .orElseThrow(() -> CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL.newInstance(id));

        if (!postEntity.getUserId().equals(userId)) {
            postEntity.increaseViews(1L);
        }
        jpaPostRepository.save(postEntity);

        return postEntity.toPostDetailResponse();
    }

    @Override
    public List<PostResponse> readPosts(PostsReadInfo postsReadInfo) {
        return jpaPostRepository.findByPostsReadInfo(postsReadInfo)
            .stream()
            .map(postEntity -> {
                final var commentCount = jpaCommentRepository.countByPostId(postEntity.getId());
                return postEntity.toPostResponse(commentCount);
            })
            .toList();
    }

    @Override
    public Post fetchOne(Long id) {
        final var postEntity = jpaPostRepository.findByIdAndPostStatusCodeNotLike(id,
                PostStatusCode.DELETED)
            .orElseThrow(() -> CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL.newInstance(id));

        return postEntity.toPost();
    }

    @Override
    public void delete(final Long id) {
        final var post = jpaPostRepository.findByIdAndPostStatusCodeNotLike(id,
                PostStatusCode.DELETED)
            .orElseThrow(() -> CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL.newInstance(id));

        post.changePostStatusCode(PostStatusCode.DELETED);
        jpaPostRepository.save(post);
    }

    @Override
    public void update(final Post post) {
        final var id = post.getId();
        final var postEntity = jpaPostRepository.findById(id).orElseThrow(
            () -> CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL.newInstance(id)
        );

        postEntity
            .modifyTitle(post.getTitle())
            .modifyContents(post.getContents())
            .modifyThumbnail(post.getThumbnail())
            .modifySummary(post.getSummary())
            .modifyClapCount(post.getClapCount())
            .changePostStatusCode(post.getPostStatusCode())
            .changePrimaryPostCategoryCode(post.getPrimaryCategory())
        ;

        jpaPostRepository.save(postEntity);
    }
}
