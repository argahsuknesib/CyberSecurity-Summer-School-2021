package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public final class SubscribeMessage {

    public static class Req extends BaseReq {
        public String reserved;
        public int scene;
        public String templateID;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            String str;
            String str2 = this.templateID;
            if (str2 == null || str2.length() == 0) {
                str = "checkArgs fail, templateID is null";
            } else if (this.templateID.length() > 1024) {
                str = "checkArgs fail, templateID is too long";
            } else {
                String str3 = this.reserved;
                if (str3 == null || str3.length() <= 1024) {
                    return true;
                }
                str = "checkArgs fail, reserved is too long";
            }
            Log.e("MicroMsg.SDK.SubscribeMessage.Req", str);
            return false;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.scene = bundle.getInt("_wxapi_subscribemessage_req_scene");
            this.templateID = bundle.getString("_wxapi_subscribemessage_req_templateid");
            this.reserved = bundle.getString("_wxapi_subscribemessage_req_reserved");
        }

        public int getType() {
            return 18;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putInt("_wxapi_subscribemessage_req_scene", this.scene);
            bundle.putString("_wxapi_subscribemessage_req_templateid", this.templateID);
            bundle.putString("_wxapi_subscribemessage_req_reserved", this.reserved);
        }
    }

    public static class Resp extends BaseResp {
        public String action;
        public String reserved;
        public int scene;
        public String templateID;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.templateID = bundle.getString("_wxapi_subscribemessage_resp_templateid");
            this.scene = bundle.getInt("_wxapi_subscribemessage_resp_scene");
            this.action = bundle.getString("_wxapi_subscribemessage_resp_action");
            this.reserved = bundle.getString("_wxapi_subscribemessage_resp_reserved");
        }

        public int getType() {
            return 18;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_subscribemessage_resp_templateid", this.templateID);
            bundle.putInt("_wxapi_subscribemessage_resp_scene", this.scene);
            bundle.putString("_wxapi_subscribemessage_resp_action", this.action);
            bundle.putString("_wxapi_subscribemessage_resp_reserved", this.reserved);
        }
    }

    private SubscribeMessage() {
    }
}
