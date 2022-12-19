package com.depromeet.coquality.outer.tag.infrastructure;

import com.depromeet.coquality.outer.tag.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTagRepository extends JpaRepository<TagEntity, Long> {

}
