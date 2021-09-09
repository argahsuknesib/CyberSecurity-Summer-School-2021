package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.onetrack.h.aa;
import com.xiaomi.onetrack.h.o;
import com.xiaomi.onetrack.h.q;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class c {

    /* renamed from: a  reason: collision with root package name */
    static String f6145a = "c";

    enum a {
        asus("ASUS"),
        huawei("HUAWEI"),
        lenovo("LENOVO"),
        motolora("MOTOLORA"),
        meizu("MEIZU"),
        oppo("OPPO"),
        samsung("SAMSUNG"),
        numbia("NUBIA"),
        vivo("VIVO"),
        xiaomi("XIAOMI"),
        redmi("REDMI"),
        blackshark("BLACKSHARK"),
        oneplus("ONEPLUS"),
        zte("ZTE"),
        freemeos("FERRMEOS"),
        ssui("SSUI");
        
        public final String q;

        public static a a(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] a() {
            return (a[]) r.clone();
        }

        private a(String str) {
            this.q = str;
        }

        static a b(String str) {
            for (a aVar : a()) {
                if (aVar.q.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    private static String c() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public String a(Context context) {
        try {
            return a(context, c());
        } catch (Exception e) {
            q.a(f6145a, e.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public String a(Context context, String str) throws Exception {
        a b = a.b(str);
        if (a()) {
            b = a.freemeos;
        }
        if (b()) {
            b = a.ssui;
        }
        if (b != null) {
            switch (d.f6147a[b.ordinal()]) {
                case 1:
                    return new a().a(context);
                case 2:
                    return new e().a(context);
                case 3:
                case 4:
                    return new g().a(context);
                case 5:
                    return new i().a(context);
                case 6:
                    return new n().a(context);
                case 7:
                    return new p().a(context);
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return new k().a(context);
                case 9:
                    return new r().a(context);
                case 10:
                case 11:
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return o.b(context);
                case 13:
                    return new l().a(context);
                case 14:
                case GmsLogger.MAX_PII_TAG_LENGTH:
                case 16:
                    return new s().a(context);
                default:
                    return "";
            }
        } else {
            throw new Exception(String.format("undefined oaid method of manufacturer %s", str));
        }
    }

    public boolean a() {
        String a2 = aa.a("ro.build.freeme.label");
        return !TextUtils.isEmpty(a2) && a2.equalsIgnoreCase("FREEMEOS");
    }

    public boolean b() {
        String a2 = aa.a("ro.ssui.product");
        return !TextUtils.isEmpty(a2) && !a2.equalsIgnoreCase("unknown");
    }
}
