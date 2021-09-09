package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class fpc implements fpg {

    /* renamed from: O000000o  reason: collision with root package name */
    protected List<String> f16797O000000o = new ArrayList();
    protected Context O00000Oo = CommonApplication.getAppContext();
    protected Handler O00000o0 = new Handler(Looper.getMainLooper());

    protected fpc() {
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String[] strArr) {
        if (this.f16797O000000o == null) {
            this.f16797O000000o = new ArrayList();
        }
        if (strArr != null && strArr.length > 0) {
            this.f16797O000000o.addAll(Arrays.asList(strArr));
        }
    }

    public final List<String> O000000o() {
        return this.f16797O000000o;
    }
}
