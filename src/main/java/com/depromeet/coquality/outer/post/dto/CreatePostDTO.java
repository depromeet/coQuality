package com.depromeet.coquality.outer.post.dto;

import javax.validation.constraints.NotBlank;

public record CreatePostDTO(@NotBlank String title) {

}
