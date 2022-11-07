package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.ReadPostUseCase;
import javax.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadPostService implements ReadPostUseCase {

    private final PostPort postPort;

    @Override
    public Post execute(@Min(1) final Long id) {
        return postPort.fetch(id);
    }
}
