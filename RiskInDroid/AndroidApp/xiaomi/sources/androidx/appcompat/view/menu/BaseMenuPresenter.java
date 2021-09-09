package androidx.appcompat.view.menu;

import _m_j.OO0OOOO;
import _m_j.OO0o00;
import _m_j.OO0o000;
import _m_j.OOO00O0;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public abstract class BaseMenuPresenter implements OO0o000 {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f2677O000000o;
    protected Context O00000Oo;
    protected LayoutInflater O00000o;
    public MenuBuilder O00000o0;
    protected LayoutInflater O00000oO;
    public OO0o000.O000000o O00000oo;
    public OO0o00 O0000O0o;
    public int O0000OOo;
    private int O0000Oo = R.layout.abc_action_menu_item_layout;
    private int O0000Oo0 = R.layout.abc_action_menu_layout;

    public abstract void O000000o(OO0OOOO oo0oooo, OO0o00.O000000o o000000o);

    public boolean O000000o(OO0OOOO oo0oooo) {
        return true;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, OO0OOOO oo0oooo) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, OO0OOOO oo0oooo) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public BaseMenuPresenter(Context context) {
        this.f2677O000000o = context;
        this.O00000o = LayoutInflater.from(context);
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.O00000Oo = context;
        this.O00000oO = LayoutInflater.from(this.O00000Oo);
        this.O00000o0 = menuBuilder;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public OO0o00 O000000o(ViewGroup viewGroup) {
        if (this.O0000O0o == null) {
            this.O0000O0o = (OO0o00) this.O00000o.inflate(this.O0000Oo0, viewGroup, false);
            this.O0000O0o.initialize(this.O00000o0);
            updateMenuView(true);
        }
        return this.O0000O0o;
    }

    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.O0000O0o;
        if (viewGroup != null) {
            MenuBuilder menuBuilder = this.O00000o0;
            int i = 0;
            if (menuBuilder != null) {
                menuBuilder.flagActionItems();
                ArrayList<OO0OOOO> visibleItems = this.O00000o0.getVisibleItems();
                int size = visibleItems.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    OO0OOOO oo0oooo = visibleItems.get(i3);
                    if (O000000o(oo0oooo)) {
                        View childAt = viewGroup.getChildAt(i2);
                        OO0OOOO itemData = childAt instanceof OO0o00.O000000o ? ((OO0o00.O000000o) childAt).getItemData() : null;
                        View O000000o2 = O000000o(oo0oooo, childAt, viewGroup);
                        if (oo0oooo != itemData) {
                            O000000o2.setPressed(false);
                            O000000o2.jumpDrawablesToCurrentState();
                        }
                        if (O000000o2 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) O000000o2.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(O000000o2);
                            }
                            ((ViewGroup) this.O0000O0o).addView(O000000o2, i2);
                        }
                        i2++;
                    }
                }
                i = i2;
            }
            while (i < viewGroup.getChildCount()) {
                if (!O000000o(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean O000000o(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void setCallback(OO0o000.O000000o o000000o) {
        this.O00000oo = o000000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View O000000o(OO0OOOO oo0oooo, View view, ViewGroup viewGroup) {
        OO0o00.O000000o o000000o;
        if (view instanceof OO0o00.O000000o) {
            o000000o = (OO0o00.O000000o) view;
        } else {
            o000000o = (OO0o00.O000000o) this.O00000o.inflate(this.O0000Oo, viewGroup, false);
        }
        O000000o(oo0oooo, o000000o);
        return (View) o000000o;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        OO0o000.O000000o o000000o = this.O00000oo;
        if (o000000o != null) {
            o000000o.O000000o(menuBuilder, z);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    public boolean onSubMenuSelected(OOO00O0 ooo00o0) {
        OO0o000.O000000o o000000o = this.O00000oo;
        MenuBuilder menuBuilder = ooo00o0;
        if (o000000o == null) {
            return false;
        }
        if (ooo00o0 == null) {
            menuBuilder = this.O00000o0;
        }
        return o000000o.O000000o(menuBuilder);
    }

    public int getId() {
        return this.O0000OOo;
    }
}
