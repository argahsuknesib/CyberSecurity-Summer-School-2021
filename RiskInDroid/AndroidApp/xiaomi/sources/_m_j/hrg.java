package _m_j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public final class hrg {
    public static final void O000000o(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, final View.OnClickListener onClickListener) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.scene_alert_dialog, (ViewGroup) null);
        final MLAlertDialog O00000o = new MLAlertDialog.Builder(context).O00000o0().O00000o();
        TextView textView = (TextView) inflate.findViewById(R.id.button2);
        textView.setText(charSequence2);
        textView.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hrg.AnonymousClass1 */

            public final void onClick(View view) {
                O00000o.dismiss();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.button1);
        textView2.setText(charSequence3);
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hrg.AnonymousClass2 */

            public final void onClick(View view) {
                onClickListener.onClick(view);
                O00000o.dismiss();
            }
        });
        ((TextView) inflate.findViewById(R.id.alertTitle)).setText(charSequence);
        O00000o.setView(inflate, 0, 0, 0, 0);
        O00000o.show();
    }
}
