package com.xiaomi.smarthome;

import _m_j.clx;
import _m_j.cmb;
import _m_j.ez;
import _m_j.fa;
import _m_j.fi;
import _m_j.gft;
import _m_j.gfu;
import _m_j.ggb;
import _m_j.gsy;
import android.app.LocalActivityManager;
import androidx.lifecycle.Lifecycle;
import com.xiaomi.smarthome.application.CommonApplication;

public class SmartHomeMainActivityLifecycle implements ez {

    /* renamed from: O000000o  reason: collision with root package name */
    clx f4134O000000o;
    private ez O00000Oo;

    public SmartHomeMainActivityLifecycle() {
        if (!cmb.O000000o()) {
            cmb.O00000Oo();
        }
    }

    @fi(O000000o = Lifecycle.Event.ON_CREATE)
    public void onCreate(fa faVar) {
        gsy.O00000Oo("SmartHomeMainActivityLifecycle", "onCreate");
        try {
            if (this.f4134O000000o != null) {
                ggb.O0000o00();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gfu O000000o2 = gft.O000000o();
            if (this.O00000Oo != null && O000000o2 != null) {
                O000000o2.isShowGlobalShop(CommonApplication.getApplication());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @fi(O000000o = Lifecycle.Event.ON_START)
    public void onStart(fa faVar) {
        gsy.O00000Oo("SmartHomeMainActivityLifecycle", "onStart");
        try {
            if (this.f4134O000000o != null) {
                ggb.O0000o00();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gfu O000000o2 = gft.O000000o();
            if (this.O00000Oo != null && O000000o2 != null) {
                O000000o2.isShowGlobalShop(CommonApplication.getApplication());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @fi(O000000o = Lifecycle.Event.ON_RESUME)
    public void onResume(fa faVar) {
        gsy.O00000Oo("SmartHomeMainActivityLifecycle", "onResume");
        try {
            if (this.f4134O000000o != null) {
                ggb.O0000o00();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gfu O000000o2 = gft.O000000o();
            if (this.O00000Oo != null && O000000o2 != null) {
                O000000o2.isShowGlobalShop(CommonApplication.getApplication());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @fi(O000000o = Lifecycle.Event.ON_PAUSE)
    public void onPause(fa faVar) {
        gsy.O00000Oo("SmartHomeMainActivityLifecycle", "onPause");
        try {
            if (this.f4134O000000o != null) {
                ggb.O0000o00();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gfu O000000o2 = gft.O000000o();
            if (this.O00000Oo != null && O000000o2 != null) {
                O000000o2.isShowGlobalShop(CommonApplication.getApplication());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @fi(O000000o = Lifecycle.Event.ON_STOP)
    public void onStop(fa faVar) {
        gsy.O00000Oo("SmartHomeMainActivityLifecycle", "onStop");
        try {
            if (this.f4134O000000o != null) {
                ggb.O0000o00();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gfu O000000o2 = gft.O000000o();
            if (this.O00000Oo != null && O000000o2 != null) {
                O000000o2.isShowGlobalShop(CommonApplication.getApplication());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @fi(O000000o = Lifecycle.Event.ON_DESTROY)
    public void onDestroy(fa faVar) {
        gsy.O00000Oo("SmartHomeMainActivityLifecycle", "onDestroy");
        try {
            if (this.f4134O000000o != null) {
                ggb.O0000o00();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @fi(O000000o = Lifecycle.Event.ON_ANY)
    public void onAny(fa faVar) {
        try {
            gsy.O00000Oo("SmartHomeMainActivityLifecycle", "onAny");
            if (this.f4134O000000o != null) {
                ggb.O0000o00();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O000000o(long j) {
        try {
            gsy.O00000Oo("SmartHomeMainActivityLifecycle", "onDelayed ".concat(String.valueOf(j)));
            if (this.f4134O000000o != null) {
                ggb.O0000o00();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final LocalActivityManager O000000o() {
        try {
            gsy.O00000Oo("SmartHomeMainActivityLifecycle", "getLocalActivityManager ");
            if (this.f4134O000000o == null || ggb.O0000o00()) {
                return null;
            }
            return this.f4134O000000o.O000000o();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean O00000Oo() {
        try {
            gsy.O00000Oo("SmartHomeMainActivityLifecycle", "onKeyUp ");
            if (this.f4134O000000o == null || ggb.O0000o00()) {
                return false;
            }
            return this.f4134O000000o.O00000Oo();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void O00000o0() {
        try {
            gsy.O00000Oo("SmartHomeMainActivityLifecycle", "openYPUrl ");
            if (this.f4134O000000o != null) {
                ggb.O0000o00();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
