package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;

public class WXVideoObject implements WXMediaMessage.IMediaObject {
    public String videoLowBandUrl;
    public String videoUrl;

    public boolean checkArgs() {
        String str;
        String str2;
        String str3 = this.videoUrl;
        if ((str3 == null || str3.length() == 0) && ((str2 = this.videoLowBandUrl) == null || str2.length() == 0)) {
            str = "both arguments are null";
        } else {
            String str4 = this.videoUrl;
            if (str4 == null || str4.length() <= 10240) {
                String str5 = this.videoLowBandUrl;
                if (str5 == null || str5.length() <= 10240) {
                    return true;
                }
                str = "checkArgs fail, videoLowBandUrl is too long";
            } else {
                str = "checkArgs fail, videoUrl is too long";
            }
        }
        b.b("MicroMsg.SDK.WXVideoObject", str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
        bundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
    }

    public int type() {
        return 4;
    }

    public void unserialize(Bundle bundle) {
        this.videoUrl = bundle.getString("_wxvideoobject_videoUrl");
        this.videoLowBandUrl = bundle.getString("_wxvideoobject_videoLowBandUrl");
    }
}
