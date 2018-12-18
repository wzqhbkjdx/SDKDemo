package sdk.af.com.sdk.service.task;

import sdk.af.com.sdk.service.threadpool.ThreadPoolManager;

public abstract class BaseTask implements Runnable {

    @Override
    public void run() {
        task();
    }

    abstract protected void task();


    public void executeByHttp() {
        ThreadPoolManager.instance().getHttpExecutor().execute(this);
    }

    public void executeByWork() {
        ThreadPoolManager.instance().getWorkExecutor().execute(this);
    }

    public void executeBySingleTask() {
        ThreadPoolManager.instance().getSingleExecutor().execute(this);
    }
}
