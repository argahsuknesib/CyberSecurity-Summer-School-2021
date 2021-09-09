package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelbase.BaseReq;

public final class JumpToBizTempSession {

    public static class Req extends BaseReq {
        public String sessionFrom;
        public int showType;
        public String toUserName;

        public boolean checkArgs() {
            String str;
            String str2 = this.toUserName;
            if (str2 == null || str2.length() <= 0) {
                str = "checkArgs fail, toUserName is invalid";
            } else {
                String str3 = this.sessionFrom;
                if (str3 != null && str3.length() <= 1024) {
                    return true;
                }
                str = "checkArgs fail, sessionFrom is invalid";
            }
            b.b("MicroMsg.SDK.JumpToBizTempSession.Req", str);
            return false;
        }

        public int getType() {
            return 10;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_session_from", this.sessionFrom);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_show_type", this.showType);
        }
    }
}
