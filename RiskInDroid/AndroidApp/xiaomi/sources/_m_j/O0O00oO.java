package _m_j;

import a.a.a.b;
import a.a.a.e.c.g;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;
import java.util.ArrayList;

public final class O0O00oO extends ooooooo implements CircleRoadProgress.O00000Oo {
    public final ArrayList<b> O00000Oo = new ArrayList<>();
    public b O00000o;
    public a.a.a.e.c.b O00000o0;
    public Button O00000oO;

    public static O0O00oO O000000o(a.a.a.e.c.b bVar) {
        O0O00oO o0O00oO = new O0O00oO();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_battery_diagnose_context", bVar);
        o0O00oO.setArguments(bundle);
        return o0O00oO;
    }

    public final g O00000o() {
        return this.O00000o0;
    }

    public final void O00000oO() {
        b bVar = this.O00000o;
        if (bVar != null) {
            O000000o(bVar);
        } else {
            O000000o(this.O00000Oo);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000o0 = (a.a.a.e.c.b) getArguments().getParcelable("arg_battery_diagnose_context");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_battery_diagnose, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.diagnoseTitle);
        if (textView != null) {
            textView.setText(this.O00000o0.O0000Oo);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.diagnoseMessage);
        if (textView2 != null) {
            textView2.setText(this.O00000o0.O0000OoO);
        }
        this.O00000oO = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O00000oO;
        if (button != null) {
            button.setVisibility(this.O00000o0.O00000Oo() ? 0 : 8);
            this.O00000oO.setText(this.O00000o0.O0000o0);
            this.O00000oO.setOnClickListener(this);
        }
    }

    public final void onResume() {
        super.onResume();
        ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (getActivity() != null) {
            Intent registerReceiver = getActivity().registerReceiver(null, intentFilter);
            boolean z = false;
            if (registerReceiver == null) {
                this.O00000Oo.add(new b("btl", 0, false));
                ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
            } else if (registerReceiver.getBooleanExtra("present", false)) {
                int intExtra = registerReceiver.getIntExtra("health", -1);
                int intExtra2 = registerReceiver.getIntExtra("level", -1);
                int intExtra3 = registerReceiver.getIntExtra("plugged", -1);
                int intExtra4 = registerReceiver.getIntExtra("scale", -1);
                int intExtra5 = registerReceiver.getIntExtra("temperature", -1);
                int intExtra6 = registerReceiver.getIntExtra("voltage", -1);
                String stringExtra = registerReceiver.getStringExtra("technology");
                this.O00000Oo.add(new b("bh", Integer.valueOf(intExtra), intExtra != -1));
                this.O00000Oo.add(new b("bl", Integer.valueOf(intExtra2), intExtra2 != -1));
                this.O00000Oo.add(new b("bp", Integer.valueOf(intExtra3), intExtra3 != -1));
                this.O00000Oo.add(new b("bs", Integer.valueOf(intExtra4), intExtra4 != -1));
                this.O00000Oo.add(new b("bt", Integer.valueOf(intExtra5), intExtra5 != -1));
                ArrayList<b> arrayList = this.O00000Oo;
                Integer valueOf = Integer.valueOf(intExtra6);
                if (intExtra6 != -1) {
                    z = true;
                }
                arrayList.add(new b("bv", valueOf, z));
                this.O00000Oo.add(new b("btl", stringExtra, true));
                ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.FALSE);
            }
        }
    }

    public final void onPause() {
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.nextButton) {
            Button button = this.O00000oO;
            if (button != null) {
                button.setEnabled(false);
            }
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
            this.O00000o = new b("btl", 4001, false, true);
        }
    }
}
