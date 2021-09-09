package com.xiaomi.smarthome.camera.api.defaultImpl;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.camera.api.IRNCameraApi;
import com.xiaomi.smarthome.device.api.DeviceStat;
import java.util.List;

public class DefaultRNCameraApiImpl implements IRNCameraApi {
    public void RNCameraStartRequestData(DeviceStat deviceStat, Intent intent) {
    }

    public void bindBpsDataCallback(String str, String str2) {
    }

    public void bindMoveTypeChangeCallback(String str, String str2) {
    }

    public void bindP2PCommandReceiveWithDid(String str, String str2) {
    }

    public void bindRDTDataReceiveCallback(String str, String str2) {
    }

    public void bindTimelinePlaybackEndListener(String str, String str2) {
    }

    public void callTutkSpecialCmd(String str, String str2, Callback callback) {
    }

    public void cancelDownloadM3U8ToMP4V2(String str, String str2, String str3, boolean z, String str4) {
    }

    public void cancleFrameFilter(String str) {
    }

    public void clearRNCameraFactory() {
    }

    public void convertG711VideoIntoAACVideo(String str, ReadableMap readableMap, Callback callback) {
    }

    public void convertH26xVideoIntoMp4(int i, String str, String str2, String str3, ReadableMap readableMap, Callback callback) {
    }

    public ViewManager createHSVideoViewManager() {
        return null;
    }

    public ViewManager createRNCameraViewManager() {
        return null;
    }

    public ViewManager createRTSPViewManager() {
        return null;
    }

    public int decodeG711(byte[] bArr, int i, int i2, byte[] bArr2) {
        return 0;
    }

    public void decryptBigFile(String str, String str2, String str3, Callback callback) {
    }

    public void decryptSmallFile(String str, String str2, String str3, Callback callback) {
    }

    public void downloadM3U8ToMP4(String str, String str2, String str3, boolean z, String str4, String str5, String str6) {
    }

    public void downloadM3U8ToMP4V2(String str, String str2, String str3, boolean z, String str4, String str5, boolean z2, String str6) {
    }

    public void getCurrentFrameInfo(String str, Callback callback) {
    }

    public int getCurrentSpeakerVolume(String str) {
        return 0;
    }

    public String getFaceImg(String str, String str2, String str3) {
        return null;
    }

    public String getVideoSnapshotUrl(String str, String str2, String str3) {
        return null;
    }

    public boolean inRNExoSoftDecodeList() {
        return false;
    }

    public void initRNCameraFrameSender(DeviceStat deviceStat) {
    }

    public void loadMonitoringDetail(DeviceStat deviceStat, Callback callback) {
    }

    public void markCurrentDeviceHualaiEncrypted(boolean z, String str) {
    }

    public void markCurrrentDeviceRdtDataEncrypted(boolean z, String str) {
    }

    public void openCloudSettingDownloadListPage(Activity activity, String str) {
    }

    public void openFloatWindow(String str, Callback callback) {
    }

    public void release(String str) {
    }

    public void sendAudioData(String str, String str2, int i, String str3, Callback callback) {
    }

    public void sendRDTCommandToDevice(String str, String str2, Callback callback) {
    }

    public void sendServerCmd(String str, int i, String str2, Callback callback) {
    }

    public void sendServerCmdWithByteArray(String str, int i, byte[] bArr, Callback callback) {
    }

    public void setCurrentDeviceIsMissFirmware(String str, boolean z) {
    }

    public void setCurrentDeviceUseFixedRdtChannel(boolean z, String str) {
    }

    public void setCurrentVoiceChangerType(int i, int i2, int i3, String str) {
    }

    public void setFrameFilter(String str, List<Integer> list, String str2) {
    }

    public void setGeneralIjkPlayerEnable(boolean z, String str) {
    }

    public void setHSVideoEnable(boolean z, String str) {
    }

    public void setTimelinePlaybackMode(String str, boolean z) {
    }

    public void showAlarmVideos(DeviceStat deviceStat, int i, boolean z) {
    }

    public void showAlbum(DeviceStat deviceStat, String str) {
    }

    public void showAlbumMediaFile(DeviceStat deviceStat, String str) {
    }

    public void showCloudStorage(DeviceStat deviceStat, boolean z, boolean z2, String str) {
    }

    public void showCloudStorageSetting(DeviceStat deviceStat, String str) {
    }

    public void showFaceRecognize(DeviceStat deviceStat, boolean z, String str, String str2) {
    }

    public void showLastAlbumMediaFile(DeviceStat deviceStat, String str) {
    }

    public void showNASSettingPage(DeviceStat deviceStat) {
    }

    public void showOperationBannerPage(DeviceStat deviceStat, String str) {
    }

    public void showPlaybackVideos(DeviceStat deviceStat, String str) {
    }

    public void snapShot(String str, String str2, Callback callback) {
    }

    public void startConnect(String str, String str2) {
    }

    public void startRNCall(DeviceStat deviceStat) {
    }

    public void startRecord(String str, String str2, String str3, int i, int i2, Callback callback) {
    }

    public void stopRNCall(DeviceStat deviceStat) {
    }

    public void stopRNCameraPlay(DeviceStat deviceStat) {
    }

    public void stopRecord(String str, Callback callback) {
    }

    public void stopRequestRNCameraData(DeviceStat deviceStat) {
    }

    public byte[] encodeG711(byte[] bArr, int i, int i2) {
        return new byte[0];
    }
}
