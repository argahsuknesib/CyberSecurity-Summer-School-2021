package com.xiaomi.mipush.sdk;

import _m_j.duv;
import _m_j.dzs;
import _m_j.dzz;
import _m_j.eab;
import _m_j.eal;
import _m_j.eam;
import _m_j.eax;
import _m_j.ebh;
import _m_j.epj;
import _m_j.eru;
import _m_j.esu;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.push.ff;
import com.xiaomi.push.ht;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PushMessageHandler extends BaseService {

    /* renamed from: O000000o  reason: collision with root package name */
    private static List<dzs.O000000o> f6049O000000o = new ArrayList();
    private static List<dzs.O00000Oo> O00000Oo = new ArrayList();
    private static ThreadPoolExecutor O00000o0 = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public interface a extends Serializable {
    }

    public static void O000000o(dzs.O000000o o000000o) {
        synchronized (f6049O000000o) {
            if (!f6049O000000o.contains(o000000o)) {
                f6049O000000o.add(o000000o);
            }
        }
    }

    private static void O000000o(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, eax.O000000o(context));
        } catch (Exception e) {
            duv.O000000o("callback sync error".concat(String.valueOf(e)));
        }
    }

    private static boolean O000000o(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    public static void O00000Oo() {
        synchronized (O00000Oo) {
            O00000Oo.clear();
        }
    }

    private static void O00000Oo(Context context, Intent intent) {
        if (intent != null && !O00000o0.isShutdown()) {
            O00000o0.execute(new eal(context, intent));
        }
    }

    public static void O00000o0() {
        synchronized (f6049O000000o) {
            f6049O000000o.clear();
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (O00000Oo) {
            Iterator<dzs.O00000Oo> it = O00000Oo.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e) {
            duv.O000000o(e.getMessage());
        }
    }

    public static void a(Context context, Intent intent) {
        duv.O00000o0("addjob PushMessageHandler ".concat(String.valueOf(intent)));
        if (intent != null) {
            O00000Oo(context, intent);
            a(context);
        }
    }

    public static boolean b() {
        return O00000Oo.isEmpty();
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o() {
        ThreadPoolExecutor threadPoolExecutor = O00000o0;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || O00000o0.getQueue().size() <= 0) ? false : true;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        O00000Oo(getApplicationContext(), intent);
    }

    public static void O000000o(Context context, Intent intent) {
        boolean z = false;
        try {
            z = intent.getBooleanExtra("is_clicked_activity_call", z);
        } catch (Throwable th) {
            duv.O000000o("intent unparcel error:".concat(String.valueOf(th)));
        }
        try {
            ResolveInfo resolveInfo = null;
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                ebh.O000000o(context, intent, null);
            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                ht htVar = new ht();
                eru.O000000o(htVar, intent.getByteArrayExtra("mipush_payload"));
                duv.O00000o0("PushMessageHandler.onHandleIntent " + htVar.f);
                dzz.O000000o(context, htVar);
            } else if (1 == eab.O000000o(context)) {
                if (b()) {
                    duv.O00000o("receive a message before application calling initialize");
                    if (z) {
                        O000000o(context);
                        return;
                    }
                    return;
                }
                a O000000o2 = eam.O000000o(context).O000000o(intent);
                if (O000000o2 != null) {
                    a(context, O000000o2);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                if (queryBroadcastReceivers != null) {
                    Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ResolveInfo next = it.next();
                        if (next.activityInfo != null && next.activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(esu.O000000o(context, next.activityInfo.name))) {
                            resolveInfo = next;
                            break;
                        }
                    }
                }
                if (resolveInfo != null) {
                    try {
                        MessageHandleService.O000000o o000000o = new MessageHandleService.O000000o(intent2, (PushMessageReceiver) esu.O000000o(context, resolveInfo.activityInfo.name).newInstance());
                        if (z) {
                            MessageHandleService.O000000o(context.getApplicationContext(), o000000o);
                        } else {
                            MessageHandleService.addJob(context.getApplicationContext(), o000000o);
                        }
                        new Intent(context.getApplicationContext(), MessageHandleService.class);
                        MessageHandleService.O000000o(context);
                    } catch (Throwable th2) {
                        duv.O000000o(th2);
                    }
                } else {
                    duv.O00000o("cannot find the receiver to handler this message, check your manifest");
                    epj.O000000o(context).O000000o(context.getPackageName(), intent, "11");
                }
            }
        } catch (Exception e) {
            duv.O000000o(e);
            epj.O000000o(context).O000000o(context.getPackageName(), intent, "9");
        } catch (Throwable th3) {
            try {
                duv.O000000o(th3);
                epj.O000000o(context).O000000o(context.getPackageName(), intent, "10");
                if (!z) {
                    return;
                }
                return;
            } finally {
                if (z) {
                    O000000o(context);
                }
            }
        }
        if (z) {
            O000000o(context);
        }
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
        } else if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String str = miPushCommandMessage.command;
            if (ff.f6377a.f30a.equals(str)) {
                List<String> list = miPushCommandMessage.commandArguments;
                a(miPushCommandMessage.resultCode, miPushCommandMessage.reason, (list == null || list.isEmpty()) ? null : list.get(0));
            } else if (ff.c.f30a.equals(str) || ff.d.f30a.equals(str) || ff.i.f30a.equals(str)) {
                O00000Oo(miPushCommandMessage.category);
            } else if (ff.g.f30a.equals(str)) {
                List<String> list2 = miPushCommandMessage.commandArguments;
                if (list2 != null && !list2.isEmpty()) {
                    list2.get(0);
                }
                O000000o(miPushCommandMessage.category);
            } else if (ff.h.f30a.equals(str)) {
                List<String> list3 = miPushCommandMessage.commandArguments;
                if (list3 != null && !list3.isEmpty()) {
                    list3.get(0);
                }
                String str2 = miPushCommandMessage.category;
                synchronized (O00000Oo) {
                    for (dzs.O00000Oo o00000Oo : O00000Oo) {
                        O000000o(str2, o00000Oo.f15106O000000o);
                    }
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (O00000Oo) {
            for (dzs.O00000Oo o00000Oo : O00000Oo) {
                O000000o(miPushMessage.category, o00000Oo.f15106O000000o);
            }
        }
    }

    public static void O000000o(String str) {
        synchronized (O00000Oo) {
            for (dzs.O00000Oo o00000Oo : O00000Oo) {
                O000000o(str, o00000Oo.f15106O000000o);
            }
        }
    }

    public static void O00000Oo(String str) {
        synchronized (O00000Oo) {
            for (dzs.O00000Oo o00000Oo : O00000Oo) {
                O000000o(str, o00000Oo.f15106O000000o);
            }
        }
    }

    protected static void O000000o(MiPushCommandMessage miPushCommandMessage) {
        synchronized (f6049O000000o) {
            for (dzs.O000000o o000000o : f6049O000000o) {
                if (o000000o instanceof dzs.O00000o) {
                    dzs.O00000o0 o00000o0 = new dzs.O00000o0();
                    if (!(miPushCommandMessage == null || miPushCommandMessage.commandArguments == null || miPushCommandMessage.commandArguments.size() <= 0)) {
                        o00000o0.O00000Oo = miPushCommandMessage.resultCode;
                        o00000o0.f15107O000000o = miPushCommandMessage.commandArguments.get(0);
                    }
                }
            }
        }
    }
}
