package com.depromeet.coquality.inner.post.port.driven;

import com.depromeet.coquality.inner.post.domain.Post;

public interface PostPort {

    void create(final Post post);

    Post fetch(final Long id);

    void delete(final Long id);

    void update(Long id, final Post post);

}
