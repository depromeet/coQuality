package com.depromeet.coquality.outer.post.adapter.driving.web.request;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import java.net.URI;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record IssuePostRequest(@NotBlank String title,
                               @NotBlank String contents,
                               URI thumbnail,
                               @NotNull PrimaryPostCategoryCode primaryCategory,
                               @NotNull String summary) {

    public Post toPost(final Long userId) {
        return Post.of(
            null,
            userId,
            title,
            contents,
            thumbnail,
            primaryCategory,
            PostStatusCode.ISSUED,
            summary
        );
    }

}
