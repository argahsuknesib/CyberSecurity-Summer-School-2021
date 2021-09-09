package _m_j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class bmo {
    private static bmo O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    private Object f13104O000000o = null;
    private Context O00000Oo = null;
    private Object O00000o0 = null;

    private bmo() {
        try {
            this.O00000Oo = blw.f13081O000000o;
            if (this.O00000Oo != null) {
                this.f13104O000000o = bna.O000000o(this.O00000Oo, bnd.O00000o0("989a8bac868c8b9a92ac9a8d89969c9a"), new Class[]{String.class}, new Object[]{bnd.O00000o0("88969996")});
                if (this.f13104O000000o != null) {
                    this.O00000o0 = bna.O000000o(this.f13104O000000o, bnd.O00000o0("989a8bbc9091919a9c8b969091b6919990"));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static bmo O000000o() {
        if (O00000o == null) {
            synchronized (bmo.class) {
                if (O00000o == null) {
                    O00000o = new bmo();
                }
            }
        }
        return O00000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A[Catch:{ Exception -> 0x00cc }] */
    public static List<String> O0000OOo() {
        String str;
        Enumeration<InetAddress> inetAddresses;
        ArrayList arrayList = new ArrayList();
        try {
            Object O000000o2 = bna.O000000o(bnd.O00000o0("959e899ed1919a8bd1b19a8b88908d94b6918b9a8d999e9c9a"), bnd.O00000o0("989a8bb19a8b88908d94b6918b9a8d999e9c9a8c"));
            Method declaredMethod = Enumeration.class.getDeclaredMethod(bnd.O00000o0("979e8cb2908d9aba939a929a918b8c"), new Class[0]);
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = Enumeration.class.getDeclaredMethod(bnd.O00000o0("919a878bba939a929a918b"), new Class[0]);
            declaredMethod2.setAccessible(true);
            while (((Boolean) declaredMethod.invoke(O000000o2, new Object[0])).booleanValue()) {
                NetworkInterface networkInterface = (NetworkInterface) declaredMethod2.invoke(O000000o2, new Object[0]);
                if (!networkInterface.isLoopback()) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    String str2 = "";
                    if (hardwareAddress != null) {
                        if (hardwareAddress.length > 0) {
                            str = bne.O00000o(bne.O000000o(hardwareAddress));
                            if (!str.isEmpty() && !str.equals("000000000000")) {
                                inetAddresses = networkInterface.getInetAddresses();
                                String str3 = str2;
                                while (inetAddresses.hasMoreElements()) {
                                    InetAddress nextElement = inetAddresses.nextElement();
                                    if (!nextElement.isLoopbackAddress()) {
                                        String hostAddress = nextElement.getHostAddress();
                                        if (hostAddress.trim().length() < 17) {
                                            str2 = hostAddress;
                                        } else {
                                            str3 = hostAddress;
                                        }
                                    }
                                }
                                arrayList.add(networkInterface.getDisplayName() + "," + str2 + "," + str + "," + str3);
                            }
                        }
                    }
                    str = str2;
                    inetAddresses = networkInterface.getInetAddresses();
                    String str32 = str2;
                    while (inetAddresses.hasMoreElements()) {
                    }
                    arrayList.add(networkInterface.getDisplayName() + "," + str2 + "," + str + "," + str32);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static boolean O0000Oo() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) blw.f13081O000000o.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static String O0000Oo0() {
        String str;
        String str2;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                str2 = System.getProperty("http.proxyHost");
                str = System.getProperty("http.proxyPort");
                if (TextUtils.isEmpty(str)) {
                    str = "-1";
                }
            } else {
                Context context = blw.f13081O000000o;
                if (context == null) {
                    return "";
                }
                String host = Proxy.getHost(context);
                str = String.valueOf(Proxy.getPort(context));
                str2 = host;
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            return str2 + ":" + str;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String O00000Oo() {
        String str;
        try {
            return (this.O00000o0 == null || (str = (String) bna.O000000o(this.O00000o0, bnd.O00000o0("989a8bacacb6bb"))) == null) ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String O00000o() {
        String str;
        try {
            return (this.O00000o0 == null || (str = (String) bna.O000000o(this.O00000o0, bnd.O00000o0("989a8bb29e9cbe9b9b8d9a8c8c"))) == null) ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String O00000o0() {
        String str;
        try {
            return (this.O00000o0 == null || (str = (String) bna.O000000o(this.O00000o0, bnd.O00000o0("989a8bbdacacb6bb"))) == null) ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String O00000oO() {
        String formatIpAddress;
        try {
            return (this.O00000o0 == null || (formatIpAddress = Formatter.formatIpAddress(((Integer) bna.O000000o(this.O00000o0, bnd.O00000o0("989a8bb68fbe9b9b8d9a8c8c"))).intValue())) == null) ? "" : formatIpAddress;
        } catch (Exception unused) {
            return "";
        }
    }

    public final List<String> O00000oo() {
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = this.O00000Oo.getPackageManager();
            int checkPermission = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", this.O00000Oo.getPackageName());
            int checkPermission2 = packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", this.O00000Oo.getPackageName());
            if ((checkPermission == 0 || checkPermission2 == 0) && this.f13104O000000o != null) {
                for (ScanResult scanResult : (List) bna.O000000o(this.f13104O000000o, bnd.O00000o0("989a8bac9c9e91ad9a8c8a938b8c"))) {
                    int intValue = ((Integer) bna.O00000Oo(scanResult, bnd.O00000o0("939a899a93"))).intValue();
                    arrayList.add(bne.O00000o((String) bna.O00000Oo(scanResult, bnd.O00000o0("bdacacb6bb"))) + "," + intValue);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final String O0000O0o() {
        String O0000OoO;
        try {
            return (this.O00000Oo == null || (O0000OoO = O0000OoO()) == null) ? "" : O0000OoO;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008a A[RETURN] */
    private String O0000OoO() {
        int i;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.O00000Oo.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                i = -1;
                if (i != -101) {
                    return "wifi";
                }
                switch (i) {
                    case -1:
                        return "nil";
                    case 0:
                        return "unknown";
                    case 1:
                        return "2g.gprs";
                    case 2:
                        return "2g.edge";
                    case 3:
                        return "3g.umts";
                    case 4:
                        return "2g.cdma";
                    case 5:
                        return "3g.evdo_0";
                    case 6:
                        return "3g.evdo_a";
                    case 7:
                        return "2g.1xrtt";
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        return "3g.hsdpa";
                    case 9:
                        return "3g.hsupa";
                    case 10:
                        return "3g.hspa";
                    case 11:
                        return "2g.iden";
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        return "3g.evdo_b";
                    case 13:
                        return "4g.lte";
                    case 14:
                        return "3g.ehrpd";
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        return "3g.hspap";
                    default:
                        return String.format("%d", Integer.valueOf(i));
                }
            } else {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    i = -101;
                } else {
                    if (type == 0) {
                        i = ((TelephonyManager) this.O00000Oo.getSystemService("phone")).getNetworkType();
                    }
                    i = 0;
                }
                if (i != -101) {
                }
            }
        } catch (Exception e) {
            bmz.O000000o(e);
        }
    }
}
