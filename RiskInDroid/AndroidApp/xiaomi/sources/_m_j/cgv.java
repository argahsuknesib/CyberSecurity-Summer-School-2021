package _m_j;

import android.content.Context;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.qrdeduct.b.b;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class cgv extends Model {

    /* renamed from: O000000o  reason: collision with root package name */
    public b f13795O000000o;
    public O00000Oo O00000Oo;

    public interface O00000Oo {
        void O000000o(int i, String str, Throwable th);

        void O000000o(b.a aVar);
    }

    public cgv(Session session) {
        super(session);
        if (this.f13795O000000o == null) {
            this.f13795O000000o = new b(getContext(), getSession());
        }
    }

    public class O000000o extends RxBaseErrorHandleTaskListener<b.a> {
        public /* synthetic */ O000000o(cgv cgv, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cgv.this.O00000Oo.O000000o((b.a) obj);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cgv.this.O00000Oo.O000000o(i, str, th);
        }
    }
}
