package com.depromeet.coquality.inner.comment.port.driving;

import com.depromeet.coquality.inner.comment.domain.Comment;
import java.util.List;

public interface ReadCommentsUserCase {
    List<Comment> execute(Long postId);
}
