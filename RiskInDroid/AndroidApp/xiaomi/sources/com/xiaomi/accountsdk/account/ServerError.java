package com.xiaomi.accountsdk.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.accountsdk.request.SimpleRequest;
import org.json.JSONObject;

public class ServerError implements Parcelable {
    public static final Parcelable.Creator<ServerError> CREATOR = new Parcelable.Creator<ServerError>() {
        /* class com.xiaomi.accountsdk.account.ServerError.AnonymousClass1 */

        public final ServerError createFromParcel(Parcel parcel) {
            return new ServerError(parcel);
        }

        public final ServerError[] newArray(int i) {
            return new ServerError[i];
        }
    };
    private String tips;
    private String title;

    public int describeContents() {
        return 0;
    }

    public ServerError(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.tips = jSONObject.optString("tips");
            this.title = jSONObject.optString("title");
        }
    }

    public ServerError(SimpleRequest.MapContent mapContent) {
        if (mapContent != null) {
            Object fromBody = mapContent.getFromBody("title");
            Object fromBody2 = mapContent.getFromBody("tips");
            if (fromBody instanceof String) {
                this.title = (String) fromBody;
            }
            if (fromBody2 instanceof String) {
                this.tips = (String) fromBody2;
            }
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getTips() {
        return this.tips;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.tips);
    }

    private ServerError(Parcel parcel) {
        this.title = parcel.readString();
        this.tips = parcel.readString();
    }
}
