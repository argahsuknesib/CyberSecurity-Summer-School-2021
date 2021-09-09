package _m_j;

import a.a.a.b;
import a.a.a.e.c.g;
import a.a.a.e.c.p;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
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

public final class O0O0O extends ooooooo implements CircleRoadProgress.O00000Oo {
    public p O00000Oo;
    public boolean O00000o;
    public boolean O00000o0;
    public final ArrayList<b> O00000oO = new ArrayList<>();
    public Button O00000oo;

    public static O0O0O O000000o(p pVar) {
        O0O0O o0o0o = new O0O0O();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_wifi_diagnose", pVar);
        o0o0o.setArguments(bundle);
        return o0o0o;
    }

    private void O00000Oo(WifiManager wifiManager) {
        b bVar;
        ArrayList<b> arrayList;
        if (wifiManager != null) {
            try {
                int rssi = wifiManager.getConnectionInfo().getRssi();
                this.O00000oO.add(new b("wss", Integer.valueOf(rssi), rssi != -127));
            } catch (Exception unused) {
                this.O00000oO.add(new b("wss", -127, true));
            }
            try {
                this.O00000oO.add(new b("wls", Integer.valueOf(wifiManager.getConnectionInfo().getLinkSpeed()), true));
            } catch (Exception unused2) {
                this.O00000oO.add(new b("wls", -1, true));
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    int frequency = wifiManager.getConnectionInfo().getFrequency();
                    arrayList = this.O00000oO;
                    bVar = new b("wss", Integer.valueOf(frequency), true);
                } else {
                    arrayList = this.O00000oO;
                    bVar = new b("wss", -1, true);
                }
                arrayList.add(bVar);
            } catch (Exception unused3) {
                this.O00000oO.add(new b("wss", -1, true));
            }
        }
    }

    public final g O00000o() {
        return this.O00000Oo;
    }

    public final void O00000oO() {
        O000000o(this.O00000oO);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        this.O00000o0 = i == 2;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000Oo = (p) getArguments().getParcelable("arg_wifi_diagnose");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_wifi_diagnose, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.diagnoseTitle);
        if (textView != null) {
            textView.setText(this.O00000Oo.O0000Oo);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.diagnoseMessage);
        if (textView2 != null) {
            textView2.setText(this.O00000Oo.O0000OoO);
        }
        this.O00000oo = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O00000oo;
        if (button != null) {
            button.setVisibility(this.O00000Oo.O00000Oo() ? 0 : 8);
            this.O00000oo.setText(this.O00000Oo.O0000o0);
            this.O00000oo.setOnClickListener(this);
        }
    }

    public final void onResume() {
        super.onResume();
        boolean z = true;
        if (O000000o("android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = null;
            try {
                wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService("wifi");
            } catch (Exception unused) {
            }
            if (wifiManager == null) {
                this.O00000oO.add(new b("wf", 4003, false));
                ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), this);
                return;
            }
            ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this);
            if (wifiManager.isWifiEnabled()) {
                O000000o(wifiManager);
            } else if (!O000000o("android.permission.CHANGE_WIFI_STATE")) {
                p pVar = this.O00000Oo;
                if (pVar != null) {
                    if (pVar.f2620O000000o != 1) {
                        z = false;
                    }
                    if (z && !this.O00000o0) {
                        if (isAdded()) {
                            Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                            intent.addFlags(67108864);
                            startActivityForResult(intent, 2);
                            return;
                        }
                        return;
                    }
                }
                this.O00000oO.add(new b("wf", 4002, false));
                O00000oo();
            } else if (wifiManager.setWifiEnabled(true)) {
                O000000o(wifiManager);
                wifiManager.setWifiEnabled(false);
            } else {
                this.O00000oO.add(new b("wf", 0, false));
                O00000oo();
            }
        } else if (!this.O00000o) {
            this.O00000o = true;
            requestPermissions(new String[]{"android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_WIFI_STATE"}, 0);
        } else {
            this.O00000oO.add(new b("wf", 4002, false));
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), this);
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
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
            this.O00000oO.add(new b("wf", 4001, false, true));
        }
    }

    private void O00000oo() {
        ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
    }

    private void O000000o(WifiManager wifiManager) {
        this.O00000oO.add(new b("wf", 1, true));
        O00000Oo(wifiManager);
        ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.FALSE);
    }
}
