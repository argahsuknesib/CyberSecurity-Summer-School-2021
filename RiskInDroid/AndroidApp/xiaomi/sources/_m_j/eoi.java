package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class eoi implements dut {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f15675O000000o = "/MiPushLog";
    /* access modifiers changed from: private */
    public static final SimpleDateFormat O00000Oo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
    /* access modifiers changed from: private */
    public static List<Pair<String, Throwable>> O00000oo = Collections.synchronizedList(new ArrayList());
    private static volatile eoi O0000OOo;
    private Context O00000o;
    /* access modifiers changed from: private */
    public String O00000o0;
    private String O00000oO = "";
    private Handler O0000O0o;

    private eoi(Context context) {
        this.O00000o = context;
        if (context.getApplicationContext() != null) {
            this.O00000o = context.getApplicationContext();
        }
        this.O00000o0 = this.O00000o.getPackageName();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.O0000O0o = new Handler(handlerThread.getLooper());
    }

    public static eoi O000000o(Context context) {
        if (O0000OOo == null) {
            synchronized (eoi.class) {
                if (O0000OOo == null) {
                    O0000OOo = new eoi(context);
                }
            }
        }
        return O0000OOo;
    }

    public final void O000000o(String str) {
        O000000o(str, null);
    }

    public final void O000000o(String str, Throwable th) {
        this.O0000O0o.post(new eoj(this, str, th));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0193 A[SYNTHETIC, Splitter:B:101:0x0193] */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0150 A[SYNTHETIC, Splitter:B:73:0x0150] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x016e A[SYNTHETIC, Splitter:B:85:0x016e] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0175 A[SYNTHETIC, Splitter:B:89:0x0175] */
    static /* synthetic */ void O00000Oo(eoi eoi) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File externalFilesDir;
        BufferedWriter bufferedWriter = null;
        try {
            if (TextUtils.isEmpty(eoi.O00000oO) && (externalFilesDir = eoi.O00000o.getExternalFilesDir(null)) != null) {
                eoi.O00000oO = externalFilesDir.getAbsolutePath();
            }
            File file = new File(eoi.O00000oO + f15675O000000o);
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                gsy.O000000o(5, eoi.O00000o0, "Create mipushlog directory fail.");
                return;
            }
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!O00000oo.isEmpty()) {
                        try {
                            Pair remove = O00000oo.remove(0);
                            String str = (String) remove.first;
                            if (remove.second != null) {
                                str = (str + "\n") + Log.getStackTraceString((Throwable) remove.second);
                            }
                            bufferedWriter2.write(str + "\n");
                        } catch (Exception e) {
                            e = e;
                            bufferedWriter = bufferedWriter2;
                            try {
                                Log.e(eoi.O00000o0, "", e);
                                if (bufferedWriter != null) {
                                }
                                try {
                                    fileLock.release();
                                } catch (IOException e2) {
                                    Log.e(eoi.O00000o0, "", e2);
                                }
                                if (randomAccessFile == null) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e3) {
                                        Log.e(eoi.O00000o0, "", e3);
                                    }
                                }
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                        Log.e(eoi.O00000o0, "", e4);
                                    }
                                }
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e5) {
                                        Log.e(eoi.O00000o0, "", e5);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                            }
                            fileLock.release();
                            if (randomAccessFile != null) {
                            }
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    File file3 = new File(file, "log1.txt");
                    if (file3.length() >= 1048576) {
                        File file4 = new File(file, "log0.txt");
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                        file3.renameTo(file4);
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e6) {
                            Log.e(eoi.O00000o0, "", e6);
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                    Log.e(eoi.O00000o0, "", e);
                    if (bufferedWriter != null) {
                    }
                    fileLock.release();
                    if (randomAccessFile == null) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e8) {
                    Log.e(eoi.O00000o0, "", e8);
                }
            } catch (Exception e9) {
                e = e9;
                fileLock = null;
                Log.e(eoi.O00000o0, "", e);
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e10) {
                        Log.e(eoi.O00000o0, "", e10);
                    }
                }
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                if (randomAccessFile == null) {
                    randomAccessFile.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileLock = null;
                if (bufferedWriter != null) {
                }
                fileLock.release();
                if (randomAccessFile != null) {
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            fileLock = null;
            randomAccessFile = null;
            Log.e(eoi.O00000o0, "", e);
            if (bufferedWriter != null) {
            }
            fileLock.release();
            if (randomAccessFile == null) {
            }
        } catch (Throwable th4) {
            th = th4;
            fileLock = null;
            randomAccessFile = null;
            if (bufferedWriter != null) {
            }
            fileLock.release();
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }
}
