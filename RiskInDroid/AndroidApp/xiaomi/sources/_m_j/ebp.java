package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.mobilestats.data.ProtoMsg$StatsMsg;
import com.xiaomi.mobilestats.data.SendStrategyEnum;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class ebp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Context f15153O000000o = null;
    public static Handler O00000Oo = new ebq(O00000oo.getLooper());
    private static WeakHashMap O00000o = new WeakHashMap();
    private static boolean O00000o0 = true;
    private static HashMap O00000oO = new HashMap();
    private static HandlerThread O00000oo = new HandlerThread("XMAgent");
    private static ebp O0000O0o = new ebp();

    private ebp() {
        HandlerThread handlerThread = O00000oo;
        if (handlerThread != null) {
            handlerThread.start();
        }
    }

    public static ebp O000000o() {
        return O0000O0o;
    }

    private static void O000000o(edh edh, HashMap hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                edn O00000o2 = ProtoMsg$StatsMsg.ProtoMap.O00000o();
                O00000o2.O000000o((String) entry.getKey());
                O00000o2.O00000Oo((String) entry.getValue());
                edh.O000000o(O00000o2);
            }
        }
    }

    public static void O000000o(Context context, String str, byte[] bArr) {
        Handler handler;
        if (context != null && bArr != null && bArr.length > 0) {
            byte[] O000000o2 = ebr.O000000o(bArr);
            String O000000o3 = eck.O000000o(context, str, O000000o2);
            if (!ecd.O000000o(O000000o3) && (handler = O00000Oo) != null) {
                handler.post(new edv(O000000o3, O000000o2));
            }
        }
    }

    public static HashMap O00000Oo() {
        return O00000oO;
    }

    private static ProtoMsg$StatsMsg.PageMsg O000000o(Context context, eeo eeo, String str) {
        if (eeo == null) {
            return null;
        }
        O00000o.remove(Integer.valueOf(eeo.hashCode()));
        try {
            String str2 = "";
            String str3 = TextUtils.isEmpty(eeo.f15192O000000o) ? str2 : eeo.f15192O000000o;
            edi O00000o02 = ProtoMsg$StatsMsg.PageMsg.O00000o0();
            edh O0000oo0 = ProtoMsg$StatsMsg.Page.O0000oo0();
            edh O00000o03 = O0000oo0.O000000o("page").O00000o0(ecp.O0000O0o(context));
            StringBuilder sb = new StringBuilder();
            sb.append(ecp.O00000oo(context));
            edh O00000o2 = O00000o03.O00000Oo(sb.toString()).O00000o(ebu.O000000o().O000000o(context));
            if (TextUtils.isEmpty(str)) {
                str = str3;
            }
            edh O000000o2 = O00000o2.O00000oO(str).O000000o(eeo.O00000Oo).O00000Oo(eeo.O00000o0).O00000o0(eeo.O00000o).O00000oo("android").O0000O0o(ecp.O000000o(context)).O0000OOo(ecp.O00000Oo(context)).O0000Oo0(ecp.O0000OOo(context)).O000000o(ecp.O00000o(context));
            edh O0000Oo = O000000o2.O0000Oo(ecp.O00000oO(context));
            edh O0000OoO = O0000Oo.O0000OoO(ecp.O000000o());
            O0000OoO.O0000Ooo(ecp.O00000Oo()).O0000o00(ebs.O000000o());
            try {
                eem O00000Oo2 = ebs.O00000Oo(context);
                O0000oo0.O0000o0(O00000Oo2 != null ? O00000Oo2.O00000o0 : str2);
                if (O00000Oo2 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(O00000Oo2.O00000Oo);
                    str2 = sb2.toString();
                }
                O0000oo0.O0000o0O(str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            O000000o(O0000oo0, O00000oO);
            O000000o(O0000oo0, eeo.O00000oO);
            O000000o(O0000oo0, null);
            O00000o02.O000000o(O0000oo0);
            return O00000o02.build();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ void O000000o(Context context) {
        if (O00000o0 && context != null) {
            eeo eeo = new eeo();
            eeo.O00000Oo = System.currentTimeMillis();
            int hashCode = context.hashCode();
            WeakHashMap weakHashMap = O00000o;
            if (weakHashMap != null) {
                if (weakHashMap.containsKey(Integer.valueOf(hashCode))) {
                    O00000o.remove(Integer.valueOf(hashCode));
                }
                O00000o.put(Integer.valueOf(hashCode), eeo);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0130, code lost:
        if (r3 != false) goto L_0x0132;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ec  */
    public static /* synthetic */ void O00000Oo(Context context) {
        WeakHashMap weakHashMap;
        eeo eeo;
        boolean z;
        Context applicationContext;
        ConnectivityManager connectivityManager;
        NetworkInfo[] allNetworkInfo;
        boolean z2;
        boolean z3;
        ConnectivityManager connectivityManager2;
        NetworkInfo activeNetworkInfo;
        if (O00000o0 && context != null && (weakHashMap = O00000o) != null && context != null && weakHashMap.containsKey(Integer.valueOf(context.hashCode())) && (eeo = (eeo) O00000o.get(Integer.valueOf(context.hashCode()))) != null) {
            eeo.O00000o0 = System.currentTimeMillis();
            eeo.O00000o = System.currentTimeMillis() - eeo.O00000o0;
            ProtoMsg$StatsMsg.PageMsg O000000o2 = O000000o(context, eeo, context.getClass().getName());
            if (O000000o2 != null) {
                boolean z4 = false;
                if (eck.O000000o().O00000Oo.equals(SendStrategyEnum.REAL_TIME)) {
                    if ((context == null || !ebs.O000000o(context, "android.permission.INTERNET") || (connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager2.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true) {
                        if (context == null) {
                            z2 = true;
                        } else {
                            char c = 65535;
                            if (context != null) {
                                NetworkInfo activeNetworkInfo2 = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                                if (activeNetworkInfo2 == null || !activeNetworkInfo2.isConnected()) {
                                    c = 0;
                                } else {
                                    String typeName = activeNetworkInfo2.getTypeName();
                                    if (typeName.equalsIgnoreCase("wifi")) {
                                        c = 4;
                                    } else if (typeName.equalsIgnoreCase("mobile")) {
                                        if (!ecd.O000000o(Proxy.getDefaultHost())) {
                                            c = 1;
                                        } else {
                                            if (context != null) {
                                                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                                                    case 3:
                                                    case 5:
                                                    case 6:
                                                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                                    case 9:
                                                    case 10:
                                                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                                    case 13:
                                                    case 14:
                                                    case GmsLogger.MAX_PII_TAG_LENGTH:
                                                        z3 = true;
                                                        break;
                                                }
                                                c = z3 ? (char) 2 : 3;
                                            }
                                            z3 = false;
                                            if (z3) {
                                            }
                                        }
                                    }
                                }
                            }
                            z2 = c == 2 || c == 1;
                            eck.O0000o0 = z2;
                        }
                        if (!z2) {
                            z = true;
                            if (z) {
                                if (eck.f15166O000000o) {
                                    if (!(context == null || !ebs.O000000o(context, "android.permission.ACCESS_WIFI_STATE") || (applicationContext = context.getApplicationContext()) == null || (connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity")) == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null || allNetworkInfo.length <= 0)) {
                                        int i = 0;
                                        while (true) {
                                            if (i < allNetworkInfo.length) {
                                                if (!allNetworkInfo[i].getTypeName().equals("WIFI") || !allNetworkInfo[i].isConnected()) {
                                                    i++;
                                                } else {
                                                    z4 = true;
                                                }
                                            }
                                        }
                                    }
                                }
                                een O000000o3 = eca.O000000o(5, ecd.O000000o(O000000o2.toByteArray()));
                                if (O000000o3 != null && !O000000o3.f15191O000000o) {
                                    O000000o(context, "page", O000000o2.toByteArray());
                                    return;
                                }
                                return;
                            }
                            O000000o(context, "page", O000000o2.toByteArray());
                        }
                    }
                }
                z = false;
                if (z) {
                }
                O000000o(context, "page", O000000o2.toByteArray());
            }
        }
    }
}
