package com.google.firebase.iid;

import _m_j.o0O0OOO0;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

final class zzah {
    private final Map<Pair<String, String>, TaskCompletionSource<String>> zzca = new o0O0OOO0();

    zzah() {
    }

    /* access modifiers changed from: private */
    public static String zza(TaskCompletionSource<String> taskCompletionSource) throws IOException {
        try {
            return (String) Tasks.await(taskCompletionSource.getTask());
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(cause);
            }
        } catch (InterruptedException e2) {
            throw new IOException(e2);
        }
    }

    private static String zza(zzak zzak, TaskCompletionSource<String> taskCompletionSource) throws IOException {
        try {
            String zzp = zzak.zzp();
            taskCompletionSource.setResult(zzp);
            return zzp;
        } catch (IOException | RuntimeException e) {
            taskCompletionSource.setException(e);
            throw e;
        }
    }

    private final synchronized zzak zzb(String str, String str2, zzak zzak) {
        Pair pair = new Pair(str, str2);
        TaskCompletionSource taskCompletionSource = this.zzca.get(pair);
        if (taskCompletionSource != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return new zzai(taskCompletionSource);
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        this.zzca.put(pair, taskCompletionSource2);
        return new zzaj(this, zzak, taskCompletionSource2, pair);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zza(zzak zzak, TaskCompletionSource taskCompletionSource, Pair pair) throws IOException {
        try {
            String zza = zza(zzak, taskCompletionSource);
            synchronized (this) {
                this.zzca.remove(pair);
            }
            return zza;
        } catch (Throwable th) {
            synchronized (this) {
                this.zzca.remove(pair);
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zza(String str, String str2, zzak zzak) throws IOException {
        return zzb(str, str2, zzak).zzp();
    }
}
