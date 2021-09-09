package _m_j;

import a.a.a.b;
import a.a.a.e.c.g;
import a.a.a.e.c.o;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;

public final class O0OO00O extends ooooooo implements CircleRoadProgress.O00000Oo {
    public o O00000Oo;
    public boolean O00000o;
    public boolean O00000o0;
    public b O00000oO;
    public Window.Callback O00000oo;
    public Button O0000O0o;
    public boolean O0000OOo;

    public class O000000o extends OO0O00o {
        public O000000o(Window.Callback callback) {
            super(callback);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return O0OO00O.O000000o(O0OO00O.this, keyEvent.getKeyCode()) || super.dispatchKeyEvent(keyEvent);
        }
    }

    public static O0OO00O O000000o(o oVar) {
        O0OO00O o0oo00o = new O0OO00O();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_volume_diagnose", oVar);
        o0oo00o.setArguments(bundle);
        return o0oo00o;
    }

    private void O00000oo() {
        try {
            this.O00000oo = getActivity().getWindow().getCallback();
            getActivity().getWindow().setCallback(new O000000o(this.O00000oo));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void O0000O0o() {
        try {
            Window window = getActivity().getWindow();
            if (this.O00000oo != window.getCallback()) {
                window.setCallback(this.O00000oo);
            }
        } catch (Throwable unused) {
        }
    }

    public final g O00000o() {
        return this.O00000Oo;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000Oo = (o) getArguments().getParcelable("arg_volume_diagnose");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_volume_diagnose, viewGroup, false);
    }

    public static /* synthetic */ boolean O000000o(O0OO00O o0oo00o, int i) {
        boolean z;
        ExchangeManager exchangeManager;
        int i2;
        if (i == 25) {
            o0oo00o.O00000o = true;
            if (!o0oo00o.O00000o0) {
                exchangeManager = (ExchangeManager) o0oo00o.getParentFragment();
                i2 = R.drawable.ic_volume_down;
                exchangeManager.O000000o(i2);
                z = true;
                if (o0oo00o.O00000o0 && o0oo00o.O00000o) {
                    o0oo00o.O0000O0o();
                    ((ExchangeManager) o0oo00o.getParentFragment()).O000000o(o0oo00o.O00000o0(), Boolean.FALSE);
                    o0oo00o.O00000oO = new b("vb", 1, true);
                }
                return z;
            }
        } else if (i == 24) {
            o0oo00o.O00000o0 = true;
            if (!o0oo00o.O00000o) {
                exchangeManager = (ExchangeManager) o0oo00o.getParentFragment();
                i2 = R.drawable.ic_volume_up;
                exchangeManager.O000000o(i2);
                z = true;
                o0oo00o.O0000O0o();
                ((ExchangeManager) o0oo00o.getParentFragment()).O000000o(o0oo00o.O00000o0(), Boolean.FALSE);
                o0oo00o.O00000oO = new b("vb", 1, true);
                return z;
            }
        } else {
            z = false;
            o0oo00o.O0000O0o();
            ((ExchangeManager) o0oo00o.getParentFragment()).O000000o(o0oo00o.O00000o0(), Boolean.FALSE);
            o0oo00o.O00000oO = new b("vb", 1, true);
            return z;
        }
        exchangeManager = (ExchangeManager) o0oo00o.getParentFragment();
        i2 = R.drawable.ic_volume_up_down;
        exchangeManager.O000000o(i2);
        z = true;
        o0oo00o.O0000O0o();
        ((ExchangeManager) o0oo00o.getParentFragment()).O000000o(o0oo00o.O00000o0(), Boolean.FALSE);
        o0oo00o.O00000oO = new b("vb", 1, true);
        return z;
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
        this.O0000O0o = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O0000O0o;
        if (button != null) {
            button.setVisibility(this.O00000Oo.O00000Oo() ? 0 : 8);
            this.O0000O0o.setText(this.O00000Oo.O0000o0);
            this.O0000O0o.setOnClickListener(this);
        }
    }

    public final void onResume() {
        super.onResume();
        O00000oo();
        ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this);
    }

    public final void onPause() {
        O0000O0o();
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.nextButton) {
            Button button = this.O0000O0o;
            if (button != null) {
                button.setEnabled(false);
            }
            this.O00000oO = new b("vb", 0, false, true);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        }
    }

    public final void O00000oO() {
        if (this.O00000oO != null || this.O0000OOo) {
            O000000o(this.O00000oO);
            return;
        }
        this.O0000OOo = true;
        this.O00000oO = new b("vb", 4005, false);
        ((ExchangeManager) getParentFragment()).O000000o(-1, this);
        ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.valueOf(true ^ this.O00000oO.O00000o0));
    }
}
