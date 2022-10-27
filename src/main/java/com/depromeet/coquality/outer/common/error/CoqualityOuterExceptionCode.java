package com.depromeet.coquality.outer.common.error;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CoqualityOuterExceptionCode {
    HTTP_STATUS_404(404, "404 Not found");

    private final int code;
    private final String message;

    public CoqualityOuterException newInstance() {
        return new CoqualityOuterException(code, message);
    }

    public CoqualityOuterException newInstance(Throwable ex) {
        return new CoqualityOuterException(code, message, ex);
    }

    public CoqualityOuterException newInstance(Object... args) {
        return new CoqualityOuterException(code, String.format(message, args), args);
    }

    public CoqualityOuterException newInstance(Throwable ex, Object... args) {
        return new CoqualityOuterException(code, String.format(message, args), ex, args);
    }
}
