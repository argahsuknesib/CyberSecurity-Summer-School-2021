package _m_j;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Pair;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.SecureRequest;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class ibv {
    public static void O000000o(final int i, LoginMiAccount loginMiAccount, final ibn<Boolean> ibn) {
        new ibk<Boolean>(loginMiAccount, ibn) {
            /* class _m_j.ibv.AnonymousClass1 */

            @SuppressLint({"StaticFieldLeak"})
            public final void O000000o(LoginMiAccount loginMiAccount, MiServiceTokenInfo miServiceTokenInfo, boolean z) {
                final AnonymousClass1 r5 = new ibh<SimpleRequest.MapContent, ExceptionError>() {
                    /* class _m_j.ibv.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ void onFailure(Error error) {
                        String str;
                        ExceptionError exceptionError = (ExceptionError) error;
                        if (ibn != null) {
                            ibn ibn = ibn;
                            if ((exceptionError.O00000Oo + exceptionError.O00000o0) == null) {
                                str = "";
                            } else {
                                str = exceptionError.O00000o0.getMessage();
                            }
                            ibn.O000000o(-1, str);
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        String str;
                        SimpleRequest.MapContent mapContent = (SimpleRequest.MapContent) obj;
                        if (mapContent != null) {
                            try {
                                Integer num = (Integer) mapContent.getFromBody("code");
                                if (num != null) {
                                    if (num.intValue() == 0) {
                                        HashMap hashMap = (HashMap) mapContent.getFromBody("data");
                                        if (hashMap != null) {
                                            ArrayList arrayList = (ArrayList) hashMap.get("userAddresses");
                                            if (arrayList != null) {
                                                boolean z = false;
                                                Iterator it = arrayList.iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        if (((Integer) ((HashMap) it.next()).get("addressType")).intValue() == i) {
                                                            z = true;
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                                if (ibn != null) {
                                                    ibn.O000000o(Boolean.valueOf(z));
                                                }
                                                str = "";
                                                if (ibn != null) {
                                                    ibn.O000000o(-998, str);
                                                    return;
                                                }
                                                return;
                                            } else if (ibn != null) {
                                                ibn.O000000o(-1, "userAddresses is null");
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (ibn != null) {
                                            ibn.O000000o(-1, "data is null");
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                if (ibn != null) {
                                    ibn.O000000o(-1, "code error ".concat(String.valueOf(num)));
                                }
                            } catch (Exception e) {
                                str = e.getMessage();
                            }
                        } else if (ibn != null) {
                            ibn.O000000o(-1, "mapContent is null");
                        }
                    }
                };
                final LoginMiAccount loginMiAccount2 = loginMiAccount;
                final MiServiceTokenInfo miServiceTokenInfo2 = miServiceTokenInfo;
                final boolean z2 = z;
                gor.O000000o(new AsyncTask<Object, Object, Pair<SimpleRequest.MapContent, Exception>>() {
                    /* class _m_j.ibv.AnonymousClass1.AnonymousClass2 */

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return O000000o();
                    }

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ void onPostExecute(Object obj) {
                        Pair pair = (Pair) obj;
                        SimpleRequest.MapContent mapContent = (SimpleRequest.MapContent) pair.first;
                        Exception exc = (Exception) pair.second;
                        if (exc == null) {
                            r5.sendSuccessMessage(mapContent);
                        } else if (!z2 || !(exc instanceof AuthenticationFailureException)) {
                            ExceptionError exceptionError = new ExceptionError(-998, "");
                            exceptionError.O00000o0 = exc;
                            r5.sendFailureMessage(exceptionError);
                        } else {
                            AnonymousClass1.this.O00000Oo();
                        }
                    }

                    private Pair<SimpleRequest.MapContent, Exception> O000000o() {
                        SimpleRequest.MapContent mapContent;
                        Exception exc = null;
                        try {
                            mapContent = SecureRequest.getAsMap("http://api.account.xiaomi.com/pass/v2/safe/user/coreInfo", new EasyMap().easyPut("userId", loginMiAccount2.O000000o()).easyPut("flag", "2"), new EasyMap().easyPut("cUserId", miServiceTokenInfo2.O00000Oo).easyPut("serviceToken", miServiceTokenInfo2.O00000o0), true, miServiceTokenInfo2.O00000o);
                        } catch (Exception e) {
                            exc = e;
                            mapContent = null;
                        }
                        return new Pair<>(mapContent, exc);
                    }
                }, new Object[0]);
            }
        }.O000000o();
    }
}
