package com.swmansion.rnscreens;

import _m_j.dfy;
import _m_j.dfz;
import _m_j.ee;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.swmansion.rnscreens.Screen;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ScreenStack extends ScreenContainer<dfz> {
    private final ArrayList<dfz> O00000o = new ArrayList<>();
    public dfz O00000o0 = null;
    private final Set<dfz> O00000oO = new HashSet();
    private final ee.O00000Oo O00000oo = new ee.O00000Oo() {
        /* class com.swmansion.rnscreens.ScreenStack.AnonymousClass1 */

        public final void O000000o() {
            if (ScreenStack.this.getFragmentManager().O00000oO() == 0) {
                ScreenStack screenStack = ScreenStack.this;
                screenStack.O000000o(screenStack.O00000o0);
            }
        }
    };
    private final ee.O000000o O0000O0o = new ee.O000000o() {
        /* class com.swmansion.rnscreens.ScreenStack.AnonymousClass2 */

        public final void O000000o(Fragment fragment) {
            if (ScreenStack.this.O00000o0 == fragment) {
                ScreenStack screenStack = ScreenStack.this;
                screenStack.setupBackHandlerIfNeeded(screenStack.O00000o0);
            }
        }
    };

    public ScreenStack(Context context) {
        super(context);
    }

    public final void O000000o(dfz dfz) {
        this.O00000oO.add(dfz);
        O00000o();
    }

    public Screen getTopScreen() {
        return this.O00000o0.O000000o();
    }

    public Screen getRootScreen() {
        int screenCount = getScreenCount();
        for (int i = 0; i < screenCount; i++) {
            Screen O00000Oo = O00000Oo(i);
            if (!this.O00000oO.contains(O00000Oo.getFragment())) {
                return O00000Oo;
            }
        }
        throw new IllegalStateException("Stack has no root screen set");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ee fragmentManager = getFragmentManager();
        fragmentManager.O00000Oo(this.O00000oo);
        getFragmentManager().O000000o(this.O0000O0o);
        if (!fragmentManager.O0000Oo0()) {
            fragmentManager.O00000Oo("RN_SCREEN_LAST");
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getFragmentManager().O000000o(this.O0000O0o, false);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i) {
        this.O00000oO.remove(O00000Oo(i));
        super.O000000o(i);
    }

    /* access modifiers changed from: protected */
    public final void O00000o() {
        Iterator<dfz> it = this.O00000o.iterator();
        while (it.hasNext()) {
            dfz next = it.next();
            if (!this.f5784O000000o.contains(next) || this.O00000oO.contains(next)) {
                getOrCreateTransaction().O000000o(next);
            }
        }
        int size = this.f5784O000000o.size() - 1;
        dfz dfz = null;
        final dfz dfz2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            dfz dfz3 = (dfz) this.f5784O000000o.get(size);
            if (!this.O00000oO.contains(dfz3)) {
                if (dfz2 != null) {
                    dfz = dfz3;
                    break;
                } else if (dfz3.O000000o().getStackPresentation() != Screen.StackPresentation.TRANSPARENT_MODAL) {
                    dfz2 = dfz3;
                    break;
                } else {
                    dfz2 = dfz3;
                }
            }
            size--;
        }
        Iterator it2 = this.f5784O000000o.iterator();
        while (it2.hasNext()) {
            dfz dfz4 = (dfz) it2.next();
            if (!this.O00000o.contains(dfz4) && !this.O00000oO.contains(dfz4)) {
                getOrCreateTransaction().O000000o(getId(), dfz4);
            }
            if (!(dfz4 == dfz2 || dfz4 == dfz || this.O00000oO.contains(dfz4))) {
                getOrCreateTransaction().O00000Oo(dfz4);
            }
        }
        if (dfz != null) {
            getOrCreateTransaction().O00000o0(dfz).O000000o(new Runnable() {
                /* class com.swmansion.rnscreens.ScreenStack.AnonymousClass3 */

                public final void run() {
                    dfz2.O000000o().bringToFront();
                }
            });
        }
        if (dfz2 != null) {
            getOrCreateTransaction().O00000o0(dfz2);
        }
        if (this.O00000o.contains(dfz2)) {
            dfz dfz5 = this.O00000o0;
            if (dfz5 != null && !dfz5.equals(dfz2)) {
                int i = 8194;
                int i2 = AnonymousClass4.f5790O000000o[this.O00000o0.O000000o().getStackAnimation().ordinal()];
                if (i2 == 1) {
                    i = 0;
                } else if (i2 == 2) {
                    i = 4099;
                }
                getOrCreateTransaction().O0000Oo0 = i;
            }
        } else if (this.O00000o0 != null) {
            int i3 = 4097;
            int i4 = AnonymousClass4.f5790O000000o[this.O00000o0.O000000o().getStackAnimation().ordinal()];
            if (i4 == 1) {
                i3 = 0;
            } else if (i4 == 2) {
                i3 = 4099;
            }
            getOrCreateTransaction().O0000Oo0 = i3;
        }
        this.O00000o0 = dfz2;
        this.O00000o.clear();
        this.O00000o.addAll(this.f5784O000000o);
        O00000Oo();
        dfz dfz6 = this.O00000o0;
        if (dfz6 != null) {
            setupBackHandlerIfNeeded(dfz6);
        }
        Iterator<dfz> it3 = this.O00000o.iterator();
        while (it3.hasNext()) {
            it3.next().O00000o0();
        }
    }

    /* renamed from: com.swmansion.rnscreens.ScreenStack$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5790O000000o = new int[Screen.StackAnimation.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f5790O000000o[Screen.StackAnimation.NONE.ordinal()] = 1;
            f5790O000000o[Screen.StackAnimation.FADE.ordinal()] = 2;
        }
    }

    public void setupBackHandlerIfNeeded(dfz dfz) {
        if (this.O00000o0.isResumed()) {
            getFragmentManager().O00000Oo(this.O00000oo);
            getFragmentManager().O00000Oo("RN_SCREEN_LAST");
            dfz dfz2 = null;
            int i = 0;
            int size = this.O00000o.size();
            while (true) {
                if (i >= size) {
                    break;
                }
                dfz dfz3 = this.O00000o.get(i);
                if (!this.O00000oO.contains(dfz3)) {
                    dfz2 = dfz3;
                    break;
                }
                i++;
            }
            if (dfz != dfz2 && dfz.O00000o()) {
                getFragmentManager().O000000o().O00000Oo(dfz).O00000o0(dfz).O000000o("RN_SCREEN_LAST").O00000oO(dfz).O00000o0();
                getFragmentManager().O000000o(this.O00000oo);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ dfy O000000o(Screen screen) {
        return new dfz(screen);
    }
}
