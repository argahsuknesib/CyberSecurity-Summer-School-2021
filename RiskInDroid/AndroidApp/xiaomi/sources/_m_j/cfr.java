package _m_j;

import android.content.Context;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.deduct.d.a;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class cfr extends Model {

    /* renamed from: O000000o  reason: collision with root package name */
    public a f13729O000000o;
    public O00000Oo O00000Oo;

    public interface O00000Oo {
        void O000000o();

        void O000000o(int i, String str);
    }

    public cfr(Session session) {
        super(session);
        if (this.f13729O000000o == null) {
            this.f13729O000000o = new a(getContext(), getSession());
        }
    }

    public class O000000o extends RxBaseErrorHandleTaskListener<a.C0041a> {
        public /* synthetic */ O000000o(cfr cfr, Context context, byte b) {
            this(context);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cfr.this.O00000Oo.O000000o(i, str);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cfr.this.O00000Oo.O000000o();
        }
    }
}
