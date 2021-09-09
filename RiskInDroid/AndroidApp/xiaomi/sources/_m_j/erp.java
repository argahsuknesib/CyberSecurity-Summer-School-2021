package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.hk;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.bt;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;

public final class erp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f15753O000000o = false;

    static class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private Context f15754O000000o;
        private ers O00000Oo;

        public O000000o(Context context, ers ers) {
            this.O00000Oo = ers;
            this.f15754O000000o = context;
        }

        public final void run() {
            erp.O00000Oo(this.f15754O000000o, this.O00000Oo);
        }
    }

    public static void O000000o(Context context, ers ers) {
        elo.O000000o(context).O000000o(new O000000o(context, ers), 0);
    }

    private static void O000000o(Context context, ers ers, File file, byte[] bArr) {
        String concat;
        int O000000o2;
        Context context2 = context;
        ers ers2 = ers;
        ArrayList arrayList = new ArrayList();
        int i = 4;
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            int i2 = 0;
            int i3 = 0;
            while (true) {
                try {
                    int read = bufferedInputStream2.read(bArr2);
                    if (read == -1) {
                        break;
                    } else if (read != i) {
                        concat = "TinyData read from cache file failed cause lengthBuffer error. size:".concat(String.valueOf(read));
                        break;
                    } else {
                        O000000o2 = eli.O000000o(bArr2);
                        if (O000000o2 <= 0) {
                            break;
                        } else if (O000000o2 > 10240) {
                            break;
                        } else {
                            byte[] bArr3 = new byte[O000000o2];
                            int read2 = bufferedInputStream2.read(bArr3);
                            if (read2 != O000000o2) {
                                concat = "TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + O000000o2;
                                break;
                            }
                            byte[] O000000o3 = ert.O000000o(bArr, bArr3);
                            if (O000000o3 != null) {
                                if (O000000o3.length != 0) {
                                    ht htVar = new ht();
                                    eru.O000000o(htVar, O000000o3);
                                    String valueOf = String.valueOf(O000000o3.length);
                                    if (htVar.f54a == null) {
                                        htVar.f54a = new HashMap();
                                    }
                                    htVar.f54a.put("item_size", valueOf);
                                    arrayList.add(htVar);
                                    i2++;
                                    i3 += O000000o3.length;
                                    if (i2 >= 8 || i3 >= 10240) {
                                        erq.O000000o(context2, ers2, arrayList);
                                        arrayList.clear();
                                        i2 = 0;
                                        i3 = 0;
                                        i = 4;
                                    } else {
                                        i = 4;
                                    }
                                }
                            }
                            duv.O00000o("TinyData read from cache file failed cause decrypt fail");
                            i = 4;
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        duv.O000000o(e);
                        ele.O000000o(bufferedInputStream);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream;
                        ele.O000000o(bufferedInputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    ele.O000000o(bufferedInputStream2);
                    throw th;
                }
            }
            concat = "TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:".concat(String.valueOf(O000000o2));
            duv.O00000o(concat);
            erq.O000000o(context2, ers2, arrayList);
            if (file.exists() && !file.delete()) {
                duv.O000000o("TinyData delete reading temp file failed");
            }
            ele.O000000o(bufferedInputStream2);
        } catch (Exception e2) {
            e = e2;
            duv.O000000o(e);
            ele.O000000o(bufferedInputStream);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cd  */
    static /* synthetic */ void O00000Oo(Context context, ers ers) {
        RandomAccessFile randomAccessFile;
        File file;
        if (!f15753O000000o) {
            f15753O000000o = true;
            File file2 = new File(context.getFilesDir(), "tiny_data.data");
            if (!file2.exists()) {
                duv.O000000o("TinyData no ready file to get data.");
                return;
            }
            File file3 = new File(context.getFilesDir() + "/tdReadTemp");
            if (!file3.exists()) {
                file3.mkdirs();
            }
            byte[] a2 = bt.a(context);
            FileLock fileLock = null;
            try {
                File file4 = new File(context.getFilesDir(), "tiny_data.lock");
                ele.O00000o0(file4);
                randomAccessFile = new RandomAccessFile(file4, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            e = e;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        duv.O000000o(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                e = e3;
                            }
                        }
                        ele.O000000o(randomAccessFile);
                        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                        if (file.exists()) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                duv.O000000o(e4);
                            }
                        }
                        ele.O000000o(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                randomAccessFile = null;
                duv.O000000o(e);
                fileLock.release();
                ele.O000000o(randomAccessFile);
                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                if (file.exists()) {
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                fileLock.release();
                ele.O000000o(randomAccessFile);
                throw th;
            }
            ele.O000000o(randomAccessFile);
            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
            if (file.exists()) {
                duv.O000000o("TinyData no ready file to get data.");
                return;
            }
            O000000o(context, ers, file, a2);
            hk.O000000o();
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
            edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
            edit.commit();
            f15753O000000o = false;
            return;
        }
        duv.O000000o("TinyData extractTinyData is running");
        return;
        duv.O000000o(e);
        ele.O000000o(randomAccessFile);
        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
        if (file.exists()) {
        }
    }
}
