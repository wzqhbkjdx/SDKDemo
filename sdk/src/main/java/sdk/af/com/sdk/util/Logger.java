package sdk.af.com.sdk.util;

import android.util.Log;

public class Logger {

    /**
     * todo debug log disable
     */
    private boolean enableLog = true;

    private void Logger() {

    }

    private static class InnerClass {
        final static Logger instance = new Logger();
    }

    public static Logger instance() {
        return InnerClass.instance;
    }

    public void enableLog(boolean enableLog) {
        this.enableLog = enableLog;
    }

    public void d(String tag, String content) {
        if(enableLog) {
            Log.d(tag, content);
        }
    }

}
