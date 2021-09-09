package _m_j;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.frame.plugin.SendMessageHandle;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;

public final class hme extends SendMessageCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    public final XQProgressHorizontalDialog f19059O000000o;
    public final SendMessageHandle O00000Oo;
    private final hmc O00000o;
    private final boolean O00000o0;
    private final Activity O00000oO;
    private long O00000oo;
    private final Interpolator O0000O0o;
    private volatile ValueAnimator O0000OOo;

    public hme(Activity activity, String str, SendMessageHandle sendMessageHandle, XQProgressHorizontalDialog xQProgressHorizontalDialog, hmc hmc) {
        this.O0000O0o = new DecelerateInterpolator();
        this.O00000oO = activity;
        this.O00000o = hmc;
        this.f19059O000000o = xQProgressHorizontalDialog;
        this.O00000o0 = CoreApi.O000000o().O0000OoO(str) == null && CoreApi.O000000o().O0000Oo(str) == null;
        this.O00000Oo = sendMessageHandle;
    }

    public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
        if (!this.O00000oO.isFinishing()) {
            XQProgressHorizontalDialog xQProgressHorizontalDialog = this.f19059O000000o;
            xQProgressHorizontalDialog.f9117O000000o = false;
            xQProgressHorizontalDialog.setCancelable(true);
            this.f19059O000000o.O000000o(true);
            this.f19059O000000o.setCanceledOnTouchOutside(false);
            this.f19059O000000o.show();
            this.f19059O000000o.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class _m_j.hme.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    hme.this.O00000Oo.cancel();
                }
            });
        }
    }

    public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
        this.f19059O000000o.O000000o(100, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    private float O000000o() {
        if (this.O0000OOo == null) {
            synchronized (this) {
                if (this.O0000OOo == null) {
                    double min = (double) Math.min(1.0f, ((float) (System.currentTimeMillis() - this.O00000oo)) / 4000.0f);
                    Double.isNaN(min);
                    this.O0000OOo = ValueAnimator.ofFloat((float) ((min * 0.14d) + 0.85d), 0.99f);
                    this.O0000OOo.setDuration(4000L);
                    this.O0000OOo.setInterpolator(this.O0000O0o);
                    this.O0000OOo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class _m_j.hme.AnonymousClass2 */

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (hme.this.f19059O000000o != null) {
                                hme.this.f19059O000000o.O000000o(100, (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 100.0f));
                            }
                        }
                    });
                    this.O0000OOo.start();
                }
            }
        }
        return ((Float) this.O0000OOo.getAnimatedValue()).floatValue();
    }

    public final void onDownloadProgress(String str, float f) {
        if (this.O00000o0) {
            int i = (int) (f * 100.0f);
            if (i >= 99) {
                if (this.O00000oo == 0) {
                    this.O00000oo = System.currentTimeMillis();
                }
                i = 99;
            }
            if (i == 99) {
                O000000o();
                return;
            }
            XQProgressHorizontalDialog xQProgressHorizontalDialog = this.f19059O000000o;
            if (xQProgressHorizontalDialog != null) {
                double d = (double) i;
                Double.isNaN(d);
                xQProgressHorizontalDialog.O000000o(100, (int) (d * 0.85d));
                return;
            }
            return;
        }
        XQProgressHorizontalDialog xQProgressHorizontalDialog2 = this.f19059O000000o;
        if (xQProgressHorizontalDialog2 != null) {
            xQProgressHorizontalDialog2.O000000o(100, (int) (f * 100.0f));
        }
    }

    public final void onDownloadSuccess(String str) {
        XQProgressHorizontalDialog xQProgressHorizontalDialog;
        if (!this.O00000o0 && (xQProgressHorizontalDialog = this.f19059O000000o) != null) {
            xQProgressHorizontalDialog.dismiss();
        }
    }

    public final void onInstallSuccess(String str) {
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
        if (this.f19059O000000o != null && O0000Oo != null && "rn".equalsIgnoreCase(O0000Oo.O0000O0o())) {
            CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class _m_j.hme.AnonymousClass3 */

                public final void run() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = hme.this.f19059O000000o;
                    if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }
            }, 3000);
        }
    }

    public final void onDownloadFailure(PluginError pluginError) {
        XQProgressHorizontalDialog xQProgressHorizontalDialog;
        if (!this.O00000o0 && (xQProgressHorizontalDialog = this.f19059O000000o) != null) {
            xQProgressHorizontalDialog.dismiss();
        }
        if (pluginError != null) {
            gsy.O000000o(6, "DeviceRenderer", pluginError.O00000Oo);
        }
    }

    public final void onDownloadCancel() {
        XQProgressHorizontalDialog xQProgressHorizontalDialog;
        if (!this.O00000o0 && (xQProgressHorizontalDialog = this.f19059O000000o) != null) {
            xQProgressHorizontalDialog.dismiss();
        }
    }

    public final void onSendSuccess(Bundle bundle) {
        if (this.O00000o0) {
            CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class _m_j.hme.AnonymousClass4 */

                public final void run() {
                    if (hme.this.f19059O000000o != null) {
                        hme.this.f19059O000000o.dismiss();
                    }
                }
            }, 500);
        }
        hmc hmc = this.O00000o;
        if (hmc != null) {
            hmc.onLoadingFinish(true);
        }
    }

    public final void onSendFailure(fso fso) {
        XQProgressHorizontalDialog xQProgressHorizontalDialog;
        if (this.O00000o0 && (xQProgressHorizontalDialog = this.f19059O000000o) != null) {
            xQProgressHorizontalDialog.dismiss();
        }
        hmc hmc = this.O00000o;
        if (hmc != null) {
            hmc.onLoadingFinish(false);
        }
        if (fso != null) {
            gsy.O000000o(6, "DeviceRenderer", fso.toString());
        }
        hte.O000000o(this.O00000oO, fso.O00000Oo, 0);
    }

    public final void onSendCancel() {
        XQProgressHorizontalDialog xQProgressHorizontalDialog;
        if (this.O00000o0 && (xQProgressHorizontalDialog = this.f19059O000000o) != null) {
            xQProgressHorizontalDialog.dismiss();
        }
        hmc hmc = this.O00000o;
        if (hmc != null) {
            hmc.onLoadingFinish(false);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    private hme(Activity activity, String str, SendMessageHandle sendMessageHandle, hmc hmc) {
        this(activity, str, sendMessageHandle, XQProgressHorizontalDialog.O000000o(activity, r1.toString()), hmc);
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(str);
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getString(R.string.plugin_downloading));
        sb.append(O00000oO2 == null ? "" : O00000oO2.O0000Oo0());
    }

    public static SendMessageHandle O000000o(Activity activity, String str, Intent intent, DeviceStat deviceStat, hmc hmc) {
        SendMessageHandle sendMessageHandle = new SendMessageHandle();
        return PluginApi.getInstance().sendMessage(activity, str, 1, intent, deviceStat, null, false, new hme(activity, str, sendMessageHandle, hmc), sendMessageHandle);
    }
}
