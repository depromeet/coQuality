package com.depromeet.coquality.inner.comment.port.driving;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driving.dto.CommentDto;

public interface UpdateCommentUseCase {
    Comment execute(Long commentId, CommentDto commentDto);
}
