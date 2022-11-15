package com.depromeet.coquality.outer.user.adapter.driving.web;

import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driving.ModifyUserUseCase;
import com.depromeet.coquality.inner.user.port.driving.ReadUserUserCase;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import com.depromeet.coquality.outer.user.adapter.driving.web.dto.reqeust.ModifyUserRequest;
import com.depromeet.coquality.outer.user.adapter.driving.web.dto.response.UserResponse;
import com.depromeet.coquality.outer.user.adapter.driving.web.dto.response.UserUpdateResponse;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final ReadUserUserCase readUserUserCase;
    private final ModifyUserUseCase modifyUserUseCase;

    @Auth
    @GetMapping("/read")
    public UserResponse readMyInfo(@UserId final Long userId) {
        final User user = readUserUserCase.execute(userId);
        return UserResponse.of(
                userId,
                user.getNickname(),
                user.getProfileImageUrl(),
                user.getSocialEmail(),
                user.getUserSummary()
        );
    }

    @Auth
    @PutMapping("/update")
    public UserUpdateResponse modifyUser(@UserId final Long userId, @RequestBody @Valid final ModifyUserRequest modifyUserRequest){
        final var modifyUser = User.ofUpdate(
                modifyUserRequest.getNickname(),
                modifyUserRequest.getEmail(),
                modifyUserRequest.getUserSummary()
        );

        final User updateUserInfo = modifyUserUseCase.execute(userId, modifyUser);
        return UserUpdateResponse.of(
                userId,
                updateUserInfo.getNickname(),
                updateUserInfo.getSocialEmail(),
                updateUserInfo.getUserSummary()
        );
    }
}
