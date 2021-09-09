package com.smarthome.uwb.ui;

import _m_j.hzm;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.xiaomi.idm.uwb.IDMUwb;
import com.xiaomi.idm.uwb.IDMUwbDevice;
import com.xiaomi.idm.uwb.constant.UwbResultCode;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.List;

public class UwbTestActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f5691O000000o;
    TextView O00000Oo;
    public Handler mHandler = new Handler() {
        /* class com.smarthome.uwb.ui.UwbTestActivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            UwbTestActivity.this.updateUwbStatus();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_uwb_test_layout);
        this.f5691O000000o = (TextView) findViewById(R.id.action_btn);
        this.O00000Oo = (TextView) findViewById(R.id.state);
        UwbIdmManager.getInstance().addDelegateCallback(new IDMUwb.UwbCallback() {
            /* class com.smarthome.uwb.ui.UwbTestActivity.AnonymousClass2 */

            public final void onPayloadReceived(String str, IDMUwb.Payload payload) {
            }

            public final void onScanning(List<IDMUwbDevice> list) {
            }

            public final void onSendPayload(UwbResultCode uwbResultCode, int i) {
            }

            public final void onSetServerSecurityKey(UwbResultCode uwbResultCode) {
            }

            public final void onTagOTA(UwbResultCode uwbResultCode, int i) {
            }

            public final void onTagPluggedIn() {
            }

            public final void onTagUnplugged() {
            }

            public final void onMiConnectConnectionState(UwbResultCode uwbResultCode) {
                UwbTestActivity.this.mHandler.sendEmptyMessage(1);
            }

            public final void onScanState(UwbResultCode uwbResultCode) {
                UwbTestActivity.this.mHandler.sendEmptyMessage(1);
            }

            public final void onConnectionState(String str, UwbResultCode uwbResultCode) {
                UwbTestActivity.this.mHandler.sendEmptyMessage(1);
            }

            public final void onEstablishSecurityLine(UwbResultCode uwbResultCode) {
                UwbTestActivity.this.mHandler.sendEmptyMessage(1);
            }

            public final void onSwitchCommunicationType(UwbResultCode uwbResultCode) {
                UwbTestActivity.this.mHandler.sendEmptyMessage(1);
            }
        });
        updateUwbStatus();
    }

    public void updateUwbStatus() {
        this.f5691O000000o.setText(hzm.O00000o0.toString());
        String dumpCacheLog = UwbLogUtil.dumpCacheLog();
        String valueOf = String.valueOf(this.O00000Oo.getText());
        TextView textView = this.O00000Oo;
        textView.setText(valueOf + "\n" + dumpCacheLog);
    }
}
