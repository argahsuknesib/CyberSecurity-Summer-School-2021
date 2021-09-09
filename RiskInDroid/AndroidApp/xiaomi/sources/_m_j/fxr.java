package _m_j;

import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.xiaomi.smarthome.framework.plugin.rn.jsc.JSCallee;
import com.xiaomi.smarthome.framework.plugin.rn.jsc.JSCaller;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class fxr implements Closeable {
    private static final AtomicLong O00000oO = new AtomicLong(100);

    /* renamed from: O000000o  reason: collision with root package name */
    private final Map<Class<? extends NativeModule>, ModuleHolder> f17378O000000o = new HashMap();
    private final Map<String, Class<? extends NativeModule>> O00000Oo = new HashMap();
    private CatalystInstanceImpl O00000o = null;
    private JSCallee O00000o0 = null;
    private final String O00000oo = ("jsc_" + O00000oO.incrementAndGet());

    public void O000000o(ReactApplicationContext reactApplicationContext, String str, String str2) throws Exception {
    }

    public String O000000o() {
        return this.O00000oo;
    }

    public boolean O00000Oo() {
        CatalystInstanceImpl catalystInstanceImpl = this.O00000o;
        return catalystInstanceImpl != null && catalystInstanceImpl.hasRunJSBundle() && !this.O00000o.isDestroyed();
    }

    public void close() {
        CatalystInstanceImpl catalystInstanceImpl = this.O00000o;
        if (catalystInstanceImpl != null) {
            if (catalystInstanceImpl.isDestroyed()) {
                this.O00000o = null;
                return;
            }
            synchronized (this) {
                if (!catalystInstanceImpl.isDestroyed()) {
                    catalystInstanceImpl.destroy();
                }
            }
            this.O00000o = null;
        }
    }

    public void O000000o(String str, String str2, fxv fxv) {
        if (this.O00000o0 == null || !O00000Oo()) {
            fxv.O00000Oo("jsc is not ready");
            return;
        }
        String add = this.O00000o0.add(fxv);
        try {
            ((JSCaller) this.O00000o.getJSModule(JSCaller.class)).invoke(add, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            if (!this.O00000o0.checkInvokedAndRemove(add)) {
                fxv.O00000Oo(e.getMessage());
            }
        }
    }
}
