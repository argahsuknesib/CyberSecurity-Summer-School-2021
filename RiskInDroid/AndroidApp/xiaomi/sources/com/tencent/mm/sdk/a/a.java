package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.h;

public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a$a  reason: collision with other inner class name */
    public static class C0049a {
        public String W;
        public String X;
        public String Y;
        public Bundle Z;
        public int flags = -1;

        public final String toString() {
            return "targetPkgName:" + this.W + ", targetClassName:" + this.X + ", content:" + this.Y + ", flags:" + this.flags + ", bundle:" + this.Z;
        }
    }

    public static boolean a(Context context, C0049a aVar) {
        if (context == null) {
            b.b("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (h.h(aVar.W)) {
            b.b("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + aVar.W);
            return false;
        } else {
            if (h.h(aVar.X)) {
                aVar.X = aVar.W + ".wxapi.WXEntryActivity";
            }
            b.e("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + aVar.W + ", targetClassName = " + aVar.X);
            Intent intent = new Intent();
            intent.setClassName(aVar.W, aVar.X);
            if (aVar.Z != null) {
                intent.putExtras(aVar.Z);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 587268097);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", aVar.Y);
            intent.putExtra("_mmessage_checksum", com.tencent.mm.sdk.a.a.b.a(aVar.Y, 587268097, packageName));
            if (aVar.flags == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(aVar.flags);
            }
            try {
                context.startActivity(intent);
                b.e("MicroMsg.SDK.MMessageAct", "send mm message, intent=".concat(String.valueOf(intent)));
                return true;
            } catch (Exception e) {
                b.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e.getMessage());
                return false;
            }
        }
    }
}
