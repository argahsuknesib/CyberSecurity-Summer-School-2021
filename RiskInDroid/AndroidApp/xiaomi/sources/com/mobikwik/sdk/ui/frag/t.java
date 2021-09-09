package com.mobikwik.sdk.ui.frag;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;
import com.mobikwik.sdk.ui.data.b;
import com.mobikwik.sdk.ui.util.l;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class t extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private Transaction f5331a;
    private Activity b;
    /* access modifiers changed from: private */
    public a c;
    private boolean d = true;

    public interface a {
        void a(PaymentInstrumentType paymentInstrumentType);
    }

    public void a(View view) {
        Button button;
        int i;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.new_po_container);
        linearLayout.removeAllViews();
        int applyDimension = (int) TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
        ArrayList arrayList = new ArrayList();
        if (b.b(this.b).g() == null || b.b(this.b).g().length <= 0) {
            button = null;
        } else {
            button = new Button(this.b);
            button.setText("\t\tSaved Card");
            button.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.mk_btn_src_credit_debit), (Drawable) null, (Drawable) null, (Drawable) null);
            arrayList.add(button);
            button.setOnClickListener(new u(this));
        }
        Button button2 = new Button(this.b);
        button2.setText("\t\tCredit Card");
        button2.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.mk_btn_src_credit_debit), (Drawable) null, (Drawable) null, (Drawable) null);
        arrayList.add(button2);
        button2.setOnClickListener(new v(this));
        Button button3 = new Button(this.b);
        button3.setText("\t\tDebit Card");
        button3.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.mk_btn_src_credit_debit), (Drawable) null, (Drawable) null, (Drawable) null);
        arrayList.add(button3);
        button3.setOnClickListener(new w(this));
        Button button4 = new Button(this.b);
        button4.setText("\t\tNetbanking");
        button4.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.mk_btn_src_netbanking), (Drawable) null, (Drawable) null, (Drawable) null);
        arrayList.add(button4);
        button4.setOnClickListener(new x(this));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            Button button5 = (Button) arrayList.get(i2);
            if (i2 == 0) {
                i = R.drawable.mk_sel_btn_top;
            } else if (i2 == arrayList.size() - 1) {
                layoutParams.setMargins(0, 2, 0, 0);
                i = R.drawable.mk_sel_btn_bottom;
            } else {
                layoutParams.setMargins(0, 2, 0, 0);
                i = R.drawable.mk_sel_btn;
            }
            button5.setBackgroundResource(i);
            button5.setGravity(19);
            button5.setPadding(applyDimension, applyDimension, 0, applyDimension);
            button5.setTextColor(getResources().getColorStateList(R.color.mk_s_btn_txt));
            linearLayout.addView(button5, layoutParams);
        }
        arrayList.clear();
        if (this.d && button != null) {
            button.performClick();
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = activity;
        this.c = (a) activity;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.mk_frag_add_money_payment_opt, viewGroup, false);
        this.f5331a = b.b(this.b).d();
        a(inflate);
        l.a((TextView) inflate.findViewById(R.id.amount), this.f5331a.getAmount(), b.b(this.b).e());
        return inflate;
    }
}
