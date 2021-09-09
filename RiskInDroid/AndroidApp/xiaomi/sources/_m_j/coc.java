package _m_j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class coc extends FilterInputStream {
    public coc(InputStream inputStream) {
        super(inputStream);
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j) {
            long skip = this.in.skip(j - j2);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j2 += skip;
        }
        return j2;
    }
}
