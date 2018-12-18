package sdk.af.com.sdk.service.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class HttpExecutorService extends ThreadPoolExecutor {

    private static final int DEFAULT_THREAD_COUNT = 5;

    private HttpExecutorService() {
        super(DEFAULT_THREAD_COUNT, DEFAULT_THREAD_COUNT, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    private static class InnerClass {
        final static HttpExecutorService instance = new HttpExecutorService();
    }

    public static HttpExecutorService instance() {
        return InnerClass.instance;
    }

}
