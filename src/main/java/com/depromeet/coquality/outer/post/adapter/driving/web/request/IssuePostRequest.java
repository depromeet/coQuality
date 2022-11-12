package com.depromeet.coquality.outer.post.adapter.driving.web.request;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record IssuePostRequest(@NotBlank String title,
                               @NotBlank String contents,
                               @NotNull PrimaryPostCategoryCode primaryPostCategoryCode,
                               @NotNull String summary) {

    public Post toPost() {
        return Post.of(
            null,
            this.title(),
            this.contents(),
            this.primaryPostCategoryCode(),
            this.summary()
        );
    }
}
