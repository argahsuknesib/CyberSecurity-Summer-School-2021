package _m_j;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.RequestManager;

public class uo implements ComponentCallbacks2 {
    private static volatile uo O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public final ux f2540O000000o = new ux() {
        /* class _m_j.uo.AnonymousClass1 */

        public final Bitmap O000000o(int i, int i2, Bitmap.Config config) {
            return Bitmap.createBitmap(i, i2, config);
        }
    };
    private MemoryCategory O00000o0 = MemoryCategory.NORMAL;

    public void onConfigurationChanged(Configuration configuration) {
    }

    public static uo O000000o() {
        if (O00000Oo == null) {
            synchronized (uo.class) {
                if (O00000Oo == null) {
                    O00000Oo = new uo();
                }
            }
        }
        return O00000Oo;
    }

    public final ux O00000Oo() {
        return this.f2540O000000o;
    }

    public static RequestManager O000000o(FragmentActivity fragmentActivity) {
        return new RequestManager(fragmentActivity);
    }

    public static RequestManager O000000o(View view) {
        return new RequestManager(view.getContext());
    }

    public static RequestManager O000000o(Context context) {
        return new RequestManager(context);
    }

    public void onTrimMemory(int i) {
        vo.O000000o();
    }

    public void onLowMemory() {
        vo.O000000o();
    }
}
