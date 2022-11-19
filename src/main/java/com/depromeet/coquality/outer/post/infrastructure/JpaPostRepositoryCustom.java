package com.depromeet.coquality.outer.post.infrastructure;

import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import com.depromeet.coquality.outer.post.entity.PostEntity;
import java.util.List;

public interface JpaPostRepositoryCustom {

    List<PostEntity> findByPostsReadInfo(PostsReadInfo postsReadInfo);
}
