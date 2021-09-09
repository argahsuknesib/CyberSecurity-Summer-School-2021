package _m_j;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.mico.MicoMainFragment;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.MicoCapability;
import com.xiaomi.mico.main.MicoMainActivity;
import com.xiaomi.mico.setting.AddressSelectionActivity;
import com.xiaomi.mico.setting.alarm.ring.AlarmRingActivity;
import com.xiaomi.mico.setting.stereo.StereoMainActivity;
import com.xiaomi.mico.tool.embedded.activity.CommonWebActivity;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.mico.MicoHelper;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.List;
import rx.functions.Action1;

@RouterService
public class gvt implements gvy {
    public Intent getAlarmRingIntent(Activity activity, String str, String str2, String str3, String str4, String str5) {
        Remote.Response.AlarmRing alarmRing = new Remote.Response.AlarmRing();
        alarmRing.id = str;
        alarmRing.query = str2;
        alarmRing.tab = str3;
        alarmRing.name = str4;
        return AlarmRingActivity.buildIntent(activity, alarmRing, true, false, str5);
    }

    public gvv parseAlarmRingResult(Intent intent) {
        Remote.Response.AlarmRing alarmRing;
        if (intent == null || (alarmRing = (Remote.Response.AlarmRing) intent.getSerializableExtra("CURRENT_RING")) == null) {
            return null;
        }
        return new gvv(alarmRing.tab, alarmRing.id, alarmRing.name, alarmRing.query);
    }

    public Intent getAddressSelectionIntent(Activity activity, String str, double d, double d2, String str2, String str3, String str4) {
        ThirdPartyResponse.POIResponse pOIResponse = new ThirdPartyResponse.POIResponse();
        pOIResponse.name = str;
        pOIResponse.latitude = d;
        pOIResponse.longitude = d2;
        pOIResponse.city = str2;
        pOIResponse.district = str3;
        Intent intent = new Intent(activity, AddressSelectionActivity.class);
        intent.putExtra("custome_title", str4);
        intent.putExtra("SELECTED_ADDRESS", pOIResponse);
        return intent;
    }

    public gvu parseAddressSelectionResult(Intent intent) {
        ThirdPartyResponse.POIResponse pOIResponse;
        if (intent == null || (pOIResponse = (ThirdPartyResponse.POIResponse) intent.getSerializableExtra("SELECTED_ADDRESS")) == null) {
            return null;
        }
        return new gvu(pOIResponse.name, pOIResponse.latitude, pOIResponse.longitude, pOIResponse.city, pOIResponse.district);
    }

    public void getWifiSpeakerBtSwitchStatus(final Context context, final String str, final fkv<Integer, Integer> fkv) {
        List<Admin.Mico> micoList = MicoManager.getInstance().getMicoList();
        if (micoList == null || micoList.size() == 0) {
            MicoManager.getInstance().getMicoList(new IncompleteApiListener() {
                /* class _m_j.gvt.AnonymousClass1 */

                public final void onSuccess() {
                    gvt.this.doGetWifiSpeakerBtInfo(str, fkv);
                }

                public final void onFailure(ApiError apiError) {
                    gsy.O000000o(6, "MicoApiImpl", "getBluetoothSwitch error:".concat(String.valueOf(apiError)));
                    Toast.makeText(context, (int) R.string.failed_of_load_retry, 1).show();
                }
            }, false);
        } else {
            doGetWifiSpeakerBtInfo(str, fkv);
        }
    }

    public boolean isMeshBtConflict(String str) {
        Admin.Mico micoByMiotDID = MicoManager.getInstance().getMicoByMiotDID(str);
        if (micoByMiotDID == null) {
            return false;
        }
        return micoByMiotDID.hasCapability(MicoCapability.MESH_CONFLICT_CHECK);
    }

