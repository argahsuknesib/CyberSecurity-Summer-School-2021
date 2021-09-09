package _m_j;

import android.content.Context;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.library.common.widget.SettingsItemView;
import java.util.List;

public final class gik extends eza<DeviceStat> {
    public O000000o O00000o0;

    public interface O000000o {
        void onClick(View view, DeviceStat deviceStat);
    }

    public final int O000000o() {
        return R.layout.item_gateway_choose;
    }

    public final /* synthetic */ void O000000o(ezc ezc, Object obj, final int i) {
        DeviceStat deviceStat = (DeviceStat) obj;
        SettingsItemView settingsItemView = (SettingsItemView) ezc.O000000o((int) R.id.ir_device_item);
        if (!deviceStat.isOnline) {
            settingsItemView.setTitle(deviceStat.name + this.f15967O000000o.getResources().getString(R.string.ir_device_offline));
            settingsItemView.setEnabled(false);
            settingsItemView.setAlpha(0.8f);
        } else {
            settingsItemView.setTitle(deviceStat.name);
        }
        gsy.O000000o(3, "IRGateWayChooseAdapter", "convert: share : " + deviceStat.ownerName + " name " + deviceStat.name);
        if (!(((deviceStat.permitLevel & 30) & 16) != 0)) {
            settingsItemView.setTitle(deviceStat.name + this.f15967O000000o.getResources().getString(R.string.ir_device_share));
            settingsItemView.setEnabled(false);
            settingsItemView.setAlpha(0.8f);
        }
        settingsItemView.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.gik.AnonymousClass1 */

            public final void onClick(View view) {
                gik.this.O00000o0.onClick(view, (DeviceStat) gik.this.getItem(i));
            }
        });
    }

    public gik(Context context, List<DeviceStat> list, O000000o o000000o) {
        super(context, list);
        this.O00000o0 = o000000o;
    }
}
