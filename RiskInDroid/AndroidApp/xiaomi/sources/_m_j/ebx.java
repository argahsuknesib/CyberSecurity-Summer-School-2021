package _m_j;

import java.io.File;

public final class ebx {
    public static void O000000o(File file) {
        if (file != null) {
            try {
                if (file.isFile()) {
                    file.delete();
                } else if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        if (listFiles.length != 0) {
                            for (File O000000o2 : listFiles) {
                                O000000o(O000000o2);
                            }
                            file.delete();
                            return;
                        }
                    }
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean O000000o(String str) {
        try {
            File file = new File(str.toString());
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
