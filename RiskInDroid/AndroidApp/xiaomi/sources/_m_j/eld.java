package _m_j;

import java.io.File;
import java.util.HashMap;

public final class eld {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final HashMap<String, String> f15605O000000o;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f15605O000000o = hashMap;
        hashMap.put("FFD8FF", "jpg");
        f15605O000000o.put("89504E47", "png");
        f15605O000000o.put("47494638", "gif");
        f15605O000000o.put("474946", "gif");
        f15605O000000o.put("424D", "bmp");
    }

    public static long O000000o(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? O000000o(listFiles[i]) : listFiles[i].length();
            }
        } catch (Exception e) {
            duv.O000000o(e);
        }
        return j;
    }
}
