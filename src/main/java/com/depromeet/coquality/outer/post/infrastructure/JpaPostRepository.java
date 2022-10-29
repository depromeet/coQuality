package com.depromeet.coquality.outer.post.infrastructure;

import com.depromeet.coquality.outer.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {

}
