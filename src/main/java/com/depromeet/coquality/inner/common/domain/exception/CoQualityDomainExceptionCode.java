package com.depromeet.coquality.inner.common.domain.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CoQualityDomainExceptionCode {
    POST(1000, "post"),
    POST_TITLE_IS_NULL(POST.code + 1, "Post's title should not be null"),
    POST_TITLE_MIN_LENGTH_VIOLATE(POST.code + 2, "Post title's length is shorter than %s"),
    POST_TITLE_MAX_LENGTH_VIOLATE(POST.code + 3, "Post title's length is longer than %s"),
    POST_CONTENTS_IS_NULL(POST.code + 4, "Post's contents should not be null"),
    POST_CONTENTS_MAX_LENGTH_VIOLATE(POST.code + 5, "Post title's length is longer than %s"),
    POST_PRIMARY_CATEGORY_IS_NULL(POST.code + 6, "Post's primary category should not be null"),
    POST_SUMMARY_IS_NULL(POST.code + 7, "Post's summary should not be null"),
    POST_VIEWS_IS_NULL(POST.code + 8, "Post's views is null"),
    POST_VIEWS_MIN_SIZE_VIOLATE(POST.code + 9, "Posts's view's value is smaller than %s"),
    POST_STATUS_CODE_IS_NULL(POST.code + 10, "Post's status code is null"),
    POST_THUMBNAIL_NOT_VALID(POST.code + 11, "Post's thumbnail is not valid"),
    ILLEGAL_POST_STATUS(POST.code + 12, "Post's status should not be status (%s)"),
    POST_MODIFIER_ID_IS_NULL(POST.code + 13, "Post's modifier's id is null"),
    POST_PERMISSION(POST.code + 14, "Do not have permission to edit the post"),

    USER(2000, "user"),
    USER_ENTITY_IS_NULL(USER.code + 1, "User Entity is null"),
    User_SOCIAL_EMAIL_IS_NULL(USER.code + 2, "User's title is null"),
    USER_SOCIAL_ID_IS_NULL(USER.code + 3, "User's social id is null"),
    USER_SOCIAL_NICKNAME_IS_NULL(USER.code + 4, "User's social nickname is null"),

    COMMENT(3000, "comment"),
    COMMENT_ENTITY_IS_NULL(COMMENT.code + 1, "Comment Entity is null"),

    FOLLOW(4000, "follow"),
    FOLLOW_ENTITY_IS_DUPLICATE(FOLLOW.code + 1, "follow entity is duplicate"),
    FOLLOW_ENTITY_IS_NULL(FOLLOW.code + 2, "follow entity is null" ),
    FOLLOW_TO_USER_IS_NULL(FOLLOW.code + 3, "follow Target is null")
    ;

    private final int code;
    private final String message;

    public CoQualityDomainException newInstance() {
        return new CoQualityDomainException(code, message);
    }

    public CoQualityDomainException newInstance(Throwable ex) {
        return new CoQualityDomainException(code, message, ex);
    }

    public CoQualityDomainException newInstance(Object... args) {
        return new CoQualityDomainException(code, String.format(message, args), args);
    }

    public CoQualityDomainException newInstance(Throwable ex, Object... args) {
        return new CoQualityDomainException(code, String.format(message, args), ex, args);
    }

}
