package _m_j;

import _m_j.ewr;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.Gson;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.smarthome.R;

public final class evo extends vx<ewr, vr> {
    private eum O00000o0;

    public final int O000000o() {
        return 14;
    }

    public final int O00000Oo() {
        return R.layout.discover_article_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        ewf ewf;
        String O000000o2;
        ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_content);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_addtime);
        TextView textView4 = (TextView) view.findViewById(R.id.tv_viewCount);
        ImageView imageView = (ImageView) view.findViewById(R.id.id_discover_article_iv);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.id_video_player_btn);
        ((ImageView) view.findViewById(R.id.id_discover_gallery_1)).setVisibility(4);
        imageView.setVisibility(0);
        ewr.O000000o o000000o = ewr.O0000oo0.get(0);
        if (!(o000000o.O0000oO0 == null || TextUtils.isEmpty(o000000o.O0000oO0) || (ewf = (ewf) new Gson().fromJson(o000000o.O0000oO0, ewf.class)) == null)) {
            String str = ewf.O00000o;
            if (str != null && !TextUtils.isEmpty(str)) {
                textView4.setText(ewf.O00000o);
            }
            if (!(ewf.f15882O000000o == null || (O000000o2 = eww.O000000o(ewf.f15882O000000o.longValue())) == null || TextUtils.isEmpty(O000000o2))) {
                textView3.setText(O000000o2);
            }
        }
        if (o000000o.O00000o != null && !TextUtils.isEmpty(o000000o.O00000o)) {
            textView.setText(o000000o.O00000o);
        }
        if (o000000o.O0000Oo0 != null && !TextUtils.isEmpty(o000000o.O0000Oo0)) {
            textView2.setText(o000000o.O0000Oo0);
        }
        int i2 = Resources.getSystem().getDisplayMetrics().widthPixels;
        if (i2 != 0) {
            double O000000o3 = (double) (i2 - dul.O000000o(eui.f15823O000000o, 30.0f));
            Double.isNaN(O000000o3);
            int i3 = (int) (O000000o3 / 2.1d);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = i3;
            imageView.setLayoutParams(layoutParams);
        }
        Option option = new Option();
        option.O00000Oo = R.drawable.default_pic_small_inverse;
        option.O0000O0o = dul.O000000o(imageView.getContext(), 10.0f);
        option.O0000Ooo = true;
        option.O0000OoO = true;
        duh.O000000o().O000000o(o000000o.O00000Oo, imageView, option);
        imageView2.setVisibility(0);
        eum eum = this.O00000o0;
        if (eum != null) {
            eum.O000000o(ewr.O00000Oo, ewr.O0000oo0.get(0));
        }
    }

    public final /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        String str;
        ewf ewf;
        ewr ewr = (ewr) obj;
        String str2 = ewr.O0000oo0.get(0).O00000o0;
        if (this.O00000o0 != null && str2 != null && !TextUtils.isEmpty(str2)) {
            if (ewr.O0000oo0.get(0).O0000oO0 == null || TextUtils.isEmpty(ewr.O0000oo0.get(0).O0000oO0) || (ewf = (ewf) new Gson().fromJson(ewr.O0000oo0.get(0).O0000oO0, ewf.class)) == null) {
                str = "";
            } else {
                str = ewf.O00000o0;
            }
            this.O00000o0.O000000o(ewr.O00000Oo, ewr.O0000oo0.get(0), str);
        }
    }

    public evo() {
    }

    public evo(eum eum) {
        this.O00000o0 = eum;
    }
}
