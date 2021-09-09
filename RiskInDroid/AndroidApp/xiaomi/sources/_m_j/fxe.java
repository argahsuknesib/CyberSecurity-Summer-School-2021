package _m_j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import java.util.List;

public final class fxe extends RecyclerView.O000000o<O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<fxf> f17364O000000o;
    public O000000o O00000Oo;
    private Context O00000o0;

    public interface O000000o {
        void O000000o(fxf fxf);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O00000Oo o00000Oo = (O00000Oo) o000OOo0;
        fxf fxf = this.f17364O000000o.get(i);
        o00000Oo.O00000o0.setText(fxf.O00000o0);
        o00000Oo.O00000o.setText(fxf.O00000o);
        o00000Oo.O00000oO.setText(fxf.O00000oO);
        DeviceFactory.O00000Oo(fxf.f17367O000000o, o00000Oo.O00000Oo);
        o00000Oo.f17365O000000o.setOnClickListener(new View.OnClickListener(fxf) {
            /* class _m_j.fxe.O00000Oo.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ fxf f17366O000000o;

            {
                this.f17366O000000o = r2;
            }

            public final void onClick(View view) {
                if (fxe.this.O00000Oo != null) {
                    fxe.this.O00000Oo.O000000o(this.f17366O000000o);
                }
            }
        });
    }

    public fxe(Context context, List<fxf> list) {
        this.O00000o0 = context;
        this.f17364O000000o = list;
    }

    public final int getItemCount() {
        List<fxf> list = this.f17364O000000o;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f17365O000000o;
        SimpleDraweeView O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        TextView O00000oO;

        public O00000Oo(View view) {
            super(view);
            this.f17365O000000o = view.findViewById(R.id.item_layout);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.item_view_device_icon);
            this.O00000o0 = (TextView) view.findViewById(R.id.item_tv_device_name);
            this.O00000o = (TextView) view.findViewById(R.id.item_tv_home);
            this.O00000oO = (TextView) view.findViewById(R.id.item_tv_room);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O00000Oo(LayoutInflater.from(this.O00000o0).inflate((int) R.layout.item_rv_wearables_scan_device, viewGroup, false));
    }
}
