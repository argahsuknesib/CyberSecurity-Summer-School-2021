package com.mibi.sdk.account;

import android.accounts.AccountsException;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.account.ILoginProvider;
import com.xiaomi.accountsdk.account.exception.IllegalDeviceException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.passport.LocalFeatures.LocalFeaturesImpl;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import java.io.IOException;

public class LoginProviderImpl implements ILoginProvider {
    private MiAccountManager mAccountManager;

    public LoginProviderImpl(Context context) {
        this.mAccountManager = MiAccountManager.O00000Oo(context);
    }

    public String getStsUrl(Activity activity, String str, String str2, String str3) throws AccountsException, IOException {
        try {
            return ((Bundle) LocalFeaturesImpl.O000000o(this.mAccountManager.f6195O000000o).O000000o(str, str2, str3, activity).getResult()).getString("sts_url");
        } catch (OperationCanceledException e) {
            throw e;
        } catch (AuthenticatorException e2) {
            throw e2;
        } catch (IOException e3) {
            throw e3;
        } catch (InvalidCredentialException e4) {
            throw new AccountsException(e4);
        } catch (InvalidUserNameException e5) {
            throw new AccountsException(e5);
        } catch (AccessDeniedException e6) {
            throw new AccountsException(e6);
        } catch (InvalidResponseException e7) {
            throw new AccountsException(e7);
        } catch (IllegalDeviceException e8) {
            throw new AccountsException(e8);
        } catch (AuthenticationFailureException e9) {
            throw new AccountsException(e9);
        }
    }
}
