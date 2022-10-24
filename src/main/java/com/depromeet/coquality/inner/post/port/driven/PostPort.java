package com.depromeet.coquality.inner.post.port.driven;

import com.depromeet.coquality.inner.post.application.command.driven.InsertPostCommand;

public interface PostPort {

    void insert(final InsertPostCommand insertPostCommand);

}
