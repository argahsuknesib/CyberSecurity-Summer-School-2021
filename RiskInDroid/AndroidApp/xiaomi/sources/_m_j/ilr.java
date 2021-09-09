package _m_j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public final class ilr {

    /* renamed from: O000000o  reason: collision with root package name */
    String f1449O000000o = null;
    ByteBuffer O00000Oo;
    private String O00000o;
    private String O00000o0;
    private ilw O00000oO;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    ilr(String str, String str2) throws FileNotFoundException, IOException {
        imc.O000000o("dl_mp3", (Object) "======================AudioFile Constructor()");
        this.O00000o0 = str;
        this.O00000o = imd.O00000Oo(str2);
        this.f1449O000000o = str2;
        this.O00000oO = new ilw(str, str2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private synchronized int O000000o(int i, byte[] bArr, int i2, int i3) throws IOException {
        int read;
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.O00000o0 + "/" + this.O00000o + ".chunk", "r");
        imc.O000000o("dl_mp3", (Object) ("======================readChunkData0(" + i + ":" + randomAccessFile.length() + ")"));
        randomAccessFile.seek((long) i);
        read = randomAccessFile.read(bArr, 0, 65536);
        randomAccessFile.close();
        return read;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final synchronized int O000000o(int i, byte[] bArr) throws IOException {
        if (!this.O00000oO.O00000oo.get(i)) {
            imc.O000000o("dl_mp3", (Object) ("fileInfo.chunkExist.get(" + i + ")false"));
            return -1;
        }
        int O000000o2 = O000000o(this.O00000oO.O0000O0o.get(i).intValue() * 65536, bArr, 0, 65536);
        imc.O000000o("dl_mp3", (Object) ("======================readChunkData(" + i + ":" + O000000o2 + ")"));
        return O000000o2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private synchronized int O000000o(byte[] bArr, int i, int i2) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.O00000o0 + "/" + this.O00000o + ".chunk", "rw");
        randomAccessFile.seek((long) (this.O00000oO.O00000Oo() * 65536));
        randomAccessFile.write(bArr, 0, i2);
        randomAccessFile.close();
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        return;
     */
    public final synchronized void O000000o(int i, byte[] bArr, int i2) {
        if (!this.O00000oO.O000000o(i)) {
            if (O000000o(bArr, 0, i2) > 0) {
                this.O00000oO.O00000Oo(i);
            }
        }
    }

    public final synchronized ilw O000000o() {
        return this.O00000oO;
    }
}
