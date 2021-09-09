package _m_j;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class cj extends ClickableSpan {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f13932O000000o;
    private final cl O00000Oo;
    private final int O00000o0;

    public cj(int i, cl clVar, int i2) {
        this.f13932O000000o = i;
        this.O00000Oo = clVar;
        this.O00000o0 = i2;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f13932O000000o);
        cl clVar = this.O00000Oo;
        int i = this.O00000o0;
        if (Build.VERSION.SDK_INT >= 16) {
            clVar.f13980O000000o.performAction(i, bundle);
        }
    }
}
