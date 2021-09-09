package com.xiaomi.smarthome.framework.page.rndebug;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class RnDebugOtherSettingActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private RnDebugOtherSettingActivity f7927O000000o;

    public RnDebugOtherSettingActivity_ViewBinding(RnDebugOtherSettingActivity rnDebugOtherSettingActivity, View view) {
        this.f7927O000000o = rnDebugOtherSettingActivity;
        rnDebugOtherSettingActivity.viewHeadLeft = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'viewHeadLeft'");
        rnDebugOtherSettingActivity.tvHeadTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'tvHeadTitle'", TextView.class);
        rnDebugOtherSettingActivity.mSwBtnRnPluginTimeToal = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_rn_plugin_time_total, "field 'mSwBtnRnPluginTimeToal'", SwitchButton.class);
        rnDebugOtherSettingActivity.mSwBtnRnPluginSdkVersionInfo = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_rn_plugin_sdk_version_info, "field 'mSwBtnRnPluginSdkVersionInfo'", SwitchButton.class);
        rnDebugOtherSettingActivity.mSwBtnUseOldPluginOnly = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_use_old_plugin_only, "field 'mSwBtnUseOldPluginOnly'", SwitchButton.class);
        rnDebugOtherSettingActivity.mSwBtnUsePreviewAppConfig = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_use_preview_app_config, "field 'mSwBtnUsePreviewAppConfig'", SwitchButton.class);
        rnDebugOtherSettingActivity.mSwBtnRnPluginFpsMemory = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_rn_plugin_fps_memory, "field 'mSwBtnRnPluginFpsMemory'", SwitchButton.class);
        rnDebugOtherSettingActivity.mSwBtnForceUseInnerRnSdk = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_force_use_inner_rn_sdk, "field 'mSwBtnForceUseInnerRnSdk'", SwitchButton.class);
        rnDebugOtherSettingActivity.mSwBtnForcePlaintextTransmission = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_force_plaintext_transmission, "field 'mSwBtnForcePlaintextTransmission'", SwitchButton.class);
        rnDebugOtherSettingActivity.mSwBtnForceAllModelSupportReuse = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_force_all_model_support_reuse, "field 'mSwBtnForceAllModelSupportReuse'", SwitchButton.class);
        rnDebugOtherSettingActivity.mSwBtnForceCloseAllModelSupportReuse = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_force_all_model_not_support_reuse, "field 'mSwBtnForceCloseAllModelSupportReuse'", SwitchButton.class);
        rnDebugOtherSettingActivity.mSwBtnSupportScanDebugReuse = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_support_scan_debug_reuse, "field 'mSwBtnSupportScanDebugReuse'", SwitchButton.class);
        rnDebugOtherSettingActivity.mEtLocalPingCount = (EditText) Utils.findRequiredViewAsType(view, R.id.et_local_ping_count, "field 'mEtLocalPingCount'", EditText.class);
        rnDebugOtherSettingActivity.mEtLocalPingRetryTime = (EditText) Utils.findRequiredViewAsType(view, R.id.et_local_ping_retry_time, "field 'mEtLocalPingRetryTime'", EditText.class);
        rnDebugOtherSettingActivity.mSwBtnLocalPing = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.swb_use_localping, "field 'mSwBtnLocalPing'", SwitchButton.class);
        rnDebugOtherSettingActivity.mLayoutDevicePluginInfo = Utils.findRequiredView(view, R.id.layout_device_plugin_info, "field 'mLayoutDevicePluginInfo'");
        rnDebugOtherSettingActivity.mLayoutPluginInstall = Utils.findRequiredView(view, R.id.layout_plugin_install, "field 'mLayoutPluginInstall'");
        rnDebugOtherSettingActivity.mLayoutPluginDownload = Utils.findRequiredView(view, R.id.layout_plugin_download, "field 'mLayoutPluginDownload'");
        rnDebugOtherSettingActivity.mExportLog = Utils.findRequiredView(view, R.id.layout_plugin_export_log, "field 'mExportLog'");
    }

    public void unbind() {
        RnDebugOtherSettingActivity rnDebugOtherSettingActivity = this.f7927O000000o;
        if (rnDebugOtherSettingActivity != null) {
            this.f7927O000000o = null;
            rnDebugOtherSettingActivity.viewHeadLeft = null;
            rnDebugOtherSettingActivity.tvHeadTitle = null;
            rnDebugOtherSettingActivity.mSwBtnRnPluginTimeToal = null;
            rnDebugOtherSettingActivity.mSwBtnRnPluginSdkVersionInfo = null;
            rnDebugOtherSettingActivity.mSwBtnUseOldPluginOnly = null;
            rnDebugOtherSettingActivity.mSwBtnUsePreviewAppConfig = null;
            rnDebugOtherSettingActivity.mSwBtnRnPluginFpsMemory = null;
            rnDebugOtherSettingActivity.mSwBtnForceUseInnerRnSdk = null;
            rnDebugOtherSettingActivity.mSwBtnForcePlaintextTransmission = null;
            rnDebugOtherSettingActivity.mSwBtnForceAllModelSupportReuse = null;
            rnDebugOtherSettingActivity.mSwBtnForceCloseAllModelSupportReuse = null;
            rnDebugOtherSettingActivity.mSwBtnSupportScanDebugReuse = null;
            rnDebugOtherSettingActivity.mEtLocalPingCount = null;
            rnDebugOtherSettingActivity.mEtLocalPingRetryTime = null;
            rnDebugOtherSettingActivity.mSwBtnLocalPing = null;
            rnDebugOtherSettingActivity.mLayoutDevicePluginInfo = null;
            rnDebugOtherSettingActivity.mLayoutPluginInstall = null;
            rnDebugOtherSettingActivity.mLayoutPluginDownload = null;
            rnDebugOtherSettingActivity.mExportLog = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
