package com.depromeet.coquality.outer.resolver;

import static com.depromeet.coquality.outer.jwt.JwtHeader.AUTH;

import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.jwt.JwtService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@RequiredArgsConstructor
@Component
public class UserIdResolver implements HandlerMethodArgumentResolver {
    private final JwtService jwtService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserId.class) && Long.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        if (parameter.getMethodAnnotation(Auth.class) == null) {
            throw new RuntimeException("인증이 필요한 컨트롤러 입니다. @Auth 어노테이션을 붙여주세요.");
        }
        final HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        final String token = request.getHeader(AUTH);
        if (!jwtService.verifyToken(token)) {
            throw new RuntimeException(String.format("USER_ID를 가져오지 못했습니다. (%s - %s)", parameter.getClass(), parameter.getMethod()));
        }

        final String subject = jwtService.getSubject(token);
        try {
            return Long.parseLong(subject);
        } catch (final NumberFormatException e) {
            throw new RuntimeException(String.format("USER_ID를 가져오지 못했습니다. (%s - %s)", parameter.getClass(), parameter.getMethod()));
        }
    }
}
