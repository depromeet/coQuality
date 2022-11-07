package com.depromeet.coquality.outer.comment.adapter.driving.web.request;

import com.depromeet.coquality.inner.comment.port.driving.dto.CommentDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record CreateCommentRequest(
        @NotNull Long postId,
        @NotBlank String contents
) {
    public CommentDto toCommentDto(Long userId) {
        return new CommentDto(
                contents,
                userId,
                postId
        );
    }
}
