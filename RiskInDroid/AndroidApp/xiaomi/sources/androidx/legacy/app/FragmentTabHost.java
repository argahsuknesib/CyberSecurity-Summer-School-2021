package androidx.legacy.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ArrayList<O000000o> f2871O000000o = new ArrayList<>();
    private Context O00000Oo;
    private int O00000o;
    private FragmentManager O00000o0;
    private TabHost.OnTabChangeListener O00000oO;
    private O000000o O00000oo;
    private boolean O0000O0o;

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f2873O000000o;
        final Class<?> O00000Oo;
        Fragment O00000o;
        final Bundle O00000o0;
    }

    static class DummyTabFactory implements TabHost.TabContentFactory {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Context f2872O000000o;

        public DummyTabFactory(Context context) {
            this.f2872O000000o = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.f2872O000000o);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class androidx.legacy.app.FragmentTabHost.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        String f2874O000000o;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2874O000000o = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2874O000000o);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f2874O000000o + "}";
        }
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, null);
        O000000o(context, (AttributeSet) null);
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.O00000o = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.O00000oO = onTabChangeListener;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.f2871O000000o.size(); i++) {
            O000000o o000000o = this.f2871O000000o.get(i);
            o000000o.O00000o = this.O00000o0.findFragmentByTag(o000000o.f2873O000000o);
            if (o000000o.O00000o != null && !o000000o.O00000o.isDetached()) {
                if (o000000o.f2873O000000o.equals(currentTabTag)) {
                    this.O00000oo = o000000o;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.O00000o0.beginTransaction();
                    }
                    fragmentTransaction.detach(o000000o.O00000o);
                }
            }
        }
        this.O0000O0o = true;
        FragmentTransaction O000000o2 = O000000o(currentTabTag, fragmentTransaction);
        if (O000000o2 != null) {
            O000000o2.commit();
            this.O00000o0.executePendingTransactions();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O0000O0o = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2874O000000o = getCurrentTabTag();
        return savedState;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f2874O000000o);
    }

    @Deprecated
    public void onTabChanged(String str) {
        FragmentTransaction O000000o2;
        if (this.O0000O0o && (O000000o2 = O000000o(str, (FragmentTransaction) null)) != null) {
            O000000o2.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.O00000oO;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    private FragmentTransaction O000000o(String str, FragmentTransaction fragmentTransaction) {
        O000000o o000000o = null;
        for (int i = 0; i < this.f2871O000000o.size(); i++) {
            O000000o o000000o2 = this.f2871O000000o.get(i);
            if (o000000o2.f2873O000000o.equals(str)) {
                o000000o = o000000o2;
            }
        }
        if (o000000o != null) {
            if (this.O00000oo != o000000o) {
                if (fragmentTransaction == null) {
                    fragmentTransaction = this.O00000o0.beginTransaction();
                }
                O000000o o000000o3 = this.O00000oo;
                if (!(o000000o3 == null || o000000o3.O00000o == null)) {
                    fragmentTransaction.detach(this.O00000oo.O00000o);
                }
                if (o000000o != null) {
                    if (o000000o.O00000o == null) {
                        o000000o.O00000o = Fragment.instantiate(this.O00000Oo, o000000o.O00000Oo.getName(), o000000o.O00000o0);
                        fragmentTransaction.add(this.O00000o, o000000o.O00000o, o000000o.f2873O000000o);
                    } else {
                        fragmentTransaction.attach(o000000o.O00000o);
                    }
                }
                this.O00000oo = o000000o;
            }
            return fragmentTransaction;
        }
        throw new IllegalStateException("No tab known for tag ".concat(String.valueOf(str)));
    }
}
