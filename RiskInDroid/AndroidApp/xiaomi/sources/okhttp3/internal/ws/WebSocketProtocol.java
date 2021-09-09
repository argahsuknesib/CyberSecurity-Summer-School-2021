package okhttp3.internal.ws;

import _m_j.jax;
import okio.ByteString;

public final class WebSocketProtocol {
    static void toggleMask(jax.O000000o o000000o, byte[] bArr) {
        int i;
        int length = bArr.length;
        int i2 = 0;
        do {
            byte[] bArr2 = o000000o.O00000o;
            int i3 = o000000o.O00000oO;
            int i4 = o000000o.O00000oo;
            while (i3 < i4) {
                int i5 = i2 % length;
                bArr2[i3] = (byte) (bArr2[i3] ^ bArr[i5]);
                i3++;
                i2 = i5 + 1;
            }
            if (o000000o.O00000o0 == o000000o.f1721O000000o.O00000Oo) {
                throw new IllegalStateException();
            } else if (o000000o.O00000o0 == -1) {
                i = o000000o.O000000o(0);
            } else {
                i = o000000o.O000000o(o000000o.O00000o0 + ((long) (o000000o.O00000oo - o000000o.O00000oO)));
            }
        } while (i != -1);
    }

    static String closeCodeExceptionMessage(int i) {
        if (i < 1000 || i >= 5000) {
            return "Code must be in range [1000,5000): ".concat(String.valueOf(i));
        }
        if ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) {
            return null;
        }
        return "Code " + i + " is reserved and may not be used.";
    }

    static void validateCloseCode(int i) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i);
        if (closeCodeExceptionMessage != null) {
            throw new IllegalArgumentException(closeCodeExceptionMessage);
        }
    }

    public static String acceptHeader(String str) {
        return ByteString.O000000o(str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").O00000o().O00000Oo();
    }

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }
}
