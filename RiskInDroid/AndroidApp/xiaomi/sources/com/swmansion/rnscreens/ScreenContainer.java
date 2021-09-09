package com.swmansion.rnscreens;

import _m_j.dfy;
import _m_j.ee;
import _m_j.ei;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ScreenContainer<T extends dfy> extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ArrayList<T> f5784O000000o = new ArrayList<>();
    public boolean O00000Oo = false;
    private ee O00000o;
    private final Set<dfy> O00000o0 = new HashSet();
    private ei O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;
    private final ChoreographerCompat.FrameCallback O0000OOo = new ChoreographerCompat.FrameCallback() {
        /* class com.swmansion.rnscreens.ScreenContainer.AnonymousClass1 */

        public final void doFrame(long j) {
            ScreenContainer.this.O00000o0();
        }
    };
    private final Runnable O0000Oo0 = new Runnable() {
        /* class com.swmansion.rnscreens.ScreenContainer.AnonymousClass2 */

        public final void run() {
            ScreenContainer screenContainer = ScreenContainer.this;
            screenContainer.O00000Oo = false;
            screenContainer.measure(View.MeasureSpec.makeMeasureSpec(screenContainer.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ScreenContainer.this.getHeight(), 1073741824));
            ScreenContainer screenContainer2 = ScreenContainer.this;
            screenContainer2.layout(screenContainer2.getLeft(), ScreenContainer.this.getTop(), ScreenContainer.this.getRight(), ScreenContainer.this.getBottom());
        }
    };

    public ScreenContainer(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getWidth(), getHeight());
        }
    }

    public void requestLayout() {
        super.requestLayout();
        if (!this.O00000Oo) {
            this.O00000Oo = true;
            post(this.O0000Oo0);
        }
    }

    /* access modifiers changed from: package-private */
    public void O000000o() {
        if (!this.O00000oo) {
            this.O00000oo = true;
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.O0000OOo);
        }
    }

    /* access modifiers changed from: protected */
    public T O000000o(Screen screen) {
        return new dfy(screen);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Screen screen, int i) {
        dfy O000000o2 = O000000o(screen);
        screen.setFragment(O000000o2);
        this.f5784O000000o.add(i, O000000o2);
        screen.setContainer(this);
        O000000o();
    }

    /* access modifiers changed from: protected */
    public void O000000o(int i) {
        ((dfy) this.f5784O000000o.get(i)).O000000o().setContainer(null);
        this.f5784O000000o.remove(i);
        O000000o();
    }

    /* access modifiers changed from: protected */
    public int getScreenCount() {
        return this.f5784O000000o.size();
    }

    /* access modifiers changed from: protected */
    public final Screen O00000Oo(int i) {
        return ((dfy) this.f5784O000000o.get(i)).O000000o();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    public final ee getFragmentManager() {
        boolean z;
        ee eeVar;
        boolean z2;
        if (this.O00000o == null) {
            ViewParent viewParent = this;
            while (true) {
                z = viewParent instanceof ReactRootView;
                if (!z && !(viewParent instanceof Screen) && viewParent.getParent() != null) {
                    viewParent = viewParent.getParent();
                }
            }
            if (viewParent instanceof Screen) {
                eeVar = ((Screen) viewParent).getFragment().getChildFragmentManager();
            } else if (z) {
                Context context = ((ReactRootView) viewParent).getContext();
                while (true) {
                    z2 = context instanceof FragmentActivity;
                    if (!z2 && (context instanceof ContextWrapper)) {
                        context = ((ContextWrapper) context).getBaseContext();
                    } else if (!z2) {
                        eeVar = ((FragmentActivity) context).getSupportFragmentManager();
                    } else {
                        throw new IllegalStateException("In order to use RNScreens components your app's activity need to extend ReactFragmentActivity or ReactCompatActivity");
                    }
                }
                if (!z2) {
                }
            } else {
                throw new IllegalStateException("ScreenContainer is not attached under ReactRootView");
            }
            this.O00000o = eeVar;
        }
        return this.O00000o;
    }

    /* access modifiers changed from: protected */
    public ei getOrCreateTransaction() {
        if (this.O00000oO == null) {
            this.O00000oO = getFragmentManager().O000000o();
            this.O00000oO.O0000oOO = true;
        }
        return this.O00000oO;
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        ei eiVar = this.O00000oO;
        if (eiVar != null) {
            eiVar.O00000o0();
            this.O00000oO = null;
        }
    }

    private void O000000o(dfy dfy) {
        getOrCreateTransaction().O000000o(dfy);
        this.O00000o0.remove(dfy);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O0000O0o = true;
        O00000o0();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O0000O0o = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
        }
    }

    public final void O00000o0() {
        if (this.O00000oo && this.O0000O0o) {
            this.O00000oo = false;
            O00000o();
        }
    }

    /* access modifiers changed from: protected */
    public void O00000o() {
        HashSet hashSet = new HashSet(this.O00000o0);
        int size = this.f5784O000000o.size();
        for (int i = 0; i < size; i++) {
            dfy dfy = (dfy) this.f5784O000000o.get(i);
            if (!dfy.O000000o().O00000Oo && this.O00000o0.contains(dfy)) {
                O000000o(dfy);
            }
            hashSet.remove(dfy);
        }
        if (!hashSet.isEmpty()) {
            Object[] array = hashSet.toArray();
            for (Object obj : array) {
                O000000o((dfy) obj);
            }
        }
        int size2 = this.f5784O000000o.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size2; i3++) {
            if (((dfy) this.f5784O000000o.get(i3)).O000000o().O00000Oo) {
                i2++;
            }
        }
        boolean z = i2 > 1;
        int size3 = this.f5784O000000o.size();
        boolean z2 = false;
        for (int i4 = 0; i4 < size3; i4++) {
            dfy dfy2 = (dfy) this.f5784O000000o.get(i4);
            boolean z3 = dfy2.O000000o().O00000Oo;
            if (z3 && !this.O00000o0.contains(dfy2)) {
                getOrCreateTransaction().O000000o(getId(), dfy2);
                this.O00000o0.add(dfy2);
                z2 = true;
            } else if (z3 && z2) {
                ei orCreateTransaction = getOrCreateTransaction();
                orCreateTransaction.O000000o(dfy2);
                orCreateTransaction.O000000o(getId(), dfy2);
            }
            dfy2.O000000o().setTransitioning(z);
        }
        O00000Oo();
    }
}
