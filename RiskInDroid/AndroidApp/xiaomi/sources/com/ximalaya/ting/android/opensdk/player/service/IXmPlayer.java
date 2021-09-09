package com.ximalaya.ting.android.opensdk.player.service;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.statistic.RecordModel;
import com.ximalaya.ting.android.opensdk.model.token.AccessToken;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher;
import com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher;
import com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack;
import com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback;
import com.ximalaya.ting.android.opensdk.player.service.IXmMainDataSupportDataCallback;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher;
import com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IXmPlayer extends IInterface {
    void addPlayList(List<Track> list) throws RemoteException;

    void browseAlbums(long j, int i, int i2, long j2) throws RemoteException;

    void clearPlayCache() throws RemoteException;

    void exitSoundAd() throws RemoteException;

    void getAlbumByCategoryId(long j, int i, int i2, long j2) throws RemoteException;

    void getAlbumByCategoryIdAndTag(long j, int i, int i2, int i3, long j2) throws RemoteException;

    void getAlbumInfo(long j, int i, int i2, String str, long j2) throws RemoteException;

    void getAttentionAlbum(int i, String str, long j) throws RemoteException;

    void getCategoriesList(int i, int i2, long j) throws RemoteException;

    void getCategoryModelList(long j) throws RemoteException;

    String getCurPlayUrl() throws RemoteException;

    int getCurrIndex() throws RemoteException;

    long getCurrentTrackPlayedDuration() throws RemoteException;

    int getDefultPageSize() throws RemoteException;

    int getDuration() throws RemoteException;

    String getHistoryPos(String str) throws RemoteException;

    void getHotContent(boolean z, int i, int i2, long j) throws RemoteException;

    String getLastPlayTrackInAlbum(String str) throws RemoteException;

    void getMainHotContent(int i, int i2, int i3, long j) throws RemoteException;

    void getMyCollect(int i, int i2, long j) throws RemoteException;

    void getNewRank(int i, int i2, int i3, long j) throws RemoteException;

    void getNextPlayList() throws RemoteException;

    Map getParam() throws RemoteException;

    void getParseDeviceInfo(long j) throws RemoteException;

    int getPlayCurrPosition() throws RemoteException;

    List<Track> getPlayList(int i) throws RemoteException;

    boolean getPlayListOrder() throws RemoteException;

    int getPlayListSize() throws RemoteException;

    String getPlayMode() throws RemoteException;

    int getPlaySourceType() throws RemoteException;

    int getPlayerStatus() throws RemoteException;

    void getPrePlayList() throws RemoteException;

    void getProvinces(long j) throws RemoteException;

    Radio getRadio() throws RemoteException;

    void getRadioList(int i, long j, int i2, int i3, long j2) throws RemoteException;

    void getRadioSchedules(String str, long j) throws RemoteException;

    void getRank(String str, String str2, int i, long j) throws RemoteException;

    void getRecommendAlbumListByAlbumId(long j, long j2) throws RemoteException;

    void getRecommendAlbumListByTrackId(long j, long j2) throws RemoteException;

    void getSourseLists(String str, int i, int i2, int i3, int i4, long j) throws RemoteException;

    void getSpecialListenList(int i, int i2, int i3, long j) throws RemoteException;

    void getSubjectDetail(int i, int i2, long j, long j2) throws RemoteException;

    void getSuggestAlbums(int i, int i2, boolean z, long j) throws RemoteException;

    void getTags(long j, long j2) throws RemoteException;

    float getTempo() throws RemoteException;

    Track getTrack(int i) throws RemoteException;

    void getTrackDetailInfo(long j, long j2) throws RemoteException;

    Track getTrackInfoSync(long j) throws RemoteException;

    void getTrackListByLastTrack(long j, long j2, int i, long j3) throws RemoteException;

    void getTrackListByTrackIdAtAlbum(long j, long j2, boolean z, long j3) throws RemoteException;

    void getUserInfo(long j) throws RemoteException;

    boolean hasNextSound() throws RemoteException;

    boolean hasPreSound() throws RemoteException;

    boolean haveNextPlayList() throws RemoteException;

    boolean havePrePlayList() throws RemoteException;

    void init(String str, String str2, String str3) throws RemoteException;

    void insertPlayListHead(List<Track> list) throws RemoteException;

    boolean isAdPlaying() throws RemoteException;

    boolean isAdsActive() throws RemoteException;

    boolean isBuffering() throws RemoteException;

    boolean isDLNAState() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isOnlineSource() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void needContinuePlay(boolean z) throws RemoteException;

    boolean pausePlay() throws RemoteException;

    void pausePlayInMillis(long j) throws RemoteException;

    boolean permutePlayList() throws RemoteException;

    boolean play(int i) throws RemoteException;

    boolean playNext() throws RemoteException;

    boolean playPre() throws RemoteException;

    boolean playRadio(Radio radio) throws RemoteException;

    void registeAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException;

    void registeCommonBusinessListener(IXmCommonBusinessDispatcher iXmCommonBusinessDispatcher) throws RemoteException;

    void registeCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException;

    void registeMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException;

    void registePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException;

    void removeListByIndex(int i) throws RemoteException;

    void requestSoundAd() throws RemoteException;

    void resetPlayList() throws RemoteException;

    void resetPlayer() throws RemoteException;

    boolean seekTo(int i) throws RemoteException;

    void setAdsDataHandlerClassName(String str) throws RemoteException;

    void setAppSecret(String str) throws RemoteException;

    void setAppkeyAndPackId(String str, String str2) throws RemoteException;

    void setBreakpointResume(boolean z) throws RemoteException;

    void setCategoryId(int i, long j) throws RemoteException;

    void setCheckAdContent(boolean z) throws RemoteException;

    void setDLNAState(boolean z) throws RemoteException;

    void setHistoryPosById(long j, int i) throws RemoteException;

    void setNotification(int i, Notification notification) throws RemoteException;

    void setPageSize(int i) throws RemoteException;

    void setPlayByAlbumTracks(String str, int i, long j) throws RemoteException;

    void setPlayByTrack(String str, long j) throws RemoteException;

    void setPlayCdnConfigureModel(CdnConfigModel cdnConfigModel) throws RemoteException;

    boolean setPlayIndex(int i) throws RemoteException;

    void setPlayList(Map map, List<Track> list) throws RemoteException;

    void setPlayListChangeListener(IXmDataCallback iXmDataCallback) throws RemoteException;

    void setPlayMode(String str) throws RemoteException;

    void setPlayModel(String str, int i, long j) throws RemoteException;

    void setPlayStatisticClassName(String str) throws RemoteException;

    void setPlayerProcessRequestEnvironment(int i) throws RemoteException;

    void setProxy(String str, int i, String str2, Map map) throws RemoteException;

    void setProxyNew(Config config) throws RemoteException;

    void setRecordModel(RecordModel recordModel) throws RemoteException;

    void setSoundTouchAllParams(float f, float f2, float f3) throws RemoteException;

    void setTokenInvalidForSDK(IXmTokenInvalidForSDKCallBack iXmTokenInvalidForSDKCallBack) throws RemoteException;

    void setTokenToPlayForSDK(AccessToken accessToken) throws RemoteException;

    void setVolume(float f, float f2) throws RemoteException;

    boolean startPlay() throws RemoteException;

    boolean stopPlay() throws RemoteException;

    void subscribeAlbum(String str, boolean z, long j) throws RemoteException;

    void unregisteAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException;

    void unregisteCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException;

    void unregisteMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException;

    void unregistePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException;

    void updateTrackDownloadUrlInPlayList(Track track) throws RemoteException;

    boolean updateTrackInPlayList(Track track) throws RemoteException;

    public static abstract class Stub extends Binder implements IXmPlayer {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
        }

        public static IXmPlayer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXmPlayer)) {
                return new Proxy(iBinder);
            }
            return (IXmPlayer) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.ximalaya.ting.android.opensdk.model.track.Track} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.ximalaya.ting.android.opensdk.model.track.Track} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.ximalaya.ting.android.opensdk.model.live.radio.Radio} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: android.app.Notification} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v51, resolved type: com.ximalaya.ting.android.opensdk.model.token.AccessToken} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v54, resolved type: com.ximalaya.ting.android.opensdk.model.statistic.RecordModel} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v57, resolved type: com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v62, resolved type: com.ximalaya.ting.android.opensdk.httputil.Config} */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v65 */
        /* JADX WARN: Type inference failed for: r2v66 */
        /* JADX WARN: Type inference failed for: r2v67 */
        /* JADX WARN: Type inference failed for: r2v68 */
        /* JADX WARN: Type inference failed for: r2v69 */
        /* JADX WARN: Type inference failed for: r2v70 */
        /* JADX WARN: Type inference failed for: r2v71 */
        /* JADX WARN: Type inference failed for: r2v72 */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel2;
            if (i3 != 1598968902) {
                ? r2 = 0;
                boolean z = false;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setProxy(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean playPre = playPre();
                        parcel2.writeNoException();
                        parcel3.writeInt(playPre);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean playNext = playNext();
                        parcel2.writeNoException();
                        parcel3.writeInt(playNext);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean play = play(parcel.readInt());
                        parcel2.writeNoException();
                        parcel3.writeInt(play);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean playIndex = setPlayIndex(parcel.readInt());
                        parcel2.writeNoException();
                        parcel3.writeInt(playIndex);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean startPlay = startPlay();
                        parcel2.writeNoException();
                        parcel3.writeInt(startPlay);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean pausePlay = pausePlay();
                        parcel2.writeNoException();
                        parcel3.writeInt(pausePlay);
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean stopPlay = stopPlay();
                        parcel2.writeNoException();
                        parcel3.writeInt(stopPlay);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean seekTo = seekTo(parcel.readInt());
                        parcel2.writeNoException();
                        parcel3.writeInt(seekTo);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean isOnlineSource = isOnlineSource();
                        parcel2.writeNoException();
                        parcel3.writeInt(isOnlineSource);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean hasPreSound = hasPreSound();
                        parcel2.writeNoException();
                        parcel3.writeInt(hasPreSound);
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean hasNextSound = hasNextSound();
                        parcel2.writeNoException();
                        parcel3.writeInt(hasNextSound);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        int playerStatus = getPlayerStatus();
                        parcel2.writeNoException();
                        parcel3.writeInt(playerStatus);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        int currIndex = getCurrIndex();
                        parcel2.writeNoException();
                        parcel3.writeInt(currIndex);
                        return true;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        int duration = getDuration();
                        parcel2.writeNoException();
                        parcel3.writeInt(duration);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        int playCurrPosition = getPlayCurrPosition();
                        parcel2.writeNoException();
                        parcel3.writeInt(playCurrPosition);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean isPlaying = isPlaying();
                        parcel2.writeNoException();
                        parcel3.writeInt(isPlaying);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean isAdsActive = isAdsActive();
                        parcel2.writeNoException();
                        parcel3.writeInt(isAdsActive);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            r2 = Track.CREATOR.createFromParcel(parcel);
                        }
                        updateTrackDownloadUrlInPlayList(r2);
                        parcel2.writeNoException();
                        if (r2 != 0) {
                            parcel3.writeInt(1);
                            r2.writeToParcel(parcel3, 1);
                        } else {
                            parcel3.writeInt(0);
                        }
                        return true;
                    case 20:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            r2 = Track.CREATOR.createFromParcel(parcel);
                        }
                        boolean updateTrackInPlayList = updateTrackInPlayList(r2);
                        parcel2.writeNoException();
                        parcel3.writeInt(updateTrackInPlayList);
                        if (r2 != 0) {
                            parcel3.writeInt(1);
                            r2.writeToParcel(parcel3, 1);
                        } else {
                            parcel3.writeInt(0);
                        }
                        return true;
                    case 21:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        Track track = getTrack(parcel.readInt());
                        parcel2.writeNoException();
                        if (track != null) {
                            parcel3.writeInt(1);
                            track.writeToParcel(parcel3, 1);
                        } else {
                            parcel3.writeInt(0);
                        }
                        return true;
                    case 22:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        Radio radio = getRadio();
                        parcel2.writeNoException();
                        if (radio != null) {
                            parcel3.writeInt(1);
                            radio.writeToParcel(parcel3, 1);
                        } else {
                            parcel3.writeInt(0);
                        }
                        return true;
                    case 23:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        int playSourceType = getPlaySourceType();
                        parcel2.writeNoException();
                        parcel3.writeInt(playSourceType);
                        return true;
                    case 24:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setPlayMode(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        String playMode = getPlayMode();
                        parcel2.writeNoException();
                        parcel3.writeString(playMode);
                        return true;
                    case 26:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setPageSize(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setPlayList(parcel.readHashMap(getClass().getClassLoader()), parcel.createTypedArrayList(Track.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        addPlayList(parcel.createTypedArrayList(Track.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 29:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            r2 = Radio.CREATOR.createFromParcel(parcel);
                        }
                        boolean playRadio = playRadio(r2);
                        parcel2.writeNoException();
                        parcel3.writeInt(playRadio);
                        return true;
                    case 30:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        List<Track> playList = getPlayList(parcel.readInt());
                        parcel2.writeNoException();
                        parcel3.writeTypedList(playList);
                        return true;
                    case 31:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        Map param = getParam();
                        parcel2.writeNoException();
                        parcel3.writeMap(param);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        int playListSize = getPlayListSize();
                        parcel2.writeNoException();
                        parcel3.writeInt(playListSize);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        clearPlayCache();
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            r2 = (Notification) Notification.CREATOR.createFromParcel(parcel);
                        }
                        setNotification(readInt, r2);
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setAppSecret(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        registePlayerListener(IXmPlayerEventDispatcher.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        unregistePlayerListener(IXmPlayerEventDispatcher.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 38:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        registeAdsListener(IXmAdsEventDispatcher.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        unregisteAdsListener(IXmAdsEventDispatcher.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 40:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        registeCommonBusinessListener(IXmCommonBusinessDispatcher.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 41:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getNextPlayList();
                        parcel2.writeNoException();
                        return true;
                    case 42:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getPrePlayList();
                        parcel2.writeNoException();
                        return true;
                    case 43:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setPlayListChangeListener(IXmDataCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 44:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean permutePlayList = permutePlayList();
                        parcel2.writeNoException();
                        parcel3.writeInt(permutePlayList);
                        return true;
                    case 45:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean playListOrder = getPlayListOrder();
                        parcel2.writeNoException();
                        parcel3.writeInt(playListOrder);
                        return true;
                    case 46:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        String curPlayUrl = getCurPlayUrl();
                        parcel2.writeNoException();
                        parcel3.writeString(curPlayUrl);
                        return true;
                    case 47:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        init(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 48:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        registeCustomDataCallBack(IXmCustomDataCallBack.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 49:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        unregisteCustomDataCallBack(IXmCustomDataCallBack.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 50:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setPlayModel(parcel.readString(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 51:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getSourseLists(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 52:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        browseAlbums(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 53:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setPlayByTrack(parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 54:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setPlayByAlbumTracks(parcel.readString(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 55:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setCategoryId(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 56:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getCategoryModelList(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 57:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        getHotContent(z, parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 58:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getTrackListByLastTrack(parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 59:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        registeMainDataSupportCallBack(IXmMainDataSupportDataCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 60:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        unregisteMainDataSupportCallBack(IXmMainDataSupportDataCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 61:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getUserInfo(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 62:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getMyCollect(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 63:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getAttentionAlbum(parcel.readInt(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 64:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getAlbumInfo(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 65:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getRank(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 66:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getMainHotContent(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 67:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getNewRank(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 68:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        int defultPageSize = getDefultPageSize();
                        parcel2.writeNoException();
                        parcel3.writeInt(defultPageSize);
                        return true;
                    case 69:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getAlbumByCategoryId(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 70:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getParseDeviceInfo(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 71:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setDLNAState(z);
                        parcel2.writeNoException();
                        return true;
                    case 72:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean isDLNAState = isDLNAState();
                        parcel2.writeNoException();
                        parcel3.writeInt(isDLNAState);
                        return true;
                    case 73:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        needContinuePlay(z);
                        parcel2.writeNoException();
                        return true;
                    case 74:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        int readInt2 = parcel.readInt();
                        int readInt3 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        getSuggestAlbums(readInt2, readInt3, z, parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 75:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getSpecialListenList(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 76:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getSubjectDetail(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 77:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        subscribeAlbum(readString, z, parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 78:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getTrackListByTrackIdAtAlbum(parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 79:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getRecommendAlbumListByTrackId(parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 80:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getRecommendAlbumListByAlbumId(parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 81:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getProvinces(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case XiaomiOAuthConstants.VERSION_MINOR:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getRadioList(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 83:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getRadioSchedules(parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 84:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getCategoriesList(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 85:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getAlbumByCategoryIdAndTag(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 86:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getTags(parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 87:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        getTrackDetailInfo(parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 88:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        Track trackInfoSync = getTrackInfoSync(parcel.readLong());
                        parcel2.writeNoException();
                        if (trackInfoSync != null) {
                            parcel3.writeInt(1);
                            trackInfoSync.writeToParcel(parcel3, 1);
                        } else {
                            parcel3.writeInt(0);
                        }
                        return true;
                    case 89:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setTokenInvalidForSDK(IXmTokenInvalidForSDKCallBack.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 90:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            r2 = AccessToken.CREATOR.createFromParcel(parcel);
                        }
                        setTokenToPlayForSDK(r2);
                        parcel2.writeNoException();
                        if (r2 != 0) {
                            parcel3.writeInt(1);
                            r2.writeToParcel(parcel3, 1);
                        } else {
                            parcel3.writeInt(0);
                        }
                        return true;
                    case 91:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            r2 = RecordModel.CREATOR.createFromParcel(parcel);
                        }
                        setRecordModel(r2);
                        parcel2.writeNoException();
                        if (r2 != 0) {
                            parcel3.writeInt(1);
                            r2.writeToParcel(parcel3, 1);
                        } else {
                            parcel3.writeInt(0);
                        }
                        return true;
                    case 92:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setVolume(parcel.readFloat(), parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 93:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setPlayStatisticClassName(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 94:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setAdsDataHandlerClassName(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 95:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            r2 = CdnConfigModel.CREATOR.createFromParcel(parcel);
                        }
                        setPlayCdnConfigureModel(r2);
                        parcel2.writeNoException();
                        return true;
                    case 96:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        resetPlayList();
                        parcel2.writeNoException();
                        return true;
                    case 97:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        removeListByIndex(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 98:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        String historyPos = getHistoryPos(parcel.readString());
                        parcel2.writeNoException();
                        parcel3.writeString(historyPos);
                        return true;
                    case 99:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setHistoryPosById(parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 100:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        String lastPlayTrackInAlbum = getLastPlayTrackInAlbum(parcel.readString());
                        parcel2.writeNoException();
                        parcel3.writeString(lastPlayTrackInAlbum);
                        return true;
                    case 101:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setPlayerProcessRequestEnvironment(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 102:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setSoundTouchAllParams(parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 103:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        requestSoundAd();
                        parcel2.writeNoException();
                        return true;
                    case 104:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        pausePlayInMillis(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 105:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean isAdPlaying = isAdPlaying();
                        parcel2.writeNoException();
                        parcel3.writeInt(isAdPlaying);
                        return true;
                    case 106:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean haveNextPlayList = haveNextPlayList();
                        parcel2.writeNoException();
                        parcel3.writeInt(haveNextPlayList);
                        return true;
                    case 107:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean havePrePlayList = havePrePlayList();
                        parcel2.writeNoException();
                        parcel3.writeInt(havePrePlayList);
                        return true;
                    case 108:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean isBuffering = isBuffering();
                        parcel2.writeNoException();
                        parcel3.writeInt(isBuffering);
                        return true;
                    case 109:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            r2 = Config.CREATOR.createFromParcel(parcel);
                        }
                        setProxyNew(r2);
                        parcel2.writeNoException();
                        if (r2 != 0) {
                            parcel3.writeInt(1);
                            r2.writeToParcel(parcel3, 1);
                        } else {
                            parcel3.writeInt(0);
                        }
                        return true;
                    case 110:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        exitSoundAd();
                        parcel2.writeNoException();
                        return true;
                    case 111:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setBreakpointResume(z);
                        parcel2.writeNoException();
                        return true;
                    case 112:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        boolean isLoading = isLoading();
                        parcel2.writeNoException();
                        parcel3.writeInt(isLoading);
                        return true;
                    case 113:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        resetPlayer();
                        parcel2.writeNoException();
                        return true;
                    case 114:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setCheckAdContent(z);
                        parcel2.writeNoException();
                        return true;
                    case 115:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        insertPlayListHead(parcel.createTypedArrayList(Track.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 116:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        long currentTrackPlayedDuration = getCurrentTrackPlayedDuration();
                        parcel2.writeNoException();
                        parcel3.writeLong(currentTrackPlayedDuration);
                        return true;
                    case 117:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        float tempo = getTempo();
                        parcel2.writeNoException();
                        parcel3.writeFloat(tempo);
                        return true;
                    case 118:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                        setAppkeyAndPackId(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel3.writeString("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                return true;
            }
        }

        static class Proxy implements IXmPlayer {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.ximalaya.ting.android.opensdk.player.service.IXmPlayer";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void setProxy(String str, int i, String str2, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean playPre() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean playNext() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean play(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setPlayIndex(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean startPlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean pausePlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean stopPlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean seekTo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isOnlineSource() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasPreSound() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasNextSound() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPlayerStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getCurrIndex() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getDuration() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPlayCurrPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isPlaying() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isAdsActive() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateTrackDownloadUrlInPlayList(Track track) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    if (track != null) {
                        obtain.writeInt(1);
                        track.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        track.O000000o(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean updateTrackInPlayList(Track track) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = true;
                    if (track != null) {
                        obtain.writeInt(1);
                        track.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    if (obtain2.readInt() != 0) {
                        track.O000000o(obtain2);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Track getTrack(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Track.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Radio getRadio() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Radio.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPlaySourceType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayMode(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getPlayMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPageSize(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayList(Map map, List<Track> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeMap(map);
                    obtain.writeTypedList(list);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addPlayList(List<Track> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeTypedList(list);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean playRadio(Radio radio) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = true;
                    if (radio != null) {
                        obtain.writeInt(1);
                        radio.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<Track> getPlayList(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(Track.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Map getParam() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPlayListSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearPlayCache() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setNotification(int i, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAppSecret(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmPlayerEventDispatcher != null ? iXmPlayerEventDispatcher.asBinder() : null);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregistePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmPlayerEventDispatcher != null ? iXmPlayerEventDispatcher.asBinder() : null);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registeAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmAdsEventDispatcher != null ? iXmAdsEventDispatcher.asBinder() : null);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisteAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmAdsEventDispatcher != null ? iXmAdsEventDispatcher.asBinder() : null);
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registeCommonBusinessListener(IXmCommonBusinessDispatcher iXmCommonBusinessDispatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmCommonBusinessDispatcher != null ? iXmCommonBusinessDispatcher.asBinder() : null);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getNextPlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getPrePlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayListChangeListener(IXmDataCallback iXmDataCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmDataCallback != null ? iXmDataCallback.asBinder() : null);
                    this.mRemote.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean permutePlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getPlayListOrder() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getCurPlayUrl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void init(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registeCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmCustomDataCallBack != null ? iXmCustomDataCallBack.asBinder() : null);
                    this.mRemote.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisteCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmCustomDataCallBack != null ? iXmCustomDataCallBack.asBinder() : null);
                    this.mRemote.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayModel(String str, int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getSourseLists(String str, int i, int i2, int i3, int i4, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeLong(j);
                    this.mRemote.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void browseAlbums(long j, int i, int i2, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j2);
                    this.mRemote.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayByTrack(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.mRemote.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayByAlbumTracks(String str, int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCategoryId(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getCategoryModelList(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    this.mRemote.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getHotContent(boolean z, int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.mRemote.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getTrackListByLastTrack(long j, long j2, int i, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeInt(i);
                    obtain.writeLong(j3);
                    this.mRemote.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registeMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmMainDataSupportDataCallback != null ? iXmMainDataSupportDataCallback.asBinder() : null);
                    this.mRemote.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisteMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmMainDataSupportDataCallback != null ? iXmMainDataSupportDataCallback.asBinder() : null);
                    this.mRemote.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getUserInfo(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    this.mRemote.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getMyCollect(int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.mRemote.transact(62, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAttentionAlbum(int i, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.mRemote.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAlbumInfo(long j, int i, int i2, String str, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeLong(j2);
                    this.mRemote.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getRank(String str, String str2, int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getMainHotContent(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    this.mRemote.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getNewRank(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    this.mRemote.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getDefultPageSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(68, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAlbumByCategoryId(long j, int i, int i2, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j2);
                    this.mRemote.transact(69, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getParseDeviceInfo(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    this.mRemote.transact(70, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDLNAState(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(71, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isDLNAState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(72, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void needContinuePlay(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(73, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getSuggestAlbums(int i, int i2, boolean z, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeLong(j);
                    this.mRemote.transact(74, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getSpecialListenList(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    this.mRemote.transact(75, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getSubjectDetail(int i, int i2, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(76, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void subscribeAlbum(String str, boolean z, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeLong(j);
                    this.mRemote.transact(77, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getTrackListByTrackIdAtAlbum(long j, long j2, boolean z, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeLong(j3);
                    this.mRemote.transact(78, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getRecommendAlbumListByTrackId(long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(79, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getRecommendAlbumListByAlbumId(long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(80, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getProvinces(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    this.mRemote.transact(81, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getRadioList(int i, long j, int i2, int i3, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j2);
                    this.mRemote.transact(82, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getRadioSchedules(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.mRemote.transact(83, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getCategoriesList(int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.mRemote.transact(84, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAlbumByCategoryIdAndTag(long j, int i, int i2, int i3, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j2);
                    this.mRemote.transact(85, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getTags(long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(86, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getTrackDetailInfo(long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(87, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Track getTrackInfoSync(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    this.mRemote.transact(88, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Track.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setTokenInvalidForSDK(IXmTokenInvalidForSDKCallBack iXmTokenInvalidForSDKCallBack) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeStrongBinder(iXmTokenInvalidForSDKCallBack != null ? iXmTokenInvalidForSDKCallBack.asBinder() : null);
                    this.mRemote.transact(89, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setTokenToPlayForSDK(AccessToken accessToken) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    if (accessToken != null) {
                        obtain.writeInt(1);
                        accessToken.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(90, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        accessToken.O000000o(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRecordModel(RecordModel recordModel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    if (recordModel != null) {
                        obtain.writeInt(1);
                        recordModel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(91, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        recordModel.O000000o(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setVolume(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.mRemote.transact(92, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayStatisticClassName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    this.mRemote.transact(93, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAdsDataHandlerClassName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    this.mRemote.transact(94, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayCdnConfigureModel(CdnConfigModel cdnConfigModel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    if (cdnConfigModel != null) {
                        obtain.writeInt(1);
                        cdnConfigModel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(95, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resetPlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(96, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeListByIndex(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    this.mRemote.transact(97, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getHistoryPos(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    this.mRemote.transact(98, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setHistoryPosById(long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    this.mRemote.transact(99, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getLastPlayTrackInAlbum(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    this.mRemote.transact(100, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayerProcessRequestEnvironment(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(i);
                    this.mRemote.transact(101, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSoundTouchAllParams(float f, float f2, float f3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    obtain.writeFloat(f3);
                    this.mRemote.transact(102, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestSoundAd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(103, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pausePlayInMillis(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeLong(j);
                    this.mRemote.transact(104, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isAdPlaying() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(105, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean haveNextPlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(106, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean havePrePlayList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(107, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isBuffering() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(108, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setProxyNew(Config config) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    if (config != null) {
                        obtain.writeInt(1);
                        config.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(109, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        config.O000000o(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void exitSoundAd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(110, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setBreakpointResume(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(111, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLoading() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    boolean z = false;
                    this.mRemote.transact(112, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resetPlayer() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(113, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCheckAdContent(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(114, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void insertPlayListHead(List<Track> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeTypedList(list);
                    this.mRemote.transact(115, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getCurrentTrackPlayedDuration() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(116, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getTempo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    this.mRemote.transact(117, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAppkeyAndPackId(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(118, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
