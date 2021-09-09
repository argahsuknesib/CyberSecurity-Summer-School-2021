package com.google.firebase.iid;

import _m_j.o0OO00OO;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzi;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzal {
    private static int zzbr;
    private static PendingIntent zzcf;
    private final zzae zzal;
    private final o0OO00OO<String, TaskCompletionSource<Bundle>> zzcg = new o0OO00OO<>();
    private Messenger zzch;
    private Messenger zzci;
    private zzi zzcj;
    private final Context zzz;

    public zzal(Context context, zzae zzae) {
        this.zzz = context;
        this.zzal = zzae;
        this.zzch = new Messenger(new zzam(this, Looper.getMainLooper()));
    }

    private static synchronized void zza(Context context, Intent intent) {
        synchronized (zzal.class) {
            if (zzcf == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzcf = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", zzcf);
        }
    }

    private final void zza(String str, Bundle bundle) {
        synchronized (this.zzcg) {
            TaskCompletionSource remove = this.zzcg.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.setResult(bundle);
        }
    }

    private static synchronized String zzac() {
        String num;
        synchronized (zzal.class) {
            int i = zzbr;
            zzbr = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* access modifiers changed from: private */
    public final void zzb(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(new zzi.zza());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof zzi) {
                this.zzcj = (zzi) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.zzci = (Messenger) parcelableExtra;
            }
        }
        Intent intent2 = (Intent) message.obj;
        String action = intent2.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            String stringExtra = intent2.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent2.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(valueOf);
                    Log.w("FirebaseInstanceId", sb.toString());
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf2 = String.valueOf(stringExtra2);
                    Log.d("FirebaseInstanceId", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
                }
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (split.length <= 2 || !"ID".equals(split[1])) {
                        String valueOf3 = String.valueOf(stringExtra2);
                        Log.w("FirebaseInstanceId", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
                        return;
                    }
                    String str = split[2];
                    String str2 = split[3];
                    if (str2.startsWith(":")) {
                        str2 = str2.substring(1);
                    }
                    zza(str, intent2.putExtra("error", str2).getExtras());
                    return;
                }
                synchronized (this.zzcg) {
                    for (int i = 0; i < this.zzcg.size(); i++) {
                        zza(this.zzcg.O00000Oo(i), intent2.getExtras());
                    }
                }
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (matcher.matches()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", group2);
                zza(group, extras);
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf4 = String.valueOf(stringExtra);
                Log.d("FirebaseInstanceId", valueOf4.length() != 0 ? "Unexpected response string: ".concat(valueOf4) : new String("Unexpected response string: "));
            }
        } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf5 = String.valueOf(action);
            Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? "Unexpected response action: ".concat(valueOf5) : new String("Unexpected response action: "));
        }
    }

    private final Bundle zzd(Bundle bundle) throws IOException {
        Bundle zze = zze(bundle);
        if (zze == null || !zze.containsKey("google.messenger")) {
            return zze;
        }
        Bundle zze2 = zze(bundle);
        if (zze2 == null || !zze2.containsKey("google.messenger")) {
            return zze2;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ec A[SYNTHETIC] */
    private final Bundle zze(Bundle bundle) throws IOException {
        String zzac = zzac();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.zzcg) {
            this.zzcg.put(zzac, taskCompletionSource);
        }
        if (this.zzal.zzx() != 0) {
            Intent intent = new Intent();
            intent.setPackage("com.google.android.gms");
            intent.setAction(this.zzal.zzx() == 2 ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.putExtras(bundle);
            zza(this.zzz, intent);
            StringBuilder sb = new StringBuilder(String.valueOf(zzac).length() + 5);
            sb.append("|ID|");
            sb.append(zzac);
            sb.append("|");
            intent.putExtra("kid", sb.toString());
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 8);
                sb2.append("Sending ");
                sb2.append(valueOf);
                Log.d("FirebaseInstanceId", sb2.toString());
            }
            intent.putExtra("google.messenger", this.zzch);
            if (!(this.zzci == null && this.zzcj == null)) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                try {
                    if (this.zzci != null) {
                        this.zzci.send(obtain);
                    } else {
                        this.zzcj.send(obtain);
                    }
                } catch (RemoteException unused) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        Log.d("FirebaseInstanceId", "Messenger failed, fallback to startService");
                    }
                }
                Bundle bundle2 = (Bundle) Tasks.await(taskCompletionSource.getTask(), DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, TimeUnit.MILLISECONDS);
                synchronized (this.zzcg) {
                    this.zzcg.remove(zzac);
                }
                return bundle2;
            }
            if (this.zzal.zzx() == 2) {
                this.zzz.sendBroadcast(intent);
            } else {
                this.zzz.startService(intent);
            }
            try {
                Bundle bundle22 = (Bundle) Tasks.await(taskCompletionSource.getTask(), DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, TimeUnit.MILLISECONDS);
                synchronized (this.zzcg) {
                }
            } catch (InterruptedException | TimeoutException unused2) {
                Log.w("FirebaseInstanceId", "No response");
                throw new IOException("TIMEOUT");
            } catch (ExecutionException e) {
                throw new IOException(e);
            } catch (Throwable th) {
                synchronized (this.zzcg) {
                    this.zzcg.remove(zzac);
                    throw th;
                }
            }
        } else {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzc(Bundle bundle) throws IOException {
        if (this.zzal.zzaa() < 12000000) {
            return zzd(bundle);
        }
        try {
            return (Bundle) Tasks.await(zzs.zzc(this.zzz).zzb(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            if (!(e.getCause() instanceof zzac) || ((zzac) e.getCause()).getErrorCode() != 4) {
                return null;
            }
            return zzd(bundle);
        }
    }
}
