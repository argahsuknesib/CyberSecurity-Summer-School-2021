package _m_j;

import android.text.Editable;
import android.text.TextWatcher;

public class bzd implements TextWatcher {
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        int i = 0;
        while (i < editable.length()) {
            if (' ' == editable.charAt(i)) {
                int i2 = i + 1;
                if (i2 % 5 != 0 || i2 == editable.length()) {
                    editable.delete(i, i2);
                }
            }
            i++;
        }
        for (int i3 = 4; i3 < editable.length(); i3 += 5) {
            if ("0123456789".indexOf(editable.charAt(i3)) >= 0) {
                editable.insert(i3, " ");
            }
        }
    }
}
