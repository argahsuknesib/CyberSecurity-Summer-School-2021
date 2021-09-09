package _m_j;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.widget.ImageView;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.XiaomiUserCoreInfo;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.internal.PassportGroupEditText;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.util.List;

public final class eis {
    public static int O000000o(boolean z) {
        return (z ? 144 : NotificationCompat.FLAG_HIGH_PRIORITY) | 1;
    }

    public static XiaomiUserCoreInfo O000000o(Context context, eez eez, List<XiaomiUserCoreInfo.Flag> list) {
        if (eez == null) {
            AccountLog.w("SysHelper", "passportInfo is null");
            return null;
        }
        int i = 0;
        while (i < 2) {
            try {
                return XMPassport.getXiaomiUserCoreInfo(eez, "passportapi", list);
            } catch (InvalidResponseException e) {
                AccountLog.e("SysHelper", "invalid response when get user info", e);
            } catch (CipherException e2) {
                AccountLog.e("SysHelper", "CipherException when get user info", e2);
            } catch (IOException e3) {
                AccountLog.e("SysHelper", "IOException when get user info", e3);
            } catch (AuthenticationFailureException e4) {
                AccountLog.e("SysHelper", "auth failure when get user info", e4);
                eez.O000000o(context);
                i++;
            } catch (AccessDeniedException e5) {
                AccountLog.e("SysHelper", "access denied when get user info", e5);
            }
        }
        return null;
    }

    public static void O000000o(Activity activity, Fragment fragment, int i) {
        if (activity != null && !activity.isFinishing()) {
            try {
                FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
                beginTransaction.setTransition(4099);
                beginTransaction.replace(i, fragment);
                beginTransaction.addToBackStack(null);
                beginTransaction.commitAllowingStateLoss();
            } catch (IllegalStateException e) {
                AccountLog.w("SysHelper", "fragment", e);
            }
        }
    }

    public static void O000000o(PassportGroupEditText passportGroupEditText, ImageView imageView, boolean z, Resources resources) {
        if (passportGroupEditText != null && imageView != null) {
            passportGroupEditText.setInputType(O000000o(z));
            passportGroupEditText.setTypeface(Typeface.DEFAULT);
            passportGroupEditText.setSelection(passportGroupEditText.getText().length());
            int i = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                int paddingStart = passportGroupEditText.getPaddingStart();
                int paddingTop = passportGroupEditText.getPaddingTop();
                if (resources != null) {
                    i = resources.getDimensionPixelSize(R.dimen.passport_password_alert_icon_padding_right);
                }
                passportGroupEditText.setPaddingRelative(paddingStart, paddingTop, i, passportGroupEditText.getPaddingBottom());
            } else {
                int paddingLeft = passportGroupEditText.getPaddingLeft();
                int paddingTop2 = passportGroupEditText.getPaddingTop();
                if (resources != null) {
                    i = resources.getDimensionPixelSize(R.dimen.passport_password_alert_icon_padding_right);
                }
                passportGroupEditText.setPadding(paddingLeft, paddingTop2, i, passportGroupEditText.getPaddingBottom());
            }
            imageView.setImageResource(z ? R.drawable.passport_password_show : R.drawable.passport_password_not_show);
        }
    }
}
