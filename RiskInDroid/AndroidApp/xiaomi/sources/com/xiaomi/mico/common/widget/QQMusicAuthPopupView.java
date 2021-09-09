package com.xiaomi.mico.common.widget;

import _m_j.bnj;
import _m_j.dka;
import _m_j.ee;
import _m_j.gqd;
import _m_j.gsy;
import _m_j.iai;
import _m_j.jgc;
import _m_j.jgi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.event.QQAuthEvent;
import com.xiaomi.mico.common.util.SystemUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.QQMusicAuthDelegate;
import com.xiaomi.mico.common.widget.dialog.MLAlertDialog2;
import com.xiaomi.mico.setting.QQMusicSuccessActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
import rx.functions.Action1;

public class QQMusicAuthPopupView extends RelativeLayout implements QQMusicAuthDelegate.QQMusicAuthListener {
    /* access modifiers changed from: private */
    public static QQMusicAuthPopupView popupView;
    TextView bindHint;
    private MLAlertDialog2 mDialog;
    private dka mTencent;
    TextView qqBtn;
    View qqMusicBtn;
    private XQProgressDialog vLoadingDialog;
    TextView wxBtn;

    public QQMusicAuthPopupView(Context context) {
        super(context);
    }

    public QQMusicAuthPopupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QQMusicAuthPopupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.bindHint = (TextView) findViewById(R.id.bind_hint);
        this.qqBtn = (TextView) findViewById(R.id.qq_btn);
        this.wxBtn = (TextView) findViewById(R.id.weixin_btn);
        this.qqMusicBtn = findViewById(R.id.qq_music_btn);
        findViewById(R.id.qq_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$QQMusicAuthPopupView$eChRMzHHWPVGeUzjR1VXzYsdG2o */

            public final void onClick(View view) {
                QQMusicAuthPopupView.this.lambda$onFinishInflate$0$QQMusicAuthPopupView(view);
            }
        });
        findViewById(R.id.weixin_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$QQMusicAuthPopupView$e2MqNbeK4FjQoRZZ7XX6fRSn6NU */

            public final void onClick(View view) {
                QQMusicAuthPopupView.this.lambda$onFinishInflate$1$QQMusicAuthPopupView(view);
            }
        });
        findViewById(R.id.skip_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$QQMusicAuthPopupView$yVdTGK5swR2imcXAI_CRRc0iVw */

            public final void onClick(View view) {
                QQMusicAuthPopupView.this.lambda$onFinishInflate$2$QQMusicAuthPopupView(view);
            }
        });
        bnj.O000000o(this.qqMusicBtn).throttleFirst(2500, TimeUnit.MILLISECONDS).subscribe(new Action1() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$QQMusicAuthPopupView$yU0I282g7fndKvlVXVFT8NHxeck */

            public final void call(Object obj) {
                QQMusicAuthPopupView.this.lambda$onFinishInflate$3$QQMusicAuthPopupView((Void) obj);
            }
        });
    }

    public /* synthetic */ void lambda$onFinishInflate$3$QQMusicAuthPopupView(Void voidR) {
        doQqMusicAuth();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addLifeListener();
    }

    private void addLifeListener() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            getLifeListenerFragment(activity.getSupportFragmentManager()).addLifeListener(QQMusicAuthDelegate.getInstance());
        }
    }

    private LifeListenerFragment getLifeListenerFragment(ee eeVar) {
        LifeListenerFragment lifeListenerFragment = (LifeListenerFragment) eeVar.O000000o("LifeListenerFragment");
        if (lifeListenerFragment != null) {
            return lifeListenerFragment;
        }
        LifeListenerFragment lifeListenerFragment2 = new LifeListenerFragment();
        eeVar.O000000o().O000000o(lifeListenerFragment2, "LifeListenerFragment").O00000o0();
        return lifeListenerFragment2;
    }

    private FragmentActivity getActivity() {
        View view = this;
        do {
            Context context = view.getContext();
            if (context instanceof FragmentActivity) {
                return (FragmentActivity) context;
            }
            view = (View) view.getParent();
        } while (view != null);
        return null;
    }

    public void setReauthUI(boolean z) {
        if (z) {
            this.bindHint.setText((int) R.string.qq_music_reauth_hint);
        } else {
            this.bindHint.setText((int) R.string.qq_music_willexire_reauth_hint);
        }
    }

    public void setDialog(MLAlertDialog2 mLAlertDialog2) {
        this.mDialog = mLAlertDialog2;
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$QQMusicAuthPopupView$_r1bLOooNg0Trld5rjJ8C8UjPsg */

            public final void onDismiss(DialogInterface dialogInterface) {
                QQMusicAuthPopupView.this.lambda$setDialog$4$QQMusicAuthPopupView(dialogInterface);
            }
        });
        this.mDialog.setOnKeyListener($$Lambda$QQMusicAuthPopupView$gFk4K9F5OngRTx8XX9nJSSFpkM.INSTANCE);
        jgc.O000000o().O000000o(this);
        this.mTencent = dka.O000000o("101410142", CommonApplication.getAppContext());
    }

    public /* synthetic */ void lambda$setDialog$4$QQMusicAuthPopupView(DialogInterface dialogInterface) {
        unregist();
    }

    static /* synthetic */ boolean lambda$setDialog$5(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            ToastUtil.showToast((int) R.string.qq_music_login_tip);
        }
        return false;
    }

    /* renamed from: onViewClicked */
    public void lambda$onFinishInflate$2$QQMusicAuthPopupView(View view) {
        if (view.getId() == R.id.qq_music_btn) {
            doQqMusicAuth();
        } else if (view.getId() == R.id.qq_btn) {
            if (!SystemUtil.isPackageInstalled(getContext(), "com.tencent.mobileqq")) {
                ToastUtil.showToast((int) R.string.error_qq_not_installed);
            } else {
                doAuth(2);
            }
        } else if (view.getId() == R.id.weixin_btn) {
            if (!MicoApplication.getInstance().getMicoHelperListener().getIWXAPI().isWXAppInstalled()) {
                ToastUtil.showToast((int) R.string.mico_error_weixin_not_installed);
            } else {
                doAuth(1);
            }
        } else if (view.getId() == R.id.skip_btn) {
            dismiss();
        }
    }

    private void doQqMusicAuth() {
        if (!SystemUtil.isPackageInstalled(getContext(), "com.tencent.qqmusic")) {
            showDownloadQQMusicHint();
        } else {
            doAuth(0);
        }
    }

    private void doAuth(int i) {
        QQMusicAuthDelegate.getInstance().init(getContext(), this);
        QQMusicAuthDelegate.getInstance().setAuthType(i);
        QQMusicAuthDelegate.getInstance().startAuth();
    }

    private static QQMusicAuthPopupView loadView(Context context) {
        return (QQMusicAuthPopupView) LayoutInflater.from(context).inflate((int) R.layout.popup_view_qq_music_auth_v2, (ViewGroup) null);
    }

    public static void showAuthAlert(Context context) {
        new Object[1][0] = "QQMusicAuthPopupView showAuthAlert";
        if (popupView != null) {
            new Object[1][0] = "QQMusicAuthPopupView is showing";
        }
        dismissPopupView();
        popupView = loadView(context);
        MLAlertDialog2 create = new MLAlertDialog2.Builder(context).setView(popupView, 0, 0, 0, 0).create();
        create.setCanceledOnTouchOutside(true);
        create.setOnDismissListener($$Lambda$QQMusicAuthPopupView$7W3imFdLLpCAeQl0kqRe4eneCUc.INSTANCE);
        popupView.setDialog(create);
        create.show();
    }

    public static void showReauthAlert(Context context, boolean z) {
        new Object[1][0] = "QQMusicAuthPopupView showReauthAlert";
        if (popupView != null) {
            new Object[1][0] = "QQMusicAuthPopupView is showing";
        }
        dismissPopupView();
        QQMusicAuthPopupView loadView = loadView(context);
        popupView = loadView;
        loadView.setReauthUI(z);
        MLAlertDialog2 create = new MLAlertDialog2.Builder(context).setView(popupView, 0, 0, 0, 0).create();
        create.setCanceledOnTouchOutside(true);
        create.setOnDismissListener($$Lambda$QQMusicAuthPopupView$6XIzM9X3GNlK1ASUeEVYCfRbHfo.INSTANCE);
        popupView.setDialog(create);
        create.show();
    }

    private static void dismissPopupView() {
        QQMusicAuthPopupView qQMusicAuthPopupView = popupView;
        if (qQMusicAuthPopupView != null) {
            qQMusicAuthPopupView.dismiss();
            popupView = null;
        }
    }

    public void dismiss() {
        MLAlertDialog2 mLAlertDialog2 = this.mDialog;
        if (mLAlertDialog2 != null && mLAlertDialog2.isShowing()) {
            try {
                this.mDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
            unregist();
            popupView = null;
            QQMusicAuthDelegate.getInstance().release();
        }
    }

    private void unregist() {
        jgc.O000000o().O00000o0(this);
    }

    public void showSuccessView() {
        getContext().startActivity(new Intent(getContext(), QQMusicSuccessActivity.class));
    }

    private void bindQQ(String str, long j, String str2) {
        ApiHelper.tencentQQBind(LoginManager.getInstance().getPassportInfo().getUserId(), str, j, str2, new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.common.widget.QQMusicAuthPopupView.AnonymousClass1 */

            public void onSuccess(String str) {
                QQMusicAuthPopupView.this.showSuccessView();
                AccountProfile.current().syncQQBindStatus();
                QQMusicAuthPopupView.this.dismiss();
            }

            public void onFailure(ApiError apiError) {
                ToastUtil.showToast((int) R.string.qq_music_account_bind_fail);
                QQMusicAuthPopupView.this.qqBtn.setEnabled(true);
            }
        }).bindToLifecycle((ApiRequest.ICleanQueue) getContext());
    }

    private void bindWechat(String str) {
        ApiHelper.tencentWechatBind(LoginManager.getInstance().getPassportInfo().getUserId(), str, new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.common.widget.QQMusicAuthPopupView.AnonymousClass2 */

            public void onSuccess(String str) {
                QQMusicAuthPopupView.this.showSuccessView();
                AccountProfile.current().syncQQBindStatus();
                QQMusicAuthPopupView.this.dismiss();
            }

            public void onFailure(ApiError apiError) {
                ToastUtil.showToast((int) R.string.qq_music_account_bind_fail);
                QQMusicAuthPopupView.this.wxBtn.setEnabled(true);
            }
        }).bindToLifecycle((ApiRequest.ICleanQueue) getContext());
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onWXAuthEvent(iai iai) {
        if (iai.f1091O000000o) {
            bindWechat(iai.O00000Oo);
            return;
        }
        this.wxBtn.setEnabled(true);
        ToastUtil.showToast((int) R.string.qq_music_account_bind_fail);
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onQQAuthEvent(QQAuthEvent qQAuthEvent) {
        if (!qQAuthEvent.success || qQAuthEvent.qqAuth == null) {
            this.qqBtn.setEnabled(true);
            ToastUtil.showToast((int) R.string.qq_music_account_bind_fail);
            return;
        }
        bindQQ(qQAuthEvent.qqAuth.accessToken, qQAuthEvent.qqAuth.expiresIn, qQAuthEvent.qqAuth.openid);
    }

    public static void checkQQBindStatus(final Context context) {
        AccountProfile.current().syncQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
            /* class com.xiaomi.mico.common.widget.QQMusicAuthPopupView.AnonymousClass3 */

            public final void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                if (AccountProfile.current().isQQAccountNotBinded()) {
                    QQMusicAuthPopupView.showAuthAlert(context);
                } else {
                    QQMusicAuthPopupView.showAuthAlert(context, cPBindStatus);
                }
            }

            public final void onFailure(ApiError apiError) {
                new Object[1][0] = apiError;
            }
        });
    }

    public static void showAuthAlert(Context context, MiBrain.CPBindStatus cPBindStatus) {
        if (cPBindStatus != null) {
            if ("expireSoon".equals(cPBindStatus.expireStatus)) {
                showReauthAlert(context, false);
                return;
            } else if ("expired".equals(cPBindStatus.expireStatus)) {
                showReauthAlert(context, true);
                return;
            } else if (!"notBind".equals(cPBindStatus.expireStatus)) {
                return;
            }
        }
        showAuthAlert(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QQMusicAuthDelegate.getInstance().release();
    }

    public void onQQMusicAuthStart() {
        showLoadingDialog();
    }

    public void onQQMusicAuthSuccess() {
        showSuccessView();
        AccountProfile.current().syncQQBindStatus();
        dismiss();
    }

    /* access modifiers changed from: protected */
    public void showLoadingDialog() {
        FragmentActivity activity = getActivity();
        if (activity != null && gqd.O000000o((Activity) activity)) {
            this.vLoadingDialog = new XQProgressDialog(getContext());
            this.vLoadingDialog.setMessage(getContext().getString(R.string.device_more_security_loading_operation));
            this.vLoadingDialog.show();
        }
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog = this.vLoadingDialog;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onGetApiService(QQMusicAuthDelegate.GetApiServiceEvent getApiServiceEvent) {
        dismissProgressDialog();
    }

    public void onQQMusicAuthFail(int i) {
        if (i == 1) {
            ToastUtil.showToast((int) R.string.qq_music_account_bind_fail_error);
        } else {
            ToastUtil.showToast((int) R.string.qq_music_account_bind_fail);
        }
        dismissProgressDialog();
        gsy.O00000Oo(12000, "12000.6.1", "");
    }

    private void showDownloadQQMusicHint() {
        new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.mico_common_hint).O00000Oo((int) R.string.not_install_qq_music_hint).O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$QQMusicAuthPopupView$Xf6FAJK_qjvk81wQSlfGsFo9Z7c */

            public final void onClick(DialogInterface dialogInterface, int i) {
                QQMusicAuthPopupView.this.lambda$showDownloadQQMusicHint$8$QQMusicAuthPopupView(dialogInterface, i);
            }
        }).O00000o().show();
    }

    public /* synthetic */ void lambda$showDownloadQQMusicHint$8$QQMusicAuthPopupView(DialogInterface dialogInterface, int i) {
        downloadQQMusic();
    }

    private void downloadQQMusic() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://y.qq.com/m/downqqmusic.html?channelId=10039399"));
        intent.addFlags(268435456);
        getContext().startActivity(intent);
    }
}
