package com.miui.tsmclient.b.a;

import android.content.Context;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.ReflectUtil;
import com.tsmclient.smartcard.terminal.IScTerminal;
import com.tsmclient.smartcard.terminal.TerminalType;
import java.lang.ref.WeakReference;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f3586a;
    private WeakReference<Context> b;

    private b(Context context) {
        this.b = new WeakReference<>(context);
    }

    public static b a() {
        if (f3586a == null) {
            synchronized (b.class) {
                if (f3586a == null) {
                    f3586a = new b(EnvironmentConfig.getContext());
                }
            }
        }
        return f3586a;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    public IScTerminal a(String str, TerminalType terminalType) {
        Object obj;
        Context context = this.b.get();
        if (terminalType == TerminalType.PERIPHERAL) {
            return new a(context, str);
        }
        if (terminalType == TerminalType.I2C) {
            obj = ReflectUtil.newInstance("com.tsmclient.smartcard.terminal.I2CSmartMxTerminal", new Class[]{Context.class}, context);
        } else {
            obj = ReflectUtil.newInstance("com.tsmclient.smartcard.terminal.SPISmartMxTerminal", new Class[]{Context.class}, context);
        }
        return (IScTerminal) obj;
    }
}
