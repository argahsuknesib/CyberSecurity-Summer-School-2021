package okhttp3.internal.cache;

import _m_j.jax;
import _m_j.jbb;
import _m_j.jbm;
import java.io.IOException;

class FaultHidingSink extends jbb {
    private boolean hasErrors;

    /* access modifiers changed from: protected */
    public void onException(IOException iOException) {
    }

    FaultHidingSink(jbm jbm) {
        super(jbm);
    }

    public void write(jax jax, long j) throws IOException {
        if (this.hasErrors) {
            jax.O0000Oo0(j);
            return;
        }
        try {
            super.write(jax, j);
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    public void flush() throws IOException {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }

    public void close() throws IOException {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }
}
