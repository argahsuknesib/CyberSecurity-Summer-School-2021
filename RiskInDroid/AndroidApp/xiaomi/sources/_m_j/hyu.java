package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Spanned;
import android.view.View;
import com.xiaomi.smarthome.device.Device;
import java.util.HashSet;

public interface hyu extends gze {
    void clear();

    Intent createFeedbackCommonProblemActivity(Context context);

    hyw createSettingMainfragment();

    void destroyConsumableData();

    String getFeedbackCommonProblemActivityClassName();

    void getMiniProgram(gys gys);

    fsn getRedDotCount(Context context, fsm<Integer, fso> fsm);

    String getSettingMainPageV2Name();

    fsn getShareKey(String str, fsm fsm);

    fsn getSupportWechatAppInfosByModel(HashSet<String> hashSet, fsm<gyt, fso> fsm);

    void getUserInfo();

    void initFloatView();

    void refreshRedPoint(Context context);

    void requestData(Context context, String str, boolean z, gwx gwx);

    void sendFeedBack2(Device device, String str, String str2, String str3, String str4, String str5, String str6, String str7, fsm<Void, fso> fsm);

    void shareProgram(gys gys, String str, boolean z, boolean z2, gyr gyr);

    void showUserLicenseDialog(Activity activity, String str, View.OnClickListener onClickListener, String str2);

    void showUserLicenseDialog(Context context, String str, String str2, String str3, int i, String str4, int i2, View.OnClickListener onClickListener, Intent intent);

    void showUserLicenseDialog(Context context, String str, String str2, String str3, Spanned spanned, String str4, Spanned spanned2, View.OnClickListener onClickListener, Intent intent);

    void showUserLicenseHtmlDialog(Activity activity, String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, String str6);

    void showUserLicenseUriDialog(Activity activity, String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, String str6, Intent intent);

    void showUserLicenseUriDialogV2(Activity activity, String str, boolean z, String str2, String str3, View.OnClickListener onClickListener, String str4, Intent intent);
}
