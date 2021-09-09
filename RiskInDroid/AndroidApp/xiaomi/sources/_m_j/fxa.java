package _m_j;

import android.view.ViewGroup;

public class fxa {
    private static volatile fxa O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile int f17359O000000o = gbt.O00000o0();
    public o0oOo0O0<fwv, fwy> O00000Oo;
    public fwy O00000o;
    public fwy O00000o0;

    private fxa() {
        gbu.O00000oo("ReuseManager init()-->mMaxLimitLoadCount:" + this.f17359O000000o);
        this.O00000Oo = new o0oOo0O0<fwv, fwy>(this.f17359O000000o) {
            /* class _m_j.fxa.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ int sizeOf(Object obj, Object obj2) {
                return 1;
            }

            public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
                fwv fwv = (fwv) obj;
                fwy fwy = (fwy) obj2;
                fwy fwy2 = (fwy) obj3;
                gbu.O00000oo("ReuseManager entryRemoved,evicted=" + z + ",key=" + fwv + ",oldValue=" + fwy + ",newValue=" + fwy2);
                super.entryRemoved(z, fwv, fwy, fwy2);
                if (z && fwy != null) {
                    if (fwy == fxa.this.O00000o) {
                        gbu.O00000oo("ReuseManager entryRemoved,current rnruntime not  destory");
                        return;
                    }
                    gbu.O00000oo("ReuseManager entryRemoved,destory rnruntime,key=".concat(String.valueOf(fwv)));
                    gbu.O00000oo("RNRuntime destroy(),");
                    if (fwy.O0000O0o != null) {
                        gbu.O00000oo("RNRuntime destroy(),mReactInstanceManager.destroy");
                        if (fwy.O00000o != null) {
                            if (fwy.O00000o.getParent() instanceof ViewGroup) {
                                ((ViewGroup) fwy.O00000o.getParent()).removeView(fwy.O00000o);
                            }
                            if (fwy.O0000O0o.getCurrentReactContext() != null) {
                                fwy.O00000o.unmountReactApplication();
                            }
                        }
                        fwy.O0000O0o.destroy();
                        fwy.O0000O0o = null;
                    }
                }
            }
        };
    }

    public static fxa O000000o() {
        if (O00000oO == null) {
            synchronized (fxa.class) {
                if (O00000oO == null) {
                    O00000oO = new fxa();
                }
            }
        }
        return O00000oO;
    }

    public final void O000000o(fwy fwy) {
        gbu.O00000oo("ReuseManager setClearRNRuntime(),rnRuntime=".concat(String.valueOf(fwy)));
        this.O00000o0 = fwy;
    }

    public final void O000000o(fwv fwv, fwy fwy) {
        gbu.O00000oo("ReuseManager addCache(),pluginBundleKey=".concat(String.valueOf(fwv)));
        fwy fwy2 = this.O00000Oo.get(fwv);
        if (fwy2 == null || fwy2.O000O00o != fwy.O000O00o) {
            this.O00000Oo.put(fwv, fwy);
        }
        O00000o0();
        gbu.O00000oo("ReuseManager addCache,add over,mReuseProcessMap.size()=" + this.O00000Oo.size());
    }

    private void O00000o0() {
        int O00000o02 = gbt.O00000o0();
        if (this.f17359O000000o != O00000o02 && O00000o02 > 0) {
            gbu.O00000oo("ReuseManager.java:checkCacheLimit -->>resize to ".concat(String.valueOf(O00000o02)));
            this.O00000Oo.resize(O00000o02);
            this.f17359O000000o = O00000o02;
        }
    }

    public final void O00000Oo() {
        gbu.O00000oo("ReuseManager onLowMemory,evictAll");
        this.O00000Oo.evictAll();
    }
}
