package _m_j;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public final class iml {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f1476O000000o = false;
    public static int O00000Oo = 30;
    public static String O00000o = (O00000o0 + "/player_caching");
    public static String O00000o0 = (Environment.getExternalStorageDirectory().getPath() + "/ting");
    public static String O00000oO = (O00000o + "/audio");
    public static String O00000oo = "playcache.info";
    public static String O0000O0o = (O00000oO + File.separator + O00000oo);

    public static void O000000o(Context context) {
        if (context != null && context.getExternalFilesDir("") != null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getExternalFilesDir(""));
                O00000o0 = sb.toString();
                O00000o = O00000o0 + "/player_caching";
                O00000oO = O00000o + "/audio";
                O0000O0o = O00000oO + File.separator + O00000oo;
                new File(O00000oO).mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
