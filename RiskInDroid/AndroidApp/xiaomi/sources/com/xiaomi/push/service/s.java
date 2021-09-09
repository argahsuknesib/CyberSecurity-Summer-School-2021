package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.env;
import _m_j.epj;
import _m_j.epq;
import _m_j.eqo;
import _m_j.eqq;
import _m_j.eqr;
import _m_j.erf;
import _m_j.eru;
import _m_j.esl;
import _m_j.esu;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.g;
import com.xiaomi.push.gg;
import com.xiaomi.push.hp;
import com.xiaomi.push.hz;
import com.xiaomi.push.ic;
import com.xiaomi.push.il;
import com.xiaomi.push.io;
import com.xiaomi.push.jf;
import com.xiaomi.push.service.af;
import com.xiaomi.push.service.az;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s {
    public static Intent a(byte[] bArr, long j) {
        il a2 = a(bArr);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a2.b);
        return intent;
    }

    public static il a(Context context, il ilVar) {
        return a(context, ilVar, (Map<String, String>) null);
    }

    public static il a(byte[] bArr) {
        il ilVar = new il();
        try {
            eru.O000000o(ilVar, bArr);
            return ilVar;
        } catch (Throwable th) {
            duv.O000000o(th);
            return null;
        }
    }

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
    public static void a(Context context, il ilVar, byte[] bArr) {
        try {
            af.a(ilVar);
            af.c a2 = af.m146a(context, ilVar, bArr);
            if (a2.f6492a > 0 && !TextUtils.isEmpty(a2.f239a)) {
                erf.O000000o(context, a2.f239a, a2.f6492a, true, false, System.currentTimeMillis());
            }
            if (!esl.O000000o(context) || !aa.a(context, ilVar, a2.f240a)) {
                b(context, ilVar, bArr);
            } else {
                duv.O000000o("consume this broadcast by tts");
            }
        } catch (Exception e) {
            duv.O000000o("notify push msg error ".concat(String.valueOf(e)));
        }
    }

    private static void a(XMPushService xMPushService, il ilVar) {
        xMPushService.a(new t(4, xMPushService, ilVar));
    }

    private static void a(XMPushService xMPushService, il ilVar, io ioVar) {
        xMPushService.a(new z(4, ioVar, ilVar, xMPushService));
    }

    private static void a(XMPushService xMPushService, il ilVar, String str) {
        xMPushService.a(new x(4, xMPushService, ilVar, str));
    }

    private static void a(XMPushService xMPushService, il ilVar, String str, String str2) {
        xMPushService.a(new y(4, xMPushService, ilVar, str, str2));
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty();
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            return !packageManager.queryBroadcastReceivers(intent2, 32).isEmpty() || !packageManager.queryIntentServices(intent, 32).isEmpty();
        } catch (Exception e) {
            duv.O000000o(e);
            return false;
        }
    }

    private static void b(XMPushService xMPushService, il ilVar) {
        xMPushService.a(new u(4, xMPushService, ilVar));
    }

    private static void c(XMPushService xMPushService, il ilVar) {
        xMPushService.a(new v(4, xMPushService, ilVar));
    }

    private static void d(XMPushService xMPushService, il ilVar) {
        xMPushService.a(new w(4, xMPushService, ilVar));
    }

    public void a(Context context, az.b bVar, boolean z, int i, String str) {
        n a2;
        if (!z && (a2 = o.m222a(context)) != null && "token-expired".equals(str)) {
            o.a(context, a2.f, a2.d, a2.e);
        }
    }

    public void a(XMPushService xMPushService, epq epq, az.b bVar) {
        try {
            a(xMPushService, epq.O00000o0(bVar.h), (long) epq.O00000o());
        } catch (IllegalArgumentException e) {
            duv.O000000o(e);
        }
    }

    public void a(XMPushService xMPushService, eqr eqr, az.b bVar) {
        if (eqr instanceof eqq) {
            eqq eqq = (eqq) eqr;
            eqo O000000o2 = eqq.O000000o("s");
            if (O000000o2 != null) {
                try {
                    a(xMPushService, bi.a(bi.a(bVar.h, eqq.O00000o()), O000000o2.O000000o()), (long) erf.O00000Oo(eqr.O00000Oo()));
                } catch (IllegalArgumentException e) {
                    duv.O000000o(e);
                }
            }
        } else {
            duv.O000000o("not a mipush message");
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> map;
        il a2 = a(bArr);
        if (a2 != null) {
            if (TextUtils.isEmpty(a2.b)) {
                duv.O000000o("receive a mipush message without package name");
                return;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            Intent a3 = a(bArr, valueOf.longValue());
            String a4 = af.a(a2);
            erf.O000000o(xMPushService, a4, j, true, true, System.currentTimeMillis());
            ic icVar = a2.f122a;
            if (!(icVar == null || icVar.f84a == null)) {
                duv.O00000oo(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a2.f124a, icVar.f84a, a2.f6426a));
            }
            if (icVar != null) {
                icVar.O000000o("mrt", Long.toString(valueOf.longValue()));
            }
            String str = "";
            if (hp.e == a2.f6426a && p.a(xMPushService).m225a(a2.b) && !af.m149a(a2)) {
                if (icVar != null) {
                    str = icVar.f84a;
                    if (af.e(a2)) {
                        epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), str, "1");
                    }
                }
                duv.O000000o("Drop a message for unregistered, msgid=".concat(String.valueOf(str)));
                a(xMPushService, a2, a2.b);
            } else if (hp.e == a2.f6426a && p.a(xMPushService).m227c(a2.b) && !af.m149a(a2)) {
                if (icVar != null) {
                    str = icVar.f84a;
                    if (af.e(a2)) {
                        epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), str, "2");
                    }
                }
                duv.O000000o("Drop a message for push closed, msgid=".concat(String.valueOf(str)));
                a(xMPushService, a2, a2.b);
            } else if (hp.e == a2.f6426a && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.b)) {
                duv.O000000o("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.b);
                a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.b);
                if (icVar != null && af.e(a2)) {
                    epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, "3");
                }
            } else if (icVar == null || (map = icVar.f86a) == null || !map.containsKey("hide") || !"true".equalsIgnoreCase(map.get("hide"))) {
                if (!(icVar == null || icVar.f86a == null || !icVar.f86a.containsKey("__miid"))) {
                    String str2 = icVar.f86a.get("__miid");
                    String O00000o0 = esu.O00000o0(xMPushService.getApplicationContext());
                    if (TextUtils.isEmpty(O00000o0) || !TextUtils.equals(str2, O00000o0)) {
                        if (af.e(a2)) {
                            epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, "4");
                        }
                        duv.O000000o(str2 + " should be login, but got " + O00000o0);
                        a(xMPushService, a2, "miid already logout or anther already login", str2 + " should be login, but got " + O00000o0);
                        return;
                    }
                }
                a(xMPushService, a4, bArr, a3);
            } else {
                b(xMPushService, a2);
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.xiaomi.push.ja] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):boolean
     arg types: [com.xiaomi.push.service.XMPushService, java.lang.String]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.af.a(android.content.Context, int):android.graphics.Bitmap
      com.xiaomi.push.service.af.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.a(java.util.Map<java.lang.String, java.lang.String>, int):java.lang.String
      com.xiaomi.push.service.af.a(java.util.Map<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):void
      com.xiaomi.push.service.af.a(android.content.Context, java.util.LinkedList<? extends java.lang.Object>):void
      com.xiaomi.push.service.af.a(java.lang.String, java.lang.String):boolean
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.ic):java.lang.String[]
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):boolean */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0315 A[SYNTHETIC, Splitter:B:125:0x0315] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x033f  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        String str2;
        boolean z;
        io ioVar;
        String str3;
        int i;
        String str4;
        XMPushService xMPushService2 = xMPushService;
        byte[] bArr2 = bArr;
        Intent intent2 = intent;
        il a2 = a(bArr);
        ic icVar = a2.f122a;
        String str5 = null;
        if (bArr2 != null) {
            env.O000000o(a2.b, xMPushService.getApplicationContext(), null, a2.f6426a, bArr2.length);
        }
        if (c(a2) && a(xMPushService, str)) {
            if (af.e(a2)) {
                epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, "5");
            }
            c(xMPushService2, a2);
        } else if (a(a2) && !a(xMPushService, str) && !b(a2)) {
            if (af.e(a2)) {
                epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, "6");
            }
            d(xMPushService2, a2);
        } else if ((af.m149a(a2) && g.O00000o(xMPushService2, a2.b)) || a(xMPushService2, intent2)) {
            boolean z2 = false;
            if (hp.f6389a == a2.f6426a) {
                String str6 = a2.b;
                SharedPreferences.Editor edit = xMPushService2.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(str6, a2.f124a);
                edit.commit();
                p.a(xMPushService).e(str6);
                p.a(xMPushService).f(str6);
                epj.O000000o(xMPushService.getApplicationContext()).O000000o(str6, "E100003", icVar.f84a, 6003, null);
                if (!TextUtils.isEmpty(icVar.f84a)) {
                    intent2.putExtra("messageId", icVar.f84a);
                    intent2.putExtra("eventMessageType", 6000);
                }
            }
            if (af.c(a2)) {
                epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(icVar.f84a)) {
                    intent2.putExtra("messageId", icVar.f84a);
                    intent2.putExtra("eventMessageType", 1000);
                }
            }
            if (af.m153b(a2)) {
                epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(icVar.f84a)) {
                    intent2.putExtra("messageId", icVar.f84a);
                    intent2.putExtra("eventMessageType", 2000);
                }
            }
            if (af.m149a(a2)) {
                epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(icVar.f84a)) {
                    intent2.putExtra("messageId", icVar.f84a);
                    intent2.putExtra("eventMessageType", 3000);
                }
            }
            boolean z3 = true;
            if (icVar != null && !TextUtils.isEmpty(icVar.f90c) && !TextUtils.isEmpty(icVar.d) && icVar.b != 1 && (af.m150a(icVar.f86a) || !af.m148a((Context) xMPushService2, a2.b))) {
                if (icVar != null) {
                    if (icVar.f86a != null) {
                        str5 = icVar.f86a.get("jobkey");
                    }
                    boolean isEmpty = TextUtils.isEmpty(str5);
                    String str7 = str5;
                    if (isEmpty) {
                        str7 = icVar.f84a;
                    }
                    z2 = ai.a(xMPushService2, a2.b, str7);
                    str5 = str7;
                }
                if (z2) {
                    epj.O000000o(xMPushService.getApplicationContext()).O00000o0(a2.b, af.b(a2), icVar.f84a, "1:".concat(String.valueOf(str5)));
                    str4 = "drop a duplicate message, key=".concat(String.valueOf(str5));
                } else if (!esl.O000000o(xMPushService) || !aa.m143a(a2)) {
                    a(xMPushService2, a2, bArr2);
                    b(xMPushService2, a2);
                } else {
                    str4 = "receive pull down message";
                }
                duv.O000000o(str4);
                b(xMPushService2, a2);
            } else if ("com.xiaomi.xmsf".contains(a2.b) && !a2.f127a && icVar != null && icVar.f86a != null && icVar.f86a.containsKey("ab")) {
                b(xMPushService2, a2);
                duv.O00000o0("receive abtest message. ack it." + icVar.f84a);
            } else if (a(xMPushService2, str, a2, icVar)) {
                if (icVar != null && !TextUtils.isEmpty(icVar.f84a)) {
                    if (af.m153b(a2)) {
                        epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, 2002, null);
                    } else if (af.m149a(a2)) {
                        epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, "7");
                    } else if (af.c(a2)) {
                        epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, "8");
                    } else if (af.d(a2)) {
                        epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, "E100003", icVar.f84a, 6004, null);
                    }
                }
                if (hp.i == a2.f6426a) {
                    try {
                        ? a3 = bv.a(xMPushService2, a2);
                        if (a3 == 0) {
                            duv.O00000o("receiving an un-recognized notification message. " + a2.f6426a);
                            str5 = a3;
                            z = false;
                            str2 = str5;
                            if (z && (str2 instanceof io)) {
                                ioVar = (io) str2;
                                if (hz.C.f70a.equals(ioVar.d) && ioVar.f133a != null) {
                                    str3 = ioVar.f133a.get(bd.L);
                                    i = -2;
                                    if (!TextUtils.isEmpty(str3)) {
                                        try {
                                            i = Integer.parseInt(str3);
                                        } catch (NumberFormatException e) {
                                            duv.O000000o("parse notifyId from STRING to INT failed: ".concat(String.valueOf(e)));
                                        }
                                    }
                                    if (i < -1) {
                                        duv.O000000o("try to retract a message by notifyId=".concat(String.valueOf(i)));
                                        af.a(xMPushService2, a2.b, i);
                                    } else {
                                        duv.O000000o("try to retract a message by title&description.");
                                        af.a(xMPushService2, a2.b, ioVar.f133a.get(bd.J), ioVar.f133a.get(bd.K));
                                    }
                                    if (icVar != null && icVar.f86a != null && esl.O000000o(xMPushService) && "pulldown".equals(as.a((Object) icVar.f86a))) {
                                        aa.a(a2);
                                    }
                                    a(xMPushService2, a2, ioVar);
                                    z3 = false;
                                }
                            }
                        } else {
                            z = true;
                            str2 = a3;
                            ioVar = (io) str2;
                            str3 = ioVar.f133a.get(bd.L);
                            i = -2;
                            if (!TextUtils.isEmpty(str3)) {
                            }
                            if (i < -1) {
                            }
                            aa.a(a2);
                            a(xMPushService2, a2, ioVar);
                            z3 = false;
                        }
                    } catch (jf e2) {
                        duv.O00000o("receive a message which action string is not valid. ".concat(String.valueOf(e2)));
                    }
                }
                if (z3) {
                    duv.O000000o("broadcast passthrough message.");
                    xMPushService2.sendBroadcast(intent2, ab.a(a2.b));
                }
            } else {
                epj.O000000o(xMPushService.getApplicationContext()).O000000o(a2.b, af.b(a2), icVar.f84a, "9");
            }
            if (a2.f6426a == hp.b && !"com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                xMPushService.stopSelf();
            }
        } else if (!g.O00000o(xMPushService2, a2.b)) {
            if (af.e(a2)) {
                epj.O000000o(xMPushService.getApplicationContext()).O00000Oo(a2.b, af.b(a2), icVar.f84a, "2");
            }
            a(xMPushService2, a2);
        } else {
            duv.O000000o("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (af.e(a2)) {
                epj.O000000o(xMPushService.getApplicationContext()).O00000Oo(a2.b, af.b(a2), icVar.f84a, "3");
            }
        }
    }

    public static void b(Context context, il ilVar, byte[] bArr) {
        if (!af.m149a(ilVar) && g.O00000o0(context.getApplicationContext(), af.a(ilVar))) {
            Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
            intent.putExtra("mipush_payload", bArr);
            intent.setPackage(ilVar.b);
            try {
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
                if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                    duv.O000000o("broadcast message arrived.");
                    context.sendBroadcast(intent, ab.a(ilVar.b));
                }
            } catch (Exception unused) {
                epj.O000000o(context.getApplicationContext()).O00000Oo(ilVar.b, af.b(ilVar), ilVar.f122a.f84a, "1");
            }
        }
    }

    private static boolean a(XMPushService xMPushService, String str, il ilVar, ic icVar) {
        boolean z = true;
        if (icVar != null && icVar.f86a != null && icVar.f86a.containsKey("__check_alive") && icVar.f86a.containsKey("__awake")) {
            io ioVar = new io();
            ioVar.c = ilVar.f124a;
            ioVar.f = str;
            ioVar.d = hz.H.f70a;
            ioVar.b = icVar.f84a;
            ioVar.f133a = new HashMap();
            boolean O00000o0 = g.O00000o0(xMPushService.getApplicationContext(), str);
            ioVar.f133a.put("app_running", Boolean.toString(O00000o0));
            if (!O00000o0) {
                boolean parseBoolean = Boolean.parseBoolean(icVar.f86a.get("__awake"));
                ioVar.f133a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                ab.a(xMPushService, ab.a(ilVar.b, ilVar.f124a, ioVar, hp.i));
            } catch (gg e) {
                duv.O000000o(e);
            }
        }
        return z;
    }

    private static boolean a(il ilVar) {
        return "com.xiaomi.xmsf".equals(ilVar.b) && ilVar.f122a != null && ilVar.f122a.f86a != null && ilVar.f122a.f86a.containsKey("miui_package_name");
    }

    private static boolean b(il ilVar) {
        Map<String, String> map = ilVar.f122a.f86a;
        return map != null && map.containsKey("notify_effect");
    }

    private static boolean c(il ilVar) {
        if (ilVar.f122a == null || ilVar.f122a.f86a == null) {
            return false;
        }
        return "1".equals(ilVar.f122a.f86a.get("obslete_ads_message"));
    }

    public static il a(Context context, il ilVar, Map<String, String> map) {
        Cif ifVar = new Cif();
        ifVar.c = ilVar.f124a;
        ic icVar = ilVar.f122a;
        if (icVar != null) {
            ifVar.b = icVar.f84a;
            ifVar.O000000o(icVar.f83a);
            if (!TextUtils.isEmpty(icVar.f88b)) {
                ifVar.d = icVar.f88b;
            }
        }
        ifVar.O000000o(eru.O000000o(context, ilVar));
        il a2 = ab.a(ilVar.b, ilVar.f124a, ifVar, hp.f);
        ic icVar2 = ilVar.f122a;
        if (icVar2 != null) {
            icVar2 = bk.a(icVar2.O000000o());
        }
        icVar2.O000000o("mat", Long.toString(System.currentTimeMillis()));
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String next : map.keySet()) {
                        icVar2.O000000o(next, map.get(next));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        a2.f122a = icVar2;
        return a2;
    }
}
