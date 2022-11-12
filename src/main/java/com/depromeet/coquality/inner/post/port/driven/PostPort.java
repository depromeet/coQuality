package com.depromeet.coquality.inner.post.port.driven;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import java.util.List;

public interface PostPort {

    void create(final Post post);

    Post fetchOne(final Long id);

    List<Post> fetch(PostsReadInfo postsReadInfo);

    void delete(final Long id);

    void update(Long id, final Post post);

}
