package com.depromeet.coquality.inner.tag.port.driving;

import com.depromeet.coquality.inner.tag.domain.Tag;
import java.util.Set;

public interface CreateTagsUseCase {

    void execute(Set<Tag> tags);

}
