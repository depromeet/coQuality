package com.depromeet.coquality.inner.tag.application.service;

import com.depromeet.coquality.inner.tag.domain.Tag;
import com.depromeet.coquality.inner.tag.port.driven.TagPort;
import com.depromeet.coquality.inner.tag.port.driving.CreateTagsUseCase;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTagsService implements CreateTagsUseCase {

    private final TagPort tagPort;

    @Override
    public void execute(Set<Tag> tags) {
        tagPort.createTags(tags);
    }
}
