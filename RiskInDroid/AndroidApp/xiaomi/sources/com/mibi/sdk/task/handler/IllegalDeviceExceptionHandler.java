package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.exception.AccountException;
import com.mibi.sdk.common.exception.IllegalDeviceException;
import com.mibi.sdk.task.handler.ExceptionDispatcher;
import com.xiaomi.smarthome.R;

public class IllegalDeviceExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    public IllegalDeviceExceptionHandler(Context context) {
        this.mContext = context;
    }

    public Class<? extends Throwable> registeredException() {
        return IllegalDeviceException.class;
    }

    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (!bundle.containsKey("errcode")) {
            bundle.putInt("errcode", 5);
        }
        if (!bundle.containsKey("errDesc")) {
            bundle.putString("errDesc", this.mContext.getString(R.string.mibi_error_invalid_device));
        }
        return exceptionDispatcher.dispatchAs(th, bundle, AccountException.class);
    }
}
