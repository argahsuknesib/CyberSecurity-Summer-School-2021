package _m_j;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.List;

public abstract class bjz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f13015O000000o = bij.f13001O000000o;
    protected Handler O00000Oo = new Handler(Looper.getMainLooper());
    protected bkf O00000o0;

    public abstract List<String> O000000o();

    public abstract boolean O000000o(Intent intent);

    protected bjz(bkf bkf) {
        this.O00000o0 = bkf;
    }

    /* access modifiers changed from: protected */
    public final List<bkm> O000000o(Class<?> cls) {
        List<bkm> O000000o2 = this.O00000o0.O000000o(cls);
        if (O000000o2 != null) {
            return O000000o2;
        }
        return Collections.EMPTY_LIST;
    }
}
