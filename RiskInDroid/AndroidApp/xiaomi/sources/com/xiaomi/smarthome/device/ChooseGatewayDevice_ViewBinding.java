package com.xiaomi.smarthome.device;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ChooseGatewayDevice_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ChooseGatewayDevice f6929O000000o;

    public ChooseGatewayDevice_ViewBinding(ChooseGatewayDevice chooseGatewayDevice, View view) {
        this.f6929O000000o = chooseGatewayDevice;
        chooseGatewayDevice.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        chooseGatewayDevice.mBackBt = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mBackBt'");
        chooseGatewayDevice.mListView = (ListView) Utils.findRequiredViewAsType(view, R.id.list, "field 'mListView'", ListView.class);
        chooseGatewayDevice.mListTitle = Utils.findRequiredView(view, R.id.list_title, "field 'mListTitle'");
        chooseGatewayDevice.mSvEmptyView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.sv_empty, "field 'mSvEmptyView'", ScrollView.class);
        chooseGatewayDevice.mLlGatewayContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_gateway_container, "field 'mLlGatewayContainer'", LinearLayout.class);
    }

    public void unbind() {
        ChooseGatewayDevice chooseGatewayDevice = this.f6929O000000o;
        if (chooseGatewayDevice != null) {
            this.f6929O000000o = null;
            chooseGatewayDevice.mTitle = null;
            chooseGatewayDevice.mBackBt = null;
            chooseGatewayDevice.mListView = null;
            chooseGatewayDevice.mListTitle = null;
            chooseGatewayDevice.mSvEmptyView = null;
            chooseGatewayDevice.mLlGatewayContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
