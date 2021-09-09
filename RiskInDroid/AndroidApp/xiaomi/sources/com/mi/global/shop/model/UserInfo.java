package com.mi.global.shop.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

public class UserInfo implements Parcelable {
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        /* class com.mi.global.shop.model.UserInfo.AnonymousClass1 */

        public final UserInfo createFromParcel(Parcel parcel) {
            return new UserInfo(parcel);
        }

        public final UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }
    };
    @SerializedName("icon")
    public String mAvatarUrl;
    @SerializedName("big_icon")
    public String mBigAvatarUrl;
    @SerializedName("eUserId")
    public String mEncryptionId;
    @SerializedName("tip_info")
    public UserCentralTip mTips;
    @SerializedName("userId")
    private String mUserId;
    @SerializedName("userName")
    private String mUserName;

    public int describeContents() {
        return 0;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getEncryptionId() {
        return this.mEncryptionId;
    }

    public static UserInfo fromJSONObject(JSONObject jSONObject) {
        try {
            return (UserInfo) new Gson().fromJson(jSONObject.getJSONObject("data").toString(), UserInfo.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUserId);
        parcel.writeString(this.mUserName);
        parcel.writeString(this.mAvatarUrl);
        parcel.writeString(this.mEncryptionId);
        parcel.writeParcelable(this.mTips, i);
    }

    public UserInfo() {
    }

    private UserInfo(Parcel parcel) {
        this.mUserId = parcel.readString();
        this.mUserName = parcel.readString();
        this.mAvatarUrl = parcel.readString();
        this.mEncryptionId = parcel.readString();
        this.mTips = (UserCentralTip) parcel.readParcelable(UserCentralTip.class.getClassLoader());
    }

    public String toString() {
        return "UserInfo{mUserId='" + this.mUserId + '\'' + ", mUserName='" + this.mUserName + '\'' + ", mAvatarUrl='" + this.mAvatarUrl + '\'' + ", mTips=" + this.mTips + '}';
    }
}
