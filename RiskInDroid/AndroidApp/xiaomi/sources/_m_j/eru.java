package _m_j;

import android.content.Context;
import com.xiaomi.push.g;
import com.xiaomi.push.il;
import com.xiaomi.push.ja;
import com.xiaomi.push.jf;
import com.xiaomi.push.jr;

public final class eru {
    public static short O000000o(Context context, il ilVar) {
        return O000000o(context, ilVar.b);
    }

    public static short O000000o(Context context, String str) {
        int i = 0;
        int a2 = g.O000000o(context, str, false).a() + 0 + (eln.O00000Oo(context) ? 4 : 0);
        if (eln.O000000o(context)) {
            i = 8;
        }
        return (short) (a2 + i);
    }

    public static <T extends ja<T, ?>> void O000000o(ja jaVar, byte[] bArr) {
        if (bArr != null) {
            new ery(new jr.a(bArr.length)).O000000o(jaVar, bArr);
            return;
        }
        throw new jf("the message byte is empty.");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <T extends com.xiaomi.push.ja<T, ?>> byte[] O000000o(T r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            _m_j.erz r1 = new _m_j.erz     // Catch:{ jf -> 0x001f }
            com.xiaomi.push.jh$a r2 = new com.xiaomi.push.jh$a     // Catch:{ jf -> 0x001f }
            r2.<init>()     // Catch:{ jf -> 0x001f }
            r1.<init>(r2)     // Catch:{ jf -> 0x001f }
            java.io.ByteArrayOutputStream r2 = r1.f15760O000000o     // Catch:{ jf -> 0x001f }
            r2.reset()     // Catch:{ jf -> 0x001f }
            _m_j.esd r2 = r1.O00000Oo     // Catch:{ jf -> 0x001f }
            r3.O00000Oo(r2)     // Catch:{ jf -> 0x001f }
            java.io.ByteArrayOutputStream r3 = r1.f15760O000000o     // Catch:{ jf -> 0x001f }
            byte[] r3 = r3.toByteArray()     // Catch:{ jf -> 0x001f }
            return r3
        L_0x001f:
            r3 = move-exception
            java.lang.String r1 = "convertThriftObjectToBytes catch TException."
            _m_j.duv.O000000o(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.eru.O000000o(com.xiaomi.push.ja):byte[]");
    }
}
