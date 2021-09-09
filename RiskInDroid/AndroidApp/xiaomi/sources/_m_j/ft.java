package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class ft {
    private static final Object O00000oo = new Object();
    private static ft O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    final Context f17082O000000o;
    final HashMap<BroadcastReceiver, ArrayList<O00000Oo>> O00000Oo = new HashMap<>();
    private final HashMap<String, ArrayList<O00000Oo>> O00000o = new HashMap<>();
    final ArrayList<O000000o> O00000o0 = new ArrayList<>();
    private final Handler O00000oO;

    static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final IntentFilter f17085O000000o;
        final BroadcastReceiver O00000Oo;
        boolean O00000o;
        boolean O00000o0;

        O00000Oo(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f17085O000000o = intentFilter;
            this.O00000Oo = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            sb.append("Receiver{");
            sb.append(this.O00000Oo);
            sb.append(" filter=");
            sb.append(this.f17085O000000o);
            if (this.O00000o) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final Intent f17084O000000o;
        final ArrayList<O00000Oo> O00000Oo;

        O000000o(Intent intent, ArrayList<O00000Oo> arrayList) {
            this.f17084O000000o = intent;
            this.O00000Oo = arrayList;
        }
    }

    public static ft O000000o(Context context) {
        ft ftVar;
        synchronized (O00000oo) {
            if (O0000O0o == null) {
                O0000O0o = new ft(context.getApplicationContext());
            }
            ftVar = O0000O0o;
        }
        return ftVar;
    }

    private ft(Context context) {
        this.f17082O000000o = context;
        this.O00000oO = new Handler(context.getMainLooper()) {
            /* class _m_j.ft.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
                r2 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
                if (r2 >= r1.length) goto L_0x000b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
                r3 = r1[r2];
                r4 = r3.O00000Oo.size();
                r5 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
                if (r5 >= r4) goto L_0x004d;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
                r6 = r3.O00000Oo.get(r5);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
                if (r6.O00000o != false) goto L_0x004a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
                r6.O00000Oo.onReceive(r10.f17082O000000o, r3.f17084O000000o);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
                r5 = r5 + 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
                r2 = r2 + 1;
             */
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                ft ftVar = ft.this;
                while (true) {
                    synchronized (ftVar.O00000Oo) {
                        int size = ftVar.O00000o0.size();
                        if (size > 0) {
                            O000000o[] o000000oArr = new O000000o[size];
                            ftVar.O00000o0.toArray(o000000oArr);
                            ftVar.O00000o0.clear();
                        } else {
                            return;
                        }
                    }
                }
                while (true) {
                }
            }
        };
    }

    public final void O000000o(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.O00000Oo) {
            O00000Oo o00000Oo = new O00000Oo(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.O00000Oo.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.O00000Oo.put(broadcastReceiver, arrayList);
            }
            arrayList.add(o00000Oo);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList arrayList2 = this.O00000o.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.O00000o.put(action, arrayList2);
                }
                arrayList2.add(o00000Oo);
            }
        }
    }

    public final void O000000o(BroadcastReceiver broadcastReceiver) {
        synchronized (this.O00000Oo) {
            ArrayList remove = this.O00000Oo.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    O00000Oo o00000Oo = (O00000Oo) remove.get(size);
                    o00000Oo.O00000o = true;
                    for (int i = 0; i < o00000Oo.f17085O000000o.countActions(); i++) {
                        String action = o00000Oo.f17085O000000o.getAction(i);
                        ArrayList arrayList = this.O00000o.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                O00000Oo o00000Oo2 = (O00000Oo) arrayList.get(size2);
                                if (o00000Oo2.O00000Oo == broadcastReceiver) {
                                    o00000Oo2.O00000o = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.O00000o.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0156, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0158, code lost:
        return false;
     */
    public final boolean O000000o(Intent intent) {
        String str;
        ArrayList arrayList;
        int i;
        String str2;
        ArrayList arrayList2;
        Intent intent2 = intent;
        synchronized (this.O00000Oo) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent2.resolveTypeIfNeeded(this.f17082O000000o.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent2);
            }
            ArrayList arrayList3 = this.O00000o.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    O00000Oo o00000Oo = (O00000Oo) arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + o00000Oo.f17085O000000o);
                    }
                    if (o00000Oo.O00000o0) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList = arrayList3;
                        str2 = action;
                        str = resolveTypeIfNeeded;
                        arrayList2 = arrayList4;
                    } else {
                        O00000Oo o00000Oo2 = o00000Oo;
                        str2 = action;
                        arrayList2 = arrayList4;
                        i = i2;
                        arrayList = arrayList3;
                        str = resolveTypeIfNeeded;
                        int match = o00000Oo.f17085O000000o.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                            arrayList4.add(o00000Oo2);
                            o00000Oo2.O00000o0 = true;
                            i2 = i + 1;
                            action = str2;
                            arrayList3 = arrayList;
                            resolveTypeIfNeeded = str;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList2;
                    i2 = i + 1;
                    action = str2;
                    arrayList3 = arrayList;
                    resolveTypeIfNeeded = str;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((O00000Oo) arrayList5.get(i3)).O00000o0 = false;
                    }
                    this.O00000o0.add(new O000000o(intent2, arrayList5));
                    if (!this.O00000oO.hasMessages(1)) {
                        this.O00000oO.sendEmptyMessage(1);
                    }
                }
            }
        }
    }
}
