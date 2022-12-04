package com.depromeet.coquality.inner.follow.exception;

import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainException;

public class FollowDuplicateException extends CoQualityDomainException {
    public FollowDuplicateException(int code, String message, Throwable ex) {
        super(code, message, ex);
    }

    public FollowDuplicateException(int code, String message, Object... args) {
        super(code, message, args);
    }

    public FollowDuplicateException(int code, String message) {
        super(code, message);
    }
}
