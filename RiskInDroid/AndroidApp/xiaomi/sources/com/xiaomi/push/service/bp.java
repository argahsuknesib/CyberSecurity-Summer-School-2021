package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.elr;
import _m_j.eme;
import _m_j.ent;
import _m_j.eou;
import _m_j.esu;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.r;
import com.xiaomi.push.service.bo;
import java.util.List;

class bp extends elr.O00000Oo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f6531a;

    /* renamed from: a  reason: collision with other field name */
    boolean f297a = false;

    bp(bo boVar) {
        this.f6531a = boVar;
    }

    public void c() {
        bo.a[] aVarArr;
        elr.O00000Oo unused = this.f6531a.f294a = (elr.O00000Oo) null;
        if (this.f297a) {
            synchronized (this.f6531a) {
                aVarArr = (bo.a[]) bo.a(this.f6531a).toArray(new bo.a[bo.a(this.f6531a).size()]);
            }
            for (bo.a a2 : aVarArr) {
                a2.a(bo.a(this.f6531a));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045 A[Catch:{ Exception -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    public void b() {
        String str;
        eou.O000000o o000000o;
        try {
            String a2 = a.a(esu.O000000o()).a();
            if (!TextUtils.isEmpty(a2)) {
                if (!r.f6460a.name().equals(a2)) {
                    str = "https://resolver.msg.global.xiaomi.net/psc/?t=a";
                    o000000o = (eou.O000000o) new eou.O000000o().O000000o(Base64.decode(ent.O000000o(esu.O000000o(), str, (List<eme>) null, new ent.O000000o()), 10));
                    if (o000000o == null) {
                        eou.O000000o unused = this.f6531a.f295a = o000000o;
                        this.f297a = true;
                        bo.a(this.f6531a);
                        return;
                    }
                    return;
                }
            }
            str = "https://resolver.msg.xiaomi.net/psc/?t=a";
            o000000o = (eou.O000000o) new eou.O000000o().O000000o(Base64.decode(ent.O000000o(esu.O000000o(), str, (List<eme>) null, new ent.O000000o()), 10));
            if (o000000o == null) {
            }
        } catch (Exception e) {
            duv.O000000o("fetch config failure: " + e.getMessage());
        }
    }
}
