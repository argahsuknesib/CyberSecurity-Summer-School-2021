package com.xiaomi.smarthome.miio.camera.face;

import android.view.View;

public interface ClickCallback {
    void onRecyclerClick(Object obj, View view, int i);

    void onRecyclerLongClick(Object obj, View view, int i);
}
