package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.application.command.driven.InsertPostCommand;
import com.depromeet.coquality.inner.post.application.command.driving.CreatePostCommand;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.PostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService implements PostUseCase {

    private final PostPort postPort;

    @Override
    public void create(final CreatePostCommand createPostCommand) {
        final var post = createPostCommand.toPost();

        postPort.insert(new InsertPostCommand(post));
    }
}
