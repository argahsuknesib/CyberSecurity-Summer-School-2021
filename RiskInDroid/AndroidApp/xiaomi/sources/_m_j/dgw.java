package _m_j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dgw {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f14622O000000o;
        public String O00000Oo;
        public Map<String, String[]> O00000o;
        public long O00000o0;
    }

    public interface O00000Oo {
        boolean O000000o(long j);

        boolean O000000o(long j, long j2, String str);

        boolean O000000o(String str, int i, String str2, String str3);
    }

    public static O000000o O000000o(String str, String str2) {
        if (!(str == null || str2 == null)) {
            O000000o o000000o = new O000000o();
            O000000o(str2, new O00000Oo(o000000o, true) {
                /* class _m_j.dgw.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                private /* synthetic */ O000000o f14620O000000o;
                private /* synthetic */ boolean O00000Oo = true;

                {
                    this.f14620O000000o = r1;
                }

                public final boolean O000000o(String str, int i, String str2, String str3) {
                    did.O00000o0("new thread %s", str);
                    if (this.f14620O000000o.f14622O000000o > 0 && this.f14620O000000o.O00000o0 > 0 && this.f14620O000000o.O00000Oo != null) {
                        if (this.f14620O000000o.O00000o == null) {
                            this.f14620O000000o.O00000o = new HashMap();
                        }
                        this.f14620O000000o.O00000o.put(str, new String[]{str2, str3, String.valueOf(i)});
                    }
                    return true;
                }

                public final boolean O000000o(long j, long j2, String str) {
                    did.O00000o0("new process %s", str);
                    O000000o o000000o = this.f14620O000000o;
                    o000000o.f14622O000000o = j;
                    o000000o.O00000Oo = str;
                    o000000o.O00000o0 = j2;
                    return this.O00000Oo;
                }

                public final boolean O000000o(long j) {
                    did.O00000o0("process end %d", Long.valueOf(j));
                    return this.f14620O000000o.f14622O000000o <= 0 || this.f14620O000000o.O00000o0 <= 0 || this.f14620O000000o.O00000Oo == null;
                }
            });
            if (o000000o.f14622O000000o <= 0 || o000000o.O00000o0 <= 0 || o000000o.O00000Oo == null) {
                return null;
            }
            return o000000o;
        }
        return null;
    }

    public static O000000o O000000o(String str) {
        if (str == null) {
            did.O00000oO("path:%s", str);
            return null;
        }
        O000000o o000000o = new O000000o();
        O000000o(str, new O00000Oo(o000000o, false) {
            /* class _m_j.dgw.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            private /* synthetic */ O000000o f14621O000000o;
            private /* synthetic */ boolean O00000Oo = false;

            {
                this.f14621O000000o = r1;
            }

            public final boolean O000000o(String str, int i, String str2, String str3) {
                did.O00000o0("new thread %s", str);
                if (this.f14621O000000o.O00000o == null) {
                    this.f14621O000000o.O00000o = new HashMap();
                }
                this.f14621O000000o.O00000o.put(str, new String[]{str2, str3, String.valueOf(i)});
                return true;
            }

            public final boolean O000000o(long j, long j2, String str) {
                did.O00000o0("new process %s", str);
                O000000o o000000o = this.f14621O000000o;
                o000000o.f14622O000000o = j;
                o000000o.O00000Oo = str;
                o000000o.O00000o0 = j2;
                return this.O00000Oo;
            }

            public final boolean O000000o(long j) {
                did.O00000o0("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (o000000o.f14622O000000o > 0 && o000000o.O00000o0 > 0 && o000000o.O00000Oo != null) {
            return o000000o;
        }
        did.O00000oO("first dump error %s", o000000o.f14622O000000o + " " + o000000o.O00000o0 + " " + o000000o.O00000Oo);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x017c A[Catch:{ all -> 0x0171 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a4 A[SYNTHETIC, Splitter:B:69:0x01a4] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01b6 A[SYNTHETIC, Splitter:B:77:0x01b6] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    private static void O000000o(String str, O00000Oo o00000Oo) {
        Throwable th;
        String str2 = str;
        O00000Oo o00000Oo2 = o00000Oo;
        if (str2 != null) {
            File file = new File(str2);
            if (file.exists()) {
                file.lastModified();
                file.length();
                BufferedReader bufferedReader = null;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    try {
                        Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                        Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                        Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                        Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                        while (true) {
                            Object[] O000000o2 = O000000o(bufferedReader2, compile);
                            if (O000000o2 != null) {
                                String[] split = O000000o2[1].toString().split("\\s");
                                long parseLong = Long.parseLong(split[2]);
                                long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                                Object[] O000000o3 = O000000o(bufferedReader2, compile3);
                                if (O000000o3 == null) {
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (IOException e) {
                                        IOException iOException = e;
                                        if (!did.O000000o(iOException)) {
                                            iOException.printStackTrace();
                                            return;
                                        }
                                        return;
                                    }
                                } else {
                                    Matcher matcher = compile3.matcher(O000000o3[1].toString());
                                    matcher.find();
                                    matcher.group(1);
                                    SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                                    if (!o00000Oo.O000000o(parseLong, time, matcher.group(1))) {
                                        try {
                                            bufferedReader2.close();
                                            return;
                                        } catch (IOException e2) {
                                            IOException iOException2 = e2;
                                            if (!did.O000000o(iOException2)) {
                                                iOException2.printStackTrace();
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        while (true) {
                                            Object[] O000000o4 = O000000o(bufferedReader2, compile4, compile2);
                                            if (O000000o4 == null) {
                                                break;
                                            } else if (O000000o4[0] == compile4) {
                                                String obj = O000000o4[1].toString();
                                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                                matcher2.find();
                                                String group = matcher2.group();
                                                String substring = group.substring(1, group.length() - 1);
                                                obj.contains("NATIVE");
                                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                                matcher3.find();
                                                String group2 = matcher3.group();
                                                o00000Oo2.O000000o(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), O000000o(bufferedReader2), O00000Oo(bufferedReader2));
                                            } else if (!o00000Oo2.O000000o(Long.parseLong(O000000o4[1].toString().split("\\s")[2]))) {
                                                try {
                                                    bufferedReader2.close();
                                                    return;
                                                } catch (IOException e3) {
                                                    IOException iOException3 = e3;
                                                    if (!did.O000000o(iOException3)) {
                                                        iOException3.printStackTrace();
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                        }
                                        simpleDateFormat = simpleDateFormat2;
                                    }
                                }
                            } else {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e4) {
                                    IOException iOException4 = e4;
                                    if (!did.O000000o(iOException4)) {
                                        iOException4.printStackTrace();
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        bufferedReader = bufferedReader2;
                        try {
                            if (!did.O000000o(e)) {
                                e.printStackTrace();
                            }
                            did.O00000o("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                            if (bufferedReader == null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e6) {
                                    IOException iOException5 = e6;
                                    if (!did.O000000o(iOException5)) {
                                        iOException5.printStackTrace();
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e7) {
                                    IOException iOException6 = e7;
                                    if (!did.O000000o(iOException6)) {
                                        iOException6.printStackTrace();
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedReader2 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                    if (!did.O000000o(e)) {
                    }
                    did.O00000o("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader == null) {
                    }
                }
            }
        }
    }

    private static Object[] O000000o(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            int length = patternArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Pattern pattern = patternArr[i];
                    if (pattern.matcher(readLine).matches()) {
                        return new Object[]{pattern, readLine};
                    }
                    i++;
                }
            }
        }
    }

    private static String O000000o(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    private static String O00000Oo(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.trim().length() > 0) {
                stringBuffer.append(readLine + "\n");
            }
        }
        return stringBuffer.toString();
    }
}
