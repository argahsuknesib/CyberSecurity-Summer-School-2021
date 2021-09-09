package com.mi.global.shop.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomEditTextView;
import com.xiaomi.smarthome.R;

public class WebViewDebugDialog extends Dialog {

    public class Builder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private Builder f5021O000000o;

        public Builder_ViewBinding(Builder builder, View view) {
            this.f5021O000000o = builder;
            builder.etUrl = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.et_url, "field 'etUrl'", CustomEditTextView.class);
            builder.etCookie = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.et_cookie, "field 'etCookie'", CustomEditTextView.class);
            builder.btnSubmit = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_submit, "field 'btnSubmit'", CustomButtonView.class);
        }

        public void unbind() {
            Builder builder = this.f5021O000000o;
            if (builder != null) {
                this.f5021O000000o = null;
                builder.etUrl = null;
                builder.etCookie = null;
                builder.btnSubmit = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public WebViewDebugDialog(Context context) {
        super(context);
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f5020O000000o;
        @BindView(2131493038)
        CustomButtonView btnSubmit;
        @BindView(2131493321)
        CustomEditTextView etCookie;
        @BindView(2131493326)
        CustomEditTextView etUrl;

        public Builder(Context context) {
            this.f5020O000000o = context;
        }
    }
}
