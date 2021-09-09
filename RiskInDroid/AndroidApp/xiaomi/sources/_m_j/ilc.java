package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.statistic.RecordModel;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class ilc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static byte[] f1433O000000o = new byte[0];
    private static volatile ilc O0000o;
    public ila O00000Oo;
    public RecordModel O00000o = null;
    public ijr O00000o0 = new ijr();
    public boolean O00000oO = false;
    public boolean O00000oo;
    public Context O0000O0o;
    public String O0000OOo;
    public Map<String, String> O0000Oo;
    public String O0000Oo0;
    public int O0000OoO = 0;
    public long O0000Ooo;
    public boolean O0000o0;
    public long O0000o00;
    public int O0000o0O;
    public long O0000o0o;
    private long O0000oO0 = 0;

    private ilc() {
        XmPlayerControl.O0000o0O = 0;
    }

    public static ilc O000000o() {
        if (O0000o == null) {
            synchronized (f1433O000000o) {
                if (O0000o == null) {
                    O0000o = new ilc();
                }
            }
        }
        return O0000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f8 A[SYNTHETIC, Splitter:B:40:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e1  */
    public final void O000000o(Track track, int i) {
        ijr ijr;
        long j;
        long j2;
        SharedPreferences sharedPreferences;
        ijr ijr2;
        int i2;
        RecordModel recordModel;
        Track track2 = track;
        int i3 = i;
        if (track2 != null && (ijr = this.O00000o0) != null && this.O00000oO) {
            this.O00000oO = false;
            if (ijr instanceof ijr) {
                if (ijr.O00000o) {
                    this.O00000o0.O00000Oo((long) i3);
                    j2 = 0;
                    j = 0;
                } else {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy:MM:dd:HH:mm", Locale.getDefault());
                    if (TextUtils.isEmpty(track2.O00oOooO) || TextUtils.isEmpty(track2.O00oOooo)) {
                        this.O00000o0.O00000Oo(0);
                        j2 = 0;
                        j = 0;
                    } else {
                        try {
                            j2 = simpleDateFormat.parse(track2.O00oOooO).getTime();
                            try {
                                j = System.currentTimeMillis();
                                try {
                                    this.O00000o0.O00000Oo(simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis()))).getTime() - j2);
                                } catch (ParseException unused) {
                                }
                            } catch (ParseException unused2) {
                                j = 0;
                                this.O00000o0.O00000Oo(0);
                                this.O00000o0.O0000ooO = track2.O000O0OO;
                                this.O00000o0.O0000oo = track2.O000O00o;
                                int i4 = (int) XmPlayerControl.O0000o0O;
                                long j3 = (long) i4;
                                this.O0000oO0 += j3;
                                sharedPreferences = this.O0000O0o.getSharedPreferences("total_play_sec", 4);
                                long j4 = sharedPreferences.getLong("listenedTimeBeforeAppraised", 0) * 1000;
                                StringBuilder sb = new StringBuilder();
                                sb.append(j4);
                                sb.append("    ");
                                long j5 = j2;
                                sb.append(this.O0000oO0);
                                ilk.O00000Oo("fjsdoifj", sb.toString());
                                sharedPreferences.edit().putBoolean("is_time_to_appraised", true).apply();
                                this.O00000o0.O000000o(j3);
                                this.O00000o0.O0000o = System.currentTimeMillis();
                                if (j == 0) {
                                }
                                ijr2 = this.O00000o0;
                                ijr2.O0000o0 = j;
                                if (!ijr2.O00000o) {
                                }
                                i2 = 0;
                                this.O00000o0.O0000o0o = (((long) i2) * track2.O0000oOo) / 1000;
                                ilk.O000000o((Object) ("Test statistic track onStopTrack old" + this.O00000o0.O00000Oo));
                                if (!TextUtils.isEmpty(track2.O000Oo00)) {
                                }
                                this.O00000o0.O0000o0O = track2.O0000ooO;
                                recordModel = this.O00000o;
                                if (recordModel != null) {
                                }
                                this.O00000o0.O0000oO0 = 0;
                                if (this.O00000Oo == null) {
                                }
                                ilk.O00000Oo("StatisticsManager", "stop:position=" + i3 + "durtion=" + this.O00000o0.O0000Oo);
                                if (TextUtils.isEmpty(this.O0000Oo0)) {
                                }
                                ijr ijr3 = this.O00000o0;
                                ijr3.O0000ooo = this.O0000o0O;
                                ijr3.O00oOooO = this.O0000o0o;
                                ijr3.O00oOooo = this.O0000Oo0;
                                ijr3.O0000Ooo = i3;
                                O00000o0();
                                this.O00000Oo.O000000o(this.O00000o0);
                                O00000Oo();
                                XmPlayerControl.O0000o0O = 0;
                            }
                        } catch (ParseException unused3) {
                            j2 = 0;
                            j = 0;
                            this.O00000o0.O00000Oo(0);
                            this.O00000o0.O0000ooO = track2.O000O0OO;
                            this.O00000o0.O0000oo = track2.O000O00o;
                            int i42 = (int) XmPlayerControl.O0000o0O;
                            long j32 = (long) i42;
                            this.O0000oO0 += j32;
                            sharedPreferences = this.O0000O0o.getSharedPreferences("total_play_sec", 4);
                            long j42 = sharedPreferences.getLong("listenedTimeBeforeAppraised", 0) * 1000;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(j42);
                            sb2.append("    ");
                            long j52 = j2;
                            sb2.append(this.O0000oO0);
                            ilk.O00000Oo("fjsdoifj", sb2.toString());
                            sharedPreferences.edit().putBoolean("is_time_to_appraised", true).apply();
                            this.O00000o0.O000000o(j32);
                            this.O00000o0.O0000o = System.currentTimeMillis();
                            if (j == 0) {
                            }
                            ijr2 = this.O00000o0;
                            ijr2.O0000o0 = j;
                            if (!ijr2.O00000o) {
                            }
                            i2 = 0;
                            this.O00000o0.O0000o0o = (((long) i2) * track2.O0000oOo) / 1000;
                            ilk.O000000o((Object) ("Test statistic track onStopTrack old" + this.O00000o0.O00000Oo));
                            if (!TextUtils.isEmpty(track2.O000Oo00)) {
                            }
                            this.O00000o0.O0000o0O = track2.O0000ooO;
                            recordModel = this.O00000o;
                            if (recordModel != null) {
                            }
                            this.O00000o0.O0000oO0 = 0;
                            if (this.O00000Oo == null) {
                            }
                            ilk.O00000Oo("StatisticsManager", "stop:position=" + i3 + "durtion=" + this.O00000o0.O0000Oo);
                            if (TextUtils.isEmpty(this.O0000Oo0)) {
                            }
                            ijr ijr32 = this.O00000o0;
                            ijr32.O0000ooo = this.O0000o0O;
                            ijr32.O00oOooO = this.O0000o0o;
                            ijr32.O00oOooo = this.O0000Oo0;
                            ijr32.O0000Ooo = i3;
                            O00000o0();
                            this.O00000Oo.O000000o(this.O00000o0);
                            O00000Oo();
                            XmPlayerControl.O0000o0O = 0;
                        }
                    }
                    this.O00000o0.O0000ooO = track2.O000O0OO;
                    this.O00000o0.O0000oo = track2.O000O00o;
                }
                int i422 = (int) XmPlayerControl.O0000o0O;
                long j322 = (long) i422;
                this.O0000oO0 += j322;
                sharedPreferences = this.O0000O0o.getSharedPreferences("total_play_sec", 4);
                long j422 = sharedPreferences.getLong("listenedTimeBeforeAppraised", 0) * 1000;
                StringBuilder sb22 = new StringBuilder();
                sb22.append(j422);
                sb22.append("    ");
                long j522 = j2;
                sb22.append(this.O0000oO0);
                ilk.O00000Oo("fjsdoifj", sb22.toString());
                if (this.O0000oO0 > j422 && this.O0000O0o != null && !sharedPreferences.getBoolean("is_time_to_appraised", false)) {
                    sharedPreferences.edit().putBoolean("is_time_to_appraised", true).apply();
                }
                this.O00000o0.O000000o(j322);
                this.O00000o0.O0000o = System.currentTimeMillis();
                if (j == 0) {
                    try {
                        j = new SimpleDateFormat("yy:MM:dd:HH:mm", Locale.getDefault()).parse(track2.O00oOooo).getTime();
                    } catch (Exception unused4) {
                        j = System.currentTimeMillis();
                    }
                }
                ijr2 = this.O00000o0;
                ijr2.O0000o0 = j;
                if (!ijr2.O00000o) {
                    long j6 = j - j522;
                    if (j6 != 0) {
                        i2 = (int) (j322 / j6);
                        this.O00000o0.O0000o0o = (((long) i2) * track2.O0000oOo) / 1000;
                        ilk.O000000o((Object) ("Test statistic track onStopTrack old" + this.O00000o0.O00000Oo));
                        if (!TextUtils.isEmpty(track2.O000Oo00)) {
                        }
                        this.O00000o0.O0000o0O = track2.O0000ooO;
                        recordModel = this.O00000o;
                        if (recordModel != null) {
                        }
                        this.O00000o0.O0000oO0 = 0;
                        if (this.O00000Oo == null) {
                        }
                        ilk.O00000Oo("StatisticsManager", "stop:position=" + i3 + "durtion=" + this.O00000o0.O0000Oo);
                        if (TextUtils.isEmpty(this.O0000Oo0)) {
                        }
                        ijr ijr322 = this.O00000o0;
                        ijr322.O0000ooo = this.O0000o0O;
                        ijr322.O00oOooO = this.O0000o0o;
                        ijr322.O00oOooo = this.O0000Oo0;
                        ijr322.O0000Ooo = i3;
                        O00000o0();
                        this.O00000Oo.O000000o(this.O00000o0);
                        O00000Oo();
                        XmPlayerControl.O0000o0O = 0;
                    }
                } else if (track2.O0000o0 != 0) {
                    i2 = i422 / track2.O0000o0;
                    this.O00000o0.O0000o0o = (((long) i2) * track2.O0000oOo) / 1000;
                    ilk.O000000o((Object) ("Test statistic track onStopTrack old" + this.O00000o0.O00000Oo));
                    if (!TextUtils.isEmpty(track2.O000Oo00)) {
                        this.O00000o0.O00000Oo = track2.O000Oo00;
                        this.O00000o0.O00000o0 = track2.O000Oo0;
                    } else if (track2.O0000oo != null) {
                        this.O00000o0.O00000Oo = track2.O0000oo.O00000oo;
                        this.O00000o0.O00000o0 = track2.O0000oo.O0000O0o;
                        ilk.O000000o((Object) ("Test statistic track onStopTrack new" + track2.O0000oo.O00000oo));
                    }
                    this.O00000o0.O0000o0O = track2.O0000ooO;
                    recordModel = this.O00000o;
                    if (recordModel != null) {
                        this.O00000o0.O0000oOO = recordModel.f12178O000000o;
                        this.O00000o0.O0000oOo = this.O00000o.O00000Oo;
                        this.O00000o0.O0000oo0 = this.O00000o.O00000o0;
                    }
                    this.O00000o0.O0000oO0 = 0;
                    if (this.O00000Oo == null) {
                        this.O00000Oo = ilb.O000000o();
                    }
                    ilk.O00000Oo("StatisticsManager", "stop:position=" + i3 + "durtion=" + this.O00000o0.O0000Oo);
                    if (TextUtils.isEmpty(this.O0000Oo0)) {
                        this.O0000Oo0 = this.O0000OOo;
                    }
                    ijr ijr3222 = this.O00000o0;
                    ijr3222.O0000ooo = this.O0000o0O;
                    ijr3222.O00oOooO = this.O0000o0o;
                    ijr3222.O00oOooo = this.O0000Oo0;
                    ijr3222.O0000Ooo = i3;
                    O00000o0();
                    this.O00000Oo.O000000o(this.O00000o0);
                    O00000Oo();
                    XmPlayerControl.O0000o0O = 0;
                }
                i2 = 0;
                this.O00000o0.O0000o0o = (((long) i2) * track2.O0000oOo) / 1000;
                ilk.O000000o((Object) ("Test statistic track onStopTrack old" + this.O00000o0.O00000Oo));
                if (!TextUtils.isEmpty(track2.O000Oo00)) {
                }
                this.O00000o0.O0000o0O = track2.O0000ooO;
                recordModel = this.O00000o;
                if (recordModel != null) {
                }
                this.O00000o0.O0000oO0 = 0;
                if (this.O00000Oo == null) {
                }
                ilk.O00000Oo("StatisticsManager", "stop:position=" + i3 + "durtion=" + this.O00000o0.O0000Oo);
                if (TextUtils.isEmpty(this.O0000Oo0)) {
                }
                ijr ijr32222 = this.O00000o0;
                ijr32222.O0000ooo = this.O0000o0O;
                ijr32222.O00oOooO = this.O0000o0o;
                ijr32222.O00oOooo = this.O0000Oo0;
                ijr32222.O0000Ooo = i3;
                O00000o0();
                this.O00000Oo.O000000o(this.O00000o0);
                O00000Oo();
                XmPlayerControl.O0000o0O = 0;
            }
        }
    }

    private void O00000Oo() {
        if (!TextUtils.equals(this.O0000OOo, this.O0000Oo0) && !TextUtils.isEmpty(this.O0000OOo)) {
            this.O0000Oo0 = this.O0000OOo;
        }
    }

    private void O00000o0() {
        Map<String, String> map = this.O0000Oo;
        if (map != null && this.O00000o0 != null && map.containsKey("tid")) {
            this.O00000o0.O000O00o = this.O0000Oo.get("tid");
        }
    }

    public static boolean O000000o(Track track) {
        if (track != null) {
            return "track".equals(track.O00000Oo) || "tts".equals(track.O00000Oo);
        }
        return false;
    }

    public static boolean O00000Oo(Track track) {
        return track != null && "schedule".equals(track.O00000Oo);
    }

    public static boolean O00000o0(Track track) {
        return track != null && "radio".equals(track.O00000Oo) && track.O0000OOo;
    }
}
