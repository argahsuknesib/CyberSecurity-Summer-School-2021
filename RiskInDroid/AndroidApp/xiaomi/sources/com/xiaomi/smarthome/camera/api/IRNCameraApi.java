package com.xiaomi.smarthome.camera.api;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.device.api.DeviceStat;
import java.util.List;

public interface IRNCameraApi {
    void RNCameraStartRequestData(DeviceStat deviceStat, Intent intent);

    void bindBpsDataCallback(String str, String str2);

    void bindMoveTypeChangeCallback(String str, String str2);

    void bindP2PCommandReceiveWithDid(String str, String str2);

    void bindRDTDataReceiveCallback(String str, String str2);

    void bindTimelinePlaybackEndListener(String str, String str2);

    void callTutkSpecialCmd(String str, String str2, Callback callback);

    void cancelDownloadM3U8ToMP4V2(String str, String str2, String str3, boolean z, String str4);

    void cancleFrameFilter(String str);

    void clearRNCameraFactory();

    void convertG711VideoIntoAACVideo(String str, ReadableMap readableMap, Callback callback);

    void convertH26xVideoIntoMp4(int i, String str, String str2, String str3, ReadableMap readableMap, Callback callback);

    ViewManager createHSVideoViewManager();

    ViewManager createRNCameraViewManager();

    ViewManager createRTSPViewManager();

    int decodeG711(byte[] bArr, int i, int i2, byte[] bArr2);

    void decryptBigFile(String str, String str2, String str3, Callback callback);

    void decryptSmallFile(String str, String str2, String str3, Callback callback);

    void downloadM3U8ToMP4(String str, String str2, String str3, boolean z, String str4, String str5, String str6);

    void downloadM3U8ToMP4V2(String str, String str2, String str3, boolean z, String str4, String str5, boolean z2, String str6);

    byte[] encodeG711(byte[] bArr, int i, int i2);

    void getCurrentFrameInfo(String str, Callback callback);

    int getCurrentSpeakerVolume(String str);

    String getFaceImg(String str, String str2, String str3);

    String getVideoSnapshotUrl(String str, String str2, String str3);

    boolean inRNExoSoftDecodeList();

    void initRNCameraFrameSender(DeviceStat deviceStat);

    void loadMonitoringDetail(DeviceStat deviceStat, Callback callback);

    void markCurrentDeviceHualaiEncrypted(boolean z, String str);

    void markCurrrentDeviceRdtDataEncrypted(boolean z, String str);

    void openCloudSettingDownloadListPage(Activity activity, String str);

    void openFloatWindow(String str, Callback callback);

    void release(String str);

    void sendAudioData(String str, String str2, int i, String str3, Callback callback);

    void sendRDTCommandToDevice(String str, String str2, Callback callback);

    void sendServerCmd(String str, int i, String str2, Callback callback);

    void sendServerCmdWithByteArray(String str, int i, byte[] bArr, Callback callback);

    void setCurrentDeviceIsMissFirmware(String str, boolean z);

    void setCurrentDeviceUseFixedRdtChannel(boolean z, String str);

    void setCurrentVoiceChangerType(int i, int i2, int i3, String str);

    void setFrameFilter(String str, List<Integer> list, String str2);

    void setGeneralIjkPlayerEnable(boolean z, String str);

    void setHSVideoEnable(boolean z, String str);

    void setTimelinePlaybackMode(String str, boolean z);

    void showAlarmVideos(DeviceStat deviceStat, int i, boolean z);

    void showAlbum(DeviceStat deviceStat, String str);

    void showAlbumMediaFile(DeviceStat deviceStat, String str);

    void showCloudStorage(DeviceStat deviceStat, boolean z, boolean z2, String str);

    void showCloudStorageSetting(DeviceStat deviceStat, String str);

    void showFaceRecognize(DeviceStat deviceStat, boolean z, String str, String str2);

    void showLastAlbumMediaFile(DeviceStat deviceStat, String str);

    void showNASSettingPage(DeviceStat deviceStat);

    void showOperationBannerPage(DeviceStat deviceStat, String str);

    void showPlaybackVideos(DeviceStat deviceStat, String str);

    void snapShot(String str, String str2, Callback callback);

    void startConnect(String str, String str2);

    void startRNCall(DeviceStat deviceStat);

    void startRecord(String str, String str2, String str3, int i, int i2, Callback callback);

    void stopRNCall(DeviceStat deviceStat);

    void stopRNCameraPlay(DeviceStat deviceStat);

    void stopRecord(String str, Callback callback);

    void stopRequestRNCameraData(DeviceStat deviceStat);
}
