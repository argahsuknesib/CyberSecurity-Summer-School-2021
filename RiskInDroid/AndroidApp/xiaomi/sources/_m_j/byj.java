package _m_j;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public final class byj extends bye {
    public File O0000oOO;
    public String O0000oOo;

    byj() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0168 A[SYNTHETIC, Splitter:B:64:0x0168] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0177 A[SYNTHETIC, Splitter:B:72:0x0177] */
    public static byj O000000o(File file) {
        BufferedReader bufferedReader;
        Throwable th;
        byj byj = new byj();
        byj.O0000oOO = file;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.startsWith("cpu_core")) {
                        byj.O00000oO = Integer.valueOf(readLine.split(" = ")[1]).intValue();
                    } else if (readLine.startsWith("time_start")) {
                        byj.O0000OoO = readLine.split(" = ")[1];
                    } else if (readLine.startsWith("time_end")) {
                        byj.O0000Ooo = readLine.split(" = ")[1];
                    } else if (readLine.startsWith("time")) {
                        byj.O0000Oo0 = Long.valueOf(readLine.split(" = ")[1]).longValue();
                    } else if (readLine.startsWith("thread_time")) {
                        byj.O0000Oo = Long.valueOf(readLine.split(" = ")[1]).longValue();
                    } else if (readLine.startsWith("totalMemory")) {
                        byj.O0000O0o = readLine.split(" = ")[1];
                    } else if (readLine.startsWith("freeMemory")) {
                        byj.O00000oo = readLine.split(" = ")[1];
                    } else if (readLine.startsWith("cpu_busy")) {
                        byj.O0000o00 = Boolean.valueOf(readLine.split(" = ")[1]).booleanValue();
                    } else if (readLine.startsWith("cpu_rate")) {
                        String[] split = readLine.split(" = ");
                        if (split.length > 1) {
                            StringBuilder sb = new StringBuilder(split[1]);
                            sb.append(readLine.split(" = ")[1]);
                            sb.append("\r\n");
                            String readLine2 = bufferedReader.readLine();
                            while (readLine2 != null && !readLine2.equals("")) {
                                sb.append(readLine2);
                                sb.append("\r\n");
                                readLine2 = bufferedReader.readLine();
                            }
                            byj.O0000o0 = sb.toString();
                        }
                    } else if (readLine.startsWith("stack")) {
                        StringBuilder sb2 = new StringBuilder(readLine.split(" = ")[1]);
                        for (String readLine3 = bufferedReader.readLine(); readLine3 != null; readLine3 = bufferedReader.readLine()) {
                            if (!readLine3.equals("")) {
                                sb2.append(readLine3);
                                sb2.append("\r\n");
                            } else if (sb2.length() > 0) {
                                byj.O0000o0O.add(sb2.toString());
                                sb2 = new StringBuilder();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        Log.e("BlockInfoEx", "newInstance: ", th);
                        if (bufferedReader != null) {
                        }
                        byj.O00000Oo();
                        return byj;
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
            }
            bufferedReader.close();
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    Log.e("BlockInfoEx", "newInstance: ", e);
                }
            }
            throw th;
        }
        byj.O00000Oo();
        return byj;
    }
}
