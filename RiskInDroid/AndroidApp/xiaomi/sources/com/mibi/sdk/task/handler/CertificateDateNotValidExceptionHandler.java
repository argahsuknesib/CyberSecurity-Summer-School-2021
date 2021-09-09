package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.exception.AccountException;
import com.mibi.sdk.common.exception.CertificateDateNotValidException;
import com.mibi.sdk.task.handler.ExceptionDispatcher;
import com.xiaomi.smarthome.R;

public class CertificateDateNotValidExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    public CertificateDateNotValidExceptionHandler(Context context) {
        this.mContext = context;
    }

    public Class<? extends Throwable> registeredException() {
        return CertificateDateNotValidException.class;
    }

    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (!bundle.containsKey("errcode")) {
            bundle.putInt("errcode", 3);
        }
        if (!bundle.containsKey("errDesc")) {
            bundle.putString("errDesc", this.mContext.getString(R.string.mibi_error_cert_date_summary));
        }
        return exceptionDispatcher.dispatchAs(th, bundle, AccountException.class);
    }
}
