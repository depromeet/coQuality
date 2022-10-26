package com.depromeet.coquality.inner.post.application.command.driving;

import java.util.Optional;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class ModifyPostCommand {

    private final Optional<String> titleOpt;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    public ModifyPostCommand(Optional<@NonNull String> titleOpt) {
        this.titleOpt = titleOpt;
    }

}
