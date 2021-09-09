package com.google.firebase.iid;

final /* synthetic */ class zzk implements zzak {
    private final FirebaseInstanceId zzaq;
    private final String zzar;
    private final String zzas;

    zzk(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.zzaq = firebaseInstanceId;
        this.zzar = str;
        this.zzas = str2;
    }

    public final String zzp() {
        return this.zzaq.zza(this.zzar, this.zzas);
    }
}
