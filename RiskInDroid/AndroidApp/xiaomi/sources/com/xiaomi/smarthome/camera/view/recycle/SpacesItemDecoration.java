package com.xiaomi.smarthome.camera.view.recycle;

import _m_j.chp;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecoration extends RecyclerView.O0000Oo {
    private int space;

    public SpacesItemDecoration(int i) {
        this.space = (int) (((float) i) * chp.O00000o0);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        int i = this.space;
        rect.right = i;
        rect.bottom = i;
        rect.top = 0;
        rect.left = 0;
    }
}
