package com.depromeet.coquality.outer.post.adapter.driving.web.request;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ModifyPostRequest(@NotBlank String title,
                                @NotBlank String contents,
                                @NotNull PrimaryPostCategoryCode primaryPostCategoryCode,
                                @NotNull String summary,
                                @NotNull Long views) {

    public Post toPost(Long id) {
        return Post.of(
            id,
            this.title,
            this.contents,
            this.primaryPostCategoryCode,
            this.summary,
            this.views
        );
    }
}
