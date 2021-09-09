package in.cashify.otex.diagnose.semi;

import _m_j.ooooooo;
import a.a.a.b;
import a.a.a.e.c.e;
import a.a.a.e.c.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;

public final class ChargerDiagnoseFragment extends ooooooo implements CircleRoadProgress.O00000Oo {
    public ChargingMonitor O00000Oo;
    public TextView O00000o;
    public e O00000o0;
    public b O00000oO;
    public Button O00000oo;
    public boolean O0000O0o;

    public static ChargerDiagnoseFragment O000000o(e eVar) {
        ChargerDiagnoseFragment chargerDiagnoseFragment = new ChargerDiagnoseFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_charger_diagnose", eVar);
        chargerDiagnoseFragment.setArguments(bundle);
        return chargerDiagnoseFragment;
    }

    public final g O00000o() {
        return this.O00000o0;
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        this.O00000Oo = new ChargingMonitor();
        FragmentActivity activity = getActivity();
        if (isAdded() && activity != null) {
            this.O00000Oo.O000000o(activity.getApplicationContext());
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000o0 = (e) getArguments().getParcelable("arg_charger_diagnose");
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

    public class ChargingMonitor extends BroadcastReceiver {
        public ChargingMonitor() {
        }

        public final void O000000o(Context context) {
            context.registerReceiver(this, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }

        public final void O00000Oo(Context context) {
            try {
                context.unregisterReceiver(this);
            } catch (Throwable unused) {
            }
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("plugged", -1);
                boolean z = intExtra == 2;
                boolean z2 = intExtra == 1;
                if (z || z2) {
                    O00000Oo(context);
                    if (ChargerDiagnoseFragment.this.O00000o != null) {
                        ChargerDiagnoseFragment.this.O00000o.setText(ChargerDiagnoseFragment.this.O00000o0.O0000Ooo);
                    }
                    b unused = ChargerDiagnoseFragment.this.O00000oO = new b("bp", 1, true, false);
                    ((ExchangeManager) ChargerDiagnoseFragment.this.getParentFragment()).O000000o(ChargerDiagnoseFragment.this.O00000o0(), Boolean.FALSE);
                }
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.diagnoseTitle);
        if (textView != null) {
            textView.setText(this.O00000o0.O0000Oo);
        }
        this.O00000o = (TextView) view.findViewById(R.id.diagnoseMessage);
        TextView textView2 = this.O00000o;
        if (textView2 != null) {
            textView2.setText(this.O00000o0.O0000OoO);
        }
        this.O00000oo = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O00000oo;
        if (button != null) {
            button.setVisibility(this.O00000o0.O00000Oo() ? 0 : 8);
            this.O00000oo.setText(this.O00000o0.O0000o0);
            this.O00000oo.setOnClickListener(this);
        }
    }

    public final void onResume() {
        super.onResume();
        Button button = this.O00000oo;
        if (button != null) {
            button.setEnabled(true);
        }
        if (this.O00000Oo != null) {
            FragmentActivity activity = getActivity();
            if (isAdded() && activity != null) {
                this.O00000Oo.O000000o(activity.getApplicationContext());
            }
        }
        ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this, this.O00000o0.O0000o);
    }

    public final void onPause() {
        if (this.O00000Oo != null) {
            FragmentActivity activity = getActivity();
            if (isAdded() && activity != null) {
                try {
                    activity.getApplicationContext().unregisterReceiver(this.O00000Oo);
                } catch (Throwable unused) {
                }
            }
        }
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
    }

    public final void onDetach() {
        if (this.O00000Oo != null) {
            FragmentActivity activity = getActivity();
            if (isAdded() && activity != null) {
                try {
                    getActivity().getApplicationContext().unregisterReceiver(this.O00000Oo);
                } catch (Throwable unused) {
                }
            }
        }
        super.onDetach();
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.nextButton) {
            Button button = this.O00000oo;
            if (button != null) {
                button.setEnabled(false);
            }
            this.O00000oO = new b("bp", 4001, false, true);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        }
    }

    public final void O00000oO() {
        if (this.O00000oO != null || this.O0000O0o) {
            O000000o(this.O00000oO);
            return;
        }
        this.O0000O0o = true;
        this.O00000oO = new b("btl", 4005, false);
        ((ExchangeManager) getParentFragment()).O000000o(-1, this);
        ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.valueOf(true ^ this.O00000oO.O00000o0));
    }
}
