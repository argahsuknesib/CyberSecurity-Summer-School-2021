package androidx.appcompat.widget;

import _m_j.Oo;
import _m_j.cw;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import com.xiaomi.smarthome.R;

class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final boolean f2705O000000o = (Build.VERSION.SDK_INT < 21);
    private boolean O00000Oo;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet, i, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        O000000o(context, attributeSet, i, i2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.Oo.O000000o(int, boolean):boolean
     arg types: [int, int]
     candidates:
      _m_j.Oo.O000000o(int, int):int
      _m_j.Oo.O000000o(int, boolean):boolean */
    private void O000000o(Context context, AttributeSet attributeSet, int i, int i2) {
        Oo O000000o2 = Oo.O000000o(context, attributeSet, new int[]{16843126, 16843465, R.attr.overlapAnchor}, i, i2);
        if (O000000o2.O0000O0o(2)) {
            O000000o(O000000o2.O000000o(2, false));
        }
        setBackgroundDrawable(O000000o2.O000000o(0));
        O000000o2.f12340O000000o.recycle();
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2705O000000o && this.O00000Oo) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2705O000000o && this.O00000Oo) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f2705O000000o && this.O00000Oo) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cw.O000000o(android.widget.PopupWindow, boolean):void
     arg types: [androidx.appcompat.widget.AppCompatPopupWindow, boolean]
     candidates:
      _m_j.cw.O000000o(android.widget.PopupWindow, int):void
      _m_j.cw.O000000o(android.widget.PopupWindow, boolean):void */
    private void O000000o(boolean z) {
        if (f2705O000000o) {
            this.O00000Oo = z;
        } else {
            cw.O000000o((PopupWindow) this, z);
        }
    }
}
