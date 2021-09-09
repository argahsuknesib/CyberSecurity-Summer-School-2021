package cn.com.xm.bt.b;

import android.content.Context;
import cn.com.xm.bt.profile.a.a;
import cn.com.xm.bt.profile.b.e;
import cn.com.xm.bt.profile.b.f;
import cn.com.xm.bt.profile.nfc.ApduResponse;
import cn.com.xm.bt.profile.nfc.HMAccessInfo;
import cn.com.xm.bt.profile.nfc.HMAidInfo;
import cn.com.xm.bt.profile.nfc.HMNFCStatus;
import cn.com.xm.bt.profile.nfc.b;

public class d extends a implements e {
    private f d = null;
    private b e = null;
    private cn.com.xm.bt.d.e f = null;

    public d(Context context, String str) {
        super(context, str);
    }

    public c c() {
        return c.MILI;
    }

    public boolean a(a aVar, cn.com.xm.bt.profile.a.f fVar) {
        return new cn.com.xm.bt.profile.a.d(this.d).a(aVar, fVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.c.a(this);
    }

    public void a(cn.com.xm.bt.d.e eVar) {
        this.f = eVar;
        cn.com.xm.bt.a.a.b("HMBaseBleDevice", "onStepChanged:".concat(String.valueOf(eVar)));
    }

    public cn.com.xm.bt.d.e h() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public cn.com.xm.bt.profile.b.a b() {
        this.d = new f(this.f3075a, this.b, this);
        this.e = new b(this.d);
        return this.d;
    }

    public HMNFCStatus a(cn.com.xm.bt.profile.nfc.d dVar) {
        if (!e()) {
            return null;
        }
        return this.e.a(dVar);
    }

    public HMNFCStatus i() {
        if (!e()) {
            return null;
        }
        return this.e.a();
    }

    public ApduResponse a(cn.com.xm.bt.profile.nfc.a aVar) {
        if (e()) {
            return this.e.a(aVar.a(), aVar.b(), aVar.c());
        }
        return null;
    }

    public boolean a(HMAidInfo hMAidInfo) {
        if (!e() || hMAidInfo == null) {
            return false;
        }
        return this.d.a(hMAidInfo);
    }

    public boolean a(HMAccessInfo hMAccessInfo) {
        if (!e()) {
            return false;
        }
        return this.d.a(hMAccessInfo);
    }
}
