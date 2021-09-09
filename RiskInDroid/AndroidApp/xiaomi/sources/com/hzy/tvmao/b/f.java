package com.hzy.tvmao.b;

import android.annotation.SuppressLint;
import com.hzy.tvmao.b.a;

public class f extends a {
    public String b = "TestIrCodeControl_getremoteids";
    public String c = "TestIrCodeControl_getRemoteIdData";
    public String d = "TestIrCodeControl_first";
    public String e = "TestIrCodeControl_other";
    public String f = "TestIrCodeControl_stb";
    public String g = "TestIrCodeControl_iptv";
    public String h = "TestIrCodeControl_post";
    public final String i = "ACMatchCodeControl";

    public void a(int i2, int i3, int i4, int i5, String str, a.c cVar) {
        new g(this, cVar, this.b, i2, i3, i4, i5, str).a();
    }

    public void a(String str, int i2, String str2, boolean z, boolean z2, a.c cVar) {
        new j(this, cVar, this.b, str, i2, str2, z, z2).a();
    }

    @SuppressLint({"StaticFieldLeak"})
    public void a(int i2, int i3, int i4, int i5, a.c cVar) {
        new k(this, cVar, "taskkey_get_ridlist_by_samekey", i2, i3, i4, i5).a();
    }

    @SuppressLint({"StaticFieldLeak"})
    public void a(int i2, int i3, boolean z, a.c cVar) {
        new l(this, cVar, "taskkey_ir_data_by_fkey", i2, i3, z).a();
    }

    public void a(int i2, int i3, String str, a.c cVar) {
        new m(this, cVar, this.b, i2, i3, str).a();
    }

    public void a(int i2, a.c cVar) {
        new h(this, cVar, "ACMatchCodeControl", i2).a();
    }

    public void a(int i2, int i3, a.c cVar) {
        new i(this, cVar, "getTVPowerTestKeys", i2, i3).a();
    }
}
