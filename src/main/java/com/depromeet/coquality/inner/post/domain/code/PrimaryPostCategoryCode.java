package com.depromeet.coquality.inner.post.domain.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PrimaryPostCategoryCode {
    DEVELOPMENT("개발"),
    DESIGN("디자인"),
    PM("기획/PM/PO"),
    MARKETING("광고/마케팅");

    private final String categoryName;
}
