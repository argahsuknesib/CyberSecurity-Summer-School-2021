package com.xiaomi.smarthome.miio.page.msgcentersetting;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class DevicePushSettingActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DevicePushSettingActivity f9919O000000o;
    private View O00000Oo;

    public DevicePushSettingActivity_ViewBinding(final DevicePushSettingActivity devicePushSettingActivity, View view) {
        this.f9919O000000o = devicePushSettingActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'moduleA3ReturnBtn' and method 'onClick'");
        devicePushSettingActivity.moduleA3ReturnBtn = (ImageView) Utils.castView(findRequiredView, R.id.module_a_3_return_btn, "field 'moduleA3ReturnBtn'", ImageView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.DevicePushSettingActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                devicePushSettingActivity.onClick(view);
            }
        });
        devicePushSettingActivity.moduleA3ReturnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'moduleA3ReturnTitle'", TextView.class);
        devicePushSettingActivity.settingList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.setting_list, "field 'settingList'", RecyclerView.class);
        devicePushSettingActivity.mMenuIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_change_icon, "field 'mMenuIcon'", ImageView.class);
        devicePushSettingActivity.titleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'titleBar'");
        devicePushSettingActivity.mMaskView = Utils.findRequiredView(view, R.id.mask, "field 'mMaskView'");
        devicePushSettingActivity.mTitleGroup = Utils.findRequiredView(view, R.id.title_group, "field 'mTitleGroup'");
    }

    public void unbind() {
        DevicePushSettingActivity devicePushSettingActivity = this.f9919O000000o;
        if (devicePushSettingActivity != null) {
            this.f9919O000000o = null;
            devicePushSettingActivity.moduleA3ReturnBtn = null;
            devicePushSettingActivity.moduleA3ReturnTitle = null;
            devicePushSettingActivity.settingList = null;
            devicePushSettingActivity.mMenuIcon = null;
            devicePushSettingActivity.titleBar = null;
            devicePushSettingActivity.mMaskView = null;
            devicePushSettingActivity.mTitleGroup = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
