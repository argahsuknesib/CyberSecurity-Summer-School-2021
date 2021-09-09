package _m_j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import com.mi.global.shop.buy.payu.PayU;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;
import java.util.Calendar;

public abstract class byu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f13415O000000o;
    protected View O00000Oo;
    protected int O00000o;
    public boolean O00000o0;
    protected int O00000oO;
    protected CustomEditTextView O00000oo;
    protected CustomEditTextView O0000O0o;
    public ImageView O0000OOo;
    protected CustomEditTextView O0000Oo;
    protected CustomEditTextView O0000Oo0;
    public CustomTextView O0000OoO;
    public CustomTextView O0000Ooo;
    protected boolean O0000o = false;
    CommonButton O0000o0;
    protected CheckBox O0000o00;
    protected boolean O0000o0O = true;
    protected boolean O0000o0o = false;
    public boolean O0000oO;
    public String O0000oO0 = "";
    private ImageView O0000oOO;

    /* access modifiers changed from: protected */
    public abstract void O00000oO();

    /* access modifiers changed from: protected */
    public abstract void O00000oo();

    public byu(Context context, View view, String str, boolean z) {
        this.f13415O000000o = context;
        this.O00000Oo = view;
        this.O0000oO0 = str;
        this.O0000oO = z;
        O000000o();
    }

    /* access modifiers changed from: protected */
    public void O000000o() {
        this.O0000Oo = (CustomEditTextView) this.O00000Oo.findViewById(R.id.card_number);
        this.O0000OoO = (CustomTextView) this.O00000Oo.findViewById(R.id.card_number_not_support);
        this.O0000Ooo = (CustomTextView) this.O00000Oo.findViewById(R.id.card_optional_expiry_cvv);
        this.O0000Oo0 = (CustomEditTextView) this.O00000Oo.findViewById(R.id.card_name);
        this.O00000oo = (CustomEditTextView) this.O00000Oo.findViewById(R.id.card_expiry);
        this.O0000O0o = (CustomEditTextView) this.O00000Oo.findViewById(R.id.card_cvv);
        this.O0000OOo = (ImageView) this.O00000Oo.findViewById(R.id.card_cvv_image);
        this.O0000o00 = (CheckBox) this.O00000Oo.findViewById(R.id.store_card);
        this.O0000o00.setChecked(true);
        this.O0000o00.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class _m_j.byu.AnonymousClass1 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                cbe.O000000o("store_card", "ConfirmActivity", "", "checked", String.valueOf(z));
            }
        });
        this.O0000o0 = (CommonButton) this.O00000Oo.findViewById(R.id.pay_order);
        this.O0000oOO = (ImageView) this.O00000Oo.findViewById(R.id.store_card_question);
        this.O00000oo.setFocusable(false);
        this.O0000o0.setEnabled(false);
        O0000O0o();
        O0000OOo();
    }

    private void O0000O0o() {
        if (this.O0000oO) {
            this.O0000Oo0.setHint("Name on card（Optional）");
            this.O00000oo.setHint("Expiry（Optional）");
            this.O0000O0o.setHint("CVV（Optional）");
        } else {
            this.O0000Oo0.setHint("Name on card");
            this.O00000oo.setHint("Expiry");
            this.O0000O0o.setHint("CVV");
        }
        O00000Oo();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(boolean z) {
        this.O0000oO = z;
        O0000O0o();
        O0000OOo();
    }

    private void O0000OOo() {
        this.O0000Oo.addTextChangedListener(new bzd() {
            /* class _m_j.byu.AnonymousClass3 */

            public final void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                String replace = byu.this.O0000Oo.getText().toString().replace(" ", "");
                String O00000Oo = bzs.O00000Oo(replace);
                if (O00000Oo.contentEquals("AMEX")) {
                    byu.this.O0000O0o.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
                    byu.this.O0000OOo.setImageResource(R.drawable.shop_cvv1234);
                } else {
                    byu.this.O0000O0o.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                    byu.this.O0000OOo.setImageResource(R.drawable.shop_cvv123);
                }
                if (O00000Oo.contentEquals("SMAE")) {
                    if (!PayU.O0000o0.contains(O00000Oo)) {
                        byu.this.O0000Ooo.setVisibility(0);
                    }
                    byu.this.O0000o = true;
                } else {
                    byu.this.O0000Ooo.setVisibility(8);
                    byu.this.O0000o = false;
                }
                if ("BFL".contentEquals(O00000Oo) || !PayU.O0000o0.contains(O00000Oo) || byu.this.O0000oO) {
                    byu.this.O0000OoO.setVisibility(8);
                } else {
                    byu.this.O0000OoO.setVisibility(0);
                    byu.this.O0000OoO.setText(byu.this.f13415O000000o.getString(R.string.buy_confirm_card_notsupport));
                }
                byu.this.O00000o0 = false;
                if (bzs.f13499O000000o.get(O00000Oo) != null) {
                    byu.this.O0000Oo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, bzs.f13499O000000o.get(O00000Oo), (Drawable) null);
                } else {
                    byu.this.O0000Oo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bzs.O000000o(replace).booleanValue()) {
                    byu.this.O00000o0 = true;
                } else {
                    byu.this.O00000o0 = false;
                }
                if (byu.this.O0000oO) {
                    if (byu.this.O00000o0 || replace.length() <= 0) {
                        byu.this.O0000OoO.setVisibility(8);
                    } else {
                        byu.this.O0000OoO.setVisibility(0);
                        byu.this.O0000OoO.setText("Enter a valid number");
                    }
                }
                byu.this.O00000Oo();
            }
        });
        this.O0000Oo.setOnTouchListener(new View.OnTouchListener() {
            /* class _m_j.byu.AnonymousClass4 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                cbe.O000000o("card_number_click", byu.this.O0000oO0);
                return false;
            }
        });
        this.O0000Oo0.setOnTouchListener(new View.OnTouchListener() {
            /* class _m_j.byu.AnonymousClass5 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                cbe.O000000o("name_click", byu.this.O0000oO0);
                return false;
            }
        });
        this.O0000O0o.setOnTouchListener(new View.OnTouchListener() {
            /* class _m_j.byu.AnonymousClass6 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                cbe.O000000o("cvv_click", byu.this.O0000oO0);
                return false;
            }
        });
        this.O0000O0o.addTextChangedListener(new TextWatcher() {
            /* class _m_j.byu.AnonymousClass7 */

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                charSequence.toString();
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (bzs.O000000o(byu.this.O0000Oo.getText().toString().replace(" ", ""), charSequence.toString())) {
                    byu byu = byu.this;
                    byu.O0000o0o = true;
                    byu.O00000Oo();
                    return;
                }
                byu byu2 = byu.this;
                byu2.O0000o0o = false;
                byu2.O0000o0.setEnabled(false);
            }
        });
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.byu.AnonymousClass8 */

            public final void onClick(View view) {
                View findViewById;
                cbe.O000000o("expiry_click", byu.this.O0000oO0);
                final Dialog dialog = new Dialog(byu.this.f13415O000000o, R.style.ProgressDialog);
                View inflate = LayoutInflater.from(byu.this.f13415O000000o).inflate((int) R.layout.shop_date_picker, (ViewGroup) null);
                dialog.setContentView(inflate);
                dialog.setCancelable(false);
                CustomButtonView customButtonView = (CustomButtonView) inflate.findViewById(R.id.datePickerOkButton);
                final DatePicker datePicker = (DatePicker) inflate.findViewById(R.id.datePicker);
                Calendar instance = Calendar.getInstance();
                int i = instance.get(5);
                int i2 = instance.get(2);
                datePicker.setMinDate(instance.getTimeInMillis() - 1000);
                instance.set(instance.get(1) + 50, i2, i);
                datePicker.setMaxDate(instance.getTimeInMillis());
                try {
                    if (Build.VERSION.SDK_INT < 21) {
                        ((ViewGroup) ((ViewGroup) datePicker.getChildAt(0)).getChildAt(0)).getChildAt(0).setVisibility(8);
                        for (Field field : datePicker.getClass().getDeclaredFields()) {
                            if ("mDayPicker".equals(field.getName()) || "mDaySpinner".equals(field.getName()) || "mDelegate".equals(field.getName())) {
                                field.setAccessible(true);
                                ((View) field.get(datePicker)).setVisibility(8);
                            }
                        }
                    } else {
                        int identifier = Resources.getSystem().getIdentifier("day", "id", "android");
                        if (!(identifier == 0 || (findViewById = datePicker.findViewById(identifier)) == null)) {
                            findViewById.setVisibility(8);
                        }
                    }
                } catch (Exception e) {
                    Log.e("AbstractCardViewWraper", e.getMessage());
                }
                dialog.show();
                customButtonView.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.byu.AnonymousClass8.AnonymousClass1 */

                    public final void onClick(View view) {
                        byu.this.O00000oO = datePicker.getMonth() + 1;
                        byu.this.O00000o = datePicker.getYear();
                        CustomEditTextView customEditTextView = byu.this.O00000oo;
                        StringBuilder sb = new StringBuilder();
                        sb.append(byu.this.O00000oO < 10 ? "0" : "");
                        sb.append(byu.this.O00000oO);
                        sb.append(" / ");
                        sb.append(byu.this.O00000o);
                        customEditTextView.setText(sb.toString());
                        byu.this.O0000o0O = false;
                        byu.this.O00000Oo();
                        dialog.dismiss();
                    }
                });
            }
        });
        this.O0000o0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.byu.AnonymousClass9 */

            public final void onClick(View view) {
                if (!cau.O000000o()) {
                    if (byu.this.O0000oO) {
                        byu.this.O00000oO();
                        return;
                    }
                    cbe.O000000o("pay_click", byu.this.O0000oO0, "channl", "EMI");
                    byu.this.O00000oo();
                }
            }
        });
        AnonymousClass10 r0 = new View.OnFocusChangeListener() {
            /* class _m_j.byu.AnonymousClass10 */

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    byu.this.O00000o();
                }
            }
        };
        this.O0000Oo.setOnFocusChangeListener(r0);
        this.O0000Oo0.setOnFocusChangeListener(r0);
        this.O00000oo.setOnFocusChangeListener(r0);
        this.O0000O0o.setOnFocusChangeListener(r0);
        this.O0000oOO.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.byu.AnonymousClass2 */

            public final void onClick(View view) {
                cbe.O000000o("card_details_click", byu.this.O0000oO0);
                AlertDialog.Builder builder = new AlertDialog.Builder(byu.this.f13415O000000o);
                builder.setMessage(byl.O00000oO().getString(R.string.buy_confirm_credit_qcontent));
                builder.setPositiveButton("OK", (DialogInterface.OnClickListener) null);
                builder.show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void O00000Oo() {
        if (O00000o0()) {
            this.O0000o0.setEnabled(true);
        } else {
            this.O0000o0.setEnabled(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean O00000o0() {
        if (this.O0000oO) {
            return this.O00000o0;
        }
        if (!this.O00000o0) {
            return false;
        }
        if (!this.O0000o) {
            return !this.O0000o0O && this.O0000o0o;
        }
        return true;
    }

    public final void O00000o() {
        if (!this.O00000o0 && this.O0000Oo.getText().toString().length() > 0 && !this.O0000Oo.isFocused()) {
            this.O0000Oo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f13415O000000o.getResources().getDrawable(R.drawable.shop_error_icon), (Drawable) null);
        }
        if (!this.O0000o0o && this.O0000O0o.getText().toString().length() > 0 && !this.O0000O0o.isFocused()) {
            this.O0000O0o.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f13415O000000o.getResources().getDrawable(R.drawable.shop_error_icon), (Drawable) null);
        }
    }
}
