package com.depromeet.coquality.outer.post.adapter.driving.web.request;

import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import com.depromeet.coquality.inner.post.vo.ModifyPostCommand;
import java.net.URI;
import java.util.Optional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ModifyPostRequest(
    Optional<@NotBlank String> title,
    Optional<@NotBlank String> contents,
    Optional<URI> thumbnail,
    Optional<@NotNull PrimaryPostCategoryCode> primaryPostCategoryCode,
    Optional<@NotNull PostStatusCode> postStatus,
    Optional<@NotNull String> summary
) {

    public ModifyPostCommand toModifyPostCommand() {
        return ModifyPostCommand.of(
            title,
            contents,
            thumbnail,
            primaryPostCategoryCode,
            postStatus,
            summary
        );
    }
}
