package com.xiaomi.smarthome.scene;

import _m_j.ezq;
import _m_j.ezt;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gof;
import _m_j.gov;
import _m_j.gtx;
import _m_j.gty;
import _m_j.hob;
import _m_j.hte;
import _m_j.hxi;
import _m_j.hxj;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class SmartHomeLauncherActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    int f10633O000000o = -1;
    String O00000Oo;
    String O00000o0 = "";
    public boolean mIsGotoLoginPage = false;
    public int mTryTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() != null) {
            this.f10633O000000o = getIntent().getExtras().getInt("extra_scene_id", -1);
            this.O00000Oo = getIntent().getExtras().getString("extra_str_scene_id");
            this.O00000o0 = getIntent().getExtras().getString("extra_scene_account");
        }
        if (!TextUtils.isEmpty(this.O00000Oo)) {
            hxj hxj = hxi.f950O000000o;
            String str = this.O00000o0;
            hxj.O000000o(str, this.O00000Oo);
        } else {
            hxj hxj2 = hxi.f950O000000o;
            String str2 = this.O00000o0;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10633O000000o);
            hxj2.O000000o(str2, sb.toString());
        }
        if (this.f10633O000000o == -1 && TextUtils.isEmpty(this.O00000Oo)) {
            finish();
        } else if (!gof.O00000o0()) {
            hte.O000000o(this, (int) R.string.status_error_cable_not_plugin_body);
            finish();
        } else {
            ezt.O000000o().startCheck(new ezq() {
                /* class com.xiaomi.smarthome.scene.SmartHomeLauncherActivity.AnonymousClass1 */

                public final void O000000o() {
                    SmartHomeLauncherActivity.this.finish();
                }

                public final void O00000Oo() {
                    SmartHomeLauncherActivity.this.finish();
                }

                public final void O00000o0() {
                    SmartHomeLauncherActivity smartHomeLauncherActivity = SmartHomeLauncherActivity.this;
                    if (!CoreApi.O000000o().O0000O0o() || !CoreApi.O000000o().O0000Ooo()) {
                        CoreApi.O000000o().O000000o(smartHomeLauncherActivity, new CoreApi.O0000o0() {
                            /* class com.xiaomi.smarthome.scene.SmartHomeLauncherActivity.AnonymousClass2 */

                            public final void onCoreReady() {
                                if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                                    SmartHomeLauncherActivity.this.lauchSceneOld();
                                } else if (CoreApi.O000000o().O0000Ooo()) {
                                    SmartHomeLauncherActivity.this.lauchSceneOld();
                                } else {
                                    SmartHomeLauncherActivity.this.startLogin();
                                }
                            }
                        });
                    } else {
                        smartHomeLauncherActivity.lauchSceneOld();
                    }
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mIsGotoLoginPage) {
            finish();
        }
    }

    public void startLogin() {
        this.mIsGotoLoginPage = true;
        gty.O000000o().startLogin(this, 1, new gtx.O000000o() {
            /* class com.xiaomi.smarthome.scene.SmartHomeLauncherActivity.AnonymousClass3 */

            public final void O000000o() {
                if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                    SmartHomeLauncherActivity smartHomeLauncherActivity = SmartHomeLauncherActivity.this;
                    smartHomeLauncherActivity.mIsGotoLoginPage = false;
                    smartHomeLauncherActivity.lauchSceneOld();
                    return;
                }
                SmartHomeLauncherActivity.this.finish();
            }
        });
    }

    public void lauchSceneOld() {
        String O0000o0 = CoreApi.O000000o().O0000o0();
        String str = this.O00000o0;
        if (str == null || O0000o0 == null || !str.equalsIgnoreCase(O0000o0)) {
            hte.O000000o(this, (int) R.string.launcher_switch_to_userid);
            finish();
            return;
        }
        hte.O000000o(this, (int) R.string.launcher_scene_loading);
        final gov gov = new gov();
        gov.O000000o(new gov.O000000o() {
            /* class com.xiaomi.smarthome.scene.SmartHomeLauncherActivity.AnonymousClass4 */

            public final void O000000o() {
                hob.O000000o();
                SmartHomeLauncherActivity smartHomeLauncherActivity = SmartHomeLauncherActivity.this;
                hob.O000000o(smartHomeLauncherActivity, smartHomeLauncherActivity.O00000Oo, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.scene.SmartHomeLauncherActivity.AnonymousClass4.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        SmartHomeLauncherActivity.this.mTryTime++;
                        if (SmartHomeLauncherActivity.this.mTryTime <= 2) {
                            gov.O00000o0();
                        } else if (fso.f17063O000000o == -1) {
                            hte.O000000o(SmartHomeLauncherActivity.this, (int) R.string.scene_expired);
                            SmartHomeLauncherActivity.this.finish();
                        } else {
                            hte.O000000o(SmartHomeLauncherActivity.this, (int) R.string.smarthome_scene_start_error);
                            SmartHomeLauncherActivity.this.finish();
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        hte.O000000o(SmartHomeLauncherActivity.this, (int) R.string.smarthome_scene_start_complete);
                        SmartHomeLauncherActivity.this.finish();
                    }
                });
            }
        }, 300);
        gov.O000000o();
    }

    public void onStart() {
        super.onStart();
    }
}
