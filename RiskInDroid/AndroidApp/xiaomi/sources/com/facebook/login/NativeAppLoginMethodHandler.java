package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;

abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    /* access modifiers changed from: package-private */
    public abstract boolean tryAuthorize(LoginClient.Request request);

    NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    /* access modifiers changed from: package-private */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        LoginClient.Result result;
        LoginClient.Request pendingRequest = this.loginClient.getPendingRequest();
        if (intent == null) {
            result = LoginClient.Result.createCancelResult(pendingRequest, "Operation canceled");
        } else if (i2 == 0) {
            result = handleResultCancel(pendingRequest, intent);
        } else if (i2 != -1) {
            result = LoginClient.Result.createErrorResult(pendingRequest, "Unexpected resultCode from authorization.", null);
        } else {
            result = handleResultOk(pendingRequest, intent);
        }
        if (result != null) {
            this.loginClient.completeAndValidate(result);
            return true;
        }
        this.loginClient.tryNextHandler();
        return true;
    }

    private LoginClient.Result handleResultOk(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String error = getError(extras);
        String obj = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
        String errorMessage = getErrorMessage(extras);
        String string = extras.getString("e2e");
        if (!Utility.isNullOrEmpty(string)) {
            logWebLoginCompleted(string);
        }
        if (error == null && obj == null && errorMessage == null) {
            try {
                return LoginClient.Result.createTokenResult(request, createAccessTokenFromWebBundle(request.getPermissions(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.getApplicationId()));
            } catch (FacebookException e) {
                return LoginClient.Result.createErrorResult(request, null, e.getMessage());
            }
        } else if (ServerProtocol.errorsProxyAuthDisabled.contains(error)) {
            return null;
        } else {
            if (ServerProtocol.errorsUserCanceled.contains(error)) {
                return LoginClient.Result.createCancelResult(request, null);
            }
            return LoginClient.Result.createErrorResult(request, error, errorMessage, obj);
        }
    }

    private LoginClient.Result handleResultCancel(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String error = getError(extras);
        String obj = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
        if ("CONNECTION_FAILURE".equals(obj)) {
            return LoginClient.Result.createErrorResult(request, error, getErrorMessage(extras), obj);
        }
        return LoginClient.Result.createCancelResult(request, error);
    }

    private String getError(Bundle bundle) {
        String string = bundle.getString("error");
        return string == null ? bundle.getString("error_type") : string;
    }

    private String getErrorMessage(Bundle bundle) {
        String string = bundle.getString("error_message");
        return string == null ? bundle.getString("error_description") : string;
    }

    /* access modifiers changed from: protected */
    public boolean tryIntent(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.loginClient.getFragment().startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
