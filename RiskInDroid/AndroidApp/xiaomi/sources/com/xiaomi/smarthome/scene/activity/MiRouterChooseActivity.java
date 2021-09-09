package com.xiaomi.smarthome.scene.activity;

import _m_j.fno;
import android.os.Bundle;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.scene.activity.SceneItemChooseFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MiRouterChooseActivity extends CommonChooseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.O00000Oo != null) {
            this.O00000Oo.setText((int) R.string.mi_router);
        }
        if (this.O00000o0 != null) {
            this.O00000o0.O000000o(getString(R.string.choose_home_router));
        }
    }

    /* access modifiers changed from: protected */
    public final List<SceneItemChooseFragment.ItemData> O000000o() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
            Device device = (Device) value.getValue();
            if (device.isOwner() && (device instanceof RouterDevice)) {
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
