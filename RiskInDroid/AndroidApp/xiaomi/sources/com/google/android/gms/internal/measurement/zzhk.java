package com.google.android.gms.internal.measurement;

import _m_j.o0O0OOO0;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhk extends zzhh {
    @VisibleForTesting
    protected zzid zzanp;
    private AppMeasurement.EventInterceptor zzanq;
    private final Set<AppMeasurement.OnEventListener> zzanr = new CopyOnWriteArraySet();
    private boolean zzans;
    private final AtomicReference<String> zzant = new AtomicReference<>();
    @VisibleForTesting
    protected boolean zzanu = true;

    protected zzhk(zzgl zzgl) {
        super(zzgl);
    }

    private final void zza(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzgb().zzcf(str) != 0) {
            zzge().zzim().zzg("Invalid conditional user property name", zzga().zzbl(str));
        } else if (zzgb().zzi(str, obj) != 0) {
            zzge().zzim().zze("Invalid conditional user property value", zzga().zzbl(str), obj);
        } else {
            Object zzj = zzgb().zzj(str, obj);
            if (zzj == null) {
                zzge().zzim().zze("Unable to normalize conditional user property value", zzga().zzbl(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzj;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                long j2 = conditionalUserProperty.mTimeToLive;
                if (j2 > 15552000000L || j2 < 1) {
                    zzge().zzim().zze("Invalid conditional user property time to live", zzga().zzbl(str), Long.valueOf(j2));
                } else {
                    zzgd().zzc(new zzhr(this, conditionalUserProperty));
                }
            } else {
                zzge().zzim().zze("Invalid conditional user property timeout", zzga().zzbl(str), Long.valueOf(j));
            }
        }
    }

    private final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        Bundle bundle3 = bundle;
        if (bundle3 == null) {
            bundle2 = new Bundle();
        } else {
            Bundle bundle4 = new Bundle(bundle3);
            for (String next : bundle4.keySet()) {
                Object obj = bundle4.get(next);
                if (obj instanceof Bundle) {
                    bundle4.putBundle(next, new Bundle((Bundle) obj));
                } else {
                    int i = 0;
                    if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        while (i < parcelableArr.length) {
                            if (parcelableArr[i] instanceof Bundle) {
                                parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                            }
                            i++;
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        while (i < arrayList.size()) {
                            Object obj2 = arrayList.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.set(i, new Bundle((Bundle) obj2));
                            }
                            i++;
                        }
                    }
                }
            }
            bundle2 = bundle4;
        }
        zzgd().zzc(new zzic(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzgd().zzc(new zzhm(this, str, str2, obj, j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzbt().currentTimeMillis(), bundle, true, z2, z3, null);
    }

    /* access modifiers changed from: private */
    public final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("User property not set since app measurement is disabled");
        } else if (this.zzacw.zzjv()) {
            zzge().zzis().zze("Setting user property (FE)", zzga().zzbj(str2), obj);
            zzfx().zzb(new zzjx(str2, j, obj, str));
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgd().zzc(new zzhs(this, conditionalUserProperty));
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        zzfi zzip;
        String str4;
        if (zzgd().zzjk()) {
            zzip = zzge().zzim();
            str4 = "Cannot get user properties from analytics worker thread";
        } else {
            zzgd();
            if (zzgg.isMainThread()) {
                zzip = zzge().zzim();
                str4 = "Cannot get user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zzacw.zzgd().zzc(new zzhu(this, atomicReference, str, str2, str3, z));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzge().zzip().zzg("Interrupted waiting for get user properties", e);
                    }
                }
                List<zzjx> list = (List) atomicReference.get();
                if (list == null) {
                    zzip = zzge().zzip();
                    str4 = "Timed out waiting for get user properties";
                } else {
                    o0O0OOO0 o0o0ooo0 = new o0O0OOO0(list.size());
                    for (zzjx zzjx : list) {
                        o0o0ooo0.put(zzjx.name, zzjx.getValue());
                    }
                    return o0o0ooo0;
                }
            }
        }
        zzip.log(str4);
        return Collections.emptyMap();
    }

    /* access modifiers changed from: private */
    public final void zzb(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = conditionalUserProperty;
        zzab();
        zzch();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty2.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty2.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty2.mValue);
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("Conditional property not sent since Firebase Analytics is disabled");
            return;
        }
        zzjx zzjx = new zzjx(conditionalUserProperty2.mName, conditionalUserProperty2.mTriggeredTimestamp, conditionalUserProperty2.mValue, conditionalUserProperty2.mOrigin);
        try {
            zzeu zza = zzgb().zza(conditionalUserProperty2.mTriggeredEventName, conditionalUserProperty2.mTriggeredEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
            zzeu zza2 = zzgb().zza(conditionalUserProperty2.mTimedOutEventName, conditionalUserProperty2.mTimedOutEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
            zzeu zza3 = zzgb().zza(conditionalUserProperty2.mExpiredEventName, conditionalUserProperty2.mExpiredEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
            String str = conditionalUserProperty2.mAppId;
            String str2 = conditionalUserProperty2.mOrigin;
            long j = conditionalUserProperty2.mCreationTimestamp;
            String str3 = conditionalUserProperty2.mTriggerEventName;
            long j2 = conditionalUserProperty2.mTriggerTimeout;
            zzed zzed = r3;
            zzed zzed2 = new zzed(str, str2, zzjx, j, false, str3, zza2, j2, zza, conditionalUserProperty2.mTimeToLive, zza3);
            zzfx().zzd(zzed);
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String
     arg types: [java.lang.String, int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzka.zza(int, java.lang.Object, boolean):java.lang.Object
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String[]):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(com.google.android.gms.internal.measurement.zzko[], java.lang.String, java.lang.Object):com.google.android.gms.internal.measurement.zzko[]
      com.google.android.gms.internal.measurement.zzka.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, android.os.Bundle, java.util.List<java.lang.String>, boolean, boolean):android.os.Bundle
     arg types: [java.lang.String, android.os.Bundle, java.util.List, boolean, int]
     candidates:
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String, int, java.lang.Object, boolean):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, java.lang.String, java.lang.String, int):void
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, android.os.Bundle, java.util.List<java.lang.String>, boolean, boolean):android.os.Bundle */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzif.zza(com.google.android.gms.internal.measurement.zzie, android.os.Bundle, boolean):void
     arg types: [com.google.android.gms.internal.measurement.zzie, android.os.Bundle, int]
     candidates:
      com.google.android.gms.internal.measurement.zzif.zza(android.app.Activity, com.google.android.gms.internal.measurement.zzie, boolean):void
      com.google.android.gms.internal.measurement.zzif.zza(com.google.android.gms.internal.measurement.zzie, android.os.Bundle, boolean):void */
    /* access modifiers changed from: private */
    public final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        String[] strArr;
        int i;
        int i2;
        Bundle bundle2;
        String str4 = str;
        String str5 = str2;
        Bundle bundle3 = bundle;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(bundle);
        zzab();
        zzch();
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("Event not sent since app measurement is disabled");
            return;
        }
        int i3 = 0;
        if (!this.zzans) {
            this.zzans = true;
            try {
                try {
                    Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", Context.class).invoke(null, getContext());
                } catch (Exception e) {
                    zzge().zzip().zzg("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzge().zzir().log("Tag Manager is not found and thus will not be used");
            }
        }
        if (z3 && !"_iap".equals(str5)) {
            zzka zzgb = this.zzacw.zzgb();
            int i4 = 2;
            if (zzgb.zzq("event", str5)) {
                if (!zzgb.zza("event", AppMeasurement.Event.zzacx, str5)) {
                    i4 = 13;
                } else if (zzgb.zza("event", 40, str5)) {
                    i4 = 0;
                }
            }
            if (i4 != 0) {
                zzge().zzio().zzg("Invalid public event name. Event will not be logged (FE)", zzga().zzbj(str5));
                this.zzacw.zzgb();
                String zza = zzka.zza(str5, 40, true);
                if (str5 != null) {
                    i3 = str2.length();
                }
                this.zzacw.zzgb().zza(i4, "_ev", zza, i3);
                return;
            }
        }
        zzie zzkc = zzfy().zzkc();
        if (zzkc != null && !bundle3.containsKey("_sc")) {
            zzkc.zzaok = true;
        }
        zzif.zza(zzkc, bundle3, z && z3);
        boolean equals = "am".equals(str4);
        boolean zzci = zzka.zzci(str2);
        if (z && this.zzanq != null && !zzci && !equals) {
            zzge().zzis().zze("Passing event to registered event handler (FE)", zzga().zzbj(str5), zzga().zzb(bundle3));
            this.zzanq.interceptEvent(str, str2, bundle, j);
        } else if (this.zzacw.zzjv()) {
            int zzcd = zzgb().zzcd(str5);
            if (zzcd != 0) {
                zzge().zzio().zzg("Invalid event name. Event will not be logged (FE)", zzga().zzbj(str5));
                zzgb();
                String zza2 = zzka.zza(str5, 40, true);
                if (str5 != null) {
                    i3 = str2.length();
                }
                this.zzacw.zzgb().zza(str3, zzcd, "_ev", zza2, i3);
                return;
            }
            List listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
            String str6 = "_si";
            String str7 = "_o";
            Bundle zza3 = zzgb().zza(str2, bundle, (List<String>) listOf, z3, true);
            zzie zzie = (zza3 == null || !zza3.containsKey("_sc") || !zza3.containsKey(str6)) ? null : new zzie(zza3.getString("_sn"), zza3.getString("_sc"), Long.valueOf(zza3.getLong(str6)).longValue());
            if (zzie == null) {
                zzie = zzkc;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza3);
            long nextLong = zzgb().zzlc().nextLong();
            String[] strArr2 = (String[]) zza3.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr2);
            int length = strArr2.length;
            int i5 = 0;
            int i6 = 0;
            while (i6 < length) {
                String str8 = strArr2[i6];
                Object obj = zza3.get(str8);
                zzgb();
                Bundle[] zze = zzka.zze(obj);
                if (zze != null) {
                    String str9 = "_eid";
                    zza3.putInt(str8, zze.length);
                    String str10 = str8;
                    int i7 = 0;
                    while (i7 < zze.length) {
                        Bundle bundle4 = zze[i7];
                        zzif.zza(zzie, bundle4, true);
                        int i8 = i7;
                        int i9 = i6;
                        int i10 = length;
                        Bundle zza4 = zzgb().zza("_ep", bundle4, (List<String>) listOf, z3, false);
                        zza4.putString("_en", str5);
                        String str11 = str9;
                        zza4.putLong(str11, nextLong);
                        String str12 = str10;
                        zza4.putString("_gn", str12);
                        zza4.putInt("_ll", zze.length);
                        int i11 = i8;
                        zza4.putInt("_i", i11);
                        arrayList.add(zza4);
                        int i12 = i11 + 1;
                        str10 = str12;
                        zza3 = zza3;
                        i6 = i9;
                        length = i10;
                        i5 = i5;
                        strArr2 = strArr2;
                        str9 = str11;
                        i7 = i12;
                    }
                    i2 = i6;
                    i = length;
                    strArr = strArr2;
                    bundle2 = zza3;
                    i5 += zze.length;
                } else {
                    i2 = i6;
                    i = length;
                    strArr = strArr2;
                    bundle2 = zza3;
                }
                i6 = i2 + 1;
                zza3 = bundle2;
                length = i;
                strArr2 = strArr;
            }
            Bundle bundle5 = zza3;
            if (i5 != 0) {
                bundle5.putLong("_eid", nextLong);
                bundle5.putInt("_epc", i5);
            }
            int i13 = 0;
            while (i13 < arrayList.size()) {
                Bundle bundle6 = (Bundle) arrayList.get(i13);
                String str13 = i13 != 0 ? "_ep" : str5;
                bundle6.putString(str7, str4);
                if (z2) {
                    bundle6 = zzgb().zzd(bundle6);
                }
                Bundle bundle7 = bundle6;
                zzge().zzis().zze("Logging event (FE)", zzga().zzbj(str5), zzga().zzb(bundle7));
                zzfx().zzb(new zzeu(str13, new zzer(bundle7), str, j), str3);
                if (!equals) {
                    for (AppMeasurement.OnEventListener onEvent : this.zzanr) {
                        onEvent.onEvent(str, str2, new Bundle(bundle7), j);
                    }
                }
                i13++;
            }
            if (zzfy().zzkc() != null && "_ae".equals(str5)) {
                zzgc().zzl(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzc(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = conditionalUserProperty;
        zzab();
        zzch();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty2.mName);
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("Conditional property not cleared since Firebase Analytics is disabled");
            return;
        }
        zzjx zzjx = new zzjx(conditionalUserProperty2.mName, 0, null, null);
        try {
            zzeu zza = zzgb().zza(conditionalUserProperty2.mExpiredEventName, conditionalUserProperty2.mExpiredEventParams, conditionalUserProperty2.mOrigin, conditionalUserProperty2.mCreationTimestamp, true, false);
            zzed zzed = r3;
            zzed zzed2 = new zzed(conditionalUserProperty2.mAppId, conditionalUserProperty2.mOrigin, zzjx, conditionalUserProperty2.mCreationTimestamp, conditionalUserProperty2.mActive, conditionalUserProperty2.mTriggerEventName, null, conditionalUserProperty2.mTriggerTimeout, null, conditionalUserProperty2.mTimeToLive, zza);
            zzfx().zzd(zzed);
        } catch (IllegalArgumentException unused) {
        }
    }

    @VisibleForTesting
    private final List<AppMeasurement.ConditionalUserProperty> zzf(String str, String str2, String str3) {
        zzfi zzim;
        String str4;
        if (zzgd().zzjk()) {
            zzim = zzge().zzim();
            str4 = "Cannot get conditional user properties from analytics worker thread";
        } else {
            zzgd();
            if (zzgg.isMainThread()) {
                zzim = zzge().zzim();
                str4 = "Cannot get conditional user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zzacw.zzgd().zzc(new zzht(this, atomicReference, str, str2, str3));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzge().zzip().zze("Interrupted waiting for get conditional user properties", str, e);
                    }
                }
                List<zzed> list = (List) atomicReference.get();
                if (list == null) {
                    zzge().zzip().zzg("Timed out waiting for get conditional user properties", str);
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (zzed zzed : list) {
                    AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
                    conditionalUserProperty.mAppId = str;
                    conditionalUserProperty.mOrigin = str2;
                    conditionalUserProperty.mCreationTimestamp = zzed.creationTimestamp;
                    conditionalUserProperty.mName = zzed.zzaep.name;
                    conditionalUserProperty.mValue = zzed.zzaep.getValue();
                    conditionalUserProperty.mActive = zzed.active;
                    conditionalUserProperty.mTriggerEventName = zzed.triggerEventName;
                    if (zzed.zzaeq != null) {
                        conditionalUserProperty.mTimedOutEventName = zzed.zzaeq.name;
                        if (zzed.zzaeq.zzafq != null) {
                            conditionalUserProperty.mTimedOutEventParams = zzed.zzaeq.zzafq.zzif();
                        }
                    }
                    conditionalUserProperty.mTriggerTimeout = zzed.triggerTimeout;
                    if (zzed.zzaer != null) {
                        conditionalUserProperty.mTriggeredEventName = zzed.zzaer.name;
                        if (zzed.zzaer.zzafq != null) {
                            conditionalUserProperty.mTriggeredEventParams = zzed.zzaer.zzafq.zzif();
                        }
                    }
                    conditionalUserProperty.mTriggeredTimestamp = zzed.zzaep.zzaqz;
                    conditionalUserProperty.mTimeToLive = zzed.timeToLive;
                    if (zzed.zzaes != null) {
                        conditionalUserProperty.mExpiredEventName = zzed.zzaes.name;
                        if (zzed.zzaes.zzafq != null) {
                            conditionalUserProperty.mExpiredEventParams = zzed.zzaes.zzafq.zzif();
                        }
                    }
                    arrayList.add(conditionalUserProperty);
                }
                return arrayList;
            }
        }
        zzim.log(str4);
        return Collections.emptyList();
    }

    /* access modifiers changed from: private */
    public final void zzi(boolean z) {
        zzab();
        zzch();
        zzge().zzis().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzgf().setMeasurementEnabled(z);
        if (!zzgg().zzaz(zzfv().zzah())) {
            zzfx().zzke();
        } else if (!this.zzacw.isEnabled() || !this.zzanu) {
            zzfx().zzke();
        } else {
            zzge().zzis().log("Recording app launch after enabling measurement for the first time (FE)");
            zzkb();
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        zza(str, str2, str3, bundle);
    }

    public final Task<String> getAppInstanceId() {
        try {
            String zzja = zzgf().zzja();
            return zzja != null ? Tasks.forResult(zzja) : Tasks.call(zzgd().zzjl(), new zzho(this));
        } catch (Exception e) {
            zzge().zzip().log("Failed to schedule task for getAppInstanceId");
            return Tasks.forException(e);
        }
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return zzf(null, str, str2);
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        return zzf(str, str2, str3);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return zzb(null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        return zzb(str, str2, str3, z);
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, this.zzanq == null || zzka.zzci(str2), false, null);
    }

    public final void registerOnMeasurementEventListener(AppMeasurement.OnEventListener onEventListener) {
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzanr.add(onEventListener)) {
            zzge().zzip().log("OnEventListener already registered");
        }
    }

    public final void resetAnalyticsData() {
        zzgd().zzc(new zzhq(this, zzbt().currentTimeMillis()));
    }

    public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzge().zzip().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mAppId);
        zzfr();
        zza(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
    }

    public final void setEventInterceptor(AppMeasurement.EventInterceptor eventInterceptor) {
        AppMeasurement.EventInterceptor eventInterceptor2;
        zzab();
        zzch();
        if (!(eventInterceptor == null || eventInterceptor == (eventInterceptor2 = this.zzanq))) {
            Preconditions.checkState(eventInterceptor2 == null, "EventInterceptor already set.");
        }
        this.zzanq = eventInterceptor;
    }

    public final void setMeasurementEnabled(boolean z) {
        zzch();
        zzgd().zzc(new zzhz(this, z));
    }

    public final void setMinimumSessionDuration(long j) {
        zzgd().zzc(new zzia(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzgd().zzc(new zzib(this, j));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String
     arg types: [java.lang.String, int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzka.zza(int, java.lang.Object, boolean):java.lang.Object
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String[]):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(com.google.android.gms.internal.measurement.zzko[], java.lang.String, java.lang.Object):com.google.android.gms.internal.measurement.zzko[]
      com.google.android.gms.internal.measurement.zzka.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String */
    public final void setUserProperty(String str, String str2, Object obj) {
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzbt().currentTimeMillis();
        int zzcf = zzgb().zzcf(str2);
        int i = 0;
        if (zzcf != 0) {
            zzgb();
            String zza = zzka.zza(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zzacw.zzgb().zza(zzcf, "_ev", zza, i);
        } else if (obj != null) {
            int zzi = zzgb().zzi(str2, obj);
            if (zzi != 0) {
                zzgb();
                String zza2 = zzka.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzacw.zzgb().zza(zzi, "_ev", zza2, i);
                return;
            }
            Object zzj = zzgb().zzj(str2, obj);
            if (zzj != null) {
                zza(str, str2, currentTimeMillis, zzj);
            }
        } else {
            zza(str, str2, currentTimeMillis, (Object) null);
        }
    }

    public final void unregisterOnMeasurementEventListener(AppMeasurement.OnEventListener onEventListener) {
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzanr.remove(onEventListener)) {
            zzge().zzip().log("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, Bundle bundle) {
        zzab();
        zzb(str, str2, zzbt().currentTimeMillis(), bundle, true, this.zzanq == null || zzka.zzci(str2), false, null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, j, bundle, false, true, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, true, this.zzanq == null || zzka.zzci(str2), true, null);
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        zzge().zzip().log("Interrupted waiting for app instance id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    public final String zzae(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzgd().zzc(new zzhp(this, atomicReference));
            atomicReference.wait(j);
            return (String) atomicReference.get();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbr(String str) {
        this.zzant.set(str);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
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

    public final String zzhm() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzgd().zza(atomicReference, 15000, "String test flag value", new zzhv(this, atomicReference));
    }

    public final List<zzjx> zzj(boolean z) {
        zzfi zzip;
        String str;
        zzch();
        zzge().zzis().log("Fetching user attributes (FE)");
        if (zzgd().zzjk()) {
            zzip = zzge().zzim();
            str = "Cannot get all user properties from analytics worker thread";
        } else {
            zzgd();
            if (zzgg.isMainThread()) {
                zzip = zzge().zzim();
                str = "Cannot get all user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zzacw.zzgd().zzc(new zzhn(this, atomicReference, z));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzge().zzip().zzg("Interrupted waiting for get user properties", e);
                    }
                }
                List<zzjx> list = (List) atomicReference.get();
                if (list != null) {
                    return list;
                }
                zzip = zzge().zzip();
                str = "Timed out waiting for get user properties";
            }
        }
        zzip.log(str);
        return Collections.emptyList();
    }

    public final String zzja() {
        return this.zzant.get();
    }

    public final Boolean zzjx() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzgd().zza(atomicReference, 15000, "boolean test flag value", new zzhl(this, atomicReference));
    }

    public final Long zzjy() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzgd().zza(atomicReference, 15000, "long test flag value", new zzhw(this, atomicReference));
    }

    public final Integer zzjz() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzgd().zza(atomicReference, 15000, "int test flag value", new zzhx(this, atomicReference));
    }

    public final Double zzka() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzgd().zza(atomicReference, 15000, "double test flag value", new zzhy(this, atomicReference));
    }

    public final void zzkb() {
        zzab();
        zzch();
        if (this.zzacw.zzjv()) {
            zzfx().zzkb();
            this.zzanu = false;
            String zzjd = zzgf().zzjd();
            if (!TextUtils.isEmpty(zzjd)) {
                zzfw().zzch();
                if (!zzjd.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzjd);
                    logEvent("auto", "_ou", bundle);
                }
            }
        }
    }
}
