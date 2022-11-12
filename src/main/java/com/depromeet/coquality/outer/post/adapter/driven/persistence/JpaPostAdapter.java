package com.depromeet.coquality.outer.post.adapter.driven.persistence;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
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

    @Override
    public void create(final Post post) {
        final var postEntity = PostEntity.factory()
            .title(post.getTitle())
            .contents(post.getContents())
            .primaryPostCategoryCode(post.getPrimaryPostCategoryCode())
            .summary(post.getSummary())
            .views(post.getViews())
            .newInstance();

        jpaPostRepository.save(postEntity);
    }

    @Override
    public Post fetchOne(Long id) {
        final var postEntity = jpaPostRepository.findById(id)
            .orElseThrow(() -> CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL.newInstance(id));

        postEntity.increaseViews(1L);
        jpaPostRepository.save(postEntity);

        return postEntity.toPost();
    }

    @Override
    public List<Post> fetch(PostsReadInfo postsReadInfo) {
        return jpaPostRepository.findByPostsReadInfo(postsReadInfo)
            .stream()
            .map(PostEntity::toPost)
            .toList();
    }

    @Override
    public void delete(final Long id) {
        jpaPostRepository.deleteById(id);
    }

    @Override
    public void update(final Long id, final Post post) {
        final var postEntity = jpaPostRepository.findById(id)
            .orElseThrow(() -> CoQualityOuterExceptionCode.POST_ENTITY_IS_NULL.newInstance(id));

        postEntity.modifyTitle(post.getTitle());
        postEntity.modifyContents(post.getContents());
        postEntity.changePrimaryPostCategoryCode(post.getPrimaryPostCategoryCode());
        postEntity.modifySummary(post.getSummary());

        jpaPostRepository.save(postEntity);
    }
}
