package _m_j;

import android.text.TextUtils;
import com.mi.util.Device;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class cbh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13588O000000o;
    private static caf O00000Oo;

    public static Map<String, String> O000000o(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (byl.O0000OoO()) {
            map.put("ot", "5");
        }
        map.put("compressed", "1");
        map.put("client_id", TextUtils.isEmpty(f13588O000000o) ? "180100031022" : f13588O000000o);
        map.put("display_density", String.valueOf(Device.O00000o));
        map.put("app_rdm", String.valueOf(System.currentTimeMillis()));
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        for (String add : map.keySet()) {
            arrayList.add(add);
        }
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (TextUtils.equals((CharSequence) arrayList.get(i), next)) {
                    if (!TextUtils.isEmpty(map.get(next))) {
                        stringBuffer.append(map.get(next));
                    }
                }
            }
        }
        caf caf = O00000Oo;
        stringBuffer.append((caf == null || TextUtils.isEmpty(caf.O00000Oo)) ? "appsign" : O00000Oo.O00000Oo);
        map.put("app_sign", cdy.O000000o(String.valueOf(stringBuffer)));
        return map;
    }

    public static String O000000o(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : map.entrySet()) {
                sb.append(URLEncoder.encode((String) next.getKey(), str));
                sb.append('=');
                String str2 = (String) next.getValue();
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(URLEncoder.encode(str2, str));
                sb.append('&');
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: ".concat(String.valueOf(str)), e);
        }
    }
}
