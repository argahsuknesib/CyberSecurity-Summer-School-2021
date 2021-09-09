package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;

public class WXMusicObject implements WXMediaMessage.IMediaObject {
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;

    public boolean checkArgs() {
        String str;
        String str2;
        String str3 = this.musicUrl;
        if ((str3 == null || str3.length() == 0) && ((str2 = this.musicLowBandUrl) == null || str2.length() == 0)) {
            str = "both arguments are null";
        } else {
            String str4 = this.musicUrl;
            if (str4 == null || str4.length() <= 10240) {
                String str5 = this.musicLowBandUrl;
                if (str5 == null || str5.length() <= 10240) {
                    return true;
                }
                str = "checkArgs fail, musicLowBandUrl is too long";
            } else {
                str = "checkArgs fail, musicUrl is too long";
            }
        }
        b.b("MicroMsg.SDK.WXMusicObject", str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
    }

    public int type() {
        return 3;
    }

    public void unserialize(Bundle bundle) {
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
    }
}
