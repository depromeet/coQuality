package com.depromeet.coquality.outer.comment.adapter.driving.web;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driving.CreateCommentUseCase;
import com.depromeet.coquality.inner.comment.port.driving.DeleteCommentUseCase;
import com.depromeet.coquality.inner.comment.port.driving.ReadCommentsUserCase;
import com.depromeet.coquality.inner.comment.port.driving.UpdateCommentUseCase;
import com.depromeet.coquality.outer.comment.adapter.driving.web.request.CreateCommentRequest;
import com.depromeet.coquality.outer.comment.adapter.driving.web.request.UpdateCommentRequest;
import com.depromeet.coquality.outer.comment.adapter.driving.web.response.CommentResponse;
import com.depromeet.coquality.outer.comment.adapter.driving.web.response.CommentsResponse;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {

    private final CreateCommentUseCase createCommentUseCase;
    private final UpdateCommentUseCase updateCommentUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;
    private final ReadCommentsUserCase readCommentsUserCase;

    @PostMapping("/comments")
    @Auth
    public void createComment(@Valid @RequestBody final CreateCommentRequest createCommentRequest,
                              @UserId final Long userId) {
        createCommentUseCase.execute(createCommentRequest.toCommentDto(userId));
    }

    @PutMapping("/comments/{commentId}")
    @Auth
    public CommentResponse updateComment(@PathVariable final Long commentId,
                                         @Valid @RequestBody final UpdateCommentRequest updateCommentRequest,
                                         @UserId final Long userId) {
        final Comment updatedComment = updateCommentUseCase.execute(commentId, updateCommentRequest.toCommentDto(userId));
        return CommentResponse.from(commentId, updatedComment);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    @Auth
    public void deleteComment(@PathVariable final Long commentId,
                              @PathVariable final Long postId,
                              @UserId final Long userId) {
        deleteCommentUseCase.execute(commentId, postId, userId);
    }

    @GetMapping("/comments/{postId}")
    public CommentsResponse getComments(@PathVariable final Long postId) {
        final List<Comment> comments = readCommentsUserCase.execute(postId);
        return new CommentsResponse(comments);
    }
}
