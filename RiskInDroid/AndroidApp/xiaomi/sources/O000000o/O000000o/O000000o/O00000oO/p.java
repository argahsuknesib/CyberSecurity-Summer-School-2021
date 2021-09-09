package O000000o.O000000o.O000000o.O00000oO;

import O000000o.O000000o.O000000o.O00000o0.a;
import _m_j.O00000Oo;
import _m_j.O0000Oo0;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.NotificationCompat;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

public class p extends LinearLayout {
    public p(Context context) {
        super(context);
        float f;
        Context applicationContext = context.getApplicationContext();
        if (O0000Oo0.f5251O000000o == null) {
            O0000Oo0 o0000Oo0 = new O0000Oo0();
            O0000Oo0.f5251O000000o = o0000Oo0;
            o0000Oo0.O00000o = 1080;
            o0000Oo0.O00000oO = 1920;
            a aVar = new a(applicationContext);
            try {
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
                if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("circle_dialog_design_width") && applicationInfo.metaData.containsKey("circle_dialog_design_height")) {
                    o0000Oo0.O00000o = ((Integer) applicationInfo.metaData.get("circle_dialog_design_width")).intValue();
                    o0000Oo0.O00000oO = ((Integer) applicationInfo.metaData.get("circle_dialog_design_height")).intValue();
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (o0000Oo0.O00000oO <= 0 || o0000Oo0.O00000o <= 0) {
                throw new RuntimeException("you must set circle_dialog_design_width and circle_dialog_design_height > 0");
            }
            int[] O000000o2 = O00000Oo.O000000o(applicationContext);
            o0000Oo0.O00000Oo = O000000o2[0];
            o0000Oo0.O00000o0 = O000000o2[1];
            int i = o0000Oo0.O00000Oo;
            int i2 = o0000Oo0.O00000o0;
            if (i > i2) {
                o0000Oo0.O00000Oo = i + i2;
                int i3 = o0000Oo0.O00000Oo;
                o0000Oo0.O00000o0 = i3 - i2;
                o0000Oo0.O00000Oo = i3 - o0000Oo0.O00000o0;
            }
            float f2 = (float) o0000Oo0.O00000o0;
            float f3 = (float) o0000Oo0.O00000Oo;
            float f4 = (float) o0000Oo0.O00000oO;
            float f5 = (float) o0000Oo0.O00000o;
            if (f2 / f3 <= f4 / f5) {
                o0000Oo0.O00000oo = f2 / f4;
            } else {
                o0000Oo0.O00000oo = f3 / f5;
            }
            float f6 = o0000Oo0.O00000oo;
            int i4 = o0000Oo0.O00000Oo;
            int i5 = o0000Oo0.O00000o0;
            if (i4 < 720 || i5 < 720) {
                if (i4 <= 480 || i5 <= 480) {
                    f = 1.2f;
                } else {
                    Context context2 = aVar.f375O000000o;
                    int[] O000000o3 = O00000Oo.O000000o(context2);
                    DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                    f = Math.sqrt(Math.pow((double) (((float) O000000o3[1]) / displayMetrics.ydpi), 2.0d) + Math.pow((double) (((float) O000000o3[0]) / displayMetrics.xdpi), 2.0d)) < 4.0d ? 1.3f : 1.05f;
                }
                f6 *= f;
            }
            o0000Oo0.O00000oo = f6;
        }
    }
}
