package sdk.af.com.sdk.service.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class WorkExecutorService extends ThreadPoolExecutor {

    private WorkExecutorService() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }

    private static class InnerClass{
        final static WorkExecutorService instance = new WorkExecutorService();
    }

    public static WorkExecutorService instance() {
        return InnerClass.instance;
    }
}
