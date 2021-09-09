package _m_j;

import android.content.Context;
import android.hardware.SensorManager;
import android.view.View;
import com.xiaomi.shopviews.adapter.bigvision.GravityImageView;
import com.xiaomi.smarthome.R;

public final class euv extends euk<ewi, vr> {
    eut O00000o0 = new eut();

    public final int O000000o() {
        return 18;
    }

    public final int O00000Oo() {
        return R.layout.big_vision_list_item;
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewi) obj, i);
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        View view = vrVar.itemView;
        ((GravityImageView) view.findViewById(R.id.panorama_image_view1)).setGyroscopeObserver(this.O00000o0);
        ((GravityImageView) view.findViewById(R.id.panorama_image_view2)).setGyroscopeObserver(this.O00000o0);
        ((GravityImageView) view.findViewById(R.id.panorama_image_view3)).setGyroscopeObserver(this.O00000o0);
        eut eut = this.O00000o0;
        Context context = view.getContext();
        if (eut.f15835O000000o == null) {
            eut.f15835O000000o = (SensorManager) context.getSystemService("sensor");
        }
        eut.f15835O000000o.registerListener(eut, eut.f15835O000000o.getDefaultSensor(4), 0);
        eut.O00000Oo = 0;
        eut.O00000o = 0.0d;
        eut.O00000o0 = 0.0d;
    }
}
