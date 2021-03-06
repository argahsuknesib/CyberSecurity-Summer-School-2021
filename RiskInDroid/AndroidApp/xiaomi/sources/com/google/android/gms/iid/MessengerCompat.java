package com.google.android.gms.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat implements ReflectedParcelable {
    public static final Parcelable.Creator<MessengerCompat> CREATOR = new zzq();
    private Messenger zzab;
    private zzl zzby;

    /* JADX WARN: Type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public MessengerCompat(IBinder iBinder) {
        zzl zzl;
        if (Build.VERSION.SDK_INT >= 21) {
            this.zzab = new Messenger(iBinder);
            return;
        }
        if (iBinder == null) {
            zzl = null;
        } else {
            ? queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            zzl = queryLocalInterface instanceof zzl ? queryLocalInterface : new zzm(iBinder);
        }
        this.zzby = zzl;
    }

    private final IBinder getBinder() {
        Messenger messenger = this.zzab;
        return messenger != null ? messenger.getBinder() : this.zzby.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((MessengerCompat) obj).getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public final void send(Message message) throws RemoteException {
        Messenger messenger = this.zzab;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.zzby.send(message);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.zzab;
        parcel.writeStrongBinder(messenger != null ? messenger.getBinder() : this.zzby.asBinder());
    }
}
