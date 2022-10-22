package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.application.command.CreatePostCommand;

public interface CreatePostUseCase {

    void create(CreatePostCommand createPostCommand);
}