    public void disableWifiSpeakerBluetooth(String str) {
        Admin.Mico micoByMiotDID = MicoManager.getInstance().getMicoByMiotDID(str);
        if (micoByMiotDID != null) {
            ApiHelper.enableBluetoothConnectOnly(micoByMiotDID.deviceID, false, new ApiRequest.Listener<Remote.Response.NullInfo>() {
                /* class _m_j.gvt.AnonymousClass2 */

                public final void onFailure(ApiError apiError) {
                    gsy.O00000Oo("MicoApiImpl", "disableWifiSpeakerBluetooth failed");
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    gsy.O00000Oo("MicoApiImpl", "disableWifiSpeakerBluetooth success");
                }
            });
        }
    }

    public void initMicoHelper(Context context) {
        MicoHelper.O000000o(context);
    }

    public void getMicoApplicationInstance() {
        MicoApplication.getInstance();
    }

    public Application.ActivityLifecycleCallbacks getMicoActivityLifecycleMonitor() {
        return MicoApplication.getInstance().getMicoActivityLifecycleMonitor();
    }

    public String getMicoMainFragmentName() {
        return MicoMainFragment.class.getSimpleName();
    }

    public Class<?> getStereoMainActivityClass() {
        return StereoMainActivity.class;
    }

    public Class<?> getMicoMainActivityClass() {
        return MicoMainActivity.class;
    }

    public void refreshServiceTokenBySystemAccountNew(String str, MiServiceTokenInfo miServiceTokenInfo, final MessageCallback messageCallback) {
        try {
            LoginManager.getInstance().refreshServiceToken(str).subscribe(new Action1<String>() {
                /* class _m_j.gvt.AnonymousClass3 */

                public final /* synthetic */ void call(Object obj) {
                    ServiceTokenResult serviceTokenResult = LoginManager.getInstance().getServiceTokenResult();
                    Intent intent = new Intent();
                    intent.putExtra("serviceToken", serviceTokenResult.O00000Oo);
                    intent.putExtra("cUserId", serviceTokenResult.O0000Oo);
                    intent.putExtra("ssecurity", "");
                    MessageCallback messageCallback = messageCallback;
                    if (messageCallback != null) {
                        messageCallback.onSuccess(intent);
                    }
                }
            }, new Action1<Throwable>() {
                /* class _m_j.gvt.AnonymousClass4 */

                public final /* synthetic */ void call(Object obj) {
                    Throwable th = (Throwable) obj;
                    if (messageCallback != null) {
                        LogType logType = LogType.PLUGIN;
                        gsy.O000000o(logType, "rn-plugin-framework", 5, "MRnAppModule", "refreshServiceTokenBySystemAccountNew error:" + th.getMessage());
                        messageCallback.onFailure(-1, "update error");
                    }
                }
            });
        } catch (Exception unused) {
            gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 5, "MRnAppModule", "refreshServiceToken error");
        }
    }

    public Intent buildCommonWebViewIntent(Context context, String str, String str2, boolean z) {
        return CommonWebActivity.buildIntent(context, str, str2, z);
    }

    public void doGetWifiSpeakerBtInfo(String str, final fkv<Integer, Integer> fkv) {
        Admin.Mico micoByMiotDID = MicoManager.getInstance().getMicoByMiotDID(str);
        if (micoByMiotDID == null) {
            gsy.O000000o(5, "MicoApiImpl", "doGetBluetoothSwitch error: micoDevice = null:".concat(String.valueOf(str)));
        } else {
            ApiHelper.getBluetoothInfo(micoByMiotDID.deviceID, new ApiRequest.Listener<Remote.Response.BluetoothResponse>() {
                /* class _m_j.gvt.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    Remote.Response.BluetoothResponse bluetoothResponse = (Remote.Response.BluetoothResponse) obj;
                    gsy.O00000Oo("MicoApiImpl", "getBluetoothSwitch onSuccess:".concat(String.valueOf(bluetoothResponse)));
                    fkv fkv = fkv;
                    if (fkv != null) {
                        try {
                            fkv.call(Integer.valueOf(bluetoothResponse.connect));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                public final void onFailure(ApiError apiError) {
                    gsy.O00000Oo("MicoApiImpl", "getBluetoothSwitch onFailure:".concat(String.valueOf(apiError)));
                }
            });
        }
    }

    public gvz createMicoMainFragment() {
        return new MicoMainFragment();
    }
}
