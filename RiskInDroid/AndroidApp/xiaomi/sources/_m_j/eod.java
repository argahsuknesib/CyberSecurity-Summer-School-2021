package _m_j;

import android.annotation.SuppressLint;
import android.os.Build;
import com.xiaomi.push.service.bo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class eod {
    static String O00000Oo = "/MiPushLog";
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: O000000o  reason: collision with root package name */
    final SimpleDateFormat f15668O000000o = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String O00000o;
    String O00000o0;
    int O00000oO = 2097152;
    private boolean O00000oo;
    private int O0000O0o;
    private ArrayList<File> O0000OOo = new ArrayList<>();

    eod() {
    }

    private void O000000o(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= read || !matcher.find(i)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.O00000o0.length() + start);
                if (this.O00000oo) {
                    if (substring.compareTo(this.O00000o) > 0) {
                        read = start;
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.O00000o0) >= 0) {
                    this.O00000oo = true;
                    i2 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.O00000o0.length();
                }
                i = start + indexOf;
            }
            if (this.O00000oo) {
                int i3 = read - i2;
                this.O0000O0o += i3;
                if (z) {
                    bufferedWriter.write(cArr, i2, i3);
                    return;
                }
                bufferedWriter.write(cArr, i2, i3);
                if (this.O0000O0o > this.O00000oO) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final eod O000000o(File file) {
        if (file.exists()) {
            this.O0000OOo.add(file);
        }
        return this;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:35:0x00d7 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:29:0x00bb */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: java.io.BufferedWriter} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x00d7=Splitter:B:35:0x00d7, B:29:0x00bb=Splitter:B:29:0x00bb} */
    public final void O00000Oo(File file) {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        BufferedWriter bufferedWriter3;
        BufferedWriter bufferedWriter4;
        BufferedWriter bufferedWriter5;
        BufferedWriter bufferedWriter6;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedWriter bufferedWriter7 = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                bufferedWriter.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + bo.m191a() + "; lng :" + Locale.getDefault().toString() + "; sdk :47" + "; andver :" + Build.VERSION.SDK_INT + "\n");
                this.O0000O0o = 0;
                Iterator<File> it = this.O0000OOo.iterator();
                while (it.hasNext()) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                    try {
                        O000000o(bufferedReader, bufferedWriter, compile);
                        bufferedReader.close();
                        bufferedWriter7 = bufferedReader;
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedWriter5 = bufferedReader;
                        bufferedWriter7 = bufferedWriter;
                        bufferedWriter4 = bufferedWriter5;
                        duv.O00000o0("LOG: filter error = " + e.getMessage());
                        ele.O000000o(bufferedWriter7);
                        ele.O000000o(bufferedWriter3);
                    } catch (IOException e2) {
                        e = e2;
                        bufferedWriter6 = bufferedReader;
                        bufferedWriter7 = bufferedWriter;
                        bufferedWriter3 = bufferedWriter6;
                        try {
                            duv.O00000o0("LOG: filter error = " + e.getMessage());
                            ele.O000000o(bufferedWriter7);
                            ele.O000000o(bufferedWriter3);
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter7;
                            bufferedWriter2 = bufferedWriter3;
                            bufferedWriter7 = bufferedWriter2;
                            ele.O000000o(bufferedWriter);
                            ele.O000000o(bufferedWriter7);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter2 = bufferedReader;
                        bufferedWriter7 = bufferedWriter2;
                        ele.O000000o(bufferedWriter);
                        ele.O000000o(bufferedWriter7);
                        throw th;
                    }
                }
                bufferedWriter.write(enp.a().c());
                ele.O000000o(bufferedWriter);
                ele.O000000o(bufferedWriter7);
            } catch (FileNotFoundException e3) {
                e = e3;
                bufferedWriter5 = bufferedWriter7;
                bufferedWriter7 = bufferedWriter;
                bufferedWriter4 = bufferedWriter5;
                duv.O00000o0("LOG: filter error = " + e.getMessage());
                ele.O000000o(bufferedWriter7);
                ele.O000000o(bufferedWriter3);
            } catch (IOException e4) {
                e = e4;
                bufferedWriter6 = bufferedWriter7;
                bufferedWriter7 = bufferedWriter;
                bufferedWriter3 = bufferedWriter6;
                duv.O00000o0("LOG: filter error = " + e.getMessage());
                ele.O000000o(bufferedWriter7);
                ele.O000000o(bufferedWriter3);
            } catch (Throwable th3) {
                th = th3;
                ele.O000000o(bufferedWriter);
                ele.O000000o(bufferedWriter7);
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            bufferedWriter4 = null;
            duv.O00000o0("LOG: filter error = " + e.getMessage());
            ele.O000000o(bufferedWriter7);
            ele.O000000o(bufferedWriter3);
        } catch (IOException e6) {
            e = e6;
            bufferedWriter3 = null;
            duv.O00000o0("LOG: filter error = " + e.getMessage());
            ele.O000000o(bufferedWriter7);
            ele.O000000o(bufferedWriter3);
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = null;
            ele.O000000o(bufferedWriter);
            ele.O000000o(bufferedWriter7);
            throw th;
        }
    }
}
