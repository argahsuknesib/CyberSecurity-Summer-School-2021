package _m_j;

import android.content.Context;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.qrSignDeduct.b.a;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class cgs extends Model {

    /* renamed from: O000000o  reason: collision with root package name */
    public a f13789O000000o;
    public O00000Oo O00000Oo;

    public interface O00000Oo {
        void O000000o(int i, String str, Throwable th);

        void O000000o(a.C0042a aVar);
    }

    public cgs(Session session) {
        super(session);
        if (this.f13789O000000o == null) {
            this.f13789O000000o = new a(getContext(), getSession());
        }
    }

    public class O000000o extends RxBaseErrorHandleTaskListener<a.C0042a> {
        public /* synthetic */ O000000o(cgs cgs, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cgs.this.O00000Oo.O000000o((a.C0042a) obj);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cgs.this.O00000Oo.O000000o(i, str, th);
        }
    }
}
