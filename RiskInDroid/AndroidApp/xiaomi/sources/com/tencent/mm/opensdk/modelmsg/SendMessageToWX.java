package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

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
                Log.e("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
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
            bundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.message.getType());
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
