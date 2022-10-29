package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.domain.Post;

public interface CreatePostUseCase {

    void execute(final Post createPostCommand);

}
