package _m_j;

import _m_j.ee;
import _m_j.ei;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerState;
import androidx.fragment.app.FragmentState;
import androidx.lifecycle.Lifecycle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ef extends ee implements LayoutInflater.Factory2 {
    public static boolean O00000o0 = false;
    static final Interpolator O000O0oO = new DecelerateInterpolator(2.5f);
    static final Interpolator O000O0oo = new DecelerateInterpolator(1.5f);
    ArrayList<O0000O0o> O00000o;
    boolean O00000oO;
    int O00000oo = 0;
    final ArrayList<Fragment> O0000O0o = new ArrayList<>();
    public final HashMap<String, Fragment> O0000OOo = new HashMap<>();
    ArrayList<Fragment> O0000Oo;
    ArrayList<dy> O0000Oo0;
    OnBackPressedDispatcher O0000OoO;
    final O0Oo0 O0000Ooo = new O0Oo0() {
        /* class _m_j.ef.AnonymousClass1 */

        public final void O00000Oo() {
            ef efVar = ef.this;
            efVar.O0000Ooo();
            if (efVar.O0000Ooo.f6677O000000o) {
                efVar.O00000o();
            } else {
                efVar.O0000OoO.O000000o();
            }
        }
    };
    public ed O0000o;
    ArrayList<Integer> O0000o0;
    ArrayList<dy> O0000o00;
    ArrayList<ee.O00000Oo> O0000o0O;
    public int O0000o0o = 0;
    Fragment O0000oO;
    ea O0000oO0;
    public Fragment O0000oOO;
    boolean O0000oOo;
    boolean O0000oo;
    boolean O0000oo0;
    public boolean O0000ooO;
    boolean O0000ooo;
    ArrayList<Fragment> O000O00o;
    Bundle O000O0OO = null;
    SparseArray<Parcelable> O000O0Oo = null;
    Runnable O000O0o = new Runnable() {
        /* class _m_j.ef.AnonymousClass2 */

        public final void run() {
            ef.this.O0000Ooo();
        }
    };
    public eg O000O0o0;
    private final CopyOnWriteArrayList<O00000o0> O000OO00 = new CopyOnWriteArrayList<>();
    ArrayList<O0000Oo0> O00oOoOo;
    ArrayList<dy> O00oOooO;
    ArrayList<Boolean> O00oOooo;

    static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final int[] f15205O000000o = {16842755, 16842960, 16842961};
    }

    interface O0000O0o {
        boolean O000000o(ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2);
    }

    public static int O00000o(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    static final class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final ee.O000000o f15206O000000o;
        final boolean O00000Oo;

        O00000o0(ee.O000000o o000000o, boolean z) {
            this.f15206O000000o = o000000o;
            this.O00000Oo = z;
        }
    }

    private void O000000o(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new bc("FragmentManager"));
        ed edVar = this.O0000o;
        if (edVar != null) {
            try {
                edVar.O000000o("  ", printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                O000000o("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public final ei O000000o() {
        return new dy(this);
    }

    public final boolean O00000Oo() {
        boolean O0000Ooo2 = O0000Ooo();
        O00oOooO();
        return O0000Ooo2;
    }

    public final void O0000Oo() {
        ArrayList<O0000O0o> arrayList = this.O00000o;
        boolean z = true;
        if (arrayList == null || arrayList.isEmpty()) {
            O0Oo0 o0Oo0 = this.O0000Ooo;
            if (O00000oO() <= 0 || !O000000o(this.O0000oO)) {
                z = false;
            }
            o0Oo0.f6677O000000o = z;
            return;
        }
        this.O0000Ooo.f6677O000000o = true;
    }

    public final boolean O000000o(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        ef efVar = fragment.mFragmentManager;
        if (fragment != efVar.O0000oOO || !O000000o(efVar.O0000oO)) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(_m_j.ef$O0000O0o, boolean):void
     arg types: [_m_j.ef$O0000OOo, int]
     candidates:
      _m_j.ef.O000000o(float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(android.os.Bundle, java.lang.String):androidx.fragment.app.Fragment
      _m_j.ef.O000000o(int, _m_j.dy):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O000000o(int, boolean):void
      _m_j.ef.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, androidx.lifecycle.Lifecycle$State):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, boolean):void
      _m_j.ef.O000000o(android.view.Menu, android.view.MenuInflater):boolean
      _m_j.ee.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(_m_j.ef$O0000O0o, boolean):void */
    public final void O00000o0() {
        O000000o((O0000O0o) new O0000OOo(null, -1, 0), false);
    }

    public final boolean O00000o() {
        O0000ooO();
        return O0000oo0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(_m_j.ef$O0000O0o, boolean):void
     arg types: [_m_j.ef$O0000OOo, int]
     candidates:
      _m_j.ef.O000000o(float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(android.os.Bundle, java.lang.String):androidx.fragment.app.Fragment
      _m_j.ef.O000000o(int, _m_j.dy):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O000000o(int, boolean):void
      _m_j.ef.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, androidx.lifecycle.Lifecycle$State):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, boolean):void
      _m_j.ef.O000000o(android.view.Menu, android.view.MenuInflater):boolean
      _m_j.ee.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(_m_j.ef$O0000O0o, boolean):void */
    public final void O00000Oo(String str) {
        O000000o((O0000O0o) new O0000OOo(str, -1, 1), false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(_m_j.ef$O0000O0o, boolean):void
     arg types: [_m_j.ef$O0000OOo, int]
     candidates:
      _m_j.ef.O000000o(float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(android.os.Bundle, java.lang.String):androidx.fragment.app.Fragment
      _m_j.ef.O000000o(int, _m_j.dy):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O000000o(int, boolean):void
      _m_j.ef.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, androidx.lifecycle.Lifecycle$State):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, boolean):void
      _m_j.ef.O000000o(android.view.Menu, android.view.MenuInflater):boolean
      _m_j.ee.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(_m_j.ef$O0000O0o, boolean):void */
    public final void O00000Oo(int i) {
        if (i >= 0) {
            O000000o((O0000O0o) new O0000OOo(null, i, 1), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(i)));
    }

    private boolean O0000oo0() {
        O0000Ooo();
        O00000o0(true);
        Fragment fragment = this.O0000oOO;
        if (fragment != null && fragment.getChildFragmentManager().O00000o()) {
            return true;
        }
        boolean O000000o2 = O000000o(this.O00oOooO, this.O00oOooo, (String) null, -1, 0);
        if (O000000o2) {
            this.O00000oO = true;
            try {
                O00000Oo(this.O00oOooO, this.O00oOooo);
            } finally {
                O0000ooo();
            }
        }
        O0000Oo();
        O000O00o();
        O000O0Oo();
        return O000000o2;
    }

    public final int O00000oO() {
        ArrayList<dy> arrayList = this.O0000Oo0;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final void O000000o(ee.O00000Oo o00000Oo) {
        if (this.O0000o0O == null) {
            this.O0000o0O = new ArrayList<>();
        }
        this.O0000o0O.add(o00000Oo);
    }

    public final void O00000Oo(ee.O00000Oo o00000Oo) {
        ArrayList<ee.O00000Oo> arrayList = this.O0000o0O;
        if (arrayList != null) {
            arrayList.remove(o00000Oo);
        }
    }

    private void O000000o(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            O000000o(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    private Fragment O000000o(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.O0000OOo.get(string);
        if (fragment == null) {
            O000000o(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragment;
    }

    public final List<Fragment> O00000oo() {
        List<Fragment> list;
        if (this.O0000O0o.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.O0000O0o) {
            list = (List) this.O0000O0o.clone();
        }
        return list;
    }

    private eg O0000o0(Fragment fragment) {
        eg egVar = this.O000O0o0;
        eg egVar2 = egVar.O00000Oo.get(fragment.mWho);
        if (egVar2 != null) {
            return egVar2;
        }
        eg egVar3 = new eg(egVar.O00000o);
        egVar.O00000Oo.put(fragment.mWho, egVar3);
        return egVar3;
    }

    public final void O00000Oo(Fragment fragment) {
        if (O0000Oo0()) {
            if (O00000o0) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.O000O0o0.O000000o(fragment) && O00000o0) {
            Log.v("FragmentManager", "Updating retained Fragments: Added ".concat(String.valueOf(fragment)));
        }
    }

    public final void O00000o0(Fragment fragment) {
        if (O0000Oo0()) {
            if (O00000o0) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.O000O0o0.O00000o0(fragment) && O00000o0) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed ".concat(String.valueOf(fragment)));
        }
    }

    public final boolean O0000O0o() {
        return this.O0000ooO;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.O0000oO;
        if (fragment != null) {
            bb.O000000o(fragment, sb);
        } else {
            bb.O000000o(this.O0000o, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void O000000o(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.O0000OOo.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment next : this.O0000OOo.values()) {
                printWriter.print(str);
                printWriter.println(next);
                if (next != null) {
                    next.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.O0000O0o.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size5; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(this.O0000O0o.get(i).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.O0000Oo;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.O0000Oo.get(i2).toString());
            }
        }
        ArrayList<dy> arrayList2 = this.O0000Oo0;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                dy dyVar = this.O0000Oo0.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(dyVar.toString());
                dyVar.O000000o(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.O0000o00 != null && (size2 = this.O0000o00.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.O0000o00.get(i4));
                }
            }
            if (this.O0000o0 != null && this.O0000o0.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.O0000o0.toArray()));
            }
        }
        ArrayList<O0000O0o> arrayList3 = this.O00000o;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(this.O00000o.get(i5));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.O0000o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.O0000oO0);
        if (this.O0000oO != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.O0000oO);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.O0000o0o);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.O0000oo0);
        printWriter.print(" mStopped=");
        printWriter.print(this.O0000oo);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.O0000ooO);
        if (this.O0000oOo) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.O0000oOo);
        }
    }

    private static O000000o O000000o(float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(O000O0oO);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(O000O0oo);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new O000000o(animationSet);
    }

    private static O000000o O000000o(float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(O000O0oo);
        alphaAnimation.setDuration(220);
        return new O000000o(alphaAnimation);
    }

    private O000000o O000000o(Fragment fragment, int i, boolean z, int i2) {
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        if (fragment.mContainer != null && fragment.mContainer.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, nextAnim);
        if (onCreateAnimation != null) {
            return new O000000o(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(i, z, nextAnim);
        if (onCreateAnimator != null) {
            return new O000000o(onCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(this.O0000o.O00000o0.getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.O0000o.O00000o0, nextAnim);
                    if (loadAnimation != null) {
                        return new O000000o(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.O0000o.O00000o0, nextAnim);
                    if (loadAnimator != null) {
                        return new O000000o(loadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.O0000o.O00000o0, nextAnim);
                        if (loadAnimation2 != null) {
                            return new O000000o(loadAnimation2);
                        }
                    } else {
                        throw e2;
                    }
                }
            }
        }
        if (i == 0) {
            return null;
        }
        char c = 65535;
        if (i == 4097) {
            c = z ? (char) 1 : 2;
        } else if (i == 4099) {
            c = z ? (char) 5 : 6;
        } else if (i == 8194) {
            c = z ? (char) 3 : 4;
        }
        if (c < 0) {
            return null;
        }
        switch (c) {
            case 1:
                return O000000o(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return O000000o(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return O000000o(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return O000000o(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return O000000o(0.0f, 1.0f);
            case 6:
                return O000000o(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.O0000o.O00000oO()) {
                    i2 = this.O0000o.O00000oo();
                }
                if (i2 == 0) {
                }
                return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void
     arg types: [androidx.fragment.app.Fragment, int, int, int, int]
     candidates:
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, _m_j.o0O0OOOo<androidx.fragment.app.Fragment>):int
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, java.lang.String, int, int):boolean
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void */
    public final void O00000o(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.O00000oO) {
            this.O0000ooo = true;
            return;
        }
        fragment.mDeferStart = false;
        O000000o(fragment, this.O0000o0o, 0, 0, false);
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:104:0x01eb */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void
     arg types: [androidx.fragment.app.Fragment, int, int, int, int]
     candidates:
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, _m_j.o0O0OOOo<androidx.fragment.app.Fragment>):int
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, java.lang.String, int, int):boolean
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, boolean):void
     arg types: [androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, int]
     candidates:
      _m_j.ef.O000000o(float, float, float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, boolean, int):_m_j.ef$O000000o
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int):void
      _m_j.ef.O000000o(_m_j.dy, boolean, boolean, boolean):void
      _m_j.ef.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
      _m_j.ee.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, boolean):void
     arg types: [androidx.fragment.app.Fragment, int]
     candidates:
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O00000Oo(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O00000Oo(_m_j.ef$O0000O0o, boolean):void
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, boolean, int):_m_j.ef$O000000o
     arg types: [androidx.fragment.app.Fragment, int, int, int]
     candidates:
      _m_j.ef.O000000o(float, float, float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, boolean):void
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int):void
      _m_j.ef.O000000o(_m_j.dy, boolean, boolean, boolean):void
      _m_j.ef.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
      _m_j.ee.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, boolean, int):_m_j.ef$O000000o */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0088, code lost:
        if (r0 != 3) goto L_0x04a8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:265:? A[RETURN, SYNTHETIC] */
    public final void O000000o(Fragment fragment, int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        Fragment fragment2;
        ViewGroup viewGroup;
        String str;
        String str2;
        String str3;
        Fragment fragment3 = fragment;
        boolean z2 = true;
        if (!fragment3.mAdded || fragment3.mDetached) {
            i4 = i;
            if (i4 > 1) {
                i4 = 1;
            }
        } else {
            i4 = i;
        }
        if (fragment3.mRemoving && i4 > fragment3.mState) {
            if (fragment3.mState != 0 || !fragment.isInBackStack()) {
                i4 = fragment3.mState;
            } else {
                i4 = 1;
            }
        }
        if (fragment3.mDeferStart && fragment3.mState < 3 && i4 > 2) {
            i4 = 2;
        }
        if (fragment3.mMaxState == Lifecycle.State.CREATED) {
            i5 = Math.min(i4, 1);
        } else {
            i5 = Math.min(i4, fragment3.mMaxState.ordinal());
        }
        int i6 = i5;
        if (fragment3.mState <= i6) {
            if (!fragment3.mFromLayout || fragment3.mInLayout) {
                if (!(fragment.getAnimatingAway() == null && fragment.getAnimator() == null)) {
                    fragment3.setAnimatingAway(null);
                    fragment3.setAnimator(null);
                    O000000o(fragment, fragment.getStateAfterAnimating(), 0, 0, true);
                }
                int i7 = fragment3.mState;
                if (i7 != 0) {
                    if (i7 != 1) {
                        if (i7 != 2) {
                        }
                        i6 = i6;
                        if (i6 > 2) {
                            if (O00000o0) {
                                Log.v("FragmentManager", "moveto STARTED: ".concat(String.valueOf(fragment)));
                            }
                            fragment.performStart();
                            O0000oo0(fragment);
                            i6 = i6;
                        }
                    }
                    if (i6 > 0) {
                        O0000o0o(fragment);
                    }
                    if (i6 > 1) {
                        if (O00000o0) {
                            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: ".concat(String.valueOf(fragment)));
                        }
                        if (!fragment3.mFromLayout) {
                            if (fragment3.mContainerId != 0) {
                                if (fragment3.mContainerId == -1) {
                                    O000000o(new IllegalArgumentException("Cannot create fragment " + fragment3 + " for a container view with no id"));
                                }
                                viewGroup = (ViewGroup) this.O0000oO0.O000000o(fragment3.mContainerId);
                                if (viewGroup == null && !fragment3.mRestored) {
                                    try {
                                        str = fragment.getResources().getResourceName(fragment3.mContainerId);
                                    } catch (Resources.NotFoundException unused) {
                                        str = "unknown";
                                    }
                                    O000000o(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment3.mContainerId) + " (" + str + ") for fragment " + fragment3));
                                }
                            } else {
                                viewGroup = null;
                            }
                            fragment3.mContainer = viewGroup;
                            fragment3.performCreateView(fragment3.performGetLayoutInflater(fragment3.mSavedFragmentState), viewGroup, fragment3.mSavedFragmentState);
                            if (fragment3.mView != null) {
                                fragment3.mInnerView = fragment3.mView;
                                fragment3.mView.setSaveFromParentEnabled(false);
                                if (viewGroup != null) {
                                    viewGroup.addView(fragment3.mView);
                                }
                                if (fragment3.mHidden) {
                                    fragment3.mView.setVisibility(8);
                                }
                                fragment3.onViewCreated(fragment3.mView, fragment3.mSavedFragmentState);
                                O000000o(fragment3, fragment3.mView, fragment3.mSavedFragmentState, false);
                                if (fragment3.mView.getVisibility() != 0 || fragment3.mContainer == null) {
                                    z2 = false;
                                }
                                fragment3.mIsNewlyAdded = z2;
                            } else {
                                fragment3.mInnerView = null;
                            }
                        }
                        fragment3.performActivityCreated(fragment3.mSavedFragmentState);
                        O00000o0(fragment3, fragment3.mSavedFragmentState);
                        if (fragment3.mView != null) {
                            fragment3.restoreViewState(fragment3.mSavedFragmentState);
                        }
                        fragment3.mSavedFragmentState = null;
                    }
                    i6 = i6;
                    if (i6 > 2) {
                    }
                } else {
                    if (i6 > 0) {
                        if (O00000o0) {
                            Log.v("FragmentManager", "moveto CREATED: ".concat(String.valueOf(fragment)));
                        }
                        if (fragment3.mSavedFragmentState != null) {
                            fragment3.mSavedFragmentState.setClassLoader(this.O0000o.O00000o0.getClassLoader());
                            fragment3.mSavedViewState = fragment3.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            Fragment O000000o2 = O000000o(fragment3.mSavedFragmentState, "android:target_state");
                            fragment3.mTargetWho = O000000o2 != null ? O000000o2.mWho : null;
                            if (fragment3.mTargetWho != null) {
                                fragment3.mTargetRequestCode = fragment3.mSavedFragmentState.getInt("android:target_req_state", 0);
                            }
                            if (fragment3.mSavedUserVisibleHint != null) {
                                fragment3.mUserVisibleHint = fragment3.mSavedUserVisibleHint.booleanValue();
                                fragment3.mSavedUserVisibleHint = null;
                            } else {
                                fragment3.mUserVisibleHint = fragment3.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                            }
                            if (!fragment3.mUserVisibleHint) {
                                fragment3.mDeferStart = true;
                                if (i6 > 2) {
                                    i6 = 2;
                                }
                            }
                        }
                        ed edVar = this.O0000o;
                        fragment3.mHost = edVar;
                        Fragment fragment4 = this.O0000oO;
                        fragment3.mParentFragment = fragment4;
                        fragment3.mFragmentManager = fragment4 != null ? fragment4.mChildFragmentManager : edVar.O00000oO;
                        if (fragment3.mTarget == null) {
                            str3 = "Fragment ";
                            str2 = " declared target fragment ";
                        } else if (this.O0000OOo.get(fragment3.mTarget.mWho) == fragment3.mTarget) {
                            if (fragment3.mTarget.mState <= 0) {
                                str3 = "Fragment ";
                                str2 = " declared target fragment ";
                                O000000o(fragment3.mTarget, 1, 0, 0, true);
                            } else {
                                str3 = "Fragment ";
                                str2 = " declared target fragment ";
                            }
                            fragment3.mTargetWho = fragment3.mTarget.mWho;
                            fragment3.mTarget = null;
                        } else {
                            throw new IllegalStateException("Fragment " + fragment3 + " declared target fragment " + fragment3.mTarget + " that does not belong to this FragmentManager!");
                        }
                        if (fragment3.mTargetWho != null) {
                            Fragment fragment5 = this.O0000OOo.get(fragment3.mTargetWho);
                            if (fragment5 == null) {
                                throw new IllegalStateException(str3 + fragment3 + str2 + fragment3.mTargetWho + " that does not belong to this FragmentManager!");
                            } else if (fragment5.mState <= 0) {
                                O000000o(fragment5, 1, 0, 0, true);
                            }
                        }
                        O000000o(fragment3, this.O0000o.O00000o0);
                        fragment.performAttach();
                        if (fragment3.mParentFragment == null) {
                            this.O0000o.O000000o(fragment3);
                        } else {
                            fragment3.mParentFragment.onAttachFragment(fragment3);
                        }
                        O00000Oo(fragment3, this.O0000o.O00000o0);
                        if (!fragment3.mIsCreated) {
                            O000000o(fragment3, fragment3.mSavedFragmentState);
                            fragment3.performCreate(fragment3.mSavedFragmentState);
                            O00000Oo(fragment3, fragment3.mSavedFragmentState);
                            i6 = i6;
                        } else {
                            fragment3.restoreChildFragmentState(fragment3.mSavedFragmentState);
                            fragment3.mState = 1;
                            i6 = i6;
                        }
                    }
                    if (i6 > 0) {
                    }
                    if (i6 > 1) {
                    }
                    i6 = i6;
                    if (i6 > 2) {
                    }
                }
                i6 = i6;
                if (i6 > 3) {
                    if (O00000o0) {
                        Log.v("FragmentManager", "moveto RESUMED: ".concat(String.valueOf(fragment)));
                    }
                    fragment.performResume();
                    O00000Oo(fragment3, false);
                    fragment3.mSavedFragmentState = null;
                    fragment3.mSavedViewState = null;
                    i6 = i6;
                }
            } else {
                return;
            }
        } else if (fragment3.mState > i6) {
            int i8 = fragment3.mState;
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4) {
                            if (i6 < 4) {
                                if (O00000o0) {
                                    Log.v("FragmentManager", "movefrom RESUMED: ".concat(String.valueOf(fragment)));
                                }
                                fragment.performPause();
                                O0000oo(fragment);
                            }
                        }
                    }
                    if (i6 < 3) {
                        if (O00000o0) {
                            Log.v("FragmentManager", "movefrom STARTED: ".concat(String.valueOf(fragment)));
                        }
                        fragment.performStop();
                        O0000ooO(fragment);
                    }
                }
                if (i6 < 2) {
                    if (O00000o0) {
                        Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: ".concat(String.valueOf(fragment)));
                    }
                    if (fragment3.mView != null && this.O0000o.O00000Oo() && fragment3.mSavedViewState == null) {
                        O0000oOO(fragment);
                    }
                    fragment.performDestroyView();
                    O0000ooo(fragment);
                    if (!(fragment3.mView == null || fragment3.mContainer == null)) {
                        fragment3.mContainer.endViewTransition(fragment3.mView);
                        fragment3.mView.clearAnimation();
                        if (fragment.getParentFragment() == null || !fragment.getParentFragment().mRemoving) {
                            O000000o O000000o3 = (this.O0000o0o <= 0 || this.O0000ooO || fragment3.mView.getVisibility() != 0 || fragment3.mPostponedAlpha < 0.0f) ? null : O000000o(fragment3, i2, false, i3);
                            fragment3.mPostponedAlpha = 0.0f;
                            if (O000000o3 != null) {
                                O000000o(fragment3, O000000o3, i6);
                            }
                            fragment3.mContainer.removeView(fragment3.mView);
                        }
                    }
                    fragment3.mContainer = null;
                    fragment3.mView = null;
                    fragment3.mViewLifecycleOwner = null;
                    fragment3.mViewLifecycleOwnerLiveData.setValue(null);
                    fragment3.mInnerView = null;
                    fragment3.mInLayout = false;
                }
            }
            if (i6 <= 0) {
                if (this.O0000ooO) {
                    if (fragment.getAnimatingAway() != null) {
                        View animatingAway = fragment.getAnimatingAway();
                        fragment3.setAnimatingAway(null);
                        animatingAway.clearAnimation();
                    } else if (fragment.getAnimator() != null) {
                        Animator animator = fragment.getAnimator();
                        fragment3.setAnimator(null);
                        animator.cancel();
                    }
                }
                if (fragment.getAnimatingAway() == null && fragment.getAnimator() == null) {
                    if (O00000o0) {
                        Log.v("FragmentManager", "movefrom CREATED: ".concat(String.valueOf(fragment)));
                    }
                    boolean z3 = fragment3.mRemoving && !fragment.isInBackStack();
                    if (z3 || this.O000O0o0.O00000Oo(fragment3)) {
                        ed edVar2 = this.O0000o;
                        if (edVar2 instanceof fq) {
                            z2 = this.O000O0o0.O00000oO;
                        } else if (edVar2.O00000o0 instanceof Activity) {
                            z2 = true ^ ((Activity) this.O0000o.O00000o0).isChangingConfigurations();
                        }
                        if (z3 || z2) {
                            this.O000O0o0.O00000o(fragment3);
                        }
                        fragment.performDestroy();
                        O00oOooO(fragment);
                    } else {
                        fragment3.mState = 0;
                    }
                    fragment.performDetach();
                    O00oOooo(fragment);
                    if (!z) {
                        if (z3 || this.O000O0o0.O00000Oo(fragment3)) {
                            O0000oO0(fragment);
                        } else {
                            fragment3.mHost = null;
                            fragment3.mParentFragment = null;
                            fragment3.mFragmentManager = null;
                            if (!(fragment3.mTargetWho == null || (fragment2 = this.O0000OOo.get(fragment3.mTargetWho)) == null || !fragment2.getRetainInstance())) {
                                fragment3.mTarget = fragment2;
                            }
                        }
                    }
                } else {
                    fragment3.setStateAfterAnimating(i6);
                    if (fragment3.mState == z2) {
                        Log.w("FragmentManager", "moveToState: Fragment state for " + fragment3 + " not updated inline; expected state " + ((int) z2) + " found " + fragment3.mState);
                        fragment3.mState = z2;
                        return;
                    }
                    return;
                }
            }
        }
        z2 = i6;
        if (fragment3.mState == z2) {
        }
    }

    private void O000000o(final Fragment fragment, O000000o o000000o, int i) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i);
        if (o000000o.f15203O000000o != null) {
            O00000Oo o00000Oo = new O00000Oo(o000000o.f15203O000000o, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            o00000Oo.setAnimationListener(new Animation.AnimationListener() {
                /* class _m_j.ef.AnonymousClass3 */

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() {
                        /* class _m_j.ef.AnonymousClass3.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void
                         arg types: [androidx.fragment.app.Fragment, int, int, int, int]
                         candidates:
                          _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, _m_j.o0O0OOOo<androidx.fragment.app.Fragment>):int
                          _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, java.lang.String, int, int):boolean
                          _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void */
                        public final void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway(null);
                                ef.this.O000000o(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            fragment.mView.startAnimation(o00000Oo);
            return;
        }
        Animator animator = o000000o.O00000Oo;
        fragment.setAnimator(o000000o.O00000Oo);
        animator.addListener(new AnimatorListenerAdapter() {
            /* class _m_j.ef.AnonymousClass4 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void
             arg types: [androidx.fragment.app.Fragment, int, int, int, int]
             candidates:
              _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, _m_j.o0O0OOOo<androidx.fragment.app.Fragment>):int
              _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, java.lang.String, int, int):boolean
              _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void */
            public final void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                Animator animator2 = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator2 != null && viewGroup.indexOfChild(view) < 0) {
                    ef efVar = ef.this;
                    Fragment fragment = fragment;
                    efVar.O000000o(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        animator.setTarget(fragment.mView);
        animator.start();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void
     arg types: [androidx.fragment.app.Fragment, int, int, int, int]
     candidates:
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, _m_j.o0O0OOOo<androidx.fragment.app.Fragment>):int
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, java.lang.String, int, int):boolean
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void */
    private void O0000o0O(Fragment fragment) {
        O000000o(fragment, this.O0000o0o, 0, 0, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, boolean):void
     arg types: [androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, int]
     candidates:
      _m_j.ef.O000000o(float, float, float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, boolean, int):_m_j.ef$O000000o
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int):void
      _m_j.ef.O000000o(_m_j.dy, boolean, boolean, boolean):void
      _m_j.ef.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
      _m_j.ee.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, boolean):void */
    private void O0000o0o(Fragment fragment) {
        if (fragment.mFromLayout && !fragment.mPerformedCreateView) {
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            if (fragment.mView != null) {
                fragment.mInnerView = fragment.mView;
                fragment.mView.setSaveFromParentEnabled(false);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                O000000o(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                return;
            }
            fragment.mInnerView = null;
        }
    }

    private void O0000o(final Fragment fragment) {
        if (fragment.mView != null) {
            O000000o O000000o2 = O000000o(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (O000000o2 == null || O000000o2.O00000Oo == null) {
                if (O000000o2 != null) {
                    fragment.mView.startAnimation(O000000o2.f15203O000000o);
                    O000000o2.f15203O000000o.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                O000000o2.O00000Oo.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = fragment.mContainer;
                    final View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    O000000o2.O00000Oo.addListener(new AnimatorListenerAdapter() {
                        /* class _m_j.ef.AnonymousClass5 */

                        public final void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.mView != null && fragment.mHidden) {
                                fragment.mView.setVisibility(8);
                            }
                        }
                    });
                }
                O000000o2.O00000Oo.start();
            }
        }
        if (fragment.mAdded && O000O00o(fragment)) {
            this.O0000oOo = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void
     arg types: [androidx.fragment.app.Fragment, int, int, int, int]
     candidates:
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, _m_j.o0O0OOOo<androidx.fragment.app.Fragment>):int
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, java.lang.String, int, int):boolean
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, boolean, int):_m_j.ef$O000000o
     arg types: [androidx.fragment.app.Fragment, int, int, int]
     candidates:
      _m_j.ef.O000000o(float, float, float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, boolean):void
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int):void
      _m_j.ef.O000000o(_m_j.dy, boolean, boolean, boolean):void
      _m_j.ef.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
      _m_j.ee.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, boolean, int):_m_j.ef$O000000o */
    /* access modifiers changed from: package-private */
    public final void O00000oO(Fragment fragment) {
        ViewGroup viewGroup;
        int indexOfChild;
        int indexOfChild2;
        if (fragment != null) {
            if (this.O0000OOo.containsKey(fragment.mWho)) {
                int i = this.O0000o0o;
                if (fragment.mRemoving) {
                    if (fragment.isInBackStack()) {
                        i = Math.min(i, 1);
                    } else {
                        i = Math.min(i, 0);
                    }
                }
                O000000o(fragment, i, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
                if (fragment.mView != null) {
                    Fragment O0000oO2 = O0000oO(fragment);
                    if (O0000oO2 != null && (indexOfChild2 = viewGroup.indexOfChild(fragment.mView)) < (indexOfChild = (viewGroup = fragment.mContainer).indexOfChild(O0000oO2.mView))) {
                        viewGroup.removeViewAt(indexOfChild2);
                        viewGroup.addView(fragment.mView, indexOfChild);
                    }
                    if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                        if (fragment.mPostponedAlpha > 0.0f) {
                            fragment.mView.setAlpha(fragment.mPostponedAlpha);
                        }
                        fragment.mPostponedAlpha = 0.0f;
                        fragment.mIsNewlyAdded = false;
                        O000000o O000000o2 = O000000o(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                        if (O000000o2 != null) {
                            if (O000000o2.f15203O000000o != null) {
                                fragment.mView.startAnimation(O000000o2.f15203O000000o);
                            } else {
                                O000000o2.O00000Oo.setTarget(fragment.mView);
                                O000000o2.O00000Oo.start();
                            }
                        }
                    }
                }
                if (fragment.mHiddenChanged) {
                    O0000o(fragment);
                }
            } else if (O00000o0) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.O0000o0o + "since it is not added to " + this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, boolean z) {
        ed edVar;
        if (this.O0000o == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.O0000o0o) {
            this.O0000o0o = i;
            int size = this.O0000O0o.size();
            for (int i2 = 0; i2 < size; i2++) {
                O00000oO(this.O0000O0o.get(i2));
            }
            for (Fragment next : this.O0000OOo.values()) {
                if (next != null && ((next.mRemoving || next.mDetached) && !next.mIsNewlyAdded)) {
                    O00000oO(next);
                }
            }
            O0000oo();
            if (this.O0000oOo && (edVar = this.O0000o) != null && this.O0000o0o == 4) {
                edVar.O00000o();
                this.O0000oOo = false;
            }
        }
    }

    private void O0000oo() {
        for (Fragment next : this.O0000OOo.values()) {
            if (next != null) {
                O00000o(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000oo(Fragment fragment) {
        if (this.O0000OOo.get(fragment.mWho) == null) {
            this.O0000OOo.put(fragment.mWho, fragment);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    O00000Oo(fragment);
                } else {
                    O00000o0(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            if (O00000o0) {
                Log.v("FragmentManager", "Added fragment to active set ".concat(String.valueOf(fragment)));
            }
        }
    }

    private void O0000oO0(Fragment fragment) {
        if (this.O0000OOo.get(fragment.mWho) != null) {
            if (O00000o0) {
                Log.v("FragmentManager", "Removed fragment from active set ".concat(String.valueOf(fragment)));
            }
            for (Fragment next : this.O0000OOo.values()) {
                if (next != null && fragment.mWho.equals(next.mTargetWho)) {
                    next.mTarget = fragment;
                    next.mTargetWho = null;
                }
            }
            this.O0000OOo.put(fragment.mWho, null);
            O00000o0(fragment);
            if (fragment.mTargetWho != null) {
                fragment.mTarget = this.O0000OOo.get(fragment.mTargetWho);
            }
            fragment.initState();
        }
    }

    public final void O000000o(Fragment fragment, boolean z) {
        if (O00000o0) {
            Log.v("FragmentManager", "add: ".concat(String.valueOf(fragment)));
        }
        O00000oo(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (!this.O0000O0o.contains(fragment)) {
            synchronized (this.O0000O0o) {
                this.O0000O0o.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (O000O00o(fragment)) {
                this.O0000oOo = true;
            }
            if (z) {
                O0000o0O(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(fragment)));
    }

    public final void O0000O0o(Fragment fragment) {
        if (O00000o0) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.O0000O0o) {
                this.O0000O0o.remove(fragment);
            }
            if (O000O00o(fragment)) {
                this.O0000oOo = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public static void O0000OOo(Fragment fragment) {
        if (O00000o0) {
            Log.v("FragmentManager", "hide: ".concat(String.valueOf(fragment)));
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        }
    }

    public static void O0000Oo0(Fragment fragment) {
        if (O00000o0) {
            Log.v("FragmentManager", "show: ".concat(String.valueOf(fragment)));
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final void O0000Oo(Fragment fragment) {
        if (O00000o0) {
            Log.v("FragmentManager", "detach: ".concat(String.valueOf(fragment)));
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (O00000o0) {
                    Log.v("FragmentManager", "remove from detach: ".concat(String.valueOf(fragment)));
                }
                synchronized (this.O0000O0o) {
                    this.O0000O0o.remove(fragment);
                }
                if (O000O00o(fragment)) {
                    this.O0000oOo = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public final void O0000OoO(Fragment fragment) {
        if (O00000o0) {
            Log.v("FragmentManager", "attach: ".concat(String.valueOf(fragment)));
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (!this.O0000O0o.contains(fragment)) {
                if (O00000o0) {
                    Log.v("FragmentManager", "add from attach: ".concat(String.valueOf(fragment)));
                }
                synchronized (this.O0000O0o) {
                    this.O0000O0o.add(fragment);
                }
                fragment.mAdded = true;
                if (O000O00o(fragment)) {
                    this.O0000oOo = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(fragment)));
        }
    }

    public final Fragment O000000o(int i) {
        for (int size = this.O0000O0o.size() - 1; size >= 0; size--) {
            Fragment fragment = this.O0000O0o.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (Fragment next : this.O0000OOo.values()) {
            if (next != null && next.mFragmentId == i) {
                return next;
            }
        }
        return null;
    }

    public final Fragment O000000o(String str) {
        if (str != null) {
            for (int size = this.O0000O0o.size() - 1; size >= 0; size--) {
                Fragment fragment = this.O0000O0o.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment next : this.O0000OOo.values()) {
            if (next != null && str.equals(next.mTag)) {
                return next;
            }
        }
        return null;
    }

    public final Fragment O00000o0(String str) {
        Fragment findFragmentByWho;
        for (Fragment next : this.O0000OOo.values()) {
            if (next != null && (findFragmentByWho = next.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    private void O0000ooO() {
        if (O0000Oo0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final boolean O0000Oo0() {
        return this.O0000oo0 || this.O0000oo;
    }

    public final void O000000o(O0000O0o o0000O0o, boolean z) {
        if (!z) {
            O0000ooO();
        }
        synchronized (this) {
            if (!this.O0000ooO) {
                if (this.O0000o != null) {
                    if (this.O00000o == null) {
                        this.O00000o = new ArrayList<>();
                    }
                    this.O00000o.add(o0000O0o);
                    O0000OoO();
                    return;
                }
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O0000OoO() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = this.O00oOoOo != null && !this.O00oOoOo.isEmpty();
            if (this.O00000o != null && this.O00000o.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.O0000o.O00000o.removeCallbacks(this.O000O0o);
                this.O0000o.O00000o.post(this.O000O0o);
                O0000Oo();
            }
        }
    }

    public final int O000000o(dy dyVar) {
        synchronized (this) {
            if (this.O0000o0 != null) {
                if (this.O0000o0.size() > 0) {
                    int intValue = this.O0000o0.remove(this.O0000o0.size() - 1).intValue();
                    if (O00000o0) {
                        Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + dyVar);
                    }
                    this.O0000o00.set(intValue, dyVar);
                    return intValue;
                }
            }
            if (this.O0000o00 == null) {
                this.O0000o00 = new ArrayList<>();
            }
            int size = this.O0000o00.size();
            if (O00000o0) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + dyVar);
            }
            this.O0000o00.add(dyVar);
            return size;
        }
    }

    private void O000000o(int i, dy dyVar) {
        synchronized (this) {
            if (this.O0000o00 == null) {
                this.O0000o00 = new ArrayList<>();
            }
            int size = this.O0000o00.size();
            if (i < size) {
                if (O00000o0) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + dyVar);
                }
                this.O0000o00.set(i, dyVar);
            } else {
                while (size < i) {
                    this.O0000o00.add(null);
                    if (this.O0000o0 == null) {
                        this.O0000o0 = new ArrayList<>();
                    }
                    if (O00000o0) {
                        Log.v("FragmentManager", "Adding available back stack index ".concat(String.valueOf(size)));
                    }
                    this.O0000o0.add(Integer.valueOf(size));
                    size++;
                }
                if (O00000o0) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + dyVar);
                }
                this.O0000o00.add(dyVar);
            }
        }
    }

    private void O00000o0(boolean z) {
        if (this.O00000oO) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.O0000o == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.O0000o.O00000o.getLooper()) {
            if (!z) {
                O0000ooO();
            }
            if (this.O00oOooO == null) {
                this.O00oOooO = new ArrayList<>();
                this.O00oOooo = new ArrayList<>();
            }
            this.O00000oO = true;
            try {
                O000000o((ArrayList<dy>) null, (ArrayList<Boolean>) null);
            } finally {
                this.O00000oO = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    public final void O00000Oo(O0000O0o o0000O0o, boolean z) {
        if (!z || (this.O0000o != null && !this.O0000ooO)) {
            O00000o0(z);
            if (o0000O0o.O000000o(this.O00oOooO, this.O00oOooo)) {
                this.O00000oO = true;
                try {
                    O00000Oo(this.O00oOooO, this.O00oOooo);
                } finally {
                    O0000ooo();
                }
            }
            O0000Oo();
            O000O00o();
            O000O0Oo();
        }
    }

    private void O0000ooo() {
        this.O00000oO = false;
        this.O00oOooo.clear();
        this.O00oOooO.clear();
    }

    /* JADX INFO: finally extract failed */
    public final boolean O0000Ooo() {
        O00000o0(true);
        boolean z = false;
        while (O00000o0(this.O00oOooO, this.O00oOooo)) {
            this.O00000oO = true;
            try {
                O00000Oo(this.O00oOooO, this.O00oOooo);
                O0000ooo();
                z = true;
            } catch (Throwable th) {
                O0000ooo();
                throw th;
            }
        }
        O0000Oo();
        O000O00o();
        O000O0Oo();
        return z;
    }

    private void O000000o(ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<O0000Oo0> arrayList3 = this.O00oOoOo;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            O0000Oo0 o0000Oo0 = this.O00oOoOo.get(i);
            if (arrayList == null || o0000Oo0.f15208O000000o || (indexOf2 = arrayList.indexOf(o0000Oo0.O00000Oo)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if ((o0000Oo0.O00000o0 == 0) || (arrayList != null && o0000Oo0.O00000Oo.O000000o(arrayList, 0, arrayList.size()))) {
                    this.O00oOoOo.remove(i);
                    i--;
                    size--;
                    if (arrayList == null || o0000Oo0.f15208O000000o || (indexOf = arrayList.indexOf(o0000Oo0.O00000Oo)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        o0000Oo0.O00000o0();
                    } else {
                        o0000Oo0.O00000o();
                    }
                }
            } else {
                this.O00oOoOo.remove(i);
                i--;
                size--;
                o0000Oo0.O00000o();
            }
            i++;
        }
    }

    private void O00000Oo(ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            O000000o(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!arrayList.get(i).O0000oOO) {
                    if (i2 != i) {
                        O000000o(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (arrayList2.get(i).booleanValue()) {
                        while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).O0000oOO) {
                            i2++;
                        }
                    }
                    O000000o(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                O000000o(arrayList, arrayList2, i2, size);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ej.O000000o(_m_j.ef, java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, boolean):void
     arg types: [_m_j.ef, java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, int]
     candidates:
      _m_j.ej.O000000o(_m_j.el, java.lang.Object, java.lang.Object, java.lang.Object, androidx.fragment.app.Fragment, boolean):java.lang.Object
      _m_j.ej.O000000o(_m_j.el, java.lang.Object, java.lang.Object, _m_j.o0O0OOO0<java.lang.String, android.view.View>, boolean, _m_j.dy):void
      _m_j.ej.O000000o(_m_j.ef, java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      _m_j.ef.O000000o(float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(android.os.Bundle, java.lang.String):androidx.fragment.app.Fragment
      _m_j.ef.O000000o(int, _m_j.dy):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(_m_j.ef$O0000O0o, boolean):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, androidx.lifecycle.Lifecycle$State):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, boolean):void
      _m_j.ef.O000000o(android.view.Menu, android.view.MenuInflater):boolean
      _m_j.ee.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(int, boolean):void */
    private void O000000o(ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        ArrayList<dy> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i4 = i;
        int i5 = i2;
        boolean z = arrayList3.get(i4).O0000oOO;
        ArrayList<Fragment> arrayList5 = this.O000O00o;
        if (arrayList5 == null) {
            this.O000O00o = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.O000O00o.addAll(this.O0000O0o);
        Fragment fragment = this.O0000oOO;
        boolean z2 = false;
        for (int i6 = i4; i6 < i5; i6++) {
            dy dyVar = arrayList3.get(i6);
            if (!arrayList4.get(i6).booleanValue()) {
                fragment = dyVar.O000000o(this.O000O00o, fragment);
            } else {
                fragment = dyVar.O00000Oo(this.O000O00o, fragment);
            }
            z2 = z2 || dyVar.O0000OoO;
        }
        this.O000O00o.clear();
        if (!z) {
            ej.O000000o(this, arrayList, arrayList2, i, i2, false);
        }
        O00000Oo(arrayList, arrayList2, i, i2);
        if (z) {
            o0O0OOOo o0o0oooo = new o0O0OOOo();
            O00000Oo(o0o0oooo);
            int O000000o2 = O000000o(arrayList, arrayList2, i, i2, o0o0oooo);
            O000000o(o0o0oooo);
            i3 = O000000o2;
        } else {
            i3 = i5;
        }
        if (i3 != i4 && z) {
            ej.O000000o(this, arrayList, arrayList2, i, i3, true);
            O000000o(this.O0000o0o, true);
        }
        while (i4 < i5) {
            dy dyVar2 = arrayList3.get(i4);
            if (arrayList4.get(i4).booleanValue() && dyVar2.O00000o0 >= 0) {
                int i7 = dyVar2.O00000o0;
                synchronized (this) {
                    this.O0000o00.set(i7, null);
                    if (this.O0000o0 == null) {
                        this.O0000o0 = new ArrayList<>();
                    }
                    if (O00000o0) {
                        Log.v("FragmentManager", "Freeing back stack index ".concat(String.valueOf(i7)));
                    }
                    this.O0000o0.add(Integer.valueOf(i7));
                }
                dyVar2.O00000o0 = -1;
            }
            dyVar2.O000000o();
            i4++;
        }
        if (z2) {
            O000O0OO();
        }
    }

    private static void O000000o(o0O0OOOo<Fragment> o0o0oooo) {
        int size = o0o0oooo.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) o0o0oooo.f2239O000000o[i];
            if (!fragment.mAdded) {
                View requireView = fragment.requireView();
                fragment.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private int O000000o(ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, o0O0OOOo<Fragment> o0o0oooo) {
        boolean z;
        boolean z2;
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            dy dyVar = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            int i5 = 0;
            while (true) {
                z = true;
                if (i5 >= dyVar.O00000o.size()) {
                    z2 = false;
                    break;
                } else if (dy.O000000o((ei.O000000o) dyVar.O00000o.get(i5))) {
                    z2 = true;
                    break;
                } else {
                    i5++;
                }
            }
            if (!z2 || dyVar.O000000o(arrayList, i4 + 1, i2)) {
                z = false;
            }
            if (z) {
                if (this.O00oOoOo == null) {
                    this.O00oOoOo = new ArrayList<>();
                }
                O0000Oo0 o0000Oo0 = new O0000Oo0(dyVar, booleanValue);
                this.O00oOoOo.add(o0000Oo0);
                dyVar.O000000o(o0000Oo0);
                if (booleanValue) {
                    dyVar.O00000oo();
                } else {
                    dyVar.O000000o(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, dyVar);
                }
                O00000Oo(o0o0oooo);
            }
        }
        return i3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ej.O000000o(_m_j.ef, java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, boolean):void
     arg types: [_m_j.ef, java.util.ArrayList, java.util.ArrayList, int, int, int]
     candidates:
      _m_j.ej.O000000o(_m_j.el, java.lang.Object, java.lang.Object, java.lang.Object, androidx.fragment.app.Fragment, boolean):java.lang.Object
      _m_j.ej.O000000o(_m_j.el, java.lang.Object, java.lang.Object, _m_j.o0O0OOO0<java.lang.String, android.view.View>, boolean, _m_j.dy):void
      _m_j.ej.O000000o(_m_j.ef, java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      _m_j.ef.O000000o(float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(android.os.Bundle, java.lang.String):androidx.fragment.app.Fragment
      _m_j.ef.O000000o(int, _m_j.dy):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(_m_j.ef$O0000O0o, boolean):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, androidx.lifecycle.Lifecycle$State):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, boolean):void
      _m_j.ef.O000000o(android.view.Menu, android.view.MenuInflater):boolean
      _m_j.ee.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(int, boolean):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(dy dyVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            dyVar.O000000o(z3);
        } else {
            dyVar.O00000oo();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(dyVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            ej.O000000o(this, (ArrayList<dy>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            O000000o(this.O0000o0o, true);
        }
        for (Fragment next : this.O0000OOo.values()) {
            if (next != null && next.mView != null && next.mIsNewlyAdded && dyVar.O00000Oo(next.mContainerId)) {
                if (next.mPostponedAlpha > 0.0f) {
                    next.mView.setAlpha(next.mPostponedAlpha);
                }
                if (z3) {
                    next.mPostponedAlpha = 0.0f;
                } else {
                    next.mPostponedAlpha = -1.0f;
                    next.mIsNewlyAdded = false;
                }
            }
        }
    }

    private Fragment O0000oO(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.O0000O0o.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.O0000O0o.get(indexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private static void O00000Oo(ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            dy dyVar = arrayList.get(i);
            boolean z = true;
            if (arrayList2.get(i).booleanValue()) {
                dyVar.O000000o(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                dyVar.O000000o(z);
            } else {
                dyVar.O000000o(1);
                dyVar.O00000oo();
            }
            i++;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void
     arg types: [androidx.fragment.app.Fragment, int, int, int, int]
     candidates:
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, _m_j.o0O0OOOo<androidx.fragment.app.Fragment>):int
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, java.lang.String, int, int):boolean
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void */
    private void O00000Oo(o0O0OOOo<Fragment> o0o0oooo) {
        int i = this.O0000o0o;
        if (i > 0) {
            int min = Math.min(i, 3);
            int size = this.O0000O0o.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.O0000O0o.get(i2);
                if (fragment.mState < min) {
                    O000000o(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        o0o0oooo.add(fragment);
                    }
                }
            }
        }
    }

    private void O00oOooO() {
        if (this.O00oOoOo != null) {
            while (!this.O00oOoOo.isEmpty()) {
                this.O00oOoOo.remove(0).O00000o0();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void
     arg types: [androidx.fragment.app.Fragment, int, int, int, int]
     candidates:
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, _m_j.o0O0OOOo<androidx.fragment.app.Fragment>):int
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, java.lang.String, int, int):boolean
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void */
    private void O00oOooo() {
        for (Fragment next : this.O0000OOo.values()) {
            if (next != null) {
                if (next.getAnimatingAway() != null) {
                    int stateAfterAnimating = next.getStateAfterAnimating();
                    View animatingAway = next.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    next.setAnimatingAway(null);
                    O000000o(next, stateAfterAnimating, 0, 0, false);
                } else if (next.getAnimator() != null) {
                    next.getAnimator().end();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        return false;
     */
    private boolean O00000o0(ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.O00000o != null) {
                if (this.O00000o.size() != 0) {
                    int size = this.O00000o.size();
                    boolean z = false;
                    for (int i = 0; i < size; i++) {
                        z |= this.O00000o.get(i).O000000o(arrayList, arrayList2);
                    }
                    this.O00000o.clear();
                    this.O0000o.O00000o.removeCallbacks(this.O000O0o);
                    return z;
                }
            }
        }
    }

    private void O000O00o() {
        if (this.O0000ooo) {
            this.O0000ooo = false;
            O0000oo();
        }
    }

    private void O000O0OO() {
        if (this.O0000o0O != null) {
            for (int i = 0; i < this.O0000o0O.size(); i++) {
                this.O0000o0O.get(i).O000000o();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList<dy> arrayList3 = this.O0000Oo0;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.O0000Oo0.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i >= 0) {
                i3 = this.O0000Oo0.size() - 1;
                while (i3 >= 0) {
                    dy dyVar = this.O0000Oo0.get(i3);
                    if ((str != null && str.equals(dyVar.O0000o00)) || (i >= 0 && i == dyVar.O00000o0)) {
                        break;
                    }
                    i3--;
                }
                if (i3 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        i3--;
                        if (i3 < 0) {
                            break;
                        }
                        dy dyVar2 = this.O0000Oo0.get(i3);
                        if ((str == null || !str.equals(dyVar2.O0000o00)) && (i < 0 || i != dyVar2.O00000o0)) {
                            break;
                        }
                    }
                }
            } else {
                i3 = -1;
            }
            if (i3 == this.O0000Oo0.size() - 1) {
                return false;
            }
            for (int size2 = this.O0000Oo0.size() - 1; size2 > i3; size2--) {
                arrayList.add(this.O0000Oo0.remove(size2));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    private void O0000oOO(Fragment fragment) {
        if (fragment.mInnerView != null) {
            SparseArray<Parcelable> sparseArray = this.O000O0Oo;
            if (sparseArray == null) {
                this.O000O0Oo = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.O000O0Oo);
            if (this.O000O0Oo.size() > 0) {
                fragment.mSavedViewState = this.O000O0Oo;
                this.O000O0Oo = null;
            }
        }
    }

    private Bundle O0000oOo(Fragment fragment) {
        Bundle bundle;
        if (this.O000O0OO == null) {
            this.O000O0OO = new Bundle();
        }
        fragment.performSaveInstanceState(this.O000O0OO);
        O00000o(fragment, this.O000O0OO);
        if (!this.O000O0OO.isEmpty()) {
            bundle = this.O000O0OO;
            this.O000O0OO = null;
        } else {
            bundle = null;
        }
        if (fragment.mView != null) {
            O0000oOO(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    public final Parcelable O0000o00() {
        ArrayList<String> arrayList;
        int size;
        O00oOooO();
        O00oOooo();
        O0000Ooo();
        this.O0000oo0 = true;
        BackStackState[] backStackStateArr = null;
        if (this.O0000OOo.isEmpty()) {
            return null;
        }
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(this.O0000OOo.size());
        boolean z = false;
        for (Fragment next : this.O0000OOo.values()) {
            if (next != null) {
                if (next.mFragmentManager != this) {
                    O000000o(new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                }
                FragmentState fragmentState = new FragmentState(next);
                arrayList2.add(fragmentState);
                if (next.mState <= 0 || fragmentState.O0000o00 != null) {
                    fragmentState.O0000o00 = next.mSavedFragmentState;
                } else {
                    fragmentState.O0000o00 = O0000oOo(next);
                    if (next.mTargetWho != null) {
                        Fragment fragment = this.O0000OOo.get(next.mTargetWho);
                        if (fragment == null) {
                            O000000o(new IllegalStateException("Failure saving state: " + next + " has target not in fragment manager: " + next.mTargetWho));
                        }
                        if (fragmentState.O0000o00 == null) {
                            fragmentState.O0000o00 = new Bundle();
                        }
                        O000000o(fragmentState.O0000o00, "android:target_state", fragment);
                        if (next.mTargetRequestCode != 0) {
                            fragmentState.O0000o00.putInt("android:target_req_state", next.mTargetRequestCode);
                        }
                    }
                }
                if (O00000o0) {
                    Log.v("FragmentManager", "Saved state of " + next + ": " + fragmentState.O0000o00);
                }
                z = true;
            }
        }
        if (!z) {
            if (O00000o0) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.O0000O0o.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<Fragment> it = this.O0000O0o.iterator();
            while (it.hasNext()) {
                Fragment next2 = it.next();
                arrayList.add(next2.mWho);
                if (next2.mFragmentManager != this) {
                    O000000o(new IllegalStateException("Failure saving state: active " + next2 + " was removed from the FragmentManager"));
                }
                if (O00000o0) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next2.mWho + "): " + next2);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<dy> arrayList3 = this.O0000Oo0;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i = 0; i < size; i++) {
                backStackStateArr[i] = new BackStackState(this.O0000Oo0.get(i));
                if (O00000o0) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.O0000Oo0.get(i));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f2865O000000o = arrayList2;
        fragmentManagerState.O00000Oo = arrayList;
        fragmentManagerState.O00000o0 = backStackStateArr;
        Fragment fragment2 = this.O0000oOO;
        if (fragment2 != null) {
            fragmentManagerState.O00000o = fragment2.mWho;
        }
        fragmentManagerState.O00000oO = this.O00000oo;
        return fragmentManagerState;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void
     arg types: [androidx.fragment.app.Fragment, int, int, int, int]
     candidates:
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, _m_j.o0O0OOOo<androidx.fragment.app.Fragment>):int
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, java.lang.String, int, int):boolean
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dy.O000000o(java.lang.String, java.io.PrintWriter, boolean):void
     arg types: [java.lang.String, java.io.PrintWriter, int]
     candidates:
      _m_j.dy.O000000o(java.util.ArrayList<_m_j.dy>, int, int):boolean
      _m_j.ei.O000000o(int, androidx.fragment.app.Fragment, java.lang.String):_m_j.ei
      _m_j.dy.O000000o(java.lang.String, java.io.PrintWriter, boolean):void */
    public final void O000000o(Parcelable parcelable) {
        FragmentState fragmentState;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f2865O000000o != null) {
                for (Fragment next : this.O000O0o0.f15238O000000o) {
                    if (O00000o0) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained ".concat(String.valueOf(next)));
                    }
                    Iterator<FragmentState> it = fragmentManagerState.f2865O000000o.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            fragmentState = null;
                            break;
                        }
                        fragmentState = it.next();
                        if (fragmentState.O00000Oo.equals(next.mWho)) {
                            break;
                        }
                    }
                    if (fragmentState == null) {
                        if (O00000o0) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + next + " that was not found in the set of active Fragments " + fragmentManagerState.f2865O000000o);
                        }
                        Fragment fragment = next;
                        O000000o(fragment, 1, 0, 0, false);
                        next.mRemoving = true;
                        O000000o(fragment, 0, 0, 0, false);
                    } else {
                        fragmentState.O0000o0 = next;
                        next.mSavedViewState = null;
                        next.mBackStackNesting = 0;
                        next.mInLayout = false;
                        next.mAdded = false;
                        next.mTargetWho = next.mTarget != null ? next.mTarget.mWho : null;
                        next.mTarget = null;
                        if (fragmentState.O0000o00 != null) {
                            fragmentState.O0000o00.setClassLoader(this.O0000o.O00000o0.getClassLoader());
                            next.mSavedViewState = fragmentState.O0000o00.getSparseParcelableArray("android:view_state");
                            next.mSavedFragmentState = fragmentState.O0000o00;
                        }
                    }
                }
                this.O0000OOo.clear();
                Iterator<FragmentState> it2 = fragmentManagerState.f2865O000000o.iterator();
                while (it2.hasNext()) {
                    FragmentState next2 = it2.next();
                    if (next2 != null) {
                        Fragment O000000o2 = next2.O000000o(this.O0000o.O00000o0.getClassLoader(), O0000OOo());
                        O000000o2.mFragmentManager = this;
                        if (O00000o0) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + O000000o2.mWho + "): " + O000000o2);
                        }
                        this.O0000OOo.put(O000000o2.mWho, O000000o2);
                        next2.O0000o0 = null;
                    }
                }
                this.O0000O0o.clear();
                if (fragmentManagerState.O00000Oo != null) {
                    Iterator<String> it3 = fragmentManagerState.O00000Oo.iterator();
                    while (it3.hasNext()) {
                        String next3 = it3.next();
                        Fragment fragment2 = this.O0000OOo.get(next3);
                        if (fragment2 == null) {
                            O000000o(new IllegalStateException("No instantiated fragment for (" + next3 + ")"));
                        }
                        fragment2.mAdded = true;
                        if (O00000o0) {
                            Log.v("FragmentManager", "restoreSaveState: added (" + next3 + "): " + fragment2);
                        }
                        if (!this.O0000O0o.contains(fragment2)) {
                            synchronized (this.O0000O0o) {
                                this.O0000O0o.add(fragment2);
                            }
                        } else {
                            throw new IllegalStateException("Already added ".concat(String.valueOf(fragment2)));
                        }
                    }
                }
                if (fragmentManagerState.O00000o0 != null) {
                    this.O0000Oo0 = new ArrayList<>(fragmentManagerState.O00000o0.length);
                    for (int i = 0; i < fragmentManagerState.O00000o0.length; i++) {
                        dy O000000o3 = fragmentManagerState.O00000o0[i].O000000o(this);
                        if (O00000o0) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + O000000o3.O00000o0 + "): " + O000000o3);
                            PrintWriter printWriter = new PrintWriter(new bc("FragmentManager"));
                            O000000o3.O000000o("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.O0000Oo0.add(O000000o3);
                        if (O000000o3.O00000o0 >= 0) {
                            O000000o(O000000o3.O00000o0, O000000o3);
                        }
                    }
                } else {
                    this.O0000Oo0 = null;
                }
                if (fragmentManagerState.O00000o != null) {
                    this.O0000oOO = this.O0000OOo.get(fragmentManagerState.O00000o);
                    O0000o00(this.O0000oOO);
                }
                this.O00000oo = fragmentManagerState.O00000oO;
            }
        }
    }

    private void O000O0Oo() {
        this.O0000OOo.values().removeAll(Collections.singleton(null));
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: _m_j.O0Oo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: androidx.fragment.app.Fragment} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void O000000o(ed edVar, ea eaVar, Fragment fragment) {
        if (this.O0000o == null) {
            this.O0000o = edVar;
            this.O0000oO0 = eaVar;
            this.O0000oO = fragment;
            if (this.O0000oO != null) {
                O0000Oo();
            }
            if (edVar instanceof O0Oo) {
                O0Oo o0Oo = (O0Oo) edVar;
                this.O0000OoO = o0Oo.getOnBackPressedDispatcher();
                Fragment fragment2 = o0Oo;
                if (fragment != null) {
                    fragment2 = fragment;
                }
                this.O0000OoO.O000000o(fragment2, this.O0000Ooo);
            }
            if (fragment != null) {
                this.O000O0o0 = fragment.mFragmentManager.O0000o0(fragment);
            } else if (edVar instanceof fq) {
                this.O000O0o0 = eg.O000000o(((fq) edVar).getViewModelStore());
            } else {
                this.O000O0o0 = new eg(false);
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public final void O0000o0() {
        this.O0000oo0 = false;
        this.O0000oo = false;
        int size = this.O0000O0o.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.O0000O0o.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final void O0000o0O() {
        this.O0000oo0 = false;
        this.O0000oo = false;
        O00000o0(1);
    }

    public final void O0000o0o() {
        this.O0000oo0 = false;
        this.O0000oo = false;
        O00000o0(2);
    }

    public final void O0000o() {
        this.O0000oo0 = false;
        this.O0000oo = false;
        O00000o0(3);
    }

    public final void O0000oO0() {
        this.O0000oo0 = false;
        this.O0000oo = false;
        O00000o0(4);
    }

    public final void O0000oO() {
        this.O0000oo = true;
        O00000o0(2);
    }

    public final void O0000oOO() {
        this.O0000ooO = true;
        O0000Ooo();
        O00000o0(0);
        this.O0000o = null;
        this.O0000oO0 = null;
        this.O0000oO = null;
        if (this.O0000OoO != null) {
            this.O0000Ooo.O000000o();
            this.O0000OoO = null;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      _m_j.ef.O000000o(float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(android.os.Bundle, java.lang.String):androidx.fragment.app.Fragment
      _m_j.ef.O000000o(int, _m_j.dy):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(_m_j.ef$O0000O0o, boolean):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, androidx.lifecycle.Lifecycle$State):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, boolean):void
      _m_j.ef.O000000o(android.view.Menu, android.view.MenuInflater):boolean
      _m_j.ee.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(int, boolean):void */
    public final void O00000o0(int i) {
        try {
            this.O00000oO = true;
            O000000o(i, false);
            this.O00000oO = false;
            O0000Ooo();
        } catch (Throwable th) {
            this.O00000oO = false;
            throw th;
        }
    }

    public final void O000000o(boolean z) {
        for (int size = this.O0000O0o.size() - 1; size >= 0; size--) {
            Fragment fragment = this.O0000O0o.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public final void O00000Oo(boolean z) {
        for (int size = this.O0000O0o.size() - 1; size >= 0; size--) {
            Fragment fragment = this.O0000O0o.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public final void O000000o(Configuration configuration) {
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            Fragment fragment = this.O0000O0o.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public final void O0000oOo() {
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            Fragment fragment = this.O0000O0o.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public final boolean O000000o(Menu menu, MenuInflater menuInflater) {
        if (this.O0000o0o <= 0) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            Fragment fragment = this.O0000O0o.get(i);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.O0000Oo != null) {
            for (int i2 = 0; i2 < this.O0000Oo.size(); i2++) {
                Fragment fragment2 = this.O0000Oo.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.O0000Oo = arrayList;
        return z;
    }

    public final boolean O000000o(Menu menu) {
        if (this.O0000o0o <= 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            Fragment fragment = this.O0000O0o.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final boolean O000000o(MenuItem menuItem) {
        if (this.O0000o0o <= 0) {
            return false;
        }
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            Fragment fragment = this.O0000O0o.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean O00000Oo(MenuItem menuItem) {
        if (this.O0000o0o <= 0) {
            return false;
        }
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            Fragment fragment = this.O0000O0o.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void O00000Oo(Menu menu) {
        if (this.O0000o0o > 0) {
            for (int i = 0; i < this.O0000O0o.size(); i++) {
                Fragment fragment = this.O0000O0o.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public final void O0000Ooo(Fragment fragment) {
        if (fragment == null || (this.O0000OOo.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            Fragment fragment2 = this.O0000oOO;
            this.O0000oOO = fragment;
            O0000o00(fragment2);
            O0000o00(this.O0000oOO);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void O0000o00(Fragment fragment) {
        if (fragment != null && this.O0000OOo.get(fragment.mWho) == fragment) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public final void O000000o(Fragment fragment, Lifecycle.State state) {
        if (this.O0000OOo.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final ec O0000OOo() {
        ef efVar = this;
        while (true) {
            if (super.O0000OOo() == f15189O000000o) {
                Fragment fragment = efVar.O0000oO;
                if (fragment == null) {
                    efVar.O00000Oo = new ec() {
                        /* class _m_j.ef.AnonymousClass6 */

                        public final Fragment O00000o0(ClassLoader classLoader, String str) {
                            return Fragment.instantiate(ef.this.O0000o.O00000o0, str, null);
                        }
                    };
                    break;
                }
                efVar = fragment.mFragmentManager;
            } else {
                break;
            }
        }
        return super.O0000OOo();
    }

    public final void O000000o(ee.O000000o o000000o, boolean z) {
        this.O000OO00.add(new O00000o0(o000000o, z));
    }

    public final void O000000o(ee.O000000o o000000o) {
        synchronized (this.O000OO00) {
            int i = 0;
            int size = this.O000OO00.size();
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.O000OO00.get(i).f15206O000000o == o000000o) {
                    this.O000OO00.remove(i);
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    private void O000000o(Fragment fragment, Context context) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O000000o(fragment, context);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void O00000Oo(Fragment fragment, Context context) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O00000Oo(fragment, context);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void O000000o(Fragment fragment, Bundle bundle) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O000000o(fragment, bundle);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void O00000Oo(Fragment fragment, Bundle bundle) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O00000Oo(fragment, bundle);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void O00000o0(Fragment fragment, Bundle bundle) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O00000o0(fragment, bundle);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, boolean):void
     arg types: [androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, int]
     candidates:
      _m_j.ef.O000000o(float, float, float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, boolean, int):_m_j.ef$O000000o
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int):void
      _m_j.ef.O000000o(_m_j.dy, boolean, boolean, boolean):void
      _m_j.ef.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
      _m_j.ee.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, boolean):void */
    private void O000000o(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O000000o(fragment, view, bundle, true);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            O00000o0 next = it.next();
            if (!z || next.O00000Oo) {
                next.f15206O000000o.O000000o(this, fragment, view);
            }
        }
    }

    private void O0000oo0(Fragment fragment) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O0000oo0(fragment);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, boolean):void
     arg types: [androidx.fragment.app.Fragment, int]
     candidates:
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O00000Oo(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O00000Oo(_m_j.ef$O0000O0o, boolean):void
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, boolean):void */
    private void O00000Oo(Fragment fragment, boolean z) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O00000Oo(fragment, true);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            O00000o0 next = it.next();
            if (!z || next.O00000Oo) {
                next.f15206O000000o.O000000o(fragment);
            }
        }
    }

    private void O0000oo(Fragment fragment) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O0000oo(fragment);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void O0000ooO(Fragment fragment) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O0000ooO(fragment);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void O00000o(Fragment fragment, Bundle bundle) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O00000o(fragment, bundle);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void O0000ooo(Fragment fragment) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O0000ooo(fragment);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void O00oOooO(Fragment fragment) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O00oOooO(fragment);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void O00oOooo(Fragment fragment) {
        Fragment fragment2 = this.O0000oO;
        if (fragment2 != null) {
            ee fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof ef) {
                ((ef) fragmentManager).O00oOooo(fragment);
            }
        }
        Iterator<O00000o0> it = this.O000OO00.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private boolean O00oOoOo() {
        boolean z = false;
        for (Fragment next : this.O0000OOo.values()) {
            if (next != null) {
                z = O000O00o(next);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean O000O00o(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.O00oOoOo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, boolean):void
     arg types: [androidx.fragment.app.Fragment, int]
     candidates:
      _m_j.ef.O000000o(float, float):_m_j.ef$O000000o
      _m_j.ef.O000000o(android.os.Bundle, java.lang.String):androidx.fragment.app.Fragment
      _m_j.ef.O000000o(int, _m_j.dy):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O000000o(int, boolean):void
      _m_j.ef.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(_m_j.ef$O0000O0o, boolean):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, androidx.lifecycle.Lifecycle$State):void
      _m_j.ef.O000000o(android.view.Menu, android.view.MenuInflater):boolean
      _m_j.ee.O000000o(_m_j.ee$O000000o, boolean):void
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void
     arg types: [androidx.fragment.app.Fragment, int, int, int, int]
     candidates:
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int, _m_j.o0O0OOOo<androidx.fragment.app.Fragment>):int
      _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, java.lang.String, int, int):boolean
      _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, int, int, boolean):void */
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        Fragment fragment2 = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O00000o.f15205O000000o);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str2 == null || !ec.O000000o(context.getClassLoader(), str2)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        if (resourceId != -1) {
            fragment2 = O000000o(resourceId);
        }
        if (fragment2 == null && string != null) {
            fragment2 = O000000o(string);
        }
        if (fragment2 == null && i != -1) {
            fragment2 = O000000o(i);
        }
        if (O00000o0) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + fragment2);
        }
        if (fragment2 == null) {
            Fragment O00000o02 = O0000OOo().O00000o0(context.getClassLoader(), str2);
            O00000o02.mFromLayout = true;
            O00000o02.mFragmentId = resourceId != 0 ? resourceId : i;
            O00000o02.mContainerId = i;
            O00000o02.mTag = string;
            O00000o02.mInLayout = true;
            O00000o02.mFragmentManager = this;
            ed edVar = this.O0000o;
            O00000o02.mHost = edVar;
            O00000o02.onInflate(edVar.O00000o0, attributeSet, O00000o02.mSavedFragmentState);
            O000000o(O00000o02, true);
            fragment = O00000o02;
        } else if (!fragment2.mInLayout) {
            fragment2.mInLayout = true;
            ed edVar2 = this.O0000o;
            fragment2.mHost = edVar2;
            fragment2.onInflate(edVar2.O00000o0, attributeSet, fragment2.mSavedFragmentState);
            fragment = fragment2;
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str2);
        }
        if (this.O0000o0o > 0 || !fragment.mFromLayout) {
            O0000o0O(fragment);
        } else {
            O000000o(fragment, 1, 0, 0, false);
        }
        if (fragment.mView != null) {
            if (resourceId != 0) {
                fragment.mView.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    class O0000OOo implements O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f15207O000000o;
        final int O00000Oo;
        final int O00000o0;

        O0000OOo(String str, int i, int i2) {
            this.f15207O000000o = str;
            this.O00000Oo = i;
            this.O00000o0 = i2;
        }

        public final boolean O000000o(ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2) {
            if (ef.this.O0000oOO != null && this.O00000Oo < 0 && this.f15207O000000o == null && ef.this.O0000oOO.getChildFragmentManager().O00000o()) {
                return false;
            }
            return ef.this.O000000o(arrayList, arrayList2, this.f15207O000000o, this.O00000Oo, this.O00000o0);
        }
    }

    static class O0000Oo0 implements Fragment.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final boolean f15208O000000o;
        final dy O00000Oo;
        int O00000o0;

        O0000Oo0(dy dyVar, boolean z) {
            this.f15208O000000o = z;
            this.O00000Oo = dyVar;
        }

        public final void O000000o() {
            this.O00000o0--;
            if (this.O00000o0 == 0) {
                this.O00000Oo.f15052O000000o.O0000OoO();
            }
        }

        public final void O00000Oo() {
            this.O00000o0++;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ef.O000000o(_m_j.dy, boolean, boolean, boolean):void
         arg types: [_m_j.dy, boolean, boolean, int]
         candidates:
          _m_j.ef.O000000o(float, float, float, float):_m_j.ef$O000000o
          _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, boolean, int):_m_j.ef$O000000o
          _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, boolean):void
          _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int):void
          _m_j.ef.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
          _m_j.ee.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
          _m_j.ef.O000000o(_m_j.dy, boolean, boolean, boolean):void */
        public final void O00000o0() {
            boolean z = this.O00000o0 > 0;
            ef efVar = this.O00000Oo.f15052O000000o;
            int size = efVar.O0000O0o.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = efVar.O0000O0o.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            this.O00000Oo.f15052O000000o.O000000o(this.O00000Oo, this.f15208O000000o, !z, true);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ef.O000000o(_m_j.dy, boolean, boolean, boolean):void
         arg types: [_m_j.dy, boolean, int, int]
         candidates:
          _m_j.ef.O000000o(float, float, float, float):_m_j.ef$O000000o
          _m_j.ef.O000000o(androidx.fragment.app.Fragment, int, boolean, int):_m_j.ef$O000000o
          _m_j.ef.O000000o(androidx.fragment.app.Fragment, android.view.View, android.os.Bundle, boolean):void
          _m_j.ef.O000000o(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int):void
          _m_j.ef.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
          _m_j.ee.O000000o(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void
          _m_j.ef.O000000o(_m_j.dy, boolean, boolean, boolean):void */
        public final void O00000o() {
            this.O00000Oo.f15052O000000o.O000000o(this.O00000Oo, this.f15208O000000o, false, false);
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Animation f15203O000000o;
        public final Animator O00000Oo;

        O000000o(Animation animation) {
            this.f15203O000000o = animation;
            this.O00000Oo = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        O000000o(Animator animator) {
            this.f15203O000000o = null;
            this.O00000Oo = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    static class O00000Oo extends AnimationSet implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private final ViewGroup f15204O000000o;
        private final View O00000Oo;
        private boolean O00000o;
        private boolean O00000o0;
        private boolean O00000oO = true;

        O00000Oo(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f15204O000000o = viewGroup;
            this.O00000Oo = view;
            addAnimation(animation);
            this.f15204O000000o.post(this);
        }

        public final boolean getTransformation(long j, Transformation transformation) {
            this.O00000oO = true;
            if (!this.O00000o0) {
                if (!super.getTransformation(j, transformation)) {
                    this.O00000o0 = true;
                    bx.O000000o(this.f15204O000000o, this);
                }
                return true;
            } else if (!this.O00000o) {
                return true;
            } else {
                return false;
            }
        }

        public final boolean getTransformation(long j, Transformation transformation, float f) {
            this.O00000oO = true;
            if (!this.O00000o0) {
                if (!super.getTransformation(j, transformation, f)) {
                    this.O00000o0 = true;
                    bx.O000000o(this.f15204O000000o, this);
                }
                return true;
            } else if (!this.O00000o) {
                return true;
            } else {
                return false;
            }
        }

        public final void run() {
            if (this.O00000o0 || !this.O00000oO) {
                this.f15204O000000o.endViewTransition(this.O00000Oo);
                this.O00000o = true;
                return;
            }
            this.O00000oO = false;
            this.f15204O000000o.post(this);
        }
    }
}
