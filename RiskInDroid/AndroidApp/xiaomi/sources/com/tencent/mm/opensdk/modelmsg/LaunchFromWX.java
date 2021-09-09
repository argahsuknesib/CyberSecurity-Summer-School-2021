package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class LaunchFromWX {

    public static class Req extends BaseReq {
        public String country;
        public String lang;
        public String messageAction;
        public String messageExt;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            String str;
            String str2 = this.messageAction;
            if (str2 == null || str2.length() <= 2048) {
                String str3 = this.messageExt;
                if (str3 == null || str3.length() <= 2048) {
                    return true;
                }
                str = "checkArgs fail, messageExt is too long";
            } else {
                str = "checkArgs fail, messageAction is too long";
            }
            Log.e("MicroMsg.SDK.LaunchFromWX.Req", str);
            return false;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.messageAction = bundle.getString("_wxobject_message_action");
            this.messageExt = bundle.getString("_wxobject_message_ext");
            this.lang = bundle.getString("_wxapi_launch_req_lang");
            this.country = bundle.getString("_wxapi_launch_req_country");
        }

        public int getType() {
            return 6;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxobject_message_action", this.messageAction);
            bundle.putString("_wxobject_message_ext", this.messageExt);
            bundle.putString("_wxapi_launch_req_lang", this.lang);
            bundle.putString("_wxapi_launch_req_country", this.country);
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
            return 6;
        }
    }

    private LaunchFromWX() {
    }
}
