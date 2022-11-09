package com.depromeet.coquality.outer.common.config;


import com.depromeet.coquality.outer.interceptor.Auth;
import java.util.List;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1000)
public class AuthorizationSwaggerConfig implements OperationBuilderPlugin {
    @Override
    public void apply(final OperationContext context) {
        if (context.findAnnotation(Auth.class).isPresent()) {
            context.operationBuilder()
                    .requestParameters(List.of(authorizationHeader()))
                    .authorizations(List.of(SecurityReference.builder()
                            .reference("Authorization")
                            .scopes(authorizationScopes())
                            .build()))
                    .build();
        }
    }
    private AuthorizationScope[] authorizationScopes() {
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = new AuthorizationScope("", "");
        return authorizationScopes;
    }

    private RequestParameter authorizationHeader() {
        return new RequestParameterBuilder()
                .name("Authorization")
                .required(false)
                .in(ParameterType.HEADER)
                .build();
    }

    @Override
    public boolean supports(final DocumentationType delimiter) {
        return true;
    }
}
