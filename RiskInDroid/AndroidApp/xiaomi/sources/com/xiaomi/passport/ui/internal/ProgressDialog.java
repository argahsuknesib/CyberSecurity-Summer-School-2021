package com.xiaomi.passport.ui.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;
import java.text.NumberFormat;

public class ProgressDialog extends AlertDialog {
    public ProgressBar O00000Oo;
    public CharSequence O00000o;
    public NumberFormat O00000o0 = NumberFormat.getPercentInstance();
    private TextView O00000oO;
    private int O00000oo = 0;
    private String O0000O0o = "%1d/%2d";
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private Handler O0000o;
    private Drawable O0000o0;
    private Drawable O0000o00;
    private boolean O0000o0O;
    private boolean O0000o0o;

    public ProgressDialog(Context context) {
        super(context);
        this.O00000o0.setMaximumFractionDigits(0);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        View view;
        LayoutInflater from = LayoutInflater.from(getContext());
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, new int[]{R.attr.passport_horizontalProgressLayout, R.attr.passport_layout, R.attr.passport_progressLayout}, 16842845, 0);
        if (this.O00000oo == 1) {
            this.O0000o = new Handler() {
                /* class com.xiaomi.passport.ui.internal.ProgressDialog.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    super.handleMessage(message);
                    int progress = ProgressDialog.this.O00000Oo.getProgress();
                    int max = ProgressDialog.this.O00000Oo.getMax();
                    if (ProgressDialog.this.O00000o0 != null) {
                        double d = (double) progress;
                        double d2 = (double) max;
                        Double.isNaN(d);
                        Double.isNaN(d2);
                        double d3 = d / d2;
                        int i = 0;
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        if (!TextUtils.isEmpty(ProgressDialog.this.O00000o)) {
                            i = ProgressDialog.this.O00000o.length();
                            spannableStringBuilder.append(ProgressDialog.this.O00000o);
                        }
                        String format = ProgressDialog.this.O00000o0.format(d3);
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(ProgressDialog.this.getContext().getResources().getColor(R.color.passport_progress_percent_color)), i, format.length() + i, 34);
                        ProgressDialog.this.O000000o(spannableStringBuilder);
                    }
                }
            };
            view = from.inflate(obtainStyledAttributes.getResourceId(0, R.layout.passport_alert_dialog_progress), (ViewGroup) null);
        } else {
            view = from.inflate(obtainStyledAttributes.getResourceId(2, R.layout.passport_progress_dialog), (ViewGroup) null);
        }
        this.O00000Oo = (ProgressBar) view.findViewById(16908301);
        this.O00000oO = (TextView) view.findViewById(R$id.message);
        this.f6229O000000o.O00000Oo(view);
        obtainStyledAttributes.recycle();
        int i = this.O0000OOo;
        if (i > 0) {
            ProgressBar progressBar = this.O00000Oo;
            if (progressBar != null) {
                progressBar.setMax(i);
                O000000o();
            } else {
                this.O0000OOo = i;
            }
        }
        int i2 = this.O0000Oo0;
        if (i2 > 0) {
            if (this.O0000o0o) {
                this.O00000Oo.setProgress(i2);
                O000000o();
            } else {
                this.O0000Oo0 = i2;
            }
        }
        int i3 = this.O0000Oo;
        if (i3 > 0) {
            ProgressBar progressBar2 = this.O00000Oo;
            if (progressBar2 != null) {
                progressBar2.setSecondaryProgress(i3);
                O000000o();
            } else {
                this.O0000Oo = i3;
            }
        }
        int i4 = this.O0000OoO;
        if (i4 > 0) {
            ProgressBar progressBar3 = this.O00000Oo;
            if (progressBar3 != null) {
                progressBar3.incrementProgressBy(i4);
                O000000o();
            } else {
                this.O0000OoO = i4 + i4;
            }
        }
        int i5 = this.O0000Ooo;
        if (i5 > 0) {
            ProgressBar progressBar4 = this.O00000Oo;
            if (progressBar4 != null) {
                progressBar4.incrementSecondaryProgressBy(i5);
                O000000o();
            } else {
                this.O0000Ooo = i5 + i5;
            }
        }
        Drawable drawable = this.O0000o00;
        if (drawable != null) {
            ProgressBar progressBar5 = this.O00000Oo;
            if (progressBar5 != null) {
                progressBar5.setProgressDrawable(drawable);
            } else {
                this.O0000o00 = drawable;
            }
        }
        Drawable drawable2 = this.O0000o0;
        if (drawable2 != null) {
            ProgressBar progressBar6 = this.O00000Oo;
            if (progressBar6 != null) {
                progressBar6.setIndeterminateDrawable(drawable2);
            } else {
                this.O0000o0 = drawable2;
            }
        }
        CharSequence charSequence = this.O00000o;
        if (charSequence != null) {
            O000000o(charSequence);
        }
        O000000o(this.O0000o0O);
        O000000o();
        super.onCreate(bundle);
    }

    public void onStart() {
        super.onStart();
        this.O0000o0o = true;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.O0000o0o = false;
    }

    private void O000000o(boolean z) {
        ProgressBar progressBar = this.O00000Oo;
        if (progressBar != null) {
            progressBar.setIndeterminate(z);
        } else {
            this.O0000o0O = z;
        }
    }

    public final void O000000o(CharSequence charSequence) {
        if (this.O00000Oo != null) {
            if (this.O00000oo == 1) {
                this.O00000o = charSequence;
            }
            this.O00000oO.setText(charSequence);
            return;
        }
        this.O00000o = charSequence;
    }

    private void O000000o() {
        Handler handler;
        if (this.O00000oo == 1 && (handler = this.O0000o) != null && !handler.hasMessages(0)) {
            this.O0000o.sendEmptyMessage(0);
        }
    }

    public static ProgressDialog O000000o(Context context, CharSequence charSequence, CharSequence charSequence2) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(charSequence);
        progressDialog.O000000o(charSequence2);
        progressDialog.O000000o(true);
        progressDialog.setCancelable(true);
        progressDialog.setOnCancelListener(null);
        progressDialog.show();
        return progressDialog;
    }
}
