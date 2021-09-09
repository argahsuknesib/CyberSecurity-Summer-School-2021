package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

public class WXVideoFileObject implements WXMediaMessage.IMediaObject {
    public String filePath;

    public WXVideoFileObject() {
        this.filePath = null;
    }

    public WXVideoFileObject(String str) {
        this.filePath = str;
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
        String str2 = this.filePath;
        if (str2 == null || str2.length() == 0) {
            str = "checkArgs fail, filePath is null";
        } else if (getFileSize(this.filePath) <= 10485760) {
            return true;
        } else {
            str = "checkArgs fail, video file size is too large";
        }
        Log.e("MicroMsg.SDK.WXVideoFileObject", str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
    }

    public int type() {
        return 38;
    }

    public void unserialize(Bundle bundle) {
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
    }
}
