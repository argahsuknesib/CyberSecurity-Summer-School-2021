package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;

public class euz {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f15837O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public boolean O00000oo;
    public boolean O0000O0o;
    public boolean O0000OOo;
    public boolean O0000Oo;
    public boolean O0000Oo0;
    public boolean O0000OoO;
    public boolean O0000Ooo;
    protected String O0000o;
    protected Context O0000o0;
    public boolean O0000o00;
    protected String O0000o0O;
    protected String O0000o0o;
    protected String O0000oO;
    protected String O0000oO0;
    protected String O0000oOO;
    protected float O0000oOo;
    protected float O0000oo;
    protected float O0000oo0;
    protected float O0000ooO;
    protected float O0000ooo;
    protected Paint O000O00o;
    protected Paint O000O0OO;
    protected float O000O0Oo;
    protected float O000O0o;
    protected float O000O0o0;
    protected float O000O0oO;
    protected float O000O0oo;
    protected float O000OO;
    protected float O000OO00;
    protected float O000OO0o;
    protected float O000OOOo;
    protected float O000OOo;
    protected float O000OOo0;
    protected float O000OOoO;
    protected float O000OOoo;
    protected float O000Oo0;
    protected float O000Oo00;
    protected float O000Oo0O;
    protected float O000Oo0o;
    private boolean O000OoO;
    protected int O000OoO0;
    private boolean O000OoOO;
    private boolean O000OoOo;
    private boolean O000Ooo;
    private boolean O000Ooo0;
    private float O000OooO;
    private int O000Oooo;
    private float O000o;
    private boolean O000o0;
    private boolean O000o00;
    private float O000o000;
    private int O000o00O;
    private float O000o00o;
    private float O000o0O;
    private float O000o0O0;
    private float O000o0OO;
    private float O000o0Oo;
    private float O000o0o;
    private float O000o0o0;
    private float O000o0oo;
    private String O000oO;
    private float O000oO0;
    private float O000oO00;
    private float O000oO0O;
    private float O000oO0o;
    private String O000oOO0;
    private boolean O00O0Oo;
    protected float O00oOoOo;
    protected boolean O00oOooO;
    protected Paint O00oOooo;

    public void O000000o(Context context, TypedArray typedArray) {
        this.O0000o0 = context;
        this.O000o00 = typedArray.getBoolean(10, false);
        this.O000o000 = typedArray.getDimension(39, evf.O00000Oo(this.O0000o0, 12.0f));
        this.O000Oooo = typedArray.getColor(38, -16777216);
        this.O00000oo = typedArray.getBoolean(2, false);
        this.O0000O0o = typedArray.getBoolean(3, false);
        this.O0000OOo = typedArray.getBoolean(5, true);
        this.O0000Oo0 = typedArray.getBoolean(6, true);
        this.O0000Oo = typedArray.getBoolean(4, false);
        if (typedArray.getBoolean(1, true)) {
            this.O0000OoO = typedArray.getBoolean(0, false);
        }
        this.O000o0 = typedArray.getBoolean(9, false);
        this.O000o00o = typedArray.getDimension(29, evf.O00000Oo(this.O0000o0, 12.0f));
        this.O000o00O = typedArray.getColor(28, -16777216);
        this.O0000o0O = typedArray.getString(11);
        this.O0000o0o = typedArray.getString(12);
        this.O0000o = typedArray.getString(16);
        this.O0000oO0 = typedArray.getString(22);
        this.O0000oO = typedArray.getString(25);
        this.O0000oOO = typedArray.getString(20);
        this.O000OoO0 = typedArray.getInt(15, 1);
        this.O000OooO = typedArray.getDimension(19, -1.0f);
        this.O00oOoOo = typedArray.getDimension(13, -1.0f);
        this.O000O0o0 = typedArray.getDimension(14, -1.0f);
        this.O000O0oo = typedArray.getDimension(17, -1.0f);
        this.O000OO00 = typedArray.getDimension(18, -1.0f);
        this.O000OO0o = typedArray.getDimension(23, -1.0f);
        this.O000OO = typedArray.getDimension(24, -1.0f);
        this.O000O0o = typedArray.getDimension(26, -1.0f);
        this.O000O0oO = typedArray.getDimension(27, -1.0f);
        this.O000OOOo = typedArray.getDimension(21, -1.0f);
        this.O0000Ooo = typedArray.hasValue(2);
        this.O0000o00 = typedArray.hasValue(3);
        O0000Oo();
        if (!this.O00000oo && !this.O0000O0o && !this.O0000OOo) {
            this.O0000Oo0 = true;
        }
        if (!this.O0000Oo0) {
            this.O0000Oo = false;
        }
    }

