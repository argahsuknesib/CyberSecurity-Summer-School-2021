package _m_j;

import android.content.Context;
import com.xiaomi.accountsdk.utils.AccountLog;

public abstract class eiv {

    /* renamed from: O000000o  reason: collision with root package name */
    public final eiv f15326O000000o;

    /* access modifiers changed from: protected */
    public abstract boolean O000000o(Context context, Throwable th);

    public eiv(eiv eiv) {
        this.f15326O000000o = eiv;
    }

    public final void O00000Oo(Context context, Throwable th) {
        AccountLog.e("ExceptionHandler", "handle exception", th);
        eiv eiv = this;
        while (eiv != null) {
            if (!eiv.O000000o(context, th)) {
                eiv = eiv.f15326O000000o;
            } else {
                return;
            }
        }
        throw new IllegalStateException("can not handle exception: ".concat(String.valueOf(th)));
    }
}
