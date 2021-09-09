package _m_j;

import android.app.Activity;
import android.os.Bundle;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.mvp.IView;

public final class cet {

    public interface O000000o extends IPresenter {
        void O000000o(Activity activity, String str, String str2);
    }

    public interface O00000Oo extends IView {
        void a();

        void a(int i, String str);

        void a(Bundle bundle);

        void a(String str, Throwable th);

        void b();

        void c();

        void d();
    }
}
