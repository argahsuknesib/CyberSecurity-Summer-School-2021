package com.mi.global.shop.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class CustomTextDialog extends Dialog {

    public class Builder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private Builder f4994O000000o;

        public Builder_ViewBinding(Builder builder, View view) {
            this.f4994O000000o = builder;
            builder.tvText = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tvText'", CustomTextView.class);
        }

        public void unbind() {
            Builder builder = this.f4994O000000o;
            if (builder != null) {
                this.f4994O000000o = null;
                builder.tvText = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public CustomTextDialog(Context context) {
        super(context);
    }

    public CustomTextDialog(Context context, byte b) {
        super(context, R.style.Dialog);
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f4993O000000o;
        public String O00000Oo;
        @BindView(2131494270)
        public CustomTextView tvText;

        public Builder(Context context) {
            this.f4993O000000o = context;
        }
    }
}
