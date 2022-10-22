package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.application.command.CreatePostCommand;
import com.depromeet.coquality.inner.post.port.driven.InsertPostPort;
import com.depromeet.coquality.inner.post.port.driving.CreatePostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostService implements CreatePostUseCase {

    private final InsertPostPort insertPostPort;

    @Override
    public void create(CreatePostCommand createPostCommand) {
        final var post = createPostCommand.toPost();

        insertPostPort.insert(post);
    }
}
