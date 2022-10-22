package com.depromeet.coquality.outer.post.adapter.driven.persistence;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driven.InsertPostPort;
import com.depromeet.coquality.outer.post.entity.JpaPost;
import com.depromeet.coquality.outer.post.infrastructure.JpaPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaInsertPostAdapter implements InsertPostPort {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public void insert(final Post post) {
        final var jpaPost = JpaPost.factory()
            .title(post.getTitle())
            .newInstance();

        jpaPostRepository.save(jpaPost);
    }
}
