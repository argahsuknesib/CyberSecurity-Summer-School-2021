package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXTextObject implements WXMediaMessage.IMediaObject {
    public String text;

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(String str) {
        this.text = str;
    }

    public boolean checkArgs() {
        String str = this.text;
        if (str != null && str.length() != 0 && this.text.length() <= 10240) {
            return true;
        }
        Log.e("MicroMsg.SDK.WXTextObject", "checkArgs fail, text is invalid");
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxtextobject_text", this.text);
    }

    public int type() {
        return 1;
    }

    public void unserialize(Bundle bundle) {
        this.text = bundle.getString("_wxtextobject_text");
    }
}
