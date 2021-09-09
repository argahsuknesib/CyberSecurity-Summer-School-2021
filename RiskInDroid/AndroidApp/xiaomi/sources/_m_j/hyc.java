package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class hyc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ConcurrentLinkedQueue<String> f968O000000o = new ConcurrentLinkedQueue<>();
    public static int O00000Oo = 100;
    private static final Map<String, ConcurrentLinkedQueue<String>> O00000oO = new ConcurrentHashMap();
    private int O00000o = 0;
    private hyf O00000o0;

    hyc(hyf hyf, int i) {
        this.O00000o0 = hyf;
        this.O00000o = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyf.O000000o(int, boolean):java.lang.String
     arg types: [int, int]
     candidates:
      _m_j.hyf.O000000o(java.lang.String, int):java.lang.String
      _m_j.hyf.O000000o(int, int):void
      _m_j.hyf.O000000o(android.content.Context, java.lang.String):boolean
      _m_j.hyf.O000000o(int, boolean):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public final String O000000o() {
        FileInputStream fileInputStream;
        int O000000o2 = this.O00000o0.O000000o(this.O00000o);
        if (O000000o2 < 0) {
            return null;
        }
        File file = new File(this.O00000o0.O000000o(this.O00000o, true));
        if (!file.canRead()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            if (O000000o2 > 0) {
                try {
                    fileInputStream.skip((long) O000000o2);
                } catch (Exception unused) {
                    gpg.O000000o(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    gpg.O000000o(fileInputStream);
                    throw th;
                }
            }
            byte[] bArr = new byte[1024];
            int i = this.O00000o0.O00000o;
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i2 = i;
                    for (int i3 = 0; i3 < read; i3++) {
                        if (bArr[i3] == 10) {
                            if (i2 == 1) {
                                this.O00000o0.O000000o(this.O00000o, O000000o2 + i3 + 1);
                                sb.append(new String(bArr, 0, i3));
                                String sb2 = sb.toString();
                                gpg.O000000o(fileInputStream);
                                return sb2;
                            }
                            i2--;
                            bArr[i3] = 44;
                        }
                    }
                    O000000o2 += read;
                    sb.append(new String(bArr, 0, read));
                    i = i2;
                } else {
                    this.O00000o0.O000000o(this.O00000o, -1);
                    sb.setLength(sb.length() - 1);
                    String replace = sb.toString().replace(9, '0');
                    gpg.O000000o(fileInputStream);
                    return replace;
                }
            }
        } catch (Exception unused2) {
            fileInputStream = null;
            gpg.O000000o(fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            gpg.O000000o(fileInputStream);
            throw th;
        }
    }

    public static LinkedList<String> O00000Oo() {
        if (f968O000000o.isEmpty()) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        while (!f968O000000o.isEmpty()) {
            String poll = f968O000000o.poll();
            if (poll != null) {
                linkedList.add(poll);
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyf.O000000o(int, boolean):java.lang.String
     arg types: [int, int]
     candidates:
      _m_j.hyf.O000000o(java.lang.String, int):java.lang.String
      _m_j.hyf.O000000o(int, int):void
      _m_j.hyf.O000000o(android.content.Context, java.lang.String):boolean
      _m_j.hyf.O000000o(int, boolean):java.lang.String */
    public final synchronized boolean O000000o(String str) {
        return O000000o(this.O00000o0.O000000o(this.O00000o, false), str);
    }

    public static boolean O000000o(final String str, String str2) {
        final ConcurrentLinkedQueue concurrentLinkedQueue = O00000oO.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            O00000oO.put(str, concurrentLinkedQueue);
        }
        concurrentLinkedQueue.offer(str2);
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.hyc.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException}
             arg types: [java.io.File, int]
             candidates:
              ClspMth{java.io.FileWriter.<init>(java.lang.String, boolean):void throws java.io.IOException}
              ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException} */
            /* JADX WARNING: Can't wrap try/catch for region: R(11:10|11|12|(1:14)|15|(5:19|(2:21|52)(1:51)|50|17|16)|22|23|40|41|42) */
            /* JADX WARNING: Can't wrap try/catch for region: R(5:28|43|44|45|46) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0091 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0096 */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x0091=Splitter:B:40:0x0091, B:45:0x0096=Splitter:B:45:0x0096} */
            public final void run() {
                int size;
                if (!concurrentLinkedQueue.isEmpty()) {
                    synchronized (concurrentLinkedQueue) {
                        if (!concurrentLinkedQueue.isEmpty()) {
                            File file = new File(str);
                            FileWriter fileWriter = null;
                            LinkedList linkedList = new LinkedList();
                            try {
                                if (!file.exists()) {
                                    file.createNewFile();
                                }
                                FileWriter fileWriter2 = new FileWriter(file, true);
                                while (!concurrentLinkedQueue.isEmpty()) {
                                    try {
                                        String str = (String) concurrentLinkedQueue.poll();
                                        if (str != null) {
                                            fileWriter2.append((CharSequence) str);
                                            fileWriter2.append(10);
                                            linkedList.offer(str);
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        fileWriter = fileWriter2;
                                        try {
                                            e.printStackTrace();
                                            size = hyc.f968O000000o.size() + linkedList.size();
                                            while (true) {
                                                int i = size - 1;
                                                if (size <= hyc.O00000Oo) {
                                                    break;
                                                }
                                                break;
                                                hyc.f968O000000o.poll();
                                                size = i;
                                            }
                                            hyc.f968O000000o.addAll(linkedList);
                                            hye.O000000o("STAT-ERR-FILE", e.getMessage());
                                            fileWriter.close();
                                        } catch (Throwable th) {
                                            th = th;
                                            fileWriter.close();
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileWriter = fileWriter2;
                                        fileWriter.close();
                                        throw th;
                                    }
                                }
                                fileWriter2.close();
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                size = hyc.f968O000000o.size() + linkedList.size();
                                while (true) {
                                    int i2 = size - 1;
                                    if (size <= hyc.O00000Oo || hyc.f968O000000o.isEmpty()) {
                                        hyc.f968O000000o.addAll(linkedList);
                                        hye.O000000o("STAT-ERR-FILE", e.getMessage());
                                    } else {
                                        hyc.f968O000000o.poll();
                                        size = i2;
                                    }
                                }
                                hyc.f968O000000o.addAll(linkedList);
                                hye.O000000o("STAT-ERR-FILE", e.getMessage());
                                fileWriter.close();
                            }
                        }
                    }
                }
            }
        });
        return true;
    }
}
