package sdk.af.com.sdk.core.biztask;

import sdk.af.com.sdk.service.task.BaseTask;
import sdk.af.com.sdk.util.Logger;

public class SendSession extends BaseTask {

    private String sessionName;

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    @Override
    protected void task() {
        Logger.instance().d("SendSession",
                sessionName + " : " +Thread.currentThread().getName());
    }

}
