package com.depromeet.coquality.outer.post.adapter.driving.web.request;

import java.util.Optional;
import javax.validation.constraints.NotBlank;

public record ModifyPostRequest(Optional<@NotBlank String> title) {

}
