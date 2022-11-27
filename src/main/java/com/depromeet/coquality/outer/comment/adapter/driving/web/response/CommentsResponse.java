package com.depromeet.coquality.outer.comment.adapter.driving.web.response;

import com.depromeet.coquality.inner.comment.domain.Comment;
import java.util.List;

public record CommentsResponse (List<Comment> comments) {
}
