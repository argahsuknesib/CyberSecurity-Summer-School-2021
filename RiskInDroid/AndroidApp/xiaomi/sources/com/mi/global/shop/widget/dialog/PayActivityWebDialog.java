package com.mi.global.shop.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class PayActivityWebDialog extends Dialog {

    public class Builder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private Builder f5011O000000o;

        public Builder_ViewBinding(Builder builder, View view) {
            this.f5011O000000o = builder;
            builder.ivClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close, "field 'ivClose'", ImageView.class);
            builder.ivActivityImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.iv_activity_image, "field 'ivActivityImage'", SimpleDraweeView.class);
        }

        public void unbind() {
            Builder builder = this.f5011O000000o;
            if (builder != null) {
                this.f5011O000000o = null;
                builder.ivClose = null;
                builder.ivActivityImage = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public PayActivityWebDialog(Context context) {
        super(context);
    }

    public PayActivityWebDialog(Context context, byte b) {
        super(context, R.style.Dialog);
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f5009O000000o;
        public String O00000Oo;
        @BindView(2131493530)
        public SimpleDraweeView ivActivityImage;
        @BindView(2131493536)
        public ImageView ivClose;

        public Builder(Context context) {
            this.f5009O000000o = context;
        }
    }
}
