package com.depromeet.coquality.inner.comment.domain;

import com.depromeet.coquality.inner.comment.exception.UpdateCommentForbiddenException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Comment {
    private Long id;
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
    public Comment(final String contents, final Long userId, final Long postId) {
        this.contents = contents;
        this.userId = userId;
        this.postId = postId;
    }

    private void applyUpdateValidation(final Long userId, final Long postId) {
        if (!Objects.equals(this.userId, userId) || !Objects.equals(this.postId, postId)) {
            throw new UpdateCommentForbiddenException(0, "Edit comments forbidden.");
        }
    }

    public static Comment of(final Long id, final String contents, final Long userId, final Long postId) {
        return new Comment(id, contents, userId, postId);
    }
}
