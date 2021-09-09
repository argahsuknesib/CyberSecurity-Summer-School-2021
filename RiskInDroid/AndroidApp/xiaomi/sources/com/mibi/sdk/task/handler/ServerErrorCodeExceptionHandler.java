package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ServerErrorCodeException;
import com.mibi.sdk.task.handler.ExceptionDispatcher;
import com.xiaomi.smarthome.R;

public class ServerErrorCodeExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    /* access modifiers changed from: protected */
    public boolean handleAccountFrozenError() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean handleCallerVerifyError() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean handleOrderExpiredError() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean handleProcessExpiredError() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean handleServerErrorCodeError(int i, String str, Object obj) {
        return false;
    }

    public ServerErrorCodeExceptionHandler(Context context) {
        this.mContext = context;
    }

    public Class<? extends PaymentException> registeredException() {
        return ServerErrorCodeException.class;
    }

    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        boolean z;
        if (th instanceof ServerErrorCodeException) {
            ServerErrorCodeException serverErrorCodeException = (ServerErrorCodeException) th;
            int serverErrorCode = serverErrorCodeException.getServerErrorCode();
            if (serverErrorCode == 1992) {
                z = handleCallerVerifyError();
            } else if (serverErrorCode == 1993) {
                z = handleAccountFrozenError();
            } else if (serverErrorCode == 1569) {
                z = handleOrderExpiredError();
            } else if (serverErrorCode == 8000) {
                z = handleProcessExpiredError();
            } else {
                z = handleServerErrorCodeError(serverErrorCode, this.mContext.getString(R.string.mibi_error_server_summary), serverErrorCodeException.getResult());
            }
            if (z) {
                return true;
            }
            if (!bundle.containsKey("errcode")) {
                bundle.putInt("errcode", serverErrorCode);
            }
            if (!bundle.containsKey("errDesc")) {
                String serverErrorDesc = serverErrorCodeException.getServerErrorDesc();
                if (TextUtils.isEmpty(serverErrorDesc)) {
                    serverErrorDesc = this.mContext.getString(R.string.mibi_error_server_summary);
                }
                bundle.putString("errDesc", serverErrorDesc);
            }
            return exceptionDispatcher.dispatchAs(th, bundle, PaymentException.class);
        }
        throw new IllegalStateException();
    }
}
