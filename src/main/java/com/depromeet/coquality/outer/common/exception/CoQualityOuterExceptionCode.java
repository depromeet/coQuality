package com.depromeet.coquality.outer.common.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CoQualityOuterExceptionCode {
    HTTP_STATUS_404(404, "404 Not found"),
    POST_ENTITY_IS_NULL(404, "Post entity is null for id %s");
    private final int code;
    private final String message;

    public CoQualityOuterException newInstance() {
        return new CoQualityOuterException(code, message);
    }

    public CoQualityOuterException newInstance(Throwable ex) {
        return new CoQualityOuterException(code, message, ex);
    }

    public CoQualityOuterException newInstance(Object... args) {
        return new CoQualityOuterException(code, String.format(message, args), args);
    }

    public CoQualityOuterException newInstance(Throwable ex, Object... args) {
        return new CoQualityOuterException(code, String.format(message, args), ex, args);
    }
}
