package _m_j;

import android.text.TextUtils;
import android.util.Base64;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.util.EncryptUtilForSDK;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public final class ilo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f1447O000000o = "0123456789abcdef".toCharArray();
    private static String O00000Oo;
    private static String O00000o;
    private static String O00000o0;

    public static void O000000o(Map<String, String> map, final iiw<String> iiw, Track track) {
        StringBuilder sb = new StringBuilder();
        sb.append(track.f12166O000000o);
        map.put("track_id", sb.toString());
        map.put("device", "android");
        iit.O00000o(map, new iiw<ijt>() {
            /* class _m_j.ilo.AnonymousClass1 */

            public final /* synthetic */ void O000000o(Object obj) {
                ijt ijt = (ijt) obj;
                if (ijt == null) {
                    O000000o(603, "updateTrackForPlay return result be null");
                    return;
                }
                StringBuilder O000000o2 = ilo.O000000o(ijt);
                if (O000000o2 == null) {
                    O000000o(603, "updateTrackForPlay return result be null");
                } else {
                    iiw.O000000o(O000000o2.toString());
                }
            }

            public final void O000000o(int i, String str) {
                iiw.O000000o(i, str);
            }
        });
    }

    public static StringBuilder O000000o(ijt ijt) {
        HashMap hashMap = new HashMap();
        hashMap.put("file_id", ijt.O00000o);
        hashMap.put("ep", ijt.O00000oO);
        StringBuilder sb = new StringBuilder();
        sb.append(ijt.f1376O000000o);
        hashMap.put("duration", sb.toString());
        hashMap.put("api_version", ijt.O00000o0);
        String O000000o2 = O000000o(hashMap);
        if (TextUtils.isEmpty(O000000o2)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(O000000o2);
        if (!TextUtils.isEmpty(O000000o2) && ijt.O00000Oo > 0 && O000000o2.contains("preview")) {
            sb2.append("&totalLength=");
            sb2.append(ijt.O00000Oo);
        }
        sb2.append("&");
        sb2.append("is_charge");
        sb2.append("=true");
        return sb2;
    }

    public static String O000000o(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("track_id", String.valueOf(j));
        hashMap.put("device", "android");
        return O000000o(iit.O00000Oo(hashMap)).toString();
    }

    private static String O000000o(Map<String, String> map) {
        byte[] bArr;
        String str;
        String remove = map.remove("file_id");
        String remove2 = map.remove("ep");
        map.remove("sample_length");
        String remove3 = map.remove("duration");
        String remove4 = map.remove("api_version");
        if (TextUtils.isEmpty(remove)) {
            ilk.O000000o((Object) "getAntiLeechUrl specificParams fileId is null");
            return null;
        }
        try {
            bArr = EncryptUtilForSDK.O00000Oo().O000000o(Base64.decode(remove, 0));
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        try {
            str = new String(bArr, "UTF-8").trim();
        } catch (UnsupportedEncodingException unused) {
            if (TextUtils.isEmpty(remove)) {
                ilk.O000000o((Object) "getAntiLeechUrl specificParams fileId decode fail");
                return null;
            }
            str = "";
        }
        ilk.O000000o((Object) "encryptStr xxx result:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(remove2)) {
            ilk.O000000o((Object) "getAntiLeechUrl specificParams no ep");
            return null;
        }
        String O000000o2 = EncryptUtilForSDK.O00000Oo().O000000o(remove2);
        if (TextUtils.isEmpty(O000000o2)) {
            ilk.O000000o((Object) "getAntiLeechUrl specificParams ep decode fail");
            return null;
        }
        String trim = O000000o2.trim();
        if (TextUtils.isEmpty(trim)) {
            ilk.O000000o((Object) "getAntiLeechUrl specificParams ep decode fail");
            return null;
        }
        String[] split = trim.split("-");
        if (split.length != 4) {
            ilk.O000000o((Object) "getAntiLeechUrl specificParams ep decode fail length error deEp:".concat(String.valueOf(trim)));
            return null;
        }
        StringBuilder sb = new StringBuilder("http://");
        map.clear();
        sb.append("audio");
        map.put("sign", split[1]);
        sb.append(".pay.");
        map.put("buy_key", split[0]);
        sb.append("xmcdn.com/");
        map.put("token", split[2]);
        sb.append("download/");
        map.put("timestamp", split[3]);
        map.put("duration", remove3);
        String str2 = (sb.toString() + remove4 + "/" + str) + "?" + ijj.O000000o(ijj.O00000Oo(map));
        ilk.O000000o((Object) "encryptStr url:".concat(String.valueOf(str2)));
        return str2;
    }

    public static String O000000o() {
        if (TextUtils.isEmpty(O00000Oo)) {
            String str = iit.O000000o().O00000Oo;
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                char[] charArray = str.toCharArray();
                for (int i = 0; i < charArray.length / 2; i++) {
                    sb.append(f1447O000000o[((char) (charArray[i] ^ charArray[(charArray.length - 1) - i])) % 16]);
                }
                O00000Oo = sb.toString();
            }
        }
        return O00000Oo;
    }

    public static String O00000Oo() {
        String O000000o2;
        if (TextUtils.isEmpty(O00000o0) && (O000000o2 = O000000o()) != null) {
            O00000o0 = O000000o2.substring(0, O000000o2.length() / 2) + "0";
        }
        PrintStream printStream = System.out;
        printStream.println("PayUtil.getKey0   " + O00000o0);
        return O00000o0;
    }

    public static String O00000o0() {
        String O000000o2;
        if (TextUtils.isEmpty(O00000o) && (O000000o2 = O000000o()) != null) {
            O00000o = O000000o2.substring(O000000o2.length() / 2) + "1";
        }
        PrintStream printStream = System.out;
        printStream.println("PayUtil.getKey1   " + O00000o);
        return O00000o;
    }
}
