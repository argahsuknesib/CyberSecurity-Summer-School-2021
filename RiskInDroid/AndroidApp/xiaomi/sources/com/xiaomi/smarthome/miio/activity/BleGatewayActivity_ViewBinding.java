package com.xiaomi.smarthome.miio.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleGatewayNestedScrollingParent;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class BleGatewayActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private BleGatewayActivity f9612O000000o;

    public BleGatewayActivity_ViewBinding(BleGatewayActivity bleGatewayActivity, View view) {
        this.f9612O000000o = bleGatewayActivity;
        bleGatewayActivity.mBackBt = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mBackBt'", ImageView.class);
        bleGatewayActivity.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        bleGatewayActivity.mHeadDescView = (TextView) Utils.findRequiredViewAsType(view, R.id.desc, "field 'mHeadDescView'", TextView.class);
        bleGatewayActivity.mHeadImageExtend = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.head_image_extend, "field 'mHeadImageExtend'", SimpleDraweeView.class);
        bleGatewayActivity.mHeadImageShrink = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.head_image_shrink, "field 'mHeadImageShrink'", SimpleDraweeView.class);
        bleGatewayActivity.mHeadAnimImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.head_anim_image, "field 'mHeadAnimImage'", ImageView.class);
        bleGatewayActivity.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.list, "field 'mRecyclerView'", RecyclerView.class);
        bleGatewayActivity.mNestedScrollView = (BleGatewayNestedScrollingParent) Utils.findRequiredViewAsType(view, R.id.root, "field 'mNestedScrollView'", BleGatewayNestedScrollingParent.class);
        bleGatewayActivity.mEmptyViewContainer = Utils.findRequiredView(view, R.id.empty_view_container, "field 'mEmptyViewContainer'");
        bleGatewayActivity.mEmptyView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'mEmptyView'");
        bleGatewayActivity.mFirstEmptyText = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'mFirstEmptyText'", TextView.class);
        bleGatewayActivity.mSecondEmptyText = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text_2, "field 'mSecondEmptyText'", TextView.class);
        bleGatewayActivity.mMeshGatewayGuideView = (TextView) Utils.findRequiredViewAsType(view, R.id.mesh_gateway_guide, "field 'mMeshGatewayGuideView'", TextView.class);
        bleGatewayActivity.mViewBleSwitch = Utils.findRequiredView(view, R.id.view_ble_switch, "field 'mViewBleSwitch'");
        bleGatewayActivity.mBleSwitchBtn = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.btn_ble_switch, "field 'mBleSwitchBtn'", SwitchButton.class);
        bleGatewayActivity.mBleSwitch = (CardView) Utils.findRequiredViewAsType(view, R.id.ble_switch, "field 'mBleSwitch'", CardView.class);
        bleGatewayActivity.mBleSwitchTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ble, "field 'mBleSwitchTitle'", TextView.class);
        bleGatewayActivity.mBleButtonContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ble_content, "field 'mBleButtonContent'", TextView.class);
        bleGatewayActivity.mListCardView = (CardView) Utils.findRequiredViewAsType(view, R.id.list_card_view, "field 'mListCardView'", CardView.class);
        bleGatewayActivity.mRefreshProgress = (ImageView) Utils.findRequiredViewAsType(view, R.id.progress_image, "field 'mRefreshProgress'", ImageView.class);
    }

    public void unbind() {
        BleGatewayActivity bleGatewayActivity = this.f9612O000000o;
        if (bleGatewayActivity != null) {
            this.f9612O000000o = null;
            bleGatewayActivity.mBackBt = null;
            bleGatewayActivity.mTitle = null;
            bleGatewayActivity.mHeadDescView = null;
            bleGatewayActivity.mHeadImageExtend = null;
            bleGatewayActivity.mHeadImageShrink = null;
            bleGatewayActivity.mHeadAnimImage = null;
            bleGatewayActivity.mRecyclerView = null;
            bleGatewayActivity.mNestedScrollView = null;
            bleGatewayActivity.mEmptyViewContainer = null;
            bleGatewayActivity.mEmptyView = null;
            bleGatewayActivity.mFirstEmptyText = null;
            bleGatewayActivity.mSecondEmptyText = null;
            bleGatewayActivity.mMeshGatewayGuideView = null;
            bleGatewayActivity.mViewBleSwitch = null;
            bleGatewayActivity.mBleSwitchBtn = null;
            bleGatewayActivity.mBleSwitch = null;
            bleGatewayActivity.mBleSwitchTitle = null;
            bleGatewayActivity.mBleButtonContent = null;
            bleGatewayActivity.mListCardView = null;
            bleGatewayActivity.mRefreshProgress = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
