package com.xiaomi.smarthome.miio.update;

import _m_j.gyh;
import _m_j.izb;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;

public class ForceUpdateActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Dialog f9961O000000o = null;

    public void dismissProgressDialog() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(new FrameLayout(this));
    }

    public void onStart() {
        super.onStart();
        if (gyh.O00000Oo().hasDownloadedNewVersionApk(this, gyh.O00000Oo().getNewVersionCode())) {
            gyh.O00000Oo().startInstallApkIntent(this);
            return;
        }
        if (this.f9961O000000o == null) {
            final Dialog dialog = new Dialog(this, R.style.LockActivityTheme);
            dialog.setContentView((int) R.layout.dialog_download_progress);
            final PieProgressBar pieProgressBar = (PieProgressBar) dialog.findViewById(R.id.pg_download);
            pieProgressBar.setPercentView((TextView) dialog.findViewById(R.id.txt_status));
            final AnonymousClass1 r2 = new BroadcastReceiver() {
                /* class com.xiaomi.smarthome.miio.update.ForceUpdateActivity.AnonymousClass1 */

                public final void onReceive(Context context, Intent intent) {
                    String stringExtra = intent.getStringExtra("status");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        if (stringExtra.equals("progress")) {
                            int intExtra = intent.getIntExtra("progress", 0);
                            if (intExtra > 0 && intExtra < 100) {
                                pieProgressBar.setPercent((float) intExtra);
                            }
                        } else if (stringExtra.equals("success")) {
                            gyh.O00000Oo().startInstallApkIntent(ForceUpdateActivity.this);
                        } else {
                            dialog.dismiss();
                            izb.O000000o(ForceUpdateActivity.this, (int) R.string.app_upgrade_failed_smarthome, 0).show();
                            ForceUpdateActivity.this.finish();
                        }
                    }
                }
            };
            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                /* class com.xiaomi.smarthome.miio.update.ForceUpdateActivity.AnonymousClass2 */

                public final void onShow(DialogInterface dialogInterface) {
                    ForceUpdateActivity.this.registerReceiver(r2, new IntentFilter("action_update_progress"));
                }
            });
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.xiaomi.smarthome.miio.update.ForceUpdateActivity.AnonymousClass3 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    ForceUpdateActivity.this.unregisterReceiver(r2);
                }
            });
            dialog.setCancelable(false);
            this.f9961O000000o = dialog;
        }
        if (!this.f9961O000000o.isShowing()) {
            this.f9961O000000o.show();
            gyh.O00000Oo().showNorifyProgress(true);
            gyh.O00000Oo().startDownloadApk(this, true, gyh.O00000Oo().getNewVersionUrl(), BitmapFactory.decodeResource(getResources(), R.drawable.mj_ic_launcher));
        }
    }

    public void onStop() {
        super.onStop();
        if (gyh.O00000Oo().isApkInstalling()) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (gyh.O00000Oo().isApkInstalling()) {
            dismissProgressDialog();
            System.exit(0);
        }
    }
}
