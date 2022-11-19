package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.ReadPostDetailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReadPostDetailService implements ReadPostDetailUseCase {

    private final PostPort postPort;

    @Transactional
    @Override
    public Post execute(final Long id) {
        return postPort.fetchOne(id);
    }
}
