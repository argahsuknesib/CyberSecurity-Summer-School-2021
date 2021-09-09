package com.facebook.react.modules.datepicker;

import _m_j.dz;
import _m_j.ee;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "DatePickerAndroid")
public class DatePickerDialogModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "DatePickerAndroid";
    }

    public DatePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    class DatePickerDialogListener implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener {
        private final Promise mPromise;
        private boolean mPromiseResolved = false;

        public DatePickerDialogListener(Promise promise) {
            this.mPromise = promise;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            if (!this.mPromiseResolved && DatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", "dateSetAction");
                writableNativeMap.putInt("year", i);
                writableNativeMap.putInt("month", i2);
                writableNativeMap.putInt("day", i3);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.mPromiseResolved && DatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
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
            promise.reject("E_NO_ACTIVITY", "Tried to open a DatePicker dialog while not attached to an Activity");
            return;
        }
        ee supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        dz dzVar = (dz) supportFragmentManager.O000000o("DatePickerAndroid");
        if (dzVar != null) {
            dzVar.dismiss();
        }
        DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
        if (readableMap != null) {
            datePickerDialogFragment.setArguments(createFragmentArguments(readableMap));
        }
        DatePickerDialogListener datePickerDialogListener = new DatePickerDialogListener(promise);
        datePickerDialogFragment.setOnDismissListener(datePickerDialogListener);
        datePickerDialogFragment.setOnDateSetListener(datePickerDialogListener);
        datePickerDialogFragment.show(supportFragmentManager, "DatePickerAndroid");
    }

    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("date") && !readableMap.isNull("date")) {
            bundle.putLong("date", (long) readableMap.getDouble("date"));
        }
        if (readableMap.hasKey("minDate") && !readableMap.isNull("minDate")) {
            bundle.putLong("minDate", (long) readableMap.getDouble("minDate"));
        }
        if (readableMap.hasKey("maxDate") && !readableMap.isNull("maxDate")) {
            bundle.putLong("maxDate", (long) readableMap.getDouble("maxDate"));
        }
        if (readableMap.hasKey("mode") && !readableMap.isNull("mode")) {
            bundle.putString("mode", readableMap.getString("mode"));
        }
        return bundle;
    }
}
