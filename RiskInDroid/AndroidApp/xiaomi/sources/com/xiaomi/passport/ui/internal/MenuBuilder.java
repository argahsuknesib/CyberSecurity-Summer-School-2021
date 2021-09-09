package com.xiaomi.passport.ui.internal;

import _m_j.egn;
import _m_j.ego;
import _m_j.eid;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder implements Menu {
    private static final int[] O0000OOo = {1, 4, 5, 3, 2, 0};

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f6247O000000o;
    public final Resources O00000Oo;
    public boolean O00000o;
    public ArrayList<egn> O00000o0;
    CharSequence O00000oO;
    Drawable O00000oo;
    View O0000O0o;
    private boolean O0000Oo;
    private boolean O0000Oo0;
    private O000000o O0000OoO;
    private ArrayList<egn> O0000Ooo;
    private ContextMenu.ContextMenuInfo O0000o;
    private ArrayList<egn> O0000o0;
    private ArrayList<egn> O0000o00;
    private boolean O0000o0O;
    private int O0000o0o = 0;
    private boolean O0000oO = false;
    private boolean O0000oO0 = false;
    private boolean O0000oOO = false;
    private boolean O0000oOo = false;
    private CopyOnWriteArrayList<WeakReference<ego>> O0000oo = new CopyOnWriteArrayList<>();
    private ArrayList<egn> O0000oo0 = new ArrayList<>();
    private egn O0000ooO;

    public interface O000000o {
        boolean O000000o(MenuItem menuItem);
    }

    public MenuBuilder O00000o0() {
        return this;
    }

    public MenuBuilder(Context context) {
        this.f6247O000000o = context;
        this.O00000Oo = context.getResources();
        this.O00000o0 = new ArrayList<>();
        this.O0000Ooo = new ArrayList<>();
        boolean z = true;
        this.O00000o = true;
        this.O0000o00 = new ArrayList<>();
        this.O0000o0 = new ArrayList<>();
        this.O0000o0O = true;
        this.O0000Oo = (this.O00000Oo.getConfiguration().keyboard == 1 || !this.O00000Oo.getBoolean(R.bool.passport_abc_config_showMenuShortcutsWhenKeyboardPresent)) ? false : z;
    }

    private void O00000o() {
        if (!this.O0000oo.isEmpty()) {
            O0000O0o();
            Iterator<WeakReference<ego>> it = this.O0000oo.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                if (((ego) next.get()) == null) {
                    this.O0000oo.remove(next);
                }
            }
            O0000OOo();
        }
    }

    private boolean O00000oO() {
        boolean z = false;
        if (this.O0000oo.isEmpty()) {
            return false;
        }
        Iterator<WeakReference<ego>> it = this.O0000oo.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            ego ego = (ego) next.get();
            if (ego == null) {
                this.O0000oo.remove(next);
            } else if (!z) {
                z = ego.O000000o();
            }
        }
        return z;
    }

    public void O000000o(O000000o o000000o) {
        this.O0000OoO = o000000o;
    }

    public MenuItem add(CharSequence charSequence) {
        return O000000o(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return O000000o(0, 0, 0, this.O00000Oo.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return O000000o(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return O000000o(i, i2, i3, this.O00000Oo.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.O00000Oo.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        egn egn = (egn) O000000o(i, i2, i3, charSequence);
        eid eid = new eid(this.f6247O000000o, this, egn);
        egn.O000000o(eid);
        return eid;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.O00000Oo.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f6247O000000o.getPackageManager();
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

    private void O000000o(int i, boolean z) {
        if (i >= 0 && i < this.O00000o0.size()) {
            this.O00000o0.remove(i);
            if (z) {
                O000000o(true);
            }
        }
    }

    public void clear() {
        egn egn = this.O0000ooO;
        if (egn != null) {
            O00000Oo(egn);
        }
        this.O00000o0.clear();
        O000000o(true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        Iterator<egn> it = this.O00000o0.iterator();
        while (it.hasNext()) {
            egn next = it.next();
            if (next.getGroupId() == i) {
                next.O00000o0 = (next.O00000o0 & -5) | (z2 ? 4 : 0);
                next.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        Iterator<egn> it = this.O00000o0.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            egn next = it.next();
            if (next.getGroupId() == i && next.O000000o(z)) {
                z2 = true;
            }
        }
        if (z2) {
            O000000o(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        Iterator<egn> it = this.O00000o0.iterator();
        while (it.hasNext()) {
            egn next = it.next();
            if (next.getGroupId() == i) {
                next.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.O00000o0.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            egn egn = this.O00000o0.get(i2);
            if (egn.getItemId() == i) {
                return egn;
            }
            if (egn.hasSubMenu() && (findItem = egn.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int size() {
        return this.O00000o0.size();
    }

    public MenuItem getItem(int i) {
        return this.O00000o0.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return O000000o(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.O0000Oo0 = z;
        O000000o(false);
    }

    /* access modifiers changed from: protected */
    public boolean O000000o() {
        return this.O0000Oo0;
    }

    public boolean O000000o(MenuBuilder menuBuilder, MenuItem menuItem) {
        O000000o o000000o = this.O0000OoO;
        if (o000000o == null) {
            return false;
        }
        o000000o.O000000o(menuItem);
        return true;
    }

    private static int O000000o(ArrayList<egn> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f15251O000000o <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        egn O000000o2 = O000000o(i, keyEvent);
        boolean O000000o3 = O000000o2 != null ? O000000o(O000000o2, i2) : false;
        if ((i2 & 2) != 0) {
            O00000oo();
        }
        return O000000o3;
    }

    private void O000000o(List<egn> list, int i, KeyEvent keyEvent) {
        char c;
        boolean O000000o2 = O000000o();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            Iterator<egn> it = this.O00000o0.iterator();
            while (it.hasNext()) {
                egn next = it.next();
                if (next.hasSubMenu()) {
                    ((MenuBuilder) next.getSubMenu()).O000000o(list, i, keyEvent);
                }
                if (O000000o2) {
                    c = next.getAlphabeticShortcut();
                } else {
                    c = next.getNumericShortcut();
                }
                if ((metaState & 5) == 0 && c != 0) {
                    if ((c == keyData.meta[0] || c == keyData.meta[2] || (O000000o2 && c == 8 && i == 67)) && next.isEnabled()) {
                        list.add(next);
                    }
                }
            }
        }
    }

    private egn O000000o(int i, KeyEvent keyEvent) {
        char c;
        ArrayList<egn> arrayList = this.O0000oo0;
        arrayList.clear();
        O000000o(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        if (arrayList.size() == 1) {
            return arrayList.get(0);
        }
        boolean O000000o2 = O000000o();
        Iterator<egn> it = arrayList.iterator();
        while (it.hasNext()) {
            egn next = it.next();
            if (O000000o2) {
                c = next.getAlphabeticShortcut();
            } else {
                c = next.getNumericShortcut();
            }
            if ((c == keyData.meta[0] && (metaState & 2) == 0) || ((c == keyData.meta[2] && (metaState & 2) != 0) || (O000000o2 && c == 8 && i == 67))) {
                return next;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return O000000o(findItem(i), i2);
    }

    private boolean O000000o(MenuItem menuItem, int i) {
        egn egn = (egn) menuItem;
        boolean z = false;
        if (egn == null || !egn.isEnabled()) {
            return false;
        }
        boolean O000000o2 = egn.O000000o();
        ActionProvider actionProvider = egn.O00000o;
        if (actionProvider != null && actionProvider.hasSubMenu()) {
            z = true;
        }
        if (egn.O00000Oo()) {
            O000000o2 |= egn.expandActionView();
            if (O000000o2) {
                O00000oo();
            }
        } else if (egn.hasSubMenu() || z) {
            O00000oo();
            if (!egn.hasSubMenu()) {
                egn.O000000o(new eid(this.f6247O000000o, this, egn));
            }
            eid eid = (eid) egn.getSubMenu();
            if (z) {
                actionProvider.onPrepareSubMenu(eid);
            }
            O000000o2 |= O00000oO();
            if (!O000000o2) {
                O00000oo();
            }
        } else if ((i & 1) == 0) {
            O00000oo();
        }
        return O000000o2;
    }

    private void O00000oo() {
        if (!this.O0000oOo) {
            this.O0000oOo = true;
            Iterator<WeakReference<ego>> it = this.O0000oo.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                if (((ego) next.get()) == null) {
                    this.O0000oo.remove(next);
                }
            }
            this.O0000oOo = false;
        }
    }

    public void close() {
        O00000oo();
    }

    public final void O000000o(boolean z) {
        if (!this.O0000oO0) {
            if (z) {
                this.O00000o = true;
                this.O0000o0O = true;
            }
            O00000o();
            return;
        }
        this.O0000oO = true;
    }

    private void O0000O0o() {
        if (!this.O0000oO0) {
            this.O0000oO0 = true;
            this.O0000oO = false;
        }
    }

    private void O0000OOo() {
        this.O0000oO0 = false;
        if (this.O0000oO) {
            this.O0000oO = false;
            O000000o(true);
        }
    }

    public final void O00000Oo() {
        this.O0000o0O = true;
        O000000o(true);
    }

    public void clearHeader() {
        this.O00000oo = null;
        this.O00000oO = null;
        this.O0000O0o = null;
        O000000o(false);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(CharSequence charSequence, Drawable drawable, View view) {
        if (view != null) {
            this.O0000O0o = view;
            this.O00000oO = null;
            this.O00000oo = null;
        } else {
            if (charSequence != null) {
                this.O00000oO = charSequence;
            }
            if (drawable != null) {
                this.O00000oo = drawable;
            }
            this.O0000O0o = null;
        }
        O000000o(false);
    }

    /* access modifiers changed from: protected */
    public final MenuBuilder O000000o(CharSequence charSequence) {
        O000000o(charSequence, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public final MenuBuilder O000000o(Drawable drawable) {
        O000000o((CharSequence) null, drawable, (View) null);
        return this;
    }

    public boolean O000000o(egn egn) {
        boolean z = false;
        if (this.O0000oo.isEmpty()) {
            return false;
        }
        O0000O0o();
        Iterator<WeakReference<ego>> it = this.O0000oo.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            ego ego = (ego) next.get();
            if (ego == null) {
                this.O0000oo.remove(next);
            } else {
                z = ego.O00000Oo();
                if (z) {
                    break;
                }
            }
        }
        O0000OOo();
        if (z) {
            this.O0000ooO = egn;
        }
        return z;
    }

    public boolean O00000Oo(egn egn) {
        boolean z = false;
        if (!this.O0000oo.isEmpty() && this.O0000ooO == egn) {
            O0000O0o();
            Iterator<WeakReference<ego>> it = this.O0000oo.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                ego ego = (ego) next.get();
                if (ego == null) {
                    this.O0000oo.remove(next);
                } else {
                    z = ego.O00000o0();
                    if (z) {
                        break;
                    }
                }
            }
            O0000OOo();
            if (z) {
                this.O0000ooO = null;
            }
        }
        return z;
    }

    private MenuItem O000000o(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = (-65536 & i3) >> 16;
        if (i4 >= 0) {
            int[] iArr = O0000OOo;
            if (i4 < iArr.length) {
                int i5 = (iArr[i4] << 16) | (65535 & i3);
                egn egn = new egn(this, i, i2, i3, i5, charSequence, this.O0000o0o);
                ContextMenu.ContextMenuInfo contextMenuInfo = this.O0000o;
                if (contextMenuInfo != null) {
                    egn.O00000oO = contextMenuInfo;
                }
                ArrayList<egn> arrayList = this.O00000o0;
                arrayList.add(O000000o(arrayList, i5), egn);
                O000000o(true);
                return egn;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(java.util.ArrayList<_m_j.egn>, int):int
      com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(int, android.view.KeyEvent):_m_j.egn
      com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(android.view.MenuItem, int):boolean
      com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(com.xiaomi.passport.ui.internal.MenuBuilder, android.view.MenuItem):boolean
      com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(int, boolean):void */
    public void removeItem(int i) {
        int size = size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.O00000o0.get(i2).getItemId() == i) {
                break;
            } else {
                i2++;
            }
        }
        O000000o(i2, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(java.util.ArrayList<_m_j.egn>, int):int
      com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(int, android.view.KeyEvent):_m_j.egn
      com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(android.view.MenuItem, int):boolean
      com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(com.xiaomi.passport.ui.internal.MenuBuilder, android.view.MenuItem):boolean
      com.xiaomi.passport.ui.internal.MenuBuilder.O000000o(int, boolean):void */
    public void removeGroup(int i) {
        int size = size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.O00000o0.get(i2).getGroupId() == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int size2 = this.O00000o0.size() - i2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size2 || this.O00000o0.get(i2).getGroupId() != i) {
                    O000000o(true);
                } else {
                    O000000o(i2, false);
                    i3 = i4;
                }
            }
            O000000o(true);
        }
    }
}
