package com.depromeet.coquality.outer.common.exception;

import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CoQualityDomainException.class)
    public ResponseEntity<ErrorResponse> handleCoQualityDomainException(CoQualityDomainException e) {
        // TODO, add log when ready
        // log.info(String.format("%s %s", e.getClass().getName(), e);

        // TODO, inject status
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.of(e.getCode(), e.getMessage()));
    }

}
