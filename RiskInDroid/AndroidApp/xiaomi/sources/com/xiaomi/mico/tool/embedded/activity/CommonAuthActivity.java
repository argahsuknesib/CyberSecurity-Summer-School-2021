package com.xiaomi.mico.tool.embedded.activity;

import _m_j.ahh;
import _m_j.aul;
import _m_j.aum;
import _m_j.aun;
import _m_j.auo;
import _m_j.avc;
import _m_j.avd;
import _m_j.avh;
import _m_j.avi;
import _m_j.avj;
import _m_j.gsy;
import _m_j.jgc;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.httpclient.okhttp.OkHttpHttpClient;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiManager;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.api.model.SkillStore;
import com.xiaomi.mico.base.MicoBaseFragment;
import com.xiaomi.mico.common.event.DeDaoAuthEvent;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity;
import com.xiaomi.mico.tool.embedded.activity.SkillDetailActivity;
import com.xiaomi.mico.tool.embedded.activity.oauth.BaiduApi;
import com.xiaomi.mico.tool.embedded.activity.oauth.DedaoApi;
import com.xiaomi.mico.tool.embedded.activity.oauth.EvernoteApi;
import com.xiaomi.mico.tool.embedded.activity.oauth.KKBoxApi;
import com.xiaomi.mico.tool.embedded.activity.oauth.MIBrainOauthApi;
import com.xiaomi.smarthome.R;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class CommonAuthActivity extends SkillDetailActivity {

    enum OAuthType {
        OAUTH10,
        OAUTH20
    }

    /* access modifiers changed from: protected */
    public void addCustomFragment(SkillDetailActivity.ViewPagerAdapter viewPagerAdapter) {
        super.addCustomFragment(viewPagerAdapter);
        CommonOauthFragment commonOauthFragment = new CommonOauthFragment();
        commonOauthFragment.setArguments(getIntent().getExtras());
        viewPagerAdapter.addFragment(getString(R.string.skill_function_title), commonOauthFragment);
    }

    @Deprecated
    public static class CommonOauthFragment extends MicoBaseFragment {
        Button authBtn;
        View authHint;
        TextView bindHint;
        Button deleteBtn;
        private ApiRequest mGetAuthRequest;
        public PublishSubject<String> mOAuth10TokenSubject = PublishSubject.create();
        private PublishSubject<String> mOAuth20CodeSubject = PublishSubject.create();
        private avj mOAuthService;
        private OAuthType mOAuthType;
        public OAuth1RequestToken mOauthRequestToekn;
        public MIBrainOauthApi mProvider;

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate((int) R.layout.fragment_evernote, (ViewGroup) null);
            this.deleteBtn = (Button) inflate.findViewById(R.id.delete_btn);
            this.deleteBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$CommonAuthActivity$CommonOauthFragment$_yZAL7H2v64NkEEgkwPFFoK77o */

                public final void onClick(View view) {
                    CommonAuthActivity.CommonOauthFragment.this.lambda$onCreateView$0$CommonAuthActivity$CommonOauthFragment(view);
                }
            });
            this.authBtn = (Button) inflate.findViewById(R.id.auth_btn);
            this.authBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$CommonAuthActivity$CommonOauthFragment$rmv4MmvmlcOy3mx8AXTyUnBtv9g */

                public final void onClick(View view) {
                    CommonAuthActivity.CommonOauthFragment.this.lambda$onCreateView$1$CommonAuthActivity$CommonOauthFragment(view);
                }
            });
            this.authHint = inflate.findViewById(R.id.auth_hint);
            this.bindHint = (TextView) inflate.findViewById(R.id.bind_hint);
            String string = getArguments().getString("PROVIDER_ID");
            if (EvernoteApi.instance().getProviderId().equals(string)) {
                this.mProvider = EvernoteApi.instance();
            } else if (BaiduApi.instance().getProviderId().equals(string)) {
                this.mProvider = BaiduApi.instance();
            } else if (DedaoApi.instance().getProviderId().equals(string)) {
                this.mProvider = DedaoApi.instance();
            } else if (KKBoxApi.instance().getProviderId().equals(string)) {
                this.mProvider = KKBoxApi.instance();
            }
            MIBrainOauthApi mIBrainOauthApi = this.mProvider;
            if (mIBrainOauthApi != null) {
                this.bindHint.setText(mIBrainOauthApi.getBindHint());
                if (this.mProvider instanceof aun) {
                    this.mOAuthType = OAuthType.OAUTH10;
                } else {
                    this.mOAuthType = OAuthType.OAUTH20;
                }
            }
            return inflate;
        }

        public /* synthetic */ void lambda$onCreateView$0$CommonAuthActivity$CommonOauthFragment(View view) {
            onDeOauthBtnClick();
        }

        public /* synthetic */ void lambda$onCreateView$1$CommonAuthActivity$CommonOauthFragment(View view) {
            onViewClicked();
        }

        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            if (this.mProvider == null) {
                new Object[1][0] = "no oauth provider found";
                getActivity().finish();
                return;
            }
            getAuthInfo();
        }

        public void onDestroyView() {
            super.onDestroyView();
        }

        /* access modifiers changed from: package-private */
        public avh getOAuth10Service() {
            return (avh) getOAuthService();
        }

        /* access modifiers changed from: package-private */
        public avi getOAuth20Service() {
            return (avi) getOAuthService();
        }

        /* access modifiers changed from: protected */
        public avj getOAuthService() {
            MIBrainOauthApi mIBrainOauthApi;
            if (this.mOAuthService == null && (mIBrainOauthApi = this.mProvider) != null) {
                aul O000000o2 = new aul(mIBrainOauthApi.getApiKey()).O00000Oo(this.mProvider.getApiSecret()).O00000o0(String.valueOf(System.currentTimeMillis())).O000000o(this.mProvider.getCallback());
                O000000o2.f12625O000000o = new OkHttpHttpClient(ApiManager.getThirdPartyInstance().getHttpClient());
                this.mOAuthService = O000000o2.O000000o((aum) this.mProvider);
            }
            return this.mOAuthService;
        }

        public void onViewClicked() {
            MIBrainOauthApi mIBrainOauthApi = this.mProvider;
            if (mIBrainOauthApi == null) {
                return;
            }
            if (mIBrainOauthApi instanceof aun) {
                doOauth10();
            } else if (mIBrainOauthApi instanceof auo) {
                doOauth20();
            }
        }

        private void doOauth20() {
            Intent intent = new Intent(getContext(), CommonWebActivity.class);
            avi oAuth20Service = getOAuth20Service();
            intent.putExtra("common_web_url", oAuth20Service.f12642O000000o.getAuthorizationUrl(oAuth20Service.O00000Oo, null));
            startActivityForResult(intent, 1);
            this.mOAuth20CodeSubject.compose(bindToLifecycle()).observeOn(Schedulers.io()).flatMap(new Func1<String, Observable<OAuth2AccessToken>>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass3 */

                public Observable<OAuth2AccessToken> call(final String str) {
                    return Observable.unsafeCreate(new Observable.OnSubscribe<OAuth2AccessToken>() {
                        /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass3.AnonymousClass1 */

                        public /* bridge */ /* synthetic */ void call(Object obj) {
                            call((Subscriber<? super OAuth2AccessToken>) ((Subscriber) obj));
                        }

                        public void call(Subscriber<? super OAuth2AccessToken> subscriber) {
                            try {
                                avi oAuth20Service = CommonOauthFragment.this.getOAuth20Service();
                                String str = str;
                                avd avd = new avd(oAuth20Service.f12642O000000o.getAccessTokenVerb(), oAuth20Service.f12642O000000o.getAccessTokenEndpoint());
                                avc avc = oAuth20Service.O00000Oo;
                                avd.O00000o("client_id", avc.f12635O000000o);
                                String str2 = avc.O00000Oo;
                                if (str2 != null) {
                                    avd.O00000o("client_secret", str2);
                                }
                                avd.O00000o("code", str);
                                avd.O00000o("redirect_uri", avc.O00000o0);
                                String str3 = avc.O00000o;
                                if (str3 != null) {
                                    avd.O00000o("scope", str3);
                                }
                                avd.O00000o("grant_type", "authorization_code");
                                subscriber.onNext(oAuth20Service.f12642O000000o.getAccessTokenExtractor().O000000o(oAuth20Service.O000000o(avd)));
                            } catch (Exception e) {
                                ahh.O000000o(e);
                                subscriber.onError(e);
                            }
                        }
                    });
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<OAuth2AccessToken>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass1 */

                public void call(OAuth2AccessToken oAuth2AccessToken) {
                    long currentTimeMillis = System.currentTimeMillis() + (((long) oAuth2AccessToken.expiresIn.intValue()) * 1000);
                    CommonOauthFragment commonOauthFragment = CommonOauthFragment.this;
                    commonOauthFragment.syncToServer(commonOauthFragment.mProvider.getProviderId(), oAuth2AccessToken.accessToken, currentTimeMillis, oAuth2AccessToken.O00000o0());
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass2 */

                public void call(Throwable th) {
                    ToastUtil.showToast((int) R.string.error_oauth_error);
                }
            });
        }

        private void doOauth10() {
            getTempToken().compose(bindToLifecycle()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(new Func1<OAuth1RequestToken, Observable<String>>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass7 */

                public Observable<String> call(OAuth1RequestToken oAuth1RequestToken) {
                    CommonOauthFragment commonOauthFragment = CommonOauthFragment.this;
                    commonOauthFragment.mOauthRequestToekn = oAuth1RequestToken;
                    Intent intent = new Intent(commonOauthFragment.getContext(), CommonWebActivity.class);
                    intent.putExtra("common_web_url", CommonOauthFragment.this.getOAuth10Service().f12640O000000o.getAuthorizationUrl(oAuth1RequestToken));
                    CommonOauthFragment.this.startActivityForResult(intent, 1);
                    return CommonOauthFragment.this.mOAuth10TokenSubject;
                }
            }).observeOn(Schedulers.io()).flatMap(new Func1<String, Observable<OAuth1AccessToken>>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass6 */

                public Observable<OAuth1AccessToken> call(String str) {
                    return CommonOauthFragment.this.getOAuth10AccessToken(str);
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<OAuth1AccessToken>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass4 */

                public void call(OAuth1AccessToken oAuth1AccessToken) {
                    String str;
                    String[] split = oAuth1AccessToken.rawResponse.split("&");
                    int length = split.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String str2 = split[i];
                        if (str2.startsWith("edam_expires" + '=')) {
                            String[] split2 = str2.split("=");
                            if (split2.length > 1) {
                                str = split2[1].trim();
                            }
                        } else {
                            i++;
                        }
                    }
                    str = null;
                    Long valueOf = Long.valueOf(str);
                    CommonOauthFragment commonOauthFragment = CommonOauthFragment.this;
                    commonOauthFragment.syncToServer(commonOauthFragment.mProvider.getProviderId(), oAuth1AccessToken.O000000o(), valueOf.longValue(), oAuth1AccessToken.O00000o0());
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass5 */

                public void call(Throwable th) {
                    ToastUtil.showToast((int) R.string.error_oauth_error);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void onDeOauthBtnClick() {
            ApiHelper.deleteOAuthInfo(this.mProvider.getProviderId(), new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass8 */

                public void onSuccess(String str) {
                    CommonOauthFragment.this.getAuthInfo();
                }

                public void onFailure(ApiError apiError) {
                    ToastUtil.showToast((int) R.string.error_oauth_delete_error);
                }
            }).bindToLifecycle(this);
        }

        private Observable<OAuth1RequestToken> getTempToken() {
            return Observable.unsafeCreate(new Observable.OnSubscribe<OAuth1RequestToken>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass9 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super OAuth1RequestToken>) ((Subscriber) obj));
                }

                public void call(Subscriber<? super OAuth1RequestToken> subscriber) {
                    try {
                        subscriber.onNext(CommonOauthFragment.this.getOAuth10Service().O000000o());
                        subscriber.onCompleted();
                    } catch (Exception e) {
                        subscriber.onError(e);
                    }
                }
            });
        }

        public void syncToServer(String str, String str2, long j, String str3) {
            ApiHelper.setOAuthToken(str2, str, j, str3, null, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass10 */

                public void onSuccess(String str) {
                    new Object[1][0] = str;
                    CommonOauthFragment.this.getAuthInfo();
                }

                public void onFailure(ApiError apiError) {
                    Object[] objArr = {"setOAuthToken", apiError.toThrowable()};
                }
            }).bindToLifecycle(this);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 == -1) {
                Uri data = intent.getData();
                if (this.mOAuthType == OAuthType.OAUTH10) {
                    String queryParameter = data.getQueryParameter("oauth_verifier");
                    if (TextUtils.isEmpty(queryParameter)) {
                        ToastUtil.showToast((int) R.string.error_oauth_error);
                    } else {
                        this.mOAuth10TokenSubject.onNext(queryParameter);
                    }
                } else {
                    String queryParameter2 = data.getQueryParameter("code");
                    if (TextUtils.isEmpty(queryParameter2)) {
                        ToastUtil.showToast((int) R.string.error_oauth_error);
                    } else {
                        this.mOAuth20CodeSubject.onNext(queryParameter2);
                    }
                }
            }
        }

        public Observable<OAuth1AccessToken> getOAuth10AccessToken(final String str) {
            return Observable.unsafeCreate(new Observable.OnSubscribe<OAuth1AccessToken>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass11 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super OAuth1AccessToken>) ((Subscriber) obj));
                }

                public void call(Subscriber<? super OAuth1AccessToken> subscriber) {
                    try {
                        subscriber.onNext(CommonOauthFragment.this.getOAuth10Service().O000000o(CommonOauthFragment.this.mOauthRequestToekn, str));
                        subscriber.onCompleted();
                    } catch (Exception e) {
                        subscriber.onError(e);
                    }
                }
            });
        }

        public void getAuthInfo() {
            ApiHelper.getOAuthInfo(this.mProvider.getProviderId(), new ApiRequest.Listener<MiBrain.OAuthInfo>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonOauthFragment.AnonymousClass12 */

                public void onSuccess(MiBrain.OAuthInfo oAuthInfo) {
                    CommonOauthFragment.this.refreshUI(oAuthInfo);
                }

                public void onFailure(ApiError apiError) {
                    CommonOauthFragment.this.refreshUI(new MiBrain.OAuthInfo());
                }
            }).bindToLifecycle(this);
        }

        /* access modifiers changed from: package-private */
        public void refreshUI(MiBrain.OAuthInfo oAuthInfo) {
            if (!isDetached()) {
                boolean equals = "binded".equals(oAuthInfo.state);
                this.deleteBtn.setVisibility(equals ? 0 : 8);
                if (equals) {
                    this.bindHint.setText((int) R.string.skill_auth_binded);
                    this.authBtn.setVisibility(8);
                    return;
                }
                this.authBtn.setVisibility(0);
                this.bindHint.setText(this.mProvider.getBindHint());
            }
        }
    }

    public static class CommonWebOauthFragment extends MicoBaseFragment implements SkillDetailActivity.OnSkillDataLoaded {
        Button authBtn;
        View authHint;
        TextView bindHint;
        Button deleteBtn;
        protected String mAuthProvider;
        protected SkillStore.SkillDetailV2 mSkill;

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate((int) R.layout.fragment_evernote, (ViewGroup) null);
            this.deleteBtn = (Button) inflate.findViewById(R.id.delete_btn);
            this.deleteBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$CommonAuthActivity$CommonWebOauthFragment$j8jfBNCwdCWN0d_G8fGK27q7vM */

                public final void onClick(View view) {
                    CommonAuthActivity.CommonWebOauthFragment.this.lambda$onCreateView$0$CommonAuthActivity$CommonWebOauthFragment(view);
                }
            });
            this.authBtn = (Button) inflate.findViewById(R.id.auth_btn);
            this.authBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$CommonAuthActivity$CommonWebOauthFragment$8VUVRSD5lYvZWbrZZ3OxAjrwS0I */

                public final void onClick(View view) {
                    CommonAuthActivity.CommonWebOauthFragment.this.lambda$onCreateView$1$CommonAuthActivity$CommonWebOauthFragment(view);
                }
            });
            this.authHint = inflate.findViewById(R.id.auth_hint);
            this.bindHint = (TextView) inflate.findViewById(R.id.bind_hint);
            return inflate;
        }

        public /* synthetic */ void lambda$onCreateView$0$CommonAuthActivity$CommonWebOauthFragment(View view) {
            onDeOauthBtnClick();
        }

        public /* synthetic */ void lambda$onCreateView$1$CommonAuthActivity$CommonWebOauthFragment(View view) {
            onViewClicked();
        }

        public void onDestroyView() {
            super.onDestroyView();
        }

        public void onViewClicked() {
            if (TextUtils.isEmpty(getSkillProviderID())) {
                ToastUtil.showToast((int) R.string.failed_of_load_retry);
                return;
            }
            startActivityForResult(CommonWebActivity.buildIntent(getContext(), "", Uri.parse(ApiConstants.getAccountLinkUrl()).buildUpon().appendQueryParameter("provider_id", getSkillProviderID()).appendQueryParameter("callback_url", "mico://oauth/oauth2/common").build().toString(), false), 0);
        }

        /* access modifiers changed from: package-private */
        public void onDeOauthBtnClick() {
            ApiHelper.deleteOAuthInfo(getSkillProviderID(), new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonWebOauthFragment.AnonymousClass1 */

                public void onSuccess(String str) {
                    CommonWebOauthFragment.this.getAuthInfo();
                    CommonWebOauthFragment.this.updateDedaoTab();
                }

                public void onFailure(ApiError apiError) {
                    gsy.O00000Oo(12000, "12000.8.2", "");
                    ToastUtil.showToast((int) R.string.error_oauth_delete_error);
                }
            }).bindToLifecycle(this);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 != -1) {
                return;
            }
            if ("fail".equalsIgnoreCase(intent.getData().getQueryParameter("status"))) {
                gsy.O00000Oo(12000, "12000.8.1", "");
                ToastUtil.showToast((int) R.string.error_oauth_error);
                return;
            }
            getAuthInfo();
            updateDedaoTab();
        }

        public void getAuthInfo() {
            ApiHelper.getOAuthInfo(getSkillProviderID(), new ApiRequest.Listener<MiBrain.OAuthInfo>() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity.CommonWebOauthFragment.AnonymousClass2 */

                public void onSuccess(MiBrain.OAuthInfo oAuthInfo) {
                    CommonWebOauthFragment.this.refreshUI(oAuthInfo);
                }

                public void onFailure(ApiError apiError) {
                    CommonWebOauthFragment.this.refreshUI(new MiBrain.OAuthInfo());
                }
            }).bindToLifecycle(this);
        }

        /* access modifiers changed from: protected */
        public void refreshUI(MiBrain.OAuthInfo oAuthInfo) {
            if (!isDetached()) {
                boolean equals = "binded".equals(oAuthInfo.state);
                this.deleteBtn.setVisibility(equals ? 0 : 8);
                if (equals) {
                    this.bindHint.setText((int) R.string.skill_auth_binded);
                    this.authBtn.setVisibility(8);
                } else {
                    this.authBtn.setVisibility(0);
                    this.bindHint.setText((int) R.string.skill_auth);
                }
                setTitleBarRightButton(equals);
            }
        }

        /* access modifiers changed from: package-private */
        public void setTitleBarRightButton(boolean z) {
            FragmentActivity activity = getActivity();
            if (activity instanceof SkillDetailActivity) {
                ((SkillDetailActivity) activity).initTopRightLabel(z);
            }
        }

        public void onSkillDataLoaded(SkillStore.SkillDetailV2 skillDetailV2) {
            this.mSkill = skillDetailV2;
            getAuthInfo();
        }

        public String getSkillProviderID() {
            SkillStore.SkillDetailV2 skillDetailV2 = this.mSkill;
            String str = skillDetailV2 == null ? "" : skillDetailV2.providerID;
            return TextUtils.isEmpty(str) ? this.mAuthProvider : str;
        }

        public void setAuthProvider(String str) {
            this.mAuthProvider = str;
        }

        private boolean isDedaoSkill() {
            return "269135865337350144".equals(getSkillProviderID());
        }

        public void updateDedaoTab() {
            if (isDedaoSkill()) {
                jgc.O000000o().O00000o(new DeDaoAuthEvent());
            }
        }
    }

    public static class MeituanWebOauthFragment extends CommonWebOauthFragment {
        Button editAccountButton;

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate((int) R.layout.fragment_skill_auth_meituan, (ViewGroup) null);
            this.editAccountButton = (Button) inflate.findViewById(R.id.account_edit);
            this.editAccountButton.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$CommonAuthActivity$MeituanWebOauthFragment$bnCD_XMvdQpLr9HZ17KMOknGio */

                public final void onClick(View view) {
                    CommonAuthActivity.MeituanWebOauthFragment.this.lambda$onCreateView$0$CommonAuthActivity$MeituanWebOauthFragment(view);
                }
            });
            return inflate;
        }

        public /* synthetic */ void lambda$onCreateView$0$CommonAuthActivity$MeituanWebOauthFragment(View view) {
            onClickEditAccount();
        }

        /* access modifiers changed from: protected */
        public void refreshUI(MiBrain.OAuthInfo oAuthInfo) {
            if (!isDetached()) {
                boolean equals = "binded".equals(oAuthInfo.state);
                this.deleteBtn.setVisibility(equals ? 0 : 8);
                this.editAccountButton.setVisibility(equals ? 0 : 4);
                if (equals) {
                    this.bindHint.setText((int) R.string.skill_auth_binded);
                    this.authBtn.setVisibility(8);
                } else {
                    this.authBtn.setVisibility(0);
                    this.bindHint.setText((int) R.string.skill_auth);
                }
                setTitleBarRightButton(equals);
            }
        }

        /* access modifiers changed from: package-private */
        public void onClickEditAccount() {
            startActivityForResult(CommonWebActivity.buildIntent(getContext(), "", Uri.parse("https://xiaoai.mi.com/user/info").buildUpon().build().toString(), false), 0);
        }
    }
}
