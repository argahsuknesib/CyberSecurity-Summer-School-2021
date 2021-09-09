package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.io.Serializable;

public class BaseWebViewRequestData implements Parcelable, Serializable {
    public static final Parcelable.Creator<BaseWebViewRequestData> CREATOR = new Parcelable.Creator<BaseWebViewRequestData>() {
        /* class com.sina.weibo.sdk.web.BaseWebViewRequestData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BaseWebViewRequestData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BaseWebViewRequestData(parcel);
        }
    };
    public AuthInfo authInfo;
    public String callback;
    private int callbackType = 0;
    String specifyTitle;
    public WebRequestType type;
    public String url;

    public int describeContents() {
        return 0;
    }

    public BaseWebViewRequestData(AuthInfo authInfo2, WebRequestType webRequestType, String str, int i, String str2, String str3) {
        this.callback = str;
        this.authInfo = authInfo2;
        this.type = webRequestType;
        this.specifyTitle = str2;
        this.url = str3;
        this.callbackType = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeParcelable(this.authInfo, i);
        WebRequestType webRequestType = this.type;
        parcel.writeInt(webRequestType == null ? -1 : webRequestType.ordinal());
        parcel.writeString(this.callback);
        parcel.writeString(this.specifyTitle);
        parcel.writeInt(this.callbackType);
    }

    protected BaseWebViewRequestData(Parcel parcel) {
        WebRequestType webRequestType;
        this.url = parcel.readString();
        this.authInfo = (AuthInfo) parcel.readParcelable(AuthInfo.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt == -1) {
            webRequestType = null;
        } else {
            webRequestType = WebRequestType.values()[readInt];
        }
        this.type = webRequestType;
        this.callback = parcel.readString();
        this.specifyTitle = parcel.readString();
        this.callbackType = parcel.readInt();
    }
}
