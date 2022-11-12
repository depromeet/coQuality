package com.depromeet.coquality.inner.post.vo;

import com.depromeet.coquality.inner.post.application.code.PostSortCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostsReadInfo {

    private final PostSortCode postSortCode;
    private final PrimaryPostCategoryCode primaryPostCategoryCode;

    public boolean noCategory() {
        return primaryPostCategoryCode == null;
    }
}
