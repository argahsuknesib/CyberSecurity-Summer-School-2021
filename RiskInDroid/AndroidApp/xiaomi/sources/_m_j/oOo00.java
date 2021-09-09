package _m_j;

import _m_j.OO0o00;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.ArrayList;

public final class oOo00 extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public MenuBuilder f2324O000000o;
    boolean O00000Oo;
    private final boolean O00000o;
    private int O00000o0 = -1;
    private final LayoutInflater O00000oO;
    private final int O00000oo;

    public final long getItemId(int i) {
        return (long) i;
    }

    public oOo00(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        this.O00000o = z;
        this.O00000oO = layoutInflater;
        this.f2324O000000o = menuBuilder;
        this.O00000oo = i;
        O000000o();
    }

    public final int getCount() {
        ArrayList<OO0OOOO> nonActionItems = this.O00000o ? this.f2324O000000o.getNonActionItems() : this.f2324O000000o.getVisibleItems();
        if (this.O00000o0 < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    /* renamed from: O000000o */
    public final OO0OOOO getItem(int i) {
        ArrayList<OO0OOOO> nonActionItems = this.O00000o ? this.f2324O000000o.getNonActionItems() : this.f2324O000000o.getVisibleItems();
        int i2 = this.O00000o0;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (OO0OOOO) nonActionItems.get(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.O00000oO.inflate(this.O00000oo, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f2324O000000o.isGroupDividerEnabled() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        OO0o00.O000000o o000000o = (OO0o00.O000000o) view;
        if (this.O00000Oo) {
            listMenuItemView.setForceShowIcon(true);
        }
        o000000o.initialize(getItem(i), 0);
        return view;
    }

    private void O000000o() {
        OO0OOOO expandedItem = this.f2324O000000o.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<OO0OOOO> nonActionItems = this.f2324O000000o.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.O00000o0 = i;
                    return;
                }
            }
        }
        this.O00000o0 = -1;
    }

    public final void notifyDataSetChanged() {
        O000000o();
        super.notifyDataSetChanged();
    }
}
