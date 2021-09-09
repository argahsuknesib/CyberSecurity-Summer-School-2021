package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.io.File;

public class WXFileObject implements WXMediaMessage.IMediaObject {
    private int contentLengthLimit;
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        this.contentLengthLimit = 10485760;
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(String str) {
        this.contentLengthLimit = 10485760;
        this.filePath = str;
    }

    public WXFileObject(byte[] bArr) {
        this.contentLengthLimit = 10485760;
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
        byte[] bArr = this.fileData;
        if ((bArr == null || bArr.length == 0) && ((str2 = this.filePath) == null || str2.length() == 0)) {
            str = "checkArgs fail, both arguments is null";
        } else {
            byte[] bArr2 = this.fileData;
            if (bArr2 == null || bArr2.length <= this.contentLengthLimit) {
                String str3 = this.filePath;
                if (str3 == null || getFileSize(str3) <= this.contentLengthLimit) {
                    return true;
                }
                str = "checkArgs fail, fileSize is too large";
            } else {
                str = "checkArgs fail, fileData is too large";
            }
        }
        b.b("MicroMsg.SDK.WXFileObject", str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxfileobject_fileData", this.fileData);
        bundle.putString("_wxfileobject_filePath", this.filePath);
    }

    public void setContentLengthLimit(int i) {
        this.contentLengthLimit = i;
    }

    public void setFileData(byte[] bArr) {
        this.fileData = bArr;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public int type() {
        return 6;
    }

    public void unserialize(Bundle bundle) {
        this.fileData = bundle.getByteArray("_wxfileobject_fileData");
        this.filePath = bundle.getString("_wxfileobject_filePath");
    }
}
