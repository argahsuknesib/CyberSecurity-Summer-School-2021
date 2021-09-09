package _m_j;

import java.lang.reflect.InvocationTargetException;

public final class ejh {
    public static String O000000o(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return str2;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return str2;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return str2;
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return str2;
        }
    }
}
