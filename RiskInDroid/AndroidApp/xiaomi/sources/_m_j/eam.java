package _m_j;

import _m_j.esv;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.u;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ff;
import com.xiaomi.push.hp;
import com.xiaomi.push.hu;
import com.xiaomi.push.hz;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.ik;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.iu;
import com.xiaomi.push.iw;
import com.xiaomi.push.iy;
import com.xiaomi.push.ja;
import com.xiaomi.push.jf;
import com.xiaomi.push.service.af;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

public final class eam {

    /* renamed from: O000000o  reason: collision with root package name */
    private static eam f15125O000000o;
    private static Object O00000o = new Object();
    private static Queue<String> O00000o0;
    private Context O00000Oo;

    private eam(Context context) {
        this.O00000Oo = context.getApplicationContext();
        if (this.O00000Oo == null) {
            this.O00000Oo = context;
        }
    }

    public static eam O000000o(Context context) {
        if (f15125O000000o == null) {
            f15125O000000o = new eam(context);
        }
        return f15125O000000o;
    }

    private void O000000o(String str, long j, e eVar) {
        au O00000Oo2 = ebe.O00000Oo(eVar);
        if (O00000Oo2 != null) {
            if (j == 0) {
                synchronized (eah.class) {
                    if (eah.O000000o(this.O00000Oo).O00000oO(str)) {
                        eah.O000000o(this.O00000Oo).O00000o(str);
                        if ("syncing".equals(eah.O000000o(this.O00000Oo).O000000o(O00000Oo2))) {
                            eah.O000000o(this.O00000Oo).O000000o(O00000Oo2, "synced");
                        }
                    }
                }
            } else if ("syncing".equals(eah.O000000o(this.O00000Oo).O000000o(O00000Oo2))) {
                synchronized (eah.class) {
                    if (eah.O000000o(this.O00000Oo).O00000oO(str)) {
                        if (eah.O000000o(this.O00000Oo).O00000o0(str) < 10) {
                            eah.O000000o(this.O00000Oo).O00000Oo(str);
                            eao.O000000o(this.O00000Oo).O000000o(str, O00000Oo2, eVar);
                        } else {
                            eah.O000000o(this.O00000Oo).O00000o(str);
                        }
                    }
                }
            } else {
                eah.O000000o(this.O00000Oo).O00000o(str);
            }
        }
    }

