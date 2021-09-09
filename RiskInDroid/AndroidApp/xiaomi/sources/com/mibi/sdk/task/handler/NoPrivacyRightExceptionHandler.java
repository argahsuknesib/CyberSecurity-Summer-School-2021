package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.exception.NoPrivacyRightException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.task.handler.ExceptionDispatcher;
import com.xiaomi.smarthome.R;

public class NoPrivacyRightExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    /* access modifiers changed from: protected */
    public boolean handleNoPrivacyRightException(int i, String str) {
        return false;
    }

    public NoPrivacyRightExceptionHandler(Context context) {
        this.mContext = context;
    }

    public Class<? extends PaymentException> registeredException() {
        return NoPrivacyRightException.class;
    }

    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        String string = this.mContext.getString(R.string.mibi_error_privacy_summary);
        bundle.putString("errDesc", string);
        bundle.putInt("errcode", 18);
        if (handleNoPrivacyRightException(18, string)) {
            return true;
        }
        return exceptionDispatcher.dispatchAs(th, bundle, PaymentException.class);
    }
}
