package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.application.command.driving.ModifyPostCommand;
import com.depromeet.coquality.inner.post.domain.Post;

public interface PostUseCase {

    void create(final Post createPostCommand);

    void modify(final Long id, final ModifyPostCommand modifyPostCommand);

}
