package com.depromeet.coquality.inner.post.domain.code;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PostStatusCode {

    ISSUED("발행"),
    PRIVATE("비공개"),
    TEMPORARY_SAVED("임시저장"),
    DELETED("삭제");

    private final String statusName;

    public static final Set<PostStatusCode> POST_NOT_DELETED = Set.of(
        ISSUED,
        PRIVATE,
        TEMPORARY_SAVED
    );

    public static final Set<PostStatusCode> POST_ISSUED = Set.of(ISSUED);
}
