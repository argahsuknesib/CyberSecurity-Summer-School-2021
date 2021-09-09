package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bvw {

    /* renamed from: O000000o  reason: collision with root package name */
    AMapLocationClientOption f13323O000000o = new AMapLocationClientOption();
    private StringBuilder O00000Oo = new StringBuilder();

    private void O000000o(AMapLocationServer aMapLocationServer, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str2) && (this.f13323O000000o.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN ? !str.contains("市") || !str.equals(str2) : !str2.equals(str))) {
            sb.append(str2);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(str5);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            if (TextUtils.isEmpty(str7) || this.f13323O000000o.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
                sb.append("Near ".concat(String.valueOf(str6)));
                str8 = "Near ".concat(String.valueOf(str6));
            } else {
                sb.append("靠近");
                sb.append(str6);
                sb.append(" ");
                str8 = "在" + str6 + "附近";
            }
            aMapLocationServer.setDescription(str8);
        }
        Bundle bundle = new Bundle();
        bundle.putString("citycode", aMapLocationServer.getCityCode());
        bundle.putString("desc", sb.toString());
        bundle.putString("adcode", aMapLocationServer.getAdCode());
        aMapLocationServer.setExtras(bundle);
        aMapLocationServer.g(sb.toString());
        String adCode = aMapLocationServer.getAdCode();
        aMapLocationServer.setAddress((adCode == null || adCode.trim().length() <= 0 || this.f13323O000000o.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) ? sb.toString() : sb.toString().replace(" ", ""));
    }

    private static String O00000Oo(String str) {
        return "[]".equals(str) ? "" : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0241, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x029b, code lost:
        r15.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d0, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ff, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0115, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x012b, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0155, code lost:
        r2 = "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x01ae */
    /* JADX WARNING: Missing exception handler attribute for start block: B:122:0x01c1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:136:0x01f7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00a6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0141 */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01c7 A[Catch:{ Throwable -> 0x0243, all -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01d6 A[Catch:{ Throwable -> 0x0243, all -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01e3 A[Catch:{ Throwable -> 0x0243, all -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01fd A[Catch:{ Throwable -> 0x0243, all -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0215 A[Catch:{ Throwable -> 0x0243, all -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0241 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:27:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x029b  */
    public final AMapLocationServer O000000o(AMapLocationServer aMapLocationServer, byte[] bArr) {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        String str;
        byte b;
        String str2;
        String str3;
        String str4;
        AMapLocationServer aMapLocationServer2 = aMapLocationServer;
        if (bArr == null) {
            try {
                aMapLocationServer2.setErrorCode(5);
                this.O00000Oo.append("binaryResult is null#0504");
                aMapLocationServer2.setLocationDetail(this.O00000Oo.toString());
                this.O00000Oo.delete(0, this.O00000Oo.length());
                return aMapLocationServer2;
            } catch (Throwable th) {
                th = th;
                byteBuffer = null;
                if (byteBuffer != null) {
                }
                throw th;
            }
        } else {
            byteBuffer = ByteBuffer.wrap(bArr);
            try {
                if (byteBuffer.get() == 0) {
                    aMapLocationServer2.b(String.valueOf((int) byteBuffer.getShort()));
                    byteBuffer.clear();
                    if (byteBuffer != null) {
                        byteBuffer.clear();
                    }
                    return aMapLocationServer2;
                }
                double d = (double) byteBuffer.getInt();
                Double.isNaN(d);
                aMapLocationServer2.setLongitude(bwi.O000000o(d / 1000000.0d));
                double d2 = (double) byteBuffer.getInt();
                Double.isNaN(d2);
                aMapLocationServer2.setLatitude(bwi.O000000o(d2 / 1000000.0d));
                aMapLocationServer2.setAccuracy((float) byteBuffer.getShort());
                aMapLocationServer2.c(String.valueOf((int) byteBuffer.get()));
                aMapLocationServer2.d(String.valueOf((int) byteBuffer.get()));
                if (byteBuffer.get() == 1) {
                    byte[] bArr2 = new byte[(byteBuffer.get() & 255)];
                    byteBuffer.get(bArr2);
                    aMapLocationServer2.setCountry(new String(bArr2, "UTF-8"));
                    try {
                        byte[] bArr3 = new byte[(byteBuffer.get() & 255)];
                        byteBuffer.get(bArr3);
                        String str5 = new String(bArr3, "UTF-8");
                        aMapLocationServer2.setProvince(str5);
                        str2 = str5;
                        byte[] bArr4 = new byte[(byteBuffer.get() & 255)];
                        byteBuffer.get(bArr4);
                        String str6 = new String(bArr4, "UTF-8");
                        aMapLocationServer2.setCity(str6);
                        str3 = str6;
                        byte[] bArr5 = new byte[(byteBuffer.get() & 255)];
                        byteBuffer.get(bArr5);
                        str4 = new String(bArr5, "UTF-8");
                        aMapLocationServer2.setDistrict(str4);
                    } catch (Throwable th2) {
                    }
                    String str7 = str4;
                    byte[] bArr6 = new byte[(byteBuffer.get() & 255)];
                    byteBuffer.get(bArr6);
                    String str8 = new String(bArr6, "UTF-8");
                    aMapLocationServer2.setStreet(str8);
                    aMapLocationServer2.setRoad(str8);
                    String str9 = str8;
                    byte[] bArr7 = new byte[(byteBuffer.get() & 255)];
                    byteBuffer.get(bArr7);
                    String str10 = new String(bArr7, "UTF-8");
                    aMapLocationServer2.setNumber(str10);
                    String str11 = str10;
                    byte[] bArr8 = new byte[(byteBuffer.get() & 255)];
                    byteBuffer.get(bArr8);
                    String str12 = new String(bArr8, "UTF-8");
                    aMapLocationServer2.setPoiName(str12);
                    String str13 = str12;
                    byte[] bArr9 = new byte[(byteBuffer.get() & 255)];
                    byteBuffer.get(bArr9);
                    aMapLocationServer2.setAoiName(new String(bArr9, "UTF-8"));
                    byte[] bArr10 = new byte[(byteBuffer.get() & 255)];
                    byteBuffer.get(bArr10);
                    String str14 = new String(bArr10, "UTF-8");
                    aMapLocationServer2.setAdCode(str14);
                    String str15 = str14;
                    byte[] bArr11 = new byte[(byteBuffer.get() & 255)];
                    byteBuffer.get(bArr11);
                    aMapLocationServer2.setCityCode(new String(bArr11, "UTF-8"));
                    str = "UTF-8";
                    b = 1;
                    O000000o(aMapLocationServer, str2, str3, str7, str9, str11, str13, str15);
                } else {
                    str = "UTF-8";
                    b = 1;
                }
                byteBuffer.get(new byte[(byteBuffer.get() & 255)]);
                if (byteBuffer.get() == b) {
                    byteBuffer.getInt();
                    byteBuffer.getInt();
                    byteBuffer.getShort();
                }
                if (byteBuffer.get() == b) {
                    byte[] bArr12 = new byte[(byteBuffer.get() & 255)];
                    byteBuffer.get(bArr12);
                    aMapLocationServer2.setBuildingId(new String(bArr12, str));
                    byte[] bArr13 = new byte[(byteBuffer.get() & 255)];
                    byteBuffer.get(bArr13);
                    aMapLocationServer2.setFloor(new String(bArr13, str));
                }
                if (byteBuffer.get() == b) {
                    byteBuffer.get();
                    byteBuffer.getInt();
                    byteBuffer.get();
                }
                if (byteBuffer.get() == b) {
                    aMapLocationServer2.setTime(byteBuffer.getLong());
                }
                int i = byteBuffer.getShort();
                if (i > 0) {
                    byte[] bArr14 = new byte[i];
                    byteBuffer.get(bArr14);
                    if (bArr14.length > 0) {
                        aMapLocationServer2.a(new String(Base64.decode(bArr14, 0), str));
                    }
                }
                int i2 = byteBuffer.getShort();
                if (i2 > 0) {
                    byteBuffer.get(new byte[i2]);
                }
                if (Double.valueOf("5.1").doubleValue() >= 5.1d) {
                    short s = byteBuffer.getShort();
                    if (!"-1".equals(aMapLocationServer.d())) {
                        if (s == -1) {
                            s = 0;
                        } else if (s == 0) {
                            s = -1;
                        }
                    } else if (s == 101) {
                        s = 100;
                    }
                    aMapLocationServer2.setConScenario(s);
                    byteBuffer.get();
                }
                if (byteBuffer != null) {
                    byteBuffer.clear();
                }
                if (this.O00000Oo.length() > 0) {
                    StringBuilder sb = this.O00000Oo;
                    sb.delete(0, sb.length());
                }
                return aMapLocationServer2;
            } catch (Throwable th22) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0083 A[Catch:{ Throwable -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088 A[Catch:{ Throwable -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d5 A[SYNTHETIC, Splitter:B:24:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e6 A[Catch:{ Throwable -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f3 A[Catch:{ Throwable -> 0x0109 }] */
    public final AMapLocationServer O000000o(String str) {
        String str2;
        String str3;
        JSONArray optJSONArray;
        String str4;
        JSONArray optJSONArray2;
        try {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
            aMapLocationServer.setCountry(O00000Oo(optJSONObject2.optString("country")));
            String O00000Oo2 = O00000Oo(optJSONObject2.optString("province"));
            aMapLocationServer.setProvince(O00000Oo2);
            String O00000Oo3 = O00000Oo(optJSONObject2.optString("citycode"));
            aMapLocationServer.setCityCode(O00000Oo3);
            String optString = optJSONObject2.optString("city");
            if (!O00000Oo3.endsWith("010") && !O00000Oo3.endsWith("021") && !O00000Oo3.endsWith("022")) {
                if (!O00000Oo3.endsWith("023")) {
                    str2 = O00000Oo(optString);
                    aMapLocationServer.setCity(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        aMapLocationServer.setCity(O00000Oo2);
                        str3 = O00000Oo2;
                    } else {
                        str3 = str2;
                    }
                    String O00000Oo4 = O00000Oo(optJSONObject2.optString("district"));
                    aMapLocationServer.setDistrict(O00000Oo4);
                    String O00000Oo5 = O00000Oo(optJSONObject2.optString("adcode"));
                    aMapLocationServer.setAdCode(O00000Oo5);
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("streetNumber");
                    String O00000Oo6 = O00000Oo(optJSONObject3.optString("street"));
                    aMapLocationServer.setStreet(O00000Oo6);
                    aMapLocationServer.setRoad(O00000Oo6);
                    String O00000Oo7 = O00000Oo(optJSONObject3.optString("number"));
                    aMapLocationServer.setNumber(O00000Oo7);
                    optJSONArray = optJSONObject.optJSONArray("pois");
                    if (optJSONArray.length() <= 0) {
                        String O00000Oo8 = O00000Oo(optJSONArray.getJSONObject(0).optString("name"));
                        aMapLocationServer.setPoiName(O00000Oo8);
                        str4 = O00000Oo8;
                    } else {
                        str4 = null;
                    }
                    optJSONArray2 = optJSONObject.optJSONArray("aois");
                    if (optJSONArray2.length() > 0) {
                        aMapLocationServer.setAoiName(O00000Oo(optJSONArray2.getJSONObject(0).optString("name")));
                    }
                    O000000o(aMapLocationServer, O00000Oo2, str3, O00000Oo4, O00000Oo6, O00000Oo7, str4, O00000Oo5);
                    return aMapLocationServer;
                }
            }
            if (O00000Oo2 == null || O00000Oo2.length() <= 0) {
                str2 = optString;
            } else {
                aMapLocationServer.setCity(O00000Oo2);
                str2 = O00000Oo2;
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            String O00000Oo42 = O00000Oo(optJSONObject2.optString("district"));
            aMapLocationServer.setDistrict(O00000Oo42);
            String O00000Oo52 = O00000Oo(optJSONObject2.optString("adcode"));
            aMapLocationServer.setAdCode(O00000Oo52);
            JSONObject optJSONObject32 = optJSONObject2.optJSONObject("streetNumber");
            String O00000Oo62 = O00000Oo(optJSONObject32.optString("street"));
            aMapLocationServer.setStreet(O00000Oo62);
            aMapLocationServer.setRoad(O00000Oo62);
            String O00000Oo72 = O00000Oo(optJSONObject32.optString("number"));
            aMapLocationServer.setNumber(O00000Oo72);
            optJSONArray = optJSONObject.optJSONArray("pois");
            if (optJSONArray.length() <= 0) {
            }
            optJSONArray2 = optJSONObject.optJSONArray("aois");
            if (optJSONArray2.length() > 0) {
            }
            O000000o(aMapLocationServer, O00000Oo2, str3, O00000Oo42, O00000Oo62, O00000Oo72, str4, O00000Oo52);
            return aMapLocationServer;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
        if (r9.has("info") == false) goto L_0x0065;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0052 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f A[SYNTHETIC, Splitter:B:12:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008d A[Catch:{ Throwable -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d4  */
    public final AMapLocationServer O000000o(String str, Context context, bta bta) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setErrorCode(7);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#SHA1AndPackage#");
        stringBuffer.append(bwt.O00000oO(context));
        String str2 = (String) bta.O00000Oo.get("gsid").get(0);
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("#gsid#");
            stringBuffer.append(str2);
        }
        String str3 = bta.O00000o0;
        if (!TextUtils.isEmpty(str3)) {
            stringBuffer.append("#csid#".concat(String.valueOf(str3)));
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status")) {
            }
            StringBuilder sb = this.O00000Oo;
            sb.append("json is error:");
            sb.append(str);
            sb.append(stringBuffer);
            sb.append("#0702");
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            String string3 = jSONObject.getString("infocode");
            if ("0".equals(string)) {
                StringBuilder sb2 = this.O00000Oo;
                sb2.append("auth fail:");
                sb2.append(string2);
                sb2.append(stringBuffer);
                sb2.append("#0701");
                bwf.O000000o(bta.O00000o, string3, string2);
            }
        } catch (Throwable th) {
            StringBuilder sb3 = this.O00000Oo;
            sb3.append("json exception error:");
            sb3.append(th.getMessage());
            sb3.append(stringBuffer);
            sb3.append("#0703");
            bvz.O000000o(th, "parser", "paseAuthFailurJson");
        }
        aMapLocationServer.setLocationDetail(this.O00000Oo.toString());
        if (this.O00000Oo.length() > 0) {
            StringBuilder sb4 = this.O00000Oo;
            sb4.delete(0, sb4.length());
        }
        return aMapLocationServer;
    }
}
