package _m_j;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class ghe extends ghc {
    public TextView O00000Oo;
    public View O00000o;
    public TextView O00000o0;

    public ghe(View view) {
        super(view);
        this.O00000Oo = (TextView) view.findViewById(R.id.title_left);
        this.O00000o0 = (TextView) view.findViewById(R.id.title_right);
        this.O00000o = view.findViewById(R.id.top_divider);
    }

    public final void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000Oo.setText(str);
        }
        this.O00000o0.setVisibility(8);
        View view = this.O00000o;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
