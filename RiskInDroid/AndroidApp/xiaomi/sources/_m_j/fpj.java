package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.bluetooth.ui.BleMatchActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import java.util.Locale;

public final class fpj extends fpi {
    public int O0000O0o = C.MSG_CUSTOM_BASE;
    public ProgressBar O0000OOo;
    public Handler O0000Oo;
    public ImageView O0000Oo0;
    public boolean O0000OoO = false;
    public Runnable O0000Ooo = new Runnable() {
        /* class _m_j.fpj.AnonymousClass2 */

        public final void run() {
            if (!fpj.this.O0000OoO) {
                if (fob.O00000Oo()) {
                    fob.O000000o(new SearchRequest.O000000o().O00000Oo(fpj.this.O0000O0o, 30000 / fpj.this.O0000O0o).O000000o(), fpj.this.O0000o00);
                } else {
                    fpj.this.O0000Oo.postDelayed(fpj.this.O0000Ooo, 1000);
                }
            }
        }
    };
    private SmartHomeWebView O0000o;
    private Button O0000o0;
    public final fon O0000o00 = new fon() {
        /* class _m_j.fpj.AnonymousClass3 */

        public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
            fpj.this.O000000o((BleDevice) obj);
        }

        public final void O000000o() {
            fpj.this.O000000o(true);
        }

        public final void O00000Oo() {
            fpj.this.O00000oO();
            if (fpj.this.O00000o != null) {
                hxc.O000000o().O000000o(fpj.this.O00000o.model, BindStep.STEP_RESET_DEVICE, "search stopped");
            }
        }

        public final void O00000o0() {
            fpj.this.O00000oo();
            if (fpj.this.O00000o != null) {
                hxc.O000000o().O000000o(fpj.this.O00000o.model, BindStep.STEP_RESET_DEVICE, "search canceled");
            }
        }
    };
    private TextView O0000o0O;
    private ImageView O0000o0o;
    private AnimationDrawable O0000oO;
    private BleDevice O0000oO0;
    private TextView O0000oOO;
    private boolean O0000oOo = false;

    public static fpj O00000o() {
        return new fpj();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        View inflate = layoutInflater.inflate((int) R.layout.ble_bind_image, (ViewGroup) null);
        this.O0000o = (SmartHomeWebView) inflate.findViewById(R.id.ble_guide_webview);
        this.O0000Oo0 = (ImageView) inflate.findViewById(R.id.mj_loading);
        this.O0000o0 = (Button) inflate.findViewById(R.id.retry);
        this.O0000o0o = (ImageView) inflate.findViewById(R.id.arrow);
        this.O0000OOo = (ProgressBar) inflate.findViewById(R.id.pbar);
        this.O0000oOO = (TextView) inflate.findViewById(R.id.device_detail);
        this.O0000o0O = (TextView) inflate.findViewById(R.id.devices);
        this.O0000o0O.getPaint().setFlags(8);
        this.O0000Oo = new Handler(Looper.getMainLooper());
        if (((BleMatchActivity) this.f14469O000000o).hasMatchListFragment()) {
            this.O0000o0O.setVisibility(0);
            this.O0000o0o.setVisibility(0);
        } else {
            this.O0000o0O.setVisibility(8);
            this.O0000o0o.setVisibility(8);
        }
        this.O0000oO = (AnimationDrawable) this.f14469O000000o.getResources().getDrawable(R.drawable.ble_loading);
        if (this.O00000o == null) {
            fte.O00000Oo("BleMatchImageFragment mDevice is null");
        }
        if (this.O00000o != null) {
            this.O0000o.setWebViewClient(new WebViewClient() {
                /* class _m_j.fpj.AnonymousClass1 */

                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    webView.loadUrl(str);
                    return true;
                }

                public final void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    fpj.this.O0000OOo.setVisibility(8);
                    fpj.this.O0000Oo0.setVisibility(0);
                }
            });
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo == null) {
                O00oOooo = Locale.getDefault();
            }
            if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                StringBuilder sb = new StringBuilder("https://");
                if (O0000ooO != null) {
                    str2 = O0000ooO.f7546O000000o + ".";
                } else {
                    str2 = "";
                }
                sb.append(str2);
                sb.append("home.mi.com/views/bleMatch.html?model=");
                sb.append(this.O00000o.model);
                sb.append("&locale=");
                sb.append(flk.O000000o(O00oOooo));
                str = sb.toString();
            } else {
                str = "https://home.mi.com/views/bleMatch.html?model=" + this.O00000o.model + "&locale=" + flk.O000000o(O00oOooo);
            }
            this.O0000o.loadUrl(str);
            dco.O000000o().O000000o(this.O00000o, this.O0000oOO, getContext());
            hxi.O00000o0.O000000o(this.O00000o.model, dco.O000000o().O00000o0() ? 1 : 2);
            this.O0000O0o = eyr.O00000Oo().O0000Oo(this.O00000o.model);
            if (this.O0000O0o <= 0) {
                this.O0000O0o = C.MSG_CUSTOM_BASE;
            }
        }
        this.O0000o0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.fpj.AnonymousClass4 */

            public final void onClick(View view) {
                fpj.this.O00000o0();
            }
        });
        this.O0000o0O.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.fpj.AnonymousClass5 */

            public final void onClick(View view) {
                ((BleMatchActivity) fpj.this.f14469O000000o).switchToMatchListFragment();
            }
        });
        this.O0000o0o.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.fpj.AnonymousClass6 */

            public final void onClick(View view) {
                ((BleMatchActivity) fpj.this.f14469O000000o).switchToMatchListFragment();
            }
        });
        return inflate;
    }

    private static void O0000O0o() {
        gsy.O000000o(4, "stopScan", "BMIF stop");
        fpo.O00000Oo();
    }

    public final void O000000o(boolean z) {
        if (z) {
            this.O0000o0.setVisibility(8);
            this.O0000Oo0.setVisibility(0);
            this.O0000Oo0.setImageDrawable(this.O0000oO);
            this.O0000oO.start();
            return;
        }
        this.O0000o0.setVisibility(0);
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
                    O0000O0o();
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
        O0000O0o();
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
