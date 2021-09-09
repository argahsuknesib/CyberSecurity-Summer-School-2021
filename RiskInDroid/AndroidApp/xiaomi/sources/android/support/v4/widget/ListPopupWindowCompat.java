package android.support.v4.widget;

import android.os.Build;
import android.view.View;

public final class ListPopupWindowCompat {
    static final ListPopupWindowImpl IMPL;

    interface ListPopupWindowImpl {
        View.OnTouchListener createDragToOpenListener(Object obj, View view);
    }

    static class BaseListPopupWindowImpl implements ListPopupWindowImpl {
        public View.OnTouchListener createDragToOpenListener(Object obj, View view) {
            return null;
        }

        BaseListPopupWindowImpl() {
        }
    }

    static class KitKatListPopupWindowImpl extends BaseListPopupWindowImpl {
        KitKatListPopupWindowImpl() {
        }

        public View.OnTouchListener createDragToOpenListener(Object obj, View view) {
            return ListPopupWindowCompatKitKat.createDragToOpenListener(obj, view);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new KitKatListPopupWindowImpl();
        } else {
            IMPL = new BaseListPopupWindowImpl();
        }
    }

    private ListPopupWindowCompat() {
    }

    public static View.OnTouchListener createDragToOpenListener(Object obj, View view) {
        return IMPL.createDragToOpenListener(obj, view);
    }
}
