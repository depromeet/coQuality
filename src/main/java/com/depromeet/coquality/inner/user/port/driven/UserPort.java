package com.depromeet.coquality.inner.user.port.driven;


import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.outer.user.entity.UserSocialType;

public interface UserPort {
    Long insert(User user, UserSocialType socialType);

    Long findUserBySocialIdAndSocialType(String socialId, UserSocialType userSocialType);

    void delete(final Long id);

    void update(final Long userId, final User user);

    User fetch(Long userId);

    boolean existNickname(String nickname);
}
