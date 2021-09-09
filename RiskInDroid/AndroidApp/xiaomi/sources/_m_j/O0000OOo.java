package _m_j;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.regex.Pattern;

public final class O0000OOo implements InputFilter {
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        Pattern compile = Pattern.compile("^[\\u4E00-\\u9FA5A-Za-z0-9]+$");
        if (!TextUtils.isEmpty(charSequence) && !compile.matcher(charSequence.toString()).matches()) {
            return "";
        }
        return null;
    }
}
