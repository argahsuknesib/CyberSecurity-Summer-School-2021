package com.xiaomi.smarthome.smartconfig.initdevice;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class InitDeviceRoomActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private InitDeviceRoomActivity f11512O000000o;

    public InitDeviceRoomActivity_ViewBinding(InitDeviceRoomActivity initDeviceRoomActivity, View view) {
        this.f11512O000000o = initDeviceRoomActivity;
        initDeviceRoomActivity.mTvHomeName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_home_name, "field 'mTvHomeName'", TextView.class);
        initDeviceRoomActivity.mIconImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon_img, "field 'mIconImg'", ImageView.class);
        initDeviceRoomActivity.mCurrentHome = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_home, "field 'mCurrentHome'", RelativeLayout.class);
        initDeviceRoomActivity.mHomeTag = (CommonFlowGroup) Utils.findRequiredViewAsType(view, R.id.hoom_tag, "field 'mHomeTag'", CommonFlowGroup.class);
        initDeviceRoomActivity.mViewMark = Utils.findRequiredView(view, R.id.view_mark, "field 'mViewMark'");
        initDeviceRoomActivity.mLlHomes = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_homes, "field 'mLlHomes'", LinearLayout.class);
        initDeviceRoomActivity.mDeviceImg = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.device_img, "field 'mDeviceImg'", SimpleDraweeView.class);
        initDeviceRoomActivity.mSkipTv = Utils.findRequiredView(view, R.id.skip, "field 'mSkipTv'");
        initDeviceRoomActivity.mRoomFlowView = (CommonFlowGroup) Utils.findRequiredViewAsType(view, R.id.room_tag, "field 'mRoomFlowView'", CommonFlowGroup.class);
        initDeviceRoomActivity.mRecommendFlowView = (CommonFlowGroup) Utils.findRequiredViewAsType(view, R.id.recommend_room_tag, "field 'mRecommendFlowView'", CommonFlowGroup.class);
        initDeviceRoomActivity.mTvStep = (TextView) Utils.findRequiredViewAsType(view, R.id.step, "field 'mTvStep'", TextView.class);
        initDeviceRoomActivity.mSbCommon = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.sb_common_set, "field 'mSbCommon'", SwitchButton.class);
        initDeviceRoomActivity.mSbCommonCamera = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.sb_common_camera_set, "field 'mSbCommonCamera'", SwitchButton.class);
        initDeviceRoomActivity.mLLCommonCamera = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_common_camera_set, "field 'mLLCommonCamera'", LinearLayout.class);
    }

    public void unbind() {
        InitDeviceRoomActivity initDeviceRoomActivity = this.f11512O000000o;
        if (initDeviceRoomActivity != null) {
            this.f11512O000000o = null;
            initDeviceRoomActivity.mTvHomeName = null;
            initDeviceRoomActivity.mIconImg = null;
            initDeviceRoomActivity.mCurrentHome = null;
            initDeviceRoomActivity.mHomeTag = null;
            initDeviceRoomActivity.mViewMark = null;
            initDeviceRoomActivity.mLlHomes = null;
            initDeviceRoomActivity.mDeviceImg = null;
            initDeviceRoomActivity.mSkipTv = null;
            initDeviceRoomActivity.mRoomFlowView = null;
            initDeviceRoomActivity.mRecommendFlowView = null;
            initDeviceRoomActivity.mTvStep = null;
            initDeviceRoomActivity.mSbCommon = null;
            initDeviceRoomActivity.mSbCommonCamera = null;
            initDeviceRoomActivity.mLLCommonCamera = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
