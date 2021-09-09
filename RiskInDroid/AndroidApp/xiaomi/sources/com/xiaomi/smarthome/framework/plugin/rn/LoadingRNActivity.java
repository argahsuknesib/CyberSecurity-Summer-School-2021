package com.xiaomi.smarthome.framework.plugin.rn;

import _m_j.fkw;
import _m_j.fvt;
import _m_j.gbt;
import _m_j.gbu;
import _m_j.gbz;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.react.bridge.Callback;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule;
import java.io.File;
import java.io.IOException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoadingRNActivity extends LoadingBaseActivity {
    private boolean O0000O0o = false;
    private TextView O0000OOo;
    private BroadcastReceiver O0000Oo0 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            gbu.O00000oo("LoadingRNActivity receive broadcast, action is ".concat(String.valueOf(action)));
            if (action != null) {
                char c = 65535;
                switch (action.hashCode()) {
                    case -1056971268:
                        if (action.equals("action_launch_plugin_finish")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 222910955:
                        if (action.equals("action_download_plugin_progress")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 235373322:
                        if (action.equals("action_download_plugin_error")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 646936263:
                        if (action.equals("action_launch_plugin_fail")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c != 0) {
                    if (c == 1) {
                        gbu.O00000oo("LoadingRNActivity Broadcast: receiver ACTION_LAUNCH_PLUGIN_FINISH broadcast...");
                        LoadingRNActivity.this.finishActivity();
                    } else if (c == 2) {
                        LoadingRNActivity.this.updateProgressView(intent.getStringExtra("deviceId"), intent.getFloatExtra("progress", 0.0f));
                    } else if (c == 3) {
                        gbu.O00000oo("LoadingRNActivity Broadcast: receiver ACTION_DOWNLOAD_PLUGIN_ERROR broadcast...");
                        LoadingRNActivity.this.finishActivityDelay(2300);
                    }
                } else if (LoadingRNActivity.this.O00000oO == null || LoadingRNActivity.this.O00000oO.equals(intent.getParcelableExtra("extra_devicestat"))) {
                    LoadingRNActivity.this.onBackPressed();
                }
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_launch_plugin_fail");
        intentFilter.addAction("action_launch_plugin_finish");
        intentFilter.addAction("action_download_plugin_progress");
        intentFilter.addAction("action_download_plugin_error");
        registerReceiver(this.O0000Oo0, intentFilter);
        gbu.O00000oo("LoadingRNActivity --> onCreate");
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        gbu.O00000oo("LoadingRNActivity --> onNewIntent");
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        gbu.O00000oo("LoadingRNActivity --> onWindowFocusChanged  hasFocus=" + z + "  isCheckOpenPlugin=" + this.O0000O0o);
        if (z && !this.O0000O0o) {
            this.O0000O0o = true;
            this.f8119O000000o.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass3 */

                public final void run() {
                    LoadingRNActivity.this.checkToOpenPlugin();
                }
            });
        }
    }

    public void updateProgressView(String str, float f) {
        if (this.O0000OOo == null) {
            this.O0000OOo = (TextView) findViewById(R.id.tv_plugin_download_progress);
            this.O0000OOo.setVisibility(0);
        }
        gbu.O000000o(str + "-->" + f);
        if (this.O00000oO != null && this.O00000oO.did.equals(str)) {
            gbu.O00000oo(this.O00000oO.model + " is current device progress..." + f);
            int i = (int) (f * 100.0f);
            if (i > 100) {
                i = 100;
            }
            TextView textView = this.O0000OOo;
            textView.setText(getString(R.string.mj_loading_hint) + i + "%");
        }
    }

    public void checkToOpenPlugin() {
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("activity_start_from", -1);
            if (intExtra == 1001) {
                XmPluginHostApi.instance().sendMessage(getIntent().getStringExtra("did"), 1, getIntent(), null, null);
            } else if (intExtra == 1002) {
                final String stringExtra = getIntent().getStringExtra(fvt.O00000oo);
                PluginPackageInfo mockPluginPackageInfo = MockRnDevicePluginManager.getInstance().getMockPluginPackageInfo(MockRnDevicePluginManager.getInstance().getMockDeviceStat(stringExtra).model);
                StringBuilder sb = new StringBuilder();
                sb.append(mockPluginPackageInfo.O00000Oo());
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(mockPluginPackageInfo.O000000o());
                String sb4 = sb3.toString();
                final String str = (fkw.O000000o(getApplicationContext()) + File.separator + "plugin" + File.separator + "install" + File.separator + "rn") + File.separator + sb4 + File.separator + sb2;
                final String stringExtra2 = getIntent().getStringExtra(fvt.O0000O0o);
                if (TextUtils.isEmpty(stringExtra2)) {
                    gbz.O000000o("url is empty");
                    return;
                }
                final File file = new File(str + File.separator + "conf.json");
                if (file.exists()) {
                    XmPluginHostApi.instance().sendMessage(stringExtra, 1, getIntent(), null, null);
                    return;
                }
                final AnonymousClass7 r2 = new Callback() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass7 */

                    public final void invoke(Object... objArr) {
                        if (((Boolean) objArr[0]).booleanValue() && !file.exists()) {
                            try {
                                file.createNewFile();
                                XmPluginHostApi.instance().sendMessage(stringExtra, 1, LoadingRNActivity.this.getIntent(), null, null);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                Observable.create(new Observable.OnSubscribe<String>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass10 */

                    public final /* synthetic */ void call(Object obj) {
                        final Subscriber subscriber = (Subscriber) obj;
                        LoadingRNActivity.this.downloadPluginFile(stringExtra2, str, new Callback() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass10.AnonymousClass1 */

                            public final void invoke(Object... objArr) {
                                if (((Boolean) objArr[0]).booleanValue()) {
                                    String obj = objArr[1].toString();
                                    LoadingRNActivity.this.unZipFile(obj);
                                    new File(obj).delete();
                                    subscriber.onNext(obj);
                                    return;
                                }
                                gbu.O00000Oo(objArr[1].toString());
                                subscriber.onError(new Throwable(objArr[1].toString()));
                            }
                        });
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass8 */

                    public final /* synthetic */ void call(Object obj) {
                        String str = (String) obj;
                        Callback callback = r2;
                        if (callback != null) {
                            callback.invoke(Boolean.TRUE, str);
                        }
                    }
                }, new Action1<Throwable>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass9 */

                    public final /* synthetic */ void call(Object obj) {
                        Throwable th = (Throwable) obj;
                        Callback callback = r2;
                        if (callback != null) {
                            callback.invoke(Boolean.FALSE, th.toString());
                        }
                    }
                });
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        gbu.O00000oo("LoadingRNActivity --> onBackPressed");
        sendBroadcast(new Intent("action_loading_finish").putExtra("extra_devicestat", this.O00000oO));
    }

    public void finishActivity() {
        gbu.O00000oo("LoadingRNActivity --> finishActivity");
        sendBroadcast(new Intent("action_loading_finish").putExtra("extra_devicestat", this.O00000oO));
        finish();
    }

    public void finishActivityDelay(final long j) {
        if (!isFinishing()) {
            Observable.create(new Observable.OnSubscribe<String>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass6 */

                public final /* synthetic */ void call(Object obj) {
                    Subscriber subscriber = (Subscriber) obj;
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException unused) {
                    }
                    subscriber.onNext("");
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass4 */

                public final /* synthetic */ void call(Object obj) {
                    LoadingRNActivity.this.finishActivity();
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass5 */

                public final /* synthetic */ void call(Object obj) {
                    LoadingRNActivity.this.finishActivity();
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        gbu.O00000oo("LoadingRNActivity --> onDestroy");
        unregisterReceiver(this.O0000Oo0);
    }

    public void downloadPluginFile(String str, String str2, final Callback callback) {
        final String str3 = str2 + File.separator + "temp.zip";
        MIOTPersistModule.download("temp.zip", str, null, str3, 60000, 60000, new Callback() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity.AnonymousClass2 */

            public final void invoke(Object... objArr) {
                if (!((Boolean) objArr[0]).booleanValue()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(objArr[1]);
                    gbu.O00000Oo(sb.toString());
                    Callback callback = callback;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(objArr[1]);
                    callback.invoke(Boolean.FALSE, sb2.toString());
                } else if (objArr[1] != null) {
                    callback.invoke(Boolean.TRUE, str3);
                }
            }
        });
    }

    public void unZipFile(String str) {
        gbt.O000000o(str, new File(str).getParent());
    }
}
