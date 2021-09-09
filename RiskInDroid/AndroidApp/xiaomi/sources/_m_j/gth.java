package _m_j;

import _m_j.gth;
import _m_j.gtp;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.IXmPluginMessageReceiver;
import com.xiaomi.smarthome.fastvideo.VideoView;
import com.xiaomi.smarthome.fastvideo.decoder.H264Decoder;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class gth {
    private static volatile gth O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile O00000Oo f18238O000000o;
    public ConcurrentMap<String, O00000o0> O00000Oo = new ConcurrentHashMap();
    public Handler O00000o;
    public ConcurrentMap<String, VideoFrame> O00000o0 = new ConcurrentHashMap();
    public Handler O00000oO = new Handler(Looper.getMainLooper());
    private HandlerThread O0000O0o = new gpq("camera_frame_manager");
    private int O0000OOo = 2;
    private HashMap<String, IXmPluginMessageReceiver> O0000Oo0 = new HashMap<>();

    public interface O000000o {
        void onBitmapLoaded(Bitmap bitmap, long j);
    }

    public interface O00000Oo extends gtp.O000000o {
        boolean O000000o();
    }

    public static gth O000000o() {
        if (O00000oo == null) {
            synchronized (gth.class) {
                if (O00000oo == null) {
                    O00000oo = new gth();
                }
            }
        }
        return O00000oo;
    }

    class O0000OOo extends Handler {
        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o() {
        }

        O0000OOo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            Message message2 = message;
            int i = message2.what;
            if (i == 1) {
                for (String next : gth.this.O00000o0.keySet()) {
                    VideoFrame videoFrame = gth.this.O00000o0.get(next);
                    File O00000o0 = gth.O00000o0("cache_frame_".concat(String.valueOf(next)));
                    try {
                        if (!O00000o0.exists()) {
                            O00000o0.createNewFile();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(O00000o0);
                        gth.O000000o(videoFrame.width, fileOutputStream);
                        gth.O000000o(videoFrame.height, fileOutputStream);
                        gth.O000000o(videoFrame.size, fileOutputStream);
                        gth.O000000o(videoFrame.videoType, fileOutputStream);
                        fileOutputStream.write(videoFrame.data);
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                gth.this.O00000o0.clear();
            } else if (i == 2) {
                O00000o0 o00000o0 = (O00000o0) message2.obj;
                VideoFrame O00000o = gth.O00000o(o00000o0.O00000Oo);
                if (O00000o != null) {
                    gth.this.O00000o0.put(o00000o0.O00000Oo, O00000o);
                    gth.this.O00000o.sendMessage(gth.this.O00000o.obtainMessage(4, o00000o0));
                }
            } else if (i == 4) {
                gsy.O000000o(4, "camera_frame_manager", "start Load Cache");
                O00000o0 o00000o02 = (O00000o0) message2.obj;
                VideoFrame videoFrame2 = gth.this.O00000o0.get(o00000o02.O00000Oo);
                if (!gth.O000000o(fno.O000000o().O000000o(o00000o02.O00000Oo).model)) {
                    if (videoFrame2 == null) {
                        videoFrame2 = gth.O00000o(o00000o02.O00000Oo);
                    }
                    if (videoFrame2 == null || videoFrame2.width <= 0 || videoFrame2.height <= 0) {
                        gth.this.O00000oO.post($$Lambda$gth$O0000OOo$K_rTg2oetL8cJIp4oVScjkYrjhk.INSTANCE);
                        return;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(videoFrame2.width, videoFrame2.height, Bitmap.Config.RGB_565);
                    createBitmap.copyPixelsFromBuffer(IntBuffer.allocate(videoFrame2.width * videoFrame2.height));
                    if (H264Decoder.decodeIFrame(videoFrame2.data, videoFrame2.data.length, videoFrame2.width, videoFrame2.height, videoFrame2.videoType, createBitmap) == 0 && o00000o02.O00000oO != null) {
                        if (!o00000o02.O0000Oo || !o00000o02.O0000O0o) {
                            gth.this.O00000oO.post(new Runnable(createBitmap) {
                                /* class _m_j.$$Lambda$gth$O0000OOo$qjV8usN4HxtbW4h8s7E6T4594 */
                                private final /* synthetic */ Bitmap f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    gth.O0000OOo.O000000o(gth.O00000o0.this, this.f$1);
                                }
                            });
                        } else {
                            gth.this.O00000oO.postDelayed(new Runnable() {
                                /* class _m_j.$$Lambda$gth$O0000OOo$d5O0dQ4eR4VKu7QD4kxQNfjuIWY */

                                public final void run() {
                                    gth.O00000o0.this.O00000oO.setVisibility(8);
                                }
                            }, 300);
                        }
                    }
                }
            } else if (i == 5) {
                O00000o0 o00000o03 = (O00000o0) message2.obj;
                VideoFrame videoFrame3 = gth.this.O00000o0.get(o00000o03.O00000Oo);
                if (!gth.O000000o(fno.O000000o().O000000o(o00000o03.O00000Oo).model)) {
                    if (videoFrame3 == null) {
                        videoFrame3 = gth.O00000o(o00000o03.O00000Oo);
                    }
                    if (videoFrame3 != null) {
                        long j = videoFrame3.timeStamp;
                        Bitmap createBitmap2 = Bitmap.createBitmap(videoFrame3.width, videoFrame3.height, Bitmap.Config.RGB_565);
                        createBitmap2.copyPixelsFromBuffer(IntBuffer.allocate(videoFrame3.width * videoFrame3.height));
                        if (H264Decoder.decodeIFrame(videoFrame3.data, videoFrame3.data.length, videoFrame3.width, videoFrame3.height, videoFrame3.videoType, createBitmap2) == 0) {
                            Point O000000o2 = gpc.O000000o(CommonApplication.getAppContext());
                            Bitmap createBitmap3 = Bitmap.createBitmap(O000000o2.x, O000000o2.y, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap3);
                            int width = (createBitmap3.getWidth() * createBitmap3.getHeight()) / createBitmap2.getHeight();
                            canvas.drawBitmap(createBitmap2, new Rect(0, 0, createBitmap2.getWidth(), createBitmap2.getHeight()), new Rect((-(width - createBitmap3.getWidth())) / 2, 0, (width + createBitmap3.getWidth()) / 2, createBitmap3.getHeight()), new Paint(1));
                            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap3, createBitmap3.getWidth() / 5, createBitmap3.getHeight() / 5, false);
                            new gzi().O000000o(createScaledBitmap);
                            gth.this.O00000oO.post(new Runnable(createScaledBitmap, j) {
                                /* class _m_j.$$Lambda$gth$O0000OOo$nncxx4Brxse84SpQYalnJhejR1c */
                                private final /* synthetic */ Bitmap f$1;
                                private final /* synthetic */ long f$2;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void run() {
                                    gth.O0000OOo.O000000o(gth.O00000o0.this, this.f$1, this.f$2);
                                }
                            });
                            return;
                        }
                        gth.this.O00000oO.post(new Runnable() {
                            /* class _m_j.$$Lambda$gth$O0000OOo$WnOItiI7lrjieQW4qKvKrfB7RAc */

                            public final void run() {
                                gth.O0000OOo.O00000o0(gth.O00000o0.this);
                            }
                        });
                        return;
                    }
                    gth.this.O00000oO.post(new Runnable() {
                        /* class _m_j.$$Lambda$gth$O0000OOo$VZq6TFqqRdelNlWs4KT6KXR3hGw */

                        public final void run() {
                            gth.O0000OOo.O00000Oo(gth.O00000o0.this);
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(O00000o0 o00000o0, Bitmap bitmap, long j) {
            if (o00000o0.O0000o00 != null) {
                o00000o0.O0000o00.onBitmapLoaded(bitmap, j);
            }
            o00000o0.O0000o00 = null;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O00000o0(O00000o0 o00000o0) {
            if (o00000o0.O0000o00 != null) {
                o00000o0.O0000o00.onBitmapLoaded(null, 0);
            }
            o00000o0.O0000o00 = null;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O00000Oo(O00000o0 o00000o0) {
            if (o00000o0.O0000o00 != null) {
                o00000o0.O0000o00.onBitmapLoaded(null, 0);
            }
            o00000o0.O0000o00 = null;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(O00000o0 o00000o0, Bitmap bitmap) {
            o00000o0.O00000oO.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageView imageView = o00000o0.O00000oO;
            CommonApplication.getAppContext();
            imageView.setImageBitmap(gpc.O000000o(bitmap));
            o00000o0.O00000oO.setVisibility(0);
        }
    }

    public static boolean O000000o(String str) {
        return TextUtils.equals("imou99.camera.tp2", str);
    }

    public class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f18240O000000o;
        public String O00000Oo;
        public ProgressBar O00000o;
        VideoView O00000o0;
        public ImageView O00000oO;
        gtp O00000oo;
        public boolean O0000O0o;
        public boolean O0000OOo = true;
        public boolean O0000Oo = false;
        public boolean O0000Oo0 = false;
        public boolean O0000OoO = false;
        boolean O0000Ooo = false;
        public O000000o O0000o00;

        O00000o0(String str, gtp gtp, boolean z) {
            this.O00000Oo = str;
            this.O00000oo = gtp;
            this.O0000O0o = false;
            this.O0000Oo0 = z;
        }
    }

    private gth() {
        this.O0000O0o.start();
        this.O00000o = new O0000OOo(this.O0000O0o.getLooper());
    }

    public final O00000o0 O00000Oo(String str) {
        return this.O00000Oo.get(str);
    }

    public final void O000000o(Context context) {
        try {
            for (String next : this.O00000Oo.keySet()) {
                O00000o0 O00000Oo2 = O00000Oo(next);
                if (!O00000Oo2.O0000Oo0) {
                    Device O000000o2 = fno.O000000o().O000000o(next);
                    if (O00000Oo2 != null) {
                        O00000Oo2.O00000oo.O00000oo();
                    }
                    if (!(O000000o2 == null || CoreApi.O000000o().O0000Oo(O000000o2.model) == null)) {
                        Intent intent = new Intent();
                        intent.putExtra("run_on_main", O00000Oo2.O0000Oo0);
                        O000000o(context, O000000o2, 21, intent);
                    }
                    this.O00000Oo.remove(next);
                    gsy.O000000o(3, "camera_frame_manager", "destoryAllContext: ".concat(String.valueOf(next)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.O00000o.sendEmptyMessage(1);
    }

    public final boolean O000000o(Device device) {
        O00000o0 O00000Oo2;
        if (device == null || (O00000Oo2 = O00000Oo(device.did)) == null) {
            return false;
        }
        return O00000Oo2.O0000Oo;
    }

    public final boolean O00000Oo(Device device) {
        O00000o0 O00000Oo2;
        if (device != null && (O00000Oo2 = O00000Oo(device.did)) != null && O00000Oo2.O0000Oo && O00000Oo2.O0000O0o) {
            return true;
        }
        return false;
    }

    public final boolean O00000Oo() {
        int i = 0;
        for (O00000o0 next : this.O00000Oo.values()) {
            if (next != null && next.O0000Oo) {
                i++;
            }
        }
        if (i >= 3) {
            return true;
        }
        return false;
    }

    public final boolean O00000o0(Device device) {
        O00000o0 O00000Oo2 = O00000Oo(device.did);
        if (O00000Oo2 != null) {
            return O00000Oo2.O0000OOo;
        }
        return false;
    }

    static class O00000o implements gtp.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        WeakReference<gth> f18239O000000o;

        public O00000o(gth gth) {
            this.f18239O000000o = new WeakReference<>(gth);
        }

        public final void O000000o(String str, VideoFrame videoFrame) {
            gth gth = this.f18239O000000o.get();
            if (gth != null) {
                O00000o0 o00000o0 = gth.O00000Oo.get(str);
                if (o00000o0 != null && o00000o0.O0000Oo) {
                    if (videoFrame.isIFrame) {
                        gth.O00000o0.put(str, videoFrame);
                    }
                    if (o00000o0.O00000o0 != null) {
                        o00000o0.O00000o0.O000000o(videoFrame);
                    }
                    if (!o00000o0.O0000O0o) {
                        o00000o0.O0000O0o = true;
                        if (!(o00000o0.O00000o0 == null || o00000o0 == null || o00000o0.O00000o == null)) {
                            o00000o0.O00000o.post(new Runnable() {
                                /* class _m_j.$$Lambda$gth$O00000o$Eehz_B0cGPoKR_1RzYaZB2KjeM */

                                public final void run() {
                                    gth.O00000o.O000000o(gth.O00000o0.this);
                                }
                            });
                        }
                    }
                }
                O00000Oo o00000Oo = gth.f18238O000000o;
                if (o00000Oo != null && o00000Oo.O000000o()) {
                    o00000Oo.O000000o(str, videoFrame);
                }
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(O00000o0 o00000o0) {
            o00000o0.O00000o.setVisibility(8);
            o00000o0.O00000o.clearAnimation();
            if (o00000o0.O00000oO != null) {
                o00000o0.O00000oO.setVisibility(8);
            }
        }
    }

    public final O00000o0 O000000o(String str, boolean z) {
        gto gto = new gto(str);
        gto.O000000o(new O00000o(this));
        gto.O00000oO();
        O00000o0 o00000o0 = new O00000o0(str, gto, z);
        this.O00000Oo.put(str, o00000o0);
        return o00000o0;
    }

    public final void O00000o(Device device) {
        O00000o0 O00000Oo2 = O00000Oo(device.did);
        if (O00000Oo2 != null) {
            O00000Oo2.O0000OOo = !O00000Oo2.O0000OOo;
        }
    }

    public final void O00000oO(Device device) {
        O00000o0 O00000Oo2 = O00000Oo(device.did);
        if (O00000Oo2 != null) {
            O00000Oo2.O0000OOo = true;
        }
    }

    public final void O00000oo(Device device) {
        O00000o0 O00000Oo2;
        if (device != null && (O00000Oo2 = O00000Oo(device.did)) != null && CoreApi.O000000o().O0000Oo(device.model) != null) {
            Intent intent = new Intent();
            intent.putExtra("run_on_main", O00000Oo2.O0000Oo0);
            O00000Oo2.f18240O000000o = false;
            O000000o(CommonApplication.getAppContext(), device, 24, intent);
        }
    }

    public final boolean O0000O0o(Device device) {
        O00000o0 O00000Oo2;
        if (device == null || (O00000Oo2 = O00000Oo(device.did)) == null) {
            return false;
        }
        return O00000Oo2.f18240O000000o;
    }

    public final void O0000OOo(Device device) {
        O00000o0 O00000Oo2 = O00000Oo(device.did);
        if (O00000Oo2 != null) {
            if (CoreApi.O000000o().O0000Oo(device.model) != null) {
                Intent intent = new Intent();
                intent.putExtra("run_on_main", O00000Oo2.O0000Oo0);
                O000000o(CommonApplication.getAppContext(), device, 21, intent);
            }
            O00000Oo2.O00000oo.O00000oo();
            gsy.O000000o(3, "camera_frame_manager", "destoryPlayContext: " + device.did);
            this.O00000Oo.remove(device.did);
        }
    }

    public final void O000000o(Device device, VideoView videoView) {
        O00000o0 O00000Oo2;
        if (device != null && (O00000Oo2 = O00000Oo(device.did)) != null) {
            O00000Oo2.O00000o0 = videoView;
            if (videoView != null) {
                videoView.setDid(O00000Oo2.O00000Oo);
            }
        }
    }

    public final void O000000o(Device device, ImageView imageView, ProgressBar progressBar) {
        O00000o0 O00000Oo2 = O00000Oo(device.did);
        if (O00000Oo2 != null) {
            O00000Oo2.O00000oO = imageView;
            if (device.isOnline && (!O00000Oo2.O0000Oo || !O00000Oo2.O0000O0o)) {
                if (gth.this.O00000o0.get(O00000Oo2.O00000Oo) != null) {
                    gth.this.O00000o.sendMessage(gth.this.O00000o.obtainMessage(4, O00000Oo2));
                } else {
                    if (O00000o0("cache_frame_" + O00000Oo2.O00000Oo).exists()) {
                        gth.this.O00000o.sendMessage(gth.this.O00000o.obtainMessage(2, O00000Oo2));
                    }
                }
            }
            O00000Oo2.O00000o = progressBar;
            if (imageView != null && device.isOnline) {
                imageView.setVisibility(0);
            }
            if (O00000Oo2.O0000Oo && !O00000Oo2.O0000O0o && O00000Oo2.O00000o != null) {
                O00000Oo2.O00000o.setVisibility(0);
                O00000Oo2.O00000o.startAnimation(AnimationUtils.loadAnimation(progressBar.getContext(), R.anim.rotate_loading));
            }
        }
    }

    public final void O00000Oo(Device device, VideoView videoView) {
        O00000o0 O00000Oo2 = O00000Oo(device.did);
        if (O00000Oo2 != null && O00000Oo2.O00000o0 != null && O00000Oo2.O00000o0.equals(videoView)) {
            O00000Oo2.O00000o0 = null;
        }
    }

    public final void O000000o(Context context, Device device) {
        O00000o0 O00000Oo2 = O00000Oo(device.did);
        if (O00000Oo2 != null) {
            Intent intent = new Intent();
            intent.putExtra("run_on_main", O00000Oo2.O0000Oo0);
            gsy.O000000o(4, "camera_frame_manager", "stopPlay - ".concat(String.valueOf(O00000Oo2)));
            O000000o(context, device, 20, intent);
            O00000Oo2.O0000Oo = false;
            O00000Oo2.O0000O0o = false;
            O00000Oo2.f18240O000000o = false;
            if (O00000Oo2.O00000o != null) {
                O00000Oo2.O00000o.clearAnimation();
                O00000Oo2.O00000o.setVisibility(8);
            }
            O000000o(device, O00000Oo2.O00000oO, O00000Oo2.O00000o);
        }
    }

    public final void O000000o(Context context, Device device, ProgressBar progressBar) {
        O00000o0 O00000Oo2;
        if (!O00000Oo() && (O00000Oo2 = O00000Oo(device.did)) != null) {
            gsy.O000000o(4, "camera_frame_manager", "startPlay1 - ".concat(String.valueOf(O00000Oo2)));
            O000000o(context, device, O00000Oo2.O0000OOo);
            if (!O00000Oo2.O0000Oo) {
                O00000Oo2.O0000Oo = true;
                progressBar.setVisibility(0);
                progressBar.startAnimation(AnimationUtils.loadAnimation(context, R.anim.rotate_loading));
                O00000Oo2.O00000o = progressBar;
            }
        }
    }

    public final void O000000o(Context context, Device device, boolean z) {
        O00000o0 O00000Oo2 = O00000Oo(device.did);
        if (O00000Oo2 != null) {
            gsy.O000000o(4, "camera_frame_manager", "startPlay2 - ".concat(String.valueOf(O00000Oo2)));
            Intent intent = new Intent();
            intent.putExtra("request_frame_rate", 1);
            intent.putExtra("mute", z);
            intent.putExtra("run_on_main", O00000Oo2.O0000Oo0);
            if (!O00000Oo2.O0000OoO) {
                O000000o(context, device, 18, intent);
                O00000Oo2.O0000OoO = true;
            }
            O000000o(context, device, 19, intent);
        }
    }

    static class O0000O0o extends SendMessageCallback {

        /* renamed from: O000000o  reason: collision with root package name */
        final WeakReference<gth> f18241O000000o;
        final boolean O00000Oo;
        final PluginDownloadTask O00000o;
        final XQProgressHorizontalDialog O00000o0;
        final WeakReference<Context> O00000oO;
        final String O00000oo;

        /* synthetic */ O0000O0o(gth gth, boolean z, XQProgressHorizontalDialog xQProgressHorizontalDialog, PluginDownloadTask pluginDownloadTask, String str, Context context, byte b) {
            this(gth, z, xQProgressHorizontalDialog, pluginDownloadTask, str, context);
        }

        private O0000O0o(gth gth, boolean z, XQProgressHorizontalDialog xQProgressHorizontalDialog, PluginDownloadTask pluginDownloadTask, String str, Context context) {
            this.f18241O000000o = new WeakReference<>(gth);
            this.O00000Oo = z;
            this.O00000o0 = xQProgressHorizontalDialog;
            this.O00000o = pluginDownloadTask;
            this.O00000oo = str;
            this.O00000oO = new WeakReference<>(context);
        }

        public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
            gth gth = this.f18241O000000o.get();
            Context context = this.O00000oO.get();
            if (gth != null && context != null) {
                pluginDownloadTask.O000000o(this.O00000o);
                if (this.O00000o0 != null && (context instanceof Activity)) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        Activity activity = (Activity) context;
                        if (activity.isFinishing() || activity.isDestroyed()) {
                            return;
                        }
                    } else if (((Activity) context).isFinishing()) {
                        return;
                    }
                    this.O00000o0.O000000o(100, 0);
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = this.O00000o0;
                    xQProgressHorizontalDialog.f9117O000000o = false;
                    xQProgressHorizontalDialog.setCancelable(true);
                    this.O00000o0.show();
                    this.O00000o0.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        /* class _m_j.$$Lambda$gth$O0000O0o$jnXM7B76h5a7SFmArhVg0u6rBJc */

                        public final void onCancel(DialogInterface dialogInterface) {
                            gth.O0000O0o.this.O000000o(dialogInterface);
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(DialogInterface dialogInterface) {
            CoreApi.O000000o().O000000o(this.O00000oo, this.O00000o);
        }

        public final void onDownloadProgress(String str, float f) {
            if (this.O00000Oo) {
                int i = (int) (f * 100.0f);
                if (i >= 99) {
                    i = 99;
                }
                XQProgressHorizontalDialog xQProgressHorizontalDialog = this.O00000o0;
                if (xQProgressHorizontalDialog != null) {
                    xQProgressHorizontalDialog.O000000o(100, i);
                    return;
                }
                return;
            }
            XQProgressHorizontalDialog xQProgressHorizontalDialog2 = this.O00000o0;
            if (xQProgressHorizontalDialog2 != null) {
                xQProgressHorizontalDialog2.O000000o(100, (int) (f * 100.0f));
            }
        }

        public final void onDownloadSuccess(String str) {
            XQProgressHorizontalDialog xQProgressHorizontalDialog;
            if (!this.O00000Oo && (xQProgressHorizontalDialog = this.O00000o0) != null) {
                xQProgressHorizontalDialog.dismiss();
            }
        }

        public final void onDownloadFailure(PluginError pluginError) {
            XQProgressHorizontalDialog xQProgressHorizontalDialog;
            if (!this.O00000Oo && (xQProgressHorizontalDialog = this.O00000o0) != null) {
                xQProgressHorizontalDialog.dismiss();
            }
        }

        public final void onDownloadCancel() {
            XQProgressHorizontalDialog xQProgressHorizontalDialog;
            if (!this.O00000Oo && (xQProgressHorizontalDialog = this.O00000o0) != null) {
                xQProgressHorizontalDialog.dismiss();
            }
        }

        public final void onSendSuccess(Bundle bundle) {
            XQProgressHorizontalDialog xQProgressHorizontalDialog;
            if (this.O00000Oo && (xQProgressHorizontalDialog = this.O00000o0) != null) {
                xQProgressHorizontalDialog.dismiss();
            }
        }

        public final void onSendFailure(fso fso) {
            XQProgressHorizontalDialog xQProgressHorizontalDialog;
            if (this.O00000Oo && (xQProgressHorizontalDialog = this.O00000o0) != null) {
                xQProgressHorizontalDialog.dismiss();
            }
        }

        public final void onSendCancel() {
            XQProgressHorizontalDialog xQProgressHorizontalDialog;
            if (this.O00000Oo && (xQProgressHorizontalDialog = this.O00000o0) != null) {
                xQProgressHorizontalDialog.dismiss();
            }
        }
    }

    public final void O000000o(Context context, Device device, int i, Intent intent) {
        Context context2 = context;
        Device device2 = device;
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device2.model);
        if (O00000oO2 != null) {
            XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(context2, context2.getString(R.string.plugin_downloading) + O00000oO2.O0000Oo0() + context2.getString(R.string.plugin));
            PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
            PluginApi.getInstance().sendMessage(context, device2.model, i, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2), null, false, new O0000O0o(this, CoreApi.O000000o().O0000OoO(device2.model) == null && CoreApi.O000000o().O0000Oo(device2.model) == null, O000000o2, pluginDownloadTask, device2.model, context, (byte) 0));
        }
    }

    public static File O00000o0(String str) {
        String str2;
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            str2 = CommonApplication.getAppContext().getCacheDir().getPath();
        } else if (CommonApplication.getAppContext().getExternalCacheDir() != null) {
            str2 = CommonApplication.getAppContext().getExternalCacheDir().getPath();
        } else {
            str2 = CommonApplication.getAppContext().getCacheDir().getPath();
        }
        return new File(str2 + File.separator + str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d A[SYNTHETIC, Splitter:B:36:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0078 A[SYNTHETIC, Splitter:B:43:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0084 A[SYNTHETIC, Splitter:B:50:0x0084] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x0073=Splitter:B:40:0x0073, B:33:0x0068=Splitter:B:33:0x0068} */
    public static VideoFrame O00000o(String str) {
        FileInputStream fileInputStream;
        File O00000o02 = O00000o0("cache_frame_".concat(String.valueOf(str)));
        VideoFrame videoFrame = null;
        if (!O00000o02.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(O00000o02);
            try {
                int O000000o2 = O000000o(fileInputStream);
                int O000000o3 = O000000o(fileInputStream);
                int O000000o4 = O000000o(fileInputStream);
                int O000000o5 = O000000o(fileInputStream);
                if (O000000o2 >= 0 && O000000o3 >= 0 && O000000o4 >= 0 && O000000o4 <= 2097152) {
                    byte[] bArr = new byte[O000000o4];
                    if (fileInputStream.read(bArr, 0, bArr.length) != O000000o4) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                    videoFrame = new VideoFrame(bArr, 0, O000000o4, O000000o2, O000000o3, O00000o02.lastModified(), O000000o5, true);
                }
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return videoFrame;
            } catch (FileNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            } catch (IOException e4) {
                e = e4;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            return null;
        } catch (IOException e8) {
            e = e8;
            fileInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    private static int O000000o(InputStream inputStream) {
        byte[] bArr = new byte[4];
        try {
            if (inputStream.read(bArr, 0, 4) != 4) {
                return -1;
            }
            return (bArr[0] & 255) | 0 | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    static void O000000o(int i, OutputStream outputStream) {
        try {
            outputStream.write(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gth.O000000o(int, java.io.OutputStream):void
      _m_j.gth.O000000o(android.content.Context, com.xiaomi.smarthome.device.Device):void
      _m_j.gth.O000000o(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.fastvideo.VideoView):void
      _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0 */
    public final synchronized O00000o0 O00000oO(String str) {
        O00000o0 O00000Oo2;
        O00000Oo2 = O00000Oo(str);
        if (O00000Oo2 == null) {
            gsy.O000000o(3, "camera_frame_manager", "createPlayContextIfNeeded: ".concat(String.valueOf(str)));
            O00000Oo2 = O000000o(str, false);
        }
        return O00000Oo2;
    }
}
