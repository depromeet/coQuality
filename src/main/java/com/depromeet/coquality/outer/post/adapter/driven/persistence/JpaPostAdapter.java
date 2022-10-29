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
    public void insert(final Post post) {
        final var jpaPost = PostEntity.factory()
                .title(post.getTitle())
                .newInstance();

        jpaPostRepository.save(jpaPost);
    }

    @Override
    public Post fetch(Long id) {
        final var jpaPost = jpaPostRepository.findById(id).orElseThrow();

        return new Post(jpaPost.getTitle());
    }
}
