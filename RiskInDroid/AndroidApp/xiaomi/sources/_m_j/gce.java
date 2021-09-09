package _m_j;

import com.facebook.react.uimanager.ThemedReactContext;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.AbsRNVideoView;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNHSVideoView;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNIjkVideoView;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNVideoViewEx;

public final class gce {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f17512O000000o = false;
    public static boolean O00000Oo = false;

    public static gcg O000000o(cid cid, boolean z) {
        if (O00000Oo) {
            return new gcj(cid, z);
        }
        fvo.O000000o();
        if (fvo.O0000oo0()) {
            fvo.O000000o();
            f17512O000000o = fvo.O0000oOO();
        }
        return f17512O000000o ? new gck(cid, z) : new gcj(cid, z);
    }

    public static AbsRNVideoView O000000o(ThemedReactContext themedReactContext) {
        if (O00000Oo) {
            return new RNHSVideoView(themedReactContext);
        }
        fvo.O000000o();
        if (fvo.O0000oo0()) {
            fvo.O000000o();
            f17512O000000o = fvo.O0000oOO();
        }
        return f17512O000000o ? new RNIjkVideoView(themedReactContext) : new RNVideoViewEx(themedReactContext);
    }

    public static void O000000o() {
        f17512O000000o = false;
        O00000Oo = false;
    }
}
