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
import com.depromeet.coquality.outer.tag.entity.TagEntity;
import com.depromeet.coquality.outer.tag.infrastructure.JpaTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaPostAdapter implements PostPort {

    private final JpaPostRepository jpaPostRepository;
    private final JpaCommentRepository jpaCommentRepository;
    private final JpaTagRepository jpaTagRepository;

    @Override
    public Post create(final Post post) {
        final var postEntity = PostEntity.from(post);

        jpaPostRepository.save(postEntity);
        return postEntity.toPost();
    }

    @Override
    public PostDetailResponse readOne(final Long userId, final Long id) {
        final var postEntity = jpaPostRepository.findByIdAndPostStatusCodeNotLike(id,
                PostStatusCode.DELETED)
            .orElseThrow(() -> CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL.newInstance(id));

        if (!postEntity.getUserId().equals(userId)) {
            postEntity.increaseViews(1L);
        }
        jpaPostRepository.save(postEntity);

        final var tags = jpaTagRepository.findByPostId(postEntity.getId())
            .stream()
            .map(TagEntity::getTagValue)
            .collect(Collectors.toSet());
        return postEntity.toPostDetailResponse(tags);
    }

    @Override
    public List<PostResponse> readPosts(final PostsReadInfo postsReadInfo) {
        return jpaPostRepository.findByPostsReadInfo(postsReadInfo)
            .stream()
            .map(this::entityToPostResponse)
            .toList();
    }

    @Override
    public Post fetchOne(final Long id) {
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

    @Override
    public Long fetchUserPostCount(final Long userId) {
        return jpaPostRepository.countByUserId(userId);
    }

    @Override
    public Long fetchUserClapCount(final Long userId) {
        return jpaPostRepository.selectClapCountByUserId(userId);
    }

    private PostResponse entityToPostResponse(final PostEntity postEntity) {
        final var commentCount = jpaCommentRepository.countByPostId(postEntity.getId());
        final var tags = jpaTagRepository.findByPostId(postEntity.getId())
            .stream()
            .map(TagEntity::getTagValue)
            .collect(Collectors.toSet());

        return postEntity.toPostResponse(commentCount, tags);
    }
}
