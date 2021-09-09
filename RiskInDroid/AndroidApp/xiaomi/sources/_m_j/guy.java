package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.framework.page.EmptyPlaceholderActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class guy implements guz {
    public final void alertFastConnectSuccessDialog(Activity activity, gul gul) {
    }

    public final void checkAndShow(CommonActivity commonActivity) {
    }

    public final void checkAppUpdate(Activity activity) {
    }

    public final void checkFeedback() {
    }

    public final void checkModelUpdate(Activity activity) {
    }

    public final void checkNewMessage() {
    }

    public final void checkNewMessageForProfile(long j, int i) {
    }

    public final void checkPluginUpdate() {
    }

    public final void checkRnConfigUpdate() {
    }

    public final void checkRnSdkUpdate() {
    }

    public final void clearRedPointListener() {
    }

    public final void clearRedPointListenerOld() {
    }

    public final boolean clickCommonMessage(JSONObject jSONObject) {
        return false;
    }

    public final long getHomeId(gul gul) {
        return 0;
    }

    public final long getHomeOwner(gul gul) {
        return 0;
    }

    public final Map<String, gus> getRedPointViewMap() {
        return null;
    }

    public final Device getShareMessageDevice(gul gul) {
        return null;
    }

    public final int getShareMessageInvitedId(gul gul) {
        return 0;
    }

    public final void gotoMyScene() {
    }

    public final void ignoreThisNewVersion() {
    }

    public final boolean isHomeShareMessage(gul gul) {
        return false;
    }

    public final boolean isShareMessage(gul gul) {
        return false;
    }

    public final void messageCenterDestroy() {
    }

    public final void miuiP0msgResolver(Context context, Intent intent, String str) {
    }

    public final void notifyRedPointChangedOld(String str) {
    }

    public final void notifyViewClicked(String str) {
    }

    public final void registerListener(String str, gup gup) {
    }

    public final void registerListenerOld(String str, gut gut) {
    }

    public final void removeDeviceAllPushMessages(String str) {
    }

    public final void removeRedPointView(String str) {
    }

    public final void removeRedPointViewOld(String str) {
    }

    public final void setAllModelUpdateIgnore() {
    }

    public final void setAllPluginUpdateIgnore() {
    }

    public final void setRedPointView(String str, gus gus) {
    }

    public final void setRedPointViewOld(String str, gus gus) {
    }

    public final void setSignStateTodayIgnore() {
    }

    public final void setUserInfoToSecurityCenter(Context context, boolean z, String str, String str2) {
    }

    public final void unregisterListener(String str, gup gup) {
    }

    public final void unregisterListenerOld(String str, gut gut) {
    }

    public final gul getShareMessageByRecord(MessageRecord messageRecord) {
        return new gul() {
            /* class _m_j.guy.AnonymousClass1 */

            public final void O000000o(TextView textView) {
            }

            public final void O000000o(SimpleDraweeView simpleDraweeView) {
            }

            public final void O000000o(XQProgressDialog xQProgressDialog) {
            }

            public final void O00000Oo(TextView textView) {
            }

            public final boolean O00000Oo() {
                return false;
            }

            public final String O00000o0() {
                return null;
            }

            public final void O00000o0(TextView textView) {
            }
        };
    }

    public final gul getHomeShareMessageByRecord(MessageRecord messageRecord) {
        return new gul() {
            /* class _m_j.guy.AnonymousClass2 */

            public final void O000000o(TextView textView) {
            }

            public final void O000000o(SimpleDraweeView simpleDraweeView) {
            }

            public final void O000000o(XQProgressDialog xQProgressDialog) {
            }

            public final void O00000Oo(TextView textView) {
            }

            public final boolean O00000Oo() {
                return false;
            }

            public final String O00000o0() {
                return null;
            }

            public final void O00000o0(TextView textView) {
            }
        };
    }

    public final gul getHomeFastConnectMessageByRecord(MessageRecord messageRecord) {
        return new gul() {
            /* class _m_j.guy.AnonymousClass3 */

            public final void O000000o(TextView textView) {
            }

            public final void O000000o(SimpleDraweeView simpleDraweeView) {
            }

            public final void O000000o(XQProgressDialog xQProgressDialog) {
            }

            public final void O00000Oo(TextView textView) {
            }

            public final boolean O00000Oo() {
                return false;
            }

            public final String O00000o0() {
                return null;
            }

            public final void O00000o0(TextView textView) {
            }
        };
    }

    public final Class<?> getMessageCenterActivity() {
        return EmptyPlaceholderActivity.class;
    }

    public final Class<?> getMessageCenterDeviceListActivityNew() {
        return EmptyPlaceholderActivity.class;
    }

    public final List<PluginDownloadTask> getLastCheckUpdateInfos() {
        return new ArrayList();
    }
}
