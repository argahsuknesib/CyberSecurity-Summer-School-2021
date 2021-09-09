package _m_j;

import _m_j.O0OOO0O;
import a.a.a.b;
import a.a.a.e.c.g;
import a.a.a.e.c.j;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;
import in.cashify.otex.widget.DiagnoseMicHeaderView;

public final class O0O0O0o extends ooooooo implements CircleRoadProgress.O00000Oo {
    public j O00000Oo;
    public b O00000o;
    public boolean O00000o0;
    public DiagnoseMicHeaderView O00000oO;
    public boolean O00000oo;
    public Button O0000O0o;
    public boolean O0000OOo;

    public static O0O0O0o O000000o(j jVar) {
        O0O0O0o o0O0O0o = new O0O0O0o();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_mic_diagnose", jVar);
        o0O0O0o.setArguments(bundle);
        return o0O0O0o;
    }

    private void O00000oo() {
        requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 0);
    }

    public final g O00000o() {
        return this.O00000Oo;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000Oo = (j) getArguments().getParcelable("arg_mic_diagnose");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_mic_diagnose, viewGroup, false);
    }

    public class O000000o implements Runnable {
        public O000000o() {
        }

        public final void run() {
            View view = ((ExchangeManager) O0O0O0o.this.getParentFragment()).O0000O0o.O00000Oo;
            if (view instanceof DiagnoseMicHeaderView) {
                O0O0O0o.this.O000000o((DiagnoseMicHeaderView) view);
            }
        }
    }

    public class O00000Oo extends O0OOO0O.O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ O0OOO0O f6663O000000o;

        public O00000Oo(O0OOO0O o0ooo0o) {
            this.f6663O000000o = o0ooo0o;
        }

        public final boolean O000000o() {
            this.f6663O000000o.dismissAllowingStateLoss();
            if (O0O0O0o.this.O00000oO != null) {
                O0O0O0o.this.O00000oO.O000000o();
            }
            ((ExchangeManager) O0O0O0o.this.getParentFragment()).O000000o(O0O0O0o.this.O00000Oo(), O0O0O0o.this);
            return true;
        }

        public final void O00000Oo() {
            this.f6663O000000o.dismissAllowingStateLoss();
            boolean unused = O0O0O0o.this.O00000oo = true;
            ((ExchangeManager) O0O0O0o.this.getParentFragment()).O000000o(-1, O0O0O0o.this);
            ((ExchangeManager) O0O0O0o.this.getParentFragment()).O000000o(O0O0O0o.this.O00000o0(), Boolean.TRUE);
            b unused2 = O0O0O0o.this.O00000o = new b("me", 4001, false, true);
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
        this.O0000O0o = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O0000O0o;
        if (button != null) {
            button.setVisibility(this.O00000Oo.O00000Oo() ? 0 : 8);
            this.O0000O0o.setText(this.O00000Oo.O0000o0);
            this.O0000O0o.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.nextButton) {
            this.O00000oo = true;
            Button button = this.O0000O0o;
            if (button != null) {
                button.setEnabled(false);
            }
            this.O00000o = new b("me", 4001, false, true);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        }
    }

    public final void onResume() {
        super.onResume();
        View view = ((ExchangeManager) getParentFragment()).O0000O0o.O00000Oo;
        if (!(view instanceof DiagnoseMicHeaderView)) {
            ((ExchangeManager) getParentFragment()).O00000Oo();
            new Handler(Looper.getMainLooper()).postDelayed(new O000000o(), 500);
            return;
        }
        O000000o((DiagnoseMicHeaderView) view);
    }

    public final void onPause() {
        DiagnoseMicHeaderView.O000000o o000000o;
        DiagnoseMicHeaderView diagnoseMicHeaderView = this.O00000oO;
        if (!(diagnoseMicHeaderView == null || (o000000o = diagnoseMicHeaderView.O00000Oo) == null || o000000o.isCancelled())) {
            diagnoseMicHeaderView.O00000Oo.cancel(true);
        }
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
    }

    public final void O00000oO() {
        DiagnoseMicHeaderView diagnoseMicHeaderView;
        if (!this.O00000oo && (diagnoseMicHeaderView = this.O00000oO) != null) {
            DiagnoseMicHeaderView.O000000o o000000o = diagnoseMicHeaderView.O00000Oo;
            if (o000000o != null && !o000000o.isCancelled()) {
                diagnoseMicHeaderView.O00000Oo.cancel(true);
            }
            boolean z = this.O00000oO.O00000o >= this.O00000Oo.f2616O000000o;
            if (this.O00000oO.O00000o < 0 || z) {
                if (!this.O0000OOo) {
                    this.O0000OOo = true;
                    this.O00000o = new b("me", Integer.valueOf(this.O00000oO.O00000o), z);
                    ((ExchangeManager) getParentFragment()).O000000o(-1, this);
                    ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.valueOf(!this.O00000o.O00000o0));
                    return;
                }
            } else if (isAdded()) {
                O0OOO0O O000000o2 = O0OOO0O.O000000o(getString(R.string.otex_mic_alert_title), this.O00000Oo.O0000Ooo, this.O00000Oo.O0000o00, this.O00000Oo.O0000o0);
                O000000o2.f6672O000000o = new O00000Oo(O000000o2);
                ei O000000o3 = getChildFragmentManager().O000000o();
                O000000o3.O000000o(O000000o2, O000000o2.getClass().getSimpleName());
                O000000o3.O00000o0();
                return;
            } else {
                return;
            }
        }
        O000000o(this.O00000o);
    }

    /* access modifiers changed from: private */
    public void O000000o(DiagnoseMicHeaderView diagnoseMicHeaderView) {
        this.O00000oO = diagnoseMicHeaderView;
        if (O000000o("android.permission.RECORD_AUDIO")) {
            DiagnoseMicHeaderView diagnoseMicHeaderView2 = this.O00000oO;
            if (diagnoseMicHeaderView2 != null) {
                diagnoseMicHeaderView2.O000000o();
            }
            ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this);
            Button button = this.O0000O0o;
            if (button != null) {
                button.setEnabled(true);
            }
        } else if (!this.O00000o0) {
            O00000oo();
            this.O00000o0 = true;
        } else if (getActivity() == null || ooooooo.O000000o(getActivity(), 27) || this.O00000o0) {
            this.O00000o = new b("me", 4002, false);
            this.O00000oo = true;
            ((ExchangeManager) getParentFragment()).O000000o(-1, this);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        } else {
            O000000o();
            this.O00000o0 = true;
        }
    }
}
