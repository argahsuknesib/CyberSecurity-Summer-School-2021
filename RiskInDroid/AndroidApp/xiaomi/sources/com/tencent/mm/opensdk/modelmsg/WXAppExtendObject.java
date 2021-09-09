package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

public class WXAppExtendObject implements WXMediaMessage.IMediaObject {
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
    }

    public WXAppExtendObject(String str, String str2) {
        this.extInfo = str;
        this.filePath = str2;
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        this.extInfo = str;
        this.fileData = bArr;
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
        byte[] bArr;
        String str3 = this.extInfo;
        if ((str3 == null || str3.length() == 0) && (((str2 = this.filePath) == null || str2.length() == 0) && ((bArr = this.fileData) == null || bArr.length == 0))) {
            str = "checkArgs fail, all arguments is null";
        } else {
            String str4 = this.extInfo;
            if (str4 == null || str4.length() <= 2048) {
                String str5 = this.filePath;
                if (str5 == null || str5.length() <= 10240) {
                    String str6 = this.filePath;
                    if (str6 == null || getFileSize(str6) <= 10485760) {
                        byte[] bArr2 = this.fileData;
                        if (bArr2 == null || bArr2.length <= 10485760) {
                            return true;
                        }
                        str = "checkArgs fail, fileData is too large";
                    } else {
                        str = "checkArgs fail, fileSize is too large";
                    }
                } else {
                    str = "checkArgs fail, filePath is invalid";
                }
            } else {
                str = "checkArgs fail, extInfo is invalid";
            }
        }
        Log.e("MicroMsg.SDK.WXAppExtendObject", str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
    }

    public int type() {
        return 7;
    }

    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
    }
}
