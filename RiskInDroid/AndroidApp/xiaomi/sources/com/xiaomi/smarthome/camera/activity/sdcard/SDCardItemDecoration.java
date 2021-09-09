package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.chp;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SDCardItemDecoration extends RecyclerView.O0000Oo {
    private int space;

    SDCardItemDecoration() {
        this.space = 0;
        this.space = (int) (chp.O00000o0 * 2.0f);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        int i;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i2 = this.space;
        int i3 = i2 * 2;
        int i4 = i2 * 2;
        if (childAdapterPosition >= 0) {
            int i5 = childAdapterPosition + 1;
            if (i5 <= 3) {
                i3 = i2 * 7;
            }
            int i6 = i5 % 3;
            int i7 = 0;
            if (i6 == 1) {
                i = this.space;
                i7 = i * 7;
            } else if (i6 == 2) {
                i = this.space;
            } else {
                i = this.space * 7;
            }
            rect.set(i7, i3, i, i4);
        }
    }
}
