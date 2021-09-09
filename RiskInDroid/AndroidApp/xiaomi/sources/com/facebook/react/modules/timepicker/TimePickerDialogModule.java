package com.facebook.react.modules.timepicker;

import _m_j.dz;
import _m_j.ee;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TimePicker;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "TimePickerAndroid")
public class TimePickerDialogModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "TimePickerAndroid";
    }

    public TimePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    class TimePickerDialogListener implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnDismissListener {
        private final Promise mPromise;
        private boolean mPromiseResolved = false;

        public TimePickerDialogListener(Promise promise) {
            this.mPromise = promise;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (!this.mPromiseResolved && TimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", "timeSetAction");
                writableNativeMap.putInt("hour", i);
                writableNativeMap.putInt("minute", i2);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.mPromiseResolved && TimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", "dismissedAction");
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Promise promise) {
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity == null) {
            promise.reject("E_NO_ACTIVITY", "Tried to open a TimePicker dialog while not attached to an Activity");
            return;
        }
        ee supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        dz dzVar = (dz) supportFragmentManager.O000000o("TimePickerAndroid");
        if (dzVar != null) {
            dzVar.dismiss();
        }
        TimePickerDialogFragment timePickerDialogFragment = new TimePickerDialogFragment();
        if (readableMap != null) {
            timePickerDialogFragment.setArguments(createFragmentArguments(readableMap));
        }
        TimePickerDialogListener timePickerDialogListener = new TimePickerDialogListener(promise);
        timePickerDialogFragment.setOnDismissListener(timePickerDialogListener);
        timePickerDialogFragment.setOnTimeSetListener(timePickerDialogListener);
        timePickerDialogFragment.show(supportFragmentManager, "TimePickerAndroid");
    }

    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("hour") && !readableMap.isNull("hour")) {
            bundle.putInt("hour", readableMap.getInt("hour"));
        }
        if (readableMap.hasKey("minute") && !readableMap.isNull("minute")) {
            bundle.putInt("minute", readableMap.getInt("minute"));
        }
        if (readableMap.hasKey("is24Hour") && !readableMap.isNull("is24Hour")) {
            bundle.putBoolean("is24Hour", readableMap.getBoolean("is24Hour"));
        }
        if (readableMap.hasKey("mode") && !readableMap.isNull("mode")) {
            bundle.putString("mode", readableMap.getString("mode"));
        }
        return bundle;
    }
}
