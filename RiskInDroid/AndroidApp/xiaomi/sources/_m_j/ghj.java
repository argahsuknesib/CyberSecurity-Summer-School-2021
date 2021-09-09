package _m_j;

import _m_j.ghl;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.homeroom.model.Room;

public class ghj extends ghd {
    public View O00000Oo;
    public View O00000o;
    public View O00000o0;
    public View O00000oO;
    public View O00000oo;
    public TextView O0000O0o;
    public View O0000OOo;
    public ghl.O000000o O0000Oo;
    public View O0000Oo0;
    public ghl.O00000Oo O0000OoO;

    public ghj(View view, ghl.O000000o o000000o) {
        super(view);
        this.O00000Oo = view;
        this.O00000o0 = view.findViewById(R.id.view_group);
        this.O00000o = view.findViewById(R.id.sort_icon);
        this.O00000oO = view.findViewById(R.id.delete_btn);
        this.O0000Oo0 = view.findViewById(R.id.divider_item);
        this.O00000oo = view.findViewById(R.id.imageView);
        this.O0000OOo = view.findViewById(R.id.desc_edit_mode);
        this.O0000O0o = (TextView) view.findViewById(R.id.desc);
        this.O0000Oo = o000000o;
    }

    public void O000000o(ghl ghl, Room room, int i) {
        boolean z = ghl.O0000O0o;
        int i2 = 8;
        this.O0000OOo.setVisibility((!z || ghl.O0000OOo) ? 8 : 0);
        View view = this.O00000oo;
        if (!z) {
            i2 = 0;
        }
        view.setVisibility(i2);
        int size = ggb.O00000Oo().O0000O0o().size();
        this.O00000o0.setVisibility(size > 0 ? 0 : 4);
        if (size <= 1) {
            this.O0000O0o.setText(CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.choose_device_device_count, size, Integer.valueOf(size)));
        } else {
            this.O0000O0o.setText(CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.choose_device_device_counts, size, Integer.valueOf(size)));
        }
        this.O00000Oo.setOnLongClickListener(new View.OnLongClickListener() {
            /* class _m_j.ghj.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                if (ghj.this.O0000Oo == null) {
                    return true;
                }
                ghj.this.O0000Oo.O000000o();
                return true;
            }
        });
    }
}
