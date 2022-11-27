package com.depromeet.coquality.outer.comment.adapter.driving.web;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driving.CreateCommentUseCase;
import com.depromeet.coquality.inner.comment.port.driving.DeleteCommentUseCase;
import com.depromeet.coquality.inner.comment.port.driving.UpdateCommentUseCase;
import com.depromeet.coquality.outer.comment.adapter.driving.web.request.CreateCommentRequest;
import com.depromeet.coquality.outer.comment.adapter.driving.web.request.UpdateCommentRequest;
import com.depromeet.coquality.outer.comment.adapter.driving.web.response.CommentResponse;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    private final DeleteCommentUseCase deleteCommentUseCase;

    @PostMapping
    @Auth
    public void createComment(@Valid @RequestBody final CreateCommentRequest createCommentRequest, @UserId final Long userId) {
        createCommentUseCase.execute(createCommentRequest.toCommentDto(userId));
    }

    @PutMapping("/{commentId}")
    @Auth
    public CommentResponse updateComment(@RequestParam final Long commentId,
                                         @Valid @RequestBody final UpdateCommentRequest updateCommentRequest,
                                         @UserId final Long userId) {
        final Comment updatedComment = updateCommentUseCase.execute(commentId, updateCommentRequest.toCommentDto(userId));
        return CommentResponse.from(updatedComment);
    }
    @DeleteMapping("/{postId}/{commentId}")
    @Auth
    public void deleteComment(@RequestParam final Long commentId,
                              @RequestParam final Long postId,
                              @UserId final Long userId){
        deleteCommentUseCase.execute(commentId, postId, userId);
    }
    //TODO 댓글 조회 기능 추가.
}
