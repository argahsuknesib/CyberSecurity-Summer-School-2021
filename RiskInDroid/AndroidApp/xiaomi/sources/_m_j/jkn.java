package _m_j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class jkn implements jhd {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static jks LOG = jks.O000000o(jkn.class);
    private ByteBuffer content;
    private ByteBuffer deadBytes = null;
    boolean isParsed;
    protected String type;
    private byte[] userType;

    /* access modifiers changed from: protected */
    public abstract void _parseDetails(ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    public abstract void getContent(ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    public abstract long getContentSize();

    protected jkn(String str) {
        this.type = str;
        this.isParsed = true;
    }

    protected jkn(String str, byte[] bArr) {
        this.type = str;
        this.userType = bArr;
        this.isParsed = true;
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        this.content = ByteBuffer.allocateDirect(jkv.O000000o(j));
        int i = 0;
        int i2 = 0;
        while (((long) i) < j && (i2 = readableByteChannel.read(this.content)) != -1) {
            i += i2;
        }
        if (i2 == -1) {
            jks jks = LOG;
            jks.O00000o0(this + " might have been truncated by file end. bytesRead=" + i + " contentSize=" + j);
        }
        this.content.position(0);
        this.isParsed = false;
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        if (this.isParsed) {
            ByteBuffer allocate = ByteBuffer.allocate(jkv.O000000o(getSize()));
            getHeader(allocate);
            getContent(allocate);
            ByteBuffer byteBuffer = this.deadBytes;
            if (byteBuffer != null) {
                byteBuffer.rewind();
                while (this.deadBytes.remaining() > 0) {
                    allocate.put(this.deadBytes);
                }
            }
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            return;
        }
        int i = 16;
        int i2 = isSmallBox() ? 8 : 16;
        if (!"uuid".equals(getType())) {
            i = 0;
        }
        ByteBuffer allocate2 = ByteBuffer.allocate(i2 + i);
        getHeader(allocate2);
        writableByteChannel.write((ByteBuffer) allocate2.rewind());
        writableByteChannel.write((ByteBuffer) this.content.position(0));
    }

    public final synchronized void parseDetails() {
        jks jks = LOG;
        jks.O000000o("parsing details of " + getType());
        if (this.content != null) {
            ByteBuffer byteBuffer = this.content;
            this.isParsed = true;
            byteBuffer.rewind();
            _parseDetails(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.deadBytes = byteBuffer.slice();
            }
            this.content = null;
        }
    }

    public long getSize() {
        long contentSize = this.isParsed ? getContentSize() : (long) this.content.limit();
        int i = 0;
        long j = contentSize + ((long) ((contentSize >= 4294967288L ? 8 : 0) + 8 + ("uuid".equals(getType()) ? 16 : 0)));
        ByteBuffer byteBuffer = this.deadBytes;
        if (byteBuffer != null) {
            i = byteBuffer.limit();
        }
        return j + ((long) i);
    }

    public String getType() {
        return this.type;
    }

    public byte[] getUserType() {
        return this.userType;
    }

    public boolean isParsed() {
        return this.isParsed;
    }

    private boolean verify(ByteBuffer byteBuffer) {
        long contentSize = getContentSize();
        ByteBuffer byteBuffer2 = this.deadBytes;
        ByteBuffer allocate = ByteBuffer.allocate(jkv.O000000o(contentSize + ((long) (byteBuffer2 != null ? byteBuffer2.limit() : 0))));
        getContent(allocate);
        ByteBuffer byteBuffer3 = this.deadBytes;
        if (byteBuffer3 != null) {
            byteBuffer3.rewind();
            while (this.deadBytes.remaining() > 0) {
                allocate.put(this.deadBytes);
            }
        }
        byteBuffer.rewind();
        allocate.rewind();
        if (byteBuffer.remaining() != allocate.remaining()) {
            System.err.print(String.valueOf(getType()) + ": remaining differs " + byteBuffer.remaining() + " vs. " + allocate.remaining());
            LOG.O00000o0(String.valueOf(getType()) + ": remaining differs " + byteBuffer.remaining() + " vs. " + allocate.remaining());
            return false;
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 1;
        int limit2 = allocate.limit() - 1;
        while (limit >= position) {
            byte b = byteBuffer.get(limit);
            byte b2 = allocate.get(limit2);
            if (b != b2) {
                LOG.O00000o0(String.format("%s: buffers differ at %d: %2X/%2X", getType(), Integer.valueOf(limit), Byte.valueOf(b), Byte.valueOf(b2)));
                byte[] bArr = new byte[byteBuffer.remaining()];
                byte[] bArr2 = new byte[allocate.remaining()];
                byteBuffer.get(bArr);
                allocate.get(bArr2);
                System.err.println("original      : " + jkx.O000000o(bArr, 4));
                System.err.println("reconstructed : " + jkx.O000000o(bArr2, 4));
                return false;
            }
            limit--;
            limit2--;
        }
        return true;
    }

    private boolean isSmallBox() {
        int i = "uuid".equals(getType()) ? 24 : 8;
        if (!this.isParsed) {
            return ((long) (this.content.limit() + i)) < 4294967296L;
        }
        long contentSize = getContentSize();
        ByteBuffer byteBuffer = this.deadBytes;
        return (contentSize + ((long) (byteBuffer != null ? byteBuffer.limit() : 0))) + ((long) i) < 4294967296L;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jla.O00000Oo(java.nio.ByteBuffer, long):void
     arg types: [java.nio.ByteBuffer, int]
     candidates:
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, double):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, int):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, java.lang.String):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, long):void */
    private void getHeader(ByteBuffer byteBuffer) {
        if (isSmallBox()) {
            jla.O00000Oo(byteBuffer, getSize());
            byteBuffer.put(jhc.O000000o(getType()));
        } else {
            jla.O00000Oo(byteBuffer, 1L);
            byteBuffer.put(jhc.O000000o(getType()));
            jla.O000000o(byteBuffer, getSize());
        }
        if ("uuid".equals(getType())) {
            byteBuffer.put(getUserType());
        }
    }
}
