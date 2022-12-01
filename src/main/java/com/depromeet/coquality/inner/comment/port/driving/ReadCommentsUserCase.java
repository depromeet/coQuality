package com.depromeet.coquality.inner.comment.port.driving;

import com.depromeet.coquality.inner.comment.vo.CommentResponse;
import java.util.List;

public interface ReadCommentsUserCase {
    List<CommentResponse> execute(Long postId);
}
