package com.sina.weibo.sdk.api;

import _m_j.dbt;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageObject extends BaseMediaObject {
    public static final Parcelable.Creator<ImageObject> CREATOR = new Parcelable.Creator<ImageObject>() {
        /* class com.sina.weibo.sdk.api.ImageObject.AnonymousClass1 */

        public final ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        public final ImageObject[] newArray(int i) {
            return new ImageObject[i];
        }
    };
    public byte[] imageData;
    public String imagePath;

    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    /* access modifiers changed from: protected */
    public String toExtraMediaString() {
        return "";
    }

    public ImageObject() {
    }

    public ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031 A[SYNTHETIC, Splitter:B:20:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003c A[SYNTHETIC, Splitter:B:25:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    public final void setImageObject(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                this.imageData = byteArrayOutputStream2.toByteArray();
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
                    dbt.O00000o0("Weibo.ImageObject", "put thumb failed");
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
            dbt.O00000o0("Weibo.ImageObject", "put thumb failed");
            if (byteArrayOutputStream == null) {
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }

    public boolean checkArgs() {
        if (this.imageData == null && this.imagePath == null) {
            dbt.O00000o0("Weibo.ImageObject", "imageData and imagePath are null");
            return false;
        }
        byte[] bArr = this.imageData;
        if (bArr == null || bArr.length <= 2097152) {
            String str = this.imagePath;
            if (str == null || str.length() <= 512) {
                String str2 = this.imagePath;
                if (str2 == null) {
                    return true;
                }
                File file = new File(str2);
                try {
                    if (file.exists() && file.length() != 0 && file.length() <= 10485760) {
                        return true;
                    }
                    dbt.O00000o0("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                    return false;
                } catch (SecurityException unused) {
                    dbt.O00000o0("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                    return false;
                }
            } else {
                dbt.O00000o0("Weibo.ImageObject", "imagePath is too length");
                return false;
            }
        } else {
            dbt.O00000o0("Weibo.ImageObject", "imageData is too large");
            return false;
        }
    }
}
