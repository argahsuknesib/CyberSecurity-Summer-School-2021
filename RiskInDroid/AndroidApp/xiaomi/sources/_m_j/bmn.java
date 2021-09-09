package _m_j;

import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;

public class bmn {

    /* renamed from: O000000o  reason: collision with root package name */
    private static bmn f13103O000000o;
    private String[] O00000Oo = {"/dev/socket/qemud", "/dev/qemu_pipe"};
    private String[] O00000o = {"/sys/qemu_trace", "/system/bin/qemu-props"};
    private String[] O00000o0 = {"goldfish"};
    private String[] O00000oO = {"000000000000000"};
    private String[] O00000oo = {"310260000000000"};
    private String[] O0000O0o = {"15555215554", "15555215556", "15555215558", "15555215560", "15555215562", "15555215564", "15555215566", "15555215568", "15555215570", "15555215572", "15555215574", "15555215576", "15555215578", "15555215580", "15555215582", "15555215584"};

    private bmn() {
    }

    public static bmn O000000o() {
        if (f13103O000000o == null) {
            synchronized (bmn.class) {
                if (f13103O000000o == null) {
                    f13103O000000o = new bmn();
                }
            }
        }
        return f13103O000000o;
    }

    private boolean O00000o() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        try {
            File file = new File("/proc/tty/drivers");
            if (file.exists() && file.canRead()) {
                byte[] bArr = new byte[((int) file.length())];
                fileInputStream = null;
                try {
                    fileInputStream2 = new FileInputStream(file);
                    fileInputStream2.read(bArr);
                    String str = new String(bArr);
                    for (String indexOf : this.O00000o0) {
                        if (str.indexOf(indexOf) != -1) {
                            bne.O000000o((Closeable) fileInputStream2);
                            return true;
                        }
                    }
                    bne.O000000o((Closeable) fileInputStream2);
                } catch (Exception unused) {
                    bne.O000000o((Closeable) fileInputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = null;
                    bne.O000000o((Closeable) fileInputStream2);
                    throw th;
                }
            }
        } catch (Exception unused2) {
            fileInputStream = fileInputStream2;
            bne.O000000o((Closeable) fileInputStream);
        } catch (Throwable unused3) {
        }
        return false;
    }

    private boolean O00000o0() {
        int i = 0;
        while (i < this.O00000Oo.length) {
            try {
                if (new File(this.O00000Oo[i]).exists()) {
                    return true;
                }
                i++;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean O00000oO() {
        int i = 0;
        while (i < this.O00000o.length) {
            try {
                if (new File(this.O00000o[i]).exists()) {
                    return true;
                }
                i++;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean O00000oo() {
        try {
            String O00000Oo2 = bms.O000000o().O00000Oo();
            for (String equalsIgnoreCase : this.O00000oO) {
                if (equalsIgnoreCase.equalsIgnoreCase(O00000Oo2)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean O0000O0o() {
        try {
            return bms.O000000o().O00000o0().toLowerCase().equals("android");
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean O0000OOo() {
        return "unknown".equals(Build.BOARD) || "unknown".equals(Build.BOOTLOADER) || "generic".equals(Build.BRAND) || "generic".equals(Build.DEVICE) || "sdk".equals(Build.MODEL) || "sdk".equals(Build.PRODUCT) || "goldfish".equals(Build.HARDWARE);
    }

    public final String O00000Oo() {
        return String.format(Locale.CHINA, "%d%d%d%d%d%d%d", Integer.valueOf(O00000o0() ? 1 : 0), Integer.valueOf(O00000o() ? 1 : 0), Integer.valueOf(O00000oO() ? 1 : 0), 0, Integer.valueOf(O00000oo() ? 1 : 0), Integer.valueOf(O0000OOo() ? 1 : 0), Integer.valueOf(O0000O0o() ? 1 : 0));
    }
}
