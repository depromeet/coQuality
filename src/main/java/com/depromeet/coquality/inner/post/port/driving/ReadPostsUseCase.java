package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import java.util.List;

public interface ReadPostsUseCase {

    List<Post> execute(PostsReadInfo postsReadInfo);
}
