package com.depromeet.coquality.inner.tag.port.driven;

import com.depromeet.coquality.inner.tag.domain.Tag;
import java.util.Set;

public interface TagPort {

    void createTags(Set<Tag> tags);

    void deleteByPostId(Long postId);
}
