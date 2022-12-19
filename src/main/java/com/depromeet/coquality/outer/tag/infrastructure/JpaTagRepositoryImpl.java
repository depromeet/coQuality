package com.depromeet.coquality.outer.tag.infrastructure;

import com.depromeet.coquality.outer.tag.entity.TagEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class JpaTagRepositoryImpl extends QuerydslRepositorySupport implements
    JpaTagRepositoryCustom {

    public JpaTagRepositoryImpl() {
        super(TagEntity.class);
    }
}
