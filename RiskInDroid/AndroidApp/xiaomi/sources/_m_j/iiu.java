package _m_j;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequestForMain$1;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class iiu {
    public static void O000000o() {
        ilk.O000000o((Object) "encryptStr 1");
        if (ilg.O000000o()) {
            try {
                ill.O000000o(iiz.O00000Oo(), "getLocalUserInfo", null, null);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static <T> boolean O000000o(Map<String, String> map, iiw<T> iiw, String str) {
        Class O00000Oo = iiz.O00000Oo();
        if (O00000Oo == null) {
            return false;
        }
        try {
            ill.O000000o(O00000Oo, str, new Object[]{map, iiw}, new Class[]{Map.class, iiw.class});
            ilk.O000000o((Object) "encryptStr 1");
        } catch (Exception e) {
            iiw.O000000o(603, "func " + str + " invoke fail");
            ilk.O000000o((Object) "encryptStr 2".concat(String.valueOf(e)));
        }
        return true;
    }

    public static <T> boolean O000000o(Map<String, String> map, iiw<T> iiw, Track track, String str) {
        Class O00000Oo = iiz.O00000Oo();
        if (O00000Oo == null) {
            return false;
        }
        try {
            ill.O000000o(O00000Oo, str, new Object[]{map, iiw, track}, new Class[]{Map.class, iiw.class, Track.class});
            ilk.O000000o((Object) "encryptStr 1");
        } catch (Exception e) {
            iiw.O000000o(603, "func " + str + " invoke fail");
            ilk.O000000o((Object) "encryptStr 2".concat(String.valueOf(e)));
        }
        return true;
    }

    public static String O000000o(Track track) {
        Class O00000Oo = iiz.O00000Oo();
        Object obj = null;
        if (O00000Oo == null) {
            return null;
        }
        try {
            obj = ill.O000000o(O00000Oo, "getChargeDownloadUrl", new Object[]{new HashMap(), track}, new Class[]{Map.class, Track.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return (String) obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    public static String O00000Oo() {
        Object obj;
        Class O00000Oo = iiz.O00000Oo();
        Object obj2 = null;
        if (O00000Oo == null) {
            return null;
        }
        try {
            obj = ill.O000000o(O00000Oo, "getInstanse", null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            obj = null;
            if (obj != null) {
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            obj = null;
            if (obj != null) {
            }
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            obj = null;
            if (obj != null) {
            }
        }
        if (obj != null) {
            return null;
        }
        try {
            Class<?>[] O000000o2 = ilg.O000000o((Class<?>[]) null);
            Object[] O000000o3 = ilg.O000000o((Object[]) null);
            Method method = obj.getClass().getMethod("getUserAgent", O000000o2);
            if (method != null) {
                obj2 = method.invoke(obj, O000000o3);
                return (String) obj2;
            }
            throw new NoSuchMethodException("No such accessible method: " + "getUserAgent" + "() on object: " + obj.getClass().getName());
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d A[RETURN] */
    public static String[][] O000000o(String str) {
        Object obj;
        try {
            try {
                obj = ill.O000000o(Class.forName("com.sina.util.dnscache.DNSCache"), "getStaticDomainServerIp", new Object[]{str}, new Class[]{String.class});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                obj = null;
                if (obj != null) {
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                obj = null;
                if (obj != null) {
                }
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                obj = null;
                if (obj != null) {
                }
            }
            if (obj != null) {
                return null;
            }
            String str2 = (String) obj;
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String[] split = str2.split("__&__");
            String[][] strArr = (String[][]) Array.newInstance(String.class, split.length + 1, 2);
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    String[] split2 = split[i].split("__#__");
                    strArr[i] = split2;
                    ilk.O000000o((Object) ("getStaticDomainServerIp ipsAndHostStrArr:" + Arrays.toString(split2)));
                }
            }
            strArr[split.length][0] = str;
            return strArr;
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static Track O000000o(long j) {
        Class O00000Oo = iiz.O00000Oo();
        Object obj = null;
        if (O00000Oo == null) {
            return null;
        }
        try {
            obj = ill.O000000o(O00000Oo, "getTrackInfoDetailSync", new Object[]{new CommonRequestForMain$1(j)}, new Class[]{Map.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return (Track) obj;
    }
}
