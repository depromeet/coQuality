package com.depromeet.coquality.outer.post.adapter.driving.web;

import com.depromeet.coquality.inner.post.application.command.driving.CreatePostCommand;
import com.depromeet.coquality.inner.post.application.command.driving.ModifyPostCommand;
import com.depromeet.coquality.inner.post.port.driving.PostUseCase;
import com.depromeet.coquality.outer.post.dto.CreatePostDTO;
import com.depromeet.coquality.outer.post.dto.ModifyPostDTO;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PatchMapping("/posts/{id}")
    public void modifyPost(@Valid @RequestBody final ModifyPostDTO modifyPostDTO,
        @PathVariable Long id) {
        final var modifyPostCommand = ModifyPostCommand.factory()
            .id(id)
            .titleOpt(modifyPostDTO.titleOpt())
            .newInstance();

        postUseCase.modify(modifyPostCommand);
    }
}
