package com.smarthome.uwb.ui.widget;

import _m_j.gpc;
import _m_j.ixc;
import _m_j.ixe;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/smarthome/uwb/ui/widget/NameAndStateTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "name", "", "nameColor", "nameColorSel", "state", "stateColor", "stateColorSel", "availableWidth", "buildSpan", "Landroid/text/SpannableString;", "", "measureStringWidth", "", "charSequence", "setNameAndState", "", "setSelected", "selected", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NameAndStateTextView extends AppCompatTextView {
    private String name;
    private int nameColor;
    private int nameColorSel;
    private String state;
    private int stateColor;
    private int stateColorSel;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NameAndStateTextView(Context context) {
        this(context, null, 0, 6, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NameAndStateTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        ixe.O00000o(context, "context");
    }

    public final void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NameAndStateTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ixe.O00000o(context, "context");
        this.nameColor = -16777216;
        this.nameColorSel = -16777216;
        this.stateColor = -16777216;
        this.stateColorSel = -16777216;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.name_color, R.attr.name_color_sel, R.attr.state_color, R.attr.state_color_sel});
            this.nameColor = obtainStyledAttributes.getColor(0, -16777216);
            this.nameColorSel = obtainStyledAttributes.getColor(1, -16777216);
            this.stateColor = obtainStyledAttributes.getColor(2, -16777216);
            this.stateColorSel = obtainStyledAttributes.getColor(3, -16777216);
            obtainStyledAttributes.recycle();
        }
        setEllipsize(TextUtils.TruncateAt.END);
        setSingleLine(true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NameAndStateTextView(Context context, AttributeSet attributeSet, int i, int i2, ixc ixc) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setSelected(boolean z) {
        super.setSelected(z);
        if (this.name != null || this.state != null) {
            setNameAndState(this.name, this.state);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    public final void setNameAndState(String str, String str2) {
        CharSequence charSequence;
        CharSequence charSequence2;
        this.name = str;
        this.state = str2;
        if (str2 != null) {
            CharSequence charSequence3 = str2;
            boolean z = true;
            if (!(charSequence3.length() == 0)) {
                if (str != null) {
                    CharSequence charSequence4 = str;
                    if (charSequence4.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        CharSequence buildSpan = buildSpan(charSequence4, charSequence3);
                        int i = (measureStringWidth(buildSpan) > ((float) availableWidth()) ? 1 : (measureStringWidth(buildSpan) == ((float) availableWidth()) ? 0 : -1));
                        charSequence2 = buildSpan;
                        if (i >= 0) {
                            float measureStringWidth = measureStringWidth(" | ");
                            float measureStringWidth2 = measureStringWidth(charSequence3);
                            if (measureStringWidth2 + measureStringWidth < ((float) (availableWidth() / 2))) {
                                CharSequence ellipsize = TextUtils.ellipsize(charSequence4, getPaint(), (((float) availableWidth()) - measureStringWidth) - measureStringWidth2, TextUtils.TruncateAt.END);
                                ixe.O00000Oo(ellipsize, "ellipsize(name, paint, (availableWidth() - splitLen - stateLen), TextUtils.TruncateAt.END)");
                                charSequence = buildSpan(ellipsize, charSequence3);
                            } else {
                                float availableWidth = (((float) availableWidth()) - measureStringWidth) / 2.0f;
                                CharSequence ellipsize2 = TextUtils.ellipsize(charSequence4, getPaint(), availableWidth, TextUtils.TruncateAt.END);
                                ixe.O00000Oo(ellipsize2, "ellipsize(name, paint, half, TextUtils.TruncateAt.END)");
                                CharSequence ellipsize3 = TextUtils.ellipsize(charSequence3, getPaint(), availableWidth, TextUtils.TruncateAt.END);
                                ixe.O00000Oo(ellipsize3, "ellipsize(state, paint, half, TextUtils.TruncateAt.END)");
                                charSequence = buildSpan(ellipsize2, ellipsize3);
                            }
                            setText(charSequence);
                        }
                        charSequence = charSequence2;
                        setText(charSequence);
                    }
                }
                setTextColor(isSelected() ? this.stateColorSel : this.stateColor);
                charSequence2 = str2;
                charSequence = charSequence2;
                setText(charSequence);
            }
        }
        setTextColor(isSelected() ? this.nameColorSel : this.nameColor);
        charSequence = str;
        setText(charSequence);
    }

    private final int availableWidth() {
        if (getLayoutParams().width < 0) {
            return gpc.O000000o(getContext(), 200.0f);
        }
        return getLayoutParams().width;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.CharSequence]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    private final SpannableString buildSpan(CharSequence charSequence, CharSequence charSequence2) {
        String str = ((Object) charSequence) + " | ";
        String O000000o2 = ixe.O000000o(str, (Object) charSequence2);
        SpannableString spannableString = new SpannableString(O000000o2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(isSelected() ? this.nameColorSel : this.nameColor);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(isSelected() ? this.stateColorSel : this.stateColor);
        spannableString.setSpan(foregroundColorSpan, 0, str.length(), 33);
        spannableString.setSpan(foregroundColorSpan2, str.length(), O000000o2.length(), 33);
        return spannableString;
    }

    private final float measureStringWidth(CharSequence charSequence) {
        return getPaint().measureText(charSequence, 0, charSequence.length());
    }
}
