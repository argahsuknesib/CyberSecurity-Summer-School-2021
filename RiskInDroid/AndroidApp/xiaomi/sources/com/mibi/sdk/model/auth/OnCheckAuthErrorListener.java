package com.mibi.sdk.model.auth;

import android.os.Bundle;

public interface OnCheckAuthErrorListener {
    void onAccountFrozen();

    void onBindPhoneCheck(Bundle bundle);

    void onPasswordCheck();

    void onSMSCodeCheck(Bundle bundle);
}
