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

public final class hcj<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hbz<C, E, T> {
    View O0000Oo;
    hhk O0000Oo0;

    public hcj(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device) {
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
        View view2;
        super.O000000o();
        if (this.f10206O000000o.size() == 3 && (this.f10206O000000o.get(1) instanceof hdy) && (this.f10206O000000o.get(2) instanceof hdz)) {
            View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_lamp, this.O00000o0, false);
            this.O00000o0.addView(inflate);
            ((hcf) this.f10206O000000o.get(0)).O000000o((ViewGroup) inflate.findViewById(R.id.ll_title_content), 3, 0);
            hdy hdy = (hdy) this.f10206O000000o.get(1);
            hdz hdz = (hdz) this.f10206O000000o.get(2);
            hdy.O0000o = hdz;
            hdz.O000000o((ViewGroup) inflate.findViewById(R.id.ll_content), 3, 1);
            hdy.O000000o((ViewGroup) inflate.findViewById(R.id.ll_content), 3, 1);
            O000000o(this.O00000o0, this.O00000oO);
            O000000o(inflate);
        } else if (this.f10206O000000o.size() == 1 && (this.f10206O000000o.get(0) instanceof hcb)) {
            View inflate2 = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_1_item_camera, this.O00000o0, false);
            this.O00000o0.addView(inflate2);
            ((hcf) this.f10206O000000o.get(0)).O000000o((ViewGroup) inflate2.findViewById(R.id.ll_content), 1, 0);
            O000000o(this.O00000o0, this.O00000oO);
            O000000o(inflate2);
        } else if (this.f10206O000000o.size() == 1) {
            View inflate3 = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_1_item, this.O00000o0, false);
            hcf hcf = (hcf) this.f10206O000000o.get(0);
            if (hcf instanceof hdx) {
                inflate3 = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_1_item_multibutton, this.O00000o0, false);
            }
            this.O00000o0.addView(inflate3);
            hcf.O000000o((ViewGroup) inflate3.findViewById(R.id.ll_content), 1, 0);
            O000000o(this.O00000o0, this.O00000oO);
            O000000o(inflate3);
        } else if (this.f10206O000000o.size() == 2) {
            if (((hcf) this.f10206O000000o.get(1)).O0000Ooo.O00000o()) {
                view2 = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_1_item_2_operation, this.O00000o0, false);
            } else {
                view2 = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_1_item_2_subitem, this.O00000o0, false);
            }
            this.O00000o0.addView(view2);
            ((hcf) this.f10206O000000o.get(0)).O000000o((ViewGroup) view2.findViewById(R.id.ll_left), 2, 0);
            ((hcf) this.f10206O000000o.get(1)).O000000o((ViewGroup) view2.findViewById(R.id.ll_right), 2, 1);
            O000000o(this.O00000o0, this.O00000oO);
            O000000o(view2);
        } else if (this.f10206O000000o.size() == 3) {
            if (((hcf) this.f10206O000000o.get(2)).O0000Ooo.O00000o()) {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_1_item_3_operation, this.O00000o0, false);
            } else {
                view = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_1_item_3_subitem, this.O00000o0, false);
            }
            this.O00000o0.addView(view);
            ((hcf) this.f10206O000000o.get(0)).O000000o((ViewGroup) view.findViewById(R.id.ll_title_content), 3, 0);
            ((hcf) this.f10206O000000o.get(1)).O000000o((ViewGroup) view.findViewById(R.id.ll_left), 3, 1);
            ((hcf) this.f10206O000000o.get(2)).O000000o((ViewGroup) view.findViewById(R.id.ll_right), 3, 2);
            O000000o(this.O00000o0, this.O00000oO);
            O000000o(view);
        } else {
            throw new IllegalArgumentException("the number of cardItem illegal " + this.O00000oO.getName() + "model:" + this.O00000oO.model);
        }
    }

    public final hhk O00000Oo() {
        return this.O0000Oo0;
    }

    public final View O00000o0() {
        return this.O0000Oo;
    }

    private void O000000o(View view) {
        this.O0000Oo0 = (hhk) view.findViewById(R.id.dpb_enter_device);
        this.O0000Oo = view.findViewById(R.id.progress_enter_device);
    }
}
