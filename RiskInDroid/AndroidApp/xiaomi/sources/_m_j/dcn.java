package _m_j;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.smarthome.connect.view.StringChooser;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Callback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dcn extends dcl {
    public static final String O0000OOo = "dcn";
    public StringChooser O00000o;
    TextView O00000oO;
    public boolean O00000oo = true;
    public O000000o O0000O0o;
    private TextView O0000Oo0;

    public interface O000000o {
        void O000000o();
    }

    public static dcn O00000Oo() {
        return new dcn();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af A[EDGE_INSN: B:36:0x00af->B:34:0x00af ?: BREAK  , SYNTHETIC] */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        O000000o o000000o;
        View inflate = layoutInflater.inflate((int) R.layout.miconnect_common_wheel_config, (ViewGroup) null);
        this.O00000oO = (TextView) inflate.findViewById(R.id.common_tile_tv);
        this.O0000Oo0 = (TextView) inflate.findViewById(R.id.common_bottom_tv);
        this.O0000Oo0.setText((int) R.string.miconnect_continue_config);
        this.O00000o = (StringChooser) inflate.findViewById(R.id.string_chooser);
        new gw().O000000o(this.O00000o);
        ArrayList<fcj> O00000Oo = dco.O000000o().O00000Oo();
        if (O00000Oo == null || O00000Oo.size() == 0) {
            O000000o o000000o2 = this.O0000O0o;
            if (o000000o2 != null) {
                o000000o2.O000000o();
                this.O0000O0o = null;
            }
        } else if (O00000Oo.size() > 1) {
            dct.O00000Oo("set origin select data: home");
            this.O00000oO.setText((int) R.string.miconnect_choose_home_for_device);
            this.O00000o.setHomeItems(O00000Oo);
            this.O00000oo = true;
            dcx dcx = dcv.O00000Oo;
            dcx.O000000o("closeto_home_pop", dcx.O00000Oo);
        } else {
            dct.O00000Oo("set origin select data: room");
            dco.O000000o().O000000o(O00000Oo.get(0));
            ArrayList<fcj> O000000o2 = dco.O000000o().O000000o(O00000Oo.get(0).O00000Oo);
            if (O000000o2.size() <= 2) {
                List<fcj> O00000o2 = dco.O000000o().O00000o();
                if (O000000o2.size() > 0) {
                    Iterator<fcj> it = O00000o2.iterator();
                    while (it.hasNext()) {
                        fcj next = it.next();
                        Iterator<fcj> it2 = O000000o2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                fcj next2 = it2.next();
                                if (TextUtils.isEmpty(next.f16082O000000o) || next.f16082O000000o.equals(next2.f16082O000000o)) {
                                    it.remove();
                                }
                                if (!it2.hasNext()) {
                                    break;
                                }
                            }
                        }
                        it.remove();
                    }
                }
                O000000o2.addAll(O00000o2);
            }
            if (O000000o2.size() > 0 || (o000000o = this.O0000O0o) == null) {
                this.O00000oO.setText((int) R.string.miconnect_choose_room_for_device);
                this.O00000o.setHomeItems(O000000o2);
                this.O00000oo = false;
                dcv.O00000Oo.O000000o();
            } else {
                o000000o.O000000o();
                this.O0000O0o = null;
            }
        }
        this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.dcn.AnonymousClass1 */

            public final void onClick(View view) {
                if (dcn.this.O00000oo) {
                    dco.O000000o().O000000o(dcn.this.O00000o.getSelectedItem());
                    dcw dcw = dcv.f14488O000000o;
                    dcw.O000000o("closeto_home_click", dcw.O00000Oo);
                    dcn dcn = dcn.this;
                    dct.O00000Oo("switch select data to room");
                    ArrayList<fcj> O000000o2 = dco.O000000o().O000000o(dco.O000000o().O00000Oo.O00000Oo);
                    if (O000000o2.size() <= 2) {
                        O000000o2.addAll(dco.O000000o().O00000o());
                    }
                    if (O000000o2.size() > 0 || dcn.O0000O0o == null) {
                        dcn.O00000oO.setText((int) R.string.miconnect_choose_room_for_device);
                        StringChooser stringChooser = dcn.O00000o;
                        stringChooser.f5655O000000o.clear();
                        stringChooser.f5655O000000o.addAll(O000000o2);
                        stringChooser.f5655O000000o.add(0, new fcj("", ""));
                        stringChooser.f5655O000000o.add(new fcj("", ""));
                        stringChooser.clearOnScrollListeners();
                        stringChooser.setOnFlingListener(null);
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.smarthome.connect.view.StringChooser.AnonymousClass2 */

                            public final void run() {
                                StringChooser.this.scrollToPosition(0);
                                StringChooser stringChooser = StringChooser.this;
                                stringChooser.O0000OOo = 0;
                                stringChooser.addOnScrollListener(new RecyclerView.O00oOooO() {
                                    /* class com.smarthome.connect.view.StringChooser.AnonymousClass2.AnonymousClass1 */

                                    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                                        super.onScrollStateChanged(recyclerView, i);
                                    }

                                    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                                        super.onScrolled(recyclerView, i, i2);
                                        StringChooser.this.O0000OOo += i2;
                                        StringChooser.this.O000000o();
                                    }
                                });
                                StringChooser stringChooser2 = StringChooser.this;
                                stringChooser2.O00000oo = 1;
                                stringChooser2.O0000o00.f14495O000000o = 1;
                                StringChooser.this.O0000o00.notifyDataSetChanged();
                            }
                        });
                        new gw().O000000o(dcn.O00000o);
                        dcn.O00000oo = false;
                        dcv.O00000Oo.O000000o();
                        return;
                    }
                    dcn.O0000O0o.O000000o();
                    dcn.O0000O0o = null;
                    return;
                }
                final fcj selectedItem = dcn.this.O00000o.getSelectedItem();
                if (TextUtils.isEmpty(selectedItem.O00000Oo)) {
                    dco O000000o3 = dco.O000000o();
                    String str = selectedItem.f16082O000000o;
                    String str2 = dco.O000000o().O00000Oo.O00000Oo;
                    AnonymousClass1 r4 = new Callback<String>() {
                        /* class _m_j.dcn.AnonymousClass1.AnonymousClass1 */

                        public final void onFailure(int i, String str) {
                            gsy.O000000o(6, dcn.O0000OOo, "create room failed, info : ".concat(String.valueOf(str)));
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            for (fcj next : dco.O000000o().O000000o(dco.O000000o().O00000Oo.O00000Oo)) {
                                if (selectedItem.f16082O000000o.equals(next.f16082O000000o)) {
                                    dco.O000000o().O00000Oo(next);
                                    return;
                                }
                            }
                        }
                    };
                    if (O000000o3.f14476O000000o != null) {
                        O000000o3.f14476O000000o.O000000o(str, str2, r4);
                    }
                } else {
                    dco.O000000o().O00000Oo(selectedItem);
                }
                if (dcn.this.O0000O0o != null) {
                    dcn.this.O0000O0o.O000000o();
                    dcn.this.O0000O0o = null;
                }
                dcw dcw2 = dcv.f14488O000000o;
                dcw2.O000000o("closeto_room_click", dcw2.O00000Oo);
            }
        });
        return inflate;
    }
}
