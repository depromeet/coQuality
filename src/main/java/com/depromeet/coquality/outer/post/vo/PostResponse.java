package com.depromeet.coquality.outer.post.vo;

import com.depromeet.coquality.outer.common.vo.CoQualityResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostResponse extends CoQualityResponse {

    private final String title;

}
