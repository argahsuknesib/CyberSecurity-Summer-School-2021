package com.xiaomi.smarthome.splashads;

import _m_j.cmb;
import _m_j.cmc;
import _m_j.cmd;
import _m_j.cme;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.ftn;
import _m_j.gsy;
import _m_j.hwz;
import _m_j.hxa;
import _m_j.hxi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.lang.ref.WeakReference;

public class YPSplashActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    View f11850O000000o;
    SimpleDraweeView O00000Oo;
    boolean O00000o = false;
    FrameLayout O00000o0;
    Handler O00000oO = new Handler() {
        /* class com.xiaomi.smarthome.splashads.YPSplashActivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 2) {
                YPSplashActivity.this.openMainActivity();
            }
        }
    };
    cme O00000oo;
    View O0000O0o;
    private final int O0000OOo = 2;
    private final int O0000Oo = 7000;
    private final int O0000Oo0 = 2000;

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.splash_activity);
        this.O00000oo = cmc.O0000OOo();
        if (this.O00000oo == null) {
            openMainActivity();
        } else {
            this.O00000o = true;
            if (this.f11850O000000o == null) {
                this.f11850O000000o = findViewById(R.id.ad_layer);
                this.O00000Oo = (SimpleDraweeView) findViewById(R.id.ad_image);
                this.O00000o0 = (FrameLayout) findViewById(R.id.jump_image);
                this.O0000O0o = findViewById(R.id.logo_jump);
                this.O0000O0o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.splashads.YPSplashActivity.AnonymousClass2 */

                    public final void onClick(View view) {
                        YPSplashActivity.this.O00000oO.removeMessages(2);
                        YPSplashActivity.this.O00000oO.sendEmptyMessage(2);
                    }
                });
            }
            try {
                this.f11850O000000o.setBackgroundColor(-1);
                this.f11850O000000o.setVisibility(0);
                hxa O000000o2 = hxa.O000000o();
                SimpleDraweeView simpleDraweeView = this.O00000Oo;
                cme cme = this.O00000oo;
                AnonymousClass3 r5 = new hwz() {
                    /* class com.xiaomi.smarthome.splashads.YPSplashActivity.AnonymousClass3 */

                    public final void O000000o() {
                        hxi.O0000o00.f954O000000o.O000000o("page_splash_expose", new Object[0]);
                        if (cmd.O000000o() != null) {
                            gsy.O00000Oo("YoupinApiHelper", "setShowedSplashId");
                        }
                        long j = YPSplashActivity.this.O00000oo.O00000Oo;
                        if (j > 7000) {
                            j = 7000;
                        }
                        Handler handler = YPSplashActivity.this.O00000oO;
                        if (j <= 0) {
                            j = 4500;
                        }
                        handler.sendEmptyMessageDelayed(2, j);
                    }

                    public final void O00000Oo() {
                        YPSplashActivity.this.O00000oO.removeMessages(2);
                    }
                };
                if (cme != null) {
                    if (!TextUtils.isEmpty(cme.O00000oO)) {
                        String str = cme.O00000oO;
                        String str2 = cme.f14119O000000o;
                        if (TextUtils.isEmpty(str)) {
                            simpleDraweeView.setVisibility(8);
                        } else {
                            if (cmd.O000000o() != null) {
                                gsy.O00000Oo("YoupinApiHelper", "loadSplashImage");
                            }
                            r5.O000000o();
                            if (!cmb.O000000o()) {
                                cmb.O00000Oo();
                            }
                            this.mHandler.postDelayed(new Runnable(simpleDraweeView, str2, r5, this) {
                                /* class _m_j.hxa.AnonymousClass1 */

                                /* renamed from: O000000o */
                                final /* synthetic */ SimpleDraweeView f936O000000o;
                                final /* synthetic */ String O00000Oo;
                                final /* synthetic */ BaseActivity O00000o;
                                final /* synthetic */ hwz O00000o0;

                                {
                                    this.f936O000000o = r2;
                                    this.O00000Oo = r3;
                                    this.O00000o0 = r4;
                                    this.O00000o = r5;
                                }

                                public final void run() {
                                    this.f936O000000o.setOnClickListener(new View.OnClickListener() {
                                        /* class _m_j.hxa.AnonymousClass1.AnonymousClass1 */

                                        public final void onClick(View view) {
                                            if (!TextUtils.isEmpty(AnonymousClass1.this.O00000Oo)) {
                                                AnonymousClass1.this.f936O000000o.setOnClickListener(null);
                                                if (AnonymousClass1.this.O00000o0 != null) {
                                                    AnonymousClass1.this.O00000o0.O00000Oo();
                                                }
                                                hxi.O00000o.f952O000000o.O000000o("splash_ad_click", new Object[0]);
                                                hxa.O000000o(AnonymousClass1.this.O00000o, AnonymousClass1.this.O00000Oo);
                                                CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                                                    /* class _m_j.hxa.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                    public final void run() {
                                                        AnonymousClass1.this.O00000o.finish();
                                                    }
                                                }, 100);
                                            }
                                        }
                                    });
                                }
                            }, 100);
                        }
                    }
                }
                simpleDraweeView.setVisibility(8);
            } catch (Exception unused) {
            }
        }
        CoreApi.O000000o().O000000o(this, new O000000o(this, (byte) 0));
    }

    static class O000000o implements CoreApi.O0000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<YPSplashActivity> f11855O000000o;

        /* synthetic */ O000000o(YPSplashActivity yPSplashActivity, byte b) {
            this(yPSplashActivity);
        }

        private O000000o(YPSplashActivity yPSplashActivity) {
            this.f11855O000000o = new WeakReference<>(yPSplashActivity);
        }

        public final void onCoreReady() {
            YPSplashActivity yPSplashActivity = this.f11855O000000o.get();
            if (yPSplashActivity != null && yPSplashActivity.isValid() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                cmc.O00000o();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000oO.removeCallbacksAndMessages(null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    public void openMainActivity() {
        fbt fbt = new fbt(this, "SmartHomeMainActivity");
        fbt.O000000o("SplashActivity.jumpTo.flag", true);
        fbt.O00000Oo(335544320);
        fbs.O000000o(fbt);
        CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.splashads.YPSplashActivity.AnonymousClass4 */

            public final void run() {
                YPSplashActivity.this.finish();
            }
        }, 100);
    }
}
