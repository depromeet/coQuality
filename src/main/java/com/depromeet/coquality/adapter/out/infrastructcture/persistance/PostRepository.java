package com.depromeet.coquality.adapter.out.infrastructcture.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    public Optional<PostEntity> findByTitle(String title);
}
