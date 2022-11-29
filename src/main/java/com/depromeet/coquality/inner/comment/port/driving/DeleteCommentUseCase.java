package com.depromeet.coquality.inner.comment.port.driving;

public interface DeleteCommentUseCase {
    void execute(Long commentId, Long postId, Long userId);
}
