package com.depromeet.coquality.outer.post.adapter.driving.web;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driving.CreatePostUseCase;
import com.depromeet.coquality.outer.common.vo.CoQualityResponse;
import com.depromeet.coquality.outer.post.adapter.driving.web.request.CreatePostRequest;
import com.depromeet.coquality.outer.post.adapter.driving.web.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final CreatePostUseCase createPostUseCase;

    @PostMapping("/posts")
    public CoQualityResponse createPost(@Valid @RequestBody final CreatePostRequest createPostRequest) {
        final var post = Post.of(createPostRequest.title());
        createPostUseCase.execute(post);

        return new PostResponse("");
    }
}
