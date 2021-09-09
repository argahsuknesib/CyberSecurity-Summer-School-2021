package com.xiaomi.mico.music.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class StationTabCell extends LinearLayout {
    private int index;
    private TextView nameView;
    private float textSizeMax;
    private float textSizeSmall;

    public StationTabCell(Context context) {
        super(context);
        initView(context);
    }

    public StationTabCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public StationTabCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.view_station_tab_cell, this);
        this.nameView = (TextView) findViewById(R.id.name);
    }

    public void setTabName(String str) {
        this.nameView.setText(str);
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void setTextSize(float f, float f2) {
        this.textSizeSmall = f;
        this.textSizeMax = f2;
    }

    public void setSelected(boolean z) {
        this.nameView.setSelected(z);
        if (z) {
            this.nameView.setTextSize(2, 17.0f);
        } else {
            this.nameView.setTextSize(2, 15.0f);
        }
    }
}
