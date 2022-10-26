package com.depromeet.coquality.inner.post.port.driven;

import com.depromeet.coquality.inner.post.application.command.driven.FetchPostCommand;
import com.depromeet.coquality.inner.post.application.command.driven.InsertPostCommand;
import com.depromeet.coquality.inner.post.application.command.driven.UpdatePostCommand;
import com.depromeet.coquality.inner.post.domain.Post;

public interface PostPort {

    void insert(final InsertPostCommand insertPostCommand);

    void update(final UpdatePostCommand updatePostCommand);

    Post fetch(final FetchPostCommand fetchPostCommand);
}
