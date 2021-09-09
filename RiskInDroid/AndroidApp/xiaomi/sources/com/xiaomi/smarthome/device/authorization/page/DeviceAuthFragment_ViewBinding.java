package com.xiaomi.smarthome.device.authorization.page;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class DeviceAuthFragment_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DeviceAuthFragment f7074O000000o;

    public DeviceAuthFragment_ViewBinding(DeviceAuthFragment deviceAuthFragment, View view) {
        this.f7074O000000o = deviceAuthFragment;
        deviceAuthFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.device_list, "field 'mRecyclerView'", RecyclerView.class);
        deviceAuthFragment.mSelectAllBtn = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.btn_select_all, "field 'mSelectAllBtn'", SwitchButton.class);
        deviceAuthFragment.emptyView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'emptyView'");
        deviceAuthFragment.menuLayout = Utils.findRequiredView(view, R.id.menu_layout, "field 'menuLayout'");
        deviceAuthFragment.mRlHomeSelect = Utils.findRequiredView(view, R.id.rl_home_select, "field 'mRlHomeSelect'");
        deviceAuthFragment.mTvHomeName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_home_name, "field 'mTvHomeName'", TextView.class);
        deviceAuthFragment.mIvSelectHomeArrow = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_select_home_arrow, "field 'mIvSelectHomeArrow'", ImageView.class);
        deviceAuthFragment.mAutoSelectTv = (TextView) Utils.findRequiredViewAsType(view, R.id.auth_select_tv, "field 'mAutoSelectTv'", TextView.class);
        deviceAuthFragment.mAppBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.appBarLayout, "field 'mAppBarLayout'", AppBarLayout.class);
        deviceAuthFragment.mLlChangeControlMode = Utils.findRequiredView(view, R.id.ll_change_control_mode, "field 'mLlChangeControlMode'");
        deviceAuthFragment.mTvAuthMode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_auth_mode, "field 'mTvAuthMode'", TextView.class);
        deviceAuthFragment.mIvChangeControlArrow = Utils.findRequiredView(view, R.id.iv_change_control_arrow, "field 'mIvChangeControlArrow'");
        deviceAuthFragment.mTvSelectDeviceName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_device_name, "field 'mTvSelectDeviceName'", TextView.class);
        deviceAuthFragment.mFilterDeviceLayout = Utils.findRequiredView(view, R.id.filter_device_layout, "field 'mFilterDeviceLayout'");
        deviceAuthFragment.mLlFilterDevice = Utils.findRequiredView(view, R.id.ll_filter_device, "field 'mLlFilterDevice'");
        deviceAuthFragment.mTvDeviceAuthFilterTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_device_auth_filter_title, "field 'mTvDeviceAuthFilterTitle'", TextView.class);
        deviceAuthFragment.mDividerLine = Utils.findRequiredView(view, R.id.divider_line, "field 'mDividerLine'");
        deviceAuthFragment.mTvEmptyResults = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_empty_results, "field 'mTvEmptyResults'", TextView.class);
    }

    public void unbind() {
        DeviceAuthFragment deviceAuthFragment = this.f7074O000000o;
        if (deviceAuthFragment != null) {
            this.f7074O000000o = null;
            deviceAuthFragment.mRecyclerView = null;
            deviceAuthFragment.mSelectAllBtn = null;
            deviceAuthFragment.emptyView = null;
            deviceAuthFragment.menuLayout = null;
            deviceAuthFragment.mRlHomeSelect = null;
            deviceAuthFragment.mTvHomeName = null;
            deviceAuthFragment.mIvSelectHomeArrow = null;
            deviceAuthFragment.mAutoSelectTv = null;
            deviceAuthFragment.mAppBarLayout = null;
            deviceAuthFragment.mLlChangeControlMode = null;
            deviceAuthFragment.mTvAuthMode = null;
            deviceAuthFragment.mIvChangeControlArrow = null;
            deviceAuthFragment.mTvSelectDeviceName = null;
            deviceAuthFragment.mFilterDeviceLayout = null;
            deviceAuthFragment.mLlFilterDevice = null;
            deviceAuthFragment.mTvDeviceAuthFilterTitle = null;
            deviceAuthFragment.mDividerLine = null;
            deviceAuthFragment.mTvEmptyResults = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
