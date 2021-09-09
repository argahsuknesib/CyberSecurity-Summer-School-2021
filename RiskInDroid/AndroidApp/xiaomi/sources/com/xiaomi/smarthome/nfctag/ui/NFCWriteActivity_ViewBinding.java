package com.xiaomi.smarthome.nfctag.ui;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.nfctag.widget.NFCProgress;

public class NFCWriteActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private NFCWriteActivity f10473O000000o;

    public NFCWriteActivity_ViewBinding(NFCWriteActivity nFCWriteActivity, View view) {
        this.f10473O000000o = nFCWriteActivity;
        nFCWriteActivity.txtHint = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_hint, "field 'txtHint'", TextView.class);
        nFCWriteActivity.txtSubHint = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_sub_hint, "field 'txtSubHint'", TextView.class);
        nFCWriteActivity.txtRetry = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_retry, "field 'txtRetry'", TextView.class);
        nFCWriteActivity.vNoTag = Utils.findRequiredView(view, R.id.scan_step_no_tag, "field 'vNoTag'");
        nFCWriteActivity.vScanBg = Utils.findRequiredView(view, R.id.scan_step_bg, "field 'vScanBg'");
        nFCWriteActivity.vScanPhone = Utils.findRequiredView(view, R.id.scan_step_phone, "field 'vScanPhone'");
        nFCWriteActivity.mScanView = Utils.findRequiredView(view, R.id.scan_view, "field 'mScanView'");
        nFCWriteActivity.mWritingView = Utils.findRequiredView(view, R.id.writing_view, "field 'mWritingView'");
        nFCWriteActivity.mWriteSuccessView = Utils.findRequiredView(view, R.id.write_success_view, "field 'mWriteSuccessView'");
        nFCWriteActivity.mWriteSuccessFinish = Utils.findRequiredView(view, R.id.finish, "field 'mWriteSuccessFinish'");
        nFCWriteActivity.mWriteFailView = Utils.findRequiredView(view, R.id.write_fail_view, "field 'mWriteFailView'");
        nFCWriteActivity.mWritingLine1 = (NFCProgress) Utils.findRequiredViewAsType(view, R.id.first_line, "field 'mWritingLine1'", NFCProgress.class);
        nFCWriteActivity.mWritingLine2 = (NFCProgress) Utils.findRequiredViewAsType(view, R.id.second_line, "field 'mWritingLine2'", NFCProgress.class);
    }

    public void unbind() {
        NFCWriteActivity nFCWriteActivity = this.f10473O000000o;
        if (nFCWriteActivity != null) {
            this.f10473O000000o = null;
            nFCWriteActivity.txtHint = null;
            nFCWriteActivity.txtSubHint = null;
            nFCWriteActivity.txtRetry = null;
            nFCWriteActivity.vNoTag = null;
            nFCWriteActivity.vScanBg = null;
            nFCWriteActivity.vScanPhone = null;
            nFCWriteActivity.mScanView = null;
            nFCWriteActivity.mWritingView = null;
            nFCWriteActivity.mWriteSuccessView = null;
            nFCWriteActivity.mWriteSuccessFinish = null;
            nFCWriteActivity.mWriteFailView = null;
            nFCWriteActivity.mWritingLine1 = null;
            nFCWriteActivity.mWritingLine2 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
