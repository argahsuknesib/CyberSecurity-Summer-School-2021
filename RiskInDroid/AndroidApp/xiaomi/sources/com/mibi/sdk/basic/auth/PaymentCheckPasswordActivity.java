package com.mibi.sdk.basic.auth;

import _m_j.cet;
import _m_j.ceu;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.component.KeyboardManager;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.widget.ProgressButton;
import com.xiaomi.smarthome.R;

public class PaymentCheckPasswordActivity extends BaseMvpActivity implements cet.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ProgressButton f5105O000000o;
    /* access modifiers changed from: private */
    public TextView O00000Oo;
    private TextView O00000o;
    /* access modifiers changed from: private */
    public EditText O00000o0;
    /* access modifiers changed from: private */
    public View O00000oO;
    private KeyboardManager O00000oo;
    private ProgressButton.IOnClickListener O0000O0o = new ProgressButton.IOnClickListener() {
        /* class com.mibi.sdk.basic.auth.PaymentCheckPasswordActivity.AnonymousClass1 */

        public final void onClick(View view) {
            String obj = PaymentCheckPasswordActivity.this.O00000o0.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                PaymentCheckPasswordActivity paymentCheckPasswordActivity = PaymentCheckPasswordActivity.this;
                paymentCheckPasswordActivity.a(paymentCheckPasswordActivity.getString(R.string.mibi_password_error), (Throwable) null);
                return;
            }
            PaymentCheckPasswordActivity.this.f5105O000000o.startProgress();
            PaymentCheckPasswordActivity.this.O00000Oo.setVisibility(4);
            ((cet.O000000o) PaymentCheckPasswordActivity.this.getPresenter()).O000000o(PaymentCheckPasswordActivity.this, PaymentCheckPasswordActivity.this.mSession.getUserId(), obj);
        }
    };
    private View.OnClickListener O0000OOo = new View.OnClickListener() {
        /* class com.mibi.sdk.basic.auth.PaymentCheckPasswordActivity.AnonymousClass2 */

        public final void onClick(View view) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(CommonConstants.getAccountBaseUrl("/forgetPassword")));
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.addFlags(8388608);
            PaymentCheckPasswordActivity.this.startActivity(intent);
        }
    };

    public IPresenter onCreatePresenter() {
        return new ceu(cet.O00000Oo.class);
    }

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        setContentView((int) R.layout.mibi_payment_check_password);
        this.O00000oO = findViewById(R.id.dialog);
        this.O00000Oo = (TextView) findViewById(R.id.error_info);
        this.O00000o0 = (EditText) findViewById(R.id.password_edit);
        this.O00000o = (TextView) findViewById(R.id.password_forget);
        this.O00000o.setOnClickListener(this.O0000OOo);
        this.f5105O000000o = (ProgressButton) findViewById(R.id.button_pay);
        this.f5105O000000o.setClickListener(this.O0000O0o);
        this.O00000oo = KeyboardManager.get(getWindow().getDecorView(), new O000000o(this, (byte) 0));
    }

    class O000000o implements KeyboardManager.IKeyboardChangedListener {
        private boolean O00000Oo;
        private int O00000o0;

        private O000000o() {
        }

        /* synthetic */ O000000o(PaymentCheckPasswordActivity paymentCheckPasswordActivity, byte b) {
            this();
        }

        public final void onKeyboardStateChanged(boolean z, int i) {
            if (this.O00000o0 == 0 && i > 0) {
                this.O00000o0 = i;
            }
            if (this.O00000Oo != z) {
                if (!z) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-this.O00000o0), 0.0f);
                    translateAnimation.setDuration(450);
                    translateAnimation.setInterpolator(new AccelerateInterpolator());
                    translateAnimation.setFillAfter(false);
                    translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.mibi.sdk.basic.auth.PaymentCheckPasswordActivity.O000000o.AnonymousClass1 */

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationStart(Animation animation) {
                            PaymentCheckPasswordActivity.this.O00000oO.setVisibility(4);
                        }

                        public final void onAnimationEnd(Animation animation) {
                            PaymentCheckPasswordActivity.this.O00000oO.setVisibility(0);
                        }
                    });
                    PaymentCheckPasswordActivity.this.O00000oO.startAnimation(translateAnimation);
                }
                this.O00000Oo = z;
            }
        }
    }

    public void a(int i, String str) {
        Log.d("PaymentCheckPwd", "showLoginAccountError : ".concat(String.valueOf(i)));
        this.f5105O000000o.stopProgress();
        if (i == 3) {
            this.O00000o.setVisibility(0);
        } else {
            this.O00000o.setVisibility(8);
        }
    }

    public void a() {
        Log.d("PaymentCheckPwd", "showProcessExpired");
        this.f5105O000000o.stopProgress();
    }

    public void b() {
        Log.d("PaymentCheckPwd", "showAccountFrozen");
        this.f5105O000000o.stopProgress();
        setResult(9);
        finish();
    }

    public void c() {
        Log.d("PaymentCheckPwd", "showPasswordError");
        this.f5105O000000o.stopProgress();
        this.O00000o.setVisibility(0);
        this.O00000Oo.setVisibility(0);
        this.O00000Oo.setText((int) R.string.mibi_password_error);
    }

    public void a(Bundle bundle) {
        Log.d("PaymentCheckPwd", "handleRiskResultReturn");
        this.f5105O000000o.stopProgress();
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(1104, intent);
        finish();
    }

    public void d() {
        Log.d("PaymentCheckPwd", "handleCheckAuthSuccess");
        this.f5105O000000o.stopProgress();
        setResult(-1, null);
        finish();
    }

    public void e() {
        Log.d("PaymentCheckPwd", "handleUserCanceled");
        this.f5105O000000o.stopProgress();
    }

    public boolean handleBackPressed() {
        Log.d("PaymentCheckPwd", "onBackPressed");
        setResult(9803, EntryResultUtils.makeResult(9803, "check password canceled by user"));
        return true;
    }

    public void a(String str, Throwable th) {
        this.O00000Oo.setVisibility(0);
        this.O00000Oo.setText(str);
    }

    public void onDestroy() {
        super.onDestroy();
        KeyboardManager keyboardManager = this.O00000oo;
        if (keyboardManager != null) {
            keyboardManager.release();
        }
    }
}
