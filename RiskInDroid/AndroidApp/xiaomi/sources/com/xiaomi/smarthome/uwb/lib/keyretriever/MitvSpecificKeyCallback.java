package com.xiaomi.smarthome.uwb.lib.keyretriever;

import android.os.Bundle;

public interface MitvSpecificKeyCallback {
    void onFailed(int i);

    void onSuccess(int i, Bundle bundle);
}
