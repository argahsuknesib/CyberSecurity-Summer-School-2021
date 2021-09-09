package _m_j;

import _m_j.fwm;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import java.util.List;

public final class fwm extends RecyclerView.O000000o<O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f17316O000000o;
    public List<fwl> O00000Oo;
    public O000000o O00000o0;

    public interface O000000o {
        void onPerformCheckedChangeListener(CompoundButton compoundButton, fwl fwl, boolean z);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O00000Oo o00000Oo = (O00000Oo) o000OOo0;
        fwl fwl = this.O00000Oo.get(i);
        DeviceFactory.O000000o(fwl.O0000O0o, o00000Oo.f17317O000000o, 0);
        o00000Oo.O00000Oo.setText(fwl.O00000o0);
        o00000Oo.O00000o0.setText(fwl.O00000o);
        o00000Oo.O00000o.setChecked(fwl.O0000OOo);
        o00000Oo.O00000o.setEnabled(true);
        o00000Oo.O00000o.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(o00000Oo, fwl) {
            /* class _m_j.$$Lambda$fwm$mmwm_RdefCH8QDi3f050R5Qo22s */
            private final /* synthetic */ fwm.O00000Oo f$1;
            private final /* synthetic */ fwl f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                fwm.this.O000000o(this.f$1, this.f$2, compoundButton, z);
            }
        });
    }

    public fwm(Context context, List<fwl> list) {
        this.f17316O000000o = context;
        this.O00000Oo = list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(O00000Oo o00000Oo, fwl fwl, CompoundButton compoundButton, boolean z) {
        O000000o o000000o = this.O00000o0;
        if (o000000o != null) {
            o000000o.onPerformCheckedChangeListener(o00000Oo.O00000o, fwl, z);
        }
    }

    public final int getItemCount() {
        return this.O00000Oo.size();
    }

    static class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f17317O000000o;
        TextView O00000Oo;
        SwitchButton O00000o;
        TextView O00000o0;

        public O00000Oo(View view) {
            super(view);
            this.f17317O000000o = (SimpleDraweeView) view.findViewById(R.id.device_icon);
            this.O00000Oo = (TextView) view.findViewById(R.id.device_name);
            this.O00000o0 = (TextView) view.findViewById(R.id.device_room_name);
            this.O00000o = (SwitchButton) view.findViewById(R.id.apply_button);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O00000Oo(LayoutInflater.from(this.f17316O000000o).inflate((int) R.layout.item_device_apply_pincode, viewGroup, false));
    }
}
