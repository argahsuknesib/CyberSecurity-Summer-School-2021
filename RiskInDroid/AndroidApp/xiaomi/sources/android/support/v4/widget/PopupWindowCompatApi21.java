package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

@TargetApi(21)
@RequiresApi(21)
class PopupWindowCompatApi21 {
    private static Field sOverlapAnchorField;

    PopupWindowCompatApi21() {
    }

    static {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            sOverlapAnchorField = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        Field field = sOverlapAnchorField;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }

    static boolean getOverlapAnchor(PopupWindow popupWindow) {
        Field field = sOverlapAnchorField;
        if (field == null) {
            return false;
        }
        try {
            return ((Boolean) field.get(popupWindow)).booleanValue();
        } catch (IllegalAccessException e) {
            Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", e);
            return false;
        }
    }
}
