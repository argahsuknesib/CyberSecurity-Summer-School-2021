package _m_j;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class bl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f13030O000000o = false;
    private static Method O00000Oo = null;
    private static Field O00000o = null;
    private static boolean O00000o0 = false;

    public interface O000000o {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean O000000o(View view, KeyEvent keyEvent) {
        return cb.O000000o(view, keyEvent);
    }

    public static boolean O000000o(O000000o o000000o, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (o000000o == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return o000000o.superDispatchKeyEvent(keyEvent);
        }
        KeyEvent.DispatcherState dispatcherState = null;
        if (callback instanceof Activity) {
            Activity activity = (Activity) callback;
            activity.onUserInteraction();
            Window window = activity.getWindow();
            if (window.hasFeature(8)) {
                ActionBar actionBar = activity.getActionBar();
                if (keyEvent.getKeyCode() == 82 && actionBar != null && O000000o(actionBar, keyEvent)) {
                    return true;
                }
            }
            if (window.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window.getDecorView();
            if (cb.O00000Oo(decorView, keyEvent)) {
                return true;
            }
            if (decorView != null) {
                dispatcherState = decorView.getKeyDispatcherState();
            }
            return keyEvent.dispatch(activity, dispatcherState, activity);
        } else if (callback instanceof Dialog) {
            Dialog dialog = (Dialog) callback;
            DialogInterface.OnKeyListener O000000o2 = O000000o(dialog);
            if (O000000o2 != null && O000000o2.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
            Window window2 = dialog.getWindow();
            if (window2.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView2 = window2.getDecorView();
            if (cb.O00000Oo(decorView2, keyEvent)) {
                return true;
            }
            if (decorView2 != null) {
                dispatcherState = decorView2.getKeyDispatcherState();
            }
            return keyEvent.dispatch(dialog, dispatcherState, dialog);
        } else if ((view == null || !cb.O00000Oo(view, keyEvent)) && !o000000o.superDispatchKeyEvent(keyEvent)) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean O000000o(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f13030O000000o) {
            try {
                O00000Oo = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException unused) {
            }
            f13030O000000o = true;
        }
        Method method = O00000Oo;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, keyEvent)).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    private static DialogInterface.OnKeyListener O000000o(Dialog dialog) {
        if (!O00000o0) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                O00000o = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            O00000o0 = true;
        }
        Field field = O00000o;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }
}
