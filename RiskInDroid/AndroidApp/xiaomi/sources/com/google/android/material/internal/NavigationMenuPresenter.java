package com.google.android.material.internal;

import _m_j.OO0OOOO;
import _m_j.OO0o00;
import _m_j.OO0o000;
import _m_j.OOO00O0;
import _m_j.cb;
import _m_j.ci;
import _m_j.cl;
import _m_j.hb;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class NavigationMenuPresenter implements OO0o000 {
    NavigationMenuAdapter adapter;
    private OO0o000.O000000o callback;
    boolean hasCustomItemIconSize;
    LinearLayout headerLayout;
    ColorStateList iconTintList;
    private int id;
    boolean isBehindStatusBar = true;
    Drawable itemBackground;
    int itemHorizontalPadding;
    int itemIconPadding;
    int itemIconSize;
    public int itemMaxLines;
    LayoutInflater layoutInflater;
    MenuBuilder menu;
    private NavigationMenuView menuView;
    final View.OnClickListener onClickListener = new View.OnClickListener() {
        /* class com.google.android.material.internal.NavigationMenuPresenter.AnonymousClass1 */

        public void onClick(View view) {
            boolean z = true;
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            OO0OOOO itemData = ((NavigationMenuItemView) view).getItemData();
            boolean performItemAction = NavigationMenuPresenter.this.menu.performItemAction(itemData, NavigationMenuPresenter.this, 0);
            if (itemData == null || !itemData.isCheckable() || !performItemAction) {
                z = false;
            } else {
                NavigationMenuPresenter.this.adapter.setCheckedItem(itemData);
            }
            NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    };
    private int overScrollMode = -1;
    int paddingSeparator;
    private int paddingTopDefault;
    int textAppearance;
    boolean textAppearanceSet;
    ColorStateList textColor;

    interface NavigationMenuItem {
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

    public boolean onSubMenuSelected(OOO00O0 ooo00o0) {
        return false;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.layoutInflater = LayoutInflater.from(context);
        this.menu = menuBuilder;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.google.android.material.internal.NavigationMenuView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public OO0o00 getMenuView(ViewGroup viewGroup) {
        if (this.menuView == null) {
            this.menuView = (NavigationMenuView) this.layoutInflater.inflate((int) R.layout.design_navigation_menu, viewGroup, false);
            NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(navigationMenuView));
            if (this.adapter == null) {
                this.adapter = new NavigationMenuAdapter();
            }
            int i = this.overScrollMode;
            if (i != -1) {
                this.menuView.setOverScrollMode(i);
            }
            this.headerLayout = (LinearLayout) this.layoutInflater.inflate((int) R.layout.design_navigation_item_header, (ViewGroup) this.menuView, false);
            this.menuView.setAdapter(this.adapter);
        }
        return this.menuView;
    }

    public void updateMenuView(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.update();
        }
    }

    public void setCallback(OO0o000.O000000o o000000o) {
        this.callback = o000000o;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        OO0o000.O000000o o000000o = this.callback;
        if (o000000o != null) {
            o000000o.O000000o(menuBuilder, z);
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.menuView != null) {
            SparseArray sparseArray = new SparseArray();
            this.menuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            bundle.putBundle("android:menu:adapter", navigationMenuAdapter.createInstanceState());
        }
        if (this.headerLayout != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.headerLayout.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.adapter.restoreInstanceState(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void setCheckedItem(OO0OOOO oo0oooo) {
        this.adapter.setCheckedItem(oo0oooo);
    }

    public OO0OOOO getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View inflateHeaderView(int i) {
        View inflate = this.layoutInflater.inflate(i, (ViewGroup) this.headerLayout, false);
        addHeaderView(inflate);
        return inflate;
    }

    public void addHeaderView(View view) {
        this.headerLayout.addView(view);
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void removeHeaderView(View view) {
        this.headerLayout.removeView(view);
        if (this.headerLayout.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, this.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int i) {
        return this.headerLayout.getChildAt(i);
    }

    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        updateMenuView(false);
    }

    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.textColor = colorStateList;
        updateMenuView(false);
    }

    public void setItemTextAppearance(int i) {
        this.textAppearance = i;
        this.textAppearanceSet = true;
        updateMenuView(false);
    }

    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public void setItemBackground(Drawable drawable) {
        this.itemBackground = drawable;
        updateMenuView(false);
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public void setItemHorizontalPadding(int i) {
        this.itemHorizontalPadding = i;
        updateMenuView(false);
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public void setItemIconPadding(int i) {
        this.itemIconPadding = i;
        updateMenuView(false);
    }

    public void setItemMaxLines(int i) {
        this.itemMaxLines = i;
        updateMenuView(false);
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    public void setItemIconSize(int i) {
        if (this.itemIconSize != i) {
            this.itemIconSize = i;
            this.hasCustomItemIconSize = true;
            updateMenuView(false);
        }
    }

    public void setUpdateSuspended(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.setUpdateSuspended(z);
        }
    }

    public void setBehindStatusBar(boolean z) {
        if (this.isBehindStatusBar != z) {
            this.isBehindStatusBar = z;
            updateTopPadding();
        }
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    private void updateTopPadding() {
        int i = (this.headerLayout.getChildCount() != 0 || !this.isBehindStatusBar) ? 0 : this.paddingTopDefault;
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
    }

    public void dispatchApplyWindowInsets(ci ciVar) {
        int O00000Oo = ciVar.O00000Oo();
        if (this.paddingTopDefault != O00000Oo) {
            this.paddingTopDefault = O00000Oo;
            updateTopPadding();
        }
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, ciVar.O00000o());
        cb.O00000Oo(this.headerLayout, ciVar);
    }

    public void setOverScrollMode(int i) {
        this.overScrollMode = i;
        NavigationMenuView navigationMenuView = this.menuView;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i);
        }
    }

    static abstract class ViewHolder extends RecyclerView.O000OOo0 {
        public ViewHolder(View view) {
            super(view);
        }
    }

    static class NormalViewHolder extends ViewHolder {
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public NormalViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate((int) R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    static class SubheaderViewHolder extends ViewHolder {
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public SubheaderViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate((int) R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    static class SeparatorViewHolder extends ViewHolder {
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public SeparatorViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate((int) R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    class NavigationMenuAdapter extends RecyclerView.O000000o<ViewHolder> {
        private OO0OOOO checkedItem;
        private final ArrayList<NavigationMenuItem> items = new ArrayList<>();
        private boolean updateSuspended;

        public long getItemId(int i) {
            return (long) i;
        }

        NavigationMenuAdapter() {
            prepareMenuItems();
        }

        public int getItemCount() {
            return this.items.size();
        }

        public int getItemViewType(int i) {
            NavigationMenuItem navigationMenuItem = this.items.get(i);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                return ((NavigationMenuTextItem) navigationMenuItem).getMenuItem().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new NormalViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup, NavigationMenuPresenter.this.onClickListener);
            }
            if (i == 1) {
                return new SubheaderViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            }
            if (i == 2) {
                return new SeparatorViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            }
            if (i != 3) {
                return null;
            }
            return new HeaderViewHolder(NavigationMenuPresenter.this.headerLayout);
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.itemView;
                navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.iconTintList);
                if (NavigationMenuPresenter.this.textAppearanceSet) {
                    navigationMenuItemView.setTextAppearance(NavigationMenuPresenter.this.textAppearance);
                }
                if (NavigationMenuPresenter.this.textColor != null) {
                    navigationMenuItemView.setTextColor(NavigationMenuPresenter.this.textColor);
                }
                cb.O000000o(navigationMenuItemView, NavigationMenuPresenter.this.itemBackground != null ? NavigationMenuPresenter.this.itemBackground.getConstantState().newDrawable() : null);
                NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.items.get(i);
                navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.needsEmptyIcon);
                navigationMenuItemView.setHorizontalPadding(NavigationMenuPresenter.this.itemHorizontalPadding);
                navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
                if (NavigationMenuPresenter.this.hasCustomItemIconSize) {
                    navigationMenuItemView.setIconSize(NavigationMenuPresenter.this.itemIconSize);
                }
                navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.itemMaxLines);
                navigationMenuItemView.initialize(navigationMenuTextItem.getMenuItem(), 0);
            } else if (itemViewType == 1) {
                ((TextView) viewHolder.itemView).setText(((NavigationMenuTextItem) this.items.get(i)).getMenuItem().getTitle());
            } else if (itemViewType == 2) {
                NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.items.get(i);
                viewHolder.itemView.setPadding(0, navigationMenuSeparatorItem.getPaddingTop(), 0, navigationMenuSeparatorItem.getPaddingBottom());
            }
        }

        public void onViewRecycled(ViewHolder viewHolder) {
            if (viewHolder instanceof NormalViewHolder) {
                ((NavigationMenuItemView) viewHolder.itemView).recycle();
            }
        }

        public void update() {
            prepareMenuItems();
            notifyDataSetChanged();
        }

        private void prepareMenuItems() {
            if (!this.updateSuspended) {
                this.updateSuspended = true;
                this.items.clear();
                this.items.add(new NavigationMenuHeaderItem());
                int size = NavigationMenuPresenter.this.menu.getVisibleItems().size();
                int i = -1;
                boolean z = false;
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    OO0OOOO oo0oooo = NavigationMenuPresenter.this.menu.getVisibleItems().get(i3);
                    if (oo0oooo.isChecked()) {
                        setCheckedItem(oo0oooo);
                    }
                    if (oo0oooo.isCheckable()) {
                        oo0oooo.O000000o(false);
                    }
                    if (oo0oooo.hasSubMenu()) {
                        SubMenu subMenu = oo0oooo.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.items.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, 0));
                            }
                            this.items.add(new NavigationMenuTextItem(oo0oooo));
                            int size2 = this.items.size();
                            int size3 = subMenu.size();
                            boolean z2 = false;
                            for (int i4 = 0; i4 < size3; i4++) {
                                OO0OOOO oo0oooo2 = (OO0OOOO) subMenu.getItem(i4);
                                if (oo0oooo2.isVisible()) {
                                    if (!z2 && oo0oooo2.getIcon() != null) {
                                        z2 = true;
                                    }
                                    if (oo0oooo2.isCheckable()) {
                                        oo0oooo2.O000000o(false);
                                    }
                                    if (oo0oooo.isChecked()) {
                                        setCheckedItem(oo0oooo);
                                    }
                                    this.items.add(new NavigationMenuTextItem(oo0oooo2));
                                }
                            }
                            if (z2) {
                                appendTransparentIconIfMissing(size2, this.items.size());
                            }
                        }
                    } else {
                        int groupId = oo0oooo.getGroupId();
                        if (groupId != i) {
                            i2 = this.items.size();
                            boolean z3 = oo0oooo.getIcon() != null;
                            if (i3 != 0) {
                                i2++;
                                this.items.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, NavigationMenuPresenter.this.paddingSeparator));
                            }
                            z = z3;
                        } else if (!z && oo0oooo.getIcon() != null) {
                            appendTransparentIconIfMissing(i2, this.items.size());
                            z = true;
                        }
                        NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(oo0oooo);
                        navigationMenuTextItem.needsEmptyIcon = z;
                        this.items.add(navigationMenuTextItem);
                        i = groupId;
                    }
                }
                this.updateSuspended = false;
            }
        }

        private void appendTransparentIconIfMissing(int i, int i2) {
            while (i < i2) {
                ((NavigationMenuTextItem) this.items.get(i)).needsEmptyIcon = true;
                i++;
            }
        }

        public void setCheckedItem(OO0OOOO oo0oooo) {
            if (this.checkedItem != oo0oooo && oo0oooo.isCheckable()) {
                OO0OOOO oo0oooo2 = this.checkedItem;
                if (oo0oooo2 != null) {
                    oo0oooo2.setChecked(false);
                }
                this.checkedItem = oo0oooo;
                oo0oooo.setChecked(true);
            }
        }

        public OO0OOOO getCheckedItem() {
            return this.checkedItem;
        }

        public Bundle createInstanceState() {
            Bundle bundle = new Bundle();
            OO0OOOO oo0oooo = this.checkedItem;
            if (oo0oooo != null) {
                bundle.putInt("android:menu:checked", oo0oooo.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.items.size();
            for (int i = 0; i < size; i++) {
                NavigationMenuItem navigationMenuItem = this.items.get(i);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    OO0OOOO menuItem = ((NavigationMenuTextItem) navigationMenuItem).getMenuItem();
                    View actionView = menuItem != null ? menuItem.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItem.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public void restoreInstanceState(Bundle bundle) {
            OO0OOOO menuItem;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            OO0OOOO menuItem2;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.updateSuspended = true;
                int size = this.items.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    NavigationMenuItem navigationMenuItem = this.items.get(i2);
                    if ((navigationMenuItem instanceof NavigationMenuTextItem) && (menuItem2 = ((NavigationMenuTextItem) navigationMenuItem).getMenuItem()) != null && menuItem2.getItemId() == i) {
                        setCheckedItem(menuItem2);
                        break;
                    }
                    i2++;
                }
                this.updateSuspended = false;
                prepareMenuItems();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.items.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    NavigationMenuItem navigationMenuItem2 = this.items.get(i3);
                    if (!(!(navigationMenuItem2 instanceof NavigationMenuTextItem) || (menuItem = ((NavigationMenuTextItem) navigationMenuItem2).getMenuItem()) == null || (actionView = menuItem.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(menuItem.getItemId())) == null)) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void setUpdateSuspended(boolean z) {
            this.updateSuspended = z;
        }

        /* access modifiers changed from: package-private */
        public int getRowCount() {
            int i = NavigationMenuPresenter.this.headerLayout.getChildCount() == 0 ? 0 : 1;
            for (int i2 = 0; i2 < NavigationMenuPresenter.this.adapter.getItemCount(); i2++) {
                if (NavigationMenuPresenter.this.adapter.getItemViewType(i2) == 0) {
                    i++;
                }
            }
            return i;
        }
    }

    static class NavigationMenuTextItem implements NavigationMenuItem {
        private final OO0OOOO menuItem;
        boolean needsEmptyIcon;

        NavigationMenuTextItem(OO0OOOO oo0oooo) {
            this.menuItem = oo0oooo;
        }

        public OO0OOOO getMenuItem() {
            return this.menuItem;
        }
    }

    static class NavigationMenuSeparatorItem implements NavigationMenuItem {
        private final int paddingBottom;
        private final int paddingTop;

        public NavigationMenuSeparatorItem(int i, int i2) {
            this.paddingTop = i;
            this.paddingBottom = i2;
        }

        public int getPaddingTop() {
            return this.paddingTop;
        }

        public int getPaddingBottom() {
            return this.paddingBottom;
        }
    }

    static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    class NavigationMenuViewAccessibilityDelegate extends hb {
        NavigationMenuViewAccessibilityDelegate(RecyclerView recyclerView) {
            super(recyclerView);
        }

        public void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            cl.O00000Oo o00000Oo;
            super.onInitializeAccessibilityNodeInfo(view, clVar);
            int rowCount = NavigationMenuPresenter.this.adapter.getRowCount();
            if (Build.VERSION.SDK_INT >= 19) {
                o00000Oo = new cl.O00000Oo(AccessibilityNodeInfo.CollectionInfo.obtain(rowCount, 0, false));
            } else {
                o00000Oo = new cl.O00000Oo(null);
            }
            clVar.O000000o(o00000Oo);
        }
    }
}
