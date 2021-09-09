package _m_j;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.PassportInfo;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SecureRequestForAccount;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.passport.snscorelib.SNSManager$6;
import com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter;
import com.xiaomi.passport.snscorelib.internal.entity.SNSLoginParameter;
import com.xiaomi.passport.snscorelib.internal.exception.SNSLoginException;
import com.xiaomi.passport.snscorelib.internal.request.SNSRequest;
import com.xiaomi.passport.uicontroller.SimpleFutureTask;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class efk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static O00000Oo f15221O000000o;
    public static final String O00000Oo = (URLs.URL_ACCOUNT_BASE + "/sns/bind/cancel");
    static WebViewClient O00000o = new WebViewClient() {
        /* class _m_j.efk.AnonymousClass2 */

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (efk.f15221O000000o != null) {
                O00000Oo o00000Oo = efk.f15221O000000o;
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String path = Uri.parse(efk.O00000Oo).getPath();
            String path2 = Uri.parse(efk.O00000o0).getPath();
            String path3 = Uri.parse(str).getPath();
            boolean equals = path2.equals(path3);
            boolean equals2 = path.equals(path3);
            if (equals) {
                O00000Oo o00000Oo = efk.f15221O000000o;
                return true;
            } else if (!equals2) {
                return false;
            } else {
                O00000Oo o00000Oo2 = efk.f15221O000000o;
                return true;
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            efk.O000000o();
        }
    };
    public static final String O00000o0 = (URLs.URL_ACCOUNT_BASE + "/sns/bind/finish");
    private static final ExecutorService O00000oo = Executors.newCachedThreadPool();
    private static final Integer O0000O0o = 0;
    private static WebView O0000OOo;
    private static Activity O0000Oo0;
    private SimpleFutureTask<SNSBindParameter> O00000oO;

    public static abstract class O000000o {
        /* access modifiers changed from: protected */
        public abstract void O000000o();

        /* access modifiers changed from: protected */
        public abstract void O000000o(int i, String str);

        /* access modifiers changed from: protected */
        public abstract void O000000o(SNSBindParameter sNSBindParameter);
    }

    public static abstract class O00000Oo {
    }

    public interface O00000o0 {
        void O000000o();
    }

    public efk(Activity activity) {
        O0000Oo0 = activity;
    }

    public efk() {
    }

    public static boolean O000000o(String str, PassportInfo passportInfo, O00000o0 o00000o0) throws IOException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("snsType is null");
        } else if (passportInfo != null) {
            if (passportInfo != null) {
                try {
                    if (TextUtils.isDigitsOnly(passportInfo.getUserId())) {
                        SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(SNSRequest.f6211O000000o, new EasyMap().easyPut("snsType", str).easyPut("userId", passportInfo.getUserId()), new EasyMap().easyPut("cUserId", passportInfo.getEncryptedUserId()).easyPut("serviceToken", passportInfo.getServiceToken()), true, passportInfo.getSecurity());
                        if (postAsMap != null) {
                            if (O0000O0o.equals(postAsMap.getFromBody("code"))) {
                                return true;
                            }
                            return false;
                        }
                        throw new IOException("failed to get response to delete sns accesstoken");
                    }
                } catch (AccessDeniedException e) {
                    AccountLog.e("SNSManager", "InvalidAccessTokenRunnable error", e);
                    return false;
                } catch (AuthenticationFailureException e2) {
                    AccountLog.e("SNSManager", "InvalidAccessTokenRunnable error", e2);
                    o00000o0.O000000o();
                    return false;
                } catch (InvalidResponseException e3) {
                    AccountLog.e("SNSManager", "InvalidAccessTokenRunnable error", e3);
                    return false;
                } catch (CipherException e4) {
                    throw new RuntimeException(e4);
                }
            }
            throw new IllegalArgumentException("illegal param");
        } else {
            throw new IllegalArgumentException("passportInfo is null");
        }
    }

    public static String O000000o(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        return String.format("%s_%s", language, country);
    }

    public final void O000000o(SNSLoginParameter sNSLoginParameter, AccountInfo accountInfo, final O000000o o000000o) {
        String str = sNSLoginParameter.O00000oO;
        String str2 = sNSLoginParameter.O00000oo;
        String str3 = sNSLoginParameter.f6207O000000o;
        this.O00000oO = new SimpleFutureTask<>(new SNSManager$6(this, str, str2, sNSLoginParameter, accountInfo, str3), new SimpleFutureTask.O000000o<SNSBindParameter>() {
            /* class _m_j.efk.AnonymousClass1 */

            public final void O000000o(SimpleFutureTask<SNSBindParameter> simpleFutureTask) {
                try {
                    SNSBindParameter sNSBindParameter = (SNSBindParameter) simpleFutureTask.get();
                    if (o000000o != null) {
                        o000000o.O000000o(sNSBindParameter);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException("snsBindByAccountInfo:interrupted");
                } catch (ExecutionException e2) {
                    Throwable cause = e2.getCause();
                    if (cause instanceof SNSLoginException) {
                        SNSLoginException sNSLoginException = (SNSLoginException) cause;
                        if (sNSLoginException.getServerError() == null) {
                            o000000o.O000000o(sNSLoginException.getCode(), cause.getMessage());
                        }
                    } else if (cause instanceof IOException) {
                        o000000o.O000000o();
                    }
                }
            }
        });
        O00000oo.submit(this.O00000oO);
    }

    public static void O000000o() {
        if (O0000OOo.getVisibility() != 0) {
            O0000OOo.setVisibility(0);
        }
    }
}
