package _m_j;

import android.content.Context;
import android.os.Parcelable;
import androidx.appcompat.view.menu.MenuBuilder;

public interface OO0o000 {

    public interface O000000o {
        void O000000o(MenuBuilder menuBuilder, boolean z);

        boolean O000000o(MenuBuilder menuBuilder);
    }

    boolean collapseItemActionView(MenuBuilder menuBuilder, OO0OOOO oo0oooo);

    boolean expandItemActionView(MenuBuilder menuBuilder, OO0OOOO oo0oooo);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, MenuBuilder menuBuilder);

    void onCloseMenu(MenuBuilder menuBuilder, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(OOO00O0 ooo00o0);

    void setCallback(O000000o o000000o);

    void updateMenuView(boolean z);
}
