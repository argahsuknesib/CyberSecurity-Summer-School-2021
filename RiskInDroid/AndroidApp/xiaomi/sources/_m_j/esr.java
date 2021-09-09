package _m_j;

import android.content.SharedPreferences;

final class esr implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ String f15777O000000o;
    final /* synthetic */ String O00000Oo;
    final /* synthetic */ esq O00000o;
    final /* synthetic */ String O00000o0;

    esr(esq esq, String str, String str2, String str3) {
        this.O00000o = esq;
        this.f15777O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
    }

    public final void run() {
        SharedPreferences.Editor edit = this.O00000o.O00000Oo.getSharedPreferences(this.f15777O000000o, 4).edit();
        edit.putString(this.O00000Oo, this.O00000o0);
        edit.commit();
    }
}
