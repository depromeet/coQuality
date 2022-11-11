package com.depromeet.coquality.outer.comment.adapter.driving.web;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driving.CreateCommentUseCase;
import com.depromeet.coquality.inner.comment.port.driving.UpdateCommentUseCase;
import com.depromeet.coquality.outer.comment.adapter.driving.web.request.CreateCommentRequest;
import com.depromeet.coquality.outer.comment.adapter.driving.web.request.UpdateCommentRequest;
import com.depromeet.coquality.outer.comment.adapter.driving.web.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CreateCommentUseCase createCommentUseCase;
    private final UpdateCommentUseCase updateCommentUseCase;

    @PostMapping
    public void createComment(
            @Valid @RequestBody final CreateCommentRequest createCommentRequest
            // @UserPrincipal User user
    ) {
        // TODO, use the resolver to get the user where auth is required
        Long userId = 1L; // TODO, sample
        createCommentUseCase.execute(createCommentRequest.toCommentDto(userId));
    }

    @PutMapping("/{commentId}")
    public CommentResponse updateComment(
            @RequestParam Long commentId,
            @Valid @RequestBody final UpdateCommentRequest updateCommentRequest
            // @UserPrincipal User user
    ) {
        // TODO, use the resolver to get the user where auth is required
        Long userId = 1L; // TODO, sample
        Comment updatedComment = updateCommentUseCase.execute(commentId, updateCommentRequest.toCommentDto(userId));
        return CommentResponse.from(updatedComment);
    }
}
