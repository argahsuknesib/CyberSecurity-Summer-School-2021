package _m_j;

import _m_j.eus;
import _m_j.eva;
import android.app.Application;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.Helper.ImageLoader;

public final class eui {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Application f15823O000000o = null;
    public static boolean O00000Oo = false;
    private static dok O00000o;
    private static VafContext O00000o0;

    static class O000000o extends vk<Bitmap> {

        /* renamed from: O000000o  reason: collision with root package name */
        dqc f15825O000000o;

        public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
            this.f15825O000000o.O000000o((Bitmap) obj);
        }

        public O000000o(dqc dqc) {
            this.f15825O000000o = dqc;
        }
    }

    public static void O000000o(final Application application) {
        f15823O000000o = application;
        duq O000000o2 = duq.O000000o();
        Application application2 = f15823O000000o;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) application2.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            O000000o2.O00000oo = i;
            O000000o2.O00000o = i2;
        } else {
            O000000o2.O00000oo = i2;
            O000000o2.O00000o = i;
        }
        O000000o2.O00000Oo = displayMetrics.density;
        O000000o2.O00000o0 = displayMetrics.densityDpi;
        O000000o2.O0000O0o = (int) ((((float) displayMetrics.widthPixels) / O000000o2.O00000Oo) + 0.5f);
        O000000o2.O00000oO = (int) ((((float) displayMetrics.heightPixels) / O000000o2.O00000Oo) + 0.5f);
        String str = duq.f14955O000000o;
        Log.d(str, "屏幕高度px:" + O000000o2.O00000o + ",屏幕宽度px:" + O000000o2.O00000oo + ",Density:" + O000000o2.O00000Oo + ",dpi:" + O000000o2.O00000o0 + ",屏幕高度dip:" + O000000o2.O00000oO + ",屏幕宽度dip:" + O000000o2.O0000O0o);
        Log.d(duq.f14955O000000o, displayMetrics.toString());
        VafContext vafContext = new VafContext(application);
        O00000o0 = vafContext;
        vafContext.O000000o(new ImageLoader.O000000o() {
            /* class _m_j.eui.AnonymousClass1 */

            public final void O000000o(String str, dqc dqc) {
                uo.O000000o(application).O00000o0().O000000o(str).O000000o(new O000000o(dqc));
            }
        });
        O00000o = O00000o0.O0000Oo();
        dow.O000000o(application);
        O00000o0.O00000Oo().O000000o(new dpl() {
            /* class _m_j.eui.AnonymousClass2 */

            public final boolean O000000o(dpj dpj) {
                Log.d("ClickProcessorImpl", "event " + dpj.O00000Oo);
                return true;
            }
        });
        O00000o.f14808O000000o.O000000o(1100, new eus.O000000o());
        O00000o.f14808O000000o.O000000o(1101, new eva.O000000o());
    }

    public static VafContext O000000o() {
        return O00000o0;
    }

    public static VafContext O00000Oo() {
        return O00000o0;
    }

    public static dok O00000o0() {
        return O00000o;
    }
}
