package com.xiaomi.smarthome.library.common.dialog;

import _m_j.gri;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public final class AlwaysDeniedPermissionDialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f9077O000000o;
    public String O00000Oo;
    public View.OnClickListener O00000o;
    public Context O00000o0;
    public View.OnClickListener O00000oO;
    public View O00000oo;
    public O000000o O0000O0o;

    public class O000000o extends Dialog {
        public O000000o(Context context) {
            super(context);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void}
         arg types: [android.graphics.drawable.ColorDrawable, int, int, int, int]
         candidates:
          ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float, float, float, float):void}
          ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void} */
        /* access modifiers changed from: protected */
        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            AlwaysDeniedPermissionDialog alwaysDeniedPermissionDialog = AlwaysDeniedPermissionDialog.this;
            alwaysDeniedPermissionDialog.O00000oo = LayoutInflater.from(alwaysDeniedPermissionDialog.O00000o0.getApplicationContext()).inflate((int) R.layout.dialog_user_permission_denied, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            layoutParams.setMargins(gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f));
            AlwaysDeniedPermissionDialog.this.O00000oo.setLayoutParams(layoutParams);
            AlwaysDeniedPermissionDialog alwaysDeniedPermissionDialog2 = AlwaysDeniedPermissionDialog.this;
            TextView textView = (TextView) alwaysDeniedPermissionDialog2.O00000oo.findViewById(R.id.dialog_title);
            if (!TextUtils.isEmpty(alwaysDeniedPermissionDialog2.f9077O000000o)) {
                textView.setText(alwaysDeniedPermissionDialog2.f9077O000000o);
            }
            if (!TextUtils.isEmpty(alwaysDeniedPermissionDialog2.O00000Oo)) {
                ((TextView) alwaysDeniedPermissionDialog2.O00000oo.findViewById(R.id.dialog_content)).setText(alwaysDeniedPermissionDialog2.O00000Oo);
            }
            Button button = (Button) alwaysDeniedPermissionDialog2.O00000oo.findViewById(R.id.cancel);
            Button button2 = (Button) alwaysDeniedPermissionDialog2.O00000oo.findViewById(R.id.agree);
            button.setOnClickListener(new View.OnClickListener(button) {
                /* class com.xiaomi.smarthome.library.common.dialog.AlwaysDeniedPermissionDialog.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Button f9078O000000o;

                {
                    this.f9078O000000o = r2;
                }

                public final void onClick(View view) {
                    AlwaysDeniedPermissionDialog.this.O0000O0o.dismiss();
                    if (AlwaysDeniedPermissionDialog.this.O00000oO != null) {
                        AlwaysDeniedPermissionDialog.this.O00000oO.onClick(this.f9078O000000o);
                    }
                }
            });
            button2.setOnClickListener(new View.OnClickListener(button2) {
                /* class com.xiaomi.smarthome.library.common.dialog.AlwaysDeniedPermissionDialog.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Button f9079O000000o;

                {
                    this.f9079O000000o = r2;
                }

                public final void onClick(View view) {
                    AlwaysDeniedPermissionDialog.this.O0000O0o.dismiss();
                    if (AlwaysDeniedPermissionDialog.this.O00000o != null) {
                        AlwaysDeniedPermissionDialog.this.O00000o.onClick(this.f9079O000000o);
                    }
                }
            });
            setContentView(AlwaysDeniedPermissionDialog.this.O00000oo);
            Window window = getWindow();
            if (window != null) {
                View findViewById = findViewById(16908310);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                window.setGravity(80);
                window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f)));
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
            }
        }
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f9080O000000o;
        public String O00000Oo;
        public View.OnClickListener O00000o;
        public Context O00000o0;
        public View.OnClickListener O00000oO;

        public Builder(Context context) {
            this.O00000o0 = context;
        }
    }
}
