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
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public interface hol {
    void buildExtra(SceneInfo sceneInfo, Callback<SceneInfo> callback);

    void builderLocalScene(DeviceStat deviceStat, String str, MessageCallback messageCallback);

    fsn changeCommonUsedSceneOrder(Context context, String str, List<Long> list, fsm<JSONObject, fso> fsm);

    void clearCreateSceneManager();

    void clearInitDeviceRecommendSceneHelper();

    void clearLiteSceneManager();

    void clearRecommendSceneManager();

    void clearSceneManager();

    void clearScenedata();

    void createAndSaveSceneFrom(PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem, String str, hqy hqy);

    hoo createSceneTabFragment();

    fsn delScene(Context context, String str, fsm<JSONObject, fso> fsm);

    void delScenes(List<String> list, Callback callback);

    void destroyLiteSceneManager();

    void destroyRecSceneManager();

    void destroySceneManager();

    void editScenes(List<String> list, Callback callback);

    hrb filterSpecInstanceBy(SpecDevice specDevice, int i, String str, int i2, Object obj, int i3, JSONArray jSONArray);

    String filterSpecInstanceBy(String str, String str2, String str3);

    int getCachedCustomSceneSize();

    fsn getCommonUsedSceneList(Context context, String str, fsm<List<CommonUsedScene>, fso> fsm);

    Class<?> getCreateSceneFromRecommendActivityClass();

    int getCustomSceneSizeByDid(String str);

    String getDegreeConfig(String str);

    String getDeviceDisplayName(String str, int i, int i2);

    Class<?> getDeviceSceneActivity();

    List<Device> getDevicesByHomeId(String str);

    JSONObject getHome(String str);

    Pair<String, String> getHomeByDevice(String str);

    Intent getIntentFrom(Context context, String str, String str2);

    int getLiteSceneSize();

    int getLiteSceneSizeByDid(String str);

    Class<?> getOperationCommonWebViewActivityClass();

    Class<?> getPluginRecommendSceneActivityClass();

    void getPluginRecommendSceneInitDevice(String str, String str2, fsm<ArrayList<hog>, fso> fsm);

    void getRecSceneDetailBy(String str, String str2, Callback callback);

    void getRecTplBy(String str, String str2, Callback callback);

    Pair<String, String> getRoomByDevice(String str);

    SceneInfo getSceneInfo(JSONObject jSONObject, boolean z);

    List<SceneInfo> getSceneInfosByDid(String str);

    boolean getSceneOnline(String str, String str2);

    String getSceneTabName();

    SpecDevice getSpecDeviceBy(Device device);

    String getSpecValue(Device device, SpecProperty specProperty, String str, Object obj);

    Class<?> getTimerSettingActivityClass();

    fsn getUncommonUsedSceneList(Context context, String str, fsm<List<CommonUsedScene>, fso> fsm);

    boolean isLiteSceneInited();

    boolean isLvMiModel(String str);

    boolean isSceneManagerInited();

    boolean isShowRecSceneInitDeviceStep(Device device);

    boolean isSupportGeo();

    boolean lockCanVisible(Device device);

    Pair<SpecDevice, Integer> matchSpecInstanceBy(String str, String str2, String str3);

    fsn miioGetRecommendScene(Context context, String str, fsm<JSONObject, fso> fsm);

    fsn miioSceneStart(Context context, String str, fsm<Void, fso> fsm);

    void miioSceneUpdate(Context context, String str, String str2, boolean z, fsm fsm);

    void openMapDialog(Activity activity, String str, String str2);

    void openRecommendSceneDetail(Context context, long j, String str, String str2);

    boolean openRecommendSceneDetail(Context context, JSONObject jSONObject);

    void replaceLiteScene(CommonUsedScene commonUsedScene);

    fsn runSpecScene(Context context, long j, fsm<JSONObject, fso> fsm);

    void saveHome(String str, String str2, String str3, String str4, String str5, Callback callback);

    fsn setCommonUse(Context context, String str, List<CommonUsedScene> list, fsm<JSONObject, fso> fsm);

    void setCurrentStepInCreateSceneManager(int i);

    void setGatewayScene(String str, DeviceStat deviceStat, int i, String str2, MessageCallback messageCallback);

    void setNeedGotoMySceneFirst(boolean z);

    void setSceneInCreateSceneManager(Object obj);

    fsn setUncommonUse(Context context, String str, List<CommonUsedScene> list, fsm<JSONObject, fso> fsm);

    void showNotifyOpenGuideDialogForSmartInSceneTab();

    void startCommonTimer(Context context, Intent intent);

    void startCountDownTimer(Context context, Intent intent);

    void startCreateAutoScene(Context context, Intent intent);

    void startDeviceSceneNewActivity(Context context, Intent intent);

    void startEditScene(Context context, Intent intent);

    void startInitDeviceRecSpecSceneActivity(Context context, Intent intent);

    void startNFCActionChoose(Context context, Intent intent);

    void startPluginRecScene(Context context, Intent intent);

    void startRecommendSceneDetailActivityBy(Activity activity, String str, int i);

    boolean toSceneListTabInSceneTab();

    void unregisterCustomSceneCallback(hny hny);

    void unregisterLiteSceneCallback(hny hny);

    fsn updateCommonUseName(Context context, CommonUsedScene commonUsedScene, fsm<JSONObject, fso> fsm);

    void updateCustomScene(String str, hny hny);

    void updateLiteScene();

    void updateLiteScene(hny hny);

    void updatePluginRecommendScenes(String str, IXmPluginHostActivity.AsyncCallback<String> asyncCallback);

    void updateScene15(String str);

    void updateTemplate();

    String validMsgForScene(Context context, long j, String str);
}
