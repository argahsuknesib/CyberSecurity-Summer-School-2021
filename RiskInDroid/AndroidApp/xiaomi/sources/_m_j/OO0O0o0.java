package _m_j;

import _m_j.OO0o000;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

final class OO0O0o0 extends OO0Oo00 implements OO0o000, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int O0000OOo = 2132344844;

    /* renamed from: O000000o  reason: collision with root package name */
    final Handler f12292O000000o;
    final List<O000000o> O00000Oo = new ArrayList();
    View O00000o;
    final ViewTreeObserver.OnGlobalLayoutListener O00000o0 = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class _m_j.OO0O0o0.AnonymousClass1 */

        public final void onGlobalLayout() {
            if (OO0O0o0.this.O00000o0() && OO0O0o0.this.O00000Oo.size() > 0 && !OO0O0o0.this.O00000Oo.get(0).f12297O000000o.O0000o0o) {
                View view = OO0O0o0.this.O00000o;
                if (view == null || !view.isShown()) {
                    OO0O0o0.this.O00000Oo();
                    return;
                }
                for (O000000o o000000o : OO0O0o0.this.O00000Oo) {
                    o000000o.f12297O000000o.a_();
                }
            }
        }
    };
    ViewTreeObserver O00000oO;
    boolean O00000oo;
    private final int O0000Oo;
    private final Context O0000Oo0;
    private final int O0000OoO;
    private final int O0000Ooo;
    private int O0000o = 0;
    private final List<MenuBuilder> O0000o0 = new ArrayList();
    private final boolean O0000o00;
    private final View.OnAttachStateChangeListener O0000o0O = new View.OnAttachStateChangeListener() {
        /* class _m_j.OO0O0o0.AnonymousClass2 */

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            if (OO0O0o0.this.O00000oO != null) {
                if (!OO0O0o0.this.O00000oO.isAlive()) {
                    OO0O0o0.this.O00000oO = view.getViewTreeObserver();
                }
                OO0O0o0.this.O00000oO.removeGlobalOnLayoutListener(OO0O0o0.this.O00000o0);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final OOOo O0000o0o = new OOOo() {
        /* class _m_j.OO0O0o0.AnonymousClass3 */

        public final void O000000o(MenuBuilder menuBuilder, MenuItem menuItem) {
            OO0O0o0.this.f12292O000000o.removeCallbacksAndMessages(menuBuilder);
        }

        public final void O00000Oo(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            final O000000o o000000o = null;
            OO0O0o0.this.f12292O000000o.removeCallbacksAndMessages(null);
            int size = OO0O0o0.this.O00000Oo.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == OO0O0o0.this.O00000Oo.get(i).O00000Oo) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < OO0O0o0.this.O00000Oo.size()) {
                    o000000o = OO0O0o0.this.O00000Oo.get(i2);
                }
                OO0O0o0.this.f12292O000000o.postAtTime(new Runnable() {
                    /* class _m_j.OO0O0o0.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        if (o000000o != null) {
                            OO0O0o0.this.O00000oo = true;
                            o000000o.O00000Oo.close(false);
                            OO0O0o0.this.O00000oo = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            menuBuilder.performItemAction(menuItem, 4);
                        }
                    }
                }, menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private View O0000oO;
    private int O0000oO0 = 0;
    private int O0000oOO;
    private boolean O0000oOo;
    private int O0000oo;
    private boolean O0000oo0;
    private int O0000ooO;
    private boolean O0000ooo;
    private PopupWindow.OnDismissListener O000O00o;
    private boolean O00oOooO;
    private OO0o000.O000000o O00oOooo;

    /* access modifiers changed from: protected */
    public final boolean O00000oO() {
        return false;
    }

    public final boolean flagActionItems() {
        return false;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public OO0O0o0(Context context, View view, int i, int i2, boolean z) {
        this.O0000Oo0 = context;
        this.O0000oO = view;
        this.O0000OoO = i;
        this.O0000Ooo = i2;
        this.O0000o00 = z;
        this.O0000ooo = false;
        this.O0000oOO = O0000O0o();
        Resources resources = context.getResources();
        this.O0000Oo = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f12292O000000o = new Handler();
    }

    public final void O000000o(boolean z) {
        this.O0000ooo = z;
    }

    private o0ooo0OO O00000oo() {
        o0ooo0OO o0ooo0oo = new o0ooo0OO(this.O0000Oo0, this.O0000OoO, this.O0000Ooo);
        o0ooo0oo.f2262O000000o = this.O0000o0o;
        o0ooo0oo.O0000o00 = this;
        o0ooo0oo.O000000o(this);
        o0ooo0oo.O0000Ooo = this.O0000oO;
        o0ooo0oo.O0000Oo0 = this.O0000oO0;
        o0ooo0oo.O0000OOo();
        o0ooo0oo.O0000Oo0();
        return o0ooo0oo;
    }

    public final void a_() {
        if (!O00000o0()) {
            for (MenuBuilder O00000o02 : this.O0000o0) {
                O00000o0(O00000o02);
            }
            this.O0000o0.clear();
            this.O00000o = this.O0000oO;
            if (this.O00000o != null) {
                boolean z = this.O00000oO == null;
                this.O00000oO = this.O00000o.getViewTreeObserver();
                if (z) {
                    this.O00000oO.addOnGlobalLayoutListener(this.O00000o0);
                }
                this.O00000o.addOnAttachStateChangeListener(this.O0000o0O);
            }
        }
    }

    public final void O00000Oo() {
        int size = this.O00000Oo.size();
        if (size > 0) {
            O000000o[] o000000oArr = (O000000o[]) this.O00000Oo.toArray(new O000000o[size]);
            for (int i = size - 1; i >= 0; i--) {
                O000000o o000000o = o000000oArr[i];
                if (o000000o.f12297O000000o.O0000o.isShowing()) {
                    o000000o.f12297O000000o.O00000Oo();
                }
            }
        }
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        O00000Oo();
        return true;
    }

    private int O0000O0o() {
        return cb.O0000Oo0(this.O0000oO) == 1 ? 0 : 1;
    }

    private int O00000o(int i) {
        List<O000000o> list = this.O00000Oo;
        OOOo000 oOOo000 = list.get(list.size() - 1).f12297O000000o.O00000oO;
        int[] iArr = new int[2];
        oOOo000.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.O00000o.getWindowVisibleDisplayFrame(rect);
        if (this.O0000oOO == 1) {
            if (iArr[0] + oOOo000.getWidth() + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public final void O000000o(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.O0000Oo0);
        if (O00000o0()) {
            O00000o0(menuBuilder);
        } else {
            this.O0000o0.add(menuBuilder);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, _m_j.OOOo000, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O00000o0(MenuBuilder menuBuilder) {
        View view;
        O000000o o000000o;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.O0000Oo0);
        oOo00 ooo00 = new oOo00(menuBuilder, from, this.O0000o00, O0000OOo);
        if (!O00000o0() && this.O0000ooo) {
            ooo00.O00000Oo = true;
        } else if (O00000o0()) {
            ooo00.O00000Oo = OO0Oo00.O00000Oo(menuBuilder);
        }
        int O000000o2 = O000000o(ooo00, null, this.O0000Oo0, this.O0000Oo);
        o0ooo0OO O00000oo2 = O00000oo();
        O00000oo2.O000000o(ooo00);
        O00000oo2.O00000o(O000000o2);
        O00000oo2.O0000Oo0 = this.O0000oO0;
        if (this.O00000Oo.size() > 0) {
            List<O000000o> list = this.O00000Oo;
            o000000o = list.get(list.size() - 1);
            view = O000000o(o000000o, menuBuilder);
        } else {
            o000000o = null;
            view = null;
        }
        if (view != null) {
            O00000oo2.O0000o0();
            O00000oo2.O0000O0o();
            int O00000o2 = O00000o(O000000o2);
            boolean z = O00000o2 == 1;
            this.O0000oOO = O00000o2;
            if (Build.VERSION.SDK_INT >= 26) {
                O00000oo2.O0000Ooo = view;
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.O0000oO.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.O0000oO0 & 7) == 5) {
                    iArr[0] = iArr[0] + this.O0000oO.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.O0000oO0 & 5) != 5) {
                if (z) {
                    O000000o2 = view.getWidth();
                }
                i3 = i - O000000o2;
                O00000oo2.O0000OOo = i3;
                O00000oo2.O0000o00();
                O00000oo2.O000000o(i2);
            } else if (!z) {
                O000000o2 = view.getWidth();
                i3 = i - O000000o2;
                O00000oo2.O0000OOo = i3;
                O00000oo2.O0000o00();
                O00000oo2.O000000o(i2);
            }
            i3 = i + O000000o2;
            O00000oo2.O0000OOo = i3;
            O00000oo2.O0000o00();
            O00000oo2.O000000o(i2);
        } else {
            if (this.O0000oOo) {
                O00000oo2.O0000OOo = this.O0000oo;
            }
            if (this.O0000oo0) {
                O00000oo2.O000000o(this.O0000ooO);
            }
            O00000oo2.O000000o(this.O0000O0o);
        }
        this.O00000Oo.add(new O000000o(O00000oo2, menuBuilder, this.O0000oOO));
        O00000oo2.a_();
        OOOo000 oOOo000 = O00000oo2.O00000oO;
        oOOo000.setOnKeyListener(this);
        if (o000000o == null && this.O00oOooO && menuBuilder.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate((int) R.layout.abc_popup_menu_header_item_layout, (ViewGroup) oOOo000, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.getHeaderTitle());
            oOOo000.addHeaderView(frameLayout, null, false);
            O00000oo2.a_();
        }
    }

    private static MenuItem O000000o(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private static View O000000o(O000000o o000000o, MenuBuilder menuBuilder) {
        int i;
        oOo00 ooo00;
        int firstVisiblePosition;
        MenuItem O000000o2 = O000000o(o000000o.O00000Oo, menuBuilder);
        if (O000000o2 == null) {
            return null;
        }
        OOOo000 oOOo000 = o000000o.f12297O000000o.O00000oO;
        ListAdapter adapter = oOOo000.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            ooo00 = (oOo00) headerViewListAdapter.getWrappedAdapter();
        } else {
            ooo00 = (oOo00) adapter;
            i = 0;
        }
        int count = ooo00.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (O000000o2 == ooo00.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - oOOo000.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < oOOo000.getChildCount()) {
            return oOOo000.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final boolean O00000o0() {
        return this.O00000Oo.size() > 0 && this.O00000Oo.get(0).f12297O000000o.O0000o.isShowing();
    }

    public final void onDismiss() {
        O000000o o000000o;
        int size = this.O00000Oo.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                o000000o = null;
                break;
            }
            o000000o = this.O00000Oo.get(i);
            if (!o000000o.f12297O000000o.O0000o.isShowing()) {
                break;
            }
            i++;
        }
        if (o000000o != null) {
            o000000o.O00000Oo.close(false);
        }
    }

    public final void updateMenuView(boolean z) {
        for (O000000o o000000o : this.O00000Oo) {
            O000000o(o000000o.f12297O000000o.O00000oO.getAdapter()).notifyDataSetChanged();
        }
    }

    public final void setCallback(OO0o000.O000000o o000000o) {
        this.O00oOooo = o000000o;
    }

    public final boolean onSubMenuSelected(OOO00O0 ooo00o0) {
        for (O000000o next : this.O00000Oo) {
            if (ooo00o0 == next.O00000Oo) {
                next.f12297O000000o.O00000oO.requestFocus();
                return true;
            }
        }
        if (!ooo00o0.hasVisibleItems()) {
            return false;
        }
        O000000o(ooo00o0);
        OO0o000.O000000o o000000o = this.O00oOooo;
        if (o000000o != null) {
            o000000o.O000000o(ooo00o0);
        }
        return true;
    }

    public final void O000000o(int i) {
        if (this.O0000o != i) {
            this.O0000o = i;
            this.O0000oO0 = bk.O000000o(i, cb.O0000Oo0(this.O0000oO));
        }
    }

    public final void O000000o(View view) {
        if (this.O0000oO != view) {
            this.O0000oO = view;
            this.O0000oO0 = bk.O000000o(this.O0000o, cb.O0000Oo0(this.O0000oO));
        }
    }

    public final void O000000o(PopupWindow.OnDismissListener onDismissListener) {
        this.O000O00o = onDismissListener;
    }

    public final ListView b_() {
        if (this.O00000Oo.isEmpty()) {
            return null;
        }
        List<O000000o> list = this.O00000Oo;
        return list.get(list.size() - 1).f12297O000000o.O00000oO;
    }

    public final void O00000Oo(int i) {
        this.O0000oOo = true;
        this.O0000oo = i;
    }

    public final void O00000o0(int i) {
        this.O0000oo0 = true;
        this.O0000ooO = i;
    }

    public final void O00000Oo(boolean z) {
        this.O00oOooO = z;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final o0ooo0OO f12297O000000o;
        public final MenuBuilder O00000Oo;
        public final int O00000o0;

        public O000000o(o0ooo0OO o0ooo0oo, MenuBuilder menuBuilder, int i) {
            this.f12297O000000o = o0ooo0oo;
            this.O00000Oo = menuBuilder;
            this.O00000o0 = i;
        }
    }

    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int size = this.O00000Oo.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == this.O00000Oo.get(i).O00000Oo) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            int i2 = i + 1;
            if (i2 < this.O00000Oo.size()) {
                this.O00000Oo.get(i2).O00000Oo.close(false);
            }
            O000000o remove = this.O00000Oo.remove(i);
            remove.O00000Oo.removeMenuPresenter(this);
            if (this.O00000oo) {
                o0ooo0OO o0ooo0oo = remove.f12297O000000o;
                if (Build.VERSION.SDK_INT >= 23) {
                    o0ooo0oo.O0000o.setExitTransition(null);
                }
                remove.f12297O000000o.O0000o.setAnimationStyle(0);
            }
            remove.f12297O000000o.O00000Oo();
            int size2 = this.O00000Oo.size();
            if (size2 > 0) {
                this.O0000oOO = this.O00000Oo.get(size2 - 1).O00000o0;
            } else {
                this.O0000oOO = O0000O0o();
            }
            if (size2 == 0) {
                O00000Oo();
                OO0o000.O000000o o000000o = this.O00oOooo;
                if (o000000o != null) {
                    o000000o.O000000o(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.O00000oO;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.O00000oO.removeGlobalOnLayoutListener(this.O00000o0);
                    }
                    this.O00000oO = null;
                }
                this.O00000o.removeOnAttachStateChangeListener(this.O0000o0O);
                this.O000O00o.onDismiss();
            } else if (z) {
                this.O00000Oo.get(0).O00000Oo.close(false);
            }
        }
    }
}
