package com.depromeet.coquality.outer.post.adapter.driving.web.request;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import java.net.URI;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ModifyPostRequest(
    @NotBlank String title,
    @NotBlank String contents,
    URI thumbnail,
    @NotNull PrimaryPostCategoryCode primaryPostCategoryCode,
    @NotNull PostStatusCode postStatus,
    @NotNull String summary,
    @NotNull Long views
) {

    public Post toPost(Long id) {
        return Post.of(
            id,
            null, // TODO 임시로 null 처리
            title,
            contents,
            thumbnail,
            primaryPostCategoryCode,
            postStatus,
            summary,
            views
        );
    }
}
