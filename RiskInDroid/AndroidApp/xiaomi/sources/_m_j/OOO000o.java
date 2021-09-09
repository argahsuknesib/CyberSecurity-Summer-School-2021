package _m_j;

import _m_j.OO0o000;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import com.xiaomi.smarthome.R;

final class OOO000o extends OO0Oo00 implements OO0o000, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    private static final int O00000oO = 2132344852;

    /* renamed from: O000000o  reason: collision with root package name */
    final o0ooo0OO f12310O000000o;
    final ViewTreeObserver.OnGlobalLayoutListener O00000Oo = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class _m_j.OOO000o.AnonymousClass1 */

        public final void onGlobalLayout() {
            if (OOO000o.this.O00000o0() && !OOO000o.this.f12310O000000o.O0000o0o) {
                View view = OOO000o.this.O00000o0;
                if (view == null || !view.isShown()) {
                    OOO000o.this.O00000Oo();
                } else {
                    OOO000o.this.f12310O000000o.a_();
                }
            }
        }
    };
    ViewTreeObserver O00000o;
    View O00000o0;
    private final Context O00000oo;
    private final MenuBuilder O0000OOo;
    private final boolean O0000Oo;
    private final oOo00 O0000Oo0;
    private final int O0000OoO;
    private final int O0000Ooo;
    private OO0o000.O000000o O0000o;
    private final View.OnAttachStateChangeListener O0000o0 = new View.OnAttachStateChangeListener() {
        /* class _m_j.OOO000o.AnonymousClass2 */

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            if (OOO000o.this.O00000o != null) {
                if (!OOO000o.this.O00000o.isAlive()) {
                    OOO000o.this.O00000o = view.getViewTreeObserver();
                }
                OOO000o.this.O00000o.removeGlobalOnLayoutListener(OOO000o.this.O00000Oo);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final int O0000o00;
    private PopupWindow.OnDismissListener O0000o0O;
    private View O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;
    private int O0000oOO;
    private int O0000oOo = 0;
    private boolean O0000oo0;

    public final void O000000o(MenuBuilder menuBuilder) {
    }

    public final boolean flagActionItems() {
        return false;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public OOO000o(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.O00000oo = context;
        this.O0000OOo = menuBuilder;
        this.O0000Oo = z;
        this.O0000Oo0 = new oOo00(menuBuilder, LayoutInflater.from(context), this.O0000Oo, O00000oO);
        this.O0000Ooo = i;
        this.O0000o00 = i2;
        Resources resources = context.getResources();
        this.O0000OoO = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.O0000o0o = view;
        this.f12310O000000o = new o0ooo0OO(this.O00000oo, this.O0000Ooo, this.O0000o00);
        menuBuilder.addMenuPresenter(this, context);
    }

    public final void O000000o(boolean z) {
        this.O0000Oo0.O00000Oo = z;
    }

    public final void O000000o(int i) {
        this.O0000oOo = i;
    }

    public final void O00000Oo() {
        if (O00000o0()) {
            this.f12310O000000o.O00000Oo();
        }
    }

    public final boolean O00000o0() {
        return !this.O0000oO0 && this.f12310O000000o.O0000o.isShowing();
    }

    public final void onDismiss() {
        this.O0000oO0 = true;
        this.O0000OOo.close();
        ViewTreeObserver viewTreeObserver = this.O00000o;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.O00000o = this.O00000o0.getViewTreeObserver();
            }
            this.O00000o.removeGlobalOnLayoutListener(this.O00000Oo);
            this.O00000o = null;
        }
        this.O00000o0.removeOnAttachStateChangeListener(this.O0000o0);
        PopupWindow.OnDismissListener onDismissListener = this.O0000o0O;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void updateMenuView(boolean z) {
        this.O0000oO = false;
        oOo00 ooo00 = this.O0000Oo0;
        if (ooo00 != null) {
            ooo00.notifyDataSetChanged();
        }
    }

    public final void setCallback(OO0o000.O000000o o000000o) {
        this.O0000o = o000000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0067  */
    public final boolean onSubMenuSelected(OOO00O0 ooo00o0) {
        boolean z;
        if (ooo00o0.hasVisibleItems()) {
            OO0Oo0 oO0Oo0 = new OO0Oo0(this.O00000oo, ooo00o0, this.O00000o0, this.O0000Oo, this.O0000Ooo, this.O0000o00);
            oO0Oo0.O000000o(this.O0000o);
            oO0Oo0.O000000o(OO0Oo00.O00000Oo(ooo00o0));
            oO0Oo0.O00000o0 = this.O0000o0O;
            this.O0000o0O = null;
            this.O0000OOo.close(false);
            int i = this.f12310O000000o.O0000OOo;
            int O00000oO2 = this.f12310O000000o.O00000oO();
            if ((Gravity.getAbsoluteGravity(this.O0000oOo, cb.O0000Oo0(this.O0000o0o)) & 7) == 5) {
                i += this.O0000o0o.getWidth();
            }
            if (!oO0Oo0.O00000oO()) {
                if (oO0Oo0.f12305O000000o == null) {
                    z = false;
                    if (z) {
                        OO0o000.O000000o o000000o = this.O0000o;
                        if (o000000o != null) {
                            o000000o.O000000o(ooo00o0);
                        }
                        return true;
                    }
                } else {
                    oO0Oo0.O000000o(i, O00000oO2, true, true);
                }
            }
            z = true;
            if (z) {
            }
        }
        return false;
    }

    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.O0000OOo) {
            O00000Oo();
            OO0o000.O000000o o000000o = this.O0000o;
            if (o000000o != null) {
                o000000o.O000000o(menuBuilder, z);
            }
        }
    }

    public final void O000000o(View view) {
        this.O0000o0o = view;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        O00000Oo();
        return true;
    }

    public final void O000000o(PopupWindow.OnDismissListener onDismissListener) {
        this.O0000o0O = onDismissListener;
    }

    public final ListView b_() {
        return this.f12310O000000o.O00000oO;
    }

    public final void O00000Oo(int i) {
        this.f12310O000000o.O0000OOo = i;
    }

    public final void O00000o0(int i) {
        this.f12310O000000o.O000000o(i);
    }

    public final void O00000Oo(boolean z) {
        this.O0000oo0 = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, _m_j.OOOo000, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void a_() {
        View view;
        boolean z = true;
        if (!O00000o0()) {
            if (this.O0000oO0 || (view = this.O0000o0o) == null) {
                z = false;
            } else {
                this.O00000o0 = view;
                this.f12310O000000o.O000000o(this);
                o0ooo0OO o0ooo0oo = this.f12310O000000o;
                o0ooo0oo.O0000o00 = this;
                o0ooo0oo.O0000OOo();
                View view2 = this.O00000o0;
                boolean z2 = this.O00000o == null;
                this.O00000o = view2.getViewTreeObserver();
                if (z2) {
                    this.O00000o.addOnGlobalLayoutListener(this.O00000Oo);
                }
                view2.addOnAttachStateChangeListener(this.O0000o0);
                o0ooo0OO o0ooo0oo2 = this.f12310O000000o;
                o0ooo0oo2.O0000Ooo = view2;
                o0ooo0oo2.O0000Oo0 = this.O0000oOo;
                if (!this.O0000oO) {
                    this.O0000oOO = O000000o(this.O0000Oo0, null, this.O00000oo, this.O0000OoO);
                    this.O0000oO = true;
                }
                this.f12310O000000o.O00000o(this.O0000oOO);
                this.f12310O000000o.O0000Oo0();
                this.f12310O000000o.O000000o(this.O0000O0o);
                this.f12310O000000o.a_();
                OOOo000 oOOo000 = this.f12310O000000o.O00000oO;
                oOOo000.setOnKeyListener(this);
                if (this.O0000oo0 && this.O0000OOo.getHeaderTitle() != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.O00000oo).inflate((int) R.layout.abc_popup_menu_header_item_layout, (ViewGroup) oOOo000, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.O0000OOo.getHeaderTitle());
                    }
                    frameLayout.setEnabled(false);
                    oOOo000.addHeaderView(frameLayout, null, false);
                }
                this.f12310O000000o.O000000o(this.O0000Oo0);
                this.f12310O000000o.a_();
            }
        }
        if (!z) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }
}
