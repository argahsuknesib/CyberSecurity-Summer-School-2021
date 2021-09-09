package androidx.fragment.app;

import _m_j.ee;
import _m_j.ei;
import android.annotation.SuppressLint;
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
    private final ArrayList<O000000o> f2867O000000o = new ArrayList<>();
    private Context O00000Oo;
    private int O00000o;
    private ee O00000o0;
    private TabHost.OnTabChangeListener O00000oO;
    private O000000o O00000oo;
    private boolean O0000O0o;

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f2869O000000o;
        final Class<?> O00000Oo;
        Fragment O00000o;
        final Bundle O00000o0;
    }

    static class DummyTabFactory implements TabHost.TabContentFactory {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Context f2868O000000o;

        public DummyTabFactory(Context context) {
            this.f2868O000000o = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.f2868O000000o);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class androidx.fragment.app.FragmentTabHost.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        String f2870O000000o;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2870O000000o = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2870O000000o);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f2870O000000o + "}";
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
        int size = this.f2867O000000o.size();
        ei eiVar = null;
        for (int i = 0; i < size; i++) {
            O000000o o000000o = this.f2867O000000o.get(i);
            o000000o.O00000o = this.O00000o0.O000000o(o000000o.f2869O000000o);
            if (o000000o.O00000o != null && !o000000o.O00000o.isDetached()) {
                if (o000000o.f2869O000000o.equals(currentTabTag)) {
                    this.O00000oo = o000000o;
                } else {
                    if (eiVar == null) {
                        eiVar = this.O00000o0.O000000o();
                    }
                    eiVar.O00000o(o000000o.O00000o);
                }
            }
        }
        this.O0000O0o = true;
        ei O000000o2 = O000000o(currentTabTag, eiVar);
        if (O000000o2 != null) {
            O000000o2.O00000Oo();
            this.O00000o0.O00000Oo();
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
        savedState.f2870O000000o = getCurrentTabTag();
        return savedState;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f2870O000000o);
    }

    @Deprecated
    public void onTabChanged(String str) {
        ei O000000o2;
        if (this.O0000O0o && (O000000o2 = O000000o(str, (ei) null)) != null) {
            O000000o2.O00000Oo();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.O00000oO;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    private ei O000000o(String str, ei eiVar) {
        O000000o O000000o2 = O000000o(str);
        if (this.O00000oo != O000000o2) {
            if (eiVar == null) {
                eiVar = this.O00000o0.O000000o();
            }
            O000000o o000000o = this.O00000oo;
            if (!(o000000o == null || o000000o.O00000o == null)) {
                eiVar.O00000o(this.O00000oo.O00000o);
            }
            if (O000000o2 != null) {
                if (O000000o2.O00000o == null) {
                    O000000o2.O00000o = this.O00000o0.O0000OOo().O00000o0(this.O00000Oo.getClassLoader(), O000000o2.O00000Oo.getName());
                    O000000o2.O00000o.setArguments(O000000o2.O00000o0);
                    eiVar.O000000o(this.O00000o, O000000o2.O00000o, O000000o2.f2869O000000o);
                } else {
                    eiVar.O00000oo(O000000o2.O00000o);
                }
            }
            this.O00000oo = O000000o2;
        }
        return eiVar;
    }

    private O000000o O000000o(String str) {
        int size = this.f2867O000000o.size();
        for (int i = 0; i < size; i++) {
            O000000o o000000o = this.f2867O000000o.get(i);
            if (o000000o.f2869O000000o.equals(str)) {
                return o000000o;
            }
        }
        return null;
    }
}
