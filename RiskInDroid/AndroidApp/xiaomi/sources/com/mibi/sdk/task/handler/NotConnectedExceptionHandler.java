package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.exception.NetworkException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.task.handler.ExceptionDispatcher;
import com.xiaomi.smarthome.R;

public class NotConnectedExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    public NotConnectedExceptionHandler(Context context) {
        this.mContext = context;
    }

    public Class<? extends Throwable> registeredException() {
        return NetworkException.class;
    }

    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (!bundle.containsKey("errcode")) {
            bundle.putInt("errcode", 3);
        }
        if (!bundle.containsKey("errDesc")) {
            bundle.putString("errDesc", this.mContext.getString(R.string.mibi_error_network_summary) + ":NC");
        }
        return exceptionDispatcher.dispatchAs(th, bundle, PaymentException.class);
    }
}
