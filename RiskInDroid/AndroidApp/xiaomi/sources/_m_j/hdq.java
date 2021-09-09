package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueRange;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.widget.CurtainControlView;
import java.util.ArrayList;

public final class hdq<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hcf<C, E, T> {
    public CurtainControlView O0000o0o;

    public hdq(E e, T[] tArr) {
        super(e, tArr);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        try {
            this.O0000o0o = (CurtainControlView) O000000o(viewGroup, (int) R.layout.miui10_card_item_curtain).findViewById(R.id.ccv);
            ArrayList arrayList = new ArrayList();
            if (O00000oO().pid == Device.PID_VIRTUAL_GROUP) {
                arrayList.add(new int[]{-1509949441, 704643071});
                arrayList.add(new int[]{-1929379841, 654311423});
                arrayList.add(new int[]{1929379839, 603979775});
                arrayList.add(new int[]{1509949439, 553648127});
                arrayList.add(new int[]{1073741823, 402653183});
                this.O0000o0o.O000000o(new int[]{-16748072, -10760961}, arrayList);
                this.O0000o0o.setMode(1);
            } else {
                arrayList.add(new int[]{704643071, -654311425});
                arrayList.add(new int[]{654311423, -1073741825});
                arrayList.add(new int[]{603979775, -1509949441});
                arrayList.add(new int[]{553648127, -1929379841});
                arrayList.add(new int[]{402653183, 1929379839});
                arrayList.add(new int[]{352321535, 1509949439});
                this.O0000o0o.O000000o(new int[]{-16748072, -10760961}, arrayList);
                this.O0000o0o.setMode(0);
            }
            O000000o(hfa.O000000o((Object[]) this.f18773O000000o), this.O0000Ooo.O00000Oo(O00000oO(), hfa.O000000o((Object[]) this.f18773O000000o)));
            ConstraintValue constraintValue = ((SpecProperty) hfa.O000000o((Object[]) this.f18773O000000o)).getPropertyDefinition().getConstraintValue();
            if (!(constraintValue instanceof ValueRange)) {
                gsy.O00000Oo(LogType.CARD, "mijia-card", "SpecPlusMinusCardItem not define ValueRange:".concat(String.valueOf(constraintValue)));
            } else {
                this.O0000o0o.setTouchCallback(new hhg() {
                    /* class _m_j.hdq.AnonymousClass1 */

                    public final void O000000o() {
                        hdq hdq = hdq.this;
                        hdq.O000000o(hdb.O000000o(hdq.O00000o0, hdq.this.O0000Ooo.O00000Oo(hdq.this.O00000oO(), hfa.O000000o((Object[]) hdq.this.f18773O000000o))), hdq.this.O00000oO(), hfa.O000000o((Object[]) hdq.this.f18773O000000o), hdq.this.O0000Ooo.O000000o(hfa.O000000o((Object[]) hdq.this.f18773O000000o), (int) (((float) hdq.this.O0000Ooo.O000000o(hfa.O000000o((Object[]) hdq.this.f18773O000000o))) * (1.0f - hdq.this.O0000o0o.getOpenPercent()))), null);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000OOo = null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    public final void O000000o(T t, Object obj) {
        if (!this.O0000Oo0 && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            this.O0000o0o.setOpenPercent((float) (1.0d - (hhc.O000000o(obj, 0.0d) / 100.0d)));
            this.O0000o0o.setEnabled(O000000o(O00000oO(), (hdb) null));
        }
    }
}
