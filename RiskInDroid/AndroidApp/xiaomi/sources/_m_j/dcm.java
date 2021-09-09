package _m_j;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.smarthome.connect.bluetooth.MiConnectBleMatchActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.device.BleDevice;

public class dcm extends dcl {
    private static final String O0000OoO = "dcm";
    public ProgressBar O00000o;
    BleDevice O00000oO;
    public Handler O00000oo;
    public boolean O0000O0o = false;
    public BleDevice O0000OOo;
    public final fon O0000Oo = new fon() {
        /* class _m_j.dcm.AnonymousClass3 */

        public final /* synthetic */ void O000000o(Object obj) {
            BleDevice bleDevice = (BleDevice) obj;
            dct.O00000Oo("onDeviceFounded");
            dcm dcm = dcm.this;
            if (dcm.O0000OOo != null && dcm.O0000OOo.model.equals(bleDevice.model)) {
                boolean z = false;
                boolean z2 = bleDevice.O00000Oo() != null && bleDevice.O00000Oo().O00000Oo();
                Object[] objArr = new Object[3];
                objArr[0] = dct.O000000o(bleDevice.mac);
                if (bleDevice.O00000Oo() != null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Boolean.valueOf(z2);
                dct.O00000o(String.format(">>> for %s: isMiot = %b, isBinding = %b", objArr));
                if (z2) {
                    dcm.O00000oO = bleDevice;
                    dcm.O00000o();
                }
            }
        }

        public final void O000000o() {
            dct.O00000Oo("onSearchStarted");
            dcm.this.O000000o(true);
        }

        public final void O00000Oo() {
            dct.O00000Oo("onSearchStopped");
            dcm dcm = dcm.this;
            if (dcm.O00000oO == null) {
                dcm.O000000o(false);
            } else {
                ((MiConnectBleMatchActivity) dcm.f14469O000000o).onDeviceMatched(dcm.O00000oO);
            }
        }

        public final void O00000o0() {
            dct.O00000Oo("onSearchCanceled");
            dcm dcm = dcm.this;
            if (dcm.O00000oO != null) {
                ((MiConnectBleMatchActivity) dcm.f14469O000000o).onDeviceMatched(dcm.O00000oO);
            }
        }
    };
    public Runnable O0000Oo0 = new Runnable() {
        /* class _m_j.dcm.AnonymousClass2 */

        public final void run() {
            if (!dcm.this.O0000O0o) {
                if (fob.O00000Oo()) {
                    fob.O000000o(new SearchRequest.O000000o().O00000Oo(C.MSG_CUSTOM_BASE, 3).O000000o(), dcm.this.O0000Oo);
                } else {
                    dcm.this.O00000oo.postDelayed(dcm.this.O0000Oo0, 1000);
                }
            }
        }
    };
    private FrameLayout O0000Ooo;
    private TextView O0000o0;
    private TextView O0000o00;
    private FrameLayout O0000o0O;
    private AnimationDrawable O0000o0o;

    public static dcm O00000Oo() {
        return new dcm();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.miconnect_ble_bind_image, viewGroup, false);
        this.O0000Ooo = (FrameLayout) inflate.findViewById(R.id.icon_content);
        this.O00000o = (ProgressBar) inflate.findViewById(R.id.pbar);
        this.O0000o00 = (TextView) inflate.findViewById(R.id.common_tile_tv);
        this.O0000o0 = (TextView) inflate.findViewById(R.id.retry);
        this.O0000o0O = (FrameLayout) inflate.findViewById(R.id.retry_layout);
        this.O0000o00.setText((int) R.string.miconnect_reset_device);
        this.O00000oo = new Handler(Looper.getMainLooper());
        this.O0000o0o = (AnimationDrawable) this.f14469O000000o.getResources().getDrawable(R.drawable.miconnect_ble_loading);
        if (this.O0000OOo == null) {
            dct.O00000o0("BleMatchImageFragment mDevice is null");
        }
        if (TextUtils.isEmpty(this.O0000OOo.model)) {
            gsy.O000000o(6, O0000OoO, "model is empty");
        } else {
            dco O000000o2 = dco.O000000o();
            WebView O000000o3 = O000000o2.f14476O000000o != null ? O000000o2.f14476O000000o.O000000o(getContext(), this.O0000OOo.model) : null;
            if (O000000o3 != null) {
                O000000o3.setWebViewClient(new WebViewClient() {
                    /* class _m_j.dcm.AnonymousClass1 */

                    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        webView.loadUrl(str);
                        return true;
                    }

                    public final void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        dcm.this.O00000o.setVisibility(8);
                    }
                });
                this.O0000Ooo.removeAllViews();
                this.O0000Ooo.addView(O000000o3);
            }
        }
        this.O0000o0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.dcm.AnonymousClass4 */

            public final void onClick(View view) {
                dcm.this.O00000o0();
            }
        });
        return inflate;
    }

    public final void O00000o0() {
        dct.O00000oo("startWatchAdvertisement isMatchByKey");
        if (fob.O00000Oo()) {
            fob.O000000o(new SearchRequest.O000000o().O00000Oo(C.MSG_CUSTOM_BASE, 3).O000000o(), this.O0000Oo);
            return;
        }
        fob.O00000o0();
        this.O00000oo.removeCallbacks(this.O0000Oo0);
        this.O00000oo.postDelayed(this.O0000Oo0, 1000);
    }

    public static void O00000o() {
        dct.O00000Oo("stopScan BMTP stop");
        fpo.O00000Oo();
    }

    public final void O000000o(boolean z) {
        if (z) {
            this.O0000o0O.setVisibility(8);
            this.O0000o0o.start();
            return;
        }
        this.O0000o0O.setVisibility(0);
        this.O0000o0o.stop();
    }

    public void onPause() {
        super.onPause();
        O00000o();
    }

    public void onResume() {
        super.onResume();
        O00000o0();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.O0000O0o = true;
        this.O0000o0o.stop();
        this.O00000oo.removeCallbacks(this.O0000Oo0);
    }
}
