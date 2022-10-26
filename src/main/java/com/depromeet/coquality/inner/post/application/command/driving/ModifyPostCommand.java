package com.depromeet.coquality.inner.post.application.command.driving;

import java.util.Optional;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class ModifyPostCommand {

    private final Long id;

    private final Optional<String> titleOpt;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    public ModifyPostCommand(@NonNull Long id, Optional<String> titleOpt) {
        this.id = id;
        this.titleOpt = titleOpt;
    }

}
