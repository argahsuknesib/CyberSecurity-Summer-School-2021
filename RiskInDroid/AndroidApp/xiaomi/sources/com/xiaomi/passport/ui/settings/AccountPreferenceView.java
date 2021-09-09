package com.xiaomi.passport.ui.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;

public class AccountPreferenceView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f6279O000000o;
    private ImageView O00000Oo;
    private View O00000o0;

    public AccountPreferenceView(Context context) {
        super(context);
        O000000o(context, null);
    }

    public AccountPreferenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    public AccountPreferenceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.account_preference_item, this);
        TextView textView = (TextView) inflate.findViewById(16908310);
        this.f6279O000000o = (TextView) inflate.findViewById(R$id.value_right);
        this.O00000Oo = (ImageView) inflate.findViewById(R$id.image_right);
        this.O00000o0 = inflate.findViewById(R$id.arrow_right);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.title});
            String string = obtainStyledAttributes.getString(0);
            if (!TextUtils.isEmpty(string)) {
                textView.setText(string);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setValue(String str) {
        this.f6279O000000o.setVisibility(!TextUtils.isEmpty(str) ? 0 : 8);
        this.f6279O000000o.setText(str);
    }

    public void setRightArrowVisible(boolean z) {
        this.O00000o0.setVisibility(z ? 0 : 4);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.O00000Oo.setVisibility(bitmap != null ? 0 : 8);
        this.O00000Oo.setImageBitmap(bitmap);
    }

    public void setValue(int i) {
        setValue(getContext().getString(i));
    }

    public CharSequence getValue() {
        return this.f6279O000000o.getText();
    }
}
