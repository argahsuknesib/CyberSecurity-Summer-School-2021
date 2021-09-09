package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

class MediaControllerCompatApi21 {

    public interface Callback {
        void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5);

        void onExtrasChanged(Bundle bundle);

        void onMetadataChanged(Object obj);

        void onPlaybackStateChanged(Object obj);

        void onQueueChanged(List<?> list);

        void onQueueTitleChanged(CharSequence charSequence);

        void onSessionDestroyed();

        void onSessionEvent(String str, Bundle bundle);
    }

    public static Object fromToken(Context context, Object obj) {
        return new MediaController(context, (MediaSession.Token) obj);
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static void registerCallback(Object obj, Object obj2, Handler handler) {
        ((MediaController) obj).registerCallback((MediaController.Callback) obj2, handler);
    }

    public static void unregisterCallback(Object obj, Object obj2) {
        ((MediaController) obj).unregisterCallback((MediaController.Callback) obj2);
    }

    public static void setMediaController(Activity activity, Object obj) {
        activity.setMediaController((MediaController) obj);
    }

    public static Object getMediaController(Activity activity) {
        return activity.getMediaController();
    }

    public static Object getSessionToken(Object obj) {
        return ((MediaController) obj).getSessionToken();
    }

    public static Object getTransportControls(Object obj) {
        return ((MediaController) obj).getTransportControls();
    }

    public static Object getPlaybackState(Object obj) {
        return ((MediaController) obj).getPlaybackState();
    }

    public static Object getMetadata(Object obj) {
        return ((MediaController) obj).getMetadata();
    }

    public static List<Object> getQueue(Object obj) {
        List<MediaSession.QueueItem> queue = ((MediaController) obj).getQueue();
        if (queue == null) {
            return null;
        }
        return new ArrayList(queue);
    }

    public static CharSequence getQueueTitle(Object obj) {
        return ((MediaController) obj).getQueueTitle();
    }

    public static Bundle getExtras(Object obj) {
        return ((MediaController) obj).getExtras();
    }

    public static int getRatingType(Object obj) {
        return ((MediaController) obj).getRatingType();
    }

    public static long getFlags(Object obj) {
        return ((MediaController) obj).getFlags();
    }

    public static Object getPlaybackInfo(Object obj) {
        return ((MediaController) obj).getPlaybackInfo();
    }

    public static PendingIntent getSessionActivity(Object obj) {
        return ((MediaController) obj).getSessionActivity();
    }

    public static boolean dispatchMediaButtonEvent(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    public static void setVolumeTo(Object obj, int i, int i2) {
        ((MediaController) obj).setVolumeTo(i, i2);
    }

    public static void adjustVolume(Object obj, int i, int i2) {
        ((MediaController) obj).adjustVolume(i, i2);
    }

    public static void sendCommand(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    public static String getPackageName(Object obj) {
        return ((MediaController) obj).getPackageName();
    }

    public static class TransportControls {
        public static void play(Object obj) {
            ((MediaController.TransportControls) obj).play();
        }

        public static void pause(Object obj) {
            ((MediaController.TransportControls) obj).pause();
        }

        public static void stop(Object obj) {
            ((MediaController.TransportControls) obj).stop();
        }

        public static void seekTo(Object obj, long j) {
            ((MediaController.TransportControls) obj).seekTo(j);
        }

        public static void fastForward(Object obj) {
            ((MediaController.TransportControls) obj).fastForward();
        }

        public static void rewind(Object obj) {
            ((MediaController.TransportControls) obj).rewind();
        }

        public static void skipToNext(Object obj) {
            ((MediaController.TransportControls) obj).skipToNext();
        }

        public static void skipToPrevious(Object obj) {
            ((MediaController.TransportControls) obj).skipToPrevious();
        }

        public static void setRating(Object obj, Object obj2) {
            ((MediaController.TransportControls) obj).setRating((Rating) obj2);
        }

        public static void playFromMediaId(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromMediaId(str, bundle);
        }

        public static void playFromSearch(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromSearch(str, bundle);
        }

        public static void skipToQueueItem(Object obj, long j) {
            ((MediaController.TransportControls) obj).skipToQueueItem(j);
        }

        public static void sendCustomAction(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).sendCustomAction(str, bundle);
        }

        private TransportControls() {
        }
    }

    public static class PlaybackInfo {
        public static int getPlaybackType(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getPlaybackType();
        }

        public static AudioAttributes getAudioAttributes(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int getLegacyAudioStream(Object obj) {
            return toLegacyStreamType(getAudioAttributes(obj));
        }

        public static int getVolumeControl(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getVolumeControl();
        }

        public static int getMaxVolume(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getMaxVolume();
        }

        public static int getCurrentVolume(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getCurrentVolume();
        }

        private static int toLegacyStreamType(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                case 14:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }

        private PlaybackInfo() {
        }
    }

    static class CallbackProxy<T extends Callback> extends MediaController.Callback {
        protected final T mCallback;

        public CallbackProxy(T t) {
            this.mCallback = t;
        }

        public void onSessionDestroyed() {
            this.mCallback.onSessionDestroyed();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onSessionEvent(java.lang.String r2, android.os.Bundle r3) {
            /*
                r1 = this;
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r3)
                T r0 = r1.mCallback
                r0.onSessionEvent(r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompatApi21.CallbackProxy.onSessionEvent(java.lang.String, android.os.Bundle):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onPlaybackStateChanged(android.media.session.PlaybackState r2) {
            /*
                r1 = this;
                T r0 = r1.mCallback
                r0.onPlaybackStateChanged(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompatApi21.CallbackProxy.onPlaybackStateChanged(android.media.session.PlaybackState):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onMetadataChanged(android.media.MediaMetadata r2) {
            /*
                r1 = this;
                T r0 = r1.mCallback
                r0.onMetadataChanged(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompatApi21.CallbackProxy.onMetadataChanged(android.media.MediaMetadata):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onQueueChanged(java.util.List<android.media.session.MediaSession.QueueItem> r2) {
            /*
                r1 = this;
                T r0 = r1.mCallback
                r0.onQueueChanged(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompatApi21.CallbackProxy.onQueueChanged(java.util.List):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onQueueTitleChanged(java.lang.CharSequence r2) {
            /*
                r1 = this;
                T r0 = r1.mCallback
                r0.onQueueTitleChanged(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompatApi21.CallbackProxy.onQueueTitleChanged(java.lang.CharSequence):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onExtrasChanged(android.os.Bundle r2) {
            /*
                r1 = this;
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r2)
                T r0 = r1.mCallback
                r0.onExtrasChanged(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompatApi21.CallbackProxy.onExtrasChanged(android.os.Bundle):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onAudioInfoChanged(android.media.session.MediaController.PlaybackInfo r7) {
            /*
                r6 = this;
                T r0 = r6.mCallback
                int r1 = r7.getPlaybackType()
                int r2 = android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(r7)
                int r3 = r7.getVolumeControl()
                int r4 = r7.getMaxVolume()
                int r5 = r7.getCurrentVolume()
                r0.onAudioInfoChanged(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompatApi21.CallbackProxy.onAudioInfoChanged(android.media.session.MediaController$PlaybackInfo):void");
        }
    }

    private MediaControllerCompatApi21() {
    }
}
