package _m_j;

import a.a.a.b;
import a.a.a.e.c.g;
import a.a.a.e.c.h;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;

public final class O0O00o extends ooooooo implements CircleRoadProgress.O00000Oo {
    public LocationManager O00000Oo;
    public b O00000o;
    public h O00000o0;
    public boolean O00000oO;
    public boolean O00000oo;
    public Button O0000O0o;

    public static O0O00o O000000o(h hVar) {
        O0O00o o0O00o = new O0O00o();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_gps_diagnose", hVar);
        o0O00o.setArguments(bundle);
        return o0O00o;
    }

    private static boolean O000000o(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            String string = Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed");
            return TextUtils.isEmpty(string) || !string.contains("gps");
        }
        try {
            int i = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
            return (i == 1 || i == 3) ? false : true;
        } catch (Settings.SettingNotFoundException unused) {
            return true;
        }
    }

    public final g O00000o() {
        return this.O00000o0;
    }

    public final void O00000oO() {
        if (this.O00000o == null) {
            this.O00000o = new b("gps", 4005, false);
        }
        O000000o(this.O00000o);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        this.O00000oO = i == 3;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000o0 = (h) getArguments().getParcelable("arg_gps_diagnose");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_gps_diagnose, viewGroup, false);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putBoolean("key_enable_request", this.O00000oO);
        }
    }

    public final void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.O00000oO = bundle.getBoolean("key_enable_request");
        }
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
        this.O0000O0o = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O0000O0o;
        if (button != null) {
            button.setVisibility(this.O00000o0.O00000Oo() ? 0 : 8);
            this.O0000O0o.setText(this.O00000o0.O0000o0);
            this.O0000O0o.setOnClickListener(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    public final void onResume() {
        b bVar;
        super.onResume();
        if (O000000o("android.permission.ACCESS_FINE_LOCATION")) {
            try {
                this.O00000Oo = (LocationManager) getContext().getSystemService("location");
            } catch (Exception unused) {
            }
            if (this.O00000Oo == null) {
                this.O00000o = new b("gps", 4004, false);
                ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), this);
                return;
            }
            ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this);
            if (this.O00000Oo.isProviderEnabled("gps") || !O000000o(getActivity())) {
                bVar = new b("gps", 1, true);
            } else {
                if (!(this.O00000o0.f2614O000000o == 1) || this.O00000oO) {
                    bVar = new b("gps", 4002, false);
                } else {
                    if (isAdded()) {
                        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                        intent.addFlags(67108864);
                        startActivityForResult(intent, 3);
                    }
                    if (this.O00000o == null) {
                        ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.valueOf(!this.O00000o.O00000o0));
                        return;
                    }
                    return;
                }
            }
            this.O00000o = bVar;
            if (this.O00000o == null) {
            }
        } else if (!this.O00000oo) {
            this.O00000oo = true;
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 0);
        } else {
            this.O00000o = new b("gps", 4002, false);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), this);
        }
    }

    public final void onPause() {
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.nextButton) {
            Button button = this.O0000O0o;
            if (button != null) {
                button.setEnabled(false);
            }
            this.O00000o = new b("gps", 4001, false, true);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        }
    }
}
