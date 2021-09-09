package com.xiaomi.smarthome.framework.page;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fqu;
import _m_j.fqx;
import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.ftt;
import _m_j.fug;
import _m_j.ful;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.Date;
import java.util.TimeZone;

public class DeviceMoreInnterActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    View f7706O000000o;
    TextView O00000Oo;
    protected Device O00000o0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("did");
        this.O00000o0 = fno.O000000o().O000000o(stringExtra);
        if (this.O00000o0 == null) {
            this.O00000o0 = fno.O000000o().O00000Oo(stringExtra);
            if (this.O00000o0 == null) {
                finish();
                return;
            }
        }
        overridePendingTransition(R.anim.activity_slide_in_right, R.anim.activity_slide_out_left);
        gwg.O00000Oo(getWindow());
        setContentView((int) R.layout.device_more_inner_activity);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity.AnonymousClass1 */

            public final void onClick(View view) {
                DeviceMoreInnterActivity.this.onBackPressed();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.miui_earphone_more_setting);
        View findViewById = findViewById(R.id.security_setting);
        if (!visableSecurity(intent) || !this.O00000o0.isOwner() || this.O00000o0.isSubDevice()) {
            findViewById.setVisibility(8);
        } else {
            if (fqx.O000000o(this.O00000o0.model, this.O00000o0.version)) {
                ((TextView) findViewById(R.id.security_setting_title)).setText((int) R.string.ble_secure_pin_device_more_title);
            }
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.$$Lambda$DeviceMoreInnterActivity$v5MFkk11iIS1IAtVHJKhNljjtY4 */

                public final void onClick(View view) {
                    DeviceMoreInnterActivity.this.O000000o(view);
                }
            });
        }
        View findViewById2 = findViewById(R.id.network_info);
        if (!visableNetwork(this.O00000o0)) {
            findViewById2.setVisibility(8);
        }
        findViewById2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity.AnonymousClass2 */

            public final void onClick(View view) {
                Intent intent = new Intent(DeviceMoreInnterActivity.this, DeviceNetworkInfoActivity.class);
                intent.putExtra("did", DeviceMoreInnterActivity.this.O00000o0.did);
                DeviceMoreInnterActivity.this.startActivity(intent);
            }
        });
        this.f7706O000000o = findViewById(R.id.timezone);
        this.O00000Oo = (TextView) findViewById(R.id.text_timezone);
        if (!visableTimezone(intent)) {
            this.f7706O000000o.setVisibility(8);
        } else {
            this.f7706O000000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    Intent intent = new Intent(DeviceMoreInnterActivity.this, TimezoneActivity.class);
                    intent.putExtra("extra_device_did", DeviceMoreInnterActivity.this.O00000o0.did);
                    DeviceMoreInnterActivity.this.startActivityForResult(intent, 3);
                }
            });
            fru.O000000o().O00000o0(this.O00000o0.did, new fsm<ful, fso>() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    ful ful = (ful) obj;
                    if (ful != null) {
                        DeviceMoreInnterActivity.this.O00000Oo.setText(ful.O00000Oo + " " + ful.O00000o0);
                    }
                }

                public final void onFailure(fso fso) {
                    gsy.O000000o(4, "zc", "onFailure");
                }
            });
        }
        View findViewById3 = findViewById(R.id.feedback);
        if (!visableFeedback(this.O00000o0)) {
            findViewById3.setVisibility(8);
        }
        findViewById3.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity.AnonymousClass5 */

            public final void onClick(View view) {
                fbt fbt = new fbt(DeviceMoreInnterActivity.this, "/userCenter/FeedbackActivity");
                fbt.O000000o("extra_device_did", DeviceMoreInnterActivity.this.O00000o0.did);
                fbt.O000000o("extra_source", 0);
                fbs.O000000o(fbt);
            }
        });
        findViewById3.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity.AnonymousClass6 */

            public final boolean onLongClick(View view) {
                if (DeviceMoreInnterActivity.this.O00000o0.did == null || ftn.O0000O0o(DeviceMoreInnterActivity.this)) {
                    return true;
                }
                new MLAlertDialog.Builder(DeviceMoreInnterActivity.this).O000000o(DeviceMoreInnterActivity.this.O00000o0.did).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity.AnonymousClass6.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).O00000oo();
                return true;
            }
        });
        View findViewById4 = findViewById(R.id.short_cut);
        findViewById4.setVisibility(8);
        if (visableShortcut(intent)) {
            findViewById4.setVisibility(0);
            findViewById4.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity.AnonymousClass7 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.fqu.O000000o(android.app.Activity, boolean, com.xiaomi.smarthome.device.Device, android.content.Intent, java.lang.String, _m_j.ftt<java.lang.Void>):void
                 arg types: [com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity, int, com.xiaomi.smarthome.device.Device, ?[OBJECT, ARRAY], java.lang.String, com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity$7$1]
                 candidates:
                  _m_j.fqu.O000000o(android.app.Activity, com.xiaomi.smarthome.device.Device, android.content.Intent, android.graphics.Bitmap, java.lang.String, boolean):void
                  _m_j.fqu.O000000o(com.xiaomi.smarthome.device.Device, android.content.Intent, android.graphics.Bitmap, java.lang.String, boolean, java.util.List):void
                  _m_j.fqu.O000000o(android.app.Activity, boolean, com.xiaomi.smarthome.device.Device, android.content.Intent, java.lang.String, _m_j.ftt<java.lang.Void>):void */
                public final void onClick(View view) {
                    DeviceMoreInnterActivity deviceMoreInnterActivity = DeviceMoreInnterActivity.this;
                    final XQProgressDialog O000000o2 = XQProgressDialog.O000000o(deviceMoreInnterActivity, null, deviceMoreInnterActivity.getString(R.string.creating));
                    DeviceMoreInnterActivity deviceMoreInnterActivity2 = DeviceMoreInnterActivity.this;
                    fqu.O000000o((Activity) deviceMoreInnterActivity2, false, deviceMoreInnterActivity2.O00000o0, (Intent) null, "device_more", (ftt<Void>) new ftt<Void>() {
                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreInnterActivity.AnonymousClass7.AnonymousClass1 */

                        public final void O000000o(int i) {
                            if (i == -1) {
                                if (Build.VERSION.SDK_INT < 23 || !DeviceMoreInnterActivity.this.shouldShowRequestPermissionRationale("com.android.launcher.permission.INSTALL_SHORTCUT")) {
                                    gqg.O00000Oo((int) R.string.permission_tips_denied_msg);
                                } else {
                                    DeviceMoreInnterActivity.this.requestPermissions(new String[]{"com.android.launcher.permission.INSTALL_SHORTCUT"}, 1);
                                }
                            }
                            O000000o2.dismiss();
                        }

                        public final void O000000o(int i, Object obj) {
                            O000000o2.dismiss();
                        }

                        public final /* synthetic */ void O000000o(Object obj) {
                            O000000o2.dismiss();
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        try {
            fbt fbt = new fbt(this, "RNSecuritySettingActivity");
            fbt.O000000o("extra_device_did", this.O00000o0.did);
            fbt.O000000o("xiaomi.smarthome.custom_hint", "");
            fbs.O000000o(fbt);
        } catch (Throwable unused) {
        }
    }

    public static boolean visableShortcut(Intent intent) {
        return intent.getBooleanExtra("shortcut_enable", true);
    }

    public static boolean visableSecurity(Intent intent) {
        return intent.getBooleanExtra("security_setting_enable", false);
    }

    public static boolean visableTimezone(Intent intent) {
        return intent.getBooleanExtra("timezone_enable", true);
    }

    public static boolean visableNetwork(Device device) {
        return !device.isSubDevice() && !device.isVirtualDevice() && (device instanceof MiioDeviceV2) && !TextUtils.isEmpty(device.bssid) && !TextUtils.isEmpty(device.ssid);
    }

    public static boolean visableFeedback(Device device) {
        return !device.model.startsWith("yeelink.light");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3 && i2 == 4 && intent != null) {
            TimeZone timeZone = (TimeZone) intent.getSerializableExtra("TimeZone");
            String O000000o2 = fug.O000000o(timeZone.getID(), this);
            TimeZone timeZone2 = TimeZone.getDefault();
            TimeZone.setDefault(timeZone);
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            TextView textView = this.O00000Oo;
            textView.setText(O000000o2 + " " + displayName);
            TimeZone.setDefault(timeZone2);
        }
        if (intent != null && intent.getBooleanExtra("finish", false)) {
            setResult(-1, intent);
            finish();
        }
    }
}
