package com.depromeet.coquality.outer.post.entity;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder(builderMethodName = "factory", buildMethodName = "newInstance")
public class RedisPost {

    private final String title;
}
