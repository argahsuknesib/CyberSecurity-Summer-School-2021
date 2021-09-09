package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.em;
import com.xiaomi.push.service.af;
import java.util.HashMap;

public final class epb {
    private static volatile epb O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f15698O000000o;
    public String O00000Oo;
    public int O00000o;
    public String O00000o0;
    public epe O00000oO;
    private HashMap<em, epd> O0000O0o = new HashMap<>();

    private epb(Context context) {
        this.f15698O000000o = context;
        this.O0000O0o.put(em.b, new epg());
        this.O0000O0o.put(em.c, new eph());
        this.O0000O0o.put(em.f6375a, new eoz());
        this.O0000O0o.put(em.d, new epf());
    }

    public static epb O000000o(Context context) {
        if (O00000oo == null) {
            synchronized (epb.class) {
                if (O00000oo == null) {
                    O00000oo = new epb(context);
                }
            }
        }
        return O00000oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):boolean
     arg types: [android.content.Context, java.lang.String]
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
    public static boolean O00000Oo(Context context) {
        return af.m148a(context, context.getPackageName());
    }

    public final void O000000o(em emVar, Context context, Intent intent, String str) {
        if (emVar != null) {
            this.O0000O0o.get(emVar).O000000o(context, intent, str);
        } else {
            eox.O000000o(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public final void O000000o(String str, String str2, int i, epe epe) {
        this.O00000Oo = str;
        this.O00000o0 = str2;
        this.O00000o = i;
        this.O00000oO = epe;
    }
}
