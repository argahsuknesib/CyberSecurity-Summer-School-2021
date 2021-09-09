package com.sina.weibo.sdk.api;

import _m_j.dbt;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class BaseMediaObject implements Parcelable {
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;

    public int describeContents() {
        return 0;
    }

    public abstract int getObjType();

    /* access modifiers changed from: protected */
    public abstract BaseMediaObject toExtraMediaObject(String str);

    /* access modifiers changed from: protected */
    public abstract String toExtraMediaString();

    public BaseMediaObject() {
    }

    public BaseMediaObject(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031 A[SYNTHETIC, Splitter:B:20:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003c A[SYNTHETIC, Splitter:B:25:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    public final void setThumbImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                this.thumbData = byteArrayOutputStream2.toByteArray();
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    e.printStackTrace();
                    dbt.O00000o0("Weibo.BaseMediaObject", "put thumb failed");
                    if (byteArrayOutputStream == null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            dbt.O00000o0("Weibo.BaseMediaObject", "put thumb failed");
            if (byteArrayOutputStream == null) {
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }

    /* access modifiers changed from: protected */
    public boolean checkArgs() {
        String str = this.actionUrl;
        if (str == null || str.length() > 512) {
            dbt.O00000o0("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
            return false;
        }
        String str2 = this.identify;
        if (str2 == null || str2.length() > 512) {
            dbt.O00000o0("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
            return false;
        }
        byte[] bArr = this.thumbData;
        if (bArr == null || bArr.length > 32768) {
            StringBuilder sb = new StringBuilder("checkArgs fail, thumbData is invalid,size is ");
            byte[] bArr2 = this.thumbData;
            sb.append(bArr2 != null ? bArr2.length : -1);
            sb.append("! more then 32768.");
            dbt.O00000o0("Weibo.BaseMediaObject", sb.toString());
            return false;
        }
        String str3 = this.title;
        if (str3 == null || str3.length() > 512) {
            dbt.O00000o0("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
            return false;
        }
        String str4 = this.description;
        if (str4 != null && str4.length() <= 1024) {
            return true;
        }
        dbt.O00000o0("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
        return false;
    }
}
