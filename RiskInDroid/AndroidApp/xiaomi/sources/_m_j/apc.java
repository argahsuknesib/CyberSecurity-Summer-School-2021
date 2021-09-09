package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.Arrays;

public final class apc extends app {
    static final apc O00000o0 = new apc(new byte[0]);
    final byte[] O00000o;

    private apc(byte[] bArr) {
        this.O00000o = bArr;
    }

    public static apc O000000o(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return O00000o0;
        }
        return new apc(bArr);
    }

    public final String O000000o() {
        return aij.O000000o().O000000o(this.O00000o, false);
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf) throws IOException, JsonProcessingException {
        jsonGenerator.O000000o(this.O00000o);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return Arrays.equals(((apc) obj).O00000o, this.O00000o);
        }
        return false;
    }

    public final int hashCode() {
        byte[] bArr = this.O00000o;
        if (bArr == null) {
            return -1;
        }
        return bArr.length;
    }

    public final String toString() {
        return aij.O000000o().O000000o(this.O00000o, true);
    }
}
