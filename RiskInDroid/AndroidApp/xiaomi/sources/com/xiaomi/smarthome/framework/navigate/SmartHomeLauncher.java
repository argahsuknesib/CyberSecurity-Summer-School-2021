package com.xiaomi.smarthome.framework.navigate;

import _m_j.eya;
import _m_j.ezq;
import _m_j.ezt;
import _m_j.fno;
import _m_j.fvc;
import _m_j.fvd;
import _m_j.gge;
import _m_j.goa;
import _m_j.gsy;
import _m_j.hor;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.SmartHomeMainActivity;
import com.xiaomi.smarthome.application.SHApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;

@RouterService
public class SmartHomeLauncher extends FragmentActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ezt.O000000o().startCheck(new ezq() {
            /* class com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher.AnonymousClass1 */

            public final void O000000o() {
                SmartHomeLauncher.this.finish();
            }

            public final void O00000Oo() {
                SmartHomeLauncher.this.finish();
            }

            public final void O00000o0() {
                CoreApi.O000000o().O000000o(SmartHomeLauncher.this, new CoreApi.O0000o0() {
                    /* class com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher.AnonymousClass1.AnonymousClass1 */

                    public final void onCoreReady() {
                        SmartHomeLauncher.this.doWork();
                    }
                });
            }
        });
    }

    public void doWork() {
        eya.O000000o().f15942O000000o = false;
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data == null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && action.equalsIgnoreCase("pluignservice.startForeground.notification.pendingIntent")) {
                processPluginServiceNotificationPendingIntent(intent);
            }
            finish();
            return;
        }
        Uri O00000Oo = fvd.O00000Oo(data);
        fvd.O00000o0 O00000o0 = fvd.O00000o0(O00000Oo);
        if (O00000o0 == null) {
            if (fvd.O000000o(O00000Oo)) {
                if (!O00000Oo.toString().equalsIgnoreCase("https://home.mi.com/download/")) {
                    UrlResolver.O000000o(this, O00000Oo, false, true);
                } else {
                    return;
                }
            }
            finish();
        } else if (O00000o0.O00000Oo) {
            if (!fvc.O000000o()) {
                fno.O000000o().O0000Oo0();
                Intent intent2 = new Intent(this, SmartHomeMainActivity.class);
                intent2.putExtras(getIntent());
                intent2.putExtra("source", 7);
                intent2.putExtra("smarthome_launcher_intent", getIntent());
                intent2.setFlags(268468224);
                startActivity(intent2);
                finish();
            } else if (!O00000o0.O00000o0) {
                UrlResolver.O000000o(this, O00000Oo, false, true);
                finish();
            } else if (CoreApi.O000000o().O0000Ooo()) {
                UrlResolver.O000000o(this, O00000Oo, false, true);
                finish();
            } else {
                new MLAlertDialog.Builder(this).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SmartHomeLauncher.this.gotoLoginPage();
                        dialogInterface.dismiss();
                        SmartHomeLauncher.this.finish();
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        SmartHomeLauncher.this.finish();
                    }
                }).O000000o(true).O000000o(new DialogInterface.OnCancelListener() {
                    /* class com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher.AnonymousClass2 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        SmartHomeLauncher.this.finish();
                    }
                }).O00000Oo((int) R.string.loing_helper_title).O00000oo();
            }
        } else if (!O00000o0.O00000o0) {
            UrlResolver.O000000o(this, O00000Oo, false, true);
            finish();
        } else if (CoreApi.O000000o().O0000Ooo()) {
            UrlResolver.O000000o(this, O00000Oo, false, true);
            finish();
        } else {
            new MLAlertDialog.Builder(this).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SmartHomeLauncher.this.gotoLoginPage();
                    dialogInterface.dismiss();
                    SmartHomeLauncher.this.finish();
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    SmartHomeLauncher.this.finish();
                }
            }).O000000o(true).O000000o(new DialogInterface.OnCancelListener() {
                /* class com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher.AnonymousClass5 */

                public final void onCancel(DialogInterface dialogInterface) {
                    SmartHomeLauncher.this.finish();
                }
            }).O00000Oo((int) R.string.loing_helper_title).O00000oo();
        }
    }

    private void processPluginServiceNotificationPendingIntent(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("model");
            Intent intent2 = (Intent) intent.getParcelableExtra("params");
            if (TextUtils.isEmpty(stringExtra)) {
                Log.d("", "model is null");
            } else {
                PluginApi.getInstance().sendMessage(SHApplication.getAppContext(), stringExtra, 17, intent2, null, null, false, null);
            }
        }
    }

    private String getApkDownloadLocalPath() {
        String str;
        if ("mounted".equals(Environment.getExternalStorageState()) || !goa.O000000o()) {
            str = goa.O000000o(SHApplication.getAppContext()).getPath();
        } else {
            str = SHApplication.getAppContext().getCacheDir().getPath() + File.separator + "app";
        }
        return str + File.separator + "SmartHomeLauncher/SmartHome.apk";
    }

    public void gotoLoginPage() {
        gge.O000000o().O00000Oo();
        fno.O000000o().O0000Oo();
        hor.O000000o().destroySceneManager();
        fno.O000000o().O0000Oo0();
        Intent intent = new Intent(this, LoginMiuiActivity.class);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        gsy.O000000o(LogType.GENERAL, "SmartHomeLauncher", "onActivityResult");
        setResult(i2, intent);
        finish();
    }
}
