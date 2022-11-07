package com.depromeet.coquality.outer.common.vo;

import com.depromeet.coquality.outer.common.exception.CoQualityOuterException;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CoQualityResponse {

    private CoQualityResponseHeader header = new CoQualityResponseHeader();

    public CoQualityResponse(CoQualityOuterException ex) {
        setHeader(ex);
    }

    @JsonSetter
    private void setHeader(CoQualityResponseHeader header) {
        this.header = header;
    }

    protected void setHeader(CoQualityOuterException ex) {
        this.header = new CoQualityResponseHeader(ex.getCode(), ex.getMessage(), false);
    }
}
