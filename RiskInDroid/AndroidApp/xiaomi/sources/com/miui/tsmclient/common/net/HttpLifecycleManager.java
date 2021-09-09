package com.miui.tsmclient.common.net;

public class HttpLifecycleManager implements IHttpLifecycleListener {
    private static volatile HttpLifecycleManager sInstance;
    private IHttpLifecycleListener mHttpLifecycleListener;

    private HttpLifecycleManager() {
    }

    public static HttpLifecycleManager getInstance() {
        if (sInstance == null) {
            synchronized (HttpLifecycleManager.class) {
                if (sInstance == null) {
                    sInstance = new HttpLifecycleManager();
                }
            }
        }
        return sInstance;
    }

    public void setHttpLifecycleListener(IHttpLifecycleListener iHttpLifecycleListener) {
        this.mHttpLifecycleListener = iHttpLifecycleListener;
    }

    public void onStart(String str) {
        IHttpLifecycleListener iHttpLifecycleListener = this.mHttpLifecycleListener;
        if (iHttpLifecycleListener != null) {
            iHttpLifecycleListener.onStart(str);
        }
    }

    public void onStop(String str, int i) {
        IHttpLifecycleListener iHttpLifecycleListener = this.mHttpLifecycleListener;
        if (iHttpLifecycleListener != null) {
            iHttpLifecycleListener.onStop(str, i);
        }
    }
}
