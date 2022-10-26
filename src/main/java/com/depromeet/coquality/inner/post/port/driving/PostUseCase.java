package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.application.command.driving.CreatePostCommand;
import com.depromeet.coquality.inner.post.application.command.driving.ModifyPostCommand;

public interface PostUseCase {

    void create(final CreatePostCommand createPostCommand);

    void modify(final ModifyPostCommand modifyPostCommand);

}
