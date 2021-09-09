package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.data.XiaomiUserCoreInfo;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.File;
import java.io.IOException;

public final class ekd {
    public static boolean O000000o(Context context, XiaomiUserCoreInfo xiaomiUserCoreInfo, String str, String str2) {
        String str3 = xiaomiUserCoreInfo.avatarAddress;
        File fileStreamPath = context.getFileStreamPath(str);
        if (str3 == null) {
            return false;
        }
        if (TextUtils.equals(str3, str2) && fileStreamPath.isFile() && fileStreamPath.exists()) {
            return false;
        }
        SimpleRequest.StreamContent streamContent = null;
        try {
            streamContent = SimpleRequest.getAsStream(str3, null, null);
        } catch (IOException e) {
            AccountLog.e("UserInfoSaver", "IO error when download avatar", e);
        } catch (AccessDeniedException e2) {
            AccountLog.e("UserInfoSaver", "access denied when download avatar", e2);
        } catch (AuthenticationFailureException e3) {
            AccountLog.e("UserInfoSaver", "auth failed when download avatar", e3);
        }
        if (streamContent == null) {
            return false;
        }
        try {
            if (ein.O000000o(context, streamContent.getStream(), str) != null) {
                streamContent.closeStream();
                return true;
            }
        } catch (IOException e4) {
            AccountLog.e("UserInfoSaver", "failed to save avatar", e4);
        } catch (Throwable th) {
            streamContent.closeStream();
            throw th;
        }
        streamContent.closeStream();
        return false;
    }
}
