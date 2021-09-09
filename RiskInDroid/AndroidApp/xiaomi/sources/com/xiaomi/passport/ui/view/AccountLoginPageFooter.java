package com.xiaomi.passport.ui.view;

import _m_j.egt;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountLoginPageFooter extends FrameLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public CheckBox f6327O000000o;
    public TextView O00000Oo;
    private View O00000o;
    public O000000o O00000o0;
    private View O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private View O0000OOo;
    private boolean O0000Oo;
    private View O0000Oo0;

    public interface O000000o {
        void onSnsFacebookClicked(View view);

        void onSnsGoogleClicked(View view);

        void onSnsQqClicked(View view);

        void onSnsWechatClicked(View view);

        void onSnsWeiboClicked(View view);

        void onUserAgreementLinkClicked(View view, String str);
    }

    public AccountLoginPageFooter(Context context) {
        super(context);
        O000000o(context);
    }

    public AccountLoginPageFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public AccountLoginPageFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.passport_layout_account_login_page_footer, this);
        this.f6327O000000o = (CheckBox) findViewById(R$id.footer_user_agreement_checkbox);
        this.O00000Oo = (TextView) findViewById(R$id.footer_user_agreement_hint);
        this.O00000o = findViewById(R$id.footer_sns_list_container);
        this.O00000oO = findViewById(R$id.footer_sns_facebook);
        this.O00000oO.setOnClickListener(this);
        this.O00000oo = findViewById(R$id.footer_sns_google);
        this.O00000oo.setOnClickListener(this);
        this.O0000O0o = findViewById(R$id.footer_sns_weibo);
        this.O0000O0o.setOnClickListener(this);
        this.O0000OOo = findViewById(R$id.footer_sns_qq);
        this.O0000OOo.setOnClickListener(this);
        this.O0000Oo0 = findViewById(R$id.footer_sns_wechat);
        this.O0000Oo0.setOnClickListener(this);
    }

    public void setOnActionClickListener(O000000o o000000o) {
        this.O00000o0 = o000000o;
    }

    public void onClick(View view) {
        if (this.O00000o0 != null) {
            int id = view.getId();
            if (id == R$id.footer_sns_facebook) {
                this.O00000o0.onSnsFacebookClicked(view);
            } else if (id == R$id.footer_sns_google) {
                this.O00000o0.onSnsGoogleClicked(view);
            } else if (id == R$id.footer_sns_qq) {
                this.O00000o0.onSnsQqClicked(view);
            } else if (id == R$id.footer_sns_weibo) {
                this.O00000o0.onSnsWeiboClicked(view);
            } else if (id == R$id.footer_sns_wechat) {
                this.O00000o0.onSnsWechatClicked(view);
            } else {
                throw new IllegalStateException("unknown id ".concat(String.valueOf(id)));
            }
        }
    }

    public final void O000000o(boolean z) {
        int i = 0;
        setVisibility(0);
        View view = this.O00000o;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        O000000o();
    }

    private void O000000o() {
        if (!this.O0000Oo) {
            this.O00000o.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("FACEBOOK_AUTH_PROVIDER", this.O00000oO));
        arrayList.add(new Pair("GOOGLE_AUTH_PROVIDER", this.O00000oo));
        arrayList.add(new Pair("WEIBO_AUTH_PROVIDER", this.O0000O0o));
        arrayList.add(new Pair("QQ_AUTH_PROVIDER", this.O0000OOo));
        arrayList.add(new Pair("WECHAT_AUTH_PROVIDER", this.O0000Oo0));
        egt egt = egt.f15254O000000o;
        List<String> O00000Oo2 = egt.O00000Oo();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (pair.second == null) {
                it.remove();
            } else {
                egt egt2 = egt.f15254O000000o;
                if (egt.O000000o((String) pair.first) == null || O00000Oo2.contains(pair.first)) {
                    ((View) pair.second).setVisibility(8);
                    it.remove();
                } else {
                    ((View) pair.second).setVisibility(0);
                }
            }
        }
        if (arrayList.isEmpty()) {
            this.O00000o.setVisibility(8);
        } else {
            this.O00000o.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public void onGlobalLayout() {
        View findViewById = getRootView().findViewById(16908290);
        if (findViewById.getRootView().getHeight() - findViewById.getHeight() >= findViewById.getRootView().getHeight() / 4) {
            this.O0000Oo = false;
        } else {
            this.O0000Oo = true;
        }
        O000000o();
    }
}