    public final void O00000oO() {
        O0000Oo0();
        O000000o();
        O0000OoO();
        if (!this.O0000Oo0) {
            this.O0000Oo = false;
        }
        O00000Oo();
    }

    private void O0000Oo0() {
        this.O00O0Oo = !TextUtils.isEmpty(this.O0000o0o);
        this.O000OoO = !TextUtils.isEmpty(this.O0000o);
        this.O000OoOO = !TextUtils.isEmpty(this.O0000oO0);
        this.O000OoOo = !TextUtils.isEmpty(this.O0000oO);
        this.O000Ooo0 = !TextUtils.isEmpty(this.O0000oOO);
        if ((this.O00000oo && this.O00O0Oo) || ((this.O0000O0o && this.O000OoO) || ((this.O0000OOo && this.O000OoOO) || ((this.O0000Oo0 && this.O000OoOo) || (this.O0000Oo && this.O000Ooo0))))) {
            this.O000Ooo = true;
        }
        this.O000oO = this.O0000oO0;
        this.O000oOO0 = this.O0000oO;
    }

    private void O0000Oo() {
        this.O000o0Oo = this.O00oOoOo;
        this.O000o0o0 = this.O000O0o0;
        this.O000o0o = this.O000O0oo;
        this.O000o0oo = this.O000OO00;
        this.O000o = this.O000OO0o;
        this.O000oO00 = this.O000OO;
        this.O000oO0 = this.O000O0o;
        this.O000oO0O = this.O000O0oO;
        this.O000oO0o = this.O000OOOo;
    }

    /* access modifiers changed from: protected */
    public void O000000o() {
        this.O00oOooo = new Paint(1);
        this.O00oOooo.setColor(this.O000Oooo);
        this.O00oOooo.setTextAlign(Paint.Align.CENTER);
        this.O00oOooo.setTextSize(this.O000o000);
        if (this.O000o00) {
            this.O00oOooo.setFakeBoldText(true);
        }
        this.O000O00o = new Paint(1);
        this.O000O00o.setColor(this.O000o00O);
        this.O000O00o.setTextSize(this.O000o00o);
        if (this.O000o0) {
            this.O000O00o.setFakeBoldText(true);
        }
        this.O000O0OO = new Paint();
        this.O000O0OO.setTextSize(this.O000o000);
        if (this.O000o00) {
            this.O000O0OO.setFakeBoldText(true);
        }
    }

