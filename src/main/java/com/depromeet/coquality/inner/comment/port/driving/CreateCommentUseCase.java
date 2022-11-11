package com.depromeet.coquality.inner.comment.port.driving;

import com.depromeet.coquality.inner.comment.port.driving.dto.CommentDto;

public interface CreateCommentUseCase {
    void execute(CommentDto commentDto);
}
