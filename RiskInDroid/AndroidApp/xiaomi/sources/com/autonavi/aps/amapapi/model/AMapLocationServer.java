package com.autonavi.aps.amapapi.model;

import _m_j.bvz;
import _m_j.bwi;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import org.json.JSONObject;

public class AMapLocationServer extends AMapLocation {
    protected String d = "";
    boolean e = true;
    String f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
    private String g = null;
    private String h = "";
    private int i;
    private String j = "";
    private String k = "new";
    private JSONObject l = null;
    private String m = "";
    private String n = "";
    private long o = 0;
    private String p = null;

    public AMapLocationServer(String str) {
        super(str);
    }

    public final String a() {
        return this.g;
    }

    public final void a(long j2) {
        this.o = j2;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void a(JSONObject jSONObject) {
        this.l = jSONObject;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final String b() {
        return this.h;
    }

    public final void b(String str) {
        this.h = str;
    }

    public final void b(JSONObject jSONObject) {
        try {
            bvz.O000000o(this, jSONObject);
            this.k = jSONObject.optString("type", this.k);
            this.j = jSONObject.optString("retype", this.j);
            String optString = jSONObject.optString("cens", this.n);
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split("\\*");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String str = split[i2];
                    if (!TextUtils.isEmpty(str)) {
                        String[] split2 = str.split(",");
                        setLongitude(bwi.O00000oO(split2[0]));
                        setLatitude(bwi.O00000oO(split2[1]));
                        setAccuracy((float) bwi.O0000O0o(split2[2]));
                        break;
                    }
                    i2++;
                }
                this.n = optString;
            }
            this.d = jSONObject.optString("desc", this.d);
            c(jSONObject.optString("coord", String.valueOf(this.i)));
            this.m = jSONObject.optString("mcell", this.m);
            this.e = jSONObject.optBoolean("isReversegeo", this.e);
            this.f = jSONObject.optString("geoLanguage", this.f);
            if (bwi.O000000o(jSONObject, "poiid")) {
                setBuildingId(jSONObject.optString("poiid"));
            }
            if (bwi.O000000o(jSONObject, "pid")) {
                setBuildingId(jSONObject.optString("pid"));
            }
            if (bwi.O000000o(jSONObject, "floor")) {
                setFloor(jSONObject.optString("floor"));
            }
            if (bwi.O000000o(jSONObject, "flr")) {
                setFloor(jSONObject.optString("flr"));
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLoc", "AmapLoc");
        }
    }

    public final int c() {
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
    public final void c(String str) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("0")) {
                i2 = 0;
            } else if (str.equals("1")) {
                i2 = 1;
            }
            this.i = i2;
            super.setCoordType(this.i != 0 ? "WGS84" : "GCJ02");
        }
        i2 = -1;
        this.i = i2;
        super.setCoordType(this.i != 0 ? "WGS84" : "GCJ02");
    }

    public final String d() {
        return this.j;
    }

    public final void d(String str) {
        this.j = str;
    }

    public final String e() {
        return this.k;
    }

    public final void e(String str) {
        this.k = str;
    }

    public final JSONObject f() {
        return this.l;
    }

    public final void f(String str) {
        this.f = str;
    }

    public final String g() {
        return this.m;
    }

    public final void g(String str) {
        this.d = str;
    }

    public final AMapLocationServer h() {
        String str = this.m;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 3) {
            return null;
        }
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setProvider(getProvider());
        aMapLocationServer.setLongitude(bwi.O00000oO(split[0]));
        aMapLocationServer.setLatitude(bwi.O00000oO(split[1]));
        aMapLocationServer.setAccuracy(bwi.O00000oo(split[2]));
        aMapLocationServer.setCityCode(getCityCode());
        aMapLocationServer.setAdCode(getAdCode());
        aMapLocationServer.setCountry(getCountry());
        aMapLocationServer.setProvince(getProvince());
        aMapLocationServer.setCity(getCity());
        aMapLocationServer.setTime(getTime());
        aMapLocationServer.k = this.k;
        aMapLocationServer.c(String.valueOf(this.i));
        if (!bwi.O000000o(aMapLocationServer)) {
            return null;
        }
        return aMapLocationServer;
    }

    public final void h(String str) {
        this.p = str;
    }

    public final boolean i() {
        return this.e;
    }

    public final String j() {
        return this.f;
    }

    public final long k() {
        return this.o;
    }

    public final String l() {
        return this.p;
    }

    public JSONObject toJson(int i2) {
        try {
            JSONObject json = super.toJson(i2);
            if (i2 == 1) {
                json.put("retype", this.j);
                json.put("cens", this.n);
                json.put("coord", this.i);
                json.put("mcell", this.m);
                json.put("desc", this.d);
                json.put("address", getAddress());
                if (this.l != null && bwi.O000000o(json, "offpct")) {
                    json.put("offpct", this.l.getString("offpct"));
                }
            } else if (!(i2 == 2 || i2 == 3)) {
                return json;
            }
            json.put("type", this.k);
            json.put("isReversegeo", this.e);
            json.put("geoLanguage", this.f);
            return json;
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int i2) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i2);
            jSONObject.put("nb", this.p);
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
