package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.firebase_messaging.zze;
import com.google.android.gms.internal.firebase_messaging.zzf;

public class zzi implements Parcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    private Messenger zzaf;
    private zze zzag;

    public static final class zza extends ClassLoader {
        /* access modifiers changed from: protected */
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (!FirebaseInstanceId.zzj()) {
                return zzi.class;
            }
            Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            return zzi.class;
        }
    }

    public zzi(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.zzaf = new Messenger(iBinder);
        } else {
            this.zzag = zzf.zza(iBinder);
        }
    }

    private final IBinder getBinder() {
        Messenger messenger = this.zzaf;
        return messenger != null ? messenger.getBinder() : this.zzag.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((zzi) obj).getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public final void send(Message message) throws RemoteException {
        Messenger messenger = this.zzaf;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.zzag.send(message);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.zzaf;
        parcel.writeStrongBinder(messenger != null ? messenger.getBinder() : this.zzag.asBinder());
    }
}
