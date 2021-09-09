package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.feedback.FeedbackApi;
import com.xiaomi.smarthome.feedback.FeedbackCommonProblemActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.privacyandlicense.UserLicenseDialog;
import com.xiaomi.smarthome.miio.activity.FloatViewActionHelper$1;
import com.xiaomi.smarthome.miio.activity.FloatViewActionHelper$2;
import com.xiaomi.smarthome.miio.page.SettingMainPageV2;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class gid implements hyu {
    private static final gid INSTANCE = new gid();

    @cug
    public static gid provideInstance() {
        return INSTANCE;
    }

    private gid() {
    }

    public void refreshRedPoint(Context context) {
        gwv.O00000Oo().O000000o(context);
    }

    public void destroyConsumableData() {
        gwv.O00000Oo().O00000o0();
    }

    public void requestData(Context context, String str, boolean z, gwx gwx) {
        gwv.O00000Oo().O000000o(context, str, z, gwx);
    }

    public void requestReset(Context context, String str, String str2, fsm<JSONObject, fso> fsm) {
        gwv.O00000Oo();
        gwv.O000000o(context, str, str2, fsm);
    }

    public void acceptShare(String str, String str2, String str3, fsm fsm) {
        gym O000000o2 = gym.O000000o();
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("share_key", str2);
            jSONObject.put("union_id", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("GET").O00000Oo("/share/accept_wechatshare").O000000o(arrayList).O000000o(), new fss<frw>() {
            /* class _m_j.gym.AnonymousClass9 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return frw.O000000o(jSONObject);
            }
        }, Crypto.RC4, fsm);
    }

    public fsn getShareKey(String str, fsm fsm) {
        return gym.O000000o().O000000o(str, fsm);
    }

    public void shareProgram(gys gys, String str, boolean z, boolean z2, gyr gyr) {
        gym.O000000o().O000000o(gys, str, z, z2, gyr);
    }

    public void getMiniProgram(gys gys) {
        gym O000000o2 = gym.O000000o();
        T t = gys.O00000o0;
        if (t == null) {
            if (O000000o2.O0000OoO != null) {
                O000000o2.O0000OoO.onError(false);
            }
        } else if (t.isOwner()) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(t.model)) {
                arrayList.add(t.model);
            }
            O000000o2.O00000Oo(arrayList);
            O000000o2.O00000oO.add(gys);
            if (O000000o2.O0000OoO != null) {
                O000000o2.O0000OoO.onSuccess(O000000o2.O00000oO, 0, false);
            }
        } else if (O000000o2.O0000OoO != null) {
            O000000o2.O0000OoO.onError(false);
        }
    }

    public void getUserInfo() {
        gym.O000000o().O00000Oo();
    }

    public void clear() {
        gym.O000000o().O00000o0();
    }

    public fsn getSupportWechatAppInfosByModel(HashSet<String> hashSet, fsm<gyt, fso> fsm) {
        return gym.O000000o().O000000o(hashSet, fsm);
    }

    public fsn getRedDotCount(Context context, fsm<Integer, fso> fsm) {
        return FeedbackApi.INSTANCE.getRedDotCount(context, fsm);
    }

    public Intent createFeedbackCommonProblemActivity(Context context) {
        return new Intent(context, FeedbackCommonProblemActivity.class);
    }

    public String getFeedbackCommonProblemActivityClassName() {
        return FeedbackCommonProblemActivity.class.getName();
    }

    public String getSettingMainPageV2Name() {
        return SettingMainPageV2.class.getSimpleName();
    }

    public void showUserLicenseDialog(Context context, String str, String str2, String str3, Spanned spanned, String str4, Spanned spanned2, View.OnClickListener onClickListener, Intent intent) {
        UserLicenseDialog.Builder builder = new UserLicenseDialog.Builder(context);
        builder.f7873O000000o = str2;
        UserLicenseDialog.Builder O000000o2 = builder.O000000o(str3);
        O000000o2.O00000Oo = spanned;
        UserLicenseDialog.Builder O000000o3 = O000000o2.O000000o();
        O000000o3.O00000o0 = spanned2;
        O000000o3.O0000Ooo = intent;
        O000000o3.O0000OoO = str;
        O000000o3.O0000Oo = onClickListener;
        O000000o3.O00000Oo().O000000o();
    }

    public void showUserLicenseDialog(Context context, String str, String str2, String str3, int i, String str4, int i2, View.OnClickListener onClickListener, Intent intent) {
        UserLicenseDialog.Builder builder = new UserLicenseDialog.Builder(context);
        builder.f7873O000000o = str2;
        UserLicenseDialog.Builder O000000o2 = builder.O000000o(str3);
        O000000o2.O0000OOo = i;
        UserLicenseDialog.Builder O000000o3 = O000000o2.O000000o();
        O000000o3.O0000Oo0 = i2;
        O000000o3.O0000Ooo = intent;
        O000000o3.O0000OoO = str;
        O000000o3.O0000Oo = onClickListener;
        O000000o3.O00000Oo().O000000o();
    }

    public void showUserLicenseDialog(Activity activity, String str, View.OnClickListener onClickListener, String str2) {
        UserLicenseDialog.Builder builder = new UserLicenseDialog.Builder(activity);
        builder.f7873O000000o = str;
        activity.getApplicationContext().getString(R.string.dialog_privacy_title);
        UserLicenseDialog.Builder O000000o2 = builder.O000000o();
        O000000o2.O00000o0 = Html.fromHtml(activity.getApplicationContext().getString(R.string.user_privacy_new));
        O000000o2.O0000OoO = str2;
        O000000o2.O0000Oo = onClickListener;
        O000000o2.O00000Oo().O000000o();
    }

    public void showUserLicenseHtmlDialog(Activity activity, String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, String str6) {
        UserLicenseDialog.Builder builder = new UserLicenseDialog.Builder(activity);
        builder.f7873O000000o = str;
        UserLicenseDialog.Builder O000000o2 = builder.O000000o(str2);
        O000000o2.O00000oo = str3;
        UserLicenseDialog.Builder O000000o3 = O000000o2.O000000o();
        O000000o3.O0000O0o = str5;
        O000000o3.O0000OoO = str6;
        O000000o3.O0000Oo = onClickListener;
        O000000o3.O00000Oo().O000000o();
    }

    public void showUserLicenseUriDialog(Activity activity, String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, String str6, Intent intent) {
        UserLicenseDialog.Builder builder = new UserLicenseDialog.Builder(activity);
        builder.f7873O000000o = str;
        UserLicenseDialog.Builder O000000o2 = builder.O000000o(str2);
        O000000o2.O00000o = str3;
        UserLicenseDialog.Builder O000000o3 = O000000o2.O000000o();
        O000000o3.O00000oO = str5;
        O000000o3.O0000OoO = str6;
        O000000o3.O0000Ooo = intent;
        O000000o3.O0000Oo = onClickListener;
        O000000o3.O00000Oo().O000000o();
    }

    public void showUserLicenseUriDialogV2(Activity activity, String str, boolean z, String str2, String str3, View.OnClickListener onClickListener, String str4, Intent intent) {
        if (z) {
            UserLicenseDialog.Builder builder = new UserLicenseDialog.Builder(activity);
            builder.f7873O000000o = str;
            builder.O00000o = str2;
            activity.getString(R.string.dialog_privacy_title);
            UserLicenseDialog.Builder O000000o2 = builder.O000000o();
            O000000o2.O00000oO = str3;
            O000000o2.O0000OoO = str4;
            O000000o2.O0000Ooo = intent;
            O000000o2.O0000Oo = onClickListener;
            O000000o2.O00000Oo().O000000o();
            return;
        }
        UserLicenseDialog.Builder builder2 = new UserLicenseDialog.Builder(activity);
        builder2.f7873O000000o = str;
        UserLicenseDialog.Builder O000000o3 = builder2.O000000o(activity.getString(R.string.dialog_license_title));
        O000000o3.O00000o = str2;
        activity.getString(R.string.dialog_privacy_title);
        UserLicenseDialog.Builder O000000o4 = O000000o3.O000000o();
        O000000o4.O00000oO = str3;
        O000000o4.O0000OoO = str4;
        O000000o4.O0000Ooo = intent;
        O000000o4.O0000Oo = onClickListener;
        O000000o4.O00000Oo().O000000o();
    }

    public hyw createSettingMainfragment() {
        return new SettingMainPageV2();
    }

    public void initFloatView() {
        gwk O000000o2 = gwk.O000000o();
        gns.O000000o(false);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_save_float_view_status");
        intentFilter.addAction("action_go_feed_back_activity");
        ServiceApplication.getApplication().registerReceiver(new FloatViewActionHelper$1(O000000o2), intentFilter);
        IntentFilter intentFilter2 = new IntentFilter("action_on_login_success");
        intentFilter2.addAction("action_on_logout");
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new FloatViewActionHelper$2(O000000o2), intentFilter2);
    }

    public void sendFeedBack2(Device device, String str, String str2, String str3, String str4, String str5, String str6, String str7, fsm<Void, fso> fsm) {
        FeedbackApi.INSTANCE.sendFeedBack2(CommonApplication.getAppContext(), device, str, str2, str3, str4, str5, str6, str7, 0, fsm);
    }
}
