package a.a.a.e.e;

import _m_j.ooooooo;
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
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;

public final class a extends ooooooo implements CircleRoadProgress.O00000Oo {
    public a.a.a.e.c.a O00000Oo;
    public a.a.a.b O00000o;
    public b O00000o0;
    public Button O00000oO;
    public boolean O00000oo;

    public static a O000000o(a.a.a.e.c.a aVar) {
        a aVar2 = new a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_audio_diagnose", aVar);
        aVar2.setArguments(bundle);
        return aVar2;
    }

    public final g O00000o() {
        return this.O00000Oo;
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        this.O00000o0 = new b(this, (byte) 0);
        try {
            getActivity().registerReceiver(this.O00000o0, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        } catch (Throwable unused) {
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000Oo = (a.a.a.e.c.a) getArguments().getParcelable("arg_audio_diagnose");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_audio_diagnose, viewGroup, false);
    }

    public final void onDetach() {
        try {
            getActivity().unregisterReceiver(this.O00000o0);
        } catch (Throwable unused) {
        }
        super.onDetach();
    }

    public class b extends BroadcastReceiver {
        private b() {
        }

        public /* synthetic */ b(a aVar, byte b) {
            this();
        }

        public void onReceive(Context context, Intent intent) {
            int intExtra;
            if (intent.getAction() != null && intent.getAction().equals("android.intent.action.HEADSET_PLUG") && (intExtra = intent.getIntExtra("state", -1)) != 0 && intExtra == 1) {
                a.a.a.b unused = a.this.O00000o = new a.a.a.b("aj", 1, true);
                ((ExchangeManager) a.this.getParentFragment()).O000000o(a.this.O00000o0(), Boolean.FALSE);
            }
        }
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
        this.O00000oO = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O00000oO;
        if (button != null) {
            button.setVisibility(this.O00000Oo.O00000Oo() ? 0 : 8);
            this.O00000oO.setText(this.O00000Oo.O0000o0);
            this.O00000oO.setOnClickListener(this);
        }
    }

    public final void onResume() {
        super.onResume();
        Button button = this.O00000oO;
        if (button != null) {
            button.setEnabled(true);
        }
        ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this, this.O00000Oo.O0000o);
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
            this.O00000o = new a.a.a.b("aj", 4001, false, true);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        }
    }

    public final void O00000oO() {
        if (this.O00000o != null || this.O00000oo) {
            O000000o(this.O00000o);
            return;
        }
        this.O00000oo = true;
        this.O00000o = new a.a.a.b("aj", 4005, false);
        ((ExchangeManager) getParentFragment()).O000000o(-1, this);
        ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.valueOf(true ^ this.O00000o.O00000o0));
    }
}
