package com.xiaomi.smarthome.nfctag.ui;

import _m_j.ezq;
import _m_j.ezt;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.gpc;
import _m_j.gtx;
import _m_j.gty;
import _m_j.hig;
import _m_j.hih;
import _m_j.hii;
import _m_j.hte;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import org.json.JSONObject;

public class NFCSceneRunActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    String f10454O000000o;
    String O00000Oo;
    String O00000o;
    String O00000o0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_run_scene);
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            finish();
        } else if (!hig.O00000oo()) {
            finish();
        } else {
            this.f10454O000000o = getIntent().getStringExtra("us_id");
            this.O00000Oo = getIntent().getStringExtra("owner_uid");
            this.O00000o0 = getIntent().getStringExtra("region");
            this.O00000o = getIntent().getStringExtra("scene_name");
            if (TextUtils.isEmpty(this.f10454O000000o) || TextUtils.isEmpty(this.O00000Oo) || TextUtils.isEmpty(this.O00000o0)) {
                hih.O000000o("smarthome-nfc", "run message has empty data");
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(this.O00000o)) {
                    sb.append(this.O00000o);
                }
                sb.append(getString(R.string.execute_fail));
                showRunResult(sb.toString());
                return;
            }
            ezt.O000000o().startCheck(new ezq() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCSceneRunActivity.AnonymousClass1 */

                public final void O000000o() {
                    NFCSceneRunActivity.this.finish();
                }

                public final void O00000Oo() {
                    NFCSceneRunActivity.this.finish();
                }

                public final void O00000o0() {
                    if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                        gty.O000000o().startLogin(NFCSceneRunActivity.this, 1, new gtx.O000000o() {
                            /* class com.xiaomi.smarthome.nfctag.ui.NFCSceneRunActivity.AnonymousClass1.AnonymousClass1 */

                            public final void O000000o() {
                                if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                                    hte.O000000o(NFCSceneRunActivity.this, (int) R.string.login_fail);
                                    NFCSceneRunActivity.this.finish();
                                    return;
                                }
                                NFCSceneRunActivity.this.runScene(NFCSceneRunActivity.this.f10454O000000o, NFCSceneRunActivity.this.O00000Oo, NFCSceneRunActivity.this.O00000o0);
                            }
                        });
                        return;
                    }
                    NFCSceneRunActivity nFCSceneRunActivity = NFCSceneRunActivity.this;
                    nFCSceneRunActivity.runScene(nFCSceneRunActivity.f10454O000000o, NFCSceneRunActivity.this.O00000Oo, NFCSceneRunActivity.this.O00000o0);
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void runScene(String str, String str2, String str3) {
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            gty.O000000o().startLogin(this, 1, null);
            finish();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("us_id", Long.valueOf(str));
            jSONObject.put("owner_uid", Long.valueOf(str2));
            jSONObject.put("region", str3);
        } catch (Exception e) {
            e.printStackTrace();
            showRunResult(getString(R.string.execute_fail));
        }
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0(jSONObject) {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCSceneRunActivity$IaGqgF7TIHt3oLYiZKJZWIra4jY */
            private final /* synthetic */ JSONObject f$1;

            {
                this.f$1 = r2;
            }

            public final void onCoreReady() {
                NFCSceneRunActivity.this.O000000o(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(JSONObject jSONObject) {
        hii.O000000o(ServiceApplication.getAppContext(), jSONObject, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCSceneRunActivity.AnonymousClass2 */

            public final void onFailure(fso fso) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(NFCSceneRunActivity.this.O00000o)) {
                    sb.append(NFCSceneRunActivity.this.O00000o);
                }
                NFCSceneRunActivity nFCSceneRunActivity = NFCSceneRunActivity.this;
                nFCSceneRunActivity.showRunResult(nFCSceneRunActivity.getString(R.string.nfc_trigger_run_fail, new Object[]{sb.toString()}));
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(NFCSceneRunActivity.this.O00000o)) {
                    sb.append(NFCSceneRunActivity.this.O00000o);
                }
                NFCSceneRunActivity nFCSceneRunActivity = NFCSceneRunActivity.this;
                nFCSceneRunActivity.showRunResult(nFCSceneRunActivity.getString(R.string.nfc_trigger_run_success, new Object[]{sb.toString()}));
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.app.Activity, float):int
     arg types: [com.xiaomi.smarthome.nfctag.ui.NFCSceneRunActivity, int]
     candidates:
      _m_j.gpc.O000000o(android.content.Context, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.app.Activity, float):int */
    public void showRunResult(String str) {
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.toast_scene_run, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.title2)).setText(str);
        hte.O000000o(this, inflate, new float[]{(float) gpc.O000000o((Activity) this, 12.0f), 0.0f});
        finish();
    }
}
