package com.xiaomi.smarthome.device;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.ftn;
import _m_j.htr;
import _m_j.hts;
import _m_j.htx;
import _m_j.hty;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class ConfigRouterStationActivity extends BaseActivity {
    public int connectionMode = -1;
    @BindView(6920)
    ImageView mIvReturn;
    @BindView(7157)
    View mLayoutWireView;
    @BindView(7158)
    View mLayoutWirelessView;
    public String mModel;
    @BindView(6612)
    Button mNextButton;
    @BindView(7517)
    View mTitleBar;
    @BindView(6677)
    ImageView mWireImageView;
    @BindView(7650)
    TextView mWireSubTitleTV;
    @BindView(7651)
    TextView mWireTitleTV;
    @BindView(6678)
    ImageView mWirelessImageView;
    @BindView(7652)
    TextView mWirelessSubTitleTV;
    @BindView(7653)
    TextView mWirelessTitleTV;

    public void writeLog(String str, Object... objArr) {
        hts.O000000o("ChooseMoXiangStationActivity", str, objArr);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.smart_config_moxiang_station_step);
        ButterKnife.bind(this);
        final boolean booleanValue = ((Boolean) htr.O000000o().O000000o("enter_scan_qrcode_normal", Boolean.TRUE)).booleanValue();
        if (booleanValue) {
            this.mIvReturn.setImageResource(R.drawable.return_icon_nor_3x);
        } else {
            this.mIvReturn.setImageResource(R.drawable.common_close_img);
        }
        this.mIvReturn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ConfigRouterStationActivity.AnonymousClass1 */

            public final void onClick(View view) {
                ConfigRouterStationActivity.this.writeLog("create step, click return btn, isEnterNormal %s", String.valueOf(booleanValue));
                ConfigRouterStationActivity.this.onBackPressed();
            }
        });
        this.mNextButton.setEnabled(false);
        this.mNextButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ConfigRouterStationActivity.AnonymousClass2 */

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
                ConfigRouterStationActivity.this.writeLog("create step,click next btn", new Object[0]);
                MMKV.O000000o().O000000o("moxiang_connection_mode", ConfigRouterStationActivity.this.connectionMode);
                Intent intent = ConfigRouterStationActivity.this.getIntent();
                ScanResult scanResult = (intent == null || !intent.hasExtra("scanResult")) ? null : (ScanResult) intent.getParcelableExtra("scanResult");
                if (scanResult == null) {
                    fbt fbt = new fbt(ConfigRouterStationActivity.this, "ResetDevicePage");
                    fbt.O000000o("model", ConfigRouterStationActivity.this.mModel);
                    fbt.O000000o("scanResult", (Parcelable) scanResult);
                    if (intent != null && intent.hasExtra("mac")) {
                        fbt.O000000o("mac", intent.getStringExtra("mac"));
                    }
                    if (intent != null && intent.hasExtra("key_qrcode_oob")) {
                        fbt.O000000o("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
                    }
                    fbs.O000000o(fbt);
                } else {
                    htx O000000o2 = hty.O000000o();
                    if (O000000o2 != null) {
                        fbt smartConfigRequest = O000000o2.getSmartConfigRequest(ConfigRouterStationActivity.this, scanResult, DeviceFactory.O00000Oo(scanResult), null, null);
                        if (smartConfigRequest != null) {
                            fbs.O000000o(smartConfigRequest);
                        }
                    } else {
                        return;
                    }
                }
                ConfigRouterStationActivity.this.finish();
            }
        });
        this.mLayoutWireView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ConfigRouterStationActivity.AnonymousClass3 */

            public final void onClick(View view) {
                ConfigRouterStationActivity.this.chooseWire();
            }
        });
        this.mLayoutWirelessView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ConfigRouterStationActivity.AnonymousClass4 */

            public final void onClick(View view) {
                ConfigRouterStationActivity.this.chooseWireLess();
            }
        });
        if (ftn.O00000oo(this)) {
            chooseWireLess();
        } else {
            chooseWire();
        }
        this.mModel = getIntent().getStringExtra("model");
    }

    public void chooseWire() {
        this.mLayoutWireView.setBackgroundResource(R.drawable.moxiang_button_choose_bg);
        this.mWireTitleTV.setTextColor(getResources().getColor(R.color.mx_choose_station_title_color));
        this.mWireSubTitleTV.setTextColor(getResources().getColor(R.color.mx_choose_station_title_color));
        this.mWireImageView.setVisibility(0);
        this.mLayoutWirelessView.setBackgroundResource(R.drawable.moxiang_button_not_choose_bg);
        this.mWirelessTitleTV.setTextColor(getResources().getColor(R.color.mx_not_choose_station_title_color));
        this.mWirelessSubTitleTV.setTextColor(getResources().getColor(R.color.mx_not_choose_station_Subtitle_color));
        this.mWirelessImageView.setVisibility(4);
        this.connectionMode = 1;
        this.mNextButton.setEnabled(true);
        writeLog("current moxiang connection stataion mode is " + this.connectionMode, new Object[0]);
    }

    public void chooseWireLess() {
        this.mLayoutWirelessView.setBackgroundResource(R.drawable.moxiang_button_choose_bg);
        this.mWirelessTitleTV.setTextColor(getResources().getColor(R.color.mx_choose_station_title_color));
        this.mWirelessSubTitleTV.setTextColor(getResources().getColor(R.color.mx_choose_station_title_color));
        this.mWirelessImageView.setVisibility(0);
        this.mLayoutWireView.setBackgroundResource(R.drawable.moxiang_button_not_choose_bg);
        this.mWireTitleTV.setTextColor(getResources().getColor(R.color.mx_not_choose_station_title_color));
        this.mWireSubTitleTV.setTextColor(getResources().getColor(R.color.mx_not_choose_station_Subtitle_color));
        this.mWireImageView.setVisibility(4);
        this.connectionMode = 2;
        this.mNextButton.setEnabled(true);
        writeLog("current moxiang connection stataion mode is " + this.connectionMode, new Object[0]);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("finish", false);
        setResult(-1, intent);
        finish();
    }
}
