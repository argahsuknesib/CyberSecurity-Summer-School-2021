package com.google.android.material.bottomnavigation;

import _m_j.OO0OOOO;
import _m_j.OO0o00;
import _m_j.OO0o000;
import _m_j.OOO00O0;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

public class BottomNavigationPresenter implements OO0o000 {
    private int id;
    private MenuBuilder menu;
    private BottomNavigationMenuView menuView;
    private boolean updateSuspended = false;

    public boolean collapseItemActionView(MenuBuilder menuBuilder, OO0OOOO oo0oooo) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, OO0OOOO oo0oooo) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public boolean onSubMenuSelected(OOO00O0 ooo00o0) {
        return false;
    }

    public void setCallback(OO0o000.O000000o o000000o) {
    }

    public void setBottomNavigationMenuView(BottomNavigationMenuView bottomNavigationMenuView) {
        this.menuView = bottomNavigationMenuView;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
        this.menuView.initialize(this.menu);
    }

    public OO0o00 getMenuView(ViewGroup viewGroup) {
        return this.menuView;
    }

    public void updateMenuView(boolean z) {
        if (!this.updateSuspended) {
            if (z) {
                this.menuView.buildMenuView();
            } else {
                this.menuView.updateMenuView();
            }
        }
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        savedState.badgeSavedStates = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.menuView.tryRestoreSelectedItemId(savedState.selectedItemId);
            this.menuView.setBadgeDrawables(BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), savedState.badgeSavedStates));
        }
    }

    public void setUpdateSuspended(boolean z) {
        this.updateSuspended = z;
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState.AnonymousClass1 */

            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ParcelableSparseArray badgeSavedStates;
        int selectedItemId;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.selectedItemId = parcel.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.selectedItemId);
            parcel.writeParcelable(this.badgeSavedStates, 0);
        }
    }
}
