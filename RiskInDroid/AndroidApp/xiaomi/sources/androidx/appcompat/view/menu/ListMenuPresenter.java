package androidx.appcompat.view.menu;

import _m_j.OO0OO0o;
import _m_j.OO0OOOO;
import _m_j.OO0o00;
import _m_j.OO0o000;
import _m_j.OOO00O0;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public final class ListMenuPresenter implements OO0o000, AdapterView.OnItemClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f2680O000000o;
    LayoutInflater O00000Oo;
    ExpandedMenuView O00000o;
    MenuBuilder O00000o0;
    int O00000oO;
    int O00000oo;
    int O0000O0o;
    O000000o O0000OOo;
    private int O0000Oo;
    private OO0o000.O000000o O0000Oo0;

    public final boolean collapseItemActionView(MenuBuilder menuBuilder, OO0OOOO oo0oooo) {
        return false;
    }

    public final boolean expandItemActionView(MenuBuilder menuBuilder, OO0OOOO oo0oooo) {
        return false;
    }

    public final boolean flagActionItems() {
        return false;
    }

    public ListMenuPresenter(Context context) {
        this((int) R.layout.abc_list_menu_item_layout);
        this.f2680O000000o = context;
        this.O00000Oo = LayoutInflater.from(this.f2680O000000o);
    }

    private ListMenuPresenter(int i) {
        this.O0000O0o = R.layout.abc_list_menu_item_layout;
        this.O00000oo = 0;
    }

    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
        int i = this.O00000oo;
        if (i != 0) {
            this.f2680O000000o = new ContextThemeWrapper(context, i);
            this.O00000Oo = LayoutInflater.from(this.f2680O000000o);
        } else if (this.f2680O000000o != null) {
            this.f2680O000000o = context;
            if (this.O00000Oo == null) {
                this.O00000Oo = LayoutInflater.from(this.f2680O000000o);
            }
        }
        this.O00000o0 = menuBuilder;
        O000000o o000000o = this.O0000OOo;
        if (o000000o != null) {
            o000000o.notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final OO0o00 O000000o(ViewGroup viewGroup) {
        if (this.O00000o == null) {
            this.O00000o = (ExpandedMenuView) this.O00000Oo.inflate((int) R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.O0000OOo == null) {
                this.O0000OOo = new O000000o();
            }
            this.O00000o.setAdapter((ListAdapter) this.O0000OOo);
            this.O00000o.setOnItemClickListener(this);
        }
        return this.O00000o;
    }

    public final ListAdapter O000000o() {
        if (this.O0000OOo == null) {
            this.O0000OOo = new O000000o();
        }
        return this.O0000OOo;
    }

    public final void updateMenuView(boolean z) {
        O000000o o000000o = this.O0000OOo;
        if (o000000o != null) {
            o000000o.notifyDataSetChanged();
        }
    }

    public final void setCallback(OO0o000.O000000o o000000o) {
        this.O0000Oo0 = o000000o;
    }

    public final boolean onSubMenuSelected(OOO00O0 ooo00o0) {
        if (!ooo00o0.hasVisibleItems()) {
            return false;
        }
        OO0OO0o oO0OO0o = new OO0OO0o(ooo00o0);
        MenuBuilder menuBuilder = oO0OO0o.f12298O000000o;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.getContext());
        oO0OO0o.O00000o0 = new ListMenuPresenter(builder.getContext());
        oO0OO0o.O00000o0.setCallback(oO0OO0o);
        oO0OO0o.f12298O000000o.addMenuPresenter(oO0OO0o.O00000o0);
        builder.setAdapter(oO0OO0o.O00000o0.O000000o(), oO0OO0o);
        View headerView = menuBuilder.getHeaderView();
        if (headerView != null) {
            builder.setCustomTitle(headerView);
        } else {
            builder.setIcon(menuBuilder.getHeaderIcon()).setTitle(menuBuilder.getHeaderTitle());
        }
        builder.setOnKeyListener(oO0OO0o);
        oO0OO0o.O00000Oo = builder.create();
        oO0OO0o.O00000Oo.setOnDismissListener(oO0OO0o);
        WindowManager.LayoutParams attributes = oO0OO0o.O00000Oo.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        oO0OO0o.O00000Oo.show();
        OO0o000.O000000o o000000o = this.O0000Oo0;
        if (o000000o == null) {
            return true;
        }
        o000000o.O000000o(ooo00o0);
        return true;
    }

    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        OO0o000.O000000o o000000o = this.O0000Oo0;
        if (o000000o != null) {
            o000000o.O000000o(menuBuilder, z);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.O00000o0.performItemAction(this.O0000OOo.getItem(i), this, 0);
    }

    public final int getId() {
        return this.O0000Oo;
    }

    public final Parcelable onSaveInstanceState() {
        if (this.O00000o == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.O00000o;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.O00000o.restoreHierarchyState(sparseParcelableArray);
        }
    }

    class O000000o extends BaseAdapter {
        private int O00000Oo = -1;

        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o() {
            O000000o();
        }

        public final int getCount() {
            int size = ListMenuPresenter.this.O00000o0.getNonActionItems().size() - ListMenuPresenter.this.O00000oO;
            return this.O00000Oo < 0 ? size : size - 1;
        }

        /* renamed from: O000000o */
        public final OO0OOOO getItem(int i) {
            ArrayList<OO0OOOO> nonActionItems = ListMenuPresenter.this.O00000o0.getNonActionItems();
            int i2 = i + ListMenuPresenter.this.O00000oO;
            int i3 = this.O00000Oo;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [int, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ListMenuPresenter.this.O00000Oo.inflate(ListMenuPresenter.this.O0000O0o, viewGroup, false);
            }
            ((OO0o00.O000000o) view).initialize(getItem(i), 0);
            return view;
        }

        private void O000000o() {
            OO0OOOO expandedItem = ListMenuPresenter.this.O00000o0.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<OO0OOOO> nonActionItems = ListMenuPresenter.this.O00000o0.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.O00000Oo = i;
                        return;
                    }
                }
            }
            this.O00000Oo = -1;
        }

        public final void notifyDataSetChanged() {
            O000000o();
            super.notifyDataSetChanged();
        }
    }
}
