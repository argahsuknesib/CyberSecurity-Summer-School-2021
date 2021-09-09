package _m_j;

import _m_j.ei;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class ej {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int[] f15327O000000o = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    private static final el O00000Oo = (Build.VERSION.SDK_INT >= 21 ? new ek() : null);
    private static final el O00000o0 = O000000o();

    private static el O000000o() {
        try {
            return (el) Class.forName("_m_j.ia").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x036f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0181 A[ADDED_TO_REGION] */
    static void O000000o(ef efVar, ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        SparseArray sparseArray;
        int i3;
        int i4;
        int i5;
        int i6;
        Fragment fragment;
        Fragment fragment2;
        el O000000o2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Fragment fragment3;
        Fragment fragment4;
        Object obj;
        Object obj2;
        Object obj3;
        O000000o o000000o;
        Object O000000o3;
        Object obj4;
        Object obj5;
        Object obj6;
        Fragment fragment5;
        Fragment fragment6;
        boolean z2;
        o0O0OOO0<String, String> o0o0ooo0;
        ArrayList arrayList5;
        Rect rect;
        ArrayList arrayList6;
        Fragment fragment7;
        Fragment fragment8;
        el O000000o4;
        ArrayList arrayList7;
        o0O0OOO0<String, String> o0o0ooo02;
        Fragment fragment9;
        boolean z3;
        Object obj7;
        Object O000000o5;
        ArrayList arrayList8;
        Object obj8;
        final Rect rect2;
        final View view;
        ef efVar2 = efVar;
        ArrayList<dy> arrayList9 = arrayList;
        ArrayList<Boolean> arrayList10 = arrayList2;
        int i7 = i2;
        boolean z4 = z;
        if (efVar2.O0000o0o > 0) {
            SparseArray sparseArray2 = new SparseArray();
            for (int i8 = i; i8 < i7; i8++) {
                dy dyVar = arrayList9.get(i8);
                if (arrayList10.get(i8).booleanValue()) {
                    O00000Oo(dyVar, sparseArray2, z4);
                } else {
                    O000000o(dyVar, sparseArray2, z4);
                }
            }
            if (sparseArray2.size() != 0) {
                View view2 = new View(efVar2.O0000o.O00000o0);
                int size = sparseArray2.size();
                int i9 = 0;
                while (i9 < size) {
                    int keyAt = sparseArray2.keyAt(i9);
                    o0O0OOO0<String, String> O000000o6 = O000000o(keyAt, arrayList9, arrayList10, i, i7);
                    O000000o o000000o2 = (O000000o) sparseArray2.valueAt(i9);
                    if (z4) {
                        ViewGroup viewGroup = efVar2.O0000oO0.O000000o() ? (ViewGroup) efVar2.O0000oO0.O000000o(keyAt) : null;
                        if (viewGroup == null || (O000000o4 = O000000o((fragment8 = o000000o2.O00000o), fragment7)) == null) {
                            sparseArray = sparseArray2;
                            i6 = i9;
                            i5 = size;
                        } else {
                            boolean z5 = o000000o2.O00000Oo;
                            boolean z6 = o000000o2.O00000oO;
                            ArrayList arrayList11 = new ArrayList();
                            ArrayList arrayList12 = new ArrayList();
                            sparseArray = sparseArray2;
                            Object O000000o7 = O000000o(O000000o4, (fragment7 = o000000o2.f15332O000000o), z5);
                            Object O00000Oo2 = O00000Oo(O000000o4, fragment8, z6);
                            Fragment fragment10 = o000000o2.f15332O000000o;
                            i6 = i9;
                            Fragment fragment11 = o000000o2.O00000o;
                            if (fragment10 != null) {
                                i5 = size;
                                fragment10.requireView().setVisibility(0);
                            } else {
                                i5 = size;
                            }
                            if (fragment10 == null || fragment11 == null) {
                                z3 = z5;
                                arrayList8 = arrayList11;
                                fragment9 = fragment7;
                            } else {
                                boolean z7 = o000000o2.O00000Oo;
                                if (O000000o6.isEmpty()) {
                                    z3 = z5;
                                    obj8 = null;
                                } else {
                                    obj8 = O000000o(O000000o4, fragment10, fragment11, z7);
                                    z3 = z5;
                                }
                                o0O0OOO0<String, View> O00000Oo3 = O00000Oo(O000000o4, O000000o6, obj8, o000000o2);
                                fragment9 = fragment7;
                                o0O0OOO0<String, View> O000000o8 = O000000o(O000000o4, O000000o6, obj8, o000000o2);
                                if (O000000o6.isEmpty()) {
                                    if (O00000Oo3 != null) {
                                        O00000Oo3.clear();
                                    }
                                    if (O000000o8 != null) {
                                        O000000o8.clear();
                                    }
                                    obj7 = null;
                                } else {
                                    O000000o(arrayList12, O00000Oo3, O000000o6.keySet());
                                    O000000o(arrayList11, O000000o8, O000000o6.values());
                                    obj7 = obj8;
                                }
                                if (O000000o7 == null && O00000Oo2 == null && obj7 == null) {
                                    arrayList8 = arrayList11;
                                } else {
                                    O000000o(fragment10, fragment11, z7, O00000Oo3);
                                    if (obj7 != null) {
                                        arrayList11.add(view2);
                                        O000000o4.O000000o(obj7, view2, (ArrayList<View>) arrayList12);
                                        o0o0ooo02 = O000000o6;
                                        arrayList7 = arrayList11;
                                        O000000o(O000000o4, obj7, O00000Oo2, O00000Oo3, o000000o2.O00000oO, o000000o2.O00000oo);
                                        Rect rect3 = new Rect();
                                        View O000000o9 = O000000o(O000000o8, o000000o2, O000000o7, z7);
                                        if (O000000o9 != null) {
                                            O000000o4.O000000o(O000000o7, rect3);
                                        }
                                        rect2 = rect3;
                                        view = O000000o9;
                                    } else {
                                        arrayList7 = arrayList11;
                                        o0o0ooo02 = O000000o6;
                                        view = null;
                                        rect2 = null;
                                    }
                                    final Fragment fragment12 = fragment10;
                                    final Fragment fragment13 = fragment11;
                                    final boolean z8 = z7;
                                    final o0O0OOO0<String, View> o0o0ooo03 = O000000o8;
                                    final el elVar = O000000o4;
                                    bx.O000000o(viewGroup, new Runnable() {
                                        /* class _m_j.ej.AnonymousClass3 */

                                        public final void run() {
                                            ej.O000000o(fragment12, fragment13, z8, o0o0ooo03);
                                            View view = view;
                                            if (view != null) {
                                                el.O000000o(view, rect2);
                                            }
                                        }
                                    });
                                    if (!(O000000o7 == null && obj7 == null && O00000Oo2 == null)) {
                                        final ArrayList<View> O000000o10 = O000000o(O000000o4, O00000Oo2, fragment8, arrayList12, view2);
                                        Fragment fragment14 = fragment9;
                                        ArrayList arrayList13 = arrayList7;
                                        ArrayList<View> O000000o11 = O000000o(O000000o4, O000000o7, fragment14, arrayList13, view2);
                                        O000000o(O000000o11, 4);
                                        O000000o5 = O000000o(O000000o4, O000000o7, O00000Oo2, obj7, fragment14, z3);
                                        if (O000000o5 != null) {
                                            if (fragment8 != null && O00000Oo2 != null && fragment8.mAdded && fragment8.mHidden && fragment8.mHiddenChanged) {
                                                fragment8.setHideReplaced(true);
                                                O000000o4.O00000Oo(O00000Oo2, fragment8.getView(), O000000o10);
                                                bx.O000000o(fragment8.mContainer, new Runnable() {
                                                    /* class _m_j.ej.AnonymousClass1 */

                                                    public final void run() {
                                                        ej.O000000o(O000000o10, 4);
                                                    }
                                                });
                                            }
                                            ArrayList<String> O000000o12 = el.O000000o((ArrayList<View>) arrayList13);
                                            O000000o4.O000000o(O000000o5, O000000o7, O000000o11, O00000Oo2, O000000o10, obj7, arrayList13);
                                            O000000o4.O000000o(viewGroup, O000000o5);
                                            O000000o4.O000000o(viewGroup, arrayList12, arrayList13, O000000o12, o0o0ooo02);
                                            O000000o(O000000o11, 0);
                                            O000000o4.O000000o(obj7, (ArrayList<View>) arrayList12, (ArrayList<View>) arrayList13);
                                        }
                                    }
                                }
                            }
                            o0o0ooo02 = O000000o6;
                            obj7 = null;
                            final ArrayList<View> O000000o102 = O000000o(O000000o4, O00000Oo2, fragment8, arrayList12, view2);
                            Fragment fragment142 = fragment9;
                            ArrayList arrayList132 = arrayList7;
                            ArrayList<View> O000000o112 = O000000o(O000000o4, O000000o7, fragment142, arrayList132, view2);
                            O000000o(O000000o112, 4);
                            O000000o5 = O000000o(O000000o4, O000000o7, O00000Oo2, obj7, fragment142, z3);
                            if (O000000o5 != null) {
                            }
                        }
                    } else {
                        ef efVar3 = efVar2;
                        sparseArray = sparseArray2;
                        o0O0OOO0<String, String> o0o0ooo04 = O000000o6;
                        i6 = i9;
                        i5 = size;
                        ViewGroup viewGroup2 = efVar3.O0000oO0.O000000o() ? (ViewGroup) efVar3.O0000oO0.O000000o(keyAt) : null;
                        if (!(viewGroup2 == null || (O000000o2 = O000000o((fragment2 = o000000o2.O00000o), fragment)) == null)) {
                            boolean z9 = o000000o2.O00000Oo;
                            boolean z10 = o000000o2.O00000oO;
                            Object O000000o13 = O000000o(O000000o2, (fragment = o000000o2.f15332O000000o), z9);
                            Object O00000Oo4 = O00000Oo(O000000o2, fragment2, z10);
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = new ArrayList();
                            Fragment fragment15 = o000000o2.f15332O000000o;
                            Fragment fragment16 = o000000o2.O00000o;
                            if (fragment15 == null || fragment16 == null) {
                                fragment4 = fragment;
                                fragment3 = fragment2;
                                obj3 = O00000Oo4;
                                obj4 = O000000o13;
                                o000000o = o000000o2;
                                arrayList4 = arrayList15;
                                i3 = i6;
                                i4 = i5;
                                arrayList3 = arrayList14;
                                obj = null;
                            } else {
                                boolean z11 = o000000o2.O00000Oo;
                                if (o0o0ooo04.isEmpty()) {
                                    obj5 = null;
                                } else {
                                    obj5 = O000000o(O000000o2, fragment15, fragment16, z11);
                                }
                                o0O0OOO0<String, String> o0o0ooo05 = o0o0ooo04;
                                o0O0OOO0<String, View> O00000Oo5 = O00000Oo(O000000o2, o0o0ooo05, obj5, o000000o2);
                                if (o0o0ooo05.isEmpty()) {
                                    obj6 = null;
                                } else {
                                    arrayList14.addAll(O00000Oo5.values());
                                    obj6 = obj5;
                                }
                                if (O000000o13 == null && O00000Oo4 == null && obj6 == null) {
                                    fragment4 = fragment;
                                    fragment3 = fragment2;
                                    obj3 = O00000Oo4;
                                    obj2 = O000000o13;
                                    o000000o = o000000o2;
                                    o0o0ooo04 = o0o0ooo05;
                                    arrayList4 = arrayList15;
                                    obj = null;
                                    i3 = i6;
                                    i4 = i5;
                                    arrayList3 = arrayList14;
                                    if (obj2 != null && obj == null && obj3 == null) {
                                        i9 = i3 + 1;
                                        efVar2 = efVar;
                                        arrayList9 = arrayList;
                                        arrayList10 = arrayList2;
                                        i7 = i2;
                                        z4 = z;
                                        size = i4;
                                        sparseArray2 = sparseArray;
                                    } else {
                                        ArrayList<View> O000000o14 = O000000o(O000000o2, obj3, fragment3, arrayList3, view2);
                                        if (O000000o14 == null || O000000o14.isEmpty()) {
                                            obj3 = null;
                                        }
                                        O000000o2.O00000Oo(obj2, view2);
                                        O000000o3 = O000000o(O000000o2, obj2, obj3, obj, fragment4, o000000o.O00000Oo);
                                        if (O000000o3 == null) {
                                            ArrayList arrayList16 = new ArrayList();
                                            O000000o2.O000000o(O000000o3, obj2, arrayList16, obj3, O000000o14, obj, arrayList4);
                                            final Object obj9 = obj2;
                                            final el elVar2 = O000000o2;
                                            final View view3 = view2;
                                            final Fragment fragment17 = fragment4;
                                            final ArrayList arrayList17 = arrayList4;
                                            final ArrayList arrayList18 = arrayList16;
                                            final ArrayList<View> arrayList19 = O000000o14;
                                            AnonymousClass2 r3 = r7;
                                            final Object obj10 = obj3;
                                            AnonymousClass2 r7 = new Runnable() {
                                                /* class _m_j.ej.AnonymousClass2 */

                                                public final void run() {
                                                    Object obj = obj9;
                                                    if (obj != null) {
                                                        elVar2.O00000o0(obj, view3);
                                                        arrayList18.addAll(ej.O000000o(elVar2, obj9, fragment17, arrayList17, view3));
                                                    }
                                                    if (arrayList19 != null) {
                                                        if (obj10 != null) {
                                                            ArrayList arrayList = new ArrayList();
                                                            arrayList.add(view3);
                                                            elVar2.O00000Oo(obj10, (ArrayList<View>) arrayList19, (ArrayList<View>) arrayList);
                                                        }
                                                        arrayList19.clear();
                                                        arrayList19.add(view3);
                                                    }
                                                }
                                            };
                                            bx.O000000o(viewGroup2, r3);
                                            ArrayList arrayList20 = arrayList4;
                                            o0O0OOO0<String, String> o0o0ooo06 = o0o0ooo04;
                                            bx.O000000o(viewGroup2, new Runnable(arrayList20, o0o0ooo06) {
                                                /* class _m_j.el.AnonymousClass2 */

                                                /* renamed from: O000000o  reason: collision with root package name */
                                                final /* synthetic */ ArrayList f15601O000000o;
                                                final /* synthetic */ Map O00000Oo;

                                                {
                                                    this.f15601O000000o = r2;
                                                    this.O00000Oo = r3;
                                                }

                                                public final void run() {
                                                    String str;
                                                    int size = this.f15601O000000o.size();
                                                    for (int i = 0; i < size; i++) {
                                                        View view = (View) this.f15601O000000o.get(i);
                                                        String O0000oo0 = cb.O0000oo0(view);
                                                        if (O0000oo0 != null) {
                                                            Iterator it = this.O00000Oo.entrySet().iterator();
                                                            while (true) {
                                                                if (!it.hasNext()) {
                                                                    str = null;
                                                                    break;
                                                                }
                                                                Map.Entry entry = (Map.Entry) it.next();
                                                                if (O0000oo0.equals(entry.getValue())) {
                                                                    str = (String) entry.getKey();
                                                                    break;
                                                                }
                                                            }
                                                            cb.O000000o(view, str);
                                                        }
                                                    }
                                                }
                                            });
                                            O000000o2.O000000o(viewGroup2, O000000o3);
                                            bx.O000000o(viewGroup2, new Runnable(arrayList20, o0o0ooo06) {
                                                /* class _m_j.el.AnonymousClass3 */

                                                /* renamed from: O000000o  reason: collision with root package name */
                                                final /* synthetic */ ArrayList f15602O000000o;
                                                final /* synthetic */ Map O00000Oo;

                                                {
                                                    this.f15602O000000o = r2;
                                                    this.O00000Oo = r3;
                                                }

                                                public final void run() {
                                                    int size = this.f15602O000000o.size();
                                                    for (int i = 0; i < size; i++) {
                                                        View view = (View) this.f15602O000000o.get(i);
                                                        cb.O000000o(view, (String) this.O00000Oo.get(cb.O0000oo0(view)));
                                                    }
                                                }
                                            });
                                        }
                                        i9 = i3 + 1;
                                        efVar2 = efVar;
                                        arrayList9 = arrayList;
                                        arrayList10 = arrayList2;
                                        i7 = i2;
                                        z4 = z;
                                        size = i4;
                                        sparseArray2 = sparseArray;
                                    }
                                } else {
                                    O000000o(fragment15, fragment16, z11, O00000Oo5);
                                    if (obj6 != null) {
                                        fragment4 = fragment;
                                        rect = new Rect();
                                        O000000o2.O000000o(obj6, view2, (ArrayList<View>) arrayList14);
                                        arrayList5 = arrayList14;
                                        fragment3 = fragment2;
                                        o0o0ooo0 = o0o0ooo05;
                                        z2 = z11;
                                        fragment6 = fragment16;
                                        fragment5 = fragment15;
                                        o0O0OOO0<String, View> o0o0ooo07 = O00000Oo5;
                                        arrayList6 = arrayList15;
                                        O000000o(O000000o2, obj6, O00000Oo4, o0o0ooo07, o000000o2.O00000oO, o000000o2.O00000oo);
                                        if (O000000o13 != null) {
                                            O000000o2.O000000o(O000000o13, rect);
                                        }
                                    } else {
                                        fragment4 = fragment;
                                        fragment3 = fragment2;
                                        arrayList5 = arrayList14;
                                        o0o0ooo0 = o0o0ooo05;
                                        z2 = z11;
                                        fragment6 = fragment16;
                                        fragment5 = fragment15;
                                        arrayList6 = arrayList15;
                                        rect = null;
                                    }
                                    Object obj11 = O00000Oo4;
                                    final el elVar3 = O000000o2;
                                    Object obj12 = O000000o13;
                                    final o0O0OOO0<String, String> o0o0ooo08 = o0o0ooo0;
                                    O000000o o000000o3 = o000000o2;
                                    final Object obj13 = obj6;
                                    Object obj14 = obj6;
                                    final O000000o o000000o4 = o000000o3;
                                    o0o0ooo04 = o0o0ooo0;
                                    o000000o = o000000o3;
                                    final ArrayList arrayList21 = arrayList6;
                                    obj4 = obj12;
                                    i3 = i6;
                                    final View view4 = view2;
                                    arrayList4 = arrayList6;
                                    obj3 = obj11;
                                    final Fragment fragment18 = fragment5;
                                    arrayList3 = arrayList5;
                                    i4 = i5;
                                    final Fragment fragment19 = fragment6;
                                    final boolean z12 = z2;
                                    final ArrayList arrayList22 = arrayList3;
                                    final Object obj15 = obj4;
                                    final Rect rect4 = rect;
                                    bx.O000000o(viewGroup2, new Runnable() {
                                        /* class _m_j.ej.AnonymousClass4 */

                                        public final void run() {
                                            o0O0OOO0<String, View> O000000o2 = ej.O000000o(elVar3, o0o0ooo08, obj13, o000000o4);
                                            if (O000000o2 != null) {
                                                arrayList21.addAll(O000000o2.values());
                                                arrayList21.add(view4);
                                            }
                                            ej.O000000o(fragment18, fragment19, z12, O000000o2);
                                            Object obj = obj13;
                                            if (obj != null) {
                                                elVar3.O000000o(obj, (ArrayList<View>) arrayList22, (ArrayList<View>) arrayList21);
                                                View O000000o3 = ej.O000000o(O000000o2, o000000o4, obj15, z12);
                                                if (O000000o3 != null) {
                                                    el.O000000o(O000000o3, rect4);
                                                }
                                            }
                                        }
                                    });
                                    obj = obj14;
                                }
                            }
                            obj2 = obj4;
                            if (obj2 != null) {
                            }
                            ArrayList<View> O000000o142 = O000000o(O000000o2, obj3, fragment3, arrayList3, view2);
                            obj3 = null;
                            O000000o2.O00000Oo(obj2, view2);
                            O000000o3 = O000000o(O000000o2, obj2, obj3, obj, fragment4, o000000o.O00000Oo);
                            if (O000000o3 == null) {
                            }
                            i9 = i3 + 1;
                            efVar2 = efVar;
                            arrayList9 = arrayList;
                            arrayList10 = arrayList2;
                            i7 = i2;
                            z4 = z;
                            size = i4;
                            sparseArray2 = sparseArray;
                        }
                    }
                    i3 = i6;
                    i4 = i5;
                    i9 = i3 + 1;
                    efVar2 = efVar;
                    arrayList9 = arrayList;
                    arrayList10 = arrayList2;
                    i7 = i2;
                    z4 = z;
                    size = i4;
                    sparseArray2 = sparseArray;
                }
            }
        }
    }

    private static o0O0OOO0<String, String> O000000o(int i, ArrayList<dy> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        o0O0OOO0<String, String> o0o0ooo0 = new o0O0OOO0<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            dy dyVar = arrayList.get(i4);
            if (dyVar.O00000Oo(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (dyVar.O0000oO0 != null) {
                    int size = dyVar.O0000oO0.size();
                    if (booleanValue) {
                        arrayList3 = dyVar.O0000oO0;
                        arrayList4 = dyVar.O0000oO;
                    } else {
                        ArrayList arrayList5 = dyVar.O0000oO0;
                        arrayList3 = dyVar.O0000oO;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String remove = o0o0ooo0.remove(str2);
                        if (remove != null) {
                            o0o0ooo0.put(str, remove);
                        } else {
                            o0o0ooo0.put(str, str2);
                        }
                    }
                }
            }
        }
        return o0o0ooo0;
    }

    private static el O000000o(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        el elVar = O00000Oo;
        if (elVar != null && O000000o(elVar, arrayList)) {
            return O00000Oo;
        }
        el elVar2 = O00000o0;
        if (elVar2 != null && O000000o(elVar2, arrayList)) {
            return O00000o0;
        }
        if (O00000Oo == null && O00000o0 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean O000000o(el elVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!elVar.O000000o(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object O000000o(el elVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return elVar.O00000o0(elVar.O00000Oo(obj));
    }

    private static Object O000000o(el elVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return elVar.O00000Oo(obj);
    }

    private static Object O00000Oo(el elVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return elVar.O00000Oo(obj);
    }

    private static void O000000o(ArrayList<View> arrayList, o0O0OOO0<String, View> o0o0ooo0, Collection<String> collection) {
        for (int size = o0o0ooo0.size() - 1; size >= 0; size--) {
            View O00000o02 = o0o0ooo0.O00000o0(size);
            if (collection.contains(cb.O0000oo0(O00000o02))) {
                arrayList.add(O00000o02);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.el.O000000o(java.util.Map<java.lang.String, android.view.View>, android.view.View):void
     arg types: [_m_j.o0O0OOO0<java.lang.String, android.view.View>, android.view.View]
     candidates:
      _m_j.el.O000000o(android.view.View, android.graphics.Rect):void
      _m_j.el.O000000o(java.util.List<android.view.View>, android.view.View):void
      _m_j.el.O000000o(android.view.ViewGroup, java.lang.Object):void
      _m_j.el.O000000o(java.lang.Object, android.graphics.Rect):void
      _m_j.el.O000000o(java.lang.Object, android.view.View):void
      _m_j.el.O000000o(java.lang.Object, java.util.ArrayList<android.view.View>):void
      _m_j.el.O000000o(java.util.ArrayList<android.view.View>, android.view.View):void
      _m_j.el.O000000o(java.util.Map<java.lang.String, android.view.View>, android.view.View):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.o0OO000o.O000000o(java.util.Map, java.util.Collection<?>):boolean
     arg types: [_m_j.o0O0OOO0<java.lang.String, android.view.View>, java.util.ArrayList]
     candidates:
      _m_j.o0OO000o.O000000o(java.util.Set, java.lang.Object):boolean
      _m_j.o0OO000o.O000000o(int, int):java.lang.Object
      _m_j.o0OO000o.O000000o(int, java.lang.Object):V
      _m_j.o0OO000o.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.o0OO000o.O000000o(java.lang.Object[], int):T[]
      _m_j.o0OO000o.O000000o(java.util.Map, java.util.Collection<?>):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.o0OO000o.O000000o(java.util.Map, java.util.Collection<?>):boolean
     arg types: [_m_j.o0O0OOO0<java.lang.String, java.lang.String>, java.util.Set<java.lang.String>]
     candidates:
      _m_j.o0OO000o.O000000o(java.util.Set, java.lang.Object):boolean
      _m_j.o0OO000o.O000000o(int, int):java.lang.Object
      _m_j.o0OO000o.O000000o(int, java.lang.Object):V
      _m_j.o0OO000o.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.o0OO000o.O000000o(java.lang.Object[], int):T[]
      _m_j.o0OO000o.O000000o(java.util.Map, java.util.Collection<?>):boolean */
    private static o0O0OOO0<String, View> O00000Oo(el elVar, o0O0OOO0<String, String> o0o0ooo0, Object obj, O000000o o000000o) {
        d dVar;
        ArrayList arrayList;
        if (o0o0ooo0.isEmpty() || obj == null) {
            o0o0ooo0.clear();
            return null;
        }
        Fragment fragment = o000000o.O00000o;
        o0O0OOO0<String, View> o0o0ooo02 = new o0O0OOO0<>();
        elVar.O000000o((Map<String, View>) o0o0ooo02, fragment.requireView());
        dy dyVar = o000000o.O00000oo;
        if (o000000o.O00000oO) {
            dVar = fragment.getEnterTransitionCallback();
            arrayList = dyVar.O0000oO;
        } else {
            dVar = fragment.getExitTransitionCallback();
            arrayList = dyVar.O0000oO0;
        }
        o0OO000o.O000000o((Map) o0o0ooo02, (Collection<?>) arrayList);
        if (dVar != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = o0o0ooo02.get(str);
                if (view == null) {
                    o0o0ooo0.remove(str);
                } else if (!str.equals(cb.O0000oo0(view))) {
                    o0o0ooo0.put(cb.O0000oo0(view), o0o0ooo0.remove(str));
                }
            }
        } else {
            o0OO000o.O000000o((Map) o0o0ooo0, (Collection<?>) o0o0ooo02.keySet());
        }
        return o0o0ooo02;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.el.O000000o(java.util.Map<java.lang.String, android.view.View>, android.view.View):void
     arg types: [_m_j.o0O0OOO0<java.lang.String, android.view.View>, android.view.View]
     candidates:
      _m_j.el.O000000o(android.view.View, android.graphics.Rect):void
      _m_j.el.O000000o(java.util.List<android.view.View>, android.view.View):void
      _m_j.el.O000000o(android.view.ViewGroup, java.lang.Object):void
      _m_j.el.O000000o(java.lang.Object, android.graphics.Rect):void
      _m_j.el.O000000o(java.lang.Object, android.view.View):void
      _m_j.el.O000000o(java.lang.Object, java.util.ArrayList<android.view.View>):void
      _m_j.el.O000000o(java.util.ArrayList<android.view.View>, android.view.View):void
      _m_j.el.O000000o(java.util.Map<java.lang.String, android.view.View>, android.view.View):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.o0OO000o.O000000o(java.util.Map, java.util.Collection<?>):boolean
     arg types: [_m_j.o0O0OOO0<java.lang.String, android.view.View>, java.util.ArrayList]
     candidates:
      _m_j.o0OO000o.O000000o(java.util.Set, java.lang.Object):boolean
      _m_j.o0OO000o.O000000o(int, int):java.lang.Object
      _m_j.o0OO000o.O000000o(int, java.lang.Object):V
      _m_j.o0OO000o.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.o0OO000o.O000000o(java.lang.Object[], int):T[]
      _m_j.o0OO000o.O000000o(java.util.Map, java.util.Collection<?>):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.o0OO000o.O000000o(java.util.Map, java.util.Collection<?>):boolean
     arg types: [_m_j.o0O0OOO0<java.lang.String, android.view.View>, java.util.Collection<java.lang.String>]
     candidates:
      _m_j.o0OO000o.O000000o(java.util.Set, java.lang.Object):boolean
      _m_j.o0OO000o.O000000o(int, int):java.lang.Object
      _m_j.o0OO000o.O000000o(int, java.lang.Object):V
      _m_j.o0OO000o.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.o0OO000o.O000000o(java.lang.Object[], int):T[]
      _m_j.o0OO000o.O000000o(java.util.Map, java.util.Collection<?>):boolean */
    static o0O0OOO0<String, View> O000000o(el elVar, o0O0OOO0<String, String> o0o0ooo0, Object obj, O000000o o000000o) {
        d dVar;
        ArrayList arrayList;
        String O000000o2;
        Fragment fragment = o000000o.f15332O000000o;
        View view = fragment.getView();
        if (o0o0ooo0.isEmpty() || obj == null || view == null) {
            o0o0ooo0.clear();
            return null;
        }
        o0O0OOO0<String, View> o0o0ooo02 = new o0O0OOO0<>();
        elVar.O000000o((Map<String, View>) o0o0ooo02, view);
        dy dyVar = o000000o.O00000o0;
        if (o000000o.O00000Oo) {
            dVar = fragment.getExitTransitionCallback();
            arrayList = dyVar.O0000oO0;
        } else {
            dVar = fragment.getEnterTransitionCallback();
            arrayList = dyVar.O0000oO;
        }
        if (arrayList != null) {
            o0OO000o.O000000o((Map) o0o0ooo02, (Collection<?>) arrayList);
            o0OO000o.O000000o((Map) o0o0ooo02, (Collection<?>) o0o0ooo0.values());
        }
        if (dVar != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = o0o0ooo02.get(str);
                if (view2 == null) {
                    String O000000o3 = O000000o(o0o0ooo0, str);
                    if (O000000o3 != null) {
                        o0o0ooo0.remove(O000000o3);
                    }
                } else if (!str.equals(cb.O0000oo0(view2)) && (O000000o2 = O000000o(o0o0ooo0, str)) != null) {
                    o0o0ooo0.put(O000000o2, cb.O0000oo0(view2));
                }
            }
        } else {
            for (int size2 = o0o0ooo0.size() - 1; size2 >= 0; size2--) {
                if (!o0o0ooo02.containsKey(o0o0ooo0.O00000o0(size2))) {
                    o0o0ooo0.O00000o(size2);
                }
            }
        }
        return o0o0ooo02;
    }

    private static String O000000o(o0O0OOO0<String, String> o0o0ooo0, String str) {
        int size = o0o0ooo0.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(o0o0ooo0.O00000o0(i))) {
                return o0o0ooo0.O00000Oo(i);
            }
        }
        return null;
    }

    static View O000000o(o0O0OOO0<String, View> o0o0ooo0, O000000o o000000o, Object obj, boolean z) {
        String str;
        dy dyVar = o000000o.O00000o0;
        if (obj == null || o0o0ooo0 == null || dyVar.O0000oO0 == null || dyVar.O0000oO0.isEmpty()) {
            return null;
        }
        if (z) {
            str = (String) dyVar.O0000oO0.get(0);
        } else {
            str = (String) dyVar.O0000oO.get(0);
        }
        return o0o0ooo0.get(str);
    }

    private static void O000000o(el elVar, Object obj, Object obj2, o0O0OOO0<String, View> o0o0ooo0, boolean z, dy dyVar) {
        String str;
        if (dyVar.O0000oO0 != null && !dyVar.O0000oO0.isEmpty()) {
            if (z) {
                str = (String) dyVar.O0000oO.get(0);
            } else {
                str = (String) dyVar.O0000oO0.get(0);
            }
            View view = o0o0ooo0.get(str);
            elVar.O000000o(obj, view);
            if (obj2 != null) {
                elVar.O000000o(obj2, view);
            }
        }
    }

    static void O000000o(Fragment fragment, Fragment fragment2, boolean z, o0O0OOO0<String, View> o0o0ooo0) {
        d dVar;
        int i;
        if (z) {
            dVar = fragment2.getEnterTransitionCallback();
        } else {
            dVar = fragment.getEnterTransitionCallback();
        }
        if (dVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (o0o0ooo0 == null) {
                i = 0;
            } else {
                i = o0o0ooo0.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(o0o0ooo0.O00000Oo(i2));
                arrayList.add(o0o0ooo0.O00000o0(i2));
            }
        }
    }

    static ArrayList<View> O000000o(el elVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            elVar.O000000o(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        elVar.O000000o(obj, arrayList2);
        return arrayList2;
    }

    static void O000000o(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    private static Object O000000o(el elVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return elVar.O000000o(obj2, obj, obj3);
        }
        return elVar.O00000Oo(obj2, obj, obj3);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ej.O000000o(_m_j.dy, _m_j.ei$O000000o, android.util.SparseArray<_m_j.ej$O000000o>, boolean, boolean):void
     arg types: [_m_j.dy, _m_j.ei$O000000o, android.util.SparseArray<_m_j.ej$O000000o>, int, boolean]
     candidates:
      _m_j.ej.O000000o(int, java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int):_m_j.o0O0OOO0<java.lang.String, java.lang.String>
      _m_j.ej.O000000o(_m_j.el, java.lang.Object, androidx.fragment.app.Fragment, java.util.ArrayList<android.view.View>, android.view.View):java.util.ArrayList<android.view.View>
      _m_j.ej.O000000o(_m_j.dy, _m_j.ei$O000000o, android.util.SparseArray<_m_j.ej$O000000o>, boolean, boolean):void */
    private static void O000000o(dy dyVar, SparseArray<O000000o> sparseArray, boolean z) {
        int size = dyVar.O00000o.size();
        for (int i = 0; i < size; i++) {
            O000000o(dyVar, (ei.O000000o) dyVar.O00000o.get(i), sparseArray, false, z);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ej.O000000o(_m_j.dy, _m_j.ei$O000000o, android.util.SparseArray<_m_j.ej$O000000o>, boolean, boolean):void
     arg types: [_m_j.dy, _m_j.ei$O000000o, android.util.SparseArray<_m_j.ej$O000000o>, int, boolean]
     candidates:
      _m_j.ej.O000000o(int, java.util.ArrayList<_m_j.dy>, java.util.ArrayList<java.lang.Boolean>, int, int):_m_j.o0O0OOO0<java.lang.String, java.lang.String>
      _m_j.ej.O000000o(_m_j.el, java.lang.Object, androidx.fragment.app.Fragment, java.util.ArrayList<android.view.View>, android.view.View):java.util.ArrayList<android.view.View>
      _m_j.ej.O000000o(_m_j.dy, _m_j.ei$O000000o, android.util.SparseArray<_m_j.ej$O000000o>, boolean, boolean):void */
    private static void O00000Oo(dy dyVar, SparseArray<O000000o> sparseArray, boolean z) {
        if (dyVar.f15052O000000o.O0000oO0.O000000o()) {
            for (int size = dyVar.O00000o.size() - 1; size >= 0; size--) {
                O000000o(dyVar, (ei.O000000o) dyVar.O00000o.get(size), sparseArray, true, z);
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
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0039, code lost:
        if (r6.mAdded != false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0070, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008c, code lost:
        if (r6.mHidden == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008e, code lost:
        r12 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00e1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    private static void O000000o(dy dyVar, ei.O000000o o000000o, SparseArray<O000000o> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        O000000o o000000o2;
        ef efVar;
        boolean z5;
        Fragment fragment = o000000o.O00000Oo;
        if (fragment != null && (i = fragment.mContainerId) != 0) {
            int i2 = z ? f15327O000000o[o000000o.f15307O000000o] : o000000o.f15307O000000o;
            boolean z6 = false;
            boolean z7 = true;
            if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 != 7) {
                                    z3 = false;
                                    z7 = false;
                                    z4 = false;
                                    O000000o o000000o3 = sparseArray.get(i);
                                    if (z6) {
                                        o000000o3 = O000000o(o000000o3, sparseArray, i);
                                        o000000o3.f15332O000000o = fragment;
                                        o000000o3.O00000Oo = z;
                                        o000000o3.O00000o0 = dyVar;
                                    }
                                    o000000o2 = o000000o3;
                                    if (!z2 && z7) {
                                        if (o000000o2 != null && o000000o2.O00000o == fragment) {
                                            o000000o2.O00000o = null;
                                        }
                                        efVar = dyVar.f15052O000000o;
                                        if (fragment.mState <= 0 && efVar.O0000o0o > 0 && !dyVar.O0000oOO) {
                                            efVar.O00000oo(fragment);
                                            efVar.O000000o(fragment, 1, 0, 0, false);
                                        }
                                    }
                                    if (z4 && (o000000o2 == null || o000000o2.O00000o == null)) {
                                        o000000o2 = O000000o(o000000o2, sparseArray, i);
                                        o000000o2.O00000o = fragment;
                                        o000000o2.O00000oO = z;
                                        o000000o2.O00000oo = dyVar;
                                    }
                                    if (z2 && z3 && o000000o2 != null && o000000o2.f15332O000000o == fragment) {
                                        o000000o2.f15332O000000o = null;
                                        return;
                                    }
                                    return;
                                }
                            }
                        } else if (z2) {
                            if (fragment.mHiddenChanged) {
                                if (!fragment.mHidden) {
                                }
                            }
                            z5 = false;
                            z6 = z5;
                            z3 = false;
                            z4 = false;
                            O000000o o000000o32 = sparseArray.get(i);
                            if (z6) {
                            }
                            o000000o2 = o000000o32;
                            o000000o2.O00000o = null;
                            efVar = dyVar.f15052O000000o;
                            efVar.O00000oo(fragment);
                            efVar.O000000o(fragment, 1, 0, 0, false);
                            o000000o2 = O000000o(o000000o2, sparseArray, i);
                            o000000o2.O00000o = fragment;
                            o000000o2.O00000oO = z;
                            o000000o2.O00000oo = dyVar;
                            if (z2) {
                                return;
                            }
                            return;
                        } else {
                            z5 = fragment.mHidden;
                            z6 = z5;
                            z3 = false;
                            z4 = false;
                            O000000o o000000o322 = sparseArray.get(i);
                            if (z6) {
                            }
                            o000000o2 = o000000o322;
                            o000000o2.O00000o = null;
                            efVar = dyVar.f15052O000000o;
                            efVar.O00000oo(fragment);
                            efVar.O000000o(fragment, 1, 0, 0, false);
                            o000000o2 = O000000o(o000000o2, sparseArray, i);
                            o000000o2.O00000o = fragment;
                            o000000o2.O00000oO = z;
                            o000000o2.O00000oo = dyVar;
                            if (z2) {
                            }
                        }
                    } else if (!z2) {
                        boolean z8 = false;
                        z4 = z8;
                        z3 = true;
                        z7 = false;
                        O000000o o000000o3222 = sparseArray.get(i);
                        if (z6) {
                        }
                        o000000o2 = o000000o3222;
                        o000000o2.O00000o = null;
                        efVar = dyVar.f15052O000000o;
                        efVar.O00000oo(fragment);
                        efVar.O000000o(fragment, 1, 0, 0, false);
                        o000000o2 = O000000o(o000000o2, sparseArray, i);
                        o000000o2.O00000o = fragment;
                        o000000o2.O00000oO = z;
                        o000000o2.O00000oo = dyVar;
                        if (z2) {
                        }
                    } else {
                        boolean z82 = false;
                        z4 = z82;
                        z3 = true;
                        z7 = false;
                        O000000o o000000o32222 = sparseArray.get(i);
                        if (z6) {
                        }
                        o000000o2 = o000000o32222;
                        o000000o2.O00000o = null;
                        efVar = dyVar.f15052O000000o;
                        efVar.O00000oo(fragment);
                        efVar.O000000o(fragment, 1, 0, 0, false);
                        o000000o2 = O000000o(o000000o2, sparseArray, i);
                        o000000o2.O00000o = fragment;
                        o000000o2.O00000oO = z;
                        o000000o2.O00000oo = dyVar;
                        if (z2) {
                        }
                    }
                }
                if (!z2) {
                    boolean z822 = false;
                    z4 = z822;
                    z3 = true;
                    z7 = false;
                    O000000o o000000o322222 = sparseArray.get(i);
                    if (z6) {
                    }
                    o000000o2 = o000000o322222;
                    o000000o2.O00000o = null;
                    efVar = dyVar.f15052O000000o;
                    efVar.O00000oo(fragment);
                    efVar.O000000o(fragment, 1, 0, 0, false);
                    o000000o2 = O000000o(o000000o2, sparseArray, i);
                    o000000o2.O00000o = fragment;
                    o000000o2.O00000oO = z;
                    o000000o2.O00000oo = dyVar;
                    if (z2) {
                    }
                } else {
                    boolean z8222 = false;
                    z4 = z8222;
                    z3 = true;
                    z7 = false;
                    O000000o o000000o3222222 = sparseArray.get(i);
                    if (z6) {
                    }
                    o000000o2 = o000000o3222222;
                    o000000o2.O00000o = null;
                    efVar = dyVar.f15052O000000o;
                    efVar.O00000oo(fragment);
                    efVar.O000000o(fragment, 1, 0, 0, false);
                    o000000o2 = O000000o(o000000o2, sparseArray, i);
                    o000000o2.O00000o = fragment;
                    o000000o2.O00000oO = z;
                    o000000o2.O00000oo = dyVar;
                    if (z2) {
                    }
                }
            }
            if (z2) {
                z5 = fragment.mIsNewlyAdded;
                z6 = z5;
                z3 = false;
                z4 = false;
                O000000o o000000o32222222 = sparseArray.get(i);
                if (z6) {
                }
                o000000o2 = o000000o32222222;
                o000000o2.O00000o = null;
                efVar = dyVar.f15052O000000o;
                efVar.O00000oo(fragment);
                efVar.O000000o(fragment, 1, 0, 0, false);
                o000000o2 = O000000o(o000000o2, sparseArray, i);
                o000000o2.O00000o = fragment;
                o000000o2.O00000oO = z;
                o000000o2.O00000oo = dyVar;
                if (z2) {
                }
            } else {
                if (!fragment.mAdded) {
                }
                z5 = false;
                z6 = z5;
                z3 = false;
                z4 = false;
                O000000o o000000o322222222 = sparseArray.get(i);
                if (z6) {
                }
                o000000o2 = o000000o322222222;
                o000000o2.O00000o = null;
                efVar = dyVar.f15052O000000o;
                efVar.O00000oo(fragment);
                efVar.O000000o(fragment, 1, 0, 0, false);
                o000000o2 = O000000o(o000000o2, sparseArray, i);
                o000000o2.O00000o = fragment;
                o000000o2.O00000oO = z;
                o000000o2.O00000oo = dyVar;
                if (z2) {
                }
            }
        }
    }

    private static O000000o O000000o(O000000o o000000o, SparseArray<O000000o> sparseArray, int i) {
        if (o000000o != null) {
            return o000000o;
        }
        O000000o o000000o2 = new O000000o();
        sparseArray.put(i, o000000o2);
        return o000000o2;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public Fragment f15332O000000o;
        public boolean O00000Oo;
        public Fragment O00000o;
        public dy O00000o0;
        public boolean O00000oO;
        public dy O00000oo;

        O000000o() {
        }
    }
}
