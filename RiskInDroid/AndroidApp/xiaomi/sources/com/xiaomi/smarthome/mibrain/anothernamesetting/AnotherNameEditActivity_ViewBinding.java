package com.xiaomi.smarthome.mibrain.anothernamesetting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class AnotherNameEditActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private AnotherNameEditActivity f9477O000000o;

    public AnotherNameEditActivity_ViewBinding(AnotherNameEditActivity anotherNameEditActivity, View view) {
        this.f9477O000000o = anotherNameEditActivity;
        anotherNameEditActivity.mReturn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturn'", ImageView.class);
        anotherNameEditActivity.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        anotherNameEditActivity.mTitleRightIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_right_iv_setting_btn, "field 'mTitleRightIcon'", ImageView.class);
        anotherNameEditActivity.mGuide = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.guide, "field 'mGuide'", LinearLayout.class);
        anotherNameEditActivity.mGuideCancel = (ImageView) Utils.findRequiredViewAsType(view, R.id.guide_cancel, "field 'mGuideCancel'", ImageView.class);
        anotherNameEditActivity.mDeviceIcon = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.device_icon, "field 'mDeviceIcon'", SimpleDraweeView.class);
        anotherNameEditActivity.mDeviceName = (TextView) Utils.findRequiredViewAsType(view, R.id.device_name, "field 'mDeviceName'", TextView.class);
        anotherNameEditActivity.mListView = (ListView) Utils.findRequiredViewAsType(view, R.id.listview, "field 'mListView'", ListView.class);
        anotherNameEditActivity.mMultiGroup = Utils.findRequiredView(view, R.id.lv_multi_button, "field 'mMultiGroup'");
        anotherNameEditActivity.mTvMultiBtnKey = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_multi_btn_key, "field 'mTvMultiBtnKey'", TextView.class);
        anotherNameEditActivity.mMultiBtnName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_multi_btn_name, "field 'mMultiBtnName'", TextView.class);
        anotherNameEditActivity.mDeleteGroup = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.delete_group, "field 'mDeleteGroup'", ViewGroup.class);
        anotherNameEditActivity.mDelete = (TextView) Utils.findRequiredViewAsType(view, R.id.delete, "field 'mDelete'", TextView.class);
    }

    public void unbind() {
        AnotherNameEditActivity anotherNameEditActivity = this.f9477O000000o;
        if (anotherNameEditActivity != null) {
            this.f9477O000000o = null;
            anotherNameEditActivity.mReturn = null;
            anotherNameEditActivity.mTitle = null;
            anotherNameEditActivity.mTitleRightIcon = null;
            anotherNameEditActivity.mGuide = null;
            anotherNameEditActivity.mGuideCancel = null;
            anotherNameEditActivity.mDeviceIcon = null;
            anotherNameEditActivity.mDeviceName = null;
            anotherNameEditActivity.mListView = null;
            anotherNameEditActivity.mMultiGroup = null;
            anotherNameEditActivity.mTvMultiBtnKey = null;
            anotherNameEditActivity.mMultiBtnName = null;
            anotherNameEditActivity.mDeleteGroup = null;
            anotherNameEditActivity.mDelete = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
