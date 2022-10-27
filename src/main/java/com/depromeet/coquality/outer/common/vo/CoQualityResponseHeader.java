package com.depromeet.coquality.outer.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoQualityResponseHeader {

    private int resultCode = 0;
    private String resultMessage = "";
    private Boolean isSuccessful = true;
}
