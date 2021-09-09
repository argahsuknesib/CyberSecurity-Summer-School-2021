package com.tencent.mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class MMessageActV2 {

    public static class Args {
        public Bundle bundle;
        public String content;
        public int flags = -1;
        public String targetClassName;
        public String targetPkgName;

        public String toString() {
            return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
        }
    }

    public static boolean send(Context context, Args args) {
        String str;
        if (context == null || args == null) {
            str = "send fail, invalid argument";
        } else if (d.a(args.targetPkgName)) {
            str = "send fail, invalid targetPkgName, targetPkgName = " + args.targetPkgName;
        } else {
            if (d.a(args.targetClassName)) {
                args.targetClassName = args.targetPkgName + ".wxapi.WXEntryActivity";
            }
            Log.d("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + args.targetPkgName + ", targetClassName = " + args.targetClassName);
            Intent intent = new Intent();
            intent.setClassName(args.targetPkgName, args.targetClassName);
            if (args.bundle != null) {
                intent.putExtras(args.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 620823552);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", args.content);
            intent.putExtra("_mmessage_checksum", b.a(args.content, 620823552, packageName));
            if (args.flags == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(args.flags);
            }
            try {
                context.startActivity(intent);
                Log.d("MicroMsg.SDK.MMessageAct", "send mm message, intent=".concat(String.valueOf(intent)));
                return true;
            } catch (Exception e) {
                str = "send fail, ex = " + e.getMessage();
            }
        }
        Log.e("MicroMsg.SDK.MMessageAct", str);
        return false;
    }
}
