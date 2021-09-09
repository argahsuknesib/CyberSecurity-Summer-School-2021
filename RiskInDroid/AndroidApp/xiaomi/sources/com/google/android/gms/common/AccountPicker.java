package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class AccountPicker {
    private AccountPicker() {
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle) {
        return newChooseAccountIntent(account, arrayList, strArr, z, str, str2, strArr2, bundle, false);
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle, boolean z2) {
        return newChooseAccountIntent(account, arrayList, strArr, z, str, str2, strArr2, bundle, z2, 0, 0);
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle, boolean z2, int i, int i2) {
        return newChooseAccountIntent(account, arrayList, strArr, z, str, str2, strArr2, bundle, z2, i, i2, null, false);
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle, boolean z2, int i, int i2, String str3, boolean z3) {
        Intent intent = new Intent();
        if (!z3) {
            Preconditions.checkArgument(str3 == null, "We only support hostedDomain filter for account chip styled account picker");
        }
        intent.setAction(z3 ? "com.google.android.gms.common.account.CHOOSE_ACCOUNT_USERTILE" : "com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", strArr);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", z);
        intent.putExtra("descriptionTextOverride", str);
        intent.putExtra("authTokenType", str2);
        intent.putExtra("addAccountRequiredFeatures", strArr2);
        intent.putExtra("setGmsCoreAccount", z2);
        intent.putExtra("overrideTheme", i);
        intent.putExtra("overrideCustomTheme", i2);
        intent.putExtra("hostedDomainFilter", str3);
        return intent;
    }
}
