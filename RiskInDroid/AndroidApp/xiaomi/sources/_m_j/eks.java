package _m_j;

import _m_j.ekp;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.xiaomi.accounts.AccountAuthenticatorResponse;
import com.xiaomi.accounts.AccountManager;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.ActivityExportSafetyGuardian;
import com.xiaomi.accountsdk.utils.CloudCoder;
import com.xiaomi.passport.AccountChangedBroadcastHelper;
import com.xiaomi.passport.LocalFeatures.LocalFeaturesManagerResponse;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenUIResponse;
import com.xiaomi.passport.utils.AMPassTokenUpdateUtil;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public final class eks {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f15585O000000o = new Object();
    private static volatile AMPassTokenUpdateUtil O00000Oo;

    public static void O000000o(Parcelable parcelable, Bundle bundle) {
        if (parcelable != null) {
            if (parcelable instanceof AccountAuthenticatorResponse) {
                AccountAuthenticatorResponse accountAuthenticatorResponse = (AccountAuthenticatorResponse) parcelable;
                if (bundle == null) {
                    if (Log.isLoggable("AccountAuthenticator", 2)) {
                        Log.v("AccountAuthenticator", "AccountAuthenticatorResponse.onError: 4" + ", " + "canceled");
                    }
                    try {
                        accountAuthenticatorResponse.f5955O000000o.onError(4, "canceled");
                    } catch (RemoteException unused) {
                    }
                } else {
                    if (Log.isLoggable("AccountAuthenticator", 2)) {
                        bundle.keySet();
                        AccountLog.v("AccountAuthenticator", "AccountAuthenticatorResponse.onResult: " + AccountManager.O000000o(bundle));
                    }
                    try {
                        accountAuthenticatorResponse.f5955O000000o.onResult(bundle);
                    } catch (RemoteException unused2) {
                    }
                }
            } else if (parcelable instanceof ServiceTokenUIResponse) {
                ServiceTokenUIResponse serviceTokenUIResponse = (ServiceTokenUIResponse) parcelable;
                if (bundle == null) {
                    serviceTokenUIResponse.O000000o("canceled");
                } else {
                    serviceTokenUIResponse.O000000o(bundle);
                }
            } else if (parcelable instanceof LocalFeaturesManagerResponse) {
                LocalFeaturesManagerResponse localFeaturesManagerResponse = (LocalFeaturesManagerResponse) parcelable;
                if (bundle == null) {
                    localFeaturesManagerResponse.O000000o(4, "canceled");
                } else {
                    localFeaturesManagerResponse.O000000o(bundle);
                }
            }
        }
    }

    public static Intent O00000Oo(Parcelable parcelable, Bundle bundle) {
        Intent intent = new Intent();
        intent.setComponent(eeu.f15193O000000o.O00000Oo());
        intent.putExtra("accountAuthenticatorResponse", parcelable);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.addFlags(67108864);
        return intent;
    }

    public static Intent O000000o(String str, Bundle bundle, Parcelable parcelable) {
        Intent intent = new Intent();
        intent.setComponent(eeu.f15193O000000o.O000000o());
        intent.putExtra("service_id", str);
        intent.putExtras(bundle);
        intent.addFlags(67108864);
        intent.putExtra("accountAuthenticatorResponse", parcelable);
        return intent;
    }

    public static Intent O000000o(Context context, Parcelable parcelable, String str, String str2, Bundle bundle) {
        Intent intent = new Intent();
        intent.setComponent(eeu.f15193O000000o.O00000o0());
        ekp.O000000o(intent, new ekp.O000000o(str, true));
        intent.putExtra("service_id", str2);
        intent.putExtra("accountAuthenticatorResponse", parcelable);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        ActivityExportSafetyGuardian.getInstance().sign(context, intent);
        return intent;
    }

    public static void O000000o(Context context, Account account, AccountInfo accountInfo) {
        String str;
        if (accountInfo != null && context != null && account != null) {
            MiAccountManager O00000Oo2 = MiAccountManager.O00000Oo(context);
            String encryptedUserId = accountInfo.getEncryptedUserId();
            if (!TextUtils.isEmpty(encryptedUserId)) {
                O00000Oo2.O000000o(account, "encrypted_user_id", encryptedUserId);
            }
            O00000Oo2.O000000o(account, "has_password", String.valueOf(accountInfo.getHasPwd()));
            String serviceId = accountInfo.getServiceId();
            String serviceToken = accountInfo.getServiceToken();
            if (!TextUtils.isEmpty(serviceId) && !TextUtils.isEmpty(serviceToken)) {
                O00000Oo2.O00000Oo(account, serviceId, ExtendedAuthToken.build(serviceToken, accountInfo.getSecurity()).toPlain());
                String md5DigestUpperCase = CloudCoder.getMd5DigestUpperCase(serviceToken);
                String str2 = null;
                if (TextUtils.isEmpty(accountInfo.getSlh())) {
                    str = null;
                } else {
                    str = md5DigestUpperCase + "," + accountInfo.getSlh();
                }
                if (!TextUtils.isEmpty(accountInfo.getPh())) {
                    str2 = md5DigestUpperCase + "," + accountInfo.getPh();
                }
                O00000Oo2.O000000o(account, serviceId + "_slh", str);
                O00000Oo2.O000000o(account, serviceId + "_ph", str2);
            }
        }
    }

    public static boolean O00000Oo(Context context, AccountInfo accountInfo) {
        String userId = accountInfo.getUserId();
        Account account = new Account(userId, "com.xiaomi");
        Bundle bundle = new Bundle();
        bundle.putString("authAccount", userId);
        bundle.putString("encrypted_user_id", accountInfo.getEncryptedUserId());
        boolean O000000o2 = O000000o(context, account, ExtendedAuthToken.build(accountInfo.getPassToken(), accountInfo.getPsecurity()).toPlain(), bundle);
        O000000o(context, account, accountInfo);
        return O000000o2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        return r7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    private static boolean O000000o(Context context, Account account, String str, Bundle bundle) {
        Account account2;
        synchronized (f15585O000000o) {
            MiAccountManager O00000Oo2 = MiAccountManager.O00000Oo(context);
            Account[] O000000o2 = MiAccountManager.O00000Oo(context).O000000o("com.xiaomi");
            if (O000000o2 != null) {
                if (O000000o2.length > 0) {
                    account2 = O000000o2[0];
                    if (account2 == null) {
                        String O000000o3 = O00000Oo2.O000000o(account2);
                        if (account2.name.equals(account.name) && !TextUtils.isEmpty(str) && !TextUtils.equals(str, O000000o3)) {
                            O00000Oo2.O00000Oo(account2, str);
                            AccountChangedBroadcastHelper.O000000o(context, account, AccountChangedBroadcastHelper.UpdateType.POST_REFRESH);
                        }
                        return true;
                    }
                    AccountChangedBroadcastHelper.O000000o(context, account, AccountChangedBroadcastHelper.UpdateType.PRE_ADD);
                    boolean O000000o4 = O00000Oo2.O000000o(account, str, bundle);
                    if (O000000o4) {
                        AccountChangedBroadcastHelper.O000000o(context, account, AccountChangedBroadcastHelper.UpdateType.POST_ADD);
                    }
                }
            }
            account2 = null;
            if (account2 == null) {
            }
        }
    }

    public static Account O000000o(Context context) {
        return MiAccountManager.O00000Oo(context).O00000oo();
    }

    public static void O000000o(Context context, Account account) {
        Boolean bool;
        AccountChangedBroadcastHelper.O000000o(context, account, AccountChangedBroadcastHelper.UpdateType.PRE_REMOVE);
        AccountManagerFuture<Boolean> O000000o2 = MiAccountManager.O00000Oo(context).O000000o(account, (AccountManagerCallback<Boolean>) null, (Handler) null);
        Boolean bool2 = Boolean.FALSE;
        try {
            bool = O000000o2.getResult();
        } catch (Exception e) {
            AccountLog.e("AuthenticatorUtil", "error when remove account", e);
            bool = bool2;
        }
        if (bool.booleanValue()) {
            AccountChangedBroadcastHelper.O000000o(context, account, AccountChangedBroadcastHelper.UpdateType.POST_REMOVE);
        }
    }

    public static void O00000Oo(Context context) {
        if (context != null) {
            CookieSyncManager.createInstance(context);
            CookieManager instance = CookieManager.getInstance();
            try {
                String host = new URL(URLs.ACCOUNT_DOMAIN).getHost();
                String[] strArr = {host, ".".concat(String.valueOf(host)), "c.id.mi.com"};
                for (int i = 0; i < 3; i++) {
                    String str = strArr[i];
                    String cookie = instance.getCookie(str);
                    if (!TextUtils.isEmpty(cookie)) {
                        String[] split = cookie.split(";");
                        for (int i2 = 0; i2 < split.length; i2++) {
                            instance.setCookie(str, String.format("%s=; Expires=Thu, 01 Jan 1970 00:00:00 GMT", split[i2].split("=")[0].trim()));
                        }
                    }
                }
                CookieSyncManager.getInstance().sync();
            } catch (MalformedURLException unused) {
                throw new IllegalStateException("never happen");
            }
        }
    }

    public static boolean O00000Oo(Context context, Account account) {
        boolean z = true;
        try {
            z = O000000o(context, (String) null);
            MiAccountManager.O00000Oo(context.getApplicationContext()).O000000o(account, "has_password", String.valueOf(z));
            return z;
        } catch (AccessDeniedException e) {
            AccountLog.e("AuthenticatorUtil", "handleQueryUserPassword error", e);
            return z;
        } catch (AuthenticationFailureException e2) {
            AccountLog.e("AuthenticatorUtil", "handleQueryUserPassword error", e2);
            return z;
        } catch (InvalidResponseException e3) {
            AccountLog.e("AuthenticatorUtil", "handleQueryUserPassword error", e3);
            return z;
        } catch (CipherException e4) {
            AccountLog.e("AuthenticatorUtil", "handleQueryUserPassword error", e4);
            return z;
        } catch (IOException e5) {
            AccountLog.e("AuthenticatorUtil", "handleQueryUserPassword error", e5);
            return z;
        }
    }

    private static boolean O000000o(Context context, String str) throws IOException, AccessDeniedException, AuthenticationFailureException, CipherException, InvalidResponseException {
        Context applicationContext = context.getApplicationContext();
        String hashedDeviceIdNoThrow = new HashedDeviceIdUtil(applicationContext).getHashedDeviceIdNoThrow();
        eez O000000o2 = eez.O000000o(applicationContext, "passportapi");
        if (O000000o2 == null) {
            AccountLog.w("AuthenticatorUtil", "passport info is null");
            return true;
        }
        String substring = UUID.randomUUID().toString().substring(0, 15);
        try {
            return ekq.O000000o(O000000o2, (String) null, hashedDeviceIdNoThrow, substring);
        } catch (AuthenticationFailureException unused) {
            O000000o2.O000000o(applicationContext);
            return ekq.O000000o(O000000o2, (String) null, hashedDeviceIdNoThrow, substring);
        }
    }

    public static String O00000o0(Context context, Account account) {
        ExtendedAuthToken parse;
        if (!(context == null || account == null)) {
            String O000000o2 = MiAccountManager.O00000Oo(context).O000000o(account);
            if (!TextUtils.isEmpty(O000000o2) && (parse = ExtendedAuthToken.parse(O000000o2)) != null) {
                return parse.authToken;
            }
        }
        return null;
    }

    public static void O00000Oo(Context context, Account account, AccountInfo accountInfo) {
        if (context != null && account != null && accountInfo != null) {
            if (O00000Oo == null) {
                O00000Oo = new AMPassTokenUpdateUtil(context);
            }
            if (O00000Oo.O000000o(O00000o0(context, account), accountInfo)) {
                MiAccountManager.O00000Oo(context).O00000Oo(account, ExtendedAuthToken.build(accountInfo.passToken, accountInfo.getPsecurity()).toPlain());
            }
        }
    }

    public static void O000000o(Context context, AccountInfo accountInfo) {
        if (accountInfo != null && context != null) {
            O000000o(context, MiAccountManager.O00000Oo(context).O00000oo(), accountInfo);
        }
    }

    public static String O00000o0(Context context) {
        if (context == null) {
            return null;
        }
        return O00000o0(context, MiAccountManager.O00000Oo(context).O00000oo());
    }
}
