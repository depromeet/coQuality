package com.depromeet.coquality.outer.common.vo;


import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    private T data;
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data);
    }
}