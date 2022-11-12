package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.ReadPostsUseCase;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadPostsService implements ReadPostsUseCase {

    private final PostPort postPort;

    @Override
    public List<Post> execute(PostsReadInfo postsReadInfo) {
        return postPort.fetch(postsReadInfo);
    }
}
