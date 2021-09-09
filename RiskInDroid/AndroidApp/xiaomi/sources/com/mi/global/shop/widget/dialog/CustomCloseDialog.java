package com.mi.global.shop.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class CustomCloseDialog extends Dialog {

    public class Builder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private Builder f4991O000000o;

        public Builder_ViewBinding(Builder builder, View view) {
            this.f4991O000000o = builder;
            builder.tvTitle = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", CustomTextView.class);
            builder.tvContent = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'tvContent'", CustomTextView.class);
            builder.btnGotIt = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_got_it, "field 'btnGotIt'", CustomButtonView.class);
            builder.btnClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_close, "field 'btnClose'", ImageView.class);
            builder.llBottom = Utils.findRequiredView(view, R.id.ll_bootom, "field 'llBottom'");
        }

        public void unbind() {
            Builder builder = this.f4991O000000o;
            if (builder != null) {
                this.f4991O000000o = null;
                builder.tvTitle = null;
                builder.tvContent = null;
                builder.btnGotIt = null;
                builder.btnClose = null;
                builder.llBottom = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public CustomCloseDialog(Context context) {
        super(context);
    }

    public CustomCloseDialog(Context context, byte b) {
        super(context, R.style.Dialog);
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f4987O000000o;
        public String O00000Oo;
        private Context O00000o;
        public DialogInterface.OnClickListener O00000o0;
        private boolean O00000oO = true;
        private boolean O00000oo = true;
        private String O0000O0o;
        @BindView(2131493023)
        ImageView btnClose;
        @BindView(2131493027)
        CustomButtonView btnGotIt;
        @BindView(2131493665)
        View llBottom;
        @BindView(2131494190)
        CustomTextView tvContent;
        @BindView(2131494276)
        CustomTextView tvTitle;

        public Builder(Context context) {
            this.O00000o = context;
        }

        public final Builder O000000o(Boolean bool) {
            this.O00000oO = bool.booleanValue();
            return this;
        }

        public final Builder O00000Oo(Boolean bool) {
            this.O00000oo = bool.booleanValue();
            return this;
        }

        public final CustomCloseDialog O000000o() {
            final CustomCloseDialog customCloseDialog = new CustomCloseDialog(this.O00000o, (byte) 0);
            View inflate = ((LayoutInflater) this.O00000o.getSystemService("layout_inflater")).inflate((int) R.layout.shop_custom_close_dialog, (ViewGroup) null);
            ButterKnife.bind(this, inflate);
            customCloseDialog.setCanceledOnTouchOutside(this.O00000oO);
            if (!TextUtils.isEmpty(this.f4987O000000o)) {
                this.tvTitle.setText(this.f4987O000000o);
            } else {
                this.tvTitle.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.O00000Oo)) {
                this.tvContent.setText(this.O00000Oo);
            }
            String str = this.O0000O0o;
            if (str != null) {
                this.btnGotIt.setText(str);
            }
            if (!this.O00000oo) {
                this.llBottom.setVisibility(8);
            }
            this.btnGotIt.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.widget.dialog.CustomCloseDialog.Builder.AnonymousClass1 */

                public final void onClick(View view) {
                    customCloseDialog.dismiss();
                }
            });
            this.btnClose.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.widget.dialog.CustomCloseDialog.Builder.AnonymousClass2 */

                public final void onClick(View view) {
                    customCloseDialog.dismiss();
                }
            });
            if (this.O00000o0 != null) {
                this.btnGotIt.setOnClickListener(new View.OnClickListener() {
                    /* class com.mi.global.shop.widget.dialog.CustomCloseDialog.Builder.AnonymousClass3 */

                    public final void onClick(View view) {
                        Builder.this.O00000o0.onClick(customCloseDialog, -1);
                        customCloseDialog.dismiss();
                    }
                });
            }
            customCloseDialog.setContentView(inflate);
            return customCloseDialog;
        }
    }
}
