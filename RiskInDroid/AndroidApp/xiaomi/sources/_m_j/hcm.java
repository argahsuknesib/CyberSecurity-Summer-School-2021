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

public final class hcm<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hbz<C, E, T> {
    private View O0000Oo;
    private hhk O0000Oo0;

    public hcm(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device) {
        super(c, arrayList, viewGroup, context, device);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o() {
        hcf hcf;
        hcf hcf2;
        hcf hcf3;
        super.O000000o();
        int size = this.f10206O000000o.size();
        View view = null;
        if (size >= 3) {
            hcf3 = (hcf) this.f10206O000000o.get(0);
            hcf2 = (hcf) this.f10206O000000o.get(1);
            hcf = (hcf) this.f10206O000000o.get(2);
        } else if (size == 2) {
            hcf = (hcf) this.f10206O000000o.get(1);
            hcf2 = (hcf) this.f10206O000000o.get(0);
            hcf3 = null;
        } else {
            return;
        }
        if (hcf3 != null) {
            if ((hcf3.O0000Ooo.O00000Oo == 2) && hcf2.O0000Ooo.O00000oo() && hcf.O0000Ooo.O00000o()) {
                View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_2button_longshape, this.O00000o0, false);
                this.O00000o0.addView(inflate);
                hcf3.O000000o((ViewGroup) inflate.findViewById(R.id.ll_left), 3, 0);
                hcf2.O000000o((ViewGroup) inflate.findViewById(R.id.ll_right), 3, 1);
                hcf.O000000o((ViewGroup) inflate.findViewById(R.id.ll_bottom), 3, 2);
                O000000o(this.O00000o0, this.O00000oO);
                O000000o(inflate);
                return;
            }
        }
        if (hcf3 != null && hcf3.O0000Ooo.O0000O0o() && hcf.O0000Ooo.O00000oo()) {
            view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_robotanim_2button, this.O00000o0, false);
        }
        if (size != 3 || !(hcf2 instanceof hdy) || !(hcf instanceof hdz)) {
            if (hcf3 != null && hcf3.O0000Ooo.O00000oO() && hcf2.O0000Ooo.O00000oo() && hcf.O0000Ooo.O00000oo()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_number_2button, this.O00000o0, false);
            }
            if (hcf3 != null && hcf3.O0000Ooo.O00000Oo() && hcf2.O0000Ooo.O00000oo() && hcf.O0000Ooo.O00000oo()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_text_2button, this.O00000o0, false);
            }
            if (view != null) {
                this.O00000o0.addView(view);
                if (hcf3 != null) {
                    hcf3.O000000o((ViewGroup) view.findViewById(R.id.ll_layout_top), 3, 0);
                }
                hcf2.O000000o((ViewGroup) view.findViewById(R.id.ll_left), 3, 1);
                hcf.O000000o((ViewGroup) view.findViewById(R.id.ll_right), 3, 2);
                O000000o(this.O00000o0, this.O00000oO);
                O000000o(view);
                return;
            }
            if (hcf2.O0000Ooo.O00000o() && hcf.O0000Ooo.O00000o()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_title_opration_2_long_shape, this.O00000o0, false);
            }
            if (hcf2.O0000Ooo.O00000oo()) {
                if ((hcf instanceof hea) || (hcf instanceof heu)) {
                    view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_title_opration_button_long_shape, this.O00000o0, false);
                } else if (hcf.O0000Ooo.O00000o()) {
                    View inflate2 = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_1_item_3_operation, this.O00000o0, false);
                    this.O00000o0.addView(inflate2);
                    if (hcf3 != null) {
                        hcf3.O000000o((ViewGroup) inflate2.findViewById(R.id.ll_title_content), 3, 0);
                    }
                    hcf2.O000000o((ViewGroup) inflate2.findViewById(R.id.ll_left), 3, 1);
                    hcf.O000000o((ViewGroup) inflate2.findViewById(R.id.ll_right), 3, 2);
                    O000000o(this.O00000o0, this.O00000oO);
                    O000000o(inflate2);
                    return;
                }
            }
            if (hcf2.O0000Ooo.O00000oO()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_title_opration_number_long_shape, this.O00000o0, false);
            }
            if (hcf2.O0000Ooo.O00000Oo() && hcf.O0000Ooo.O00000oo()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_vertical_title_opration_text_button, this.O00000o0, false);
            }
            if (view == null) {
                Device device = this.O00000oO;
                gsy.O000000o(6, "cardRender", "the type of cardItem illegal,model:".concat(String.valueOf(device != null ? device.model : "")));
                return;
            }
            this.O00000o0.addView(view);
            if (hcf3 != null) {
                hcf3.O000000o((ViewGroup) view.findViewById(R.id.ll_title_content), 3, 0);
            }
            hcf2.O000000o((ViewGroup) view.findViewById(R.id.ll_layout_top), 3, 1);
            hcf.O000000o((ViewGroup) view.findViewById(R.id.ll_layout_bottom), 3, 2);
            O000000o(this.O00000o0, this.O00000oO);
            O000000o(view);
            return;
        }
        View inflate3 = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_lamp, this.O00000o0, false);
        this.O00000o0.addView(inflate3);
        if (hcf3 != null) {
            hcf3.O000000o((ViewGroup) inflate3.findViewById(R.id.ll_title_content), 3, 0);
        }
        hdy hdy = (hdy) hcf2;
        hdz hdz = (hdz) hcf;
        hdy.O0000o = hdz;
        hdz.O000000o((ViewGroup) inflate3.findViewById(R.id.ll_content), 3, 1);
        hdy.O000000o((ViewGroup) inflate3.findViewById(R.id.ll_content), 3, 1);
        O000000o(this.O00000o0, this.O00000oO);
        O000000o(inflate3);
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
