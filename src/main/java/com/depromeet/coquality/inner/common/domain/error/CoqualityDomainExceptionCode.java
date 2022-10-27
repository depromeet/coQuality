package com.depromeet.coquality.inner.common.domain.error;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CoqualityDomainExceptionCode {
    POST_TITLE_LENGTH_ZERO(1, "Post title's length is zero. (%s)"),
    POST_BODY_LENGTH_ZERO(2, "Post body's length is zero.");

    private final int code;
    private final String message;

    public CoqualityDomainException newInstance() {
        return new CoqualityDomainException(code, message);
    }

    public CoqualityDomainException newInstance(Throwable ex) {
        return new CoqualityDomainException(code, message, ex);
    }

    public CoqualityDomainException newInstance(Object... args) {
        return new CoqualityDomainException(code, String.format(message, args), args);
    }

    public CoqualityDomainException newInstance(Throwable ex, Object... args) {
        return new CoqualityDomainException(code, String.format(message, args), ex, args);
    }

}
