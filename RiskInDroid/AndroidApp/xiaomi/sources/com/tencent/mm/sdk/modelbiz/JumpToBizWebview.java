package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelbase.BaseReq;

public final class JumpToBizWebview {

    public static class Req extends BaseReq {
        public String extMsg;
        public int scene = 1;
        public String toUserName;
        public int webType;

        public boolean checkArgs() {
            String str;
            String str2 = this.toUserName;
            if (str2 == null || str2.length() <= 0) {
                str = "checkArgs fail, toUserName is invalid";
            } else {
                String str3 = this.extMsg;
                if (str3 == null || str3.length() <= 1024) {
                    return true;
                }
                str = "ext msg is not null, while the length exceed 1024 bytes";
            }
            b.b("MicroMsg.SDK.JumpToBizWebview.Req", str);
            return false;
        }

        public int getType() {
            return 8;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
        }
    }
}
