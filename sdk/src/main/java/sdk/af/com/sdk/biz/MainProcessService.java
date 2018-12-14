package sdk.af.com.sdk.biz;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import sdk.af.com.sdk.IDataService;
import sdk.af.com.sdk.util.CommonUtil;

/**
 * 通过在主进程中的Service传递数据到Core
 */
public class MainProcessService extends Service {

    private CoreService coreService;

    @Override
    public void onCreate() {
        super.onCreate();
        coreService = new CoreService();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return coreService;
    }


    class CoreService extends IDataService.Stub {
        /**
         * todo 在这里做包名验证
         */
        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        }

        @Override
        public void sendSessionData(String session) throws RemoteException {

        }

        @Override
        public void sendEventData(String eventStr) throws RemoteException {

        }

        public String fetchProcessName() {
            return CommonUtil.getCurrentProcessName(AppsFlyerLib.instance().getContext());
        }
    }


    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
