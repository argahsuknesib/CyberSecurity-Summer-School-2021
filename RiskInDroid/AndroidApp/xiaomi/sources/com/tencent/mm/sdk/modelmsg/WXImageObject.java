package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class WXImageObject implements WXMediaMessage.IMediaObject {
    public byte[] imageData;
    public String imagePath;

    public WXImageObject() {
    }

    public WXImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    private int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        return (int) file.length();
    }

    public boolean checkArgs() {
        String str;
        String str2;
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && ((str2 = this.imagePath) == null || str2.length() == 0)) {
            str = "checkArgs fail, all arguments are null";
        } else {
            byte[] bArr2 = this.imageData;
            if (bArr2 == null || bArr2.length <= 10485760) {
                String str3 = this.imagePath;
                if (str3 == null || str3.length() <= 10240) {
                    String str4 = this.imagePath;
                    if (str4 == null || getFileSize(str4) <= 10485760) {
                        return true;
                    }
                    str = "checkArgs fail, image content is too large";
                } else {
                    str = "checkArgs fail, path is invalid";
                }
            } else {
                str = "checkArgs fail, content is too large";
            }
        }
        b.b("MicroMsg.SDK.WXImageObject", str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public int type() {
        return 2;
    }

    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
    }
}
