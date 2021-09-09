package _m_j;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public final class eug {
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:19:? */
    /* JADX INFO: additional move instructions added (4) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:5|6|7|8|9|10|11|12|(1:15)|16) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055 A[SYNTHETIC, Splitter:B:30:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005c A[SYNTHETIC, Splitter:B:34:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006c A[SYNTHETIC, Splitter:B:44:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0073 A[SYNTHETIC, Splitter:B:48:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007a  */
    public static String O000000o(String str) {
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
                }
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream2 = null;
                if (bufferedOutputStream2 != null) {
                }
                if (bufferedInputStream3 != null) {
                }
                if (process != null) {
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
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
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
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused5) {
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused6) {
                }
            }
            if (process != null) {
                process.destroy();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
            bufferedOutputStream2 = null;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException unused7) {
                }
            }
            if (bufferedInputStream3 != null) {
                try {
                    bufferedInputStream3.close();
                } catch (IOException unused8) {
                }
            }
            if (process != null) {
                process.destroy();
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
            } catch (Exception unused) {
            }
        } while (read >= 512);
        return sb.toString();
    }
}
