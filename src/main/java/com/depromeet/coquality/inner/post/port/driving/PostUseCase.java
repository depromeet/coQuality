package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.application.command.driving.CreatePostCommand;

public interface PostUseCase {

    void create(final CreatePostCommand createPostCommand);
}
