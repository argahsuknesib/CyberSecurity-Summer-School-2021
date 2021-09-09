package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.framework.page.EmptyPlaceholderActivity;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hok implements hol {
    public final void buildExtra(SceneInfo sceneInfo, Callback<SceneInfo> callback) {
    }

    public final void builderLocalScene(DeviceStat deviceStat, String str, MessageCallback messageCallback) {
    }

    public final fsn changeCommonUsedSceneOrder(Context context, String str, List<Long> list, fsm<JSONObject, fso> fsm) {
        return null;
    }

    public final void clearCreateSceneManager() {
    }

    public final void clearInitDeviceRecommendSceneHelper() {
    }

    public final void clearLiteSceneManager() {
    }

    public final void clearRecommendSceneManager() {
    }

    public final void clearSceneManager() {
    }

    public final void clearScenedata() {
    }

    public final void createAndSaveSceneFrom(PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem, String str, hqy hqy) {
    }

    public final fsn delScene(Context context, String str, fsm<JSONObject, fso> fsm) {
        return null;
    }

    public final void delScenes(List<String> list, Callback callback) {
    }

    public final void destroyLiteSceneManager() {
    }

    public final void destroyRecSceneManager() {
    }

    public final void destroySceneManager() {
    }

    public final void editScenes(List<String> list, Callback callback) {
    }

    public final hrb filterSpecInstanceBy(SpecDevice specDevice, int i, String str, int i2, Object obj, int i3, JSONArray jSONArray) {
        return null;
    }

    public final String filterSpecInstanceBy(String str, String str2, String str3) {
        return null;
    }

    public final int getCachedCustomSceneSize() {
        return 0;
    }

    public final fsn getCommonUsedSceneList(Context context, String str, fsm<List<CommonUsedScene>, fso> fsm) {
        return null;
    }

    public final int getCustomSceneSizeByDid(String str) {
        return 0;
    }

    public final String getDegreeConfig(String str) {
        return null;
    }

    public final String getDeviceDisplayName(String str, int i, int i2) {
        return null;
    }

    public final List<Device> getDevicesByHomeId(String str) {
        return null;
    }

    public final JSONObject getHome(String str) {
        return null;
    }

    public final Pair<String, String> getHomeByDevice(String str) {
        return null;
    }

    public final int getLiteSceneSize() {
        return 0;
    }

    public final int getLiteSceneSizeByDid(String str) {
        return 0;
    }

    public final void getPluginRecommendSceneInitDevice(String str, String str2, fsm<ArrayList<hog>, fso> fsm) {
    }

    public final void getRecSceneDetailBy(String str, String str2, Callback callback) {
    }

    public final void getRecTplBy(String str, String str2, Callback callback) {
    }

    public final Pair<String, String> getRoomByDevice(String str) {
        return null;
    }

    public final SceneInfo getSceneInfo(JSONObject jSONObject, boolean z) {
        return null;
    }

    public final List<SceneInfo> getSceneInfosByDid(String str) {
        return null;
    }

    public final boolean getSceneOnline(String str, String str2) {
        return false;
    }

    public final String getSceneTabName() {
        return "SceneTabFragment";
    }

    public final SpecDevice getSpecDeviceBy(Device device) {
        return null;
    }

    public final String getSpecValue(Device device, SpecProperty specProperty, String str, Object obj) {
        return null;
    }

    public final fsn getUncommonUsedSceneList(Context context, String str, fsm<List<CommonUsedScene>, fso> fsm) {
        return null;
    }

    public final boolean isLiteSceneInited() {
        return false;
    }

    public final boolean isLvMiModel(String str) {
        return false;
    }

    public final boolean isSceneManagerInited() {
        return false;
    }

    public final boolean isShowRecSceneInitDeviceStep(Device device) {
        return false;
    }

    public final boolean isSupportGeo() {
        return false;
    }

    public final boolean lockCanVisible(Device device) {
        return false;
    }

    public final Pair<SpecDevice, Integer> matchSpecInstanceBy(String str, String str2, String str3) {
        return null;
    }

    public final fsn miioGetRecommendScene(Context context, String str, fsm<JSONObject, fso> fsm) {
        return null;
    }

    public final fsn miioSceneStart(Context context, String str, fsm<Void, fso> fsm) {
        return null;
    }

    public final void miioSceneUpdate(Context context, String str, String str2, boolean z, fsm fsm) {
    }

    public final void openMapDialog(Activity activity, String str, String str2) {
    }

    public final void openRecommendSceneDetail(Context context, long j, String str, String str2) {
    }

    public final boolean openRecommendSceneDetail(Context context, JSONObject jSONObject) {
        return false;
    }

    public final void replaceLiteScene(CommonUsedScene commonUsedScene) {
    }

    public final fsn runSpecScene(Context context, long j, fsm<JSONObject, fso> fsm) {
        return null;
    }

    public final void saveHome(String str, String str2, String str3, String str4, String str5, Callback callback) {
    }

    public final fsn setCommonUse(Context context, String str, List<CommonUsedScene> list, fsm<JSONObject, fso> fsm) {
        return null;
    }

    public final void setCurrentStepInCreateSceneManager(int i) {
    }

    public final void setGatewayScene(String str, DeviceStat deviceStat, int i, String str2, MessageCallback messageCallback) {
    }

    public final void setNeedGotoMySceneFirst(boolean z) {
    }

    public final void setSceneInCreateSceneManager(Object obj) {
    }

    public final fsn setUncommonUse(Context context, String str, List<CommonUsedScene> list, fsm<JSONObject, fso> fsm) {
        return null;
    }

    public final void showNotifyOpenGuideDialogForSmartInSceneTab() {
    }

    public final void startCommonTimer(Context context, Intent intent) {
    }

    public final void startCountDownTimer(Context context, Intent intent) {
    }

    public final void startCreateAutoScene(Context context, Intent intent) {
    }

    public final void startDeviceSceneNewActivity(Context context, Intent intent) {
    }

    public final void startEditScene(Context context, Intent intent) {
    }

    public final void startInitDeviceRecSpecSceneActivity(Context context, Intent intent) {
    }

    public final void startNFCActionChoose(Context context, Intent intent) {
    }

    public final void startPluginRecScene(Context context, Intent intent) {
    }

    public final void startRecommendSceneDetailActivityBy(Activity activity, String str, int i) {
    }

    public final boolean toSceneListTabInSceneTab() {
        return false;
    }

    public final void unregisterCustomSceneCallback(hny hny) {
    }

    public final void unregisterLiteSceneCallback(hny hny) {
    }

    public final fsn updateCommonUseName(Context context, CommonUsedScene commonUsedScene, fsm<JSONObject, fso> fsm) {
        return null;
    }

    public final void updateCustomScene(String str, hny hny) {
    }

    public final void updateLiteScene() {
    }

    public final void updateLiteScene(hny hny) {
    }

    public final void updatePluginRecommendScenes(String str, IXmPluginHostActivity.AsyncCallback<String> asyncCallback) {
    }

    public final void updateScene15(String str) {
    }

    public final void updateTemplate() {
    }

    public final String validMsgForScene(Context context, long j, String str) {
        return null;
    }

    public final Intent getIntentFrom(Context context, String str, String str2) {
        return new Intent(context, EmptyPlaceholderActivity.class);
    }

    public final Class<?> getDeviceSceneActivity() {
        return EmptyPlaceholderActivity.class;
    }

    public final Class<?> getPluginRecommendSceneActivityClass() {
        return EmptyPlaceholderActivity.class;
    }

    public final Class<?> getOperationCommonWebViewActivityClass() {
        return EmptyPlaceholderActivity.class;
    }

    public final Class<?> getCreateSceneFromRecommendActivityClass() {
        return EmptyPlaceholderActivity.class;
    }

    public final Class<?> getTimerSettingActivityClass() {
        return EmptyPlaceholderActivity.class;
    }

    public final hoo createSceneTabFragment() {
        return new hoq();
    }
}
