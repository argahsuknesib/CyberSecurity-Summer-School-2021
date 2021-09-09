package _m_j;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public final class iiy {
    public static Request.Builder O000000o(String str, Map<String, String> map) throws XimalayaException {
        if (iio.f1319O000000o || !TextUtils.isEmpty(str)) {
            if (map != null && !map.isEmpty()) {
                str = str + "?" + ijj.O000000o(ijj.O00000Oo(map));
            }
            ilk.O00000Oo("url123", str);
            try {
                return new Request.Builder().url(str);
            } catch (Exception e) {
                e.printStackTrace();
                throw new XimalayaException(1012, e.getMessage());
            }
        } else {
            throw XimalayaException.getExceptionByCode(1001);
        }
    }

    public static Request.Builder O000000o(String str, Map<String, String> map, String str2) throws XimalayaException {
        if (iio.f1319O000000o || !TextUtils.isEmpty(str)) {
            String O000000o2 = iji.O000000o(str2, map);
            if (!TextUtils.isEmpty(O000000o2)) {
                map.put("sig", O000000o2);
                return O000000o(str, map);
            }
            throw XimalayaException.getExceptionByCode(1002);
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Request.Builder O00000Oo(String str, Map<String, String> map, String str2) throws XimalayaException {
        if (iio.f1319O000000o || !TextUtils.isEmpty(str)) {
            String O000000o2 = iji.O000000o(str2, map);
            if (!TextUtils.isEmpty(O000000o2)) {
                map.put("sig", O000000o2);
                return O00000Oo(str, map);
            }
            throw XimalayaException.getExceptionByCode(1002);
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Request.Builder O00000Oo(String str, Map<String, String> map) throws XimalayaException {
        if (iio.f1319O000000o || !TextUtils.isEmpty(str)) {
            FormBody.Builder builder = new FormBody.Builder();
            if (map == null || map.size() <= 0) {
                throw XimalayaException.getExceptionByCode(1003);
            }
            for (Map.Entry next : map.entrySet()) {
                if (next.getValue() != null) {
                    builder.add((String) next.getKey(), (String) next.getValue());
                }
            }
            return new Request.Builder().url(str).post(builder.build());
        }
        throw XimalayaException.getExceptionByCode(1001);
    }

    public static Request.Builder O000000o(String str, String str2) throws XimalayaException {
        if (iio.f1319O000000o || !TextUtils.isEmpty(str)) {
            return new Request.Builder().url(str).post(RequestBody.create((MediaType) null, str2));
        }
        throw XimalayaException.getExceptionByCode(1001);
    }
}
