package com.facebook.react.devsupport;

import android.view.View;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "JSDevSupport")
public class JSDevSupport extends ReactContextBaseJavaModule {
    private volatile DevSupportCallback mCurrentCallback = null;

    public interface DevSupportCallback {
        void onFailure(int i, Exception exc);

        void onSuccess(String str);
    }

    public interface JSDevSupportModule extends JavaScriptModule {
        void getJSHierarchy(int i);
    }

    public String getName() {
        return "JSDevSupport";
    }

    public JSDevSupport(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public synchronized void computeDeepestJSHierarchy(View view, DevSupportCallback devSupportCallback) {
        getJSHierarchy(Integer.valueOf(((View) ViewHierarchyUtil.getDeepestLeaf(view).first).getId()).intValue(), devSupportCallback);
    }

    public synchronized void getJSHierarchy(int i, DevSupportCallback devSupportCallback) {
        JSDevSupportModule jSDevSupportModule = (JSDevSupportModule) getReactApplicationContext().getJSModule(JSDevSupportModule.class);
        if (jSDevSupportModule == null) {
            devSupportCallback.onFailure(0, new JSCHeapCapture.CaptureException("JSDevSupport module not registered."));
            return;
        }
        this.mCurrentCallback = devSupportCallback;
        jSDevSupportModule.getJSHierarchy(i);
    }

    @ReactMethod
    public synchronized void onSuccess(String str) {
        if (this.mCurrentCallback != null) {
            this.mCurrentCallback.onSuccess(str);
        }
    }

    @ReactMethod
    public synchronized void onFailure(int i, String str) {
        if (this.mCurrentCallback != null) {
            this.mCurrentCallback.onFailure(i, new RuntimeException(str));
        }
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("ERROR_CODE_EXCEPTION", 0);
        hashMap.put("ERROR_CODE_VIEW_NOT_FOUND", 1);
        return hashMap;
    }
}
