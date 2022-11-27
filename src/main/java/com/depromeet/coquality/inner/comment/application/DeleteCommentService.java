package com.depromeet.coquality.inner.comment.application;

import com.depromeet.coquality.inner.comment.port.driven.CommentPort;
import com.depromeet.coquality.inner.comment.port.driving.DeleteCommentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentService implements DeleteCommentUseCase {

    private final CommentPort commentPort;

    @Override
    public void execute(final Long commentId, final Long postId, final Long userId) {
        commentPort.delete(commentId, postId, userId);
    }
}
