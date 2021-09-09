package _m_j;

import _m_j.ef;
import _m_j.ei;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.google.android.exoplayer2.C;
import java.io.PrintWriter;
import java.util.ArrayList;

public final class dy extends ei implements ef.O0000O0o {

    /* renamed from: O000000o  reason: collision with root package name */
    final ef f15052O000000o;
    boolean O00000Oo;
    public int O00000o0 = -1;

    public final String toString() {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.O00000o0 >= 0) {
            sb.append(" #");
            sb.append(this.O00000o0);
        }
        if (this.O0000o00 != null) {
            sb.append(" ");
            sb.append(this.O0000o00);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dy.O000000o(java.lang.String, java.io.PrintWriter, boolean):void
     arg types: [java.lang.String, java.io.PrintWriter, int]
     candidates:
      _m_j.dy.O000000o(java.util.ArrayList<_m_j.dy>, int, int):boolean
      _m_j.ei.O000000o(int, androidx.fragment.app.Fragment, java.lang.String):_m_j.ei
      _m_j.dy.O000000o(java.lang.String, java.io.PrintWriter, boolean):void */
    public final void O000000o(String str, PrintWriter printWriter) {
        O000000o(str, printWriter, true);
    }

    public final void O000000o(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.O0000o00);
            printWriter.print(" mIndex=");
            printWriter.print(this.O00000o0);
            printWriter.print(" mCommitted=");
            printWriter.println(this.O00000Oo);
            if (this.O0000Oo0 != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.O0000Oo0));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.O0000Oo));
            }
            if (!(this.O00000oO == 0 && this.O00000oo == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.O00000oO));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.O00000oo));
            }
            if (!(this.O0000O0o == 0 && this.O0000OOo == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.O0000O0o));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.O0000OOo));
            }
            if (!(this.O0000o0 == 0 && this.O0000o0O == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.O0000o0));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.O0000o0O);
            }
            if (!(this.O0000o0o == 0 && this.O0000o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.O0000o0o));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.O0000o);
            }
        }
        if (!this.O00000o.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.O00000o.size();
            for (int i = 0; i < size; i++) {
                ei.O000000o o000000o = (ei.O000000o) this.O00000o.get(i);
                switch (o000000o.f15307O000000o) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + o000000o.f15307O000000o;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(o000000o.O00000Oo);
                if (z) {
                    if (!(o000000o.O00000o0 == 0 && o000000o.O00000o == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(o000000o.O00000o0));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(o000000o.O00000o));
                    }
                    if (o000000o.O00000oO != 0 || o000000o.O00000oo != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(o000000o.O00000oO));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(o000000o.O00000oo));
                    }
                }
            }
        }
    }

    public dy(ef efVar) {
        this.f15052O000000o = efVar;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, Fragment fragment, String str, int i2) {
        super.O000000o(i, fragment, str, i2);
        fragment.mFragmentManager = this.f15052O000000o;
    }

    public final ei O000000o(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f15052O000000o) {
            return super.O000000o(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final ei O00000Oo(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f15052O000000o) {
            return super.O00000Oo(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final ei O00000o0(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f15052O000000o) {
            return super.O00000o0(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final ei O00000o(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f15052O000000o) {
            return super.O00000o(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final ei O00000oO(Fragment fragment) {
        if (fragment == null || fragment.mFragmentManager == null || fragment.mFragmentManager == this.f15052O000000o) {
            return super.O00000oO(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final ei O000000o(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f15052O000000o) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f15052O000000o);
        } else if (state.isAtLeast(Lifecycle.State.CREATED)) {
            return super.O000000o(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + Lifecycle.State.CREATED);
        }
    }

    public final void O000000o(int i) {
        if (this.O0000OoO) {
            if (ef.O00000o0) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.O00000o.size();
            for (int i2 = 0; i2 < size; i2++) {
                ei.O000000o o000000o = (ei.O000000o) this.O00000o.get(i2);
                if (o000000o.O00000Oo != null) {
                    o000000o.O00000Oo.mBackStackNesting += i;
                    if (ef.O00000o0) {
                        Log.v("FragmentManager", "Bump nesting of " + o000000o.O00000Oo + " to " + o000000o.O00000Oo.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final void O000000o() {
        if (this.O0000oOo != null) {
            for (int i = 0; i < this.O0000oOo.size(); i++) {
                ((Runnable) this.O0000oOo.get(i)).run();
            }
            this.O0000oOo = null;
        }
    }

    public final int O00000Oo() {
        return O00000Oo(false);
    }

    public final int O00000o0() {
        return O00000Oo(true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O00000Oo(_m_j.ef$O0000O0o, boolean):void
     arg types: [_m_j.dy, int]
     candidates:
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, boolean):void
      _m_j.ef.O00000Oo(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O00000Oo(_m_j.ef$O0000O0o, boolean):void */
    public final void O00000o() {
        O0000OOo();
        this.f15052O000000o.O00000Oo((ef.O0000O0o) this, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ef.O00000Oo(_m_j.ef$O0000O0o, boolean):void
     arg types: [_m_j.dy, int]
     candidates:
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, android.content.Context):void
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, android.os.Bundle):void
      _m_j.ef.O00000Oo(androidx.fragment.app.Fragment, boolean):void
      _m_j.ef.O00000Oo(java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>):void
      _m_j.ef.O00000Oo(_m_j.ef$O0000O0o, boolean):void */
    public final void O00000oO() {
        O0000OOo();
        this.f15052O000000o.O00000Oo((ef.O0000O0o) this, true);
    }

    private int O00000Oo(boolean z) {
        if (!this.O00000Oo) {
            if (ef.O00000o0) {
                Log.v("FragmentManager", "Commit: ".concat(String.valueOf(this)));
                PrintWriter printWriter = new PrintWriter(new bc("FragmentManager"));
                O000000o("  ", printWriter);
                printWriter.close();
            }
            this.O00000Oo = true;
            if (this.O0000OoO) {
                this.O00000o0 = this.f15052O000000o.O000000o(this);
            } else {
                this.O00000o0 = -1;
            }
            this.f15052O000000o.O000000o(this, z);
            return this.O00000o0;
        }
        throw new IllegalStateException("commit already called");
    }

    public final boolean O000000o(ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2) {
        if (ef.O00000o0) {
            Log.v("FragmentManager", "Run: ".concat(String.valueOf(this)));
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.O0000OoO) {
            return true;
        }
        ef efVar = this.f15052O000000o;
        if (efVar.O0000Oo0 == null) {
            efVar.O0000Oo0 = new ArrayList<>();
        }
        efVar.O0000Oo0.add(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo(int i) {
        int size = this.O00000o.size();
        for (int i2 = 0; i2 < size; i2++) {
            ei.O000000o o000000o = (ei.O000000o) this.O00000o.get(i2);
            int i3 = o000000o.O00000Oo != null ? o000000o.O00000Oo.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(ArrayList<dy> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.O00000o.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            ei.O000000o o000000o = (ei.O000000o) this.O00000o.get(i4);
            int i5 = o000000o.O00000Oo != null ? o000000o.O00000Oo.mContainerId : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    dy dyVar = arrayList.get(i6);
                    int size2 = dyVar.O00000o.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        ei.O000000o o000000o2 = (ei.O000000o) dyVar.O00000o.get(i7);
                        if ((o000000o2.O00000Oo != null ? o000000o2.O00000Oo.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
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
    public final void O00000oo() {
        int size = this.O00000o.size();
        for (int i = 0; i < size; i++) {
            ei.O000000o o000000o = (ei.O000000o) this.O00000o.get(i);
            Fragment fragment = o000000o.O00000Oo;
            if (fragment != null) {
                fragment.setNextTransition(this.O0000Oo0, this.O0000Oo);
            }
            switch (o000000o.f15307O000000o) {
                case 1:
                    fragment.setNextAnim(o000000o.O00000o0);
                    this.f15052O000000o.O000000o(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + o000000o.f15307O000000o);
                case 3:
                    fragment.setNextAnim(o000000o.O00000o);
                    this.f15052O000000o.O0000O0o(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(o000000o.O00000o);
                    ef.O0000OOo(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(o000000o.O00000o0);
                    ef.O0000Oo0(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(o000000o.O00000o);
                    this.f15052O000000o.O0000Oo(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(o000000o.O00000o0);
                    this.f15052O000000o.O0000OoO(fragment);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    this.f15052O000000o.O0000Ooo(fragment);
                    break;
                case 9:
                    this.f15052O000000o.O0000Ooo(null);
                    break;
                case 10:
                    this.f15052O000000o.O000000o(fragment, o000000o.O0000OOo);
                    break;
            }
            if (!(this.O0000oOO || o000000o.f15307O000000o == 1 || fragment == null)) {
                this.f15052O000000o.O00000oO(fragment);
            }
        }
        if (!this.O0000oOO) {
            ef efVar = this.f15052O000000o;
            efVar.O000000o(efVar.O0000o0o, true);
        }
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
    public final void O000000o(boolean z) {
        for (int size = this.O00000o.size() - 1; size >= 0; size--) {
            ei.O000000o o000000o = (ei.O000000o) this.O00000o.get(size);
            Fragment fragment = o000000o.O00000Oo;
            if (fragment != null) {
                fragment.setNextTransition(ef.O00000o(this.O0000Oo0), this.O0000Oo);
            }
            switch (o000000o.f15307O000000o) {
                case 1:
                    fragment.setNextAnim(o000000o.O00000oo);
                    this.f15052O000000o.O0000O0o(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + o000000o.f15307O000000o);
                case 3:
                    fragment.setNextAnim(o000000o.O00000oO);
                    this.f15052O000000o.O000000o(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(o000000o.O00000oO);
                    ef.O0000Oo0(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(o000000o.O00000oo);
                    ef.O0000OOo(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(o000000o.O00000oO);
                    this.f15052O000000o.O0000OoO(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(o000000o.O00000oo);
                    this.f15052O000000o.O0000Oo(fragment);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    this.f15052O000000o.O0000Ooo(null);
                    break;
                case 9:
                    this.f15052O000000o.O0000Ooo(fragment);
                    break;
                case 10:
                    this.f15052O000000o.O000000o(fragment, o000000o.O0000O0o);
                    break;
            }
            if (!(this.O0000oOO || o000000o.f15307O000000o == 3 || fragment == null)) {
                this.f15052O000000o.O00000oO(fragment);
            }
        }
        if (!this.O0000oOO && z) {
            ef efVar = this.f15052O000000o;
            efVar.O000000o(efVar.O0000o0o, true);
        }
    }

    /* access modifiers changed from: package-private */
    public final Fragment O000000o(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i;
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i < this.O00000o.size()) {
            ei.O000000o o000000o = (ei.O000000o) this.O00000o.get(i);
            int i3 = o000000o.f15307O000000o;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = o000000o.O00000Oo;
                    int i4 = fragment3.mContainerId;
                    Fragment fragment4 = fragment2;
                    int i5 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList2.get(size);
                        if (fragment5.mContainerId == i4) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.O00000o.add(i5, new ei.O000000o(9, fragment5));
                                    i5++;
                                    fragment4 = null;
                                }
                                ei.O000000o o000000o2 = new ei.O000000o(3, fragment5);
                                o000000o2.O00000o0 = o000000o.O00000o0;
                                o000000o2.O00000oO = o000000o.O00000oO;
                                o000000o2.O00000o = o000000o.O00000o;
                                o000000o2.O00000oo = o000000o.O00000oo;
                                this.O00000o.add(i5, o000000o2);
                                arrayList2.remove(fragment5);
                                i5++;
                            }
                        }
                    }
                    if (z) {
                        this.O00000o.remove(i5);
                        i = i5 - 1;
                    } else {
                        o000000o.f15307O000000o = 1;
                        arrayList2.add(fragment3);
                        i = i5;
                    }
                    fragment2 = fragment4;
                } else if (i3 == 3 || i3 == 6) {
                    arrayList2.remove(o000000o.O00000Oo);
                    if (o000000o.O00000Oo == fragment2) {
                        this.O00000o.add(i, new ei.O000000o(9, o000000o.O00000Oo));
                        i++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.O00000o.add(i, new ei.O000000o(9, fragment2));
                        i++;
                        fragment2 = o000000o.O00000Oo;
                    }
                }
                i2 = i + 1;
            }
            arrayList2.add(o000000o.O00000Oo);
            i2 = i + 1;
        }
        return fragment2;
    }

    /* access modifiers changed from: package-private */
    public final Fragment O00000Oo(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.O00000o.size() - 1; size >= 0; size--) {
            ei.O000000o o000000o = (ei.O000000o) this.O00000o.get(size);
            int i = o000000o.f15307O000000o;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            fragment = null;
                            break;
                        case 9:
                            fragment = o000000o.O00000Oo;
                            break;
                        case 10:
                            o000000o.O0000OOo = o000000o.O0000O0o;
                            break;
                    }
                }
                arrayList.add(o000000o.O00000Oo);
            }
            arrayList.remove(o000000o.O00000Oo);
        }
        return fragment;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Fragment.O00000Oo o00000Oo) {
        for (int i = 0; i < this.O00000o.size(); i++) {
            ei.O000000o o000000o = (ei.O000000o) this.O00000o.get(i);
            if (O000000o(o000000o)) {
                o000000o.O00000Oo.setOnStartEnterTransitionListener(o00000Oo);
            }
        }
    }

    static boolean O000000o(ei.O000000o o000000o) {
        Fragment fragment = o000000o.O00000Oo;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    public final boolean O0000O0o() {
        return this.O00000o.isEmpty();
    }
}
