package cn.com.xm.bt.profile.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private byte f3104a = 16;
    private byte b = -1;
    private byte c = 0;
    private byte[] d = null;
    private boolean e = false;
    private byte[] f = null;

    public static c a(byte[] bArr) {
        return a(bArr, 1);
    }

    private static c a(byte[] bArr, int i) {
        c cVar = new c();
        cVar.b(bArr, i);
        return cVar;
    }

    public synchronized byte[] a() {
        return this.f;
    }

    public synchronized byte[] b() {
        return this.d;
    }

    public synchronized byte c() {
        return this.c;
    }

    public synchronized boolean a(byte b2) {
        return this.b == b2 && this.c == a.SUCCESS.a();
    }

    public synchronized byte d() {
        return this.b;
    }

    public synchronized void b(byte[] bArr) {
        b(bArr, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        return;
     */
    private synchronized void b(byte[] bArr, int i) {
        cn.com.xm.bt.a.a.b("HMNotifyResponse", "from value:" + cn.com.xm.bt.c.c.a(bArr));
        this.e = true;
        if (bArr != null && bArr.length > 0) {
            this.f = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f, 0, bArr.length);
        }
        int i2 = i + 2;
        if (bArr != null) {
            if (bArr.length >= i2) {
                this.f3104a = bArr[0];
                this.b = bArr[1];
                this.c = bArr[i2 - 1];
                this.d = null;
                int length = bArr.length - i2;
                if (length > 0) {
                    this.d = new byte[length];
                    System.arraycopy(bArr, i2, this.d, 0, length);
                }
                cn.com.xm.bt.a.a.b("HMNotifyResponse", toString());
            }
        }
    }

    public synchronized String toString() {
        return "HMNotifyResponse{origin=" + cn.com.xm.bt.c.c.a(this.f) + ", flag=" + String.format("%02x ", Byte.valueOf(this.f3104a)) + ", cmd=" + String.format("%02x ", Byte.valueOf(this.b)) + ", code=" + String.format("%02x ", Byte.valueOf(this.c)) + ", data=" + cn.com.xm.bt.c.c.a(this.d) + '}';
    }

    enum a {
        RESERVED((byte) 0),
        SUCCESS((byte) 1),
        INVALID_STATE((byte) 2),
        UNKNOW_COMMAND((byte) 3),
        OPERATION_FAILED((byte) 4);
        
        private final byte f;

        private a(byte b) {
            this.f = b;
        }

        public final byte a() {
            return this.f;
        }
    }
}
