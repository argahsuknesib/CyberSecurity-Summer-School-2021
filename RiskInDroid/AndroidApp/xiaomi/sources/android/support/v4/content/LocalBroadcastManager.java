package android.support.v4.content;

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

public final class LocalBroadcastManager {
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap<>();

    static class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            sb.append("}");
            return sb.toString();
        }
    }

    static class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent intent2, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent2;
            this.receivers = arrayList;
        }
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            /* class android.support.v4.content.LocalBroadcastManager.AnonymousClass1 */

            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    public final void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList remove = this.mReceivers.remove(broadcastReceiver);
            if (remove != null) {
                for (int i = 0; i < remove.size(); i++) {
                    IntentFilter intentFilter = (IntentFilter) remove.get(i);
                    for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                        String action = intentFilter.getAction(i2);
                        ArrayList arrayList = this.mActions.get(action);
                        if (arrayList != null) {
                            int i3 = 0;
                            while (i3 < arrayList.size()) {
                                if (((ReceiverRecord) arrayList.get(i3)).receiver == broadcastReceiver) {
                                    arrayList.remove(i3);
                                    i3--;
                                }
                                i3++;
                            }
                            if (arrayList.size() <= 0) {
                                this.mActions.remove(action);
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
    public final boolean sendBroadcast(Intent intent) {
        String str;
        ArrayList arrayList;
        int i;
        String str2;
        ArrayList arrayList2;
        Intent intent2 = intent;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent2.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent2);
            }
            ArrayList arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    ReceiverRecord receiverRecord = (ReceiverRecord) arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + receiverRecord.filter);
                    }
                    if (receiverRecord.broadcasting) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList = arrayList3;
                        str2 = action;
                        str = resolveTypeIfNeeded;
                        arrayList2 = arrayList4;
                    } else {
                        ReceiverRecord receiverRecord2 = receiverRecord;
                        str2 = action;
                        arrayList2 = arrayList4;
                        i = i2;
                        arrayList = arrayList3;
                        str = resolveTypeIfNeeded;
                        int match = receiverRecord.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                            arrayList4.add(receiverRecord2);
                            receiverRecord2.broadcasting = true;
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
                        ((ReceiverRecord) arrayList5.get(i3)).broadcasting = false;
                    }
                    this.mPendingBroadcasts.add(new BroadcastRecord(intent2, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                }
            }
        }
    }

    public final void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r2 >= r1.length) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r3 = r1[r2];
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r4 >= r3.receivers.size()) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r3.receivers.get(r4).receiver.onReceive(r8.mAppContext, r3.intent);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r2 = 0;
     */
    public final void executePendingBroadcasts() {
        while (true) {
            synchronized (this.mReceivers) {
                int size = this.mPendingBroadcasts.size();
                if (size > 0) {
                    BroadcastRecord[] broadcastRecordArr = new BroadcastRecord[size];
                    this.mPendingBroadcasts.toArray(broadcastRecordArr);
                    this.mPendingBroadcasts.clear();
                } else {
                    return;
                }
            }
        }
        while (true) {
        }
    }
}
