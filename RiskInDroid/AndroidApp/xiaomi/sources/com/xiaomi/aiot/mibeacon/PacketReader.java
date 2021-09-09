package com.xiaomi.aiot.mibeacon;

import com.xiaomi.aiot.mibeacon.bluetooth.Pdu;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class PacketReader {
    private byte[] bytes;
    private ByteBuffer mByteBuffer = ByteBuffer.wrap(this.bytes).order(ByteOrder.LITTLE_ENDIAN);

    public boolean getBit(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    public int getInt(int i, int i2, int i3) {
        return (i >> i2) & ((1 << ((i3 - i2) + 1)) - 1);
    }

    public PacketReader(Pdu pdu) {
        this.bytes = pdu.getBytes();
    }

    public void position(int i) {
        this.mByteBuffer.position(i);
    }

    public int getShort() {
        return this.mByteBuffer.getShort() & 65535;
    }

    public int getByte() {
        return this.mByteBuffer.get() & 255;
    }

    public int getTXPower() {
        return this.mByteBuffer.get();
    }
}
