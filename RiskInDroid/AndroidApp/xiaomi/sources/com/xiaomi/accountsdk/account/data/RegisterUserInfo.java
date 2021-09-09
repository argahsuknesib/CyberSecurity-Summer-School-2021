package com.xiaomi.accountsdk.account.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.accountsdk.utils.AccountLog;

public class RegisterUserInfo implements Parcelable {
    public static final Parcelable.Creator<RegisterUserInfo> CREATOR = new Parcelable.Creator<RegisterUserInfo>() {
        /* class com.xiaomi.accountsdk.account.data.RegisterUserInfo.AnonymousClass1 */

        public final RegisterUserInfo createFromParcel(Parcel parcel) {
            Bundle readBundle = parcel.readBundle();
            if (readBundle == null) {
                return null;
            }
            return new Builder(readBundle.getInt("register_status")).userId(readBundle.getString("user_id")).userName(readBundle.getString("user_name")).avatarAddress(readBundle.getString("avatar_address")).ticketToken(readBundle.getString("ticket_token")).phone(readBundle.getString("phone")).maskedUserId(readBundle.getString("masked_user_id")).hasPwd(readBundle.getBoolean("has_pwd")).bindTime(readBundle.getLong("bind_time")).needToast(readBundle.getBoolean("need_toast")).needGetActiveTime(readBundle.getBoolean("need_get_active_time")).registerPwd(readBundle.getBoolean("register_pwd")).tmpPhoneToken(readBundle.getString("tmp_phone_token")).build();
        }

        public final RegisterUserInfo[] newArray(int i) {
            return new RegisterUserInfo[0];
        }
    };
    @Deprecated
    public static final int STATUS_NOT_REGISTERED = 0;
    @Deprecated
    public static final int STATUS_USED_NOT_RECYCLED = 2;
    @Deprecated
    public static final int STATUS_USED_POSSIBLY_RECYCLED = 1;
    public final String avatarAddress;
    public final long bindTime;
    public final boolean hasPwd;
    public final String maskedUserId;
    public final boolean needGetActiveTime;
    public final boolean needToast;
    public final String phone;
    public final boolean registerPwd;
    public final RegisterStatus status;
    public final String ticketToken;
    public final String tmpPhoneToken;
    public final String userId;
    public final String userName;

    public int describeContents() {
        return 0;
    }

    public enum RegisterStatus {
        STATUS_NOT_REGISTERED(0),
        STATUS_USED_POSSIBLY_RECYCLED(1),
        STATUS_REGISTERED_NOT_RECYCLED(2);
        
        public final int value;

        private RegisterStatus(int i) {
            this.value = i;
        }

        public static RegisterStatus getInstance(int i) {
            for (RegisterStatus registerStatus : values()) {
                if (i == registerStatus.value) {
                    return registerStatus;
                }
            }
            AccountLog.w("RegisterStatus", "has not this status value: ".concat(String.valueOf(i)));
            return null;
        }
    }

    @Deprecated
    public RegisterUserInfo(int i, String str, String str2, String str3, String str4) {
        this.status = RegisterStatus.getInstance(i);
        this.userId = str;
        this.userName = str2;
        this.avatarAddress = str3;
        this.ticketToken = str4;
        this.phone = null;
        this.maskedUserId = null;
        this.hasPwd = false;
        this.bindTime = -1;
        this.needGetActiveTime = false;
        this.needToast = false;
        this.registerPwd = true;
        this.tmpPhoneToken = null;
    }

    private RegisterUserInfo(Builder builder) {
        this.status = RegisterStatus.getInstance(builder.status);
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.avatarAddress = builder.avatarAddress;
        this.ticketToken = builder.ticketToken;
        this.phone = builder.phone;
        this.maskedUserId = builder.maskedUserId;
        this.hasPwd = builder.hasPwd;
        this.bindTime = builder.bindTime;
        this.needGetActiveTime = builder.needGetActiveTime;
        this.needToast = builder.needToast;
        this.registerPwd = builder.registerPwd;
        this.tmpPhoneToken = builder.tmpPhoneToken;
    }

    @Deprecated
    public int getStatus() {
        return this.status.value;
    }

    @Deprecated
    public String getUserName() {
        return this.userName;
    }

    @Deprecated
    public String getAvartarAddress() {
        return this.avatarAddress;
    }

    @Deprecated
    public String getUserId() {
        return this.userId;
    }

    @Deprecated
    public String getTicketToken() {
        return this.ticketToken;
    }

    public static Builder copyFrom(RegisterUserInfo registerUserInfo) {
        if (registerUserInfo == null) {
            return null;
        }
        return new Builder(registerUserInfo.status.value).userId(registerUserInfo.userId).userName(registerUserInfo.userName).avatarAddress(registerUserInfo.avatarAddress).ticketToken(registerUserInfo.ticketToken).phone(registerUserInfo.phone).tmpPhoneToken(registerUserInfo.tmpPhoneToken).maskedUserId(registerUserInfo.maskedUserId).hasPwd(registerUserInfo.hasPwd).bindTime(registerUserInfo.bindTime).needGetActiveTime(registerUserInfo.needGetActiveTime).needToast(registerUserInfo.needToast);
    }

    public static class Builder {
        public String avatarAddress;
        public long bindTime;
        public boolean hasPwd;
        public String maskedUserId;
        public boolean needGetActiveTime;
        public boolean needToast;
        public String phone;
        public boolean registerPwd;
        public int status;
        public String ticketToken;
        public String tmpPhoneToken;
        public String userId;
        public String userName;

        public Builder(int i) {
            this.status = i;
        }

        public Builder status(int i) {
            this.status = i;
            return this;
        }

        public Builder userId(String str) {
            this.userId = str;
            return this;
        }

        public Builder userName(String str) {
            this.userName = str;
            return this;
        }

        public Builder avatarAddress(String str) {
            this.avatarAddress = str;
            return this;
        }

        public Builder ticketToken(String str) {
            this.ticketToken = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder maskedUserId(String str) {
            this.maskedUserId = str;
            return this;
        }

        public Builder hasPwd(boolean z) {
            this.hasPwd = z;
            return this;
        }

        public Builder bindTime(long j) {
            this.bindTime = j;
            return this;
        }

        public Builder needGetActiveTime(boolean z) {
            this.needGetActiveTime = z;
            return this;
        }

        public Builder needToast(boolean z) {
            this.needToast = z;
            return this;
        }

        public Builder registerPwd(boolean z) {
            this.registerPwd = z;
            return this;
        }

        public Builder tmpPhoneToken(String str) {
            this.tmpPhoneToken = str;
            return this;
        }

        public RegisterUserInfo build() {
            return new RegisterUserInfo(this);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("register_status", this.status.value);
        bundle.putString("user_id", this.userId);
        bundle.putString("user_name", this.userName);
        bundle.putString("avatar_address", this.avatarAddress);
        bundle.putString("ticket_token", this.ticketToken);
        bundle.putString("phone", this.phone);
        bundle.putString("masked_user_id", this.maskedUserId);
        bundle.putBoolean("has_pwd", this.hasPwd);
        bundle.putLong("bind_time", this.bindTime);
        bundle.putBoolean("need_toast", this.needToast);
        bundle.putBoolean("need_get_active_time", this.needGetActiveTime);
        bundle.putBoolean("register_pwd", this.registerPwd);
        bundle.putString("tmp_phone_token", this.tmpPhoneToken);
        parcel.writeBundle(bundle);
    }
}
