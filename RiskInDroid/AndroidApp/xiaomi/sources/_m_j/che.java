package _m_j;

import android.os.Bundle;
import com.mibi.sdk.model.auth.OnCheckAuthErrorListener;
import com.mibi.sdk.mvp.IView;

public interface che {

    public interface O000000o {
        String O000000o();
    }

    public interface O00000Oo extends OnCheckAuthErrorListener, IView {
        void a(int i, Bundle bundle);

        void a(int i, String str, Throwable th);

        void a(Bundle bundle);
    }
}
