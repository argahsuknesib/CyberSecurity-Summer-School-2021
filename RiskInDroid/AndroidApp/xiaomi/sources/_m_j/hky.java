package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors.LoginInterceptor;
import com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors.MibiInterceptor;
import com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors.ThirdSchemeInterceptor;

public final class hky {

    /* renamed from: O000000o  reason: collision with root package name */
    public final hkx f19027O000000o = new hkx();

    public final void O000000o(Context context) {
        this.f19027O000000o.O000000o(hlf.class.getSimpleName(), new hlf());
        this.f19027O000000o.O000000o(MibiInterceptor.class.getSimpleName(), new MibiInterceptor(context));
        this.f19027O000000o.O000000o(ThirdSchemeInterceptor.class.getSimpleName(), new ThirdSchemeInterceptor(context));
        this.f19027O000000o.O000000o(hkz.class.getSimpleName(), new hkz());
        this.f19027O000000o.O000000o(LoginInterceptor.class.getSimpleName(), new LoginInterceptor(context));
        this.f19027O000000o.O000000o(hla.class.getSimpleName(), new hla());
        this.f19027O000000o.O000000o("StatUrlInterceptorAdapter", new hll());
    }
}
