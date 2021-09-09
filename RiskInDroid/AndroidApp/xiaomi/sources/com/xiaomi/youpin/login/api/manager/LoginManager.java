package com.xiaomi.youpin.login.api.manager;

import _m_j.gor;
import _m_j.gsy;
import _m_j.ibl;
import _m_j.ibm;
import _m_j.ibo;
import _m_j.ibp;
import _m_j.ibq;
import _m_j.ibr;
import _m_j.ibs;
import _m_j.ibt;
import _m_j.ibx;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import com.xiaomi.account.openauth.XMAuthericationException;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import com.xiaomi.account.openid.OauthAccountManager;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginManager {

    /* renamed from: O000000o  reason: collision with root package name */
    private MiuiSystemLoginManager f12066O000000o;
    private ibo O00000Oo;
    public ibs O00000o;
    protected Context O00000o0;
    public PassportUILoginManager O00000oO;

    /* access modifiers changed from: protected */
    public void O00000o0() {
    }

    public LoginManager(Context context) {
        this.O00000o0 = context;
        ibl ibl = ibm.f1156O000000o;
        if (ibl != null) {
            this.O00000o = ibl.O0000O0o;
        }
    }

    public final void O000000o(Activity activity, final ibq ibq) {
        O00000o0();
        MiAccountManager.O00000Oo(this.O00000o0).O00000o();
        AnonymousClass3 r0 = new ibq() {
            /* class com.xiaomi.youpin.login.api.manager.LoginManager.AnonymousClass3 */

            public final void O000000o(LoginMiAccount loginMiAccount) {
                LoginManager.this.O000000o("MIUI", loginMiAccount, null, ibq);
            }

            public final void O000000o(int i, String str, Map<String, String> map) {
                ibq ibq = ibq;
                if (ibq != null) {
                    ibq.O000000o(i, str, map);
                }
                Map<String, String> O000000o2 = ibt.O000000o(i, str);
                if (map != null) {
                    O000000o2.putAll(map);
                }
                gsy.O00000Oo(4000, "4000.1.1", "");
                LoginManager.this.O000000o("MIUI", i, str, map, ibq);
            }
        };
        if (this.f12066O000000o == null) {
            this.f12066O000000o = new MiuiSystemLoginManager(this.O00000o0);
        }
        this.f12066O000000o.O000000o(activity, r0);
    }

    public final void O000000o(Activity activity, int[] iArr, String str, String str2, final ibr ibr) {
        O00000o0();
        MiAccountManager.O00000Oo(this.O00000o0).O00000oO();
        AnonymousClass4 r7 = new ibr() {
            /* class com.xiaomi.youpin.login.api.manager.LoginManager.AnonymousClass4 */

            public final void O000000o(ibx ibx) {
                LoginManager loginManager = LoginManager.this;
                ibr ibr = ibr;
                if (loginManager.O00000o != null) {
                    loginManager.O00000o.O000000o();
                }
                if (ibr != null) {
                    ibr.O000000o(ibx);
                }
            }

            public final void O000000o(int i, String str) {
                if (LoginManager.this.O00000o != null) {
                    LoginManager.this.O00000o.O000000o("OAuth", ibt.O000000o(i, str));
                }
                ibr ibr = ibr;
                if (ibr != null) {
                    ibr.O000000o(i, str);
                }
            }
        };
        if (this.O00000Oo == null) {
            this.O00000Oo = new ibo();
        }
        gor.O000000o(new AsyncTask<Object, Object, Pair<ibx, ExceptionError>>(str, str2, iArr, activity, r7) {
            /* class _m_j.ibo.AnonymousClass1 */

            /* renamed from: O000000o */
            final /* synthetic */ String f1161O000000o;
            final /* synthetic */ String O00000Oo;
            final /* synthetic */ Activity O00000o;
            final /* synthetic */ int[] O00000o0;
            final /* synthetic */ ibr O00000oO;
            private XiaomiOAuthFuture<XiaomiOAuthResults> O0000O0o;

            {
                this.f1161O000000o = r2;
                this.O00000Oo = r3;
                this.O00000o0 = r4;
                this.O00000o = r5;
                this.O00000oO = r6;
            }

            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            public final /* synthetic */ void onPostExecute(Object obj) {
                Pair pair = (Pair) obj;
                ibx ibx = (ibx) pair.first;
                ExceptionError exceptionError = (ExceptionError) pair.second;
                if (exceptionError == null) {
                    this.O00000oO.O000000o(ibx);
                } else if (exceptionError.O00000o0 == null) {
                    this.O00000oO.O000000o(-9001, exceptionError.O00000Oo);
                } else {
                    this.O00000oO.O000000o(-9001, exceptionError.O00000o0.getMessage());
                }
            }

            public final void onPreExecute() {
                this.O0000O0o = new XiaomiOAuthorize().setAppId(Long.parseLong(this.f1161O000000o)).setRedirectUrl(this.O00000Oo).setScope(this.O00000o0).startGetAccessToken(this.O00000o);
            }

            private Pair<ibx, ExceptionError> O000000o() {
                XiaomiOAuthResults xiaomiOAuthResults;
                String str;
                try {
                    xiaomiOAuthResults = this.O0000O0o.getResult();
                    e = null;
                } catch (OperationCanceledException | XMAuthericationException | IOException e) {
                    e = e;
                    xiaomiOAuthResults = null;
                }
                if (e != null) {
                    ExceptionError exceptionError = new ExceptionError(-1, "exception");
                    exceptionError.O00000o0 = e;
                    return new Pair<>(null, exceptionError);
                } else if (xiaomiOAuthResults == null) {
                    return new Pair<>(null, new ExceptionError(-2, "oauthResults is null"));
                } else {
                    if (xiaomiOAuthResults.hasError()) {
                        return new Pair<>(null, new ExceptionError(xiaomiOAuthResults.getErrorCode(), xiaomiOAuthResults.getErrorMessage()));
                    }
                    try {
                        str = new XiaomiOAuthorize().callOpenApi(this.O00000o, Long.parseLong(this.f1161O000000o), "/user/profile", xiaomiOAuthResults.getAccessToken(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()).getResult();
                    } catch (OperationCanceledException | XMAuthericationException | IOException e2) {
                        e = e2;
                        str = null;
                    }
                    if (e != null) {
                        ExceptionError exceptionError2 = new ExceptionError(-3, "exception");
                        exceptionError2.O00000o0 = e;
                        return new Pair<>(null, exceptionError2);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        ibx ibx = new ibx();
                        ibx.O00000Oo = xiaomiOAuthResults.getAccessToken();
                        ibx.O00000o0 = xiaomiOAuthResults.getExpiresIn();
                        ibx.O00000o = xiaomiOAuthResults.getScopes();
                        ibx.O00000oO = xiaomiOAuthResults.getState();
                        ibx.O00000oo = xiaomiOAuthResults.getTokenType();
                        ibx.O0000O0o = xiaomiOAuthResults.getMacKey();
                        ibx.O0000OOo = xiaomiOAuthResults.getMacAlgorithm();
                        ibx.O0000Oo0 = xiaomiOAuthResults.getCode();
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        ibx.f1167O000000o = optJSONObject.optString("userId");
                        ibx.O0000Oo = optJSONObject.optString("miliaoIcon_90");
                        ibx.O0000OoO = optJSONObject.optString("miliaoNick");
                        ibx.O0000Ooo = optJSONObject.optString("miliaoIcon_75");
                        ibx.O0000o00 = optJSONObject.optString("miliaoIcon_320");
                        ibx.O0000o0 = optJSONObject.optString("miliaoIcon_120");
                        ibx.O0000o0O = optJSONObject.optString("miliaoIcon_orig");
                        ibx.O0000o0o = optJSONObject.optString("miliaoIcon");
                        return new Pair<>(ibx, null);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        return new Pair<>(null, new ExceptionError(-4, "JSONException ".concat(String.valueOf(e3))));
                    }
                }
            }
        }, new Object[0]);
    }

    public final void O00000Oo(Activity activity, int[] iArr, String str, String str2, ibr ibr) {
        MiAccountManager.O00000Oo(this.O00000o0).O00000oO();
        if (this.O00000Oo == null) {
            this.O00000Oo = new ibo();
        }
        gor.O000000o(new AsyncTask<Object, Object, Pair<ibx, ExceptionError>>(str, str2, iArr, activity, ibr) {
            /* class _m_j.ibo.AnonymousClass2 */

            /* renamed from: O000000o */
            final /* synthetic */ String f1162O000000o;
            final /* synthetic */ String O00000Oo;
            final /* synthetic */ Activity O00000o;
            final /* synthetic */ int[] O00000o0;
            final /* synthetic */ ibr O00000oO;
            private XiaomiOAuthFuture<XiaomiOAuthResults> O0000O0o;

            {
                this.f1162O000000o = r2;
                this.O00000Oo = r3;
                this.O00000o0 = r4;
                this.O00000o = r5;
                this.O00000oO = r6;
            }

            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            public final /* synthetic */ void onPostExecute(Object obj) {
                Pair pair = (Pair) obj;
                if (this.O00000oO != null) {
                    ibx ibx = (ibx) pair.first;
                    ExceptionError exceptionError = (ExceptionError) pair.second;
                    if (exceptionError == null) {
                        this.O00000oO.O000000o(ibx);
                    } else if (exceptionError.O00000o0 == null) {
                        this.O00000oO.O000000o(-9001, exceptionError.O00000Oo);
                    } else {
                        this.O00000oO.O000000o(-9001, exceptionError.O00000o0.getMessage());
                    }
                }
            }

            public final void onPreExecute() {
                this.O0000O0o = new XiaomiOAuthorize().setAccountAuth(OauthAccountManager.getOauthAccount()).setAppId(Long.parseLong(this.f1162O000000o)).setRedirectUrl(this.O00000Oo).setScope(this.O00000o0).setNoMiui(true).startGetOAuthCode(this.O00000o);
            }

            private Pair<ibx, ExceptionError> O000000o() {
                XiaomiOAuthResults xiaomiOAuthResults;
                try {
                    xiaomiOAuthResults = this.O0000O0o.getResult();
                    e = null;
                } catch (OperationCanceledException | XMAuthericationException | IOException e) {
                    e = e;
                    xiaomiOAuthResults = null;
                }
                if (e != null) {
                    ExceptionError exceptionError = new ExceptionError(-1, "exception");
                    exceptionError.O00000o0 = e;
                    return new Pair<>(null, exceptionError);
                } else if (xiaomiOAuthResults == null) {
                    return new Pair<>(null, new ExceptionError(-2, "oauthResults is null"));
                } else {
                    if (xiaomiOAuthResults.hasError()) {
                        return new Pair<>(null, new ExceptionError(xiaomiOAuthResults.getErrorCode(), xiaomiOAuthResults.getErrorMessage()));
                    }
                    ibx ibx = new ibx();
                    ibx.O00000Oo = xiaomiOAuthResults.getAccessToken();
                    ibx.O00000o0 = xiaomiOAuthResults.getExpiresIn();
                    ibx.O00000o = xiaomiOAuthResults.getScopes();
                    ibx.O00000oO = xiaomiOAuthResults.getState();
                    ibx.O00000oo = xiaomiOAuthResults.getTokenType();
                    ibx.O0000O0o = xiaomiOAuthResults.getMacKey();
                    ibx.O0000OOo = xiaomiOAuthResults.getMacAlgorithm();
                    ibx.O0000Oo0 = xiaomiOAuthResults.getCode();
                    return new Pair<>(ibx, null);
                }
            }
        }, new Object[0]);
    }

    public void O000000o(String str, LoginMiAccount loginMiAccount, Map<String, String> map, ibp ibp) {
        if (ibp != null) {
            ibp.O000000o(loginMiAccount);
        }
        ibs ibs = this.O00000o;
        if (ibs != null) {
            ibs.O000000o();
        }
    }

    public void O000000o(String str, int i, String str2, Map<String, String> map, ibp ibp) {
        ibs ibs = this.O00000o;
        if (ibs != null) {
            ibs.O000000o(str, map);
        }
    }
}
