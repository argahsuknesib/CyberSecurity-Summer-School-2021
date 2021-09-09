package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;

public final class hcn<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hbz<C, E, T> {
    private View O0000Oo;
    private hhk O0000Oo0;

    public hcn(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device) {
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
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_4_item_2_line, this.O00000o0, false);
        this.O00000o0.addView(inflate);
        int size = this.f10206O000000o.size();
        try {
            ((hcf) this.f10206O000000o.get(0)).O000000o((ViewGroup) inflate.findViewById(R.id.ll_layout_topleft), size, 0);
            ((hcf) this.f10206O000000o.get(1)).O000000o((ViewGroup) inflate.findViewById(R.id.ll_layout_topright), size, 1);
            ((hcf) this.f10206O000000o.get(2)).O000000o((ViewGroup) inflate.findViewById(R.id.ll_layout_bottomleft), size, 2);
            ((hcf) this.f10206O000000o.get(3)).O000000o((ViewGroup) inflate.findViewById(R.id.ll_layout_bottomright), size, 3);
        } catch (Exception e) {
            Log.e("mijia-card", "fatal", e);
            Context context = this.O00000o;
            hte.O000000o(context, "卡片样式配置错误 " + this.O00000Oo.O00000Oo);
        }
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
