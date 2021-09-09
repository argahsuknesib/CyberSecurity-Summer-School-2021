package com.xiaomi.passport.ui.view;

import _m_j.ekf;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.data.PhoneAccount;
import com.xiaomi.smarthome.R;
import java.io.File;

public class PhoneAccountCard extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public PhoneAccount f6333O000000o;
    public O000000o O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    private ImageView O00000oO;
    private Button O00000oo;
    private boolean O0000O0o;
    private int O0000OOo = R.drawable.passport_ic_user_avatar_sim;
    private boolean O0000Oo0 = true;

    public interface O000000o {
        void O000000o(PhoneAccount phoneAccount);

        void O00000Oo(PhoneAccount phoneAccount);
    }

    public PhoneAccountCard(Context context) {
        super(context);
        O000000o(context, (AttributeSet) null);
    }

    public PhoneAccountCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    public PhoneAccountCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        boolean z = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.card_mode}, 0, 0);
        if (obtainStyledAttributes.getInt(0, 0) != 0) {
            z = false;
        }
        this.O0000O0o = z;
        obtainStyledAttributes.recycle();
        if (this.O0000O0o) {
            LayoutInflater.from(context).inflate((int) R.layout.passport_layout_phone_account_card_big, this);
        } else {
            LayoutInflater.from(context).inflate((int) R.layout.passport_layout_phone_account_card_small, this);
        }
        this.O00000o0 = (TextView) findViewById(R$id.tv_phone_number);
        this.O00000o = (TextView) findViewById(R$id.tv_user_name);
        this.O00000oO = (ImageView) findViewById(R$id.iv_user_avatar);
        this.O00000oo = (Button) findViewById(R$id.btn_login_register);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.passport.ui.view.PhoneAccountCard.AnonymousClass1 */

            public final void onClick(View view) {
                if (PhoneAccountCard.this.O00000Oo != null) {
                    if (PhoneAccountCard.this.f6333O000000o.O00000Oo()) {
                        PhoneAccountCard.this.O00000Oo.O000000o(PhoneAccountCard.this.f6333O000000o);
                    } else {
                        PhoneAccountCard.this.O00000Oo.O00000Oo(PhoneAccountCard.this.f6333O000000o);
                    }
                }
            }
        });
    }

    public final void O000000o(PhoneAccount phoneAccount) {
        String str;
        this.f6333O000000o = phoneAccount;
        if (phoneAccount.O00000o0()) {
            Bitmap O000000o2 = O000000o(getContext(), phoneAccount.O00000Oo.avatarAddress);
            if (O000000o2 == null) {
                this.O00000oO.setImageResource(R.drawable.passport_ic_user_avatar_default);
            } else {
                this.O00000oO.setImageBitmap(O000000o2);
            }
        } else {
            this.O00000oO.setImageResource(this.O0000OOo);
        }
        if (!this.O0000Oo0) {
            this.O00000o.setVisibility(8);
        } else if (phoneAccount.O00000o0()) {
            this.O00000o.setVisibility(0);
            String str2 = phoneAccount.O00000Oo.userName;
            if (TextUtils.isEmpty(str2)) {
                str2 = phoneAccount.O00000Oo.maskedUserId;
            }
            this.O00000o.setText(str2);
        } else if (this.O0000O0o) {
            this.O00000o.setVisibility(8);
        } else {
            this.O00000o.setVisibility(0);
            this.O00000o.setText((int) R.string.user_name_phone_number);
        }
        this.O00000o0.setText(phoneAccount.O00000Oo.phone);
        if (phoneAccount.O000000o()) {
            str = getContext().getString(this.O0000O0o ? R.string.register_by_local_phone_long_text : R.string.register_by_local_phone_short_text);
        } else {
            str = getContext().getString(this.O0000O0o ? R.string.login_by_local_phone_long_text : R.string.login_by_local_phone_short_text);
        }
        this.O00000oo.setText(str);
    }

    private static Bitmap O000000o(Context context, String str) {
        File O00000Oo2 = ekf.O00000Oo(context, str);
        if (O00000Oo2 == null || !O00000Oo2.isFile() || !O00000Oo2.exists()) {
            return null;
        }
        return BitmapFactory.decodeFile(O00000Oo2.getAbsolutePath());
    }

    public void setUserAvatarPlaceholder(int i) {
        this.O0000OOo = i;
    }

    public void setCustomUserNameVisible(boolean z) {
        this.O0000Oo0 = z;
    }

    public void setOnActionListener(O000000o o000000o) {
        this.O00000Oo = o000000o;
    }
}
