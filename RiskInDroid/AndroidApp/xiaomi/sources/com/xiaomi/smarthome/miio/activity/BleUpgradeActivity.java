package com.xiaomi.smarthome.miio.activity;

import _m_j.fno;
import _m_j.fte;
import _m_j.izb;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.bluetooth.IBleUpgradeController;
import com.xiaomi.smarthome.bluetooth.IBleUpgradeViewer;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;

public class BleUpgradeActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ViewSwitcher f9640O000000o;
    private View O00000Oo;
    private TextView O00000o;
    private PieProgressBar O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private Button O0000OOo;
    private String O0000Oo;
    private int O0000Oo0;
    private Device O0000OoO;
    private IBleUpgradeController O0000Ooo;
    private final IBleUpgradeViewer.Stub O0000o00 = new IBleUpgradeViewer.Stub() {
        /* class com.xiaomi.smarthome.miio.activity.BleUpgradeActivity.AnonymousClass2 */

        public void showPage(int i, Bundle bundle) throws RemoteException {
            BleUpgradeActivity.this.mHandler.obtainMessage(i, bundle).sendToTarget();
        }

        public void setBtnBackEnabled(boolean z) throws RemoteException {
            BleUpgradeActivity bleUpgradeActivity = BleUpgradeActivity.this;
            bleUpgradeActivity.mBackEnabled = z;
            if (bleUpgradeActivity.mIvBack != null) {
                BleUpgradeActivity.this.mIvBack.setEnabled(z);
            }
        }
    };
    public boolean mBackEnabled = true;
    public String mDid;
    public final Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.miio.activity.BleUpgradeActivity.AnonymousClass1 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
         arg types: [java.lang.String, int]
         candidates:
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void */
        public final void handleMessage(Message message) {
            int i = message.what;
            Bundle bundle = (Bundle) message.obj;
            if (bundle == null) {
                bundle = new Bundle();
            }
            fte.O00000Oo("BleUpgradeActivity.showPage ".concat(String.valueOf(i)));
            if (i == 0) {
                BleUpgradeActivity.this.showLoadingView();
            } else if (i == 1) {
                BleUpgradeActivity.this.showCurrentLatestView();
            } else if (i == 2) {
                BleUpgradeActivity.this.showCurrentDeprecatedView();
            } else if (i == 3) {
                BleUpgradeActivity.this.showPageUpgradingView(bundle.getInt("extra_upgrade_progress"));
            } else if (i == 4) {
                BleUpgradeActivity.this.showUpgradeSuccessView();
                CoreApi.O000000o().O000000o(BleUpgradeActivity.this.mDid, false);
            } else if (i == 5) {
                BleUpgradeActivity.this.showUpgradeFailedView();
                CoreApi.O000000o().O000000o(BleUpgradeActivity.this.mDid, false);
            }
        }
    };
    public ImageView mIvBack;

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        setContentView((int) R.layout.miio_setting_update);
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        Intent intent = getIntent();
        this.mDid = intent.getStringExtra("miio_upgrade_did");
        this.O0000Oo0 = intent.getIntExtra("miio_upgrade_pid", 0);
        this.O0000Oo = intent.getStringExtra("miio_upgrade_name");
        this.O0000OoO = fno.O000000o().O000000o(this.mDid);
        this.mIvBack = (ImageView) findViewById(R.id.module_a_3_return_btn);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.BleUpgradeActivity.AnonymousClass3 */

            public final void onClick(View view) {
                BleUpgradeActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(this.O0000Oo);
        this.f9640O000000o = (ViewSwitcher) findViewById(R.id.vs_root);
        this.O00000Oo = findViewById(R.id.ll_loading);
        this.O00000o0 = (PieProgressBar) findViewById(R.id.pb_progress);
        this.O00000o = (TextView) findViewById(R.id.txt_progress);
        this.O00000oO = (TextView) findViewById(R.id.txt_update_title);
        this.O00000oo = (TextView) findViewById(R.id.txt_update_desc);
        this.O0000O0o = (TextView) findViewById(R.id.txt_updating_tip);
        this.O0000OOo = (Button) findViewById(R.id.btn_bottom);
        this.O00000o0.setPercentView(this.O00000o);
        showLoadingView();
        Bundle extras = intent.getExtras();
        IBinder binder = (extras == null || Build.VERSION.SDK_INT < 18) ? null : extras.getBinder("extra_upgrade_controller");
        if (binder != null) {
            this.O0000Ooo = IBleUpgradeController.Stub.asInterface(binder);
        }
        IBleUpgradeController iBleUpgradeController = this.O0000Ooo;
        if (iBleUpgradeController != null) {
            try {
                iBleUpgradeController.attachUpgradeCaller(this.O0000o00);
            } catch (Exception unused) {
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            izb.O000000o(this, "Upgrade Controller null", 0).show();
            finish();
            return;
        }
        try {
            this.O0000Ooo.onActivityCreated(extras);
        } catch (Exception unused2) {
        }
    }

    public void onBackPressed() {
        if (this.mBackEnabled) {
            super.onBackPressed();
        }
    }

    public void showLoadingView() {
        if (this.f9640O000000o.getCurrentView() != this.O00000Oo) {
            this.f9640O000000o.showNext();
        }
    }

    private void O000000o() {
        if (this.f9640O000000o.getCurrentView() == this.O00000Oo) {
            this.f9640O000000o.showNext();
        }
    }

    public void showCurrentLatestView() {
        O000000o();
        this.O00000o0.setBackgroundResource(R.drawable.update_img_latest);
        TextView textView = this.O00000oO;
        textView.setText(getResources().getString(R.string.model_latest) + "\n\n" + getResources().getString(R.string.app_curr_version) + " " + O00000Oo());
        this.O00000o.setVisibility(8);
        this.O00000o0.setPercent(0.0f);
        this.O00000o0.setOnClickListener(null);
        this.O00000oO.setVisibility(0);
        this.O00000oo.setVisibility(8);
        this.O0000O0o.setVisibility(8);
        this.O0000OOo.setVisibility(0);
        this.O0000OOo.setText((int) R.string.ok_button);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.BleUpgradeActivity.AnonymousClass4 */

            public final void onClick(View view) {
                BleUpgradeActivity.this.finish();
            }
        });
    }

    public void showCurrentDeprecatedView() {
        O000000o();
        this.O00000o.setVisibility(8);
        this.O00000o0.setBackgroundResource(R.drawable.update_img_update);
        this.O00000o0.setPercent(0.0f);
        this.O00000o0.setOnClickListener(null);
        this.O00000oO.setVisibility(0);
        TextView textView = this.O00000oO;
        textView.setText(getResources().getString(R.string.list_item_curr_version) + " " + O00000Oo() + "\n\n" + getResources().getString(R.string.list_item_latest_version) + " " + O00000o0());
        this.O00000oo.setVisibility(0);
        this.O00000oo.setText(O00000o());
        this.O0000O0o.setVisibility(8);
        this.O0000OOo.setVisibility(0);
        this.O0000OOo.setText((int) R.string.update_now);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.BleUpgradeActivity.AnonymousClass5 */

            public final void onClick(View view) {
                BleUpgradeActivity.this.startUpgrade();
            }
        });
    }

    public void showPageUpgradingView(int i) {
        O000000o();
        this.O00000oO.setVisibility(0);
        this.O00000oO.setText((int) R.string.model_updating);
        this.O00000oo.setVisibility(8);
        this.O0000O0o.setVisibility(0);
        this.O0000OOo.setVisibility(4);
        this.O00000o0.setOnClickListener(null);
        this.O00000o0.setBackgroundResource(R.drawable.kuailian_progress_filled_not);
        this.O00000o.setVisibility(0);
        if (i >= 0 && i < 100) {
            this.O00000o0.setPercent((float) i);
        } else if (i >= 100) {
            this.O00000o0.setPercent(99.0f);
        }
    }

    public void showUpgradeSuccessView() {
        O000000o();
        this.O00000o0.setBackgroundResource(R.drawable.update_img_success);
        TextView textView = this.O00000oO;
        textView.setText(getResources().getString(R.string.model_update_success) + "\n\n" + getResources().getString(R.string.app_curr_version) + " " + O00000Oo());
        this.O00000o.setVisibility(8);
        this.O00000o0.setPercent(0.0f);
        this.O00000o0.setOnClickListener(null);
        this.O00000oO.setVisibility(0);
        this.O00000oo.setVisibility(8);
        this.O0000O0o.setVisibility(8);
        this.O0000OOo.setVisibility(0);
        this.O0000OOo.setText((int) R.string.ok_button);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.BleUpgradeActivity.AnonymousClass6 */

            public final void onClick(View view) {
                BleUpgradeActivity.this.finish();
            }
        });
    }

    public void showUpgradeFailedView() {
        O000000o();
        this.O00000oO.setVisibility(0);
        this.O00000oo.setVisibility(8);
        this.O0000O0o.setVisibility(8);
        this.O0000OOo.setVisibility(0);
        this.O0000OOo.setText((int) R.string.ok_button);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.BleUpgradeActivity.AnonymousClass7 */

            public final void onClick(View view) {
                BleUpgradeActivity.this.finish();
            }
        });
        this.O00000o0.setBackgroundResource(R.drawable.update_img_failed);
        this.O00000o0.setPercent(0.0f);
        this.O00000o.setVisibility(8);
        this.O00000oO.setText((int) R.string.update_failed_retry);
        this.O00000o0.setOnClickListener(null);
    }

    private String O00000Oo() {
        try {
            return this.O0000Ooo.getCurrentVersion();
        } catch (Exception unused) {
            return "";
        }
    }

    private String O00000o0() {
        try {
            return this.O0000Ooo.getLatestVersion();
        } catch (Exception unused) {
            return "";
        }
    }

    private String O00000o() {
        try {
            return this.O0000Ooo.getUpgradeDescription();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void */
    public void startUpgrade() {
        try {
            CoreApi.O000000o().O000000o(this.mDid, true);
            this.O0000Ooo.startUpgrade();
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void */
    public void onDestroy() {
        try {
            this.O0000Ooo.detachUpgradeCaller();
        } catch (Exception unused) {
        }
        super.onDestroy();
        CoreApi.O000000o().O000000o(this.mDid, false);
    }
}
