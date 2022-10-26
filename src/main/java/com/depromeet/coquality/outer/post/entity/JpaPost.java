package com.depromeet.coquality.outer.post.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "Post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class JpaPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    public JpaPost(Long id, @NonNull String title) {
        this.id = id;
        this.title = title;
    }
}
