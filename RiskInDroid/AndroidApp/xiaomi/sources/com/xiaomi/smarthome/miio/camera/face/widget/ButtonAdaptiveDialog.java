package com.xiaomi.smarthome.miio.camera.face.widget;

import _m_j.gri;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
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

public class ButtonAdaptiveDialog extends Dialog {
    public Builder builder = null;

    public interface OnNameSelectListener {
        void onNameSelected(String str, boolean z);
    }

    public ButtonAdaptiveDialog(Context context) {
        super(context);
    }

    public ButtonAdaptiveDialog(Context context, int i) {
        super(context, i);
    }

    protected ButtonAdaptiveDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public ButtonAdaptiveDialog(Builder builder2) {
        super(builder2.context);
        this.builder = builder2;
    }

    private int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void}
     arg types: [android.graphics.drawable.ColorDrawable, int, int, int, int]
     candidates:
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float, float, float, float):void}
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void} */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i;
        Button button;
        Button button2;
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this.builder.context).inflate((int) R.layout.adaptive_buttons_message_dialog, (ViewGroup) null);
        Paint paint = new Paint();
        paint.setTextSize((float) dip2px(this.builder.context, 16.0f));
        float measureText = paint.measureText(this.builder.cancleText);
        float measureText2 = paint.measureText(this.builder.confirmText);
        Context context = this.builder.context;
        if (context == null) {
            i = 0;
        } else {
            i = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
        }
        float f = (float) i;
        if (f / measureText < 2.0f || f / measureText2 < 2.0f) {
            inflate.findViewById(R.id.buttons_vertical).setVisibility(0);
            inflate.findViewById(R.id.buttonPanel).setVisibility(8);
            button2 = (Button) inflate.findViewById(R.id.btn_confirm_vertical);
            button = (Button) inflate.findViewById(R.id.btn_cancel_vertical);
        } else {
            inflate.findViewById(R.id.buttons_vertical).setVisibility(8);
            inflate.findViewById(R.id.buttonPanel).setVisibility(0);
            button2 = (Button) inflate.findViewById(R.id.btn_confirm);
            button = (Button) inflate.findViewById(R.id.btn_cancel);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.alertContent);
        ((TextView) inflate.findViewById(R.id.alertTitle)).setText(this.builder.title);
        if (TextUtils.isEmpty(this.builder.content)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(this.builder.content);
        }
        button2.setText(this.builder.confirmText);
        button.setText(this.builder.cancleText);
        button2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.widget.ButtonAdaptiveDialog.AnonymousClass1 */

            public void onClick(View view) {
                ButtonAdaptiveDialog.this.dismiss();
                if (ButtonAdaptiveDialog.this.builder.onConfirmListener != null) {
                    ButtonAdaptiveDialog.this.builder.onConfirmListener.onClick(view);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.widget.ButtonAdaptiveDialog.AnonymousClass2 */

            public void onClick(View view) {
                ButtonAdaptiveDialog.this.dismiss();
                if (ButtonAdaptiveDialog.this.builder.onCancleListener != null) {
                    ButtonAdaptiveDialog.this.builder.onCancleListener.onClick(view);
                }
            }
        });
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        setContentView(inflate);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f)));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public static class Builder {
        public String cancleText;
        public String confirmText;
        public String content;
        public Context context;
        public View.OnClickListener onCancleListener;
        public View.OnClickListener onConfirmListener;
        public String title;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setContent(String str) {
            this.content = str;
            return this;
        }

        public Builder setCancle(String str, View.OnClickListener onClickListener) {
            this.cancleText = str;
            this.onCancleListener = onClickListener;
            return this;
        }

        public Builder setConfirmText(String str, View.OnClickListener onClickListener) {
            this.confirmText = str;
            this.onConfirmListener = onClickListener;
            return this;
        }

        public ButtonAdaptiveDialog build() {
            return new ButtonAdaptiveDialog(this);
        }
    }
}
