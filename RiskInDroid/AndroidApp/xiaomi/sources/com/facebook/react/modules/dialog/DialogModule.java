package com.facebook.react.modules.dialog;

import _m_j.ee;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Map;

@ReactModule(name = "DialogManagerAndroid")
public class DialogModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    static final Map<String, Object> CONSTANTS = MapBuilder.of("buttonClicked", "buttonClicked", "dismissed", "dismissed", "buttonPositive", -1, "buttonNegative", -2, "buttonNeutral", -3);
    public boolean mIsInForeground;

    public String getName() {
        return "DialogManagerAndroid";
    }

    public void onHostDestroy() {
    }

    public DialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    class FragmentManagerHelper {
        private final ee mFragmentManager;
        private Object mFragmentToShow;

        public FragmentManagerHelper(ee eeVar) {
            this.mFragmentManager = eeVar;
        }

        public void showPendingAlert() {
            UiThreadUtil.assertOnUiThread();
            SoftAssertions.assertCondition(DialogModule.this.mIsInForeground, "showPendingAlert() called in background");
            if (this.mFragmentToShow != null) {
                dismissExisting();
                ((AlertFragment) this.mFragmentToShow).show(this.mFragmentManager, "com.facebook.catalyst.react.dialog.DialogModule");
                this.mFragmentToShow = null;
            }
        }

        private void dismissExisting() {
            AlertFragment alertFragment;
            if (DialogModule.this.mIsInForeground && (alertFragment = (AlertFragment) this.mFragmentManager.O000000o("com.facebook.catalyst.react.dialog.DialogModule")) != null && alertFragment.isResumed()) {
                alertFragment.dismiss();
            }
        }

        public void showNewAlert(Bundle bundle, Callback callback) {
            UiThreadUtil.assertOnUiThread();
            dismissExisting();
            AlertFragment alertFragment = new AlertFragment(callback != null ? new AlertFragmentListener(callback) : null, bundle);
            if (!DialogModule.this.mIsInForeground || this.mFragmentManager.O0000Oo0()) {
                this.mFragmentToShow = alertFragment;
                return;
            }
            if (bundle.containsKey("cancelable")) {
                alertFragment.setCancelable(bundle.getBoolean("cancelable"));
            }
            alertFragment.show(this.mFragmentManager, "com.facebook.catalyst.react.dialog.DialogModule");
        }
    }

    class AlertFragmentListener implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        private final Callback mCallback;
        private boolean mCallbackConsumed = false;

        public AlertFragmentListener(Callback callback) {
            this.mCallback = callback;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!this.mCallbackConsumed && DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                this.mCallback.invoke("buttonClicked", Integer.valueOf(i));
                this.mCallbackConsumed = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.mCallbackConsumed && DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                this.mCallback.invoke("dismissed");
                this.mCallbackConsumed = true;
            }
        }
    }

    public Map<String, Object> getConstants() {
        return CONSTANTS;
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    public void onHostPause() {
        this.mIsInForeground = false;
    }

    public void onHostResume() {
        this.mIsInForeground = true;
        FragmentManagerHelper fragmentManagerHelper = getFragmentManagerHelper();
        if (fragmentManagerHelper != null) {
            fragmentManagerHelper.showPendingAlert();
        } else {
            FLog.w(DialogModule.class, "onHostResume called but no FragmentManager found");
        }
    }

    @ReactMethod
    public void showAlert(ReadableMap readableMap, Callback callback, final Callback callback2) {
        final FragmentManagerHelper fragmentManagerHelper = getFragmentManagerHelper();
        if (fragmentManagerHelper == null) {
            callback.invoke("Tried to show an alert while not attached to an Activity");
            return;
        }
        final Bundle bundle = new Bundle();
        if (readableMap.hasKey("title")) {
            bundle.putString("title", readableMap.getString("title"));
        }
        if (readableMap.hasKey("message")) {
            bundle.putString("message", readableMap.getString("message"));
        }
        if (readableMap.hasKey("buttonPositive")) {
            bundle.putString("button_positive", readableMap.getString("buttonPositive"));
        }
        if (readableMap.hasKey("buttonNegative")) {
            bundle.putString("button_negative", readableMap.getString("buttonNegative"));
        }
        if (readableMap.hasKey("buttonNeutral")) {
            bundle.putString("button_neutral", readableMap.getString("buttonNeutral"));
        }
        if (readableMap.hasKey("items")) {
            ReadableArray array = readableMap.getArray("items");
            CharSequence[] charSequenceArr = new CharSequence[array.size()];
            for (int i = 0; i < array.size(); i++) {
                charSequenceArr[i] = array.getString(i);
            }
            bundle.putCharSequenceArray("items", charSequenceArr);
        }
        if (readableMap.hasKey("cancelable")) {
            bundle.putBoolean("cancelable", readableMap.getBoolean("cancelable"));
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.modules.dialog.DialogModule.AnonymousClass1 */

            public void run() {
                fragmentManagerHelper.showNewAlert(bundle, callback2);
            }
        });
    }

    private FragmentManagerHelper getFragmentManagerHelper() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return null;
        }
        return new FragmentManagerHelper(((FragmentActivity) currentActivity).getSupportFragmentManager());
    }
}
