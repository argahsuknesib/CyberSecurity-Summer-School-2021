package _m_j;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Pair;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;
import com.xiaomi.youpin.login.LoginRouter$1;
import com.xiaomi.youpin.login.ui.LoginSystemTransparentActivity;
import java.util.concurrent.ExecutionException;

public final class ici {
    public static boolean O000000o(Context context) {
        return O00000o0(context) != null;
    }

    public static String O00000Oo(Context context) {
        Account O00000o0 = O00000o0(context);
        return O00000o0 != null ? O00000o0.name : "";
    }

    public static Account O00000o0(Context context) {
        if (!MiAccountManager.O00000Oo(context.getApplicationContext()).O00000Oo) {
            return null;
        }
        return O00000o(context);
    }

    private static Account O00000o(Context context) {
        MiAccountManager O00000Oo = MiAccountManager.O00000Oo(context.getApplicationContext());
        if (O00000Oo == null) {
            return null;
        }
        boolean O00000Oo2 = O00000Oo.O00000Oo();
        boolean O00000o0 = O00000Oo.O00000o0();
        O00000Oo.O00000o();
        Account[] O000000o2 = O00000Oo.O000000o("com.xiaomi");
        if (O00000Oo2) {
            O00000Oo.O00000o();
        } else if (O00000o0) {
            O00000Oo.O00000oO();
        }
        if (O000000o2.length > 0) {
            return O000000o2[0];
        }
        return null;
    }

    @SuppressLint({"StaticFieldLeak"})
    public static void O000000o(final Context context, final boolean z, final ich ich) {
        gor.O000000o(new AsyncTask<Void, Void, Pair<XmAccountVisibility, Exception>>() {
            /* class _m_j.ici.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                Pair pair = (Pair) obj;
                if (pair == null) {
                    ich.O000000o(-9, "");
                    return;
                }
                XmAccountVisibility xmAccountVisibility = (XmAccountVisibility) pair.first;
                if (xmAccountVisibility != null) {
                    int i = AnonymousClass2.f1180O000000o[xmAccountVisibility.f6203O000000o.ordinal()];
                    if (i != 1) {
                        if (i == 2) {
                            ich.O000000o(-11, "");
                        } else if (i == 3) {
                            ich.O000000o(ici.O00000o0(context));
                        } else if (i == 4) {
                            ich.O000000o(-13, "");
                        } else if (i == 5) {
                            if (z) {
                                Intent intent = xmAccountVisibility.O00000oo;
                                if (intent == null || intent.getComponent() == null) {
                                    ich.O000000o(-14, "");
                                    return;
                                } else if (!"android.accounts.ChooseTypeAndAccountActivity".equals(intent.getComponent().getClassName())) {
                                    Context context = context;
                                    LoginRouter$1 loginRouter$1 = new LoginRouter$1(new ich() {
                                        /* class _m_j.ici.AnonymousClass1.AnonymousClass1 */

                                        public final void O000000o(Account account) {
                                            ich.O000000o(account);
                                        }

                                        public final void O000000o(int i, String str) {
                                            ich.O000000o(-14, "");
                                        }
                                    });
                                    IntentFilter intentFilter = new IntentFilter();
                                    intentFilter.addAction("mijia.access.xm_account");
                                    ft.O000000o(context.getApplicationContext()).O000000o(loginRouter$1, intentFilter);
                                    Intent intent2 = new Intent(context, LoginSystemTransparentActivity.class);
                                    intent2.addFlags(268435456);
                                    intent2.putExtra("XmAccountVisibility", xmAccountVisibility);
                                    context.startActivity(intent2);
                                    return;
                                }
                            }
                            ich.O000000o(-14, "");
                        }
                    } else if (xmAccountVisibility.O00000o0) {
                        ich.O000000o(xmAccountVisibility.O00000o);
                    } else {
                        ich.O000000o(-10, "");
                    }
                }
            }

            /* JADX INFO: additional move instructions added (1) to help type inference */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.InterruptedException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.util.concurrent.ExecutionException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.InterruptedException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.InterruptedException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.InterruptedException} */
            /* JADX WARNING: Multi-variable type inference failed */
            private Pair<XmAccountVisibility, Exception> O000000o() {
                InterruptedException interruptedException;
                MiAccountManager O00000Oo2 = MiAccountManager.O00000Oo(context.getApplicationContext());
                XmAccountVisibility xmAccountVisibility = null;
                if (O00000Oo2 == null) {
                    return null;
                }
                O00000Oo2.O00000o();
                try {
                    xmAccountVisibility = (XmAccountVisibility) O00000Oo2.O000000o(context).get();
                    interruptedException = null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    interruptedException = e;
                } catch (ExecutionException e2) {
                    e2.printStackTrace();
                    interruptedException = e2;
                }
                return new Pair<>(xmAccountVisibility, interruptedException);
            }
        }, new Void[0]);
    }

    /* renamed from: _m_j.ici$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f1180O000000o = new int[XmAccountVisibility.ErrorCode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f1180O000000o[XmAccountVisibility.ErrorCode.ERROR_NONE.ordinal()] = 1;
            f1180O000000o[XmAccountVisibility.ErrorCode.ERROR_NO_ACCOUNT.ordinal()] = 2;
            f1180O000000o[XmAccountVisibility.ErrorCode.ERROR_PRE_ANDROID_O.ordinal()] = 3;
            f1180O000000o[XmAccountVisibility.ErrorCode.ERROR_NO_PERMISSION.ordinal()] = 4;
            f1180O000000o[XmAccountVisibility.ErrorCode.ERROR_NOT_SUPPORT.ordinal()] = 5;
        }
    }
}
