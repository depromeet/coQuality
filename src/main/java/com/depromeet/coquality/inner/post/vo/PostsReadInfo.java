package com.depromeet.coquality.inner.post.vo;

import com.depromeet.coquality.inner.post.application.code.PostSortCode;
import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import java.util.Set;

public record PostsReadInfo(Long id,
                            PostSortCode postSortCode,
                            PrimaryPostCategoryCode primaryPostCategoryCode,
                            Set<PostStatusCode> postStatusCodes) {

    public boolean isCategorySpecified() {
        return primaryPostCategoryCode != null;
    }

    public boolean isUserSpecified() {
        return id != null;
    }

    public static PostsReadInfo of(
        PostSortCode postSortCode,
        PrimaryPostCategoryCode primaryPostCategoryCode,
        Set<PostStatusCode> postStatusCodes
    ) {
        return new PostsReadInfo(null, postSortCode, primaryPostCategoryCode, postStatusCodes);
    }

    public static PostsReadInfo of(
        Long id,
        PostSortCode postSortCode,
        Set<PostStatusCode> postStatusCodes
    ) {
        return new PostsReadInfo(id, postSortCode, null, postStatusCodes);
    }
}
