package com.mi.global.shop.widget;

import _m_j.cay;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

public class XEditText extends CustomEditTextView {
    O000000o finishedEditListener;
    public boolean hasFocused;
    private boolean hasNoSeparator;
    public int inputLength;
    public int[] intervals;
    public int mMaxLength;
    public int mPreLength;
    public String mSeparator;
    public String mSeparatorString;
    public O00000o0 mTextWatcher;
    public O00000Oo mXTextChangeListener;
    public int[] pattern;

    public interface O000000o {
        void O000000o(boolean z);
    }

    public interface O00000Oo {
    }

    public XEditText(Context context) {
        this(context, null);
    }

    public XEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public XEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxLength = Integer.MAX_VALUE;
        cay.O000000o(this, context);
        if (this.mSeparator == null) {
            this.mSeparator = "";
            this.mSeparatorString = "";
        }
        this.mTextWatcher = new O00000o0(this, (byte) 0);
        addTextChangedListener(this.mTextWatcher);
        setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.mi.global.shop.widget.XEditText.AnonymousClass1 */

            public final void onFocusChange(View view, boolean z) {
                XEditText.this.hasFocused = z;
            }
        });
    }

    public void setInputLength(int i) {
        this.inputLength = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setFinishedEditListener(O000000o o000000o) {
        this.finishedEditListener = o000000o;
    }

    class O00000o0 implements TextWatcher {
        private O00000o0() {
        }

        /* synthetic */ O00000o0(XEditText xEditText, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            XEditText.this.mPreLength = charSequence.length();
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() <= XEditText.this.mPreLength) {
                return;
            }
            if (charSequence.toString().contains(XEditText.this.mSeparator) || charSequence.length() > XEditText.this.inputLength) {
                XEditText xEditText = XEditText.this;
                xEditText.removeTextChangedListener(xEditText.mTextWatcher);
                String replaceAll = charSequence.toString().replaceAll(XEditText.this.mSeparator, "");
                if (replaceAll.length() > XEditText.this.inputLength) {
                    replaceAll = replaceAll.substring(0, XEditText.this.inputLength);
                }
                XEditText.this.setText(replaceAll);
                XEditText xEditText2 = XEditText.this;
                xEditText2.addTextChangedListener(xEditText2.mTextWatcher);
            }
        }

        public final void afterTextChanged(Editable editable) {
            int length = editable.length();
            if (TextUtils.isEmpty(XEditText.this.mSeparatorString)) {
                XEditText.this.mMaxLength = length;
            }
            if (length > XEditText.this.mMaxLength) {
                XEditText.this.getText().delete(XEditText.this.mMaxLength, length);
                if (XEditText.this.finishedEditListener == null) {
                    return;
                }
                if (XEditText.this.getText().toString().trim().length() >= XEditText.this.mMaxLength) {
                    XEditText.this.finishedEditListener.O000000o(true);
                } else {
                    XEditText.this.finishedEditListener.O000000o(false);
                }
            } else if (XEditText.this.pattern != null && editable.toString().trim().length() != 0) {
                XEditText xEditText = XEditText.this;
                xEditText.removeTextChangedListener(xEditText.mTextWatcher);
                if (length > XEditText.this.mPreLength) {
                    for (int i = 0; i < XEditText.this.pattern.length - 1; i++) {
                        if (length <= XEditText.this.intervals[i]) {
                            if (i == 0) {
                                break;
                            }
                        } else {
                            XEditText.this.getText().insert(XEditText.this.intervals[i], XEditText.this.mSeparatorString);
                        }
                    }
                    if (editable.length() > 0) {
                        XEditText xEditText2 = XEditText.this;
                        xEditText2.setSelection(xEditText2.getText().length());
                    }
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= XEditText.this.pattern.length) {
                            break;
                        } else if (length - 1 == XEditText.this.intervals[i2]) {
                            XEditText.this.getText().delete(length - 2, length);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (XEditText.this.finishedEditListener != null) {
                    if (XEditText.this.getText().toString().trim().length() >= XEditText.this.mMaxLength) {
                        XEditText.this.finishedEditListener.O000000o(true);
                    } else {
                        XEditText.this.finishedEditListener.O000000o(false);
                    }
                }
                XEditText xEditText3 = XEditText.this;
                xEditText3.addTextChangedListener(xEditText3.mTextWatcher);
            } else if (XEditText.this.finishedEditListener != null) {
                XEditText.this.finishedEditListener.O000000o(false);
            }
        }
    }

    private boolean isTextEmpty() {
        return getText().toString().trim().length() == 0;
    }

    private int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, Resources.getSystem().getDisplayMetrics());
    }

    public void setSeparator(String str, int i) {
        this.mSeparator = str;
        this.hasNoSeparator = false;
        this.mSeparatorString = str;
        while (true) {
            i--;
            if (i > 0) {
                this.mSeparatorString += str;
            } else {
                return;
            }
        }
    }

    public void setPattern(int[] iArr, String str, int i) {
        setSeparator(str, i);
        setPattern(iArr);
    }

    public void setPattern(int[] iArr) {
        this.pattern = iArr;
        this.intervals = new int[iArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            i += iArr[i3];
            this.intervals[i3] = i + i2;
            if (i3 < iArr.length - 1) {
                i2 += this.mSeparatorString.length();
            }
        }
        int[] iArr2 = this.intervals;
        this.mMaxLength = iArr2[iArr2.length - 1];
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.mMaxLength)});
    }

    @Deprecated
    public String getNonSeparatorText() {
        return getText().toString().replaceAll(this.mSeparator, "");
    }

    public String getTrimmedString() {
        if (this.hasNoSeparator) {
            return getText().toString().trim();
        }
        return getText().toString().replaceAll(this.mSeparator, "").trim();
    }

    public boolean hasNoSeparator() {
        return this.hasNoSeparator;
    }

    public void setHasNoSeparator(boolean z) {
        this.hasNoSeparator = z;
        if (z) {
            this.mSeparator = "";
            this.mSeparatorString = "";
        }
    }

    public void setOnXTextChangeListener(O00000Oo o00000Oo) {
        this.mXTextChangeListener = o00000Oo;
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putString("separator", this.mSeparator);
        bundle.putString("mSeparatorString", this.mSeparatorString);
        bundle.putIntArray("pattern", this.pattern);
        bundle.putBoolean("hasNoSeparator", this.hasNoSeparator);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mSeparator = bundle.getString("separator");
            this.mSeparatorString = bundle.getString("mSeparatorString");
            this.pattern = bundle.getIntArray("pattern");
            this.hasNoSeparator = bundle.getBoolean("hasNoSeparator");
            int[] iArr = this.pattern;
            if (iArr != null) {
                setPattern(iArr);
            }
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
