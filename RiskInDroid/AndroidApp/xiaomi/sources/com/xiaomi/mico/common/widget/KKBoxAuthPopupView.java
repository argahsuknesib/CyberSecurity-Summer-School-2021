package com.xiaomi.mico.common.widget;

import _m_j.jgc;
import _m_j.jgi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.application.AreaCode;
import com.xiaomi.mico.common.event.KKBoxAuthEvent;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.dialog.MLAlertDialog2;
import com.xiaomi.mico.tool.embedded.activity.CommonWebActivity;
import com.xiaomi.mico.tool.embedded.activity.oauth.KKBoxApi;
import com.xiaomi.smarthome.R;
import java.util.Date;
import org.greenrobot.eventbus.ThreadMode;

public class KKBoxAuthPopupView extends LinearLayout {
    private Boolean expired;
    TextView loginBtn;
    private MLAlertDialog2 mDialog;

    public KKBoxAuthPopupView(Context context) {
        super(context);
    }

    public KKBoxAuthPopupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KKBoxAuthPopupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        this.loginBtn = (TextView) findViewById(R.id.btn_login);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$KKBoxAuthPopupView$mrJ_i7cK7fXZLjLUaG0yQmpa4w */

            public final void onClick(View view) {
                KKBoxAuthPopupView.this.lambda$onFinishInflate$0$KKBoxAuthPopupView(view);
            }
        });
        findViewById(R.id.btn_switch_location_cn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$KKBoxAuthPopupView$n5P3rNiEQ9c0CSz8aFXmJK5B6W0 */

            public final void onClick(View view) {
                KKBoxAuthPopupView.this.lambda$onFinishInflate$1$KKBoxAuthPopupView(view);
            }
        });
    }

    public void setDialog(MLAlertDialog2 mLAlertDialog2) {
        this.mDialog = mLAlertDialog2;
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiaomi.mico.common.widget.KKBoxAuthPopupView.AnonymousClass1 */

            public void onDismiss(DialogInterface dialogInterface) {
            }
        });
        jgc.O000000o().O000000o(this);
    }

    /* renamed from: onViewClicked */
    public void lambda$onFinishInflate$1$KKBoxAuthPopupView(View view) {
        int id = view.getId();
        if (id == R.id.btn_login) {
            showOauthView();
        } else if (id == R.id.btn_switch_location_cn) {
            dismiss();
        }
    }

    private void switchLocationCN(String str) {
        AreaCode.setLocation(str);
        jgc.O000000o().O00000o(new MicoEvent.AccountLogout());
    }

    private void showOauthView() {
        ((Activity) getContext()).startActivityForResult(CommonWebActivity.buildIntent(getContext(), getContext().getString(R.string.setting_oauth), Uri.parse("https://i.ai.mi.com/skills/account_link").buildUpon().appendQueryParameter("provider_id", "347442676548767744").appendQueryParameter("callback_url", "mico://oauth/oauth2/common").build().toString(), false), 1102);
    }

    public static void showAuthAlert(Context context) {
        KKBoxAuthPopupView kKBoxAuthPopupView = (KKBoxAuthPopupView) LayoutInflater.from(context).inflate((int) R.layout.popup_view_kkbox_auth, (ViewGroup) null);
        MLAlertDialog2 create = new MLAlertDialog2.Builder(context).setView(kKBoxAuthPopupView).create();
        create.setCanceledOnTouchOutside(true);
        kKBoxAuthPopupView.setDialog(create);
        create.show();
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onKKBoxAuthEvent(KKBoxAuthEvent kKBoxAuthEvent) {
        if (kKBoxAuthEvent.success) {
            ToastUtil.showToast((int) R.string.skill_auth_done);
            getAuthInfo(KKBoxApi.instance().getProviderId());
            dismiss();
            return;
        }
        ToastUtil.showToast((int) R.string.error_oauth_error);
    }

    private void dismiss() {
        MLAlertDialog2 mLAlertDialog2 = this.mDialog;
        if (mLAlertDialog2 != null && mLAlertDialog2.isShowing()) {
            this.mDialog.dismiss();
            unregist();
            this.mDialog = null;
        }
    }

    public static void checkKKBoxOAuthStatus(final Context context, final Runnable runnable) {
        AccountProfile.current().syncQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
            /* class com.xiaomi.mico.common.widget.KKBoxAuthPopupView.AnonymousClass2 */

            public final void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                if (!AccountProfile.current().isKKBoxAuthValid()) {
                    KKBoxAuthPopupView.showAuthAlert(context);
                } else {
                    runnable.run();
                }
            }

            public final void onFailure(ApiError apiError) {
                new Object[1][0] = apiError;
            }
        });
    }

    private void unregist() {
        jgc.O000000o().O00000o0(this);
    }

    public void getAuthInfo(String str) {
        ApiHelper.getOAuthInfo(str, new ApiRequest.Listener<MiBrain.OAuthInfo>() {
            /* class com.xiaomi.mico.common.widget.KKBoxAuthPopupView.AnonymousClass3 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(MiBrain.OAuthInfo oAuthInfo) {
                MiBrain.CPBindStatus cPBindStatus = new MiBrain.CPBindStatus();
                cPBindStatus.expireStatus = oAuthInfo.state;
                cPBindStatus.providerName = oAuthInfo.providerName;
                long time = (oAuthInfo.expireAt - new Date().getTime()) / 1000;
                if (time > 0) {
                    cPBindStatus.expiresIn = (int) time;
                }
                if (cPBindStatus.isBinded()) {
                    AccountProfile.current().setKkboxBindStatus(cPBindStatus);
                }
            }
        });
    }
}
