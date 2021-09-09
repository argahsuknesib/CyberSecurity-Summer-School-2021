package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

public class WXEmojiObject implements WXMediaMessage.IMediaObject {
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
        this.emojiData = null;
        this.emojiPath = null;
    }

    public WXEmojiObject(String str) {
        this.emojiPath = str;
    }

    public WXEmojiObject(byte[] bArr) {
        this.emojiData = bArr;
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
        byte[] bArr = this.emojiData;
        if ((bArr == null || bArr.length == 0) && ((str2 = this.emojiPath) == null || str2.length() == 0)) {
            str = "checkArgs fail, both arguments is null";
        } else {
            byte[] bArr2 = this.emojiData;
            if (bArr2 == null || bArr2.length <= 10485760) {
                String str3 = this.emojiPath;
                if (str3 == null || getFileSize(str3) <= 10485760) {
                    return true;
                }
                str = "checkArgs fail, emojiSize is too large";
            } else {
                str = "checkArgs fail, emojiData is too large";
            }
        }
        Log.e("MicroMsg.SDK.WXEmojiObject", str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
    }

    public void setEmojiData(byte[] bArr) {
        this.emojiData = bArr;
    }

    public void setEmojiPath(String str) {
        this.emojiPath = str;
    }

    public int type() {
        return 8;
    }

    public void unserialize(Bundle bundle) {
        this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
    }
}
