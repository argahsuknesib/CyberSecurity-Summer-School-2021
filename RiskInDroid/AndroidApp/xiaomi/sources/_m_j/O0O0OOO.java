package _m_j;

import a.a.a.b;
import a.a.a.e.c.g;
import a.a.a.e.c.m;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.diagnose.manual.TouchCalibrationActivity;
import in.cashify.otex.widget.CircleRoadProgress;

public final class O0O0OOO extends ooooooo implements View.OnClickListener, CircleRoadProgress.O00000Oo {
    public m O00000Oo;
    public b O00000o;
    public long O00000o0;
    public boolean O00000oO;
    public TextView O00000oo;
    public Button O0000O0o;

    public static O0O0OOO O000000o(m mVar) {
        O0O0OOO o0o0ooo = new O0O0OOO();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_touch_diagnose", mVar);
        o0o0ooo.setArguments(bundle);
        return o0o0ooo;
    }

    private void O000000o(boolean z) {
        TextView textView = this.O00000oo;
        if (textView != null) {
            textView.setEnabled(z);
        }
    }

    public final g O00000o() {
        return this.O00000Oo;
    }

    public final void O00000oO() {
        if (this.O00000o == null) {
            this.O00000o = new b("sdr", 4005, false);
        }
        O000000o(this.O00000o);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8 && i2 == -1 && intent != null) {
            boolean z = false;
            int intExtra = intent.getIntExtra("result", 0);
            if (intExtra == 100) {
                z = true;
            }
            this.O00000oO = z;
            this.O00000o = new b("sdr", Integer.valueOf(intExtra), this.O00000oO);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000Oo = (m) getArguments().getParcelable("arg_touch_diagnose");
        }
        this.O00000o0 = O00000Oo();
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
        view.findViewById(R.id.nextButton).setOnClickListener(this);
        this.O00000oo = (TextView) view.findViewById(R.id.diagnoseActionButton);
        TextView textView = this.O00000oo;
        int i = 0;
        if (textView != null) {
            textView.setOnClickListener(this);
            this.O00000oo.setVisibility(0);
            this.O00000oo.setText((int) R.string.otex_start);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.diagnoseTitle);
        if (this.O00000oo != null) {
            textView2.setText(this.O00000Oo.O0000Oo);
        }
        TextView textView3 = (TextView) view.findViewById(R.id.diagnoseMessage);
        if (textView3 != null) {
            textView3.setText(this.O00000Oo.O0000OoO);
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
        ((ExchangeManager) getParentFragment()).O000000o(this.O00000o0, this);
        if (this.O00000o != null) {
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.valueOf(true ^ this.O00000oO));
        }
    }

    public final void onPause() {
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.diagnoseActionButton) {
            ((ExchangeManager) getParentFragment()).O000000o();
            Intent intent = new Intent(getActivity(), TouchCalibrationActivity.class);
            intent.putExtra("arg_context", this.O00000Oo);
            startActivityForResult(intent, 8);
        } else if (id == R.id.nextButton) {
            O000000o(false);
            Button button = this.O0000O0o;
            if (button != null) {
                button.setEnabled(false);
            }
            this.O00000o = new b("sdr", 4001, false, true);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        }
    }
}
