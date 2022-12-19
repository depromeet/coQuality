package com.depromeet.coquality.inner.post.vo;

import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import java.net.URI;
import java.util.Optional;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ModifyPostCommand(Optional<@NotBlank String> title,
                                Optional<@NotBlank String> contents,
                                Optional<URI> thumbnail,
                                Optional<@NotNull PrimaryPostCategoryCode> primaryPostCategoryCode,
                                Optional<@NotNull PostStatusCode> postStatus,
                                Optional<@NotNull String> summary,
                                Optional<Set<String>> tags) {

    public static ModifyPostCommand of(
        Optional<String> title,
        Optional<String> contents,
        Optional<URI> thumbnail,
        Optional<PrimaryPostCategoryCode> primaryPostCategoryCode,
        Optional<PostStatusCode> postStatus,
        Optional<String> summary,
        Optional<Set<String>> tags) {
        return new ModifyPostCommand(
            title,
            contents,
            thumbnail,
            primaryPostCategoryCode,
            postStatus,
            summary,
            tags
        );
    }
}
