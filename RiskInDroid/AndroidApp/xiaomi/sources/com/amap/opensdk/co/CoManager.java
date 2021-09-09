package com.amap.opensdk.co;

import _m_j.btx;
import _m_j.bua;
import _m_j.bwt;
import _m_j.of;
import _m_j.og;
import _m_j.oi;
import _m_j.ph;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import com.loc.ch;
import com.loc.cp;
import com.loc.cr;
import org.json.JSONObject;

public class CoManager {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f3563O000000o = null;
    public volatile boolean O00000Oo = false;
    public cr O00000o = null;
    public btx O00000o0 = null;
    public boolean O00000oO = false;
    public ch O00000oo = null;
    boolean O0000O0o = false;
    private cp O0000OOo = null;
    private boolean O0000Oo0 = false;

    public CoManager(Context context) {
        if (context != null) {
            try {
                this.f3563O000000o = context;
            } catch (Throwable th) {
                bua.O000000o(th, "CoManager", "<init>");
            }
        }
    }

    public static String O00000o0() {
        try {
            return oi.O00000o0();
        } catch (Throwable th) {
            bua.O000000o(th, "CoManager", "getCollectVersion");
            return null;
        }
    }

    public final String O000000o(String str, ScanResult[] scanResultArr) {
        try {
            if (this.O00000Oo) {
                if (!this.O00000oO) {
                    O000000o();
                    O0000O0o();
                    return this.O0000OOo.O000000o(str, scanResultArr, false);
                }
            }
            return null;
        } catch (Throwable th) {
            new String[]{"getOfflineLocation error!!!!"};
            bua.O000000o(th, "CoManager", "getOfflineLoc");
            return null;
        }
    }

    public final void O00000Oo() {
        try {
            if (!this.O00000Oo) {
                System.loadLibrary("apssdk");
                this.O00000Oo = true;
            }
        } catch (Throwable unused) {
        }
    }

    public final void O00000oo() {
        try {
            O00000o();
            O00000oO();
            og.O000000o().O00000Oo();
            this.O0000O0o = false;
            this.O00000oO = true;
            this.f3563O000000o = null;
            this.O00000Oo = false;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oO = false;
            this.O0000Oo0 = false;
        } catch (Throwable th) {
            bua.O000000o(th, "CoManager", "destroy");
        }
    }

    public final void O0000O0o() {
        try {
            if (this.O0000OOo == null) {
                this.O0000OOo = new cp(this.f3563O000000o);
                this.O0000OOo.O000000o(this.O00000o0, this.O00000o);
            }
        } catch (Throwable th) {
            bua.O000000o(th, "CoManager", "initOfflineManager");
        }
    }

    public final void O000000o(String str) {
        if (!this.O0000Oo0) {
            try {
                if (this.O00000o0 == null) {
                    this.O00000o0 = new btx();
                }
                if (str != null) {
                    JSONObject jSONObject = new JSONObject(str);
                    this.O00000o0.O00000Oo = jSONObject.optString("als", "");
                    this.O00000o0.f13278O000000o = jSONObject.optString("sv", "");
                    this.O00000o0.O00000o = jSONObject.optString("pn", "");
                    this.O00000o0.O00000o0 = jSONObject.optString("ak", "");
                    this.O00000o0.O00000oO = jSONObject.optString("au", "");
                    this.O00000o0.O00000oo = jSONObject.optString("ud", "");
                    this.O00000o0.O0000O0o = jSONObject.optBoolean("isimei", true);
                }
            } catch (Throwable th) {
                bua.O000000o(th, "CoManager", "init");
                return;
            }
            if (this.O00000o == null) {
                this.O00000o = new cr(this.f3563O000000o);
            }
            cr crVar = this.O00000o;
            btx btx = this.O00000o0;
            crVar.O00000o = btx;
            if (btx != null) {
                crVar.f4523O000000o = btx.O00000o0;
            }
            if (TextUtils.isEmpty(crVar.f4523O000000o)) {
                crVar.f4523O000000o = bwt.O00000oo(crVar.O00000o0);
            }
            this.O0000Oo0 = true;
        }
    }

    public final void O000000o() {
        try {
            if (!this.O0000O0o && this.O0000Oo0) {
                of ofVar = new of();
                of.O00000o(this.O00000o0.O00000oO);
                ofVar.O000000o(this.O00000o);
                of.O00000o0(this.O00000o0.O00000Oo);
                of.O00000Oo(this.O00000o0.O00000o0);
                of.O000000o();
                of.O000000o(this.O00000o0.f13278O000000o);
                ofVar.O00000oO(this.O00000o0.O00000oo);
                of.O000000o(this.O00000o0.O0000O0o);
                og.O000000o().O000000o(this.f3563O000000o, ofVar);
                this.O0000O0o = true;
            }
        } catch (Throwable unused) {
        }
    }

    public final void O000000o(int i) {
        cr crVar = this.O00000o;
        if (crVar != null) {
            crVar.O00000Oo = i;
        }
    }

    public final void O00000o() {
        try {
            if (this.O00000oo != null) {
                ch chVar = this.O00000oo;
                if (chVar.O00000Oo != null) {
                    chVar.O00000Oo.O000000o();
                }
                chVar.O00000Oo = null;
            }
        } catch (Throwable th) {
            bua.O000000o(th, "CoManager", "stopCollect");
            return;
        }
        this.O00000oo = null;
    }

    public final void O00000oO() {
        try {
            if (this.O0000OOo != null) {
                cp cpVar = this.O0000OOo;
                ph.O000000o().O00000Oo();
                cpVar.O00000Oo = null;
            }
        } catch (Throwable th) {
            bua.O000000o(th, "CoManager", "destroyOfflineLoc");
            return;
        }
        this.O0000OOo = null;
    }
}
