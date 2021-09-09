package _m_j;

import android.widget.ImageView;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.smarthome.R;

public final class evh extends euk<ewk, vr> {
    public final int O000000o() {
        return 22;
    }

    public final int O00000Oo() {
        return R.layout.crowdfunding_single_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        ImageView imageView = (ImageView) vrVar.itemView.findViewById(R.id.imageView);
        Option option = new Option();
        option.O0000O0o = dul.O000000o(imageView.getContext(), 10.0f);
        duh.O000000o().O000000o(((ewk) obj).f15888O000000o.get(0).f15889O000000o, imageView, option);
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewk) obj, i);
    }
}
