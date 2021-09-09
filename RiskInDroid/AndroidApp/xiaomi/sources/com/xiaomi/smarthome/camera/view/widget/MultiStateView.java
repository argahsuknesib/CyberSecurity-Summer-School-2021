package com.xiaomi.smarthome.camera.view.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class MultiStateView extends ImageView implements View.OnClickListener {
    int mCurrentState;
    Handler mMainHandler;
    List<StateItem> mStatItems;

    public MultiStateView(Context context) {
        super(context, null);
        this.mCurrentState = 0;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mStatItems = new ArrayList(5);
    }

    public MultiStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MultiStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentState = 0;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mStatItems = new ArrayList(5);
        setOnClickListener(this);
    }

    public static class StateItem {
        View.OnClickListener mOnClickListener;
        int topBitmapRes;

        public StateItem(int i, View.OnClickListener onClickListener) {
            this.topBitmapRes = i;
            this.mOnClickListener = onClickListener;
        }
    }

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
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.camera.view.widget.MultiStateView.AnonymousClass1 */

                public void run() {
                    StateItem stateItem = MultiStateView.this.mStatItems.get(MultiStateView.this.mCurrentState);
                    if (stateItem.topBitmapRes > 0) {
                        MultiStateView multiStateView = MultiStateView.this;
                        multiStateView.setImageDrawable(multiStateView.getResources().getDrawable(stateItem.topBitmapRes));
                    }
                }
            });
        }
    }
}
