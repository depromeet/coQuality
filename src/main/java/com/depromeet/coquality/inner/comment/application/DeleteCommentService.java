package com.depromeet.coquality.inner.comment.application;

import com.depromeet.coquality.inner.comment.port.driven.CommentPort;
import com.depromeet.coquality.inner.comment.port.driving.DeleteCommentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteCommentService implements DeleteCommentUseCase {

    private final CommentPort commentPort;

    @Override
    @Transactional
    public void execute(final Long commentId, final Long postId, final Long userId) {
        commentPort.delete(commentId, postId, userId);
    }
}
