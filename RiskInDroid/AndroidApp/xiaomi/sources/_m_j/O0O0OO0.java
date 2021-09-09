package _m_j;

import _m_j.O0OOO0O;
import _m_j.OO0oO;
import a.a.a.b;
import a.a.a.e.c.f;
import a.a.a.e.c.g;
import a.a.a.e.c.i;
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
import java.util.List;

public final class O0O0OO0 extends ooooooo implements OO0oO.O00000Oo, View.OnClickListener, CircleRoadProgress.O00000Oo {
    public f O00000Oo;
    public b O00000o;
    public OO0oO O00000o0;
    public TextView O00000oO;
    public Button O00000oo;
    public O0OOO0O O0000O0o;

    public static O0O0OO0 O000000o(f fVar) {
        O0O0OO0 o0o0oo0 = new O0O0OO0();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_dead_pixel_diagnose", fVar);
        o0o0oo0.setArguments(bundle);
        return o0o0oo0;
    }

    public final g O00000o() {
        return this.O00000Oo;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000Oo = (f) getArguments().getParcelable("arg_dead_pixel_diagnose");
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

    public class O000000o extends O0OOO0O.O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ i.b f6668O000000o;
        public final /* synthetic */ i.b O00000Oo;

        public O000000o(i.b bVar, i.b bVar2) {
            this.f6668O000000o = bVar;
            this.O00000Oo = bVar2;
        }

        public final boolean O000000o() {
            ((ExchangeManager) O0O0OO0.this.getParentFragment()).O000000o(O0O0OO0.this.O00000o0(), Boolean.TRUE);
            O0O0OO0 o0o0oo0 = O0O0OO0.this;
            b unused = o0o0oo0.O00000o = new b(o0o0oo0.O00000Oo.O0000oOO, this.f6668O000000o.f2615O000000o, false, true);
            return true;
        }

        public final void O00000Oo() {
            ((ExchangeManager) O0O0OO0.this.getParentFragment()).O000000o(O0O0OO0.this.O00000o0(), Boolean.FALSE);
            O0O0OO0 o0o0oo0 = O0O0OO0.this;
            b unused = o0o0oo0.O00000o = new b(o0o0oo0.O00000Oo.O0000oOO, this.O00000Oo.f2615O000000o, true, true);
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.nextButton).setOnClickListener(this);
        this.O00000oO = (TextView) view.findViewById(R.id.diagnoseActionButton);
        TextView textView = this.O00000oO;
        int i = 0;
        if (textView != null) {
            textView.setOnClickListener(this);
            this.O00000oO.setVisibility(0);
            this.O00000oO.setText((int) R.string.otex_start);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.diagnoseTitle);
        if (textView2 != null) {
            textView2.setText(this.O00000Oo.O0000Oo);
        }
        TextView textView3 = (TextView) view.findViewById(R.id.diagnoseMessage);
        if (textView3 != null) {
            textView3.setText(this.O00000Oo.O0000OoO);
        }
        this.O00000oo = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O00000oo;
        if (button != null) {
            if (!this.O00000Oo.O00000Oo()) {
                i = 8;
            }
            button.setVisibility(i);
            this.O00000oo.setText(this.O00000Oo.O0000o0);
            this.O00000oo.setOnClickListener(this);
        }
    }

    public final void onResume() {
        super.onResume();
        ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this, this.O00000Oo.O0000o);
    }

    public final void onPause() {
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
        OO0oO oO0oO = this.O00000o0;
        if (oO0oO != null) {
            oO0oO.dismissAllowingStateLoss();
        }
        O0OOO0O o0ooo0o = this.O0000O0o;
        if (o0ooo0o != null) {
            o0ooo0o.dismissAllowingStateLoss();
        }
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.diagnoseActionButton) {
            ((ExchangeManager) getParentFragment()).O000000o();
            String name = OO0oO.class.getName();
            this.O00000o0 = OO0oO.O000000o(this.O00000Oo.f2613O000000o, this.O00000Oo.O00000Oo);
            this.O00000o0.setCancelable(false);
            this.O00000o0.O00000oo = this;
            ei O000000o2 = getChildFragmentManager().O000000o();
            O000000o2.O000000o(this.O00000o0, name);
            O000000o2.O00000o0();
        } else if (id == R.id.nextButton) {
            TextView textView = this.O00000oO;
            if (textView != null) {
                textView.setEnabled(false);
            }
            Button button = this.O00000oo;
            if (button != null) {
                button.setEnabled(false);
            }
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
            this.O00000o = new b(this.O00000Oo.O0000oOO, 4001, false, true);
        }
    }

    public final void O00000oO() {
        if (this.O00000o == null) {
            this.O00000o = new b(this.O00000Oo.O0000oOO, 4005, false);
        }
        O000000o(this.O00000o);
    }

    public final void O00000oo() {
        List<i.b> list = this.O00000Oo.O0000oO;
        if (list.size() < 2) {
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
            this.O00000o = new b(this.O00000Oo.O0000oOO, 4001, false, true);
            return;
        }
        i.b bVar = list.get(0);
        i.b bVar2 = list.get(1);
        this.O0000O0o = O0OOO0O.O000000o("", getString(R.string.blink_dialog_msg), bVar.O00000Oo, bVar2.O00000Oo);
        this.O0000O0o.f6672O000000o = new O000000o(bVar, bVar2);
        ei O000000o2 = getChildFragmentManager().O000000o();
        O0OOO0O o0ooo0o = this.O0000O0o;
        O000000o2.O000000o(o0ooo0o, o0ooo0o.getClass().getSimpleName());
        O000000o2.O00000o0();
    }
}
