package _m_j;

import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import com.xiaomi.accountsdk.account.exception.IllegalDeviceException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import java.io.IOException;

public interface ees<V> {
    V getResult() throws OperationCanceledException, IOException, AuthenticatorException, InvalidCredentialException, InvalidUserNameException, AccessDeniedException, InvalidResponseException, IllegalDeviceException, AuthenticationFailureException;
}
