package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;

public final class GetMessageFromWX {

    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public String username;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.lang = bundle.getString("_wxapi_getmessage_req_lang");
            this.country = bundle.getString("_wxapi_getmessage_req_country");
        }

        public int getType() {
            return 3;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_getmessage_req_lang", this.lang);
            bundle.putString("_wxapi_getmessage_req_country", this.country);
        }
    }

    public static class Resp extends BaseResp {
        public WXMediaMessage message;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage != null) {
                return wXMediaMessage.checkArgs();
            }
            b.b("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
            return false;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
        }

        public int getType() {
            return 3;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
        }
    }

    private GetMessageFromWX() {
    }
}
