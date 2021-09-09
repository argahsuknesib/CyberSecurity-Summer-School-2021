package _m_j;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.PointerEventsConfig;

public final class deu implements den {
    public final PointerEventsConfig O000000o(View view) {
        PointerEvents pointerEvents = view instanceof ReactPointerEventsView ? ((ReactPointerEventsView) view).getPointerEvents() : PointerEvents.AUTO;
        if (!view.isEnabled()) {
            if (pointerEvents == PointerEvents.AUTO) {
                return PointerEventsConfig.BOX_NONE;
            }
            if (pointerEvents == PointerEvents.BOX_ONLY) {
                return PointerEventsConfig.NONE;
            }
        }
        int i = AnonymousClass1.f14561O000000o[pointerEvents.ordinal()];
        if (i == 1) {
            return PointerEventsConfig.BOX_ONLY;
        }
        if (i == 2) {
            return PointerEventsConfig.BOX_NONE;
        }
        if (i != 3) {
            return PointerEventsConfig.AUTO;
        }
        return PointerEventsConfig.NONE;
    }

    /* renamed from: _m_j.deu$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14561O000000o = new int[PointerEvents.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f14561O000000o[PointerEvents.BOX_ONLY.ordinal()] = 1;
            f14561O000000o[PointerEvents.BOX_NONE.ordinal()] = 2;
            try {
                f14561O000000o[PointerEvents.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final View O000000o(ViewGroup viewGroup, int i) {
        if (viewGroup instanceof ReactViewGroup) {
            return viewGroup.getChildAt(((ReactViewGroup) viewGroup).getZIndexMappedChildIndex(i));
        }
        return viewGroup.getChildAt(i);
    }

    public final boolean O000000o(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT < 18 || viewGroup.getClipChildren()) {
            return true;
        }
        if (viewGroup instanceof ReactViewGroup) {
            return "hidden".equals(((ReactViewGroup) viewGroup).getOverflow());
        }
        return false;
    }
}
