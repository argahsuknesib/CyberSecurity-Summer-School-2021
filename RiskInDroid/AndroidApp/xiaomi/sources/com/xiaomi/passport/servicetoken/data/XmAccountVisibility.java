package com.xiaomi.passport.servicetoken.data;

import android.accounts.Account;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class XmAccountVisibility implements Parcelable {
    public static final Parcelable.Creator<XmAccountVisibility> CREATOR = new Parcelable.Creator<XmAccountVisibility>() {
        /* class com.xiaomi.passport.servicetoken.data.XmAccountVisibility.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new XmAccountVisibility[0];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new XmAccountVisibility(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final ErrorCode f6203O000000o;
    public final String O00000Oo;
    public final Account O00000o;
    public final boolean O00000o0;
    public final int O00000oO;
    public final Intent O00000oo;

    public int describeContents() {
        return 0;
    }

    public enum ErrorCode {
        ERROR_NONE("successful"),
        ERROR_NOT_SUPPORT("no support account service"),
        ERROR_PRE_ANDROID_O("no support account service, and pre o version"),
        ERROR_NO_ACCOUNT("no account"),
        ERROR_NO_PERMISSION("no access account service permission"),
        ERROR_CANCELLED("task cancelled"),
        ERROR_EXECUTION("execution error"),
        ERROR_UNKNOWN("unknown");
        
        String errorMsg;

        private ErrorCode(String str) {
            this.errorMsg = str;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final ErrorCode f6204O000000o;
        public final String O00000Oo;
        public Account O00000o;
        public boolean O00000o0;
        public int O00000oO = Build.VERSION.SDK_INT;
        public Intent O00000oo;

        public O000000o(ErrorCode errorCode, String str) {
            this.f6204O000000o = errorCode;
            this.O00000Oo = TextUtils.isEmpty(str) ? errorCode.errorMsg : str;
        }

        public final O000000o O000000o(Account account) {
            this.O00000o0 = true;
            this.O00000o = account;
            return this;
        }

        public final XmAccountVisibility O000000o() {
            return new XmAccountVisibility(this);
        }
    }

    public XmAccountVisibility(O000000o o000000o) {
        this.f6203O000000o = o000000o.f6204O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
        this.O00000oo = o000000o.O00000oo;
    }

    public XmAccountVisibility(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        this.f6203O000000o = ErrorCode.values()[readBundle.getInt("error_code")];
        this.O00000Oo = readBundle.getString("error_msg");
        this.O00000o0 = readBundle.getBoolean("visible");
        this.O00000o = (Account) readBundle.getParcelable("account");
        this.O00000oO = readBundle.getInt("build_sdk_version");
        this.O00000oo = (Intent) readBundle.getParcelable("new_choose_account_intent");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("error_code", this.f6203O000000o.ordinal());
        bundle.putString("error_msg", this.O00000Oo);
        bundle.putBoolean("visible", this.O00000o0);
        bundle.putParcelable("account", this.O00000o);
        bundle.putInt("build_sdk_version", this.O00000oO);
        bundle.putParcelable("new_choose_account_intent", this.O00000oo);
        parcel.writeBundle(bundle);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AccountVisibility{");
        stringBuffer.append(", errorCode=");
        stringBuffer.append(this.f6203O000000o);
        stringBuffer.append(", errorMessage='");
        stringBuffer.append(this.O00000Oo);
        stringBuffer.append('\'');
        stringBuffer.append(", accountVisible='");
        stringBuffer.append(this.O00000o0);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
