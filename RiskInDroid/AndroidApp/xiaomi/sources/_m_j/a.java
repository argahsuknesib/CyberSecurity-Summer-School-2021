package _m_j;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a {
    private static String O00000o;
    private static final Object O00000o0 = new Object();
    private static Set<String> O00000oO = new HashSet();
    private static final Object O00000oo = new Object();
    private static O00000o O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f12348O000000o;
    public final NotificationManager O00000Oo = ((NotificationManager) this.f12348O000000o.getSystemService("notification"));

    interface O0000O0o {
        void O000000o(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    public static a O000000o(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.f12348O000000o = context;
    }

    public final boolean O000000o() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.O00000Oo.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) this.f12348O000000o.getSystemService("appops");
            ApplicationInfo applicationInfo = this.f12348O000000o.getApplicationInfo();
            String packageName = this.f12348O000000o.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                if (((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
        }
        return true;
    }

    public static Set<String> O00000Oo(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (O00000o0) {
            if (string != null) {
                if (!string.equals(O00000o)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    O00000oO = hashSet;
                    O00000o = string;
                }
            }
            set = O00000oO;
        }
        return set;
    }

    public final void O000000o(O0000O0o o0000O0o) {
        synchronized (O00000oo) {
            if (O0000O0o == null) {
                O0000O0o = new O00000o(this.f12348O000000o.getApplicationContext());
            }
            O0000O0o.f12351O000000o.obtainMessage(0, o0000O0o).sendToTarget();
        }
    }

    static class O00000o implements ServiceConnection, Handler.Callback {

        /* renamed from: O000000o  reason: collision with root package name */
        final Handler f12351O000000o;
        private final Context O00000Oo;
        private final Map<ComponentName, O000000o> O00000o = new HashMap();
        private final HandlerThread O00000o0;
        private Set<String> O00000oO = new HashSet();

        O00000o(Context context) {
            this.O00000Oo = context;
            this.O00000o0 = new HandlerThread("NotificationManagerCompat");
            this.O00000o0.start();
            this.f12351O000000o = new Handler(this.O00000o0.getLooper(), this);
        }

        public final boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                O0000O0o o0000O0o = (O0000O0o) message.obj;
                Set<String> O00000Oo2 = a.O00000Oo(this.O00000Oo);
                if (!O00000Oo2.equals(this.O00000oO)) {
                    this.O00000oO = O00000Oo2;
                    List<ResolveInfo> queryIntentServices = this.O00000Oo.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                    HashSet<ComponentName> hashSet = new HashSet<>();
                    for (ResolveInfo next : queryIntentServices) {
                        if (O00000Oo2.contains(next.serviceInfo.packageName)) {
                            ComponentName componentName = new ComponentName(next.serviceInfo.packageName, next.serviceInfo.name);
                            if (next.serviceInfo.permission != null) {
                                Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                            } else {
                                hashSet.add(componentName);
                            }
                        }
                    }
                    for (ComponentName componentName2 : hashSet) {
                        if (!this.O00000o.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Adding listener record for ".concat(String.valueOf(componentName2)));
                            }
                            this.O00000o.put(componentName2, new O000000o(componentName2));
                        }
                    }
                    Iterator<Map.Entry<ComponentName, O000000o>> it = this.O00000o.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next2 = it.next();
                        if (!hashSet.contains(next2.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Removing listener record for " + next2.getKey());
                            }
                            O000000o((O000000o) next2.getValue());
                            it.remove();
                        }
                    }
                }
                for (O000000o next3 : this.O00000o.values()) {
                    next3.O00000o.add(o0000O0o);
                    O00000o0(next3);
                }
                return true;
            } else if (i == 1) {
                O00000o0 o00000o0 = (O00000o0) message.obj;
                ComponentName componentName3 = o00000o0.f12353O000000o;
                IBinder iBinder = o00000o0.O00000Oo;
                O000000o o000000o = this.O00000o.get(componentName3);
                if (o000000o != null) {
                    o000000o.O00000o0 = INotificationSideChannel.Stub.asInterface(iBinder);
                    o000000o.O00000oO = 0;
                    O00000o0(o000000o);
                }
                return true;
            } else if (i == 2) {
                O000000o o000000o2 = this.O00000o.get((ComponentName) message.obj);
                if (o000000o2 != null) {
                    O000000o(o000000o2);
                }
                return true;
            } else if (i != 3) {
                return false;
            } else {
                O000000o o000000o3 = this.O00000o.get((ComponentName) message.obj);
                if (o000000o3 != null) {
                    O00000o0(o000000o3);
                }
                return true;
            }
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service ".concat(String.valueOf(componentName)));
            }
            this.f12351O000000o.obtainMessage(1, new O00000o0(componentName, iBinder)).sendToTarget();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service ".concat(String.valueOf(componentName)));
            }
            this.f12351O000000o.obtainMessage(2, componentName).sendToTarget();
        }

        private void O000000o(O000000o o000000o) {
            if (o000000o.O00000Oo) {
                this.O00000Oo.unbindService(this);
                o000000o.O00000Oo = false;
            }
            o000000o.O00000o0 = null;
        }

        private void O00000Oo(O000000o o000000o) {
            if (!this.f12351O000000o.hasMessages(3, o000000o.f12352O000000o)) {
                o000000o.O00000oO++;
                if (o000000o.O00000oO > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + o000000o.O00000o.size() + " tasks to " + o000000o.f12352O000000o + " after " + o000000o.O00000oO + " retries");
                    o000000o.O00000o.clear();
                    return;
                }
                int i = (1 << (o000000o.O00000oO - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.f12351O000000o.sendMessageDelayed(this.f12351O000000o.obtainMessage(3, o000000o.f12352O000000o), (long) i);
            }
        }

        private void O00000o0(O000000o o000000o) {
            boolean z;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + o000000o.f12352O000000o + ", " + o000000o.O00000o.size() + " queued tasks");
            }
            if (!o000000o.O00000o.isEmpty()) {
                if (o000000o.O00000Oo) {
                    z = true;
                } else {
                    o000000o.O00000Oo = this.O00000Oo.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(o000000o.f12352O000000o), this, 33);
                    if (o000000o.O00000Oo) {
                        o000000o.O00000oO = 0;
                    } else {
                        Log.w("NotifManCompat", "Unable to bind to listener " + o000000o.f12352O000000o);
                        this.O00000Oo.unbindService(this);
                    }
                    z = o000000o.O00000Oo;
                }
                if (!z || o000000o.O00000o0 == null) {
                    O00000Oo(o000000o);
                    return;
                }
                while (true) {
                    O0000O0o peek = o000000o.O00000o.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task ".concat(String.valueOf(peek)));
                        }
                        peek.O000000o(o000000o.O00000o0);
                        o000000o.O00000o.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + o000000o.f12352O000000o);
                        }
                    } catch (RemoteException e) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + o000000o.f12352O000000o, e);
                    }
                }
                if (!o000000o.O00000o.isEmpty()) {
                    O00000Oo(o000000o);
                }
            }
        }

        static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            final ComponentName f12352O000000o;
            boolean O00000Oo = false;
            ArrayDeque<O0000O0o> O00000o = new ArrayDeque<>();
            INotificationSideChannel O00000o0;
            int O00000oO = 0;

            O000000o(ComponentName componentName) {
                this.f12352O000000o = componentName;
            }
        }
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final ComponentName f12353O000000o;
        final IBinder O00000Oo;

        O00000o0(ComponentName componentName, IBinder iBinder) {
            this.f12353O000000o = componentName;
            this.O00000Oo = iBinder;
        }
    }

    public static class O00000Oo implements O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f12350O000000o;
        final int O00000Oo;
        final Notification O00000o;
        final String O00000o0 = null;

        public O00000Oo(String str, int i, String str2, Notification notification) {
            this.f12350O000000o = str;
            this.O00000Oo = i;
            this.O00000o = notification;
        }

        public final void O000000o(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f12350O000000o, this.O00000Oo, this.O00000o0, this.O00000o);
        }

        public final String toString() {
            return "NotifyTask[" + "packageName:" + this.f12350O000000o + ", id:" + this.O00000Oo + ", tag:" + this.O00000o0 + "]";
        }
    }

    public static class O000000o implements O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f12349O000000o;
        final int O00000Oo;
        final boolean O00000o = false;
        final String O00000o0 = null;

        public O000000o(String str, int i, String str2) {
            this.f12349O000000o = str;
            this.O00000Oo = i;
        }

        public final void O000000o(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.O00000o) {
                iNotificationSideChannel.cancelAll(this.f12349O000000o);
            } else {
                iNotificationSideChannel.cancel(this.f12349O000000o, this.O00000Oo, this.O00000o0);
            }
        }

        public final String toString() {
            return "CancelTask[" + "packageName:" + this.f12349O000000o + ", id:" + this.O00000Oo + ", tag:" + this.O00000o0 + ", all:" + this.O00000o + "]";
        }
    }
}
