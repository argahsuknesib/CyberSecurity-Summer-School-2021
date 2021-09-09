package com.xiaomi.smarthome.camera.api;

import _m_j.fsm;
import _m_j.fso;
import _m_j.gze;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import java.util.List;
import java.util.Map;

public interface ICameraManagerApi extends gze {
    void addDeviceMoreMenuEvent(String str);

    void addExceptionCamerasFloatWindow();

    void addFloatWindow(Device device);

    void cameraAudioConfig();

    void cameraFrameManagerDestroyAllContext(Context context);

    void cameraInfoRefreshManagerClear();

    void cameraPreConnectionNative();

    boolean checkShouldPreloadCameraCameraOperationUtils();

    void destorySubscriberCameraDeviceOpManager();

    void disconnectAllXmStreamClient();

    void forceGetMissTutkVersionConfig(Callback<String> callback);

    Class<?> getAlarmVideoActivityClass(String str, String str2);

    Class<?> getAlarmVideoNormalPlayerActivityClass(String str);

    Class<?> getAlarmVideoPlayerActivityClass(String str);

    Class<?> getAlbumActivityClass();

    Class<?> getAlbumViewerActivityClass();

    Class<?> getCameraHorizontalActivityClass();

    Class<?> getCameraSortActivityClass();

    Class<?> getCloudVideoDownloadActivityClass();

    List<Device> getHomeDeviceList();

    Class<?> getLocalAlarmPlayerActivityClass();

    Class<?> getNASDiscoveryActivityClass();

    Class<?> getNASInfoActivityClass();

    Class<?> getPlaybackVideoActivityClass();

    void getRNConfigCameraRNUtils();

    Class<?> getScreenLinkageDeviceActivityClass();

    List<Device> getShareDeviceList();

    Map<String, Long> getSupportCameraModelsCameraDeviceOpManager();

    void loadAllCameraCloudStorageInfoFromServer(fsm<Void, fso> fsm);

    void openDevicePinVerifyDialog(Fragment fragment, Context context, String str, int i);

    void payWithMipayChinaMainland(Context context, String str, boolean z);

    void removeFloatWindow(boolean z);

    void saveSeqToSPCameraOperationUtils();

    void setEnvironment(Context context);

    void setForceUseSoftDecode(boolean z);

    void setFullLogEnable(boolean z);

    void setSaveAppAudioRawData(boolean z);

    void setSaveVideoRawData(boolean z);

    void setSuperResolutionEnable(boolean z);

    void swapCameraDeviceOpManager();

    void updateDevicePropsCameraDeviceOpManager(fsm<Void, fso> fsm);
}
