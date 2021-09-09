package com.mi.global.shop.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public final class EMIAgreementDialog extends Dialog {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4998O000000o;

    public class Builder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private Builder f5000O000000o;
        private View O00000Oo;
        private View O00000o0;

        public Builder_ViewBinding(final Builder builder, View view) {
            this.f5000O000000o = builder;
            builder.tvText = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tvText'", CustomTextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.btn_change_plan, "method 'changePlan'");
            this.O00000Oo = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                /* class com.mi.global.shop.widget.dialog.EMIAgreementDialog.Builder_ViewBinding.AnonymousClass1 */

                public final void doClick(View view) {
                    builder.changePlan();
                }
            });
            View findRequiredView2 = Utils.findRequiredView(view, R.id.btn_agree_continue, "method 'agreeContinue'");
            this.O00000o0 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                /* class com.mi.global.shop.widget.dialog.EMIAgreementDialog.Builder_ViewBinding.AnonymousClass2 */

                public final void doClick(View view) {
                    builder.agreeContinue();
                }
            });
        }

        public void unbind() {
            Builder builder = this.f5000O000000o;
            if (builder != null) {
                this.f5000O000000o = null;
                builder.tvText = null;
                this.O00000Oo.setOnClickListener(null);
                this.O00000Oo = null;
                this.O00000o0.setOnClickListener(null);
                this.O00000o0 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public EMIAgreementDialog(Context context) {
        super(context, R.style.BackgroundLightDialog);
        this.f4998O000000o = context;
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f4999O000000o;
        private Context O00000Oo;
        private O000000o O00000o;
        private EMIAgreementDialog O00000o0;
        @BindView(2131494270)
        CustomTextView tvText;

        public interface O000000o {
            void O00000o0();
        }

        public Builder(Context context, O000000o o000000o) {
            this.O00000Oo = context;
            this.O00000o = o000000o;
        }

        public final EMIAgreementDialog O000000o() {
            this.O00000o0 = new EMIAgreementDialog(this.O00000Oo);
            View inflate = ((LayoutInflater) this.O00000Oo.getSystemService("layout_inflater")).inflate((int) R.layout.shop_emi_agreement_dialog, (ViewGroup) null);
            ButterKnife.bind(this, inflate);
            String str = this.f4999O000000o;
            if (str != null) {
                this.tvText.setText(Html.fromHtml(str));
            }
            this.O00000o0.setCanceledOnTouchOutside(true);
            this.O00000o0.setCancelable(false);
            Rect rect = new Rect();
            ((Activity) this.O00000Oo).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            this.O00000o0.setContentView(inflate, new ViewGroup.LayoutParams(rect.width(), rect.height()));
            return this.O00000o0;
        }

        @OnClick({2131493022})
        public void changePlan() {
            EMIAgreementDialog eMIAgreementDialog = this.O00000o0;
            if (BaseActivity.isActivityAlive(eMIAgreementDialog.f4998O000000o)) {
                eMIAgreementDialog.dismiss();
            }
            Context context = this.O00000Oo;
            if (context instanceof FragmentActivity) {
                ((FragmentActivity) context).getSupportFragmentManager().O00000o0();
            }
        }

        @OnClick({2131493017})
        public void agreeContinue() {
            O000000o o000000o = this.O00000o;
            if (o000000o != null) {
                o000000o.O00000o0();
            }
        }
    }

    public final void O000000o() {
        if (BaseActivity.isActivityAlive(this.f4998O000000o)) {
            show();
        }
    }
}
