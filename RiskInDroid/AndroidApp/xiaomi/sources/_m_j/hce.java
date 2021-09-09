package _m_j;

import _m_j.exx;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;
import com.xiaomi.smarthome.application.CommonApplication;

public final class hce extends exx.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final hce f18771O000000o = new hce();
    private final hyj O00000Oo = new hyj() {
        /* class _m_j.hce.AnonymousClass1 */

        public final int O000000o(int i) {
            if ((CommonApplication.getAppContext().getResources().getConfiguration().uiMode & 48) != 32) {
                return i;
            }
            if (-1 == i) {
                return Color.argb(229, 255, 255, 255);
            }
            int alpha = Color.alpha(i);
            if (alpha < 100) {
                i = Color.argb(((alpha * 49) / 100) + 51, Color.red(i), Color.green(i), Color.blue(i));
            }
            return hyj.O00000oo.O000000o(i);
        }
    };

    public final Drawable createDrawable(CloseableImage closeableImage) {
        return new hym(((exx.O000000o) closeableImage).f15939O000000o).O000000o(this.O00000Oo);
    }
}
