package com.amap.openapi;

import _m_j.ok;
import _m_j.pe;
import _m_j.su;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.amap.location.uptunnel.core.db.DBProvider;
import java.util.Calendar;

public class dt {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f3561O000000o;
    private DBProvider O00000Oo;
    private Calendar O00000o;
    private SharedPreferences O00000o0;

    public dt(Context context) {
        this.f3561O000000o = context;
        try {
            this.O00000o = Calendar.getInstance();
            this.O00000o0 = context.getSharedPreferences(ok.O00000oO() + "_tunnel", 0);
            this.O00000Oo = DBProvider.O000000o(context);
        } catch (Throwable unused) {
        }
    }

    public static Uri O00000Oo(int i) {
        String str;
        if (i == 1) {
            str = "count";
        } else if (i == 2) {
            str = "event";
        } else if (i == 3) {
            str = "key_log";
        } else if (i == 4) {
            str = "log";
        } else if (i != 5) {
            return null;
        } else {
            str = "data_block";
        }
        return DBProvider.O000000o(str);
    }

    public static String O00000o0(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "data_block" : "log" : "key_log" : "event" : "count";
    }

    public final synchronized long O000000o(int i, int i2) {
        int i3 = this.O00000o0.getInt("last_upload_day_".concat(String.valueOf(i)), -1);
        this.O00000o.setTimeInMillis(System.currentTimeMillis());
        int i4 = this.O00000o.get(6);
        if (i4 != i3) {
            SharedPreferences.Editor edit = this.O00000o0.edit();
            edit.putInt("last_upload_day_".concat(String.valueOf(i)), i4);
            edit.putLong("uploaded_size_" + i + "_" + i2, 0);
            StringBuilder sb = new StringBuilder("uploaded_size_");
            sb.append(i);
            sb.append("_");
            sb.append(i2 == 0 ? 1 : 0);
            edit.putLong(sb.toString(), 0);
            edit.apply();
            return 0;
        }
        SharedPreferences sharedPreferences = this.O00000o0;
        return sharedPreferences.getLong("uploaded_size_" + i + "_" + i2, 0);
    }

    public final synchronized long O000000o(int i, int i2, long j) {
        int i3 = this.O00000o0.getInt("last_upload_day_".concat(String.valueOf(i)), -1);
        this.O00000o.setTimeInMillis(System.currentTimeMillis());
        int i4 = this.O00000o.get(6);
        if (i4 != i3) {
            SharedPreferences.Editor edit = this.O00000o0.edit();
            edit.putInt("last_upload_day_".concat(String.valueOf(i)), i4);
            edit.putLong("uploaded_size_" + i + "_" + i2, j);
            StringBuilder sb = new StringBuilder("uploaded_size_");
            sb.append(i);
            sb.append("_");
            sb.append(i2 == 0 ? 1 : 0);
            edit.putLong(sb.toString(), 0);
            edit.apply();
            return j;
        }
        SharedPreferences sharedPreferences = this.O00000o0;
        long j2 = sharedPreferences.getLong("uploaded_size_" + i + "_" + i2, 0);
        SharedPreferences.Editor edit2 = this.O00000o0.edit();
        long j3 = j2 + j;
        edit2.putLong("uploaded_size_" + i + "_" + i2, j3).apply();
        return j3;
    }

    public final synchronized Context O000000o() {
        return this.f3561O000000o;
    }

    public final synchronized String O000000o(int i) {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(su.f2482O000000o ? "http://aps.testing.amap.com/dataPipeline/uploadData" : "http://cgicol.amap.com/dataPipeline/uploadData");
        sb.append("?");
        sb.append("channel=");
        sb.append(i == 1 ? "statistics" : "report");
        sb.append("&version=v1");
        return sb.toString();
    }

    public final synchronized DBProvider O00000Oo() {
        return this.O00000Oo;
    }

    public final synchronized int O00000o0() {
        return pe.O000000o(this.f3561O000000o);
    }
}
