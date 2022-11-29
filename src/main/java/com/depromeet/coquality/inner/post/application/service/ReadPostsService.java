package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.ReadPostsUseCase;
import com.depromeet.coquality.inner.post.vo.PostResponse;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReadPostsService implements ReadPostsUseCase {

    private final PostPort postPort;

    @Transactional
    @Override
    public List<PostResponse> execute(PostsReadInfo postsReadInfo) {
        return postPort.fetch(postsReadInfo);
    }
}
