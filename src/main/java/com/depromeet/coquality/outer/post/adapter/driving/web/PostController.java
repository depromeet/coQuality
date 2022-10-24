package com.depromeet.coquality.outer.post.adapter.driving.web;

import com.depromeet.coquality.inner.post.application.command.driving.CreatePostCommand;
import com.depromeet.coquality.inner.post.port.driving.PostUseCase;
import com.depromeet.coquality.outer.post.dto.CreatePostDTO;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostUseCase postUseCase;

    @PostMapping("/posts")
    public void createPost(@Valid @RequestBody final CreatePostDTO createPostDTO) {
        final var createPostCommand = CreatePostCommand.factory()
            .title(createPostDTO.title())
            .newInstance();

        postUseCase.create(createPostCommand);
    }
}
