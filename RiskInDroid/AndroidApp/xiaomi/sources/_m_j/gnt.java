package _m_j;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.floatingview.EnFloatingView;
import com.xiaomi.smarthome.library.common.floatingview.FloatPositionEntity;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;

public class gnt {

    /* renamed from: O000000o  reason: collision with root package name */
    public static EnFloatingView f18057O000000o;
    private static volatile gnt O00000o;
    public int O00000Oo = R.layout.en_floating_view;
    public ViewGroup.LayoutParams O00000o0;
    private WeakReference<FrameLayout> O00000oO;

    private gnt() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 21;
        this.O00000o0 = layoutParams;
    }

    public static gnt O000000o() {
        if (O00000o == null) {
            synchronized (gnt.class) {
                if (O00000o == null) {
                    O00000o = new gnt();
                }
            }
        }
        return O00000o;
    }

    public final gnt O000000o(Activity activity) {
        if (activity != null) {
            try {
                if (f18057O000000o != null) {
                    f18057O000000o.O0000o0O = new WeakReference<>(activity);
                }
            } catch (Exception unused) {
            }
        }
        if (gns.O00000o0() && gns.O00000oo()) {
            O000000o(O00000o0(activity));
        }
        return this;
    }

    private gnt O000000o(FrameLayout frameLayout) {
        if (frameLayout != null) {
            try {
                if (f18057O000000o != null) {
                    if (f18057O000000o.getParent() == frameLayout) {
                        return this;
                    }
                    if (f18057O000000o.getParent() != null) {
                        ((ViewGroup) f18057O000000o.getParent()).removeView(f18057O000000o);
                    }
                    if (f18057O000000o.getAttachActivity() != null) {
                        LogType logType = LogType.GENERAL;
                        gsy.O00000o0(logType, "zhudong", "float_attach:" + f18057O000000o.getAttachActivity().getClass().getSimpleName());
                    }
                    this.O00000oO = new WeakReference<>(frameLayout);
                    f18057O000000o.post(new Runnable() {
                        /* class _m_j.gnt.AnonymousClass1 */

                        public final void run() {
                            FloatPositionEntity O00000o = gns.O00000o();
                            if (O00000o.x >= 0.0f) {
                                gnt.f18057O000000o.setX(O00000o.x);
                            } else {
                                gnt.f18057O000000o.O00000Oo();
                            }
                            if (O00000o.y >= 0.0f) {
                                gnt.f18057O000000o.setY(O00000o.y);
                            }
                            if (gns.O0000OOo()) {
                                gns.O0000O0o();
                                gnt.f18057O000000o.O00000Oo(3);
                            } else {
                                EnFloatingView enFloatingView = gnt.f18057O000000o;
                                enFloatingView.O00000Oo(enFloatingView.f9119O000000o);
                            }
                            gnt.f18057O000000o.setVisibility(0);
                        }
                    });
                    frameLayout.addView(f18057O000000o);
                    return this;
                }
            } catch (Exception unused) {
            }
        }
        this.O00000oO = new WeakReference<>(frameLayout);
        return this;
    }

    public final gnt O00000Oo(Activity activity) {
        try {
            LogType logType = LogType.GENERAL;
            gsy.O00000o0(logType, "zhudong", "float_detach:" + activity.getClass().getSimpleName() + "---mmkv_show_status:" + gns.O00000o0());
            O00000Oo(O00000o0(activity));
        } catch (Exception unused) {
        }
        return this;
    }

    private gnt O00000Oo(FrameLayout frameLayout) {
        FrameLayout frameLayout2;
        try {
            if (!(f18057O000000o == null || frameLayout == null || !f18057O000000o.isAttachedToWindow())) {
                frameLayout.removeView(f18057O000000o);
            }
            if (this.O00000oO == null) {
                frameLayout2 = null;
            } else {
                frameLayout2 = this.O00000oO.get();
            }
            if (frameLayout2 == frameLayout) {
                this.O00000oO = null;
            }
        } catch (Exception unused) {
        }
        return this;
    }

    private static FrameLayout O00000o0(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (FrameLayout) activity.getWindow().getDecorView().findViewById(16908290);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
