package _m_j;

import android.content.Context;
import android.os.FileObserver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class jrn {
    private static final jrn O0000o = new jrn();

    /* renamed from: O000000o  reason: collision with root package name */
    final Date f2102O000000o = new Date();
    public Context O00000Oo;
    public String O00000o;
    public int O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public boolean O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;
    public int O0000OoO;
    public boolean O0000Ooo;
    public jrq O0000o0;
    public boolean O0000o00;
    long O0000o0O = 0;
    public FileObserver O0000o0o = null;
    private final Pattern O0000oO = Pattern.compile("^Cmd\\sline:\\s+(.*)$");
    private final Pattern O0000oO0 = Pattern.compile("^-----\\spid\\s(\\d+)\\sat\\s(.*)\\s-----$");
    private final long O0000oOO = 15000;

    private jrn() {
    }

    public static jrn O000000o() {
        return O0000o;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bd A[SYNTHETIC, Splitter:B:48:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c4 A[SYNTHETIC, Splitter:B:56:0x00c4] */
    public final String O000000o(String str, long j) {
        BufferedReader bufferedReader;
        Date parse;
        String group;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            boolean z = false;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (z || !readLine.startsWith("----- pid ")) {
                            if (z) {
                                if (readLine.startsWith("----- end ")) {
                                    break;
                                }
                                sb.append(readLine);
                                sb.append(10);
                            } else {
                                continue;
                            }
                        } else {
                            Matcher matcher = this.O0000oO0.matcher(readLine);
                            if (matcher.find() && matcher.groupCount() == 2) {
                                String group2 = matcher.group(1);
                                String group3 = matcher.group(2);
                                if (!(group2 == null || group3 == null || this.O00000o0 != Integer.parseInt(group2) || (parse = simpleDateFormat.parse(group3)) == null || Math.abs(parse.getTime() - j) > 15000)) {
                                    String readLine2 = bufferedReader.readLine();
                                    if (readLine2 == null) {
                                        break;
                                    }
                                    Matcher matcher2 = this.O0000oO.matcher(readLine2);
                                    if (matcher2.find() && matcher2.groupCount() == 1 && (group = matcher2.group(1)) != null && group.equals(this.O00000o)) {
                                        sb.append(readLine2);
                                        sb.append(10);
                                        sb.append("Mode: Watching /data/anr/*\n");
                                        z = true;
                                    }
                                }
                            }
                        }
                    } else {
                        break;
                    }
                } catch (Exception unused) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception unused4) {
            }
            return sb2;
        } catch (Exception unused5) {
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }
}
