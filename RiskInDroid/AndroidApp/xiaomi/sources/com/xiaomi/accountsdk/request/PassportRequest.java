package com.xiaomi.accountsdk.request;

import com.xiaomi.account.exception.PassportCAException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import java.io.IOException;

public abstract class PassportRequest {
    public abstract SimpleRequest.StringContent execute() throws IOException, PassportRequestException;

    public final SimpleRequest.StringContent executeEx() throws PassportCAException, InvalidResponseException, InvalidCredentialException, InvalidUserNameException, NeedVerificationException, NeedCaptchaException, IOException, AccessDeniedException, AuthenticationFailureException, NeedNotificationException {
        try {
            return execute();
        } catch (PassportRequestException e) {
            Throwable cause = e.getCause();
            if (cause instanceof InvalidResponseException) {
                throw ((InvalidResponseException) cause);
            } else if (cause instanceof InvalidCredentialException) {
                throw ((InvalidCredentialException) cause);
            } else if (cause instanceof InvalidUserNameException) {
                throw ((InvalidUserNameException) cause);
            } else if (cause instanceof NeedVerificationException) {
                throw ((NeedVerificationException) cause);
            } else if (cause instanceof NeedCaptchaException) {
                throw ((NeedCaptchaException) cause);
            } else if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof AccessDeniedException) {
                throw ((AccessDeniedException) cause);
            } else if (cause instanceof AuthenticationFailureException) {
                throw ((AuthenticationFailureException) cause);
            } else if (cause instanceof NeedNotificationException) {
                throw ((NeedNotificationException) cause);
            } else if (cause instanceof PassportCAException) {
                throw ((PassportCAException) cause);
            } else {
                throw new IllegalStateException("");
            }
        }
    }
}
