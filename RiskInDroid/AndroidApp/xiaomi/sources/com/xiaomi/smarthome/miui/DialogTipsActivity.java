package com.xiaomi.smarthome.miui;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.gqb;
import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class DialogTipsActivity extends BaseActivity {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gqb.O000000o(android.content.Context, int, int, android.text.style.ClickableSpan):android.text.SpannableStringBuilder
     arg types: [com.xiaomi.smarthome.miui.DialogTipsActivity, ?, ?, com.xiaomi.smarthome.miui.DialogTipsActivity$1]
     candidates:
      _m_j.gqb.O000000o(android.content.Context, int, int, java.lang.Object):java.lang.String
      _m_j.gqb.O000000o(android.app.Activity, java.util.Locale, int, android.widget.TextView):boolean
      _m_j.gqb.O000000o(android.content.Context, int, int, android.text.style.ClickableSpan):android.text.SpannableStringBuilder */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.find_device_tips);
        TextView textView = (TextView) findViewById(R.id.goto_setting);
        textView.setText(gqb.O000000o((Context) this, (int) R.string.goto_setting, (int) R.string.goto_setting, (ClickableSpan) new ClickableSpan() {
            /* class com.xiaomi.smarthome.miui.DialogTipsActivity.AnonymousClass1 */

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(DialogTipsActivity.this.getResources().getColor(R.color.mj_color_black_40_transparent));
                textPaint.setUnderlineText(true);
            }

            public final void onClick(View view) {
                fbs.O000000o(new fbt(DialogTipsActivity.this.getContext(), "/setting/AboutActivity"));
                DialogTipsActivity.this.finish();
                DialogTipsActivity.this.overridePendingTransition(0, 0);
            }
        }));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        findViewById(R.id.dialog_container).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miui.DialogTipsActivity.AnonymousClass2 */

            public final void onClick(View view) {
                DialogTipsActivity.this.finish();
                DialogTipsActivity.this.overridePendingTransition(0, 0);
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miui.DialogTipsActivity.AnonymousClass3 */

            public final void onClick(View view) {
                DialogTipsActivity.this.finish();
                DialogTipsActivity.this.overridePendingTransition(0, 0);
            }
        });
    }
}
