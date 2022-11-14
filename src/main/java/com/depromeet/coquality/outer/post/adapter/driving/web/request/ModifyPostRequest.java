package com.depromeet.coquality.outer.post.adapter.driving.web.request;

import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ModifyPostRequest(
    @NotBlank String title,
    @NotBlank String contents,
    @NotNull PrimaryPostCategoryCode primaryPostCategoryCode,
    @NotNull PostStatusCode postStatusCode,
    @NotNull String summary,
    @NotNull Long views
) {

}
