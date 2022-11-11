package com.depromeet.coquality.inner.comment.port.driven;

import com.depromeet.coquality.inner.comment.domain.Comment;

public interface CommentPort {
    void save(final Comment comment);

    Comment findById(Long commentId);
}
