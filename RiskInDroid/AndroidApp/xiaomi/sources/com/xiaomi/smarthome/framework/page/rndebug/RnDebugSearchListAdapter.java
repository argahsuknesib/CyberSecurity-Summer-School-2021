package com.xiaomi.smarthome.framework.page.rndebug;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceStat;
import java.util.ArrayList;
import java.util.List;

public final class RnDebugSearchListAdapter extends RecyclerView.O000000o<O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    List<DeviceStat> f7928O000000o = new ArrayList();
    public O000000o O00000Oo;
    private Context O00000o0;

    public interface O000000o {
        void O000000o(DeviceStat deviceStat);
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O00000Oo o00000Oo = (O00000Oo) o000OOo0;
        DeviceStat deviceStat = this.f7928O000000o.get(i);
        o00000Oo.O00000Oo.setText("package: *");
        TextView textView = o00000Oo.O00000o0;
        textView.setText("model: " + deviceStat.model);
        o00000Oo.f7929O000000o.setOnClickListener(new View.OnClickListener(deviceStat) {
            /* class com.xiaomi.smarthome.framework.page.rndebug.RnDebugSearchListAdapter.O00000Oo.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ DeviceStat f7930O000000o;

            {
                this.f7930O000000o = r2;
            }

            public final void onClick(View view) {
                if (RnDebugSearchListAdapter.this.O00000Oo != null) {
                    RnDebugSearchListAdapter.this.O00000Oo.O000000o(this.f7930O000000o);
                }
            }
        });
    }

    public RnDebugSearchListAdapter(Context context) {
        this.O00000o0 = context;
        O000000o(null, this.f7928O000000o);
    }

    public final int getItemCount() {
        List<DeviceStat> list = this.f7928O000000o;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f7929O000000o;
        TextView O00000Oo;
        TextView O00000o0;

        public O00000Oo(View view) {
            super(view);
            this.f7929O000000o = view.findViewById(R.id.layout_item_rn_debug);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv_debug_package_name);
            this.O00000o0 = (TextView) view.findViewById(R.id.tv_debug_device_model);
        }
    }

    static void O000000o(List list, List list2) {
        list2.clear();
        if (list != null && list.size() != 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list2.add(list.get(i));
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O00000Oo(LayoutInflater.from(this.O00000o0).inflate((int) R.layout.item_rn_debug_search_list, viewGroup, false));
    }
}
