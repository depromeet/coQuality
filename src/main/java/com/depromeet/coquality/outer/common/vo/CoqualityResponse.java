package com.depromeet.coquality.outer.common.vo;

import com.depromeet.coquality.outer.common.error.CoqualityOuterException;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CoqualityResponse {

    private CoqualityResponseHeader header = new CoqualityResponseHeader();

    public CoqualityResponse(CoqualityOuterException ex) {
        setHeader(ex);
    }

    @JsonSetter
    private void setHeader(CoqualityResponseHeader header) {
        this.header = header;
    }

    protected void setHeader(CoqualityOuterException ex) {
        this.header = new CoqualityResponseHeader(ex.getCode(), ex.getMessage(), false);
    }
}
