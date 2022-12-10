package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.domain.Post;

public interface IssuePostUseCase {

    Post execute(final Post post);

}
