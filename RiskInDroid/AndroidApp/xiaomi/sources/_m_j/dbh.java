package _m_j;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Base64;
import com.sdu.didi.uuid.SigLib;
import com.sdu.didi.uuid.ed;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dbh {
    private static dbh O00000Oo;
    private static Activity O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    private final long f14446O000000o = 5000;
    private int[] O00000o = {231, 260, 251};
    private int[] O00000oO = {193, 240, 232};
    private Handler O00000oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.dbh.AnonymousClass1 */

        public final void handleMessage(Message message) {
            Object obj;
            String O000000o2;
            if (message.what == 4097 && (obj = message.obj) != null && (obj instanceof O000000o) && (O000000o2 = dbh.this.O000000o()) != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(O000000o2.getBytes("UTF-8"));
                    gZIPOutputStream.finish();
                    gZIPOutputStream.close();
                    Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                } catch (Exception unused) {
                }
            }
        }
    };

    public interface O000000o {
    }

    private dbh(Activity activity) {
        O00000o0 = activity;
    }

    public static synchronized dbh O000000o(Activity activity) {
        dbh dbh;
        synchronized (dbh.class) {
            if (O00000Oo == null) {
                O00000Oo = new dbh(activity);
            }
            dbh = O00000Oo;
        }
        return dbh;
    }

    private static void O000000o(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.putOpt(str, str2);
        }
    }

    private void O000000o(byte[] bArr) {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            String param2 = SigLib.getParam2(O00000o0, this.O00000oO);
            if (!TextUtils.isEmpty(param2)) {
                String str = absolutePath + File.separator + param2;
                String str2 = str + File.separator + SigLib.getParam1(O00000o0, this.O00000oO);
                File file = null;
                if (!TextUtils.isEmpty(str)) {
                    file = new File(str);
                    file.mkdirs();
                }
                if (file != null && file.exists()) {
                    dbi.O000000o(str2, bArr);
                }
                String str3 = absolutePath + File.separator + SigLib.getParam2(O00000o0, this.O00000o);
                String str4 = str3 + File.separator + SigLib.getParam1(O00000o0, this.O00000o);
                if (!TextUtils.isEmpty(str3)) {
                    file = new File(str3);
                    file.mkdirs();
                }
                if (file != null && file.exists()) {
                    dbi.O000000o(str4, bArr);
                }
                String param = SigLib.getParam(O00000o0, this.O00000oO);
                if (!TextUtils.isEmpty(param)) {
                    absolutePath = absolutePath + File.separator + param;
                }
                dbi.O000000o(absolutePath + File.separator + SigLib.getParam(O00000o0, this.O00000o), bArr);
            }
        }
    }

    private String[] O00000o() {
        String O0000OOo = dbi.O0000OOo(O00000o0);
        String O00000Oo2 = dbi.O00000Oo(O00000o0);
        String O000000o2 = dbi.O000000o((Context) O00000o0);
        ed edVar = new ed();
        edVar.f5607a = O0000OOo;
        edVar.b = O00000Oo2;
        edVar.c = O000000o2;
        edVar.d = dbi.O0000Oo0(O00000o0);
        byte[] O000000o3 = dbi.O000000o(edVar);
        String[] strArr = {O0000OOo, edVar.d};
        O000000o(O000000o3);
        return strArr;
    }

    /* access modifiers changed from: package-private */
    public final String O000000o() {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject O00000oO2 = O00000oO();
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("sig", SigLib.getSig(O00000o0, O00000oO2.toString()));
            jSONArray.put(O00000oO2);
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String O00000Oo() {
        dbg.O000000o(O00000o0).O000000o();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String O000000o2 = O000000o();
        if (O000000o2 == null) {
            return "";
        }
        Deflater deflater = new Deflater(9);
        try {
            byte[] bytes = O000000o2.getBytes("UTF-8");
            byte[] bArr = new byte[bytes.length];
            deflater.setInput(bytes);
            deflater.finish();
            int deflate = deflater.deflate(bArr);
            deflater.end();
            dbg.O000000o(O00000o0).O00000Oo();
            return Base64.encodeToString(bArr, 0, deflate, 0);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0125  */
    private synchronized String[] O00000o0() {
        String[] strArr;
        byte[] O000000o2;
        Object O000000o3;
        File file;
        String str;
        String param;
        String str2;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str3 = null;
        if (!TextUtils.isEmpty(absolutePath)) {
            String param2 = SigLib.getParam2(O00000o0, this.O00000oO);
            if (!TextUtils.isEmpty(param2)) {
                String str4 = absolutePath + File.separator + param2;
                String str5 = str4 + File.separator + SigLib.getParam1(O00000o0, this.O00000oO);
                if (!TextUtils.isEmpty(str4)) {
                    file = new File(str4);
                    file.mkdirs();
                } else {
                    file = null;
                }
                File file2 = (file == null || !file.exists()) ? null : new File(str5);
                if (file2 != null) {
                    if (file2.exists()) {
                        str = str5;
                        if (file2 != null) {
                            if (file2.exists()) {
                                str3 = str;
                            }
                        }
                        param = SigLib.getParam(O00000o0, this.O00000oO);
                        if (TextUtils.isEmpty(param)) {
                            absolutePath = absolutePath + File.separator + param;
                        }
                        str2 = absolutePath + File.separator + SigLib.getParam(O00000o0, this.O00000o);
                        if (!new File(str2).exists()) {
                            str3 = str2;
                        }
                    }
                }
                String str6 = absolutePath + File.separator + SigLib.getParam2(O00000o0, this.O00000o);
                str = str6 + File.separator + SigLib.getParam1(O00000o0, this.O00000o);
                if (!TextUtils.isEmpty(str6)) {
                    file = new File(str6);
                    file.mkdirs();
                }
                if (file != null && file.exists()) {
                    file2 = new File(str);
                }
                if (file2 != null) {
                }
                param = SigLib.getParam(O00000o0, this.O00000oO);
                if (TextUtils.isEmpty(param)) {
                }
                str2 = absolutePath + File.separator + SigLib.getParam(O00000o0, this.O00000o);
                if (!new File(str2).exists()) {
                }
            }
        }
        strArr = new String[2];
        if (TextUtils.isEmpty(str3) || (O000000o3 = dbi.O000000o((O000000o2 = dbi.O000000o(str3)))) == null || !(O000000o3 instanceof ed)) {
            strArr = O00000o();
        } else {
            String str7 = ((ed) O000000o3).f5607a;
            String str8 = ((ed) O000000o3).d;
            int i = 0;
            strArr[0] = str7;
            strArr[1] = str8;
            String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
            int i2 = -1;
            if (!TextUtils.isEmpty(absolutePath2)) {
                String param22 = SigLib.getParam2(O00000o0, this.O00000oO);
                if (!TextUtils.isEmpty(param22)) {
                    File file3 = new File((absolutePath2 + File.separator + param22) + File.separator + SigLib.getParam1(O00000o0, this.O00000oO));
                    if (file3.exists() && file3.isFile()) {
                        i = 1;
                    }
                    File file4 = new File((absolutePath2 + File.separator + SigLib.getParam2(O00000o0, this.O00000o)) + File.separator + SigLib.getParam1(O00000o0, this.O00000o));
                    if (file4.exists() && file4.isFile()) {
                        i++;
                    }
                    String param3 = SigLib.getParam(O00000o0, this.O00000oO);
                    if (!TextUtils.isEmpty(param3)) {
                        absolutePath2 = absolutePath2 + File.separator + param3;
                    }
                    File file5 = new File(absolutePath2 + File.separator + SigLib.getParam(O00000o0, this.O00000o));
                    if (file5.exists() && file5.isFile()) {
                        i++;
                    }
                    i2 = i;
                }
            }
            if (i2 == 1) {
                O000000o(O000000o2);
            }
        }
        return strArr;
    }

    private JSONObject O00000oO() {
        String str;
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        TelephonyManager telephonyManager;
        JSONObject jSONObject = new JSONObject();
        String[] O00000o02 = O00000o0();
        int i2 = 0;
        if (O00000o02 != null) {
            try {
                O000000o(jSONObject, "suuid", O00000o02[0]);
                O000000o(jSONObject, "gqid", O00000o02[1]);
            } catch (JSONException unused) {
            }
        }
        O000000o(jSONObject, "imei", dbi.O00000Oo(O00000o0));
        Activity activity = O00000o0;
        String str6 = null;
        if (activity == null) {
            str = null;
        } else {
            TelephonyManager telephonyManager2 = (TelephonyManager) activity.getSystemService("phone");
            str = telephonyManager2.getSubscriberId() == null ? "" : telephonyManager2.getSubscriberId();
        }
        O000000o(jSONObject, "imsi", str);
        Activity activity2 = O00000o0;
        if (activity2 == null) {
            str2 = null;
        } else {
            WifiInfo connectionInfo = ((WifiManager) activity2.getSystemService("wifi")).getConnectionInfo();
            str2 = connectionInfo.getMacAddress() != null ? connectionInfo.getMacAddress() : "null";
        }
        O000000o(jSONObject, "mac", str2);
        String str7 = Build.MODEL;
        if (TextUtils.isEmpty(str7)) {
            str7 = "";
        }
        O000000o(jSONObject, "model", str7);
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        jSONObject.putOpt("version", sb.toString());
        String str8 = Build.BRAND;
        if (TextUtils.isEmpty(str8)) {
            str8 = "";
        }
        O000000o(jSONObject, "brand", str8);
        Activity activity3 = O00000o0;
        if (activity3 == null || (telephonyManager = (TelephonyManager) activity3.getSystemService("phone")) == null) {
            str3 = null;
        } else {
            str3 = telephonyManager.getSimOperatorName();
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.putOpt("SimOperatorName", str3);
            O000000o(jSONObject, "mobile_ip", dbi.O000000o());
        }
        O000000o(jSONObject, "net", dbi.O00000oo(O00000o0));
        if (dbi.O00000oO(O00000o0)) {
            Activity activity4 = O00000o0;
            if (activity4 == null) {
                str4 = null;
            } else {
                str4 = ((WifiManager) activity4.getSystemService("wifi")).getConnectionInfo().getSSID();
            }
            O000000o(jSONObject, "wifi_name", str4);
            Activity activity5 = O00000o0;
            if (activity5 == null) {
                str5 = null;
            } else {
                WifiInfo connectionInfo2 = ((WifiManager) activity5.getSystemService("wifi")).getConnectionInfo();
                connectionInfo2.getMacAddress();
                int ipAddress = connectionInfo2.getIpAddress();
                str5 = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
            }
            O000000o(jSONObject, "wifi_ip", str5);
            O000000o(jSONObject, "wifi_mac", dbi.O00000o0(O00000o0));
        }
        O000000o(jSONObject, "wifi_mac", dbi.O00000o0(O00000o0));
        TelephonyManager telephonyManager3 = (TelephonyManager) O00000o0.getSystemService("phone");
        String networkOperator = telephonyManager3.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            int parseInt = Integer.parseInt(networkOperator.substring(0, 3));
            int parseInt2 = Integer.parseInt(networkOperator.substring(3));
            CellLocation cellLocation = telephonyManager3.getCellLocation();
            if (cellLocation != null) {
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    i2 = gsmCellLocation.getLac();
                    i = gsmCellLocation.getCid();
                } else if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    i2 = cdmaCellLocation.getNetworkId();
                    i = cdmaCellLocation.getBaseStationId();
                } else {
                    i = 0;
                }
                str6 = parseInt + ":" + parseInt2 + ":" + i2 + ":" + i;
            }
        }
        O000000o(jSONObject, "CGI", str6);
        jSONObject.putOpt("root", Boolean.valueOf(dbi.O00000Oo()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dbi.O00000o(O00000o0));
        jSONObject.putOpt("app_version", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(dbi.O0000O0o(O00000o0));
        jSONObject.putOpt("app_install_time", sb3.toString());
        jSONObject.putOpt("app_type", O00000o0.getPackageName());
        dbg.O000000o(O00000o0).O000000o(jSONObject);
        return jSONObject;
    }
}
