package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public interface guz {
    void alertFastConnectSuccessDialog(Activity activity, gul gul);

    void checkAndShow(CommonActivity commonActivity);

    void checkAppUpdate(Activity activity);

    void checkFeedback();

    void checkModelUpdate(Activity activity);

    void checkNewMessage();

    void checkNewMessageForProfile(long j, int i);

    void checkPluginUpdate();

    void checkRnConfigUpdate();

    void checkRnSdkUpdate();

    void clearRedPointListener();

    void clearRedPointListenerOld();

    boolean clickCommonMessage(JSONObject jSONObject);

    gul getHomeFastConnectMessageByRecord(MessageRecord messageRecord);

    long getHomeId(gul gul);

    long getHomeOwner(gul gul);

    gul getHomeShareMessageByRecord(MessageRecord messageRecord);

    List<PluginDownloadTask> getLastCheckUpdateInfos();

    Class<?> getMessageCenterActivity();

    Class<?> getMessageCenterDeviceListActivityNew();

    Map<String, gus> getRedPointViewMap();

    gul getShareMessageByRecord(MessageRecord messageRecord);

    Device getShareMessageDevice(gul gul);

    int getShareMessageInvitedId(gul gul);

    void gotoMyScene();

    void ignoreThisNewVersion();

    boolean isHomeShareMessage(gul gul);

    boolean isShareMessage(gul gul);

    void messageCenterDestroy();

    void miuiP0msgResolver(Context context, Intent intent, String str);

    void notifyRedPointChangedOld(String str);

    void notifyViewClicked(String str);

    void registerListener(String str, gup gup);

    void registerListenerOld(String str, gut gut);

    void removeDeviceAllPushMessages(String str);

    void removeRedPointView(String str);

    void removeRedPointViewOld(String str);

    void setAllModelUpdateIgnore();

    void setAllPluginUpdateIgnore();

    void setRedPointView(String str, gus gus);

    void setRedPointViewOld(String str, gus gus);

    void setSignStateTodayIgnore();

    void setUserInfoToSecurityCenter(Context context, boolean z, String str, String str2);

    void unregisterListener(String str, gup gup);

    void unregisterListenerOld(String str, gut gut);
}
