package com.depromeet.coquality.application.service;

import com.depromeet.coquality.application.port.in.SavePostUseCase;
import com.depromeet.coquality.application.port.in.dto.request.PostRequest;
import com.depromeet.coquality.application.port.in.dto.response.PostResponse;
import com.depromeet.coquality.application.port.out.SavePostPort;
import com.depromeet.coquality.application.port.out.PostDetail;
import com.depromeet.coquality.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SavePostService implements SavePostUseCase {
    private final SavePostPort savePostPort;

    @Transactional
    @Override
    public PostResponse savePost(final PostRequest postRequest) {
        Post post = new Post(postRequest.getTitle(), postRequest.getDescription());
        savePostPort.savePost(PostDetail.of(post.getTitle(), post.getDescription()));

        return new PostResponse(post.getTitle(), post.getDescription());
    }
}

