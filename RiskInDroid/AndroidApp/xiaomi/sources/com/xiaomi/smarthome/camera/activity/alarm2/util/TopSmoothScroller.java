package com.xiaomi.smarthome.camera.activity.alarm2.util;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;

public class TopSmoothScroller extends LinearSmoothScroller {
    public int getHorizontalSnapPreference() {
        return -1;
    }

    public int getVerticalSnapPreference() {
        return -1;
    }

    public TopSmoothScroller(Context context) {
        super(context);
    }
}
