package _m_j;

import _m_j.gsj;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.bluetooth.ui.BleMatchActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONObject;

public final class fpl extends fpi {
    public int O0000O0o = C.MSG_CUSTOM_BASE;
    public ProgressBar O0000OOo;
    public Handler O0000Oo;
    public ImageView O0000Oo0;
    public boolean O0000OoO = false;
    public Runnable O0000Ooo = new Runnable() {
        /* class _m_j.fpl.AnonymousClass4 */

        public final void run() {
            if (!fpl.this.O0000OoO) {
                if (fob.O00000Oo()) {
                    fob.O000000o(new SearchRequest.O000000o().O00000Oo(fpl.this.O0000O0o, 30000 / fpl.this.O0000O0o).O000000o(), fpl.this.O0000o00);
                } else {
                    fpl.this.O0000Oo.postDelayed(fpl.this.O0000Ooo, 1000);
                }
            }
        }
    };
    private ImageView O0000o;
    private SimpleDraweeView O0000o0;
    public final fon O0000o00 = new fon() {
        /* class _m_j.fpl.AnonymousClass5 */

        public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
            fpl.this.O000000o((BleDevice) obj);
        }

        public final void O000000o() {
            fpl.this.O000000o(true);
        }

        public final void O00000Oo() {
            fpl.this.O00000oO();
            if (fpl.this.O00000o != null) {
                hxc.O000000o().O000000o(fpl.this.O00000o.model, BindStep.STEP_RESET_DEVICE, "search stopped");
            }
        }

