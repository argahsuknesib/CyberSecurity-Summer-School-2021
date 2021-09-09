package _m_j;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public final class gpf {
    public static void O000000o(Intent intent, Intent intent2) {
        if (intent != null) {
            intent2.putExtra("from_miui", intent.getBooleanExtra("from_miui", false));
        }
    }

    public static void O000000o(Context context, Runnable runnable) {
        if (fix.O000000o().f16428O000000o.getInt("donnot_show_again", -1) == 100) {
            runnable.run();
        } else if (context != null) {
            try {
                View inflate = LayoutInflater.from(context).inflate((int) R.layout.dialog_connect_success, (ViewGroup) null);
                ((SimpleDraweeView) inflate.findViewById(R.id.tips_gif)).setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri("http://cdn.cnbj0.fds.api.mi-img.com/miio.files/resource_package/20210125142923_card_miui_connect_success_dialog.gif").setAutoPlayAnimations(true)).build());
                ((Button) inflate.findViewById(R.id.ok)).setOnClickListener(new View.OnClickListener((CheckBox) inflate.findViewById(R.id.remember), runnable) {
                    /* class _m_j.$$Lambda$gpf$j1EBTOdBPnSMVZiTZQgzQCl4NGE */
                    private final /* synthetic */ CheckBox f$0;
                    private final /* synthetic */ Runnable f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        gpf.O000000o(this.f$0, this.f$1, view);
                    }
                });
                MLAlertDialog O00000o = new MLAlertDialog.Builder(context).O000000o(inflate).O00000o();
                O00000o.setCancelable(false);
                O00000o.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(CheckBox checkBox, Runnable runnable, View view) {
        if (checkBox.isChecked()) {
            fix.O000000o().O000000o("donnot_show_again", 100);
        }
        runnable.run();
    }
}
