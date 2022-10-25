package com.depromeet.coquality.application.service;

import com.depromeet.coquality.application.port.in.GetPostUseCase;
import com.depromeet.coquality.application.port.in.dto.response.PostResponse;
import com.depromeet.coquality.application.port.out.GetPostPort;
import com.depromeet.coquality.application.port.out.PostDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetPostService implements GetPostUseCase {
    private final GetPostPort getPostPort;

    @Override
    public PostResponse getPost(String title) {
        PostDetail post = getPostPort.getPost(title);
        return new PostResponse(post.getTitle(), post.getDescription());
    }
}
