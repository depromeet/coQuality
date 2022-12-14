package com.depromeet.coquality.inner.post.port.driven;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.vo.PostDetailResponse;
import com.depromeet.coquality.inner.post.vo.PostResponse;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import java.util.List;

public interface PostPort {

    Post create(final Post post);

    PostDetailResponse readOne(Long userId, final Long id);

    List<PostResponse> readPosts(PostsReadInfo postsReadInfo);

    Post fetchOne(final Long id);

    void delete(final Long id);

    void update(final Post post);

    Long fetchUserPostCount(final Long userId);

    Long fetchUserClapCount(final Long userId);

}
