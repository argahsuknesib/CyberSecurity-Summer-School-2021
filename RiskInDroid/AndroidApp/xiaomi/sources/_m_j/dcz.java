package _m_j;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.smarthome.connect.stepview.BaseStepView;
import com.xiaomi.smarthome.R;

public class dcz extends BaseStepView {
    private static final String O00000Oo = "dcz";
    private View.OnClickListener O00000o;
    private String O00000o0;

    public dcz(Context context, String str, View.OnClickListener onClickListener) {
        super(context);
        this.O00000o0 = str;
        this.O00000o = onClickListener;
        TextView textView = (TextView) this.f5631O000000o.findViewById(R.id.common_bottom_tv);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) this.f5631O000000o.findViewById(R.id.icon_view);
        ((TextView) this.f5631O000000o.findViewById(R.id.common_tile_tv)).setText((int) R.string.miconnect_add_device_success);
        textView.setText((int) R.string.miconnect_see_it_in_mijia);
        if (TextUtils.isEmpty(this.O00000o0)) {
            simpleDraweeView.setImageResource(R.drawable.miconnect_launcher_src);
        } else {
            simpleDraweeView.setImageURI(Uri.parse(this.O00000o0));
        }
        dct.O00000oO("device success url " + dct.O000000o(this.O00000o0));
        textView.setOnClickListener(this.O00000o);
    }

    public final View O000000o(Context context) {
        this.f5631O000000o = LayoutInflater.from(context).inflate((int) R.layout.miconnect_success_step, (ViewGroup) null);
        return this.f5631O000000o;
    }
}
