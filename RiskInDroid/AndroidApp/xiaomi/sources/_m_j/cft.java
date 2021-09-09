package _m_j;

import _m_j.cfn;
import android.app.Activity;
import android.os.Bundle;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.Model;

public abstract class cft extends Model {

    /* renamed from: O000000o  reason: collision with root package name */
    String f13733O000000o;
    public O000000o O00000Oo;

    public interface O000000o {
        void O000000o();

        void O000000o(int i, String str);

        void O000000o(cfn.O000000o<Activity> o000000o);
    }

    public abstract void O000000o();

    public void O000000o(int i, int i2, Bundle bundle) {
    }

    public void O00000Oo() {
    }

    public cft(Session session, String str) {
        super(session);
        this.f13733O000000o = str;
    }
}
