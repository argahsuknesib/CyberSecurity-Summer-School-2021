package _m_j;

import android.widget.RadioGroup;
import com.hannto.print.pickimage.activity.PickPhotoActivity;
import com.xiaomi.smarthome.R;

public final class O00O0OOo implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ PickPhotoActivity f6627O000000o;

    public O00O0OOo(PickPhotoActivity pickPhotoActivity) {
        this.f6627O000000o = pickPhotoActivity;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.photo) {
            this.f6627O000000o.f4352a.setCurrentItem(0, false);
        } else if (i == R.id.album) {
            this.f6627O000000o.f4352a.setCurrentItem(1, false);
        }
    }
}
