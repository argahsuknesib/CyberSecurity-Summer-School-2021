package _m_j;

import _m_j.gxg;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.miband.MiBandStepDetailActivity;
import com.xiaomi.smarthome.miio.miband.widget.SimpleCircleProgressView;
import java.util.Date;

public final class gxl extends fvm implements gxg.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f18469O000000o;
    private TextView O00000Oo;
    private View O00000o;
    private SimpleCircleProgressView O00000o0;
    private int O00000oO = 0;
    private int O00000oo = 0;
    private int O0000O0o = 0;
    private int O0000OOo = 0;

    public final void onSleepDataChanged() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.miband_step_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f18469O000000o = (TextView) view.findViewById(R.id.sport_step);
        this.O00000Oo = (TextView) view.findViewById(R.id.sport_info);
        this.O00000o = view.findViewById(R.id.container);
        this.O00000o0 = (SimpleCircleProgressView) view.findViewById(R.id.scp_progress_view);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.gxl.AnonymousClass1 */

            public final void onClick(View view) {
                if (gxm.O00000o0().O00000Oo) {
                    gxl.this.startActivity(new Intent(gxl.this.getActivity(), MiBandStepDetailActivity.class));
                }
            }
        });
        O000000o();
    }

    private void O000000o() {
        this.f18469O000000o.setText(String.valueOf(this.O00000oO));
        TextView textView = this.O00000Oo;
        String string = getString(R.string.today_kilometers);
        double d = (double) this.O00000oo;
        Double.isNaN(d);
        textView.setText(String.format(string, Double.valueOf(d / 1000.0d), Integer.valueOf(this.O0000O0o)));
        SimpleCircleProgressView simpleCircleProgressView = this.O00000o0;
        int i = this.O0000OOo;
        simpleCircleProgressView.setProgress(i == 0 ? 0.0f : (((float) this.O00000oO) * 1.0f) / ((float) i));
    }

    public final void onResume() {
        super.onResume();
        gxg.O000000o().O000000o(this);
        O00000Oo();
    }

    public final void onPause() {
        super.onPause();
        gxg.O000000o().O00000Oo(this);
    }

    private void O00000Oo() {
        gxi O00000Oo2 = gxg.O000000o().O00000Oo(new Date());
        this.O0000OOo = gxg.O000000o().O00000o();
        if (O00000Oo2 != null) {
            this.O00000oO = O00000Oo2.O0000O0o;
            this.O00000oo = O00000Oo2.O00000Oo;
            this.O0000O0o = O00000Oo2.O00000oo;
            O000000o();
        }
    }

    public final void onStepDataChanged() {
        O00000Oo();
    }

    public final void onUserDataChanged() {
        this.O0000OOo = gxg.O000000o().O0000O0o.O00000oO;
        O000000o();
    }
}
