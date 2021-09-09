package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelbase.BaseReq;

public class JumpToBizProfile {

    public static class Req extends BaseReq {
        public String extMsg;
        public int profileType = 0;
        public String toUserName;

        public boolean checkArgs() {
            String str;
            String str2;
            String str3 = this.toUserName;
            if (str3 == null || str3.length() == 0) {
                str = "checkArgs fail, toUserName is invalid";
            } else {
                String str4 = this.extMsg;
                if (str4 != null && str4.length() > 1024) {
                    str = "ext msg is not null, while the length exceed 1024 bytes";
                } else if (this.profileType != 1 || ((str2 = this.extMsg) != null && str2.length() != 0)) {
                    return true;
                } else {
                    str = "scene is jump to hardware profile, while extmsg is null";
                }
            }
            b.b("MicroMsg.SDK.JumpToBizProfile.Req", str);
            return false;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.toUserName = bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
            this.extMsg = bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
        }

        public int getType() {
            return 7;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_profile_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_profile_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_profile_req_scene", 0);
            bundle.putInt("_wxapi_jump_to_biz_profile_req_profile_type", this.profileType);
        }
    }
}
