package com.xiaomi.smarthome.app.startup;

import _m_j.eyk;
import _m_j.ezz;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fju;
import _m_j.flk;
import _m_j.fsl;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ftn;
import _m_j.goy;
import _m_j.gpc;
import _m_j.gpv;
import _m_j.gpy;
import _m_j.gqf;
import _m_j.gwc;
import _m_j.hyy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.Locale;

public class CTAActivity2rd extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4193O000000o;
    View O00000Oo;
    ImageView O00000o;
    TextView O00000o0;
    TextView O00000oO;
    TextView O00000oo;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        ezz.O000000o(getWindow());
        hyy.O000000o(this);
        this.f4193O000000o = this;
        setContentView((int) R.layout.cta_activity);
        boolean booleanExtra = getIntent().getBooleanExtra("init", false);
        TextView textView = (TextView) findViewById(R.id.title);
        this.O00000Oo = findViewById(R.id.empty);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass1 */

            public final void onClick(View view) {
            }
        });
        gpv.O00000Oo("pref_key_smarthome_exp_plan_user", true);
        this.O00000o0 = (TextView) findViewById(R.id.disclaim_content);
        if (!ftn.O00000oO((ServerBean) null)) {
            if (booleanExtra) {
                textView.setText((int) R.string.usr_exp_plan_update);
            } else {
                textView.setText((int) R.string.usr_exp_plan);
            }
            this.O00000o0.setVisibility(0);
            String string = getString(R.string.disclaim_join_user_exp_plan);
            int indexOf = string.indexOf("#start#");
            int indexOf2 = string.indexOf("#end#") - 7;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
            AnonymousClass10 r15 = new ClickableSpan() {
                /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass10 */

                public final void onClick(View view) {
                    fbs.O000000o(new fbt(CTAActivity2rd.this, "/userCenter/UsrExpPlanActivity"));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(Color.parseColor("#FF527ACC"));
                    textPaint.setUnderlineText(false);
                }
            };
            if (indexOf > 0 && indexOf2 > 0) {
                try {
                    spannableStringBuilder.setSpan(r15, indexOf, indexOf2, 33);
                } catch (Exception unused) {
                }
            }
            this.O00000o0.setText(spannableStringBuilder);
            this.O00000o0.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            ((TextView) findViewById(R.id.title)).setText((int) R.string.disclaim_title);
            this.O00000o0.setVisibility(8);
        }
        this.O00000o = (ImageView) findViewById(R.id.remember);
        int O00000oO2 = goy.O00000oO();
        View findViewById = findViewById(R.id.remember_container);
        if (O00000oO2 == 1) {
            findViewById.setVisibility(8);
            this.O00000o.setSelected(true);
        } else {
            findViewById.setVisibility(8);
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass3 */

                public final void onClick(View view) {
                    if (CTAActivity2rd.this.O00000o.isSelected()) {
                        CTAActivity2rd.this.O00000o.setSelected(false);
                    } else {
                        CTAActivity2rd.this.O00000o.setSelected(true);
                    }
                }
            });
        }
        this.O00000o.setSelected(true);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass4 */

            public final void onClick(View view) {
                CTAActivity2rd.this.O00000o.setSelected(!CTAActivity2rd.this.O00000o.isSelected());
            }
        });
        String string2 = getString(R.string.disclaim_join_user_exp_plan);
        int indexOf3 = string2.indexOf("#start#");
        int indexOf4 = string2.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append((CharSequence) string2.replace("#start#", "").replace("#end#", ""));
        AnonymousClass5 r1 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass5 */

            public final void onClick(View view) {
                fbs.O000000o(new fbt(CTAActivity2rd.this.f4193O000000o, "/userCenter/UsrExpPlanActivity"));
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#FF527ACC"));
                textPaint.setUnderlineText(false);
            }
        };
        if (indexOf3 > 0 && indexOf4 > 0) {
            try {
                spannableStringBuilder2.setSpan(r1, indexOf3, indexOf4, 33);
            } catch (Exception unused2) {
            }
        }
        if (ftn.O00000oO((ServerBean) null)) {
            findViewById(R.id.disclaim_content1).setVisibility(8);
            findViewById(R.id.disclaim_content1).setVisibility(0);
            findViewById(R.id.remember_container).setVisibility(8);
            findViewById(R.id.remember_container2).setVisibility(0);
            findViewById(R.id.remember_container3).setVisibility(0);
            final ImageView imageView = (ImageView) findViewById(R.id.remember2);
            final ImageView imageView2 = (ImageView) findViewById(R.id.remember3);
            imageView.setSelected(true);
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass13 */

                public final void onClick(View view) {
                    ImageView imageView = imageView;
                    imageView.setSelected(!imageView.isSelected());
                    if (!imageView2.isSelected() || !imageView.isSelected()) {
                        CTAActivity2rd.this.O00000oo.setEnabled(false);
                        CTAActivity2rd.this.O00000oo.setTextColor(CTAActivity2rd.this.getResources().getColor(R.color.mj_color_gray_normal));
                        return;
                    }
                    CTAActivity2rd.this.O00000oo.setEnabled(true);
                    CTAActivity2rd.this.O00000oo.setTextColor(CTAActivity2rd.this.getResources().getColor(R.color.mj_color_green_normal));
                }
            });
            String string3 = getString(R.string.disclaim_join_user_exp_plan2);
            int indexOf5 = string3.indexOf("#start#");
            int indexOf6 = string3.indexOf("#end#") - 7;
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
            spannableStringBuilder3.append((CharSequence) string3.replace("#start#", "").replace("#end#", ""));
            AnonymousClass14 r2 = new ClickableSpan() {
                /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass14 */

                public final void onClick(View view) {
                    eyk.O000000o(CTAActivity2rd.this, CTAActivity2rd.this.getUrlByTpye("userLicense"));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(Color.parseColor("#FF527ACC"));
                    textPaint.setUnderlineText(false);
                }
            };
            if (indexOf5 >= 0 && indexOf6 > 0) {
                try {
                    spannableStringBuilder3.setSpan(r2, indexOf5, indexOf6, 33);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            TextView textView2 = (TextView) findViewById(R.id.join_usr_exp_plan_tv2);
            textView2.setText(spannableStringBuilder3);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            imageView2.setSelected(true);
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass15 */

                public final void onClick(View view) {
                    ImageView imageView = imageView2;
                    imageView.setSelected(!imageView.isSelected());
                    if (!imageView2.isSelected() || !imageView.isSelected()) {
                        CTAActivity2rd.this.O00000oo.setEnabled(false);
                        CTAActivity2rd.this.O00000oo.setTextColor(CTAActivity2rd.this.getResources().getColor(R.color.mj_color_gray_normal));
                        return;
                    }
                    CTAActivity2rd.this.O00000oo.setEnabled(true);
                    CTAActivity2rd.this.O00000oo.setTextColor(CTAActivity2rd.this.getResources().getColor(R.color.mj_color_green_normal));
                }
            });
            String string4 = getString(R.string.disclaim_join_user_exp_plan3);
            int indexOf7 = string4.indexOf("#start#");
            int indexOf8 = string4.indexOf("#end#") - 7;
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder();
            spannableStringBuilder4.append((CharSequence) string4.replace("#start#", "").replace("#end#", ""));
            AnonymousClass16 r0 = new ClickableSpan() {
                /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass16 */

                public final void onClick(View view) {
                    eyk.O000000o(CTAActivity2rd.this, CTAActivity2rd.this.getUrlByTpye("userPrivacy"));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(Color.parseColor("#FF527ACC"));
                    textPaint.setUnderlineText(false);
                }
            };
            if (indexOf7 >= 0 && indexOf8 > 0) {
                try {
                    spannableStringBuilder4.setSpan(r0, indexOf7, indexOf8, 33);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            TextView textView3 = (TextView) findViewById(R.id.join_usr_exp_plan_tv3);
            textView3.setText(spannableStringBuilder4);
            textView3.setMovementMethod(LinkMovementMethod.getInstance());
            this.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass17 */

                public final void onClick(View view) {
                    CTAActivity2rd.this.O00000o.setSelected(!CTAActivity2rd.this.O00000o.isSelected());
                }
            });
            this.O00000o.setSelected(true);
            String string5 = getString(R.string.disclaim_join_user_exp_plan1);
            int indexOf9 = string5.indexOf("#start#");
            int indexOf10 = string5.indexOf("#end#") - 7;
            SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder();
            spannableStringBuilder5.append((CharSequence) string5.replace("#start#", "").replace("#end#", ""));
            AnonymousClass2 r02 = new ClickableSpan() {
                /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass2 */

                public final void onClick(View view) {
                    fbs.O000000o(new fbt(CTAActivity2rd.this.f4193O000000o, "/userCenter/UsrExpPlanActivity"));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(Color.parseColor("#FF527ACC"));
                    textPaint.setUnderlineText(false);
                }
            };
            if (indexOf9 >= 0 && indexOf10 > 0) {
                try {
                    spannableStringBuilder5.setSpan(r02, indexOf9, indexOf10, 33);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        findViewById(R.id.remember).setVisibility(8);
        findViewById(R.id.remember3).setVisibility(8);
        findViewById(R.id.remember2).setVisibility(8);
        this.O00000oO = (TextView) findViewById(R.id.cancel);
        this.O00000oO.setText((int) R.string.family_reject);
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass11 */

            public final void onClick(View view) {
                CTAActivity2rd.this.doCancel();
            }
        });
        this.O00000oo = (TextView) findViewById(R.id.ok);
        this.O00000oo.setText((int) R.string.license_positive_btn);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass12 */

            public final void onClick(View view) {
                CTAActivity2rd.this.doOK();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        gqf.O000000o();
        ServiceApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass6 */

            public final void run() {
                CoreApi.O000000o().O0000Oo0();
            }
        });
    }

    public void onBackPressed() {
        try {
            doCancel();
            super.onBackPressed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fsl.O000000o(android.content.Context, boolean):void
     arg types: [android.content.Context, int]
     candidates:
      _m_j.fsl.O000000o(android.content.Context, java.lang.String):boolean
      _m_j.fsl.O000000o(android.content.Context, boolean):void */
    public void doOK() {
        CoreApi.O000000o().O000000o(this.f4193O000000o, new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass7 */

            public final void onCoreReady() {
                CoreApi.O000000o().O00000Oo((fsm<Void, fso>) null);
            }
        });
        fsl.O000000o(getApplicationContext(), true);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass8 */

            public final void run() {
                CTAActivity2rd.this.finish();
                CTAActivity2rd.this.overridePendingTransition(R.anim.base_anim_no, R.anim.base_anim_no);
            }
        }, 50);
        ft O000000o2 = ft.O000000o(this.f4193O000000o);
        Intent intent = new Intent("action_disclaim_local_broadcast_complete");
        intent.putExtra("param_key", 1);
        O000000o2.O000000o(intent);
        OneTrack.setDisable(ftn.O0000O0o(this));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fsl.O000000o(android.content.Context, boolean):void
     arg types: [android.content.Context, int]
     candidates:
      _m_j.fsl.O000000o(android.content.Context, java.lang.String):boolean
      _m_j.fsl.O000000o(android.content.Context, boolean):void */
    public void doCancel() {
        fsl.O000000o(getApplicationContext(), false);
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            decorView.setVisibility(8);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity2rd.AnonymousClass9 */

            public final void run() {
                CTAActivity2rd.this.finish();
                CTAActivity2rd.this.overridePendingTransition(R.anim.base_anim_no, R.anim.base_anim_no);
            }
        }, 50);
        overridePendingTransition(R.anim.base_anim_no, R.anim.base_anim_no);
        ft O000000o2 = ft.O000000o(this.f4193O000000o);
        Intent intent = new Intent("action_disclaim_local_broadcast_complete");
        intent.putExtra("param_key", 1);
        O000000o2.O000000o(intent);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 17) {
            Context appContext = ServiceApplication.getAppContext();
            if (appContext == null) {
                locale = gwc.O00000Oo();
            } else {
                Locale locale2 = null;
                SharedPreferences sharedPreferences = appContext.getSharedPreferences("com.xiaomi.smarthome.globaldynamicsetting", 0);
                String O00000Oo2 = gpy.O00000Oo(sharedPreferences, "locale_language", "");
                String O00000Oo3 = gpy.O00000Oo(sharedPreferences, "locale_country", "");
                if (!TextUtils.isEmpty(O00000Oo2) && !TextUtils.isEmpty(O00000Oo3)) {
                    locale2 = new Locale(O00000Oo2, O00000Oo3);
                }
                locale = locale2;
                if (locale == null) {
                    locale = gwc.O00000Oo();
                }
            }
            boolean O000000o2 = gwc.O000000o(context);
            if (gwc.O0000o0.contains(gwc.O00000Oo())) {
                if (O000000o2) {
                    locale = gwc.O0000Oo;
                } else if (gwc.O000000o(Locale.US, locale)) {
                    locale = gwc.O0000Oo;
                }
            } else if (gwc.O000000o(gwc.O0000Oo, locale)) {
                if (O000000o2) {
                    locale = gwc.O00000Oo();
                } else {
                    locale = Locale.US;
                }
            }
            context = gwc.O000000o(context, locale);
        }
        super.attachBaseContext(context);
    }

    public String getUrlByTpye(String str) {
        Locale O0000O0o = fju.O000000o().O0000O0o();
        if (O0000O0o == null) {
            O0000O0o = Locale.getDefault();
        }
        String O000000o2 = flk.O000000o(O0000O0o);
        return "https://g.home.mi.com/views/user-terms.html?locale=" + O000000o2 + "&type=" + str;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hyy.O000000o(this, configuration);
    }
}
