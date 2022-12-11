package com.depromeet.coquality.outer.follow.adapter.driving.web;

import com.depromeet.coquality.inner.follow.port.driving.CreateFollowUseCase;
import com.depromeet.coquality.inner.follow.port.driving.DeleteFollowUseCase;
import com.depromeet.coquality.inner.follow.port.driving.GetFollowCountUseCase;
import com.depromeet.coquality.inner.follow.port.driving.GetFollowersUseCase;
import com.depromeet.coquality.inner.follow.port.driving.GetFollowingUseCase;
import com.depromeet.coquality.outer.common.vo.ApiResponse;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/follows")
public class FollowController {

    private final CreateFollowUseCase createFollowUseCase;
    private final DeleteFollowUseCase deleteFollowUseCase;
    private final GetFollowCountUseCase getFollowCountUseCase;
    private final GetFollowersUseCase getFollowersUseCase;
    private final GetFollowingUseCase getFollowingUseCase;

    @ApiOperation("[인증] 팔로우 하기 기능")
    @PostMapping("/{id}")
    @Auth
    public void createFollow(@UserId final Long fromUserId, @PathVariable("id") final Long toUserId){
        createFollowUseCase.execute(fromUserId, toUserId);
    }

    @ApiOperation("[인증] 팔로우 취소하기 기능")
    @DeleteMapping("/{id}")
    @Auth
    public void deleteFollow(@UserId final Long fromUserId, @PathVariable("id") final Long toUserId){
        deleteFollowUseCase.execute(fromUserId, toUserId);
    }

    @ApiOperation("특정 유저의 팔로우 수 조회")
    @GetMapping("/users/{id}")
    public ApiResponse getFollowCount(@PathVariable("id") final Long userId){
        return ApiResponse.success(getFollowCountUseCase.execute(userId));
    }

    @ApiOperation("특정 유저의 팔로워 리스트를 조회합니다.")
    @GetMapping("/users/followers/{id}")
    public ApiResponse getFollowers(@PathVariable("id") final Long toUserId){
        return ApiResponse.success(getFollowersUseCase.execute(toUserId));
    }

    @ApiOperation("특정 유저의 팔로잉 리스트를 조회합니다.")
    @GetMapping("/users/followings/{id}")
    public ApiResponse getFollowings(@PathVariable("id") final Long fromUserId){
        return ApiResponse.success(getFollowingUseCase.execute(fromUserId));
    }
}
