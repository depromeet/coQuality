package com.depromeet.coquality.outer.post.adapter.driven.persistence;

import com.depromeet.coquality.outer.post.infrastructure.JpaPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaPostAdapter{

    private final JpaPostRepository jpaPostRepository;

}
