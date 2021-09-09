package com.ximalaya.ting.android.opensdk.player.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class XmPlayerException extends Exception implements Parcelable {
    public static final Parcelable.Creator<XmPlayerException> CREATOR = new Parcelable.Creator<XmPlayerException>() {
        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerException.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new XmPlayerException[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new XmPlayerException(parcel);
        }
    };
    private static final long serialVersionUID = 8102305468025663148L;
    private String mCause;
    private int mExtra;
    private int mWhat;

    public int describeContents() {
        return 0;
    }

    public XmPlayerException() {
        this("");
    }

    public XmPlayerException(Parcel parcel) {
        this(parcel.readString());
        this.mWhat = parcel.readInt();
        this.mExtra = parcel.readInt();
    }

    public XmPlayerException(int i, int i2) {
        this("Player Status Exception, what = " + i + ", extra = " + i2);
        this.mWhat = i;
        this.mExtra = i2;
    }

    public XmPlayerException(String str) {
        super(str);
        this.mCause = str;
    }

    public String getMessage() {
        if (!TextUtils.isEmpty(this.mCause)) {
            return this.mCause;
        }
        return super.getMessage();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCause);
        parcel.writeInt(this.mWhat);
        parcel.writeInt(this.mExtra);
    }

    public void readFromParcel(Parcel parcel) {
        this.mCause = parcel.readString();
        this.mWhat = parcel.readInt();
        this.mExtra = parcel.readInt();
    }

    public String toString() {
        return "XmPlayerException{mWhat=" + this.mWhat + ", mExtra=" + this.mExtra + ", mCause='" + this.mCause + '\'' + '}';
    }
}
