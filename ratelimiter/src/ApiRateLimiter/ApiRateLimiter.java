package ApiRateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class ApiRateLimiter {
    private final ConcurrentHashMap<String,SlidingWindowRateLimiter> userRateLimiters = new ConcurrentHashMap<>();

    private final int maxRequests;
    private final long windowSizemillis;

    public ApiRateLimiter(int maxRequests, long windowSizemillis) {
        this.maxRequests = maxRequests;
        this.windowSizemillis = windowSizemillis;
    }

    public boolean allowRequest(String userId) {
        userRateLimiters.putIfAbsent(userId,new SlidingWindowRateLimiter(maxRequests,windowSizemillis));
        return userRateLimiters.get(userId).allowRequest();
    }


}
