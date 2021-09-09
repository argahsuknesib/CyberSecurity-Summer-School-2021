package _m_j;

import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class O000o0 extends vp<O00O00o0, vr> {
    public O000o0(List list) {
        super(R.layout.ht_item_album, list);
    }

    public final void O000000o(vr vrVar, Object obj) {
        O00O00o0 o00O00o0 = (O00O00o0) obj;
        uo.O000000o(this.O0000Oo0).O000000o(o00O00o0.f6625O000000o).O000000o((ImageView) vrVar.O00000Oo(R.id.album_image));
        String str = o00O00o0.O00000Oo;
        vrVar.O000000o((int) R.id.album_name, str.substring(str.lastIndexOf("/") + 1));
        vrVar.O000000o((int) R.id.album_number, String.valueOf(o00O00o0.O00000o0));
    }
}
