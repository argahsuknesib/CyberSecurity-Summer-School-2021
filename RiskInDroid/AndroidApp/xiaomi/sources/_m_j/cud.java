package _m_j;

import android.content.Intent;
import android.text.TextUtils;

public final class cud extends cuc {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f14362O000000o;

    public cud(String str) {
        if (TextUtils.isEmpty(str)) {
            new NullPointerException("className不应该为空");
            cvb.O0000OOo();
        }
        this.f14362O000000o = str;
    }

    /* access modifiers changed from: protected */
    public final Intent O00000Oo(cvg cvg) {
        return new Intent().setClassName(cvg.f14384O000000o, this.f14362O000000o);
    }

    public final String toString() {
        return "ActivityHandler (" + this.f14362O000000o + ")";
    }
}