    private void O0000OoO() {
        float f;
        boolean z;
        float measureText = this.O000O00o.measureText(":");
        if (!TextUtils.isEmpty(this.O0000o0O)) {
            z = false;
            f = this.O000O00o.measureText(this.O0000o0O);
        } else {
            z = true;
            f = 0.0f;
        }
        if (!this.O00000oo) {
            this.O0000oOo = 0.0f;
        } else if (this.O00O0Oo) {
            this.O0000oOo = this.O000O00o.measureText(this.O0000o0o);
        } else if (!z) {
            this.O0000o0o = this.O0000o0O;
            this.O0000oOo = f;
        } else if (!this.O000Ooo) {
            this.O0000o0o = ":";
            this.O0000oOo = measureText;
        }
        if (!this.O0000O0o) {
            this.O0000oo0 = 0.0f;
        } else if (this.O000OoO) {
            this.O0000oo0 = this.O000O00o.measureText(this.O0000o);
        } else if (!z) {
            this.O0000o = this.O0000o0O;
            this.O0000oo0 = f;
        } else if (!this.O000Ooo) {
            this.O0000o = ":";
            this.O0000oo0 = measureText;
        }
        if (!this.O0000OOo) {
            this.O0000oo = 0.0f;
        } else if (this.O000OoOO) {
            this.O0000oo = this.O000O00o.measureText(this.O0000oO0);
        } else if (!this.O0000Oo0) {
            this.O0000oo = 0.0f;
        } else if (!z) {
            this.O0000oO0 = this.O0000o0O;
            this.O0000oo = f;
        } else if (!this.O000Ooo) {
            this.O0000oO0 = ":";
            this.O0000oo = measureText;
        }
        if (!this.O0000Oo0) {
            this.O0000ooO = 0.0f;
        } else if (this.O000OoOo) {
            this.O0000ooO = this.O000O00o.measureText(this.O0000oO);
        } else if (!this.O0000Oo) {
            this.O0000ooO = 0.0f;
        } else if (!z) {
            this.O0000oO = this.O0000o0O;
            this.O0000ooO = f;
        } else if (!this.O000Ooo) {
            this.O0000oO = ":";
            this.O0000ooO = measureText;
        }
        if (!this.O0000Oo || !this.O000Ooo || !this.O000Ooo0) {
            this.O0000ooo = 0.0f;
        } else {
            this.O0000ooo = this.O000O00o.measureText(this.O0000oOO);
        }
        O0000Ooo();
    }

    private void O0000Ooo() {
        int O000000o2 = evf.O000000o(this.O0000o0, 3.0f);
        boolean z = this.O000OooO < 0.0f;
        if (!this.O00000oo || this.O0000oOo <= 0.0f) {
            this.O00oOoOo = 0.0f;
            this.O000O0o0 = 0.0f;
        } else {
            if (this.O00oOoOo < 0.0f) {
                if (!z) {
                    this.O00oOoOo = this.O000OooO;
                } else {
                    this.O00oOoOo = (float) O000000o2;
                }
            }
            if (this.O000O0o0 < 0.0f) {
                if (!z) {
                    this.O000O0o0 = this.O000OooO;
                } else {
                    this.O000O0o0 = (float) O000000o2;
                }
            }
        }
        if (!this.O0000O0o || this.O0000oo0 <= 0.0f) {
            this.O000O0oo = 0.0f;
            this.O000OO00 = 0.0f;
        } else {
            if (this.O000O0oo < 0.0f) {
                if (!z) {
                    this.O000O0oo = this.O000OooO;
                } else {
                    this.O000O0oo = (float) O000000o2;
                }
            }
            if (this.O000OO00 < 0.0f) {
                if (!z) {
                    this.O000OO00 = this.O000OooO;
                } else {
                    this.O000OO00 = (float) O000000o2;
                }
            }
        }
        if (!this.O0000OOo || this.O0000oo <= 0.0f) {
            this.O000OO0o = 0.0f;
            this.O000OO = 0.0f;
        } else {
            if (this.O000OO0o < 0.0f) {
                if (!z) {
                    this.O000OO0o = this.O000OooO;
                } else {
                    this.O000OO0o = (float) O000000o2;
                }
            }
            if (!this.O0000Oo0) {
                this.O000OO = 0.0f;
            } else if (this.O000OO < 0.0f) {
                if (!z) {
                    this.O000OO = this.O000OooO;
                } else {
                    this.O000OO = (float) O000000o2;
                }
            }
        }
        if (this.O0000Oo0) {
            if (this.O0000ooO > 0.0f) {
                if (this.O000O0o < 0.0f) {
                    if (!z) {
                        this.O000O0o = this.O000OooO;
                    } else {
                        this.O000O0o = (float) O000000o2;
                    }
                }
                if (!this.O0000Oo) {
                    this.O000O0oO = 0.0f;
                } else if (this.O000O0oO < 0.0f) {
                    if (!z) {
                        this.O000O0oO = this.O000OooO;
                    } else {
                        this.O000O0oO = (float) O000000o2;
                    }
                }
            } else {
                this.O000O0o = 0.0f;
                this.O000O0oO = 0.0f;
            }
            if (!this.O0000Oo || this.O0000ooo <= 0.0f) {
                this.O000OOOo = 0.0f;
            } else if (this.O000OOOo >= 0.0f) {
            } else {
                if (!z) {
                    this.O000OOOo = this.O000OooO;
                } else {
                    this.O000OOOo = (float) O000000o2;
                }
            }
        } else {
            this.O000O0o = 0.0f;
            this.O000O0oO = 0.0f;
            this.O000OOOo = 0.0f;
        }
    }

