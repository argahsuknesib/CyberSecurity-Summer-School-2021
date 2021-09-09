package com.xiaomi.smarthome.device;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.FixHeightGridView;

public class ChooseConnectDevice_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ChooseConnectDevice f6922O000000o;

    public ChooseConnectDevice_ViewBinding(ChooseConnectDevice chooseConnectDevice, View view) {
        this.f6922O000000o = chooseConnectDevice;
        chooseConnectDevice.mListView = (FixHeightGridView) Utils.findRequiredViewAsType(view, R.id.device_list, "field 'mListView'", FixHeightGridView.class);
        chooseConnectDevice.inScanHint = Utils.findRequiredView(view, R.id.inScanHint, "field 'inScanHint'");
        chooseConnectDevice.mRadarImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.scanning_image, "field 'mRadarImage'", ImageView.class);
        chooseConnectDevice.mMoreDevice = (Button) Utils.findRequiredViewAsType(view, R.id.more_device, "field 'mMoreDevice'", Button.class);
        chooseConnectDevice.mHelpTips = (TextView) Utils.findRequiredViewAsType(view, R.id.can_not_find_device, "field 'mHelpTips'", TextView.class);
        chooseConnectDevice.mRadarBgImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.radar_bg, "field 'mRadarBgImg'", ImageView.class);
        chooseConnectDevice.mScanDescTv = (TextView) Utils.findRequiredViewAsType(view, R.id.sc_scan_desc, "field 'mScanDescTv'", TextView.class);
    }

    public void unbind() {
        ChooseConnectDevice chooseConnectDevice = this.f6922O000000o;
        if (chooseConnectDevice != null) {
            this.f6922O000000o = null;
            chooseConnectDevice.mListView = null;
            chooseConnectDevice.inScanHint = null;
            chooseConnectDevice.mRadarImage = null;
            chooseConnectDevice.mMoreDevice = null;
            chooseConnectDevice.mHelpTips = null;
            chooseConnectDevice.mRadarBgImg = null;
            chooseConnectDevice.mScanDescTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
