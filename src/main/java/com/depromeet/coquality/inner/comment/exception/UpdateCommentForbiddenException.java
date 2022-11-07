package com.depromeet.coquality.inner.comment.exception;

import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainException;

public class UpdateCommentForbiddenException extends CoQualityDomainException {
    public UpdateCommentForbiddenException(int code, String message) {
        super(code, message);
    }
}
