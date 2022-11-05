package com.depromeet.coquality.inner.common.domain.error;

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
