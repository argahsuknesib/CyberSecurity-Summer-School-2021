package _m_j;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.httputil.HttpDNSUtilForOpenSDK$DNSHostIP$1;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class ijc {

    public static class O000000o {
        private static List<O000000o> O00000o0;

        /* renamed from: O000000o  reason: collision with root package name */
        String[] f1358O000000o;
        int O00000Oo;

        public /* synthetic */ O000000o(String[] strArr, byte b) {
            this(strArr);
        }

        private O000000o(String[] strArr) {
            this.O00000Oo = 0;
            if (strArr != null && strArr.length > 1) {
                this.f1358O000000o = strArr;
            }
        }

        public static List<O000000o> O000000o() {
            if (O00000o0 == null) {
                O00000o0 = new HttpDNSUtilForOpenSDK$DNSHostIP$1();
            }
            return O00000o0;
        }

        public static boolean O000000o(String str) {
            Iterator<O000000o> it = O000000o().iterator();
            while (true) {
                if (!it.hasNext()) {
                    return false;
                }
                String[] strArr = it.next().f1358O000000o;
                if (strArr != null) {
                    for (String equals : strArr) {
                        if (equals.equals(str)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
    }

    public static ima O000000o(Context context) {
        if (!ikz.O000000o(context).O00000oO()) {
            return null;
        }
        return new ima() {
            /* class _m_j.ijc.AnonymousClass1 */

            public final void O000000o(String str, String str2, String str3) {
            }

            public final String O00000Oo(String str) {
                return null;
            }

            /* JADX WARNING: Removed duplicated region for block: B:17:0x004f A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
            public final String[][] O000000o(String str) {
                String[] strArr;
                String[][] strArr2 = null;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String host = Uri.parse(str).getHost();
                if (O000000o.O000000o(host)) {
                    if (!TextUtils.isEmpty(host)) {
                        Iterator<O000000o> it = O000000o.O000000o().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            O000000o next = it.next();
                            if (next.f1358O000000o != null && next.f1358O000000o[0].equals(host)) {
                                strArr = (String[]) Arrays.copyOfRange(next.f1358O000000o, 1, next.f1358O000000o.length);
                                break;
                            }
                        }
                        if (strArr != null) {
                            return null;
                        }
                        strArr2 = (String[][]) Array.newInstance(String.class, strArr.length + 1, 2);
                        strArr2[0] = new String[]{str, host};
                        for (int i = 1; i < strArr2.length; i++) {
                            int i2 = i - 1;
                            strArr2[i] = new String[]{str.replaceFirst(host, strArr[i2]), strArr[i2]};
                        }
                    }
                    strArr = null;
                    if (strArr != null) {
                    }
                }
                return strArr2;
            }
        };
    }
}
