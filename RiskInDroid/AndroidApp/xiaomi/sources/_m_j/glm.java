package _m_j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.List;

public final class glm extends gls {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17989O000000o;
    public List<Short> O00000Oo = Collections.emptyList();

    public final String O000000o() {
        return "ack";
    }

    public glm(int i) {
        this.f17989O000000o = i;
    }

    public glm(int i, List<Short> list) {
        this.f17989O000000o = i;
        if (list != null && list.size() > 0) {
            this.O00000Oo = list;
        }
    }

    public final byte[] O00000Oo() {
        ByteBuffer order = ByteBuffer.allocate((this.O00000Oo.size() * 2) + 4).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 1);
        order.put((byte) this.f17989O000000o);
        if (this.O00000Oo.size() > 0) {
            for (Short shortValue : this.O00000Oo) {
                order.putShort(shortValue.shortValue());
            }
        }
        return order.array();
    }

    public final String toString() {
        return "ACKPacket{status=" + this.f17989O000000o + ", seq=" + this.O00000Oo.toString() + '}';
    }
}
