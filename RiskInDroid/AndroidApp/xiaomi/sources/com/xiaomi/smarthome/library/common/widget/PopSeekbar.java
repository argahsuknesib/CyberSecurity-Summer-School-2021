package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class PopSeekbar extends BaseSeekbar {
    private O000000o O0000Oo;
    private PopupWindow O0000OoO;
    protected ImageView O0000o;
    protected View O0000o0O;
    protected TextView O0000o0o;
    protected int O0000oO;
    protected boolean O0000oO0;

    public interface O000000o {
    }

    public PopSeekbar(Context context) {
        this(context, null);
        O00000o0();
    }

    public PopSeekbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000oO0 = false;
        this.O0000oO = 10;
        O00000o0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void}
     arg types: [android.view.View, int, int, int]
     candidates:
      ClspMth{android.widget.PopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void}
      ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void} */
    private void O00000o0() {
        this.O0000o0O = LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_color_seekbar_pop, (ViewGroup) null);
        this.O0000o0o = (TextView) this.O0000o0O.findViewById(R.id.txt_pop_progress);
        this.O0000o = (ImageView) this.O0000o0O.findViewById(R.id.img_pop_inner);
        View view = this.O0000o0O;
        this.O0000OoO = new PopupWindow(view, view.getWidth(), this.O0000o0O.getHeight(), false);
        this.O0000OoO.setAnimationStyle(R.style.PopupNoneAnimStyle);
    }

    /* access modifiers changed from: package-private */
    public void O000000o(float f, boolean z) {
        super.O000000o(f, z);
        if (this.O0000oO0) {
            int O00000Oo = (O00000Oo(this.O0000o0O) + getHeight()) - gri.O000000o(8.0f);
            if (this.O0000OoO != null) {
                try {
                    int centerX = this.O00000oo.getBounds().centerX() - (O000000o(this.O0000o0O) / 2);
                    if (!this.O0000OoO.isShowing()) {
                        this.O0000OoO.showAsDropDown(this, centerX, -O00000Oo);
                    }
                    this.O0000OoO.update(this, centerX, -O00000Oo, O000000o(this.O0000o0O), O00000Oo(this.O0000o0O));
                    if (this.O0000o0o.getVisibility() == 0) {
                        TextView textView = this.O0000o0o;
                        StringBuilder sb = new StringBuilder();
                        sb.append(getShowProgress());
                        textView.setText(sb.toString());
                    }
                } catch (Exception unused) {
                }
            }
        } else {
            O00000o();
        }
        if (this.O0000Oo != null) {
            getProgress();
        }
    }

    public void setOnSeekBarChangeListener(O000000o o000000o) {
        this.O0000Oo = o000000o;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        this.O0000oO0 = true;
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        this.O0000oO0 = false;
        O00000o();
    }

    private void O00000o() {
        PopupWindow popupWindow = this.O0000OoO;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.O0000OoO.dismiss();
        }
    }

    private static int O000000o(View view) {
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        } catch (Exception unused) {
        }
        return view.getMeasuredWidth();
    }

    private static int O00000Oo(View view) {
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        } catch (Exception unused) {
        }
        return view.getMeasuredHeight();
    }

    public void setShowProgress(int i) {
        setProgress(O000000o(i));
    }

    public int getShowProgress() {
        return (getProgress() * this.O0000oO) / getMax();
    }

    /* access modifiers changed from: protected */
    public final int O000000o(int i) {
        return (i * getMax()) / this.O0000oO;
    }

    public void setShowMax(int i) {
        this.O0000oO = i;
    }

    public int getShowMax() {
        return this.O0000oO;
    }
}
