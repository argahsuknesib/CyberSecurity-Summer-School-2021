package com.xiaomi.smarthome.operation.js_sdk.promise;

import _m_j.gsy;
import _m_j.hli;
import android.app.Activity;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

public abstract class JsPromiseSync extends hli implements Callable<String> {
    public JsPromiseSync(WeakReference<CommonWebView> weakReference, WeakReference<Activity> weakReference2) {
        super(weakReference, weakReference2);
        this.mWebViewRef = weakReference;
        this.mActivityRef = weakReference2;
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.operation.js_sdk.promise.$$Lambda$JsPromiseSync$dQegvJk1PkDCQ5evXmKUGRkg4JY */

            public final void run() {
                JsPromiseSync.this.invoke();
            }
        });
    }

    /* access modifiers changed from: private */
    public void invoke() {
        try {
            String str = (String) call();
            gsy.O000000o(3, "JsPromiseSync", "invoke: ".concat(String.valueOf(str)));
            this.mResultSubject.onNext(str);
        } catch (Exception e) {
            gsy.O000000o(3, "JsPromiseSync", "invoke: " + Log.getStackTraceString(e));
            this.mResultSubject.onError(e);
        }
    }
}
