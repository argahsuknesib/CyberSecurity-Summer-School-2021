package _m_j;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class hel extends hec {
    public final /* bridge */ /* synthetic */ void O000000o(Object obj, Object obj2) {
    }

    public hel(hed hed) {
        super(hed);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        String str;
        super.O000000o(viewGroup, i, i2);
        View O000000o2 = O000000o(viewGroup, (int) R.layout.miui10_card_item_text_number);
        TextView textView = (TextView) O000000o2.findViewById(R.id.desc);
        TextView textView2 = (TextView) O000000o2.findViewById(R.id.value);
        O000000o2.findViewById(R.id.unit);
        if (i2 != i - 1) {
            View findViewById = O000000o2.findViewById(R.id.card_item_divider);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            marginLayoutParams.setMargins(gpc.O000000o(O000000o2.getContext(), 13.0f), 0, gpc.O000000o(O000000o2.getContext(), 13.0f), 0);
            findViewById.setLayoutParams(marginLayoutParams);
            findViewById.requestLayout();
        }
        if (this.O0000Ooo.O000000o() == null) {
            str = null;
        } else {
            str = this.O0000Ooo.O000000o().O0000OoO;
        }
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText(O0000OOo());
        }
        Pair<Object, Long> O000000o3 = ((hed) this.O0000Ooo).O00000o(O00000oO(), (String) hfa.O000000o((Object[]) this.f18773O000000o));
        if (O000000o3 != null) {
            textView2.setText(hhc.O000000o(((Long) O000000o3.second).longValue()));
        }
    }
}
