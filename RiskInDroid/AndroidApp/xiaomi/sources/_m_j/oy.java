package _m_j;

import java.io.File;
import java.io.FileWriter;

public final class oy {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileWriter.<init>(java.lang.String, boolean):void throws java.io.IOException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException}
      ClspMth{java.io.FileWriter.<init>(java.lang.String, boolean):void throws java.io.IOException} */
    public static boolean O000000o(String str, File file) {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file.getAbsolutePath(), true);
            try {
                fileWriter2.write(str);
                pd.O000000o(fileWriter2);
                return true;
            } catch (Exception e) {
                e = e;
                fileWriter = fileWriter2;
                try {
                    e.printStackTrace();
                    pd.O000000o(fileWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    pd.O000000o(fileWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileWriter = fileWriter2;
                pd.O000000o(fileWriter);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            pd.O000000o(fileWriter);
            return false;
        }
    }
}
