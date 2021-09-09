package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;

public class ShowMessageFromWX {

    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public WXMediaMessage message;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage == null) {
                return false;
            }
            return wXMediaMessage.checkArgs();
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.lang = bundle.getString("_wxapi_showmessage_req_lang");
            this.country = bundle.getString("_wxapi_showmessage_req_country");
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
        }

        public int getType() {
            return 4;
        }

        public void toBundle(Bundle bundle) {
            Bundle bundle2 = WXMediaMessage.Builder.toBundle(this.message);
            super.toBundle(bundle2);
            bundle.putString("_wxapi_showmessage_req_lang", this.lang);
            bundle.putString("_wxapi_showmessage_req_country", this.country);
            bundle.putAll(bundle2);
        }
    }

    public static class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            return true;
        }

        public int getType() {
            return 4;
        }
    }

    private ShowMessageFromWX() {
    }
}
