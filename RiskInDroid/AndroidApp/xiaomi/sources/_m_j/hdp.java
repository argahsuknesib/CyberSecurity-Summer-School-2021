package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.widget.BitmapColorPicker;

public final class hdp<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hcf<C, E, T> {
    public BitmapColorPicker O0000o0o;

    public hdp(E e, T[] tArr) {
        super(e, tArr);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        this.O0000o0o = (BitmapColorPicker) O000000o(viewGroup, (int) R.layout.card_item_pick_color).findViewById(R.id.bcp);
        final Device O00000oO = O00000oO();
        final Object O000000o2 = hfa.O000000o((Object[]) this.f18773O000000o);
        this.O0000o0o.setRatio(1.0f);
        this.O0000o0o.setStrawPixel(2);
        this.O0000o0o.setTouchScale(0.06f);
        O000000o(hfa.O000000o((Object[]) this.f18773O000000o), this.O0000Ooo.O00000Oo(O00000oO, O000000o2));
        this.O0000o0o.setTouchCallback(new hhg() {
            /* class _m_j.hdp.AnonymousClass1 */

            public final void O000000o() {
                hdp hdp = hdp.this;
                hdp.O000000o(hdb.O000000o(hdp.O00000o0, hdp.this.O0000Ooo.O00000Oo(O00000oO, O000000o2)), O00000oO, O000000o2, Integer.valueOf(hdp.this.O0000o0o.getSelectColor() & 16777215), null);
            }
        });
    }

    public final void O000000o(T t, Object obj) {
        if (!this.O0000Oo0 && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            this.O0000o0o.setCurrentColor(hhc.O000000o(obj, 0) | -16777216);
            this.O0000o0o.setEnabled(O000000o(O00000oO(), (hdb) null));
        }
    }
}
