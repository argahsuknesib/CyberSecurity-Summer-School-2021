package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;

public class SendMessageToWX {

    public static class Req extends BaseReq {
        public WXMediaMessage message;
        public int scene;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage == null) {
                b.b("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
                return false;
            }
            if (wXMediaMessage.mediaObject.type() == 6 && this.scene == 2) {
                ((WXFileObject) this.message.mediaObject).setContentLengthLimit(26214400);
            }
            return this.message.checkArgs();
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
            this.scene = bundle.getInt("_wxapi_sendmessagetowx_req_scene");
        }

        public int getType() {
            return 2;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
            bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
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

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        public int getType() {
            return 2;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    private SendMessageToWX() {
    }
}
