package androidx.appcompat.view.menu;

import _m_j.OO0OOOO;
import _m_j.OO0o000;
import _m_j.OOO00O0;
import _m_j.ah;
import _m_j.cc;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.core.view.ActionProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder implements ah {
    private static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    private ArrayList<OO0OOOO> mActionItems;
    private O000000o mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction = 0;
    private OO0OOOO mExpandedItem;
    private boolean mGroupDividerEnabled = false;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing = false;
    private boolean mIsVisibleItemsStale;
    private ArrayList<OO0OOOO> mItems;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private ArrayList<OO0OOOO> mNonActionItems;
    private boolean mOptionalIconsVisible = false;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList<WeakReference<OO0o000>> mPresenters = new CopyOnWriteArrayList<>();
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private ArrayList<OO0OOOO> mTempShortcutItemList = new ArrayList<>();
    private ArrayList<OO0OOOO> mVisibleItems;

    public interface O000000o {
        boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder menuBuilder);
    }

    public interface O00000Oo {
        boolean O000000o(OO0OOOO oo0oooo);
    }

    /* access modifiers changed from: protected */
    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public MenuBuilder(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        this.mItems = new ArrayList<>();
        this.mVisibleItems = new ArrayList<>();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList<>();
        this.mNonActionItems = new ArrayList<>();
        this.mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
    }

    public MenuBuilder setDefaultShowAsAction(int i) {
        this.mDefaultShowAsAction = i;
        return this;
    }

    public void addMenuPresenter(OO0o000 oO0o000) {
        addMenuPresenter(oO0o000, this.mContext);
    }

    public void addMenuPresenter(OO0o000 oO0o000, Context context) {
        this.mPresenters.add(new WeakReference(oO0o000));
        oO0o000.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    public void removeMenuPresenter(OO0o000 oO0o000) {
        Iterator<WeakReference<OO0o000>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            OO0o000 oO0o0002 = (OO0o000) next.get();
            if (oO0o0002 == null || oO0o0002 == oO0o000) {
                this.mPresenters.remove(next);
            }
        }
    }

    private void dispatchPresenterUpdate(boolean z) {
        if (!this.mPresenters.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<OO0o000>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                OO0o000 oO0o000 = (OO0o000) next.get();
                if (oO0o000 == null) {
                    this.mPresenters.remove(next);
                } else {
                    oO0o000.updateMenuView(z);
                }
            }
            startDispatchingItemsChanged();
        }
    }

    private boolean dispatchSubMenuSelected(OOO00O0 ooo00o0, OO0o000 oO0o000) {
        boolean z = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        if (oO0o000 != null) {
            z = oO0o000.onSubMenuSelected(ooo00o0);
        }
        Iterator<WeakReference<OO0o000>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            OO0o000 oO0o0002 = (OO0o000) next.get();
            if (oO0o0002 == null) {
                this.mPresenters.remove(next);
            } else if (!z) {
                z = oO0o0002.onSubMenuSelected(ooo00o0);
            }
        }
        return z;
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.mPresenters.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<OO0o000>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                OO0o000 oO0o000 = (OO0o000) next.get();
                if (oO0o000 == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id = oO0o000.getId();
                    if (id > 0 && (onSaveInstanceState = oO0o000.onSaveInstanceState()) != null) {
                        sparseArray.put(id, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.mPresenters.isEmpty()) {
            Iterator<WeakReference<OO0o000>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                OO0o000 oO0o000 = (OO0o000) next.get();
                if (oO0o000 == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id = oO0o000.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        oO0o000.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    public void savePresenterStates(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void restorePresenterStates(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((OOO00O0) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((OOO00O0) item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void setCallback(O000000o o000000o) {
        this.mCallback = o000000o;
    }

    /* access modifiers changed from: protected */
    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        int ordering = getOrdering(i3);
        OO0OOOO createNewMenuItem = createNewMenuItem(i, i2, i3, ordering, charSequence, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
        if (contextMenuInfo != null) {
            createNewMenuItem.O0000O0o = contextMenuInfo;
        }
        ArrayList<OO0OOOO> arrayList = this.mItems;
        arrayList.add(findInsertIndex(arrayList, ordering), createNewMenuItem);
        onItemsChanged(true);
        return createNewMenuItem;
    }

    private OO0OOOO createNewMenuItem(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new OO0OOOO(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return addInternal(0, 0, 0, this.mResources.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return addInternal(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return addInternal(i, i2, i3, this.mResources.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        OO0OOOO oo0oooo = (OO0OOOO) addInternal(i, i2, i3, charSequence);
        OOO00O0 ooo00o0 = new OOO00O0(this.mContext, this, oo0oooo);
        oo0oooo.O000000o(ooo00o0);
        return ooo00o0;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.mResources.getString(i4));
    }

    public void setGroupDividerEnabled(boolean z) {
        this.mGroupDividerEnabled = z;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        removeItemAtInt(findItemIndex(i), true);
    }

    public void removeGroup(int i) {
        int findGroupIndex = findGroupIndex(i);
        if (findGroupIndex >= 0) {
            int size = this.mItems.size() - findGroupIndex;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.mItems.get(findGroupIndex).getGroupId() != i) {
                    onItemsChanged(true);
                } else {
                    removeItemAtInt(findGroupIndex, false);
                    i2 = i3;
                }
            }
            onItemsChanged(true);
        }
    }

    private void removeItemAtInt(int i, boolean z) {
        if (i >= 0 && i < this.mItems.size()) {
            this.mItems.remove(i);
            if (z) {
                onItemsChanged(true);
            }
        }
    }

    public void removeItemAt(int i) {
        removeItemAtInt(i, true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clear() {
        OO0OOOO oo0oooo = this.mExpandedItem;
        if (oo0oooo != null) {
            collapseItemActionView(oo0oooo);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public void setExclusiveItemChecked(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        stopDispatchingItemsChanged();
        for (int i = 0; i < size; i++) {
            OO0OOOO oo0oooo = this.mItems.get(i);
            if (oo0oooo.getGroupId() == groupId && oo0oooo.O00000oO() && oo0oooo.isCheckable()) {
                oo0oooo.O00000Oo(oo0oooo == menuItem);
            }
        }
        startDispatchingItemsChanged();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            OO0OOOO oo0oooo = this.mItems.get(i2);
            if (oo0oooo.getGroupId() == i) {
                oo0oooo.O000000o(z2);
                oo0oooo.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.mItems.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            OO0OOOO oo0oooo = this.mItems.get(i2);
            if (oo0oooo.getGroupId() == i && oo0oooo.O00000o0(z)) {
                z2 = true;
            }
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            OO0OOOO oo0oooo = this.mItems.get(i2);
            if (oo0oooo.getGroupId() == i) {
                oo0oooo.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.mItems.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            OO0OOOO oo0oooo = this.mItems.get(i2);
            if (oo0oooo.getItemId() == i) {
                return oo0oooo;
            }
            if (oo0oooo.hasSubMenu() && (findItem = oo0oooo.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mItems.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int findGroupIndex(int i) {
        return findGroupIndex(i, 0);
    }

    public int findGroupIndex(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.mItems.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int size() {
        return this.mItems.size();
    }

    public MenuItem getItem(int i) {
        return this.mItems.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return findItemWithShortcutForKey(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.mQwertyMode = z;
        onItemsChanged(false);
    }

    private static int getOrdering(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = sCategoryToOrder;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public void setShortcutsVisible(boolean z) {
        if (this.mShortcutsVisible != z) {
            setShortcutsVisibleInner(z);
            onItemsChanged(false);
        }
    }

    private void setShortcutsVisibleInner(boolean z) {
        boolean z2 = true;
        if (!z || this.mResources.getConfiguration().keyboard == 1 || !cc.O00000o0(ViewConfiguration.get(this.mContext), this.mContext)) {
            z2 = false;
        }
        this.mShortcutsVisible = z2;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    /* access modifiers changed from: package-private */
    public Resources getResources() {
        return this.mResources;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dispatchMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        O000000o o000000o = this.mCallback;
        return o000000o != null && o000000o.onMenuItemSelected(menuBuilder, menuItem);
    }

    public void changeMenuMode() {
        O000000o o000000o = this.mCallback;
        if (o000000o != null) {
            o000000o.onMenuModeChange(this);
        }
    }

    private static int findInsertIndex(ArrayList<OO0OOOO> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f12299O000000o <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        OO0OOOO findItemWithShortcutForKey = findItemWithShortcutForKey(i, keyEvent);
        boolean performItemAction = findItemWithShortcutForKey != null ? performItemAction(findItemWithShortcutForKey, i2) : false;
        if ((i2 & 2) != 0) {
            close(true);
        }
        return performItemAction;
    }

    /* access modifiers changed from: package-private */
    public void findItemsWithShortcutForKey(List<OO0OOOO> list, int i, KeyEvent keyEvent) {
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.mItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                OO0OOOO oo0oooo = this.mItems.get(i2);
                if (oo0oooo.hasSubMenu()) {
                    ((MenuBuilder) oo0oooo.getSubMenu()).findItemsWithShortcutForKey(list, i, keyEvent);
                }
                char alphabeticShortcut = isQwertyMode ? oo0oooo.getAlphabeticShortcut() : oo0oooo.getNumericShortcut();
                if (((modifiers & 69647) == ((isQwertyMode ? oo0oooo.getAlphabeticModifiers() : oo0oooo.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (isQwertyMode && alphabeticShortcut == 8 && i == 67)) && oo0oooo.isEnabled())) {
                    list.add(oo0oooo);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public OO0OOOO findItemWithShortcutForKey(int i, KeyEvent keyEvent) {
        char c;
        ArrayList<OO0OOOO> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i2 = 0; i2 < size; i2++) {
            OO0OOOO oo0oooo = arrayList.get(i2);
            if (isQwertyMode) {
                c = oo0oooo.getAlphabeticShortcut();
            } else {
                c = oo0oooo.getNumericShortcut();
            }
            if ((c == keyData.meta[0] && (metaState & 2) == 0) || ((c == keyData.meta[2] && (metaState & 2) != 0) || (isQwertyMode && c == 8 && i == 67))) {
                return oo0oooo;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return performItemAction(findItem(i), i2);
    }

    public boolean performItemAction(MenuItem menuItem, int i) {
        return performItemAction(menuItem, null, i);
    }

    public boolean performItemAction(MenuItem menuItem, OO0o000 oO0o000, int i) {
        OO0OOOO oo0oooo = (OO0OOOO) menuItem;
        if (oo0oooo == null || !oo0oooo.isEnabled()) {
            return false;
        }
        boolean O00000Oo2 = oo0oooo.O00000Oo();
        ActionProvider actionProvider = oo0oooo.O00000oo;
        boolean z = actionProvider != null && actionProvider.O00000o0();
        if (oo0oooo.O0000Oo0()) {
            O00000Oo2 |= oo0oooo.expandActionView();
            if (O00000Oo2) {
                close(true);
            }
        } else if (oo0oooo.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                close(false);
            }
            if (!oo0oooo.hasSubMenu()) {
                oo0oooo.O000000o(new OOO00O0(getContext(), this, oo0oooo));
            }
            OOO00O0 ooo00o0 = (OOO00O0) oo0oooo.getSubMenu();
            if (z) {
                actionProvider.O000000o(ooo00o0);
            }
            O00000Oo2 |= dispatchSubMenuSelected(ooo00o0, oO0o000);
            if (!O00000Oo2) {
                close(true);
            }
        } else if ((i & 1) == 0) {
            close(true);
        }
        return O00000Oo2;
    }

    public final void close(boolean z) {
        if (!this.mIsClosing) {
            this.mIsClosing = true;
            Iterator<WeakReference<OO0o000>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                OO0o000 oO0o000 = (OO0o000) next.get();
                if (oO0o000 == null) {
                    this.mPresenters.remove(next);
                } else {
                    oO0o000.onCloseMenu(this, z);
                }
            }
            this.mIsClosing = false;
        }
    }

    public void close() {
        close(true);
    }

    public void onItemsChanged(boolean z) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            dispatchPresenterUpdate(z);
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    public void stopDispatchingItemsChanged() {
        if (!this.mPreventDispatchingItemsChanged) {
            this.mPreventDispatchingItemsChanged = true;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
        }
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public void onItemVisibleChanged(OO0OOOO oo0oooo) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemActionRequestChanged(OO0OOOO oo0oooo) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    public ArrayList<OO0OOOO> getVisibleItems() {
        if (!this.mIsVisibleItemsStale) {
            return this.mVisibleItems;
        }
        this.mVisibleItems.clear();
        int size = this.mItems.size();
        for (int i = 0; i < size; i++) {
            OO0OOOO oo0oooo = this.mItems.get(i);
            if (oo0oooo.isVisible()) {
                this.mVisibleItems.add(oo0oooo);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    public void flagActionItems() {
        ArrayList<OO0OOOO> visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            Iterator<WeakReference<OO0o000>> it = this.mPresenters.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                OO0o000 oO0o000 = (OO0o000) next.get();
                if (oO0o000 == null) {
                    this.mPresenters.remove(next);
                } else {
                    z |= oO0o000.flagActionItems();
                }
            }
            if (z) {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                int size = visibleItems.size();
                for (int i = 0; i < size; i++) {
                    OO0OOOO oo0oooo = visibleItems.get(i);
                    if (oo0oooo.O00000oo()) {
                        this.mActionItems.add(oo0oooo);
                    } else {
                        this.mNonActionItems.add(oo0oooo);
                    }
                }
            } else {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                this.mNonActionItems.addAll(getVisibleItems());
            }
            this.mIsActionItemsStale = false;
        }
    }

    public ArrayList<OO0OOOO> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    public ArrayList<OO0OOOO> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    private void setHeaderInternal(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i > 0) {
                this.mHeaderTitle = resources.getText(i);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i2 > 0) {
                this.mHeaderIcon = ContextCompat.O000000o(getContext(), i2);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        setHeaderInternal(0, charSequence, 0, null, null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(int i) {
        setHeaderInternal(i, null, 0, null, null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(Drawable drawable) {
        setHeaderInternal(0, null, 0, drawable, null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(int i) {
        setHeaderInternal(0, null, i, null, null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderViewInt(View view) {
        setHeaderInternal(0, null, 0, null, view);
        return this;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public void setOptionalIconsVisible(boolean z) {
        this.mOptionalIconsVisible = z;
    }

    /* access modifiers changed from: package-private */
    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public boolean expandItemActionView(OO0OOOO oo0oooo) {
        boolean z = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<OO0o000>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            OO0o000 oO0o000 = (OO0o000) next.get();
            if (oO0o000 == null) {
                this.mPresenters.remove(next);
            } else {
                z = oO0o000.expandItemActionView(this, oo0oooo);
                if (z) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z) {
            this.mExpandedItem = oo0oooo;
        }
        return z;
    }

    public boolean collapseItemActionView(OO0OOOO oo0oooo) {
        boolean z = false;
        if (!this.mPresenters.isEmpty() && this.mExpandedItem == oo0oooo) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<OO0o000>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                OO0o000 oO0o000 = (OO0o000) next.get();
                if (oO0o000 == null) {
                    this.mPresenters.remove(next);
                } else {
                    z = oO0o000.collapseItemActionView(this, oo0oooo);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.mExpandedItem = null;
            }
        }
        return z;
    }

    public OO0OOOO getExpandedItem() {
        return this.mExpandedItem;
    }

    public void setOverrideVisibleItems(boolean z) {
        this.mOverrideVisibleItems = z;
    }
}
