package okhttp3.internal.cache2;

import _m_j.jax;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class FileOperator {
    private final FileChannel fileChannel;

    FileOperator(FileChannel fileChannel2) {
        this.fileChannel = fileChannel2;
    }

    public final void read(long j, jax jax, long j2) throws IOException {
        if (j2 >= 0) {
            while (j2 > 0) {
                long transferTo = this.fileChannel.transferTo(j, j2, jax);
                j += transferTo;
                j2 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void write(long j, jax jax, long j2) throws IOException {
        if (j2 < 0 || j2 > jax.O00000Oo) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long transferFrom = this.fileChannel.transferFrom(jax, j3, j4);
            j3 += transferFrom;
            j4 -= transferFrom;
        }
    }
}
