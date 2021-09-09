package _m_j;

import android.view.View;
import com.xiaomi.shopviews.adapter.discover.widget.BannerLayout;
import com.xiaomi.smarthome.R;

public final class evm extends vx<ewr, vr> {
    private eum O00000o0;

    public final int O000000o() {
        return 11;
    }

    public final int O00000Oo() {
        return R.layout.widget_item_discover_banner;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        View view = vrVar.itemView;
        ((BannerLayout) view.findViewById(R.id.recycler)).setAdapter(new evi(view.getContext(), (ewr) obj, this.O00000o0));
    }

    public evm() {
    }

    public evm(eum eum) {
        this.O00000o0 = eum;
    }
}
