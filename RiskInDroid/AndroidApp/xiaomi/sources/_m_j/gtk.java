package _m_j;

import _m_j.fvi;
import _m_j.gth;
import _m_j.gtk;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.fastvideo.VideoView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class gtk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static WindowManager f18259O000000o = null;
    public static FrameLayout O00000Oo = null;
    public static Device O00000o = null;
    public static O000000o O00000o0 = null;
    public static boolean O00000oO = false;
    private static fvi.O00000Oo O00000oo;

    public static void O000000o() {
        if (O00000Oo != null) {
            if (gth.O000000o().O000000o(O00000o)) {
                O000000o(O00000o0, O00000o);
            }
            try {
                f18259O000000o.removeView(O00000Oo);
            } catch (Exception unused) {
            }
            fvi.O000000o().O00000Oo(O00000oo);
            gth.O000000o().O0000OOo(O00000o);
            O00000Oo = null;
            O00000o0 = null;
            O00000o = null;
            f18259O000000o = null;
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
    public static void O000000o(final Device device) {
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        gth.O000000o().O0000OOo(device);
        f18259O000000o = (WindowManager) gkv.f17949O000000o.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 8388661;
        layoutParams.x = 60;
        layoutParams.y = 100;
        int O000000o2 = gpc.O000000o(219.0f);
        layoutParams.width = O000000o2;
        layoutParams.height = (O000000o2 * 360) / 640;
        O00000Oo = (FrameLayout) LayoutInflater.from(gkv.f17949O000000o).inflate((int) R.layout.camera_float_view_layout, (ViewGroup) null);
        O00000o0 = new O000000o(O00000Oo);
        O00000o = device;
        if (gth.O000000o().O00000Oo(device.did) == null) {
            gth.O000000o().O000000o(device.did, true);
        }
        O00000Oo(O00000o0, device);
        O00000o0.f18262O000000o.setTag(device);
        O00000o0.O0000OOo.setVisibility(0);
        O00000o0.O0000Oo0.setVisibility(0);
        O00000o0.O00000oo.setVisibility(0);
        O00000o0.O0000O0o.setVisibility(0);
        gth.O00000o0 O00000Oo2 = gth.O000000o().O00000Oo(device.did);
        if (O00000Oo2.O0000Oo) {
            O00000o0.O00000oo.setImageResource(R.drawable.camera_float_btn_pause);
        } else {
            O00000o0.O00000oo.setImageResource(R.drawable.camera_float_btn_play);
        }
        if (O00000Oo2.O0000OOo) {
            O00000o0.O0000O0o.setImageResource(R.drawable.camera_float_btn_mute);
        } else {
            O00000o0.O0000O0o.setImageResource(R.drawable.camera_float_btn_unmute);
        }
        O00000o0.O0000Oo0.setEnabled(true);
        O00000o0.O00000oo.setEnabled(true);
        O00000o0.O0000O0o.setEnabled(true);
        O00000o0.O0000OOo.setEnabled(true);
        O00000o0.O0000Oo.setVisibility(8);
        gth.O000000o().O000000o(device, O00000o0.O00000o0, O00000o0.O0000Oo);
        if (gth.O000000o().O00000Oo(device)) {
            if (O00000o0.O00000oO == null) {
                O000000o(O00000o0);
            }
            gth.O000000o().O000000o(device, O00000o0.O00000oO);
            O00000o0.O00000o0.setVisibility(8);
        }
        O00000o0.O0000Oo0.setOnClickListener($$Lambda$gtk$YAMn1uLAgZVXzTQ7XOpzVoRv8UQ.INSTANCE);
        O00000o0.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.$$Lambda$gtk$YmKWLY4eGj9bOdFvcHOBApD54 */

            public final void onClick(View view) {
                gtk.O00000Oo(Device.this, view);
            }
        });
        O00000o0.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.$$Lambda$gtk$NYKxYw8YClpbZkLYjppb6wQEnww */

            public final void onClick(View view) {
                gtk.O000000o(Device.this, view);
            }
        });
        O00000o0.O0000OOo.setOnClickListener($$Lambda$gtk$ocjPOklpCHoiixAxrPpC1qsRLQ0.INSTANCE);
        f18259O000000o.addView(O00000Oo, layoutParams);
        O00000Oo.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        O00000Oo.setOnTouchListener(new View.OnTouchListener() {
            /* class _m_j.gtk.AnonymousClass1 */
            private float O00000Oo;
            private boolean O00000o = false;
            private float O00000o0;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                if (motionEvent.getAction() == 0) {
                    this.O00000Oo = motionEvent.getRawX();
                    this.O00000o0 = motionEvent.getRawY();
                } else if (motionEvent.getAction() == 2) {
                    if (Math.abs(motionEvent.getRawX() - this.O00000Oo) > 5.0f) {
                        WindowManager.LayoutParams layoutParams = layoutParams;
                        layoutParams.x = (int) (((float) layoutParams.x) - (motionEvent.getRawX() - this.O00000Oo));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (Math.abs(motionEvent.getRawY() - this.O00000o0) > 5.0f) {
                        WindowManager.LayoutParams layoutParams2 = layoutParams;
                        layoutParams2.y = (int) (((float) layoutParams2.y) + (motionEvent.getRawY() - this.O00000o0));
                        z = true;
                    }
                    if (z) {
                        this.O00000Oo = motionEvent.getRawX();
                        this.O00000o0 = motionEvent.getRawY();
                        this.O00000o = true;
                        if (gtk.f18259O000000o != null) {
                            gtk.f18259O000000o.updateViewLayout(gtk.O00000Oo, layoutParams);
                        }
                    }
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    if (!this.O00000o && gtk.O00000o0 != null) {
                        if (gtk.O00000o0.O0000Oo0.getVisibility() == 0) {
                            gtk.O00000o0.O0000Oo0.setVisibility(8);
                        } else {
                            gtk.O00000o0.O0000Oo0.setVisibility(0);
                        }
                        if (gtk.O00000o0.O00000Oo.getVisibility() == 0) {
                            gtk.O00000o0.O00000Oo.setVisibility(8);
                        } else {
                            gtk.O00000o0.O00000Oo.setVisibility(0);
                        }
                    }
                    this.O00000o = false;
                }
                return false;
            }
        });
        O00000o0();
        O00000oo = new fvi.O00000Oo() {
            /* class _m_j.gtk.AnonymousClass2 */

            public final void O000000o() {
                if (!fvi.O000000o().O00000o() && gtk.O00000oO && gtk.O00000Oo != null) {
                    if (gth.O000000o().O000000o(device)) {
                        gtk.O000000o(gtk.O00000o0, gtk.O00000o);
                        izb.O000000o(gkv.f17949O000000o, (int) R.string.network_changed, 0).show();
                    }
                    if (gth.O000000o().O000000o(device)) {
                        gtk.O00000o0.O00000oo.setImageResource(R.drawable.camera_float_btn_pause);
                    } else {
                        gtk.O00000o0.O00000oo.setImageResource(R.drawable.camera_float_btn_play);
                    }
                }
                gtk.O00000oO = fvi.O000000o().O00000o();
            }

            public final void O00000Oo() {
                if (gtk.O00000Oo != null) {
                    if (gth.O000000o().O000000o(device)) {
                        gtk.O000000o(gtk.O00000o0, gtk.O00000o);
                        izb.O000000o(gkv.f17949O000000o, (int) R.string.network_changed, 0).show();
                    }
                    if (gth.O000000o().O000000o(device)) {
                        gtk.O00000o0.O00000oo.setImageResource(R.drawable.camera_float_btn_pause);
                    } else {
                        gtk.O00000o0.O00000oo.setImageResource(R.drawable.camera_float_btn_play);
                    }
                }
            }
        };
        fvi.O000000o().O000000o(O00000oo);
        O00000oO = fvi.O000000o().O00000o();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(Device device, View view) {
        if (O00000o0 != null) {
            gth.O000000o().O00000o(device);
            if (gth.O000000o().O000000o(device)) {
                O00000Oo(O00000o0, device);
            }
            if (gth.O000000o().O00000o0(device)) {
                O00000o0.O0000O0o.setImageResource(R.drawable.camera_float_btn_mute);
            } else {
                O00000o0.O0000O0o.setImageResource(R.drawable.camera_float_btn_unmute);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(Device device, View view) {
        if (O00000o0 != null) {
            if (gth.O000000o().O000000o(device)) {
                O000000o(O00000o0, device);
            } else if (!gth.O000000o().O00000Oo()) {
                O00000Oo(O00000o0, device);
            } else {
                return;
            }
            if (gth.O000000o().O000000o(device)) {
                O00000o0.O00000oo.setImageResource(R.drawable.camera_float_btn_pause);
            } else {
                O00000o0.O00000oo.setImageResource(R.drawable.camera_float_btn_play);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(View view) {
        Device device = O00000o;
        if (device != null) {
            String str = device.did;
            O000000o();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(str) {
                /* class _m_j.$$Lambda$gtk$fRPyFhQ11q9NlJtCpBY6o41kBh8 */
                private final /* synthetic */ String f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    XmPluginHostApi.instance().sendMessage(this.f$0, 1, new Intent(), null, null);
                }
            }, 500);
        }
    }

    private static boolean O00000o0() {
        try {
            Method declaredMethod = Class.forName("com.miui.whetstone.WhetstoneActivityManager").getDeclaredMethod("promoteApplicationLevel", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, 2);
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.fastvideo.VideoView.<init>(android.content.Context, boolean):void
     arg types: [android.content.Context, int]
     candidates:
      com.xiaomi.smarthome.fastvideo.VideoView.<init>(android.content.Context, android.util.AttributeSet):void
      com.xiaomi.smarthome.fastvideo.VideoView.<init>(android.content.Context, boolean):void */
    private static void O000000o(O000000o o000000o) {
        o000000o.O00000oO = new VideoView(gkv.f17949O000000o, true);
        int O000000o2 = gpc.O000000o(219.0f);
        o000000o.O00000oO.O000000o(O000000o2, (O000000o2 * 360) / 640, false);
        o000000o.O00000oO.O0000OOo = true;
        o000000o.O00000oO.setVideoViewListener(new VideoView.O000000o() {
            /* class _m_j.$$Lambda$gtk$lW9DrMOdEGVsGjPAuVsaW_QvQk */

            public final void onVideoViewClick() {
                gtk.O00000o0(gtk.O000000o.this);
            }
        });
        o000000o.O00000o.addView(o000000o.O00000oO);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000o0(O000000o o000000o) {
        if (o000000o.O00000Oo.getVisibility() == 0) {
            o000000o.O00000Oo.setVisibility(8);
        } else {
            o000000o.O00000Oo.setVisibility(0);
        }
    }

    private static void O00000Oo(O000000o o000000o, Device device) {
        if (o000000o.O00000oO == null) {
            O000000o(o000000o);
        }
        gth.O000000o().O000000o(device, o000000o.O00000oO);
        gth.O000000o().O000000o(gkv.f17949O000000o, device, o000000o.O0000Oo);
    }

    private static void O00000Oo(O000000o o000000o) {
        o000000o.O00000o.removeAllViews();
        try {
            Method declaredMethod = Class.forName("com.miui.whetstone.WhetstoneActivityManager").getDeclaredMethod("releaseApplicationPromoteLevel", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        o000000o.O00000oO = null;
    }

    static void O000000o(O000000o o000000o, Device device) {
        gth.O000000o().O00000Oo(device, o000000o.O00000oO);
        gth.O000000o().O000000o(gkv.f17949O000000o, device);
        O00000Oo(o000000o);
    }

    public static void O00000Oo() {
        if (O00000o != null) {
            XmStreamClient.sExceptionDevices.put(O00000o.model + "_" + O00000o.did, O00000o.did);
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f18262O000000o;
        public View O00000Oo;
        public FrameLayout O00000o;
        public ImageView O00000o0;
        public VideoView O00000oO;
        public ImageView O00000oo;
        public ImageView O0000O0o;
        public ImageView O0000OOo;
        public ProgressBar O0000Oo;
        public ImageView O0000Oo0;

        public O000000o(View view) {
            if (view instanceof ViewGroup) {
                this.f18262O000000o = view;
                this.O00000o0 = (ImageView) view.findViewById(R.id.video_view_cover);
                this.O00000o = (FrameLayout) view.findViewById(R.id.video_view_container);
                this.O00000Oo = view.findViewById(R.id.btn_bottom_view);
                this.O00000oo = (ImageView) view.findViewById(R.id.pause_button);
                this.O0000O0o = (ImageView) view.findViewById(R.id.mute_button);
                this.O0000OOo = (ImageView) view.findViewById(R.id.goto_plugin_button);
                this.O0000Oo0 = (ImageView) view.findViewById(R.id.delete_button_right);
                this.O0000Oo = (ProgressBar) view.findViewById(R.id.camera_loading);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(View view) {
        O000000o();
        ft.O000000o(gkv.f17949O000000o).O000000o(new Intent("refresh_list"));
    }
}
