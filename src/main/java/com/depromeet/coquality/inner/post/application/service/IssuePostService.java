package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.IssuePostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class IssuePostService implements IssuePostUseCase {

    private final PostPort postPort;

    @Transactional
    @Override
    public Post execute(final Post post) {
        return postPort.create(post);
    }
}
