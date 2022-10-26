package com.depromeet.coquality.outer.post.dto;

import java.util.Optional;
import javax.validation.constraints.NotBlank;

public record ModifyPostDTO(Optional<@NotBlank String> titleOpt) {

}
