package com.xiaomi.smarthome.scene.activity;

import _m_j.fno;
import android.os.Bundle;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.scene.activity.SceneItemChooseFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BodySensorChooseActivity extends CommonChooseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.O00000Oo != null) {
            this.O00000Oo.setText((int) R.string.gateway_motion_name);
        }
        if (this.O00000o0 != null) {
            this.O00000o0.O000000o(getString(R.string.choose_body_sensor));
        }
    }

    /* access modifiers changed from: protected */
    public final List<SceneItemChooseFragment.ItemData> O000000o() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : fno.O000000o().O00000Oo().entrySet()) {
            Device device = (Device) value.getValue();
            if (device.isOwner() && DeviceFactory.O0000O0o(device.model, "lumi.sensor_motion.v1")) {
                this.O00000o.add(device);
                SceneItemChooseFragment.ItemData itemData = new SceneItemChooseFragment.ItemData();
                itemData.f10832O000000o = device.did;
                itemData.O00000Oo = device.getName();
                arrayList.add(itemData);
            }
        }
        return arrayList;
    }
}
