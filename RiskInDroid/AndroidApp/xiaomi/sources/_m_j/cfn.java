package _m_j;

import android.app.Activity;
import android.os.Bundle;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.mvp.IView;

public final class cfn {

    public interface O000000o<T> {
        void O000000o(T t);
    }

    public interface O00000Oo extends IPresenter {
        void O000000o();
    }

    public interface O00000o0 extends IView {
        void a(int i, String str, Bundle bundle);

        void a(O000000o<Activity> o000000o);

        void a(boolean z);
    }
}
