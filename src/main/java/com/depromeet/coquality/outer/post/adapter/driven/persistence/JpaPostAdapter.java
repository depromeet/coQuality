package com.depromeet.coquality.outer.post.adapter.driven.persistence;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
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
            .summary(post.getSummary())
            .views(post.getViews())
            .newInstance();

        jpaPostRepository.save(postEntity);
    }

    @Override
    public Post fetch(final Long id) {
        return null;
    }

    @Override
    public void delete(final Long id) {
        jpaPostRepository.deleteById(id);
    }

    @Override
    public void update(final Post post) {

    }
}
