package _m_j;

import _m_j.fbn;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.ir.IRV2ControllerMiActivity;
import com.xiaomi.smarthome.miui10.MIUI10CardActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class hdu extends hcf<hdr, hds, Object> {
    public List<View> O0000o = new ArrayList();
    View O0000o0o;
    List<TextView> O0000oO = new ArrayList();
    List<ImageView> O0000oO0 = new ArrayList();
    public List<fmu> O0000oOO;
    public long O0000oOo = 0;
    public Object O0000oo = new Object();
    public View O0000oo0;

    public final void O000000o(Object obj, Object obj2) {
    }

    public hdu(hds hds) {
        super(hds, null);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        this.O0000o0o = O000000o(viewGroup, (int) R.layout.card_item_ir_3);
        this.O0000oo0 = this.O0000o0o.findViewById(R.id.ll_no_controller);
        gor.O000000o(new AsyncTask<Object, Object, List<fmu>>() {
            /* class _m_j.hdu.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fqw.O000000o(int, boolean):android.graphics.drawable.Drawable
             arg types: [int, int]
             candidates:
              _m_j.fqw.O000000o(android.app.Activity, int):void
              _m_j.fqw.O000000o(android.content.Context, android.content.Intent):void
              _m_j.fqw.O000000o(int, boolean):android.graphics.drawable.Drawable */
            /* access modifiers changed from: protected */
            /* JADX WARNING: Code restructure failed: missing block: B:63:0x0244, code lost:
                return;
             */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0085  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x00b1  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x00dd  */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x0109  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x0135  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x0161 A[DONT_GENERATE] */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x0163  */
            public final /* synthetic */ void onPostExecute(Object obj) {
                View findViewById;
                View findViewById2;
                View findViewById3;
                View findViewById4;
                View findViewById5;
                View findViewById6;
                List<fmu> list = (List) obj;
                synchronized (hdu.this.O0000oo) {
                    if (!hdu.this.O0000Oo0) {
                        hdu.this.O0000oOO = list;
                        if (hdu.this.O0000oOO != null) {
                            if (hdu.this.O0000oOO.size() > 0) {
                                hdu.this.O0000oo0.setVisibility(8);
                                hdu.O000000o(hdu.this.O0000oOO);
                                hdu hdu = hdu.this;
                                hdu.O0000o.clear();
                                hdu.O0000oO0.clear();
                                hdu.O0000oO.clear();
                                findViewById = hdu.O0000o0o.findViewById(R.id.item_1);
                                if (findViewById != null) {
                                    hdu.O0000o.add(findViewById);
                                    hdu.O0000oO0.add((ImageView) findViewById.findViewById(R.id.image_1));
                                    hdu.O0000oO.add((TextView) findViewById.findViewById(R.id.text_1));
                                }
                                findViewById2 = hdu.O0000o0o.findViewById(R.id.item_2);
                                if (findViewById2 != null) {
                                    hdu.O0000o.add(findViewById2);
                                    hdu.O0000oO0.add((ImageView) findViewById2.findViewById(R.id.image_2));
                                    hdu.O0000oO.add((TextView) findViewById2.findViewById(R.id.text_2));
                                }
                                findViewById3 = hdu.O0000o0o.findViewById(R.id.item_3);
                                if (findViewById3 != null) {
                                    hdu.O0000o.add(findViewById3);
                                    hdu.O0000oO0.add((ImageView) findViewById3.findViewById(R.id.image_3));
                                    hdu.O0000oO.add((TextView) findViewById3.findViewById(R.id.text_3));
                                }
                                findViewById4 = hdu.O0000o0o.findViewById(R.id.item_4);
                                if (findViewById4 != null) {
                                    hdu.O0000o.add(findViewById4);
                                    hdu.O0000oO0.add((ImageView) findViewById4.findViewById(R.id.image_4));
                                    hdu.O0000oO.add((TextView) findViewById4.findViewById(R.id.text_4));
                                }
                                findViewById5 = hdu.O0000o0o.findViewById(R.id.item_5);
                                if (findViewById5 != null) {
                                    hdu.O0000o.add(findViewById5);
                                    hdu.O0000oO0.add((ImageView) findViewById5.findViewById(R.id.image_5));
                                    hdu.O0000oO.add((TextView) findViewById5.findViewById(R.id.text_5));
                                }
                                findViewById6 = hdu.O0000o0o.findViewById(R.id.item_6);
                                if (findViewById6 != null) {
                                    hdu.O0000o.add(findViewById6);
                                    hdu.O0000oO0.add((ImageView) findViewById6.findViewById(R.id.image_6));
                                    hdu.O0000oO.add((TextView) findViewById6.findViewById(R.id.text_6));
                                }
                                if (hdu.this.O0000o.size() != 6) {
                                    if (hdu.this.O0000oOO != null) {
                                        if (hdu.this.O0000oOO.size() > 0) {
                                            int size = hdu.this.O0000oOO.size();
                                            if (!fcn.O000000o().O0000OOo()) {
                                                size = 0;
                                            }
                                            if (size > 6) {
                                                size = 6;
                                            }
                                            for (int i = 0; i < 6; i++) {
                                                if (i < size) {
                                                    hdu hdu2 = hdu.this;
                                                    fmu fmu = hdu2.O0000oOO.get(i);
                                                    ImageView imageView = hdu2.O0000oO0.get(i);
                                                    TextView textView = hdu2.O0000oO.get(i);
                                                    View view = hdu2.O0000o.get(i);
                                                    if (!fcn.O000000o().O0000OOo()) {
                                                        textView.setText((int) R.string.buildin_ir_name);
                                                        imageView.setImageDrawable(fqw.O000000o(false));
                                                        view.setOnClickListener(new View.OnClickListener(view) {
                                                            /* class _m_j.hdu.AnonymousClass3 */

                                                            /* renamed from: O000000o  reason: collision with root package name */
                                                            final /* synthetic */ View f18820O000000o;

                                                            {
                                                                this.f18820O000000o = r2;
                                                            }

                                                            public final void onClick(View view) {
                                                                if (!hdu.this.O0000Oo0) {
                                                                    this.f18820O000000o.getContext().startActivity(new Intent(this.f18820O000000o.getContext(), IRV2ControllerMiActivity.class));
                                                                }
                                                            }
                                                        });
                                                    } else {
                                                        String str = fmu.O00000Oo;
                                                        CharSequence text = textView.getResources().getText(R.string.device_card_name_replace);
                                                        if (str.length() <= 6) {
                                                            textView.setText(str);
                                                        } else {
                                                            String substring = new StringBuilder((CharSequence) str).substring(0, 5);
                                                            textView.setText(substring + ((Object) text));
                                                        }
                                                        imageView.setImageDrawable(fqw.O000000o(fmu.O00000o0, false));
                                                        view.setOnClickListener(new View.OnClickListener(fmu) {
                                                            /* class _m_j.hdu.AnonymousClass4 */

                                                            /* renamed from: O000000o  reason: collision with root package name */
                                                            final /* synthetic */ fmu f18821O000000o;

                                                            {
                                                                this.f18821O000000o = r2;
                                                            }

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
                                                                                    /* class _m_j.hdu.AnonymousClass4.AnonymousClass1 */

                                                                                    public final void O000000o(boolean z) {
                                                                                        if (!hdu.this.O0000Oo0 && z) {
                                                                                            fno.O000000o().O0000Ooo();
                                                                                        }
                                                                                    }
                                                                                });
                                                                                izb.O000000o(CommonApplication.getAppContext(), (int) R.string.toast_failed_retry, 0).show();
                                                                            } else if ("default".equals(this.f18821O000000o.O00000o)) {
                                                                                fqw.O00000o();
                                                                                fqw.O000000o(CommonApplication.getAppContext(), (Intent) null);
                                                                            } else {
                                                                                Intent intent = new Intent();
                                                                                intent.putExtra("remote_id", this.f18821O000000o.f16657O000000o);
                                                                                fqw.O00000o();
                                                                                fqw.O000000o(CommonApplication.getAppContext(), intent);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        });
                                                    }
                                                } else {
                                                    hdu.this.O0000o.get(i).setVisibility(4);
                                                }
                                            }
                                        }
                                    }
                                    for (int i2 = 0; i2 < hdu.this.O0000o.size(); i2++) {
                                        hdu.this.O0000o.get(i2).setVisibility(4);
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                        hdu.this.O0000oo0.setVisibility(0);
                        hdu.O000000o(hdu.this.O0000oOO);
                        hdu hdu3 = hdu.this;
                        hdu3.O0000o.clear();
                        hdu3.O0000oO0.clear();
                        hdu3.O0000oO.clear();
                        findViewById = hdu3.O0000o0o.findViewById(R.id.item_1);
                        if (findViewById != null) {
                        }
                        findViewById2 = hdu3.O0000o0o.findViewById(R.id.item_2);
                        if (findViewById2 != null) {
                        }
                        findViewById3 = hdu3.O0000o0o.findViewById(R.id.item_3);
                        if (findViewById3 != null) {
                        }
                        findViewById4 = hdu3.O0000o0o.findViewById(R.id.item_4);
                        if (findViewById4 != null) {
                        }
                        findViewById5 = hdu3.O0000o0o.findViewById(R.id.item_5);
                        if (findViewById5 != null) {
                        }
                        findViewById6 = hdu3.O0000o0o.findViewById(R.id.item_6);
                        if (findViewById6 != null) {
                        }
                        if (hdu.this.O0000o.size() != 6) {
                        }
                    }
                }
            }

            private static List<fmu> O000000o() {
                try {
                    return fqw.O00000Oo(CommonApplication.getAppContext());
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
        }, new Object[0]);
    }

    public final void O00000o0() {
        synchronized (this.O0000oo) {
            super.O00000o0();
            this.O0000o.clear();
            this.O0000oO.clear();
            this.O0000oO0.clear();
            this.O0000o0o = null;
            this.O0000oo0 = null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    public static void O000000o(List<fmu> list) {
        String str = "IrRemoteList" + "DuoKan";
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (fmu fmu : list) {
                jSONArray.put(fmu.O00000o0);
            }
        }
        CoreApi.O000000o().O000000o(StatType.EVENT, str, jSONArray.toString(), (String) null, false);
    }
}
