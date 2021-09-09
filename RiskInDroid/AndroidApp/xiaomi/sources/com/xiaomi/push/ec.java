package com.xiaomi.push;

import _m_j.ele;
import _m_j.eli;
import _m_j.elj;
import _m_j.elo;
import _m_j.emf;
import _m_j.eml;
import _m_j.eol;
import _m_j.eom;
import _m_j.eon;
import _m_j.eoo;
import _m_j.eru;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.service.at;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

public class ec extends elo.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f6374O000000o;
    private SharedPreferences O00000Oo;
    private at O00000o0;

    public ec(Context context) {
        this.f6374O000000o = context;
        this.O00000Oo = context.getSharedPreferences("mipush_extra", 0);
        this.O00000o0 = at.a(context);
    }

    public String a() {
        return "1";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0081, code lost:
        if (r1 != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c5, code lost:
        if (r1 != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ce, code lost:
        if (_m_j.emf.O0000OOo(r14.f6374O000000o) != false) goto L_0x00d2;
     */
    public void run() {
        boolean z;
        boolean z2;
        File file = new File(this.f6374O000000o.getExternalFilesDir(null), "push_cdata.data");
        if (emf.O00000o0(this.f6374O000000o)) {
            boolean z3 = true;
            if (!emf.O00000o(this.f6374O000000o)) {
                if (emf.O00000oo(this.f6374O000000o) || emf.O00000oO(this.f6374O000000o)) {
                    if (this.O00000o0.a(hu.J.a(), true)) {
                        int max = Math.max(86400, this.O00000o0.a(hu.K.a(), 259200));
                        if (Math.abs((System.currentTimeMillis() / 1000) - this.O00000Oo.getLong("last_upload_data_timestamp", -1)) > ((long) max)) {
                            z2 = true;
                        }
                    }
                    z2 = false;
                }
                if (emf.O0000O0o(this.f6374O000000o)) {
                    if (this.O00000o0.a(hu.L.a(), true)) {
                        int max2 = Math.max(86400, this.O00000o0.a(hu.M.a(), 432000));
                        if (Math.abs((System.currentTimeMillis() / 1000) - this.O00000Oo.getLong("last_upload_data_timestamp", -1)) > ((long) max2)) {
                            z = true;
                        }
                    }
                    z = false;
                }
            }
            z3 = false;
            if (!z3 && file.exists()) {
                List<hx> O000000o2 = O000000o(file);
                if (!elj.O000000o(O000000o2)) {
                    int size = O000000o2.size();
                    if (size > 4000) {
                        O000000o2 = O000000o2.subList(size - 4000, size);
                    }
                    ii iiVar = new ii();
                    iiVar.f6420a = O000000o2;
                    byte[] O000000o3 = ele.O000000o(eru.O000000o(iiVar));
                    io ioVar = new io("-1", false);
                    ioVar.d = hz.q.f70a;
                    ioVar.O000000o(O000000o3);
                    eol eol = eom.O000000o().f15678O000000o;
                    if (eol != null) {
                        eol.O000000o(ioVar, hp.i);
                    }
                    SharedPreferences.Editor edit = this.O00000Oo.edit();
                    edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
                    edit.commit();
                }
                file.delete();
            }
        } else if (file.length() > 1863680) {
            file.delete();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00aa, code lost:
        r13 = th;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00c7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00db */
    private List<hx> O000000o(File file) {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        eol eol = eom.O000000o().f15678O000000o;
        String O000000o2 = eol == null ? "" : eol.O000000o();
        FileLock fileLock2 = null;
        if (TextUtils.isEmpty(O000000o2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (eoo.f15679O000000o) {
            try {
                File file2 = new File(this.f6374O000000o.getExternalFilesDir(null), "push_cdata.lock");
                ele.O00000o0(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (Exception unused) {
                    fileInputStream = null;
                    fileLock2.release();
                    ele.O000000o(fileInputStream);
                    ele.O000000o(randomAccessFile);
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    fileLock = null;
                    fileInputStream = null;
                    fileLock.release();
                    ele.O000000o(fileInputStream);
                    ele.O000000o(randomAccessFile);
                    throw th;
                }
                try {
                    fileInputStream = new FileInputStream(file);
                    while (fileInputStream.read(bArr) == 4) {
                        int O000000o3 = eli.O000000o(bArr);
                        byte[] bArr2 = new byte[O000000o3];
                        if (fileInputStream.read(bArr2) != O000000o3) {
                            break;
                        }
                        byte[] O000000o4 = eon.O000000o(O000000o2, bArr2);
                        if (!(O000000o4 == null || O000000o4.length == 0)) {
                            hx hxVar = new hx();
                            eru.O000000o(hxVar, O000000o4);
                            arrayList.add(hxVar);
                            if (hxVar.f63a == hr.b && !hxVar.f64a.startsWith("same_")) {
                                SharedPreferences.Editor edit = this.O00000Oo.edit();
                                edit.putLong("dc_job_result_time_4", hxVar.f6400a);
                                edit.putString("dc_job_result_4", eml.O000000o(hxVar.f64a));
                                edit.commit();
                            }
                        }
                    }
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            fileLock.release();
                        }
                    }
                    ele.O000000o(fileInputStream);
                } catch (Exception unused2) {
                    fileInputStream = null;
                    fileLock2 = fileLock;
                    fileLock2.release();
                    ele.O000000o(fileInputStream);
                    ele.O000000o(randomAccessFile);
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    fileLock.release();
                    ele.O000000o(fileInputStream);
                    ele.O000000o(randomAccessFile);
                    throw th;
                }
            } catch (Exception unused3) {
                randomAccessFile = null;
                fileInputStream = null;
                if (fileLock2 != null && fileLock2.isValid()) {
                    fileLock2.release();
                }
                ele.O000000o(fileInputStream);
                ele.O000000o(randomAccessFile);
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                fileLock = null;
                randomAccessFile = null;
                fileInputStream = null;
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                ele.O000000o(fileInputStream);
                ele.O000000o(randomAccessFile);
                throw th;
            }
            ele.O000000o(randomAccessFile);
        }
        return arrayList;
    }
}
