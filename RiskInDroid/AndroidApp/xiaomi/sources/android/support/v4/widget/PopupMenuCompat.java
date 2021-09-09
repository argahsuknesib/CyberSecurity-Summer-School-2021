package android.support.v4.widget;

import android.os.Build;
import android.view.View;

public final class PopupMenuCompat {
    static final PopupMenuImpl IMPL;

    interface PopupMenuImpl {
        View.OnTouchListener getDragToOpenListener(Object obj);
    }

    static class BasePopupMenuImpl implements PopupMenuImpl {
        public View.OnTouchListener getDragToOpenListener(Object obj) {
            return null;
        }

        BasePopupMenuImpl() {
        }
    }

    static class KitKatPopupMenuImpl extends BasePopupMenuImpl {
        KitKatPopupMenuImpl() {
        }

        public View.OnTouchListener getDragToOpenListener(Object obj) {
            return PopupMenuCompatKitKat.getDragToOpenListener(obj);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new KitKatPopupMenuImpl();
        } else {
            IMPL = new BasePopupMenuImpl();
        }
    }

    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object obj) {
        return IMPL.getDragToOpenListener(obj);
    }
}
