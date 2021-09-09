package _m_j;

import android.accounts.AccountsException;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.account.AccountRegistry;
import com.mibi.sdk.common.account.ILoginProvider;
import com.mibi.sdk.common.exception.AccountException;
import com.mibi.sdk.common.exception.ConnectionException;
import com.mibi.sdk.common.exception.NotConnectedException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.task.RxTask;
import java.io.IOException;

public final class ces extends RxTask<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public SortedParameter f13691O000000o;
    private Activity O00000Oo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f13692O000000o;
        public int O00000Oo;
    }

    public final /* synthetic */ void doLoad(Object obj) throws PaymentException {
        O000000o o000000o = (O000000o) obj;
        if (Utils.isConnected(this.O00000Oo)) {
            String string = this.f13691O000000o.getString("userName");
            String string2 = this.f13691O000000o.getString("password");
            ILoginProvider loginProvider = AccountRegistry.getLoginProvider();
            if (loginProvider != null) {
                try {
                    o000000o.f13692O000000o = loginProvider.getStsUrl(this.O00000Oo, string, string2, CommonConstants.SERVICE_ID);
                    o000000o.O00000Oo = 0;
                } catch (OperationCanceledException unused) {
                    o000000o.O00000Oo = 2;
                } catch (AuthenticatorException e) {
                    o000000o.O00000Oo = 1;
                    throw new AccountException(e);
                } catch (IOException e2) {
                    o000000o.O00000Oo = 2;
                    throw new AccountException(new ConnectionException(e2));
                } catch (AccountsException e3) {
                    o000000o.O00000Oo = 1;
                    throw new AccountException(e3);
                }
            } else {
                throw new IllegalStateException("account pay should not use this task");
            }
        } else {
            throw new NotConnectedException();
        }
    }

    public ces(Activity activity) {
        super(O000000o.class);
        this.O00000Oo = activity;
    }
}