    /* access modifiers changed from: protected */
    public void O00000Oo() {
        Rect rect = new Rect();
        this.O00oOooo.getTextBounds("00", 0, 2, rect);
        this.O000Oo0 = (float) rect.width();
        this.O000Oo0O = (float) rect.height();
        this.O000Oo0o = (float) rect.bottom;
    }

    private float O00000Oo(String str) {
        float f;
        int i;
        Rect rect = new Rect();
        this.O000O00o.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.O000OoO0;
        if (i2 == 0) {
            f = this.O000o0OO - this.O000Oo0O;
            i = rect.top;
        } else if (i2 != 2) {
            return (this.O000o0OO - (this.O000Oo0O / 2.0f)) + ((float) (rect.height() / 2));
        } else {
            f = this.O000o0OO;
            i = rect.bottom;
        }
        return f - ((float) i);
    }

    /* access modifiers changed from: protected */
    public final float O00000oo(float f) {
        float f2 = this.O0000oOo + this.O0000oo0 + this.O0000oo + this.O0000ooO + this.O0000ooo + this.O00oOoOo + this.O000O0o0 + this.O000O0oo + this.O000OO00 + this.O000OO0o + this.O000OO + this.O000O0o + this.O000O0oO + this.O000OOOo;
        if (this.O0000OoO) {
            Rect rect = new Rect();
            float f3 = 0.0f;
            if (this.O00000oo) {
                String O000000o2 = evf.O000000o(this.f15837O000000o);
                this.O00oOooo.getTextBounds(O000000o2, 0, O000000o2.length(), rect);
                this.O000o0O0 = (float) rect.width();
                f3 = 0.0f + this.O000o0O0;
            }
            if (this.O0000O0o) {
                String O000000o3 = evf.O000000o(this.O00000Oo);
                this.O000O0OO.getTextBounds(O000000o3, 0, O000000o3.length(), rect);
                this.O000o0O = (float) rect.width();
                f3 += this.O000o0O;
            }
            f2 += f3;
        } else if (this.O0000O0o) {
            f2 += f;
        }
        if (this.O0000OOo) {
            f2 += f;
        }
        if (this.O0000Oo0) {
            f2 += f;
        }
        return this.O0000Oo ? f2 + f : f2;
    }

    public int O00000o0() {
        float f;
        float O00000oo2 = O00000oo(this.O000Oo0);
        if (!this.O0000OoO && this.O00000oo) {
            if (this.O00oOooO) {
                Rect rect = new Rect();
                String valueOf = String.valueOf(this.f15837O000000o);
                this.O00oOooo.getTextBounds(valueOf, 0, valueOf.length(), rect);
                this.O000o0O0 = (float) rect.width();
                f = this.O000o0O0;
            } else {
                f = this.O000Oo0;
                this.O000o0O0 = f;
            }
            O00000oo2 += f;
        }
        return (int) Math.ceil((double) O00000oo2);
    }

    public int O00000o() {
        return (int) this.O000Oo0O;
    }

    public void O000000o(View view, int i, int i2, int i3, int i4) {
        int paddingTop = view.getPaddingTop();
        if (paddingTop == view.getPaddingBottom()) {
            this.O000o0OO = (((float) (i2 / 2)) + (this.O000Oo0O / 2.0f)) - this.O000Oo0o;
        } else {
            this.O000o0OO = (((float) (i2 - (i2 - paddingTop))) + this.O000Oo0O) - this.O000Oo0o;
        }
        if (this.O00000oo && this.O0000oOo > 0.0f) {
            this.O000OOo0 = O00000Oo(this.O0000o0o);
        }
        if (this.O0000O0o && this.O0000oo0 > 0.0f) {
            this.O000OOo = O00000Oo(this.O0000o);
        }
        if (this.O0000OOo && this.O0000oo > 0.0f) {
            this.O000OOoO = O00000Oo(this.O0000oO0);
        }
        if (this.O0000ooO > 0.0f) {
            this.O000OOoo = O00000Oo(this.O0000oO);
        }
        if (this.O0000Oo && this.O0000ooo > 0.0f) {
            this.O000Oo00 = O00000Oo(this.O0000oOO);
        }
        this.O000O0Oo = view.getPaddingLeft() == view.getPaddingRight() ? (float) ((i - i3) / 2) : (float) view.getPaddingLeft();
    }

