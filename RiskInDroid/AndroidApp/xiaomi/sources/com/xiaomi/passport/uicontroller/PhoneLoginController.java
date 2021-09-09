package com.xiaomi.passport.uicontroller;

import _m_j.ekt;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.PhoneTicketLoginParams;
import com.xiaomi.accountsdk.account.data.PhoneTokenRegisterParams;
import com.xiaomi.accountsdk.account.data.QueryPhoneInfoParams;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.accountsdk.account.data.SendPhoneTicketParams;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidParameterException;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.InvalidVerifyCodeException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.ReachLimitException;
import com.xiaomi.accountsdk.account.exception.TokenExpiredException;
import com.xiaomi.accountsdk.account.exception.UserRestrictedException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.PassportUserEnvironment;
import com.xiaomi.passport.data.LoginPreference;
import com.xiaomi.passport.uicontroller.SimpleFutureTask;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class PhoneLoginController {
    private static final ExecutorService O00000Oo = Executors.newCachedThreadPool();

    /* renamed from: O000000o  reason: collision with root package name */
    public O00000o0 f6340O000000o = new O00000o0();

    public enum ErrorCode {
        NONE,
        ERROR_UNKNOWN,
        ERROR_AUTH_FAIL,
        ERROR_NETWORK,
        ERROR_SERVER,
        ERROR_ACCESS_DENIED,
        ERROR_INVALID_PARAM,
        ERROR_USER_ACTION_OVER_LIMIT,
        ERROR_PASSWORD,
        ERROR_NON_EXIST_USER,
        ERROR_NO_PHONE
    }

    public interface O000000o {
    }

    public interface O00000Oo {
    }

    public interface O00000o {
    }

    public interface O0000O0o {
    }

    public final SimpleFutureTask<Integer> O000000o(final SendPhoneTicketParams sendPhoneTicketParams, final O00000o o00000o) {
        SimpleFutureTask<Integer> simpleFutureTask = new SimpleFutureTask<>(new Callable<Integer>() {
            /* class com.xiaomi.passport.uicontroller.PhoneLoginController.AnonymousClass2 */

            public Integer call() throws Exception {
                return Integer.valueOf(XMPassport.sendPhoneLoginTicket(sendPhoneTicketParams));
            }
        }, new SimpleFutureTask.O000000o<Integer>() {
            /* class com.xiaomi.passport.uicontroller.PhoneLoginController.AnonymousClass1 */

            public final void O000000o(SimpleFutureTask<Integer> simpleFutureTask) {
                try {
                    ((Integer) simpleFutureTask.get()).intValue();
                } catch (InterruptedException e) {
                    AccountLog.e("PhoneLoginController", "sendPhoneLoginTicket", e);
                    ErrorCode errorCode = ErrorCode.ERROR_UNKNOWN;
                    e.getMessage();
                } catch (ExecutionException e2) {
                    AccountLog.e("PhoneLoginController", "sendPhoneLoginTicket", e2);
                    Throwable cause = e2.getCause();
                    if (cause instanceof NeedCaptchaException) {
                        ((NeedCaptchaException) cause).getCaptchaUrl();
                    } else if (!(cause instanceof TokenExpiredException) && !(cause instanceof ReachLimitException) && !(cause instanceof InvalidPhoneNumException)) {
                        PhoneLoginController.O000000o(cause);
                        if ((cause instanceof InvalidResponseException) && ((InvalidResponseException) cause).getServerError() != null) {
                            e2.getMessage();
                        }
                    }
                }
            }
        });
        O00000Oo.submit(simpleFutureTask);
        return simpleFutureTask;
    }

    public final SimpleFutureTask<RegisterUserInfo> O000000o(final QueryPhoneInfoParams queryPhoneInfoParams, final O00000Oo o00000Oo) {
        SimpleFutureTask<RegisterUserInfo> simpleFutureTask = new SimpleFutureTask<>(new Callable<RegisterUserInfo>() {
            /* class com.xiaomi.passport.uicontroller.PhoneLoginController.AnonymousClass4 */

            public RegisterUserInfo call() throws Exception {
                return PhoneLoginController.this.f6340O000000o.O000000o(queryPhoneInfoParams);
            }
        }, new SimpleFutureTask.O000000o<RegisterUserInfo>() {
            /* class com.xiaomi.passport.uicontroller.PhoneLoginController.AnonymousClass3 */

            public final void O000000o(SimpleFutureTask<RegisterUserInfo> simpleFutureTask) {
                try {
                    if (((RegisterUserInfo) simpleFutureTask.get()).status != RegisterUserInfo.RegisterStatus.STATUS_NOT_REGISTERED) {
                        RegisterUserInfo.RegisterStatus registerStatus = RegisterUserInfo.RegisterStatus.STATUS_REGISTERED_NOT_RECYCLED;
                    }
                } catch (InterruptedException e) {
                    AccountLog.e("PhoneLoginController", "query user phone info", e);
                    ErrorCode errorCode = ErrorCode.ERROR_UNKNOWN;
                    e.getMessage();
                } catch (ExecutionException e2) {
                    AccountLog.e("PhoneLoginController", "query user phone info", e2);
                    Throwable cause = e2.getCause();
                    if (!(cause instanceof InvalidVerifyCodeException) && !(cause instanceof InvalidPhoneNumException)) {
                        PhoneLoginController.O000000o(cause);
                        e2.getMessage();
                    }
                }
            }
        });
        O00000Oo.submit(simpleFutureTask);
        return simpleFutureTask;
    }

    public final SimpleFutureTask<AccountInfo> O000000o(final PhoneTicketLoginParams phoneTicketLoginParams, final O0000O0o o0000O0o) {
        SimpleFutureTask<AccountInfo> simpleFutureTask = new SimpleFutureTask<>(new Callable<AccountInfo>() {
            /* class com.xiaomi.passport.uicontroller.PhoneLoginController.AnonymousClass6 */

            public AccountInfo call() throws Exception {
                PhoneTicketLoginParams phoneTicketLoginParams;
                if (phoneTicketLoginParams.hashedEnvFactors == null) {
                    phoneTicketLoginParams = PhoneTicketLoginParams.copyFrom(phoneTicketLoginParams).hashedEnvFactors(PassportUserEnvironment.O000000o.O000000o().O000000o(XMPassportSettings.getApplicationContext())).build();
                } else {
                    phoneTicketLoginParams = phoneTicketLoginParams;
                }
                return XMPassport.loginByPhone(phoneTicketLoginParams);
            }
        }, new SimpleFutureTask.O000000o<AccountInfo>() {
            /* class com.xiaomi.passport.uicontroller.PhoneLoginController.AnonymousClass5 */

            public final void O000000o(SimpleFutureTask<AccountInfo> simpleFutureTask) {
                try {
                    simpleFutureTask.get();
                } catch (InterruptedException e) {
                    AccountLog.e("PhoneLoginController", "loginByPhoneTicket", e);
                    ErrorCode errorCode = ErrorCode.ERROR_UNKNOWN;
                    e.getMessage();
                } catch (ExecutionException e2) {
                    AccountLog.e("PhoneLoginController", "loginByPhoneTicket", e2);
                    Throwable cause = e2.getCause();
                    if (cause instanceof NeedNotificationException) {
                        ((NeedNotificationException) cause).getNotificationUrl();
                    } else if (!(cause instanceof InvalidPhoneNumException) && !(cause instanceof InvalidVerifyCodeException)) {
                        PhoneLoginController.O000000o(cause);
                        e2.getMessage();
                    }
                }
            }
        });
        O00000Oo.submit(simpleFutureTask);
        return simpleFutureTask;
    }

    public final SimpleFutureTask<AccountInfo> O000000o(final PhoneTokenRegisterParams phoneTokenRegisterParams, final O000000o o000000o) {
        SimpleFutureTask<AccountInfo> simpleFutureTask = new SimpleFutureTask<>(new Callable<AccountInfo>() {
            /* class com.xiaomi.passport.uicontroller.PhoneLoginController.AnonymousClass10 */

            public AccountInfo call() throws Exception {
                return XMPassport.regByPhoneWithToken(phoneTokenRegisterParams);
            }
        }, new SimpleFutureTask.O000000o<AccountInfo>() {
            /* class com.xiaomi.passport.uicontroller.PhoneLoginController.AnonymousClass7 */

            public final void O000000o(SimpleFutureTask<AccountInfo> simpleFutureTask) {
                try {
                    simpleFutureTask.get();
                } catch (InterruptedException e) {
                    AccountLog.e("PhoneLoginController", "registerByPhone", e);
                    ErrorCode errorCode = ErrorCode.ERROR_UNKNOWN;
                    e.getMessage();
                } catch (ExecutionException e2) {
                    AccountLog.e("PhoneLoginController", "registerByPhone", e2);
                    Throwable cause = e2.getCause();
                    if (!(cause instanceof UserRestrictedException) && !(cause instanceof TokenExpiredException)) {
                        if (cause instanceof ReachLimitException) {
                            ErrorCode errorCode2 = ErrorCode.ERROR_USER_ACTION_OVER_LIMIT;
                            e2.getMessage();
                            return;
                        }
                        PhoneLoginController.O000000o(cause);
                        e2.getMessage();
                    }
                }
            }
        });
        O00000Oo.submit(simpleFutureTask);
        return simpleFutureTask;
    }

    public static SimpleFutureTask<LoginPreference> O000000o(final String str) {
        SimpleFutureTask<LoginPreference> simpleFutureTask = new SimpleFutureTask<>(new Callable<LoginPreference>(null) {
            /* class com.xiaomi.passport.uicontroller.PhoneLoginController.AnonymousClass16 */

            public final LoginPreference call() throws Exception {
                return ekt.O000000o(str, null);
            }
        }, null);
        O00000Oo.submit(simpleFutureTask);
        return simpleFutureTask;
    }

    public static ErrorCode O000000o(Throwable th) {
        if (th instanceof InvalidResponseException) {
            return ErrorCode.ERROR_SERVER;
        }
        if (th instanceof IOException) {
            return ErrorCode.ERROR_NETWORK;
        }
        if (th instanceof AuthenticationFailureException) {
            return ErrorCode.ERROR_AUTH_FAIL;
        }
        if (th instanceof AccessDeniedException) {
            return ErrorCode.ERROR_ACCESS_DENIED;
        }
        if (th instanceof InvalidParameterException) {
            return ErrorCode.ERROR_INVALID_PARAM;
        }
        if (th instanceof InvalidUserNameException) {
            return ErrorCode.ERROR_NON_EXIST_USER;
        }
        if (th instanceof InvalidCredentialException) {
            return ErrorCode.ERROR_PASSWORD;
        }
        return ErrorCode.ERROR_UNKNOWN;
    }

    public static class O00000o0 {
        public RegisterUserInfo O000000o(QueryPhoneInfoParams queryPhoneInfoParams) throws Exception {
            return XMPassport.queryPhoneUserInfo(queryPhoneInfoParams);
        }
    }
}
