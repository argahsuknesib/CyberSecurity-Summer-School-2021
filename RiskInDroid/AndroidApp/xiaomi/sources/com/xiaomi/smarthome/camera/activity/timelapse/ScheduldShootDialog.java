package com.xiaomi.smarthome.camera.activity.timelapse;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class ScheduldShootDialog extends BottomBaseDialog {

    public interface CancelListener {
        void onCancel(ScheduldShootDialog scheduldShootDialog);
    }

    public interface ConfirmListener {
        void onConfirm(ScheduldShootDialog scheduldShootDialog);
    }

    public View onCreateView() {
        return null;
    }

    public ScheduldShootDialog(Context context) {
        super(context);
    }

    public ScheduldShootDialog(Context context, int i) {
        super(context, i);
    }

    public ScheduldShootDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public static class Builder {
        CancelListener cancelListener;
        ConfirmListener confirmListener;
        Context context;
        ScheduldShootDialog dialog;
        boolean isCancelable;
        String title;

        public Builder(Context context2, boolean z) {
            this.context = context2;
            this.isCancelable = z;
        }

        public String getTitle() {
            return this.title;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setConfirmListener(ConfirmListener confirmListener2) {
            this.confirmListener = confirmListener2;
            return this;
        }

        public Builder setCancelListener(CancelListener cancelListener2) {
            this.cancelListener = cancelListener2;
            return this;
        }

        public ScheduldShootDialog build() {
            this.dialog = new ScheduldShootDialog(this.context, this.isCancelable, null) {
                /* class com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootDialog.Builder.AnonymousClass1 */

                public View onCreateView() {
                    View inflate = LayoutInflater.from(Builder.this.context).inflate((int) R.layout.camera_layout_scheduled_shoot, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.tv_tips_title)).setText(Builder.this.title);
                    ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootDialog.Builder.AnonymousClass1.AnonymousClass1 */

                        public void onClick(View view) {
                            if (Builder.this.cancelListener != null) {
                                Builder.this.cancelListener.onCancel(Builder.this.dialog);
                            }
                            Builder.this.dialog.dismiss();
                        }
                    });
                    ((TextView) inflate.findViewById(R.id.tv_ok)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootDialog.Builder.AnonymousClass1.AnonymousClass2 */

                        public void onClick(View view) {
                            if (Builder.this.confirmListener != null) {
                                Builder.this.confirmListener.onConfirm(Builder.this.dialog);
                            }
                            Builder.this.dialog.dismiss();
                        }
                    });
                    return inflate;
                }
            };
            return this.dialog;
        }
    }
}
