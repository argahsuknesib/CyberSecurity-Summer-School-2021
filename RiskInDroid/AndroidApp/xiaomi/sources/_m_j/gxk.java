package _m_j;

import _m_j.gxg;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.miband.MiBandSleepDetailActivity;
import java.util.Date;

public final class gxk extends fvm implements gxg.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f18467O000000o;
    private TextView O00000Oo;
    private int O00000o = 0;
    private View O00000o0;
    private int O00000oO = 0;

    public final void onStepDataChanged() {
    }

    public final void onUserDataChanged() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.miband_sleep_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f18467O000000o = (TextView) view.findViewById(R.id.tv_all_sleep);
        this.O00000Oo = (TextView) view.findViewById(R.id.tv_deep_sleep);
        this.O00000o0 = view.findViewById(R.id.sleep_container);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.gxk.AnonymousClass1 */

            public final void onClick(View view) {
                if (gxm.O00000o0().O00000Oo) {
                    gxk.this.startActivity(new Intent(gxk.this.getActivity(), MiBandSleepDetailActivity.class));
                }
            }
        });
        O000000o();
    }

    private void O000000o() {
        TextView textView = this.f18467O000000o;
        Resources resources = getResources();
        int i = this.O00000o;
        Object[] objArr = {Integer.valueOf(i / 60)};
        Resources resources2 = getResources();
        int i2 = this.O00000o;
        textView.setText(getString(R.string.all_sleep_time, resources.getQuantityString(R.plurals.miband_hour, i / 60, objArr), resources2.getQuantityString(R.plurals.miband_minute, i2 % 60, Integer.valueOf(i2 % 60))));
        TextView textView2 = this.O00000Oo;
        Resources resources3 = getResources();
        int i3 = this.O00000oO;
        int i4 = i3 / 60;
        Object[] objArr2 = {Integer.valueOf(i3 / 60)};
        Resources resources4 = getResources();
        int i5 = this.O00000oO;
        textView2.setText(getString(R.string.deep_sleep_time, resources3.getQuantityString(R.plurals.miband_hour, i4, objArr2), resources4.getQuantityString(R.plurals.miband_minute, i5 % 60, Integer.valueOf(i5 % 60))));
    }

    public final void onResume() {
        super.onResume();
        gxg.O000000o().O000000o(this);
        O000000o();
    }

    public final void onPause() {
        super.onPause();
        gxg.O000000o().O00000Oo(this);
    }

    public final void onSleepDataChanged() {
        gxh O000000o2 = gxg.O000000o().O000000o(new Date());
        if (O000000o2 != null) {
            this.O00000oO = O000000o2.O00000Oo;
            this.O00000o = O000000o2.f18464O000000o + this.O00000oO;
            O000000o();
        }
    }
}
