package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushServiceReceiver;
import com.xiaomi.push.ic;
import com.xiaomi.push.is;
import java.util.List;

public final class eab {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f15116O000000o;

    public static void O000000o(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra("key_command", miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static boolean O000000o(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty();
        } catch (Exception unused) {
            return true;
        }
    }

    public static int O000000o(Context context) {
        if (f15116O000000o == 0) {
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
            if (O000000o(context, intent)) {
                f15116O000000o = 1;
            } else {
                f15116O000000o = 2;
            }
        }
        return f15116O000000o;
    }

    public static MiPushCommandMessage O000000o(String str, List<String> list, long j, String str2, String str3) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.command = str;
        miPushCommandMessage.commandArguments = list;
        miPushCommandMessage.resultCode = j;
        miPushCommandMessage.reason = str2;
        miPushCommandMessage.category = str3;
        return miPushCommandMessage;
    }

    public static MiPushMessage O000000o(is isVar, ic icVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.messageId = isVar.b;
        if (!TextUtils.isEmpty(isVar.f)) {
            miPushMessage.messageType = 1;
            miPushMessage.alias = isVar.f;
        } else if (!TextUtils.isEmpty(isVar.e)) {
            miPushMessage.messageType = 2;
            miPushMessage.topic = isVar.e;
        } else if (!TextUtils.isEmpty(isVar.h)) {
            miPushMessage.messageType = 3;
            miPushMessage.userAccount = isVar.h;
        } else {
            miPushMessage.messageType = 0;
        }
        miPushMessage.category = isVar.g;
        if (isVar.f6440a != null) {
            miPushMessage.content = isVar.f6440a.f82c;
        }
        if (icVar != null) {
            if (TextUtils.isEmpty(miPushMessage.messageId)) {
                miPushMessage.messageId = icVar.f84a;
            }
            if (TextUtils.isEmpty(miPushMessage.topic)) {
                miPushMessage.topic = icVar.f88b;
            }
            miPushMessage.description = icVar.d;
            miPushMessage.title = icVar.f90c;
            miPushMessage.notifyType = icVar.f6409a;
            miPushMessage.notifyId = icVar.c;
            miPushMessage.passThrough = icVar.b;
            miPushMessage.O000000o(icVar.f86a);
        }
        miPushMessage.isNotified = z;
        return miPushMessage;
    }
}