        public final void O00000o0() {
            fpl.this.O00000oo();
            if (fpl.this.O00000o != null) {
                hxc.O000000o().O000000o(fpl.this.O00000o.model, BindStep.STEP_RESET_DEVICE, "search canceled");
            }
        }
    };
    private Button O0000o0O;
    private TextView O0000o0o;
    private AnimationDrawable O0000oO;
    private BleDevice O0000oO0;
    private TextView O0000oOO;
    private boolean O0000oOo = false;

    interface O000000o {
        void O000000o(String str);
    }

    public static fpl O00000o() {
        return new fpl();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0121 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x015f  */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        gsj gsj = null;
        View inflate = layoutInflater.inflate((int) R.layout.ble_ninebot_bind_image, (ViewGroup) null);
        this.O0000o0 = (SimpleDraweeView) inflate.findViewById(R.id.icon);
        this.O0000Oo0 = (ImageView) inflate.findViewById(R.id.mj_loading);
        this.O0000o0O = (Button) inflate.findViewById(R.id.retry);
        this.O0000o = (ImageView) inflate.findViewById(R.id.arrow);
        this.O0000OOo = (ProgressBar) inflate.findViewById(R.id.pbar);
        this.O0000oOO = (TextView) inflate.findViewById(R.id.device_detail);
        this.O0000o0o = (TextView) inflate.findViewById(R.id.devices);
        this.O0000o0o.getPaint().setFlags(8);
        this.O0000Oo = new Handler(Looper.getMainLooper());
        this.O0000o0.setHierarchy(new GenericDraweeHierarchyBuilder(this.O0000o0.getResources()).setFadeDuration(200).build());
        if (((BleMatchActivity) this.f14469O000000o).hasMatchListFragment()) {
            this.O0000o0o.setVisibility(0);
            this.O0000o.setVisibility(0);
        } else {
            this.O0000o0o.setVisibility(8);
            this.O0000o.setVisibility(8);
        }
        this.O0000oO = (AnimationDrawable) this.f14469O000000o.getResources().getDrawable(R.drawable.ble_loading);
        if (this.O00000o == null) {
            fte.O00000Oo("BleMatchImageFragment mDevice is null");
        }
        if (this.O00000o != null) {
            if (TextUtils.equals(this.O00000o.model, "ninebot.scooter.v1") || TextUtils.equals(this.O00000o.model, "ninebot.scooter.v2")) {
                final String str = this.O00000o.model;
                final AnonymousClass1 r0 = new O000000o() {
                    /* class _m_j.fpl.AnonymousClass1 */

                    public final void O000000o(final String str) {
                        Activity activity = (Activity) fpl.this.f14469O000000o;
                        if (activity != null && !activity.isFinishing()) {
                            fpl.this.O0000Oo.post(new Runnable() {
                                /* class _m_j.fpl.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    fpl.this.O00000Oo(str);
                                }
                            });
                        }
                    }
                };
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lang", "zh_CN");
                StringBuilder sb = new StringBuilder("pair_image_ninebot");
                sb.append(gfr.O0000oo0 ? "_preview" : "");
                jSONObject.put("name", sb.toString());
                jSONObject.put("version", "1");
                try {
                    gsj.O000000o o000000o = new gsj.O000000o();
                    o000000o.f18212O000000o = "GET";
                    gsj = o000000o.O00000Oo(hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).O000000o();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (gsj != null) {
                    gsg.O00000Oo(gsj, new gsl() {
                        /* class _m_j.fpl.AnonymousClass3 */

                        public final void onFailure(gsf gsf, Exception exc, Response response) {
                        }

                        public final void onSuccess(Object obj, Response response) {
                        }

                        public final void processFailure(Call call, IOException iOException) {
                        }

                        public final void processResponse(Response response) {
                            JSONObject optJSONObject;
                            String str;
                            try {
                                JSONObject optJSONObject2 = new JSONObject(response.body().string()).optJSONObject("result");
                                if (optJSONObject2 != null) {
                                    String optString = optJSONObject2.optString("content");
                                    if (!TextUtils.isEmpty(optString) && (optJSONObject = new JSONObject(optString).optJSONObject(str)) != null) {
                                        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                                        if (O00oOooo == null) {
                                            O00oOooo = Locale.getDefault();
                                        }
                                        String lowerCase = O00oOooo.getLanguage().toLowerCase();
                                        if ("zh".equals(lowerCase)) {
                                            str = optJSONObject.optString("zh-Hans");
                                        } else {
                                            str = optJSONObject.optString(lowerCase);
                                        }
                                        if (TextUtils.isEmpty(str)) {
                                            str = optJSONObject.optString("en");
                                        }
                                        r0.O000000o(str);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } else {
                O00000Oo(BleDevice.O00000o(this.O00000o.model));
            }
            hxi.O00000o0.O000000o(this.O00000o.model, dco.O000000o().O00000o0() ? 1 : 2);
            this.O0000O0o = eyr.O00000Oo().O0000Oo(this.O00000o.model);
            if (this.O0000O0o <= 0) {
                this.O0000O0o = C.MSG_CUSTOM_BASE;
            }
        }
        this.O0000o0O.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.fpl.AnonymousClass6 */

            public final void onClick(View view) {
                fpl.this.O00000o0();
            }
        });
        this.O0000o0o.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.fpl.AnonymousClass7 */

            public final void onClick(View view) {
                ((BleMatchActivity) fpl.this.f14469O000000o).switchToMatchListFragment();
            }
        });
        this.O0000o.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.fpl.AnonymousClass8 */

            public final void onClick(View view) {
                ((BleMatchActivity) fpl.this.f14469O000000o).switchToMatchListFragment();
            }
        });
        return inflate;
    }

    public final void O00000Oo(String str) {
        if (this.O00000o != null && !TextUtils.isEmpty(str)) {
            AnonymousClass2 r0 = new BaseControllerListener() {
                /* class _m_j.fpl.AnonymousClass2 */

                public final void onFinalImageSet(String str, Object obj, Animatable animatable) {
                    fpl.this.O0000OOo.setVisibility(8);
                    fpl.this.O0000Oo0.setVisibility(0);
                }

                public final void onFailure(String str, Throwable th) {
                    super.onFailure(str, th);
                }
            };
            this.O0000o0.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setControllerListener(r0)).setImageRequest(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setResizeOptions(new ResizeOptions(540, 960)).build())).build());
            O0000O0o();
        }
    }

    @SuppressLint({"CheckResult"})
    private void O0000O0o() {
        dco.O000000o().O000000o(this.O00000o, this.O0000oOO, getContext());
    }

    private static void O0000OOo() {
        gsy.O000000o(4, "stopScan", "BMIF stop");
        fpo.O00000Oo();
    }

    public final void O000000o(boolean z) {
        if (z) {
            this.O0000o0O.setVisibility(8);
            this.O0000Oo0.setVisibility(0);
            this.O0000Oo0.setImageDrawable(this.O0000oO);
            this.O0000oO.start();
            return;
        }
        this.O0000o0O.setVisibility(0);
        this.O0000Oo0.setVisibility(8);
        this.O0000oO.stop();
    }

    public final void O000000o(BleDevice bleDevice) {
        if (this.O00000o != null) {
            boolean z = false;
            if ((this.O00000o.model.equals(bleDevice.model) || O000000o(bleDevice.model)) && !fob.O00000Oo(bleDevice)) {
                boolean z2 = bleDevice.O00000Oo() != null && bleDevice.O00000Oo().O00000Oo();
                Object[] objArr = new Object[3];
                objArr[0] = fte.O000000o(bleDevice.mac);
                if (bleDevice.O00000Oo() != null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Boolean.valueOf(z2);
                fte.O00000Oo(String.format(">>> for %s: isMiot = %b, isBinding = %b", objArr));
                if (z2) {
                    this.O0000oO0 = bleDevice;
                    if (this.O00000o != null) {
                        hxc.O000000o().O00000o0(this.O00000o.model, BindStep.STEP_RESET_DEVICE);
                    }
                    O0000OOo();
                }
            }
        }
    }

    public final void O00000oO() {
        if (this.O0000oO0 == null) {
            if (this.O00000o != null) {
                hxi.O00000o.O000000o(this.O00000o.model, -1);
            }
            O000000o(false);
            return;
        }
        this.O0000oOo = true;
        ((BleMatchActivity) this.f14469O000000o).onDeviceMatched(this.O0000oO0, true);
    }

    public final void O00000oo() {
        if (this.O0000oO0 != null) {
            this.O0000Oo0.setVisibility(4);
            if (this.O00000o != null) {
                hxi.O00000o.O000000o(this.O00000o.model, 0);
            }
            this.O0000oOo = true;
            ((BleMatchActivity) this.f14469O000000o).onDeviceMatched(this.O0000oO0, true);
        }
    }

    public final void onPause() {
        super.onPause();
        O0000OOo();
        if (this.O00000o != null) {
            hxc.O000000o().O000000o(this.O00000o.model, BindStep.STEP_RESET_DEVICE, "pause watch");
        }
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
    public final void onResume() {
        super.onResume();
        if (!this.O0000oOo) {
            O00000o0();
        } else if (this.f14469O000000o != null) {
            Intent intent = new Intent();
            intent.putExtra("finish", true);
            ((Activity) this.f14469O000000o).setResult(-1, intent);
            ((Activity) this.f14469O000000o).finish();
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.O0000OoO = true;
        this.O0000oO.stop();
        this.O0000Oo.removeCallbacks(this.O0000Ooo);
    }

    public final void O00000o0() {
        fte.O00000Oo("startWatchAdvertisement isMatchByKey");
        if (this.O00000o != null) {
            hxc.O000000o().O000000o(this.O00000o.model, BindStep.STEP_RESET_DEVICE);
        }
        if (fob.O00000Oo()) {
            SearchRequest.O000000o o000000o = new SearchRequest.O000000o();
            int i = this.O0000O0o;
            fob.O000000o(o000000o.O00000Oo(i, 30000 / i).O000000o(), this.O0000o00);
            return;
        }
        fob.O00000o0();
        this.O0000Oo.removeCallbacks(this.O0000Ooo);
        this.O0000Oo.postDelayed(this.O0000Ooo, 1000);
    }
}
