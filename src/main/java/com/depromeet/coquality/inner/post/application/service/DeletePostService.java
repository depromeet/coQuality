package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.DeletePostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostService implements DeletePostUseCase {

    private final PostPort postPort;

    @Override
    public void execute(final Long id) {
        postPort.delete(id);
    }
}
