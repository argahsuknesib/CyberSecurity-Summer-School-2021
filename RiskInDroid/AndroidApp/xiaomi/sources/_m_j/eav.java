package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.g;
import com.xiaomi.push.hp;
import com.xiaomi.push.hz;
import com.xiaomi.push.ic;
import com.xiaomi.push.io;
import com.xiaomi.push.ja;
import com.xiaomi.push.service.aw;
import java.util.HashMap;
import java.util.Map;

final class eav implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f15134O000000o;
    final /* synthetic */ boolean O00000Oo;

    eav(Context context, boolean z) {
        this.f15134O000000o = context;
        this.O00000Oo = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    public final void run() {
        String str;
        String str2;
        Map<String, String> map;
        duv.O000000o("do sync info");
        io ioVar = new io(aw.a(), false);
        b O000000o2 = b.O000000o(this.f15134O000000o);
        ioVar.d = hz.v.f70a;
        ioVar.c = O000000o2.O00000Oo.f6054O000000o;
        ioVar.f = this.f15134O000000o.getPackageName();
        ioVar.f133a = new HashMap();
        Map<String, String> map2 = ioVar.f133a;
        Context context = this.f15134O000000o;
        esn.O000000o(map2, "app_version", g.O000000o(context, context.getPackageName()));
        Map<String, String> map3 = ioVar.f133a;
        Context context2 = this.f15134O000000o;
        esn.O000000o(map3, "app_version_code", Integer.toString(g.O00000Oo(context2, context2.getPackageName())));
        esn.O000000o(ioVar.f133a, "push_sdk_vn", "4_2_0");
        esn.O000000o(ioVar.f133a, "push_sdk_vc", Integer.toString(40020));
        esn.O000000o(ioVar.f133a, "token", O000000o2.O00000Oo.O00000Oo);
        erv.O000000o(this.f15134O000000o, ioVar.f133a);
        if (!esl.O00000oo()) {
            String O000000o3 = eml.O000000o(erv.O00000o(this.f15134O000000o));
            String O00000oo = erv.O00000oo(this.f15134O000000o);
            if (!TextUtils.isEmpty(O00000oo)) {
                O000000o3 = O000000o3 + "," + O00000oo;
            }
            if (!TextUtils.isEmpty(O000000o3)) {
                esn.O000000o(ioVar.f133a, "imei_md5", O000000o3);
            }
        }
        elz.O000000o(this.f15134O000000o).O000000o(ioVar.f133a);
        esn.O000000o(ioVar.f133a, "reg_id", O000000o2.O00000Oo.O00000o0);
        esn.O000000o(ioVar.f133a, "reg_secret", O000000o2.O00000Oo.O00000o);
        esn.O000000o(ioVar.f133a, "accept_time", dzs.O0000ooo(this.f15134O000000o).replace(",", "-"));
        if (this.O00000Oo) {
            esn.O000000o(ioVar.f133a, "aliases_md5", eau.O000000o(dzs.O00000Oo(this.f15134O000000o)));
            esn.O000000o(ioVar.f133a, "topics_md5", eau.O000000o(dzs.O00000o0(this.f15134O000000o)));
            map = ioVar.f133a;
            str2 = eau.O000000o(dzs.O00000o(this.f15134O000000o));
            str = "accounts_md5";
        } else {
            esn.O000000o(ioVar.f133a, "aliases", eau.O00000o0(dzs.O00000Oo(this.f15134O000000o)));
            esn.O000000o(ioVar.f133a, "topics", eau.O00000o0(dzs.O00000o0(this.f15134O000000o)));
            map = ioVar.f133a;
            str2 = eau.O00000o0(dzs.O00000o(this.f15134O000000o));
            str = "user_accounts";
        }
        esn.O000000o(map, str, str2);
        eao.O000000o(this.f15134O000000o).O000000o((ja) ioVar, hp.i, false, (ic) null);
    }
}
