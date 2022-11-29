package com.depromeet.coquality.inner.post.port.driven;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.vo.PostDetailResponse;
import com.depromeet.coquality.inner.post.vo.PostResponse;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import java.util.List;

public interface PostPort {

    void create(final Post post);

    PostDetailResponse fetchOne(final Long id);

    List<PostResponse> fetch(PostsReadInfo postsReadInfo);

    void delete(final Long id);

    void update(Long id, final Post post);

}
