package com.xiaomi.smarthome.framework.push;

import _m_j.ezq;
import _m_j.ezt;
import _m_j.gdz;
import _m_j.gfr;
import _m_j.gsy;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.smarthome.library.log.LogType;

public class PushReceiver extends PushMessageReceiver {
    public void onCommandResult(final Context context, final MiPushCommandMessage miPushCommandMessage) {
        if (miPushCommandMessage != null) {
            gdz.O000000o().O00000o0();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.push.PushReceiver.AnonymousClass1 */

                public final void run() {
                    ezt.O000000o().startCheck(new ezq() {
                        /* class com.xiaomi.smarthome.framework.push.PushReceiver.AnonymousClass1.AnonymousClass1 */

                        public final void O000000o() {
                        }

                        public final void O00000Oo() {
                        }

                        public final void O00000o0() {
                            PushReceiver.this.doWorkOnCommandResult(context, miPushCommandMessage);
                        }
                    });
                }
            });
        }
    }

    public void onReceivePassThroughMessage(final Context context, final MiPushMessage miPushMessage) {
        if (miPushMessage != null) {
            gdz.O000000o().O00000o0();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.push.PushReceiver.AnonymousClass2 */

                public final void run() {
                    ezt.O000000o().startCheck(new ezq() {
                        /* class com.xiaomi.smarthome.framework.push.PushReceiver.AnonymousClass2.AnonymousClass1 */

                        public final void O000000o() {
                        }

                        public final void O00000Oo() {
                        }

                        public final void O00000o0() {
                            PushReceiver.this.doWorkOnReceiveMessage(context, miPushMessage);
                        }
                    });
                }
            });
        }
    }

    public void onNotificationMessageClicked(final Context context, final MiPushMessage miPushMessage) {
        if (miPushMessage != null) {
            gdz.O000000o().O00000o0();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.push.PushReceiver.AnonymousClass3 */

                public final void run() {
                    ezt.O000000o().startCheck(new ezq() {
                        /* class com.xiaomi.smarthome.framework.push.PushReceiver.AnonymousClass3.AnonymousClass1 */

                        public final void O000000o() {
                        }

                        public final void O00000Oo() {
                        }

                        public final void O00000o0() {
                            PushReceiver.this.doWorkOnReceiveMessage(context, miPushMessage);
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void doWorkOnCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        gdz.O000000o().O0000Oo.obtainMessage(1, miPushCommandMessage).sendToTarget();
    }

    /* access modifiers changed from: package-private */
    public void doWorkOnReceiveMessage(Context context, MiPushMessage miPushMessage) {
        if (miPushMessage != null && (gfr.O0000Oo || gfr.O0000OOo)) {
            LogType logType = LogType.PUSH;
            gsy.O000000o(logType, "PushReceiver", "PushReceiver-->  MessageId: " + miPushMessage.messageId + "  Content: " + miPushMessage.content);
        }
        gdz.O000000o().O0000Oo.obtainMessage(2, miPushMessage).sendToTarget();
    }
}
