package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

final class zzdy {
    private final zzgl zzacw;
    private String zzadl;
    private String zzadm;
    private String zzadn;
    private String zzado;
    private long zzadp;
    private long zzadq;
    private long zzadr;
    private long zzads;
    private String zzadt;
    private long zzadu;
    private long zzadv;
    private boolean zzadw;
    private long zzadx;
    private boolean zzady;
    private boolean zzadz;
    private long zzaea;
    private long zzaeb;
    private long zzaec;
    private long zzaed;
    private long zzaee;
    private long zzaef;
    private String zzaeg;
    private boolean zzaeh;
    private long zzaei;
    private long zzaej;
    private String zzth;
    private final String zzti;

    zzdy(zzgl zzgl, String str) {
        Preconditions.checkNotNull(zzgl);
        Preconditions.checkNotEmpty(str);
        this.zzacw = zzgl;
        this.zzti = str;
        this.zzacw.zzab();
    }

    public final String getAppInstanceId() {
        this.zzacw.zzab();
        return this.zzadl;
    }

    public final String getGmpAppId() {
        this.zzacw.zzab();
        return this.zzadm;
    }

    public final boolean isMeasurementEnabled() {
        this.zzacw.zzab();
        return this.zzadw;
    }

    public final void setAppVersion(String str) {
        this.zzacw.zzab();
        this.zzaeh |= !zzka.zzs(this.zzth, str);
        this.zzth = str;
    }

    public final void setMeasurementEnabled(boolean z) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzadw != z;
        this.zzadw = z;
    }

    public final void zzaa(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzadx != j;
        this.zzadx = j;
    }

    public final String zzag() {
        this.zzacw.zzab();
        return this.zzth;
    }

    public final String zzah() {
        this.zzacw.zzab();
        return this.zzti;
    }

    public final void zzal(String str) {
        this.zzacw.zzab();
        this.zzaeh |= !zzka.zzs(this.zzadl, str);
        this.zzadl = str;
    }

    public final void zzam(String str) {
        this.zzacw.zzab();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzaeh |= !zzka.zzs(this.zzadm, str);
        this.zzadm = str;
    }

    public final void zzan(String str) {
        this.zzacw.zzab();
        this.zzaeh |= !zzka.zzs(this.zzadn, str);
        this.zzadn = str;
    }

    public final void zzao(String str) {
        this.zzacw.zzab();
        this.zzaeh |= !zzka.zzs(this.zzado, str);
        this.zzado = str;
    }

    public final void zzap(String str) {
        this.zzacw.zzab();
        this.zzaeh |= !zzka.zzs(this.zzadt, str);
        this.zzadt = str;
    }

    public final void zzaq(String str) {
        this.zzacw.zzab();
        this.zzaeh |= !zzka.zzs(this.zzaeg, str);
        this.zzaeg = str;
    }

    public final void zzd(boolean z) {
        this.zzacw.zzab();
        this.zzaeh = this.zzady != z;
        this.zzady = z;
    }

    public final void zze(boolean z) {
        this.zzacw.zzab();
        this.zzaeh = this.zzadz != z;
        this.zzadz = z;
    }

    public final void zzgh() {
        this.zzacw.zzab();
        this.zzaeh = false;
    }

    public final String zzgi() {
        this.zzacw.zzab();
        return this.zzadn;
    }

    public final String zzgj() {
        this.zzacw.zzab();
        return this.zzado;
    }

    public final long zzgk() {
        this.zzacw.zzab();
        return this.zzadq;
    }

    public final long zzgl() {
        this.zzacw.zzab();
        return this.zzadr;
    }

    public final long zzgm() {
        this.zzacw.zzab();
        return this.zzads;
    }

    public final String zzgn() {
        this.zzacw.zzab();
        return this.zzadt;
    }

    public final long zzgo() {
        this.zzacw.zzab();
        return this.zzadu;
    }

    public final long zzgp() {
        this.zzacw.zzab();
        return this.zzadv;
    }

    public final long zzgq() {
        this.zzacw.zzab();
        return this.zzadp;
    }

    public final long zzgr() {
        this.zzacw.zzab();
        return this.zzaei;
    }

    public final long zzgs() {
        this.zzacw.zzab();
        return this.zzaej;
    }

    public final void zzgt() {
        this.zzacw.zzab();
        long j = this.zzadp + 1;
        if (j > 2147483647L) {
            this.zzacw.zzge().zzip().zzg("Bundle index overflow. appId", zzfg.zzbm(this.zzti));
            j = 0;
        }
        this.zzaeh = true;
        this.zzadp = j;
    }

    public final long zzgu() {
        this.zzacw.zzab();
        return this.zzaea;
    }

    public final long zzgv() {
        this.zzacw.zzab();
        return this.zzaeb;
    }

    public final long zzgw() {
        this.zzacw.zzab();
        return this.zzaec;
    }

    public final long zzgx() {
        this.zzacw.zzab();
        return this.zzaed;
    }

    public final long zzgy() {
        this.zzacw.zzab();
        return this.zzaef;
    }

    public final long zzgz() {
        this.zzacw.zzab();
        return this.zzaee;
    }

    public final String zzha() {
        this.zzacw.zzab();
        return this.zzaeg;
    }

    public final String zzhb() {
        this.zzacw.zzab();
        String str = this.zzaeg;
        zzaq(null);
        return str;
    }

    public final long zzhc() {
        this.zzacw.zzab();
        return this.zzadx;
    }

    public final boolean zzhd() {
        this.zzacw.zzab();
        return this.zzady;
    }

    public final boolean zzhe() {
        this.zzacw.zzab();
        return this.zzadz;
    }

    public final void zzm(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzadq != j;
        this.zzadq = j;
    }

    public final void zzn(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzadr != j;
        this.zzadr = j;
    }

    public final void zzo(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzads != j;
        this.zzads = j;
    }

    public final void zzp(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzadu != j;
        this.zzadu = j;
    }

    public final void zzq(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzadv != j;
        this.zzadv = j;
    }

    public final void zzr(long j) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        this.zzacw.zzab();
        boolean z2 = this.zzaeh;
        if (this.zzadp == j) {
            z = false;
        }
        this.zzaeh = z | z2;
        this.zzadp = j;
    }

    public final void zzs(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzaei != j;
        this.zzaei = j;
    }

    public final void zzt(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzaej != j;
        this.zzaej = j;
    }

    public final void zzu(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzaea != j;
        this.zzaea = j;
    }

    public final void zzv(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzaeb != j;
        this.zzaeb = j;
    }

    public final void zzw(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzaec != j;
        this.zzaec = j;
    }

    public final void zzx(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzaed != j;
        this.zzaed = j;
    }

    public final void zzy(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzaef != j;
        this.zzaef = j;
    }

    public final void zzz(long j) {
        this.zzacw.zzab();
        this.zzaeh |= this.zzaee != j;
        this.zzaee = j;
    }
}
