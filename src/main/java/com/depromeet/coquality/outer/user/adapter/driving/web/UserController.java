package com.depromeet.coquality.outer.user.adapter.driving.web;

import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driving.ModifyUserUseCase;
import com.depromeet.coquality.inner.user.port.driving.ReadUserUserCase;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import com.depromeet.coquality.outer.user.adapter.driving.web.dto.reqeust.ModifyUserRequest;
import com.depromeet.coquality.outer.user.adapter.driving.web.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        return UserResponse.of(userId, user.getNickname());
    }

    @Auth
    @PutMapping("/update")
    public void modifyUser(@UserId final Long userId, @RequestBody @Valid final ModifyUserRequest modifyUserRequest){
        final var modifyUser = User.of(
                modifyUserRequest.getNickname(),
                modifyUserRequest.getEmail(),
                modifyUserRequest.getUserSummary()
        );
        modifyUserUseCase.execute(userId, modifyUser);
    }
}
