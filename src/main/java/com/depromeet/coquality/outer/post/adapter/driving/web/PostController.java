package com.depromeet.coquality.outer.post.adapter.driving.web;

import com.depromeet.coquality.inner.post.application.command.driving.ModifyPostCommand;
import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driving.PostUseCase;
import com.depromeet.coquality.outer.common.vo.CoQualityResponse;
import com.depromeet.coquality.outer.post.dto.CreatePostDTO;
import com.depromeet.coquality.outer.post.dto.ModifyPostDTO;
import com.depromeet.coquality.outer.post.vo.PostResponse;
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
    public CoQualityResponse createPost(@Valid @RequestBody final CreatePostDTO createPostDTO) {
        final var post = Post.of(createPostDTO.title());
        postUseCase.create(post);

        return new PostResponse("");
    }

    @PatchMapping("/posts/{id}")
    public CoQualityResponse modifyPost(@PathVariable Long id,
                                        @Valid @RequestBody final ModifyPostDTO modifyPostDTO) {
        final var modifyPostCommand = ModifyPostCommand.factory()
            .titleOpt(modifyPostDTO.title())
            .newInstance();
        postUseCase.modify(id, modifyPostCommand);

        return new CoQualityResponse();
    }
}
