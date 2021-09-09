package in.cashify.otex.diagnose.manual;

import _m_j.O0O0OO;
import _m_j.O0OOO0O;
import _m_j.ei;
import a.a.a.e.c.m;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.smarthome.R;
import in.cashify.otex.widget.CalibrationView;
import java.util.Iterator;

public class TouchCalibrationActivity extends AppCompatActivity implements O0O0OO.O00000o, CalibrationView.O00000Oo, CalibrationView.O0000O0o {

    /* renamed from: a  reason: collision with root package name */
    public boolean f12267a;
    public m b;
    public final O0O0OO c = new O0O0OO(this);
    public CalibrationView d;
    public TextView e;

    public class O000000o extends O0OOO0O.O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ O0OOO0O f12268O000000o;

        public O000000o(O0OOO0O o0ooo0o) {
            this.f12268O000000o = o0ooo0o;
        }

        public final boolean O000000o() {
            TouchCalibrationActivity.this.e();
            TouchCalibrationActivity.this.c.O000000o();
            boolean unused = TouchCalibrationActivity.this.f12267a = false;
            return true;
        }

        public final void O00000Oo() {
            this.f12268O000000o.dismissAllowingStateLoss();
            Intent intent = new Intent();
            intent.putExtra("result", TouchCalibrationActivity.this.d());
            TouchCalibrationActivity.this.setResult(-1, intent);
            TouchCalibrationActivity.this.finish();
            boolean unused = TouchCalibrationActivity.this.f12267a = false;
        }
    }

    public void a(boolean z) {
        if (z) {
            this.c.O000000o();
        } else {
            this.c.O00000Oo();
        }
    }

    public void b() {
        TextView textView = this.e;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void c() {
        Intent intent = new Intent();
        intent.putExtra("result", 100);
        setResult(-1, intent);
        finish();
    }

    public int d() {
        CalibrationView calibrationView = this.d;
        if (calibrationView != null) {
            return calibrationView.getCompletionPercent();
        }
        return 0;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_touch_calibration);
        this.b = (m) getIntent().getParcelableExtra("arg_context");
        this.c.f6664O000000o = this.b.f2618O000000o;
        O0O0OO o0o0oo = this.c;
        o0o0oo.O00000oo = (TextView) findViewById(R.id.touchTimer);
        o0o0oo.O00000oO = this;
        this.d = (CalibrationView) findViewById(R.id.touchCalibrationView);
        CalibrationView calibrationView = this.d;
        if (calibrationView != null) {
            calibrationView.setOnCalibrationDoneListener(this);
            this.e = (TextView) findViewById(R.id.test_touch_sub_title);
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.f12267a) {
            O0O0OO o0o0oo = this.c;
            if (o0o0oo.O00000o) {
                o0o0oo.O00000o0();
                o0o0oo.O00000o = false;
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (!this.f12267a) {
            O0O0OO o0o0oo = this.c;
            o0o0oo.O00000o = true;
            o0o0oo.O00000o();
        }
    }

    public void a() {
        if (!this.f12267a) {
            this.f12267a = true;
            this.c.O00000Oo();
            if (this.b != null) {
                O0OOO0O O000000o2 = O0OOO0O.O000000o(getResources().getString(R.string.otex_touch_alert_title), this.b.O0000Ooo, this.b.O0000o00, this.b.O0000o0);
                O000000o2.f6672O000000o = new O000000o(O000000o2);
                ei O000000o3 = getSupportFragmentManager().O000000o();
                O000000o3.O000000o(O000000o2, O000000o2.getClass().getSimpleName());
                O000000o3.O00000o0();
            }
        }
    }

    public void e() {
        CalibrationView calibrationView = this.d;
        if (calibrationView != null) {
            calibrationView.O00000oo.clear();
            Iterator<CalibrationView.O00000o0> it = calibrationView.O00000oO.iterator();
            while (it.hasNext()) {
                it.next().O00000oo = false;
            }
            calibrationView.invalidate();
        }
    }
}
