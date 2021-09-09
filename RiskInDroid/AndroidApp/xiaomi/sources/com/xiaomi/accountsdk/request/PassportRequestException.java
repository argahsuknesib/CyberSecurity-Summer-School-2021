package com.xiaomi.accountsdk.request;

import com.xiaomi.account.exception.PassportCAException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import org.json.JSONException;

public class PassportRequestException extends Exception {
    public PassportRequestException(PassportCAException passportCAException) {
        super(passportCAException);
    }

    public PassportRequestException(AuthenticationFailureException authenticationFailureException) {
        super(authenticationFailureException);
    }

    public PassportRequestException(AccessDeniedException accessDeniedException) {
        super(accessDeniedException);
    }

    public PassportRequestException(InvalidResponseException invalidResponseException) {
        super(invalidResponseException);
    }

    public PassportRequestException(JSONException jSONException) {
        super(jSONException);
    }

    public PassportRequestException(InvalidCredentialException invalidCredentialException) {
        super(invalidCredentialException);
    }

    public PassportRequestException(InvalidUserNameException invalidUserNameException) {
        super(invalidUserNameException);
    }

    public PassportRequestException(NeedVerificationException needVerificationException) {
        super(needVerificationException);
    }

    public PassportRequestException(NeedCaptchaException needCaptchaException) {
        super(needCaptchaException);
    }

    public PassportRequestException(NeedNotificationException needNotificationException) {
        super(needNotificationException);
    }
}
