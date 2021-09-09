package com.mi.global.shop.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomButtonView;
import com.xiaomi.smarthome.R;

public class ReviewSubmitCancelDialog extends Dialog {

    public class Builder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private Builder f5015O000000o;

        public Builder_ViewBinding(Builder builder, View view) {
            this.f5015O000000o = builder;
            builder.btnCancel = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_cancel, "field 'btnCancel'", CustomButtonView.class);
            builder.btnLeave = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_leave, "field 'btnLeave'", CustomButtonView.class);
        }

        public void unbind() {
            Builder builder = this.f5015O000000o;
            if (builder != null) {
                this.f5015O000000o = null;
                builder.btnCancel = null;
                builder.btnLeave = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ReviewSubmitCancelDialog(Context context) {
        super(context);
    }

    public ReviewSubmitCancelDialog(Context context, byte b) {
        super(context, R.style.Dialog);
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f5012O000000o;
        public DialogInterface.OnClickListener O00000Oo;
        @BindView(2131493021)
        public CustomButtonView btnCancel;
        @BindView(2131493030)
        public CustomButtonView btnLeave;

        public Builder(Context context) {
            this.f5012O000000o = context;
        }
    }
}
