package com.depromeet.coquality.outer.post.infrastructure;

import com.depromeet.coquality.outer.post.entity.JpaPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<JpaPost, Long> {

}
