package com.depromeet.coquality.outer.user.entity;

import lombok.Getter;

@Getter
public enum UserRank {

    STARTER("starter"),
    EDITOR("editor"),
    SPECIAL_EDITOR("special_editor"),
    PROFESSIONAL_EDITOR("professional"),
    ;
    private final String rank;

    UserRank(final String rank) {
        this.rank = rank;
    }
}
