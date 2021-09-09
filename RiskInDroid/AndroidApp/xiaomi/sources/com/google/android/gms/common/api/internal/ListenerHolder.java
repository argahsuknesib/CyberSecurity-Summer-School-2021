package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class ListenerHolder<L> {
    private final zza zzlh;
    private volatile L zzli;
    private final ListenerKey<L> zzlj;

    @KeepForSdk
    public static final class ListenerKey<L> {
        private final L zzli;
        private final String zzll;

        @KeepForSdk
        ListenerKey(L l, String str) {
            this.zzli = l;
            this.zzll = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.zzli == listenerKey.zzli && this.zzll.equals(listenerKey.zzll);
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zzli) * 31) + this.zzll.hashCode();
        }
    }

    @KeepForSdk
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(L l);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            ListenerHolder.this.notifyListenerInternal((Notifier) message.obj);
        }
    }

    @KeepForSdk
    ListenerHolder(Looper looper, L l, String str) {
        this.zzlh = new zza(looper);
        this.zzli = Preconditions.checkNotNull(l, "Listener must not be null");
        this.zzlj = new ListenerKey<>(l, Preconditions.checkNotEmpty(str));
    }

    @KeepForSdk
    public final void clear() {
        this.zzli = null;
    }

    @KeepForSdk
    public final ListenerKey<L> getListenerKey() {
        return this.zzlj;
    }

    @KeepForSdk
    public final boolean hasListener() {
        return this.zzli != null;
    }

    @KeepForSdk
    public final void notifyListener(Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zzlh.sendMessage(this.zzlh.obtainMessage(1, notifier));
    }

    /* access modifiers changed from: package-private */
    @KeepForSdk
    public final void notifyListenerInternal(Notifier<? super L> notifier) {
        L l = this.zzli;
        if (l == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(l);
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            throw e;
        }
    }
}
