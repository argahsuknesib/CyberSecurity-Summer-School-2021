package com.xiaomi.smarthome.camera.activity.nas;

import _m_j.ciu;
import _m_j.ft;
import _m_j.gqg;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.mijia.camera.nas.NASInfo;
import com.mijia.camera.nas.NASServer;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.Iterator;
import java.util.List;

public class NASAddActivity extends CameraBaseActivity {
    private EditText mNASName;
    private EditText mNASPassword;
    public NASServer mNASServer;
    private EditText mNASUserName;
    public int mPollCnt = 3;
    public XQProgressDialog mXQProgressDialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.camera_activity_device_smb_add);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.mNASServer = (NASServer) intent.getParcelableExtra("data");
        if (this.mNASServer == null) {
            finish();
            return;
        }
        initViews();
        initProgressDialog();
    }

    private void initViews() {
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.smb_add_title);
        findViewById(R.id.title_bar_more).setVisibility(8);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASAddActivity.AnonymousClass1 */

            public void onClick(View view) {
                NASAddActivity.this.finish();
            }
        });
        this.mNASName = (EditText) findViewById(R.id.smb_name_et);
        this.mNASName.setText(this.mNASServer.f5188O000000o);
        this.mNASUserName = (EditText) findViewById(R.id.smb_username_et);
        this.mNASPassword = (EditText) findViewById(R.id.smb_password_et);
        findViewById(R.id.complete_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASAddActivity.AnonymousClass2 */

            public void onClick(View view) {
                NASAddActivity.this.onComplete();
            }
        });
    }

    private void initProgressDialog() {
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
    }

    public void onComplete() {
        String obj = this.mNASName.getText().toString();
        String obj2 = this.mNASUserName.getText().toString();
        String obj3 = this.mNASPassword.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            izb.O000000o(this, (int) R.string.smb_warning_name_empty, 0).show();
            return;
        }
        NASServer nASServer = this.mNASServer;
        nASServer.O00000o = nASServer.O00000o;
        NASServer nASServer2 = this.mNASServer;
        nASServer2.O00000oO = obj2;
        nASServer2.O00000oo = obj3;
        this.mXQProgressDialog.show();
        this.mCameraDevice.O0000oO0().O000000o(new ciu(this.mNASServer, ""), new Callback<List<ciu>>() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASAddActivity.AnonymousClass3 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<ciu>) ((List) obj));
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
            public void onSuccess(List<ciu> list) {
                if (!NASAddActivity.this.isFinishing()) {
                    boolean z = false;
                    if (list != null && !list.isEmpty()) {
                        Iterator<ciu> it = list.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().O00000Oo.equals("摄像机监控视频$")) {
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (z) {
                        NASAddActivity.this.mNASServer.O0000O0o = "摄像机监控视频$";
                        NASInfo nASInfo = new NASInfo(NASAddActivity.this.mNASServer);
                        nASInfo.f5186O000000o = 300;
                        nASInfo.O00000Oo = 7776000;
                        nASInfo.O00000o = 1;
                        NASAddActivity.this.mCameraDevice.O0000oO0().O000000o(nASInfo, new Callback<Object>() {
                            /* class com.xiaomi.smarthome.camera.activity.nas.NASAddActivity.AnonymousClass3.AnonymousClass1 */

                            public void onSuccess(Object obj) {
                                if (!NASAddActivity.this.isFinishing()) {
                                    NASAddActivity.this.startPolling("摄像机监控视频$");
                                }
                            }

                            public void onFailure(int i, String str) {
                                if (!NASAddActivity.this.isFinishing()) {
                                    NASAddActivity.this.mXQProgressDialog.dismiss();
                                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                                }
                            }
                        });
                        return;
                    }
                    NASAddActivity.this.mXQProgressDialog.dismiss();
                    Intent intent = new Intent();
                    intent.putExtra("data", new NASInfo(NASAddActivity.this.mNASServer));
                    intent.putExtra("wait", true);
                    intent.setClass(NASAddActivity.this, NASDirListActivity.class);
                    NASAddActivity.this.startActivity(intent);
                    NASAddActivity.this.finish();
                }
            }

            public void onFailure(int i, String str) {
                if (!NASAddActivity.this.isFinishing()) {
                    NASAddActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                }
            }
        });
    }

    public boolean isValid() {
        if (isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !isDestroyed()) {
            return true;
        }
        return false;
    }

    public void startPolling(final String str) {
        this.mXQProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASAddActivity.AnonymousClass4 */

            public void onCancel(DialogInterface dialogInterface) {
                NASAddActivity.this.mHandler.removeCallbacksAndMessages(null);
            }
        });
        this.mPollCnt = 3;
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASAddActivity.AnonymousClass5 */

            public void run() {
                if (NASAddActivity.this.isValid()) {
                    NASAddActivity nASAddActivity = NASAddActivity.this;
                    nASAddActivity.mPollCnt--;
                    if (NASAddActivity.this.mPollCnt < 0) {
                        NASAddActivity.this.mXQProgressDialog.dismiss();
                        gqg.O000000o((int) R.string.smb_tip_set_fail);
                        return;
                    }
                    NASAddActivity.this.mCameraDevice.O0000oO0().O000000o(new Callback<NASInfo>() {
                        /* class com.xiaomi.smarthome.camera.activity.nas.NASAddActivity.AnonymousClass5.AnonymousClass1 */

                        public void onSuccess(NASInfo nASInfo) {
                            if (nASInfo == null) {
                                NASAddActivity.this.mHandler.postDelayed(this, 2000);
                            } else if (TextUtils.equals(str, nASInfo.O000000o())) {
                                NASAddActivity.this.mHandler.post(new Runnable() {
                                    /* class com.xiaomi.smarthome.camera.activity.nas.NASAddActivity.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                    public void run() {
                                        NASAddActivity.this.mXQProgressDialog.dismiss();
                                        gqg.O000000o((int) R.string.smb_tip_set_success);
                                        ft.O000000o(NASAddActivity.this).O000000o(new Intent("go_smbinfo_clear_top_activity"));
                                        Intent intent = new Intent();
                                        intent.setClass(NASAddActivity.this, NASInfoActivity.class);
                                        NASAddActivity.this.startActivity(intent);
                                        NASAddActivity.this.finish();
                                    }
                                });
                            } else {
                                NASAddActivity.this.mHandler.postDelayed(this, 2000);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (NASAddActivity.this.isValid()) {
                                NASAddActivity.this.mHandler.postDelayed(this, 2000);
                            }
                        }
                    });
                }
            }
        }, 2000);
    }
}
