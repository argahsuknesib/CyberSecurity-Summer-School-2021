package com.xiaomi.smarthome.multikey;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;

public class PowerItemkeyActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private PowerItemkeyActivity f10054O000000o;

    public PowerItemkeyActivity_ViewBinding(PowerItemkeyActivity powerItemkeyActivity, View view) {
        this.f10054O000000o = powerItemkeyActivity;
        powerItemkeyActivity.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        powerItemkeyActivity.mReturnBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'", ImageView.class);
        powerItemkeyActivity.mTitleTv = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTv'", TextView.class);
        powerItemkeyActivity.tv_keyname = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_keyname, "field 'tv_keyname'", TextView.class);
        powerItemkeyActivity.tvRoomadd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_roomadd, "field 'tvRoomadd'", TextView.class);
        powerItemkeyActivity.tv_roomname = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_roomname, "field 'tv_roomname'", TextView.class);
        powerItemkeyActivity.inputRemarkView = (TextView) Utils.findRequiredViewAsType(view, R.id.client_remark_input_view_text, "field 'inputRemarkView'", TextView.class);
        powerItemkeyActivity.etKeyname = (EditText) Utils.findRequiredViewAsType(view, R.id.et_keyname, "field 'etKeyname'", EditText.class);
        powerItemkeyActivity.mDeviceFlowView = (CommonFlowGroup) Utils.findRequiredViewAsType(view, R.id.recommend_device_tag, "field 'mDeviceFlowView'", CommonFlowGroup.class);
        powerItemkeyActivity.mRoomFlowView = (CommonFlowGroup) Utils.findRequiredViewAsType(view, R.id.recommend_room_tag, "field 'mRoomFlowView'", CommonFlowGroup.class);
        powerItemkeyActivity.mRightImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_right_iv_setting_btn, "field 'mRightImage'", ImageView.class);
        powerItemkeyActivity.mViewClear = Utils.findRequiredView(view, R.id.client_remark_input_view_clear, "field 'mViewClear'");
        powerItemkeyActivity.mRecommendNoimg = Utils.findRequiredView(view, R.id.recommend_room_noimg, "field 'mRecommendNoimg'");
    }

    public void unbind() {
        PowerItemkeyActivity powerItemkeyActivity = this.f10054O000000o;
        if (powerItemkeyActivity != null) {
            this.f10054O000000o = null;
            powerItemkeyActivity.mTitleBar = null;
            powerItemkeyActivity.mReturnBtn = null;
            powerItemkeyActivity.mTitleTv = null;
            powerItemkeyActivity.tv_keyname = null;
            powerItemkeyActivity.tvRoomadd = null;
            powerItemkeyActivity.tv_roomname = null;
            powerItemkeyActivity.inputRemarkView = null;
            powerItemkeyActivity.etKeyname = null;
            powerItemkeyActivity.mDeviceFlowView = null;
            powerItemkeyActivity.mRoomFlowView = null;
            powerItemkeyActivity.mRightImage = null;
            powerItemkeyActivity.mViewClear = null;
            powerItemkeyActivity.mRecommendNoimg = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
