package com.mibi.sdk.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.PermissionUtils;
import com.mibi.sdk.common.account.AccountUtils;
import com.mibi.sdk.common.account.LoginHelper;
import com.mibi.sdk.common.account.loader.AccountLoader;

public class BaseEntryHandler {
    public EntryResultCallback mEntryCallback;
    private Activity mHostActivity;
    private boolean mIsNoAccount = false;
    public boolean mIsRequestingLogin = false;

    public BaseEntryHandler(EntryResultCallback entryResultCallback, Activity activity) {
        this.mEntryCallback = entryResultCallback;
        this.mHostActivity = activity;
    }

    public void startEntryProcess(Bundle bundle, boolean z) {
        this.mIsNoAccount = z;
        if (bundle != null) {
            this.mIsRequestingLogin = bundle.getBoolean("is_request_login", false);
            if (this.mIsRequestingLogin) {
                AccountLoader currentAccountLoader = AccountUtils.getCurrentAccountLoader();
                if (currentAccountLoader != null) {
                    Log.d("BaseEntryHandler", "login success");
                    this.mEntryCallback.onEntrySuccess(currentAccountLoader);
                    this.mIsRequestingLogin = false;
                    return;
                }
                this.mEntryCallback.onEntryFailed(4, "login failed");
                return;
            }
            return;
        }
        AccountUtils.checkAndPostAccountChange(this.mHostActivity);
        requestPermissions(PermissionUtils.BASIC_PERMISSIONS);
    }

    public void saveState(Bundle bundle) {
        bundle.putBoolean("is_request_login", this.mIsRequestingLogin);
    }

    /* access modifiers changed from: protected */
    public EntryResultCallback getEntryCallback() {
        return this.mEntryCallback;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void requestPermissions(String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            onPermissionGranted();
            return;
        }
        String[] ungrantedPermissions = PermissionUtils.getUngrantedPermissions(this.mHostActivity, strArr);
        if (ungrantedPermissions != null) {
            this.mHostActivity.requestPermissions(ungrantedPermissions, 1000001);
        } else {
            onPermissionGranted();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (CommonConstants.DEBUG) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                Log.d("BaseEntryHandler", "permission result: " + strArr[i2] + " " + iArr[i2]);
            }
        }
        if (PermissionUtils.isAllGranted(iArr)) {
            onPermissionGranted();
        } else {
            onPermissionDenied();
        }
    }

    /* access modifiers changed from: protected */
    public void onPermissionGranted() {
        Log.d("BaseEntryHandler", "user granted permissions");
        this.mIsRequestingLogin = true;
        LoginHelper.login(this.mHostActivity, this.mIsNoAccount, new LoginHelper.LoginWithResult() {
            /* class com.mibi.sdk.component.BaseEntryHandler.AnonymousClass1 */

            public void onLoginSuccess(AccountLoader accountLoader) {
                Log.d("BaseEntryHandler", "login success");
                BaseEntryHandler baseEntryHandler = BaseEntryHandler.this;
                baseEntryHandler.mIsRequestingLogin = false;
                baseEntryHandler.mEntryCallback.onEntrySuccess(accountLoader);
            }

            public void onLoginFailed(int i, String str) {
                Log.d("BaseEntryHandler", "login failed error:" + i + "message:" + str);
                BaseEntryHandler.this.mEntryCallback.onEntryFailed(i, str);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPermissionDenied() {
        Log.d("BaseEntryHandler", "user not granted permissions");
        this.mEntryCallback.onEntryFailed(2, "user not granted permissions");
    }

    public void handleActivityResult(int i, int i2, Intent intent) {
        if (i != 1000000) {
            return;
        }
        if (i2 == -1) {
            requestPermissions(PermissionUtils.BASIC_PERMISSIONS);
        } else {
            this.mEntryCallback.onEntryFailed(2, "user canceled");
        }
    }
}
