package _m_j;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ListPopupWindow;
import java.lang.reflect.Method;

public final class o0ooo0OO extends ListPopupWindow implements OOOo {
    private static Method O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public OOOo f2262O000000o;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                O00000Oo = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public o0ooo0OO(Context context, int i, int i2) {
        super(context, null, i, i2);
    }

    public final OOOo000 O000000o(Context context, boolean z) {
        O000000o o000000o = new O000000o(context, z);
        o000000o.setHoverListener(this);
        return o000000o;
    }

    public final void O0000O0o() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.O0000o.setEnterTransition(null);
        }
    }

    public final void O0000o0() {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = O00000Oo;
            if (method != null) {
                try {
                    method.invoke(this.O0000o, Boolean.FALSE);
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.O0000o.setTouchModal(false);
        }
    }

    public final void O00000Oo(MenuBuilder menuBuilder, MenuItem menuItem) {
        OOOo oOOo = this.f2262O000000o;
        if (oOOo != null) {
            oOOo.O00000Oo(menuBuilder, menuItem);
        }
    }

    public final void O000000o(MenuBuilder menuBuilder, MenuItem menuItem) {
        OOOo oOOo = this.f2262O000000o;
        if (oOOo != null) {
            oOOo.O000000o(menuBuilder, menuItem);
        }
    }

    public static class O000000o extends OOOo000 {
        final int O00000Oo;
        private OOOo O00000o;
        final int O00000o0;
        private MenuItem O00000oO;

        public final /* bridge */ /* synthetic */ int O000000o(int i, int i2, int i3, int i4, int i5) {
            return super.O000000o(i, i2, i3, i4, i5);
        }

        public final /* bridge */ /* synthetic */ boolean O000000o(MotionEvent motionEvent, int i) {
            return super.O000000o(motionEvent, i);
        }

        public final /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public final /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public final /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public final /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public final /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public final /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public O000000o(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.O00000Oo = 22;
                this.O00000o0 = 21;
                return;
            }
            this.O00000Oo = 21;
            this.O00000o0 = 22;
        }

        public final void setHoverListener(OOOo oOOo) {
            this.O00000o = oOOo;
        }

        public final boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.O00000Oo) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.O00000o0) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((oOo00) getAdapter()).f2324O000000o.close(false);
                return true;
            }
        }

        public final boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            oOo00 ooo00;
            int pointToPosition;
            int i2;
            if (this.O00000o != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    ooo00 = (oOo00) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    ooo00 = (oOo00) adapter;
                }
                OO0OOOO oo0oooo = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < ooo00.getCount()) {
                    oo0oooo = ooo00.getItem(i2);
                }
                MenuItem menuItem = this.O00000oO;
                if (menuItem != oo0oooo) {
                    MenuBuilder menuBuilder = ooo00.f2324O000000o;
                    if (menuItem != null) {
                        this.O00000o.O000000o(menuBuilder, menuItem);
                    }
                    this.O00000oO = oo0oooo;
                    if (oo0oooo != null) {
                        this.O00000o.O00000Oo(menuBuilder, oo0oooo);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
