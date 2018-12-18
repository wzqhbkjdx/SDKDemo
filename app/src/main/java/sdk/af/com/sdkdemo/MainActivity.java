package sdk.af.com.sdkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sdk.af.com.sdk.biz.AppsFlyerLib;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AnotherProcessService.class);
        startService(intent);

        AppsFlyerLib.instance().sendSession("custom session");

    }
}
