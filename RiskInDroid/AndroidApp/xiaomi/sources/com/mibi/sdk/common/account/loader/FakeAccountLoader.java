package com.mibi.sdk.common.account.loader;

import android.accounts.Account;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.mibi.sdk.common.account.AccountToken;
import com.mibi.sdk.common.exception.PaymentException;

public class FakeAccountLoader implements AccountLoader {
    public static final Parcelable.Creator<AccountLoader> CREATOR = new Parcelable.Creator<AccountLoader>() {
        /* class com.mibi.sdk.common.account.loader.FakeAccountLoader.AnonymousClass1 */

        public final FakeAccountLoader[] newArray(int i) {
            return new FakeAccountLoader[i];
        }

        public final AccountLoader createFromParcel(Parcel parcel) {
            return new FakeAccountLoader();
        }
    };

    public int describeContents() {
        return 0;
    }

    public String getUserId() {
        return "-1";
    }

    public boolean isAccountChanged(Context context) {
        return false;
    }

    public void load(Context context) throws PaymentException {
    }

    public void reload(Context context) throws PaymentException {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public static boolean isFakeAccount(Account account) {
        if (account == null) {
            return false;
        }
        return TextUtils.equals("-1", account.name);
    }

    public AccountToken getAccountToken() {
        return new AccountToken("-1", "", "", "");
    }
}
