package _m_j;

import android.view.View;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

public final class euw extends euk<ewp, vr> {
    public final int O000000o() {
        return 25;
    }

    public final int O00000Oo() {
        return R.layout.content_show_1_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        View view = vrVar.itemView;
        view.findViewById(R.id.product_name);
        duh.O000000o().O000000o(((ewp) obj).f15897O000000o.get(0).f15898O000000o, (ImageView) view.findViewById(R.id.product_img));
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewp) obj, i);
    }
}
