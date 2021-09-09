package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;

public final class hco<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hbz<C, E, T> {
    private View O0000Oo;
    private hhk O0000Oo0;

    public hco(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device) {
        super(c, arrayList, viewGroup, context, device);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o() {
        View view;
        super.O000000o();
        if (this.f10206O000000o.size() >= 3) {
            hcf hcf = (hcf) this.f10206O000000o.get(0);
            hcf hcf2 = (hcf) this.f10206O000000o.get(1);
            hcf hcf3 = (hcf) this.f10206O000000o.get(2);
            if (hcf.O0000Ooo.O00000oo()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_3_item_horizontal_button, this.O00000o0, false);
            } else if (hcf.O0000Ooo.O00000oO() && hcf2.O0000Ooo.O00000oO() && hcf3.O0000Ooo.O00000oO()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_3_item_horizontal_num, this.O00000o0, false);
            } else if (hcf.O0000Ooo.O00000Oo() && hcf2.O0000Ooo.O00000Oo() && hcf3.O0000Ooo.O00000Oo()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_3_item_horizontal_text, this.O00000o0, false);
            } else if ((hcf.O0000Ooo.O00000Oo() || hcf.O0000Ooo.O00000oO()) && ((hcf2.O0000Ooo.O00000Oo() || hcf2.O0000Ooo.O00000oO()) && (hcf3.O0000Ooo.O00000Oo() || hcf3.O0000Ooo.O00000oO()))) {
                View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_3_item_2_line, this.O00000o0, false);
                this.O00000o0.addView(inflate);
                hcf.O000000o((ViewGroup) inflate.findViewById(R.id.ll_top), 3, 0);
                hcf2.O000000o((ViewGroup) inflate.findViewById(R.id.ll_left), 3, 1);
                hcf3.O000000o((ViewGroup) inflate.findViewById(R.id.ll_right), 3, 2);
                O000000o(this.O00000o0, this.O00000oO);
                O000000o(inflate);
                return;
            } else {
                view = null;
            }
            if (view != null) {
                this.O00000o0.addView(view);
                hcf.O000000o((ViewGroup) view.findViewById(R.id.ll_left), 3, 0);
                hcf2.O000000o((ViewGroup) view.findViewById(R.id.ll_layout_center), 3, 1);
                hcf3.O000000o((ViewGroup) view.findViewById(R.id.ll_right), 3, 2);
                O000000o(this.O00000o0, this.O00000oO);
                O000000o(view);
            }
        }
    }

    public final hhk O00000Oo() {
        return this.O0000Oo0;
    }

    private void O000000o(View view) {
        this.O0000Oo0 = (hhk) view.findViewById(R.id.dpb_enter_device);
        this.O0000Oo = view.findViewById(R.id.progress_enter_device);
    }

    public final View O00000o0() {
        return this.O0000Oo;
    }
}
