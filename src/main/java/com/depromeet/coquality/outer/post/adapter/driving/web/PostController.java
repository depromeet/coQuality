package com.depromeet.coquality.outer.post.adapter.driving.web;

import com.depromeet.coquality.inner.post.application.command.CreatePostCommand;
import com.depromeet.coquality.inner.post.port.driving.CreatePostUseCase;
import com.depromeet.coquality.outer.post.dto.CreatePostRecord;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final CreatePostUseCase createPostUseCase;

    @PostMapping("/posts")
    public void createPost(@Valid @RequestBody final CreatePostRecord createPostRecord) {
        final var createPostCommand = CreatePostCommand.factory()
            .title(createPostRecord.title())
            .newInstance();

        createPostUseCase.create(createPostCommand);
    }
}
