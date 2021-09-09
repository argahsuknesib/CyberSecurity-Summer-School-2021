package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class OO0o0 extends OO0O0OO implements Menu {
    private final ah O00000o;

    public OO0o0(Context context, ah ahVar) {
        super(context);
        if (ahVar != null) {
            this.O00000o = ahVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return O000000o(this.O00000o.add(charSequence));
    }

    public MenuItem add(int i) {
        return O000000o(this.O00000o.add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return O000000o(this.O00000o.add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return O000000o(this.O00000o.add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return O000000o(this.O00000o.addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return O000000o(this.O00000o.addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return O000000o(this.O00000o.addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return O000000o(this.O00000o.addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.O00000o.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr2[i5] = O000000o(menuItemArr3[i5]);
            }
        }
        return addIntentOptions;
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.O00000o.setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        this.O00000o.setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        this.O00000o.setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return this.O00000o.hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return O000000o(this.O00000o.findItem(i));
    }

    public int size() {
        return this.O00000o.size();
    }

    public MenuItem getItem(int i) {
        return O000000o(this.O00000o.getItem(i));
    }

    public void close() {
        this.O00000o.close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.O00000o.performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.O00000o.isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return this.O00000o.performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        this.O00000o.setQwertyMode(z);
    }

    public void removeItem(int i) {
        if (this.O00000Oo != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.O00000Oo.size()) {
                    break;
                } else if (this.O00000Oo.O00000Oo(i2).getItemId() == i) {
                    this.O00000Oo.O00000o(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.O00000o.removeItem(i);
    }

    public void removeGroup(int i) {
        if (this.O00000Oo != null) {
            int i2 = 0;
            while (i2 < this.O00000Oo.size()) {
                if (this.O00000Oo.O00000Oo(i2).getGroupId() == i) {
                    this.O00000Oo.O00000o(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.O00000o.removeGroup(i);
    }

    public void clear() {
        if (this.O00000Oo != null) {
            this.O00000Oo.clear();
        }
        if (this.O00000o0 != null) {
            this.O00000o0.clear();
        }
        this.O00000o.clear();
    }
}
