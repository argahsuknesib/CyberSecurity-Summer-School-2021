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

public final class hcl<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hbz<C, E, T> {
    private View O0000Oo;
    private hhk O0000Oo0;

    public hcl(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device) {
        super(c, arrayList, viewGroup, context, device);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o() {
        super.O000000o();
        View view = null;
        if (this.f10206O000000o.size() == 2) {
            hcf hcf = (hcf) this.f10206O000000o.get(0);
            hcf hcf2 = (hcf) this.f10206O000000o.get(1);
            View inflate = (!hcf.O0000Ooo.O00000o() || !hcf2.O0000Ooo.O00000o()) ? null : LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_2_long_shape, this.O00000o0, false);
            if (hcf.O0000Ooo.O00000oo()) {
                if ((hcf2 instanceof hea) || (hcf2 instanceof heu) || (hcf2 instanceof hdx) || (hcf2 instanceof het)) {
                    inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_button_long_shape, this.O00000o0, false);
                } else if (hcf2.O0000Ooo.O00000o()) {
                    View inflate2 = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_1_item_2_operation, this.O00000o0, false);
                    this.O00000o0.addView(inflate2);
                    ((hcf) this.f10206O000000o.get(0)).O000000o((ViewGroup) inflate2.findViewById(R.id.ll_left), 2, 0);
                    ((hcf) this.f10206O000000o.get(1)).O000000o((ViewGroup) inflate2.findViewById(R.id.ll_right), 2, 1);
                    O000000o(this.O00000o0, this.O00000oO);
                    O000000o(inflate2);
                }
            }
            if (hcf.O0000Ooo.O00000oO()) {
                if (hcf2.O0000Ooo.O00000o()) {
                    inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_number_long_shape, this.O00000o0, false);
                }
                if (hcf2.O0000Ooo.O00000oo()) {
                    inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_number_button, this.O00000o0, false);
                }
            }
            if (hcf.O0000Ooo.O00000Oo() && hcf2.O0000Ooo.O00000oo()) {
                inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_text_button, this.O00000o0, false);
            }
            if (inflate != null) {
                this.O00000o0.addView(inflate);
                ((hcf) this.f10206O000000o.get(0)).O000000o((ViewGroup) inflate.findViewById(R.id.ll_layout_top), 2, 0);
                ((hcf) this.f10206O000000o.get(1)).O000000o((ViewGroup) inflate.findViewById(R.id.ll_layout_bottom), 2, 1);
                O000000o(this.O00000o0, this.O00000oO);
                O000000o(inflate);
            }
        }
        if (this.f10206O000000o.size() == 3) {
            hcf hcf3 = (hcf) this.f10206O000000o.get(0);
            hcf hcf4 = (hcf) this.f10206O000000o.get(1);
            if (hcf3.O0000Ooo.O00000oO() && hcf4.O0000Ooo.O00000oo()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_number_2button, this.O00000o0, false);
            }
            if (hcf3.O0000Ooo.O00000Oo() && hcf4.O0000Ooo.O00000oo()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_text_2button, this.O00000o0, false);
            }
            if (hcf3.O0000Ooo.O0000O0o() && hcf4.O0000Ooo.O00000oo()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_robotanim_2button, this.O00000o0, false);
            }
            if (view != null) {
                this.O00000o0.addView(view);
                hcf3.O000000o((ViewGroup) view.findViewById(R.id.ll_layout_top), 3, 0);
                hcf4.O000000o((ViewGroup) view.findViewById(R.id.ll_left), 3, 1);
                ((hcf) this.f10206O000000o.get(2)).O000000o((ViewGroup) view.findViewById(R.id.ll_right), 3, 2);
                O000000o(this.O00000o0, this.O00000oO);
                O000000o(view);
            } else {
                if (hcf3.O0000Ooo.O00000oo() && hcf4.O0000Ooo.O00000oo() && ((hcf) this.f10206O000000o.get(2)).O0000Ooo.O00000o()) {
                    view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_2button_longshape, this.O00000o0, false);
                }
                if (view != null) {
                    this.O00000o0.addView(view);
                    hcf3.O000000o((ViewGroup) view.findViewById(R.id.ll_left), 3, 0);
                    hcf4.O000000o((ViewGroup) view.findViewById(R.id.ll_right), 3, 1);
                    ((hcf) this.f10206O000000o.get(2)).O000000o((ViewGroup) view.findViewById(R.id.ll_bottom), 3, 2);
                    O000000o(this.O00000o0, this.O00000oO);
                    O000000o(view);
                }
            }
        }
        this.f10206O000000o.size();
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
