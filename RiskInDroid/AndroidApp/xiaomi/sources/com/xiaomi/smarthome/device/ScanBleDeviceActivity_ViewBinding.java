package com.xiaomi.smarthome.device;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.choosedevice.ScanDeviceProgressBar;

public class ScanBleDeviceActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ScanBleDeviceActivity f7035O000000o;

    public ScanBleDeviceActivity_ViewBinding(ScanBleDeviceActivity scanBleDeviceActivity, View view) {
        this.f7035O000000o = scanBleDeviceActivity;
        scanBleDeviceActivity.mScanFailView = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.scan_fail_view, "field 'mScanFailView'", RelativeLayout.class);
        scanBleDeviceActivity.mCannotFindDeviceTx = (TextView) Utils.findRequiredViewAsType(view, R.id.cannot_find_device, "field 'mCannotFindDeviceTx'", TextView.class);
        scanBleDeviceActivity.mRescanBt = (Button) Utils.findRequiredViewAsType(view, R.id.scan_again, "field 'mRescanBt'", Button.class);
        scanBleDeviceActivity.mScanDescText = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_desc, "field 'mScanDescText'", TextView.class);
        scanBleDeviceActivity.mProgressBar = (ScanDeviceProgressBar) Utils.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ScanDeviceProgressBar.class);
    }

    public void unbind() {
        ScanBleDeviceActivity scanBleDeviceActivity = this.f7035O000000o;
        if (scanBleDeviceActivity != null) {
            this.f7035O000000o = null;
            scanBleDeviceActivity.mScanFailView = null;
            scanBleDeviceActivity.mCannotFindDeviceTx = null;
            scanBleDeviceActivity.mRescanBt = null;
            scanBleDeviceActivity.mScanDescText = null;
            scanBleDeviceActivity.mProgressBar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
