package com.xiaomi.smarthome.frame.crash;

import _m_j.fsr;
import _m_j.ftc;
import _m_j.ftm;
import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

public class FrameCrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f7520O000000o;
    private Thread.UncaughtExceptionHandler O00000Oo = Thread.getDefaultUncaughtExceptionHandler();

    public FrameCrashHandler(Context context) {
        this.f7520O000000o = context;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        String str2;
        Throwable th2 = th;
        if (th2 != null) {
            th.printStackTrace();
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            String obj = stringWriter.toString();
            if (obj.length() > 5000) {
                obj = obj.substring(0, 5000);
            }
            if (th2 == null) {
                str = "";
            } else {
                str = th.getStackTrace()[0].getClassName();
            }
            if (th2 == null) {
                str2 = "";
            } else {
                str2 = th.getStackTrace()[0].getMethodName();
            }
            String O00000o0 = ftm.O00000o0(this.f7520O000000o);
            ftc.O000000o().O000000o(this.f7520O000000o, str, str2, obj, (TextUtils.isEmpty(O00000o0) || !O00000o0.startsWith("com.xiaomi.smarthome:")) ? O00000o0 : O00000o0.replace("com.xiaomi.smarthome:", ""), fsr.O0000Oo, 0, 0);
            gsy.O00000o0(LogType.SERIOUS_EXCEPTION, "FrameCrashHandler", obj);
            gsy.O000000o();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.O00000Oo;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        }
    }
}
