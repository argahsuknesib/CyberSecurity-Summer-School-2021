package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.common.widget.AutoSizeTextView;
import com.xiaomi.smarthome.newui.card.BaseCardRender;

public final class hdn<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hcf<C, E, T> {
    private AutoSizeTextView O0000o;
    private TextView O0000o0o;
    private int O0000oO;
    private int O0000oO0;
    private int O0000oOO;
    private int O0000oOo;

    public hdn(E e, T[] tArr) {
        super(e, tArr);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        this.O0000oOo = i2;
        try {
            RelativeLayout relativeLayout = (RelativeLayout) O000000o(viewGroup, (int) R.layout.miui10_card_item_text_string);
            this.O0000oO0 = viewGroup.getResources().getColor(R.color.mj_color_gray_lighter);
            this.O0000o0o = (TextView) relativeLayout.findViewById(R.id.desc);
            this.O0000o = (AutoSizeTextView) relativeLayout.findViewById(R.id.value);
            TextView textView = this.O0000o0o;
            AutoSizeTextView autoSizeTextView = this.O0000o;
            if (textView == null) {
                return;
            }
            if (autoSizeTextView != null) {
                this.O0000oO = textView.getCurrentTextColor();
                this.O0000oOO = autoSizeTextView.getCurrentTextColor();
                O000000o(this.O0000Ooo.O00000Oo(O00000oO(), hfa.O000000o((Object[]) this.f18773O000000o)));
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
            AutoSizeTextView autoSizeTextView = this.O0000o;
            if (textView != null && autoSizeTextView != null) {
                Device O00000oO = O00000oO();
                Object O000000o2 = hfa.O000000o((Object[]) this.f18773O000000o);
                String O000000o3 = this.O0000Ooo.O000000o(O00000oO, O000000o2);
                if (O000000o3 != null) {
                    textView.setText(O000000o3);
                }
                if (obj == null || "".equals(obj)) {
                    autoSizeTextView.setText("--");
                } else {
                    String O000000o4 = this.O0000Ooo.O000000o(O00000oO, O000000o2, obj);
                    int size = O00000oo().O00000Oo().size();
                    this.O0000o.setSingleLine(false);
                    if (size != 1) {
                        this.O0000o.setMaxLines(1);
                        this.O0000o.setEllipsize(TextUtils.TruncateAt.END);
                    } else if (String.valueOf(O000000o4).contains("\n")) {
                        this.O0000o.setMaxLines(2);
                        O000000o4 = String.valueOf(O000000o4).replace("\n", "");
                    } else {
                        this.O0000o.setMaxLines(1);
                        this.O0000o.setEllipsize(TextUtils.TruncateAt.END);
                    }
                    autoSizeTextView.setText(String.valueOf(O000000o4));
                }
                String O00000Oo = this.O0000Ooo.O00000Oo(O00000oO, O000000o2, obj);
                if (!TextUtils.isEmpty(O00000Oo)) {
                    this.O0000oOO = hyj.O00000o0.O000000o(Color.parseColor(O00000Oo));
                } else {
                    this.O0000oOO = autoSizeTextView.getResources().getColor(R.color.mj_color_black_80_transparent);
                }
                hcc O00000oo = O00000oo();
                if ((O00000oO instanceof BleDevice) || (((O00000oo instanceof heb) && ((heb) O00000oo).O00000oO) || (O00000oO.isOnline && this.O0000o0O == BaseCardRender.DataInitState.DONE))) {
                    autoSizeTextView.setTextColor(this.O0000oOO);
                    textView.setTextColor(this.O0000oO);
                } else {
                    autoSizeTextView.setTextColor(this.O0000oO0);
                    textView.setTextColor(this.O0000oO0);
                }
                hgw.O000000o(O00000oo(), this.O0000oOo, this.O0000o0o, 1, this.O0000o, null);
            }
        }
    }

    public final void O000000o(T t, Object obj) {
        if (!this.O0000Oo0 && O00000oO() != null && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            O000000o(obj);
        }
    }
}
