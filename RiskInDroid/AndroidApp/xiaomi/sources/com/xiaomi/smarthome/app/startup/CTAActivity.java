package com.xiaomi.smarthome.app.startup;

import _m_j.eyk;
import _m_j.ezz;
import _m_j.fju;
import _m_j.flk;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.gpc;
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
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.Locale;

public class CTAActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4184O000000o;
    View O00000Oo;
    TextView O00000o;
    TextView O00000o0;
    TextView O00000oO;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        ezz.O000000o(getWindow());
        hyy.O000000o(this);
        this.f4184O000000o = this;
        setContentView((int) R.layout.cta_activity);
        this.O00000Oo = findViewById(R.id.empty);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity.AnonymousClass1 */

            public final void onClick(View view) {
            }
        });
        this.O00000o0 = (TextView) findViewById(R.id.disclaim_content);
        TextView textView = (TextView) findViewById(R.id.title);
        String string = getString(R.string.disclaimers_content);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("type", 2);
        String stringExtra = intent.getStringExtra("msg");
        String stringExtra2 = intent.getStringExtra("title");
        final boolean booleanExtra = intent.getBooleanExtra("statis", true);
        if (!TextUtils.isEmpty(stringExtra)) {
            string = stringExtra;
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            textView.setText(stringExtra2);
        }
        this.O00000o0.setText(string);
        this.O00000o0.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView2 = (TextView) findViewById(R.id.disclaim_content1);
        textView2.setVisibility(0);
        String string2 = getString(R.string.disclaimers_join_user_exp_plan);
        int indexOf = string2.indexOf("#start#");
        int indexOf2 = string2.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String replace = string2.replace("#start#", "").replace("#end#", "");
        int indexOf3 = replace.indexOf("#start1#");
        int indexOf4 = replace.indexOf("#end1#") - 8;
        spannableStringBuilder.append((CharSequence) replace.replace("#start1#", "").replace("#end1#", ""));
        AnonymousClass4 r3 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity.AnonymousClass4 */

            public final void onClick(View view) {
                eyk.O000000o(CTAActivity.this, CTAActivity.this.getUrlByTpye("userLicense"));
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#FF527ACC"));
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass5 r4 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity.AnonymousClass5 */

            public final void onClick(View view) {
                eyk.O000000o(CTAActivity.this, CTAActivity.this.getUrlByTpye("userPrivacy"));
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#FF527ACC"));
                textPaint.setUnderlineText(false);
            }
        };
        if (indexOf >= 0 && indexOf2 > 0) {
            try {
                spannableStringBuilder.setSpan(r3, indexOf, indexOf2, 33);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (indexOf3 >= 0 && indexOf4 > 0) {
            try {
                spannableStringBuilder.setSpan(r4, indexOf3, indexOf4, 33);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        textView2.setText(spannableStringBuilder);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        this.O00000o = (TextView) findViewById(R.id.cancel);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity.AnonymousClass2 */

            public final void onClick(View view) {
                CTAActivity.this.doCancel();
            }
        });
        this.O00000oO = (TextView) findViewById(R.id.ok);
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity.AnonymousClass3 */

            public final void onClick(View view) {
                CTAActivity.this.doOK(booleanExtra);
            }
        });
        if (intExtra == 0) {
            finish();
        } else if (intExtra == 1) {
            this.O00000o.setVisibility(8);
            this.O00000oO.setVisibility(0);
            this.O00000oO.setText((int) R.string.knows_already_tips);
        } else {
            this.O00000o.setVisibility(0);
            this.O00000oO.setVisibility(0);
            this.O00000o.setText((int) R.string.disclaim_cancel);
            this.O00000oO.setText((int) R.string.disclaim_confirm);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        gqf.O000000o();
        ServiceApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity.AnonymousClass6 */

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
    public void doOK(final boolean z) {
        CoreApi.O000000o().O000000o(this.f4184O000000o, new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity.AnonymousClass7 */

            public final void onCoreReady() {
                if (!z) {
                    Intent intent = new Intent("action_disclaim_local_broadcast_complete");
                    intent.putExtra("param_key", 1);
                    ft.O000000o(CTAActivity.this.f4184O000000o).O000000o(intent);
                }
                CoreApi.O000000o().O00000Oo((fsm<Void, fso>) null);
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.app.startup.CTAActivity.AnonymousClass8 */

            public final void run() {
                CTAActivity.this.finish();
                CTAActivity.this.overridePendingTransition(R.anim.base_anim_no, R.anim.base_anim_no);
            }
        }, 50);
        if (z) {
            Intent intent = new Intent(this, CTAActivity2rd.class);
            intent.putExtra("init", false);
            startActivity(intent);
            overridePendingTransition(R.anim.base_anim_no, R.anim.base_anim_no);
        }
    }

    public void doCancel() {
        finish();
        overridePendingTransition(R.anim.base_anim_no, R.anim.base_anim_no);
        ft O000000o2 = ft.O000000o(this.f4184O000000o);
        Intent intent = new Intent("action_disclaim_local_broadcast_complete");
        intent.putExtra("param_key", 2);
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
