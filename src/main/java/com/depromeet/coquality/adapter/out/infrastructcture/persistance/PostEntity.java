package com.depromeet.coquality.adapter.out.infrastructcture.persistance;

import com.depromeet.coquality.application.port.out.PostDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    private PostEntity(final String title, final String description) {
        this.title = title;
        this.description = description;
    }
    public static PostEntity newInstance(PostDetail postDetail){
        return new PostEntity(postDetail.getTitle(), postDetail.getDescription());
    }
}
