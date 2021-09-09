package _m_j;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

public final class OOOO0O {

    /* renamed from: O000000o  reason: collision with root package name */
    public TextClassifier f12327O000000o;
    private TextView O00000Oo;

    public OOOO0O(TextView textView) {
        this.O00000Oo = (TextView) bf.O000000o(textView);
    }

    public final TextClassifier O000000o() {
        TextClassifier textClassifier = this.f12327O000000o;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.O00000Oo.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }
}
