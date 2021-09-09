package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Calendar;

public final class sc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static SharedPreferences f2450O000000o = null;
    private static int O00000Oo = -1;
    private static int O00000o = -1;
    private static int O00000o0 = -1;
    private static int O00000oO = -1;
    private static int O00000oo = -1;
    private static int O0000O0o = -1;
    private static long O0000OOo = -1;

    @SuppressLint({"NewApi"})
    public static void O000000o(Context context, int i) {
        try {
            O0000O0o(context);
            int i2 = Calendar.getInstance().get(6);
            om.O00000Oo("@_18_8_@", "@_18_8_2_@(" + i2 + "," + i + ")");
            O00000Oo = i2;
            O00000o0 = O00000o0 + i;
            SharedPreferences.Editor edit = f2450O000000o.edit();
            edit.putInt("last_upload_time", O00000Oo);
            edit.putInt("uploaded_count", O00000o0);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean O000000o(Context context) {
        try {
            O0000O0o(context);
            if (O00000Oo == -1) {
                O00000Oo = f2450O000000o.getInt("last_upload_time", 0);
            }
            if (O00000o0 == -1) {
                O00000o0 = f2450O000000o.getInt("uploaded_count", 0);
            }
            int i = Calendar.getInstance().get(6);
            om.O00000Oo("@_18_8_@", "@_18_8_1_@(" + O00000Oo + "," + i + "," + O00000o0 + ")");
            if (i == O00000Oo) {
                return O00000o0 < 500;
            }
            O00000o0 = 0;
            SharedPreferences.Editor edit = f2450O000000o.edit();
            edit.putInt("uploaded_count", O00000o0);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean O000000o(Context context, long j) {
        try {
            O0000O0o(context);
            if (O0000OOo == -1) {
                O0000OOo = f2450O000000o.getLong("config_time", 0);
            }
            boolean z = O0000OOo != j;
            if (z) {
                O0000OOo = j;
                SharedPreferences.Editor edit = f2450O000000o.edit();
                edit.putLong("config_time", O0000OOo);
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            }
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int O00000Oo(Context context) {
        try {
            O0000O0o(context);
            if (O00000o0 == -1) {
                O00000o0 = f2450O000000o.getInt("uploaded_count", 0);
            }
            return Math.max(0, 500 - O00000o0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean O00000Oo(Context context, int i) {
        try {
            O0000O0o(context);
            if (((long) O00000oO) == -1) {
                O00000oO = f2450O000000o.getInt("last_download_time", 0);
            }
            int i2 = Calendar.getInstance().get(6);
            om.O00000Oo("@_18_8_@", "@_18_8_3_@(" + O00000oO + "," + i2 + ")");
            if (i2 != O00000oO) {
                O00000oO = i2;
                O00000oo = 0;
                O0000O0o = 0;
                SharedPreferences.Editor edit = f2450O000000o.edit();
                edit.putInt("last_download_time", O00000oO);
                edit.putInt("downloaded_count", O00000oo);
                edit.putInt("nonwifi_downloaded_count", O0000O0o);
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
                return true;
            }
            if (O00000oo == -1) {
                O00000oo = f2450O000000o.getInt("downloaded_count", 0);
            }
            om.O00000Oo("@_18_8_@", "@_18_8_4_@" + O00000oo);
            return O00000oo < i;
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void O00000o(Context context) {
        try {
            O0000O0o(context);
            O00000o = 1;
            SharedPreferences.Editor edit = f2450O000000o.edit();
            edit.putInt("first_downloaded", O00000o);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean O00000o0(Context context) {
        try {
            O0000O0o(context);
            if (O00000o == -1) {
                O00000o = f2450O000000o.getInt("first_downloaded", 0);
            }
            return O00000o == 1;
        } catch (Throwable unused) {
            return true;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean O00000o0(Context context, int i) {
        try {
            O0000O0o(context);
            if (((long) O00000oO) == -1) {
                O00000oO = f2450O000000o.getInt("last_download_time", 0);
            }
            int i2 = Calendar.getInstance().get(6);
            om.O00000Oo("@_18_8_@", "@_18_8_3_@(" + O00000oO + "," + i2 + ")");
            if (i2 != O00000oO) {
                O00000oO = i2;
                O00000oo = 0;
                O0000O0o = 0;
                SharedPreferences.Editor edit = f2450O000000o.edit();
                edit.putInt("last_download_time", O00000oO);
                edit.putInt("downloaded_count", O00000oo);
                edit.putInt("nonwifi_downloaded_count", O0000O0o);
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
                return true;
            }
            if (O0000O0o == -1) {
                O0000O0o = f2450O000000o.getInt("nonwifi_downloaded_count", 0);
            }
            om.O00000Oo("@_18_8_@", "@_18_8_5_@" + O0000O0o);
            return O0000O0o < i;
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void O00000oO(Context context) {
        try {
            O0000O0o(context);
            if (O00000oo == -1) {
                O00000oo = f2450O000000o.getInt("downloaded_count", 0);
            }
            O00000oo++;
            SharedPreferences.Editor edit = f2450O000000o.edit();
            edit.putInt("downloaded_count", O00000oo);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void O00000oo(Context context) {
        try {
            O0000O0o(context);
            if (O0000O0o == -1) {
                O0000O0o = f2450O000000o.getInt("nonwifi_downloaded_count", 0);
            }
            O0000O0o++;
            SharedPreferences.Editor edit = f2450O000000o.edit();
            edit.putInt("nonwifi_downloaded_count", O0000O0o);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private static void O0000O0o(Context context) {
        if (f2450O000000o == null) {
            f2450O000000o = context.getSharedPreferences("location_offline", 0);
        }
    }
}
