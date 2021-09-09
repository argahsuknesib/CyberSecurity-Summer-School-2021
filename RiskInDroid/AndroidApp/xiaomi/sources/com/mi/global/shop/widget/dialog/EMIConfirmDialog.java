package com.mi.global.shop.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class EMIConfirmDialog extends Dialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f5003O000000o;

    public class Builder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private Builder f5008O000000o;

        public Builder_ViewBinding(Builder builder, View view) {
            this.f5008O000000o = builder;
            builder.tvTitle = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", CustomTextView.class);
            builder.tvContent = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'tvContent'", CustomTextView.class);
            builder.btnNo = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_no, "field 'btnNo'", CustomButtonView.class);
            builder.btnYes = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_yes, "field 'btnYes'", CustomButtonView.class);
        }

        public void unbind() {
            Builder builder = this.f5008O000000o;
            if (builder != null) {
                this.f5008O000000o = null;
                builder.tvTitle = null;
                builder.tvContent = null;
                builder.btnNo = null;
                builder.btnYes = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public EMIConfirmDialog(Context context) {
        super(context);
    }

    public EMIConfirmDialog(Context context, byte b) {
        super(context, R.style.Dialog);
        this.f5003O000000o = context;
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f5004O000000o;
        public boolean O00000Oo = true;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public DialogInterface.OnClickListener O0000O0o;
        public DialogInterface.OnClickListener O0000OOo;
        @BindView(2131493033)
        public CustomButtonView btnNo;
        @BindView(2131493042)
        public CustomButtonView btnYes;
        @BindView(2131494190)
        public CustomTextView tvContent;
        @BindView(2131494276)
        public CustomTextView tvTitle;

        public Builder(Context context) {
            this.f5004O000000o = context;
        }
    }
}
