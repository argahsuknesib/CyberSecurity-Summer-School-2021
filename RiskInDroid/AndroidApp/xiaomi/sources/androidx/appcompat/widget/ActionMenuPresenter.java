package androidx.appcompat.widget;

import _m_j.OO00O0;
import _m_j.OO0OOOO;
import _m_j.OO0Oo0;
import _m_j.OO0o;
import _m_j.OO0o00;
import _m_j.OO0o000;
import _m_j.OOO00O0;
import _m_j.OOOo00;
import _m_j.ab;
import _m_j.o000000;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ActionProvider;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.O000000o {
    Drawable O0000Oo;
    OverflowMenuButton O0000Oo0;
    boolean O0000OoO;
    boolean O0000Ooo;
    int O0000o;
    O000000o O0000o0;
    O00000o O0000o00;
    O00000o0 O0000o0O;
    final O0000O0o O0000o0o = new O0000O0o();
    private boolean O0000oO;
    private boolean O0000oO0;
    private int O0000oOO;
    private int O0000oOo;
    private boolean O0000oo;
    private int O0000oo0;
    private boolean O0000ooO;
    private boolean O0000ooo;
    private O00000Oo O000O00o;
    private int O00oOooO;
    private final SparseBooleanArray O00oOooo = new SparseBooleanArray();

    public ActionMenuPresenter(Context context) {
        super(context);
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        OO00O0 O000000o2 = OO00O0.O000000o(context);
        if (!this.O0000oO) {
            boolean z = true;
            if (Build.VERSION.SDK_INT < 19 && ViewConfiguration.get(O000000o2.f6713O000000o).hasPermanentMenuKey()) {
                z = false;
            }
            this.O0000oO0 = z;
        }
        if (!this.O0000ooo) {
            this.O0000oOO = O000000o2.f6713O000000o.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.O0000oo) {
            this.O0000oo0 = O000000o2.O000000o();
        }
        int i = this.O0000oOO;
        if (this.O0000oO0) {
            if (this.O0000Oo0 == null) {
                this.O0000Oo0 = new OverflowMenuButton(this.f2677O000000o);
                if (this.O0000OoO) {
                    this.O0000Oo0.setImageDrawable(this.O0000Oo);
                    this.O0000Oo = null;
                    this.O0000OoO = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.O0000Oo0.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.O0000Oo0.getMeasuredWidth();
        } else {
            this.O0000Oo0 = null;
        }
        this.O0000oOo = i;
        this.O00oOooO = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public final void O000000o() {
        if (!this.O0000oo) {
            this.O0000oo0 = OO00O0.O000000o(this.O00000Oo).O000000o();
        }
        if (this.O00000o0 != null) {
            this.O00000o0.onItemsChanged(true);
        }
    }

    public final void O00000Oo() {
        this.O0000oO0 = true;
        this.O0000oO = true;
    }

    public final OO0o00 O000000o(ViewGroup viewGroup) {
        OO0o00 oO0o00 = this.O0000O0o;
        OO0o00 O000000o2 = super.O000000o(viewGroup);
        if (oO0o00 != O000000o2) {
            ((ActionMenuView) O000000o2).setPresenter(this);
        }
        return O000000o2;
    }

    public final View O000000o(OO0OOOO oo0oooo, View view, ViewGroup viewGroup) {
        View actionView = oo0oooo.getActionView();
        if (actionView == null || oo0oooo.O0000Oo0()) {
            actionView = super.O000000o(oo0oooo, view, viewGroup);
        }
        actionView.setVisibility(oo0oooo.isActionViewExpanded() ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.O000000o(layoutParams));
        }
        return actionView;
    }

    public final void O000000o(OO0OOOO oo0oooo, OO0o00.O000000o o000000o) {
        o000000o.initialize(oo0oooo, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) o000000o;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.O0000O0o);
        if (this.O000O00o == null) {
            this.O000O00o = new O00000Oo();
        }
        actionMenuItemView.setPopupCallback(this.O000O00o);
    }

    public final boolean O000000o(OO0OOOO oo0oooo) {
        return oo0oooo.O00000oo();
    }

    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((View) this.O0000O0o).requestLayout();
        boolean z2 = false;
        if (this.O00000o0 != null) {
            ArrayList<OO0OOOO> actionItems = this.O00000o0.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ActionProvider actionProvider = actionItems.get(i).O00000oo;
                if (actionProvider != null) {
                    actionProvider.O00000o = this;
                }
            }
        }
        ArrayList<OO0OOOO> nonActionItems = this.O00000o0 != null ? this.O00000o0.getNonActionItems() : null;
        if (this.O0000oO0 && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !((OO0OOOO) nonActionItems.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.O0000Oo0 == null) {
                this.O0000Oo0 = new OverflowMenuButton(this.f2677O000000o);
            }
            ViewGroup viewGroup = (ViewGroup) this.O0000Oo0.getParent();
            if (viewGroup != this.O0000O0o) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.O0000Oo0);
                }
                ((ActionMenuView) this.O0000O0o).addView(this.O0000Oo0, ActionMenuView.O000000o());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.O0000Oo0;
            if (overflowMenuButton != null && overflowMenuButton.getParent() == this.O0000O0o) {
                ((ViewGroup) this.O0000O0o).removeView(this.O0000Oo0);
            }
        }
        ((ActionMenuView) this.O0000O0o).setOverflowReserved(this.O0000oO0);
    }

    public final boolean O000000o(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.O0000Oo0) {
            return false;
        }
        return super.O000000o(viewGroup, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042  */
    public boolean onSubMenuSelected(OOO00O0 ooo00o0) {
        View view;
        boolean z = false;
        if (!ooo00o0.hasVisibleItems()) {
            return false;
        }
        OOO00O0 ooo00o02 = ooo00o0;
        while (ooo00o02.getParentMenu() != this.O00000o0) {
            ooo00o02 = (OOO00O0) ooo00o02.getParentMenu();
        }
        MenuItem item = ooo00o02.getItem();
        ViewGroup viewGroup = (ViewGroup) this.O0000O0o;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                view = viewGroup.getChildAt(i);
                if ((view instanceof OO0o00.O000000o) && ((OO0o00.O000000o) view).getItemData() == item) {
                    break;
                }
                i++;
            }
            if (view != null) {
                return false;
            }
            this.O0000o = ooo00o0.getItem().getItemId();
            int size = ooo00o0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MenuItem item2 = ooo00o0.getItem(i2);
                if (item2.isVisible() && item2.getIcon() != null) {
                    z = true;
                    break;
                }
                i2++;
            }
            this.O0000o0 = new O000000o(this.O00000Oo, ooo00o0, view);
            this.O0000o0.O000000o(z);
            if (this.O0000o0.O00000Oo()) {
                super.onSubMenuSelected(ooo00o0);
                return true;
            }
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
        view = null;
        if (view != null) {
        }
    }

    public final boolean O00000o0() {
        if (!this.O0000oO0 || O0000O0o() || this.O00000o0 == null || this.O0000O0o == null || this.O0000o0O != null || this.O00000o0.getNonActionItems().isEmpty()) {
            return false;
        }
        this.O0000o0O = new O00000o0(new O00000o(this.O00000Oo, this.O00000o0, this.O0000Oo0));
        ((View) this.O0000O0o).post(this.O0000o0O);
        return true;
    }

    public final boolean O00000o() {
        if (this.O0000o0O == null || this.O0000O0o == null) {
            O00000o o00000o = this.O0000o00;
            if (o00000o == null) {
                return false;
            }
            o00000o.O00000o0();
            return true;
        }
        ((View) this.O0000O0o).removeCallbacks(this.O0000o0O);
        this.O0000o0O = null;
        return true;
    }

    public final boolean O00000oO() {
        return O00000o() | O00000oo();
    }

    public final boolean O00000oo() {
        O000000o o000000o = this.O0000o0;
        if (o000000o == null) {
            return false;
        }
        o000000o.O00000o0();
        return true;
    }

    public final boolean O0000O0o() {
        O00000o o00000o = this.O0000o00;
        return o00000o != null && o00000o.O00000oO();
    }

    public boolean flagActionItems() {
        int i;
        ArrayList<OO0OOOO> arrayList;
        int i2;
        int i3;
        int i4;
        boolean z;
        ActionMenuPresenter actionMenuPresenter = this;
        View view = null;
        int i5 = 0;
        if (actionMenuPresenter.O00000o0 != null) {
            arrayList = actionMenuPresenter.O00000o0.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = actionMenuPresenter.O0000oo0;
        int i7 = actionMenuPresenter.O0000oOo;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.O0000O0o;
        int i8 = i6;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            OO0OOOO oo0oooo = (OO0OOOO) arrayList.get(i11);
            if (oo0oooo.O0000OOo()) {
                i9++;
            } else if (oo0oooo.O0000O0o()) {
                i10++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.O0000Ooo && oo0oooo.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (actionMenuPresenter.O0000oO0 && (z2 || i10 + i9 > i8)) {
            i8--;
        }
        int i12 = i8 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.O00oOooo;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.O0000ooO) {
            int i13 = actionMenuPresenter.O00oOooO;
            i2 = i7 / i13;
            i3 = i13 + ((i7 % i13) / i2);
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i14 = i7;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i) {
            OO0OOOO oo0oooo2 = (OO0OOOO) arrayList.get(i15);
            if (oo0oooo2.O0000OOo()) {
                View O000000o2 = actionMenuPresenter.O000000o(oo0oooo2, view, viewGroup);
                if (actionMenuPresenter.O0000ooO) {
                    i2 -= ActionMenuView.O000000o(O000000o2, i3, i2, makeMeasureSpec, i5);
                } else {
                    O000000o2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = O000000o2.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = oo0oooo2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                oo0oooo2.O00000o(z);
                i16 = measuredWidth;
                i4 = i;
            } else if (oo0oooo2.O0000O0o()) {
                int groupId2 = oo0oooo2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i14 > 0 && (!actionMenuPresenter.O0000ooO || i2 > 0);
                if (z4) {
                    boolean z5 = z4;
                    i4 = i;
                    View O000000o3 = actionMenuPresenter.O000000o(oo0oooo2, null, viewGroup);
                    if (actionMenuPresenter.O0000ooO) {
                        int O000000o4 = ActionMenuView.O000000o(O000000o3, i3, i2, makeMeasureSpec, 0);
                        i2 -= O000000o4;
                        z5 = O000000o4 == 0 ? false : z5;
                    } else {
                        O000000o3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = O000000o3.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z4 = z5 & (!actionMenuPresenter.O0000ooO ? i14 + i16 > 0 : i14 >= 0);
                } else {
                    i4 = i;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i17 = 0; i17 < i15; i17++) {
                        OO0OOOO oo0oooo3 = (OO0OOOO) arrayList.get(i17);
                        if (oo0oooo3.getGroupId() == groupId2) {
                            if (oo0oooo3.O00000oo()) {
                                i12++;
                            }
                            oo0oooo3.O00000o(false);
                        }
                    }
                }
                if (z4) {
                    i12--;
                }
                oo0oooo2.O00000o(z4);
            } else {
                i4 = i;
                oo0oooo2.O00000o(false);
                i15++;
                actionMenuPresenter = this;
                i = i4;
                view = null;
                i5 = 0;
            }
            i15++;
            actionMenuPresenter = this;
            i = i4;
            view = null;
            i5 = 0;
        }
        return true;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        O00000oO();
        super.onCloseMenu(menuBuilder, z);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f2692O000000o = this.O0000o;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.f2692O000000o > 0 && (findItem = this.O00000o0.findItem(savedState.f2692O000000o)) != null) {
                onSubMenuSelected((OOO00O0) findItem.getSubMenu());
            }
        }
    }

    public final void O000000o(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else if (this.O00000o0 != null) {
            this.O00000o0.close(false);
        }
    }

    public final void O000000o(ActionMenuView actionMenuView) {
        this.O0000O0o = actionMenuView;
        actionMenuView.initialize(this.O00000o0);
    }

    @SuppressLint({"BanParcelableUsage"})
    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class androidx.appcompat.widget.ActionMenuPresenter.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public int f2692O000000o;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f2692O000000o = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2692O000000o);
        }
    }

    class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.O000000o {
        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public OverflowMenuButton(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            o000000.O000000o(this, getContentDescription());
            setOnTouchListener(new OOOo00(this, ActionMenuPresenter.this) {
                /* class androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.AnonymousClass1 */

                public final OO0o O000000o() {
                    if (ActionMenuPresenter.this.O0000o00 == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.O0000o00.O000000o();
                }

                public final boolean O00000Oo() {
                    ActionMenuPresenter.this.O00000o0();
                    return true;
                }

                public final boolean O00000o0() {
                    if (ActionMenuPresenter.this.O0000o0O != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.O00000o();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.O00000o0();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                ab.O000000o(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    class O00000o extends OO0Oo0 {
        public O00000o(Context context, MenuBuilder menuBuilder, View view) {
            super(context, menuBuilder, view, true);
            this.O00000Oo = 8388613;
            O000000o(ActionMenuPresenter.this.O0000o0o);
        }

        public final void O00000o() {
            if (ActionMenuPresenter.this.O00000o0 != null) {
                ActionMenuPresenter.this.O00000o0.close();
            }
            ActionMenuPresenter.this.O0000o00 = null;
            super.O00000o();
        }
    }

    class O000000o extends OO0Oo0 {
        public O000000o(Context context, OOO00O0 ooo00o0, View view) {
            super(context, ooo00o0, view, false);
            if (!((OO0OOOO) ooo00o0.getItem()).O00000oo()) {
                this.f12305O000000o = ActionMenuPresenter.this.O0000Oo0 == null ? (View) ActionMenuPresenter.this.O0000O0o : ActionMenuPresenter.this.O0000Oo0;
            }
            O000000o(ActionMenuPresenter.this.O0000o0o);
        }

        public final void O00000o() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.O0000o0 = null;
            actionMenuPresenter.O0000o = 0;
            super.O00000o();
        }
    }

    class O0000O0o implements OO0o000.O000000o {
        O0000O0o() {
        }

        public final boolean O000000o(MenuBuilder menuBuilder) {
            if (menuBuilder == ActionMenuPresenter.this.O00000o0) {
                return false;
            }
            ActionMenuPresenter.this.O0000o = ((OOO00O0) menuBuilder).getItem().getItemId();
            OO0o000.O000000o o000000o = ActionMenuPresenter.this.O00000oo;
            if (o000000o != null) {
                return o000000o.O000000o(menuBuilder);
            }
            return false;
        }

        public final void O000000o(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof OOO00O0) {
                menuBuilder.getRootMenu().close(false);
            }
            OO0o000.O000000o o000000o = ActionMenuPresenter.this.O00000oo;
            if (o000000o != null) {
                o000000o.O000000o(menuBuilder, z);
            }
        }
    }

    class O00000o0 implements Runnable {
        private O00000o O00000Oo;

        public O00000o0(O00000o o00000o) {
            this.O00000Oo = o00000o;
        }

        public final void run() {
            if (ActionMenuPresenter.this.O00000o0 != null) {
                ActionMenuPresenter.this.O00000o0.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.O0000O0o;
            if (!(view == null || view.getWindowToken() == null || !this.O00000Oo.O00000Oo())) {
                ActionMenuPresenter.this.O0000o00 = this.O00000Oo;
            }
            ActionMenuPresenter.this.O0000o0O = null;
        }
    }

    class O00000Oo extends ActionMenuItemView.O00000Oo {
        O00000Oo() {
        }

        public final OO0o O000000o() {
            if (ActionMenuPresenter.this.O0000o0 != null) {
                return ActionMenuPresenter.this.O0000o0.O000000o();
            }
            return null;
        }
    }
}
