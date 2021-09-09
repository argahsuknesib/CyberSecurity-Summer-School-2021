package com.xiaomi.passport.servicetoken;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ServiceTokenResult implements Parcelable {
    public static final Parcelable.Creator<ServiceTokenResult> CREATOR = new Parcelable.Creator<ServiceTokenResult>() {
        /* class com.xiaomi.passport.servicetoken.ServiceTokenResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ServiceTokenResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ServiceTokenResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f6200O000000o;
    public final String O00000Oo;
    public final ErrorCode O00000o;
    public final String O00000o0;
    public final String O00000oO;
    public final String O00000oo;
    public final Intent O0000O0o;
    public final String O0000OOo;
    public final String O0000Oo;
    public final String O0000Oo0;
    public final boolean O0000OoO;
    public final boolean O0000Ooo;
    public final String O0000o00;

    public enum ErrorCode {
        ERROR_UNKNOWN,
        ERROR_NONE,
        ERROR_NO_ACCOUNT,
        ERROR_APP_PERMISSION_FORBIDDEN,
        ERROR_IOERROR,
        ERROR_OLD_MIUI_ACCOUNT_MANAGER_PERMISSION_ISSUE,
        ERROR_CANCELLED,
        ERROR_AUTHENTICATOR_ERROR,
        ERROR_TIME_OUT,
        ERROR_REMOTE_EXCEPTION,
        ERROR_USER_INTERACTION_NEEDED
    }

    public int describeContents() {
        return 0;
    }

    /* synthetic */ ServiceTokenResult(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private ServiceTokenResult(O000000o o000000o) {
        this.f6200O000000o = o000000o.f6201O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000oO = o000000o.O00000o;
        this.O00000o = o000000o.O00000oo;
        this.O0000O0o = o000000o.O0000O0o;
        this.O00000oo = o000000o.O00000oO;
        this.O0000OOo = o000000o.O0000OOo;
        this.O0000Oo0 = o000000o.O0000Oo0;
        this.O0000Oo = o000000o.O0000Oo;
        this.O0000OoO = o000000o.O0000OoO;
        this.O0000Ooo = o000000o.O0000Ooo;
        this.O0000o00 = o000000o.O0000o00;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServiceTokenResult)) {
            return false;
        }
        ServiceTokenResult serviceTokenResult = (ServiceTokenResult) obj;
        if (this.O0000o00 != serviceTokenResult.O0000o00 || this.O0000OoO != serviceTokenResult.O0000OoO || this.O0000Ooo != serviceTokenResult.O0000Ooo) {
            return false;
        }
        String str = this.f6200O000000o;
        if (str == null ? serviceTokenResult.f6200O000000o != null : !str.equals(serviceTokenResult.f6200O000000o)) {
            return false;
        }
        String str2 = this.O00000Oo;
        if (str2 == null ? serviceTokenResult.O00000Oo != null : !str2.equals(serviceTokenResult.O00000Oo)) {
            return false;
        }
        String str3 = this.O00000o0;
        if (str3 == null ? serviceTokenResult.O00000o0 != null : !str3.equals(serviceTokenResult.O00000o0)) {
            return false;
        }
        if (this.O00000o != serviceTokenResult.O00000o) {
            return false;
        }
        String str4 = this.O00000oO;
        if (str4 == null ? serviceTokenResult.O00000oO != null : !str4.equals(serviceTokenResult.O00000oO)) {
            return false;
        }
        String str5 = this.O00000oo;
        if (str5 == null ? serviceTokenResult.O00000oo != null : !str5.equals(serviceTokenResult.O00000oo)) {
            return false;
        }
        Intent intent = this.O0000O0o;
        if (intent == null ? serviceTokenResult.O0000O0o != null : !intent.equals(serviceTokenResult.O0000O0o)) {
            return false;
        }
        String str6 = this.O0000OOo;
        if (str6 == null ? serviceTokenResult.O0000OOo != null : !str6.equals(serviceTokenResult.O0000OOo)) {
            return false;
        }
        String str7 = this.O0000Oo0;
        if (str7 == null ? serviceTokenResult.O0000Oo0 != null : !str7.equals(serviceTokenResult.O0000Oo0)) {
            return false;
        }
        String str8 = this.O0000Oo;
        if (str8 != null) {
            return str8.equals(serviceTokenResult.O0000Oo);
        }
        return serviceTokenResult.O0000Oo == null;
    }

    public int hashCode() {
        String str = this.f6200O000000o;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.O00000Oo;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.O00000o0;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ErrorCode errorCode = this.O00000o;
        int hashCode4 = (hashCode3 + (errorCode != null ? errorCode.hashCode() : 0)) * 31;
        String str4 = this.O00000oO;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.O00000oo;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Intent intent = this.O0000O0o;
        int hashCode7 = (hashCode6 + (intent != null ? intent.hashCode() : 0)) * 31;
        String str6 = this.O0000OOo;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.O0000Oo0;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.O0000Oo;
        int hashCode10 = (((((hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31) + (this.O0000OoO ? 1 : 0)) * 31) + (this.O0000Ooo ? 1 : 0)) * 31;
        String str9 = this.O0000o00;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return hashCode10 + i;
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f6201O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public ErrorCode O00000oo = ErrorCode.ERROR_NONE;
        public Intent O0000O0o;
        public String O0000OOo;
        public String O0000Oo;
        public String O0000Oo0;
        public boolean O0000OoO;
        public boolean O0000Ooo;
        public String O0000o00;

        public O000000o(String str) {
            this.f6201O000000o = str;
        }

        public final O000000o O000000o(String str) {
            this.O00000Oo = str;
            return this;
        }

        public final O000000o O00000Oo(String str) {
            this.O00000o0 = str;
            return this;
        }

        public final ServiceTokenResult O000000o() {
            return new ServiceTokenResult(this, (byte) 0);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = -1;
        if (this.O0000Ooo) {
            parcel.writeString(this.f6200O000000o);
            parcel.writeString(this.O00000Oo);
            parcel.writeString(this.O00000o0);
            ErrorCode errorCode = this.O00000o;
            if (errorCode != null) {
                i2 = errorCode.ordinal();
            }
            parcel.writeInt(i2);
            parcel.writeString(this.O00000oO);
            parcel.writeString(this.O00000oo);
            parcel.writeParcelable(this.O0000O0o, i);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("sid", this.f6200O000000o);
        bundle.putString("serviceToken", this.O00000Oo);
        bundle.putString("security", this.O00000o0);
        ErrorCode errorCode2 = this.O00000o;
        if (errorCode2 != null) {
            i2 = errorCode2.ordinal();
        }
        bundle.putInt("errorCode", i2);
        bundle.putString("errorMessage", this.O00000oO);
        bundle.putString("stackTrace", this.O00000oo);
        bundle.putParcelable("intent", this.O0000O0o);
        bundle.putString("slh", this.O0000OOo);
        bundle.putString("ph", this.O0000Oo0);
        bundle.putString("cUserId", this.O0000Oo);
        bundle.putBoolean("peeked", this.O0000OoO);
        bundle.putString("userId", this.O0000o00);
        parcel.writeString("V2#");
        parcel.writeBundle(bundle);
    }

    protected ServiceTokenResult(Parcel parcel) {
        ErrorCode errorCode;
        String readString = parcel.readString();
        ErrorCode errorCode2 = null;
        if (!TextUtils.equals("V2#", readString)) {
            this.f6200O000000o = readString;
            this.O00000Oo = parcel.readString();
            this.O00000o0 = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt == -1) {
                errorCode = null;
            } else {
                errorCode = ErrorCode.values()[readInt];
            }
            this.O00000o = errorCode;
            this.O00000oO = parcel.readString();
            this.O00000oo = parcel.readString();
            this.O0000O0o = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            this.O0000Oo = null;
            this.O0000OoO = false;
            this.O0000Ooo = false;
            this.O0000o00 = null;
            return;
        }
        Bundle readBundle = parcel.readBundle(Intent.class.getClassLoader());
        this.f6200O000000o = readBundle.getString("sid");
        this.O00000Oo = readBundle.getString("serviceToken");
        this.O00000o0 = readBundle.getString("security");
        int i = readBundle.getInt("errorCode");
        this.O00000o = i != -1 ? ErrorCode.values()[i] : errorCode2;
        this.O00000oO = readBundle.getString("errorMessage");
        this.O00000oo = readBundle.getString("stackTrace");
        this.O0000O0o = (Intent) readBundle.getParcelable("intent");
        this.O0000OOo = readBundle.getString("slh");
        this.O0000Oo0 = readBundle.getString("ph");
        this.O0000Oo = readBundle.getString("cUserId");
        this.O0000OoO = readBundle.getBoolean("peeked");
        this.O0000Ooo = true;
        this.O0000o00 = readBundle.getString("userId");
    }

    public String toString() {
        String str;
        if (TextUtils.isEmpty(this.O0000o00) || this.O0000o00.length() <= 3) {
            str = this.O0000Oo;
        } else {
            str = TextUtils.substring(this.O0000o00, 0, 2) + "****";
        }
        StringBuffer stringBuffer = new StringBuffer("ServiceTokenResult{");
        stringBuffer.append("userId=");
        stringBuffer.append(str);
        stringBuffer.append('\'');
        stringBuffer.append(", sid='");
        stringBuffer.append(this.f6200O000000o);
        stringBuffer.append('\'');
        stringBuffer.append(", serviceToken='");
        stringBuffer.append("serviceTokenMasked");
        stringBuffer.append('\'');
        stringBuffer.append(", security='");
        stringBuffer.append("securityMasked");
        stringBuffer.append('\'');
        stringBuffer.append(", errorCode=");
        stringBuffer.append(this.O00000o);
        stringBuffer.append(", errorMessage='");
        stringBuffer.append(this.O00000oO);
        stringBuffer.append('\'');
        stringBuffer.append(", errorStackTrace='");
        stringBuffer.append(this.O00000oo);
        stringBuffer.append('\'');
        stringBuffer.append(", intent=");
        stringBuffer.append(this.O0000O0o);
        stringBuffer.append(", slh='");
        stringBuffer.append(this.O0000OOo);
        stringBuffer.append('\'');
        stringBuffer.append(", ph='");
        stringBuffer.append(this.O0000Oo0);
        stringBuffer.append('\'');
        stringBuffer.append(", cUserId='");
        stringBuffer.append(this.O0000Oo);
        stringBuffer.append('\'');
        stringBuffer.append(", peeked=");
        stringBuffer.append(this.O0000OoO);
        stringBuffer.append('\'');
        stringBuffer.append(", useV1Parcel=");
        stringBuffer.append(this.O0000Ooo);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
