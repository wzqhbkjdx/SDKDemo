package sdk.af.com.sdk.service.threadpool;

import java.util.concurrent.ExecutorService;

public class ThreadPoolManager {

    private ThreadPoolManager() {

    }

    private static class InnerClass {
        static final ThreadPoolManager instance = new ThreadPoolManager();
    }

    public static ThreadPoolManager instance() {
        return InnerClass.instance;
    }

    public synchronized ExecutorService getHttpExecutor() {
        return HttpExecutorService.instance();
    }

    public synchronized ExecutorService getWorkExecutor() {
        return WorkExecutorService.instance();
    }

    public synchronized ExecutorService getSingleExecutor() {
        return SingleExecutorService.instance();
    }

    public synchronized void finish() {
        HttpExecutorService.instance().shutdown();
        WorkExecutorService.instance().shutdown();
        SingleExecutorService.instance().shutdown();
    }
}
