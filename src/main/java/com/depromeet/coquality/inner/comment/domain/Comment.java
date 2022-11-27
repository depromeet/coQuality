package com.depromeet.coquality.inner.comment.domain;

import com.depromeet.coquality.inner.comment.exception.UpdateCommentForbiddenException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Comment {
    private String contents;
    private Long userId;
    private Long postId;

    public Comment update(final Long userId, final Long postId, final String contents) {
        applyUpdateValidation(userId, postId);

        return new Comment(
                contents,
                userId,
                postId
        );
    }

    private void applyUpdateValidation(final Long userId, final Long postId) {
        if (!Objects.equals(this.userId, userId) || !Objects.equals(this.postId, postId)) {
            throw new UpdateCommentForbiddenException(0, "Edit comments forbidden.");
        }
    }
}
