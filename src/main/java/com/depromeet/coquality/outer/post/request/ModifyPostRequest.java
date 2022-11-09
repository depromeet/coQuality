package com.depromeet.coquality.outer.post.request;

import java.util.Optional;
import javax.validation.constraints.NotBlank;

public record ModifyPostRequest(Optional<@NotBlank String> title) {

}
