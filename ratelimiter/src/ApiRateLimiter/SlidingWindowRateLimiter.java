package ApiRateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SlidingWindowRateLimiter {

    private final int maxRequests;
    private final long windowSizemillis;
    private long windowStart;
    private final AtomicInteger requestCount;
    private ReentrantLock lock = new ReentrantLock();

    public SlidingWindowRateLimiter(int maxRequests, long windowSizemillis) {
        this.maxRequests = maxRequests;
        this.windowSizemillis = windowSizemillis;
        this.windowStart = System.currentTimeMillis();
        this.requestCount = new AtomicInteger(0);
    }

    public boolean allowRequest() {
        lock.lock();
        try {
            long currentTime = System.currentTimeMillis();
            if(currentTime - windowStart > windowSizemillis) {
                windowStart = currentTime;
                requestCount.set(0);
            }
            if(requestCount.get() < maxRequests) {
                requestCount.incrementAndGet();
                return true;
            }
            return false;
        }finally {
            lock.unlock();
        }
    }
}
