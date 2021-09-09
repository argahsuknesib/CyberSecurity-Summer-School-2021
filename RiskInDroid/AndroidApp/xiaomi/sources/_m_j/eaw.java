package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.hp;
import com.xiaomi.push.hu;
import com.xiaomi.push.hz;
import com.xiaomi.push.io;
import com.xiaomi.push.ja;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.aw;
import java.util.HashMap;

public final class eaw implements epe {
    public final void b(Context context, HashMap<String, String> hashMap) {
        dzz.O000000o("category_awake_app", "wake_up_app", eow.O000000o(hashMap));
        duv.O000000o("MoleInfo：　send data in app layer");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, int]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void */
    public final void a(Context context, HashMap<String, String> hashMap) {
        io ioVar = new io();
        ioVar.c = epb.O000000o(context).O00000Oo;
        ioVar.f = epb.O000000o(context).O00000o0;
        ioVar.d = hz.I.f70a;
        ioVar.b = aw.a();
        ioVar.f133a = hashMap;
        eao.O000000o(context).O000000o((ja) ioVar, hp.i, true, true);
        duv.O000000o("MoleInfo：　send data in app layer");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public final void c(Context context, HashMap<String, String> hashMap) {
        duv.O000000o("MoleInfo：　" + eow.O00000Oo(hashMap));
        String str = hashMap.get("awake_info");
        if ("1007".equals(hashMap.get("event_type"))) {
            duv.O000000o("aw_ping : send aw_ping cmd and content to push service from 3rd app");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("awake_info", str);
            hashMap2.put("event_type", "9999");
            hashMap2.put("description", "ping message");
            io ioVar = new io();
            ioVar.c = b.O000000o(context).O00000Oo.f6054O000000o;
            ioVar.f = context.getPackageName();
            ioVar.d = hz.I.f70a;
            ioVar.b = aw.a();
            ioVar.f133a = hashMap2;
            boolean a2 = at.a(context).a(hu.aG.a(), false);
            int a3 = at.a(context).a(hu.aH.a(), 0);
            if (a3 >= 0 && a3 < 30) {
                duv.O00000o0("aw_ping: frquency need > 30s.");
                a3 = 30;
            }
            if (a3 < 0) {
                a2 = false;
            }
            if (!esl.O000000o()) {
                byte[] O000000o2 = eru.O000000o(ioVar);
                if (O000000o2 == null) {
                    duv.O000000o("send message fail, because msgBytes is null.");
                    return;
                }
                Intent intent = new Intent();
                intent.setAction("action_help_ping");
                intent.putExtra("extra_help_ping_switch", a2);
                intent.putExtra("extra_help_ping_frequency", a3);
                intent.putExtra("mipush_payload", O000000o2);
                intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                eao.O000000o(context).O000000o(intent);
            } else if (a2) {
                elo.O000000o(context.getApplicationContext()).O000000o(new ebi(ioVar, context), a3, 0);
            }
        }
    }
}
