package com.depromeet.coquality.inner.common.domain.error;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class CoQualityDomainException extends RuntimeException {

    private final int code;

    private final List<Object> args;

    public CoQualityDomainException(int code, String message, Throwable ex) {
        super(message, ex);
        this.code = code;
        this.args = new ArrayList<>();
    }

    public CoQualityDomainException(int code, String message, Object... args) {
        super(message);
        this.code = code;
        this.args = Arrays.asList(args);
    }

    public CoQualityDomainException(int code, String message) {
        super(message);
        this.code = code;
        this.args = new ArrayList<>();
    }


}
