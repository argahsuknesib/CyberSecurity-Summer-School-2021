package com.xiaomi.smarthome.newui;

import _m_j.fno;
import _m_j.fso;
import _m_j.gof;
import _m_j.goq;
import _m_j.gsy;
import _m_j.gth;
import _m_j.gti;
import _m_j.gzx;
import _m_j.han;
import _m_j.hxi;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.iwb;
import _m_j.iwc;
import _m_j.ixe;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.fastvideo.VideoView;
import com.xiaomi.smarthome.fastvideo.decoder.H264Decoder;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.module.blur.JavaBlurProcess;
import com.xiaomi.smarthome.newui.ViewHolderVideoPlayer;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\t\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0004KLMNB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J*\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0006J\u0014\u0010 \u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"J\u0014\u0010#\u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"J\"\u0010$\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u000e2\u0006\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u0006H\u0016J\u0014\u0010(\u001a\u00060)R\u00020*2\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010-\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010/\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\rJ\b\u00100\u001a\u00020\u0019H\u0002J\u0016\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010\u001a\u001a\u00020\rJ\u0018\u00104\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u000eH\u0016J\u0018\u00105\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u00106\u001a\u000207H\u0016J\u0016\u00108\u001a\u00020\u00192\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00190:H\u0002J\u0018\u0010;\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010<\u001a\u000207H\u0002J(\u0010=\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020@H\u0002J\u001e\u0010A\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010B\u001a\u00020\u0015J\"\u0010A\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010C\u001a\u00020\u0006H\u0002J\u0010\u0010D\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0002J*\u0010E\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010<\u001a\u0002072\b\b\u0002\u0010&\u001a\u00020\u0006J\u000e\u0010F\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rJ\u0018\u0010G\u001a\u00020\u00192\u0006\u00102\u001a\u0002032\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0016\u0010H\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u0010\u001a\u001a\u00020\rJ\f\u0010I\u001a\u00020J*\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer;", "Lcom/xiaomi/smarthome/listcamera/CameraFrameManager$FrameCallback;", "Lcom/xiaomi/smarthome/newui/TimeoutHandler$OnTimeout;", "playStateCallback", "Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer$PlayStateChangeCallback;", "allCameraPage", "", "(Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer$PlayStateChangeCallback;Z)V", "connectionKeepHandler", "com/xiaomi/smarthome/newui/ViewHolderVideoPlayer$connectionKeepHandler$1", "Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer$connectionKeepHandler$1;", "lastFrames", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/xiaomi/smarthome/camera/VideoFrame;", "lastFramesTime", "", "muteState", "playState", "Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer$State;", "targets", "Lcom/xiaomi/smarthome/fastvideo/VideoView;", "timeoutHandler", "Lcom/xiaomi/smarthome/newui/TimeoutHandler;", "bindCover", "", "did", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "callback", "Lcom/xiaomi/smarthome/newui/FrescoBitmapCache$Callback;", "blur", "clearConnections", "connectionsMayAlive", "", "dispose", "doCacheFrame", "videoFrame", "blurCover", "haveReceiver", "initFrameReceiverIfNeeded", "Lcom/xiaomi/smarthome/listcamera/CameraFrameManager$FrameContext;", "Lcom/xiaomi/smarthome/listcamera/CameraFrameManager;", "isFrameValid", "isMute", "isPlaying", "isStarted", "isStartedOrPlaying", "logPlayCount", "mute", "context", "Landroid/content/Context;", "onFrameReceived", "onTimeout", "payload", "", "post", "block", "Lkotlin/Function0;", "sendConnectionTimeOutMsg", "keepConnectionWithTimeout", "sendMessage", "cmd", "args", "Landroid/content/Intent;", "startPlay", "videoView", "forceSendInitMsg", "stopConnection", "stopPlay", "syncMuteState", "toggleMute", "unMute", "toBitmap", "Landroid/graphics/Bitmap;", "Companion", "NotInstallProgressCallback", "PlayStateChangeCallback", "State", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewHolderVideoPlayer implements gth.O00000Oo, han.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f10126O000000o = new O000000o((byte) 0);
    public final O00000o0 O00000Oo;
    private final boolean O00000o;
    public final ConcurrentHashMap<String, Boolean> O00000o0 = new ConcurrentHashMap<>();
    private final han O00000oO;
    private final O00000o O00000oo = new O00000o(this, Looper.getMainLooper());
    private final ConcurrentHashMap<String, State> O0000O0o = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, VideoView> O0000OOo = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Long> O0000Oo = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, VideoFrame> O0000Oo0 = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer$PlayStateChangeCallback;", "", "onCaptureNew", "", "did", "", "bitmap", "Landroid/graphics/Bitmap;", "isBlur", "", "onPlayError", "onPlayStart", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O00000o0 {
        void O000000o(String str);

        void O000000o(String str, Bitmap bitmap, boolean z);

        void O00000Oo(String str);
    }

    public ViewHolderVideoPlayer(O00000o0 o00000o0, boolean z) {
        ixe.O00000o(o00000o0, "playStateCallback");
        this.O00000Oo = o00000o0;
        this.O00000o = z;
        Looper mainLooper = Looper.getMainLooper();
        ixe.O00000Oo(mainLooper, "getMainLooper()");
        this.O00000oO = new han(this, mainLooper);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer$Companion;", "", "()V", "FRAME_RATE_1080P", "", "FRAME_RATE_480P", "FRAME_RATE_720P", "FRAME_RATE_AUTO", "PAYLOAD_FINISH_ON_TIMEOUT", "PAYLOAD_RETRY_ON_TIMEOUT", "TAG", "", "TIMEOUT_DURATION", "", "TIMEOUT_RETRY", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer$State;", "", "(Ljava/lang/String;I)V", "Start", "Playing", "Stop", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = $values();
        public static final State Playing = new State("Playing", 1);
        public static final State Start = new State("Start", 0);
        public static final State Stop = new State("Stop", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{Start, Playing, Stop};
        }

        private State(String str, int i) {
        }

        public static State valueOf(String str) {
            ixe.O00000o(str, "value");
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            State[] stateArr = $VALUES;
            return (State[]) Arrays.copyOf(stateArr, stateArr.length);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/newui/ViewHolderVideoPlayer$connectionKeepHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ViewHolderVideoPlayer f10128O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000o(ViewHolderVideoPlayer viewHolderVideoPlayer, Looper looper) {
            super(looper);
            this.f10128O000000o = viewHolderVideoPlayer;
        }

        public final void handleMessage(Message message) {
            ixe.O00000o(message, "msg");
            this.f10128O000000o.O000000o(message.obj.toString());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.newui.ViewHolderVideoPlayer.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.newui.ViewHolderVideoPlayer.O000000o(android.content.Context, java.lang.String, com.xiaomi.smarthome.fastvideo.VideoView):boolean
      com.xiaomi.smarthome.newui.ViewHolderVideoPlayer.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public final boolean O000000o(Context context, String str, VideoView videoView) {
        ixe.O00000o(context, "context");
        ixe.O00000o(str, "did");
        ixe.O00000o(videoView, "videoView");
        if (O00000o0(str)) {
            return true;
        }
        this.O0000OOo.put(str, videoView);
        videoView.setDid(str);
        this.O00000oO.O000000o(str, 20000, 0);
        LogType logType = LogType.MAIN_PAGE;
        gsy.O00000o0(logType, "ViewHolderVideoPlayer", "startPlay put " + str + " in " + hashCode() + ",target：" + videoView.hashCode());
        return O000000o(context, str, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    private final boolean O000000o(Context context, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("request_frame_rate", 1);
        Boolean bool = this.O00000o0.get(str);
        if (bool == null) {
            bool = Boolean.TRUE;
        }
        intent.putExtra("mute", bool.booleanValue());
        intent.putExtra("run_on_main", false);
        gth.O00000o0 O00000oO2 = O00000oO(str);
        if (!O00000oO2.O0000OoO || z) {
            O00000oO2.O0000OoO = true;
            O000000o(context, str, 18, intent);
        }
        this.O0000O0o.put(str, State.Start);
        this.O00000oo.removeMessages(str.hashCode());
        O00000Oo();
        if (!O00000oO2.O0000Oo) {
            O00000oO2.O0000Oo = true;
            O000000o(context, str, 19, intent);
        }
        return true;
    }

    private final void O00000Oo() {
        if (this.O00000o) {
            int O00000o2 = gti.O000000o().O00000o() + 1;
            if (this.O0000OOo.size() == 2) {
                hxi.O00000o.O0000oOo(O00000o2);
            } else if (this.O0000OOo.size() == 3) {
                hxi.O00000o.O0000oOO(O00000o2);
            }
        }
    }

    private final gth.O00000o0 O00000oO(String str) {
        gth.O00000o0 O00000oO2;
        synchronized (this) {
            gth.O000000o().f18238O000000o = this;
            O00000oO2 = gth.O000000o().O00000oO(str);
            ixe.O00000Oo(O00000oO2, "instance().createPlayContextIfNeeded(did)");
        }
        return O00000oO2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public final boolean O000000o(Context context, String str, int i, boolean z) {
        ixe.O00000o(context, "context");
        ixe.O00000o(str, "did");
        if (!(this.O0000O0o.get(str) == null || this.O0000O0o.get(str) == State.Stop)) {
            this.O0000O0o.put(str, State.Stop);
            this.O0000OOo.remove(str);
            if (i != Integer.MAX_VALUE) {
                Intent intent = new Intent();
                intent.putExtra("run_on_main", false);
                O000000o(context, str, 20, intent);
                gth.O00000o0 O00000oO2 = O00000oO(str);
                O00000oO2.O0000Oo = false;
                O00000oO2.O0000O0o = false;
                O00000oO2.O0000OoO = true;
            }
            VideoFrame remove = this.O0000Oo0.remove(str);
            gth.O000000o();
            if (gth.O000000o(fno.O000000o().O000000o(str).model)) {
                O000000o(new ViewHolderVideoPlayer$doCacheFrame$1(this, str));
            } else {
                goq.O000000o(new Runnable(this, str, z) {
                    /* class com.xiaomi.smarthome.newui.$$Lambda$ViewHolderVideoPlayer$y865ZC3ryjI29nHWandk6Zc5oRM */
                    private final /* synthetic */ ViewHolderVideoPlayer f$1;
                    private final /* synthetic */ String f$2;
                    private final /* synthetic */ boolean f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        ViewHolderVideoPlayer.O000000o(VideoFrame.this, this.f$1, this.f$2, this.f$3);
                    }
                });
            }
            this.O0000Oo.remove(str);
            han han = this.O00000oO;
            ixe.O00000o(str, "did");
            han.O000000o().removeMessages(str.hashCode());
            LogType logType = LogType.MAIN_PAGE;
            gsy.O00000o0(logType, "ViewHolderVideoPlayer", "stopPlay remove " + hashCode() + ' ' + str + ", keep : " + i);
            if (i != Integer.MAX_VALUE) {
                if (i != 0) {
                    Message obtain = Message.obtain();
                    obtain.what = str.hashCode();
                    obtain.obj = str;
                    this.O00000oo.removeMessages(obtain.what);
                    this.O00000oo.sendMessageDelayed(obtain, (long) i);
                } else {
                    O000000o(str);
                }
            }
            O00000Oo();
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public final void O000000o(String str) {
        gsy.O00000o0(LogType.MAIN_PAGE, "ViewHolderVideoPlayer", ixe.O000000o("stopConnection: ", (Object) str));
        gth.O00000o0 O00000oO2 = O00000oO(str);
        O00000oO2.O0000Oo = false;
        O00000oO2.O0000O0o = false;
        O00000oO2.O0000OoO = false;
        this.O00000oo.removeMessages(str.hashCode());
        Intent intent = new Intent();
        intent.putExtra("run_on_main", false);
        Context appContext = CommonApplication.getAppContext();
        ixe.O00000Oo(appContext, "getAppContext()");
        O000000o(appContext, str, 21, intent);
    }

    public final boolean O000000o(Context context, String str) {
        ixe.O00000o(context, "context");
        ixe.O00000o(str, "did");
        this.O00000o0.put(str, Boolean.TRUE);
        O00000Oo(context, str);
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public final void O00000Oo(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("request_frame_rate", 1);
        Boolean bool = this.O00000o0.get(str);
        if (bool == null) {
            bool = Boolean.TRUE;
        }
        intent.putExtra("mute", bool.booleanValue());
        intent.putExtra("run_on_main", false);
        O000000o(context, str, 19, intent);
    }

    public final boolean O00000Oo(String str) {
        ixe.O00000o(str, "did");
        Boolean bool = this.O00000o0.get(str);
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    private boolean O00000oo(String str) {
        ixe.O00000o(str, "did");
        return this.O0000O0o.get(str) == State.Playing;
    }

    private boolean O0000O0o(String str) {
        ixe.O00000o(str, "did");
        return this.O0000O0o.get(str) == State.Start;
    }

    public final boolean O00000o0(String str) {
        ixe.O00000o(str, "did");
        return O0000O0o(str) || O00000oo(str);
    }

    public static void O000000o(String str, SimpleDraweeView simpleDraweeView, gzx.O000000o o000000o, boolean z) {
        ixe.O00000o(str, "did");
        ixe.O00000o(simpleDraweeView, "imageView");
        gzx gzx = gzx.f18674O000000o;
        gzx.O000000o(str, simpleDraweeView, o000000o, z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void O000000o(List<String> list) {
        ixe.O00000o(list, "connectionsMayAlive");
        Iterable<String> iterable = list;
        gsy.O00000o0(LogType.MAIN_PAGE, "ViewHolderVideoPlayer", ixe.O000000o("dispose: connectionMayAlive: ", (Object) iuo.O000000o(iterable, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (iwc) null, 63)));
        synchronized (this) {
            gth.O000000o().f18238O000000o = null;
            this.O0000OOo.clear();
            this.O0000O0o.clear();
            iuh iuh = iuh.f1631O000000o;
        }
        this.O00000oO.O000000o().removeCallbacksAndMessages(null);
        this.O0000Oo0.clear();
        this.O0000Oo.clear();
        this.O00000oo.removeCallbacksAndMessages(null);
        for (String O000000o2 : iterable) {
            O000000o(O000000o2);
        }
    }

    public final boolean O000000o() {
        return !this.O0000OOo.isEmpty();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.newui.ViewHolderVideoPlayer.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.newui.ViewHolderVideoPlayer.O000000o(android.content.Context, java.lang.String, com.xiaomi.smarthome.fastvideo.VideoView):boolean
      com.xiaomi.smarthome.newui.ViewHolderVideoPlayer.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public final void O000000o(String str, int i) {
        ixe.O00000o(str, "did");
        gsy.O00000Oo("ViewHolderVideoPlayer", "onTimeout " + str + " ,payload: " + i);
        LogType logType = LogType.MAIN_PAGE;
        gsy.O00000o0(logType, "ViewHolderVideoPlayer", "onTimeout " + str + " ,payload: " + i);
        if (i != 0 || !gof.O000000o()) {
            synchronized (this.O0000O0o) {
                this.O0000O0o.put(str, State.Stop);
                iuh iuh = iuh.f1631O000000o;
            }
            O000000o(new ViewHolderVideoPlayer$onTimeout$2(this, str));
            return;
        }
        this.O00000oO.O000000o(str, 5000, 1);
        Context appContext = CommonApplication.getAppContext();
        ixe.O00000Oo(appContext, "getAppContext()");
        O000000o(appContext, str, true);
    }

    private static void O000000o(iwb<iuh> iwb) {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$ViewHolderVideoPlayer$Ud0bDpBN2THbD3gSobewdAIGEc */

            public final void run() {
                ViewHolderVideoPlayer.O00000Oo(iwb.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(iwb iwb) {
        ixe.O00000o(iwb, "$block");
        iwb.invoke();
    }

    public final boolean O00000o(String str) {
        ixe.O00000o(str, "did");
        Long l = this.O0000Oo.get(str);
        if (l == null) {
            return false;
        }
        if (System.currentTimeMillis() - l.longValue() < 40) {
            return true;
        }
        return false;
    }

    public final void O000000o(String str, VideoFrame videoFrame) {
        ixe.O00000o(str, "did");
        ixe.O00000o(videoFrame, "videoFrame");
        VideoView videoView = this.O0000OOo.get(str);
        if (videoView == null) {
            LogType logType = LogType.MAIN_PAGE;
            gsy.O00000o0(logType, "ViewHolderVideoPlayer", "onFrameReceived target is null in " + hashCode() + " for " + str + ", size: " + this.O0000OOo.size());
            return;
        }
        if (videoFrame.isIFrame) {
            this.O0000Oo0.put(str, videoFrame);
        }
        this.O0000Oo.put(str, Long.valueOf(System.currentTimeMillis()));
        videoView.O000000o(videoFrame);
        this.O00000oO.O000000o(str, 20000, 0);
        synchronized (this.O0000O0o) {
            if (this.O0000O0o.get(str) == State.Start) {
                this.O0000O0o.put(str, State.Playing);
                this.O00000Oo.O000000o(str);
                LogType logType2 = LogType.MAIN_PAGE;
                gsy.O00000o0(logType2, "ViewHolderVideoPlayer", "onFrameReceived: did: " + str + " , target hashcode : " + videoView.hashCode());
            }
            iuh iuh = iuh.f1631O000000o;
        }
    }

    private static boolean O000000o(Context context, String str, int i, Intent intent) {
        PluginDeviceInfo O00000oO2;
        Context context2 = context;
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null || (O00000oO2 = CoreApi.O000000o().O00000oO(O000000o2.model)) == null) {
            return false;
        }
        boolean z = CoreApi.O000000o().O0000OoO(O000000o2.model) == null && CoreApi.O000000o().O0000Oo(O000000o2.model) == null;
        PluginApi instance = PluginApi.getInstance();
        String str2 = O000000o2.model;
        DeviceStat newDeviceStat = DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o2);
        XQProgressHorizontalDialog O000000o3 = XQProgressHorizontalDialog.O000000o(context2, context2.getString(R.string.plugin_downloading) + ((Object) O00000oO2.O0000Oo0()) + context2.getString(R.string.plugin));
        ixe.O00000Oo(O000000o3, "build(\n                        context, context.getString(R.string.plugin_downloading) + deviceInfo.name + context.getString(R.string.plugin))");
        PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
        String str3 = O000000o2.model;
        ixe.O00000Oo(str3, "device.model");
        instance.sendMessage(context, str2, i, intent, newDeviceStat, null, false, new O00000Oo(z, O000000o3, pluginDownloadTask, str3, new WeakReference(context2)));
        if (!z) {
            return true;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0007H\u0016J\u0012\u0010\"\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\u0012\u0010$\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer$NotInstallProgressCallback;", "Lcom/xiaomi/smarthome/frame/plugin/SendMessageCallback;", "isNotInstallAndNotDownload", "", "dialog", "Lcom/xiaomi/smarthome/library/common/dialog/XQProgressHorizontalDialog;", "taskHolder", "Lcom/xiaomi/smarthome/core/entity/plugin/PluginDownloadTask;", "model", "", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(ZLcom/xiaomi/smarthome/library/common/dialog/XQProgressHorizontalDialog;Lcom/xiaomi/smarthome/core/entity/plugin/PluginDownloadTask;Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "getContextRef", "()Ljava/lang/ref/WeakReference;", "getDialog", "()Lcom/xiaomi/smarthome/library/common/dialog/XQProgressHorizontalDialog;", "()Z", "getModel", "()Ljava/lang/String;", "getTaskHolder", "()Lcom/xiaomi/smarthome/core/entity/plugin/PluginDownloadTask;", "onDownloadCancel", "", "onDownloadFailure", "error", "Lcom/xiaomi/smarthome/core/entity/plugin/PluginError;", "onDownloadProgress", "record", "percent", "", "onDownloadStart", "task", "onDownloadSuccess", "onSendCancel", "onSendFailure", "Lcom/xiaomi/smarthome/frame/Error;", "onSendSuccess", "result", "Landroid/os/Bundle;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O00000Oo extends SendMessageCallback {

        /* renamed from: O000000o  reason: collision with root package name */
        private final boolean f10127O000000o;
        private final XQProgressHorizontalDialog O00000Oo;
        private final String O00000o;
        private final PluginDownloadTask O00000o0;
        private final WeakReference<Context> O00000oO;

        public O00000Oo(boolean z, XQProgressHorizontalDialog xQProgressHorizontalDialog, PluginDownloadTask pluginDownloadTask, String str, WeakReference<Context> weakReference) {
            ixe.O00000o(xQProgressHorizontalDialog, "dialog");
            ixe.O00000o(pluginDownloadTask, "taskHolder");
            ixe.O00000o(str, "model");
            ixe.O00000o(weakReference, "contextRef");
            this.f10127O000000o = z;
            this.O00000Oo = xQProgressHorizontalDialog;
            this.O00000o0 = pluginDownloadTask;
            this.O00000o = str;
            this.O00000oO = weakReference;
        }

        public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
            ixe.O00000o(str, "record");
            ixe.O00000o(pluginDownloadTask, "task");
            Context context = this.O00000oO.get();
            if (context != null) {
                pluginDownloadTask.O000000o(this.O00000o0);
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (!activity.isFinishing() && !activity.isDestroyed()) {
                        this.O00000Oo.O000000o(100, 0);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = this.O00000Oo;
                        xQProgressHorizontalDialog.f9117O000000o = false;
                        xQProgressHorizontalDialog.setCancelable(true);
                        this.O00000Oo.show();
                        this.O00000Oo.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            /* class com.xiaomi.smarthome.newui.$$Lambda$ViewHolderVideoPlayer$O00000Oo$0JgGYqfLVeBjznkYhO0oCqxz7Uo */

                            public final void onCancel(DialogInterface dialogInterface) {
                                ViewHolderVideoPlayer.O00000Oo.O000000o(ViewHolderVideoPlayer.O00000Oo.this, dialogInterface);
                            }
                        });
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O00000Oo o00000Oo, DialogInterface dialogInterface) {
            ixe.O00000o(o00000Oo, "this$0");
            CoreApi.O000000o().O000000o(o00000Oo.O00000o, o00000Oo.O00000o0);
        }

        public final void onDownloadProgress(String str, float f) {
            ixe.O00000o(str, "record");
            if (this.f10127O000000o) {
                int i = (int) (f * 100.0f);
                if (i >= 99) {
                    i = 99;
                }
                this.O00000Oo.O000000o(100, i);
                return;
            }
            this.O00000Oo.O000000o(100, (int) (f * 100.0f));
        }

        public final void onDownloadSuccess(String str) {
            if (!this.f10127O000000o) {
                this.O00000Oo.dismiss();
            }
        }

        public final void onDownloadFailure(PluginError pluginError) {
            if (!this.f10127O000000o) {
                this.O00000Oo.dismiss();
            }
        }

        public final void onDownloadCancel() {
            if (!this.f10127O000000o) {
                this.O00000Oo.dismiss();
            }
        }

        public final void onSendSuccess(Bundle bundle) {
            if (this.f10127O000000o) {
                this.O00000Oo.dismiss();
            }
        }

        public final void onSendFailure(fso fso) {
            if (this.f10127O000000o) {
                this.O00000Oo.dismiss();
            }
        }

        public final void onSendCancel() {
            if (this.f10127O000000o) {
                this.O00000Oo.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(VideoFrame videoFrame, ViewHolderVideoPlayer viewHolderVideoPlayer, String str, boolean z) {
        Bitmap bitmap;
        ixe.O00000o(viewHolderVideoPlayer, "this$0");
        ixe.O00000o(str, "$did");
        if (videoFrame == null) {
            bitmap = null;
        } else {
            try {
                bitmap = Bitmap.createBitmap(videoFrame.width, videoFrame.height, Bitmap.Config.RGB_565);
                bitmap.copyPixelsFromBuffer(IntBuffer.allocate(videoFrame.width * videoFrame.height));
                ixe.O00000Oo(bitmap, "bitmap");
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        boolean z2 = false;
        if (bitmap != null && H264Decoder.decodeIFrame(videoFrame.data, videoFrame.data.length, videoFrame.width, videoFrame.height, videoFrame.videoType, bitmap) == 0) {
            z2 = true;
        }
        if (!z2) {
            gzx gzx = gzx.f18674O000000o;
            bitmap = gzx.O000000o(str);
        }
        if (bitmap != null) {
            float f = bitmap.getHeight() == 360 ? 10.0f : 30.0f;
            if (z) {
                O000000o(new ViewHolderVideoPlayer$doCacheFrame$2$1(viewHolderVideoPlayer, str, new JavaBlurProcess().O000000o(bitmap, f)));
            } else {
                O000000o(new ViewHolderVideoPlayer$doCacheFrame$2$2(viewHolderVideoPlayer, str, bitmap));
            }
            if (z2) {
                gzx gzx2 = gzx.f18674O000000o;
                gzx.O000000o(str, bitmap);
            }
        }
    }
}
