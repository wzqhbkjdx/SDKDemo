package sdk.af.com.sdk.service.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class SingleExecutorService extends ThreadPoolExecutor {

    private SingleExecutorService() {
        super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    private static class InnerClass {
        static final SingleExecutorService instance = new SingleExecutorService();
    }

    public static SingleExecutorService instance() {
        return InnerClass.instance;
    }

}
