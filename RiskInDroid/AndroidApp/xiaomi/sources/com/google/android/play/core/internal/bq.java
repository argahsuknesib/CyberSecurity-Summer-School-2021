package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public abstract class bq extends j implements br {
    public bq() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                c(parcel.readInt(), (Bundle) k.a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                k.a(parcel, Bundle.CREATOR);
                a(readInt);
                return true;
            case 4:
                a(parcel.readInt(), (Bundle) k.a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                b(parcel.readInt(), (Bundle) k.a(parcel, Bundle.CREATOR));
                return true;
            case 6:
                e((Bundle) k.a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                a(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                d((Bundle) k.a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                a((Bundle) k.a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                k.a(parcel, Bundle.CREATOR);
                b();
                return true;
            case 11:
                k.a(parcel, Bundle.CREATOR);
                a();
                return true;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                b((Bundle) k.a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                c((Bundle) k.a(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
