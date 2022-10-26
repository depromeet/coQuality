package com.depromeet.coquality.inner.post.port.driven;

import com.depromeet.coquality.inner.post.application.command.driven.UpdatePostCommand;
import com.depromeet.coquality.inner.post.domain.Post;

public interface PostPort {

    void insert(final Post post);

    void update(final UpdatePostCommand updatePostCommand);

    Post fetch(final Long id);
}
