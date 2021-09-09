package com.sina.weibo.sdk.api;

import _m_j.dbt;
import android.os.Parcel;
import android.os.Parcelable;

public class TextObject extends BaseMediaObject {
    public static final Parcelable.Creator<TextObject> CREATOR = new Parcelable.Creator<TextObject>() {
        /* class com.sina.weibo.sdk.api.TextObject.AnonymousClass1 */

        public final TextObject createFromParcel(Parcel parcel) {
            return new TextObject(parcel);
        }

        public final TextObject[] newArray(int i) {
            return new TextObject[i];
        }
    };
    public String text;

    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    /* access modifiers changed from: protected */
    public String toExtraMediaString() {
        return "";
    }

    public TextObject() {
    }

    public TextObject(Parcel parcel) {
        this.text = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
    }

    public boolean checkArgs() {
        String str = this.text;
        if (str != null && str.length() != 0 && this.text.length() <= 1024) {
            return true;
        }
        dbt.O00000o0("Weibo.TextObject", "checkArgs fail, text is invalid");
        return false;
    }
}
