package sdk.af.com.sdk.biz;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;

import java.util.List;

import sdk.af.com.sdk.IDataService;
import sdk.af.com.sdk.core.CoreImpl;
import sdk.af.com.sdk.inter.Biz;
import sdk.af.com.sdk.inter.Core;
import sdk.af.com.sdk.util.AFConstants;
import sdk.af.com.sdk.util.CommonUtil;
import sdk.af.com.sdk.util.Logger;

final class BizImpl implements Biz {

    private final String TAG = this.getClass().getSimpleName();

    private Core core;

    @Override
    public void init() {
        core = CoreImpl.instance();
    }


    private void connectWithCore() {
        //IDataService dataService = IDataService.Stub.asInterface()
    }

    @Override
    public void sendDataToService(final String data) {
        Logger.instance().d(TAG, "sendDataToService");

        ServiceConnection conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Logger.instance().d(TAG, "service connected");
                IDataService dataService = IDataService.Stub.asInterface(service);

                if (dataService instanceof MainProcessService.CoreService) {
                    MainProcessService.CoreService core = (MainProcessService.CoreService) dataService;
                    Logger.instance().d(TAG, "service class name: " + service.getClass().getSimpleName());
                } else {
                    Logger.instance().d(TAG, "service class name: " + service.getClass().getSimpleName());
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Logger.instance().d(TAG, "service disconnected");
            }
        };

        //Intent intent = new Intent(AFConstants.AF_SERVICE_STRING);
        //String packageName = AppsFlyerLib.instance().getContext().getPackageName();
        //Logger.instance().d(TAG, "packageName: " + packageName);
        //intent.setPackage(packageName);
        Intent mIntent = new Intent();//辅助Intent
        mIntent.setAction(AFConstants.AF_SERVICE_STRING);
        final Intent serviceIntent = new Intent(getExplicitIntent(AppsFlyerLib.instance().getContext(), mIntent));
        AppsFlyerLib.instance().getContext().bindService(serviceIntent, conn, Context.BIND_AUTO_CREATE);

    }

    @Override
    public void bindServiceLater() {
        Logger.instance().d(TAG, "bindServiceLater");

        ServiceConnection conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Logger.instance().d(TAG, "service connected");
                IDataService dataService = IDataService.Stub.asInterface(service);

                if (dataService instanceof MainProcessService.CoreService) {
                    MainProcessService.CoreService core = (MainProcessService.CoreService) dataService;
                    Logger.instance().d(TAG, "service class name: " + service.getClass().getSimpleName());
                } else {
                    Logger.instance().d(TAG, "service class name: " + service.getClass().getSimpleName());
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Logger.instance().d(TAG, "service disconnected");
            }
        };

        if (CommonUtil.getCurrentProcessName(AppsFlyerLib.instance().getContext()).equals("sdk.af.com.sdkdemo:another")) {
            Intent mIntent = new Intent();//辅助Intent
            mIntent.setAction(AFConstants.AF_SERVICE_STRING);
            final Intent serviceIntent = new Intent(getExplicitIntent(AppsFlyerLib.instance().getContext(), mIntent));
            AppsFlyerLib.instance().getContext().bindService(serviceIntent, conn, Context.BIND_AUTO_CREATE);
        }
    }


    private Intent getExplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);
        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }
        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);
        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);
        // Set the component to be explicit
        explicitIntent.setComponent(component);
        return explicitIntent;
    }

}
