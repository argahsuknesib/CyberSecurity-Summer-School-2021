package okhttp3.internal.huc;

import _m_j.jax;
import _m_j.jay;
import _m_j.jbg;
import _m_j.jbh;
import java.io.IOException;
import okhttp3.internal.http.UnrepeatableRequestBody;

final class StreamedRequestBody extends OutputStreamRequestBody implements UnrepeatableRequestBody {
    private final jbh pipe = new jbh();

    StreamedRequestBody(long j) {
        initOutputStream(jbg.O000000o(this.pipe.O00000oO), j);
    }

    public final void writeTo(jay jay) throws IOException {
        jax jax = new jax();
        while (this.pipe.O00000oo.read(jax, 8192) != -1) {
            jay.write(jax, jax.O00000Oo);
        }
    }
}
