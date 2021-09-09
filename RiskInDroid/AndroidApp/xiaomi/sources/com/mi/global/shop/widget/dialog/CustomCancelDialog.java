package com.mi.global.shop.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class CustomCancelDialog extends Dialog {

    public class Builder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private Builder f4986O000000o;

        public Builder_ViewBinding(Builder builder, View view) {
            this.f4986O000000o = builder;
            builder.tvTitle = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", CustomTextView.class);
            builder.tvContent = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'tvContent'", CustomTextView.class);
            builder.btnNo = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_no, "field 'btnNo'", CustomButtonView.class);
            builder.btnYes = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_yes, "field 'btnYes'", CustomButtonView.class);
        }

        public void unbind() {
            Builder builder = this.f4986O000000o;
            if (builder != null) {
                this.f4986O000000o = null;
                builder.tvTitle = null;
                builder.tvContent = null;
                builder.btnNo = null;
                builder.btnYes = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public CustomCancelDialog(Context context) {
        super(context);
    }

    public CustomCancelDialog(Context context, byte b) {
        super(context, R.style.Dialog);
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f4982O000000o;
        public String O00000Oo;
        public DialogInterface.OnClickListener O00000o;
        public DialogInterface.OnClickListener O00000o0;
        private Context O00000oO;
        private boolean O00000oo = true;
        private String O0000O0o;
        private String O0000OOo;
        private int O0000Oo = 0;
        private int O0000Oo0 = 0;
        @BindView(2131493033)
        CustomButtonView btnNo;
        @BindView(2131493042)
        CustomButtonView btnYes;
        @BindView(2131494190)
        CustomTextView tvContent;
        @BindView(2131494276)
        CustomTextView tvTitle;

        public Builder(Context context) {
            this.O00000oO = context;
        }

        public final Builder O000000o(String str, DialogInterface.OnClickListener onClickListener) {
            this.O0000OOo = str;
            this.O00000o0 = onClickListener;
            return this;
        }

        public final Builder O000000o(String str) {
            this.O0000O0o = str;
            this.O00000o = null;
            return this;
        }

        public final Builder O000000o(Boolean bool) {
            this.O00000oo = bool.booleanValue();
            return this;
        }

        public final CustomCancelDialog O000000o() {
            final CustomCancelDialog customCancelDialog = new CustomCancelDialog(this.O00000oO, (byte) 0);
            View inflate = ((LayoutInflater) this.O00000oO.getSystemService("layout_inflater")).inflate((int) R.layout.shop_custom_cancel_dialog, (ViewGroup) null);
            ButterKnife.bind(this, inflate);
            customCancelDialog.setCanceledOnTouchOutside(this.O00000oo);
            if (TextUtils.isEmpty(this.f4982O000000o)) {
                this.tvTitle.setVisibility(8);
            } else {
                this.tvTitle.setVisibility(0);
                this.tvTitle.setText(this.f4982O000000o);
                this.tvTitle.setGravity(this.O0000Oo0);
            }
            if (TextUtils.isEmpty(this.O00000Oo)) {
                this.tvContent.setVisibility(8);
            } else {
                this.tvContent.setVisibility(0);
                this.tvContent.setText(this.O00000Oo);
                this.tvContent.setGravity(this.O0000Oo);
            }
            String str = this.O0000O0o;
            if (str != null) {
                this.btnNo.setText(str);
            }
            String str2 = this.O0000OOo;
            if (str2 != null) {
                this.btnYes.setText(str2);
            }
            this.btnNo.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.widget.dialog.CustomCancelDialog.Builder.AnonymousClass1 */

                public final void onClick(View view) {
                    customCancelDialog.dismiss();
                }
            });
            if (this.O00000o0 != null) {
                this.btnYes.setOnClickListener(new View.OnClickListener() {
                    /* class com.mi.global.shop.widget.dialog.CustomCancelDialog.Builder.AnonymousClass2 */

                    public final void onClick(View view) {
                        Builder.this.O00000o0.onClick(customCancelDialog, -1);
                        customCancelDialog.dismiss();
                    }
                });
            }
            if (this.O00000o != null) {
                this.btnNo.setOnClickListener(new View.OnClickListener() {
                    /* class com.mi.global.shop.widget.dialog.CustomCancelDialog.Builder.AnonymousClass3 */

                    public final void onClick(View view) {
                        Builder.this.O00000o.onClick(customCancelDialog, -2);
                    }
                });
            }
            customCancelDialog.setContentView(inflate);
            return customCancelDialog;
        }
    }
}
