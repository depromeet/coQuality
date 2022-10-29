package com.depromeet.coquality.inner.user.port.driven;

import com.depromeet.coquality.inner.post.domain.Post;

public interface UserPort {
    void insert();

    Post fetch(final Long id);

    void delete(final Long id);

    void update();
}
