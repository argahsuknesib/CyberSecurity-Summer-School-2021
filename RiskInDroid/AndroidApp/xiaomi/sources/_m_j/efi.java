package _m_j;

import android.content.Context;
import com.xiaomi.accountsdk.futureservice.MiAccountManagerFuture;
import com.xiaomi.accountsdk.utils.PassportExecutors;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.servicetoken.ServiceTokenUtilImplBase$3;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;
import java.util.concurrent.Executor;

public abstract class efi implements efe {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile Executor f15211O000000o = PassportExecutors.newFixedThreadPool(3, "ServiceTokenUtilImplBase");

    public abstract XmAccountVisibility O000000o(Context context);

    /* access modifiers changed from: protected */
    public abstract ServiceTokenResult O00000Oo(Context context, ServiceTokenResult serviceTokenResult);

    /* access modifiers changed from: protected */
    public abstract ServiceTokenResult O00000o0(Context context, String str);

    efi() {
    }

    public final ServiceTokenFuture O00000Oo(final Context context, final String str) {
        return new O000000o() {
            /* class _m_j.efi.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final ServiceTokenResult O000000o() {
                return efi.this.O00000o0(context, str);
            }
        }.O00000Oo();
    }

    public final ServiceTokenFuture O000000o(final Context context, final ServiceTokenResult serviceTokenResult) {
        return new O000000o() {
            /* class _m_j.efi.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public final ServiceTokenResult O000000o() {
                return efi.this.O00000Oo(context, serviceTokenResult);
            }
        }.O00000Oo();
    }

    public MiAccountManagerFuture<XmAccountVisibility> O00000o0(Context context) {
        return new ServiceTokenUtilImplBase$3(this, context).start();
    }

    static abstract class O000000o {
        /* access modifiers changed from: protected */
        public abstract ServiceTokenResult O000000o();

        O000000o() {
        }

        /* access modifiers changed from: package-private */
        public final ServiceTokenFuture O00000Oo() {
            final ServiceTokenFuture serviceTokenFuture = new ServiceTokenFuture(null);
            efi.f15211O000000o.execute(new Runnable() {
                /* class _m_j.efi.O000000o.AnonymousClass1 */

                public final void run() {
                    try {
                        serviceTokenFuture.setServerData(O000000o.this.O000000o());
                    } catch (Throwable th) {
                        serviceTokenFuture.setServerSideThrowable(th);
                    }
                }
            });
            return serviceTokenFuture;
        }
    }
}
