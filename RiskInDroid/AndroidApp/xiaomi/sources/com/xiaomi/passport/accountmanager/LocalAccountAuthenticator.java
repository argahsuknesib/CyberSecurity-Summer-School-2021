package com.xiaomi.passport.accountmanager;

import _m_j.ekq;
import _m_j.eks;
import android.accounts.Account;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.accounts.AbstractAccountAuthenticator;
import com.xiaomi.accounts.AccountAuthenticatorResponse;
import com.xiaomi.accounts.AccountManager;
import com.xiaomi.accounts.AccountManagerService;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.PassTokenLoginParams;
import com.xiaomi.accountsdk.account.exception.IllegalDeviceException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.account.exception.PackageNameDeniedException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.IOException;

public class LocalAccountAuthenticator extends AbstractAccountAuthenticator {
    private Context O00000Oo;

    public LocalAccountAuthenticator(Context context) {
        super(context);
        this.O00000Oo = context;
    }

    public final Bundle O000000o(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, Bundle bundle) throws NetworkErrorException {
        Account[] O000000o2 = AccountManager.O000000o(this.O00000Oo).O000000o("com.xiaomi");
        Bundle bundle2 = new Bundle();
        if (O000000o2.length > 0) {
            AccountLog.d("LocalAccountAuthenticat", "a xiaomi account already exists");
            Account account = O000000o2[0];
            bundle2.putString("authAccount", account.name);
            bundle2.putString("accountType", account.type);
        } else {
            if (TextUtils.isEmpty(str)) {
                AccountLog.w("LocalAccountAuthenticat", "no service id contained, use passportapi");
                str = "passportapi";
            }
            bundle2.putParcelable("intent", eks.O000000o(str, bundle, accountAuthenticatorResponse));
        }
        return bundle2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    public final Bundle O000000o(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) throws NetworkErrorException {
        String str;
        AccountInfo build;
        Bundle bundle2 = new Bundle();
        boolean z = false;
        AccountInfo accountInfo = null;
        boolean z2 = true;
        if (bundle == null || !bundle.containsKey("password")) {
            String O000000o2 = AccountManager.O000000o(this.O00000Oo).O000000o(account);
            if (bundle != null && !bundle.getBoolean("verify_only", true)) {
                z2 = false;
            }
            if (z2 && TextUtils.isEmpty(O000000o2)) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean("verify_only", false);
            }
            Bundle bundle3 = bundle;
            O000000o(bundle2, accountAuthenticatorResponse, false, account, bundle3 != null ? bundle3.getString("service_id") : null, bundle3);
        } else {
            String str2 = account.name;
            try {
                build = ekq.O000000o(str2, bundle.getString("password"), bundle.getString("captcha_code"), bundle.getString("captcha_ick"));
            } catch (IOException e) {
                throw new NetworkErrorException("IO exception when sending request to passport server", e);
            } catch (IllegalDeviceException e2) {
                e2.printStackTrace();
                str = null;
                bundle2.putString("authAccount", str2);
                bundle2.putString("accountType", "com.xiaomi");
                if (accountInfo != null) {
                }
                bundle2.putBoolean("booleanResult", z);
                bundle2.putString("captcha_url", str);
                return bundle2;
            } catch (InvalidResponseException e3) {
                e3.printStackTrace();
                str = null;
                bundle2.putString("authAccount", str2);
                bundle2.putString("accountType", "com.xiaomi");
                if (accountInfo != null) {
                }
                bundle2.putBoolean("booleanResult", z);
                bundle2.putString("captcha_url", str);
                return bundle2;
            } catch (InvalidCredentialException e4) {
                str = e4.getCaptchaUrl();
                e4.printStackTrace();
            } catch (AccessDeniedException e5) {
                e5.printStackTrace();
                str = null;
                bundle2.putString("authAccount", str2);
                bundle2.putString("accountType", "com.xiaomi");
                if (accountInfo != null) {
                }
                bundle2.putBoolean("booleanResult", z);
                bundle2.putString("captcha_url", str);
                return bundle2;
            } catch (AuthenticationFailureException e6) {
                e6.printStackTrace();
                str = null;
                bundle2.putString("authAccount", str2);
                bundle2.putString("accountType", "com.xiaomi");
                if (accountInfo != null) {
                }
                bundle2.putBoolean("booleanResult", z);
                bundle2.putString("captcha_url", str);
                return bundle2;
            } catch (NeedVerificationException unused) {
                build = new AccountInfo.Builder().userId(str2).build();
            } catch (NeedCaptchaException e7) {
                str = e7.getCaptchaUrl();
                e7.printStackTrace();
            } catch (InvalidUserNameException e8) {
                e8.printStackTrace();
                str = null;
                bundle2.putString("authAccount", str2);
                bundle2.putString("accountType", "com.xiaomi");
                if (accountInfo != null) {
                }
                bundle2.putBoolean("booleanResult", z);
                bundle2.putString("captcha_url", str);
                return bundle2;
            }
            str = null;
            accountInfo = build;
            bundle2.putString("authAccount", str2);
            bundle2.putString("accountType", "com.xiaomi");
            if (accountInfo != null) {
                z = true;
            }
            bundle2.putBoolean("booleanResult", z);
            bundle2.putString("captcha_url", str);
        }
        return bundle2;
    }

