package com.xiaomi.smarthome.international;

import _m_j.cub;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ftn;
import _m_j.gft;
import _m_j.gfu;
import _m_j.gjk;
import _m_j.gty;
import _m_j.hje;
import _m_j.ibh;
import _m_j.izb;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.ActivityStack;
import com.xiaomi.youpin.login.entity.Error;

public class ServerLocationIncompatibleActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    ImageView f9060O000000o;
    TextView O00000Oo;
    Button O00000o;
    Button O00000o0;
    ServerBean O00000oO;
    public Context mContext;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        this.mContext = this;
        setContentView((int) R.layout.server_location_incompatible_activity);
        this.O00000oO = (ServerBean) getIntent().getParcelableExtra("server");
        if (this.O00000oO == null) {
            doCancel();
            return;
        }
        this.O00000Oo = (TextView) findViewById(R.id.content_tv);
        new AsyncTask<Void, Void, String>() {
            /* class com.xiaomi.smarthome.international.ServerLocationIncompatibleActivity.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                String str = (String) obj;
                super.onPostExecute(str);
                ServerLocationIncompatibleActivity.this.O00000Oo.setText(String.format(ServerLocationIncompatibleActivity.this.getString(R.string.server_location_incompatible_content), str));
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                ServerLocationIncompatibleActivity serverLocationIncompatibleActivity = ServerLocationIncompatibleActivity.this;
                return ftn.O000000o(serverLocationIncompatibleActivity, serverLocationIncompatibleActivity.O00000oO.O00000Oo);
            }
        }.execute(new Void[0]);
        this.f9060O000000o = (ImageView) findViewById(R.id.remember);
        findViewById(R.id.remember_container).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.international.ServerLocationIncompatibleActivity.AnonymousClass2 */

            public final void onClick(View view) {
                if (ServerLocationIncompatibleActivity.this.f9060O000000o.isSelected()) {
                    ServerLocationIncompatibleActivity.this.f9060O000000o.setSelected(false);
                } else {
                    ServerLocationIncompatibleActivity.this.f9060O000000o.setSelected(true);
                }
            }
        });
        this.f9060O000000o.setSelected(true);
        this.O00000o = (Button) findViewById(R.id.cancel);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.international.ServerLocationIncompatibleActivity.AnonymousClass3 */

            public final void onClick(View view) {
                ServerLocationIncompatibleActivity.this.doCancel();
            }
        });
        this.O00000o0 = (Button) findViewById(R.id.ok);
        final ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.international.ServerLocationIncompatibleActivity.AnonymousClass4 */

            public final void onClick(View view) {
                if (CoreApi.O000000o().O0000Ooo()) {
                    gty.O000000o().logout(new ibh<Void, Error>() {
                        /* class com.xiaomi.smarthome.international.ServerLocationIncompatibleActivity.AnonymousClass4.AnonymousClass1 */

                        public final void onFailure(Error error) {
                            izb.O000000o(ServerLocationIncompatibleActivity.this.mContext, (int) R.string.server_change_server_failure, 0).show();
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            ServerLocationIncompatibleActivity.this.doOK(ServerLocationIncompatibleActivity.this.O00000oO, new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.international.ServerLocationIncompatibleActivity.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    ActivityStack.instance.doClearOnServerChanged();
                                    gfu O000000o2 = gft.O000000o();
                                    if (O000000o2 != null) {
                                        O000000o2.onChangeServer(O0000ooO);
                                    }
                                    Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher");
                                    if (O00000Oo != null) {
                                        Intent intent = new Intent(ServiceApplication.getAppContext(), O00000Oo);
                                        intent.setData(Uri.parse("https://home.mi.com/main/login"));
                                        ServerLocationIncompatibleActivity.this.startActivity(intent);
                                    }
                                }
                            });
                        }
                    }, "ServerLocationIncompatibleActivity#onCreate");
                    return;
                }
                ServerLocationIncompatibleActivity serverLocationIncompatibleActivity = ServerLocationIncompatibleActivity.this;
                serverLocationIncompatibleActivity.doOK(serverLocationIncompatibleActivity.O00000oO, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.international.ServerLocationIncompatibleActivity.AnonymousClass4.AnonymousClass2 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        ActivityStack.instance.doClearOnServerChanged();
                        gfu O000000o2 = gft.O000000o();
                        if (O000000o2 != null) {
                            O000000o2.onChangeServer(O0000ooO);
                        }
                        fbs.O000000o(new fbt(ServerLocationIncompatibleActivity.this.mContext, "SmartHomeMainActivity"));
                    }
                });
            }
        });
    }

    public void onBackPressed() {
        doCancel();
        super.onBackPressed();
    }

    public void doOK(final ServerBean serverBean, final fsm<Void, fso> fsm) {
        if (serverBean == null) {
            doCancel();
            return;
        }
        hje.O000000o();
        hje.O00000o();
        if (CoreApi.O000000o().O0000O0o()) {
            CoreApi.O000000o().O000000o(serverBean, fsm);
        } else {
            IntentFilter intentFilter = new IntentFilter("ClientApiStub.onCoreReady");
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new BroadcastReceiver() {
                /* class com.xiaomi.smarthome.international.ServerLocationIncompatibleActivity.AnonymousClass5 */

                public final void onReceive(Context context, Intent intent) {
                    ft.O000000o(ServiceApplication.getAppContext()).O000000o(this);
                    CoreApi.O000000o().O000000o(serverBean, fsm);
                }
            }, intentFilter);
        }
        if (this.f9060O000000o.isSelected()) {
            gjk.O000000o(true);
        } else {
            gjk.O000000o(false);
        }
        finish();
        overridePendingTransition(0, 0);
        ft O000000o2 = ft.O000000o(this.mContext);
        Intent intent = new Intent("action_select_server_local_broadcast_complete");
        intent.putExtra("param_key", 1);
        O000000o2.O000000o(intent);
    }

    public void doCancel() {
        ImageView imageView = this.f9060O000000o;
        if (imageView != null) {
            if (imageView.isSelected()) {
                gjk.O000000o(true);
            } else {
                gjk.O000000o(false);
            }
        }
        finish();
        overridePendingTransition(0, 0);
        ft O000000o2 = ft.O000000o(this.mContext);
        Intent intent = new Intent("action_select_server_local_broadcast_complete");
        intent.putExtra("param_key", 2);
        O000000o2.O000000o(intent);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ft.O000000o(this.mContext).O000000o(new Intent("action_select_server_local_broadcast_complete_final"));
    }
}
