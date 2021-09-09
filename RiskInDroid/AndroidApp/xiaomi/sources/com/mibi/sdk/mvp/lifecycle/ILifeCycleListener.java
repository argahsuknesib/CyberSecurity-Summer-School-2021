package com.mibi.sdk.mvp.lifecycle;

import android.os.Bundle;

public interface ILifeCycleListener {
    void handleResult(int i, int i2, Bundle bundle);

    void onDestroy();

    void onPause();

    void onResume();
}
