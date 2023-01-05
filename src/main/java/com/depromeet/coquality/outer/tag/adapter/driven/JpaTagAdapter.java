package com.depromeet.coquality.outer.tag.adapter.driven;

import com.depromeet.coquality.inner.tag.domain.Tag;
import com.depromeet.coquality.inner.tag.port.driven.TagPort;
import com.depromeet.coquality.outer.tag.entity.TagEntity;
import com.depromeet.coquality.outer.tag.infrastructure.JpaTagRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaTagAdapter implements TagPort {

    private final JpaTagRepository jpaTagRepository;

    @Override
    public void createTags(Set<Tag> tags) {
        final var tagEntities = tags.stream()
            .map(TagEntity::from)
            .toList();

        jpaTagRepository.saveAll(tagEntities);
    }

    @Override
    public void deleteByPostId(Long postId) {
        jpaTagRepository.deleteByPostId(postId);
    }
}
