package com.xiaomi.smarthome.miio.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class BleGatewayMeshDialog_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private BleGatewayMeshDialog f9719O000000o;

    public BleGatewayMeshDialog_ViewBinding(BleGatewayMeshDialog bleGatewayMeshDialog, View view) {
        this.f9719O000000o = bleGatewayMeshDialog;
        bleGatewayMeshDialog.mMiddleLine = Utils.findRequiredView(view, R.id.middle_line, "field 'mMiddleLine'");
        bleGatewayMeshDialog.mContent = (TextView) Utils.findRequiredViewAsType(view, R.id.dialog_content, "field 'mContent'", TextView.class);
        bleGatewayMeshDialog.mBtnCancel = (Button) Utils.findRequiredViewAsType(view, R.id.cancel, "field 'mBtnCancel'", Button.class);
        bleGatewayMeshDialog.mBtnAgree = (Button) Utils.findRequiredViewAsType(view, R.id.agree, "field 'mBtnAgree'", Button.class);
    }

    public void unbind() {
        BleGatewayMeshDialog bleGatewayMeshDialog = this.f9719O000000o;
        if (bleGatewayMeshDialog != null) {
            this.f9719O000000o = null;
            bleGatewayMeshDialog.mMiddleLine = null;
            bleGatewayMeshDialog.mContent = null;
            bleGatewayMeshDialog.mBtnCancel = null;
            bleGatewayMeshDialog.mBtnAgree = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
