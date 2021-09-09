package O000000o.O000000o.O000000o.O00000oO;

import _m_j.O00000o;
import _m_j.O000OOo0;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import com.hannto.circledialog.params.ButtonParams;
import com.hannto.circledialog.params.CircleParams;

public class t extends q {

    /* renamed from: a  reason: collision with root package name */
    public ButtonParams f377a;

    public class O000000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ EditText f378O000000o;

        public O000000o(EditText editText) {
            this.f378O000000o = editText;
        }

        public final void onClick(View view) {
            this.f378O000000o.getText();
            t.this.f377a.O000000o();
            if (t.this.f377a.O00000o != null) {
                ButtonParams unused = t.this.f377a;
            }
        }
    }

    public t(Context context, CircleParams circleParams) {
        super(context);
        ButtonParams buttonParams = circleParams.O00000oO;
        this.f377a = buttonParams == null ? circleParams.O00000oo : buttonParams;
        setText(this.f377a.O0000Oo);
        setTextSize((float) this.f377a.O0000O0o);
        setTextColor(this.f377a.O00000oo);
        setHeight(this.f377a.O0000OOo);
        getPaint().setFakeBoldText(this.f377a.O00000Oo);
        int i = this.f377a.O0000Oo0;
        int i2 = i == 0 ? -1 : i;
        int i3 = circleParams.O00000Oo.O0000OoO;
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(new O00000o(i2, 0, 0, i3, i3));
        } else {
            setBackgroundDrawable(new O00000o(i2, 0, 0, i3, i3));
        }
        setOnClickListener(new O000OOo0(this));
    }

    public void a(EditText editText) {
        setOnClickListener(new O000000o(editText));
    }
}
