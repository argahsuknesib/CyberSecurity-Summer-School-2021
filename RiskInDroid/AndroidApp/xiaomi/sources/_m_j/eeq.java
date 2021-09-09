package _m_j;

import java.io.File;

public final class eeq {
    public static boolean O000000o() {
        File[] listFiles;
        try {
            if (ecd.O000000o(eck.O0000O0o)) {
                return false;
            }
            File file = new File(eck.O0000O0o);
            return file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File[] O00000Oo() {
        File[] listFiles;
        try {
            File file = new File(eck.O0000O0o);
            if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                return null;
            }
            return listFiles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
