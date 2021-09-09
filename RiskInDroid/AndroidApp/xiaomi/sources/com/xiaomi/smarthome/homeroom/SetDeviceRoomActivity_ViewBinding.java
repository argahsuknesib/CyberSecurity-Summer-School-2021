package com.xiaomi.smarthome.homeroom;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;
import com.xiaomi.smarthome.ui.DeviceBigHeaderView;

public class SetDeviceRoomActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SetDeviceRoomActivity f8951O000000o;

    public SetDeviceRoomActivity_ViewBinding(SetDeviceRoomActivity setDeviceRoomActivity, View view) {
        this.f8951O000000o = setDeviceRoomActivity;
        setDeviceRoomActivity.mReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'");
        setDeviceRoomActivity.mChooseRoom = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_choose_room, "field 'mChooseRoom'", TextView.class);
        setDeviceRoomActivity.mDivider = (TextView) Utils.findRequiredViewAsType(view, R.id.divider_item, "field 'mDivider'", TextView.class);
        setDeviceRoomActivity.mRoomFlowView = (CommonFlowGroup) Utils.findRequiredViewAsType(view, R.id.room_tag, "field 'mRoomFlowView'", CommonFlowGroup.class);
        setDeviceRoomActivity.mRecommendFlowView = (CommonFlowGroup) Utils.findRequiredViewAsType(view, R.id.recommend_room_tag, "field 'mRecommendFlowView'", CommonFlowGroup.class);
        setDeviceRoomActivity.mComplete = (Button) Utils.findRequiredViewAsType(view, R.id.complete, "field 'mComplete'", Button.class);
        setDeviceRoomActivity.mDeviceListContainer = (DeviceBigHeaderView) Utils.findRequiredViewAsType(view, R.id.device_big_header_view, "field 'mDeviceListContainer'", DeviceBigHeaderView.class);
    }

    public void unbind() {
        SetDeviceRoomActivity setDeviceRoomActivity = this.f8951O000000o;
        if (setDeviceRoomActivity != null) {
            this.f8951O000000o = null;
            setDeviceRoomActivity.mReturnBtn = null;
            setDeviceRoomActivity.mChooseRoom = null;
            setDeviceRoomActivity.mDivider = null;
            setDeviceRoomActivity.mRoomFlowView = null;
            setDeviceRoomActivity.mRecommendFlowView = null;
            setDeviceRoomActivity.mComplete = null;
            setDeviceRoomActivity.mDeviceListContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
