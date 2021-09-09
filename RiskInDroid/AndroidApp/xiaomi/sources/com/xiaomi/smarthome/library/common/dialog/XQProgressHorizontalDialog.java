package com.xiaomi.smarthome.library.common.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.text.NumberFormat;

public class XQProgressHorizontalDialog extends MLAlertDialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f9117O000000o;
    private Context O00000Oo;
    private TextView O00000o;
    private ProgressBar O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private boolean O0000O0o;
    private CharSequence O0000OOo;
    private NumberFormat O0000Oo;
    private String O0000Oo0;

    public static XQProgressHorizontalDialog O000000o(Context context, CharSequence charSequence) {
        XQProgressHorizontalDialog xQProgressHorizontalDialog = new XQProgressHorizontalDialog(context);
        xQProgressHorizontalDialog.setMessage(charSequence);
        return xQProgressHorizontalDialog;
    }

    public XQProgressHorizontalDialog(Context context) {
        this(context, (byte) 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, int, int, int):void
     arg types: [android.content.Context, int, int, int, int]
     candidates:
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, android.content.DialogInterface$OnCancelListener, int, int):void
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, int, int, int):void */
    private XQProgressHorizontalDialog(Context context, byte b) {
        super(context, true, 2132739282, 80, 0);
        this.O0000O0o = false;
        this.O0000OOo = null;
        this.f9117O000000o = true;
        this.O0000Oo0 = "%1d/%2d";
        this.O0000Oo = NumberFormat.getPercentInstance();
        this.O0000Oo.setMaximumFractionDigits(0);
        this.O00000Oo = context;
        setCancelable(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        View inflate = LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.xq_progress_horizital_dialog, (ViewGroup) null);
        this.O00000o0 = (ProgressBar) inflate.findViewById(R.id.progress);
        this.O00000oO = (TextView) inflate.findViewById(R.id.progress_percent);
        this.O00000o = (TextView) inflate.findViewById(R.id.progress_message);
        this.O00000oo = (TextView) inflate.findViewById(R.id.progress_number);
        if (this.f9117O000000o) {
            this.O00000oo.setVisibility(0);
        } else {
            this.O00000oo.setVisibility(8);
        }
        setView(inflate);
        CharSequence charSequence = this.O0000OOo;
        if (charSequence != null) {
            setMessage(charSequence);
        }
        O000000o(this.O0000O0o);
        super.onCreate(bundle);
    }

    public final void O000000o(int i, int i2) {
        if (this.O00000o0 != null && i >= 0) {
            O000000o(false);
            this.O00000o0.setMax(i);
            this.O00000o0.setProgress(i2);
            NumberFormat numberFormat = this.O0000Oo;
            if (numberFormat != null) {
                double d = (double) i2;
                double d2 = (double) i;
                Double.isNaN(d);
                Double.isNaN(d2);
                this.O00000oO.setText(new SpannableString(numberFormat.format(d / d2)));
            } else {
                this.O00000oO.setText("");
            }
            if (i > 1) {
                TextView textView = this.O00000oo;
                textView.setText((i2 / 1024) + "K/" + (i / 1024) + "K");
                return;
            }
            this.O00000oo.setText("");
        }
    }

    public final void O000000o(boolean z) {
        ProgressBar progressBar = this.O00000o0;
        if (progressBar != null) {
            progressBar.setIndeterminate(z);
            if (z) {
                this.O00000o0.setIndeterminateDrawable(new ColorDrawable() {
                    /* class com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    Paint f9118O000000o = new Paint();
                    RectF O00000Oo = new RectF();

                    public final void draw(Canvas canvas) {
                        this.f9118O000000o.setColor(getColor());
                        Rect bounds = getBounds();
                        float height = ((float) bounds.height()) * 0.15f;
                        this.O00000Oo.top = ((float) bounds.top) + height;
                        this.O00000Oo.bottom = ((float) bounds.bottom) - height;
                        float width = (float) bounds.width();
                        float abs = (0.4f * width) + (0.6f * width * Math.abs((((float) (System.currentTimeMillis() % 1700)) / 1700.0f) - 0.5f));
                        RectF rectF = this.O00000Oo;
                        float currentTimeMillis = width * (((float) (System.currentTimeMillis() % 1000)) / 1000.0f);
                        rectF.left = ((float) bounds.left) + currentTimeMillis;
                        this.O00000Oo.right = ((float) bounds.left) + abs + currentTimeMillis;
                        RectF rectF2 = this.O00000Oo;
                        canvas.drawRoundRect(rectF2, rectF2.height(), this.O00000Oo.height(), this.f9118O000000o);
                        if (((float) bounds.right) < this.O00000Oo.right) {
                            this.O00000Oo.right -= (float) bounds.right;
                            RectF rectF3 = this.O00000Oo;
                            rectF3.left = -rectF3.height();
                            RectF rectF4 = this.O00000Oo;
                            canvas.drawRoundRect(rectF4, rectF4.height(), this.O00000Oo.height(), this.f9118O000000o);
                        }
                    }
                });
                return;
            }
            return;
        }
        this.O0000O0o = z;
    }

    public void setMessage(CharSequence charSequence) {
        TextView textView = this.O00000o;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.O0000OOo = charSequence;
        }
    }
}
