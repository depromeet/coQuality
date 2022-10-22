package com.depromeet.coquality.outer.post.adapter.driven.persistence;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driven.InsertPostPort;
import com.depromeet.coquality.outer.post.entity.RedisPost;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;

//@Component
@RequiredArgsConstructor
public class RedisInsertPostAdapter implements InsertPostPort {

    private final RedisTemplate<Integer, RedisPost> redisTemplate;

    @Override
    public void insert(Post post) {
        final var redisPost = RedisPost.factory()
            .title(post.getTitle())
            .newInstance();

        redisTemplate
            .opsForValue()
            .setIfAbsent(
                post.hashCode(),
                redisPost,
                Duration.ofSeconds(2)
            );
    }
}
