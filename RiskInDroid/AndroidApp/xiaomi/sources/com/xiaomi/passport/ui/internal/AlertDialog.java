package com.xiaomi.passport.ui.internal;

import _m_j.efq;
import _m_j.eio;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.xiaomi.passport.ui.AlertControllerWrapper;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class AlertDialog extends Dialog implements DialogInterface {

    /* renamed from: O000000o  reason: collision with root package name */
    public AlertControllerWrapper f6229O000000o;

    protected AlertDialog(Context context) {
        this(context, O000000o(context, 0));
    }

    protected AlertDialog(Context context, int i) {
        super(context, O000000o(context, i));
        this.f6229O000000o = new AlertControllerWrapper(context, this, getWindow());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        efq efq = this.f6229O000000o.f6212O000000o;
        boolean z2 = true;
        efq.O00000Oo.requestFeature(1);
        if (efq.O0000Oo0 == null || !efq.O000000o(efq.O0000Oo0)) {
            efq.O00000Oo.setFlags(131072, 131072);
        }
        efq.O00000Oo.setContentView(efq.f15225O000000o);
        if (!eio.O00000o0) {
            efq.O00000Oo.setGravity(80);
            efq.O00000Oo.setLayout(-1, -2);
        }
        efq.O00000o0 = (ViewGroup) efq.O00000Oo.findViewById(R$id.parentPanel);
        ViewGroup viewGroup = (ViewGroup) efq.O00000o0.findViewById(R$id.topPanel);
        if (efq.O0000OOo != null) {
            viewGroup.addView(efq.O0000OOo, 0, new LinearLayout.LayoutParams(-1, -2));
            int dimensionPixelSize = efq.O0000ooO.getResources().getDimensionPixelSize(R.dimen.passport_dialog_title_vertical_padding);
            if (efq.O0000OOo.getPaddingTop() != 0) {
                dimensionPixelSize = efq.O0000OOo.getPaddingTop();
            }
            int dimensionPixelSize2 = efq.O0000ooO.getResources().getDimensionPixelSize(R.dimen.passport_dialog_title_horizontal_padding);
            if (Build.VERSION.SDK_INT >= 17) {
                int paddingStart = efq.O0000OOo.getPaddingStart() != 0 ? efq.O0000OOo.getPaddingStart() : dimensionPixelSize2;
                if (efq.O0000OOo.getPaddingEnd() != 0) {
                    dimensionPixelSize2 = efq.O0000OOo.getPaddingEnd();
                }
                efq.O0000OOo.setPaddingRelative(paddingStart, dimensionPixelSize, dimensionPixelSize2, 0);
            } else {
                int paddingLeft = efq.O0000OOo.getPaddingLeft() != 0 ? efq.O0000OOo.getPaddingLeft() : dimensionPixelSize2;
                if (efq.O0000OOo.getPaddingRight() != 0) {
                    dimensionPixelSize2 = efq.O0000OOo.getPaddingRight();
                }
                efq.O0000OOo.setPadding(paddingLeft, dimensionPixelSize, dimensionPixelSize2, 0);
            }
            viewGroup.removeView(efq.O00000o0.findViewById(R$id.alertTitle));
        } else if (!TextUtils.isEmpty(efq.O00000o)) {
            efq.O00000oo = (TextView) viewGroup.findViewById(R$id.alertTitle);
            efq.O00000oo.setText(efq.O00000o);
        } else {
            viewGroup.setVisibility(8);
        }
        ViewGroup viewGroup2 = (ViewGroup) efq.O00000o0.findViewById(R$id.contentPanel);
        efq.O0000oo0 = (ScrollView) efq.O00000o0.findViewById(R$id.scrollView);
        efq.O0000oo0.setFocusable(false);
        efq.O0000O0o = (TextView) efq.O00000o0.findViewById(R$id.message);
        if (efq.O0000O0o != null) {
            if (efq.O00000oO != null) {
                efq.O0000O0o.setText(efq.O00000oO);
            } else {
                efq.O0000O0o.setVisibility(8);
                efq.O0000oo0.removeView(efq.O0000O0o);
                viewGroup2.setVisibility(8);
            }
        }
        FrameLayout frameLayout = (FrameLayout) efq.O00000o0.findViewById(R$id.customPanel);
        if (efq.O0000Oo0 != null) {
            ((FrameLayout) efq.O00000o0.findViewById(16908331)).addView(efq.O0000Oo0, new ViewGroup.LayoutParams(-1, -1));
            if (efq.O0000Oo0 instanceof ViewGroup) {
                ViewGroup viewGroup3 = (ViewGroup) efq.O0000Oo0;
                int dimensionPixelSize3 = efq.O0000ooO.getResources().getDimensionPixelSize(R.dimen.passport_dialog_custom_vertical_padding);
                if (viewGroup3.getPaddingTop() != 0) {
                    dimensionPixelSize3 = viewGroup3.getPaddingTop();
                }
                int dimensionPixelSize4 = efq.O0000ooO.getResources().getDimensionPixelSize(R.dimen.passport_dialog_custom_horizontal_padding);
                if (Build.VERSION.SDK_INT >= 17) {
                    int paddingStart2 = viewGroup3.getPaddingStart() != 0 ? viewGroup3.getPaddingStart() : dimensionPixelSize4;
                    if (viewGroup3.getPaddingEnd() != 0) {
                        dimensionPixelSize4 = viewGroup3.getPaddingEnd();
                    }
                    viewGroup3.setPaddingRelative(paddingStart2, dimensionPixelSize3, dimensionPixelSize4, viewGroup3.getPaddingBottom());
                    frameLayout.setPaddingRelative(0, 0, 0, 0);
                } else {
                    int paddingLeft2 = viewGroup3.getPaddingLeft() != 0 ? viewGroup3.getPaddingLeft() : dimensionPixelSize4;
                    if (viewGroup3.getPaddingRight() != 0) {
                        dimensionPixelSize4 = viewGroup3.getPaddingRight();
                    }
                    viewGroup3.setPadding(paddingLeft2, dimensionPixelSize3, dimensionPixelSize4, viewGroup3.getPaddingBottom());
                    frameLayout.setPadding(0, 0, 0, 0);
                }
            }
        } else {
            efq.O00000o0.findViewById(R$id.customPanel).setVisibility(8);
        }
        ViewGroup viewGroup4 = (ViewGroup) efq.O00000o0.findViewById(R$id.buttonPanel);
        efq.O0000Ooo = (Button) viewGroup4.findViewById(16908313);
        if (efq.O0000Ooo != null) {
            efq.O0000Ooo.setOnClickListener(efq.O0000ooo);
            if (TextUtils.isEmpty(efq.O0000o00)) {
                efq.O0000Ooo.setVisibility(8);
            } else {
                efq.O0000Ooo.setText(efq.O0000o00);
                efq.O0000Ooo.setVisibility(0);
                z = true;
                efq.O0000o0O = (Button) viewGroup4.findViewById(16908314);
                if (efq.O0000o0O != null) {
                    efq.O0000o0O.setOnClickListener(efq.O0000ooo);
                    if (TextUtils.isEmpty(efq.O0000o0o)) {
                        efq.O0000o0O.setVisibility(8);
                    } else {
                        efq.O0000o0O.setText(efq.O0000o0o);
                        efq.O0000o0O.setVisibility(0);
                        z = true;
                    }
                }
                efq.O0000oO0 = (Button) viewGroup4.findViewById(16908315);
                if (efq.O0000oO0 != null) {
                    efq.O0000oO0.setOnClickListener(efq.O0000ooo);
                    if (TextUtils.isEmpty(efq.O0000oO)) {
                        efq.O0000oO0.setVisibility(8);
                    } else {
                        efq.O0000oO0.setText(efq.O0000oO);
                        efq.O0000oO0.setVisibility(0);
                        if (!z2) {
                            viewGroup4.setVisibility(8);
                            return;
                        }
                        return;
                    }
                }
                z2 = z;
                if (!z2) {
                }
            }
        }
        z = false;
        efq.O0000o0O = (Button) viewGroup4.findViewById(16908314);
        if (efq.O0000o0O != null) {
        }
        efq.O0000oO0 = (Button) viewGroup4.findViewById(16908315);
        if (efq.O0000oO0 != null) {
        }
        z2 = z;
        if (!z2) {
        }
    }

    static int O000000o(Context context, int i) {
        if (i == 3) {
            return 2132738558;
        }
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        return typedValue.resourceId;
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f6229O000000o.O000000o(charSequence);
    }

    public void O000000o(CharSequence charSequence) {
        this.f6229O000000o.O00000Oo(charSequence);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        efq efq = this.f6229O000000o.f6212O000000o;
        return (efq.O0000oo0 != null && efq.O0000oo0.executeKeyEvent(keyEvent)) || super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        efq efq = this.f6229O000000o.f6212O000000o;
        return (efq.O0000oo0 != null && efq.O0000oo0.executeKeyEvent(keyEvent)) || super.onKeyDown(i, keyEvent);
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public AlertControllerWrapper.AlertParams f6230O000000o;
        private int O00000Oo;

        public Builder(Context context) {
            this(context, AlertDialog.O000000o(context, 0));
        }

        private Builder(Context context, int i) {
            this.f6230O000000o = new AlertControllerWrapper.AlertParams(new ContextThemeWrapper(context, AlertDialog.O000000o(context, i)));
            this.f6230O000000o.O00000oO = i >= 4;
            this.O00000Oo = i;
        }

        public final Builder O000000o(int i) {
            AlertControllerWrapper.AlertParams alertParams = this.f6230O000000o;
            alertParams.O0000OOo = alertParams.O00000oo.getText(i);
            return this;
        }

        public final Builder O000000o(CharSequence charSequence) {
            this.f6230O000000o.O0000Oo = charSequence;
            return this;
        }

        public final Builder O000000o() {
            AlertControllerWrapper.AlertParams alertParams = this.f6230O000000o;
            alertParams.O0000o0O = alertParams.O00000oo.getText(17039370);
            this.f6230O000000o.O0000o0o = null;
            return this;
        }

        public final AlertDialog O00000Oo() {
            AlertDialog alertDialog = new AlertDialog(this.f6230O000000o.O00000oo, this.O00000Oo);
            AlertControllerWrapper.AlertParams alertParams = this.f6230O000000o;
            AlertControllerWrapper alertControllerWrapper = alertDialog.f6229O000000o;
            if (alertParams.O0000Oo0 != null) {
                alertControllerWrapper.O000000o(alertParams.O0000Oo0);
            } else if (alertParams.O0000OOo != null) {
                alertControllerWrapper.O000000o(alertParams.O0000OOo);
            }
            if (alertParams.O0000Oo != null) {
                alertControllerWrapper.O00000Oo(alertParams.O0000Oo);
            }
            if (alertParams.O0000OoO != null) {
                alertControllerWrapper.O000000o(-1, alertParams.O0000OoO, alertParams.O0000Ooo);
            }
            if (alertParams.O0000o00 != null) {
                alertControllerWrapper.O000000o(-2, alertParams.O0000o00, alertParams.O0000o0);
            }
            if (alertParams.O0000o0O != null) {
                alertControllerWrapper.O000000o(-3, alertParams.O0000o0O, alertParams.O0000o0o);
            }
            if (alertParams.O0000oOO != null) {
                alertControllerWrapper.O00000Oo(alertParams.O0000oOO);
            }
            if (alertParams.O00000o != null) {
                efq efq = alertControllerWrapper.f6212O000000o;
                ArrayList<AlertControllerWrapper.AlertParams.O000000o> arrayList = alertParams.O00000o;
                DialogInterface.OnClickListener onClickListener = alertParams.f6213O000000o;
                efq.O0000Oo = arrayList;
                efq.O0000OoO = onClickListener;
            }
            alertDialog.setOnCancelListener(this.f6230O000000o.O0000oO0);
            alertDialog.setOnDismissListener(this.f6230O000000o.O00000Oo);
            alertDialog.setOnShowListener(this.f6230O000000o.O00000o0);
            if (this.f6230O000000o.O0000oO != null) {
                alertDialog.setOnKeyListener(this.f6230O000000o.O0000oO);
            }
            return alertDialog;
        }

        public final AlertDialog O00000o0() {
            AlertDialog O00000Oo2 = O00000Oo();
            O00000Oo2.show();
            return O00000Oo2;
        }
    }
}
