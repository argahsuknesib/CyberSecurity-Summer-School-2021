package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;

final class am extends al<ParcelFileDescriptor> {
    am(as asVar, i<ParcelFileDescriptor> iVar) {
        super(asVar, iVar);
    }

    public final void b(Bundle bundle, Bundle bundle2) throws RemoteException {
        super.b(bundle, bundle2);
        this.f3637a.b((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