    public void O000000o(Canvas canvas) {
        float f;
        if (this.O00000oo) {
            canvas.drawText(evf.O000000o(this.f15837O000000o), this.O000O0Oo + (this.O000o0O0 / 2.0f), this.O000o0OO, this.O00oOooo);
            if (this.O0000oOo > 0.0f) {
                canvas.drawText(this.O0000o0o, this.O000O0Oo + this.O000o0O0 + this.O00oOoOo, this.O000OOo0, this.O000O00o);
            }
            f = this.O000O0Oo + this.O000o0O0 + this.O0000oOo + this.O00oOoOo + this.O000O0o0;
        } else {
            f = this.O000O0Oo;
        }
        if (this.O0000O0o) {
            float f2 = this.O0000OoO ? this.O000o0O : this.O000Oo0;
            canvas.drawText(evf.O000000o(this.O00000Oo), (f2 / 2.0f) + f, this.O000o0OO, this.O00oOooo);
            if (this.O0000oo0 > 0.0f) {
                canvas.drawText(this.O0000o, f + f2 + this.O000O0oo, this.O000OOo, this.O000O00o);
            }
            f = f + f2 + this.O0000oo0 + this.O000O0oo + this.O000OO00;
        }
        if (this.O0000OOo) {
            canvas.drawText(evf.O000000o(this.O00000o0), (this.O000Oo0 / 2.0f) + f, this.O000o0OO, this.O00oOooo);
            if (this.O0000oo > 0.0f) {
                canvas.drawText(this.O0000oO0, this.O000Oo0 + f + this.O000OO0o, this.O000OOoO, this.O000O00o);
            }
            f = f + this.O000Oo0 + this.O0000oo + this.O000OO0o + this.O000OO;
        }
        if (this.O0000Oo0) {
            canvas.drawText(evf.O000000o(this.O00000o), (this.O000Oo0 / 2.0f) + f, this.O000o0OO, this.O00oOooo);
            if (this.O0000ooO > 0.0f) {
                canvas.drawText(this.O0000oO, this.O000Oo0 + f + this.O000O0o, this.O000OOoo, this.O000O00o);
            }
            if (this.O0000Oo) {
                float f3 = f + this.O000Oo0 + this.O0000ooO + this.O000O0o + this.O000O0oO;
                canvas.drawText(evf.O00000Oo(this.O00000oO), (this.O000Oo0 / 2.0f) + f3, this.O000o0OO, this.O00oOooo);
                if (this.O0000ooo > 0.0f) {
                    canvas.drawText(this.O0000oOO, f3 + this.O000Oo0 + this.O000OOOo, this.O000Oo00, this.O000O00o);
                }
            }
        }
    }

