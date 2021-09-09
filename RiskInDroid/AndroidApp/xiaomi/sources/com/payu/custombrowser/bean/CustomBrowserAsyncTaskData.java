package com.payu.custombrowser.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class CustomBrowserAsyncTaskData implements Parcelable {
    public static final Parcelable.Creator<CustomBrowserAsyncTaskData> CREATOR = new Parcelable.Creator<CustomBrowserAsyncTaskData>() {
        /* class com.payu.custombrowser.bean.CustomBrowserAsyncTaskData.AnonymousClass1 */

        public final CustomBrowserAsyncTaskData createFromParcel(Parcel parcel) {
            return new CustomBrowserAsyncTaskData(parcel);
        }

        public final CustomBrowserAsyncTaskData[] newArray(int i) {
            return new CustomBrowserAsyncTaskData[i];
        }
    };
    private String contentType;
    private String httpMethod;
    private String postData;
    private String url;

    public int describeContents() {
        return 0;
    }

    protected CustomBrowserAsyncTaskData(Parcel parcel) {
        this.httpMethod = parcel.readString();
        this.url = parcel.readString();
        this.postData = parcel.readString();
        this.contentType = parcel.readString();
    }

    public CustomBrowserAsyncTaskData() {
        this.httpMethod = "GET";
        this.contentType = "application/x-www-form-urlencoded";
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public void setHttpMethod(String str) {
        this.httpMethod = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getPostData() {
        return this.postData;
    }

    public void setPostData(String str) {
        this.postData = str;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.httpMethod);
        parcel.writeString(this.url);
        parcel.writeString(this.postData);
        parcel.writeString(this.contentType);
    }
}
