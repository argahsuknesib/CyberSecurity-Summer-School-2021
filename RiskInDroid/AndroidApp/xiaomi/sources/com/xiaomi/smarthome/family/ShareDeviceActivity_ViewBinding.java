package com.xiaomi.smarthome.family;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ShareDeviceActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ShareDeviceActivity f7354O000000o;

    public ShareDeviceActivity_ViewBinding(ShareDeviceActivity shareDeviceActivity, View view) {
        this.f7354O000000o = shareDeviceActivity;
        shareDeviceActivity.manageTxt = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_right_img_btn, "field 'manageTxt'", ImageView.class);
        shareDeviceActivity.mTopDeleteBar = Utils.findRequiredView(view, R.id.top_delete_bar, "field 'mTopDeleteBar'");
        shareDeviceActivity.mIvCancel = (ImageView) Utils.findRequiredViewAsType(view, R.id.cancel_btn, "field 'mIvCancel'", ImageView.class);
        shareDeviceActivity.mIvSelectAll = (ImageView) Utils.findRequiredViewAsType(view, R.id.select_all_btn, "field 'mIvSelectAll'", ImageView.class);
        shareDeviceActivity.mBottomDeleteBar = Utils.findRequiredView(view, R.id.bottom_delete_bar, "field 'mBottomDeleteBar'");
        shareDeviceActivity.mSelectedCntTv = (TextView) Utils.findRequiredViewAsType(view, R.id.selected_cnt, "field 'mSelectedCntTv'", TextView.class);
        shareDeviceActivity.mDeleteConfirm = Utils.findRequiredView(view, R.id.delete_msg_btn, "field 'mDeleteConfirm'");
    }

    public void unbind() {
        ShareDeviceActivity shareDeviceActivity = this.f7354O000000o;
        if (shareDeviceActivity != null) {
            this.f7354O000000o = null;
            shareDeviceActivity.manageTxt = null;
            shareDeviceActivity.mTopDeleteBar = null;
            shareDeviceActivity.mIvCancel = null;
            shareDeviceActivity.mIvSelectAll = null;
            shareDeviceActivity.mBottomDeleteBar = null;
            shareDeviceActivity.mSelectedCntTv = null;
            shareDeviceActivity.mDeleteConfirm = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
