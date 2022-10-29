package com.depromeet.coquality.outer.post.adapter.driving.web.request;

import javax.validation.constraints.NotBlank;

public record CreatePostRequest(@NotBlank String title) {

}
