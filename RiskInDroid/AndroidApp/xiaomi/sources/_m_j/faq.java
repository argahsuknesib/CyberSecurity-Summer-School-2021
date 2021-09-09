package _m_j;

import com.tencent.mmkv.MMKV;

public final class faq {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16028O000000o;

    public faq(String str) {
        this.f16028O000000o = str;
    }

    public faq() {
        this.f16028O000000o = "NONE";
    }

    public final void O000000o() {
        MMKV.O000000o(this.f16028O000000o).O000000o("KEY.CONNECT.STATUS", 2);
    }

    public final int O00000Oo() {
        return MMKV.O000000o(this.f16028O000000o).O00000Oo("KEY.CONNECT.STATUS", 0);
    }

    public final void O000000o(boolean z) {
        MMKV.O000000o(this.f16028O000000o).O000000o("KEY.IS_OTA", z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.tencent.mmkv.MMKV.O00000Oo(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      com.tencent.mmkv.MMKV.O00000Oo(java.lang.String, int):int
      com.tencent.mmkv.MMKV.O00000Oo(java.lang.String, java.util.Set<java.lang.String>):java.util.Set<java.lang.String>
      com.tencent.mmkv.MMKV.O00000Oo(java.lang.String, java.lang.String):boolean
      com.tencent.mmkv.MMKV.O00000Oo(java.lang.String, boolean):boolean */
    public final boolean O00000o0() {
        return MMKV.O000000o(this.f16028O000000o).O00000Oo("KEY.IS_OTA", false);
    }

    public final void O000000o(String str) {
        MMKV.O000000o(this.f16028O000000o).O00000Oo("KEY.LATEST.VERSION", str);
    }

    public final void O00000Oo(String str) {
        MMKV.O000000o(this.f16028O000000o).O00000Oo("KEY.CURRENT.VERSION", str);
    }

    public final String toString() {
        return String.format("BleDeviceState{mac = %s \n,connect status = %d, \n isOTA = %s, \n currentVersion=%s,\n latestVersion=%s", this.f16028O000000o, Integer.valueOf(O00000Oo()), Boolean.valueOf(O00000o0()), MMKV.O000000o(this.f16028O000000o).O00000Oo("KEY.CURRENT.VERSION"), MMKV.O000000o(this.f16028O000000o).O00000o0("KEY.LATEST.VERSION", ""));
    }
}
