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

public final class hck<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hbz<C, E, T> {
    private View O0000Oo;
    hhk O0000Oo0;

    public hck(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device) {
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
        hcf hcf = (hcf) this.f10206O000000o.get(0);
        View inflate = hcf.O0000Ooo.O00000oo() ? LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_horizontal_2_button, this.O00000o0, false) : null;
        if (hcf.O0000Ooo.O00000oO()) {
            inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_2_item_horizontal_2_number, this.O00000o0, false);
        }
        if (inflate == null) {
            inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_1_item_2_subitem, this.O00000o0, false);
        }
        this.O00000o0.addView(inflate);
        ((hcf) this.f10206O000000o.get(0)).O000000o((ViewGroup) inflate.findViewById(R.id.ll_left), 2, 0);
        ((hcf) this.f10206O000000o.get(1)).O000000o((ViewGroup) inflate.findViewById(R.id.ll_right), 2, 1);
        O000000o(this.O00000o0, this.O00000oO);
        this.O0000Oo0 = (hhk) inflate.findViewById(R.id.dpb_enter_device);
        this.O0000Oo = inflate.findViewById(R.id.progress_enter_device);
    }

    public final hhk O00000Oo() {
        return this.O0000Oo0;
    }

    public final View O00000o0() {
        return this.O0000Oo;
    }
}
