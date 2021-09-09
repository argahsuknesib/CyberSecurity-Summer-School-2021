package _m_j;

import _m_j.foo;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.bluetooth.ui.BleMatchActivity;
import com.xiaomi.smarthome.device.bluetooth.ui.LoopRunView;
import com.xiaomi.smarthome.framework.statistic.BindStep;

public final class fpn extends fpi {
    public ImageView O0000O0o;
    public ImageView O0000OOo;
    public ImageView O0000Oo;
    public ImageView O0000Oo0;
    ImageView O0000OoO;
    View O0000Ooo;
    public Handler O0000o;
    LoopRunView O0000o0;
    LoopRunView O0000o00;
    Bitmap O0000o0O;
    Bitmap O0000o0o;
    public Runnable O0000oO = new Runnable() {
        /* class _m_j.fpn.AnonymousClass1 */

        public final void run() {
            if (!fpn.this.O0000oO0) {
                if (fob.O00000Oo()) {
                    fob.O000000o(new SearchRequest.O000000o().O00000Oo(3000, 4).O000000o(), fpn.this.O0000oOO);
                    return;
                }
                fob.O00000o0();
                fpn.this.O0000o.postDelayed(fpn.this.O0000oO, 300);
            }
        }
    };
    public boolean O0000oO0 = false;
    public final fon O0000oOO = new fon() {
        /* class _m_j.fpn.AnonymousClass3 */

        public final /* synthetic */ void O000000o(Object obj) {
            BleDevice bleDevice = (BleDevice) obj;
            boolean z = fpn.this.O00000o.model.equals(bleDevice.model) || fpn.this.O000000o(bleDevice.model);
            if (fpn.this.O00000o != null && z && !fob.O00000Oo(bleDevice) && bleDevice.O00000Oo() != null) {
                foo.O000000o(bleDevice);
            }
        }

        public final void O000000o() {
            foo.O000000o();
        }

        public final void O00000Oo() {
            String str;
            foo.O00000o0 O00000Oo = foo.O00000Oo();
            fte.O00000Oo("onRssiMonitorStopped: ".concat(String.valueOf(O00000Oo)));
            if (O00000Oo != null) {
                int O00000oO = fpn.this.O00000oO();
                fte.O00000Oo(String.format("Rssi Threadhold: %d", Integer.valueOf(O00000oO)));
                if ((O00000oO < 0 && O00000Oo.O00000o0 >= O00000oO) || O00000oO >= 0) {
                    if (fpn.this.O00000o != null) {
                        hxc.O000000o().O00000o0(fpn.this.O00000o.model, BindStep.STEP_RESET_DEVICE);
                    }
                    ((BleMatchActivity) fpn.this.f14469O000000o).onDeviceMatched(O00000Oo.O00000Oo);
                    return;
                }
            }
            if (fpn.this.O00000o != null) {
                str = fpn.this.O00000o.model;
                hxc.O000000o().O000000o(fpn.this.O00000o.model, BindStep.STEP_RESET_DEVICE, "search stopped, not found");
            } else {
                str = "";
            }
            ((BleMatchActivity) fpn.this.f14469O000000o).onDeviceNotFound(str);
        }

        public final void O00000o0() {
            if (fpn.this.O00000o != null) {
                hxc.O000000o().O000000o(fpn.this.O00000o.model, BindStep.STEP_RESET_DEVICE, "search canceled");
            }
        }
    };
    public O000000o O0000oOo = new O000000o() {
        /* class _m_j.fpn.AnonymousClass6 */

        public final void O000000o() {
            fpn fpn = fpn.this;
            fpn.O000000o(fpn.O0000OOo, fpn.this.O0000oo0);
        }
    };
    public O000000o O0000oo = new O000000o() {
        /* class _m_j.fpn.AnonymousClass8 */

        public final void O000000o() {
            fpn fpn = fpn.this;
            fpn.O000000o(fpn.O0000Oo, fpn.this.O0000ooO);
        }
    };
    public O000000o O0000oo0 = new O000000o() {
        /* class _m_j.fpn.AnonymousClass7 */

        public final void O000000o() {
            fpn fpn = fpn.this;
            fpn.O000000o(fpn.O0000Oo0, fpn.this.O0000oo);
        }
    };
    public O000000o O0000ooO = new O000000o() {
        /* class _m_j.fpn.AnonymousClass9 */

        public final void O000000o() {
            fpn fpn = fpn.this;
            fpn.O000000o(fpn.O0000O0o, fpn.this.O0000oOo);
        }
    };
    private TextView O0000ooo;

    public interface O000000o {
        void O000000o();
    }

    public static fpn O00000o() {
        return new fpn();
    }

