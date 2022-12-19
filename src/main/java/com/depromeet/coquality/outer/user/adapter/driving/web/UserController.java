package com.depromeet.coquality.outer.user.adapter.driving.web;

import com.depromeet.coquality.inner.user.port.driving.ValidateNicknameUseCase;
import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driving.ModifyUserUseCase;
import com.depromeet.coquality.inner.user.port.driving.ReadUserUserCase;
import com.depromeet.coquality.outer.common.vo.ApiResponse;
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
    private final ValidateNicknameUseCase validateNicknameUseCase;

    @Auth
    @GetMapping("/read")
    public ApiResponse readMyInfo(@UserId final Long userId) {
        final User user = readUserUserCase.execute(userId);
        return ApiResponse.success(UserResponse.of(userId, user.getNickname()));
    }

    @Auth
    @PutMapping("/update")
    public void modifyUser(@UserId final Long userId, @RequestBody @Valid final ModifyUserRequest request){
        modifyUserUseCase.execute(userId, request.toUserDto());
    }

    @GetMapping("/exist")
    public ApiResponse existNickname(final @RequestParam String nickname){
        return ApiResponse.success(validateNicknameUseCase.execute(nickname));
    }
}
