package com.facebook.v8.reactexecutor;

import android.os.Build;
import android.os.StrictMode;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import java.util.TimeZone;

public class V8ExecutorFactory implements JavaScriptExecutorFactory {
    public String toString() {
        return "JSIExecutor+V8Runtime";
    }

    public JavaScriptExecutor create() {
        return new V8Executor(getTimezoneId());
    }

    public void startSamplingProfiler() {
        throw new UnsupportedOperationException("Starting sampling profiler not supported on " + toString());
    }

    public void stopSamplingProfiler(String str) {
        throw new UnsupportedOperationException("Stopping sampling profiler not supported on " + toString());
    }

    private String getTimezoneId() {
        if (Build.VERSION.SDK_INT > 24) {
            return TimeZone.getDefault().getID();
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String id = TimeZone.getDefault().getID();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return id;
    }
}
