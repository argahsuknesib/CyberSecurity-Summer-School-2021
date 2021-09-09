package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzan;
import com.google.firebase.iid.zzb;
import com.google.firebase.iid.zzs;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseMessagingService extends zzb {
    private static final Queue<String> zzdg = new ArrayDeque(10);

    static void zzj(Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    static boolean zzk(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    public final Intent zzb(Intent intent) {
        return zzan.zzad().zzae();
    }

    public final boolean zzc(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!zzk(intent.getExtras())) {
            return true;
        }
        zzb.zzd(this, intent);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cd  */
    public final void zzd(Intent intent) {
        char c;
        Task<Void> task;
        boolean z;
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        int hashCode = action.hashCode();
        char c2 = 65535;
        if (hashCode != 75300319) {
            if (hashCode == 366519424 && action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                c = 0;
                if (c == 0) {
                    String stringExtra = intent.getStringExtra("google.message_id");
                    if (TextUtils.isEmpty(stringExtra)) {
                        task = Tasks.forResult(null);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("google.message_id", stringExtra);
                        task = zzs.zzc(this).zza(2, bundle);
                    }
                    if (!TextUtils.isEmpty(stringExtra)) {
                        if (zzdg.contains(stringExtra)) {
                            if (Log.isLoggable("FirebaseMessaging", 3)) {
                                String valueOf = String.valueOf(stringExtra);
                                Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Received duplicate message: ".concat(valueOf) : new String("Received duplicate message: "));
                            }
                            z = true;
                            if (!z) {
                                String stringExtra2 = intent.getStringExtra("message_type");
                                if (stringExtra2 == null) {
                                    stringExtra2 = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
                                }
                                switch (stringExtra2.hashCode()) {
                                    case -2062414158:
                                        if (stringExtra2.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                                            c2 = 1;
                                            break;
                                        }
                                        break;
                                    case 102161:
                                        if (stringExtra2.equals(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                                            c2 = 0;
                                            break;
                                        }
                                        break;
                                    case 814694033:
                                        if (stringExtra2.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
                                            c2 = 3;
                                            break;
                                        }
                                        break;
                                    case 814800675:
                                        if (stringExtra2.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_EVENT)) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                }
                                if (c2 == 0) {
                                    if (zzk(intent.getExtras())) {
                                        zzb.zzc(this, intent);
                                    }
                                    Bundle extras = intent.getExtras();
                                    if (extras == null) {
                                        extras = new Bundle();
                                    }
                                    extras.remove("androidx.contentpager.content.wakelockid");
                                    if (zza.zzf(extras)) {
                                        if (!zza.zzd(this).zzh(extras)) {
                                            if (zzk(extras)) {
                                                zzb.zzf(this, intent);
                                            }
                                        }
                                    }
                                    onMessageReceived(new RemoteMessage(extras));
                                } else if (c2 == 1) {
                                    onDeletedMessages();
                                } else if (c2 == 2) {
                                    onMessageSent(intent.getStringExtra("google.message_id"));
                                } else if (c2 != 3) {
                                    String valueOf2 = String.valueOf(stringExtra2);
                                    Log.w("FirebaseMessaging", valueOf2.length() != 0 ? "Received message with unknown type: ".concat(valueOf2) : new String("Received message with unknown type: "));
                                } else {
                                    String stringExtra3 = intent.getStringExtra("google.message_id");
                                    if (stringExtra3 == null) {
                                        stringExtra3 = intent.getStringExtra("message_id");
                                    }
                                    onSendError(stringExtra3, new SendException(intent.getStringExtra("error")));
                                }
                            }
                            Tasks.await(task, 1, TimeUnit.SECONDS);
                            return;
                        }
                        if (zzdg.size() >= 10) {
                            zzdg.remove();
                        }
                        zzdg.add(stringExtra);
                    }
                    z = false;
                    if (!z) {
                    }
                    try {
                        Tasks.await(task, 1, TimeUnit.SECONDS);
                        return;
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        String valueOf3 = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 20);
                        sb.append("Message ack failed: ");
                        sb.append(valueOf3);
                        Log.w("FirebaseMessaging", sb.toString());
                        return;
                    }
                } else if (c != 1) {
                    String valueOf4 = String.valueOf(intent.getAction());
                    Log.d("FirebaseMessaging", valueOf4.length() != 0 ? "Unknown intent action: ".concat(valueOf4) : new String("Unknown intent action: "));
                    return;
                } else if (zzk(intent.getExtras())) {
                    zzb.zze(this, intent);
                    return;
                } else {
                    return;
                }
            }
        } else if (action.equals("com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }
}
