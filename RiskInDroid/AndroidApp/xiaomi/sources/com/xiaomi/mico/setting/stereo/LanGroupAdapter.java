package com.xiaomi.mico.setting.stereo;

import _m_j.we;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.xiaomi.mico.api.model.DeviceState;
import com.xiaomi.mico.api.model.LanGroupInfo;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class LanGroupAdapter extends GroupedRecyclerViewAdapter {
    private Context context;
    private List<LanGroupInfo.LanGroup> mGroups;
    private DeviceState selectedDeviceState;

    public int getChildLayout(int i) {
        return R.layout.item_stereo_lan_device;
    }

    public int getFooterLayout(int i) {
        return 0;
    }

    public int getHeaderLayout(int i) {
        return R.layout.item_stereo_group_header;
    }

    public boolean hasFooter(int i) {
        return false;
    }

    public boolean hasHeader(int i) {
        return true;
    }

    public void onBindFooterViewHolder(we weVar, int i) {
    }

    public LanGroupAdapter(Context context2) {
        super(context2);
        this.context = context2;
    }

    public void setGroups(List<LanGroupInfo.LanGroup> list) {
        this.mGroups = list;
        if (!ContainerUtil.hasData(list)) {
            setSelectedDeviceState(null);
        }
        notifyDataChanged();
    }

    public List<LanGroupInfo.LanGroup> getGroups() {
        return this.mGroups;
    }

    public void setSelectedDeviceState(DeviceState deviceState) {
        this.selectedDeviceState = deviceState;
    }

    public DeviceState getSelectedDeviceState() {
        return this.selectedDeviceState;
    }

    public int getGroupCount() {
        return ContainerUtil.getSize(this.mGroups);
    }

    public int getChildrenCount(int i) {
        return ContainerUtil.getSize((ArrayList) this.mGroups.get(i).devices);
    }

    public void onBindHeaderViewHolder(we weVar, int i) {
        int i2;
        Resources resources;
        LanGroupInfo.LanGroup lanGroup = this.mGroups.get(i);
        TextView textView = (TextView) weVar.O000000o(R.id.tv_header);
        if (lanGroup.select) {
            resources = this.context.getResources();
            i2 = R.color.mj_color_black;
        } else {
            resources = this.context.getResources();
            i2 = R.color.mj_color_gray_lighter;
        }
        textView.setTextColor(resources.getColor(i2));
        textView.setCompoundDrawablesWithIntrinsicBounds(lanGroup.select ? R.drawable.icon_lan_wifi_selected : R.drawable.icon_lan_wifi, 0, 0, 0);
        textView.setText(this.context.getString(R.string.setting_stereo_lan, String.valueOf(i + 1)));
    }

    public void onBindChildViewHolder(we weVar, int i, int i2) {
        Hardware safeValueOf;
        LanGroupInfo.LanGroup lanGroup = this.mGroups.get(i);
        DeviceState deviceState = lanGroup.devices.get(i2);
        ((TextView) weVar.O000000o(R.id.name)).setText(deviceState.deviceName);
        weVar.O000000o(R.id.status, deviceState.select ? R.drawable.mj_webp_widget_checkbox_pres : R.drawable.mj_webp_widget_checkbox_uncheck_pres);
        Hardware safeValueOf2 = Hardware.safeValueOf(deviceState.hardware == null ? "" : deviceState.hardware.toUpperCase());
        if (safeValueOf2 == Hardware.LX06) {
            weVar.O000000o(R.id.device_icon, R.drawable.mico_icon_stereo_lx06);
        } else if (safeValueOf2 == Hardware.L06A) {
            weVar.O000000o(R.id.device_icon, R.drawable.mico_icon_stereo_lx06a);
        } else if (safeValueOf2 == Hardware.L09A) {
            weVar.O000000o(R.id.device_icon, R.drawable.mico_icon_stereo_lx09a);
        } else if (safeValueOf2 == Hardware.L09B) {
            weVar.O000000o(R.id.device_icon, R.drawable.mico_icon_stereo_l09b);
        } else if (safeValueOf2 == Hardware.L15A) {
            weVar.O000000o(R.id.device_icon, R.drawable.mico_icon_stereo_l15a);
        } else if (safeValueOf2 == Hardware.L16A) {
            weVar.O000000o(R.id.device_icon, R.drawable.mico_icon_stereo_l16a);
        }
        View O000000o2 = weVar.O000000o(R.id.child_layout);
        if (lanGroup.selectState == 2) {
            O000000o2.setAlpha(0.4f);
            O000000o2.setClickable(true);
            return;
        }
        O000000o2.setAlpha(1.0f);
        O000000o2.setClickable(false);
        DeviceState deviceState2 = this.selectedDeviceState;
        if (deviceState2 != null && (safeValueOf = Hardware.safeValueOf(deviceState2.hardware)) != null && !Hardware.canSetupStereo(safeValueOf, safeValueOf2)) {
            O000000o2.setAlpha(0.4f);
            O000000o2.setClickable(true);
        }
    }
}
