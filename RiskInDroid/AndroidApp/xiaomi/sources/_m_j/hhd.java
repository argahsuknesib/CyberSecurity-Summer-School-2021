package _m_j;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.xiaomi.smarthome.cardbridge.PluginDownloadingRecordWrapper;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.widget.micards.DownloadProgressProcessor;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class hhd implements hhk {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static Map<Device, PluginDownloadingRecordWrapper> f18930O000000o = new HashMap();
    public Device O00000Oo;
    public Context O00000o;
    public hhk O00000o0;
    public hhi O00000oO;
    public DownloadProgressProcessor O00000oo;
    public hhe O0000O0o;
    public int O0000OOo = 91;
    private Timer O0000Oo = new Timer();
    public Handler O0000Oo0 = new Handler() {
        /* class _m_j.hhd.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 1 && hhd.this.O00000o0 != null) {
                hhd.this.O00000o0.setPercent((float) hhd.this.O0000OOo);
            }
        }
    };
    private TimerTask O0000OoO;

    public hhd(Context context, hhk hhk, Device device) {
        this.O00000Oo = device;
        this.O00000o = context;
        this.O00000o0 = hhk;
    }

    public final void setCallback(hhi hhi) {
        this.O00000oO = hhi;
    }

    public final void O000000o(final Device device) {
        device.setLaunchParams(new Intent());
        final boolean z = !fbn.O000000o(device.model) && !fbn.O00000Oo(device.model);
        fbn.O000000o(this.O00000o, device.model, new fbp() {
            /* class _m_j.hhd.AnonymousClass2 */
            private float O00000o = 0.0f;
            private long O00000oO;
            private final Interpolator O00000oo = new DecelerateInterpolator();
            private volatile ValueAnimator O0000O0o;

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.lang.Math.min(float, float):float}
             arg types: [int, float]
             candidates:
              ClspMth{java.lang.Math.min(double, double):double}
              ClspMth{java.lang.Math.min(long, long):long}
              ClspMth{java.lang.Math.min(int, int):int}
              ClspMth{java.lang.Math.min(float, float):float} */
            private float O00000o0() {
                if (this.O0000O0o == null) {
                    synchronized (this) {
                        if (this.O0000O0o == null) {
                            double min = (double) Math.min(1.0f, ((float) (System.currentTimeMillis() - this.O00000oO)) / 4000.0f);
                            Double.isNaN(min);
                            this.O0000O0o = ValueAnimator.ofFloat((float) ((min * 0.14d) + 0.85d), 0.99f);
                            this.O0000O0o.setDuration(4000L);
                            this.O0000O0o.setInterpolator(this.O00000oo);
                            this.O0000O0o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class _m_j.hhd.AnonymousClass2.AnonymousClass1 */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    if (hhd.this.O00000o0 != null) {
                                        hhd.this.O00000o0.setPercent((float) ((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 100.0f)));
                                    }
                                }
                            });
                            this.O0000O0o.start();
                        }
                    }
                }
                return ((Float) this.O0000O0o.getAnimatedValue()).floatValue();
            }

            public final void O000000o(String str, fbo fbo) {
                super.O000000o(str, fbo);
                if (hhd.f18930O000000o.get(device) == null) {
                    PluginDownloadingRecordWrapper pluginDownloadingRecordWrapper = new PluginDownloadingRecordWrapper();
                    pluginDownloadingRecordWrapper.f6715O000000o = device.model;
                    pluginDownloadingRecordWrapper.O00000Oo = PluginDownloadingRecordWrapper.Status.DOWNLOADING;
                    hhd.f18930O000000o.put(device, pluginDownloadingRecordWrapper);
                }
                if (hhd.this.O00000o0 != null) {
                    hhd.this.O00000o0.O000000o();
                }
                this.O00000o = 0.0f;
            }

            public final void O000000o(String str, float f) {
                super.O000000o(str, f);
                if (((double) (f - this.O00000o)) >= 0.005d || f >= 1.0f) {
                    PluginDownloadingRecordWrapper pluginDownloadingRecordWrapper = hhd.f18930O000000o.get(device);
                    if (pluginDownloadingRecordWrapper != null) {
                        if (z && ((double) f) >= 0.99d) {
                            f = 0.99f;
                        }
                        pluginDownloadingRecordWrapper.O00000o0 = f;
                    }
                    int i = (int) (100.0f * f);
                    if (i == 99) {
                        if (this.O00000oO == 0) {
                            this.O00000oO = System.currentTimeMillis();
                        }
                        O00000o0();
                    } else if (hhd.this.O00000o0 != null) {
                        hhk hhk = hhd.this.O00000o0;
                        double d = (double) i;
                        Double.isNaN(d);
                        hhk.setPercent((float) (d * 0.85d));
                    }
                    this.O00000o = f;
                }
            }

            public final void O00000o0(String str) {
                super.O00000o0(str);
                hhd.this.O00000Oo();
                if (hhd.this.O00000oO != null) {
                    hhd.this.O00000oO.O000000o();
                }
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                if (!z) {
                    hhd.f18930O000000o.remove(device);
                }
                hhd.this.O00000oO();
            }

            public final void O000000o(Error error) {
                super.O000000o(error);
                if (!z) {
                    hhd.f18930O000000o.remove(device);
                }
                if (hhd.this.O00000oO != null) {
                    hhd.this.O00000oO.O00000Oo();
                }
                hhd.this.O00000o0.O00000o0();
            }

            public final void O000000o() {
                super.O000000o();
                if (!z) {
                    hhd.f18930O000000o.remove(device);
                }
                if (hhd.this.O00000oO != null) {
                    hhd.this.O00000oO.O00000o0();
                }
                hhd.this.O00000o0.O00000o();
            }
        });
    }

    public final void O000000o() {
        hhk hhk = this.O00000o0;
        if (hhk != null) {
            hhk.O000000o();
        }
    }

    public final void O00000Oo() {
        hhk hhk = this.O00000o0;
        if (hhk != null) {
            hhk.O00000Oo();
        }
    }

    public final void O00000o0() {
        hhk hhk = this.O00000o0;
        if (hhk != null) {
            hhk.O00000o0();
        }
    }

    public final void O00000o() {
        hhk hhk = this.O00000o0;
        if (hhk != null) {
            hhk.O00000o();
        }
    }

    public final void setPercent(float f) {
        hhk hhk = this.O00000o0;
        if (hhk != null) {
            hhk.setPercent(f);
        }
    }

    public final void O00000oO() {
        TimerTask timerTask = this.O0000OoO;
        if (timerTask != null) {
            timerTask.cancel();
        }
        O00000oo();
        this.O0000Oo = new Timer();
        this.O0000OoO = new TimerTask() {
            /* class _m_j.hhd.AnonymousClass4 */

            public final void run() {
                hhd.this.O0000OOo++;
                if (hhd.this.O0000OOo <= 99) {
                    hhd.this.O0000Oo0.sendEmptyMessage(1);
                } else {
                    hhd.this.O00000oo();
                }
            }
        };
        this.O0000Oo.schedule(this.O0000OoO, 200, 200);
    }

    public final void O00000oo() {
        Timer timer = this.O0000Oo;
        if (timer != null) {
            timer.cancel();
        }
        this.O0000OOo = 91;
    }
}
