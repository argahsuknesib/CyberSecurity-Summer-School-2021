package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

class SmoothCalendarLayoutManager extends LinearLayoutManager {
    SmoothCalendarLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o, int i) {
        AnonymousClass1 r2 = new LinearSmoothScroller(recyclerView.getContext()) {
            /* class com.google.android.material.datepicker.SmoothCalendarLayoutManager.AnonymousClass1 */

            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
        r2.setTargetPosition(i);
        startSmoothScroll(r2);
    }
}
