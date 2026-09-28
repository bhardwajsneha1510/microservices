package com.tekpyramid.TEK_ApiGateway.rateLimit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitTestController {

    private final RateLimiterService rateLimiterService;

    public RateLimitTestController(RateLimiterService rateLimiterService) {

        this.rateLimiterService = rateLimiterService;
    }

    @GetMapping("/rate-limit-test")
    public String testRateLimit() {

        String clientKey = "test-user";

        boolean allowed = rateLimiterService.isAllowed(clientKey);

        if (!allowed) {
            return "429 - Too Many Requests";
        }

        return "Request Allowed";
    }
}
