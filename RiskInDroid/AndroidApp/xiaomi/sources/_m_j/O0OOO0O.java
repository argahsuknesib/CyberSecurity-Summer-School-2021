package _m_j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.Timer;
import java.util.TimerTask;

public final class O0OOO0O extends dz implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public O00000o0 f6672O000000o;
    public TextView O00000Oo;
    public Timer O00000o;
    public ProgressBar O00000o0;
    public boolean O00000oO;

    public class O000000o extends TimerTask {
        public O000000o() {
        }

        public final void run() {
            O0OOO0O.O000000o(O0OOO0O.this);
        }
    }

    public class O00000Oo implements Runnable {
        public O00000Oo() {
        }

        public final void run() {
            O0OOO0O.this.O00000Oo.setVisibility(0);
            O0OOO0O.this.O00000o0.setVisibility(4);
        }
    }

    public static abstract class O00000o0 {
        public abstract boolean O000000o();

        public abstract void O00000Oo();
    }

    public static O0OOO0O O000000o(String str, String str2, String str3, String str4) {
        O0OOO0O o0ooo0o = new O0OOO0O();
        o0ooo0o.setStyle(1, 0);
        Bundle bundle = new Bundle();
        bundle.putString("key_title", str);
        bundle.putString("key_message", str2);
        bundle.putString("key_button_positive", str3);
        bundle.putString("key_button_negative", str4);
        bundle.putBoolean("key_cancelable", false);
        o0ooo0o.setArguments(bundle);
        return o0ooo0o;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("key_title");
            String string2 = arguments.getString("key_message");
            String string3 = arguments.getString("key_button_positive");
            String string4 = arguments.getString("key_button_negative");
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View inflate = getActivity().getLayoutInflater().inflate((int) R.layout.layout_custom_dialog, (ViewGroup) null);
            builder.setView(inflate);
            TextView textView = (TextView) inflate.findViewById(R.id.customDialogTitle);
            if (string == null || string.isEmpty()) {
                textView.setVisibility(8);
            } else {
                textView.setText(arguments.getString("key_title"));
            }
            this.O00000Oo = (TextView) inflate.findViewById(R.id.customDialogMessage);
            this.O00000Oo.setText(string2);
            this.O00000o0 = (ProgressBar) inflate.findViewById(R.id.progress);
            Button button = (Button) inflate.findViewById(R.id.customDialogButtonOk);
            button.setAllCaps(true);
            if (TextUtils.isEmpty(string3)) {
                button.setVisibility(8);
            } else {
                button.setText(string3);
                button.setOnClickListener(this);
            }
            Button button2 = (Button) inflate.findViewById(R.id.customDialogButtonCancel);
            button2.setAllCaps(true);
            if (TextUtils.isEmpty(string4)) {
                button2.setVisibility(8);
            } else {
                button2.setText(string4);
                button2.setOnClickListener(this);
            }
            AlertDialog create = builder.create();
            setCancelable(getArguments().getBoolean("key_cancelable"));
            Window window = create.getWindow();
            if (window != null) {
                window.requestFeature(8);
                window.setBackgroundDrawable(new ColorDrawable(O00o.O000000o(getActivity(), 17170445)));
            }
            return create;
        }
        throw new IllegalStateException("Use newInstance method to create Dialog");
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public static /* synthetic */ void O000000o(O0OOO0O o0ooo0o) {
        if (o0ooo0o.getActivity() != null) {
            o0ooo0o.getActivity().runOnUiThread(new O00000Oo());
        }
    }

    public final void onClick(View view) {
        if (this.f6672O000000o != null) {
            int id = view.getId();
            if (id == R.id.customDialogButtonOk) {
                this.O00000oO = true;
                if (this.f6672O000000o.O000000o()) {
                    dismiss();
                } else if (this.O00000Oo.getVisibility() != 8 || this.O00000o0.getVisibility() != 0) {
                    Timer timer = this.O00000o;
                    if (timer != null) {
                        timer.cancel();
                        this.O00000o = null;
                    }
                    this.O00000o = new Timer();
                    this.O00000Oo.setVisibility(4);
                    this.O00000o0.setVisibility(0);
                    this.O00000o.schedule(new O000000o(), 1000);
                }
            } else if (id == R.id.customDialogButtonCancel) {
                this.O00000oO = true;
                dismiss();
                this.f6672O000000o.O00000Oo();
            }
        }
    }
}
