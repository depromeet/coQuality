package com.depromeet.coquality.outer.tag.infrastructure;

import com.depromeet.coquality.outer.tag.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaTagRepository extends JpaRepository<TagEntity, Long> {

    List<TagEntity> findByPostId(Long postId);

    void deleteByPostId(Long postId);

}
