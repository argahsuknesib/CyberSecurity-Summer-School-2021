package _m_j;

import java.io.File;
import java.io.IOException;

public interface jqq {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jqq f2063O000000o = new jqq() {
        /* class _m_j.jqq.AnonymousClass1 */

        public final void O000000o(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }
    };

    void O000000o(File file) throws IOException;
}
