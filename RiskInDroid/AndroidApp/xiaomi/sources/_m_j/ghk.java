package _m_j;

import _m_j.ghl;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.homeroom.HomeRoomEditorActivityV2;
import com.xiaomi.smarthome.homeroom.model.Room;
import java.util.Set;

public final class ghk extends ghj {
    protected View O0000Ooo;
    private TextView O0000o;
    public View O0000o0;
    public View O0000o00;
    public View O0000o0O;
    LinearLayout O0000o0o;
    private View O0000oO;
    private TextView O0000oO0;
    private Set<String> O0000oOO;

    public ghk(View view, ghl.O000000o o000000o) {
        super(view, o000000o);
        this.O0000Ooo = view.findViewById(R.id.root);
        this.O0000o0o = (LinearLayout) view.findViewById(R.id.desc_container);
        this.O0000o = (TextView) view.findViewById(R.id.title);
        this.O0000oO0 = (TextView) view.findViewById(R.id.desc);
        this.O0000oO = view.findViewById(R.id.next_btn);
        this.O0000o00 = view.findViewById(R.id.sort_icon);
        this.O0000o0 = view.findViewById(R.id.delete_btn);
        this.O0000o0O = view.findViewById(R.id.divider_item);
    }

    public final void O000000o(final ghl ghl, final Room room, final int i) {
        final boolean z = ghl.O0000O0o;
        this.O0000oOO = ghl.O00000o0;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O0000o0o.getLayoutParams();
        int i2 = 8;
        if (z) {
            layoutParams.leftMargin = gpc.O00000o0(CommonApplication.getAppContext(), 15.0f);
            layoutParams.setMarginStart(gpc.O00000o0(CommonApplication.getAppContext(), 15.0f));
            this.O0000o0o.setLayoutParams(layoutParams);
            if (i > 0) {
                this.O0000o00.setVisibility(0);
                this.O0000o0.setVisibility(0);
            } else {
                this.O0000o0.setVisibility(4);
                this.O0000o00.setVisibility(4);
            }
        } else {
            layoutParams.leftMargin = gpc.O00000o0(CommonApplication.getAppContext(), 27.0f);
            layoutParams.setMarginStart(gpc.O00000o0(CommonApplication.getAppContext(), 27.0f));
            this.O0000o0o.setLayoutParams(layoutParams);
            this.O0000o00.setVisibility(4);
            this.O0000o0.setVisibility(8);
        }
        View view = this.O0000oO;
        if (!z) {
            i2 = 0;
        }
        view.setVisibility(i2);
        this.O0000o.setText(room.getName());
        if (TextUtils.equals(room.getId(), "mijia.roomid.common")) {
            int size = ggb.O00000Oo().O0000o0().size();
            if (size <= 1) {
                this.O0000oO0.setText(CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.choose_device_device_count, size, Integer.valueOf(size)));
            } else {
                this.O0000oO0.setText(CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.choose_device_device_counts, size, Integer.valueOf(size)));
            }
        } else {
            int O000000o2 = ggb.O00000Oo().O000000o(room);
            if (O000000o2 <= 1) {
                this.O0000oO0.setText(CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.choose_device_device_count, O000000o2, Integer.valueOf(O000000o2)));
            } else {
                this.O0000oO0.setText(CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.choose_device_device_counts, O000000o2, Integer.valueOf(O000000o2)));
            }
        }
        this.O0000o0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.ghk.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ghl.O000000o(com.xiaomi.smarthome.homeroom.model.Room, boolean):void
             arg types: [com.xiaomi.smarthome.homeroom.model.Room, int]
             candidates:
              _m_j.ghl.O000000o(int, int):boolean
              _m_j.axq.O000000o(int, int):boolean
              _m_j.ghl.O000000o(com.xiaomi.smarthome.homeroom.model.Room, boolean):void */
            public final void onClick(View view) {
                if (z) {
                    ghl.O000000o(room, true);
                }
                if (ghk.this.O0000OoO != null) {
                    ghk.this.O0000OoO.O000000o();
                }
            }
        });
        this.O0000Ooo.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.ghk.AnonymousClass2 */

            public final void onClick(View view) {
                if (!z) {
                    Intent intent = new Intent(CommonApplication.getAppContext(), HomeRoomEditorActivityV2.class);
                    intent.addFlags(268435456);
                    intent.putExtra("room_id_param", room.getId());
                    intent.putExtra("room_name", room.getName());
                    intent.putExtra("home_id_param", room.getParentid());
                    CommonApplication.getAppContext().startActivity(intent);
                    hxk hxk = hxi.O00000o;
                    String name = room.getName();
                    hxk.f952O000000o.O000000o("page_room_admin", "room", name);
                }
            }
        });
        this.O0000Ooo.setOnLongClickListener(new View.OnLongClickListener() {
            /* class _m_j.ghk.AnonymousClass3 */

            public final boolean onLongClick(View view) {
                if (ghk.this.O0000Oo != null && !z) {
                    ghk.this.O0000Oo.O000000o();
                }
                hxi.O00000o.O00000oo();
                hxi.O00000o.O0000oo(i == 0 ? "2" : "3");
                return true;
            }
        });
    }
}
