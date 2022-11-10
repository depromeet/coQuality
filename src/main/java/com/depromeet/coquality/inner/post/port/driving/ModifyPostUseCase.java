package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.domain.Post;

public interface ModifyPostUseCase {

    void execute(final Long id, Post post);
}
