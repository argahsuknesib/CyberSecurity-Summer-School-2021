package _m_j;

import _m_j.OO0o000;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;

public final class OO0OO0o implements OO0o000.O000000o, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public MenuBuilder f12298O000000o;
    public AlertDialog O00000Oo;
    private OO0o000.O000000o O00000o;
    public ListMenuPresenter O00000o0;

    public OO0OO0o(MenuBuilder menuBuilder) {
        this.f12298O000000o = menuBuilder;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.O00000Oo.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.O00000Oo.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f12298O000000o.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f12298O000000o.performShortcut(i, keyEvent, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.O00000o0.onCloseMenu(this.f12298O000000o, true);
    }

    public final void O000000o(MenuBuilder menuBuilder, boolean z) {
        AlertDialog alertDialog;
        if ((z || menuBuilder == this.f12298O000000o) && (alertDialog = this.O00000Oo) != null) {
            alertDialog.dismiss();
        }
        OO0o000.O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.O000000o(menuBuilder, z);
        }
    }

    public final boolean O000000o(MenuBuilder menuBuilder) {
        OO0o000.O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            return o000000o.O000000o(menuBuilder);
        }
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f12298O000000o.performItemAction((OO0OOOO) this.O00000o0.O000000o().getItem(i), 0);
    }
}
