package com.mi.global.shop.base.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

public class BaseLayout extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    protected WeakReference<Activity> f4837O000000o;
    protected WeakReference<O000000o> O00000Oo;

    public interface O000000o {
        boolean O000000o();
    }

    public BaseLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BaseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseLayout(Context context) {
        super(context);
    }

    public void setActivity(Activity activity) {
        this.f4837O000000o = new WeakReference<>(activity);
    }

    public void setBackKeyListener(O000000o o000000o) {
        this.O00000Oo = new WeakReference<>(o000000o);
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        WeakReference<Activity> weakReference = this.f4837O000000o;
        O000000o o000000o = null;
        Activity activity = weakReference == null ? null : weakReference.get();
        WeakReference<O000000o> weakReference2 = this.O00000Oo;
        if (weakReference2 != null) {
            o000000o = weakReference2.get();
        }
        if (!(o000000o == null || !o000000o.O000000o() || activity == null || keyEvent.getKeyCode() != 4 || (keyDispatcherState = getKeyDispatcherState()) == null)) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && keyDispatcherState.isTracking(keyEvent)) {
                InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                }
                return true;
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}
