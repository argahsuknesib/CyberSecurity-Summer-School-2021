package _m_j;

import com.alibaba.fastjson.JSON;
import java.util.List;

public final class ebz {
    public static String O000000o(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List O000000o(String str, Class cls) {
        try {
            return JSON.parseArray(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
