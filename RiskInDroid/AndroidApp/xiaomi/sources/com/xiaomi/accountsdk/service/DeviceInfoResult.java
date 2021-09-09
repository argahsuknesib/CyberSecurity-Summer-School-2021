package com.xiaomi.accountsdk.service;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class DeviceInfoResult implements Parcelable {
    public static final Parcelable.Creator<DeviceInfoResult> CREATOR = new Parcelable.Creator<DeviceInfoResult>() {
        /* class com.xiaomi.accountsdk.service.DeviceInfoResult.AnonymousClass1 */

        public final DeviceInfoResult createFromParcel(Parcel parcel) {
            return new DeviceInfoResult(parcel);
        }

        public final DeviceInfoResult[] newArray(int i) {
            return new DeviceInfoResult[i];
        }
    };
    public final Bundle deviceInfo;
    public final ErrorCode errorCode;
    public final String errorMessage;
    public final String errorStackTrace;

    public enum ErrorCode {
        ERROR_UNKNOWN,
        ERROR_NONE,
        ERROR_APP_PERMISSION_FORBIDDEN,
        ERROR_TIME_OUT,
        ERROR_NOT_SUPPORTED,
        ERROR_EXECUTION_EXCEPTION,
        ERROR_QUERY_TOO_FREQUENTLY
    }

    public int describeContents() {
        return 0;
    }

    private DeviceInfoResult(Builder builder) {
        this.deviceInfo = builder.deviceInfo;
        this.errorMessage = builder.errorMessage;
        this.errorCode = builder.errorCode;
        this.errorStackTrace = builder.errorStackTrace;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfoResult)) {
            return false;
        }
        DeviceInfoResult deviceInfoResult = (DeviceInfoResult) obj;
        Bundle bundle = this.deviceInfo;
        if (bundle == null ? deviceInfoResult.deviceInfo != null : !bundle.equals(deviceInfoResult.deviceInfo)) {
            return false;
        }
        if (this.errorCode != deviceInfoResult.errorCode) {
            return false;
        }
        String str = this.errorMessage;
        if (str == null ? deviceInfoResult.errorMessage != null : !str.equals(deviceInfoResult.errorMessage)) {
            return false;
        }
        String str2 = this.errorStackTrace;
        return str2 == null ? deviceInfoResult.errorStackTrace == null : str2.equals(deviceInfoResult.errorStackTrace);
    }

    public int hashCode() {
        Bundle bundle = this.deviceInfo;
        int i = 0;
        int hashCode = (bundle != null ? bundle.hashCode() : 0) * 31;
        ErrorCode errorCode2 = this.errorCode;
        int hashCode2 = (hashCode + (errorCode2 != null ? errorCode2.hashCode() : 0)) * 31;
        String str = this.errorMessage;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.errorStackTrace;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public static final class Builder {
        public final Bundle deviceInfo;
        public ErrorCode errorCode = ErrorCode.ERROR_NONE;
        public String errorMessage;
        public String errorStackTrace;

        public Builder(Bundle bundle) {
            this.deviceInfo = bundle;
        }

        public final Builder errorMessage(String str) {
            this.errorMessage = str;
            return this;
        }

        public final Builder errorStackTrace(String str) {
            this.errorStackTrace = str;
            return this;
        }

        public final Builder errorCode(ErrorCode errorCode2) {
            this.errorCode = errorCode2;
            return this;
        }

        public static Builder copyFrom(DeviceInfoResult deviceInfoResult) {
            return new Builder(deviceInfoResult.deviceInfo).errorCode(deviceInfoResult.errorCode).errorMessage(deviceInfoResult.errorMessage).errorStackTrace(deviceInfoResult.errorStackTrace);
        }

        public final DeviceInfoResult build() {
            return new DeviceInfoResult(this);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putBundle("device_info", this.deviceInfo);
        ErrorCode errorCode2 = this.errorCode;
        bundle.putInt("error_code", errorCode2 == null ? -1 : errorCode2.ordinal());
        bundle.putString("error_message", this.errorMessage);
        bundle.putString("stacktrace", this.errorStackTrace);
        parcel.writeBundle(bundle);
    }

    protected DeviceInfoResult(Parcel parcel) {
        ErrorCode errorCode2;
        Bundle readBundle = parcel.readBundle(DeviceInfoResult.class.getClassLoader());
        this.deviceInfo = readBundle.getBundle("device_info");
        int i = readBundle.getInt("error_code");
        if (i == -1) {
            errorCode2 = null;
        } else {
            errorCode2 = ErrorCode.values()[i];
        }
        this.errorCode = errorCode2;
        this.errorMessage = readBundle.getString("error_message");
        this.errorStackTrace = readBundle.getString("stacktrace");
    }
}
