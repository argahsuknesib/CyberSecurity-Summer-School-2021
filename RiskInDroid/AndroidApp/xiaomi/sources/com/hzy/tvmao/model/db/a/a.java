package com.hzy.tvmao.model.db.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.hzy.tvmao.model.db.bean.ChannelInfo;
import com.kookong.app.data.api.LineupData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a {
    private static a b;

    /* renamed from: a  reason: collision with root package name */
    private SQLiteDatabase f4427a = com.hzy.tvmao.model.db.a.a().b();

    private a() {
    }

    public static final a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public synchronized void a(int i, int i2, List<LineupData.Chnnum> list) {
        ArrayList arrayList = new ArrayList();
        for (LineupData.Chnnum next : list) {
            ChannelInfo channelInfo = new ChannelInfo();
            channelInfo.channelId = next.cid;
            channelInfo.name = next.name;
            channelInfo.num = next.num;
            channelInfo.countryId = next.ctrid;
            channelInfo.isHd = next.hd;
            channelInfo.ishidden = next.hidden;
            channelInfo.linupId = i2;
            channelInfo.logo = next.logo;
            channelInfo.llogo = next.llogo;
            channelInfo.sequence = 0;
            channelInfo.type = next.type;
            channelInfo.fee = next.fee;
            channelInfo.pulse = next.pulse;
            arrayList.add(channelInfo);
        }
        a(i, arrayList);
    }

    public void a(int i, List<ChannelInfo> list) {
        this.f4427a.beginTransaction();
        try {
            this.f4427a.execSQL("delete from lineup where device_id=?", new String[]{String.valueOf(i)});
            for (ChannelInfo next : list) {
                next.encrypt();
                ContentValues contentValues = new ContentValues();
                contentValues.put("device_id", Integer.valueOf(i));
                contentValues.put("lineup_id", Integer.valueOf(next.linupId));
                contentValues.put("sequence", Integer.valueOf(next.sequence));
                contentValues.put("channel_id", Integer.valueOf(next.channelId));
                contentValues.put("country_id", next.countryId);
                contentValues.put("pulse", next.pulse);
                contentValues.put("hd", Short.valueOf(next.isHd));
                contentValues.put("hidden", Integer.valueOf(next.ishidden));
                contentValues.put("type", Short.valueOf(next.type));
                contentValues.put("enc_name", next.encname);
                contentValues.put("enc_num", next.encnum);
                contentValues.put("fee", Short.valueOf(next.fee));
                contentValues.put("logo", next.logo);
                contentValues.put("llogo", next.llogo);
                this.f4427a.insert("lineup", null, contentValues);
            }
            this.f4427a.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f4427a.endTransaction();
            throw th;
        }
        this.f4427a.endTransaction();
    }

    public HashMap<ChannelInfo.a, ChannelInfo> a(int i) {
        List<ChannelInfo> b2 = b(i);
        if (b2 == null) {
            return null;
        }
        HashMap<ChannelInfo.a, ChannelInfo> hashMap = new HashMap<>();
        for (int i2 = 0; i2 < b2.size(); i2++) {
            ChannelInfo channelInfo = b2.get(i2);
            hashMap.put(channelInfo.getKey(), channelInfo);
        }
        return hashMap;
    }

    public List<ChannelInfo> b(int i) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = this.f4427a.rawQuery("select * from lineup where device_id=?", new String[]{String.valueOf(i)});
            while (rawQuery != null && rawQuery.moveToNext()) {
                ChannelInfo channelInfo = new ChannelInfo();
                channelInfo.deviceId = rawQuery.getInt(rawQuery.getColumnIndex("device_id"));
                channelInfo.fee = rawQuery.getShort(rawQuery.getColumnIndex("fee"));
                channelInfo.channelId = rawQuery.getInt(rawQuery.getColumnIndex("channel_id"));
                channelInfo.countryId = rawQuery.getString(rawQuery.getColumnIndex("country_id"));
                channelInfo.pulse = rawQuery.getString(rawQuery.getColumnIndex("pulse"));
                channelInfo.encname = rawQuery.getBlob(rawQuery.getColumnIndex("enc_name"));
                channelInfo.logo = rawQuery.getString(rawQuery.getColumnIndex("logo"));
                channelInfo.llogo = rawQuery.getString(rawQuery.getColumnIndex("llogo"));
                channelInfo.ishidden = rawQuery.getInt(rawQuery.getColumnIndex("hidden"));
                channelInfo.isHd = rawQuery.getShort(rawQuery.getColumnIndex("hd"));
                channelInfo.linupId = rawQuery.getInt(rawQuery.getColumnIndex("lineup_id"));
                channelInfo.encnum = rawQuery.getBlob(rawQuery.getColumnIndex("enc_num"));
                channelInfo.decrypt();
                arrayList.add(channelInfo);
            }
            if (rawQuery != null) {
                com.hzy.tvmao.model.db.a.a().a(rawQuery);
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (0 != 0) {
                com.hzy.tvmao.model.db.a.a().a(null);
            }
            return arrayList;
        } catch (Throwable th) {
            if (0 != 0) {
                com.hzy.tvmao.model.db.a.a().a(null);
            }
            throw th;
        }
    }

    public List<ChannelInfo> c(int i) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = this.f4427a.rawQuery("select device_id,channel_id,country_id,hd from lineup where device_id=?", new String[]{String.valueOf(i)});
            while (rawQuery != null && rawQuery.moveToNext()) {
                ChannelInfo channelInfo = new ChannelInfo();
                channelInfo.deviceId = rawQuery.getInt(rawQuery.getColumnIndex("device_id"));
                channelInfo.channelId = rawQuery.getInt(rawQuery.getColumnIndex("channel_id"));
                channelInfo.countryId = rawQuery.getString(rawQuery.getColumnIndex("country_id"));
                channelInfo.isHd = rawQuery.getShort(rawQuery.getColumnIndex("hd"));
                arrayList.add(channelInfo);
            }
            if (rawQuery != null) {
                com.hzy.tvmao.model.db.a.a().a(rawQuery);
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (0 != 0) {
                com.hzy.tvmao.model.db.a.a().a(null);
            }
            return arrayList;
        } catch (Throwable th) {
            if (0 != 0) {
                com.hzy.tvmao.model.db.a.a().a(null);
            }
            throw th;
        }
    }
}
