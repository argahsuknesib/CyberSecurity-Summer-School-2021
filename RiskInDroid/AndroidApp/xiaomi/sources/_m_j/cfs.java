package _m_j;

import android.content.Context;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.deduct.d.b;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class cfs extends Model {

    /* renamed from: O000000o  reason: collision with root package name */
    public b f13731O000000o;
    public O00000Oo O00000Oo;

    public interface O00000Oo {
        void O000000o();

        void O000000o(int i, String str, Throwable th);
    }

    public cfs(Session session) {
        super(session);
        if (this.f13731O000000o == null) {
            this.f13731O000000o = new b(getContext(), getSession());
        }
    }

    public class O000000o extends RxBaseErrorHandleTaskListener<b.a> {
        public /* synthetic */ O000000o(cfs cfs, Context context, byte b) {
            this(context);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cfs.this.O00000Oo.O000000o(i, str, th);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            cfs.this.O00000Oo.O000000o();
        }
    }
}