    @SuppressLint({"CheckResult"})
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.ble_rssi_match, (ViewGroup) null);
        this.O0000O0o = (ImageView) inflate.findViewById(R.id.wave1);
        this.O0000OOo = (ImageView) inflate.findViewById(R.id.wave2);
        this.O0000Oo0 = (ImageView) inflate.findViewById(R.id.wave3);
        this.O0000Oo = (ImageView) inflate.findViewById(R.id.wave4);
        this.O0000OoO = (ImageView) inflate.findViewById(R.id.phone);
        this.O0000Ooo = inflate.findViewById(R.id.arrow);
        this.O0000o00 = (LoopRunView) inflate.findViewById(R.id.left);
        this.O0000o0 = (LoopRunView) inflate.findViewById(R.id.right);
        this.O0000ooo = (TextView) inflate.findViewById(R.id.device_detail);
        dco.O000000o().O000000o(this.O00000o, this.O0000ooo, getContext());
        O00000Oo(this.O0000O0o, this.O0000oOo);
        this.O0000o = new Handler(Looper.getMainLooper());
        this.O0000o.postDelayed(new Runnable() {
            /* class _m_j.fpn.AnonymousClass4 */

            public final void run() {
                fpn fpn = fpn.this;
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -141.0f);
                translateAnimation.setDuration(1000);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    /* class _m_j.fpn.AnonymousClass5 */

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        fpn fpn = fpn.this;
                        fpn.O0000Ooo.setVisibility(0);
                        fpn.O0000o0O = BitmapFactory.decodeResource(fpn.getResources(), R.drawable.arrow_icon);
                        Bitmap bitmap = fpn.O0000o0O;
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        Matrix matrix = new Matrix();
                        matrix.postRotate(180.0f, (float) (width / 2), (float) (height / 2));
                        canvas.drawBitmap(bitmap, matrix, new Paint(1));
                        fpn.O0000o0o = createBitmap;
                        LoopRunView.O000000o o000000o = new LoopRunView.O000000o();
                        o000000o.f7195O000000o = 300;
                        o000000o.O00000Oo = LoopRunView.Direction.UP;
                        o000000o.O00000o0 = 5;
                        fpn.O0000o00.O000000o(fpn.O0000o0O, o000000o);
                        LoopRunView.O000000o o000000o2 = new LoopRunView.O000000o();
                        o000000o2.f7195O000000o = 300;
                        o000000o2.O00000Oo = LoopRunView.Direction.DOWN;
                        o000000o2.O00000o0 = 5;
                        fpn.O0000o0.O000000o(fpn.O0000o0o, o000000o2);
                    }
                });
                fpn.O0000OoO.startAnimation(translateAnimation);
            }
        }, 500);
        O00000o0();
        if (this.O00000o != null) {
            int i = dco.O000000o().O00000o0() ? 1 : 2;
            hxi.O00000o0.f957O000000o.O000000o("adddevice_BLE_neardevice_show", "model", this.O00000o.model, "from", Integer.valueOf(i));
        }
        return inflate;
    }

    public final void O00000o0() {
        gnk.O00000oO("startWatchAdvertisement");
        if (this.O00000o != null) {
            hxc.O000000o().O000000o(this.O00000o.model, BindStep.STEP_RESET_DEVICE);
        }
        this.O0000oO.run();
    }

    public final int O00000oO() {
        return BleDevice.O00000o0(O00000Oo());
    }

    public final void onPause() {
        gsy.O000000o(4, "stopScan", "BRMF stop");
        fpo.O00000Oo();
        if (this.O00000o != null) {
            hxc.O000000o().O000000o(this.O00000o.model, BindStep.STEP_RESET_DEVICE, "pause watch");
        }
        super.onPause();
    }

    public final void onDestroy() {
        super.onDestroy();
        LoopRunView loopRunView = this.O0000o00;
        if (loopRunView != null) {
            loopRunView.O000000o();
        }
        LoopRunView loopRunView2 = this.O0000o0;
        if (loopRunView2 != null) {
            loopRunView2.O000000o();
        }
        Bitmap bitmap = this.O0000o0O;
        if (bitmap != null) {
            gos.O000000o(bitmap);
        }
        Bitmap bitmap2 = this.O0000o0o;
        if (bitmap2 != null) {
            gos.O000000o(bitmap2);
        }
        this.O0000O0o.clearAnimation();
        this.O0000OOo.clearAnimation();
        this.O0000Oo0.clearAnimation();
        this.O0000Oo.clearAnimation();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final View view, final O000000o o000000o) {
        view.postDelayed(new Runnable() {
            /* class _m_j.fpn.AnonymousClass10 */

            public final void run() {
                fpn.this.O00000Oo(view, o000000o);
            }
        }, 425);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(View view, final O000000o o000000o) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.setDuration(1600);
        animationSet.addAnimation(new AlphaAnimation(0.5f, 0.02f));
        animationSet.addAnimation(new ScaleAnimation(1.0f, 3.5f, 1.0f, 3.5f, 1, 0.5f, 1, 0.5f));
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            /* class _m_j.fpn.AnonymousClass2 */

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                o000000o.O000000o();
            }
        });
        view.startAnimation(animationSet);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.O0000oO0 = true;
        this.O0000o.removeCallbacks(this.O0000oO);
    }
}
