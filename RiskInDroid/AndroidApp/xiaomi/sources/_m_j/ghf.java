package _m_j;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class ghf extends ghc {
    private TextView O00000Oo;

    public ghf(View view) {
        super(view);
        this.O00000Oo = (TextView) view.findViewById(R.id.title_left);
    }

    public final void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000Oo.setText(str);
        }
    }
}
