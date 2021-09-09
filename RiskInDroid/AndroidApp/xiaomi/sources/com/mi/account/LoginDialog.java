package com.mi.account;

import _m_j.bxq;
import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class LoginDialog extends Dialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f4549O000000o;
    private Context O00000Oo;

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public LoginDialog(Context context) {
        this(context, (byte) 0);
    }

    private LoginDialog(Context context, byte b) {
        super(context, R.style.LoginDialogStyle);
        this.O00000Oo = context;
        setContentView((int) R.layout.dialog_login);
        Window window = getWindow();
        if (window != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, 8.0f, this.O00000Oo.getResources().getDisplayMetrics());
            window.getDecorView().setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        ((TextView) findViewById(R.id.tv_login_dialog_content)).setText(String.format(context.getResources().getString(R.string.autologin_summary), bxq.O000000o().O0000OOo()));
        findViewById(R.id.tv_system_login).setOnClickListener(new View.OnClickListener() {
            /* class com.mi.account.LoginDialog.AnonymousClass1 */

            public final void onClick(View view) {
                if (LoginDialog.this.f4549O000000o != null) {
                    LoginDialog.this.f4549O000000o.O000000o();
                    LoginDialog.this.dismiss();
                }
            }
        });
        findViewById(R.id.tv_login_local).setOnClickListener(new View.OnClickListener() {
            /* class com.mi.account.LoginDialog.AnonymousClass2 */

            public final void onClick(View view) {
                if (LoginDialog.this.f4549O000000o != null) {
                    LoginDialog.this.f4549O000000o.O00000Oo();
                    LoginDialog.this.dismiss();
                }
            }
        });
    }
}