    public final Bundle O000000o(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        Bundle O00000Oo2 = O00000Oo(accountAuthenticatorResponse, account, str, bundle);
        if (eks.O000000o(this.O00000Oo) != null) {
            return O00000Oo2;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("booleanResult", false);
        return bundle2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ekq.O000000o(com.xiaomi.accountsdk.account.data.AccountInfo, boolean):android.os.Bundle
     arg types: [com.xiaomi.accountsdk.account.data.AccountInfo, int]
     candidates:
      _m_j.ekq.O000000o(android.content.Context, com.xiaomi.accountsdk.account.data.PassTokenLoginParams):com.xiaomi.accountsdk.account.data.AccountInfo
      _m_j.ekq.O000000o(android.content.Context, java.lang.String):java.lang.String
      _m_j.ekq.O000000o(com.xiaomi.accountsdk.account.data.AccountInfo, boolean):android.os.Bundle */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e  */
    private Bundle O00000Oo(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        String str2;
        String O00000o0;
        Account account2 = account;
        String str3 = str;
        Bundle bundle2 = bundle;
        String string = bundle2.getString("androidPackageName", this.O00000Oo.getPackageName());
        Object[] objArr = new Object[2];
        objArr[0] = str3.startsWith("weblogin:") ? "websso" : str3;
        objArr[1] = string;
        AccountLog.i("LocalAccountAuthenticat", String.format("getting AuthToken, type: %s, package name: %s", objArr));
        Bundle bundle3 = new Bundle();
        Account O000000o2 = eks.O000000o(this.O00000Oo);
        if (O000000o2 == null || !O000000o2.name.equals(account2.name)) {
            bundle3.putBoolean("booleanResult", false);
            return bundle3;
        }
        String str4 = "passportapi";
        if (TextUtils.isEmpty(str)) {
            AccountLog.w("LocalAccountAuthenticat", "getting auth token, but no service url contained, use passportapi");
        } else if (str3.startsWith("weblogin:")) {
            str2 = str3.substring(9);
            if (!ekq.O000000o(str2)) {
                bundle3.putInt("errorCode", 7);
                bundle3.putString("errorMessage", "untrusted web sso url");
                return bundle3;
            }
            O00000o0 = eks.O00000o0(this.O00000Oo, account2);
            if (!TextUtils.isEmpty(O00000o0)) {
                O000000o(bundle3, accountAuthenticatorResponse, true, account, str4, bundle);
                AccountLog.d("LocalAccountAuthenticat", "passToken is null");
                return bundle3;
            }
            PassTokenLoginParams.Builder packageName = new PassTokenLoginParams.Builder().userId(account2.name).passToken(O00000o0).packageName(string);
            if (str2 != null) {
                try {
                    packageName.serviceId(null);
                    packageName.loginRequestUrl(str2);
                    AccountInfo O000000o3 = ekq.O000000o(this.O00000Oo, packageName.build());
                    bundle3.putString("authAccount", O000000o3.getUserId());
                    bundle3.putString("accountType", str2);
                    bundle3.putString("authtoken", O000000o3.getAutoLoginUrl());
                    AccountLog.i("LocalAccountAuthenticat", "web sso getAuthToken succeed");
                    return bundle3;
                } catch (IOException e) {
                    AccountLog.w("LocalAccountAuthenticat", "io exception when getting service token", e);
                    bundle3.putInt("errorCode", 3);
                    bundle3.putString("errorMessage", e.toString());
                } catch (IllegalDeviceException e2) {
                    AccountLog.w("LocalAccountAuthenticat", "get device id failed when getting service token", e2);
                    bundle3.putInt("errorCode", 3);
                    bundle3.putString("errorMessage", "illegal device exception");
                } catch (InvalidResponseException e3) {
                    AccountLog.w("LocalAccountAuthenticat", "invalid response received when getting service token", e3);
                    bundle3.putInt("errorCode", 5);
                    bundle3.putString("errorMessage", e3.toString());
                } catch (InvalidCredentialException e4) {
                    AccountLog.w("LocalAccountAuthenticat", "invalid credential, passToken is invalid", e4);
                    AccountManager O000000o4 = AccountManager.O000000o(this.O00000Oo);
                    if (account2 != null) {
                        AccountManagerService accountManagerService = O000000o4.O00000Oo;
                        if (Log.isLoggable("AccountManagerService", 2)) {
                            AccountLog.v("AccountManagerService", "clearPassword: " + account2 + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
                        }
                        if (account2 != null) {
                            accountManagerService.O000000o(accountManagerService.O000000o(), account2, (String) null);
                            bundle2.putString("captcha_url", e4.getCaptchaUrl());
                            O000000o(bundle3, accountAuthenticatorResponse, true, account, str4, bundle);
                        } else {
                            throw new IllegalArgumentException("account is null");
                        }
                    } else {
                        throw new IllegalArgumentException("account is null");
                    }
                } catch (PackageNameDeniedException e5) {
                    AccountLog.w("LocalAccountAuthenticat", "package name denied: ".concat(String.valueOf(string)), e5);
                    bundle3.putInt("errorCode", 9);
                    bundle3.putString("errorMessage", e5.toString());
                } catch (AccessDeniedException e6) {
                    AccountLog.w("LocalAccountAuthenticat", "access denied", e6);
                    bundle3.putInt("errorCode", 5);
                    bundle3.putString("errorMessage", e6.toString());
                } catch (AuthenticationFailureException e7) {
                    AccountLog.w("LocalAccountAuthenticat", "auth failure", e7);
                    bundle3.putInt("errorCode", 5);
                    bundle3.putString("errorMessage", e7.toString());
                } catch (InvalidUserNameException e8) {
                    AccountLog.e("LocalAccountAuthenticat", "no such a user", e8);
                } catch (NeedNotificationException e9) {
                    AccountLog.w("LocalAccountAuthenticat", "need notification ", e9);
                    if (str2 != null) {
                        AccountLog.i("LocalAccountAuthenticat", "websso return notification url: ".concat(String.valueOf(str4)));
                        bundle3.putString("authAccount", account2.name);
                        bundle3.putString("accountType", str2);
                        bundle3.putString("authtoken", e9.getNotificationUrl());
                        return bundle3;
                    }
                    bundle3.putParcelable("intent", eks.O000000o(this.O00000Oo, accountAuthenticatorResponse, e9.getNotificationUrl(), str4, bundle2));
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                packageName.serviceId(str4);
                packageName.loginRequestUrl(null);
                AccountInfo O000000o5 = ekq.O000000o(this.O00000Oo, packageName.build());
                eks.O000000o(this.O00000Oo, account2, O000000o5);
                eks.O00000Oo(this.O00000Oo, account2, O000000o5);
                bundle3.putAll(ekq.O000000o(O000000o5, false));
                AccountLog.i("LocalAccountAuthenticat", String.format("type: %s, package name: %s, getAuthToken succeed", str3, string));
                return bundle3;
            }
        } else {
            str4 = str3;
        }
        str2 = null;
        O00000o0 = eks.O00000o0(this.O00000Oo, account2);
        if (!TextUtils.isEmpty(O00000o0)) {
        }
    }

    public final Bundle O00000Oo() throws NetworkErrorException {
        throw new UnsupportedOperationException("updateCredentials not supported");
    }

    public final Bundle O00000o0() throws NetworkErrorException {
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", true);
        return bundle;
    }

    private void O000000o(Bundle bundle, AccountAuthenticatorResponse accountAuthenticatorResponse, boolean z, Account account, String str, Bundle bundle2) {
        if (!TextUtils.equals(AccountManager.O000000o(this.O00000Oo).O000000o(account, "has_password"), "true") && !TextUtils.isEmpty(eks.O00000o0(this.O00000Oo, account))) {
            eks.O00000Oo(this.O00000Oo, account);
        }
        String O000000o2 = AccountManager.O000000o(this.O00000Oo).O000000o(account, "has_password");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("userId", account.name);
        bundle2.putBoolean("need_retry_on_authenticator_response_result", z);
        bundle2.putBoolean("has_password", TextUtils.equals(O000000o2, "true"));
        Intent O00000Oo2 = eks.O00000Oo(accountAuthenticatorResponse, bundle2);
        O00000Oo2.putExtra("service_id", str);
        bundle.putParcelable("intent", O00000Oo2);
    }
}
