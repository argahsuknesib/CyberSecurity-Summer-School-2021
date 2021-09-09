package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.ele;
import _m_j.eli;
import _m_j.elo;
import _m_j.emi;
import _m_j.eml;
import _m_j.ert;
import _m_j.eru;
import _m_j.esq;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ht;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class bt {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f6536a = new Object();

    public static byte[] a(Context context) {
        String O00000Oo = esq.O000000o(context).O00000Oo("mipush", "td_key", "");
        if (TextUtils.isEmpty(O00000Oo)) {
            O00000Oo = eml.O000000o(20);
            esq.O000000o(context).O000000o("mipush", "td_key", O00000Oo);
        }
        return a(O00000Oo);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(emi.O00000Oo(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    public static void a(Context context, ht htVar) {
        if (bs.a(htVar.g)) {
            elo.O000000o(context).O000000o(new bu(context, htVar), 0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x00a1=Splitter:B:34:0x00a1, B:40:0x00bd=Splitter:B:40:0x00bd} */
    public static void c(Context context, ht htVar) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        try {
            byte[] O00000Oo = ert.O00000Oo(a(context), eru.O000000o(htVar));
            if (O00000Oo != null) {
                if (O00000Oo.length > 0) {
                    if (O00000Oo.length > 10240) {
                        duv.O000000o("TinyData write to cache file failed case too much data content item:" + htVar.f + "  ts:" + System.currentTimeMillis());
                        ele.O000000o((Closeable) null);
                        ele.O000000o((Closeable) null);
                        return;
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(eli.O000000o(O00000Oo.length));
                        bufferedOutputStream3.write(O00000Oo);
                        bufferedOutputStream3.flush();
                        ele.O000000o((Closeable) null);
                        ele.O000000o(bufferedOutputStream3);
                        return;
                    } catch (IOException e) {
                        IOException iOException = e;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = iOException;
                        duv.O000000o("TinyData write to cache file failed cause io exception item:" + htVar.f, e);
                        ele.O000000o((Closeable) null);
                        ele.O000000o(bufferedOutputStream);
                    } catch (Exception e2) {
                        Exception exc = e2;
                        bufferedOutputStream = bufferedOutputStream3;
                        e = exc;
                        try {
                            duv.O000000o("TinyData write to cache file  failed item:" + htVar.f, e);
                            ele.O000000o((Closeable) null);
                            ele.O000000o(bufferedOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            ele.O000000o((Closeable) null);
                            ele.O000000o(bufferedOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        bufferedOutputStream = bufferedOutputStream3;
                        th = th2;
                        ele.O000000o((Closeable) null);
                        ele.O000000o(bufferedOutputStream);
                        throw th;
                    }
                }
            }
            duv.O000000o("TinyData write to cache file failed case encryption fail item:" + htVar.f + "  ts:" + System.currentTimeMillis());
            ele.O000000o((Closeable) null);
            ele.O000000o((Closeable) null);
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream2 = null;
            duv.O000000o("TinyData write to cache file failed cause io exception item:" + htVar.f, e);
            ele.O000000o((Closeable) null);
            ele.O000000o(bufferedOutputStream);
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream = null;
            duv.O000000o("TinyData write to cache file  failed item:" + htVar.f, e);
            ele.O000000o((Closeable) null);
            ele.O000000o(bufferedOutputStream);
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            ele.O000000o((Closeable) null);
            ele.O000000o(bufferedOutputStream);
            throw th;
        }
    }
}
