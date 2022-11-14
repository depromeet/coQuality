package com.depromeet.coquality.outer.post.infrastructure;

import static com.depromeet.coquality.outer.post.entity.QPostEntity.postEntity;

import com.depromeet.coquality.inner.post.application.code.PostSortCode;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import com.depromeet.coquality.outer.post.entity.PostEntity;
import com.querydsl.core.BooleanBuilder;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPostRepositoryImpl extends QuerydslRepositorySupport implements
    JpaPostRepositoryCustom {

    public JpaPostRepositoryImpl() {
        super(PostEntity.class);
    }

    public List<PostEntity> findByPostsReadInfo(PostsReadInfo postsReadInfo) {
        final var where = new BooleanBuilder();

        if (!postsReadInfo.noCategory()) {
            where.and(
                postEntity.primaryPostCategoryCode.eq(postsReadInfo.getPrimaryPostCategoryCode())
            );
        }

        final var orderBy =
            postsReadInfo.getPostSortCode() == PostSortCode.LATEST ?
                postEntity.createdAt.desc() :
                postEntity.views.desc();

        return from(postEntity)
            .where(where)
            .orderBy(orderBy)
            .fetch();
    }
}
