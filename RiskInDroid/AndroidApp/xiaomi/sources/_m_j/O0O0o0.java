package _m_j;

import a.a.a.b;
import a.a.a.e.c.g;
import a.a.a.e.c.k;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;

public final class O0O0o0 extends ooooooo implements SensorEventListener, CircleRoadProgress.O00000Oo {
    public k O00000Oo;
    public Sensor O00000o;
    public SensorManager O00000o0;
    public boolean O00000oO;
    public b O00000oo;
    public Button O0000O0o;
    public TextView O0000OOo;
    public boolean O0000Oo0;

    public static O0O0o0 O000000o(k kVar) {
        O0O0o0 o0O0o0 = new O0O0o0();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_proximity_diagnose", kVar);
        o0O0o0.setArguments(bundle);
        return o0O0o0;
    }

    private void O000000o(boolean z) {
        TextView textView = this.O0000OOo;
        if (textView != null) {
            textView.setEnabled(z);
        }
        Button button = this.O0000O0o;
        if (button != null) {
            button.setEnabled(z);
        }
    }

    private void O00000oo() {
        try {
            if (this.O00000o0 != null) {
                this.O00000o0.unregisterListener(this);
            }
        } catch (Throwable unused) {
        }
    }

    public final g O00000o() {
        return this.O00000Oo;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000Oo = (k) getArguments().getParcelable("arg_proximity_diagnose");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_diagnose_base, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000OOo = (TextView) view.findViewById(R.id.diagnoseActionButton);
        int i = 0;
        this.O0000OOo.setVisibility(0);
        this.O0000OOo.setOnClickListener(this);
        this.O0000OOo.setText((int) R.string.otex_start);
        TextView textView = (TextView) view.findViewById(R.id.diagnoseTitle);
        if (textView != null) {
            textView.setText(this.O00000Oo.O0000Oo);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.diagnoseMessage);
        if (textView2 != null) {
            textView2.setText(this.O00000Oo.O0000OoO);
        }
        this.O0000O0o = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O0000O0o;
        if (button != null) {
            if (!this.O00000Oo.O00000Oo()) {
                i = 8;
            }
            button.setVisibility(i);
            this.O0000O0o.setText(this.O00000Oo.O0000o0);
            this.O0000O0o.setOnClickListener(this);
        }
    }

    public final void onResume() {
        super.onResume();
        O000000o(true);
        ((ExchangeManager) getParentFragment()).O000000o(0, this, this.O00000Oo.O0000o);
    }

    public final void onPause() {
        ((ExchangeManager) getParentFragment()).O000000o();
        O00000oo();
        super.onPause();
    }

    public final void onClick(View view) {
        Sensor sensor;
        if (view.getId() == R.id.nextButton) {
            O000000o(false);
            this.O00000oo = new b("ps", 0, false, true);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        } else if (view.getId() == R.id.diagnoseActionButton) {
            SensorManager sensorManager = this.O00000o0;
            if (!(sensorManager == null || (sensor = this.O00000o) == null)) {
                sensorManager.registerListener(this, sensor, 2);
            }
            ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this);
        }
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.O00000o0 = (SensorManager) getActivity().getSystemService("sensor");
            if (this.O00000o0 != null) {
                this.O00000o = this.O00000o0.getDefaultSensor(8);
            }
        } catch (Exception unused) {
            O000000o(new b("ps", 0, false));
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null && sensorEvent.values != null && sensorEvent.sensor.getType() == 8) {
            float[] fArr = sensorEvent.values;
            int length = fArr.length;
            int i = 0;
            while (i < length) {
                float f = fArr[i];
                Sensor sensor = this.O00000o;
                if (sensor == null || f != sensor.getMaximumRange()) {
                    i++;
                } else {
                    this.O00000oO = true;
                    return;
                }
            }
            if (this.O00000oO) {
                this.O00000oo = new b("ps", 1, true);
                ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.FALSE);
            }
            this.O00000oO = false;
        }
    }

    public final void O00000oO() {
        if (this.O00000oo != null || this.O0000Oo0) {
            O000000o(this.O00000oo);
            return;
        }
        this.O0000Oo0 = true;
        this.O00000oo = new b("ps", 4005, false);
        ((ExchangeManager) getParentFragment()).O000000o(-1, this);
        ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.valueOf(true ^ this.O00000oo.O00000o0));
    }
}
