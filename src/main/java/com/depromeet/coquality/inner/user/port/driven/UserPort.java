package com.depromeet.coquality.inner.user.port.driven;


import com.depromeet.coquality.inner.user.domain.User;

public interface UserPort {
    Long insert(User user);

    void delete(final Long id);

    void update();
}
