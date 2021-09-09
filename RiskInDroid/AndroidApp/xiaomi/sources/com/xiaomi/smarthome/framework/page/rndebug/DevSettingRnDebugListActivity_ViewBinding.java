package com.xiaomi.smarthome.framework.page.rndebug;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class DevSettingRnDebugListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DevSettingRnDebugListActivity f7901O000000o;

    public DevSettingRnDebugListActivity_ViewBinding(DevSettingRnDebugListActivity devSettingRnDebugListActivity, View view) {
        this.f7901O000000o = devSettingRnDebugListActivity;
        devSettingRnDebugListActivity.viewWindow = Utils.findRequiredView(view, R.id.layout_dev_setting_rn_debug, "field 'viewWindow'");
        devSettingRnDebugListActivity.viewHeadLeft = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'viewHeadLeft'");
        devSettingRnDebugListActivity.tvHeadTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'tvHeadTitle'", TextView.class);
        devSettingRnDebugListActivity.ivHeadRight = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_right_iv_setting_btn, "field 'ivHeadRight'", ImageView.class);
        devSettingRnDebugListActivity.srvRnDebugPluginModelList = (SlideRecyclerView) Utils.findRequiredViewAsType(view, R.id.srv_rn_debug_plugin_model_list, "field 'srvRnDebugPluginModelList'", SlideRecyclerView.class);
        devSettingRnDebugListActivity.ivPluginDebug = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_plugin_debug, "field 'ivPluginDebug'", ImageView.class);
        devSettingRnDebugListActivity.tvPluginDebug = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_plugin_debug, "field 'tvPluginDebug'", TextView.class);
        devSettingRnDebugListActivity.etSearchModel = (EditText) Utils.findRequiredViewAsType(view, R.id.et_rn_debug_search_model, "field 'etSearchModel'", EditText.class);
        devSettingRnDebugListActivity.srvSearchModelList = (SlideRecyclerView) Utils.findRequiredViewAsType(view, R.id.srv_rn_debug_plugin_search_model_list, "field 'srvSearchModelList'", SlideRecyclerView.class);
        devSettingRnDebugListActivity.layoutRnSettingIp = Utils.findRequiredView(view, R.id.layout_rn_setting_ip, "field 'layoutRnSettingIp'");
        devSettingRnDebugListActivity.tvIpDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ip_detail, "field 'tvIpDetail'", TextView.class);
        devSettingRnDebugListActivity.layoutOtherSetting = Utils.findRequiredView(view, R.id.layout_rn_other_setting, "field 'layoutOtherSetting'");
    }

    public void unbind() {
        DevSettingRnDebugListActivity devSettingRnDebugListActivity = this.f7901O000000o;
        if (devSettingRnDebugListActivity != null) {
            this.f7901O000000o = null;
            devSettingRnDebugListActivity.viewWindow = null;
            devSettingRnDebugListActivity.viewHeadLeft = null;
            devSettingRnDebugListActivity.tvHeadTitle = null;
            devSettingRnDebugListActivity.ivHeadRight = null;
            devSettingRnDebugListActivity.srvRnDebugPluginModelList = null;
            devSettingRnDebugListActivity.ivPluginDebug = null;
            devSettingRnDebugListActivity.tvPluginDebug = null;
            devSettingRnDebugListActivity.etSearchModel = null;
            devSettingRnDebugListActivity.srvSearchModelList = null;
            devSettingRnDebugListActivity.layoutRnSettingIp = null;
            devSettingRnDebugListActivity.tvIpDetail = null;
            devSettingRnDebugListActivity.layoutOtherSetting = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
