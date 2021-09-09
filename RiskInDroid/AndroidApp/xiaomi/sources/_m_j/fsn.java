package _m_j;

import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.IServerHandle;
import java.lang.ref.WeakReference;
import okhttp3.Call;

public class fsn<H> {
    protected WeakReference<H> mHandle;

    public interface O00000Oo {
        void cancel();
    }

    public fsn(H h) {
        this.mHandle = new WeakReference<>(h);
    }

    public void cancel() {
        H h;
        WeakReference<H> weakReference = this.mHandle;
        if (weakReference != null && (h = weakReference.get()) != null) {
            if (h instanceof O00000Oo) {
                ((O00000Oo) h).cancel();
            } else if (h instanceof IServerHandle) {
                try {
                    ((IServerHandle) h).cancel();
                } catch (RemoteException unused) {
                }
            } else if (h instanceof Call) {
                ((Call) h).cancel();
            }
        }
    }

    public static class O000000o extends fsn {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f17062O000000o;

        public O000000o() {
            super(null);
        }

        public final void O000000o(fsn fsn) {
            if (fsn != null) {
                this.mHandle = fsn.mHandle;
            }
        }

        public final void cancel() {
            this.f17062O000000o = true;
            fsn.super.cancel();
        }
    }
}
