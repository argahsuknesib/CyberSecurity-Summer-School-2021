package com.xiaomi.smarthome.notishortcut.inward;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.gsy;
import _m_j.hje;
import _m_j.hjf;
import _m_j.hjg;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class QuickOpServiceNew extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        gsy.O00000Oo("QuickOpServiceNew", "Quickop onStartCommand");
        O000000o(null);
        if (intent != null) {
            String action = intent.getAction();
            if (TextUtils.equals("notification_cancel", action)) {
                hjg.O000000o(this);
            } else if (TextUtils.equals("quick_noti_setting_update", action)) {
                O000000o(intent.getStringExtra("device_id"));
            } else if (intent != null) {
                String action2 = intent.getAction();
                gsy.O000000o(6, "QuickOpServiceNew", action2);
                if (TextUtils.equals("notification_click", action2)) {
                    int intExtra = intent.getIntExtra("device_index", -1);
                    if (intExtra < hjf.O000000o(this).f18975O000000o.size() && !hjf.O000000o(this).f18975O000000o.get(intExtra).O00000oo) {
                        hjf.O000000o(this).f18975O000000o.get(intExtra).O00000oo = true;
                        hjf.O000000o(this).f18975O000000o.get(intExtra).O0000O0o = 1;
                        hjg.O000000o(this, hjf.O000000o(this).f18975O000000o);
                        hjf O000000o2 = hjf.O000000o(this);
                        String O000000o3 = hjf.O000000o(O000000o2.f18975O000000o.get(intExtra).O0000Ooo, O000000o2.f18975O000000o.get(intExtra).O0000o00);
                        Context context = O000000o2.O00000oo;
                        String str = O000000o2.f18975O000000o.get(intExtra).f18982O000000o;
                        hjf.AnonymousClass4 r5 = new hje.O000000o(intExtra) {
                            /* class _m_j.hjf.AnonymousClass4 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ int f18979O000000o;

                            {
                                this.f18979O000000o = r2;
                            }

                            public final void O000000o() {
                                if (this.f18979O000000o < hjf.this.f18975O000000o.size()) {
                                    hjf.this.f18975O000000o.get(this.f18979O000000o).O00000oO = !hjf.this.f18975O000000o.get(this.f18979O000000o).O00000oO;
                                    hjf.this.O00000Oo();
                                    hjf.this.O000000o(this.f18979O000000o, 0);
                                }
                            }

                            public final void O000000o(int i) {
                                hjf.this.O000000o(this.f18979O000000o, i);
                            }
                        };
                        gsy.O00000Oo("NotiSettingManager", "rpc did: ".concat(String.valueOf(str)));
                        gsy.O00000Oo("NotiSettingManager", O000000o3);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new KeyValuePair("data", O000000o3));
                        NetRequest O000000o4 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/rpc/".concat(String.valueOf(str))).O000000o(arrayList).O000000o();
                        hjf.AnonymousClass5 r6 = new fss<JSONObject>() {
                            /* class _m_j.hjf.AnonymousClass5 */

                            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                                return jSONObject;
                            }
                        };
                        CoreApi.O000000o().O000000o(context, O000000o4, r6, Crypto.RC4, new fsm<JSONObject, fso>(r5) {
                            /* class _m_j.hjf.AnonymousClass6 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ hje.O000000o f18981O000000o;

                            {
                                this.f18981O000000o = r2;
                            }

                            public final void onFailure(fso fso) {
                                hje.O000000o o000000o = this.f18981O000000o;
                                if (o000000o != null) {
                                    int O000000o2 = fso.O000000o();
                                    new StringBuilder("msg: ").append(fso.O00000Oo());
                                    o000000o.O000000o(O000000o2);
                                }
                                gsy.O00000Oo("NotiSettingManager", "rpc onError: code: " + fso.O000000o() + " ,message: " + fso.O00000Oo());
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                hje.O000000o o000000o = this.f18981O000000o;
                                if (o000000o != null) {
                                    o000000o.O000000o();
                                }
                            }
                        });
                    }
                } else if (TextUtils.equals("auth_expired", action2)) {
                    Intent intent2 = new Intent("com.xiaomi.smarthome.notification.auth_expired");
                    intent2.setPackage(getPackageName());
                    hjg.O000000o(this, 990, getString(R.string.noti_token_expired_title), getString(R.string.noti_token_expired), intent2);
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        stopForeground(true);
        hjf.O000000o(this).O00000o();
        hjf.O000000o(this).O00000o0();
        gsy.O000000o(6, "QuickOpServiceNew", "service onDestroy");
        super.onDestroy();
    }

    private void O000000o(String str) {
        if (TextUtils.isEmpty(str) || !hjf.O000000o(this).O00000oO.containsKey(str)) {
            hjg.O000000o(this, hjf.O000000o(this).f18975O000000o);
            hjf.O000000o(this).O00000oO();
            return;
        }
        gsy.O00000Oo("QuickOpServiceNew", "等到了全量列表");
        int intValue = hjf.O000000o(this).O00000oO.get(str).intValue();
        if (intValue < 0 || intValue >= hjf.O000000o(this).f18975O000000o.size()) {
            hjf.O000000o(this).O00000o();
        } else {
            hjf.O000000o(this).f18975O000000o.get(intValue).O00000oo = false;
            hjf.O000000o(this).O00000oO.remove(str);
        }
        hjg.O000000o(this, hjf.O000000o(this).f18975O000000o);
        hjf.O000000o(this).O00000oO();
    }
}
