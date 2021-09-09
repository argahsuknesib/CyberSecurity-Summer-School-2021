package _m_j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class dzh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Map<String, dzh> f15095O000000o = new HashMap();
    private static boolean O00000Oo = true;
    private static double O00000o = 0.0d;
    private static double O00000o0 = 0.0d;
    private double O00000oO;
    private double O00000oo;
    private double O0000O0o;
    private double O0000OOo;
    private double O0000Oo0;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060 A[SYNTHETIC, Splitter:B:16:0x0060] */
    public static String[] O000000o(int i) {
        BufferedReader bufferedReader;
        IOException e;
        String[] strArr = new String[3];
        File file = new File("/proc/" + i + "/stat");
        if (file.exists() && file.canRead()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split(" ");
                        strArr[0] = split[1];
                        strArr[1] = split[13];
                        strArr[2] = split[14];
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                    }
                    return strArr;
                }
            } catch (IOException e3) {
                IOException iOException = e3;
                bufferedReader = null;
                e = iOException;
                e.printStackTrace();
                if (bufferedReader != null) {
                }
                return strArr;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return strArr;
    }

    public dzh() {
        this.O00000oO = 0.0d;
        this.O00000oo = 0.0d;
        this.O0000O0o = 0.0d;
        this.O0000OOo = 0.0d;
        this.O0000Oo0 = 0.0d;
        this.O0000OOo = 0.0d;
        this.O00000oo = 0.0d;
        this.O0000Oo0 = 0.0d;
        this.O0000O0o = 0.0d;
    }
}
