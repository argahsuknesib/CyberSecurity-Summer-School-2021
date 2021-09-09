package com.xiaomi.mico.music.player.lrc;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public abstract class LrcView extends View {
    protected String mEmptyText;
    protected List<LrcRow> mLrcRows;

    /* access modifiers changed from: protected */
    public abstract void init(Context context, AttributeSet attributeSet);

    /* access modifiers changed from: protected */
    public abstract void onReset();

    public abstract void seekTo(int i, boolean z, boolean z2);

    public LrcView(Context context) {
        this(context, null);
    }

    public LrcView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public void setEmptyText(String str) {
        this.mEmptyText = str;
    }

    public boolean hasLrcRows() {
        List<LrcRow> list = this.mLrcRows;
        return list != null && !list.isEmpty();
    }

    public void setLrcRows(List<LrcRow> list) {
        this.mLrcRows = list;
        onReset();
        invalidateView();
    }

    public void reset() {
        this.mLrcRows = null;
        onReset();
        invalidateView();
    }

    /* access modifiers changed from: protected */
    public void invalidateView() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }
}
