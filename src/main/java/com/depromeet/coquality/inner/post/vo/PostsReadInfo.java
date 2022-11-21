package com.depromeet.coquality.inner.post.vo;

import com.depromeet.coquality.inner.post.application.code.PostSortCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;

public record PostsReadInfo(Long id,
                            PostSortCode postSortCode,
                            PrimaryPostCategoryCode primaryPostCategoryCode) {

    public boolean isCategorySpecified() {
        return primaryPostCategoryCode != null;
    }

    public boolean isUserSpecified() {
        return id != null;
    }
}
