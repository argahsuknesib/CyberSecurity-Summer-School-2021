package _m_j;

import android.text.TextUtils;
import com.facebook.react.bridge.ReadableMap;

public final class bdc {
    public static boolean O000000o(Class cls, ReadableMap readableMap, String str) {
        if (!readableMap.hasKey(str) || readableMap.isNull(str)) {
            return false;
        }
        if (!String.class.equals(cls) || !TextUtils.isEmpty(readableMap.getString(str))) {
            return true;
        }
        return false;
    }
}
