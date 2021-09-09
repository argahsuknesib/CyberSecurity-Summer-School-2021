package com.xiaomi.smarthome.smartconfig;

import _m_j.fbs;
import _m_j.fbt;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class XiaobaiChooseConnection extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    ScanResult f11473O000000o;
    @BindView(7370)
    SimpleDraweeView mDeviceIcon;
    @BindView(7372)
    TextView mDeviceInfo;
    @BindView(7371)
    TextView mDeviceInfoSubTitle;
    @BindView(6987)
    Button mNextBtn1;
    @BindView(6988)
    Button mNextBtn2;
    @BindView(6920)
    View mReturnBtn;
    @BindView(6925)
    TextView mTitle;
    @BindView(7517)
    View mTitleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.xiaobai_choose_connection);
        ButterKnife.bind(this);
        this.f11473O000000o = (ScanResult) getIntent().getParcelableExtra("scanResult");
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.XiaobaiChooseConnection.AnonymousClass1 */

            public final void onClick(View view) {
                XiaobaiChooseConnection.this.finish();
            }
        });
        this.mDeviceInfo.setText(DeviceFactory.O0000OoO("chuangmi.camera.xiaobai"));
        DeviceFactory.O00000Oo("chuangmi.camera.xiaobai", this.mDeviceIcon);
        this.mDeviceInfoSubTitle.setText((int) R.string.kuailian_sub_main_title_1);
        this.mNextBtn1.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.XiaobaiChooseConnection.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
             arg types: [java.lang.String, android.net.wifi.ScanResult]
             candidates:
              _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
              _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
            public final void onClick(View view) {
                fbt fbt = new fbt(XiaobaiChooseConnection.this.getContext(), "SmartConfigMainActivity");
                if (XiaobaiChooseConnection.this.getIntent() != null) {
                    fbt.O000000o("connect_source", XiaobaiChooseConnection.this.getIntent().getIntExtra("connect_source", 0));
                    fbt.O000000o("connect_unique", XiaobaiChooseConnection.this.getIntent().getStringExtra("connect_unique"));
                }
                fbt.O000000o("strategy_id", 3);
                fbt.O000000o("scanResult", (Parcelable) XiaobaiChooseConnection.this.f11473O000000o);
                fbt.O000000o("model", DeviceFactory.O00000Oo(XiaobaiChooseConnection.this.f11473O000000o));
                fbs.O000000o(fbt);
                XiaobaiChooseConnection.this.finish();
            }
        });
        this.mNextBtn2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.XiaobaiChooseConnection.AnonymousClass3 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
             arg types: [java.lang.String, android.net.wifi.ScanResult]
             candidates:
              _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
              _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
            public final void onClick(View view) {
                fbt fbt = new fbt(XiaobaiChooseConnection.this.getContext(), "SmartConfigMainActivity");
                if (XiaobaiChooseConnection.this.getIntent() != null) {
                    fbt.O000000o("connect_source", XiaobaiChooseConnection.this.getIntent().getIntExtra("connect_source", 0));
                    fbt.O000000o("connect_unique", XiaobaiChooseConnection.this.getIntent().getStringExtra("connect_unique"));
                }
                fbt.O000000o("strategy_id", 2);
                fbt.O000000o("scanResult", (Parcelable) XiaobaiChooseConnection.this.f11473O000000o);
                fbt.O000000o("model", DeviceFactory.O00000Oo(XiaobaiChooseConnection.this.f11473O000000o));
                fbs.O000000o(fbt);
                XiaobaiChooseConnection.this.finish();
            }
        });
    }
}
