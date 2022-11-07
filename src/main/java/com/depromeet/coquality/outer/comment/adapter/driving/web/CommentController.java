package com.depromeet.coquality.outer.comment.adapter.driving.web;

import com.depromeet.coquality.inner.comment.port.driving.CreateCommentUseCase;
import com.depromeet.coquality.outer.comment.adapter.driving.web.request.CreateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CreateCommentUseCase createCommentUseCase;

    @PostMapping
    public void createComment(
            @Valid @RequestBody final CreateCommentRequest createCommentRequest
            // @UserPrincipal User user
    ) {
        // TODO, use the resolver to get the user where auth is required
        Long userId = 1L; // TODO, sample
        createCommentUseCase.execute(createCommentRequest.toCommentDto(userId));
    }
}
