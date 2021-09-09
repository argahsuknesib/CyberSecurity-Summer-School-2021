package com.xiaomi.smarthome.uwb.lib.auth;

import android.os.Bundle;

public interface AuthResultCallback {
    void onFailed(int i);

    void onSuccess(Bundle bundle);
}
