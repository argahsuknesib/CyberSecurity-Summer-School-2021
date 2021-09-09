package _m_j;

import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class exg {

    /* renamed from: O000000o  reason: collision with root package name */
    public TextView f15917O000000o;
    public TextView O00000Oo;
    public TextView O00000o0;

    public exg(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_viewhelper_price);
        this.O00000Oo = textView;
        textView.setTag(67108864, Boolean.TRUE);
        this.O00000o0 = (TextView) view.findViewById(R.id.tv_viewhelper_price_qi);
        this.f15917O000000o = (TextView) view.findViewById(R.id.tv_viewhelper_marketprice);
        dun.O000000o(view.getContext(), this.O00000Oo);
        dun.O000000o(view.getContext(), this.f15917O000000o);
    }
}
