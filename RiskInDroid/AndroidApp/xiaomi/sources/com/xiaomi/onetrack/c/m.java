package com.xiaomi.onetrack.c;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.xiaomi.onetrack.d.a;
import com.xiaomi.onetrack.d.c;
import com.xiaomi.onetrack.d.f;
import com.xiaomi.onetrack.g.b;
import com.xiaomi.onetrack.h.n;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.w;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class m {
    private static volatile m d;
    private k e;

    private m() {
        c();
    }

    public static m a() {
        b();
        return d;
    }

    public static void b() {
        if (d == null) {
            synchronized (m.class) {
                if (d == null) {
                    d = new m();
                }
            }
        }
    }

    public synchronized void a(int i, boolean z) {
        if (this.e != null) {
            this.e.a(i, z);
        } else {
            q.b("UploaderEngine", "*** impossible, upload timer should not be null");
        }
    }

    public boolean a(int i) {
        q.a("UploaderEngine", "即将读取数据库并上传数据");
        while (true) {
            f a2 = b.a().a(i);
            if (a2 != null) {
                ArrayList<Long> arrayList = a2.c;
                boolean a3 = a(a2.f6128a);
                q.a("UploaderEngine", "upload success:".concat(String.valueOf(a3)));
                if (a3) {
                    if (b.a().a(arrayList) != 0) {
                        if (a2.d) {
                            q.a("UploaderEngine", "No more records for prio=".concat(String.valueOf(i)));
                            break;
                        }
                    } else {
                        q.b("UploaderEngine", "delete DB failed!", new Throwable());
                        break;
                    }
                } else {
                    return false;
                }
            } else {
                q.a("UploaderEngine", "满足条件的记录为空，即将返回, priority=".concat(String.valueOf(i)));
                return true;
            }
        }
        return true;
    }

    private boolean a(JSONArray jSONArray) {
        try {
            String b = w.a().b();
            String jSONArray2 = jSONArray.toString();
            q.a("UploaderEngine", " payload:".concat(String.valueOf(jSONArray2)));
            byte[] a2 = a(a(jSONArray2));
            q.a("UploaderEngine", "before zip and encrypt, len=" + jSONArray2.length() + ", after=" + a2.length);
            String a3 = b.a(b, a2);
            q.a("UploaderEngine", "sendDataToServer response: ".concat(String.valueOf(a3)));
            if (TextUtils.isEmpty(a3)) {
                return false;
            }
            return b(a3);
        } catch (Exception e2) {
            q.b("UploaderEngine", "Exception while uploading ", e2);
            return false;
        }
    }

    private void c() {
        HandlerThread handlerThread = new HandlerThread("mi_analytics_uploader_worker");
        handlerThread.start();
        this.e = new k(handlerThread.getLooper());
    }

    private static byte[] a(String str) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(str.getBytes("UTF-8").length);
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Exception e2) {
                e = e2;
                gZIPOutputStream = null;
                try {
                    q.b("UploaderEngine", " zipData failed! " + e.toString());
                    n.a((OutputStream) byteArrayOutputStream);
                    n.a((OutputStream) gZIPOutputStream);
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    n.a((OutputStream) byteArrayOutputStream);
                    n.a((OutputStream) gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
                n.a((OutputStream) byteArrayOutputStream);
                n.a((OutputStream) gZIPOutputStream);
                throw th;
            }
            try {
                gZIPOutputStream.write(str.getBytes("UTF-8"));
                gZIPOutputStream.finish();
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Exception e3) {
                e = e3;
                q.b("UploaderEngine", " zipData failed! " + e.toString());
                n.a((OutputStream) byteArrayOutputStream);
                n.a((OutputStream) gZIPOutputStream);
                return bArr;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
            q.b("UploaderEngine", " zipData failed! " + e.toString());
            n.a((OutputStream) byteArrayOutputStream);
            n.a((OutputStream) gZIPOutputStream);
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
            n.a((OutputStream) byteArrayOutputStream);
            n.a((OutputStream) gZIPOutputStream);
            throw th;
        }
        n.a((OutputStream) byteArrayOutputStream);
        n.a((OutputStream) gZIPOutputStream);
        return bArr;
    }

    private byte[] a(byte[] bArr) {
        if (bArr != null) {
            return a.a(bArr, c.a(f.a().b()[0]));
        }
        q.b("UploaderEngine", "content is null");
        return null;
    }

    private boolean b(String str) {
        try {
            int optInt = new JSONObject(str).optInt("code");
            if (optInt == 0) {
                q.a("UploaderEngine", "成功发送数据到服务端");
                return true;
            } else if (optInt == -3) {
                q.b("UploaderEngine", "signature expired, will update");
                f.a().c();
                return false;
            } else {
                q.b("UploaderEngine", "Error: status code=".concat(String.valueOf(optInt)));
                return false;
            }
        } catch (Exception e2) {
            q.b("UploaderEngine", "parseUploadingResult exception ", e2);
            return false;
        }
    }
}
