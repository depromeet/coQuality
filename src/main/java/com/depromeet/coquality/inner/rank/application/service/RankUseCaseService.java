package com.depromeet.coquality.inner.rank.application.service;

import com.depromeet.coquality.inner.follow.port.driven.FollowPort;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.rank.port.driving.RankUseCase;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import com.depromeet.coquality.outer.user.entity.UserRank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RankUseCaseService implements RankUseCase {

    public static final long EDITOR_RANK_CRITERIA = 1L;
    public static final long SPECIAL_EDITOR_RANK_CRITERIA = 10L;
    public static final long PROFESSIONAL_EDITOR_CRITERIA = 10L;
    private final UserPort userPort;
    private final PostPort postPort;
    private final FollowPort followPort;

    @Override
    public void achieveEditor(Long userId) {
        final UserEntity findUser = userPort.fetchUser(userId);
        final Long postCount = postPort.fetchUserPostCount(userId);

        if (postCount >= EDITOR_RANK_CRITERIA && findUser.getRank() == UserRank.STARTER){
            findUser.advancementUserRank(UserRank.EDITOR);
        }

    }

    @Override
    public void achieveSpecialEditor(Long userId) {
        final UserEntity findUser = userPort.fetchUser(userId);
        final Long clapCount = postPort.fetchUserClapCount(userId);

        if (clapCount >= SPECIAL_EDITOR_RANK_CRITERIA && findUser.getRank() == UserRank.EDITOR){
            findUser.advancementUserRank(UserRank.SPECIAL_EDITOR);
        }

    }

    @Override
    public void achieveProfessionalEditor(Long userId) {
        final UserEntity findUser = userPort.fetchUser(userId);
        final Long followCount = followPort.fetchFollowCount(userId);

        if (followCount >= PROFESSIONAL_EDITOR_CRITERIA && findUser.getRank() == UserRank.PROFESSIONAL_EDITOR){
            findUser.advancementUserRank(UserRank.PROFESSIONAL_EDITOR);
        }
    }
}
