package com.xiaomi.smarthome.camera.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MultiStateTextView extends TextView implements View.OnClickListener {
    int mCurrentState;
    List<StateItem> mStatItems;

    public void onClick(View view) {
        int i;
        List<StateItem> list = this.mStatItems;
        if (list != null && (i = this.mCurrentState) >= 0 && i < list.size()) {
            StateItem stateItem = this.mStatItems.get(this.mCurrentState);
            if (stateItem.mOnClickListener != null) {
                stateItem.mOnClickListener.onClick(view);
            }
        }
    }

    public static class StateItem {
        View.OnClickListener mOnClickListener;
        int textRes;
        int topBitmapRes;

        public StateItem(int i, int i2, View.OnClickListener onClickListener) {
            this.textRes = i;
            this.topBitmapRes = i2;
            this.mOnClickListener = onClickListener;
        }
    }

    public MultiStateTextView(Context context) {
        this(context, null);
    }

    public MultiStateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.mStatItems = new ArrayList(5);
        setOnClickListener(this);
    }

    public void addState(StateItem stateItem) {
        this.mStatItems.add(stateItem);
    }

    public void setCurrentState(int i) {
        this.mCurrentState = i;
        refresh();
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    /* access modifiers changed from: package-private */
    public void refresh() {
        int i;
        List<StateItem> list = this.mStatItems;
        if (list != null && (i = this.mCurrentState) >= 0 && i < list.size()) {
            StateItem stateItem = this.mStatItems.get(this.mCurrentState);
            setText(stateItem.textRes);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, stateItem.topBitmapRes > 0 ? getResources().getDrawable(stateItem.topBitmapRes) : null, (Drawable) null, (Drawable) null);
        }
    }
}
