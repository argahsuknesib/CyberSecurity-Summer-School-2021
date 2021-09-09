package _m_j;

import _m_j.cfo;
import android.app.Activity;
import android.os.Bundle;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.Model;

public abstract class cfx extends Model {
    public O000000o O00000o;
    public String O00000o0;

    public interface O000000o {
        void O000000o();

        void O000000o(int i, String str);

        void O000000o(cfo.O000000o<Activity> o000000o);
    }

    public abstract void O000000o();

    public void handleResult(int i, int i2, Bundle bundle) {
    }

    public cfx(Session session, String str) {
        super(session);
        this.O00000o0 = str;
    }
}
