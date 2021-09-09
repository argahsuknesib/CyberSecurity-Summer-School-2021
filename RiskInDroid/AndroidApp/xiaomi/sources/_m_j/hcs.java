package _m_j;

import _m_j.fbn;
import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miui10.MIUI10CardActivity;
import java.util.ArrayList;

public final class hcs<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hbz<C, E, T> {
    private View O0000Oo;
    private hhk O0000Oo0;
    private View O0000OoO;

    public hcs(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device) {
        super(c, arrayList, viewGroup, context, device);
    }

    public final hhk O00000Oo() {
        return this.O0000Oo0;
    }

    public final View O00000o0() {
        return this.O0000Oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o() {
        super.O000000o();
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.miui10_cardlayout_ir, this.O00000o0, false);
        this.O00000o0.addView(inflate);
        hdu hdu = (hdu) this.f10206O000000o.get(0);
        this.O0000OoO = inflate.findViewById(R.id.ll_title_content);
        this.O0000OoO.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hdu.AnonymousClass2 */

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
            public final void onClick(View view) {
                if (!hdu.this.O0000Oo0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - hdu.this.O0000oOo >= 1500) {
                        hdu.this.O0000oOo = currentTimeMillis;
                        if (!fcn.O000000o().O0000OOo()) {
                            fbr.O000000o(view.getContext());
                            return;
                        }
                        String O000000o2 = fqw.O000000o();
                        if (!TextUtils.isEmpty(O000000o2)) {
                            if (!TextUtils.isEmpty(MIUI10CardActivity.sRoomName)) {
                                fbq.O000000o(O000000o2, MIUI10CardActivity.sRoomName, false);
                            }
                            if (!CoreApi.O000000o().O00000o(O000000o2)) {
                                fbn.O000000o(new fbn.O000000o() {
                                    /* class _m_j.hdu.AnonymousClass2.AnonymousClass1 */

                                    public final void O000000o(boolean z) {
                                        if (!hdu.this.O0000Oo0 && z) {
                                            fno.O000000o().O0000Ooo();
                                        }
                                    }
                                });
                                izb.O000000o(CommonApplication.getAppContext(), (int) R.string.toast_failed_retry, 0).show();
                                return;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("add_device", true);
                            fqw.O00000o();
                            fqw.O000000o(CommonApplication.getAppContext(), intent);
                        }
                    }
                }
            }
        });
        hdu.O000000o((ViewGroup) inflate.findViewById(R.id.ll_content), 1, 0);
        O000000o(this.O00000o0, this.O00000oO);
        this.O0000Oo0 = (hhk) inflate.findViewById(R.id.dpb_enter_device);
        this.O0000Oo = inflate.findViewById(R.id.progress_enter_device);
    }
}
