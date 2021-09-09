package _m_j;

import a.a.a.b;
import a.a.a.e.c.c;
import a.a.a.e.c.g;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;

public final class O0O000o extends ooooooo implements CircleRoadProgress.O00000Oo {
    public boolean O00000Oo;
    public c O00000o;
    public boolean O00000o0;
    public b O00000oO;
    public Button O00000oo;

    public static O0O000o O000000o(c cVar) {
        O0O000o o0O000o = new O0O000o();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_bluetooth_diagnose", cVar);
        o0O000o.setArguments(bundle);
        return o0O000o;
    }

    public final g O00000o() {
        return this.O00000o;
    }

    public final void O00000oO() {
        if (this.O00000oO == null) {
            this.O00000oO = new b("btd", 4005, false);
        }
        O000000o(this.O00000oO);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.O00000o0 = z;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000o = (c) getArguments().getParcelable("arg_bluetooth_diagnose");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_bluetooth_diagnose, viewGroup, false);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putBoolean("enable_request", this.O00000o0);
        }
    }

    public final void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.O00000o0 = bundle.getBoolean("enable_request");
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.diagnoseTitle);
        if (textView != null) {
            textView.setText(this.O00000o.O0000Oo);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.diagnoseMessage);
        if (textView2 != null) {
            textView2.setText(this.O00000o.O0000OoO);
        }
        this.O00000oo = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O00000oo;
        if (button != null) {
            button.setVisibility(this.O00000o.O00000Oo() ? 0 : 8);
            this.O00000oo.setText(this.O00000o.O0000o0);
            this.O00000oo.setOnClickListener(this);
        }
    }

    public final void onResume() {
        super.onResume();
        if (!O000000o("android.permission.BLUETOOTH")) {
            if (this.O00000Oo) {
                this.O00000oO = new b("btd", 4002, false);
                ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), this);
                return;
            }
            requestPermissions(new String[]{"android.permission.BLUETOOTH_ADMIN", "android.permission.BLUETOOTH"}, 0);
            this.O00000Oo = true;
        } else if (getActivity() == null || ooooooo.O000000o(getActivity(), 39) || this.O00000Oo) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                this.O00000oO = new b("btd", 4003, false);
                ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), this);
                return;
            }
            ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this);
            if (defaultAdapter.isEnabled()) {
                this.O00000oO = new b("btd", 1, true);
            } else if (O000000o("android.permission.BLUETOOTH_ADMIN")) {
                boolean enable = defaultAdapter.enable();
                this.O00000oO = new b("btd", Integer.valueOf(enable ? 1 : 0), enable);
                defaultAdapter.disable();
            } else {
                c cVar = this.O00000o;
                if (cVar != null) {
                    if ((cVar.f2611O000000o == 1) && !this.O00000o0) {
                        if (isAdded()) {
                            Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
                            intent.addFlags(67108864);
                            startActivityForResult(intent, 1);
                        }
                    }
                }
                this.O00000oO = new b("btd", 0, false);
                ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
            }
            if (this.O00000oO != null) {
                ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.valueOf(!this.O00000oO.O00000o0));
            }
        } else {
            O000000o();
            this.O00000Oo = true;
        }
    }

    public final void onPause() {
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.nextButton) {
            Button button = this.O00000oo;
            if (button != null) {
                button.setEnabled(false);
            }
            this.O00000oO = new b("btd", 4001, false, true);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        }
    }
}
