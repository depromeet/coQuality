package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.vo.PostResponse;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import java.util.List;

public interface ReadPostsUseCase {

    List<PostResponse> execute(PostsReadInfo postsReadInfo);
}
