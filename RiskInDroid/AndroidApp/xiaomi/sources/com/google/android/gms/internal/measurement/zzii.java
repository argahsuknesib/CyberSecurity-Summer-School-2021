package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzii extends zzhh {
    /* access modifiers changed from: private */
    public final zziw zzaox;
    /* access modifiers changed from: private */
    public zzey zzaoy;
    private volatile Boolean zzaoz;
    private final zzem zzapa;
    private final zzjm zzapb;
    private final List<Runnable> zzapc = new ArrayList();
    private final zzem zzapd;

    protected zzii(zzgl zzgl) {
        super(zzgl);
        this.zzapb = new zzjm(zzgl.zzbt());
        this.zzaox = new zziw(this);
        this.zzapa = new zzij(this, zzgl);
        this.zzapd = new zzio(this, zzgl);
    }

    /* access modifiers changed from: private */
    public final void onServiceDisconnected(ComponentName componentName) {
        zzab();
        if (this.zzaoy != null) {
            this.zzaoy = null;
            zzge().zzit().zzg("Disconnected from device MeasurementService", componentName);
            zzab();
            zzdf();
        }
    }

    /* access modifiers changed from: private */
    public final void zzcu() {
        zzab();
        this.zzapb.start();
        this.zzapa.zzh(zzew.zzaho.get().longValue());
    }

    /* access modifiers changed from: private */
    public final void zzcv() {
        zzab();
        if (isConnected()) {
            zzge().zzit().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    private final void zzf(Runnable runnable) throws IllegalStateException {
        zzab();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzapc.size()) >= 1000) {
            zzge().zzim().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zzapc.add(runnable);
            this.zzapd.zzh(60000);
            zzdf();
        }
    }

    private final zzdz zzk(boolean z) {
        return zzfv().zzbi(z ? zzge().zziv() : null);
    }

    /* access modifiers changed from: private */
    public final void zzkg() {
        zzab();
        zzge().zzit().zzg("Processing queued up service tasks", Integer.valueOf(this.zzapc.size()));
        for (Runnable run : this.zzapc) {
            try {
                run.run();
            } catch (Exception e) {
                zzge().zzim().zzg("Task exception while flushing queue", e);
            }
        }
        this.zzapc.clear();
        this.zzapd.cancel();
    }

    public final void disconnect() {
        zzab();
        zzch();
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.zzaox);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzaoy = null;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final boolean isConnected() {
        zzab();
        zzch();
        return this.zzaoy != null;
    }

    /* access modifiers changed from: protected */
    public final void resetAnalyticsData() {
        zzab();
        zzch();
        zzdz zzk = zzk(false);
        zzfz().resetAnalyticsData();
        zzf(new zzik(this, zzk));
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(zzey zzey) {
        zzab();
        Preconditions.checkNotNull(zzey);
        this.zzaoy = zzey;
        zzcu();
        zzkg();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(zzey zzey, AbstractSafeParcelable abstractSafeParcelable, zzdz zzdz) {
        int i;
        zzfi zzim;
        String str;
        zzab();
        zzch();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zzp = zzfz().zzp(100);
            if (zzp != null) {
                arrayList.addAll(zzp);
                i = zzp.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzeu) {
                    try {
                        zzey.zza((zzeu) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e) {
                        e = e;
                        zzim = zzge().zzim();
                        str = "Failed to send event to the service";
                    }
                } else if (abstractSafeParcelable2 instanceof zzjx) {
                    try {
                        zzey.zza((zzjx) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e2) {
                        e = e2;
                        zzim = zzge().zzim();
                        str = "Failed to send attribute to the service";
                    }
                } else if (abstractSafeParcelable2 instanceof zzed) {
                    try {
                        zzey.zza((zzed) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e3) {
                        e = e3;
                        zzim = zzge().zzim();
                        str = "Failed to send conditional property to the service";
                    }
                } else {
                    zzge().zzim().log("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
        return;
        zzim.zzg(str, e);
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzab();
        zzch();
        zzf(new zzil(this, atomicReference, zzk(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzed>> atomicReference, String str, String str2, String str3) {
        zzab();
        zzch();
        zzf(new zzis(this, atomicReference, str, str2, str3, zzk(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzjx>> atomicReference, String str, String str2, String str3, boolean z) {
        zzab();
        zzch();
        zzf(new zzit(this, atomicReference, str, str2, str3, z, zzk(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzjx>> atomicReference, boolean z) {
        zzab();
        zzch();
        zzf(new zziv(this, atomicReference, zzk(false), z));
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzeu zzeu, String str) {
        Preconditions.checkNotNull(zzeu);
        zzab();
        zzch();
        zzf(new zziq(this, true, zzfz().zza(zzeu), zzeu, zzk(true), str));
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzie zzie) {
        zzab();
        zzch();
        zzf(new zzin(this, zzie));
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzjx zzjx) {
        zzab();
        zzch();
        zzf(new zziu(this, zzfz().zza(zzjx), zzjx, zzk(true)));
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzed zzed) {
        Preconditions.checkNotNull(zzed);
        zzab();
        zzch();
        zzf(new zzir(this, true, zzfz().zzc(zzed), new zzed(zzed), zzk(true), zzed));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f5  */
    public final void zzdf() {
        boolean z;
        boolean z2;
        String str;
        zzfi zzfi;
        String str2;
        zzfi zzfi2;
        zzab();
        zzch();
        if (!isConnected()) {
            boolean z3 = false;
            if (this.zzaoz == null) {
                zzab();
                zzch();
                Boolean zzjb = zzgf().zzjb();
                if (zzjb == null || !zzjb.booleanValue()) {
                    if (zzfv().zzik() != 1) {
                        zzge().zzit().log("Checking service availability");
                        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzgb().getContext(), 12451);
                        if (isGooglePlayServicesAvailable != 0) {
                            if (isGooglePlayServicesAvailable == 1) {
                                zzge().zzit().log("Service missing");
                                z2 = true;
                            } else if (isGooglePlayServicesAvailable != 2) {
                                if (isGooglePlayServicesAvailable == 3) {
                                    zzfi2 = zzge().zzip();
                                    str2 = "Service disabled";
                                    zzfi2.log(str2);
                                } else if (isGooglePlayServicesAvailable == 9) {
                                    zzfi2 = zzge().zzip();
                                    str2 = "Service invalid";
                                    zzfi2.log(str2);
                                } else if (isGooglePlayServicesAvailable != 18) {
                                    zzge().zzip().zzg("Unexpected service status", Integer.valueOf(isGooglePlayServicesAvailable));
                                } else {
                                    zzfi = zzge().zzip();
                                    str = "Service updating";
                                }
                                z2 = false;
                            } else {
                                zzge().zzis().log("Service container out of date");
                                if (zzgb().zzld() >= 12600) {
                                    Boolean zzjb2 = zzgf().zzjb();
                                    z = zzjb2 == null || zzjb2.booleanValue();
                                    z2 = false;
                                    if (z2) {
                                        zzgf().zzf(z);
                                    }
                                }
                                z2 = true;
                            }
                            z = false;
                            if (z2) {
                            }
                        } else {
                            zzfi = zzge().zzit();
                            str = "Service available";
                        }
                        zzfi.log(str);
                    }
                    z2 = true;
                    z = true;
                    if (z2) {
                    }
                } else {
                    z = true;
                }
                this.zzaoz = Boolean.valueOf(z);
            }
            if (this.zzaoz.booleanValue()) {
                this.zzaox.zzkh();
                return;
            }
            List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                z3 = true;
            }
            if (z3) {
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.zzaox.zzc(intent);
                return;
            }
            zzge().zzim().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        }
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        return super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        return super.zzgg();
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void zzkb() {
        zzab();
        zzch();
        zzf(new zzim(this, zzk(true)));
    }

    /* access modifiers changed from: protected */
    public final void zzke() {
        zzab();
        zzch();
        zzf(new zzip(this, zzk(true)));
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzkf() {
        return this.zzaoz;
    }
}
