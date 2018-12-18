package sdk.af.com.sdk.biz;

import android.content.Context;

import sdk.af.com.sdk.core.CoreImpl;
import sdk.af.com.sdk.inter.Biz;
import sdk.af.com.sdk.util.Logger;

public final class AppsFlyerLib {

    private Context mContext;

    private Biz biz;

    private AppsFlyerLib() {

    }

    private static class InnerClass {
        static final AppsFlyerLib instance = new AppsFlyerLib();
    }

    public static AppsFlyerLib instance() {
        return InnerClass.instance;
    }

    public AppsFlyerLib inject(Context context) {
        mContext = context.getApplicationContext();
        return this;
    }

    public AppsFlyerLib init() {
        /**
         * 判断是否是UI进程，只在UI进程才有核心类，否则需要biz与核心类之间IPC
         */
        if(biz == null) {
            biz = new BizImpl();
        }
        biz.init();

        return this;
    }

    public Context getContext() {
        return mContext;
    }

    public void enableLog(boolean enable) {
        Logger.instance().enableLog(enable);
    }

    public void sendData(String data) {
        biz.sendDataToService(data);
    }

    public void bindServiceLater() {
        biz.bindServiceLater();
    }

    public void sendSession(String sessionName) {
        CoreImpl.instance().runTask(sessionName);
    }
}
