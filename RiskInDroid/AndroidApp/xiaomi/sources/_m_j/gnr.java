package _m_j;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.utils.DialogBase;

public final class gnr {

    public static class O000000o extends DialogBase {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18052O000000o;
        Intent O00000Oo;
        private final Context O00000o0;

        public O000000o(String str, Intent intent, Context context) {
            super(context, 2132739282);
            this.O00000o0 = context;
            this.f18052O000000o = str;
            this.O00000Oo = intent;
        }

        /* access modifiers changed from: protected */
        public final void onCreate(Bundle bundle) {
            int i;
            int i2;
            super.onCreate(bundle);
            Window window = getWindow();
            if (window != null) {
                window.requestFeature(1);
                window.setBackgroundDrawableResource(17170445);
            }
            String str = null;
            setContentView(LayoutInflater.from(getContext().getApplicationContext()).inflate((int) R.layout.dialog_user_exp_plan, (ViewGroup) null));
            TextView textView = (TextView) findViewById(R.id.join_usr_exp_plan_tv);
            Intent intent = this.O00000Oo;
            if (intent != null) {
                str = intent.getStringExtra("usr_exp_plan_tips");
            }
            AnonymousClass1 r0 = new ClickableSpan() {
                /* class _m_j.gnr.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    fbt fbt = new fbt(O000000o.this.getContext().getApplicationContext(), "/userCenter/UsrExpPlanActivity");
                    if (O000000o.this.O00000Oo != null) {
                        fbt.O000000o(O000000o.this.O00000Oo.getExtras());
                    }
                    fbt.O00000Oo(268435456);
                    fbs.O000000o(fbt);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(Color.parseColor("#33aaff"));
                    textPaint.setUnderlineText(false);
                }
            };
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i3 = 0;
            if (TextUtils.isEmpty(str)) {
                String O000000o2 = gwc.O000000o((int) R.string.disclaim_join_user_exp_plan);
                int indexOf = O000000o2.indexOf("#start#");
                str = O000000o2.replace("#start#", "").replace("#end#", "");
                i2 = indexOf;
                i = O000000o2.indexOf("#end#") - 7;
            } else {
                i2 = this.O00000Oo.getIntExtra("usr_exp_plan_start", 0);
                i = this.O00000Oo.getIntExtra("usr_exp_plan_end", str.length());
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i > str.length()) {
                    i = str.length();
                }
            }
            if (i2 >= i) {
                i2 = 0;
            } else {
                i3 = i;
            }
            spannableStringBuilder.append((CharSequence) str);
            if (i2 >= 0 && i3 > 0) {
                try {
                    spannableStringBuilder.setSpan(r0, i2, i3, 33);
                } catch (Exception unused) {
                }
            }
            textView.setText(spannableStringBuilder);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            Button button = (Button) findViewById(R.id.cancel);
            Button button2 = (Button) findViewById(R.id.agree);
            button.setText(gwc.O000000o((int) R.string.sh_common_cancel));
            button.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gnr.O000000o.AnonymousClass2 */

                public final void onClick(View view) {
                    PluginHostApi.instance().setUsrExpPlanEnabled(O000000o.this.f18052O000000o, false);
                    O000000o.this.dismiss();
                }
            });
            button2.setText(gwc.O000000o((int) R.string.agree_go_on));
            button2.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gnr.O000000o.AnonymousClass3 */

                public final void onClick(View view) {
                    PluginHostApi.instance().setUsrExpPlanEnabled(O000000o.this.f18052O000000o, true);
                    O000000o.this.dismiss();
                }
            });
            hyy.O000000o(this.O00000o0, this, 80);
        }
    }
}
