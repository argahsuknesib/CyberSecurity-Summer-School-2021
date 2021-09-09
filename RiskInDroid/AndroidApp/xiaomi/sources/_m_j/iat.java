package _m_j;

import com.xiaomi.verificationsdk.internal.UnknownValueException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public final class iat {
    public static boolean O000000o() throws UnknownValueException {
        String[] split;
        String O00000Oo = O00000Oo();
        if (O00000Oo != null) {
            String O000000o2 = O000000o("ps");
            if (O000000o2 != null && !O000000o2.isEmpty() && (split = O000000o2.split("\n")) != null && split.length > 0) {
                int i = 0;
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (split[i2].contains(O00000Oo)) {
                        int lastIndexOf = split[i2].lastIndexOf(" ");
                        if (new File(String.format("/data/data/%s", split[i2].substring(lastIndexOf <= 0 ? 0 : lastIndexOf + 1, split[i2].length()), Locale.CHINA)).exists()) {
                            i++;
                        }
                    }
                }
                if (i > 1) {
                    return true;
                }
            }
            return false;
        }
        throw new UnknownValueException("getUidStrFormat is null");
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:22:? */
    /* JADX INFO: additional move instructions added (4) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005f A[SYNTHETIC, Splitter:B:33:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0069 A[SYNTHETIC, Splitter:B:38:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x007c A[SYNTHETIC, Splitter:B:49:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0086 A[SYNTHETIC, Splitter:B:54:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0090  */
    private static String O000000o(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Process process;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream3 = null;
        try {
            process = Runtime.getRuntime().exec("sh");
            try {
                bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
            } catch (Exception unused) {
                bufferedInputStream2 = null;
                bufferedInputStream = bufferedInputStream2;
                bufferedOutputStream = bufferedInputStream2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream2 = null;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (bufferedInputStream3 != null) {
                    try {
                        bufferedInputStream3.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
            try {
                bufferedInputStream = new BufferedInputStream(process.getInputStream());
                try {
                    bufferedOutputStream.write(str.getBytes());
                    bufferedOutputStream.write(10);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    process.waitFor();
                    String O000000o2 = O000000o(bufferedInputStream);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return O000000o2;
                } catch (Exception unused2) {
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (process != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream3 = bufferedInputStream;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                    }
                    if (bufferedInputStream3 != null) {
                    }
                    if (process != null) {
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                bufferedInputStream = null;
                bufferedOutputStream = bufferedOutputStream;
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                }
                if (bufferedInputStream3 != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            process = null;
            bufferedInputStream2 = null;
            bufferedInputStream = bufferedInputStream2;
            bufferedOutputStream = bufferedInputStream2;
            if (bufferedOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (process != null) {
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
            bufferedOutputStream2 = null;
            if (bufferedOutputStream2 != null) {
            }
            if (bufferedInputStream3 != null) {
            }
            if (process != null) {
            }
            throw th;
        }
    }

    private static String O000000o(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (read >= 512);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0058 A[Catch:{ Exception -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071 A[RETURN] */
    private static String O00000Oo() {
        boolean z;
        String O000000o2 = O000000o("cat /proc/self/cgroup");
        if (!(O000000o2 == null || O000000o2.length() == 0)) {
            int lastIndexOf = O000000o2.lastIndexOf("uid");
            int lastIndexOf2 = O000000o2.lastIndexOf("/pid");
            if (lastIndexOf < 0) {
                return null;
            }
            if (lastIndexOf2 <= 0) {
                lastIndexOf2 = O000000o2.length();
            }
            try {
                String replaceAll = O000000o2.substring(lastIndexOf + 4, lastIndexOf2).replaceAll("\n", "");
                if (replaceAll != null) {
                    if (replaceAll.length() != 0) {
                        int i = 0;
                        while (i < replaceAll.length()) {
                            if (Character.isDigit(replaceAll.charAt(i))) {
                                i++;
                            }
                        }
                        z = true;
                        if (z) {
                            return null;
                        }
                        return String.format("u0_a%d", Integer.valueOf(Integer.valueOf(replaceAll).intValue() - 10000));
                    }
                }
                z = false;
                if (z) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
