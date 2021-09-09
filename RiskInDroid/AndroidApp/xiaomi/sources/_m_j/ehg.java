package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.internal.PhoneViewWrapper$1;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u0004\u0018\u00010\"J\b\u0010#\u001a\u00020$H\u0002J\u0016\u0010%\u001a\u00020 2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhoneViewWrapper;", "", "sid", "", "context", "Landroid/content/Context;", "phone", "Landroid/widget/AutoCompleteTextView;", "countryCode", "Landroid/widget/TextView;", "deletePhone", "Landroid/view/View;", "passport_operator_license", "(Ljava/lang/String;Landroid/content/Context;Landroid/widget/AutoCompleteTextView;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/TextView;)V", "activateInfoList", "", "Lcom/xiaomi/accountsdk/account/data/ActivatorPhoneInfo;", "getContext", "()Landroid/content/Context;", "getDeletePhone", "()Landroid/view/View;", "passportRepo", "Lcom/xiaomi/passport/ui/internal/PassportRepo;", "getPassport_operator_license", "()Landroid/widget/TextView;", "getPhone", "()Landroid/widget/AutoCompleteTextView;", "phoneTextWatcher", "Landroid/text/TextWatcher;", "getSid", "()Ljava/lang/String;", "destroy", "", "getPhoneWrapper", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "isInputValid", "", "setPhonePopList", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class ehg {

    /* renamed from: O000000o  reason: collision with root package name */
    TextWatcher f15278O000000o;
    public List<? extends ActivatorPhoneInfo> O00000Oo;
    public final Context O00000o;
    final String O00000o0;
    public final AutoCompleteTextView O00000oO;
    final TextView O00000oo;
    final View O0000O0o;
    final TextView O0000OOo;
    private egr O0000Oo0 = new egs();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.egr.O000000o(android.content.Context, java.lang.String, boolean):_m_j.eib<java.util.List<com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo>>
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.egr.O000000o(com.xiaomi.passport.ui.internal.PhoneWrapper, _m_j.ega, _m_j.eif):_m_j.eib<java.lang.String>
      _m_j.egr.O000000o(android.content.Context, java.lang.String, boolean):_m_j.eib<java.util.List<com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo>> */
    public ehg(String str, Context context, AutoCompleteTextView autoCompleteTextView, TextView textView, View view, TextView textView2) {
        ixe.O00000o0(str, "sid");
        ixe.O00000o0(context, "context");
        ixe.O00000o0(autoCompleteTextView, "phone");
        ixe.O00000o0(textView, "countryCode");
        ixe.O00000o0(view, "deletePhone");
        this.O00000o0 = str;
        this.O00000o = context;
        this.O00000oO = autoCompleteTextView;
        this.O00000oo = textView;
        this.O0000O0o = view;
        this.O0000OOo = textView2;
        egt egt = egt.f15254O000000o;
        if (!egt.O00000oO()) {
            this.O0000Oo0.O000000o(this.O00000o, this.O00000o0, true).O000000o(new PhoneViewWrapper$1(this));
        }
        this.f15278O000000o = new TextWatcher(this) {
            /* class _m_j.ehg.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ ehg f15279O000000o;

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.f15279O000000o = r1;
            }

            public final void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable != null ? editable.toString() : null)) {
                    this.f15279O000000o.O0000O0o.setVisibility(8);
                    TextView textView = this.f15279O000000o.O0000OOo;
                    if (textView != null) {
                        textView.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.f15279O000000o.O0000O0o.setVisibility(0);
            }
        };
        this.O00000oO.addTextChangedListener(this.f15278O000000o);
        this.O0000O0o.setVisibility(8);
        this.O0000O0o.setOnClickListener(new View.OnClickListener(this) {
            /* class _m_j.ehg.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ ehg f15280O000000o;

            {
                this.f15280O000000o = r1;
            }

            public final void onClick(View view) {
                this.f15280O000000o.O00000oO.setEnabled(true);
                this.f15280O000000o.O00000oO.setText("");
            }
        });
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0007¨\u0006\u0012"}, d2 = {"com/xiaomi/passport/ui/internal/PhoneViewWrapper$setPhonePopList$adapter$1", "Landroid/widget/ArrayAdapter;", "", "(Lcom/xiaomi/passport/ui/internal/PhoneViewWrapper;Ljava/util/ArrayList;Landroid/content/Context;ILjava/util/List;)V", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "initView", "", "view", "Landroid/widget/AutoCompleteTextView;", "setFirstItemToView", "setItemToView", "id", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o extends ArrayAdapter<String> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehg f15281O000000o;
        final /* synthetic */ ArrayList O00000Oo;

        /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List, int] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        public O000000o(ehg ehg, ArrayList arrayList, Context context, int r4) {
            super(context, (int) R.layout.phone_list_item, (List) r4);
            this.f15281O000000o = ehg;
            this.O00000Oo = arrayList;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [android.view.View, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        @SuppressLint({"ViewHolder"})
        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = View.inflate(getContext(), R.layout.phone_list_item, null);
            View findViewById = inflate.findViewById(R$id.image_sim_index);
            if (findViewById != null) {
                ImageView imageView = (ImageView) findViewById;
                if (i == 0) {
                    imageView.setImageResource(R.drawable.passport_sim1);
                }
                if (i == 1) {
                    imageView.setImageResource(R.drawable.passport_sim2);
                }
                View findViewById2 = inflate.findViewById(16908308);
                if (findViewById2 != null) {
                    ((TextView) findViewById2).setText((CharSequence) getItem(i));
                    ixe.O000000o((Object) inflate, "view");
                    return inflate;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
        }

        public final void O000000o(AutoCompleteTextView autoCompleteTextView, int i) {
            if (autoCompleteTextView != null) {
                autoCompleteTextView.setText((CharSequence) getItem(i));
            }
            if (autoCompleteTextView != null) {
                autoCompleteTextView.dismissDropDown();
            }
            if (autoCompleteTextView != null) {
                autoCompleteTextView.setEnabled(false);
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "", "id", "", "onItemClick"}, k = 3, mv = {1, 1, 10})
        /* renamed from: _m_j.ehg$O000000o$O000000o  reason: collision with other inner class name */
        public static final class C0102O000000o implements AdapterView.OnItemClickListener {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O000000o f15282O000000o;
            final /* synthetic */ AutoCompleteTextView O00000Oo;

            public C0102O000000o(O000000o o000000o, AutoCompleteTextView autoCompleteTextView) {
                this.f15282O000000o = o000000o;
                this.O00000Oo = autoCompleteTextView;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.f15282O000000o.O000000o(this.O00000Oo, (int) j);
            }
        }
    }
}
