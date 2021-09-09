package tv.danmaku.ijk.media.player;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Rect;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.annotations.AccessedByNative;
import tv.danmaku.ijk.media.player.annotations.CalledByNative;
import tv.danmaku.ijk.media.player.misc.IAndroidIO;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

public final class IjkMediaPlayer extends AbstractMediaPlayer {
    public static final String TAG = "tv.danmaku.ijk.media.player.IjkMediaPlayer";
    private static volatile boolean mIsLibLoaded = false;
    private static volatile boolean mIsNativeInitialized = false;
    private static final IjkLibLoader sLocalLibLoader = new IjkLibLoader() {
        /* class tv.danmaku.ijk.media.player.IjkMediaPlayer.AnonymousClass1 */

        public void loadLibrary(String str) throws UnsatisfiedLinkError, SecurityException {
            System.loadLibrary(str);
        }
    };
    private String mDataSource;
    private EventHandler mEventHandler;
    @AccessedByNative
    private int mListenerContext;
    @AccessedByNative
    private long mNativeAndroidIO;
    @AccessedByNative
    private long mNativeMediaDataSource;
    @AccessedByNative
    public long mNativeMediaPlayer;
    @AccessedByNative
    private int mNativeSurfaceTexture;
    private OnControlMessageListener mOnControlMessageListener;
    private OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private OnNativeInvokeListener mOnNativeInvokeListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    public int mVideoHeight;
    public int mVideoSarDen;
    public int mVideoSarNum;
    public int mVideoWidth;
    private PowerManager.WakeLock mWakeLock;

    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i);
    }

    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2);
    }

    public interface OnNativeInvokeListener {
        boolean onNativeInvoke(int i, Bundle bundle);
    }

    private native String _getAudioCodecInfo();

    private static native String _getColorFormatName(int i);

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native float _getPropertyFloat(int i, float f);

    private native long _getPropertyLong(int i, long j);

    private native String _getVideoCodecInfo();

    private native void _pause() throws IllegalStateException;

    private native void _release();

    private native void _reset();

    private native void _setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSourceFd(int i) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setFrameAtTime(String str, long j, long j2, int i, int i2) throws IllegalArgumentException, IllegalStateException;

    private native void _setLoopCount(int i);

    private native void _setOption(int i, String str, long j);

    private native void _setOption(int i, String str, String str2);

    private native void _setPropertyFloat(int i, float f);

    private native void _setPropertyLong(int i, long j);

    private native void _setStreamSelected(int i, boolean z);

    private native void _setVideoSurface(Surface surface);

    private native void _start() throws IllegalStateException;

    private native void _stop() throws IllegalStateException;

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i);

    private native void native_setup(Object obj);

    public final native void _prepareAsync() throws IllegalStateException;

    public final native int getAudioSessionId();

    public final native long getCurrentPosition();

    public final native long getDuration();

    public final boolean isPlayable() {
        return true;
    }

    public final native boolean isPlaying();

    public final native void seekTo(long j) throws IllegalStateException;

    public final void setAudioStreamType(int i) {
    }

    public final void setKeepInBackground(boolean z) {
    }

    public final void setLogEnabled(boolean z) {
    }

    public final native void setVolume(float f, float f2);

    public static void loadLibrariesOnce(IjkLibLoader ijkLibLoader) {
        synchronized (IjkMediaPlayer.class) {
            if (!mIsLibLoaded) {
                if (ijkLibLoader == null) {
                    ijkLibLoader = sLocalLibLoader;
                }
                ijkLibLoader.loadLibrary("ijkffmpeg");
                ijkLibLoader.loadLibrary("ijksdl");
                ijkLibLoader.loadLibrary("ijkplayer");
                mIsLibLoaded = true;
            }
        }
    }

    private static void initNativeOnce() {
        synchronized (IjkMediaPlayer.class) {
            if (!mIsNativeInitialized) {
                native_init();
                mIsNativeInitialized = true;
            }
        }
    }

    public IjkMediaPlayer() {
        this(sLocalLibLoader);
    }

    public IjkMediaPlayer(IjkLibLoader ijkLibLoader) {
        this.mWakeLock = null;
        initPlayer(ijkLibLoader);
    }

    private void initPlayer(IjkLibLoader ijkLibLoader) {
        loadLibrariesOnce(ijkLibLoader);
        initNativeOnce();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        native_setup(new WeakReference(this));
    }

    public final void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    public final void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    public final void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, (Map<String, String>) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        if (r0 == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        if (r0 == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0082, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0085, code lost:
        android.util.Log.d(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "Couldn't open file on client side, trying server side");
        setDataSource(r9.toString(), r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        return;
     */
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            setDataSource(uri.getPath());
        } else if (!"content".equals(scheme) || !"settings".equals(uri.getAuthority()) || (uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri))) != null) {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                assetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
                if (assetFileDescriptor != null) {
                    if (assetFileDescriptor.getDeclaredLength() < 0) {
                        setDataSource(assetFileDescriptor.getFileDescriptor());
                    } else {
                        setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
                    }
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                } else if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
            } catch (SecurityException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th) {
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                throw th;
            }
        } else {
            throw new FileNotFoundException("Failed to resolve default ringtone");
        }
    }

    public final void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = str;
        _setDataSource(str, null, null);
    }

    public final void setDataSource(String str, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : map.entrySet()) {
                sb.append((String) next.getKey());
                sb.append(":");
                if (!TextUtils.isEmpty((String) next.getValue())) {
                    sb.append((String) next.getValue());
                }
                sb.append("\r\n");
                setOption(1, "headers", sb.toString());
                setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,rtp,tcp,tls,udp,ijkurlhook,data");
            }
        }
        setDataSource(str);
    }

    @TargetApi(13)
    public final void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        if (Build.VERSION.SDK_INT < 12) {
            try {
                Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                _setDataSourceFd(declaredField.getInt(fileDescriptor));
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
            try {
                _setDataSourceFd(dup.getFd());
            } finally {
                dup.close();
            }
        }
    }

    private void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException, IllegalArgumentException, IllegalStateException {
        setDataSource(fileDescriptor);
    }

    public final void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setDataSource(iMediaDataSource);
    }

    public final void setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setAndroidIOCallback(iAndroidIO);
    }

    public final String getDataSource() {
        return this.mDataSource;
    }

    public final void prepareAsync() throws IllegalStateException {
        _prepareAsync();
    }

    public final void start() throws IllegalStateException {
        stayAwake(true);
        _start();
    }

    public final void stop() throws IllegalStateException {
        stayAwake(false);
        _stop();
    }

    public final void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
    }

    @SuppressLint({"Wakelock"})
    public final void setWakeMode(Context context, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.mWakeLock.release();
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        this.mWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, IjkMediaPlayer.class.getName());
        this.mWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    public final void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    @SuppressLint({"Wakelock"})
    public final void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    public final IjkTrackInfo[] getTrackInfo() {
        IjkMediaMeta parse;
        Bundle mediaMeta = getMediaMeta();
        if (mediaMeta == null || (parse = IjkMediaMeta.parse(mediaMeta)) == null || parse.mStreams == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<IjkMediaMeta.IjkStreamMeta> it = parse.mStreams.iterator();
        while (it.hasNext()) {
            IjkMediaMeta.IjkStreamMeta next = it.next();
            IjkTrackInfo ijkTrackInfo = new IjkTrackInfo(next);
            if (next.mType.equalsIgnoreCase("video")) {
                ijkTrackInfo.setTrackType(1);
            } else if (next.mType.equalsIgnoreCase("audio")) {
                ijkTrackInfo.setTrackType(2);
            } else if (next.mType.equalsIgnoreCase("timedtext")) {
                ijkTrackInfo.setTrackType(3);
            }
            arrayList.add(ijkTrackInfo);
        }
        return (IjkTrackInfo[]) arrayList.toArray(new IjkTrackInfo[arrayList.size()]);
    }

    public final int getSelectedTrack(int i) {
        long _getPropertyLong;
        if (i == 1) {
            _getPropertyLong = _getPropertyLong(20001, -1);
        } else if (i == 2) {
            _getPropertyLong = _getPropertyLong(20002, -1);
        } else if (i != 3) {
            return -1;
        } else {
            _getPropertyLong = _getPropertyLong(20011, -1);
        }
        return (int) _getPropertyLong;
    }

    public final void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    public final void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    public final int getVideoWidth() {
        return this.mVideoWidth;
    }

    public final int getVideoHeight() {
        return this.mVideoHeight;
    }

    public final int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    public final int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    public final void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        resetListeners();
        _release();
    }

    public final void reset() {
        stayAwake(false);
        _reset();
        this.mEventHandler.removeCallbacksAndMessages(null);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    public final void setLooping(boolean z) {
        boolean z2 = !z;
        setOption(4, "loop", z2 ? 1 : 0);
        _setLoopCount(z2);
    }

    public final boolean isLooping() {
        return _getLoopCount() != 1;
    }

    public final void setSpeed(float f) {
        _setPropertyFloat(10003, f);
    }

    public final float getSpeed(float f) {
        return _getPropertyFloat(10003, 0.0f);
    }

    public final int getVideoDecoder() {
        return (int) _getPropertyLong(20003, 0);
    }

    public final float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    public final float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    public final long getVideoCachedDuration() {
        return _getPropertyLong(20005, 0);
    }

    public final long getAudioCachedDuration() {
        return _getPropertyLong(20006, 0);
    }

    public final long getVideoCachedBytes() {
        return _getPropertyLong(20007, 0);
    }

    public final long getAudioCachedBytes() {
        return _getPropertyLong(20008, 0);
    }

    public final long getVideoCachedPackets() {
        return _getPropertyLong(20009, 0);
    }

    public final long getAudioCachedPackets() {
        return _getPropertyLong(20010, 0);
    }

    public final long getAsyncStatisticBufBackwards() {
        return _getPropertyLong(20201, 0);
    }

    public final long getAsyncStatisticBufForwards() {
        return _getPropertyLong(20202, 0);
    }

    public final long getAsyncStatisticBufCapacity() {
        return _getPropertyLong(20203, 0);
    }

    public final long getTrafficStatisticByteCount() {
        return _getPropertyLong(20204, 0);
    }

    public final long getCacheStatisticPhysicalPos() {
        return _getPropertyLong(20205, 0);
    }

    public final long getCacheStatisticFileForwards() {
        return _getPropertyLong(20206, 0);
    }

    public final long getCacheStatisticFilePos() {
        return _getPropertyLong(20207, 0);
    }

    public final long getCacheStatisticCountBytes() {
        return _getPropertyLong(20208, 0);
    }

    public final long getFileSize() {
        return _getPropertyLong(20209, 0);
    }

    public final long getBitRate() {
        return _getPropertyLong(20100, 0);
    }

    public final long getTcpSpeed() {
        return _getPropertyLong(20200, 0);
    }

    public final long getSeekLoadDuration() {
        return _getPropertyLong(20300, 0);
    }

    public final float getDropFrameRate() {
        return _getPropertyFloat(10007, 0.0f);
    }

    public final MediaInfo getMediaInfo() {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = "ijkplayer";
        String _getVideoCodecInfo = _getVideoCodecInfo();
        if (!TextUtils.isEmpty(_getVideoCodecInfo)) {
            String[] split = _getVideoCodecInfo.split(",");
            if (split.length >= 2) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = split[1];
            } else if (split.length > 0) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = "";
            }
        }
        String _getAudioCodecInfo = _getAudioCodecInfo();
        if (!TextUtils.isEmpty(_getAudioCodecInfo)) {
            String[] split2 = _getAudioCodecInfo.split(",");
            if (split2.length >= 2) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = split2[1];
            } else if (split2.length > 0) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = "";
            }
        }
        try {
            mediaInfo.mMeta = IjkMediaMeta.parse(_getMediaMeta());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return mediaInfo;
    }

    public final void setOption(int i, String str, String str2) {
        _setOption(i, str, str2);
    }

    public final void setOption(int i, String str, long j) {
        _setOption(i, str, j);
    }

    public final Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    public static String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        super.finalize();
    }

    public final void httphookReconnect() {
        _setPropertyLong(20211, 1);
    }

    public final void setCacheShare(int i) {
        _setPropertyLong(20210, (long) i);
    }

    static class EventHandler extends Handler {
        private final WeakReference<IjkMediaPlayer> mWeakPlayer;

        public EventHandler(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(ijkMediaPlayer);
        }

        public void handleMessage(Message message) {
            IjkMediaPlayer ijkMediaPlayer = this.mWeakPlayer.get();
            if (ijkMediaPlayer != null) {
                long j = 0;
                if (ijkMediaPlayer.mNativeMediaPlayer != 0) {
                    int i = message.what;
                    if (i == 0) {
                        return;
                    }
                    if (i == 1) {
                        ijkMediaPlayer.notifyOnPrepared();
                        return;
                    } else if (i == 2) {
                        ijkMediaPlayer.stayAwake(false);
                        ijkMediaPlayer.notifyOnCompletion();
                        return;
                    } else if (i == 3) {
                        long j2 = (long) message.arg1;
                        if (j2 < 0) {
                            j2 = 0;
                        }
                        long duration = ijkMediaPlayer.getDuration();
                        if (duration > 0) {
                            j = (j2 * 100) / duration;
                        }
                        if (j >= 100) {
                            j = 100;
                        }
                        ijkMediaPlayer.notifyOnBufferingUpdate((int) j);
                        return;
                    } else if (i == 4) {
                        ijkMediaPlayer.notifyOnSeekComplete();
                        return;
                    } else if (i == 5) {
                        ijkMediaPlayer.mVideoWidth = message.arg1;
                        ijkMediaPlayer.mVideoHeight = message.arg2;
                        ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.mVideoWidth, ijkMediaPlayer.mVideoHeight, ijkMediaPlayer.mVideoSarNum, ijkMediaPlayer.mVideoSarDen);
                        return;
                    } else if (i != 99) {
                        if (i == 100) {
                            DebugLog.e(IjkMediaPlayer.TAG, "Error (" + message.arg1 + "," + message.arg2 + ")");
                            if (!ijkMediaPlayer.notifyOnError(message.arg1, message.arg2)) {
                                ijkMediaPlayer.notifyOnCompletion();
                            }
                            ijkMediaPlayer.stayAwake(false);
                            return;
                        } else if (i == 200) {
                            if (message.arg1 == 3) {
                                DebugLog.i(IjkMediaPlayer.TAG, "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                            }
                            ijkMediaPlayer.notifyOnInfo(message.arg1, message.arg2);
                            return;
                        } else if (i != 10001) {
                            DebugLog.e(IjkMediaPlayer.TAG, "Unknown message type " + message.what);
                            return;
                        } else {
                            ijkMediaPlayer.mVideoSarNum = message.arg1;
                            ijkMediaPlayer.mVideoSarDen = message.arg2;
                            ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.mVideoWidth, ijkMediaPlayer.mVideoHeight, ijkMediaPlayer.mVideoSarNum, ijkMediaPlayer.mVideoSarDen);
                            return;
                        }
                    } else if (message.obj == null) {
                        ijkMediaPlayer.notifyOnTimedText(null);
                        return;
                    } else {
                        ijkMediaPlayer.notifyOnTimedText(new IjkTimedText(new Rect(0, 0, 1, 1), (String) message.obj));
                        return;
                    }
                }
            }
            DebugLog.w(IjkMediaPlayer.TAG, "IjkMediaPlayer went away with unhandled events");
        }
    }

    @CalledByNative
    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj != null && (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) != null) {
            if (i == 200 && i2 == 2) {
                ijkMediaPlayer.start();
            }
            EventHandler eventHandler = ijkMediaPlayer.mEventHandler;
            if (eventHandler != null) {
                ijkMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj2));
            }
        }
    }

    public final void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    public final void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    @CalledByNative
    private static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        OnControlMessageListener onControlMessageListener;
        DebugLog.ifmt(TAG, "onNativeInvoke %d", Integer.valueOf(i));
        if (obj == null || !(obj instanceof WeakReference)) {
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
        if (ijkMediaPlayer != null) {
            OnNativeInvokeListener onNativeInvokeListener = ijkMediaPlayer.mOnNativeInvokeListener;
            if (onNativeInvokeListener != null && onNativeInvokeListener.onNativeInvoke(i, bundle)) {
                return true;
            }
            if (i != 131079 || (onControlMessageListener = ijkMediaPlayer.mOnControlMessageListener) == null) {
                return false;
            }
            int i2 = bundle.getInt("segment_index", -1);
            if (i2 >= 0) {
                String onControlResolveSegmentUrl = onControlMessageListener.onControlResolveSegmentUrl(i2);
                if (onControlResolveSegmentUrl != null) {
                    bundle.putString("url", onControlResolveSegmentUrl);
                    return true;
                }
                throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
            }
            throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
        }
        throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
    }

    public final void setOnMediaCodecSelectListener(OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    public final void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
    }

    @CalledByNative
    private static String onSelectCodec(Object obj, String str, int i, int i2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || !(obj instanceof WeakReference) || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return null;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = ijkMediaPlayer.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(ijkMediaPlayer, str, i, i2);
    }

    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        @TargetApi(16)
        public String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2) {
            String[] supportedTypes;
            IjkMediaCodecInfo ijkMediaCodecInfo;
            String str2 = str;
            if (Build.VERSION.SDK_INT < 16 || TextUtils.isEmpty(str)) {
                return null;
            }
            Log.i(IjkMediaPlayer.TAG, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str2, Integer.valueOf(i), Integer.valueOf(i2)));
            ArrayList arrayList = new ArrayList();
            int codecCount = MediaCodecList.getCodecCount();
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                Log.d(IjkMediaPlayer.TAG, String.format(Locale.US, "  found codec: %s", codecInfoAt.getName()));
                if (!codecInfoAt.isEncoder() && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                    for (String str3 : supportedTypes) {
                        if (!TextUtils.isEmpty(str3)) {
                            Log.d(IjkMediaPlayer.TAG, String.format(Locale.US, "    mime: %s", str3));
                            if (str3.equalsIgnoreCase(str2) && (ijkMediaCodecInfo = IjkMediaCodecInfo.setupCandidate(codecInfoAt, str2)) != null) {
                                arrayList.add(ijkMediaCodecInfo);
                                Log.i(IjkMediaPlayer.TAG, String.format(Locale.US, "candidate codec: %s rank=%d", codecInfoAt.getName(), Integer.valueOf(ijkMediaCodecInfo.mRank)));
                                ijkMediaCodecInfo.dumpProfileLevels(str2);
                            }
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            IjkMediaCodecInfo ijkMediaCodecInfo2 = (IjkMediaCodecInfo) arrayList.get(0);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                IjkMediaCodecInfo ijkMediaCodecInfo3 = (IjkMediaCodecInfo) it.next();
                if (ijkMediaCodecInfo3.mRank > ijkMediaCodecInfo2.mRank) {
                    ijkMediaCodecInfo2 = ijkMediaCodecInfo3;
                }
            }
            if (ijkMediaCodecInfo2.mRank < 600) {
                Log.w(IjkMediaPlayer.TAG, String.format(Locale.US, "unaccetable codec: %s", ijkMediaCodecInfo2.mCodecInfo.getName()));
                return null;
            }
            Log.i(IjkMediaPlayer.TAG, String.format(Locale.US, "selected codec: %s rank=%d", ijkMediaCodecInfo2.mCodecInfo.getName(), Integer.valueOf(ijkMediaCodecInfo2.mRank)));
            return ijkMediaCodecInfo2.mCodecInfo.getName();
        }
    }
}
