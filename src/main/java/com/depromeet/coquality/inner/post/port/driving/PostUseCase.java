package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.domain.Post;

public interface PostUseCase {

    void create(final Post createPostCommand);

}
