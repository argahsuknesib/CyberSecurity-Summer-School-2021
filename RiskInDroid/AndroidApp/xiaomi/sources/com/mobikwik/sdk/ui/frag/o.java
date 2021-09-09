package com.mobikwik.sdk.ui.frag;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.mobikwik.sdk.lib.model.SavedCardResponse;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.PaymentOptionsDecoder;
import com.mobikwik.sdk.lib.utils.UIFunctions;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.lib.wallet.WalletAPIs;
import com.mobikwik.sdk.ui.util.l;
import com.xiaomi.smarthome.R;

public class o extends aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    SavedCardResponse.CardDetails[] f5325a;
    private WalletAPIs s;
    private b t;
    /* access modifiers changed from: private */
    public ProgressDialog u;
    /* access modifiers changed from: private */
    public int v;
    /* access modifiers changed from: private */
    public SavedCardResponse.CardDetails w;
    private View x;

    class a extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        SavedCardResponse.CardDetails f5326a;

        public a(SavedCardResponse.CardDetails cardDetails) {
            this.f5326a = cardDetails;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            String zaakpayMerchantIdForAmount = PaymentOptionsDecoder.getZaakpayMerchantIdForAmount(o.this.p, o.this.r, o.this.n);
            return Network.getResponseFromQuery(o.this.k, "https://api.zaakpay.com/removeCard?mode=0&merchantIdentifier=" + zaakpayMerchantIdForAmount + "&buyerEmail=" + o.this.l.getUser().getEmail() + "&cardId=" + this.f5326a.cardId);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(String str) {
            o oVar;
            SavedCardResponse.CardDetails cardDetails;
            if (o.this.u != null && o.this.u.isShowing()) {
                o.this.u.dismiss();
            }
            if (Network.validateNetworkResponse(o.this.k, str, true)) {
                SavedCardResponse savedCardResponse = (SavedCardResponse) new Gson().fromJson(str, SavedCardResponse.class);
                if ("100".equals(savedCardResponse.responseCode)) {
                    oVar = o.this;
                    cardDetails = savedCardResponse.cards[0];
                } else {
                    oVar = o.this;
                    cardDetails = null;
                }
                oVar.a(cardDetails, savedCardResponse.responseDescription);
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            o oVar = o.this;
            ProgressDialog unused = oVar.u = ProgressDialog.show(oVar.k, null, "Processing your request...", true);
        }
    }

    public interface b {
        void a();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void a(View view) {
        View inflate = LayoutInflater.from(this.k).inflate((int) R.layout.mk_layout_cvv, (ViewGroup) null, false);
        inflate.setVisibility(4);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.btnContinueWithNewCard).getParent();
        linearLayout.addView(inflate, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.requestLayout();
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new p(this, inflate, linearLayout));
    }

    private void a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt);
            }
            if ((childAt instanceof TextView) && childAt.getTag() != null) {
                TextView textView = (TextView) childAt;
                textView.setCompoundDrawablesWithIntrinsicBounds(l.a(((SavedCardResponse.CardDetails) textView.getTag()).cardType), 0, 0, 0);
                textView.setSelected(false);
                textView.setTypeface(Typeface.create((String) null, 0));
                ViewGroup viewGroup2 = (ViewGroup) textView.getParent();
                View findViewById = viewGroup2.findViewById(R.id.layout_cvv_block);
                if (findViewById != null && findViewById.getVisibility() == 0) {
                    textView.bringToFront();
                    com.mobikwik.sdk.ui.util.a aVar = new com.mobikwik.sdk.ui.util.a(viewGroup2, findViewById, viewGroup2.getHeight(), viewGroup2.getHeight() - findViewById.getHeight(), 2);
                    aVar.a(true);
                    findViewById.startAnimation(aVar);
                }
            }
        }
    }

    private void a(LinearLayout linearLayout) {
        View view = new View(this.k);
        view.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.height = (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics());
        linearLayout.addView(view, layoutParams);
    }

    /* access modifiers changed from: private */
    public void a(SavedCardResponse.CardDetails cardDetails, View view) {
        if (cardDetails != null && view != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_saved_cards);
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                View childAt = linearLayout.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    childAt = ((ViewGroup) childAt).getChildAt(0);
                }
                SavedCardResponse.CardDetails cardDetails2 = (SavedCardResponse.CardDetails) childAt.getTag();
                if ((childAt instanceof TextView) && cardDetails2 != null && cardDetails.cardId.equalsIgnoreCase(cardDetails2.cardId)) {
                    ((TextView) childAt).performClick();
                }
            }
        }
    }

    private void a(String str) {
        SharedPreferences.Editor edit = this.k.getSharedPreferences("PREF_PRE_SAVED_CARD", 0).edit();
        edit.putString("SCARD" + this.l.getUser().getEmail(), str);
        edit.commit();
    }

    /* access modifiers changed from: private */
    public boolean a(boolean z) {
        String str;
        boolean equalsIgnoreCase = "maestro".equalsIgnoreCase(this.i.cardType);
        EditText editText = (EditText) getView().findViewById(R.id.editText_cvv);
        String obj = editText.getText().toString();
        editText.setBackgroundResource(R.drawable.mk_edit_text_bg);
        if (obj.length() == 0) {
            if (!equalsIgnoreCase) {
                if (!z) {
                    str = "Enter CVV";
                }
                editText.setBackgroundResource(R.drawable.mk_cvv_text_bg);
                this.h++;
                return false;
            }
            this.g = obj;
            return true;
        }
        if (obj.length() < 3 || ("amex".equalsIgnoreCase(this.i.cardType) && obj.length() != 4)) {
            if (!z) {
                str = "Please enter valid CVV";
            }
            editText.setBackgroundResource(R.drawable.mk_cvv_text_bg);
            this.h++;
            return false;
        }
        this.g = obj;
        return true;
        editText.setError(str);
        editText.requestFocus();
        editText.setBackgroundResource(R.drawable.mk_cvv_text_bg);
        this.h++;
        return false;
    }

    private void b(View view) {
        SavedCardResponse.CardDetails[] cardDetailsArr;
        if (this.r) {
            this.f5325a = com.mobikwik.sdk.ui.data.b.b(this.k).g();
        } else {
            this.f5325a = com.mobikwik.sdk.ui.data.b.b(this.k).h();
        }
        int applyDimension = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_saved_cards);
        linearLayout.removeAllViews();
        this.i = null;
        SavedCardResponse.CardDetails[] cardDetailsArr2 = this.f5325a;
        if (cardDetailsArr2 == null || cardDetailsArr2.length == 0) {
            TextView textView = new TextView(this.k);
            textView.setTextSize(16.0f);
            int i = applyDimension * 2;
            textView.setPadding(applyDimension, i, applyDimension, i);
            textView.setTextColor(getResources().getColorStateList(R.color.mk_blue_text_state_list));
            textView.setText("No Saved Cards.");
            textView.setGravity(17);
            linearLayout.addView(textView, -1, -2);
            return;
        }
        String c = c();
        TextView textView2 = null;
        int i2 = 0;
        while (true) {
            cardDetailsArr = this.f5325a;
            if (i2 >= cardDetailsArr.length) {
                break;
            }
            if (i2 == 0) {
                a(linearLayout);
            }
            SavedCardResponse.CardDetails cardDetails = this.f5325a[i2];
            RelativeLayout relativeLayout = new RelativeLayout(this.k);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            TextView textView3 = new TextView(this.k);
            textView3.setCompoundDrawablesWithIntrinsicBounds(l.a(cardDetails.cardType), 0, 0, 0);
            textView3.setCompoundDrawablePadding(applyDimension);
            int i3 = applyDimension * 2;
            textView3.setPadding(applyDimension, i3, applyDimension, i3);
            textView3.setGravity(16);
            String str = cardDetails.first4 + "-XXXX-XXXX-" + cardDetails.last4;
            if (!Utils.isNull(cardDetails.formattedCardNum)) {
                str = cardDetails.formattedCardNum;
            }
            textView3.setText(str);
            textView3.setTextSize(18.0f);
            textView3.setTextColor(getResources().getColorStateList(R.color.mk_blue_text_state_list));
            textView3.setId(121);
            relativeLayout.addView(textView3, new RelativeLayout.LayoutParams(-1, -2));
            registerForContextMenu(textView3);
            linearLayout.addView(relativeLayout, layoutParams);
            a(linearLayout);
            textView3.setTag(cardDetails);
            textView3.setOnClickListener(this);
            if (cardDetails.cardId.equals(c) && this.w == null) {
                this.w = cardDetails;
            }
            i2++;
            textView2 = textView3;
        }
        if (cardDetailsArr.length == 1 && textView2 != null) {
            textView2.performClick();
        }
    }

    private void b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                b((ViewGroup) childAt);
            } else if (this.i == null) {
                if ((childAt instanceof TextView) && childAt.getTag() != null) {
                    TextView textView = (TextView) childAt;
                    textView.getTag();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.4f, 1.0f);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setDuration(10);
                    textView.startAnimation(alphaAnimation);
                    textView.setTextColor(getResources().getColorStateList(R.color.mk_blue_text_state_list));
                    textView.setBackgroundDrawable(null);
                }
            } else if ((childAt instanceof TextView) && childAt.getTag() != null) {
                TextView textView2 = (TextView) childAt;
                SavedCardResponse.CardDetails cardDetails = (SavedCardResponse.CardDetails) textView2.getTag();
                ViewGroup viewGroup2 = (ViewGroup) textView2.getParent();
                if (cardDetails == this.i) {
                    AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.4f, 1.0f);
                    alphaAnimation2.setFillAfter(true);
                    alphaAnimation2.setDuration(10);
                    viewGroup2.startAnimation(alphaAnimation2);
                    textView2.setTextColor(getResources().getColorStateList(R.color.mk_blue_text_state_list));
                    viewGroup2.setBackgroundDrawable(null);
                } else {
                    AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 0.4f);
                    alphaAnimation3.setFillAfter(true);
                    alphaAnimation3.setDuration(10);
                    viewGroup2.startAnimation(alphaAnimation3);
                    viewGroup2.setBackgroundColor(getResources().getColor(R.color.mk_uic_btn_selected_dull));
                }
            }
        }
    }

    private String c() {
        SharedPreferences sharedPreferences = this.k.getSharedPreferences("PREF_PRE_SAVED_CARD", 0);
        return sharedPreferences.getString("SCARD" + this.l.getUser().getEmail(), "");
    }

    private void c(View view) {
        boolean equalsIgnoreCase = "maestro".equalsIgnoreCase(this.i == null ? "" : this.i.cardType);
        EditText editText = (EditText) view.findViewById(R.id.editText_cvv);
        if (editText != null) {
            editText.setHint(equalsIgnoreCase ? "CVV (optional)" : "CVV");
        }
    }

    private void d() {
        if (a(false)) {
            a(this.i.cardId);
            if (Network.isConnected(this.k)) {
                b();
            }
        }
    }

    private void d(View view) {
        Object tag = view.getTag();
        if (tag instanceof SavedCardResponse.CardDetails) {
            SavedCardResponse.CardDetails cardDetails = (SavedCardResponse.CardDetails) tag;
            AlertDialog.Builder builder = new AlertDialog.Builder(this.k);
            builder.setTitle("Delete Saved Card");
            String str = cardDetails.first4 + "-XXXX-XXXX-" + cardDetails.last4;
            if (!Utils.isNull(cardDetails.formattedCardNum)) {
                str = cardDetails.formattedCardNum;
            }
            builder.setMessage(Html.fromHtml("Your card <b>" + str + " </b> will be deleted."));
            builder.setPositiveButton("Delete", new r(this, cardDetails));
            builder.setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    /* access modifiers changed from: protected */
    public void a(SavedCardResponse.CardDetails cardDetails) {
        SavedCardResponse.CardDetails cardDetails2 = cardDetails;
        if (Network.isConnected(this.k)) {
            com.mobikwik.sdk.ui.data.b b2 = com.mobikwik.sdk.ui.data.b.b(this.k);
            if (this.r) {
                this.u = ProgressDialog.show(this.k, null, "Processing your request...", true);
                this.s.deleteSavedCard(this.l.getUser().getEmail(), this.l.getUser().getCell(), this.l.getOrderId(), this.l.getAmount(), this.m.getMbkId(), b2.i(), true, com.mobikwik.sdk.ui.data.a.a(this.k, this.l.getUser()), cardDetails2.cardId, this.m.getPgResponseUrl(), this.m.getMerchantName(), new s(this, cardDetails2));
                return;
            }
            new a(cardDetails2).execute(new Void[0]);
        }
    }

    public void a(SavedCardResponse.CardDetails cardDetails, String str) {
        SavedCardResponse.CardDetails[] cardDetailsArr;
        if (cardDetails != null) {
            SavedCardResponse.CardDetails[] g = this.r ? com.mobikwik.sdk.ui.data.b.b(this.k).g() : com.mobikwik.sdk.ui.data.b.b(this.k).h();
            if (g != null) {
                cardDetailsArr = new SavedCardResponse.CardDetails[(g.length - 1)];
                int i = 0;
                for (int i2 = 0; i2 < g.length; i2++) {
                    if (!g[i2].cardId.equalsIgnoreCase(cardDetails.cardId)) {
                        cardDetailsArr[i] = g[i2];
                        i++;
                    }
                }
            } else {
                cardDetailsArr = null;
            }
            this.f5325a = cardDetailsArr;
            if (this.r) {
                com.mobikwik.sdk.ui.data.b.b(this.k).a(cardDetailsArr);
            } else {
                com.mobikwik.sdk.ui.data.b.b(this.k).b(cardDetailsArr);
            }
            this.i = null;
            b(getView());
            UIFunctions.displayAlertDialogWithParams(this.k, "Delete Status", "Your card has been deleted Successfully", "OK");
            return;
        }
        UIFunctions.showToastLong(this.k.getBaseContext(), str);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof b) {
            this.t = (b) activity;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onClick(View view) {
        if (view.getId() == R.id.button_savedcard_pay) {
            d();
        } else if (view.getId() == R.id.btnContinueWithNewCard) {
            b bVar = this.t;
            if (bVar != null) {
                bVar.a();
            }
        } else if (view.getId() == 100) {
            d(view);
        } else if (!(view instanceof TextView)) {
        } else {
            if (this.i == null || this.f5325a.length != 1) {
                TextView textView = (TextView) view;
                LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.layout_saved_cards);
                SavedCardResponse.CardDetails cardDetails = (SavedCardResponse.CardDetails) textView.getTag();
                a((ViewGroup) linearLayout);
                if (cardDetails.equals(this.i)) {
                    this.i = null;
                    b((ViewGroup) linearLayout);
                    textView.setCompoundDrawablesWithIntrinsicBounds(l.a(cardDetails.cardType), 0, 0, 0);
                    textView.setSelected(false);
                    return;
                }
                this.i = cardDetails;
                textView.setCompoundDrawablesWithIntrinsicBounds(l.a(cardDetails.cardType), 0, 0, 0);
                textView.setSelected(true);
                textView.setTypeface(Typeface.create((String) null, 1));
                ViewGroup viewGroup = (ViewGroup) textView.getParent();
                View inflate = LayoutInflater.from(this.k).inflate((int) R.layout.mk_layout_cvv, (ViewGroup) null, false);
                inflate.findViewById(R.id.button_savedcard_pay).setOnClickListener(this);
                int height = viewGroup.getHeight();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(3, 121);
                viewGroup.addView(inflate, layoutParams);
                EditText editText = (EditText) inflate.findViewById(R.id.editText_cvv);
                editText.requestFocus();
                editText.addTextChangedListener(new q(this));
                textView.bringToFront();
                if (this.f5325a.length > 1) {
                    inflate.startAnimation(new com.mobikwik.sdk.ui.util.a(viewGroup, inflate, height, height + this.v, 1));
                }
                c(inflate);
                b((ViewGroup) linearLayout);
            }
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        d(this.x);
        return super.onContextItemSelected(menuItem);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (view.getTag() instanceof SavedCardResponse.CardDetails) {
            contextMenu.add("Delete Card");
            this.x = view;
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        com.mobikwik.sdk.ui.data.b.b(getActivity());
        this.s = WalletAPIs.getInstance("1".equals(com.mobikwik.sdk.ui.data.b.b(getActivity()).f().getMode()), getActivity());
        View inflate = layoutInflater.inflate((int) R.layout.mk_fragment_saved_cards, viewGroup, false);
        l.a((TextView) inflate.findViewById(R.id.amount), this.l.getAmount(), this.p);
        inflate.findViewById(R.id.btnContinueWithNewCard).setOnClickListener(this);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        a(getView());
        b(getView());
    }

    public void onStop() {
        View findViewById = this.k.findViewById(R.id.imageViewAddCard);
        if (findViewById != null) {
            findViewById.setVisibility(4);
        }
        super.onStop();
    }
}
