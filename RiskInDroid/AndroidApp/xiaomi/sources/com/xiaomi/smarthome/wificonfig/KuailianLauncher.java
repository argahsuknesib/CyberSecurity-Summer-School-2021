package com.xiaomi.smarthome.wificonfig;

import _m_j.ezq;
import _m_j.ezt;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.gpc;
import _m_j.gty;
import _m_j.ibh;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.youpin.login.entity.Error;

public class KuailianLauncher extends CommonActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f11986O000000o = 1;
    private int O00000Oo = 50;

    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.scene_launcher_layout);
        if ("com.xiaomi.smarthome.action.startkuailian".equals(getIntent().getAction())) {
            overridePendingTransition(R.anim.v5_dialog_enter, R.anim.v5_dialog_exit);
        }
        ezt.O000000o().startCheck(new ezq() {
            /* class com.xiaomi.smarthome.wificonfig.KuailianLauncher.AnonymousClass1 */

            public final void O000000o() {
                KuailianLauncher.this.finish();
            }

            public final void O00000Oo() {
                KuailianLauncher.this.finish();
            }

            public final void O00000o0() {
                Object obj;
                KuailianLauncher kuailianLauncher = KuailianLauncher.this;
                if ("com.xiaomi.smarthome.action.startkuailian".equals(kuailianLauncher.getIntent().getAction())) {
                    Intent intent = kuailianLauncher.getIntent();
                    Bundle extras = kuailianLauncher.getIntent().getExtras();
                    String str = "";
                    if (!(extras == null || (obj = extras.get("user_id")) == null)) {
                        String obj2 = obj.toString();
                        if (!"0".equals(obj2)) {
                            str = obj2;
                        }
                    }
                    String stringExtra = intent.getStringExtra("bssid");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        stringExtra = stringExtra.toLowerCase();
                    }
                    String stringExtra2 = intent.getStringExtra("user_model");
                    String stringExtra3 = intent.getStringExtra("password");
                    if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str)) {
                        if (!CoreApi.O000000o().O0000Ooo()) {
                            kuailianLauncher.O00000Oo();
                            return;
                        } else if (TextUtils.isEmpty(str) || !CoreApi.O000000o().O0000Ooo() || CoreApi.O000000o().O0000o0().equals(str)) {
                            fbt fbt = new fbt(kuailianLauncher, "ChooseDeviceActivity");
                            fbt.O000000o("model", stringExtra2);
                            fbt.O000000o("bssid", stringExtra);
                            if (stringExtra3 != null) {
                                fbt.O000000o("password", stringExtra3);
                            }
                            fbs.O000000o(fbt);
                            kuailianLauncher.finish();
                        } else {
                            new MLAlertDialog.Builder(kuailianLauncher).O00000Oo(kuailianLauncher.getString(R.string.open_device_account_erro)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.wificonfig.KuailianLauncher.AnonymousClass4 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    gty.O000000o().logout(new ibh<Void, Error>() {
                                        /* class com.xiaomi.smarthome.wificonfig.KuailianLauncher.AnonymousClass4.AnonymousClass1 */

                                        public final void onFailure(Error error) {
                                            KuailianLauncher.this.O000000o(KuailianLauncher.this.getString(R.string.open_device_logout_error));
                                        }

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            KuailianLauncher.this.O00000Oo();
                                        }
                                    }, "KuailianLauncher#openKuailianPage");
                                }
                            }).O000000o(new DialogInterface.OnCancelListener() {
                                /* class com.xiaomi.smarthome.wificonfig.KuailianLauncher.AnonymousClass3 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    KuailianLauncher.this.O000000o();
                                }
                            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.wificonfig.KuailianLauncher.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    KuailianLauncher.this.O000000o();
                                }
                            }).O00000oo();
                            return;
                        }
                    }
                    kuailianLauncher.O000000o(kuailianLauncher.getString(R.string.open_device_not_found_erro_1));
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        new MLAlertDialog.Builder(this).O00000Oo(str).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.KuailianLauncher.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                KuailianLauncher.this.O000000o();
            }
        }).O000000o(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.wificonfig.KuailianLauncher.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                KuailianLauncher.this.O000000o();
            }
        }).O00000oo();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        finish();
        overridePendingTransition(R.anim.v5_dialog_enter, R.anim.v5_dialog_exit);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        Intent intent = new Intent(this, SmartConfigRouterFactory.getSmartConfigManager().getSmartHomeMainActivity());
        intent.putExtras(getIntent());
        intent.setFlags(268468224);
        intent.setAction("com.xiaomi.smarthome.action.viewdevice");
        startActivity(intent);
        overridePendingTransition(R.anim.activity_slide_in_right, R.anim.activity_slide_out_left);
        finish();
    }
}
