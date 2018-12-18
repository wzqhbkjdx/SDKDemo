package sdk.af.com.sdk.core;

import sdk.af.com.sdk.core.biztask.SendSession;
import sdk.af.com.sdk.inter.Core;
import sdk.af.com.sdk.util.Logger;

public final class CoreImpl implements Core {

    private CoreImpl() {

    }

    private static class InnerClass {
        static final CoreImpl instance = new CoreImpl();
    }

    public static CoreImpl instance() {
        return InnerClass.instance;
    }


    @Override
    public void initCore() {

    }

    public void runTask(String sessionName) {
        Logger.instance().d("SendSession", "run task : " + Thread.currentThread().getName());
        SendSession sendSession = new SendSession();
        sendSession.setSessionName(sessionName);
        sendSession.executeByHttp();
        sendSession.executeBySingleTask();
        sendSession.executeByWork();
    }
}
