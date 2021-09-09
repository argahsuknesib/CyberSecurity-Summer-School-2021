package O000000o.O000000o.O00000Oo.O0000OoO;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class a extends Dialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public TextView f380O000000o;
    public String O00000Oo = "";
    public Context O00000o;
    public ImageView O00000o0;

    public a(Context context) {
        super(context, R.style.ht_LoadingDialog);
        this.O00000o = context;
    }

    private static int O000000o(Context context) {
        return (int) ((context.getResources().getDisplayMetrics().density * 120.0f) + 0.5f);
    }

    public void onCreate(Bundle bundle) {
        TextView textView;
        String string;
        super.onCreate(bundle);
        setContentView((int) R.layout.ht_layout_load_dialog);
        this.O00000o0 = (ImageView) findViewById(R.id.dialog_icon);
        this.f380O000000o = (TextView) findViewById(R.id.dialog_message);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.dialog_load_layout);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(O000000o(this.O00000o), O000000o(this.O00000o)));
        linearLayout.setBackgroundResource(R.drawable.ht_bg_toast);
        if (!this.O00000Oo.isEmpty()) {
            textView = this.f380O000000o;
            string = this.O00000Oo;
        } else {
            textView = this.f380O000000o;
            string = this.O00000o.getString(R.string.ht_toast_process);
        }
        textView.setText(string);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
    }

    public void show() {
        super.show();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(2000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(10);
        this.O00000o0.setAnimation(rotateAnimation);
    }
}
