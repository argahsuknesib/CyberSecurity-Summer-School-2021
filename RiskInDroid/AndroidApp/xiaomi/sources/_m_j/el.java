package _m_j;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
public abstract class el {
    public abstract Object O000000o(Object obj, Object obj2, Object obj3);

    public abstract void O000000o(ViewGroup viewGroup, Object obj);

    public abstract void O000000o(Object obj, Rect rect);

    public abstract void O000000o(Object obj, View view);

    public abstract void O000000o(Object obj, View view, ArrayList<View> arrayList);

    public abstract void O000000o(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void O000000o(Object obj, ArrayList<View> arrayList);

    public abstract void O000000o(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract boolean O000000o(Object obj);

    public abstract Object O00000Oo(Object obj);

    public abstract Object O00000Oo(Object obj, Object obj2, Object obj3);

    public abstract void O00000Oo(Object obj, View view);

    public abstract void O00000Oo(Object obj, View view, ArrayList<View> arrayList);

    public abstract void O00000Oo(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object O00000o0(Object obj);

    public abstract void O00000o0(Object obj, View view);

    protected static void O000000o(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    static ArrayList<String> O000000o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(cb.O0000oo0(view));
            cb.O000000o(view, (String) null);
        }
        return arrayList2;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String O0000oo0 = cb.O0000oo0(view2);
            arrayList4.add(O0000oo0);
            if (O0000oo0 != null) {
                cb.O000000o(view2, (String) null);
                String str = map.get(O0000oo0);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i2))) {
                        cb.O000000o(arrayList2.get(i2), O0000oo0);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<String> arrayList6 = arrayList3;
        final ArrayList<View> arrayList7 = arrayList;
        bx.O000000o(view, new Runnable() {
            /* class _m_j.el.AnonymousClass1 */

            public final void run() {
                for (int i = 0; i < size; i++) {
                    cb.O000000o((View) arrayList5.get(i), (String) arrayList6.get(i));
                    cb.O000000o((View) arrayList7.get(i), (String) arrayList4.get(i));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(ArrayList<View> arrayList, View view) {
        boolean z;
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (Build.VERSION.SDK_INT >= 21) {
                z = viewGroup.isTransitionGroup();
            } else {
                Boolean bool = (Boolean) viewGroup.getTag(R.id.tag_transition_group);
                z = ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && cb.O0000oo0(viewGroup) == null) ? false : true;
            }
            if (z) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                O000000o(arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String O0000oo0 = cb.O0000oo0(view);
            if (O0000oo0 != null) {
                map.put(O0000oo0, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    O000000o(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    protected static void O000000o(List<View> list, View view) {
        int size = list.size();
        if (!O000000o(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!O000000o(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean O000000o(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean O000000o(List list) {
        return list == null || list.isEmpty();
    }
}
