package android.support.v4.media.session;

import _m_j.oOOO0OO0;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaControllerCompatApi23;
import android.support.v4.media.session.MediaControllerCompatApi24;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.app.ComponentActivity;
import com.google.android.exoplayer2.C;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class MediaControllerCompat {
    private final MediaControllerImpl mImpl;
    private final HashSet<Callback> mRegisteredCallbacks = new HashSet<>();
    private final MediaSessionCompat.Token mToken;

    interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i);

        void adjustVolume(int i, int i2);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        int getShuffleMode();

        TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(Callback callback, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i, int i2);

        void unregisterCallback(Callback callback);
    }

    static class MediaControllerExtraData extends ComponentActivity.O000000o {
        private final MediaControllerCompat mMediaController;

        MediaControllerExtraData(MediaControllerCompat mediaControllerCompat) {
            this.mMediaController = mediaControllerCompat;
        }

        /* access modifiers changed from: package-private */
        public MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    public static void setMediaController(Activity activity, MediaControllerCompat mediaControllerCompat) {
        if (activity instanceof ComponentActivity) {
            ((ComponentActivity) activity).putExtraData(new MediaControllerExtraData(mediaControllerCompat));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Object obj = null;
            if (mediaControllerCompat != null) {
                obj = MediaControllerCompatApi21.fromToken(activity, mediaControllerCompat.getSessionToken().getToken());
            }
            MediaControllerCompatApi21.setMediaController(activity, obj);
        }
    }

    public static MediaControllerCompat getMediaController(Activity activity) {
        Object mediaController;
        if (activity instanceof ComponentActivity) {
            MediaControllerExtraData mediaControllerExtraData = (MediaControllerExtraData) ((ComponentActivity) activity).getExtraData(MediaControllerExtraData.class);
            if (mediaControllerExtraData != null) {
                return mediaControllerExtraData.getMediaController();
            }
            return null;
        } else if (Build.VERSION.SDK_INT < 21 || (mediaController = MediaControllerCompatApi21.getMediaController(activity)) == null) {
            return null;
        } else {
            try {
                return new MediaControllerCompat(activity, MediaSessionCompat.Token.fromToken(MediaControllerCompatApi21.getSessionToken(mediaController)));
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getMediaController.", e);
                return null;
            }
        }
    }

    static void validateCustomAction(String str, Bundle bundle) {
        if (str != null) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1348483723) {
                if (hashCode == 503011406 && str.equals("android.support.v4.media.session.action.UNFOLLOW")) {
                    c = 1;
                }
            } else if (str.equals("android.support.v4.media.session.action.FOLLOW")) {
                c = 0;
            }
            if (c != 0 && c != 1) {
                return;
            }
            if (bundle == null || !bundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + ".");
            }
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        MediaControllerImpl mediaControllerImpl;
        if (mediaSessionCompat != null) {
            this.mToken = mediaSessionCompat.getSessionToken();
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    mediaControllerImpl = new MediaControllerImplApi24(context, this.mToken);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    mediaControllerImpl = new MediaControllerImplApi23(context, this.mToken);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    mediaControllerImpl = new MediaControllerImplApi21(context, this.mToken);
                } else {
                    mediaControllerImpl = new MediaControllerImplBase(this.mToken);
                }
            } catch (RemoteException e) {
                Log.w("MediaControllerCompat", "Failed to create MediaControllerImpl.", e);
                mediaControllerImpl = null;
            }
            this.mImpl = mediaControllerImpl;
            return;
        }
        throw new IllegalArgumentException("session must not be null");
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) throws RemoteException {
        if (token != null) {
            this.mToken = token;
            if (Build.VERSION.SDK_INT >= 24) {
                this.mImpl = new MediaControllerImplApi24(context, token);
            } else if (Build.VERSION.SDK_INT >= 23) {
                this.mImpl = new MediaControllerImplApi23(context, token);
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.mImpl = new MediaControllerImplApi21(context, token);
            } else {
                this.mImpl = new MediaControllerImplBase(token);
            }
        } else {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
    }

    public final TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public final boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.mImpl.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public final PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public final MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public final List<MediaSessionCompat.QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public final void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.addQueueItem(mediaDescriptionCompat);
    }

    public final void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        this.mImpl.addQueueItem(mediaDescriptionCompat, i);
    }

    public final void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.removeQueueItem(mediaDescriptionCompat);
    }

    @Deprecated
    public final void removeQueueItemAt(int i) {
        MediaSessionCompat.QueueItem queueItem;
        List<MediaSessionCompat.QueueItem> queue = getQueue();
        if (queue != null && i >= 0 && i < queue.size() && (queueItem = queue.get(i)) != null) {
            removeQueueItem(queueItem.getDescription());
        }
    }

    public final CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public final Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public final int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public final boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }

    public final int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public final int getShuffleMode() {
        return this.mImpl.getShuffleMode();
    }

    public final long getFlags() {
        return this.mImpl.getFlags();
    }

    public final PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public final PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public final MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    public final Bundle getSessionToken2Bundle() {
        return this.mToken.getSessionToken2Bundle();
    }

    public final void setVolumeTo(int i, int i2) {
        this.mImpl.setVolumeTo(i, i2);
    }

    public final void adjustVolume(int i, int i2) {
        this.mImpl.adjustVolume(i, i2);
    }

    public final void registerCallback(Callback callback) {
        registerCallback(callback, null);
    }

    public final void registerCallback(Callback callback, Handler handler) {
        if (callback != null) {
            if (handler == null) {
                handler = new Handler();
            }
            callback.setHandler(handler);
            this.mImpl.registerCallback(callback, handler);
            this.mRegisteredCallbacks.add(callback);
            return;
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    public final void unregisterCallback(Callback callback) {
        if (callback != null) {
            try {
                this.mRegisteredCallbacks.remove(callback);
                this.mImpl.unregisterCallback(callback);
            } finally {
                callback.setHandler(null);
            }
        } else {
            throw new IllegalArgumentException("callback must not be null");
        }
    }

    public final void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (!TextUtils.isEmpty(str)) {
            this.mImpl.sendCommand(str, bundle, resultReceiver);
            return;
        }
        throw new IllegalArgumentException("command must neither be null nor empty");
    }

    public final boolean isSessionReady() {
        return this.mImpl.isSessionReady();
    }

    public final String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public final Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    public static abstract class Callback implements IBinder.DeathRecipient {
        final Object mCallbackObj;
        MessageHandler mHandler;
        IMediaControllerCallback mIControllerCallback;

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onCaptioningEnabledChanged(boolean z) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int i) {
        }

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21(this));
                return;
            }
            StubCompat stubCompat = new StubCompat(this);
            this.mIControllerCallback = stubCompat;
            this.mCallbackObj = stubCompat;
        }

        public IMediaControllerCallback getIControllerCallback() {
            return this.mIControllerCallback;
        }

        public void binderDied() {
            postToHandler(8, null, null);
        }

        /* access modifiers changed from: package-private */
        public void setHandler(Handler handler) {
            if (handler == null) {
                MessageHandler messageHandler = this.mHandler;
                if (messageHandler != null) {
                    messageHandler.mRegistered = false;
                    messageHandler.removeCallbacksAndMessages(null);
                    this.mHandler = null;
                    return;
                }
                return;
            }
            this.mHandler = new MessageHandler(handler.getLooper());
            this.mHandler.mRegistered = true;
        }

        /* access modifiers changed from: package-private */
        public void postToHandler(int i, Object obj, Bundle bundle) {
            MessageHandler messageHandler = this.mHandler;
            if (messageHandler != null) {
                Message obtainMessage = messageHandler.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        static class StubApi21 implements MediaControllerCompatApi21.Callback {
            private final WeakReference<Callback> mCallback;

            StubApi21(Callback callback) {
                this.mCallback = new WeakReference<>(callback);
            }

            public void onSessionDestroyed() {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onSessionDestroyed();
                }
            }

            public void onSessionEvent(String str, Bundle bundle) {
                Callback callback = this.mCallback.get();
                if (callback == null) {
                    return;
                }
                if (callback.mIControllerCallback == null || Build.VERSION.SDK_INT >= 23) {
                    callback.onSessionEvent(str, bundle);
                }
            }

            public void onPlaybackStateChanged(Object obj) {
                Callback callback = this.mCallback.get();
                if (callback != null && callback.mIControllerCallback == null) {
                    callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
                }
            }

            public void onMetadataChanged(Object obj) {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
                }
            }

            public void onQueueChanged(List<?> list) {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onQueueTitleChanged(charSequence);
                }
            }

            public void onExtrasChanged(Bundle bundle) {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onExtrasChanged(bundle);
                }
            }

            public void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5) {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.onAudioInfoChanged(new PlaybackInfo(i, i2, i3, i4, i5));
                }
            }
        }

        static class StubCompat extends IMediaControllerCallback.Stub {
            private final WeakReference<Callback> mCallback;

            public void onShuffleModeChangedRemoved(boolean z) throws RemoteException {
            }

            StubCompat(Callback callback) {
                this.mCallback = new WeakReference<>(callback);
            }

            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(1, str, bundle);
                }
            }

            public void onSessionDestroyed() throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(8, null, null);
                }
            }

            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(2, playbackStateCompat, null);
                }
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(3, mediaMetadataCompat, null);
                }
            }

            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(5, list, null);
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(6, charSequence, null);
                }
            }

            public void onCaptioningEnabledChanged(boolean z) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(11, Boolean.valueOf(z), null);
                }
            }

            public void onRepeatModeChanged(int i) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(9, Integer.valueOf(i), null);
                }
            }

            public void onShuffleModeChanged(int i) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(12, Integer.valueOf(i), null);
                }
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(7, bundle, null);
                }
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume) : null, null);
                }
            }

            public void onSessionReady() throws RemoteException {
                Callback callback = this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(13, null, null);
                }
            }
        }

        class MessageHandler extends Handler {
            boolean mRegistered = false;

            MessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (this.mRegistered) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.ensureClassLoader(data);
                            Callback.this.onSessionEvent((String) message.obj, data);
                            return;
                        case 2:
                            Callback.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            Callback.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            Callback.this.onAudioInfoChanged((PlaybackInfo) message.obj);
                            return;
                        case 5:
                            Callback.this.onQueueChanged((List) message.obj);
                            return;
                        case 6:
                            Callback.this.onQueueTitleChanged((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.ensureClassLoader(bundle);
                            Callback.this.onExtrasChanged(bundle);
                            return;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                            Callback.this.onSessionDestroyed();
                            return;
                        case 9:
                            Callback.this.onRepeatModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 10:
                        default:
                            return;
                        case 11:
                            Callback.this.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                            return;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            Callback.this.onShuffleModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            Callback.this.onSessionReady();
                            return;
                    }
                }
            }
        }
    }

    public static abstract class TransportControls {
        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setCaptioningEnabled(boolean z);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRating(RatingCompat ratingCompat, Bundle bundle);

        public abstract void setRepeatMode(int i);

        public abstract void setShuffleMode(int i);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();

        TransportControls() {
        }
    }

    public static final class PlaybackInfo {
        private final int mAudioStream;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.mPlaybackType = i;
            this.mAudioStream = i2;
            this.mVolumeControl = i3;
            this.mMaxVolume = i4;
            this.mCurrentVolume = i5;
        }

        public final int getPlaybackType() {
            return this.mPlaybackType;
        }

        public final int getAudioStream() {
            return this.mAudioStream;
        }

        public final int getVolumeControl() {
            return this.mVolumeControl;
        }

        public final int getMaxVolume() {
            return this.mMaxVolume;
        }

        public final int getCurrentVolume() {
            return this.mCurrentVolume;
        }
    }

    static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private TransportControls mTransportControls;

        public Object getMediaController() {
            return null;
        }

        public boolean isSessionReady() {
            return true;
        }

        public MediaControllerImplBase(MediaSessionCompat.Token token) {
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        public void registerCallback(Callback callback, Handler handler) {
            if (callback != null) {
                try {
                    this.mBinder.asBinder().linkToDeath(callback, 0);
                    this.mBinder.registerCallbackListener((IMediaControllerCallback) callback.mCallbackObj);
                    callback.postToHandler(13, null, null);
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    callback.postToHandler(8, null, null);
                }
            } else {
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        public void unregisterCallback(Callback callback) {
            if (callback != null) {
                try {
                    this.mBinder.unregisterCallbackListener((IMediaControllerCallback) callback.mCallbackObj);
                    this.mBinder.asBinder().unlinkToDeath(callback, 0);
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e);
                }
            } else {
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            if (keyEvent != null) {
                try {
                    this.mBinder.sendMediaButton(keyEvent);
                    return false;
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e);
                    return false;
                }
            } else {
                throw new IllegalArgumentException("event may not be null.");
            }
        }

        public TransportControls getTransportControls() {
            if (this.mTransportControls == null) {
                this.mTransportControls = new TransportControlsBase(this.mBinder);
            }
            return this.mTransportControls;
        }

        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.mBinder.getPlaybackState();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
                return null;
            }
        }

        public MediaMetadataCompat getMetadata() {
            try {
                return this.mBinder.getMetadata();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata.", e);
                return null;
            }
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            try {
                return this.mBinder.getQueue();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getQueue.", e);
                return null;
            }
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.mBinder.getFlags() & 4) != 0) {
                    this.mBinder.addQueueItem(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItem.", e);
            }
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            try {
                if ((this.mBinder.getFlags() & 4) != 0) {
                    this.mBinder.addQueueItemAt(mediaDescriptionCompat, i);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItemAt.", e);
            }
        }

        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.mBinder.getFlags() & 4) != 0) {
                    this.mBinder.removeQueueItem(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in removeQueueItem.", e);
            }
        }

        public CharSequence getQueueTitle() {
            try {
                return this.mBinder.getQueueTitle();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getQueueTitle.", e);
                return null;
            }
        }

        public Bundle getExtras() {
            try {
                return this.mBinder.getExtras();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getExtras.", e);
                return null;
            }
        }

        public int getRatingType() {
            try {
                return this.mBinder.getRatingType();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getRatingType.", e);
                return 0;
            }
        }

        public boolean isCaptioningEnabled() {
            try {
                return this.mBinder.isCaptioningEnabled();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e);
                return false;
            }
        }

        public int getRepeatMode() {
            try {
                return this.mBinder.getRepeatMode();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
                return -1;
            }
        }

        public int getShuffleMode() {
            try {
                return this.mBinder.getShuffleMode();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e);
                return -1;
            }
        }

        public long getFlags() {
            try {
                return this.mBinder.getFlags();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getFlags.", e);
                return 0;
            }
        }

        public PlaybackInfo getPlaybackInfo() {
            try {
                ParcelableVolumeInfo volumeAttributes = this.mBinder.getVolumeAttributes();
                return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo.", e);
                return null;
            }
        }

        public PendingIntent getSessionActivity() {
            try {
                return this.mBinder.getLaunchPendingIntent();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", e);
                return null;
            }
        }

        public void setVolumeTo(int i, int i2) {
            try {
                this.mBinder.setVolumeTo(i, i2, null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setVolumeTo.", e);
            }
        }

        public void adjustVolume(int i, int i2) {
            try {
                this.mBinder.adjustVolume(i, i2, null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in adjustVolume.", e);
            }
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.mBinder.sendCommand(str, bundle, new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in sendCommand.", e);
            }
        }

        public String getPackageName() {
            try {
                return this.mBinder.getPackageName();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPackageName.", e);
                return null;
            }
        }
    }

    static class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        public TransportControlsBase(IMediaSession iMediaSession) {
            this.mBinder = iMediaSession;
        }

        public void prepare() {
            try {
                this.mBinder.prepare();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepare.", e);
            }
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            try {
                this.mBinder.prepareFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromMediaId.", e);
            }
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            try {
                this.mBinder.prepareFromSearch(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromSearch.", e);
            }
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            try {
                this.mBinder.prepareFromUri(uri, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromUri.", e);
            }
        }

        public void play() {
            try {
                this.mBinder.play();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in play.", e);
            }
        }

        public void playFromMediaId(String str, Bundle bundle) {
            try {
                this.mBinder.playFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromMediaId.", e);
            }
        }

        public void playFromSearch(String str, Bundle bundle) {
            try {
                this.mBinder.playFromSearch(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromSearch.", e);
            }
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            try {
                this.mBinder.playFromUri(uri, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromUri.", e);
            }
        }

        public void skipToQueueItem(long j) {
            try {
                this.mBinder.skipToQueueItem(j);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToQueueItem.", e);
            }
        }

        public void pause() {
            try {
                this.mBinder.pause();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in pause.", e);
            }
        }

        public void stop() {
            try {
                this.mBinder.stop();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in stop.", e);
            }
        }

        public void seekTo(long j) {
            try {
                this.mBinder.seekTo(j);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in seekTo.", e);
            }
        }

        public void fastForward() {
            try {
                this.mBinder.fastForward();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in fastForward.", e);
            }
        }

        public void skipToNext() {
            try {
                this.mBinder.next();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext.", e);
            }
        }

        public void rewind() {
            try {
                this.mBinder.rewind();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in rewind.", e);
            }
        }

        public void skipToPrevious() {
            try {
                this.mBinder.previous();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToPrevious.", e);
            }
        }

        public void setRating(RatingCompat ratingCompat) {
            try {
                this.mBinder.rate(ratingCompat);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", e);
            }
        }

        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            try {
                this.mBinder.rateWithExtras(ratingCompat, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", e);
            }
        }

        public void setCaptioningEnabled(boolean z) {
            try {
                this.mBinder.setCaptioningEnabled(z);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setCaptioningEnabled.", e);
            }
        }

        public void setRepeatMode(int i) {
            try {
                this.mBinder.setRepeatMode(i);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setRepeatMode.", e);
            }
        }

        public void setShuffleMode(int i) {
            try {
                this.mBinder.setShuffleMode(i);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setShuffleMode.", e);
            }
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompat.validateCustomAction(str, bundle);
            try {
                this.mBinder.sendCustomAction(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in sendCustomAction.", e);
            }
        }
    }

    static class MediaControllerImplApi21 implements MediaControllerImpl {
        private HashMap<Callback, ExtraCallback> mCallbackMap = new HashMap<>();
        protected final Object mControllerObj;
        final Object mLock = new Object();
        private final List<Callback> mPendingCallbacks = new ArrayList();
        final MediaSessionCompat.Token mSessionToken;

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.mSessionToken = token;
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, this.mSessionToken.getToken());
            if (this.mControllerObj == null) {
                throw new RemoteException();
            } else if (this.mSessionToken.getExtraBinder() == null) {
                requestExtraBinder();
            }
        }

        public final void registerCallback(Callback callback, Handler handler) {
            MediaControllerCompatApi21.registerCallback(this.mControllerObj, callback.mCallbackObj, handler);
            synchronized (this.mLock) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    ExtraCallback extraCallback = new ExtraCallback(callback);
                    this.mCallbackMap.put(callback, extraCallback);
                    callback.mIControllerCallback = extraCallback;
                    try {
                        this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                        callback.postToHandler(13, null, null);
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    }
                } else {
                    callback.mIControllerCallback = null;
                    this.mPendingCallbacks.add(callback);
                }
            }
        }

        public final void unregisterCallback(Callback callback) {
            MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, callback.mCallbackObj);
            synchronized (this.mLock) {
                if (this.mSessionToken.getExtraBinder() != null) {
                    try {
                        ExtraCallback remove = this.mCallbackMap.remove(callback);
                        if (remove != null) {
                            callback.mIControllerCallback = null;
                            this.mSessionToken.getExtraBinder().unregisterCallbackListener(remove);
                        }
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e);
                    }
                } else {
                    this.mPendingCallbacks.remove(callback);
                }
            }
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, keyEvent);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls != null) {
                return new TransportControlsApi21(transportControls);
            }
            return null;
        }

        public PlaybackStateCompat getPlaybackState() {
            if (this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getPlaybackState();
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
                }
            }
            Object playbackState = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            if (playbackState != null) {
                return PlaybackStateCompat.fromPlaybackState(playbackState);
            }
            return null;
        }

        public MediaMetadataCompat getMetadata() {
            Object metadata = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            if (metadata != null) {
                return MediaMetadataCompat.fromMediaMetadata(metadata);
            }
            return null;
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> queue = MediaControllerCompatApi21.getQueue(this.mControllerObj);
            if (queue != null) {
                return MediaSessionCompat.QueueItem.fromQueueItemList(queue);
            }
            return null;
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
                sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
                bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", i);
                sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
                sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.mControllerObj);
        }

        public int getRatingType() {
            if (Build.VERSION.SDK_INT < 22 && this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getRatingType();
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in getRatingType.", e);
                }
            }
            return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        public boolean isCaptioningEnabled() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return false;
            }
            try {
                return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e);
                return false;
            }
        }

        public int getRepeatMode() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return -1;
            }
            try {
                return this.mSessionToken.getExtraBinder().getRepeatMode();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
                return -1;
            }
        }

        public int getShuffleMode() {
            if (this.mSessionToken.getExtraBinder() == null) {
                return -1;
            }
            try {
                return this.mSessionToken.getExtraBinder().getShuffleMode();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e);
                return -1;
            }
        }

        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.mControllerObj);
        }

        public PlaybackInfo getPlaybackInfo() {
            Object playbackInfo = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            if (playbackInfo != null) {
                return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(playbackInfo));
            }
            return null;
        }

        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        public void setVolumeTo(int i, int i2) {
            MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, i, i2);
        }

        public void adjustVolume(int i, int i2) {
            MediaControllerCompatApi21.adjustVolume(this.mControllerObj, i, i2);
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, str, bundle, resultReceiver);
        }

        public boolean isSessionReady() {
            return this.mSessionToken.getExtraBinder() != null;
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        public Object getMediaController() {
            return this.mControllerObj;
        }

        private void requestExtraBinder() {
            sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        /* access modifiers changed from: package-private */
        public void processPendingCallbacksLocked() {
            if (this.mSessionToken.getExtraBinder() != null) {
                for (Callback next : this.mPendingCallbacks) {
                    ExtraCallback extraCallback = new ExtraCallback(next);
                    this.mCallbackMap.put(next, extraCallback);
                    next.mIControllerCallback = extraCallback;
                    try {
                        this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                        next.postToHandler(13, null, null);
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    }
                }
                this.mPendingCallbacks.clear();
            }
        }

        static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.mMediaControllerImpl = new WeakReference<>(mediaControllerImplApi21);
            }

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.mMediaControllerImpl.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.mLock) {
                        mediaControllerImplApi21.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(oOOO0OO0.O000000o(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                        mediaControllerImplApi21.mSessionToken.setSessionToken2Bundle(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                        mediaControllerImplApi21.processPendingCallbacksLocked();
                    }
                }
            }
        }

        static class ExtraCallback extends Callback.StubCompat {
            ExtraCallback(Callback callback) {
                super(callback);
            }

            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }
    }

    static class TransportControlsApi21 extends TransportControls {
        protected final Object mControlsObj;

        public TransportControlsApi21(Object obj) {
            this.mControlsObj = obj;
        }

        public void prepare() {
            sendCustomAction("android.support.v4.media.session.action.PREPARE", (Bundle) null);
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", str);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", bundle2);
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", str);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", bundle2);
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", bundle2);
        }

        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
        }

        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
        }

        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }

        public void seekTo(long j) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, j);
        }

        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
        }

        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
        }

        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
        }

        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
        }

        public void setRating(RatingCompat ratingCompat) {
            MediaControllerCompatApi21.TransportControls.setRating(this.mControlsObj, ratingCompat != null ? ratingCompat.getRating() : null);
        }

        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_RATING", ratingCompat);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.SET_RATING", bundle2);
        }

        public void setCaptioningEnabled(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", z);
            sendCustomAction("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", bundle);
        }

        public void setRepeatMode(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", i);
            sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
        }

        public void setShuffleMode(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", i);
            sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle);
        }

        public void playFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, str, bundle);
        }

        public void playFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, str, bundle);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            if (uri == null || Uri.EMPTY.equals(uri)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", bundle2);
        }

        public void skipToQueueItem(long j) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, j);
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompat.validateCustomAction(customAction.getAction(), bundle);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompat.validateCustomAction(str, bundle);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, str, bundle);
        }
    }

    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls != null) {
                return new TransportControlsApi23(transportControls);
            }
            return null;
        }
    }

    static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object obj) {
            super(obj);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, uri, bundle);
        }
    }

    static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls != null) {
                return new TransportControlsApi24(transportControls);
            }
            return null;
        }
    }

    static class TransportControlsApi24 extends TransportControlsApi23 {
        public TransportControlsApi24(Object obj) {
            super(obj);
        }

        public void prepare() {
            MediaControllerCompatApi24.TransportControls.prepare(this.mControlsObj);
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.mControlsObj, str, bundle);
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.mControlsObj, str, bundle);
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromUri(this.mControlsObj, uri, bundle);
        }
    }
}
