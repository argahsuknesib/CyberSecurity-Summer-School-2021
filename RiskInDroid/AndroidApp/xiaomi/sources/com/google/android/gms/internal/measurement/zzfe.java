package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfe extends zzhh {
    private static final AtomicReference<String[]> zzaij = new AtomicReference<>();
    private static final AtomicReference<String[]> zzaik = new AtomicReference<>();
    private static final AtomicReference<String[]> zzail = new AtomicReference<>();

    zzfe(zzgl zzgl) {
        super(zzgl);
    }

    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzka.zzs(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private final void zza(StringBuilder sb, int i, zzkf zzkf) {
        String str;
        if (zzkf != null) {
            zza(sb, i);
            sb.append("filter {\n");
            zza(sb, i, "complement", zzkf.zzarx);
            zza(sb, i, "param_name", zzbk(zzkf.zzary));
            int i2 = i + 1;
            zzki zzki = zzkf.zzarv;
            if (zzki != null) {
                zza(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzki.zzash != null) {
                    switch (zzki.zzash.intValue()) {
                        case 1:
                            str = "REGEXP";
                            break;
                        case 2:
                            str = "BEGINS_WITH";
                            break;
                        case 3:
                            str = "ENDS_WITH";
                            break;
                        case 4:
                            str = "PARTIAL";
                            break;
                        case 5:
                            str = "EXACT";
                            break;
                        case 6:
                            str = "IN_LIST";
                            break;
                        default:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                    }
                    zza(sb, i2, "match_type", str);
                }
                zza(sb, i2, "expression", zzki.zzasi);
                zza(sb, i2, "case_sensitive", zzki.zzasj);
                if (zzki.zzask.length > 0) {
                    zza(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String append : zzki.zzask) {
                        zza(sb, i2 + 2);
                        sb.append(append);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zza(sb, i2);
                sb.append("}\n");
            }
            zza(sb, i2, "number_filter", zzkf.zzarw);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzkg zzkg) {
        if (zzkg != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzkg.zzarz != null) {
                int intValue = zzkg.zzarz.intValue();
                zza(sb, i, "comparison_type", intValue != 1 ? intValue != 2 ? intValue != 3 ? intValue != 4 ? "UNKNOWN_COMPARISON_TYPE" : "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN");
            }
            zza(sb, i, "match_as_float", zzkg.zzasa);
            zza(sb, i, "comparison_value", zzkg.zzasb);
            zza(sb, i, "min_comparison_value", zzkg.zzasc);
            zza(sb, i, "max_comparison_value", zzkg.zzasd);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzkr zzkr) {
        if (zzkr != null) {
            zza(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            int i2 = 0;
            if (zzkr.zzaul != null) {
                zza(sb, 4);
                sb.append("results: ");
                long[] jArr = zzkr.zzaul;
                int length = jArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf);
                    i3++;
                    i4 = i5;
                }
                sb.append(10);
            }
            if (zzkr.zzauk != null) {
                zza(sb, 4);
                sb.append("status: ");
                long[] jArr2 = zzkr.zzauk;
                int length2 = jArr2.length;
                int i6 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf2);
                    i2++;
                    i6 = i7;
                }
                sb.append(10);
            }
            zza(sb, 3);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private final String zzb(zzer zzer) {
        if (zzer == null) {
            return null;
        }
        return !zzil() ? zzer.toString() : zzb(zzer.zzif());
    }

    private final boolean zzil() {
        return this.zzacw.zzge().isLoggable(3);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzep zzep) {
        if (zzep == null) {
            return null;
        }
        if (!zzil()) {
            return zzep.toString();
        }
        return "Event{appId='" + zzep.zzti + "', name='" + zzbj(zzep.name) + "', params=" + zzb(zzep.zzafq) + "}";
    }

    /* access modifiers changed from: protected */
    public final String zza(zzke zzke) {
        if (zzke == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", zzke.zzarp);
        zza(sb, 0, "event_name", zzbj(zzke.zzarq));
        zza(sb, 1, "event_count_filter", zzke.zzart);
        sb.append("  filters {\n");
        for (zzkf zza : zzke.zzarr) {
            zza(sb, 2, zza);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzkh zzkh) {
        if (zzkh == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", zzkh.zzarp);
        zza(sb, 0, "property_name", zzbl(zzkh.zzasf));
        zza(sb, 1, zzkh.zzasg);
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzkp zzkp) {
        int i;
        zzkq[] zzkqArr;
        int i2;
        zzkq[] zzkqArr2;
        zzfe zzfe = this;
        zzkp zzkp2 = zzkp;
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzkp2.zzatf != null) {
            zzkq[] zzkqArr3 = zzkp2.zzatf;
            int length = zzkqArr3.length;
            int i3 = 0;
            while (i3 < length) {
                zzkq zzkq = zzkqArr3[i3];
                if (zzkq == null || zzkq == null) {
                    zzkqArr = zzkqArr3;
                    i = length;
                } else {
                    zza(sb, 1);
                    sb.append("bundle {\n");
                    zza(sb, 1, "protocol_version", zzkq.zzath);
                    zza(sb, 1, "platform", zzkq.zzatp);
                    zza(sb, 1, "gmp_version", zzkq.zzatt);
                    zza(sb, 1, "uploading_gmp_version", zzkq.zzatu);
                    zza(sb, 1, "config_version", zzkq.zzauf);
                    zza(sb, 1, "gmp_app_id", zzkq.zzadm);
                    zza(sb, 1, "app_id", zzkq.zzti);
                    zza(sb, 1, "app_version", zzkq.zzth);
                    zza(sb, 1, "app_version_major", zzkq.zzaub);
                    zza(sb, 1, "firebase_instance_id", zzkq.zzado);
                    zza(sb, 1, "dev_cert_hash", zzkq.zzatx);
                    zza(sb, 1, "app_store", zzkq.zzadt);
                    zza(sb, 1, "upload_timestamp_millis", zzkq.zzatk);
                    zza(sb, 1, "start_timestamp_millis", zzkq.zzatl);
                    zza(sb, 1, "end_timestamp_millis", zzkq.zzatm);
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", zzkq.zzatn);
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", zzkq.zzato);
                    zza(sb, 1, "app_instance_id", zzkq.zzadl);
                    zza(sb, 1, "resettable_device_id", zzkq.zzatv);
                    zza(sb, 1, "device_id", zzkq.zzaue);
                    zza(sb, 1, "limited_ad_tracking", zzkq.zzatw);
                    zza(sb, 1, "os_version", zzkq.zzatq);
                    zza(sb, 1, "device_model", zzkq.zzatr);
                    zza(sb, 1, "user_default_language", zzkq.zzafn);
                    zza(sb, 1, "time_zone_offset_minutes", zzkq.zzats);
                    zza(sb, 1, "bundle_sequential_index", zzkq.zzaty);
                    zza(sb, 1, "service_upload", zzkq.zzatz);
                    zza(sb, 1, "health_monitor", zzkq.zzaek);
                    if (!(zzkq.zzaug == null || zzkq.zzaug.longValue() == 0)) {
                        zza(sb, 1, "android_id", zzkq.zzaug);
                    }
                    if (zzkq.zzauj != null) {
                        zza(sb, 1, "retry_counter", zzkq.zzauj);
                    }
                    zzks[] zzksArr = zzkq.zzatj;
                    int i4 = 2;
                    if (zzksArr != null) {
                        int length2 = zzksArr.length;
                        int i5 = 0;
                        while (i5 < length2) {
                            zzks zzks = zzksArr[i5];
                            if (zzks != null) {
                                zza(sb, i4);
                                sb.append("user_property {\n");
                                zzkqArr2 = zzkqArr3;
                                i2 = length;
                                zza(sb, 2, "set_timestamp_millis", zzks.zzaun);
                                zza(sb, 2, "name", zzfe.zzbl(zzks.name));
                                zza(sb, 2, "string_value", zzks.zzajf);
                                zza(sb, 2, "int_value", zzks.zzate);
                                zza(sb, 2, "double_value", zzks.zzarc);
                                zza(sb, 2);
                                sb.append("}\n");
                            } else {
                                zzkqArr2 = zzkqArr3;
                                i2 = length;
                            }
                            i5++;
                            zzkqArr3 = zzkqArr2;
                            length = i2;
                            i4 = 2;
                        }
                    }
                    zzkqArr = zzkqArr3;
                    i = length;
                    zzkm[] zzkmArr = zzkq.zzaua;
                    if (zzkmArr != null) {
                        for (zzkm zzkm : zzkmArr) {
                            if (zzkm != null) {
                                zza(sb, 2);
                                sb.append("audience_membership {\n");
                                zza(sb, 2, "audience_id", zzkm.zzarl);
                                zza(sb, 2, "new_audience", zzkm.zzasy);
                                zza(sb, 2, "current_data", zzkm.zzasw);
                                zza(sb, 2, "previous_data", zzkm.zzasx);
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    zzkn[] zzknArr = zzkq.zzati;
                    if (zzknArr != null) {
                        int length3 = zzknArr.length;
                        int i6 = 0;
                        while (i6 < length3) {
                            zzkn zzkn = zzknArr[i6];
                            if (zzkn != null) {
                                zza(sb, 2);
                                sb.append("event {\n");
                                zza(sb, 2, "name", zzfe.zzbj(zzkn.name));
                                zza(sb, 2, "timestamp_millis", zzkn.zzatb);
                                zza(sb, 2, "previous_timestamp_millis", zzkn.zzatc);
                                zza(sb, 2, "count", zzkn.count);
                                zzko[] zzkoArr = zzkn.zzata;
                                if (zzkoArr != null) {
                                    int length4 = zzkoArr.length;
                                    int i7 = 0;
                                    while (i7 < length4) {
                                        zzko zzko = zzkoArr[i7];
                                        if (zzko != null) {
                                            zza(sb, 3);
                                            sb.append("param {\n");
                                            zza(sb, 3, "name", zzfe.zzbk(zzko.name));
                                            zza(sb, 3, "string_value", zzko.zzajf);
                                            zza(sb, 3, "int_value", zzko.zzate);
                                            zza(sb, 3, "double_value", zzko.zzarc);
                                            zza(sb, 3);
                                            sb.append("}\n");
                                        }
                                        i7++;
                                        zzfe = this;
                                    }
                                }
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                            i6++;
                            zzfe = this;
                        }
                    }
                    zza(sb, 1);
                    sb.append("}\n");
                }
                i3++;
                zzfe = this;
                zzkqArr3 = zzkqArr;
                length = i;
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: protected */
    public final String zzb(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzil()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String next : bundle.keySet()) {
            sb.append(sb.length() != 0 ? ", " : "Bundle[{");
            sb.append(zzbk(next));
            sb.append("=");
            sb.append(bundle.get(next));
        }
        sb.append("}]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String zzb(zzeu zzeu) {
        if (zzeu == null) {
            return null;
        }
        if (!zzil()) {
            return zzeu.toString();
        }
        return "origin=" + zzeu.origin + ",name=" + zzbj(zzeu.name) + ",params=" + zzb(zzeu.zzafq);
    }

    /* access modifiers changed from: protected */
    public final String zzbj(String str) {
        if (str == null) {
            return null;
        }
        return !zzil() ? str : zza(str, AppMeasurement.Event.zzacy, AppMeasurement.Event.zzacx, zzaij);
    }

    /* access modifiers changed from: protected */
    public final String zzbk(String str) {
        if (str == null) {
            return null;
        }
        return !zzil() ? str : zza(str, AppMeasurement.Param.zzada, AppMeasurement.Param.zzacz, zzaik);
    }

    /* access modifiers changed from: protected */
    public final String zzbl(String str) {
        if (str == null) {
            return null;
        }
        if (!zzil()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, AppMeasurement.UserProperty.zzadc, AppMeasurement.UserProperty.zzadb, zzail);
        }
        return "experiment_id" + "(" + str + ")";
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
}
