package com.depromeet.coquality.outer.post.vo;

import com.depromeet.coquality.outer.common.vo.CoqualityResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostResponse extends CoqualityResponse {

    private final String title;

}
