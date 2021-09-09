package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.Iterator;

public final class hci<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hbz<C, E, T> {
    private final ArrayList<ArrayList<Integer>> O0000Oo;
    private final View O0000Oo0 = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_spec, this.O00000o0, false);
    private final String O0000OoO;
    private hhk O0000Ooo;
    private View O0000o00;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public hci(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device, ArrayList<ArrayList<Integer>> arrayList2) {
        super(c, arrayList, viewGroup, context, device);
        this.O0000Oo = arrayList2;
        this.O0000OoO = fml.O00000Oo(this.O00000oO);
    }

    public final void O000000o() {
        int i;
        super.O000000o();
        this.O00000o0.addView(this.O0000Oo0);
        LinearLayout linearLayout = (LinearLayout) this.O0000Oo0.findViewById(R.id.layout_content);
        int size = this.O0000Oo.size();
        int O000000o2 = gpc.O000000o(7.5f);
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = null;
        while (i2 < size) {
            int size2 = this.O0000Oo.get(i2).size();
            ArrayList arrayList2 = new ArrayList();
            int i4 = i3;
            LinearLayout linearLayout2 = null;
            for (int i5 = 0; i5 < size2; i5++) {
                hcf hcf = (hcf) this.f10206O000000o.get(i4);
                arrayList2.add(Integer.valueOf(hcf.O00000Oo));
                if (size2 == 1 && size != 1 && hcf.O00000Oo == 1) {
                    hcf.O000000o((ViewGroup) this.O0000Oo0.findViewById(R.id.ll_title_content), this.f10206O000000o.size(), i4);
                } else {
                    if (linearLayout2 == null) {
                        linearLayout2 = new LinearLayout(linearLayout.getContext());
                    }
                    LinearLayout linearLayout3 = new LinearLayout(linearLayout.getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, hcf.O0000Ooo.O00000o() ? 100.0f : 1.0f);
                    layoutParams.rightMargin = O000000o2;
                    layoutParams.leftMargin = O000000o2;
                    if (i5 == 0) {
                        i = 0;
                        layoutParams.leftMargin = 0;
                    } else {
                        i = 0;
                    }
                    if (i5 == size2 - 1) {
                        layoutParams.rightMargin = i;
                    }
                    linearLayout2.addView(linearLayout3, layoutParams);
                    linearLayout3.setGravity(1);
                    hcf.O000000o(linearLayout3, this.f10206O000000o.size(), i4);
                }
                i4++;
            }
            if (linearLayout2 != null && linearLayout2.getChildCount() > 0) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = gpc.O000000o((float) O000000o((ArrayList<Integer>) arrayList, (ArrayList<Integer>) arrayList2));
                if (size - 1 == i2) {
                    layoutParams2.bottomMargin = gpc.O000000o((float) O000000o((ArrayList<Integer>) arrayList2, (ArrayList<Integer>) null));
                }
                linearLayout2.setGravity(16);
                linearLayout.addView(linearLayout2, layoutParams2);
                arrayList = arrayList2;
            }
            i2++;
            i3 = i4;
        }
        O000000o(this.O00000o0, this.O00000oO);
        View view = this.O0000Oo0;
        this.O0000Ooo = (hhk) view.findViewById(R.id.dpb_enter_device);
        this.O0000o00 = view.findViewById(R.id.progress_enter_device);
    }

    private int O000000o(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        int i = 0;
        if (arrayList == null || arrayList.size() == 0) {
            if (arrayList2 == null || arrayList2.size() == 0) {
                return 20;
            }
            Iterator<Integer> it = arrayList2.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 = Math.max(O000000o(0, it.next().intValue()), i2);
            }
            return i2;
        } else if (arrayList2 == null || arrayList2.size() == 0) {
            Iterator<Integer> it2 = arrayList.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                i3 = Math.max(O000000o(it2.next().intValue(), 0), i3);
            }
            return i3;
        } else {
            Iterator<Integer> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                Integer next = it3.next();
                Iterator<Integer> it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    i = Math.max(O000000o(next.intValue(), it4.next().intValue()), i);
                }
            }
            return i;
        }
    }

    private static int O000000o(int i, int i2) {
        if (O000000o(i, i2, 7, 17, 8, 9, 18, 10, 14)) {
            return 51;
        }
        if (O000000o(i, i2, 1, 2, 101)) {
            return 33;
        }
        if (i == 0 && i2 == 3) {
            return 36;
        }
        if (i == 0 && i2 == 5) {
            return 32;
        }
        if (i == 3 && i2 == 4) {
            return 26;
        }
        if (i == 3 && i2 == 0) {
            return 33;
        }
        if (i == 4 && i2 == 0) {
            return 33;
        }
        if (i == 12 && i2 == 0) {
            return 33;
        }
        if (i == 11 && i2 == 0) {
            return 33;
        }
        if (O000000o(i, i2, 5, 6, 19, 20)) {
        }
        return 20;
    }

    private static boolean O000000o(int i, int i2, int... iArr) {
        for (int i3 : iArr) {
            if (i == i3 || i2 == i3) {
                return true;
            }
        }
        return false;
    }

    public final hhk O00000Oo() {
        return this.O0000Ooo;
    }

    public final View O00000o0() {
        return this.O0000o00;
    }
}
