package com.depromeet.coquality.inner.post.vo;

import com.depromeet.coquality.inner.post.application.code.PostSortCode;
import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostsReadInfo {

    private final PostSortCode postSortCode;
    private final PrimaryPostCategoryCode primaryPostCategoryCode;
    private final Set<PostStatusCode> postStatusCodes;

    public boolean noCategory() {
        return primaryPostCategoryCode == null;
    }
}
