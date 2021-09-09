package _m_j;

import android.os.RemoteException;
import com.miot.spec.entity.SpecValueType;
import java.nio.ByteBuffer;

public abstract class cmx extends cms {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f14131O000000o = cne.O000000o();

    public abstract void O000000o(int i, String str) throws RemoteException;

    public abstract void O000000o(cmv cmv) throws RemoteException;

    public abstract byte[] O000000o();

    public cmx(String str, int i) {
        super(str);
        this.O00000oO = i;
    }

    protected static boolean O000000o(ByteBuffer byteBuffer, SpecValueType specValueType, Object obj) {
        if (specValueType.byteLength() == 1) {
            if (specValueType == SpecValueType.BOOL) {
                byteBuffer.put(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
            } else {
                byteBuffer.put(((Byte) obj).byteValue());
            }
        } else if (specValueType.byteLength() == 2) {
            byteBuffer.putShort((short) ((Short) obj).shortValue());
        } else if (specValueType.byteLength() == 4) {
            if (specValueType == SpecValueType.FLOAT) {
                byteBuffer.putFloat(((Float) obj).floatValue());
            } else {
                byteBuffer.putInt(((Integer) obj).intValue());
            }
        } else if (specValueType.byteLength() == 8) {
            byteBuffer.putLong(((Long) obj).longValue());
        } else if (specValueType.byteLength() == 0 && obj != null) {
            byteBuffer.put(((String) obj).getBytes());
        }
        return true;
    }

    public final int O00000o0() {
        return this.f14131O000000o;
    }

    public final String O00000o() {
        return this.O00000oo + this.f14131O000000o;
    }

    /* access modifiers changed from: protected */
    public final int O000000o(cmh cmh) {
        SpecValueType specValueType = cmh.O00000o;
        Object obj = cmh.O00000o0;
        int value = specValueType.value() << 12;
        int byteLength = specValueType.byteLength();
        if (byteLength == 0 && obj != null) {
            String str = (String) obj;
            byteLength = str.getBytes().length;
            if (byteLength > 1024) {
                O000000o("value string :%s, size %d out of 1024,not support!", str, Integer.valueOf(str.length()));
                throw new IllegalArgumentException("string value byte size must less than 1024");
            }
        }
        return value | byteLength;
    }

    /* access modifiers changed from: protected */
    public final int O00000Oo(cmh cmh) {
        int byteLength = cmh.O00000o.byteLength();
        Object obj = cmh.O00000o0;
        if (byteLength == 0) {
            String str = (String) obj;
            byteLength = str.getBytes().length;
            if (byteLength > 1024) {
                O000000o("value string :%s, size %d out of 1024,not support!", str, Integer.valueOf(str.length()));
                throw new IllegalArgumentException("string value byte size must less than 1024");
            }
        }
        return byteLength;
    }
}
