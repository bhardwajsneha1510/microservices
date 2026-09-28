package com.tekpyramid.TEK_ApiGateway.rateLimit;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterService {

    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    public boolean isAllowed(String key) {

        Bucket bucket = buckets.computeIfAbsent(key, this::createBucket);

        return bucket.tryConsume(1);
    }

    private Bucket createBucket(String key) {

        Refill refill = Refill.greedy(5, Duration.ofMinutes(1));

        Bandwidth limit = Bandwidth.classic(5, refill);

        return Bucket.builder().addLimit(limit).build();
    }
}