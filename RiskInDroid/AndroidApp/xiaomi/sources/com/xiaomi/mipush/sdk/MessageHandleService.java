package com.xiaomi.mipush.sdk;

import _m_j.duv;
import _m_j.eam;
import _m_j.ebb;
import _m_j.ebn;
import _m_j.ebo;
import _m_j.elo;
import _m_j.epj;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.ff;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MessageHandleService extends BaseService {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ConcurrentLinkedQueue<O000000o> f6046O000000o = new ConcurrentLinkedQueue<>();
    private static ExecutorService O00000Oo = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        PushMessageReceiver f6047O000000o;
        Intent O00000Oo;

        public O000000o(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f6047O000000o = pushMessageReceiver;
            this.O00000Oo = intent;
        }
    }

    protected static void O000000o(Context context) {
        O00000o0(context);
    }

    private static void O00000o0(Context context) {
        if (!O00000Oo.isShutdown()) {
            O00000Oo.execute(new ebo(context));
        }
    }

    public static void addJob(Context context, O000000o o000000o) {
        if (o000000o != null) {
            f6046O000000o.add(o000000o);
            O00000o0(context);
            startService(context);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o() {
        ConcurrentLinkedQueue<O000000o> concurrentLinkedQueue = f6046O000000o;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        elo.O000000o(context).O000000o(new ebn(context, intent), 0);
    }

    static void O000000o(Context context, O000000o o000000o) {
        String[] stringArrayExtra;
        if (o000000o != null) {
            try {
                PushMessageReceiver pushMessageReceiver = o000000o.f6047O000000o;
                Intent intent = o000000o.O00000Oo;
                int intExtra = intent.getIntExtra("message_type", 1);
                if (intExtra == 1) {
                    PushMessageHandler.a O000000o2 = eam.O000000o(context).O000000o(intent);
                    int intExtra2 = intent.getIntExtra("eventMessageType", -1);
                    if (O000000o2 == null) {
                        return;
                    }
                    if (O000000o2 instanceof MiPushMessage) {
                        MiPushMessage miPushMessage = (MiPushMessage) O000000o2;
                        if (!miPushMessage.arrived) {
                            pushMessageReceiver.onReceiveMessage(context, miPushMessage);
                        }
                        if (miPushMessage.passThrough == 1) {
                            epj.O000000o(context.getApplicationContext()).O000000o(context.getPackageName(), intent, 2004);
                            duv.O00000oo("begin execute onReceivePassThroughMessage from " + miPushMessage.messageId);
                            pushMessageReceiver.onReceivePassThroughMessage(context, miPushMessage);
                        } else if (miPushMessage.isNotified) {
                            if (intExtra2 == 1000) {
                                epj.O000000o(context.getApplicationContext()).O000000o(context.getPackageName(), intent, 1007);
                            } else {
                                epj.O000000o(context.getApplicationContext()).O000000o(context.getPackageName(), intent, 3007);
                            }
                            duv.O00000oo("begin execute onNotificationMessageClicked from　" + miPushMessage.messageId);
                            pushMessageReceiver.onNotificationMessageClicked(context, miPushMessage);
                        } else {
                            duv.O00000oo("begin execute onNotificationMessageArrived from " + miPushMessage.messageId);
                            pushMessageReceiver.onNotificationMessageArrived(context, miPushMessage);
                        }
                    } else if (O000000o2 instanceof MiPushCommandMessage) {
                        MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) O000000o2;
                        duv.O00000oo("begin execute onCommandResult, command=" + miPushCommandMessage.command + ", resultCode=" + miPushCommandMessage.resultCode + ", reason=" + miPushCommandMessage.reason);
                        pushMessageReceiver.onCommandResult(context, miPushCommandMessage);
                        if (TextUtils.equals(miPushCommandMessage.command, ff.f6377a.f30a)) {
                            pushMessageReceiver.onReceiveRegisterResult(context, miPushCommandMessage);
                            PushMessageHandler.O000000o(miPushCommandMessage);
                            if (miPushCommandMessage.resultCode == 0) {
                                ebb.O00000oO(context);
                            }
                        }
                    }
                } else if (intExtra == 3) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) intent.getSerializableExtra("key_command");
                    duv.O00000oo("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.command + ", resultCode=" + miPushCommandMessage2.resultCode + ", reason=" + miPushCommandMessage2.reason);
                    pushMessageReceiver.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.command, ff.f6377a.f30a)) {
                        pushMessageReceiver.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.O000000o(miPushCommandMessage2);
                        if (miPushCommandMessage2.resultCode == 0) {
                            ebb.O00000oO(context);
                        }
                    }
                } else if (intExtra != 4 && intExtra == 5) {
                    if ("error_lack_of_permission".equals(intent.getStringExtra("error_type")) && (stringArrayExtra = intent.getStringArrayExtra("error_message")) != null) {
                        duv.O00000oo("begin execute onRequirePermissions, lack of necessary permissions");
                        pushMessageReceiver.onRequirePermissions(context, stringArrayExtra);
                    }
                }
            } catch (RuntimeException e) {
                duv.O000000o(e);
            }
        }
    }

    public static /* synthetic */ void O00000Oo(Context context) {
        try {
            O000000o(context, f6046O000000o.poll());
        } catch (RuntimeException e) {
            duv.O000000o(e);
        }
    }
}
