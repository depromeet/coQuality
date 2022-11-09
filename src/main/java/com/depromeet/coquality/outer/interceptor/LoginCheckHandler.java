package com.depromeet.coquality.outer.interceptor;

import static com.depromeet.coquality.outer.jwt.JwtHeader.AUTH;

import com.depromeet.coquality.outer.jwt.JwtService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LoginCheckHandler {
    private final JwtService jwtService;
    Long getUserId(final HttpServletRequest request) {
        final String token = request.getHeader(AUTH);
        if (!jwtService.verifyToken(token)) {
            throw new IllegalArgumentException();
        }

        final String subject = jwtService.getSubject(token);
        return convertToUserId(subject);
    }

    private long convertToUserId(final String subject) {
        return Long.parseLong(subject);
    }
}
