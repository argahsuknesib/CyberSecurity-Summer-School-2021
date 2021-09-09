package com.xiaomi.smarthome.miio.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;

public class BleGatewayListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private BleGatewayListActivity f9639O000000o;

    public BleGatewayListActivity_ViewBinding(BleGatewayListActivity bleGatewayListActivity, View view) {
        this.f9639O000000o = bleGatewayListActivity;
        bleGatewayListActivity.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        bleGatewayListActivity.mReturnButton = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnButton'", ImageView.class);
        bleGatewayListActivity.mTitleText = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleText'", TextView.class);
        bleGatewayListActivity.mEmptyView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'mEmptyView'");
        bleGatewayListActivity.mFirstEmptyText = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'mFirstEmptyText'", TextView.class);
        bleGatewayListActivity.mSecondEmptyText = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text_2, "field 'mSecondEmptyText'", TextView.class);
        bleGatewayListActivity.mListView = (PullDownDragListView) Utils.findRequiredViewAsType(view, R.id.bluetooth_gateway_list, "field 'mListView'", PullDownDragListView.class);
        bleGatewayListActivity.mAboutBleGateway = (TextView) Utils.findRequiredViewAsType(view, R.id.about_ble_gateway, "field 'mAboutBleGateway'", TextView.class);
    }

    public void unbind() {
        BleGatewayListActivity bleGatewayListActivity = this.f9639O000000o;
        if (bleGatewayListActivity != null) {
            this.f9639O000000o = null;
            bleGatewayListActivity.mTitleBar = null;
            bleGatewayListActivity.mReturnButton = null;
            bleGatewayListActivity.mTitleText = null;
            bleGatewayListActivity.mEmptyView = null;
            bleGatewayListActivity.mFirstEmptyText = null;
            bleGatewayListActivity.mSecondEmptyText = null;
            bleGatewayListActivity.mListView = null;
            bleGatewayListActivity.mAboutBleGateway = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
