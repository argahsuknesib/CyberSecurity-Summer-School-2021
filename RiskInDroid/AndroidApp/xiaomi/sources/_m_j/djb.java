package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.format.Time;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

public final class djb extends dja implements Handler.Callback {
    HandlerThread O00000Oo;
    private FileWriter O00000o;
    private djc O00000o0;
    private FileWriter O00000oO;
    private File O00000oo;
    private File O0000O0o;
    private char[] O0000OOo;
    private volatile djg O0000Oo;
    private volatile djg O0000Oo0;
    private volatile djg O0000OoO;
    private volatile djg O0000Ooo;
    private Handler O0000o0;
    private volatile boolean O0000o00;

    public djb(djc djc) {
        this(djd.O00000Oo, djh.f14716O000000o, djc);
    }

    private djb(int i, djh djh, djc djc) {
        super(i, true, djh);
        this.O0000o00 = false;
        this.O00000o0 = djc;
        this.O0000Oo0 = new djg();
        this.O0000Oo = new djg();
        this.O0000OoO = this.O0000Oo0;
        this.O0000Ooo = this.O0000Oo;
        this.O0000OOo = new char[djc.O00000Oo];
        this.O00000Oo = new HandlerThread(djc.f14712O000000o, djc.O00000o0);
        HandlerThread handlerThread = this.O00000Oo;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (this.O00000Oo.isAlive() && this.O00000Oo.getLooper() != null) {
            this.O0000o0 = new Handler(this.O00000Oo.getLooper(), this);
        }
    }

    public final void O000000o() {
        if (this.O0000o0.hasMessages(1024)) {
            this.O0000o0.removeMessages(1024);
        }
        this.O0000o0.sendEmptyMessage(1024);
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1024 && Thread.currentThread() == this.O00000Oo && !this.O0000o00) {
            this.O0000o00 = true;
            synchronized (this) {
                if (this.O0000OoO == this.O0000Oo0) {
                    this.O0000OoO = this.O0000Oo;
                    this.O0000Ooo = this.O0000Oo0;
                } else {
                    this.O0000OoO = this.O0000Oo0;
                    this.O0000Ooo = this.O0000Oo;
                }
            }
            try {
                djg djg = this.O0000Ooo;
                Writer[] O00000o2 = O00000o();
                char[] cArr = this.O0000OOo;
                if (!(O00000o2 == null || cArr == null || cArr.length == 0)) {
                    if (O00000o2.length >= 2) {
                        Writer writer = O00000o2[0];
                        Writer writer2 = O00000o2[1];
                        int length = cArr.length;
                        Iterator<String> it = djg.iterator();
                        int i = length;
                        int i2 = 0;
                        while (it.hasNext()) {
                            String next = it.next();
                            int length2 = next.length();
                            int i3 = 0;
                            while (length2 > 0) {
                                int i4 = i > length2 ? length2 : i;
                                int i5 = i3 + i4;
                                next.getChars(i3, i5, cArr, i2);
                                i -= i4;
                                i2 += i4;
                                length2 -= i4;
                                if (i == 0) {
                                    if (writer != null) {
                                        try {
                                            writer.write(cArr, 0, length);
                                        } catch (Exception unused) {
                                        }
                                    }
                                    if (writer2 != null) {
                                        try {
                                            writer2.write(cArr, 0, length);
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    i = length;
                                    i3 = i5;
                                    i2 = 0;
                                } else {
                                    i3 = i5;
                                }
                            }
                        }
                        if (i2 > 0) {
                            if (writer != null) {
                                try {
                                    writer.write(cArr, 0, i2);
                                } catch (Exception unused3) {
                                }
                            }
                            if (writer2 != null) {
                                try {
                                    writer2.write(cArr, 0, i2);
                                } catch (Exception unused4) {
                                }
                            }
                        }
                        if (writer != null) {
                            try {
                                writer.flush();
                            } catch (Exception unused5) {
                            }
                        }
                        if (writer2 != null) {
                            try {
                                writer2.flush();
                            } catch (Exception unused6) {
                            }
                        }
                    }
                }
            } catch (IOException e) {
                diz.O00000Oo("FileTracer", "flushBuffer exception", e);
            } catch (Throwable th) {
                this.O0000Ooo.O000000o();
                throw th;
            }
            this.O0000Ooo.O000000o();
            this.O0000o00 = false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        try {
            if (this.O00000o != null) {
                this.O00000o.flush();
                this.O00000o.close();
            }
        } catch (IOException e) {
            diz.O00000Oo("openSDK_LOG", "-->closeFileWriter() exception:", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        try {
            if (this.O00000oO != null) {
                this.O00000oO.flush();
                this.O00000oO.close();
            }
        } catch (IOException e) {
            diz.O00000Oo("openSDK_LOG", "-->closeAppSpecificFileWriter() exception:", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(int i, Thread thread, long j, String str, String str2, Throwable th) {
        long j2 = j % 1000;
        Time time = new Time();
        time.set(j);
        StringBuilder sb = new StringBuilder();
        sb.append(djh.O000000o(i));
        sb.append('/');
        sb.append(time.format("%Y-%m-%d %H:%M:%S"));
        sb.append('.');
        if (j2 < 10) {
            sb.append("00");
        } else if (j2 < 100) {
            sb.append('0');
        }
        sb.append(j2);
        sb.append(' ');
        sb.append('[');
        if (thread == null) {
            sb.append("N/A");
        } else {
            sb.append(thread.getName());
        }
        sb.append(']');
        sb.append('[');
        sb.append(str);
        sb.append(']');
        sb.append(' ');
        sb.append(str2);
        sb.append(10);
        if (th != null) {
            sb.append("* Exception : \n");
            sb.append(Log.getStackTraceString(th));
            sb.append(10);
        }
        String sb2 = sb.toString();
        djg djg = this.O0000OoO;
        int length = sb2.length();
        djg.f14715O000000o.add(sb2);
        djg.O00000Oo.addAndGet(length);
        if (this.O0000OoO.O00000Oo.get() >= this.O00000o0.O00000Oo) {
            O000000o();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileWriter.<init>(java.lang.String, boolean):void throws java.io.IOException}
      ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException} */
    private Writer[] O00000o() {
        File[] O000000o2 = this.O00000o0.O000000o(System.currentTimeMillis());
        File file = O000000o2[0];
        if ((file != null && !file.equals(this.O00000oo)) || (this.O00000o == null && file != null)) {
            this.O00000oo = file;
            O00000Oo();
            try {
                this.O00000o = new FileWriter(this.O00000oo, true);
            } catch (IOException unused) {
                this.O00000o = null;
                diz.O00000oO("openSDK_LOG", "-->obtainFileWriter() old log file permission denied");
            }
        }
        File file2 = O000000o2[1];
        if ((file2 != null && !file2.equals(this.O0000O0o)) || (this.O00000oO == null && file2 != null)) {
            this.O0000O0o = file2;
            O00000o0();
            try {
                this.O00000oO = new FileWriter(this.O0000O0o, true);
            } catch (IOException unused2) {
                this.O00000oO = null;
                diz.O00000oO("openSDK_LOG", "-->obtainFileWriter() app specific file permission denied");
            }
        }
        return new Writer[]{this.O00000o, this.O00000oO};
    }
}
