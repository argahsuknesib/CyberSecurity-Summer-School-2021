package com.xiaomi.assemble.control;

import _m_j.dzo;
import _m_j.dzz;
import _m_j.ebb;
import _m_j.gsy;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.xiaomi.mipush.sdk.e;
import java.util.Map;

public class MiFirebaseMessagingService extends FirebaseMessagingService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        gsy.O000000o(4, "FCM-PUSH", "fcm onMessageReceived");
        if (remoteMessage.getData().size() > 0) {
            Map<String, String> data = remoteMessage.getData();
            gsy.O000000o(4, "FCM-PUSH", "get fcm data message");
            if (remoteMessage.getNotification() != null) {
                gsy.O000000o(4, "FCM-PUSH", "get fcm notification with data when app in foreground");
                dzo.O000000o(this, data);
                return;
            }
            gsy.O000000o(4, "FCM-PUSH", "get fcm passThough message");
            dzo.O00000Oo(this, data);
        }
    }

    public void onDeletedMessages() {
        super.onDeletedMessages();
        gsy.O000000o(4, "FCM-PUSH", "onDeletedMessages");
        dzz.O000000o(ebb.O000000o(e.b), "fcm", "some fcm messages was deleted ");
    }

    public void onMessageSent(String str) {
        gsy.O000000o(4, "FCM-PUSH", String.valueOf(str));
        super.onMessageSent(str);
    }

    public void onSendError(String str, Exception exc) {
        gsy.O000000o(4, "FCM-PUSH", str + " || " + exc.toString());
        super.onSendError(str, exc);
    }
}
