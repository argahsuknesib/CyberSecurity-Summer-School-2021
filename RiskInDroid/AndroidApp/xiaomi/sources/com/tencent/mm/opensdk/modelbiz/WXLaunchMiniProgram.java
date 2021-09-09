package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXLaunchMiniProgram {

    public static final class Req extends BaseReq {
        public int miniprogramType = 0;
        public String path = "";
        public String userName;

        public final boolean checkArgs() {
            String str;
            if (d.a(this.userName)) {
                str = "userName is null";
            } else {
                int i = this.miniprogramType;
                if (i >= 0 && i <= 2) {
                    return true;
                }
                str = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
            }
            Log.e("MicroMsg.SDK.WXLaunchMiniProgram.Req", str);
            return false;
        }

        public final int getType() {
            return 19;
        }

        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_username", this.userName);
            bundle.putString("_launch_wxminiprogram_path", this.path);
            bundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
        }
    }

    public static final class Resp extends BaseResp {
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_launch_wxminiprogram_ext_msg");
        }

        public final int getType() {
            return 19;
        }

        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_command_type", getType());
        }
    }
}
