package com.tencent.open.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

public class a extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f5874O000000o = "com.tencent.open.b.a";
    private Rect O00000Oo = null;
    private O000000o O00000o = null;
    private boolean O00000o0 = false;

    public interface O000000o {
    }

    public a(Context context) {
        super(context);
        if (this.O00000Oo == null) {
            this.O00000Oo = new Rect();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.O00000Oo);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.O00000Oo.top) - size;
        if (!(this.O00000o == null || size == 0 || height <= 100)) {
            Math.abs(this.O00000Oo.height());
            getPaddingBottom();
            getPaddingTop();
        }
        super.onMeasure(i, i2);
    }
}
