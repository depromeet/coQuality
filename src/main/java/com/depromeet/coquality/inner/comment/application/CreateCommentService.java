package com.depromeet.coquality.inner.comment.application;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driven.CommentPort;
import com.depromeet.coquality.inner.comment.port.driving.CreateCommentUseCase;
import com.depromeet.coquality.inner.comment.port.driving.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCommentService implements CreateCommentUseCase {

    private final CommentPort commentPort;

    @Override
    @Transactional
    public void execute(final CommentDto commentDto) {
        final Comment comment = commentDto.toComment();
        commentPort.save(comment);
    }
}
