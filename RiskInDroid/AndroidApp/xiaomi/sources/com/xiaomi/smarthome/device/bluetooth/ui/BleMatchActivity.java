package com.xiaomi.smarthome.device.bluetooth.ui;

import _m_j.dda;
import _m_j.fno;
import _m_j.fob;
import _m_j.fod;
import _m_j.fpi;
import _m_j.fpj;
import _m_j.fpk;
import _m_j.fpl;
import _m_j.fpm;
import _m_j.fpn;
import _m_j.gnk;
import _m_j.hvg;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.device.bluetooth.connect.ConnectBaseActivity;
import java.util.ArrayList;
import java.util.List;

public class BleMatchActivity extends ConnectBaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int f7154O000000o = 2132345213;
    public static BleDevice mMatchedDevice;
    private View O00000Oo;
    private VerticalViewPager O00000o;
    private TextView O00000o0;
    private fpm O00000oO;
    private List<fpi> O00000oo;
    private BleDevice O0000O0o;
    private ArrayList<String> O0000OOo;
    private fpi O0000Oo;
    private fpn O0000Oo0;
    private fpk O0000OoO;
    private String O0000Ooo;

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x017e, code lost:
        if (android.text.TextUtils.equals(r8.O0000O0o.model, "ninebot.scooter.v2") == false) goto L_0x0183;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01ac  */
    public void onCreate(Bundle bundle) {
        BleDeviceGroup O000000o2;
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.O0000Ooo = intent.getStringExtra("extra_from");
        if ("from_plus".equalsIgnoreCase(this.O0000Ooo)) {
            String stringExtra = intent.getStringExtra("model");
            if (!TextUtils.isEmpty(stringExtra) && (O000000o2 = fob.O000000o(stringExtra)) != null && O000000o2.mDeviceCount > 0) {
                this.O0000O0o = O000000o2;
            }
        } else if ("from_bind".equalsIgnoreCase(this.O0000Ooo)) {
            this.O0000O0o = (BleDevice) fno.O000000o().O000000o(intent.getStringExtra("extra_did"));
        }
        this.O0000OOo = intent.getStringArrayListExtra("key_combine_model");
        BleDevice bleDevice = this.O0000O0o;
        if (!(bleDevice != null && !TextUtils.isEmpty(bleDevice.model))) {
            finish();
        } else if (!checkDirectBind()) {
            setContentView(f7154O000000o);
            this.O00000Oo = findViewById(R.id.title_bar);
            this.O00000o0 = (TextView) findViewById(R.id.module_a_3_return_title);
            this.O00000o = (VerticalViewPager) findViewById(R.id.viewpager);
            this.O00000o0.setVisibility(8);
            BleDevice bleDevice2 = this.O0000O0o;
            boolean O000000o3 = (!(bleDevice2 instanceof BleDeviceGroup) || ((BleDeviceGroup) bleDevice2).mDeviceCount != 1) ? false : dda.O000000o(((BleDeviceGroup) this.O0000O0o).O0000OoO().get(0));
            this.O00000oo = new ArrayList();
            if (!O000000o3) {
                int O0000Oo2 = this.O0000O0o.O0000Oo();
                if (O0000Oo2 == 0) {
                    O00000Oo();
                    hvg.O000000o(this).O00000Oo("matchStyle", "none");
                    if (!TextUtils.equals(this.O0000O0o.model, "ninebot.scooter.v1")) {
                    }
                } else if (O0000Oo2 == 1) {
                    String O00000o2 = BleDevice.O00000o(this.O0000O0o.model);
                    hvg.O000000o(this).O00000Oo("matchStyle", "byKey");
                    if (TextUtils.isEmpty(O00000o2)) {
                        O00000Oo();
                        if (TextUtils.equals(this.O0000O0o.model, "ninebot.scooter.v1") || TextUtils.equals(this.O0000O0o.model, "ninebot.scooter.v2")) {
                            O000000o();
                        }
                    } else if (TextUtils.equals(this.O0000O0o.model, "ninebot.scooter.v1") || TextUtils.equals(this.O0000O0o.model, "ninebot.scooter.v2")) {
                        O000000o();
                    } else {
                        this.O0000Oo = fpj.O00000o();
                        this.O0000Oo.O000000o(this.O0000O0o, this.O0000OOo);
                        this.O00000oo.add(this.O0000Oo);
                    }
                } else if (O0000Oo2 == 2) {
                    this.O0000Oo0 = fpn.O00000o();
                    this.O0000Oo0.O000000o(this.O0000O0o, this.O0000OOo);
                    this.O00000oo.add(this.O0000Oo0);
                    hvg.O000000o(this).O00000Oo("matchStyle", "byRssi");
                }
                if (this.O00000oo.size() == 1 && this.O0000OoO == this.O00000oo.get(0)) {
                    this.O00000o0.setText(BleDevice.O00000Oo(this.O0000O0o.model));
                    if (this.O00000oo.get(0) instanceof fpk) {
                        this.O00000o0.setVisibility(0);
                    }
                }
                this.O00000oO = new fpm(getSupportFragmentManager(), this.O00000oo);
                this.O00000o.setAdapter(this.O00000oO);
                this.O00000o.setCurrentItem(0);
                hvg.O000000o(this).O00000Oo(2);
                findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchActivity.AnonymousClass1 */

                    public final void onClick(View view) {
                        BleMatchActivity.this.finish();
                    }
                });
                mMatchedDevice = null;
            }
            O000000o();
            this.O00000o0.setText(BleDevice.O00000Oo(this.O0000O0o.model));
            if (this.O00000oo.get(0) instanceof fpk) {
            }
            this.O00000oO = new fpm(getSupportFragmentManager(), this.O00000oo);
            this.O00000o.setAdapter(this.O00000oO);
            this.O00000o.setCurrentItem(0);
            hvg.O000000o(this).O00000Oo(2);
            findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    BleMatchActivity.this.finish();
                }
            });
            mMatchedDevice = null;
        }
    }

    public boolean checkDirectBind() {
        BleDevice bleDevice = this.O0000O0o;
        if (bleDevice != null && (bleDevice instanceof BleDeviceGroup)) {
            BleDeviceGroup bleDeviceGroup = (BleDeviceGroup) bleDevice;
            if (bleDeviceGroup.mDeviceCount != 1 || dda.O000000o(bleDeviceGroup.O0000OoO().get(0))) {
                return false;
            }
            String O00000o2 = BleDevice.O00000o(this.O0000O0o.model);
            int O0000Oo2 = this.O0000O0o.O0000Oo();
            if ((O0000Oo2 == 0 || O0000Oo2 == 1) && TextUtils.isEmpty(O00000o2)) {
                onDeviceMatched(bleDeviceGroup.O0000OoO().get(0));
                return true;
            }
        }
        return false;
    }

    private void O000000o() {
        this.O0000Oo = fpl.O00000o();
        this.O0000Oo.O000000o(this.O0000O0o, this.O0000OOo);
        this.O00000oo.add(this.O0000Oo);
    }

    private void O00000Oo() {
        this.O0000OoO = fpk.O00000o();
        this.O0000OoO.O000000o(this.O0000O0o, this.O0000OOo);
        this.O00000oo.add(this.O0000OoO);
    }

    public void onDeviceMatched(BleDevice bleDevice) {
        onDeviceMatched(bleDevice, false);
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
    public void onDeviceMatched(BleDevice bleDevice, boolean z) {
        Intent intent = new Intent();
        Intent intent2 = getIntent();
        if (intent2 != null) {
            intent.putExtra("connect_source", intent2.getIntExtra("connect_source", 0));
            intent.putExtra("connect_unique", intent2.getStringExtra("connect_unique"));
        }
        if (getIntent().hasExtra("key_qrcode_oob")) {
            intent.putExtra("key_qrcode_oob", getIntent().getStringExtra("key_qrcode_oob"));
        }
        if (z) {
            intent.putExtra("key_already_found", true);
        }
        fod.O000000o(this, bleDevice, intent, 10);
    }

    public void onDeviceNotFound(String str) {
        gnk.O00000oO("onDeviceNotFound");
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.setClass(this, BleErrorActivity.class);
        intent.putExtra("error.from", 1);
        intent.putExtra("model", str);
        startActivityForResult(intent, 11);
    }

    public boolean hasMatchListFragment() {
        if (!TextUtils.equals(this.O0000O0o.model, "ninebot.scooter.v1") && !TextUtils.equals(this.O0000O0o.model, "ninebot.scooter.v2")) {
            for (fpi fpi : this.O00000oo) {
                if (fpi instanceof fpk) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasMatchImageFragment() {
        for (fpi fpi : this.O00000oo) {
            if (fpi instanceof fpj) {
                return true;
            }
        }
        return false;
    }

    public void switchToMatchListFragment() {
        int indexOf;
        fpk fpk = this.O0000OoO;
        if (fpk != null && (indexOf = this.O00000oo.indexOf(fpk)) >= 0 && indexOf < this.O00000oo.size()) {
            this.O00000o.setCurrentItem(indexOf);
        }
    }

    public void switchToMatchImageFragment() {
        int indexOf;
        fpi fpi = this.O0000Oo;
        if (fpi != null && (indexOf = this.O00000oo.indexOf(fpi)) >= 0 && indexOf < this.O00000oo.size()) {
            this.O00000o.setCurrentItem(indexOf);
        }
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
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11) {
            if (i2 == -1) {
                int currentItem = this.O00000o.getCurrentItem();
                List<fpi> list = this.O00000oo;
                if (list != null && list.size() > currentItem) {
                    this.O00000oo.get(currentItem).O00000o0();
                    return;
                }
                return;
            }
            finish();
        } else if (i == 10) {
            boolean z = false;
            if (intent != null) {
                z = intent.getBooleanExtra("finish", true);
            }
            if (z) {
                Intent intent2 = new Intent();
                intent2.putExtra("finish", true);
                setResult(-1, intent2);
            }
            finish();
        }
    }
}
