package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.card.BaseCardRender;
import java.util.List;

public final class hdo<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hcf<C, E, T> {
    private TextView O0000o;
    private TextView O0000o0o;
    private int O0000oO;
    private int O0000oO0;
    private int O0000oOO;

    public hdo(E e, T[] tArr) {
        super(e, tArr);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        try {
            RelativeLayout relativeLayout = (RelativeLayout) O000000o(viewGroup, (int) R.layout.miui10_card_item_text_string);
            this.O0000oO0 = viewGroup.getResources().getColor(R.color.mj_color_gray_lighter);
            this.O0000o0o = (TextView) relativeLayout.findViewById(R.id.desc);
            this.O0000o = (TextView) relativeLayout.findViewById(R.id.value);
            TextView textView = this.O0000o0o;
            TextView textView2 = this.O0000o;
            if (textView == null) {
                return;
            }
            if (textView2 != null) {
                this.O0000oO = textView.getCurrentTextColor();
                this.O0000oOO = textView2.getCurrentTextColor();
                Device O00000oO = O00000oO();
                List O00000Oo = O00000oo().O00000Oo();
                if (O00000Oo.size() == 3 && ((hcc.O000000o) O00000Oo.get(0)).O00000Oo() && ((hcc.O000000o) O00000Oo.get(1)).O00000Oo() && ((hcc.O000000o) O00000Oo.get(2)).O00000Oo()) {
                    this.O0000o.setTextSize(1, 33.0f);
                }
                O000000o(this.O0000Ooo.O00000Oo(O00000oO, hfa.O000000o((Object[]) this.f18773O000000o)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000o0o = null;
        this.O0000o = null;
    }

    private void O000000o(Object obj) {
        if (!this.O0000Oo0) {
            TextView textView = this.O0000o0o;
            TextView textView2 = this.O0000o;
            if (textView != null && textView2 != null) {
                try {
                    String O000000o2 = this.O0000Ooo.O000000o(O00000oO(), hfa.O000000o((Object[]) this.f18773O000000o), obj);
                    String O000000o3 = this.O0000Ooo.O000000o(O00000oO(), hfa.O000000o((Object[]) this.f18773O000000o));
                    if (!TextUtils.isEmpty(O000000o2)) {
                        textView.setText(O000000o2);
                    } else if (!TextUtils.isEmpty(O000000o3)) {
                        textView.setText(O000000o3);
                    } else {
                        textView.setText("--");
                    }
                    Pair<Object, Long> O00000o = this.O0000Ooo.O00000o(O00000oO(), hfa.O000000o((Object[]) this.f18773O000000o));
                    if (O00000o == null) {
                        textView2.setText("--");
                        return;
                    }
                    long O000000o4 = hhc.O000000o(O00000o.second);
                    if (O000000o4 != 0) {
                        textView2.setText(hhc.O000000o(O000000o4));
                    } else {
                        textView2.setText("--");
                    }
                    hcc O00000oo = O00000oo();
                    if ((O00000oO() instanceof BleDevice) || (((O00000oo instanceof heb) && ((heb) O00000oo).O00000oO) || (O00000oO().isOnline && this.O0000o0O == BaseCardRender.DataInitState.DONE))) {
                        textView2.setTextColor(this.O0000oOO);
                        textView.setTextColor(this.O0000oO);
                        return;
                    }
                    textView2.setTextColor(this.O0000oO0);
                    textView.setTextColor(this.O0000oO0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void O000000o(T t, Object obj) {
        if (!this.O0000Oo0 && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            O000000o(obj);
        }
    }
}
