package com.depromeet.coquality.outer.post.adapter.driven.persistence;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.outer.common.exception.CoQualityOuterExceptionCode;
import com.depromeet.coquality.outer.post.entity.PostEntity;
import com.depromeet.coquality.outer.post.infrastructure.JpaPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaPostAdapter implements PostPort {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public void create(final Post post) {
        final var postEntity = PostEntity.factory()
            .title(post.getTitle())
            .contents(post.getContents())
            .primaryPostCategoryCode(post.getPrimaryPostCategoryCode())
            .postStatusCode(post.getPostStatusCode())
            .summary(post.getSummary())
            .views(post.getViews())
            .newInstance();

        jpaPostRepository.save(postEntity);
    }

    @Override
    public Post fetchOne(Long id) {
        final var postEntity = jpaPostRepository.findByIdAndPostStatusCodeLike(id,
                PostStatusCode.ISSUED)
            .orElseThrow(() -> CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL.newInstance(id));

        postEntity.increaseViews(1L);
        jpaPostRepository.save(postEntity);

        return Post.of(
            postEntity.getTitle(),
            postEntity.getContents(),
            postEntity.getPrimaryPostCategoryCode(),
            postEntity.getPostStatusCode(),
            postEntity.getSummary(),
            postEntity.getViews()
        );
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
    public void update(final Long id, final Post post) {
        final var postEntity = jpaPostRepository.findByIdAndPostStatusCodeNotLike(id,
                PostStatusCode.DELETED)
            .orElseThrow(() -> CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL.newInstance(id));

        postEntity.modifyTitle(post.getTitle());
        postEntity.modifyContents(post.getContents());
        postEntity.changePrimaryPostCategoryCode(post.getPrimaryPostCategoryCode());
        postEntity.modifySummary(post.getSummary());

        jpaPostRepository.save(postEntity);
    }
}
