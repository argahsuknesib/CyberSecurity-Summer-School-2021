package com.xiaomi.smarthome.device;

import _m_j.gsy;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MitvDeviceRecommendManager {
    private static volatile MitvDeviceRecommendManager O0000O0o;
    private static Object O0000OOo = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    volatile boolean f6979O000000o = false;
    Handler O00000Oo = new Handler(Looper.getMainLooper());
    HashMap<String, O000000o> O00000o = new HashMap<>();
    HashMap<String, O000000o> O00000o0 = new HashMap<>();
    long O00000oO = 0;
    String O00000oo;

    private MitvDeviceRecommendManager() {
        new Thread() {
            /* class com.xiaomi.smarthome.device.MitvDeviceRecommendManager.AnonymousClass1 */

            public final void run() {
                super.run();
                MitvDeviceRecommendManager.this.f6979O000000o = true;
                try {
                    gsy.O000000o(3, "MitvDeviceRecommend", "initial");
                    DataInputStream dataInputStream = new DataInputStream(CommonApplication.getAppContext().openFileInput("mitv_recommend"));
                    Date date = new Date();
                    if (date.getTime() - dataInputStream.readLong() > 86400000) {
                        dataInputStream.close();
                        CommonApplication.getAppContext().deleteFile("mitv_recommend");
                        return;
                    }
                    int readInt = dataInputStream.readInt();
                    if (readInt <= 0) {
                        dataInputStream.close();
                        return;
                    }
                    byte[] bArr = new byte[readInt];
                    dataInputStream.read(bArr);
                    dataInputStream.close();
                    MitvDeviceRecommendManager.this.O000000o(new JSONObject(new String(bArr, "UTF-8")));
                    MitvDeviceRecommendManager.this.f6979O000000o = false;
                } catch (Exception unused) {
                    CommonApplication.getAppContext().deleteFile("mitv_recommend");
                }
            }
        }.start();
    }

    public static MitvDeviceRecommendManager O000000o() {
        if (O0000O0o == null) {
            synchronized (O0000OOo) {
                if (O0000O0o == null) {
                    O0000O0o = new MitvDeviceRecommendManager();
                }
            }
        }
        return O0000O0o;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f6984O000000o;
        public String O00000Oo;
        public ArrayList<MiTVRecommendItem> O00000o0;

        public static O000000o O000000o(String str, JSONObject jSONObject) {
            try {
                O000000o o000000o = new O000000o();
                Iterator<String> keys = jSONObject.keys();
                if (keys.hasNext()) {
                    o000000o.f6984O000000o = str;
                    o000000o.O00000Oo = keys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(o000000o.O00000Oo);
                    o000000o.O00000o0 = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        o000000o.O00000o0.add(MiTVRecommendItem.O000000o(jSONArray.getJSONObject(i)));
                    }
                }
                return o000000o;
            } catch (JSONException unused) {
                return null;
            }
        }
    }

    public static class MiTVRecommendItem implements Parcelable {
        public static final Parcelable.Creator<MiTVRecommendItem> CREATOR = new Parcelable.Creator<MiTVRecommendItem>() {
            /* class com.xiaomi.smarthome.device.MitvDeviceRecommendManager.MiTVRecommendItem.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MiTVRecommendItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new MiTVRecommendItem(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public String f6983O000000o;
        public int O00000Oo;
        public int O00000o;
        public String[] O00000o0;
        public String O00000oO;

        public int describeContents() {
            return 0;
        }

        public MiTVRecommendItem() {
        }

        public MiTVRecommendItem(Parcel parcel) {
            this.f6983O000000o = parcel.readString();
            this.O00000Oo = parcel.readInt();
            this.O00000o = parcel.readInt();
            this.O00000oO = parcel.readString();
        }

        public static MiTVRecommendItem O000000o(JSONObject jSONObject) throws JSONException {
            MiTVRecommendItem miTVRecommendItem = new MiTVRecommendItem();
            miTVRecommendItem.O00000Oo = jSONObject.getInt("id");
            miTVRecommendItem.O00000o = jSONObject.getInt("type");
            miTVRecommendItem.f6983O000000o = jSONObject.getString("poster");
            miTVRecommendItem.O00000oO = jSONObject.getString("name");
            JSONArray jSONArray = jSONObject.getJSONArray("from");
            miTVRecommendItem.O00000o0 = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                miTVRecommendItem.O00000o0[i] = jSONArray.getString(i);
            }
            return miTVRecommendItem;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f6983O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o);
            parcel.writeString(this.O00000oO);
        }
    }

    public final void O000000o(JSONObject jSONObject) {
        if (jSONObject != null) {
            gsy.O000000o(3, "MitvDeviceRecommend", "updateRecommend:" + jSONObject.toString());
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        O000000o O000000o2 = O000000o.O000000o(next, jSONArray.getJSONObject(i));
                        if (O000000o2 != null) {
                            arrayList.add(O000000o2);
                        }
                    }
                }
                this.O00000o0.clear();
                this.O00000o.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    O000000o o000000o = (O000000o) it.next();
                    this.O00000o0.put(o000000o.O00000Oo, o000000o);
                    this.O00000o.put(o000000o.f6984O000000o, o000000o);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void O00000Oo() {
        long currentTimeMillis = System.currentTimeMillis();
        Context appContext = CommonApplication.getAppContext();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext);
        this.O00000oO = defaultSharedPreferences.getLong("pref_last_scan_time", 0);
        if (this.O00000oO == 0) {
            this.O00000oO = System.currentTimeMillis() / 1000;
            defaultSharedPreferences.edit().putLong("pref_last_scan_time", this.O00000oO).apply();
            return;
        }
        try {
            if (appContext.getPackageManager().getApplicationInfo("com.xiaomi.mitv.phone.tvassistant", 0) != null) {
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Cursor query = CommonApplication.getAppContext().getContentResolver().query(uri, new String[]{"_data"}, "date_added>" + this.O00000oO, null, "date_added DESC");
                if (query != null) {
                    if (query.getCount() != 0) {
                        query.moveToFirst();
                        this.O00000oo = query.getString(query.getColumnIndex("_data"));
                        query.close();
                        StringBuilder sb = new StringBuilder("Time:");
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        sb.append(this.O00000oo == null ? " no pic" : " new pic");
                        gsy.O000000o(3, "scanpic", sb.toString());
                        return;
                    }
                }
                if (query != null) {
                    query.close();
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
