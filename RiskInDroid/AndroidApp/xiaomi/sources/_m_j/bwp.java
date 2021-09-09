package _m_j;

import android.os.Bundle;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import com.loc.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bwp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static long f13341O000000o;

    public static int O000000o(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        Bundle bundle2 = bundle;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            if (optInt != 1 || (optJSONArray = jSONObject.optJSONArray("pois")) == null) {
                return optInt2;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                GeoFence geoFence = new GeoFence();
                PoiItem poiItem = new PoiItem();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                poiItem.setPoiId(jSONObject2.optString("id"));
                poiItem.setPoiName(jSONObject2.optString("name"));
                poiItem.setPoiType(jSONObject2.optString("type"));
                poiItem.setTypeCode(jSONObject2.optString("typecode"));
                poiItem.setAddress(jSONObject2.optString("address"));
                String optString = jSONObject2.optString("location");
                if (optString != null) {
                    String[] split = optString.split(",");
                    poiItem.setLongitude(Double.parseDouble(split[0]));
                    poiItem.setLatitude(Double.parseDouble(split[1]));
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                    arrayList2.add(dPoint);
                    arrayList.add(arrayList2);
                    geoFence.setPointList(arrayList);
                    geoFence.setCenter(dPoint);
                }
                poiItem.setTel(jSONObject2.optString("tel"));
                poiItem.setProvince(jSONObject2.optString("pname"));
                poiItem.setCity(jSONObject2.optString("cityname"));
                poiItem.setAdname(jSONObject2.optString("adname"));
                geoFence.setPoiItem(poiItem);
                StringBuilder sb = new StringBuilder();
                sb.append(O000000o());
                geoFence.setFenceId(sb.toString());
                geoFence.setCustomId(bundle2.getString("customId"));
                geoFence.setPendingIntentAction(bundle2.getString("pendingIntentAction"));
                geoFence.setType(2);
                geoFence.setRadius(bundle2.getFloat("fenceRadius"));
                geoFence.setExpiration(bundle2.getLong("expiration"));
                geoFence.setActivatesAction(bundle2.getInt("activatesAction", 1));
                list.add(geoFence);
            }
            return optInt2;
        } catch (Throwable unused) {
            return 5;
        }
    }

    public static synchronized long O000000o() {
        long j;
        synchronized (bwp.class) {
            long O00000o0 = bwi.O00000o0();
            if (O00000o0 > f13341O000000o) {
                f13341O000000o = O00000o0;
            } else {
                f13341O000000o++;
            }
            j = f13341O000000o;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ec A[SYNTHETIC] */
    private List<DPoint> O000000o(List<DPoint> list, float f) {
        DPoint dPoint;
        double d;
        double d2;
        double O000000o2;
        double d3;
        double d4;
        List<DPoint> list2 = list;
        float f2 = f;
        if (list2 == null) {
            return null;
        }
        if (list.size() <= 2) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        DPoint dPoint2 = list2.get(0);
        int i = 1;
        DPoint dPoint3 = list2.get(list.size() - 1);
        double d5 = 0.0d;
        double d6 = 0.0d;
        int i2 = 1;
        int i3 = 0;
        while (i2 < list.size() - i) {
            DPoint dPoint4 = list2.get(i2);
            double longitude = dPoint4.getLongitude() - dPoint2.getLongitude();
            double latitude = dPoint4.getLatitude() - dPoint2.getLatitude();
            double longitude2 = dPoint3.getLongitude() - dPoint2.getLongitude();
            double latitude2 = dPoint3.getLatitude() - dPoint2.getLatitude();
            double d7 = ((longitude * longitude2) + (latitude * latitude2)) / ((longitude2 * longitude2) + (latitude2 * latitude2));
            boolean z = dPoint2.getLongitude() == dPoint3.getLongitude() && dPoint2.getLatitude() == dPoint3.getLatitude();
            if (d7 < d5 || z) {
                d4 = dPoint2.getLongitude();
                d3 = dPoint2.getLatitude();
            } else if (d7 > 1.0d) {
                d4 = dPoint3.getLongitude();
                d3 = dPoint3.getLatitude();
            } else {
                double longitude3 = dPoint2.getLongitude() + (longitude2 * d7);
                d = dPoint2.getLatitude() + (d7 * latitude2);
                dPoint = dPoint2;
                d2 = longitude3;
                O000000o2 = (double) bwi.O000000o(new DPoint(dPoint4.getLatitude(), dPoint4.getLongitude()), new DPoint(d, d2));
                if (O000000o2 <= d6) {
                    d6 = O000000o2;
                    i3 = i2;
                }
                i2++;
                i = 1;
                d5 = 0.0d;
                list2 = list;
                dPoint2 = dPoint;
            }
            d = d3;
            dPoint = dPoint2;
            d2 = d4;
            O000000o2 = (double) bwi.O000000o(new DPoint(dPoint4.getLatitude(), dPoint4.getLongitude()), new DPoint(d, d2));
            if (O000000o2 <= d6) {
            }
            i2++;
            i = 1;
            d5 = 0.0d;
            list2 = list;
            dPoint2 = dPoint;
        }
        DPoint dPoint5 = dPoint2;
        if (d6 < ((double) f2)) {
            arrayList.add(dPoint5);
            arrayList.add(dPoint3);
            return arrayList;
        }
        List<DPoint> list3 = list;
        List<DPoint> O000000o3 = O000000o(list3.subList(0, i3 + 1), f2);
        List<DPoint> O000000o4 = O000000o(list3.subList(i3, list.size()), f2);
        arrayList.addAll(O000000o3);
        arrayList.remove(arrayList.size() - 1);
        arrayList.addAll(O000000o4);
        return arrayList;
    }

    public final int O00000Oo(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        String str2;
        ArrayList arrayList;
        long j;
        float f;
        String str3;
        String str4;
        int i;
        int i2;
        long j2;
        String str5;
        Bundle bundle2 = bundle;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            String string = bundle2.getString("customId");
            String string2 = bundle2.getString("pendingIntentAction");
            float f2 = bundle2.getFloat("fenceRadius");
            long j3 = bundle2.getLong("expiration");
            int i3 = bundle2.getInt("activatesAction", 1);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("districts")) != null) {
                int i4 = 0;
                while (i4 < optJSONArray.length()) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    GeoFence geoFence = new GeoFence();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                    String optString = jSONObject2.optString("citycode");
                    String optString2 = jSONObject2.optString("adcode");
                    String optString3 = jSONObject2.optString("name");
                    JSONArray jSONArray = optJSONArray;
                    String string3 = jSONObject2.getString("center");
                    int i5 = optInt2;
                    DPoint dPoint = new DPoint();
                    int i6 = i4;
                    String str6 = ",";
                    if (string3 != null) {
                        String[] split = string3.split(str6);
                        arrayList = arrayList2;
                        str2 = optString3;
                        dPoint.setLatitude(Double.parseDouble(split[1]));
                        dPoint.setLongitude(Double.parseDouble(split[0]));
                        geoFence.setCenter(dPoint);
                    } else {
                        arrayList = arrayList2;
                        str2 = optString3;
                    }
                    geoFence.setCustomId(string);
                    geoFence.setPendingIntentAction(string2);
                    geoFence.setType(3);
                    geoFence.setRadius(f2);
                    geoFence.setExpiration(j3);
                    geoFence.setActivatesAction(i3);
                    StringBuilder sb = new StringBuilder();
                    sb.append(O000000o());
                    geoFence.setFenceId(sb.toString());
                    String optString4 = jSONObject2.optString("polyline");
                    if (optString4 != null) {
                        String[] split2 = optString4.split("\\|");
                        int length = split2.length;
                        i = i3;
                        float f3 = Float.MAX_VALUE;
                        int i7 = 0;
                        float f4 = Float.MIN_VALUE;
                        while (i7 < length) {
                            String str7 = string;
                            String str8 = split2[i7];
                            String[] strArr = split2;
                            DistrictItem districtItem = new DistrictItem();
                            String str9 = string2;
                            List arrayList4 = new ArrayList();
                            districtItem.setCitycode(optString);
                            districtItem.setAdcode(optString2);
                            String str10 = optString2;
                            String str11 = str2;
                            districtItem.setDistrictName(str11);
                            str2 = str11;
                            String[] split3 = str8.split(";");
                            float f5 = f2;
                            int i8 = 0;
                            while (i8 < split3.length) {
                                String[] split4 = split3[i8].split(str6);
                                String str12 = str6;
                                String[] strArr2 = split3;
                                if (split4.length > 1) {
                                    String str13 = split4[1];
                                    String str14 = split4[0];
                                    j2 = j3;
                                    double parseDouble = Double.parseDouble(str13);
                                    i2 = length;
                                    str5 = optString;
                                    arrayList4.add(new DPoint(parseDouble, Double.parseDouble(str14)));
                                } else {
                                    j2 = j3;
                                    i2 = length;
                                    str5 = optString;
                                }
                                i8++;
                                optString = str5;
                                str6 = str12;
                                split3 = strArr2;
                                j3 = j2;
                                length = i2;
                            }
                            String str15 = str6;
                            long j4 = j3;
                            int i9 = length;
                            String str16 = optString;
                            if (((float) arrayList4.size()) > 100.0f) {
                                try {
                                    arrayList4 = O000000o(arrayList4, 100.0f);
                                } catch (Throwable unused) {
                                    return 5;
                                }
                            }
                            arrayList3.add(arrayList4);
                            districtItem.setPolyline(arrayList4);
                            ArrayList arrayList5 = arrayList;
                            arrayList5.add(districtItem);
                            f4 = Math.max(f4, j.O00000Oo(dPoint, arrayList4));
                            f3 = Math.min(f3, j.O000000o(dPoint, arrayList4));
                            i7++;
                            optString = str16;
                            arrayList = arrayList5;
                            string = str7;
                            split2 = strArr;
                            string2 = str9;
                            optString2 = str10;
                            f2 = f5;
                            str6 = str15;
                            j3 = j4;
                            length = i9;
                        }
                        str4 = string;
                        str3 = string2;
                        f = f2;
                        j = j3;
                        geoFence.setMaxDis2Center(f4);
                        geoFence.setMinDis2Center(f3);
                        geoFence.setDistrictItemList(arrayList);
                        geoFence.setPointList(arrayList3);
                        list.add(geoFence);
                    } else {
                        i = i3;
                        str4 = string;
                        str3 = string2;
                        f = f2;
                        j = j3;
                    }
                    i4 = i6 + 1;
                    optJSONArray = jSONArray;
                    optInt2 = i5;
                    i3 = i;
                    string = str4;
                    string2 = str3;
                    f2 = f;
                    j3 = j;
                }
            }
            return optInt2;
        } catch (Throwable unused2) {
            return 5;
        }
    }
}
