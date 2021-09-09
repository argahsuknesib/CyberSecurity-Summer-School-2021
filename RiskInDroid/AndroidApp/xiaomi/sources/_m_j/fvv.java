package _m_j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class fvv extends RecyclerView.O000000o<RecyclerView.O000OOo0> implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f17285O000000o = false;
    public List<JSONObject> O00000Oo = new ArrayList();
    private Context O00000o;
    public O000000o O00000o0;

    public interface O000000o {
        void O000000o();

        void O000000o(int i);

        void O000000o(int i, boolean z);

        void O00000Oo(int i);
    }

    public final void onClick(View view) {
    }

    public fvv(Context context, List<JSONObject> list) {
        this.O00000o = context;
        O000000o(list, this.O00000Oo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 0) {
            return new O00000Oo(LayoutInflater.from(this.O00000o).inflate((int) R.layout.item_rn_debug_list_plugin_debug, viewGroup, false));
        }
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.item_rn_debug_list_plugin, viewGroup, false);
        inflate.setOnClickListener(this);
        return new O00000o0(inflate);
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        String str;
        if (o000OOo0 instanceof O00000o0) {
            JSONObject jSONObject = this.O00000Oo.get(i);
            O00000o0 o00000o0 = (O00000o0) o000OOo0;
            String str2 = null;
            o00000o0.O00000Oo.setOnCheckedChangeListener(null);
            boolean z = false;
            try {
                str = jSONObject.getString(fvt.f17284O000000o);
                try {
                    str2 = jSONObject.getString(fvt.O00000Oo);
                    z = jSONObject.getBoolean(fvt.O00000o0);
                } catch (JSONException e) {
                    e = e;
                    gsy.O00000o0(LogType.PLUGIN, "RnDebugListAdapter", e.toString());
                    gsy.O00000o0(LogType.PLUGIN, "RnDebugListAdapter", "name: " + str + "   model: " + str2 + "   isCheck: " + z);
                    o00000o0.O00000o0.setText("package: ".concat(String.valueOf(str)));
                    o00000o0.O00000o.setText("model: ".concat(String.valueOf(str2)));
                    o00000o0.O00000Oo.setChecked(z);
                    o00000o0.O00000Oo.setEnabled(fvv.this.f17285O000000o);
                    o00000o0.f17288O000000o.setOnClickListener(new View.OnClickListener(i) {
                        /* class _m_j.fvv.O00000o0.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ int f17289O000000o;

                        {
                            this.f17289O000000o = r2;
                        }

                        public final void onClick(View view) {
                            if (fvv.this.O00000o0 != null) {
                                fvv.this.O00000o0.O000000o(this.f17289O000000o);
                            }
                        }
                    });
                    o00000o0.O00000Oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(i) {
                        /* class _m_j.fvv.O00000o0.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ int f17290O000000o;

                        {
                            this.f17290O000000o = r2;
                        }

                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            if (fvv.this.f17285O000000o && fvv.this.O00000o0 != null) {
                                fvv.this.O00000o0.O000000o(this.f17290O000000o, z);
                            }
                        }
                    });
                    o00000o0.O00000oO.setOnClickListener(new View.OnClickListener(i) {
                        /* class _m_j.fvv.O00000o0.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ int f17291O000000o;

                        {
                            this.f17291O000000o = r2;
                        }

                        public final void onClick(View view) {
                            if (fvv.this.f17285O000000o) {
                                if (fvv.this.O00000o0 != null) {
                                    fvv.this.O00000o0.O00000Oo(this.f17291O000000o);
                                }
                                fvv.this.O00000Oo.remove(this.f17291O000000o);
                                fvv.this.notifyDataSetChanged();
                            }
                        }
                    });
                }
            } catch (JSONException e2) {
                e = e2;
                str = null;
                gsy.O00000o0(LogType.PLUGIN, "RnDebugListAdapter", e.toString());
                gsy.O00000o0(LogType.PLUGIN, "RnDebugListAdapter", "name: " + str + "   model: " + str2 + "   isCheck: " + z);
                o00000o0.O00000o0.setText("package: ".concat(String.valueOf(str)));
                o00000o0.O00000o.setText("model: ".concat(String.valueOf(str2)));
                o00000o0.O00000Oo.setChecked(z);
                o00000o0.O00000Oo.setEnabled(fvv.this.f17285O000000o);
                o00000o0.f17288O000000o.setOnClickListener(new View.OnClickListener(i) {
                    /* class _m_j.fvv.O00000o0.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ int f17289O000000o;

                    {
                        this.f17289O000000o = r2;
                    }

                    public final void onClick(View view) {
                        if (fvv.this.O00000o0 != null) {
                            fvv.this.O00000o0.O000000o(this.f17289O000000o);
                        }
                    }
                });
                o00000o0.O00000Oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(i) {
                    /* class _m_j.fvv.O00000o0.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ int f17290O000000o;

                    {
                        this.f17290O000000o = r2;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (fvv.this.f17285O000000o && fvv.this.O00000o0 != null) {
                            fvv.this.O00000o0.O000000o(this.f17290O000000o, z);
                        }
                    }
                });
                o00000o0.O00000oO.setOnClickListener(new View.OnClickListener(i) {
                    /* class _m_j.fvv.O00000o0.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ int f17291O000000o;

                    {
                        this.f17291O000000o = r2;
                    }

                    public final void onClick(View view) {
                        if (fvv.this.f17285O000000o) {
                            if (fvv.this.O00000o0 != null) {
                                fvv.this.O00000o0.O00000Oo(this.f17291O000000o);
                            }
                            fvv.this.O00000Oo.remove(this.f17291O000000o);
                            fvv.this.notifyDataSetChanged();
                        }
                    }
                });
            }
            gsy.O00000o0(LogType.PLUGIN, "RnDebugListAdapter", "name: " + str + "   model: " + str2 + "   isCheck: " + z);
            o00000o0.O00000o0.setText("package: ".concat(String.valueOf(str)));
            o00000o0.O00000o.setText("model: ".concat(String.valueOf(str2)));
            o00000o0.O00000Oo.setChecked(z);
            o00000o0.O00000Oo.setEnabled(fvv.this.f17285O000000o);
            o00000o0.f17288O000000o.setOnClickListener(new View.OnClickListener(i) {
                /* class _m_j.fvv.O00000o0.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ int f17289O000000o;

                {
                    this.f17289O000000o = r2;
                }

                public final void onClick(View view) {
                    if (fvv.this.O00000o0 != null) {
                        fvv.this.O00000o0.O000000o(this.f17289O000000o);
                    }
                }
            });
            o00000o0.O00000Oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(i) {
                /* class _m_j.fvv.O00000o0.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ int f17290O000000o;

                {
                    this.f17290O000000o = r2;
                }

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (fvv.this.f17285O000000o && fvv.this.O00000o0 != null) {
                        fvv.this.O00000o0.O000000o(this.f17290O000000o, z);
                    }
                }
            });
            o00000o0.O00000oO.setOnClickListener(new View.OnClickListener(i) {
                /* class _m_j.fvv.O00000o0.AnonymousClass3 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ int f17291O000000o;

                {
                    this.f17291O000000o = r2;
                }

                public final void onClick(View view) {
                    if (fvv.this.f17285O000000o) {
                        if (fvv.this.O00000o0 != null) {
                            fvv.this.O00000o0.O00000Oo(this.f17291O000000o);
                        }
                        fvv.this.O00000Oo.remove(this.f17291O000000o);
                        fvv.this.notifyDataSetChanged();
                    }
                }
            });
        } else if (o000OOo0 instanceof O00000Oo) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            o00000Oo.f17286O000000o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.fvv.O00000Oo.AnonymousClass1 */

                public final void onClick(View view) {
                    if (fvv.this.f17285O000000o && fvv.this.O00000o0 != null) {
                        fvv.this.O00000o0.O000000o();
                    }
                }
            });
        }
    }

    public final void O000000o(List<JSONObject> list) {
        O000000o(list, this.O00000Oo);
    }

    public final int getItemCount() {
        List<JSONObject> list = this.O00000Oo;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.O00000Oo.size() + 1;
    }

    public final int getItemViewType(int i) {
        List<JSONObject> list = this.O00000Oo;
        return (list == null || list.size() <= 0 || i != this.O00000Oo.size()) ? 0 : 1;
    }

    public class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f17288O000000o;
        CheckBox O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        TextView O00000oO;

        public O00000o0(View view) {
            super(view);
            this.f17288O000000o = view.findViewById(R.id.layout_item_rn_debug_left);
            this.O00000Oo = (CheckBox) view.findViewById(R.id.cb_debug_plugin_check);
            this.O00000o0 = (TextView) view.findViewById(R.id.tv_debug_package_name);
            this.O00000o = (TextView) view.findViewById(R.id.tv_debug_device_model);
            this.O00000oO = (TextView) view.findViewById(R.id.tv_debug_plugin_delete);
        }
    }

    public class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f17286O000000o;

        public O00000Oo(View view) {
            super(view);
            this.f17286O000000o = (TextView) view.findViewById(R.id.tv_rn_debug_auto_debug);
            this.f17286O000000o.getPaint().setFlags(8);
        }
    }

    private static void O000000o(List list, List list2) {
        list2.clear();
        if (list != null && list.size() != 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list2.add(list.get(i));
            }
        }
    }
}
