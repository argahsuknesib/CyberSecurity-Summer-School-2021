package com.xiaomi.passport.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;

public class LoadingDialog extends Dialog {

    /* renamed from: O000000o  reason: collision with root package name */
    private CharSequence f6332O000000o;

    public LoadingDialog(Context context) {
        super(context, 2132738514);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
     arg types: [?, android.util.TypedValue, int]
     candidates:
      ClspMth{android.content.res.Resources.getValue(java.lang.String, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
      ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException} */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.passport_layout_loading_dialog);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        TypedValue typedValue = new TypedValue();
        getContext().getResources().getValue((int) R.dimen.passport_loading_dialog_bg_alpha, typedValue, true);
        attributes.dimAmount = typedValue.getFloat();
        getWindow().setAttributes(attributes);
        getWindow().addFlags(2);
        ((TextView) findViewById(R$id.tv_loading)).setText(this.f6332O000000o);
    }

    public final void O000000o(int i) {
        O000000o(getContext().getString(i));
    }

    public final void O000000o(CharSequence charSequence) {
        this.f6332O000000o = charSequence;
        show();
    }
}
