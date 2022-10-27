package com.depromeet.coquality.inner.common.domain.error;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CoQualityDomainExceptionCode {
    POST_TITLE_LENGTH_ZERO(1, "Post title's length is zero. (%s)"),
    POST_BODY_LENGTH_ZERO(2, "Post body's length is zero.");

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
