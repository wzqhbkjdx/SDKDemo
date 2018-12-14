package sdk.af.com.sdkdemo;

import android.app.Application;

import sdk.af.com.sdk.biz.AppsFlyerLib;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppsFlyerLib.instance().init().inject(this);

        AppsFlyerLib.instance().sendData("bob wang test data");
    }
}
