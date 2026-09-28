package com.tekpyramid.TEK_ApiGateway.rateLimit;

import org.springframework.stereotype.Component;

import org.springframework.cloud.gateway.server.mvc.common.MvcUtils;
import org.springframework.web.servlet.function.ServerRequest;

@Component
public class ClientIpKeyResolver {

    public String resolve(ServerRequest request) {

        return request.servletRequest().getRemoteAddr();
    }
}