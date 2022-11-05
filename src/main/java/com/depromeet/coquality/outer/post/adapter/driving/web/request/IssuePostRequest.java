package com.depromeet.coquality.outer.post.adapter.driving.web.request;

import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record IssuePostRequest(@NotBlank String title,
                               @NotBlank String contents,
                               @NotNull PrimaryPostCategoryCode primaryPostCategoryCode,
                               @NotNull String summary) {

}
