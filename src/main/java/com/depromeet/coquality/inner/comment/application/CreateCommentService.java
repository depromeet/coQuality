package com.depromeet.coquality.inner.comment.application;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driving.CreateCommentUseCase;
import com.depromeet.coquality.inner.comment.port.driving.dto.CommentDto;
import com.depromeet.coquality.outer.comment.adapter.driven.persistence.JpaCommentAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCommentService implements CreateCommentUseCase {

    private final JpaCommentAdapter commentAdapter;

    @Override
    public void execute(CommentDto commentDto) {
        Comment comment = commentDto.toComment();

        // TODO, add validation of user and post existence

        commentAdapter.save(comment);
    }
}
