package _m_j;

import _m_j.or;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.util.List;

public final class pe {
    public static int O000000o(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return -1;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1 || type == 0) {
                return type;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static long O000000o(String str) {
        long j;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        long j2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long charAt = (long) str.charAt(length);
            if (charAt < 48 || charAt > 57) {
                long j3 = 97;
                if (charAt < 97 || charAt > 102) {
                    j3 = 65;
                    if (charAt < 65 || charAt > 70) {
                        if (!(charAt == 58 || charAt == 124)) {
                            return 0;
                        }
                    }
                }
                j = (charAt - j3) + 10;
            } else {
                j = charAt - 48;
            }
            j2 += j << i;
            i += 4;
        }
        if (i != 48) {
            return 0;
        }
        return j2;
    }

    public static String O000000o(long j) {
        if (j < 0 || j > 281474976710655L) {
            return null;
        }
        return pa.O000000o(pa.O000000o(j), ":");
    }

    public static void O000000o(or.O000000o o000000o, List<or.O000000o> list) {
        if (list != null) {
            int size = list.size();
            if (size == 0) {
                list.add(o000000o);
                return;
            }
            long j = Long.MAX_VALUE;
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            while (true) {
                if (i >= size) {
                    i2 = i3;
                    break;
                }
                or.O000000o o000000o2 = list.get(i);
                if (!o000000o.equals(o000000o2)) {
                    j = Math.min(j, o000000o2.O0000OOo);
                    if (j == o000000o2.O0000OOo) {
                        i3 = i;
                    }
                    i++;
                } else if (o000000o.O00000Oo != o000000o2.O00000Oo) {
                    o000000o2.O0000OOo = o000000o.O0000OOo;
                    o000000o2.O00000Oo = o000000o.O00000Oo;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (size < 3) {
                list.add(o000000o);
            } else if (o000000o.O0000OOo > j && i2 < size) {
                list.remove(i2);
                list.add(o000000o);
            }
        }
    }

    public static boolean O000000o(int i) {
        return i >= 0 && i <= 65535;
    }

    public static boolean O00000Oo(int i) {
        return i >= 0 && i <= 268435455;
    }
}
