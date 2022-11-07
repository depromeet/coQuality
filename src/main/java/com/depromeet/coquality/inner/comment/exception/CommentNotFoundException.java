package com.depromeet.coquality.inner.comment.exception;

import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainException;

public class CommentNotFoundException extends CoQualityDomainException {
    public CommentNotFoundException(int code, String message) {
        super(code, message);
    }
}
