package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GoogleCertificates;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
public class GoogleCertificatesQuery extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleCertificatesQuery> CREATOR = new GoogleCertificatesQueryCreator();
    @SafeParcelable.Field(getter = "getCallingPackage", id = 1)
    private final String zzbh;
    @SafeParcelable.Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    private final GoogleCertificates.CertData zzbi;
    @SafeParcelable.Field(getter = "getAllowTestKeys", id = 3)
    private final boolean zzbj;

    @SafeParcelable.Constructor
    GoogleCertificatesQuery(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) boolean z) {
        this.zzbh = str;
        this.zzbi = zza(iBinder);
        this.zzbj = z;
    }

    GoogleCertificatesQuery(String str, GoogleCertificates.CertData certData, boolean z) {
        this.zzbh = str;
        this.zzbi = certData;
        this.zzbj = z;
    }

    private static GoogleCertificates.CertData zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper bytesWrapped = ICertData.Stub.asInterface(iBinder).getBytesWrapped();
            byte[] bArr = bytesWrapped == null ? null : (byte[]) ObjectWrapper.unwrap(bytesWrapped);
            if (bArr != null) {
                return new zzb(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    public boolean getAllowTestKeys() {
        return this.zzbj;
    }

    public IBinder getCallingCertificateBinder() {
        GoogleCertificates.CertData certData = this.zzbi;
        if (certData != null) {
            return certData.asBinder();
        }
        Log.w("GoogleCertificatesQuery", "certificate binder is null");
        return null;
    }

    public String getCallingPackage() {
        return this.zzbh;
    }

    public GoogleCertificates.CertData getCertificate() {
        return this.zzbi;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getCallingPackage(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, getCallingCertificateBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, getAllowTestKeys());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