    private static boolean O000000o(Context context, String str) {
        synchronized (O00000o) {
            b.O000000o(context);
            SharedPreferences O00000Oo2 = b.O00000Oo(context);
            if (O00000o0 == null) {
                String[] split = O00000Oo2.getString("pref_msg_ids", "").split(",");
                O00000o0 = new LinkedList();
                for (String add : split) {
                    O00000o0.add(add);
                }
            }
            if (O00000o0.contains(str)) {
                return true;
            }
            O00000o0.add(str);
            if (O00000o0.size() > 25) {
                O00000o0.poll();
            }
            String O000000o2 = eml.O000000o(O00000o0, ",");
            SharedPreferences.Editor edit = O00000Oo2.edit();
            edit.putString("pref_msg_ids", O000000o2);
            ess.O000000o(edit);
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.if, com.xiaomi.push.hp, int, com.xiaomi.push.ic]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bd A[Catch:{ jf -> 0x02da, Exception -> 0x02ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fc A[Catch:{ jf -> 0x02da, Exception -> 0x02ca }] */
    public final PushMessageHandler.a O000000o(Intent intent) {
        String str;
        String str2;
        epj epj;
        Map<String, String> map;
        boolean z;
        Intent intent2 = intent;
        String action = intent.getAction();
        duv.O000000o("receive an intent from server, action=".concat(String.valueOf(action)));
        String stringExtra = intent2.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent2.getStringExtra("messageId");
        int intExtra = intent2.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent2.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent2.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                duv.O00000o("receiving an empty message, drop");
                epj.O000000o(this.O00000Oo).O000000o(this.O00000Oo.getPackageName(), intent2, "12");
                return null;
            }
            il ilVar = new il();
            try {
                eru.O000000o(ilVar, byteArrayExtra);
                b O000000o2 = b.O000000o(this.O00000Oo);
                ic icVar = ilVar.f122a;
                boolean z2 = true;
                if (ilVar.f6426a == hp.e && icVar != null && !O000000o2.O00000Oo.O0000Oo && !booleanExtra) {
                    icVar.O000000o("mrt", stringExtra);
                    icVar.O000000o("mat", Long.toString(System.currentTimeMillis()));
                    if (ilVar.f122a == null) {
                        map = null;
                    } else {
                        map = ilVar.f122a.f86a;
                    }
                    if (map != null) {
                        String str3 = (String) map.get("push_server_action");
                        if (TextUtils.equals(str3, "hybrid_message") || TextUtils.equals(str3, "platform_message")) {
                            z = true;
                            if (z) {
                                ic icVar2 = ilVar.f122a;
                                if (icVar2 != null) {
                                    icVar2 = bk.a(icVar2.O000000o());
                                }
                                Cif ifVar = new Cif();
                                ifVar.c = ilVar.f124a;
                                ifVar.b = icVar2.f84a;
                                ifVar.O000000o(icVar2.f83a);
                                if (!TextUtils.isEmpty(icVar2.f88b)) {
                                    ifVar.d = icVar2.f88b;
                                }
                                ifVar.O000000o(eru.O000000o(this.O00000Oo, ilVar));
                                eao.O000000o(this.O00000Oo).O000000o((ja) ifVar, hp.f, false, icVar2);
                            } else {
                                duv.O00000Oo("this is a mina's message, ack later");
                                icVar.O000000o("__hybrid_message_ts", String.valueOf(icVar.f83a));
                                icVar.O000000o("__hybrid_device_status", String.valueOf((int) eru.O000000o(this.O00000Oo, ilVar)));
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
                String str4 = "";
                if (ilVar.f6426a == hp.e) {
                    if (!ilVar.f127a) {
                        if (af.m149a(ilVar)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = ilVar.b;
                            if (icVar != null) {
                                str4 = icVar.f84a;
                            }
                            objArr[1] = str4;
                            duv.O000000o(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                            epj.O000000o(this.O00000Oo).O000000o(this.O00000Oo.getPackageName(), intent2, String.format("13: %1$s", ilVar.b));
                        } else {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = ilVar.b;
                            if (icVar != null) {
                                str4 = icVar.f84a;
                            }
                            objArr2[1] = str4;
                            duv.O000000o(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                            epj.O000000o(this.O00000Oo).O000000o(this.O00000Oo.getPackageName(), intent2, String.format("14: %1$s", ilVar.b));
                        }
                        ebk.O000000o(this.O00000Oo, ilVar, booleanExtra);
                        return null;
                    }
                }
                if (ilVar.f6426a == hp.e && ilVar.f127a && af.m149a(ilVar) && (!booleanExtra || icVar == null || icVar.f86a == null || !icVar.f86a.containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = ilVar.b;
                    if (icVar != null) {
                        str4 = icVar.f84a;
                    }
                    objArr3[1] = str4;
                    duv.O000000o(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    epj.O000000o(this.O00000Oo).O000000o(this.O00000Oo.getPackageName(), intent2, String.format("25: %1$s", ilVar.b));
                    ebk.O00000Oo(this.O00000Oo, ilVar, booleanExtra);
                    return null;
                } else if (O000000o2.O00000Oo.O000000o() || ilVar.f6426a == hp.f6389a) {
                    if (!O000000o2.O00000Oo.O000000o() || !O000000o2.O00000Oo()) {
                        return O000000o(ilVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    if (ilVar.f6426a == hp.b) {
                        O000000o2.O00000Oo.O00000o0();
                        dzs.O00000oO(this.O00000Oo);
                        PushMessageHandler.O00000Oo();
                        return null;
                    }
                    ebk.O00000oO(this.O00000Oo, ilVar, booleanExtra);
                    dzs.O0000O0o(this.O00000Oo);
                    return null;
                } else if (af.m149a(ilVar)) {
                    return O000000o(ilVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                } else {
                    ebk.O00000oO(this.O00000Oo, ilVar, booleanExtra);
                    if (TextUtils.isEmpty(O000000o2.O00000Oo.f6054O000000o) || TextUtils.isEmpty(O000000o2.O00000Oo.O00000Oo) || TextUtils.isEmpty(O000000o2.O00000Oo.O00000o0) || TextUtils.isEmpty(O000000o2.O00000Oo.O00000o)) {
                        z2 = false;
                    }
                    duv.O00000o("receive message without registration. need re-register!registered?".concat(String.valueOf(z2)));
                    epj.O000000o(this.O00000Oo).O000000o(this.O00000Oo.getPackageName(), intent2, "15");
                    if (!z2) {
                        return null;
                    }
                    SharedPreferences sharedPreferences = this.O00000Oo.getSharedPreferences("mipush_extra", 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (Math.abs(currentTimeMillis - sharedPreferences.getLong("last_reinitialize", 0)) <= 1800000) {
                        return null;
                    }
                    dzs.O000000o(this.O00000Oo, id.b);
                    sharedPreferences.edit().putLong("last_reinitialize", currentTimeMillis).commit();
                    return null;
                }
            } catch (jf e) {
                e = e;
                epj = epj.O000000o(this.O00000Oo);
                str2 = this.O00000Oo.getPackageName();
                str = "16";
                epj.O000000o(str2, intent2, str);
                duv.O000000o(e);
                return null;
            } catch (Exception e2) {
                e = e2;
                epj = epj.O000000o(this.O00000Oo);
                str2 = this.O00000Oo.getPackageName();
                str = "17";
                epj.O000000o(str2, intent2, str);
                duv.O000000o(e);
                return null;
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            il ilVar2 = new il();
            try {
                byte[] byteArrayExtra2 = intent2.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    eru.O000000o(ilVar2, byteArrayExtra2);
                }
            } catch (jf unused) {
            }
            miPushCommandMessage.command = String.valueOf(ilVar2.f6426a);
            miPushCommandMessage.resultCode = (long) intent2.getIntExtra("mipush_error_code", 0);
            miPushCommandMessage.reason = intent2.getStringExtra("mipush_error_msg");
            duv.O00000o("receive a error message. code = " + intent2.getIntExtra("mipush_error_code", 0) + ", msg= " + intent2.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if (!"com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            return null;
        } else {
            byte[] byteArrayExtra3 = intent2.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                duv.O00000o("message arrived: receiving an empty message, drop");
                return null;
            }
            il ilVar3 = new il();
            try {
                eru.O000000o(ilVar3, byteArrayExtra3);
                b O000000o3 = b.O000000o(this.O00000Oo);
                if (af.m149a(ilVar3)) {
                    duv.O00000o("message arrived: receive ignore reg message, ignore!");
                    return null;
                } else if (!O000000o3.O00000Oo.O000000o()) {
                    duv.O00000o("message arrived: receive message without registration. need unregister or re-register!");
                    return null;
                } else if (!O000000o3.O00000Oo.O000000o() || !O000000o3.O00000Oo()) {
                    return O000000o(ilVar3);
                } else {
                    duv.O00000o("message arrived: app info is invalidated");
                    return null;
                }
            } catch (Exception e3) {
                duv.O00000o("fail to deal with arrived message. ".concat(String.valueOf(e3)));
                return null;
            }
        }
    }

    private PushMessageHandler.a O000000o(il ilVar) {
        String str = null;
        try {
            ja O000000o2 = eai.O000000o(this.O00000Oo, ilVar);
            if (O000000o2 == null) {
                duv.O00000o("message arrived: receiving an un-recognized message. " + ilVar.f6426a);
                return null;
            }
            hp hpVar = ilVar.f6426a;
            duv.O000000o("message arrived: processing an arrived message, action=".concat(String.valueOf(hpVar)));
            if (ean.f15126O000000o[hpVar.ordinal()] != 1) {
                return null;
            }
            if (!ilVar.f127a) {
                duv.O00000o("message arrived: receiving an un-encrypt message(SendMessage).");
                return null;
            }
            is isVar = (is) O000000o2;
            ib ibVar = isVar.f6440a;
            if (ibVar == null) {
                duv.O00000o("message arrived: receive an empty message without push content, drop it");
                return null;
            }
            if (!(ilVar.f122a == null || ilVar.f122a.f86a == null)) {
                str = ilVar.f122a.f86a.get("jobkey");
            }
            MiPushMessage O000000o3 = eab.O000000o(isVar, ilVar.f122a, false);
            O000000o3.arrived = true;
            duv.O000000o("message arrived: receive a message, msgid=" + ibVar.f78a + ", jobkey=" + str);
            return O000000o3;
        } catch (u e) {
            duv.O000000o(e);
            duv.O00000o("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (jf e2) {
            duv.O000000o(e2);
            duv.O00000o("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(boolean, java.lang.String):void
     arg types: [int, java.lang.String]
     candidates:
      _m_j.eao.O000000o(_m_j.eao, android.os.Messenger):android.os.Messenger
      _m_j.eao.O000000o(_m_j.eao, java.lang.Integer):java.lang.Integer
      _m_j.eao.O000000o(int, int):void
      _m_j.eao.O000000o(com.xiaomi.push.ip, boolean):void
      _m_j.eao.O000000o(boolean, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eau.O000000o(android.content.Context, boolean):void
     arg types: [android.content.Context, int]
     candidates:
      _m_j.eau.O000000o(android.content.Context, com.xiaomi.push.io):void
      _m_j.eau.O000000o(android.content.Context, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):com.xiaomi.push.service.af$c
     arg types: [android.content.Context, com.xiaomi.push.il, byte[]]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.lang.String):int
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, boolean):android.graphics.Bitmap
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):android.widget.RemoteViews
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):java.lang.String
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int):void
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, java.lang.String):boolean
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):com.xiaomi.push.service.af$c */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    private PushMessageHandler.a O000000o(il ilVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        String str2;
        String str3;
        MiPushMessage miPushMessage;
        String str4;
        int i2;
        String str5;
        String str6;
        epj epj;
        long j;
        e eVar;
        il ilVar2 = ilVar;
        boolean z2 = z;
        byte[] bArr2 = bArr;
        String str7 = str;
        int i3 = i;
        ArrayList arrayList = null;
        try {
            ja O000000o2 = eai.O000000o(this.O00000Oo, ilVar2);
            if (O000000o2 == null) {
                duv.O00000o("receiving an un-recognized message. " + ilVar2.f6426a);
                epj.O000000o(this.O00000Oo).O00000Oo(this.O00000Oo.getPackageName(), epi.O000000o(i), str7, "18");
                ebk.O00000o0(this.O00000Oo, ilVar2, z2);
                return null;
            }
            hp hpVar = ilVar2.f6426a;
            duv.O000000o("processing a message, action=".concat(String.valueOf(hpVar)));
            boolean z3 = true;
            switch (ean.f15126O000000o[hpVar.ordinal()]) {
                case 1:
                    if (!ilVar2.f127a) {
                        duv.O00000o("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (!b.O000000o(this.O00000Oo).O00000Oo.O0000Oo || z2) {
                        is isVar = (is) O000000o2;
                        ib ibVar = isVar.f6440a;
                        if (ibVar == null) {
                            duv.O00000o("receive an empty message without push content, drop it");
                            epj.O000000o(this.O00000Oo).O00000Oo(this.O00000Oo.getPackageName(), epi.O000000o(i), str7, "22");
                            ebk.O00000o(this.O00000Oo, ilVar2, z2);
                            return null;
                        }
                        int intExtra = intent.getIntExtra("notification_click_button", 0);
                        if (z2) {
                            if (af.m149a(ilVar)) {
                                dzs.O000000o(this.O00000Oo, ibVar.f78a, ilVar2.f122a, ilVar2.b, ibVar.f81b);
                            } else {
                                ic icVar = ilVar2.f122a != null ? new ic(ilVar2.f122a) : new ic();
                                if (icVar.f86a == null) {
                                    icVar.f86a = new HashMap();
                                }
                                icVar.f86a.put("notification_click_button", String.valueOf(intExtra));
                                dzs.O000000o(this.O00000Oo, ibVar.f78a, icVar, ibVar.f81b);
                            }
                        }
                        if (!z2) {
                            if (!TextUtils.isEmpty(isVar.f) && dzs.O0000OoO(this.O00000Oo, isVar.f) < 0) {
                                dzs.O00000o(this.O00000Oo, isVar.f);
                            } else if (!TextUtils.isEmpty(isVar.e) && dzs.O0000Oo(this.O00000Oo, isVar.e) < 0) {
                                dzs.O0000OOo(this.O00000Oo, isVar.e);
                            }
                        }
                        if (ilVar2.f122a == null || ilVar2.f122a.f86a == null) {
                            str3 = null;
                            str2 = null;
                        } else {
                            str2 = ilVar2.f122a.f86a.get("jobkey");
                            str3 = str2;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            str2 = ibVar.f78a;
                        }
                        if (z2 || !O000000o(this.O00000Oo, str2)) {
                            miPushMessage = eab.O000000o(isVar, ilVar2.f122a, z2);
                            if (miPushMessage.passThrough != 0 || z2 || !af.m150a((Map<String, String>) miPushMessage.extra)) {
                                duv.O000000o("receive a message, msgid=" + ibVar.f78a + ", jobkey=" + str2 + ", btn=" + intExtra);
                                String a2 = af.a(miPushMessage.extra, intExtra);
                                if (z2 && miPushMessage.extra != null && !TextUtils.isEmpty(a2)) {
                                    HashMap<String, String> hashMap = miPushMessage.extra;
                                    if (!(intExtra == 0 || ilVar2.f122a == null)) {
                                        eao.O000000o(this.O00000Oo).O000000o(ilVar2.f122a.c, intExtra);
                                    }
                                    if (af.m149a(ilVar)) {
                                        Intent b = af.b(this.O00000Oo, ilVar2.b, hashMap, intExtra);
                                        b.putExtra("eventMessageType", i3);
                                        b.putExtra("messageId", str7);
                                        b.putExtra("jobkey", str3);
                                        if (b == null) {
                                            duv.O000000o("Getting Intent fail from ignore reg message. ");
                                            epj.O000000o(this.O00000Oo).O00000Oo(this.O00000Oo.getPackageName(), epi.O000000o(i), str7, ayt.f12712O000000o);
                                            return null;
                                        }
                                        String str8 = ibVar.f82c;
                                        if (!TextUtils.isEmpty(str8)) {
                                            b.putExtra("payload", str8);
                                        }
                                        this.O00000Oo.startActivity(b);
                                        ebk.O000000o(this.O00000Oo, ilVar2);
                                        epj.O000000o(this.O00000Oo).O000000o(this.O00000Oo.getPackageName(), epi.O000000o(i), str, 3006, a2);
                                        return null;
                                    }
                                    Context context = this.O00000Oo;
                                    Intent b2 = af.b(context, context.getPackageName(), hashMap, intExtra);
                                    if (b2 == null) {
                                        return null;
                                    }
                                    if (!a2.equals(bd.c)) {
                                        b2.putExtra("key_message", miPushMessage);
                                        b2.putExtra("eventMessageType", i3);
                                        b2.putExtra("messageId", str7);
                                        b2.putExtra("jobkey", str3);
                                    }
                                    this.O00000Oo.startActivity(b2);
                                    ebk.O000000o(this.O00000Oo, ilVar2);
                                    duv.O000000o("start activity succ");
                                    epj.O000000o(this.O00000Oo).O000000o(this.O00000Oo.getPackageName(), epi.O000000o(i), str, 1006, a2);
                                    if (!a2.equals(bd.c)) {
                                        return null;
                                    }
                                    epj.O000000o(this.O00000Oo).O000000o(this.O00000Oo.getPackageName(), epi.O000000o(i), str7, "13");
                                    return null;
                                }
                            } else {
                                af.m146a(this.O00000Oo, ilVar2, bArr2);
                                return null;
                            }
                        } else {
                            duv.O000000o("drop a duplicate message, key=".concat(String.valueOf(str2)));
                            epj.O000000o(this.O00000Oo).O00000o0(this.O00000Oo.getPackageName(), epi.O000000o(i), str7, "2:".concat(String.valueOf(str2)));
                            miPushMessage = null;
                        }
                        if (ilVar2.f122a == null && !z2) {
                            ic icVar2 = ilVar2.f122a;
                            if (icVar2 != null) {
                                icVar2 = bk.a(icVar2.O000000o());
                            }
                            Cif ifVar = new Cif();
                            ifVar.c = isVar.c;
                            ifVar.b = isVar.b;
                            ifVar.O000000o(isVar.f6440a.f6407a);
                            if (!TextUtils.isEmpty(isVar.e)) {
                                ifVar.d = isVar.e;
                            }
                            if (!TextUtils.isEmpty(isVar.f)) {
                                ifVar.e = isVar.f;
                            }
                            ifVar.O000000o(eru.O000000o(this.O00000Oo, ilVar2));
                            eao.O000000o(this.O00000Oo).O000000o(ifVar, hp.f, icVar2);
                        }
                        return miPushMessage;
                    } else {
                        duv.O000000o("receive a message in pause state. drop it");
                        epj.O000000o(this.O00000Oo).O000000o(this.O00000Oo.getPackageName(), epi.O000000o(i), str7, "12");
                        return null;
                    }
                case 2:
                    iq iqVar = (iq) O000000o2;
                    String str9 = b.O000000o(this.O00000Oo).O00000o;
                    if (TextUtils.isEmpty(str9) || !TextUtils.equals(str9, iqVar.f153b)) {
                        duv.O000000o("bad Registration result:");
                        epj.O000000o(this.O00000Oo).O00000Oo(this.O00000Oo.getPackageName(), epi.O000000o(i), str7, "21");
                        return null;
                    }
                    b.O000000o(this.O00000Oo).O00000o = null;
                    if (iqVar.f148a == 0) {
                        b O000000o3 = b.O000000o(this.O00000Oo);
                        String str10 = iqVar.e;
                        String str11 = iqVar.f;
                        String str12 = iqVar.l;
                        b.a aVar = O000000o3.O00000Oo;
                        aVar.O00000o0 = str10;
                        aVar.O00000o = str11;
                        aVar.O00000oo = erv.O0000Oo0(aVar.O0000Ooo);
                        aVar.O00000oO = aVar.O00000Oo();
                        aVar.O0000Oo0 = true;
                        aVar.O0000OOo = str12;
                        SharedPreferences.Editor edit = b.O00000Oo(aVar.O0000Ooo).edit();
                        edit.putString("regId", str10);
                        edit.putString("regSec", str11);
                        edit.putString("devId", aVar.O00000oo);
                        edit.putString("vName", aVar.O00000Oo());
                        edit.putBoolean("valid", true);
                        edit.putString("appRegion", str12);
                        edit.commit();
                        epj = epj.O000000o(this.O00000Oo);
                        str6 = this.O00000Oo.getPackageName();
                        str5 = epi.O000000o(i);
                        i2 = 6006;
                        str4 = "1";
                    } else {
                        epj = epj.O000000o(this.O00000Oo);
                        str6 = this.O00000Oo.getPackageName();
                        str5 = epi.O000000o(i);
                        i2 = 6006;
                        str4 = "2";
                    }
                    epj.O000000o(str6, str5, str, i2, str4);
                    if (!TextUtils.isEmpty(iqVar.e)) {
                        arrayList = new ArrayList();
                        arrayList.add(iqVar.e);
                    }
                    MiPushCommandMessage O000000o4 = eab.O000000o(ff.f6377a.f30a, arrayList, iqVar.f148a, iqVar.d, null);
                    eao.O000000o(this.O00000Oo).O00000oO();
                    return O000000o4;
                case 3:
                    if (((iw) O000000o2).f6448a == 0) {
                        b.O000000o(this.O00000Oo).O00000Oo.O00000o0();
                        dzs.O00000oO(this.O00000Oo);
                    }
                    PushMessageHandler.O00000Oo();
                    break;
                case 4:
                    iu iuVar = (iu) O000000o2;
                    if (iuVar.f6444a == 0) {
                        dzs.O0000OOo(this.O00000Oo, iuVar.e);
                    }
                    if (!TextUtils.isEmpty(iuVar.e)) {
                        arrayList = new ArrayList();
                        arrayList.add(iuVar.e);
                    }
                    duv.O00000oo("resp-cmd:" + ff.g + ", " + iuVar.b);
                    return eab.O000000o(ff.g.f30a, arrayList, iuVar.f6444a, iuVar.d, iuVar.g);
                case 5:
                    iy iyVar = (iy) O000000o2;
                    if (iyVar.f6450a == 0) {
                        dzs.O0000Oo0(this.O00000Oo, iyVar.e);
                    }
                    if (!TextUtils.isEmpty(iyVar.e)) {
                        arrayList = new ArrayList();
                        arrayList.add(iyVar.e);
                    }
                    duv.O00000oo("resp-cmd:" + ff.h + ", " + iyVar.b);
                    return eab.O000000o(ff.h.f30a, arrayList, iyVar.f6450a, iyVar.d, iyVar.g);
                case 6:
                    env.O000000o(this.O00000Oo.getPackageName(), this.O00000Oo, O000000o2, hp.j, bArr2.length);
                    ik ikVar = (ik) O000000o2;
                    String str13 = ikVar.c;
                    List list = ikVar.f120a;
                    if (ikVar.f6424a == 0) {
                        if (TextUtils.equals(str13, ff.i.f30a) && list != null && list.size() > 1) {
                            dzs.O00000Oo(this.O00000Oo, (String) list.get(0), (String) list.get(1));
                            if (!"00:00".equals(list.get(0)) || !"00:00".equals(list.get(1))) {
                                b.O000000o(this.O00000Oo).O000000o(false);
                            } else {
                                b.O000000o(this.O00000Oo).O000000o(true);
                            }
                            TimeZone timeZone = TimeZone.getTimeZone("GMT+08");
                            TimeZone timeZone2 = TimeZone.getDefault();
                            if (!timeZone.equals(timeZone2)) {
                                long rawOffset = (long) (((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60);
                                long parseLong = ((((Long.parseLong(((String) list.get(0)).split(":")[0]) * 60) + Long.parseLong(((String) list.get(0)).split(":")[1])) - rawOffset) + 1440) % 1440;
                                long parseLong2 = ((((Long.parseLong(((String) list.get(1)).split(":")[0]) * 60) + Long.parseLong(((String) list.get(1)).split(":")[1])) - rawOffset) + 1440) % 1440;
                                list = new ArrayList();
                                list.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
                                list.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
                            }
                        } else if (TextUtils.equals(str13, ff.c.f30a) && list != null && list.size() > 0) {
                            dzs.O00000o(this.O00000Oo, (String) list.get(0));
                        } else if (TextUtils.equals(str13, ff.d.f30a) && list != null && list.size() > 0) {
                            dzs.O00000oO(this.O00000Oo, (String) list.get(0));
                        } else if (TextUtils.equals(str13, ff.e.f30a) && list != null && list.size() > 0) {
                            dzs.O00000oo(this.O00000Oo, (String) list.get(0));
                        } else if (TextUtils.equals(str13, ff.f.f30a) && list != null && list.size() > 0) {
                            dzs.O0000O0o(this.O00000Oo, (String) list.get(0));
                        } else if (TextUtils.equals(str13, ff.j.f30a)) {
                            if (list != null && list.size() > 0) {
                                erv.O000000o(this.O00000Oo, (String) list.get(0));
                            }
                            return null;
                        }
                    }
                    duv.O00000oo("resp-cmd:" + str13 + ", " + ikVar.f118a);
                    return eab.O000000o(str13, list, ikVar.f6424a, ikVar.d, ikVar.f);
                case 7:
                    env.O000000o(this.O00000Oo.getPackageName(), this.O00000Oo, O000000o2, hp.i, bArr2.length);
                    if (!(O000000o2 instanceof ig)) {
                        if (O000000o2 instanceof io) {
                            io ioVar = (io) O000000o2;
                            if (!"registration id expired".equalsIgnoreCase(ioVar.d)) {
                                if (!hz.h.f70a.equalsIgnoreCase(ioVar.d)) {
                                    if (!hz.m.f70a.equalsIgnoreCase(ioVar.d)) {
                                        if (!hz.n.f70a.equalsIgnoreCase(ioVar.d)) {
                                            if (!hz.o.f70a.equalsIgnoreCase(ioVar.d)) {
                                                if (!hz.w.f70a.equalsIgnoreCase(ioVar.d)) {
                                                    if (!hz.x.f70a.equalsIgnoreCase(ioVar.d)) {
                                                        if (!hz.C.f70a.equals(ioVar.d)) {
                                                            if (!hz.K.f70a.equals(ioVar.d)) {
                                                                if (!hz.M.f70a.equals(ioVar.d)) {
                                                                    if (!hz.P.f70a.equals(ioVar.d)) {
                                                                        if (!hz.af.f70a.equals(ioVar.d)) {
                                                                            if (com.xiaomi.push.service.e.a(ioVar)) {
                                                                                duv.O00000Oo("receive notification handle by cpra");
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            duv.O00000Oo("receive detect msg");
                                                                            O000000o(ioVar);
                                                                            break;
                                                                        }
                                                                    }
                                                                } else {
                                                                    iw iwVar = new iw();
                                                                    eru.O000000o(iwVar, ioVar.O000000o());
                                                                    dzy.O000000o(iwVar);
                                                                    break;
                                                                }
                                                            } else {
                                                                try {
                                                                    iq iqVar2 = new iq();
                                                                    eru.O000000o(iqVar2, ioVar.O000000o());
                                                                    dzy.O000000o(this.O00000Oo, iqVar2);
                                                                    break;
                                                                } catch (jf e) {
                                                                    duv.O000000o(e);
                                                                    break;
                                                                }
                                                            }
                                                        } else {
                                                            duv.O00000oo("resp-type:" + ioVar.d + ", " + ioVar.b);
                                                            if (ioVar.f133a != null) {
                                                                int i4 = -2;
                                                                if (ioVar.f133a.containsKey(bd.L)) {
                                                                    String str14 = ioVar.f133a.get(bd.L);
                                                                    if (!TextUtils.isEmpty(str14)) {
                                                                        try {
                                                                            i4 = Integer.parseInt(str14);
                                                                        } catch (NumberFormatException e2) {
                                                                            e2.printStackTrace();
                                                                        }
                                                                    }
                                                                }
                                                                if (i4 >= -1) {
                                                                    dzs.O000000o(this.O00000Oo, i4);
                                                                } else {
                                                                    dzs.O000000o(this.O00000Oo, ioVar.f133a.containsKey(bd.J) ? ioVar.f133a.get(bd.J) : "", ioVar.f133a.containsKey(bd.K) ? ioVar.f133a.get(bd.K) : "");
                                                                }
                                                            }
                                                            ig igVar = new ig();
                                                            igVar.d = hz.D.f70a;
                                                            igVar.b = ioVar.b;
                                                            igVar.f106a = ioVar.f129a;
                                                            igVar.c = ioVar.c;
                                                            igVar.f = ioVar.f;
                                                            igVar.O000000o();
                                                            igVar.e = "success clear push message.";
                                                            eao.O000000o(this.O00000Oo).O000000o(igVar, hp.i, false, true, null, false, this.O00000Oo.getPackageName(), b.O000000o(this.O00000Oo).O00000Oo.f6054O000000o, false);
                                                            break;
                                                        }
                                                    } else {
                                                        duv.O000000o("receive force sync notification");
                                                        eau.O000000o(this.O00000Oo, false);
                                                        break;
                                                    }
                                                } else {
                                                    eau.O000000o(this.O00000Oo, ioVar);
                                                    break;
                                                }
                                            } else {
                                                im imVar = new im();
                                                eru.O000000o(imVar, ioVar.O000000o());
                                                com.xiaomi.push.service.au.a(at.a(this.O00000Oo), imVar);
                                                break;
                                            }
                                        } else {
                                            in inVar = new in();
                                            try {
                                                eru.O000000o(inVar, ioVar.O000000o());
                                                com.xiaomi.push.service.au.a(at.a(this.O00000Oo), inVar);
                                                break;
                                            } catch (jf unused) {
                                                break;
                                            }
                                        }
                                    } else if (ilVar2.f127a && ioVar.f133a != null && ioVar.f133a.containsKey("awake_info")) {
                                        Context context2 = this.O00000Oo;
                                        String str15 = b.O000000o(context2).O00000Oo.f6054O000000o;
                                        int a3 = at.a(this.O00000Oo).a(hu.aF.a(), 0);
                                        io ioVar2 = new io();
                                        ioVar2.c = str15;
                                        ioVar2.f133a = new HashMap();
                                        ioVar2.f133a.put("extra_aw_app_online_cmd", String.valueOf(a3));
                                        ioVar2.f133a.put("extra_help_aw_info", ioVar.f133a.get("awake_info"));
                                        ioVar2.b = aw.a();
                                        byte[] O000000o5 = eru.O000000o(ioVar2);
                                        if (O000000o5 != null) {
                                            Intent intent2 = new Intent();
                                            intent2.setAction("action_aw_app_logic");
                                            intent2.putExtra("mipush_payload", O000000o5);
                                            eao.O000000o(context2).O000000o(intent2);
                                            break;
                                        } else {
                                            duv.O000000o("send message fail, because msgBytes is null.");
                                            break;
                                        }
                                    }
                                } else if (ioVar.f133a != null && ioVar.f133a.containsKey("app_version")) {
                                    String str16 = ioVar.f133a.get("app_version");
                                    b O000000o6 = b.O000000o(this.O00000Oo);
                                    SharedPreferences.Editor edit2 = b.O00000Oo(O000000o6.f6053O000000o).edit();
                                    edit2.putString("vName", str16);
                                    edit2.commit();
                                    O000000o6.O00000Oo.O00000oO = str16;
                                    break;
                                }
                            } else {
                                List<String> O00000Oo2 = dzs.O00000Oo(this.O00000Oo);
                                List<String> O00000o02 = dzs.O00000o0(this.O00000Oo);
                                List<String> O00000o2 = dzs.O00000o(this.O00000Oo);
                                String O0000ooo = dzs.O0000ooo(this.O00000Oo);
                                duv.O00000oo("resp-type:" + ioVar.d + ", " + ioVar.b);
                                dzs.O000000o(this.O00000Oo, id.f6410a);
                                for (String next : O00000Oo2) {
                                    dzs.O00000oO(this.O00000Oo, next);
                                    dzs.O000000o(this.O00000Oo, next);
                                }
                                for (String next2 : O00000o02) {
                                    dzs.O0000Oo0(this.O00000Oo, next2);
                                    dzs.O00000o0(this.O00000Oo, next2);
                                }
                                for (String next3 : O00000o2) {
                                    dzs.O0000O0o(this.O00000Oo, next3);
                                    dzs.O00000Oo(this.O00000Oo, next3);
                                }
                                String[] split = O0000ooo.split(",");
                                if (split.length == 2) {
                                    dzs.O0000ooO(this.O00000Oo);
                                    dzs.O00000Oo(this.O00000Oo, split[0], split[1]);
                                    break;
                                }
                            }
                        }
                    } else {
                        ig igVar2 = (ig) O000000o2;
                        String str17 = igVar2.b;
                        duv.O00000oo("resp-type:" + igVar2.d + ", code:" + igVar2.f6416a + ", " + str17);
                        if (!hz.E.f70a.equalsIgnoreCase(igVar2.d)) {
                            if (!hz.F.f70a.equalsIgnoreCase(igVar2.d)) {
                                if (!hz.N.f70a.equalsIgnoreCase(igVar2.d)) {
                                    if (hz.B.f70a.equalsIgnoreCase(igVar2.d)) {
                                        String str18 = igVar2.b;
                                        duv.O00000Oo("receive ack ".concat(String.valueOf(str18)));
                                        Map<String, String> map = igVar2.f109a;
                                        if (map != null) {
                                            String str19 = map.get("real_source");
                                            if (!TextUtils.isEmpty(str19)) {
                                                duv.O00000Oo("receive ack : messageId = " + str18 + "  realSource = " + str19);
                                                emr O000000o7 = emr.O000000o(this.O00000Oo);
                                                if (igVar2.f6416a != 0) {
                                                    z3 = false;
                                                }
                                                Boolean valueOf = Boolean.valueOf(z3);
                                                if (O000000o7.O00000o != null) {
                                                    valueOf.booleanValue();
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    duv.O00000o0("ASSEMBLE_PUSH : " + igVar2.toString());
                                    String str20 = igVar2.b;
                                    Map<String, String> map2 = igVar2.f109a;
                                    if (map2 != null) {
                                        String str21 = map2.get("RegInfo");
                                        if (!TextUtils.isEmpty(str21)) {
                                            if (str21.contains("brand:" + ag.c.name())) {
                                                duv.O000000o("ASSEMBLE_PUSH : receive fcm token sync ack");
                                                ebb.O00000Oo(this.O00000Oo, e.b, str21);
                                                j = igVar2.f6416a;
                                                eVar = e.b;
                                            } else {
                                                if (str21.contains("brand:" + ag.f6051a.name())) {
                                                    duv.O000000o("ASSEMBLE_PUSH : receive hw token sync ack");
                                                    ebb.O00000Oo(this.O00000Oo, e.f6055a, str21);
                                                    j = igVar2.f6416a;
                                                    eVar = e.f6055a;
                                                } else {
                                                    if (str21.contains("brand:" + ag.d.name())) {
                                                        duv.O000000o("ASSEMBLE_PUSH : receive COS token sync ack");
                                                        ebb.O00000Oo(this.O00000Oo, e.c, str21);
                                                        j = igVar2.f6416a;
                                                        eVar = e.c;
                                                    } else {
                                                        if (str21.contains("brand:" + ag.e.name())) {
                                                            duv.O000000o("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                                            ebb.O00000Oo(this.O00000Oo, e.d, str21);
                                                            j = igVar2.f6416a;
                                                            eVar = e.d;
                                                        }
                                                    }
                                                }
                                            }
                                            O000000o(str20, j, eVar);
                                            break;
                                        }
                                    }
                                }
                            } else if (igVar2.f6416a != 0) {
                                if ("syncing".equals(eah.O000000o(this.O00000Oo).O000000o(au.b))) {
                                    synchronized (eah.class) {
                                        if (eah.O000000o(this.O00000Oo).O00000oO(str17)) {
                                            if (eah.O000000o(this.O00000Oo).O00000o0(str17) < 10) {
                                                eah.O000000o(this.O00000Oo).O00000Oo(str17);
                                                eao.O000000o(this.O00000Oo).O000000o(false, str17);
                                            } else {
                                                eah.O000000o(this.O00000Oo).O00000o(str17);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                synchronized (eah.class) {
                                    if (eah.O000000o(this.O00000Oo).O00000oO(str17)) {
                                        eah.O000000o(this.O00000Oo).O00000o(str17);
                                        if ("syncing".equals(eah.O000000o(this.O00000Oo).O000000o(au.b))) {
                                            eah.O000000o(this.O00000Oo).O000000o(au.b, "synced");
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (igVar2.f6416a != 0) {
                            if ("syncing".equals(eah.O000000o(this.O00000Oo).O000000o(au.f6052a))) {
                                synchronized (eah.class) {
                                    if (eah.O000000o(this.O00000Oo).O00000oO(str17)) {
                                        if (eah.O000000o(this.O00000Oo).O00000o0(str17) < 10) {
                                            eah.O000000o(this.O00000Oo).O00000Oo(str17);
                                            eao.O000000o(this.O00000Oo).O000000o(true, str17);
                                        } else {
                                            eah.O000000o(this.O00000Oo).O00000o(str17);
                                        }
                                    }
                                }
                                break;
                            }
                        } else {
                            synchronized (eah.class) {
                                if (eah.O000000o(this.O00000Oo).O00000oO(str17)) {
                                    eah.O000000o(this.O00000Oo).O00000o(str17);
                                    if ("syncing".equals(eah.O000000o(this.O00000Oo).O000000o(au.f6052a))) {
                                        eah.O000000o(this.O00000Oo).O000000o(au.f6052a, "synced");
                                        dzs.O0000o0(this.O00000Oo);
                                        dzs.O00000oo(this.O00000Oo);
                                        PushMessageHandler.O00000Oo();
                                        eao O000000o8 = eao.O000000o(this.O00000Oo);
                                        Intent O00000Oo3 = O000000o8.O00000Oo();
                                        O00000Oo3.setAction("com.xiaomi.mipush.DISABLE_PUSH");
                                        O000000o8.O00000o0(O00000Oo3);
                                    }
                                }
                            }
                            break;
                        }
                        eah.O000000o(this.O00000Oo).O00000o(str17);
                        break;
                    }
                    break;
            }
            return null;
        } catch (u e3) {
            duv.O000000o(e3);
            duv.O000000o("receive a message but decrypt failed. report now.");
            io ioVar3 = new io(ilVar2.f122a.f84a, false);
            ioVar3.d = hz.u.f70a;
            ioVar3.c = ilVar2.f124a;
            ioVar3.f = ilVar2.b;
            ioVar3.f133a = new HashMap();
            ioVar3.f133a.put("regid", dzs.O0000o0O(this.O00000Oo));
            eao.O000000o(this.O00000Oo).O000000o((ja) ioVar3, hp.i, false, (ic) null);
            epj.O000000o(this.O00000Oo).O00000Oo(this.O00000Oo.getPackageName(), epi.O000000o(i), str7, "19");
            ebk.O00000o0(this.O00000Oo, ilVar2, z2);
            return null;
        } catch (jf e4) {
            duv.O000000o(e4);
            duv.O00000o("receive a message which action string is not valid. is the reg expired?");
            epj.O000000o(this.O00000Oo).O00000Oo(this.O00000Oo.getPackageName(), epi.O000000o(i), str7, "20");
            ebk.O00000o0(this.O00000Oo, ilVar2, z2);
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    private void O000000o(io ioVar) {
        Map<String, String> map = ioVar.f133a;
        if (map == null) {
            duv.O000000o("detect failed because null");
            return;
        }
        String str = (String) as.a(map, "pkgList", (Object) null);
        if (TextUtils.isEmpty(str)) {
            duv.O000000o("detect failed because empty");
            return;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.O00000Oo.getSystemService("activity")).getRunningAppProcesses();
            if (!esv.O000000o(runningAppProcesses)) {
                String[] split = str.split(",");
                HashMap hashMap = new HashMap();
                for (String split2 : split) {
                    String[] split3 = split2.split("~");
                    if (split3.length >= 2) {
                        hashMap.put(split3[1], split3[0]);
                    }
                }
                esv.O000000o o000000o = new esv.O000000o("~", ",");
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (hashMap.containsKey(next.processName)) {
                        o000000o.O000000o((String) hashMap.get(next.processName), String.valueOf(next.importance));
                        hashMap.remove(next.processName);
                    }
                }
                if (o000000o.toString().length() > 0) {
                    io ioVar2 = new io();
                    ioVar2.b = ioVar.b;
                    ioVar2.c = ioVar.c;
                    ioVar2.f = ioVar.f;
                    ioVar2.d = hz.ag.f70a;
                    ioVar2.f133a = new HashMap();
                    ioVar2.f133a.put("alive", o000000o.toString());
                    if (Boolean.parseBoolean((String) as.a(map, "reportNotAliveApp", "false")) && hashMap.size() > 0) {
                        esv.O000000o o000000o2 = new esv.O000000o("", ",");
                        for (String str2 : hashMap.keySet()) {
                            o000000o2.O000000o((String) hashMap.get(str2), "");
                        }
                        ioVar2.f133a.put("notAlive", o000000o2.toString());
                    }
                    eao.O000000o(this.O00000Oo).O000000o((ja) ioVar2, hp.i, false, (ic) null);
                    return;
                }
                duv.O00000Oo("detect failed because no alive process");
                return;
            }
            duv.O000000o("detect failed because params illegal");
        } catch (Throwable th) {
            duv.O000000o("detect failed ".concat(String.valueOf(th)));
        }
    }
}