    public final boolean O000000o(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = false;
        if (!z4) {
            z5 = false;
        }
        if (this.O00000oo != z) {
            this.O00000oo = z;
            if (z) {
                this.O00oOoOo = this.O000o0Oo;
                this.O000O0o0 = this.O000o0o0;
            }
        }
        if (this.O0000O0o != z2) {
            this.O0000O0o = z2;
            if (z2) {
                this.O000O0oo = this.O000o0o;
                this.O000OO00 = this.O000o0oo;
            }
        }
        if (this.O0000OOo != z3) {
            this.O0000OOo = z3;
            if (z3) {
                this.O000OO0o = this.O000o;
                this.O000OO = this.O000oO00;
                this.O0000oO0 = this.O000oO;
            }
        }
        if (this.O0000Oo0 != z4) {
            this.O0000Oo0 = z4;
            if (z4) {
                this.O000O0o = this.O000oO0;
                this.O000O0oO = this.O000oO0O;
                this.O0000oO = this.O000oOO0;
            } else {
                this.O0000oO0 = this.O000oO;
            }
            this.O000OO0o = this.O000o;
            this.O000OO = this.O000oO00;
            z6 = true;
        }
        if (this.O0000Oo == z5) {
            return z6;
        }
        this.O0000Oo = z5;
        if (z5) {
            this.O000OOOo = this.O000oO0o;
        } else {
            this.O0000oO = this.O000oOO0;
        }
        this.O000O0o = this.O000oO0;
        this.O000O0oO = this.O000oO0O;
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.euz.O000000o(boolean, boolean, boolean, boolean, boolean):boolean
     arg types: [int, int, boolean, boolean, boolean]
     candidates:
      _m_j.euz.O000000o(int, int, int, int, int):void
      _m_j.euz.O000000o(android.view.View, int, int, int, int):void
      _m_j.euz.O000000o(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean
      _m_j.euz.O000000o(boolean, boolean, boolean, boolean, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.euz.O000000o(boolean, boolean, boolean, boolean, boolean):boolean
     arg types: [int, boolean, boolean, boolean, boolean]
     candidates:
      _m_j.euz.O000000o(int, int, int, int, int):void
      _m_j.euz.O000000o(android.view.View, int, int, int, int):void
      _m_j.euz.O000000o(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean
      _m_j.euz.O000000o(boolean, boolean, boolean, boolean, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.euz.O000000o(boolean, boolean, boolean, boolean, boolean):boolean
     arg types: [boolean, int, boolean, boolean, boolean]
     candidates:
      _m_j.euz.O000000o(int, int, int, int, int):void
      _m_j.euz.O000000o(android.view.View, int, int, int, int):void
      _m_j.euz.O000000o(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean
      _m_j.euz.O000000o(boolean, boolean, boolean, boolean, boolean):boolean */
    public final boolean O00000oo() {
        if (!this.O0000Ooo) {
            if (this.O00000oo || this.f15837O000000o <= 0) {
                if (this.O00000oo && this.f15837O000000o == 0) {
                    O000000o(false, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo);
                    return true;
                } else if (!this.O0000o00) {
                    if (!this.O0000O0o && (this.f15837O000000o > 0 || this.O00000Oo > 0)) {
                        O000000o(this.O00000oo, true, this.O0000OOo, this.O0000Oo0, this.O0000Oo);
                        return true;
                    } else if (this.O0000O0o && this.f15837O000000o == 0 && this.O00000Oo == 0) {
                        O000000o(false, false, this.O0000OOo, this.O0000Oo0, this.O0000Oo);
                        return true;
                    }
                }
            } else if (!this.O0000o00) {
                O000000o(true, true, this.O0000OOo, this.O0000Oo0, this.O0000Oo);
                return true;
            } else {
                O000000o(true, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo);
                return true;
            }
        } else if (!this.O0000o00) {
            if (!this.O0000O0o && (this.f15837O000000o > 0 || this.O00000Oo > 0)) {
                O000000o(this.O00000oo, true, this.O0000OOo, this.O0000Oo0, this.O0000Oo);
                return true;
            } else if (this.O0000O0o && this.f15837O000000o == 0 && this.O00000Oo == 0) {
                O000000o(this.O00000oo, false, this.O0000OOo, this.O0000Oo0, this.O0000Oo);
                return true;
            }
        }
        return false;
    }

    public final boolean O0000O0o() {
        if (this.O00000oo) {
            if (!this.O00oOooO && this.f15837O000000o > 99) {
                this.O00oOooO = true;
                return true;
            } else if (this.O00oOooO && this.f15837O000000o <= 99) {
                this.O00oOooO = false;
                return true;
            }
        }
        return false;
    }

    public final void O000000o(int i, int i2, int i3, int i4, int i5) {
        this.f15837O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = i3;
        this.O00000o = i4;
        this.O00000oO = i5;
    }

    public final void O0000OOo() {
        O0000OoO();
        O00000Oo();
    }

    public final void O0000O0o(float f) {
        if (f > 0.0f) {
            this.O000o000 = evf.O00000Oo(this.O0000o0, f);
            this.O00oOooo.setTextSize(this.O000o000);
        }
    }

    public final void O00000o(int i) {
        this.O000Oooo = i;
        this.O00oOooo.setColor(this.O000Oooo);
    }

    public final void O00000o0(boolean z) {
        this.O000o00 = z;
        this.O00oOooo.setFakeBoldText(this.O000o00);
    }

    public final void O0000OOo(float f) {
        if (f > 0.0f) {
            this.O000o00o = evf.O00000Oo(this.O0000o0, f);
            this.O000O00o.setTextSize(this.O000o00o);
        }
    }

    public final void O00000oO(int i) {
        this.O000o00O = i;
        this.O000O00o.setColor(this.O000o00O);
    }

    public final void O00000o(boolean z) {
        this.O000o0 = z;
        this.O000O00o.setFakeBoldText(this.O000o0);
    }

    public final void O000000o(String str) {
        this.O0000o0O = str;
        String str2 = this.O0000o0O;
        O000000o(str2, str2, str2, str2, str2);
    }

    public final boolean O00000oO(boolean z) {
        if (this.O0000OoO == z) {
            return false;
        }
        this.O0000OoO = z;
        return true;
    }

    public final boolean O000000o(String str, String str2, String str3, String str4, String str5) {
        boolean z;
        if (str != null) {
            this.O0000o0o = str;
            z = true;
        } else {
            z = false;
        }
        if (str2 != null) {
            this.O0000o = str2;
            z = true;
        }
        if (str3 != null) {
            this.O0000oO0 = str3;
            z = true;
        }
        if (str4 != null) {
            this.O0000oO = str4;
            z = true;
        }
        if (str5 != null) {
            this.O0000oOO = str5;
            z = true;
        }
        if (z) {
            O0000Oo0();
        }
        return z;
    }

    public final void O0000Oo0(float f) {
        this.O000OooO = (float) evf.O000000o(this.O0000o0, f);
        O000000o(Float.valueOf(this.O00oOoOo), Float.valueOf(this.O00oOoOo), Float.valueOf(this.O00oOoOo), Float.valueOf(this.O00oOoOo), Float.valueOf(this.O00oOoOo), Float.valueOf(this.O00oOoOo), Float.valueOf(this.O00oOoOo), Float.valueOf(this.O00oOoOo), Float.valueOf(this.O00oOoOo));
    }

    public final boolean O000000o(Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9) {
        boolean z;
        if (f != null) {
            this.O00oOoOo = (float) evf.O000000o(this.O0000o0, f.floatValue());
            z = true;
        } else {
            z = false;
        }
        if (f2 != null) {
            this.O000O0o0 = (float) evf.O000000o(this.O0000o0, f2.floatValue());
            z = true;
        }
        if (f3 != null) {
            this.O000O0oo = (float) evf.O000000o(this.O0000o0, f3.floatValue());
            z = true;
        }
        if (f4 != null) {
            this.O000OO00 = (float) evf.O000000o(this.O0000o0, f4.floatValue());
            z = true;
        }
        if (f5 != null) {
            this.O000OO0o = (float) evf.O000000o(this.O0000o0, f5.floatValue());
            z = true;
        }
        if (f6 != null) {
            this.O000OO = (float) evf.O000000o(this.O0000o0, f6.floatValue());
            z = true;
        }
        if (f7 != null) {
            this.O000O0o = (float) evf.O000000o(this.O0000o0, f7.floatValue());
            z = true;
        }
        if (f8 != null) {
            this.O000O0oO = (float) evf.O000000o(this.O0000o0, f8.floatValue());
            z = true;
        }
        if (f9 != null) {
            this.O000OOOo = (float) evf.O000000o(this.O0000o0, f9.floatValue());
            z = true;
        }
        if (z) {
            O0000Oo();
        }
        return z;
    }

    public final void O00000oo(int i) {
        this.O000OoO0 = i;
    }
}
