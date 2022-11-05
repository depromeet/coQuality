package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.IssuePostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssuePostService implements IssuePostUseCase {

    private final PostPort postPort;

    @Override
    public void execute(final Post post) {
        postPort.create(post);
    }
}
